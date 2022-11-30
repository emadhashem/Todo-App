package com.example.simpletodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TodoAdapter extends ArrayAdapter<Todo> {

    public static class ViewHolder {
        TextView todoTextView;
    }

    public TodoAdapter(Context ctx , ArrayList<Todo> list) {
        super(ctx , 0 , list);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder item;
        if(convertView == null) {
            item = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.todolistitem, parent, false);
            item.todoTextView = convertView.findViewById(R.id.todo_text);
            convertView.setTag(item);
        } else {
            item = (ViewHolder) convertView.getTag();
        }
        Todo curTodo = getItem(position);
        item.todoTextView.setText(curTodo.getText());
        return convertView;
    }
}
