package com.example.btnhom.controller.activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.btnhom.R;

import android.os.Bundle;
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
    private RoomAdapter roomAdapter;
    private RoomRepository roomRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

        initViews();
        loadData();
    }

    private void initViews() {
        rvListRooms = findViewById(R.id.rv_list_rooms);
        rvListRooms.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadData() {
        // Lấy dữ liệu từ Model
        roomRepository = RoomRepository.getInstance();
        List<Room> rooms = roomRepository.getRoomList();

        // Cập nhật View thông qua Adapter
        roomAdapter = new RoomAdapter(this, rooms);
        rvListRooms.setAdapter(roomAdapter);
    }
}