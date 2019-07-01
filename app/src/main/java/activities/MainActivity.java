package activities;

import android.os.Bundle;
import androidx.annotation.Nullable;

public class MainActivity extends BaseActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    showMessage(this, "onCreate");
  }

  @Override protected void onRestart() {
    super.onRestart();
    showMessage(this, "onRestart");
  }

  @Override protected void onStart() {
    super.onStart();
    showMessage(this, "onStart");
  }

  @Override protected void onResume() {
    super.onResume();
    showMessage(this, "onResume");
  }

  @Override protected void onPause() {
    super.onPause();
    showMessage(this, "onPause");
  }

  @Override protected void onStop() {
    super.onStop();
    showMessage(this, "onStop");
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    showMessage(this, "onDestroy");
  }
}
