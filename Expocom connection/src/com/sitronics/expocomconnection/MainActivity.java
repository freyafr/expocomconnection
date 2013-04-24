package com.sitronics.expocomconnection;

import android.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.view.*;
import java.util.*;
import android.view.*;
import android.content.*;
import android.os.*;
import android.support.v4.app.*;
import com.actionbarsherlock.app.*;
import com.actionbarsherlock.view.Menu;
import com.sitronics.data.Solution;

public class MainActivity extends SherlockFragmentActivity implements
TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener
{

	private TabHost _tabHost;
	private ViewPager _viewPager;
	private HashMap<String, TabInfo> _mapInfo = new HashMap<String, TabInfo>();

	private PagerAdapter _pagerAdapter;
	private static Handler handler;

	private class TabInfo
	{
		private String tag;
		private Bundle args;

		TabInfo(String tag,

				Bundle args)
		{
			this.tag = tag;
			this.args = args;

		}
	}

	class TabFactory implements TabContentFactory
	{
		private Context _context;

		public TabFactory(Context context)
		{
			_context = context;
		}

		public View createTabContent(String p1)
		{
			// TODO: Implement this method
			View view = new View(_context);
			view.setMinimumHeight(0);
			view.setMinimumWidth(0);
			return view;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		// requestWindowFeature(Window.FEATURE_LEFT_ICON);
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);

		handler = new Handler();

		setContentView(R.layout.activity_main);
		initTabHost(savedInstanceState);

		if (savedInstanceState != null)
		{
			_tabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); // set
			// the
			// tab
			// as
			// per
			// the
			// saved
			// state
		}

		initViewPager(savedInstanceState);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
		getSupportActionBar().setDisplayUseLogoEnabled(true);

		getSupportActionBar().setIcon(R.drawable.logo);

		TabWidget tabWidget = (TabWidget) findViewById(id.tabs);
		for (int i = 0; i < tabWidget.getChildCount(); i++)
		{
			View view = tabWidget.getChildAt(i);
			view.setFocusableInTouchMode(true);
		}

	}

	public Activity getActivity()
	{
		return this;
	}

	public void handleError(final String errorMesage)
	{
		handler.post(new Runnable() {
				public void run()
				{
					Toast.makeText(getActivity(), errorMesage, Toast.LENGTH_SHORT)
						.show();

				}
			});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.FragmentActivity#onSaveInstanceState(android.os.Bundle)
	 */
	protected void onSaveInstanceState(Bundle outState)
	{
		outState.putString("tab", _tabHost.getCurrentTabTag()); // save the tab
		// selected
		super.onSaveInstanceState(outState);
	}

	private void initTabHost(Bundle args)
	{
		try
		{
			_tabHost = (TabHost) findViewById(android.R.id.tabhost);
			_tabHost.setup();
			MainActivity.TabInfo tabInfo = null;
			addTab(_tabHost,
				   _tabHost.newTabSpec("page1").setIndicator(
					   getString(R.string.description)),
				   (tabInfo = new TabInfo("page1", args)));
			_mapInfo.put(tabInfo.tag, tabInfo);
		

			addTab(_tabHost,
				   _tabHost.newTabSpec("page3").setIndicator(
					   getString(R.string.schedule)),
				   (tabInfo = new TabInfo("page3", args)));
			_mapInfo.put(tabInfo.tag, tabInfo);

			addTab(_tabHost,
				   _tabHost.newTabSpec("page4").setIndicator(
					   getString(R.string.solutions)),
				   (tabInfo = new TabInfo("page4", args)));
			_mapInfo.put(tabInfo.tag, tabInfo);
			_tabHost.setOnTabChangedListener(this);
		}
		catch (Exception ex)
		{
			handleError(ex.toString());
		}
	}

	private void initViewPager(Bundle args)
	{
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(new DescriptionFragment());
		//fragments.add(new LotteryFragment());
		fragments.add(new ScheduleFragment());
		fragments.add(new SolutionFragment());
		_pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
		_viewPager = (ViewPager) findViewById(R.id.viewPager);
		_viewPager.setAdapter(_pagerAdapter);
		_viewPager.setOnPageChangeListener(this);
	}

	private void addTab(TabHost tabhost, TabHost.TabSpec tabSpec,
						TabInfo tabInfo)
	{
		tabSpec.setContent(this.new TabFactory(this));
		tabhost.addTab(tabSpec);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrolled
	 * (int, float, int)
	 */
	@Override
	public void onPageScrolled(int position, float positionOffset,
							   int positionOffsetPixels)
	{

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.view.ViewPager.OnPageChangeListener#onPageSelected
	 * (int)
	 */
	@Override
	public void onPageSelected(int position)
	{
		// TODO Auto-generated method stub
		_tabHost.setCurrentTab(position);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#
	 * onPageScrollStateChanged(int)
	 */
	@Override
	public void onPageScrollStateChanged(int state)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
	 */
	public void onTabChanged(String tag)
	{
		int pos = _tabHost.getCurrentTab();
		if (_viewPager != null)
			_viewPager.setCurrentItem(pos, true);
	}

	public void onShowDescription(View view)
	{
		SolutionFragment fragment = (SolutionFragment) _pagerAdapter.getItem(3);
		TextView code = (TextView) ((View) view.getParent())
			.findViewById(R.id.solution_code);
		int position = Integer.parseInt(code.getText().toString());
		fragment.onItemClick(null, (View) view.getParent(), position, 0);
	}
	
}
