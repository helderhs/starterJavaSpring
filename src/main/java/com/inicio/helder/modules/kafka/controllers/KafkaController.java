package com.inicio.helder.modules.kafka.controllers;

import com.inicio.helder.modules.kafka.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/kafka/enviar")
    public String enviarParaKafka( @RequestBody Object mensagem) {
        //@RequestParam String chave
        kafkaService.enviarMensagem( );
        return "Mensagem enviada!";
    }
}