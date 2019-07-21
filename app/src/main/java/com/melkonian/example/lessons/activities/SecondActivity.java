package com.melkonian.example.lessons.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.melkonian.example.lessons.R;
import java.util.regex.Pattern;

public class SecondActivity extends AppCompatActivity {
  private TextInputEditText tietLogin;
  private TextInputEditText tietPassword;
  private TextInputLayout tilLogin;
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

    tietLogin = findViewById(R.id.tiet_login);
    tilLogin = findViewById(R.id.til_login);
    tietPassword = findViewById(R.id.teit_password);
    btnOk = findViewById(R.id.btn_ok);

    //tietLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    //  @Override public void onFocusChange(View v, boolean hasFocus) {
    //    if (hasFocus) return;
    //    //TextView tv = (TextView) v;
    //    String error = "Это не имя!";
    //    if (checkLogin.matcher(tietLogin.getText()).matches()) {
    //      tilLogin.setError(null);
    //    } else {
    //      tilLogin.setError(error);
    //    }
    //
    //    //validate(tv, checkLogin, "Это не имя!");
    //  }
    //});

    tietLogin.setOnFocusChangeListener(new View.OnFocusChangeListener() {
      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) return;
        TextView tv = (TextView) v;
        validate(tv, checkLogin, "Это не имя!");
      }
    });

    tietPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
      @Override
      public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) return;
        TextView tv = (TextView) v;
        validate(tv, checkPassword, "Пароль слишком простой!");
      }
    });

    btnOk.setOnClickListener(v -> ThirdActivity.startActivity(this));
  }

  private void validate(TextView tv, Pattern check, String message) {
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
