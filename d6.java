package com.example.dadogo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random; // Importante para o sorteio!

public class d6 extends AppCompatActivity {

    private ImageView imageResultadoDado;
    private Button btnVoltar;
    private Button btnLancar; // Referência para o novo botão
    private Random gerador = new Random(); // Objeto que sorteia os números

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d6);

        // 1. Vincula os componentes do XML
        imageResultadoDado = findViewById(R.id.imageResultadoDado);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnLancar = findViewById(R.id.btnLancar); // ID que deve estar no seu XML

        // 2. Lógica inicial: mostra o número que veio da outra tela (se houver)
        Bundle dados = getIntent().getExtras();
        if (dados != null) {
            int numeroInicial = dados.getInt("numero");
            atualizarImagem(numeroInicial);
        }

        // 3. Botão LANÇAR: Sorteia e troca a imagem aqui mesmo
        btnLancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Sorteia de 1 a 6
                int novoNumero = gerador.nextInt(6) + 1;
                atualizarImagem(novoNumero);
            }
        });

        // 4. Botão VOLTAR
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // MÉTODO MÁGICO: Ele monta o nome "d6_1", "d6_2"... e acha a imagem sozinho!
    private void atualizarImagem(int numero) {
        String nomeDaImagem = "d6_" + numero;

        // Procura o ID da imagem na pasta drawable pelo nome dela
        int resId = getResources().getIdentifier(nomeDaImagem, "drawable", getPackageName());

        if (resId != 0) {
            imageResultadoDado.setImageResource(resId);
        }
    }
}