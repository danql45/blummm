package com.example.blum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProwadnikiAdapter extends RecyclerView.Adapter<ProwadnikiAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<Prowadnik> prowadniki;

    public ProwadnikiAdapter(Context context, List<Prowadnik>prowadniki){
        this.inflater = LayoutInflater.from(context);
        this.prowadniki = prowadniki;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //bind data
        holder.distance.setVisibility(View.VISIBLE);
        holder.name.setText(prowadniki.get(position).getTitle());
        holder.distance.setText(prowadniki.get(position).getDistance());
        holder.height.setText(prowadniki.get(position).getHeight());
        holder.colour.setText(prowadniki.get(position).getColour());
        holder.articleNumber.setText(prowadniki.get(position).getArticleNumber());
        Picasso.get().load(prowadniki.get(position).getImageURL()).into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return prowadniki.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, distance, height, colour, articleNumber, productInfo;
        ImageView productImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.itemName);
            distance = itemView.findViewById(R.id.distance);
            height = itemView.findViewById(R.id.height);
            colour = itemView.findViewById(R.id.colour);
            articleNumber = itemView.findViewById(R.id.artNum);
            productImage = itemView.findViewById(R.id.itemImage);
        }
    }
}