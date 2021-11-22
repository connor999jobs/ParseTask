package com.example.parsings.service;

import com.example.parsings.models.Values;

import java.util.List;

public interface ParsingService {
    Object parse(String url);
    public void save(Values values);
    public boolean isExist(String valueTitle);
    public List<Values> getAllValue();


}
