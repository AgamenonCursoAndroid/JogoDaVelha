package com.example.jogodavelha.core;

import java.util.List;

public class Utils {
    public static int[] ObterPosicaoSelecionadaHumano(String dado) {
        int[] posicao = new int[2];
        posicao[0] = 0;
        posicao[1] = 0;
        int pos = dado.indexOf("img");
        if (pos > -1) {
            String str = dado.substring(pos+3);
            posicao[0] = Integer.parseInt(str.substring(0,1));
            posicao[1] = Integer.parseInt(str.substring(1,2));
        }
        return posicao;
    }

}
