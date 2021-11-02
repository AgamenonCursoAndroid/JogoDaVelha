package com.example.jogodavelha.core;

public class Tabuleiro {
    private int[][] tabuleiro= new int[3][3];

    public Tabuleiro(){
        LimparTabuleiro();
    }

    public void LimparTabuleiro(){
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
                tabuleiro[linha][coluna]=0;
    }

    public int obterPosicao(int[] tentativa){
        return tabuleiro[tentativa[0]][tentativa[1]];
    }

    public void setarPosicao(int[] tentativa, int jogador){
        tabuleiro[tentativa[0]][tentativa[1]] = jogador;
    }

    public int checaLinhas(int jogador){
        for(int linha=0 ; linha<3 ; linha++){
            if (tabuleiro[linha][0] == jogador && tabuleiro[linha][1] == jogador && tabuleiro[linha][2] == jogador)
                return jogador;
        }
        return 0;
    }

    public int checaColunas(int jogador){
        for(int coluna=0 ; coluna<3 ; coluna++){
            if (tabuleiro[0][coluna] == jogador && tabuleiro[1][coluna] == jogador && tabuleiro[2][coluna] == jogador)
                return jogador;
        }
        return 0;
    }

    public int checaDiagonais(int jogador){
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador)
            return jogador;
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)
            return jogador;
        return 0;
    }

    public boolean verificaGanhador(int jogador)
    {
        if (checaLinhas(jogador) == jogador || checaColunas(jogador) == jogador || checaDiagonais(jogador) == jogador)
            return true;
        return false;
    }

    public boolean tabuleiroCompleto(){
        for(int linha=0 ; linha<3 ; linha++)
            for(int coluna=0 ; coluna<3 ; coluna++)
                if( tabuleiro[linha][coluna]==0 )
                    return false;
        return true;
    }
}
