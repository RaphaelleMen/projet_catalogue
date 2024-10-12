package com.raphaellem.api.repository;

import com.raphaellem.api.model.Thematique;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThematiqueRepository extends CrudRepository<Thematique, Long> {

}
