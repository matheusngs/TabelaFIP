package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Brands (@JsonAlias("codigo") String code,
                      @JsonAlias("nome") String name){
}
