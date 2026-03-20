package com.example.btnhom.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.btnhom.R;
import com.example.btnhom.model.Room;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {

    private final List<Room> roomList;
    private final Context context;

    public RoomAdapter(Context context, List<Room> roomList) {
        this.context = context;
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_room_list, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room room = roomList.get(position);

        holder.tvItemRoomName.setText(room.getName());

        String priceText = context.getString(R.string.text_price_format, String.valueOf(room.getPrice()));
        holder.tvItemRoomPrice.setText(priceText);

        if (room.isVacant()) {
            holder.tvItemRoomStatus.setText(context.getString(R.string.text_status_vacant));
            holder.tvItemRoomStatus.setTextColor(context.getColor(android.R.color.holo_green_dark));
        } else {
            holder.tvItemRoomStatus.setText(context.getString(R.string.text_status_occupied));
            holder.tvItemRoomStatus.setTextColor(context.getColor(android.R.color.holo_red_dark));
        }
    }

    @Override
    public int getItemCount() {
        return roomList != null ? roomList.size() : 0;
    }

    public static class RoomViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemRoomName;
        TextView tvItemRoomPrice;
        TextView tvItemRoomStatus;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            // Tuân thủ đúng quy tắc ID View bạn đã đề ra
            tvItemRoomName = itemView.findViewById(R.id.tv_item_room_name);
            tvItemRoomPrice = itemView.findViewById(R.id.tv_item_room_price);
            tvItemRoomStatus = itemView.findViewById(R.id.tv_item_room_status);
        }
    }
}