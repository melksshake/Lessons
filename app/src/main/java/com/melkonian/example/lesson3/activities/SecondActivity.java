package com.melkonian.example.lesson3.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lesson3.model.LocalParcel;

public class SecondActivity extends AppCompatActivity {
  public static final String CLICKS_COUNT = "CLICKS_COUNT";
  public static String FROM_SECOND_ACTIVITY = "FROM_SECOND_ACTIVITY";

  private TextView dataFromMainView;
  private AppCompatButton finishButton;
  private EditText etEnteredStringOne;
  private EditText etEnteredStringTwo;

  private String receivedValue = null;

  public static void start(@NonNull Context context, int clicks) {
    Intent startIntent = new Intent(context, SecondActivity.class);
    startIntent.putExtra(CLICKS_COUNT, clicks);
    context.startActivity(startIntent);
    //startActivityForResult(startIntent, REQUEST_CODE_SECOND_A);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);
    Toast.makeText(getApplicationContext(), "Second - onCreate()", Toast.LENGTH_SHORT).show();

    initViews();

    if (getIntent() != null && getIntent().getExtras() != null) {
      receivedValue = String.valueOf(getIntent().getIntExtra(CLICKS_COUNT, -1));
    }

    dataFromMainView.setText(receivedValue);

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
    setResult(Activity.RESULT_CANCELED, dataToMainActivity);
    finish();
  }
}
