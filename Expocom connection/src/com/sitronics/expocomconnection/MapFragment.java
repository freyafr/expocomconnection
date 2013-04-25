package com.sitronics.expocomconnection;

import com.sitronics.data.Solution;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MapFragment extends Fragment {
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View result = inflater.inflate(R.layout.map_fragment, container, false);
		View firstStage = result.findViewById(R.id.firststage);
		firstStage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent descrIntent = new Intent(getActivity(),
						MapDetailsFragment.class);
				descrIntent.putExtra("image_source", R.drawable.map);
				startActivity(descrIntent);
			}
		});
		View secondStage = result.findViewById(R.id.secondstage);
		secondStage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent descrIntent = new Intent(getActivity(),
						MapDetailsFragment.class);
				descrIntent.putExtra("image_source", R.drawable.map2);
				startActivity(descrIntent);
			}
		});
		return result;
	}
}
