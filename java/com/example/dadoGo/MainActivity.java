package com.example.dadogo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Agora declaramos a Imagem que vai funcionar como botão
    private ImageButton btnMenuD6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 1. Buscamos o ID novo que você colocou no XML (btnMenuD6)
        btnMenuD6 = findViewById(R.id.btnMenuD6);

        // 2. Só configura o clique se ele encontrar a imagem no layout
        if (btnMenuD6 != null) {
            btnMenuD6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Vamos direto para a tela do d6.
                    // A lógica de sortear o número a gente deixa dentro da tela do d6 para ficar mais organizado!
                    Intent intent = new Intent(MainActivity.this, d6.class);
                    startActivity(intent);
                }
            });
        }

        // Ajuste automático de tela (Insets)
        // Certifique-se que o id do seu layout principal no XML seja "main"
        View viewPrincipal = findViewById(R.id.main);
        if (viewPrincipal != null) {
            ViewCompat.setOnApplyWindowInsetsListener(viewPrincipal, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
    }
}
