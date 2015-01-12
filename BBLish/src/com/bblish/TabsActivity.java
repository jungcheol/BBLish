package com.bblish;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class TabsActivity extends TabActivity implements OnTabChangeListener {
	TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_tabs);
		
		Intent HomeIntent = new Intent().setClass(this, HomeActivity.class);
		Intent SearchIntent = new Intent(this, SearchActivity.class);
		Intent FavoriteIntent = new Intent(this, FavoriteActivity.class);
//		Intent SetIntent = new Intent(this, SetActivity.class);
		Intent DemoIntent = new Intent(this, DemoActivity.class);
				
		tabHost = getTabHost();		
		tabHost.setOnTabChangedListener(this);
		
//		tabHost.getTabWidget().setStripEnabled(false);
//		tabHost.getTabWidget().setDividerDrawable(R.drawable.ic_launcher);
		
		TabSpec HomeTabSpec = tabHost.newTabSpec("HomeTabSpec").setIndicator("", getResources().getDrawable(R.drawable.tabmenu_01_indicator));
		HomeTabSpec.setContent(HomeIntent);
		tabHost.addTab(HomeTabSpec);

		TabSpec CreateTabSpec = tabHost.newTabSpec("CreateTabSpec").setIndicator("", getResources().getDrawable(R.drawable.tabmenu_02_indicator));
		CreateTabSpec.setContent(SearchIntent);
		tabHost.addTab(CreateTabSpec);
		
		TabSpec ListTabSpec = tabHost.newTabSpec("ListTabSpec").setIndicator("", getResources().getDrawable(R.drawable.tabmenu_03_indicator));
		ListTabSpec.setContent(FavoriteIntent);
		tabHost.addTab(ListTabSpec);
		
//		TabSpec ProfileTabSpec = tabHost.newTabSpec("ProfileTabSpec").setIndicator("", getResources().getDrawable(R.drawable.tabmenu_04_indicator));
//		ProfileTabSpec.setContent(SetIntent);
//		tabHost.addTab(ProfileTabSpec);
		
		TabSpec DemoTabSpec = tabHost.newTabSpec("DemoTabSpec").setIndicator("", getResources().getDrawable(R.drawable.tabmenu_04_indicator));
		DemoTabSpec.setContent(DemoIntent);
		tabHost.addTab(DemoTabSpec);
				
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#1d202f"));
			tabHost.getTabWidget().getChildAt(i).getLayoutParams().height = 200;
		}
		
		tabHost.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#507b9e"));
		
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
			tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#1d202f"));
			tabHost.getTabWidget().getChildAt(i).getLayoutParams().height = 200;
		}
		
		tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).setBackgroundColor(Color.parseColor("#507b9e"));
		
	}
}
