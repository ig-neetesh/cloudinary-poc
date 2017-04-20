package com.ttn.poc.upload;

import com.ttn.poc.ApiResponse;
import com.ttn.poc.Option;

import java.util.Map;

public class UploadImageResponse extends ApiResponse {
    private String publicId;
    private String url;
    private String secureUrl;
    private String format;

    public UploadImageResponse(Map map) {
        super(null != map);
        if (null != map) {
            this.publicId = String.valueOf(map.get(UploadOption.PUBLIC_ID.getApiParam()));
            this.url = String.valueOf(map.get(Option.Common.URL.getApiParam()));
            this.secureUrl = String.valueOf(map.get(Option.Common.SECURE_URL.getApiParam()));
            this.format = String.valueOf(map.get(Option.Common.FORMAT.getApiParam()));
        }
    }

    public String getPublicId() {
        return publicId;
    }

    public String getSecureUrl() {
        return secureUrl;
    }

    public String getUrl() {
        return url;
    }

    public String getImageTag() {
        return publicId + "." + format;
    }

    @Override
    public String toString() {
        return "UploadImageResponse : {success : " + isSuccess() + ", publicId : " + publicId + ", format : " + format + ", url : " + url + ", secureUrl : " + secureUrl + "}";
    }

}