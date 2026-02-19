package tn.enis.kafka_ecommerce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private static final Logger log = LoggerFactory.getLogger(InventoryService.class);

    @KafkaListener(topics = "orders", groupId = "inventory-group")
    public void updateInventory(String order) {
        log.info("[Inventory Service] Updating stock for: {}", order);
    }

}
