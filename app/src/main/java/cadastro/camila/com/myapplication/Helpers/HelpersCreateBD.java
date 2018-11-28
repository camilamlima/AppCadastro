package cadastro.camila.com.myapplication.Helpers;

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Camila Maria de Oliveira Lima

//******************************************************

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import cadastro.camila.com.myapplication.Dominio.Pessoa;


public class HelpersCreateBD extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "CadastroPessoa.db";
    public static final String TABELA = "Pessoa";
    private String TAG = "TAG";

    public HelpersCreateBD(Context context) {
        // Cria o BD CADASTROPESSOA
        super(context, NOME_BANCO, null, Pessoa.VERSAO);
    }

    //é chamado quando a aplicação cria o banco de dados pela primeira  vez.
    @Override
    public void onCreate(SQLiteDatabase db) {

        // scritp para criar da Tabela PESSOA
        String sql = "CREATE TABLE " + TABELA + "("
                + Pessoa.ID + " integer primary key autoincrement,"
                + Pessoa.NOME + " text,"
                + Pessoa.CPF + " text,"
                + Pessoa.IDADE + " text,"
                + Pessoa.TELEFONE + " text,"
                + Pessoa.EMAIL + " text"
                + ")";
        db.execSQL(sql);

        Log.i(TAG, "BD criado");

    }

    //é o método responsável por atualizar o banco de dados com alguma informação estrutural que tenha sido alterada.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

        Log.i(TAG, "UpGrade");
    }


}
