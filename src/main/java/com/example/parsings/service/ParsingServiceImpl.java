package com.example.parsings.service;

import com.example.parsings.models.Values;
import com.example.parsings.repository.ValuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ParsingServiceImpl implements  ParsingService{

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ValuesRepository valuesRepository;
    @Override
    public Object parse(String url) {
        return restTemplate.getForObject(url,Object.class);
    }

    @Override
    public void save(Values values) {
        valuesRepository.save(values);

    }

    @Override
    public boolean isExist(String valueTitle) {
        List<Values> allVal = valuesRepository.findAll();
        for (Values n: allVal) {
            if (n.getTitle().equals(valueTitle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Values> getAllValue() {
        return valuesRepository.findAll();
    }


}
