package com.example.greenvoiceapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseHelper dbHelper;
    PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);

        recyclerView = findViewById(R.id.recyclerView);
        dbHelper = new DatabaseHelper(this);

        ArrayList<Post> posts = dbHelper.getAllPosts();
        adapter = new PostAdapter(posts);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
