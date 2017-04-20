package com.ttn.poc.upload;

import com.ttn.poc.Option;

public enum UploadOption implements Option {
    PUBLIC_ID;

    public String getApiParam() {
        return name().toLowerCase();
    }
}
