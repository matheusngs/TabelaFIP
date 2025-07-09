package com.example.demo.service;

import java.util.List;

public interface iConvertData {
    <T>T getData(String json, Class<T> myClass);

    <T>List<T> getList(String json, Class<T> myClass);
}
