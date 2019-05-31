package com.melkonian.example.lesson3.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import com.melkonian.example.lesson3.FragmentNavigator;
import com.melkonian.example.lesson3.R;

public class MainFragment extends Fragment {
  private String shape;

  private ImageView imageView;
  private RadioButton radioBall;
  private RadioButton radioStar;
  private AppCompatButton button;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);

    final MainActivity parentActivity = (MainActivity) getActivity();
    if (parentActivity == null) {
      return null;
    }

    shape = getString(R.string.ball);

    imageView = fragmentView.findViewById(R.id.imageView);
    radioBall = fragmentView.findViewById(R.id.radioBall);
    radioStar = fragmentView.findViewById(R.id.radioStar);
    button = fragmentView.findViewById(R.id.button);

    radioBall.setOnClickListener(v -> {
      imageView.setImageResource(R.drawable.ic_ball);
      shape = getString(R.string.ball);
    });
    radioStar.setOnClickListener(v -> {
      imageView.setImageResource(R.drawable.ic_star);
      shape = getString(R.string.star);
    });
    button.setOnClickListener(v -> {
      //FragmentNavigator mainNavigator = parentActivity;
      //mainNavigator.startSecondFragment(shape);

      parentActivity.startSecondFragment(shape);
    });

    return fragmentView;
  }
}
