package com.melkonian.example.lessons.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.melkonian.example.lessons.R;
import com.melkonian.example.lessons.activities.MainActivity;

public class InflaterFragment extends Fragment {
  private String[] citiesList = { "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Самара" };

  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_inflater, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    manuallyAddCities(view);
    //manuallyAddCitiesInflater(view);
  }

  private void manuallyAddCities(@NonNull View view) {
    if (getActivity() == null) {
      return;
    }

    LinearLayout list = view.findViewById(R.id.layout);

    for (String city : citiesList) {
      TextView cityView = new TextView(getContext());
      cityView.setText(city);
      cityView.setTextSize(42);
      cityView.setOnClickListener(v -> ((MainActivity) getActivity()).showMessage("Not a position"));
      list.addView(cityView);
    }
  }

  private void manuallyAddCitiesInflater(@NonNull View view) {
    if (getActivity() == null) {
      return;
    }

    LinearLayout list = view.findViewById(R.id.layout);
    LayoutInflater ltInflater = getLayoutInflater();

    for (int i = 0; i < citiesList.length; i++) {
      View item = ltInflater.inflate(R.layout.city_item, list, false);
      TextView cityView = item.findViewById(R.id.textView);
      cityView.setText(citiesList[i]);
      String index = String.valueOf(i);
      cityView.setOnClickListener(v -> ((MainActivity) getActivity()).showMessage(index));
      list.addView(item);
    }
  }
}
