package com.example.jogodavelha.core;

import java.util.List;

public class Humano extends Jogador {
    public Humano(int codigo, String nome) {
        super(codigo, nome);
    }

    public void Jogar(Tabuleiro tabuleiro, int[] posicao) {
        tabuleiro.setarPosicao(posicao, this.getCodigo());
    }

}
