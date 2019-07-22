package com.melkonian.example.lessons.activities;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.melkonian.example.lessons.R;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setToolbar();

    Button btnNext = findViewById(R.id.btn_next);
    btnNext.setOnClickListener(view -> SecondActivity.startActivity(this));
  }

  private void setToolbar() {
    ActionBar toolbar = getSupportActionBar();
    if (toolbar != null) {
      toolbar.setTitle(R.string.main_activity_title);
    }
  }
}
