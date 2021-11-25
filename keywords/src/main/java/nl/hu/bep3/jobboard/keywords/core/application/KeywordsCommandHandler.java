package nl.hu.bep3.jobboard.keywords.core.application;

import nl.hu.bep3.jobboard.keywords.core.application.command.AddCandidateToKeyword;
import nl.hu.bep3.jobboard.keywords.core.application.command.AddJobToKeyword;
import nl.hu.bep3.jobboard.keywords.core.application.command.RemoveCandidateFromKeyword;
import nl.hu.bep3.jobboard.keywords.core.application.command.RemoveJobFromKeyword;
import nl.hu.bep3.jobboard.keywords.core.domain.Keyword;
import nl.hu.bep3.jobboard.keywords.core.port.storage.KeywordRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KeywordsCommandHandler {
    public KeywordsCommandHandler(KeywordRepository repository) {
        this.repository = repository;
    }

    private final KeywordRepository repository;

    public void handle(AddCandidateToKeyword command) {
        Keyword keywordOverview = this.createIfNotExists(command.getKeyword());
        keywordOverview.addCandidate(command.getCandidate());

        this.repository.save(keywordOverview);
    }

    public void handle(RemoveCandidateFromKeyword command) {
        Optional<Keyword> optionalMatch = this.repository.findByKeyword(command.getKeyword());

        if (optionalMatch.isEmpty()) {
            return;
        }

        Keyword keywordOverview = optionalMatch.get();
        keywordOverview.removeCandidate(command.getCandidate());

        this.repository.save(keywordOverview);
    }

    public void handle(AddJobToKeyword command) {
        Keyword keywordOverview = this.createIfNotExists(command.getKeyword());
        keywordOverview.addJob(command.getJob());

        this.repository.save(keywordOverview);
    }

    public void handle(RemoveJobFromKeyword command) {
        Optional<Keyword> optionalMatch = this.repository.findByKeyword(command.getKeyword());

        if (optionalMatch.isEmpty()) {
            return;
        }

        Keyword keywordOverview = optionalMatch.get();
        keywordOverview.removeJob(command.getJob());

        this.repository.save(keywordOverview);
    }

    private Keyword createIfNotExists(String keyword) {
        return this.repository
                .findByKeyword(keyword)
                .orElse(new Keyword(keyword));
    }
}
