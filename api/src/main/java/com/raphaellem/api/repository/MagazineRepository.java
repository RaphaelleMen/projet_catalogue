package com.raphaellem.api.repository;

import com.raphaellem.api.model.Magazine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazineRepository extends CrudRepository<Magazine, Long> {

}
