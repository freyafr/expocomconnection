package com.sitronics.expocomconnection;

//import android.app.*;
import android.view.*;
import android.os.*;
import android.widget.*;
import android.support.v4.app.*;

public class DescriptionFragment extends Fragment
{
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.description_fragment, container, false);
		//return null; 
	} 
	
	public void onStart()
	{
		super.onStart();
		TextView descr= (TextView)getActivity().findViewById(R.id.image_description);
		descr.setText(R.string.description);
		ImageView image = (ImageView)getActivity().findViewById(R.id.image_photo);
		image.setImageResource(R.drawable.home_image);
		
	}
}
