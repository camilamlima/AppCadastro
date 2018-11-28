package cadastro.camila.com.myapplication.Apresentacao;

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Camila Maria de Oliveira Lima

//******************************************************

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cadastro.camila.com.myapplication.Helpers.HelpersBDController;
import cadastro.camila.com.myapplication.MainActivity;
import cadastro.camila.com.myapplication.R;

public class cadastro extends Activity {

    private EditText nome;
    private EditText cpf;
    private EditText idade;
    private EditText telefone;
    private EditText email;
    private Button btnSalvar;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        Inicializar();
        nome.setFocusable(true);
        nome.requestFocus();

        // OBJETIVO.......: Este loop é utilizado para validar o valor do campo nome, cpf, idade, telefone e email.

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HelpersBDController crud = new HelpersBDController(getBaseContext());

                String resultado;

                if (TextUtils.isEmpty(nome.getText())) {
                    nome.setError("Informe o Nome");
                    nome.setFocusable(true);
                    return;
                } else if (TextUtils.isEmpty(cpf.getText())) {
                    cpf.setError("Informe o CPF");
                    cpf.setFocusable(true);
                    return;
                } else if (TextUtils.isEmpty(idade.getText())) {
                    idade.setError("Informe a Idade");
                    idade.setFocusable(true);
                    return;
                } else if (TextUtils.isEmpty(telefone.getText())) {
                    telefone.setError("Informe o Telefone");
                    telefone.setFocusable(true);
                    return;
                } else if (TextUtils.isEmpty(email.getText())) {
                    email.setError("Informe o Email");
                    email.setFocusable(true);
                    return;
                }

                resultado = crud.inserirDados(
                        nome.getText().toString(),
                        cpf.getText().toString(),
                        idade.getText().toString(),
                        telefone.getText().toString(),
                        email.getText().toString()
                );

                LimparTudo();
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_SHORT).show();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(cadastro.this, MainActivity.class);
                startActivity(it);
            }
        });

    }

    // OBJETIVO.......: Este loop é utilizado para ativar os botões Voltar e Salvar.

    private void Inicializar() {

        btnSalvar = findViewById(R.id.btnSalvar);
        btnVoltar = findViewById(R.id.btnVoltar);

        nome = findViewById(R.id.edtNome);
        cpf = findViewById(R.id.edtCpf);
        idade = findViewById(R.id.edtIdade);
        telefone = findViewById(R.id.edtTelefone);
        email = findViewById(R.id.edtEmail);



    }


    private void LimparTudo() {
        nome.setText("");
        cpf.setText("");
        idade.setText("");
        telefone.setText("");
        email.setText("");
    }
}