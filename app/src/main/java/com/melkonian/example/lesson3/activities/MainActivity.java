package com.melkonian.example.lesson3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lesson3.model.LocalParcel;

import static com.melkonian.example.lesson3.activities.SecondActivity.FROM_SECOND_ACTIVITY;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  public static final String CLICKS_COUNT = "CLICKS_COUNT";
  public static final int REQUEST_CODE_SECOND_A = 100;
  private final String TAG = MainActivity.class.getName();

  private int counterValue = 0;

  private TextView counterValueView;
  private TextView fromSecondActivity1;
  private TextView fromSecondActivity2;
  private AppCompatButton clickButton;
  private AppCompatButton nextActivityButton;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //boolean isDark = true;
    //SharedPreferences;
    //setTheme(isDark ? android.R.style.Theme_Black : android.R.style.Theme);
    setContentView(R.layout.activity_main);

    Toast.makeText(this, checkInstanceState(savedInstanceState), Toast.LENGTH_SHORT).show();

    initViews();

    counterValueView.setText(String.valueOf(counterValue));
    clickButton.setOnClickListener(this);
    nextActivityButton.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()) {
      case R.id.btn_next_activity:
        Intent nextActivity = new Intent(this, SecondActivity.class);
        nextActivity.putExtra(CLICKS_COUNT, counterValue);
        startActivityForResult(nextActivity, REQUEST_CODE_SECOND_A);
        break;

      case R.id.btn_dummy:
        ++counterValue;
        counterValueView.setText(String.valueOf(counterValue));
        break;
    }
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_SECOND_A) {
      if (data != null && data.getExtras() != null) {
        LocalParcel receivedData = (LocalParcel) data.getExtras().get(FROM_SECOND_ACTIVITY);

        if (receivedData != null) {
          fromSecondActivity1.setText(receivedData.getText1());
          fromSecondActivity2.setText(receivedData.getText2());
        }
      }
    }
  }

  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putInt(CLICKS_COUNT, counterValue);
  }

  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    counterValue = savedInstanceState.getInt(CLICKS_COUNT);
    counterValueView.setText(String.valueOf(counterValue));
  }

  private void initViews() {
    counterValueView = findViewById(R.id.tv_clicks_count);
    clickButton = findViewById(R.id.btn_dummy);
    nextActivityButton = findViewById(R.id.btn_next_activity);
    fromSecondActivity1 = findViewById(R.id.tv_data_from_second_1);
    fromSecondActivity2 = findViewById(R.id.tv_data_from_second_2);
  }

  private String checkInstanceState(Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      return getString(R.string.instance_state_first);
    } else {
      return getString(R.string.instance_state_not_first);
    }
  }


}
