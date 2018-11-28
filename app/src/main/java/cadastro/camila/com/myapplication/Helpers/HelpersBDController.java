package cadastro.camila.com.myapplication.Helpers;

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Camila Maria de Oliveira Lima

//******************************************************

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import cadastro.camila.com.myapplication.Dominio.Pessoa;

import static cadastro.camila.com.myapplication.Helpers.HelpersCreateBD.TABELA;


public class HelpersBDController {

    private String TAG = "TAG";
    private SQLiteDatabase db;
    private HelpersCreateBD banco_dados;

    public HelpersBDController(Context context) {
        banco_dados = new HelpersCreateBD(context);
    }

    // realiza insercao dos dados no banco de dados
    public String inserirDados(String nome, String cpf, String idade, String telefone, String email) {
        ContentValues valores;
        long retorno;

        //getWritableDatabase = prepara o banco de dados para leitura e escrita de dados.
        db = banco_dados.getWritableDatabase();
        valores = new ContentValues();
        valores.put(Pessoa.NOME, nome);
        valores.put(Pessoa.CPF, cpf);
        valores.put(Pessoa.IDADE, idade);
        valores.put(Pessoa.TELEFONE, telefone);
        valores.put(Pessoa.EMAIL, email);


        // insere os dados no banco de dados
        retorno = db.insert(TABELA, null, valores);
        // fecha a conexao
        db.close();

        if (retorno == -1)
            return "Erro ao inserir registro!";
        else
            return "Cadastro realizado com sucesso!";

    }

    // lista contendo todos os cadastros
    public Cursor carregaDados() {
        Cursor cursor;
        String[] campos = {
                Pessoa.ID,
                Pessoa.NOME,
                Pessoa.CPF,
                Pessoa.IDADE,
                Pessoa.TELEFONE,
                Pessoa.EMAIL

        };
        db = banco_dados.getReadableDatabase();
        cursor = db.query(TABELA, campos, null, null, null, null, Pessoa.ID, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    // verifica se existe dados cadastrados no banco de dados
    public boolean existeCadastro() {
        db = banco_dados.getWritableDatabase();
        long numOfEntries = DatabaseUtils.queryNumEntries(db, TABELA);

        if (numOfEntries == 0l) {
            return false;
        } else {
            return true;
        }
    }

     public Integer Excluir(int codigo){
        db = banco_dados.getWritableDatabase();
        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return db.delete(TABELA,"_id = ? ",
                new String[]{
                        Integer.toString(codigo)
                }
        );
    }

}



