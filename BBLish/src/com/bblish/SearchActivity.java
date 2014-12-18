package com.bblish;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bblish.DatabaseHelper;
import com.bblish.InfoClass;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
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
	
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		Log.d("", "[BBLishMainActivity] SearchActivity-onCreate : 1111");
		
//		GridView gridview = (GridView) findViewById(R.id.gridView1);
//	    gridview.setAdapter(new ImageAdapter(this));
//	    
//	    gridview.setOnItemClickListener(new OnItemClickListener() {
//	        public void onItemClick(AdapterView<?> parent, 
//	              View v, int position, long id) {
//	            
//	        	Toast.makeText(SearchActivity.this, 
//	        		position + "", Toast.LENGTH_SHORT).show();
//	        }
//	    });
		
        GridView gv = (GridView)findViewById(R.id.gridView1);
//        final IImageAdapter ia = new IImageAdapter(this);
        final ImageAdapter ia = new ImageAdapter(this);
        gv.setAdapter(ia);

		

		
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
	
	/**========================================== 
	 * 		        Adapter class 
	 * ==========================================*/
	public class IImageAdapter extends BaseAdapter {
		private String imgData;
		private String geoData;
		private ArrayList<String> thumbsDataList;
		private ArrayList<Long> thumbsIDList;
		
		IImageAdapter(Context c){
			mContext = c;
			thumbsDataList = new ArrayList<String>();
			thumbsIDList = new ArrayList<Long>();
			getThumbInfo(thumbsIDList, thumbsDataList);
		}
		

		
		public boolean deleteSelected(int sIndex){
			return true;
		}
		
		public int getCount() {
			return thumbsIDList.size();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {	
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null){
				imageView = new ImageView(mContext);
//				imageView.setLayoutParams(new GridView.LayoutParams(95, 95));
				imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
				imageView.setAdjustViewBounds(false);
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(2, 2, 2, 2);
			}else{
				imageView = (ImageView) convertView;
			}
//			BitmapFactory.Options bo = new BitmapFactory.Options();
//			bo.inSampleSize = 8;
//			
//			Bitmap bmp = BitmapFactory.decodeFile(thumbsDataList.get(position), bo);
//			
//			Bitmap resized = Bitmap.createScaledBitmap(bmp, 95, 95, true);
//			imageView.setImageBitmap(resized);
			
			Bitmap bmp = MediaStore.Images.Thumbnails.getThumbnail(getContentResolver(), thumbsIDList.get(position), MediaStore.Images.Thumbnails.MICRO_KIND, null);
			imageView.setImageBitmap(bmp);
			
			return imageView;
		}
		
		private void getThumbInfo(ArrayList<Long> thumbsIDs, ArrayList<String> thumbsDatas){
			String[] proj = {MediaStore.Images.Media._ID,
							 MediaStore.Images.Media.DATA,
							 MediaStore.Images.Media.DISPLAY_NAME,
							 MediaStore.Images.Media.SIZE};
			
			Cursor imageCursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, proj, MediaStore.Images.Media.DISPLAY_NAME + " like '2014121712%'", null, null);
			
			if (imageCursor != null && imageCursor.moveToFirst()){
				String title;
				long thumbsID;
				String thumbsImageID;
				String thumbsData;
				String data;
				String imgSize;
				
				int thumbsIDCol = imageCursor.getColumnIndex(MediaStore.Images.Media._ID);
				int thumbsDataCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
				int thumbsImageIDCol = imageCursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME);
				int thumbsSizeCol = imageCursor.getColumnIndex(MediaStore.Images.Media.SIZE);
				int num = 0;
				do {
//					thumbsID = imageCursor.getString(thumbsIDCol);
					thumbsID = imageCursor.getLong(thumbsIDCol);
					thumbsData = imageCursor.getString(thumbsDataCol);
					thumbsImageID = imageCursor.getString(thumbsImageIDCol);
					imgSize = imageCursor.getString(thumbsSizeCol);
					num++;
					if (thumbsImageID != null){
						Log.d("", "[BBLishMainActivity] thumbsID : " + thumbsID);
						Log.d("", "[BBLishMainActivity] thumbsData : " + thumbsData);
						Log.d("", "[BBLishMainActivity] thumbsImageID : " + thumbsImageID);
						Log.d("", "[BBLishMainActivity] imgSize : " + imgSize);
						thumbsIDs.add(thumbsID);
						thumbsDatas.add(thumbsData);
					}
				}while (imageCursor.moveToNext());
			}
			imageCursor.close();
			return;
		}
		
		private String getImageInfo(String ImageData, String Location, String thumbID){
			String imageDataPath = null;
			String[] proj = {MediaStore.Images.Media._ID,
					 MediaStore.Images.Media.DATA,
					 MediaStore.Images.Media.DISPLAY_NAME,
					 MediaStore.Images.Media.SIZE};
			Cursor imageCursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
					proj, "_ID='"+ thumbID +"'", null, null);
			
			if (imageCursor != null && imageCursor.moveToFirst()){
				if (imageCursor.getCount() > 0){
					int imgData = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
					imageDataPath = imageCursor.getString(imgData);
				}
			}
			imageCursor.close();
			return imageDataPath;
		}
	}	
}
