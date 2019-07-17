package com.melkonian.example.lessons.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.melkonian.example.lessons.FragmentNavigator;
import com.melkonian.example.lessons.R;
import com.melkonian.example.lessons.fragments.InflaterFragment;
import com.melkonian.example.lessons.fragments.ListViewFragment;
import com.melkonian.example.lessons.fragments.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity implements FragmentNavigator, View.OnClickListener {
  private LinearLayout mainContainer;
  private FrameLayout fragmentContainer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mainContainer = findViewById(R.id.main_container);
    fragmentContainer = findViewById(R.id.fragment_container);

    Button openSimpleLayout = findViewById(R.id.btn_simple_layout);
    Button openListView = findViewById(R.id.btn_list_view);
    Button openRecyclerView = findViewById(R.id.btn_recycler_view);

    openSimpleLayout.setOnClickListener(this);
    openListView.setOnClickListener(this);
    openRecyclerView.setOnClickListener(this);
  }

  @Override public void onClick(View view) {
    mainContainer.setVisibility(View.GONE);
    fragmentContainer.setVisibility(View.VISIBLE);

    switch (view.getId()) {
      case R.id.btn_simple_layout:
        openInflaterFragment();
        break;

      case R.id.btn_list_view:
        openListViewFragment();
        break;

      case R.id.btn_recycler_view:
        openRecyclerFragment();
        break;
    }
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
    if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
      mainContainer.setVisibility(View.VISIBLE);
      fragmentContainer.setVisibility(View.GONE);
    }
  }

  @Override public void openInflaterFragment() {
    commitOperation(new InflaterFragment());
  }

  @Override public void openListViewFragment() {
    commitOperation(new ListViewFragment());
  }

  @Override public void openRecyclerFragment() {
    commitOperation(new RecyclerViewFragment());
  }

  public void showMessage(@NonNull String position) {
    String message;
    message = String.format("Выбрана позиция города - %s", position);

    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  private void commitOperation(@NonNull Fragment fragmentToCommit) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager
        .beginTransaction()
        .replace(R.id.fragment_container, fragmentToCommit)
        .addToBackStack("")
        .commit();
  }
}
