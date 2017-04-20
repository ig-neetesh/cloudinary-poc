package com.ttn.poc.delete;

import com.ttn.poc.ApiResponse;

public class DeleteImageResponse extends ApiResponse {
    private String publicId;

    public DeleteImageResponse(String publicId, boolean success) {
        super(success);
        this.publicId = publicId;
    }

    public String getPublicId() {
        return publicId;
    }

    @Override
    public String toString() {
        return "DeleteImageResponse : {success : " + isSuccess() + ", publicId : " + publicId + "}";
    }
}