package com.ttn.poc;

import java.util.HashMap;
import java.util.Map;

public abstract class ApiRequest<T extends Option> {
    private Map<String, Object> options = new HashMap<String, Object>();

    public void addRawOption(String key, Object value) {
        options.put(key, value);
    }

    public void addRawOptions(Map<String, Object> options) {
        this.options.putAll(options);
    }


    public void addOption(T optionKey, Object value) {
        addRawOption(optionKey.getApiParam(), value);
    }

    public void addOptions(Map<T, Object> options) {
        for (Map.Entry<T, Object> option : options.entrySet()) {
            addOption(option.getKey(), option.getValue());
        }
    }

    public Map<String, Object> getOptions() {
        return options;
    }
}