package com.ttn.poc.transform;

import com.ttn.poc.Option;

public enum TransformOption implements Option {
    WIDTH,
    HEIGHT,
    CROP;

    public String getApiParam() {
        return name().toLowerCase();
    }

    public enum Crop implements Option {
        SCALE,
        FIT,
        LIMIT,
        MFIT,
        FILL,
        LFILL,
        PAD,
        LPAD,
        MPAD,
        CROP,
        THUMB;

        public String getApiParam() {
            return name().toLowerCase();
        }
    }
}
