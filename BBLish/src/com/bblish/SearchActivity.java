package com.bblish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SearchActivity extends Activity {
	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		
		
		Log.d("", "[BBLishMainActivity] SearchActivity-onCreate : 1111");
		
		webView = (WebView)findViewById(R.id.bbengWeb2);
		webView.setWebViewClient(new WebViewClient());
		WebSettings set = webView.getSettings();
		set.setJavaScriptEnabled(true);
//		set.setBuiltInZoomControls(true);

		webView.loadUrl("http://hirumiran.cafe24.com/web/");
//		webView.loadUrl("http://172.30.95.84:8080/testWeb/getCK.jsp");
		
		String path = "http://hirumiran.cafe24.com/web/";
		URL url =  null;
		HttpURLConnection con = null;
		BufferedReader in = null;
		String resultStr = "";
		String cookies = "";
		
		try {
			url = new URL(path);
			
			con = (HttpURLConnection)url.openConnection();
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String str;
			
			List<String> cookies2 = con.getHeaderFields().get("Set-Cookie");
			
			String aaaa = con.getHeaderField("Set-Cookie");
			Log.d("", "[BBLishMainActivity] aaaa : " + aaaa);
			if (cookies2 != null) {
			    for (String cookie : cookies2) {
			        Log.d("", "[BBLishMainActivity] cookie2 : " + cookie.split(";\\s*")[0]);
//			    	Log.d("", "[BBLishMainActivity] cookie2 : " + cookie);
			    }
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			
			Log.d("", "[BBLishMainActivity] Exception");
		} finally {
			try {
				if (in != null) in.close();
				if (con != null) con.disconnect();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
}
