package com.javamentor.qa.platform.dao.abstracts.repository;

import com.javamentor.qa.platform.models.entity.question.IgnoredTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IgnoredTagRepository extends JpaRepository<IgnoredTag,Long> {

}
