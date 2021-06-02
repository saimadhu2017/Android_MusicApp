package com.saimadhukalluri.music.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saimadhukalluri.music.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    Context context;
    String[] arrListOfStrings;

    public HomeAdapter(Context context, String[] arrListOfStrings) {
        this.context = context;
        this.arrListOfStrings = arrListOfStrings;
    }

    static class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView recycler_view_text;
        RelativeLayout recycler_view_relative_layout;

        public HomeViewHolder(View view) {
            super(view);
            recycler_view_text = view.findViewById(R.id.recycler_view_text);
            recycler_view_relative_layout = view.findViewById(R.id.recycler_view_relative_layout);
        }
    }


    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_home, parent, false);
        return (new HomeViewHolder(view));
    }

    @Override
    public void onBindViewHolder(HomeAdapter.HomeViewHolder holder, int position) {
        holder.recycler_view_text.setText(arrListOfStrings[position]);
        holder.recycler_view_relative_layout.setOnClickListener(v -> Toast.makeText(v.getContext(), "selected bro", Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return arrListOfStrings.length;
    }


}
