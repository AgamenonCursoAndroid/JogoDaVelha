package com.example.jogodavelha;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jogodavelha.core.Computador;
import com.example.jogodavelha.core.DadosDaImagem;
import com.example.jogodavelha.core.Humano;
import com.example.jogodavelha.core.ImagensDaView;
import com.example.jogodavelha.core.Tabuleiro;
import com.example.jogodavelha.core.Utils;

import java.util.List;

public class HomemMaquinaActivity extends AppCompatActivity {
    TextView txtResultado;
    Button btnJogarNovamente;
    RadioGroup rgNivelDificuldade;
    Tabuleiro tabuleiro;
    Computador computador = new Computador(1, "Computador");
    Humano humano = new Humano(2, "Você");
    final String suaVez = "Sua vez de jogar !!!";
    List<DadosDaImagem> dadosDasImagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homem_maquina);
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) (findViewById(android.R.id.content))).getChildAt(0);
        dadosDasImagens = new ImagensDaView(viewGroup).getDados();
        tabuleiro = new Tabuleiro();
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        txtResultado.setText("Pode Iniciar o Jogo !!!");
        btnJogarNovamente = (Button) findViewById(R.id.btnJogarNovamente);
        btnJogarNovamente.setVisibility(View.INVISIBLE);
        rgNivelDificuldade = (RadioGroup) findViewById(R.id.rgNivelDificuldade);
    }

    public void Selecionou(View view) {
        txtResultado.setText("");
        ImageView img = findViewById(view.getId());
        int[] posicao = Utils.ObterPosicaoSelecionadaHumano(img.getResources().getResourceName(img.getId()));
        int pos = tabuleiro.obterPosicao(posicao);
        if (pos != 0)
        {
            txtResultado.setText("Jogada Inválida!!!");
            return;
        }
        humano.Jogar(tabuleiro, posicao);
        img.setImageResource(android.R.drawable.star_big_on);

        int idImagem = computador.JogarNivelFacil(tabuleiro, dadosDasImagens);
        if (idImagem != 0)
        {
            ImageView imgComputador = findViewById(idImagem);
            imgComputador.setImageResource(android.R.drawable.star_big_off);
        }
        VerificaGanhador();
    }

    private void PrepararNovoJogo() {
        ImageView img;
        int idImagem;
        for (int i=0; i < dadosDasImagens.size(); i++)
        {
            idImagem = dadosDasImagens.get(i).getId();
            img = (ImageView) findViewById(idImagem);
            img.setEnabled(false);
        }
        btnJogarNovamente.setVisibility(View.VISIBLE);
    }

    public void JogarNovamente(View view) {
        ImageView img;
        int idImagem;
        for (int i=0; i < dadosDasImagens.size(); i++)
        {
            idImagem = dadosDasImagens.get(i).getId();
            img = (ImageView) findViewById(idImagem);
            img.setImageResource(android.R.drawable.checkbox_off_background);
            img.setEnabled(true);
            tabuleiro.LimparTabuleiro();
        }
        txtResultado.setText("Pode Iniciar o Jogo !!!");
        btnJogarNovamente.setVisibility(View.INVISIBLE);
    }

    public void VerificaGanhador() {
        boolean ganhador = false;
        ganhador = tabuleiro.verificaGanhador(computador.getCodigo());
        if (ganhador)
        {
            txtResultado.setText("Eu Ganhei !!!");
            PrepararNovoJogo();
            return;
        }
        ganhador = tabuleiro.verificaGanhador(humano.getCodigo());
        if (ganhador)
        {
            txtResultado.setText("Você Ganhou !!!");
            PrepararNovoJogo();
            return;
        }
        if (tabuleiro.tabuleiroCompleto())
        {
            txtResultado.setText("Empatou !!!");
            PrepararNovoJogo();
            return;
        }
        txtResultado.setText(suaVez);
    }

    public void ClicouNivelDificuldade(View view)
    {
        switch (view.getId()) {
            case R.id.rbMedio:
                MensagemNaoImplementado();
                break;
            case R.id.rbDificl:
                MensagemNaoImplementado();
                break;
        }
    }

    private void MensagemNaoImplementado() {
        Toast toast = Toast.makeText(this,
                "Nível não Implementado - Aguarde",
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
        RadioButton rb = findViewById(R.id.rbFacil);
        rb.setChecked(true);
    }

}
