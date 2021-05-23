package com.geek.homework5.Adapter;

import android.location.GnssAntennaInfo;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geek.homework5.R;
import com.geek.homework5.databinding.ItemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Model> list = new ArrayList<>();
    Listener listener;

    public Adapter(){}
    public Adapter(Listener listener){
        this.listener=listener;
    }
    public void adds(Model model) {
        list.add(model);
        notifyDataSetChanged();
    }
    public void update(Model model, int num) {
        list.remove(num);
        list.add(num,model);
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBinding.inflate
                (LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding itemBinding;


        public ViewHolder(@NonNull ItemBinding itemView) {
            super(itemView.getRoot());
            itemBinding = itemView;

            itemView.getRoot().setOnClickListener(v -> {
                listener.onItemclick(list.get(getAdapterPosition()),getAdapterPosition());
            });
        }

        public void onBind(Model model) {
            itemBinding.tvName.setText(model.getName());
            itemBinding.tvPhone.setText(model.getPhone());
        }
    }
    public interface Listener{
        void onItemclick(Model model,int position);
    }
}
