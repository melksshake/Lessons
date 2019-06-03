package com.melkonian.example.lesson3.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lesson3.adapter.CitiesAdapter;
import com.melkonian.example.lesson3.adapter.OnRecyclerViewClickListener;

public class MainActivity extends AppCompatActivity implements /*View.OnClickListener, */OnRecyclerViewClickListener {
  private String[] citiesList = { "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Самара" };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // 1
    //manuallyAddCities();

    // 2
    //manuallyAddCitiesInflater();

    // 3
    //manageListView();

    // 4
    manageRecyclerView();
  }

  /*private void manuallyAddCities() {
    LinearLayout list = findViewById(R.id.layout);

    for (String city : citiesList) {
      TextView cityView = new TextView(this);
      cityView.setText(city);
      cityView.setTextSize(42);
      cityView.setOnClickListener(v -> showMessage(v, null));
      list.addView(cityView);
    }
  }*/

  /*private void manuallyAddCitiesInflater() {
    LinearLayout list = findViewById(R.id.layout);
    LayoutInflater ltInflater = getLayoutInflater();

    for (String city : citiesList) {
      View item = ltInflater.inflate(R.layout.city_item, list, false);
      TextView cityView = item.findViewById(R.id.textView);
      cityView.setText(city);
      cityView.setOnClickListener(v -> showMessage(v, null));
      list.addView(item);
    }
  }*/

 /* private void manageListView() {
    ListView listView = findViewById(R.id.listCities);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, citiesList);
    listView.setAdapter(adapter);
    final Activity activity = this;
    listView.setOnItemClickListener((parent, view, position, id) -> showMessage(view, null));
    //listView.setOnItemLongClickListener((parent, view, position, id) -> {
    //  Toast.makeText(activity, "onLongClick", Toast.LENGTH_SHORT).show();
    //  return false;
    //});
  }*/

  private void manageRecyclerView() {
    RecyclerView recyclerView = findViewById(R.id.recycler_view);

    recyclerView.setHasFixedSize(true);
    recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);

    //CitiesAdapter adapter = new CitiesAdapter(citiesList);

    //CitiesAdapter adapter = new CitiesAdapter(citiesList, view -> showMessage(view, null));
    //CitiesAdapter adapter = new CitiesAdapter(citiesList, new View.OnClickListener() {
    //  @Override public void onClick(View v) {
    //    showMessage(v, null);
    //  }
    //});
    // или
    CitiesAdapter adapter = new CitiesAdapter(citiesList, this);

    recyclerView.setAdapter(adapter);

    // или
    //adapter.SetOnItemClickListener(new CitiesAdapter.OnItemClickListener() {
    //  @Override
    //  public void onItemClick(View view, int position) {
    //    showMessage(view);
    //  }
    //});
  }

  @Override public void onItemClick(View view, int position) {
    showMessage(view, String.valueOf(position));
  }
 /* @Override public void onClick(View v) {
    showMessage(v, null);
  }*/

  private void showMessage(@NonNull View view, @Nullable String position) {
    String message;

    message = position == null
        ? String.format("Выбран город - %s", ((TextView) view).getText())
        : String.format("Выбран город - %s (номер %s)", ((TextView) view).getText(), position);

    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }
}
