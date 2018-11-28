package cadastro.camila.com.myapplication.Apresentacao;

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Camila Maria de Oliveira Lima

//******************************************************
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import cadastro.camila.com.myapplication.Dominio.Pessoa;
import cadastro.camila.com.myapplication.Helpers.CustomAdapter;
import cadastro.camila.com.myapplication.Helpers.HelpersBDController;
import cadastro.camila.com.myapplication.MainActivity;
import cadastro.camila.com.myapplication.R;


public class pesquisar extends Activity {
    private ListView lista;
    private Button btnVoltar, buttonExcluir;

    private TextView codigo, nome, cpf, idade, telefone, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);

        Inicializar();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(pesquisar.this, MainActivity.class);
                startActivity(it);
            }
        });

        HelpersBDController crud = new HelpersBDController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[]{
                Pessoa.ID,
                Pessoa.NOME,
                Pessoa.CPF,
                Pessoa.IDADE,
                Pessoa.TELEFONE,
                Pessoa.EMAIL
        };


        int[] idViews = new int[]{
                R.id.codigoPessoa,
                R.id.nomePessoa,
                R.id.cpfPessoa,
                R.id.idadePessoa,
                R.id.telefonePessoa,
                R.id.emailPessoa
        };

        CustomAdapter adaptador = new CustomAdapter(getBaseContext(),
                R.layout.activity_gridpesquisa, cursor, nomeCampos, idViews, 0);

        lista.setAdapter(adaptador);
    }

    //Objetivo Consultar os registros cadastrados
    public void Inicializar() {

        btnVoltar = findViewById(R.id.btnVoltar);
        lista = findViewById(R.id.listView);

        codigo = findViewById(R.id.codigo);
        nome = findViewById(R.id.nome);
        cpf = findViewById(R.id.cpf);
        idade = findViewById(R.id.idade);
        telefone = findViewById(R.id.telefone);
        email = findViewById(R.id.email);
    }
//Objetivo o botao voltar [e utilizado para voltar a tela principal

}
