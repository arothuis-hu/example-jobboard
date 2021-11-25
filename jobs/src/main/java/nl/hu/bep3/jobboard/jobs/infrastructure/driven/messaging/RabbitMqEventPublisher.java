package nl.hu.bep3.jobboard.jobs.infrastructure.driven.messaging;

import nl.hu.bep3.jobboard.jobs.core.domain.event.JobEvent;
import nl.hu.bep3.jobboard.jobs.core.ports.messaging.JobEventPublisher;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class RabbitMqEventPublisher implements JobEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final String jobBoardExchange;

    public RabbitMqEventPublisher(
            RabbitTemplate rabbitTemplate,
            String jobBoardExchange
    ) {
        this.rabbitTemplate = rabbitTemplate;
        this.jobBoardExchange = jobBoardExchange;
    }

    public void publish(JobEvent event) {
        this.rabbitTemplate.convertAndSend(jobBoardExchange, event.getEventKey(), event);
    }
}
