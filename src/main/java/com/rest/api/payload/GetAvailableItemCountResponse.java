package com.rest.api.payload;

public class GetAvailableItemCountResponse {
    private Integer availableCount;

    public GetAvailableItemCountResponse() {}

    public GetAvailableItemCountResponse(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }
    
}
