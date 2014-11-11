package com.bblish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.ImageView;

public class SetActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);
		
		CookieSyncManager.createInstance(this);
		final CookieManager cookieManager = CookieManager.getInstance();
		CookieSyncManager.getInstance().startSync();
//		cookieManager.setCookie("http://hirumiran.cafe24.com", "PHPSESSID=33n1miu2k39tfv31c4tevptlv5; path=/");
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		ImageView submit = (ImageView)findViewById(R.id.twoBLogo);
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("", "[BBLishMainActivity] --submit");
				
//				String strCookie = CookieManager.getInstance().getCookie("http://localhost:8080/testWeb/setCK.jsp");
//				Log.d("", "strCookie : " + strCookie);
				
//				String sResult = "Error";
				
//				String path = "http://172.30.95.84:8080/testWeb/setCK.jsp?id=zzzz";
//				String path = "http://hirumiran.cafe24.com/web/";
				String path = "http://www.wemakeprice.com";
				URL url =  null;
				HttpURLConnection con = null;
				BufferedReader in = null;
				String resultStr = "";
				String cookies = "";
				
				try {
					url = new URL(path);
					
//					URL u = new URL("http://hirumiran.cafe24.com/web/");
					
					con = (HttpURLConnection)url.openConnection();
					
					in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					/*
					String str;
					
					while ((str = in.readLine()) != null) {
						resultStr += str;
						
					}
					
					Log.d("", "[BBLishMainActivity] Data : " + resultStr);
					*/
					
					
					List<String> cookies2 = con.getHeaderFields().get("set-cookie");
					 
					if (cookies2 != null) {
					    for (String cookie : cookies2) {
					        Log.d("", "[BBLishMainActivity] cookie2 : " + cookie.split(";\\s*")[0]);
					    }
					}
					
					
					cookies = con.getHeaderField("Set-Cookie");

					if (cookies != null) {
						Log.d("", "[BBLishMainActivity] cookies : " + cookies);
//						cookieManager.setCookie("http://hirumiran.cafe24.com", cookies);
						cookieManager.setCookie("http://172.30.95.84:8080", "fb_autologin=1; path=/");
					}
					
					
//		            conn.setRequestMethod("POST");
		            
//		            String body = "abcde=aaaa";

//		            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
//		            osw.write(body);
//		            osw.flush();        
		           
		            /*
		            InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8"); 
		            BufferedReader reader = new BufferedReader(tmp); 
		            StringBuilder builder = new StringBuilder(); 
		            String str; 
		            
		            while ((str = reader.readLine()) != null) {
		                builder.append(str);
		            } 
		            sResult = builder.toString();
		            
		            Log.d("", "[BBLishMainActivity] sResult : " + sResult);
		            */
					/*
					Map m = huc.getHeaderFields();
					
					String cookie = "";
					
					 if(m.containsKey("Set-Cookie")) {
					        Collection c =(Collection)m.get("Set-Cookie");
					        for(Iterator i = c.iterator(); i.hasNext(); ) {
					              cookie = (String)i.next();
					        }
					        
					        Log.d("", "[BBLishMainActivity] cookie : " + cookie);
					        
					}
					*/
					
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
								
				

				
				Log.d("", "[BBLishMainActivity] submit--");
				
				
			}

		});
	}
}
