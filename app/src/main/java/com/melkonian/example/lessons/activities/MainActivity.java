package com.melkonian.example.lessons.activities;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.melkonian.example.lessons.R;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setToolbar();

    Button btnNext = findViewById(R.id.btn_next);
    btnNext.setOnClickListener(v -> SecondActivity.startActivity(this));
  }

  private void setToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setTitleTextColor(R.string.main_activity_title);
  }
}
