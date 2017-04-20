package com.ttn.poc.upload;

import com.ttn.poc.ApiRequest;

public class UploadImageRequest extends ApiRequest<UploadOption> {
    private String imageUrl;

    public UploadImageRequest(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}