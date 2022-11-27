package com.javamentor.qa.platform.dao.abstracts.repository;

import com.javamentor.qa.platform.models.entity.question.TrackedTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackedTagRepository extends JpaRepository<TrackedTag,Long> {
}
