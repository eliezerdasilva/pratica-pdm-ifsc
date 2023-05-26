package com.example.mynotes;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import model.Nota;

public class ApplicationAdapter extends ArrayAdapter<Nota> {
    Context context;
    int resorceLayout;
    private List<Nota> listaNota;
    Nota nota;
    List<ApplicationInfo> obj;
    public ApplicationAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resorceLayout =resource;
        this.obj=objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            itemView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        }
        nota = new Nota();
        nota = listaNota.get(position);

        TextView textViewNome = itemView.findViewById(android.R.id.text1);
        textViewNome.setText(nota.getTitulo());

        return itemView;
    }
}
