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
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SearchActivity extends Activity {
	WebView webView;
	
	DatabaseHelper db;
	InfoClass info;
	
	Bitmap sp;
	Cursor ic;
	Cursor ric;
	ImageView selectImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		Log.d("", "[BBLishMainActivity] SearchActivity-onCreate : 1111");
		
		GridView gridview = (GridView) findViewById(R.id.gridView1);
	    gridview.setAdapter(new ImageAdapter(this));
	    
	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, 
	              View v, int position, long id) {
	            
	        	Toast.makeText(SearchActivity.this, 
	        		position + "", Toast.LENGTH_SHORT).show();
	        }
	    });
		
		Log.d("", "[BBLishMainActivity] SearchActivity-onCreate : 2222");
		
		Log.d("", "[BBLishMainActivity] SearchActivity-onCreate : 3333");
		
		Log.d("", "[BBLishMainActivity] SearchActivity-onCreate : 4444");
		
//		String[] img = {MediaStore.Images.Thumbnails._ID};
//		ic = managedQuery(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, img, null, null, MediaStore.Images.Thumbnails.IMAGE_ID + "");
//		String[] pq = {MediaStore.Images.Media.DATA};
//		ric = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, pq, null, null, null);
//		int count = ic.getCount();
//		if (count > 0) {
//			selectImage = (ImageView)findViewById(R.id.selectImage);
//			
//		}

		
//		String[] proj = {
//				Images.Media._ID, 
//				Images.Media.DATA, 
//				Images.Media.DISPLAY_NAME
//		};
//		int[] idx = new int[proj.length];
//		
//		ContentResolver resolver = mContext.getContentResolver();
//		Cursor cursor = Images.Media.query(resolver, Images.Media.EXTERNAL_CONTENT_URI, proj);
//		
//		if (cursor != null && cursor.moveToFirst()) {
//			idx[0] = cursor.getColumnIndex(proj[0]);
//			idx[1] = cursor.getColumnIndex(proj[1]);
//			idx[2] = cursor.getColumnIndex(proj[2]);
//			
//			do {
//				int photoID = cursor.getInt(idx[0]);
//				String photoPath = cursor.getString(idx[1]);
//				String displayName = cursor.getString(idx[2]);
//				
//				Log.d("", "[BBLishMainActivity] photoID : " + photoID);
//				Log.d("", "[BBLishMainActivity] photoPath : " + photoPath);
//				Log.d("", "[BBLishMainActivity] displayName : " + displayName);
//				Log.d("", "[BBLishMainActivity] --");
//			} while (cursor.moveToNext());
//		}
		
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
