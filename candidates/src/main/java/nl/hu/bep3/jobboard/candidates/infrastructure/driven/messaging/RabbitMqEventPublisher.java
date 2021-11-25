package nl.hu.bep3.jobboard.candidates.infrastructure.driven.messaging;

import nl.hu.bep3.jobboard.candidates.core.domain.event.CandidateEvent;
import nl.hu.bep3.jobboard.candidates.core.port.messaging.CandidateEventPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqEventPublisher implements CandidateEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final String jobBoardExchange;

    public RabbitMqEventPublisher(
            RabbitTemplate rabbitTemplate,
            String jobBoardExchange
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.jobBoardExchange = jobBoardExchange;
    }

    public void publish(CandidateEvent event) {
        this.rabbitTemplate.convertAndSend(jobBoardExchange, event.getEventKey(), event);
    }
}
