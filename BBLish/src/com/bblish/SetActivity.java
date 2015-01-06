package com.bblish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.provider.ContactsContract.Contacts;

import com.bblish.info;

public class SetActivity extends Activity {
	
	ListView mListView = null;
	ListViewAdapter mAdapter = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);
		
		mListView = (ListView)findViewById(R.id.mList);
		
		mAdapter = new ListViewAdapter(this);
		mListView.setAdapter(mAdapter);
		
		mAdapter.addItem(getResources().getDrawable(R.drawable.jackofclubs), "title1");
		mAdapter.addItem(getResources().getDrawable(R.drawable.jackofdiamonds), "title2");
		mAdapter.addItem(getResources().getDrawable(R.drawable.jackofhearts), "title3");
		mAdapter.addItem(getResources().getDrawable(R.drawable.jackofspades), "title4");
	}
	
	
	
	private Cursor getContractCursor() {
		String[] proj = new String[] {
			Contacts._ID, 
			Contacts.PHOTO_ID, 
			Contacts.DISPLAY_NAME, 
			Contacts.HAS_PHONE_NUMBER
		};
		
		return managedQuery(Contacts.CONTENT_URI, proj, null, null, null);
	}
	
	

}
