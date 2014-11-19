package com.bblish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
		
//		cookieManager.setCookie("http://hirumiran.cafe24.com", "PHPSESSID=r0s96277qc1vugnd2p6dvup0t4; path=/; domain=hirumiran.cafe24.com");
//		cookieManager.setCookie("http://hirumiran.cafe24.com", "wordpress_3c4038bb61779c66da49063858848587=laweon|1416473164|d5d4f1edcc2ca9073337640f40703288; path=/web/wp-admin; domain=hirumiran.cafe24.com; HttpOnly");
		
		cookieManager.setCookie("http://hirumiran.cafe24.com/web/", "wordpress_logged_in_3c4038bb61779c66da49063858848587=laweon|1416473164|c1e86379ebb7bd32069ed1219ea25817; path=/web/; domain=hirumiran.cafe24.com; HttpOnly");
		/*
		cookieManager.setCookie("http://hirumiran.cafe24.com", "wordpress_test_cookie=WP Cookie check; path=/web/; domain=hirumiran.cafe24.com");
		cookieManager.setCookie("http://hirumiran.cafe24.com", "wp-settings-2=mfold=o; expires=Wed, 11 Nov 2015 08:30:15 GMT; path=/web/; domain=hirumiran.cafe24.com");
		cookieManager.setCookie("http://hirumiran.cafe24.com", "wp-settings-time-2=1415694614; expires=Wed, 11 Nov 2015 08:30:15 GMT; path=/web/; domain=hirumiran.cafe24.com");
		*/
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
				String path = "http://hirumiran.cafe24.com/web/";
//				String path = "http://www.wemakeprice.com";
				URL url =  null;
				HttpURLConnection con = null;
				BufferedReader in = null;
				String resultStr = "";
				String cookies = "";
				
				try {
					url = new URL(path);
					
//					URL u = new URL("http://hirumiran.cafe24.com/web/");
					
					con = (HttpURLConnection)url.openConnection();
					/*
					String headerName = "";
					String headerValue = "";
					for (int i = 0; ; i++) {
						headerName = con.getHeaderFieldKey(i);
						if (headerName != null && headerName.equals("Set-Cookie")) {
							headerValue = con.getHeaderField(i);
							
							Log.d("", "[BBLishMainActivity] headerName : " + headerName);
							Log.d("", "[BBLishMainActivity] headerValue : " + headerValue);
							
							break;
						}
					}
					*/
					in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					
					String str;
				/*
					while ((str = in.readLine()) != null) {
						resultStr += str;
						
					}
					
					Log.d("", "[BBLishMainActivity] Data : " + resultStr);
					*/
					
					
					List<String> cookies2 = con.getHeaderFields().get("Set-Cookie");
					
					String aaaa = con.getHeaderField("Set-Cookie");
					Log.d("", "[BBLishMainActivity] aaaa : " + aaaa);
					if (cookies2 != null) {
					    for (String cookie : cookies2) {
					        Log.d("", "[BBLishMainActivity] cookie2 : " + cookie.split(";\\s*")[0]);
//					    	Log.d("", "[BBLishMainActivity] cookie2 : " + cookie);
					    }
					}
					
					/*
					List<String> cookies2 = con.getHeaderFields().get("Set-Cookie");
					String cookieValue = null;
					
				
					for (Iterator<String> iter = cookies2.iterator(); iter.hasNext();) {
						String value = iter.next();
						
						if (value != null) {
							Log.d("", "[BBLishMainActivity] value : " + value);
						}
						
					}
				*/


					
					/*
					cookies = con.getHeaderField("Referer");

					if (cookies != null) {
						Log.d("", "[BBLishMainActivity] cookies : " + cookies);
//						cookieManager.setCookie("http://hirumiran.cafe24.com", cookies);
//						cookieManager.setCookie("http://172.30.95.84:8080", "fb_autologin=1; path=/");
					}
					*/
					
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
