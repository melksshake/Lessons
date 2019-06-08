package com.melkonian.example.lesson3.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import com.melkonian.example.lesson3.R;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button btnNext = findViewById(R.id.btn_next);
    btnNext.setOnClickListener(v -> SecondActivity.startActivity(this));
  }
}
