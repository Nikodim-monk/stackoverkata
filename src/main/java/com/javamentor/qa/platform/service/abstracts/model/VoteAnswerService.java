package com.javamentor.qa.platform.service.abstracts.model;

import com.javamentor.qa.platform.models.entity.question.answer.VoteAnswer;
import com.javamentor.qa.platform.service.abstracts.repository.ReadWriteService;

public interface VoteAnswerService extends ReadWriteService<VoteAnswer, Long> {
    Long upCount(String email, long questionId,long id);
}
