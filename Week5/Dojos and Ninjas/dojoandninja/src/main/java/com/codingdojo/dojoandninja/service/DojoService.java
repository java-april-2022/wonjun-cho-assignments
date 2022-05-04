package com.codingdojo.dojoandninja.service;

import com.codingdojo.dojoandninja.model.Dojo;
import com.codingdojo.dojoandninja.repository.DojoRepository;
import org.springframework.stereotype.Service;

@Service
public class DojoService {

    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public void createDojo(Dojo d) {
        dojoRepository.save(d);
    }

    public Iterable<Dojo> allDojo() {
        return dojoRepository.findAll();
    }

    public Dojo findDojoById(Long id) {
        return dojoRepository.findById(id).orElse(null);
    }
}
