package com.inicio.helder.modules.kafka.dto;


public class KafkaMensagem {
    private String mensagem;
    private String name;

    // Construtor padrão (necessário para Jackson)
    public KafkaMensagem() {
    }

    // Construtor com parâmetros
    public KafkaMensagem(String mensagem, String name) {
        this.mensagem = mensagem;
        this.name = name;
    }

    // Getters e Setters
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}