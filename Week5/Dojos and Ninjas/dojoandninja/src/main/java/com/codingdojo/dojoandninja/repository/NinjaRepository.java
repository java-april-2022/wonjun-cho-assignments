package com.codingdojo.dojoandninja.repository;

import com.codingdojo.dojoandninja.model.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
}
