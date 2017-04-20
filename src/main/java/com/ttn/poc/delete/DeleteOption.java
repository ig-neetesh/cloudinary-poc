package com.ttn.poc.delete;

import com.ttn.poc.Option;

public enum DeleteOption implements Option {
    INVALIDATE;

    public String getApiParam() {
        return name().toLowerCase();
    }
}