package com.example.btnhom.repository;

import com.example.btnhom.model.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RoomRepository {
    private static final List<Room> ROOM_LIST = new ArrayList<>();

    private RoomRepository() {
    }

    public static List<Room> getRoomList() {
        return Collections.unmodifiableList(ROOM_LIST);
    }

    public static void addRoom(Room room) {
        ROOM_LIST.add(room);
    }

    public static boolean isRoomCodeExists(String roomCode) {
        for (Room room : ROOM_LIST) {
            if (room.getRoomCode().equalsIgnoreCase(roomCode)) {
                return true;
            }
        }
        return false;
    }
}

