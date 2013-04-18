package com.sitronics.expocomconnection;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;
import android.support.v4.view.*;
import java.util.*;
import android.view.*;
import android.content.*;
import android.os.*;
import android.support.v4.app.*;

public class MainActivity extends FragmentActivity
implements TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener 
{

	private TabHost _tabHost;
	private ViewPager _viewPager;
	private HashMap<String,TabInfo> _mapInfo = new HashMap<String,TabInfo>();

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
	//	requestWindowFeature(Window.FEATURE_NO_TITLE);
	//	requestWindowFeature(Window.FEATURE_LEFT_ICON);
	//	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	//	WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		handler = new Handler();
	
		setContentView(R.layout.activity_main);
		initTabHost(savedInstanceState);

		if (savedInstanceState != null) 
		{
			_tabHost.setCurrentTabByTag(savedInstanceState.getString("tab")); //set the tab as per the saved state
		}

		initViewPager(savedInstanceState);

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
					Toast.makeText(getActivity(), errorMesage,
								   Toast.LENGTH_SHORT).show();

				}
			});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


	/** (non-Javadoc)
     * @see android.support.v4.app.FragmentActivity#onSaveInstanceState(android.os.Bundle)
     */
    protected void onSaveInstanceState(Bundle outState)
	{
        outState.putString("tab", _tabHost.getCurrentTabTag()); //save the tab selected
        super.onSaveInstanceState(outState);
    }

	private void initTabHost(Bundle args)
	{
		try
		{
			_tabHost = (TabHost)findViewById(android.R.id.tabhost);
			_tabHost.setup();
			MainActivity.TabInfo tabInfo = null;
			addTab(_tabHost, _tabHost.newTabSpec("page1").setIndicator("Описание"),
				   (tabInfo = new TabInfo("page1", args)));
			_mapInfo.put(tabInfo.tag, tabInfo);

			addTab(_tabHost, _tabHost.newTabSpec("page2").setIndicator("Программа"),
				   (tabInfo = new TabInfo("page2", args)));
			_mapInfo.put(tabInfo.tag, tabInfo);

			addTab(_tabHost, _tabHost.newTabSpec("page3").setIndicator("Представители"),
				   (tabInfo = new TabInfo("page3", args)));
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
		fragments.add(new OrganizationFragment());
		fragments.add(new ParticipantsFragment());
		_pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
		_viewPager = (ViewPager)findViewById(R.id.viewPager);
		_viewPager.setAdapter(_pagerAdapter);
		_viewPager.setOnPageChangeListener(this);
	}

	private void addTab(TabHost tabhost, TabHost.TabSpec tabSpec,
						TabInfo tabInfo)
	{
		tabSpec.setContent(this.new TabFactory(this));
		tabhost.addTab(tabSpec);
	}


	/* (non-Javadoc)
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrolled(int, float, int)
	 */
	@Override
	public void onPageScrolled(int position, float positionOffset,
							   int positionOffsetPixels)
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageSelected(int)
	 */
	@Override
	public void onPageSelected(int position)
	{
		// TODO Auto-generated method stub
		_tabHost.setCurrentTab(position);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.view.ViewPager.OnPageChangeListener#onPageScrollStateChanged(int)
	 */
	@Override
	public void onPageScrollStateChanged(int state)
	{
		// TODO Auto-generated method stub

	}


	/** (non-Javadoc)
	 * @see android.widget.TabHost.OnTabChangeListener#onTabChanged(java.lang.String)
	 */
	public void onTabChanged(String tag)
	{
		int pos = _tabHost.getCurrentTab();
		if (_viewPager != null)
			_viewPager.setCurrentItem(pos, true);
    }

}
