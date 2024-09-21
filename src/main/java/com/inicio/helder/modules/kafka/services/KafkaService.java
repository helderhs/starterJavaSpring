package com.inicio.helder.modules.kafka.services;

import com.inicio.helder.modules.kafka.dto.KafkaMensagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class KafkaService {

    private static final String TOPICO = "teste";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void enviarMensagem() {


        KafkaMensagem mensagem = new KafkaMensagem("Helder", "teste");

        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TOPICO, mensagem);

        future.handle((result, ex) -> {
            if (ex != null) {
                System.err.println("Falha ao enviar mensagem: " + ex.getMessage());
            } else {
                System.out.println("Mensagem enviada com sucesso: " + result.getRecordMetadata());
            }
            return null; // Retorna null já que não estamos interessados no resultado
        });


//        kafkaTemplate.send(TOPIC, new KafkaMensagem("Helder", "teste"));
    }
}