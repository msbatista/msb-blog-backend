package com.marcelo.msbBlogBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.msbBlogBackend.entity.Article;
import com.marcelo.msbBlogBackend.service.article.ArticleService;

@RestController
@RequestMapping(value = "/articles")
public class ArticleController {
	@Autowired
	private ArticleService articleBusiness;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Article> findById(@PathVariable Long id) {
		Article article = articleBusiness.findById(id);
		return ResponseEntity.ok().body(article);
	}

	@GetMapping(value = "/page")
	public ResponseEntity<Page<Article>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Article> articles = articleBusiness.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(articles);
	}

	public ResponseEntity<List<Article>> findAll() {
		List<Article> articles = articleBusiness.findAll();
		return ResponseEntity.ok().body(articles);
	}
}
