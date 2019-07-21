package com.melkonian.example.lessons.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.textfield.TextInputEditText;
import com.melkonian.example.lessons.R;
import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {
  private TextInputEditText tietLogin;
  private TextInputEditText tietPassword;
  private Button btnOk;

  private String regexPattern = "^[A-Z][a-z][0-9]{2,}";
  private Pattern checkLogin = Pattern.compile(regexPattern);

  private Pattern checkPassword = Pattern.compile("[0-9]{6,}");

  public static void startActivity(@NonNull Context context) {
    Intent intent = new Intent(context, SecondActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    setToolbar();
    initViews();

    tietLogin.setOnFocusChangeListener((v, hasFocus) -> {
      if (hasFocus) return;
      TextView tv = (TextView) v;
      validateEnteredData(tv, checkLogin, getString(R.string.login_error));
    });

    tietPassword.setOnFocusChangeListener((v, hasFocus) -> {
      if (hasFocus) return;
      TextView tv = (TextView) v;
      validateEnteredData(tv, checkPassword, getString(R.string.password_error));
    });

    btnOk.setOnClickListener(v -> ThirdActivity.startActivity(this));
  }

  private void setToolbar() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setTitleTextColor(R.string.third_activity_title);
  }

  private void initViews() {
    tietLogin = findViewById(R.id.tiet_login);
    tietPassword = findViewById(R.id.teit_password);
    btnOk = findViewById(R.id.btn_ok);
  }

  private void validateEnteredData(TextView tv, Pattern check, String message) {
    String value = tv.getText().toString();
    if (check.matcher(value).matches()) {
      hideError(tv);
    } else {
      showError(tv, message);
    }
  }

  private void showError(TextView view, String message) {
    view.setError(message);
  }

  private void hideError(TextView view) {
    view.setError(null);
  }
}
