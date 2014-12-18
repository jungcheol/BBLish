package com.bblish;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	
	private Context c;
	
	private ArrayList<String> thumbsDataList;
	private ArrayList<Long> thumbsIDList;
	
//    private Integer[] mThumbIds = {
//            R.drawable.jackofclubs, R.drawable.jackofdiamonds,
//            R.drawable.jackofhearts, R.drawable.jackofspades,
//            R.drawable.kingofclubs, R.drawable.kingofdiamonds,
//            R.drawable.kingofhearts, R.drawable.kingofspades,
//            R.drawable.queenofclubs, R.drawable.queenofdiamonds,
//            R.drawable.queenofhearts, R.drawable.queenofspades,
//    };

    public ImageAdapter(Context c) {
		// TODO Auto-generated constructor stub
		this.c = c ;
		
		thumbsDataList = new ArrayList<String>();
		thumbsIDList = new ArrayList<Long>();
		getThumbInfo(thumbsIDList, thumbsDataList);
	}

    @Override
	public int getCount() {
		// TODO Auto-generated method stub
		return thumbsIDList.size();
	}

    @Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

    @Override
	public View getView(int position, View v, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView;
        if (v == null) { 
            
            imageView = new ImageView(c);
            
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            
            imageView.setPadding(8, 8, 8, 8);
        } else { 
            imageView = (ImageView) v;
        }
       
        
//        imageView.setImageResource(mThumbIds[position]);
        Bitmap bmp = MediaStore.Images.Thumbnails.getThumbnail(c.getContentResolver(), thumbsIDList.get(position), MediaStore.Images.Thumbnails.MICRO_KIND, null);
		imageView.setImageBitmap(bmp);
        
        return imageView;
	}
    
	private void getThumbInfo(ArrayList<Long> thumbsIDs, ArrayList<String> thumbsDatas) {
		String[] proj = {MediaStore.Images.Media._ID,
						 MediaStore.Images.Media.DATA,
						 MediaStore.Images.Media.DISPLAY_NAME,
						 MediaStore.Images.Media.SIZE};
		
		Cursor imageCursor = c.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, 
															proj, 
															MediaStore.Images.Media.DISPLAY_NAME + " like '2014121712%'", 
															null, 
															null);
		
		if (imageCursor != null && imageCursor.moveToFirst()) {
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
//				thumbsID = imageCursor.getString(thumbsIDCol);
				thumbsID = imageCursor.getLong(thumbsIDCol);
				thumbsData = imageCursor.getString(thumbsDataCol);
				thumbsImageID = imageCursor.getString(thumbsImageIDCol);
				imgSize = imageCursor.getString(thumbsSizeCol);
				num++;
				
				if (thumbsImageID != null) {
					Log.d("", "[BBLishMainActivity] thumbsID : " + thumbsID);
					Log.d("", "[BBLishMainActivity] thumbsData : " + thumbsData);
					Log.d("", "[BBLishMainActivity] thumbsImageID : " + thumbsImageID);
					Log.d("", "[BBLishMainActivity] imgSize : " + imgSize);
					
					thumbsIDs.add(thumbsID);
					thumbsDatas.add(thumbsData);
				}
			} while (imageCursor.moveToNext());
		}
		
		imageCursor.close();
		
		return;
	}    

}
