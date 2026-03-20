package com.example.btnhom.controller;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btnhom.R;
import com.example.btnhom.model.Room;
import com.example.btnhom.repository.RoomRepository;

public class AddRoomActivity extends AppCompatActivity {

    private EditText etAddRoomCode;
    private EditText etAddRoomName;
    private EditText etAddRoomPrice;
    private CheckBox cbAddRoomRented;
    private EditText etAddTenantName;
    private EditText etAddTenantPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_room);

        initViews();
        setupRentedToggle();
        findViewById(R.id.btn_add_save).setOnClickListener(v -> saveRoom());
    }

    private void initViews() {
        etAddRoomCode = findViewById(R.id.et_add_room_code);
        etAddRoomName = findViewById(R.id.et_add_room_name);
        etAddRoomPrice = findViewById(R.id.et_add_room_price);
        cbAddRoomRented = findViewById(R.id.cb_add_room_rented);
        etAddTenantName = findViewById(R.id.et_add_tenant_name);
        etAddTenantPhone = findViewById(R.id.et_add_tenant_phone);
    }

    private void setupRentedToggle() {
        cbAddRoomRented.setOnCheckedChangeListener((buttonView, isChecked) -> {
            etAddTenantName.setEnabled(isChecked);
            etAddTenantPhone.setEnabled(isChecked);
            if (!isChecked) {
                etAddTenantName.setText("");
                etAddTenantPhone.setText("");
            }
        });
        cbAddRoomRented.setChecked(false);
    }

    private void saveRoom() {
        String roomCode = etAddRoomCode.getText().toString().trim();
        String roomName = etAddRoomName.getText().toString().trim();
        String priceRaw = etAddRoomPrice.getText().toString().trim();
        boolean isRented = cbAddRoomRented.isChecked();
        String tenantName = etAddTenantName.getText().toString().trim();
        String tenantPhone = etAddTenantPhone.getText().toString().trim();

        if (TextUtils.isEmpty(roomCode)) {
            etAddRoomCode.setError(getString(R.string.error_room_code_required));
            etAddRoomCode.requestFocus();
            return;
        }

        if (RoomRepository.isRoomCodeExists(roomCode)) {
            etAddRoomCode.setError(getString(R.string.error_room_code_exists));
            etAddRoomCode.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(roomName)) {
            etAddRoomName.setError(getString(R.string.error_room_name_required));
            etAddRoomName.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(priceRaw)) {
            etAddRoomPrice.setError(getString(R.string.error_room_price_required));
            etAddRoomPrice.requestFocus();
            return;
        }

        double roomPrice;
        try {
            roomPrice = Double.parseDouble(priceRaw);
            if (roomPrice <= 0) {
                etAddRoomPrice.setError(getString(R.string.error_room_price_invalid));
                etAddRoomPrice.requestFocus();
                return;
            }
        } catch (NumberFormatException ex) {
            etAddRoomPrice.setError(getString(R.string.error_room_price_invalid));
            etAddRoomPrice.requestFocus();
            return;
        }

        if (isRented && TextUtils.isEmpty(tenantName)) {
            etAddTenantName.setError(getString(R.string.error_tenant_name_required));
            etAddTenantName.requestFocus();
            return;
        }

        if (isRented && TextUtils.isEmpty(tenantPhone)) {
            etAddTenantPhone.setError(getString(R.string.error_tenant_phone_required));
            etAddTenantPhone.requestFocus();
            return;
        }

        Room newRoom = new Room(roomCode, roomName, roomPrice, isRented, tenantName, tenantPhone);
        RoomRepository.addRoom(newRoom);

        Toast.makeText(this, R.string.message_add_room_success, Toast.LENGTH_SHORT).show();
        setResult(RESULT_OK);
        finish();
    }
}

