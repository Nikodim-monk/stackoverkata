package com.javamentor.qa.platform.service.impl.model;

import com.javamentor.qa.platform.dao.abstracts.model.VoteAnswerDao;
import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.entity.question.VoteType;
import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import com.javamentor.qa.platform.models.entity.question.answer.VoteAnswer;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.models.entity.user.reputation.Reputation;
import com.javamentor.qa.platform.models.entity.user.reputation.ReputationType;
import com.javamentor.qa.platform.service.abstracts.model.ReputationService;
import com.javamentor.qa.platform.service.abstracts.model.VoteAnswerService;
import com.javamentor.qa.platform.service.impl.repository.ReadWriteServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class VoteAnswerServiceImpl extends ReadWriteServiceImpl<VoteAnswer, Long> implements VoteAnswerService {

    private final VoteAnswerDao voteAnswerDao;
    private final ReputationService reputationService;

    public VoteAnswerServiceImpl(ReadWriteDao<VoteAnswer, Long> readWriteDao, VoteAnswerDao voteAnswerDao, ReputationService reputationService) {
        super(readWriteDao);
        this.voteAnswerDao = voteAnswerDao;
        this.reputationService = reputationService;
    }

    @Override
    @Transactional
    public Long voteUp(Answer answer, User user) {
        return vote(answer, user, 10, VoteType.UP);
    }

    private Long vote(Answer answer, User user, int repCount, VoteType voteType) {
        Optional<VoteAnswer> voteAnswerOptional = voteAnswerDao.getByAnswerIdAndUserId(answer.getId(),user.getId());
        Optional<Reputation> reputationOptional = reputationService.getByAnswerIdSenderId(answer.getId(),user.getId());
        VoteAnswer voteAnswer;
        Reputation reputation;
        if (voteAnswerOptional.isPresent() && reputationOptional.isPresent()){
            voteAnswer = voteAnswerOptional.get();
            reputation = reputationOptional.get();
        } else {
            voteAnswer = new VoteAnswer();
            reputation = new Reputation();
        }
        voteAnswer.setVoteType(voteType);
        voteAnswer.setAnswer(answer);
        voteAnswer.setUser(user);
        voteAnswer.setPersistDateTime(LocalDateTime.now());

        reputation.setAnswer(answer);
        reputation.setAuthor(answer.getUser());
        reputation.setCount(repCount);
        reputation.setSender(user);
        reputation.setType(ReputationType.Answer);
        try {
            voteAnswerDao.update(voteAnswer);
            reputationService.update(reputation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voteAnswerDao.sumVote(answer.getId());
    }
}
