package com.example.powerbreathe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.powerbreathe.DogModels.DogModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {

    private final List<DogModel> dataList;

    public DogAdapter(List<DogModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dog, parent, false);
        return new DogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        DogModel dog = dataList.get(position);

        holder.nameTextView.setText(dog.getName());
        holder.weightTextView.setText("Weight: " + dog.getWeight().getMetric());
        holder.heightTextView.setText("Height: " + dog.getHeight().getMetric());

        Picasso.get()
                .load(dog.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class DogViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView weightTextView;
        TextView heightTextView;
        ImageView imageView;

        DogViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            weightTextView = itemView.findViewById(R.id.weightTextView);
            heightTextView = itemView.findViewById(R.id.heightTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}