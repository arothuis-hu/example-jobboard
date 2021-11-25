package nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword;

import com.fasterxml.jackson.annotation.JsonTypeName;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.KeywordsEvent;

import java.util.UUID;

@JsonTypeName(KeywordAddedToJob.KEY)
public class KeywordAddedToJob extends KeywordsEvent {
    public static final String KEY = "keywords.job.added";

    private final UUID job;
    private final String keyword;

    public KeywordAddedToJob(UUID job, String keyword) {
        this.job = job;
        this.keyword = keyword;
    }

    @Override
    public String getEventKey() {
        return KEY;
    }

    public UUID getJob() {
        return job;
    }

    public String getKeyword() {
        return keyword;
    }
}
