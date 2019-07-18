package com.melkonian.example.lessons.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.melkonian.example.lessons.R;
import com.melkonian.example.lessons.activities.MainActivity;
import com.melkonian.example.lessons.adapter.CitiesAdapter;
import com.melkonian.example.lessons.adapter.OnRecyclerViewClickListener;

public class RecyclerViewFragment extends Fragment implements OnRecyclerViewClickListener, View.OnClickListener {
  private String[] citiesList = { "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Самара" };

  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_recycler_view, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    manageRecyclerView(view);
  }

  // For OnRecyclerViewClickListener
  @Override public void onItemClick(View view, int position) {
    if (getActivity() == null) {
      return;
    }

    ((MainActivity) getActivity()).showMessage(String.valueOf(position));
  }

  // For View.OnClickListener
  @Override public void onClick(View view) {
    if (getActivity() == null) {
      return;
    }

    ((MainActivity) getActivity()).showMessage("Basic clicker");
  }

  private void manageRecyclerView(@NonNull View view) {
    if (getContext() == null) {
      return;
    }

    RecyclerView recyclerView = view.findViewById(R.id.recycler_view);

    recyclerView.setHasFixedSize(true);
    recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
    recyclerView.setLayoutManager(layoutManager);

    CitiesAdapter adapter = new CitiesAdapter(citiesList, this);
    recyclerView.setAdapter(adapter);
  }
}
