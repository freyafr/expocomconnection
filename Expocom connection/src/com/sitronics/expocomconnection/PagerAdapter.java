package com.sitronics.expocomconnection;

import java.util.*;
import android.support.v4.app.*;
//import android.support.v4.app.*;

public class PagerAdapter extends FragmentPagerAdapter
{

	public Fragment getItem(int pos)
	{
		// TODO: Implement this method
		if (fragments!=null)
			return fragments.get(pos);
		return new Fragment();
	}

	public int getCount()
	{
		// TODO: Implement this method
		return fragments.size();
	}
	
	private List<Fragment> fragments;

	public PagerAdapter(FragmentManager fm,List<Fragment> fragments)
	{
		super(fm);
		this.fragments = fragments;
	}
}
