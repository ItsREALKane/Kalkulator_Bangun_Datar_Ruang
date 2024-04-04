package com.example.kalbangun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterBangun extends RecyclerView.Adapter<AdapterBangun.ViewHolder> {

    List<modelbangun> listData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    public AdapterBangun(List<modelbangun> listData, Context context){
        this.listData = listData;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.template, parent, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        modelbangun modelbangun = listData.get(position);
        holder.tvname.setText(modelbangun.getNamaBangun());
        holder.tvDesc.setText(modelbangun.getDesc());
        Glide.with(holder.itemView.getContext()).load(modelbangun.getImageBangun()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvname;
        TextView tvDesc;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.tvname);
            tvDesc = itemView.findViewById(R.id.tvDesc);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public modelbangun getItem(int id) {
        return listData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
