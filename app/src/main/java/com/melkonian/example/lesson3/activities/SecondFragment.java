package com.melkonian.example.lesson3.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.melkonian.example.lesson3.R;

public class SecondFragment extends Fragment {
  private String shape;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View fragmentView = inflater.inflate(R.layout.fragment_second, container, false);
    TextView textShape = fragmentView.findViewById(R.id.textShape);
    textShape.setText(shape);
    return fragmentView;
  }

  public void setShape(@NonNull String shape) {
    this.shape = shape;
  }
}
