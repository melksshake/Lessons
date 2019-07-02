package activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.melkonian.example.lesson.R;

public class MainActivity extends BaseActivity {
  private TextView lifeCycleLog;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    lifeCycleLog = findViewById(R.id.tv_life_cycle);
    lifeCycleLog.setText("onCreate()\n");

    showMessage(this, "onCreate");

    ConstraintLayout mainContainer = findViewById(R.id.main_container);
    mainContainer.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        startNewActivity();
      }
    });
  }

  private void startNewActivity() {
    Intent newActivityIntent = new Intent(this, SecondActivity.class);
    startActivity(newActivityIntent);
  }

  @Override protected void onRestart() {
    super.onRestart();
    String text = lifeCycleLog.getText().toString() + "\nonRestart()";
    lifeCycleLog.setText(text);

    showMessage(this, "onRestart");
  }

  @Override protected void onStart() {
    super.onStart();
    String text = lifeCycleLog.getText().toString() + "onStart()";
    lifeCycleLog.setText(text);

    showMessage(this, "onStart");
  }

  @Override protected void onResume() {
    super.onResume();
    String text = lifeCycleLog.getText().toString() + "\nonResume()";
    lifeCycleLog.setText(text);

    showMessage(this, "onResume");
  }

  @Override protected void onPause() {
    String text = lifeCycleLog.getText().toString() + "\nonPause()";
    lifeCycleLog.setText(text);

    showMessage(this, "onPause");
    super.onPause();
  }

  @Override protected void onStop() {
    String text = lifeCycleLog.getText().toString() + "\nonStop()";
    lifeCycleLog.setText(text);

    showMessage(this, "onStop");
    super.onStop();
  }

  @Override protected void onDestroy() {
    String text = lifeCycleLog.getText().toString() + "\nonDestroy()";
    lifeCycleLog.setText(text);

    showMessage(this, "onDestroy");
    super.onDestroy();
  }
}
