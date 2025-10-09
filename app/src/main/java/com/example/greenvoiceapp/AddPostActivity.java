package com.example.greenvoiceapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddPostActivity extends AppCompatActivity {
    EditText titleInput, contentInput;
    Button saveBtn;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        dbHelper = new DatabaseHelper(this);
        titleInput = findViewById(R.id.titleInput);
        contentInput = findViewById(R.id.contentInput);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(v -> {
            String title = titleInput.getText().toString().trim();
            String content = contentInput.getText().toString().trim();

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHelper.addPost(title, content);
            Toast.makeText(this, "Post Added!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
