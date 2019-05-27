package com.melkonian.example.lessons.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lessons.fragments.CoatOfArmsFragment;
import com.melkonian.example.lessons.model.CityIndex;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static com.melkonian.example.lessons.fragments.CoatOfArmsFragment.PARCEL;

public class CoatOfArmsActivity extends AppCompatActivity {

  public static Intent start(@NonNull Context context, @NonNull CityIndex parcel) {
    Intent intent = new Intent(context, CoatOfArmsActivity.class);
    intent.putExtra(PARCEL, parcel);
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
      finish();
      return;
    }

    if (savedInstanceState == null) {
      CoatOfArmsFragment coatOfArmsFragment = new CoatOfArmsFragment();
      coatOfArmsFragment.setArguments(getIntent().getExtras());

      FragmentManager fragmentManager = getSupportFragmentManager();
      fragmentManager
          .beginTransaction()
          .add(R.id.placeholder_coat_of_arms, coatOfArmsFragment)
          .commit();
    }
  }
}
