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

		Intent intent = getIntent();	
		int imageSource = intent.getIntExtra("image_source", -1);
		String title = intent.getStringExtra("map_title_text");
		((TextView)findViewById(R.id.map_title_view)).setText(title);

		if (imageSource > -1)
		{
			TouchImageView touchView = (TouchImageView)findViewById(R.id.touchview);
			touchView.setImageResource(imageSource);
			touchView.setMaxZoom(10f);
		}
	}
}
