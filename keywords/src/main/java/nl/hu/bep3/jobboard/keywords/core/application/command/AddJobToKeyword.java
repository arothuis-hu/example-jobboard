package nl.hu.bep3.jobboard.keywords.core.application.command;

import java.util.UUID;

public class AddJobToKeyword {
    private final UUID job;
    private final String keyword;

    public AddJobToKeyword(UUID job, String keyword) {
        this.job = job;
        this.keyword = keyword;
    }

    public UUID getJob() {
        return job;
    }

    public String getKeyword() {
        return keyword;
    }
}
