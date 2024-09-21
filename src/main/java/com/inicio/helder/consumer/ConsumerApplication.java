//package com.inicio.helder.consumer;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.inicio.helder.modules.kafka.dto.KafkaMensagem;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.kafka.annotation.KafkaListener;
//
//@SpringBootApplication
//public class ConsumerApplication {
//
//
//    ObjectMapper objectMapper = new ObjectMapper();
//
//    public static void main(String[] args) {
//        SpringApplication.run(ConsumerApplication.class, args);
//    }
//
////    @Bean
////    public NewTopic topic() {
////        return TopicBuilder.name("teste")
////                .partitions(3)
////                .replicas(1)
////                .build();
////    }
//
////    @KafkaListener(id = "myId", topics = "teste")
////    public void listenString(String message) {
////        System.out.println("Mensagem recebida: " + message);
////    }
//
//    @KafkaListener(id = "myId", topics = "teste")
//    public void listen(String mensagem) throws JsonProcessingException {
//        System.out.println("Mensagem recebida: "  + mensagem);
//        String jsonString = "{\"name\":\"John\",\"mensagem\":30}";
//
//        try {
//            // Converte o JSON em um objeto Java
//            KafkaMensagem _mensagem = objectMapper.readValue(mensagem, KafkaMensagem.class);
//            System.out.println("Nome: " + _mensagem.getName());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}