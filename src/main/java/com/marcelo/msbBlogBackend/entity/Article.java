package com.marcelo.msbBlogBackend.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Article implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6689435992699397213L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	@Column(columnDefinition = "TEXT")
	private String summary;
	@Lob
	private String content;
	private Date publishedAt;
	private String slug;

	public Article() {
	}

	public Article(Long id, String title, String summary, String content, Date publishedAt) {
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.publishedAt = publishedAt;
		setSlug(title.toLowerCase().replace(' ', '-'));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Article) {
			Article article = (Article) o;
			return this.id.equals(article.id);
		}

		return false;
	}

}