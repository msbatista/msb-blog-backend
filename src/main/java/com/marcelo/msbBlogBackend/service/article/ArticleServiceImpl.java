package com.marcelo.msbBlogBackend.service.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.marcelo.msbBlogBackend.entity.Article;
import com.marcelo.msbBlogBackend.repository.ArticleRepository;
import com.marcelo.msbBlogBackend.service.exceptions.ObjectNotFoundException;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public List<Article> findAll() {
		return articleRepository.findAll();
	}

	@Override
	public Article findById(Long id) {
		Optional<Article> article = articleRepository.findById(id);
		return article.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id));
	}

	@Override
	public Article insert(Article article) {
		throw new UnsupportedOperationException("Unimplemented method");
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException("Unimplemented method");
	}

	@Override
	public Article update(Article article) {
		throw new UnsupportedOperationException("Unimplemented method");
	}

	@Override
	public Page<Article> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
		return articleRepository.findAll(pageRequest);
	}
}
