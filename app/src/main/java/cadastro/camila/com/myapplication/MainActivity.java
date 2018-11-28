package cadastro.camila.com.myapplication;

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Camila Maria de Oliveira Lima

//******************************************************

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cadastro.camila.com.myapplication.Apresentacao.cadastro;
import cadastro.camila.com.myapplication.Apresentacao.pesquisar;
import cadastro.camila.com.myapplication.Helpers.HelpersBDController;


public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private Button btnCadastrar;
    private Button btnPesquisar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inicializar();


        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, cadastro.class);
                startActivity(it);
            }
        });

        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                HelpersBDController verificar = new HelpersBDController(getBaseContext());

                if (verificar.existeCadastro()) {
                    Intent it = new Intent(MainActivity.this, pesquisar.class);
                    startActivity(it);
                } else {
                    Toast.makeText(getApplicationContext(), "Não há dados cadastrados!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    private void Inicializar() {
        texto = findViewById(R.id.texto);
        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnPesquisar = findViewById(R.id.btnPesquisar);
    }
// OBJETIVO.......: Este loop é utilizado para criar os botões de Cadastrar e Pesquisar, onde Cadastrar transfere para segunda tela e efetua o cadastro. Ja a Pesquisar mostra os cadastros realizados.


}
