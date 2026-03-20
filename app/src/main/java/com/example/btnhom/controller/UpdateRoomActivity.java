package com.example.btnhom.controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btnhom.R;
import com.example.btnhom.model.Room;
import com.example.btnhom.model.RoomRepository;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UpdateRoomActivity extends AppCompatActivity {

    private TextInputEditText tietRoomName, tietRentPrice, tietTenantName, tietPhoneNumber;
    private TextInputLayout tilTenantName, tilPhoneNumber;
    private CheckBox cbIsRented;
    private Button btnSave, btnCancel;
    private Room currentRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_room);

        initViews();
        loadRoomData();
        setupListeners();
    }

    private void initViews() {
        tietRoomName = findViewById(R.id.tiet_update_room_name);
        tietRentPrice = findViewById(R.id.tiet_update_rent_price);
        tietTenantName = findViewById(R.id.tiet_update_tenant_name);
        tietPhoneNumber = findViewById(R.id.tiet_update_phone_number);
        tilTenantName = findViewById(R.id.til_update_tenant_name);
        tilPhoneNumber = findViewById(R.id.til_update_phone_number);
        cbIsRented = findViewById(R.id.cb_update_is_rented);
        btnSave = findViewById(R.id.btn_update_save);
        btnCancel = findViewById(R.id.btn_update_cancel);
    }

    private void loadRoomData() {
        // Assume room ID is passed via intent
        String roomId = getIntent().getStringExtra("ROOM_ID");
        if (roomId != null) {
            currentRoom = RoomRepository.getRoomById(roomId);
            if (currentRoom != null) {
                tietRoomName.setText(currentRoom.getRoomName());
                tietRentPrice.setText(String.valueOf(currentRoom.getRentPrice()));
                cbIsRented.setChecked(currentRoom.isRented());
                tietTenantName.setText(currentRoom.getTenantName());
                tietPhoneNumber.setText(currentRoom.getPhoneNumber());
                
                toggleTenantInfo(currentRoom.isRented());
            }
        }
    }

    private void setupListeners() {
        cbIsRented.setOnCheckedChangeListener((buttonView, isChecked) -> toggleTenantInfo(isChecked));

        btnSave.setOnClickListener(v -> saveRoom());

        btnCancel.setOnClickListener(v -> finish());
    }

    private void toggleTenantInfo(boolean isRented) {
        int visibility = isRented ? View.VISIBLE : View.GONE;
        tilTenantName.setVisibility(visibility);
        tilPhoneNumber.setVisibility(visibility);
    }

    private void saveRoom() {
        String name = tietRoomName.getText().toString().trim();
        String priceStr = tietRentPrice.getText().toString().trim();
        boolean isRented = cbIsRented.isChecked();
        String tenant = tietTenantName.getText().toString().trim();
        String phone = tietPhoneNumber.getText().toString().trim();

        if (name.isEmpty()) {
            tietRoomName.setError(getString(R.string.error_empty_name));
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            tietRentPrice.setError(getString(R.string.error_invalid_price));
            return;
        }

        currentRoom.setRoomName(name);
        currentRoom.setRentPrice(price);
        currentRoom.setRented(isRented);
        if (isRented) {
            currentRoom.setTenantName(tenant);
            currentRoom.setPhoneNumber(phone);
        } else {
            currentRoom.setTenantName("");
            currentRoom.setPhoneNumber("");
        }

        RoomRepository.updateRoom(currentRoom);
        Toast.makeText(this, R.string.update_success, Toast.LENGTH_SHORT).show();
        finish();
    }
}
