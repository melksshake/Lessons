package com.melkonian.example.lessons.fragments;

import android.R.layout;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.melkonian.example.lessons.R;
import com.melkonian.example.lessons.activities.MainActivity;

public class ListViewFragment extends Fragment {
  private String[] citiesList = { "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Самара" };

  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_list_view, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    manageListView(view);
  }

  private void manageListView(@NonNull View view) {
    if (getActivity() == null || getContext() == null) {
      return;
    }

    ListView listView = view.findViewById(R.id.lw_cities_list);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), layout.simple_list_item_1, citiesList);

    listView.setAdapter(adapter);
    listView.setOnItemClickListener((parent, v, position, id) ->
        ((MainActivity) getActivity()).showMessage(String.valueOf(position)));

    //listView.setOnItemLongClickListener((parent, v, position, id) -> {
    //  Toast.makeText(getActivity(), "onLongClick", Toast.LENGTH_SHORT).show();
    //  return false;
    //});
  }
}
