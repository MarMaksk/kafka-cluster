package ru.home.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.home.kafka.dto.JsonMessage;

import java.util.concurrent.ThreadLocalRandom;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

    @Value("${kafka.topics.test-topic}")
    private String topic;

    private int messageNumber = 0;

    private final KafkaTemplate<Object, Object> kafkaTemplate;

    public void sendMessages() {
        while (messageNumber != 10_000) {
            messageNumber++;
            JsonMessage jsonMessage = JsonMessage.builder()
                    .number(messageNumber)
                    .message("message number " + messageNumber)
                    .build();
            kafkaTemplate.send(topic, String.valueOf(ThreadLocalRandom.current().nextLong()), jsonMessage);
            log.info("Отправлено сообщение номер {}", messageNumber);
        }
    }
}