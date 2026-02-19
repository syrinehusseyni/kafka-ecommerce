package tn.enis.kafka_ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
//Prooooducer  
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired //automatic injection 
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String ORDERS_TOPIC = "orders";
    private final ObjectMapper objectMapper = new ObjectMapper();

    // POST JSON body 
    @PostMapping
    public String sendOrder(@RequestBody OrderRequest orderRequest) {
        try {
            String orderJson = objectMapper.writeValueAsString(orderRequest);
            kafkaTemplate.send(ORDERS_TOPIC, orderJson);
            return "Order sent: " + orderJson;
        } catch (Exception e) {
            return "Error sending order";
        }
    }

    // Simple test endpoint to verify controller works
    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }
}
