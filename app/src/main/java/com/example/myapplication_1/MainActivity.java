package com.example.myapplication_1;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication_1.Adapter.ToDoAdapter;
import com.example.myapplication_1.Model.ToDoModel;
import com.example.myapplication_1.Util.DataBaseHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DialogCloseListener {

    private RecyclerView taskRecycleView;
    private ToDoAdapter tasksAdapter;
    private List<ToDoModel> taskList;
    private DataBaseHandler db;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        db= new DataBaseHandler(this);



        ToDoModel task= new ToDoModel();
        task.setTask("This is test task");
        task.setStatus(0);
        task.setId(1);

        taskList.add(task);
        taskList.add(task);
        taskList.add(task);
        taskList.add(task);
        taskList.add(task);

        tasksAdapter.setTasks(TaskList);

        taskList= new ArrayList<>();

        taskRecycleView= taskRecycleView.findViewById(R.id.taskRecycleView);
        taskRecycleView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter =new ToDoAdapter(this);
        tasksRecycleView.setAdapter(tasksAdapter);
    }
    @Override
    public void handleDialogClose(DialogInterface dialog){
        taskList= db.getAllTask();
        Collection.reverse(TaskList);
        tasksAdapter.setTasks(taskList);
        tasksAdapter.notifyDataSetChanged();
    }



}
