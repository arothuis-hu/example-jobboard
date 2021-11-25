package nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword.CandidateAddedKeyword;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword.CandidateRemovedKeyword;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword.KeywordAddedToJob;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword.KeywordRemovedFromJob;

import java.time.Instant;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "eventKey")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CandidateAddedKeyword.class),
        @JsonSubTypes.Type(value = CandidateRemovedKeyword.class),
        @JsonSubTypes.Type(value = KeywordAddedToJob.class),
        @JsonSubTypes.Type(value = KeywordRemovedFromJob.class),
})
public abstract class KeywordsEvent {
    private final UUID eventId = UUID.randomUUID();
    private final Instant eventDate = Instant.now();

    public UUID getEventId() {
        return eventId;
    }

    public Instant getEventDate() {
        return eventDate;
    }

    public abstract String getEventKey();
}
