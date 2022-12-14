package com.javamentor.qa.platform.service.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.ReputationDao;
import com.javamentor.qa.platform.models.entity.user.reputation.Reputation;
import com.javamentor.qa.platform.models.entity.user.reputation.ReputationType;
import com.javamentor.qa.platform.service.abstracts.model.ReputationService;
import com.javamentor.qa.platform.service.impl.repository.ReadWriteServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ReputationServiceImpl extends ReadWriteServiceImpl<Reputation, Long> implements ReputationService {

    private final ReputationDao reputationDao;

    public ReputationServiceImpl(ReputationDao reputationDao) {
        super(reputationDao);
        this.reputationDao = reputationDao;
    }

    @Override
    @Transactional
    public Optional<Reputation> getByAnswerIdSenderId(Long answerId, Long senderId) {
        return reputationDao.getByAnswerIdSenderId(answerId, senderId);
    }

    @Override
    public Optional<Reputation> getByVoteQuestion(Long userId, Long questionId, ReputationType reputationType) {
        return reputationDao.getByVoteQuestion(userId, questionId, reputationType);
    }
}
