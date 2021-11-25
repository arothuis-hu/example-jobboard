package nl.hu.bep3.jobboard.candidates.core.port.messaging;

import nl.hu.bep3.jobboard.candidates.core.domain.event.CandidateEvent;

public interface CandidateEventPublisher {
    void publish(CandidateEvent event);
}
