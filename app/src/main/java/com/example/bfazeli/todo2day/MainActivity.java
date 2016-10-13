package com.example.bfazeli.todo2day;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DBHelper database;
    private List<Task> taskList;
    private TaskListAdapter taskListAdapter;

    private EditText taskEditText;
    private ListView taskListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FOR NOW (TEMPORARY), delete the old database, then create a new one
        this.deleteDatabase(DBHelper.DATABASE_TABLE);

        // Let's make a DBHelper reference:
        database = new DBHelper(this);

        database.addTask(new Task("Studying", 0));
        database.addTask(new Task("Eating", 0));

        // Let's fill the List with all tasks
        taskList = database.getAllTasks();

        // Let's create our custom task list adapter
        // (We want to associate the adapter with context, the layout and the List)
        taskListAdapter = new TaskListAdapter(this, R.layout.task_item, taskList);

        // Connect the ListView with our layout
        taskListView = (ListView) findViewById(R.id.taskListView);

        // Associate the adapter with the list view
        taskListView.setAdapter(taskListAdapter);
    }
}
