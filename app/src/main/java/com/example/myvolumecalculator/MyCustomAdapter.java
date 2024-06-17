package com.example.myvolumecalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyCustomAdapter extends ArrayAdapter<ShapeClass> {
    Context context;
    private ArrayList<ShapeClass>shapelist;
    private static GridItemClickListener customlistener;

    public  void setCustomlistener(GridItemClickListener customlistener) {
        MyCustomAdapter.customlistener = customlistener;
    }

    public MyCustomAdapter(@NonNull Context context, @NonNull ArrayList<ShapeClass> shapelist) {
        super(context, R.layout.grid_custom_layout, shapelist);
        this.shapelist=shapelist;
        this.context=context;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView shapenameholder;
        ImageView shapeimageholder;

        public ViewHolder(View myview){
            super(myview);
            shapenameholder=myview.findViewById(R.id.layoutTextView);
            shapeimageholder=myview.findViewById(R.id.layoutImageView);
            myview.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            customlistener.onItemClicked(v,getAdapterPosition());

        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ShapeClass shapes=getItem(position);
        ViewHolder holder;
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.grid_custom_layout,parent,false);
            holder= new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        else{
            holder =(ViewHolder) convertView.getTag();
        }
        holder.shapenameholder.setText(shapes.getShapename());
        holder.shapeimageholder.setImageResource(shapes.getShapeimage());
        return convertView;
    }
}
