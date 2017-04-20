package com.ttn.poc;

public abstract class ApiResponse {

    private boolean success;

    protected ApiResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
