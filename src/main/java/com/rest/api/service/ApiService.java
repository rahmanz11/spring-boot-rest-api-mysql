package com.rest.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rest.api.model.*;
import com.rest.api.payload.GetAvailableItemCountResponse;
import com.rest.api.payload.ReceiveOrderRequest;
import com.rest.api.payload.ReceiveOrderResponse;
import com.rest.api.repository.ItemInventoryRepository;
import com.rest.api.repository.OrderRepository;

import java.util.Optional;

@Service
public class ApiService {

    @Value("${shipping.cost.dhl}")
    private Integer shippingCostDhl;

    @Value("${shipping.cost.hermes}")
    private Integer shippingCostHermes;

    @Value("${max.weight.dhl}")
    private Integer maxWeightDhl;

    @Value("${max.weight.hermes}")
    private Integer maxWeightHermes;

    private final ItemInventoryRepository itemInventoryRepository;
    private final OrderRepository orderRepository;

    public ApiService(ItemInventoryRepository itemInventoryRepository, 
                        OrderRepository orderRepository) {
        this.itemInventoryRepository = itemInventoryRepository;
        this.orderRepository = orderRepository;
    }

    public GetAvailableItemCountResponse getItemsAvailableUnits(Integer number) throws Exception {
        // Find the item with the given item number
        Optional<ItemInventory> item = itemInventoryRepository.findByItemNumber(number);
        if (item.isPresent()) {
            return new GetAvailableItemCountResponse(item.get().getAvailableUnits());
        }

        throw new Exception("Cannot find any item with given item number");
    }

    public ReceiveOrderResponse receiveOrder(ReceiveOrderRequest request) throws Exception {
        // Find the item with the given item number
        Optional<ItemInventory> item = itemInventoryRepository.findByItemNumber(request.getItemNumber());
        if (!item.isPresent()) {
            throw new Exception("Cannot find any item with given item number");
        }

        // Check if requested units are available
        if (item.get().getAvailableUnits() < request.getOrderQuantity()) {
            throw new Exception("Item not available for the given quantity");
        }

        // Calculate total weight
        Integer totalWeight = request.getOrderQuantity() * item.get().getWeightPerUnitInKg();
        Integer shippingCostSubTotal = 0;

        // Check if total weight exceeded the maximum capacity by the logistics company
        // Then calculate shipping sub total
        if (request.getLogisticsCompany().equals(LogisticsCompany.DHL)) {            
            if (totalWeight > maxWeightDhl) {
                throw new Exception("Cannot ship more than " + maxWeightDhl + " KG by DHL");
            }
            shippingCostSubTotal = request.getOrderQuantity() * shippingCostDhl;
        } else {
            if (totalWeight > maxWeightHermes) {
                throw new Exception("Cannot ship more than " + maxWeightHermes + " KG by Hermes");
            }
            shippingCostSubTotal = request.getOrderQuantity() * shippingCostHermes;
        }

        // Calculate total
        Integer total = request.getOrderQuantity() * item.get().getPricePerUnit();

        // Save new received order
        Orders newOrder = new Orders();
        BeanUtils.copyProperties(request, newOrder);
        newOrder.setShippingCostSubtotal(shippingCostSubTotal);
        newOrder.setTotal(total);

        orderRepository.save(newOrder);
        
        // Decrease available units
        item.get().setAvailableUnits(item.get().getAvailableUnits() - request.getOrderQuantity());
        itemInventoryRepository.save(item.get());

        // Prepare response
        ReceiveOrderResponse response = new ReceiveOrderResponse();        
        response.setShippingCostSubTotal(shippingCostSubTotal);
        response.setTotal(total);
        System.out.println(response.toString());
        return response;
    }
}
