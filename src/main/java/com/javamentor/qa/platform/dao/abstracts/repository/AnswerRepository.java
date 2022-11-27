package com.javamentor.qa.platform.dao.abstracts.repository;

import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository <Answer, Long> {
}
