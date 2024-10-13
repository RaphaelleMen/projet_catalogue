package com.raphaellem.api.repository;

import com.raphaellem.api.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
    Iterable<Article> findByFkThematique(Long fkThematique);
}
