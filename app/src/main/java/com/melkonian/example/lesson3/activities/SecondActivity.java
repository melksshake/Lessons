package com.melkonian.example.lesson3.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lesson3.model.LocalParcel;

import static com.melkonian.example.lesson3.activities.MainActivity.CLICKS_COUNT;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
  public static String FROM_SECOND_ACTIVITY = "FROM_SECOND_ACTIVITY";

  private TextView dataFromMainView;
  private EditText etEnteredStringOne;
  private EditText etEnteredStringTwo;

  private int receivedValue = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    initViews();

    if (getIntent() != null && getIntent().getExtras() != null) {
      receivedValue = getIntent().getIntExtra(CLICKS_COUNT, -1);
    }

    dataFromMainView.setText(String.valueOf(receivedValue));
  }

  @Override public void onClick(View v) {
    if (v.getId() == R.id.btn_finish) {
      LocalParcel parcel = new LocalParcel();
      parcel.setText1(etEnteredStringOne.getText().toString());
      parcel.setText2(etEnteredStringTwo.getText().toString());

      Intent dataToMainActivity = new Intent(this, MainActivity.class);
      dataToMainActivity.putExtra(FROM_SECOND_ACTIVITY, parcel);
      setResult(Activity.RESULT_OK, dataToMainActivity);
      finish();
    }
  }

  private void initViews() {
    dataFromMainView = findViewById(R.id.tv_data_from_main);
    etEnteredStringOne = findViewById(R.id.entered_data_1);
    etEnteredStringTwo = findViewById(R.id.entered_data_2);
  }
}
