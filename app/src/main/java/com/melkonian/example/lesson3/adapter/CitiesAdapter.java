package com.melkonian.example.lesson3.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.melkonian.example.lesson3.R;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {
  private String[] data;

  // Для recyclerView
  private OnRecyclerViewClickListener recyclerItemClickListener;
  //private View.OnClickListener clickListener;

  public CitiesAdapter(String[] data, /*View.OnClickListener clickListener*/ OnRecyclerViewClickListener recyclerItemClickListener) {
    this.data = data;
    //this.clickListener = clickListener;
    this.recyclerItemClickListener = recyclerItemClickListener;
  }

  @NonNull @Override
  public CitiesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, parent, false);
    //ViewHolder viewHolder = new ViewHolder((TextView) v, clickListener);
    ViewHolder viewHolder = new ViewHolder(v, recyclerItemClickListener);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.textView.setText(data[position]);
  }

  @Override
  public int getItemCount() {
    return data.length;
  }

  public void SetOnItemClickListener(OnRecyclerViewClickListener itemClickListener){
    this.recyclerItemClickListener = itemClickListener;
  }



  public static class ViewHolder extends RecyclerView.ViewHolder {
    //private TextView textView;
    private CardView cardView;
    //private View.OnClickListener clickListener;
    private OnRecyclerViewClickListener recyclerItemClickListener;

    //public ViewHolder(TextView view, View.OnClickListener itemClickListener) {
  /*  public ViewHolder(TextView view, OnRecyclerViewClickListener itemClickListener) {
      super(view);
      //this.textView = view;
      //this.clickListener = itemClickListener;
      this.recyclerItemClickListener = itemClickListener;

      textView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          if (recyclerItemClickListener != null) {
            recyclerItemClickListener.onItemClick(v, getAdapterPosition() + 1);
          }
        }
      });

      //textView.setOnClickListener(itemClickListener);
      //textView.setOnClickListener(new View.OnClickListener() {
      //  @Override public void onClick(View v) {
      //    if (clickListener != null) {
      //      clickListener.onClick(v);
      //    }
      //  }
      //});
    }*/

    private TextView textView;
    public ViewHolder(View view, OnRecyclerViewClickListener itemClickListener) {
      super(view);
      textView = view.findViewById(R.id.text_view);
      textView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          if (itemClickListener != null) {
            itemClickListener.onItemClick(v, getAdapterPosition());
          }
        }
      });
    }
  }
}
