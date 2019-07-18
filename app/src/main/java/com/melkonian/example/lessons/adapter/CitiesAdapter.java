package com.melkonian.example.lessons.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.melkonian.example.lessons.R;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {
  private String[] data;

  private OnRecyclerViewClickListener recyclerItemClickListener;
  private View.OnClickListener clickListener;

  public CitiesAdapter(@Nullable String[] data, View.OnClickListener clickListener /*OnRecyclerViewClickListener recyclerItemClickListener*/) {
    this.data = data;
    this.clickListener = clickListener;
    //this.recyclerItemClickListener = recyclerItemClickListener;
  }

  @NonNull @Override
  public CitiesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.city_item, parent, false);
    ViewHolder viewHolder = new ViewHolder(view, clickListener);
    //ViewHolder viewHolder = new ViewHolder(view, recyclerItemClickListener);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.setPosition(position);
    holder.textView.setText(data[position]);
  }

  @Override
  public int getItemCount() {
    return data == null ? 0 : data.length;
  }

  public void SetOnItemClickListener(OnRecyclerViewClickListener itemClickListener) {
    this.recyclerItemClickListener = itemClickListener;
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView;
    private OnRecyclerViewClickListener recyclerItemClickListener;

    private TextView textView;

    private int position;

    //public ViewHolder(View view, @Nullable OnRecyclerViewClickListener itemClickListener) {
    public ViewHolder(View view, @Nullable View.OnClickListener itemClickListener) {
      super(view);
      textView = view.findViewById(R.id.text_view);
      cardView = view.findViewById(R.id.card_view);
      //textView.setOnClickListener(v -> {
      //  if (itemClickListener != null) {
      //    itemClickListener.onItemClick(v, getAdapterPosition());
      //  }
      //});
      if (itemClickListener != null) {
        //cardView.setOnClickListener(itemClickListener);
        cardView.setOnClickListener(view1 -> {
          Log.d("CitiesAdapter: position", String.valueOf(position));
        });
      }
    }

    public void setPosition(int position) {
      this.position = position;
    }
  }
}
