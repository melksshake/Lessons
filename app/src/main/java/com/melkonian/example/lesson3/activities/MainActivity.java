package com.melkonian.example.lesson3.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lesson3.model.LocalParcel;
import com.melkonian.example.lesson3.utils.LifecycleStateSaver;

import static com.melkonian.example.lesson3.activities.SecondActivity.CLICKS_COUNT;
import static com.melkonian.example.lesson3.activities.SecondActivity.FROM_SECOND_ACTIVITY;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  public static final int REQUEST_CODE_SECOND_A = 100;

  // 1.
  //private int counterValue = 0;

  // 2.
  private final LifecycleStateSaver saver = LifecycleStateSaver.getInstance();

  private TextView counterValueView;
  private TextView fromSecondActivity1;
  private TextView fromSecondActivity2;
  private AppCompatButton clickButton;
  private AppCompatButton nextActivityButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Toast.makeText(this, checkInstanceState(savedInstanceState), Toast.LENGTH_SHORT).show();

    initViews();

    // 1.
    //counterValueView.setText(String.valueOf(counterValue));
    //clickButton.setOnClickListener(this);

    // 2.
    counterValueView.setText(String.valueOf(saver.getCounter()));
    clickButton.setOnClickListener(v -> onButtonCLicked());

    nextActivityButton.setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    if (v.getId() == R.id.btn_next_activity) {
      // 3.
      //SecondActivity.start(this, saver.getCounter());

      Intent startIntent = new Intent(this, SecondActivity.class);
      startIntent.putExtra(CLICKS_COUNT, saver.getCounter());
      startActivityForResult(startIntent, REQUEST_CODE_SECOND_A);
    }
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

  private void onButtonCLicked() {
    // 1.
    //++counterValue;
    //counterValueView.setText(String.valueOf(counterValue));

    // 2.
    saver.incrementCounter();
    counterValueView.setText(String.valueOf(saver.getCounter()));
  }

  // 4.
  @Override protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_CANCELED && requestCode == REQUEST_CODE_SECOND_A) {
      if (data != null && data.getExtras() != null) {
        LocalParcel receivedData = (LocalParcel) data.getExtras().get(FROM_SECOND_ACTIVITY);

        if (receivedData != null) {
          fromSecondActivity1.setText(receivedData.getText1());
          fromSecondActivity2.setText(receivedData.getText2());
        }
      }
    }
  }

  // 1.
  //@Override protected void onSaveInstanceState(Bundle outState) {
  //  super.onSaveInstanceState(outState);
  //  outState.putInt(CLICKS_COUNT, counterValue);
  //}
  //
  //@Override protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
  //  super.onRestoreInstanceState(savedInstanceState);
  //  counterValue = savedInstanceState.getInt(CLICKS_COUNT);
  //  counterValueView.setText(String.valueOf(counterValue));
  //}
}
