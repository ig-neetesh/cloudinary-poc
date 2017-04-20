package com.ttn.poc;

public interface Option {
    String getApiParam();

    enum Common implements Option {
        URL,
        SECURE_URL,
        FORMAT;

        public String getApiParam() {
            return name().toLowerCase();
        }
    }
}
