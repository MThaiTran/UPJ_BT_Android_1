package com.example.btnhom.controller.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.btnhom.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.btnhom.R;

public class MainActivity extends AppCompatActivity {

    private Button btnMainCreate;
    private Button btnMainView;
    private Button btnMainUpdate;
    private Button btnMainDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupListeners();
    }

    private void initViews() {
        btnMainCreate = findViewById(R.id.btn_main_create);
        btnMainView = findViewById(R.id.btn_main_view);
        btnMainUpdate = findViewById(R.id.btn_main_update);
        btnMainDelete = findViewById(R.id.btn_main_delete);
    }

    private void setupListeners() {
        // Nút thêm phòng (Chưa có màn hình, tạm thời hiển thị thông báo)
        btnMainCreate.setOnClickListener(v ->
                                                 Toast.makeText(this, "Chuyển sang màn hình Create", Toast.LENGTH_SHORT).show()
        );

        // Nút Xem danh sách (Điều hướng sang RoomListActivity)
        btnMainView.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, RoomListActivity.class);
            startActivity(intent);
        });

        // Nút Cập nhật
        btnMainUpdate.setOnClickListener(v ->
                                                 Toast.makeText(this, "Chuyển sang màn hình Update", Toast.LENGTH_SHORT).show()
        );

        // Nút Xóa
        btnMainDelete.setOnClickListener(v ->
                                                 Toast.makeText(this, "Chuyển sang màn hình Delete", Toast.LENGTH_SHORT).show()
        );
    }
}