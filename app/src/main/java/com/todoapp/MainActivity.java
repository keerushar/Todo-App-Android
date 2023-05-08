package com.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText todoEt;
    MaterialButton saveBtn;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listLv);

        saveBtn = findViewById(R.id.saveBtn);

        items = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, R.layout.my_list, R.id.titleTv, items);
        listView.setAdapter(adapter);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(v);
            }
        });
    }

    private void addItem(View view) {
        todoEt = findViewById(R.id.todoEt);
        String text = todoEt.getText().toString();
        if (!text.equals("")) {
            adapter.add(text);
            todoEt.setText("");
        } else {
            Toast.makeText(getApplicationContext(), "Please enter the text", Toast.LENGTH_LONG).show();
        }
    }
}
