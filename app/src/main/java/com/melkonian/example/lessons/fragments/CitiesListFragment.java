package com.melkonian.example.lessons.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lessons.activities.CoatOfArmsActivity;
import com.melkonian.example.lessons.model.CityIndex;

public class CitiesListFragment extends ListFragment {
  private final String CURRENT_CITY_INDEX = "CURRENT_CITY_INDEX";

  private boolean isDualPane;
  private CityIndex cityIndexParcel;
  private View detailsFrame;

  private int defaultIndex = 0;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_cities_list, container, false);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    FragmentActivity activityContext = getActivity();
    if (activityContext == null) {
      return;
    }

    ArrayAdapter adapter = ArrayAdapter.createFromResource(
        activityContext,
        R.array.cities_list,
        android.R.layout.simple_list_item_activated_1);
    setListAdapter(adapter);

    detailsFrame = activityContext.findViewById(R.id.placeholder_coat_of_arms);
    isDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

    if (savedInstanceState != null) {
      cityIndexParcel = (CityIndex) savedInstanceState.getSerializable(CURRENT_CITY_INDEX);
    } else {
      cityIndexParcel = new CityIndex(defaultIndex, getResources().getTextArray(R.array.cities_list)[defaultIndex].toString());
    }

    if (isDualPane) {
      getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
      showCoatOfArms(cityIndexParcel);
    }
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putSerializable(CURRENT_CITY_INDEX, cityIndexParcel);
  }

  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
    TextView cityNameView = (TextView) v;
    cityIndexParcel = new CityIndex(position, cityNameView.getText().toString());
    showCoatOfArms(cityIndexParcel);
  }

  private void showCoatOfArms(CityIndex parcel) {
    if (getActivity() == null) {
      return;
    }
    if (parcel == null) {
      return;
    }

    int index = parcel.getIndex();

    if (isDualPane) {
      getListView().setItemChecked(index, true);
      CoatOfArmsFragment coatOfArmsFragment = (CoatOfArmsFragment) getActivity()
          .getSupportFragmentManager()
          .findFragmentById(R.id.placeholder_coat_of_arms);

      if (coatOfArmsFragment.getParcel() == null) {
        return;
      }

      int indexFromAttributes = coatOfArmsFragment.getParcel().getIndex();

      if (coatOfArmsFragment == null || indexFromAttributes != index) {
        coatOfArmsFragment = CoatOfArmsFragment.createInstance(parcel);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager
            .beginTransaction()
            .replace(R.id.placeholder_coat_of_arms, coatOfArmsFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit();
      }
    } else {
      if (getContext() != null) {
        startActivity(CoatOfArmsActivity.start(getContext(), parcel));
      }
    }
  }
}
