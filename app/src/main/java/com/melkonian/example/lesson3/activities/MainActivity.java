package com.melkonian.example.lesson3.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lesson3.utils.LifecycleStateSaver;

public class MainActivity extends AppCompatActivity {
  private int counterValue = 0;
  private TextView counterValueView;
  private AppCompatButton clickButton;

  //private final LifecycleStateSaver saver = LifecycleStateSaver.getInstance();;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toast.makeText(this, checkInstanceState(savedInstanceState), Toast.LENGTH_SHORT).show();

    initViews();
    initValues();
  }

  // TODO
  @Override protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  // TODO
  @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
  }

  private void initViews() {
    counterValueView = findViewById(R.id.tv_clicks_count);
    clickButton = findViewById(R.id.btn_dummy);
  }

  private void initValues() {
    counterValueView.setText(String.valueOf(counterValue));
    clickButton.setOnClickListener(v -> onButtonCLicked());
  }

  private String checkInstanceState(Bundle savedInstanceState) {
    if (savedInstanceState == null) {
      return getString(R.string.instance_state_first);
    } else {
      return getString(R.string.instance_state_not_first);
    }
  }

  private void onButtonCLicked() {
    ++counterValue;
    counterValueView.setText(String.valueOf(counterValue));
    // TODO add alternative setText + increment
  }

  // TODO
  private void alternativeStateSaver() {
     //counterValueView.setText(String.valueOf(saver.getCounter()));
  }
}
