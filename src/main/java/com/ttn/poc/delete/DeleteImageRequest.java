package com.ttn.poc.delete;

import com.ttn.poc.ApiRequest;

public class DeleteImageRequest extends ApiRequest<DeleteOption> {
    private String publicId;

    public DeleteImageRequest(String publicId) {
        this.publicId = publicId;
    }

    public String getPublicId() {
        return publicId;
    }
}