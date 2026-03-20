package com.example.btnhom.repository;

import com.example.btnhom.model.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    private static List<Room> roomList = new ArrayList<>();

    static {
        // Sample data with new attributes
        roomList.add(new Room("R001", "Phòng 101", 1500000, false, "", "", 20.5, "Gần cầu thang"));
        roomList.add(new Room("R002", "Phòng 102", 1800000, true, "Nguyễn Văn A", "0987654321", 25.0, "Có ban công"));
    }

    public static List<Room> getRoomList() {
        return roomList;
    }

    public static void addRoom(Room room) {
        roomList.add(room);
    }

    public static void updateRoom(Room updatedRoom) {
        for (int i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).getRoomId().equals(updatedRoom.getRoomId())) {
                roomList.set(i, updatedRoom);
                break;
            }
        }
    }

    public static void deleteRoom(String roomId) {
        roomList.removeIf(room -> room.getRoomId().equals(roomId));
    }
    
    public static Room getRoomById(String roomId) {
        for (Room room : roomList) {
            if (room.getRoomId().equals(roomId)) {
                return room;
            }
        }
        return null;
    }
}
