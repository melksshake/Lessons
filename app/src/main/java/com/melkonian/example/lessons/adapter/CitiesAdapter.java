package com.melkonian.example.lessons.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.melkonian.example.lessons.R;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {
  private String[] data;

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

  public void SetOnItemClickListener(OnRecyclerViewClickListener itemClickListener) {
    this.recyclerItemClickListener = itemClickListener;
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    //private TextView textView;
    private CardView cardView;
    //private View.OnClickListener clickListener;
    private OnRecyclerViewClickListener recyclerItemClickListener;

    private TextView textView;

    public ViewHolder(View view, OnRecyclerViewClickListener itemClickListener) {
      super(view);
      textView = view.findViewById(R.id.text_view);
      textView.setOnClickListener(v -> {
        if (itemClickListener != null) {
          itemClickListener.onItemClick(v, getAdapterPosition());
        }
      });
    }
  }
}
