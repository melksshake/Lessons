package com.melkonian.example.lesson3.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.melkonian.example.lesson3.R;

public class ThirdActivity extends AppCompatActivity {

  public static void startActivity(@NonNull Context context) {
    Intent intent = new Intent(context, ThirdActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_third);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    toolbar.setTitleTextColor(R.string.third_activity);

    FloatingActionButton fab = findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar
            .make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Кнопка в Snackbar нажата", Toast.LENGTH_LONG).show();
              }
            })
            .show();
      }
    });
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    //int id = item.getItemId();
    //if (id == R.id.action_settings1) {
    //  Toast.makeText(this, "Action settings clicked", Toast.LENGTH_SHORT).show();
    //  return true;
    //}

    switch(item.getItemId()) {
      case R.id.action_settings1:
        Toast.makeText(this, "Action settings clicked", Toast.LENGTH_SHORT).show();;
        return true;
      case R.id.action_settings2:
        SecondActivity.startActivity(this);
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
