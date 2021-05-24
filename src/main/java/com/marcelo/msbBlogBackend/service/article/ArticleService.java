package com.marcelo.msbBlogBackend.service.article;

import java.util.List;

import org.springframework.data.domain.Page;

import com.marcelo.msbBlogBackend.entity.Article;

public interface ArticleService {
	List<Article> findAll();
	Page<Article> findPage(Integer page, Integer linesPerPage, String orderBy, String direction);
	Article findById(Long id);
	Article insert(Article article);
	Article update(Article article);
	void delete(Long id);
}
