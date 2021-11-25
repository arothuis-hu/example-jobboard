package nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging;

import nl.hu.bep3.jobboard.keywords.core.application.KeywordsCommandHandler;
import nl.hu.bep3.jobboard.keywords.core.application.command.AddCandidateToKeyword;
import nl.hu.bep3.jobboard.keywords.core.application.command.AddJobToKeyword;
import nl.hu.bep3.jobboard.keywords.core.application.command.RemoveCandidateFromKeyword;
import nl.hu.bep3.jobboard.keywords.core.application.command.RemoveJobFromKeyword;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.KeywordsEvent;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword.CandidateAddedKeyword;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword.CandidateRemovedKeyword;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword.KeywordAddedToJob;
import nl.hu.bep3.jobboard.keywords.infrastructure.driver.messaging.event.keyword.KeywordRemovedFromJob;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqEventListener {
    public RabbitMqEventListener(KeywordsCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    private final KeywordsCommandHandler commandHandler;

    @RabbitListener(queues = "#{'${messaging.queue.all-keywords}'}")
    public void listen(KeywordsEvent event) {
        switch (event.getEventKey()) {
            case CandidateAddedKeyword.KEY:
                this.handle((CandidateAddedKeyword) event);
                break;
            case CandidateRemovedKeyword.KEY:
                this.handle((CandidateRemovedKeyword) event);
                break;
            case KeywordAddedToJob.KEY:
                this.handle((KeywordAddedToJob) event);
                break;
            case KeywordRemovedFromJob.KEY:
                this.handle((KeywordRemovedFromJob) event);
                break;
        }
    }

    private void handle(CandidateAddedKeyword event) {
        this.commandHandler.handle(new AddCandidateToKeyword(event.getCandidate(), event.getKeyword()));
    }

    private void handle(CandidateRemovedKeyword event) {
        this.commandHandler.handle(new RemoveCandidateFromKeyword(event.getCandidate(), event.getKeyword()));
    }

    private void handle(KeywordAddedToJob event) {
        this.commandHandler.handle(new AddJobToKeyword(event.getJob(), event.getKeyword()));
    }

    private void handle(KeywordRemovedFromJob event) {
        this.commandHandler.handle(new RemoveJobFromKeyword(event.getJob(), event.getKeyword()));
    }
}
