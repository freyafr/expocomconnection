package com.sitronics.expocomconnection;

import android.view.*;
import android.content.Intent;
import android.os.*;
import android.widget.*;
import android.support.v4.app.*;

public class SolutionDetailsFragment extends FragmentActivity
{
	public void onCreate(Bundle savedInstance)
	{
		super.onCreate(savedInstance);
		
		setContentView(R.layout.solution_details);
		Intent intent = getIntent();	
		String name = intent.getStringExtra("name");
		String descr = intent.getStringExtra("description");
		int image = intent.getIntExtra("image", 0);
		TextView nameView = (TextView)findViewById(R.id.solution_name);
		nameView.setText(name);
		
		TextView descrView = (TextView)findViewById(R.id.solution_descr);
		descrView.setText(descr);
		if (image > 0)
		{
			ImageView imageView = (ImageView)findViewById(R.id.solution_image);
			imageView.setImageResource(image);
		}
	}
}
