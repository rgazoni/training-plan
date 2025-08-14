package io.spring.training.boot.trainingplan.domain.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sport {
    SWIM("swim"),
    BIKE("bike"),
    RUN("run"),
    TRIATHLON("triathlon");

    private final String code;

    Sport(String code) {
        this.code = code;
    }

    @JsonValue
    public String code() {
        return this.code;
    }

    @Override
    public String toString() {
        return code;
    }

    public static Sport from(String value) {
        if(value == null || value.isEmpty()) {
           throw new IllegalArgumentException("sport is null");
        }
        var v = value.trim().toLowerCase();
        for(var sport: values()) {
            if(sport.code.equals(v)) {
                return sport;
            }
        }
        throw new IllegalArgumentException("unknown sport: " + value);
    }
}
