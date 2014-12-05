package com.bblish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

public class IntroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		
		CookieSyncManager.createInstance(this);
		CookieManager cookieManager = CookieManager.getInstance();
		CookieSyncManager.getInstance().startSync();
		
		if (cookieManager != null) {
			cookieManager.removeAllCookie();	
		}
		
		Handler hd = new Handler();
		hd.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				startTabsIntent();
				
				finish();
			}
		}, 2000);
	}
	
	public void startTabsIntent() {
		Intent TabsIntent = new Intent().setClass(this, TabsActivity.class);
		startActivity(TabsIntent);
	}
	
	public void startLoginIntent() {
		Intent LoginIntent = new Intent().setClass(this, LoginActivity.class);
		startActivity(LoginIntent);	
	}
}
