package com.example.btnhom.controller.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
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
    private Button btnListBack;
    private RoomAdapter roomAdapter;
    private List<Room> roomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);

        initViews();
        setupListeners();
        loadData();
    }

    private void initViews() {
        rvListRooms = findViewById(R.id.rv_list_rooms);
        btnListBack = findViewById(R.id.btn_list_back);
        rvListRooms.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupListeners() {
        // Nút quay lại MainActivity theo đúng quy ước
        btnListBack.setOnClickListener(v -> finish());
    }

    private void loadData() {
        roomList = RoomRepository.getRoomList();
        roomAdapter = new RoomAdapter(this, roomList);

        // Đăng ký sự kiện nhấn giữ để xóa
        roomAdapter.setOnItemLongClickListener((room, position) -> showDeleteConfirmDialog(room, position));

        rvListRooms.setAdapter(roomAdapter);
    }

    /**
     * Hiển thị AlertDialog xác nhận trước khi xóa theo yêu cầu.
     */
    private void showDeleteConfirmDialog(Room room, int position) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.dialog_delete_confirm_title))
                .setMessage(getString(R.string.dialog_delete_confirm_message, room.getRoomName()))
                .setPositiveButton(getString(R.string.btn_delete_confirm), (dialog, which) -> performDelete(room.getRoomId(), position))
                .setNegativeButton(getString(R.string.btn_delete_cancel), null)
                .show();
    }

    /**
     * Thực hiện xóa phòng trong Model và cập nhật View.
     */
    private void performDelete(String roomId, int position) {
        RoomRepository.deleteRoom(roomId);
        
        // Cập nhật giao diện sau khi xóa
        roomAdapter.notifyItemRemoved(position);
        roomAdapter.notifyItemRangeChanged(position, roomList.size());

        Toast.makeText(this, getString(R.string.toast_delete_success), Toast.LENGTH_SHORT).show();
    }
}
