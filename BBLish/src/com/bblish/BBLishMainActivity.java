package com.bblish;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.CookieManager;
import android.widget.ImageView;

public class BBLishMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_bblish_main);
		
//		Intent TabsIntent = new Intent().setClass(this, TabsActivity.class);
//		startActivity(TabsIntent);
		
		ImageView submit = (ImageView)findViewById(R.id.twoBLogo);
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("", "[BBLishMainActivity] --submit");
				
//				String strCookie = CookieManager.getInstance().getCookie("http://localhost:8080/testWeb/setCK.jsp");
//				Log.d("", "strCookie : " + strCookie);
				
				
				
				try {
					URL u = new URL("http://localhost:8080/testWeb/setCK.jsp");
					
					HttpURLConnection huc = (HttpURLConnection)u.openConnection();
					Map m = huc.getHeaderFields();
					String cookie = "";
					
					 if(m.containsKey("Set-Cookie")) {
					        Collection c =(Collection)m.get("Set-Cookie");
					        for(Iterator i = c.iterator(); i.hasNext(); ) {
					              cookie = (String)i.next();
					        }
					        
					        Log.d("", "[BBLishMainActivity] cookie : " + cookie);
					        
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
								

				
				Log.d("", "[BBLishMainActivity] submit--");
			}
		});
	}
	
}
