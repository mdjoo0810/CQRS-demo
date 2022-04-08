package com.github.mdjoo0810.messageworker;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomMessageListener {

    private final ProductRepository productRepository;

    @RabbitListener(queues = "product.queue")
    public void receiveMessage(final Message message) {
        Long id = Long.parseLong(new String(message.getBody()));
        log.info("ADD ID : {}", id);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductResponse> response = restTemplate.getForEntity("http://localhost:8081/v1/products/" + id, ProductResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            ReadProduct readProduct = new ReadProduct(Objects.requireNonNull(response.getBody()));
            log.info(readProduct.getShop().toString());
            productRepository.insert(readProduct);
        } else {
            log.error("데이터 정합성 실패");
        }

    }

}
