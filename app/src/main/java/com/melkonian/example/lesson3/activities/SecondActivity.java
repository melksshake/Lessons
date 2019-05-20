package com.melkonian.example.lesson3.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lesson3.model.LocalParcel;

import static com.melkonian.example.lesson3.activities.MainActivity.CLICKS_COUNT;

public class SecondActivity extends AppCompatActivity {
  public static String FROM_SECOND_ACTIVITY = "FROM_SECOND_ACTIVITY";

  private TextView dataFromMainView;
  private AppCompatButton finishButton;
  private EditText etEnteredStringOne;
  private EditText etEnteredStringTwo;

  private int receivedValue = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    Toast.makeText(getApplicationContext(), "Second - onCreate()", Toast.LENGTH_SHORT).show();

    initViews();

    if (getIntent() != null && getIntent().getExtras() != null) {
      receivedValue = getIntent().getIntExtra(CLICKS_COUNT, -1);
    }

    dataFromMainView.setText(String.valueOf(receivedValue));

    //finishButton.setOnClickListener(v -> finish());
    finishButton.setOnClickListener(v -> onSaveAndFinishClicked());
  }

  private void initViews() {
    dataFromMainView = findViewById(R.id.tv_data_from_main);
    finishButton = findViewById(R.id.btn_finish);

    etEnteredStringOne = findViewById(R.id.entered_data_1);
    etEnteredStringTwo = findViewById(R.id.entered_data_2);
  }

  private void onSaveAndFinishClicked() {
    LocalParcel parcel = new LocalParcel();
    parcel.setText1(etEnteredStringOne.getText().toString());
    parcel.setText2(etEnteredStringTwo.getText().toString());

    Intent dataToMainActivity = new Intent(this, MainActivity.class);
    dataToMainActivity.putExtra(FROM_SECOND_ACTIVITY, parcel);
    setResult(Activity.RESULT_OK, dataToMainActivity);
    finish();
  }
}
