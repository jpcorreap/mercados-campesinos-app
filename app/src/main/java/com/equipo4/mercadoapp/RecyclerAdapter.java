package com.equipo4.mercadoapp;
//*create el 02/08/2021 para probes

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {
    private List<ItemList> items;
    private List<ItemList> originalItems;

    public RecyclerAdapter(List<ItemList> items) {
        this.items = items;
        originalItems = new ArrayList<>();
        originalItems.addAll(items);
    }

    @Override
    public RecyclerHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_card,parent,false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
        ItemList item = items.get(position);
        holder.imgMarket.setImageResource(item.getImgMarket());
        holder.counter.setText(item.getCounter());
        holder.coment.setText(item.getComent());
        holder.place.setText(item.getPlace());
        holder.direction.setText(item.getDirection());
        holder.email.setText(item.getEmail());
        holder.telephone.setText(item.getTelephone());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void filter(String strSearch){
        if(strSearch.length() == 0){
            items.clear();
            items.addAll(originalItems);
        }
        else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                items.clear();
                List<ItemList> collect = originalItems.stream().filter(i -> i.getTelephone().toLowerCase().contains(strSearch)).collect(Collectors.toList());
                items.addAll(collect);

            }
            else{
                items.clear();
                for (ItemList i : originalItems){
                    if(i.getTelephone().toLowerCase().contains(strSearch)){
                        items.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }


    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        private ImageView imgMarket;
        private TextView counter;
        private TextView coment;
        private TextView place;
        private TextView direction;
        private TextView email;
        private TextView telephone;

        public RecyclerHolder(View itemView){
            super(itemView);
            imgMarket = itemView.findViewById(R.id.imgMarket);
            counter = itemView.findViewById(R.id.textViewTitleCounter);
            coment = itemView.findViewById(R.id.textViewComent);
            place = itemView.findViewById(R.id.textViewPlace2);
            direction = itemView.findViewById(R.id.textViewDirection2);
            email = itemView.findViewById(R.id.textViewMail);
            telephone = itemView.findViewById(R.id.textViewPhoneNumber);

        }

    }
}
