package nl.hu.bep3.jobboard.jobs.core.ports.messaging;

import nl.hu.bep3.jobboard.jobs.core.domain.event.JobEvent;

public interface JobEventPublisher {
    void publish(JobEvent event);
}
