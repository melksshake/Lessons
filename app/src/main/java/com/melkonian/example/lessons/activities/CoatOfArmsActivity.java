package com.melkonian.example.lessons.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.melkonian.example.lessons.fragments.CoatOfArmsFragment;
import com.melkonian.example.lessons.model.CityIndex;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static com.melkonian.example.lessons.fragments.CoatOfArmsFragment.PARCEL;

public class CoatOfArmsActivity extends AppCompatActivity {

  public static void start(@NonNull Context context, @NonNull CityIndex parcel) {
    Intent intent = new Intent(context, CoatOfArmsActivity.class);
    intent.putExtra(PARCEL, parcel);
    context.startActivity(intent);
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
          .add(android.R.id.content, coatOfArmsFragment)
          //TODO
          //.add(R.id.placeholder_coat_of_arms, coatOfArmsFragment)
          .commit();
    }
  }
}
