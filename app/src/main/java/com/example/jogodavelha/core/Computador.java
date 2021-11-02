package com.example.jogodavelha.core;

import java.util.List;

public class Computador extends Jogador {
    public Computador(int codigo, String nome) {
        super(codigo, nome);
    }

    public int JogarNivelFacil(Tabuleiro tabuleiro, List<DadosDaImagem> dadosDasImagens) {
        int[] res = obterPosicaoDisponivel(tabuleiro);
        int idDaImagem = 0;
        int pos = 0;
        if (res[0] == 99 && res[1]==99) return idDaImagem;
        tabuleiro.setarPosicao(res, this.getCodigo());
        String nomeImagem = "img" + String.valueOf(res[0]) + String.valueOf(res[1]);
        for (int i=0; i < dadosDasImagens.size(); i++)
        {
            pos = dadosDasImagens.get(i).getNome().indexOf(nomeImagem);
            if (pos > 0)
            {
                idDaImagem = dadosDasImagens.get(i).getId();
                break;
            }
        }
        return idDaImagem;
    }

    public int[] obterPosicaoDisponivel(Tabuleiro tabuleiro) {
        for (int l = 0; l < 3; l++)
        {
            for (int c = 0; c < 3; c++) {
                int pos = tabuleiro.obterPosicao(new int[]{l, c});
                if (pos == 0) return new int[]{l, c};
            }
        }
        return new int[]{99, 99};
    }
}
