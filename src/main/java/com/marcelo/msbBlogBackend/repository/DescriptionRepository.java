package com.marcelo.msbBlogBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcelo.msbBlogBackend.entity.Description;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {

}
