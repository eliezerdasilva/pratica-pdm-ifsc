package com.example.mylaucher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    PackageManager pm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);

        pm = getPackageManager();
        ArrayList<String> appsNames = new ArrayList<>();
        List<ApplicationInfo> apps = pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo app : apps) {
            appsNames.add(app.loadLabel(pm).toString());
        }
        //Criando o adapter padrao do array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, appsNames);
        //listView.setAdapter(adapter);


        //Adaptador Personalizado (Custon Adapter)
        ApplicationAdapter adapter2 = new ApplicationAdapter(this, R.layout.item_lista, apps);

        listView.setAdapter(adapter2);


    }
}