package nl.hu.bep3.jobboard.candidates.infrastructure.driver.messaging;

import nl.hu.bep3.jobboard.candidates.core.application.CandidatesCommandHandler;
import nl.hu.bep3.jobboard.candidates.core.application.command.MatchCandidates;
import nl.hu.bep3.jobboard.candidates.core.application.command.UnmatchCandidates;
import nl.hu.bep3.jobboard.candidates.infrastructure.driver.messaging.event.JobKeywordEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqEventListener {
    private final CandidatesCommandHandler commandHandler;

    public RabbitMqEventListener(CandidatesCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @RabbitListener(queues = "#{'${messaging.queue.job-keywords}'}")
    void listen(JobKeywordEvent event) {
        switch (event.eventKey) {
            case "keywords.job.added":
                this.commandHandler.handle(
                        new MatchCandidates(event.job, event.keyword)
                );
                break;
            case "keywords.job.removed":
                this.commandHandler.handle(
                        new UnmatchCandidates(event.job, event.keyword)
                );
                break;
        }
    }
}
