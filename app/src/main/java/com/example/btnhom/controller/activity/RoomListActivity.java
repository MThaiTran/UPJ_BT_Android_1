package com.example.btnhom.controller.activity;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.btnhom.R;
import com.example.btnhom.controller.adapter.RoomAdapter;
import com.example.btnhom.model.Room;
import com.example.btnhom.repository.RoomRepository;

import java.util.List;

public class RoomListActivity extends AppCompatActivity {

    private RecyclerView rvListRooms;
    private Button btnListBack; // Khai báo biến mới
    private RoomAdapter roomAdapter;
    private com.example.btnhom.repository.RoomRepository roomRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

        initViews();
        setupListeners(); // Hàm mới để bắt sự kiện
        loadData();
    }

    private void initViews() {
        rvListRooms = findViewById(R.id.rv_list_rooms);
        btnListBack = findViewById(R.id.btn_list_back); // Ánh xạ View
        rvListRooms.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupListeners() {
        // Sử dụng finish() để đóng Activity hiện tại, quay về Activity trước đó (MainActivity)
        btnListBack.setOnClickListener(v -> finish());
    }

    private void loadData() {
        roomRepository = RoomRepository.getInstance();
        List<Room> rooms = roomRepository.getRoomList();

        roomAdapter = new RoomAdapter(this, rooms);
        rvListRooms.setAdapter(roomAdapter);
    }
}
