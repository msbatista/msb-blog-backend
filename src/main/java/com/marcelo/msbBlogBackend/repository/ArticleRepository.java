package com.marcelo.msbBlogBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.msbBlogBackend.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
