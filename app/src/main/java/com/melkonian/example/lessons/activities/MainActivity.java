package com.melkonian.example.lessons.activities;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.melkonian.example.lessons.R;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btnNext = findViewById(R.id.btn_next);
    btnNext.setOnClickListener(v -> SecondActivity.startActivity(this));
  }
}
