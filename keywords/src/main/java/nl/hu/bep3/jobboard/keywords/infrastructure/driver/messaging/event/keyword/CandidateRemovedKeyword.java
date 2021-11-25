package nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword;

import com.fasterxml.jackson.annotation.JsonTypeName;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.KeywordsEvent;

import java.util.UUID;

@JsonTypeName(CandidateRemovedKeyword.KEY)
public class CandidateRemovedKeyword extends KeywordsEvent {
    public static final String KEY = "keywords.candidate.removed";

    private final UUID candidate;
    private final String keyword;

    public CandidateRemovedKeyword(UUID candidate, String keyword) {
        this.candidate = candidate;
        this.keyword = keyword;
    }

    @Override
    public String getEventKey() {
        return KEY;
    }

    public UUID getCandidate() {
        return candidate;
    }

    public String getKeyword() {
        return keyword;
    }
}
