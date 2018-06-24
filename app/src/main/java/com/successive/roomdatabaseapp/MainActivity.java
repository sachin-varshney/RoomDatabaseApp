package com.successive.roomdatabaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import com.successive.roomdatabaseapp.roomdatabase.AppDatabase;
import com.successive.roomdatabaseapp.roomdatabase.User;

import java.util.Iterator;
import java.util.List;

import static com.successive.roomdatabaseapp.roomdatabase.AppDatabase.appDatabase;

public class MainActivity extends AppCompatActivity {
    TextView count, dataTxt;
    AppCompatButton add, countBtn, dataBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AppDatabase appDatabase = AppDatabase.getDatabaseInstance(MainActivity.this);
        dataTxt = findViewById(R.id.data);
        count = findViewById(R.id.count);
        add = findViewById(R.id.add);
        countBtn = findViewById(R.id.getCount);
        dataBtn = findViewById(R.id.getData);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDummyData();
            }
        });

        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int totalEntry = appDatabase.userDao().getCount();
                count.setText("count: " + totalEntry);
            }
        });

        dataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> userDataList = appDatabase.userDao().getUserList();
                Iterator iterator = userDataList.iterator();
                String data = "";
                while (iterator.hasNext()) {
                    User user = (User) iterator.next();
                    data = data.isEmpty() ? user.toString() : data + user.toString();

                }
                dataTxt.setText(data);
            }
        });
    }

    public void addDummyData() {
        appDatabase.userDao().addUser(
                new User("Sachin", "Varshney", "728945254"),
                new User("Nisheet", "Varshney", "234234234"),
                new User("Prashant", "Varshney", "35342545"),
                new User("Joe", "Smith", "090943042"));
    }
}
