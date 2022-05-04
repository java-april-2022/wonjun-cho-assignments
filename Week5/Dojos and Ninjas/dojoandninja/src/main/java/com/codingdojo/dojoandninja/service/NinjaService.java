package com.codingdojo.dojoandninja.service;

import com.codingdojo.dojoandninja.model.Ninja;
import com.codingdojo.dojoandninja.repository.NinjaRepository;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public void createNinja(Ninja n) {
        ninjaRepository.save(n);
    }
}
