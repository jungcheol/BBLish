package com.bblish;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HomeActivity extends Activity {
	WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
		
		Log.d("", "[bbEngLog] HomeActivity-onCreate : 1111");
		
		webView = (WebView)findViewById(R.id.bbengWeb);
		webView.setWebViewClient(new WebViewClient());
		WebSettings set = webView.getSettings();
		set.setJavaScriptEnabled(true);
//		set.setBuiltInZoomControls(true);

		webView.loadUrl("http://hirumiran.cafe24.com/web/");
//		webView.loadUrl("http://172.30.95.84:8080/testWeb/setCK.jsp");
	}
	
}
