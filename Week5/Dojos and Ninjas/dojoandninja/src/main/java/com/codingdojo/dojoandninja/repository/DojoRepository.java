package com.codingdojo.dojoandninja.repository;

import com.codingdojo.dojoandninja.model.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
}
