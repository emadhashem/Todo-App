package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button addBtn;
    private EditText textInput;
    private ListView todoList;
    private ArrayList<Todo> list;
    TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);todoList = findViewById(R.id.todolist);
        textInput = findViewById(R.id.text_input);
        addBtn = findViewById(R.id.add_btn);
        list = new ArrayList<Todo>();
        adapter = new TodoAdapter(this , list);
        todoList.setAdapter(adapter);
        handleAddTodo();

    }

    public void handleAddTodo() {

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = String.valueOf(textInput.getText());
                adapter.add(new Todo(str));
            }
        });

    }
}