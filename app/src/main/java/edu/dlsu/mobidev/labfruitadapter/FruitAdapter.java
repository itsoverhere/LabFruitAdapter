package edu.dlsu.mobidev.labfruitadapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by courtneyngo on 10/6/16.
 */
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private ArrayList<String> listFruits;

    public FruitAdapter(ArrayList<String> listFruits){
        this.listFruits = listFruits;
    }

    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_fruit, parent, false);
        // passing parent (RecyclerView) as the ViewGroup (2nd parameter) will give itemView the parent's size, thus allowing it to match parent's width
        // the third parameter is set to false, which means we don't want itemView to be attached to the parent (RecyclerView), this is done for us by the LayoutManager
        // setting the ViewGroup (2nd parameter) to null will also disable attachment to RecyclerView, but will not give the width/height of the RecyclerView

        return new FruitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {
        // Here, the data at position is placed on the TextView tvFruit
        holder.tvFruit.setText(listFruits.get(position));

        // This part alternates the colors of odd rows from even rows.
        // If you have a COMPLETELY different view in mind for a particular row, you may notice that there is an int viewType parameter in onCreateViewHolder
        // Overriding getViewType(position) will allow you to specify which position/index follows a specific layout file
        if(position%2==0){ // even rows
            holder.container.setBackgroundColor(Color.parseColor("#000000"));
            holder.tvFruit.setTextColor(Color.parseColor("#ffffff"));
        }else{ // odd rows
            holder.container.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.tvFruit.setTextColor(Color.parseColor("#000000"));
        }
        // It is important to specify how the colors should behave for both odd and even. RecyclerViews also recycle the styles!

    }

    @Override
    public int getItemCount() {
        return listFruits.size();
    }

    public class FruitViewHolder extends RecyclerView.ViewHolder{

        TextView tvFruit;
        View container; // This is the LinearLayout wrapper in list_item_fruit. I am adding this for aesthetic purposes.

        public FruitViewHolder(View itemView) {
            super(itemView);
            tvFruit = (TextView) itemView.findViewById(R.id.tv_fruit);
            container = itemView.findViewById(R.id.container);
        }
    }

}
