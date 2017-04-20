package com.ttn.poc.transform;

import com.ttn.poc.ApiRequest;

public class TransformImageRequest extends ApiRequest<TransformOption> {
    private String imageTag;

    public TransformImageRequest(String imageTag) {
        this.imageTag = imageTag;
    }

    public TransformImageRequest(String publicId, String format) {
        this(publicId + "." + format);
    }

    public String getImageTag() {
        return imageTag;
    }
}