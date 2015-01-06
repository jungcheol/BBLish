package com.bblish;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bblish.DatabaseHelper;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class FavoriteActivity extends Activity {
	
	private static final int MESSAGE_ID = 1;
	private NotificationManager nm;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST = 100;
	Uri fileUri;
	Bitmap bitmap;
	ImageView preview;
	DatabaseHelper db;
	Button notiBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favorite);
		
		nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		
		db = new DatabaseHelper(this);
		
		InfoClass info = new InfoClass();
		
		info.setImgSrc("/aaaa");
		info.setPlace("a");
		info.setPeople("b");
		info.setBeer(1);
		info.setSoju(2);
		info.setMalgoli(3);
		info.setWhisky(4);
		info.setEtc(5);
		
//		int result = db.insert(info);
		
		preview = (ImageView)findViewById(R.id.preview);
		
		preview.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent actionViewIntent = new Intent(Intent.ACTION_VIEW);
				actionViewIntent.setDataAndType(fileUri, "image/jpg");
				startActivity(actionViewIntent);
			}
		});
		
		ImageView captureAction = (ImageView)findViewById(R.id.captureImage);
//		Button captureAction = (Button)findViewById(R.id.captureAction);
		captureAction.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub			
//				captureAction();
				
				
				
				Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				
				fileUri = getOutputMediaFileUri();
				intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);	
			
				startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST);
			}
		});
		
		notiBtn = (Button)findViewById(R.id.noti);
		notiBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				onNoti();
			}
		});
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
			
		switch (requestCode) {
		case CAPTURE_IMAGE_ACTIVITY_REQUEST:
			
			if (resultCode == Activity.RESULT_OK) {
							
				try {
					/*
					if (bitmap != null && !bitmap.isRecycled()) {
						bitmap.recycle();
						bitmap = null;
					}
					*/
										
					BitmapFactory.Options options = new BitmapFactory.Options();
					options.inSampleSize = 4;

					Bitmap src = BitmapFactory.decodeFile(fileUri.getPath(), options);
					Bitmap bMap = Bitmap.createScaledBitmap(src, 300, 300, true);
					
					preview.setImageBitmap(bMap);
				} catch (Exception e) {
					// TODO: handle exception
				
					Log.d("", "[BBLishMainActivity] onActivityResult Exception : " + e.toString());
				}
			}
			
			break;

		default:
			break;
		}
	}



/*
public void captureAction() {
	camera = getCameraInstance();
	
	preview = new CameraView(this, camera);
	
	FrameLayout screen = (FrameLayout)findViewById(R.id.cameraPreView);
	screen.addView(preview);
	
	Button capture = (Button)findViewById(R.id.captureBtn);
	capture.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			camera.takePicture(null, null, picture);
		}
	});		
}
*/

private static File getOutputMediaFile() {
	File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "BBLish");

	if (!mediaStorageDir.exists()) {
		if (!mediaStorageDir.mkdirs()) {
			Log.d("", "[BBLishMainActivity] : failed to create directory");
			return null;
		}
	}
	
	String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	File mediaFile = new File(mediaStorageDir.getPath() + File.separator + timeStamp + ".jpg");
	
	return mediaFile;
}

private static Uri getOutputMediaFileUri() {
	return Uri.fromFile(getOutputMediaFile());
	
}	

public void onNoti() {
	
	Notification nf = new Notification(R.drawable.jackofclubs, "zzzz", System.currentTimeMillis());
	
	Intent it = new Intent(this, LoginActivity.class);
	PendingIntent pit = PendingIntent.getActivity(this, 0, it, 0);
	
	nf.setLatestEventInfo(this, "subject", "content", pit);
	
	nm.notify(MESSAGE_ID, nf);
}


	
}
