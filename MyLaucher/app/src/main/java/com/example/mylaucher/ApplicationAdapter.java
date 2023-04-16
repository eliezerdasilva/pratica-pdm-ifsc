package com.example.mylaucher;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ApplicationAdapter  extends ArrayAdapter {
    Context context ;
    int resorceLayout;
    List<ApplicationInfo>  objs;
    public ApplicationAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;
        this.resorceLayout =resource;
        this.objs=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(resorceLayout, parent, false);

        ImageView imagemView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);

        ApplicationInfo app = objs.get(position);


        imagemView.setImageDrawable(app.loadIcon(context.getPackageManager()));
        textView.setText(app.loadLabel(context.getPackageManager()));
        return convertView;

    }


}
