package com.melkonian.example.lessons.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.melkonian.example.lesson3.R;
import com.melkonian.example.lessons.model.CityIndex;

public class CoatOfArmsFragment extends Fragment {
  public static final String PARCEL = "parcel";

  private ImageView coatOfArms;
  private TextView cityNameView;

  private TypedArray coatOfArmsImgs;

  private int defaultIndex = 0;

  public static CoatOfArmsFragment createInstance(CityIndex parcel) {
    CoatOfArmsFragment fragment = new CoatOfArmsFragment();
    Bundle args = new Bundle();
    args.putSerializable(PARCEL, parcel);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_coat_of_arms, container, false);
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    if (getView() == null) {
      return;
    }

    coatOfArms = getView().findViewById(R.id.iv_coat_of_arms_view);
    cityNameView = getView().findViewById(R.id.tv_chosen_city);

    coatOfArmsImgs = getResources().obtainTypedArray(R.array.coat_of_arms_list);

    CityIndex parcel = getParcel();
    if (parcel != null) {
      coatOfArms.setImageResource(coatOfArmsImgs.getResourceId(parcel.getIndex(), defaultIndex));
      cityNameView.setText(parcel.getCityName());
    } else {
      coatOfArms.setImageResource(coatOfArmsImgs.getResourceId(defaultIndex, defaultIndex));
      cityNameView.setText(getResources().getTextArray(R.array.cities_list)[defaultIndex].toString());
    }
  }

  public @Nullable CityIndex getParcel() {
    CityIndex parcel = null;
    if (getArguments() != null) {
      parcel = (CityIndex) getArguments().getSerializable(PARCEL);
    }
    return parcel;
  }
}
