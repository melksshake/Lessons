package com.melkonian.example.lesson3.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.melkonian.example.lesson3.FragmentNavigator;
import com.melkonian.example.lesson3.R;

public class MainActivity extends AppCompatActivity implements FragmentNavigator {
  private MainFragment mainFragment;
  private SecondFragment secondFragment;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mainFragment = new MainFragment();
    secondFragment = new SecondFragment();

    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager
        .beginTransaction()
        .add(R.id.fragment_container, mainFragment)
        .commit();
  }

  @Override
  public void startSecondFragment(@NonNull String shape) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager
        .beginTransaction()
        .replace(R.id.fragment_container, secondFragment)
        .addToBackStack("")
        .commit();

    secondFragment.setShape(shape);
  }
}
