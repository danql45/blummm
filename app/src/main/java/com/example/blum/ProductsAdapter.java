package com.example.blum;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<Products> productsList;
    Integer categoryClicked;


    public ProductsAdapter(Context context, List<Products>productsList, Integer categoryClicked){
        this.inflater = LayoutInflater.from(context);
        this.productsList = productsList;
        this.categoryClicked = categoryClicked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {


        //bind data
        holder.btnInfo.setText("Nr art. " + productsList.get(position).getArticleNumber());
        holder.btnInfo.setBackgroundColor(Color.parseColor("#162C35"));
        holder.productName.setText(productsList.get(position).getTitle());
        Picasso.get().load(productsList.get(position).getImageURL()).into(holder.imageURL);
        holder.articleNumber.setText("Nr art.  " + productsList.get(position).getArticleNumber());
        Picasso.get().load(productsList.get(position).getProductURL()).into(holder.productURL);
        holder.distance.setText("Dystans:  " + productsList.get(position).getDistance() + "(mm)");
        holder.height.setText("Wysokość:  " + productsList.get(position).getHeight() + "(mm)");
        holder.colour.setText("Kolor:  " + productsList.get(position).getColour());
        holder.fixingMethod.setText("Mocowanie:  " + productsList.get(position).getFixingMethod());
        holder.doorType.setText("Przeznaczenie zawiasu:  " + productsList.get(position).getDoorType());
        holder.openingAngle.setText("Kąt otwarcia:  " + productsList.get(position).getOpeningAngle());
        holder.productSystem.setText("System:  " + productsList.get(position).getProductSystem());
        holder.powerFactorLF.setText("Współcznynnik mocy LF:  " + productsList.get(position).getPowerFactorLF());
        holder.cabinetHeight.setText("Wyskokość wewnętrzna korpusu:  " + productsList.get(position).getCabinetHeight());
        holder.cabinetMinDepth.setText("Minimalna głębokość korpusu:  " + productsList.get(position).getCabinetMinDepth());

        holder.productName.setVisibility(View.VISIBLE);
        holder.imageURL.setVisibility(View.VISIBLE);
        holder.distance.setVisibility(View.VISIBLE);
        holder.height.setVisibility(View.VISIBLE);
        holder.colour.setVisibility(View.VISIBLE);
        holder.articleNumber.setVisibility(View.VISIBLE);
        holder.fixingMethod.setVisibility(View.VISIBLE);
        holder.productURL.setVisibility(View.VISIBLE);
        holder.productSystem.setVisibility(View.VISIBLE);
        holder.openingAngle.setVisibility(View.VISIBLE);
        holder.doorType.setVisibility(View.VISIBLE);
        holder.powerFactorLF.setVisibility(View.VISIBLE);
        holder.cabinetHeight.setVisibility(View.VISIBLE);
        holder.cabinetMinDepth.setVisibility(View.VISIBLE);

        if(productsList.get(position).getParentID() != null){
            holder.linearlayout.setVisibility(View.GONE);
            holder.btnInfo.setVisibility(View.VISIBLE);
        }

        String URLisMissing = productsList.get(position).getImageURL();
        if(URLisMissing == null){
            holder.imageURL.setVisibility(View.GONE);
            holder.productName.setVisibility(View.GONE);;
        } else {
            holder.btnInfo.setVisibility(View.GONE);
            holder.linearlayout.setVisibility(View.GONE);
        }

        if (categoryClicked == 0) { //zawiasy
            holder.height.setVisibility(View.GONE);
            holder.distance.setVisibility(View.GONE);
            holder.powerFactorLF.setVisibility(View.GONE);
            holder.cabinetHeight.setVisibility(View.GONE);
            holder.cabinetMinDepth.setVisibility(View.GONE);
        }else if (categoryClicked == 1){ //prowadniki
            holder.productSystem.setVisibility(View.GONE);
            holder.openingAngle.setVisibility(View.GONE);
            holder.productSystem.setVisibility(View.GONE);
            holder.doorType.setVisibility(View.GONE);
            holder.powerFactorLF.setVisibility(View.GONE);
            holder.cabinetHeight.setVisibility(View.GONE);
            holder.cabinetMinDepth.setVisibility(View.GONE);
        }else if(categoryClicked == 2){ //podnosniki
            holder.height.setVisibility(View.GONE);
            holder.distance.setVisibility(View.GONE);
            holder.doorType.setVisibility(View.GONE);
        }

    }



    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView productName, distance, height, colour, articleNumber, fixingMethod,
                productSystem, openingAngle, doorType, powerFactorLF,cabinetHeight,cabinetMinDepth;
        ImageView imageURL, productURL;
        LinearLayout linearlayout;
        ConstraintLayout clayout;
        CardView cardview;
        Button btnInfo;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            productName = itemView.findViewById(R.id.itemName);
            distance = itemView.findViewById(R.id.distance);
            height = itemView.findViewById(R.id.height);
            colour = itemView.findViewById(R.id.colour);
            articleNumber = itemView.findViewById(R.id.artNum);
            imageURL = itemView.findViewById(R.id.itemImage);
            fixingMethod = itemView.findViewById(R.id.fixingMethod);
            productURL = itemView.findViewById(R.id.productURL);
            linearlayout = itemView.findViewById(R.id.linearLayout);
            cardview = itemView.findViewById(R.id.cardview);
            btnInfo = itemView.findViewById(R.id.btnInfo);
            clayout = itemView.findViewById(R.id.clayout);
            productSystem = itemView.findViewById(R.id.productSystem);
            openingAngle = itemView.findViewById(R.id.openingAngle);
            doorType = itemView.findViewById(R.id.doorType);
            powerFactorLF = itemView.findViewById(R.id.powerFactorLF);
            cabinetHeight = itemView.findViewById(R.id.cabinetHeight);
            cabinetMinDepth = itemView.findViewById(R.id.cabinetMinDepth);


            btnInfo.setOnClickListener(new View.OnClickListener() {
                boolean isPressed = true;
                @Override
                public void onClick(View view) {
                    if(isPressed){
                        if(productsList.get(getAdapterPosition()).getParentID() != null){
                            linearlayout.setVisibility(View.VISIBLE);
                            isPressed = false;
                        }
                    }else{
                        if(productsList.get(getAdapterPosition()).getParentID() != null){
                            linearlayout.setVisibility(View.GONE);
                            isPressed = true;
                        }
                    }


                }
            });

        }

    }
}