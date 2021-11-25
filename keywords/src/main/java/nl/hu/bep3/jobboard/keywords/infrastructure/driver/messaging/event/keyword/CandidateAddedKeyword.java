package nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword;

import com.fasterxml.jackson.annotation.JsonTypeName;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.KeywordsEvent;

import java.util.UUID;

@JsonTypeName(CandidateAddedKeyword.KEY)
public class CandidateAddedKeyword extends KeywordsEvent {
    public static final String KEY = "keywords.candidate.added";

    private final UUID candidate;
    private final String keyword;

    public CandidateAddedKeyword(UUID candidate, String keyword) {
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
