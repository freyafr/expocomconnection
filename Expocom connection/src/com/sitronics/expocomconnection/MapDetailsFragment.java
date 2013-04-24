package com.sitronics.expocomconnection;

import android.content.Intent;
import android.os.*;
import android.widget.*;
import android.support.v4.app.*;

public class MapDetailsFragment extends FragmentActivity
{
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		
		setContentView(R.layout.map_detail_fragment);

		TouchImageView touchView = (TouchImageView)findViewById(R.id.touchview);
		touchView.setImageResource(R.drawable.map);
		touchView.setMaxZoom(10f);
	}
}
