package com.example.crudmynotes;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.crudmynotes.controller.NotaController;
import com.example.crudmynotes.model.Nota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewDados;
    private ArrayAdapter<String> adapter;
    private ArrayList<Nota> notas;
    private NotaController notaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewDados = findViewById(R.id.listViewNotas);
        Button buttonCadastrar = findViewById(R.id.buttonCadastra);
        Button buttonPesquisar = findViewById(R.id.buttonPesquisar);
        Button buttonLimpar = findViewById(R.id.buttonLimpar);



        notaController = new NotaController(this);
        notas = notaController.listarNotas();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getTitulosNotas());
        listViewDados.setAdapter(adapter);

        buttonPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText pesquisa = (EditText) findViewById(R.id.txtPesquisa);
                String pesquisaString = pesquisa.getText().toString();
                notas = notaController.filtroTitulo(pesquisaString);
                adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, getTitulosNotas());
                listViewDados.setAdapter(adapter);
            }
        });

        buttonLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notas = notaController.listarNotas();
                adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, getTitulosNotas());
                listViewDados.setAdapter(adapter);
            }
        });

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abriTelaCadastro();
            }
        });

        listViewDados.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                excluirNota(i);
                return true;
            }
        });

        listViewDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                alterarNota(position);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        notaController.fecharBancoDados();
    }

    @Override
    protected void onResume() {
        super.onResume();
        notas = notaController.listarNotas();
        adapter.clear();
        adapter.addAll(getTitulosNotas());
    }

    private void abriTelaCadastro() {
        Intent intent = new Intent(this, Cadastro.class);
        startActivity(intent);
    }

    private void excluirNota(final int position) {
        AlertDialog.Builder msgBox = new AlertDialog.Builder(MainActivity.this);
        msgBox.setTitle("Excluir");
        msgBox.setIcon(android.R.drawable.ic_menu_delete);
        msgBox.setMessage("Você realmente deseja excluir esse registro?");
        msgBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int id = notas.get(position).getId();
                notaController.excluirNota(id);
                notas.remove(position);
                adapter.remove(adapter.getItem(position));
                adapter.notifyDataSetChanged();
            }
        });
        msgBox.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        msgBox.show();
    }

    private void alterarNota(int position) {
        int id = notas.get(position).getId();
        Intent intent = new Intent(this, Alterar.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public ArrayList<String> getTitulosNotas() {
        ArrayList<String> titulos = new ArrayList<>();
        for (Nota nota : notas) {
            titulos.add(nota.getTitulo());
        }
        return titulos;
    }
}
