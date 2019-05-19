package com.melkonian.example.lesson3.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.TextView;
import android.widget.Toast;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lesson3.model.LocalParcel;

public class SecondActivity extends AppCompatActivity {
  private TextView dataFromMainView;
  private AppCompatButton finishButton;
  //private EditText etEnteredStringOne;
  //private EditText etEnteredStringTwo;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    Toast.makeText(getApplicationContext(), "Second - onCreate()", Toast.LENGTH_SHORT).show();

    initViews();

    finishButton.setOnClickListener(v -> finish());
  }

  @Override
  protected void onStart() {
    super.onStart();
    Toast.makeText(getApplicationContext(), "Second - onStart()", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onResume() {
    super.onResume();
    Toast.makeText(getApplicationContext(), "Second - onResume()", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onPause() {
    super.onPause();
    Toast.makeText(getApplicationContext(), "Second - onPause()", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onStop() {
    super.onStop();
    Toast.makeText(getApplicationContext(), "Second - onStop()", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    Toast.makeText(getApplicationContext(), "Second - onRestart()", Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Toast.makeText(getApplicationContext(), "Second - onDestroy()", Toast.LENGTH_SHORT).show();
  }

  private void initViews() {
    dataFromMainView = findViewById(R.id.tv_data_from_main);
    finishButton = findViewById(R.id.btn_finish);
  }

  private void onSaveAndFinishClicked() {
    LocalParcel parcel = new LocalParcel();
    // TODO set data, set parcel to intent, finish
  }
}
