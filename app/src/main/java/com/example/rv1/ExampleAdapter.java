package com.example.rv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<example_item> mExampleList;
    static private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=  listener;
    }

    public ExampleAdapter(Context context, ArrayList<example_item> exampleList) {
        mContext = context;
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        example_item current=mExampleList.get(position);
holder.textV.setText(current.getText());
        Picasso.with(mContext).load(current.getImage()).into(holder.imV);
    }

    @Override
    public int getItemCount() {
return mExampleList.size();
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
private TextView textV;
private ImageView imV;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            imV=itemView.findViewById(R.id.imv);
            textV=itemView.findViewById(R.id.ext);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
