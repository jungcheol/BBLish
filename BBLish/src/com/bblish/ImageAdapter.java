package com.bblish;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	
	private Context c;
	
    private Integer[] mThumbIds = {
            R.drawable.jackofclubs, R.drawable.jackofdiamonds,
            R.drawable.jackofhearts, R.drawable.jackofspades,
            R.drawable.kingofclubs, R.drawable.kingofdiamonds,
            R.drawable.kingofhearts, R.drawable.kingofspades,
            R.drawable.queenofclubs, R.drawable.queenofdiamonds,
            R.drawable.queenofhearts, R.drawable.queenofspades,
    };

    public ImageAdapter(Context c) {
		// TODO Auto-generated constructor stub
		this.c = c ;
	}

    @Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mThumbIds.length;
	}

    @Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return mThumbIds[position];
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
       
        
        imageView.setImageResource(mThumbIds[position]);
       
        
        return imageView;
	}

}
