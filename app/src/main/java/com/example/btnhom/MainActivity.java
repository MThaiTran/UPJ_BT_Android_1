package com.example.btnhom;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.btnhom.controller.AddRoomActivity;
import com.example.btnhom.repository.RoomRepository;

public class MainActivity extends AppCompatActivity {

    private TextView tvMainRoomCount;

    private final ActivityResultLauncher<Intent> addRoomLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    updateRoomCount();
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvMainRoomCount = findViewById(R.id.tv_main_room_count);
        Button btnMainAddRoom = findViewById(R.id.btn_main_add_room);
        btnMainAddRoom.setOnClickListener(v -> addRoomLauncher.launch(new Intent(this, AddRoomActivity.class)));

        updateRoomCount();
    }

    private void updateRoomCount() {
        int totalRooms = RoomRepository.getRoomList().size();
        tvMainRoomCount.setText(getString(R.string.label_total_rooms, totalRooms));
    }
}