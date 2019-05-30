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
import com.melkonian.example.lesson3.R;

public class MainFragment extends Fragment {
  private String shape;

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View fragmentView = inflater.inflate(R.layout.fragment_main, container, false);

    shape = getString(R.string.ball);

    final ImageView imageView = fragmentView.findViewById(R.id.imageView);
    RadioButton radioBall = fragmentView.findViewById(R.id.radioBall);

    radioBall.setOnClickListener(v -> {
      imageView.setImageResource(R.drawable.ic_ball);
      shape = getString(R.string.ball);
    });

    RadioButton radioStar = fragmentView.findViewById(R.id.radioStar);
    radioStar.setOnClickListener(v -> {
      imageView.setImageResource(R.drawable.ic_star);
      shape = getString(R.string.star);
    });

    AppCompatButton button = fragmentView.findViewById(R.id.button);
    final Activity parentActivity = getActivity();
    if (parentActivity == null) {
      return null;
    }

    button.setOnClickListener(v -> {
      //FragmentNavigator mainNavigator = (FragmentNavigator) parentActivity;
      //mainNavigator.startSecondFragment(shape);
      ((MainActivity) getActivity()).startSecondFragment(shape);
    });

    return fragmentView;
  }
}
