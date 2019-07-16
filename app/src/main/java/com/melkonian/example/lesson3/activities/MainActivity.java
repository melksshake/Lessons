package com.melkonian.example.lesson3.activities;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.melkonian.example.lesson3.FragmentNavigator;
import com.melkonian.example.lesson3.R;

public class MainActivity extends AppCompatActivity implements FragmentNavigator {
  private MainFragment mainFragment;
  private SecondFragment secondFragment;

  private FragmentManager fragmentManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    fragmentManager = getSupportFragmentManager();

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
    secondFragment.setShape(shape);
    commitOperation(secondFragment);

  }

  private void commitOperation(@NonNull Fragment fragmentToCommit) {
    fragmentManager
        .beginTransaction()
        .replace(R.id.fragment_container, fragmentToCommit)
        .addToBackStack("")
        .commit();
  }
}
