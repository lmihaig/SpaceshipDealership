package com.spaceshipdealership.services;

public interface CSVService<T> {

    T CSVread();

    void CSVwrite(T object);
}
