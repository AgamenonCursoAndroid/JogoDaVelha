package com.example.jogodavelha.core;

public abstract class Jogador {
    private int codigo;
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Jogador(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

}
