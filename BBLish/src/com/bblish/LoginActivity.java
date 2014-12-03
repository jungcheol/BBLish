package com.bblish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		CookieSyncManager.createInstance(this);
		final CookieManager cookieManager = CookieManager.getInstance();
		CookieSyncManager.getInstance().startSync();
		
		/*
		cookieManager.setCookie("http://hirumiran.cafe24.com", "PHPSESSID=r0s96277qc1vugnd2p6dvup0t4; path=/; domain=hirumiran.cafe24.com");
		cookieManager.setCookie("http://hirumiran.cafe24.com", "wordpress_3c4038bb61779c66da49063858848587=laweon|1416473164|d5d4f1edcc2ca9073337640f40703288; path=/web/wp-admin; domain=hirumiran.cafe24.com; HttpOnly");
		cookieManager.setCookie("http://hirumiran.cafe24.com", "wordpress_logged_in_3c4038bb61779c66da49063858848587=laweon|1416473164|c1e86379ebb7bd32069ed1219ea25817; path=/web/; domain=hirumiran.cafe24.com; HttpOnly");
		cookieManager.setCookie("http://hirumiran.cafe24.com", "wordpress_test_cookie=WP Cookie check; path=/web/; domain=hirumiran.cafe24.com");
		cookieManager.setCookie("http://hirumiran.cafe24.com", "wp-settings-2=mfold=o; expires=Wed, 11 Nov 2015 08:30:15 GMT; path=/web/; domain=hirumiran.cafe24.com");
		cookieManager.setCookie("http://hirumiran.cafe24.com", "wp-settings-time-2=1415694614; expires=Wed, 11 Nov 2015 08:30:15 GMT; path=/web/; domain=hirumiran.cafe24.com");
		*/
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		Button submitBtn = (Button)findViewById(R.id.loginBtn);
		submitBtn.setOnClickListener(new View.OnClickListener() {
			
			Dialog dialog = null;
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("", "[BBLishMainActivity] --submit");
				
				EditText loginId = (EditText)findViewById(R.id.loginId);
				EditText loginPwd = (EditText)findViewById(R.id.loginPwd);
				
//				Log.d("", "[BBLishMainActivity] loginId.toString() : " + loginId.getText().toString());
//				Log.d("", "[BBLishMainActivity] loginId.toString().length() : " + loginId.getText().toString().length());
				
				String idC = "";
				if (loginId.getText().toString().trim().length() == 0) {
					idC = getResources().getString(R.string.id_check);
					dialog = process(idC);
					dialog.show();
					
					return;
				}
				
				String pwdC = "";
				if (loginPwd.getText().toString().trim().length() == 0) {
					pwdC = getResources().getString(R.string.pwd_check);
					dialog = process(pwdC);
					dialog.show();
					
					return;
				}
				
				String body = "log=" + loginId.getText().toString().trim() + "&pwd=" + loginPwd.getText().toString().trim();
				String path = "http://hirumiran.cafe24.com/web/wp-login-mobile.php";
				URL url =  null;
				HttpURLConnection con = null;
				BufferedReader in = null;
				String resultStr = "";
				String cookies = "";
				
				try {
					url = new URL(path);
					
					con = (HttpURLConnection)url.openConnection();
					con.setRequestMethod("POST");
					con.setDoInput(true);
					con.setDoOutput(true);
					con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
					OutputStream os = con.getOutputStream();
					os.write(body.getBytes("UTF-8"));
					os.flush();
					os.close();
									
					String ck = con.getHeaderField("Set-Cookie");
					Log.d("", "[BBLishMainActivity] ck : " + ck);
						
					String idPwdC = "";
					if (!ck.contains("wordpress_logged_in_")) {
						idPwdC = getResources().getString(R.string.id_pwd_check);
						dialog = process(idPwdC);
						dialog.show();
						
						return;
					} else {
						cookieManager.setCookie("http://hirumiran.cafe24.com/", ck);
						
						startTabsIntent();
					}
					
/*
					in = new BufferedReader(new InputStreamReader(con.getInputStream()));
					
					String str;

					while ((str = in.readLine()) != null) {
						resultStr += str;
						
					}
					
					Log.d("", "[BBLishMainActivity] Data : " + resultStr);

					List<String> cookies2 = con.getHeaderFields().get("Set-Cookie");
					
					String aaaa = con.getHeaderField("Set-Cookie");
					Log.d("", "[BBLishMainActivity] aaaa : " + aaaa);
					if (cookies2 != null) {
					    for (String cookie : cookies2) {
					        Log.d("", "[BBLishMainActivity] cookie2 : " + cookie.split(";\\s*")[0]);
					    	Log.d("", "[BBLishMainActivity] cookie2 : " + cookie);
					    }
					}

					List<String> cookies2 = con.getHeaderFields().get("Set-Cookie");
					String cookieValue = null;
					
				
					for (Iterator<String> iter = cookies2.iterator(); iter.hasNext();) {
						String value = iter.next();
						
						if (value != null) {
							Log.d("", "[BBLishMainActivity] value : " + value);
						}
						
					}
*/

				} catch (Exception e) {
					// TODO: handle exception
					
					Log.d("", "[BBLishMainActivity] Exception");
				} finally {
					try {
//						if (in != null) in.close();
						if (con != null) con.disconnect();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
								

				
				Log.d("", "[BBLishMainActivity] submit--");
			}
		});
	
	}
	
	public void startTabsIntent() {
		Intent TabsIntent = new Intent().setClass(this, TabsActivity.class);
		startActivity(TabsIntent);
	}
	
	public Dialog process(String msg) {		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(msg)
		.setTitle(R.string.app_name)
		.setCancelable(false)
		.setPositiveButton(R.string.cStr, new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				dialog.cancel();
			}
		});
		
		return builder.create();
		
	}
}
