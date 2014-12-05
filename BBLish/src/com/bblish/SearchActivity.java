package com.bblish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bblish.DatabaseHelper;
import com.bblish.InfoClass;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.GridView;

public class SearchActivity extends Activity {
	WebView webView;
	
	DatabaseHelper db;
	InfoClass info;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		Log.d("", "[BBLishMainActivity] SearchActivity-onCreate : 1111");
		
		GridView gridview = (GridView)findViewById(R.id.gridView1);
		
		
//		webView = (WebView)findViewById(R.id.bbengWeb2);
//		webView.setWebViewClient(new WebViewClient());
//		WebSettings set = webView.getSettings();
//		set.setJavaScriptEnabled(true);
//		set.setBuiltInZoomControls(true);
//
//		webView.loadUrl("http://hirumiran.cafe24.com/web/");
		
//		db = new DatabaseHelper(this);
//		
//		List<InfoClass> infoList = db.getAllInfo();
//
//		for (int i = 0; i < infoList.size(); i++) {
//			info = (InfoClass)infoList.get(i);
//			Log.d("", "[BBLishMainActivity] id : " + info.getId());
//			Log.d("", "[BBLishMainActivity] imgSrc : " + info.getImgSrc());
//			Log.d("", "[BBLishMainActivity] place : " + info.getPlace());
//			Log.d("", "[BBLishMainActivity] people : " + info.getPeople());
//			Log.d("", "[BBLishMainActivity] beer : " + info.getBeer());
//			Log.d("", "[BBLishMainActivity] soju : " + info.getSoju());
//			Log.d("", "[BBLishMainActivity] malgoli : " + info.getMalgoli());
//			Log.d("", "[BBLishMainActivity] whisky : " + info.getWhisky());
//			Log.d("", "[BBLishMainActivity] etc : " + info.getEtc());
//			Log.d("", "[BBLishMainActivity] ");
//			
//		}

	}
}
