package com.bimbonet.beerlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bimbonet.beerlist.R;
import com.bimbonet.beerlist.data.model.BeerModel;
import com.bimbonet.beerlist.interfaces.OnItemClickListener;
import com.bumptech.glide.Glide;

import java.util.List;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.BeerViewHolder> {

    private final Context context;
    private final List<BeerModel> beerList;
    private final OnItemClickListener onItemClickListener;

    public BeerAdapter(Context context, List<BeerModel> beerList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.beerList = beerList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public BeerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_beer, parent, false);

        final BeerViewHolder viewHolder = new BeerViewHolder(layoutView);
        viewHolder.cvItemBeer.setOnClickListener(view -> onItemClickListener.onItemClick(viewHolder.getAdapterPosition()));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BeerViewHolder holder, int position) {
        BeerModel beerItem = beerList.get(position);

        Glide.with(context)
                .asBitmap()
                .fitCenter()
                .load(beerItem.getImageUrl())
                .into(holder.ivBeerImage);
        holder.tvBeerName.setText(beerItem.getName());
    }

    @Override
    public int getItemCount() {
        return beerList.size();
    }

    public static class BeerViewHolder extends RecyclerView.ViewHolder {

        private final CardView cvItemBeer;
        private final TextView tvBeerName;
        private final ImageView ivBeerImage;

        public BeerViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItemBeer = itemView.findViewById(R.id.cvItemBeer);
            tvBeerName = itemView.findViewById(R.id.tvBeerName);
            ivBeerImage = itemView.findViewById(R.id.ivBeerImage);
        }
    }
}
