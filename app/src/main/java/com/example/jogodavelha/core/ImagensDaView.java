package com.example.jogodavelha.core;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class ImagensDaView {
    DadosDaImagem dadosDaImagem;
    List<DadosDaImagem> ids;

    public ImagensDaView(View v) {
        ids = new ArrayList<DadosDaImagem>();
        enumerate(v);
    }

    public List<DadosDaImagem> getDados() {
        return ids;
    }

    private void enumerate(View child) {
        if (child == null)
            return;

        if (child instanceof ViewGroup) {
            enumerate((ViewGroup) child);
        }
        else if (child != null) {
            if (child instanceof ImageView)
            {
                CreateObject(child);
            }
        }
    }

    private void CreateObject(View child) {
        dadosDaImagem = new DadosDaImagem(child.getId(),
                child.getResources().getResourceName(child.getId()));
        ids.add(dadosDaImagem);
    }

    private void enumerate(ViewGroup parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            if (child instanceof ViewGroup) {
                enumerate((ViewGroup) child);
            } else {
                enumerate(child);
            }
        }
    }
}
