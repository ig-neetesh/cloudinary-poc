package com.ttn.poc.transform;

import com.ttn.poc.ApiResponse;

public class TransformImageResponse extends ApiResponse {
    private String url;

    public TransformImageResponse(String url) {
        super(null != url);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
