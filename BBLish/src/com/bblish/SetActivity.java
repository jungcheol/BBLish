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
import android.provider.ContactsContract.Contacts;

import com.bblish.info;

public class SetActivity extends Activity {
	
	ListView lv = null;
	ArrayList<info> al = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);
		
		setLayout();
		
		al = new ArrayList<info>();
		
		for (int i = 0; i < 10; i++) {
			al.add(new info(i + " lv", getResources().getDrawable(R.drawable.ic_launcher)));
		}

		lv.setAdapter(new CAA(this, R.layout.lv_row, al));
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
	
	public void setLayout() {
		lv = (ListView)findViewById(R.id.lv);
	}
}
