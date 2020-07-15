package com.paesa.qrgen;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

    @JsonProperty("data")
    private String data;

    @JsonCreator
    public Request(String data) {
        this.data = data;
    }

    @JsonProperty("data")
    public String getData() {
        return this.data;
    }
}