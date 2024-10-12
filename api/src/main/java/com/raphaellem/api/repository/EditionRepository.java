package com.raphaellem.api.repository;

import com.raphaellem.api.model.Edition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditionRepository extends CrudRepository<Edition, Long> {

}
