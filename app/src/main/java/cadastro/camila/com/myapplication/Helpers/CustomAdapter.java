package cadastro.camila.com.myapplication.Helpers;

//******************************************************

//Instituto Federal de São Paulo - Campus Sertãozinho

//Disciplina......: M4DADM

//Programação de Computadores e Dispositivos Móveis

//Aluno...........: Camila Maria de Oliveira Lima

//******************************************************

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import cadastro.camila.com.myapplication.Dominio.Pessoa;
import cadastro.camila.com.myapplication.MainActivity;
import cadastro.camila.com.myapplication.R;

public class CustomAdapter extends SimpleCursorAdapter {

    private Context mContext;
    private Context appContext;
    private int layout;
    private Cursor cr;
    private final LayoutInflater inflater;
//    private CustomAdapter self;

    public CustomAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
        this.layout = layout;
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.cr = c;
//        this.self = self;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return inflater.inflate(layout, null);
    }

    @Override
    public void bindView(final View view, final Context context, final Cursor cursor) {
    super.bindView(view, context, cursor);

        final int row_id = cursor.getInt( cursor.getColumnIndex( Pessoa.ID ) );

        // CRIANDO O BOTÃO  EXCLUIR PARA DELETARMOS UM REGISTRO DO BANCO DE DADOS
        Button buttonExcluir = (Button)   view.findViewById(R.id.buttonExcluir);

        // CRIANDO EVENTO CLICK PARA O BOTÃO DE EXCLUIR REGISTRO
        buttonExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //EXCLUINDO UM REGISTRO
                HelpersBDController crud = new HelpersBDController(v.getContext());
                crud.Excluir(row_id);

                notifyDataSetChanged();

                //MOSTRA A MENSAGEM APÓS EXCLUIR UM REGISTRO
                Toast.makeText(v.getContext(), "Registro excluido com sucesso!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
