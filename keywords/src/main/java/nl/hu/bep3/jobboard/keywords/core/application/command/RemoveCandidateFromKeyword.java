package nl.hu.bep3.jobboard.keywords.core.application.command;

import java.util.UUID;

public class RemoveCandidateFromKeyword {
    private final UUID candidate;
    private final String keyword;

    public RemoveCandidateFromKeyword(UUID candidate, String keyword) {
        this.candidate = candidate;
        this.keyword = keyword;
    }

    public UUID getCandidate() {
        return candidate;
    }

    public String getKeyword() {
        return keyword;
    }
}
