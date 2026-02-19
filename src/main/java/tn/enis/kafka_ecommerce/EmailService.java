package tn.enis.kafka_ecommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final Logger log = LoggerFactory.getLogger(EmailService.class);


    @KafkaListener(topics = "orders", groupId = "email-group")
    public void sendEmail(String order) {
        log.info("[Email Service] Sending confirmation email for: {}", order);
    }

}
