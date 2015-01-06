package com.bblish;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
	private Context mContext = null;
	private ArrayList<ListData> mListData = new ArrayList<ListData>();

	public ListViewAdapter(Context mContext) {
		super();
		// TODO Auto-generated constructor stub
		
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListData.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mListData.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		
		if (convertView == null) {
			holder =  new ViewHolder();
			
			LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.listview_item, null);
			
			holder.mIcon = (ImageView)convertView.findViewById(R.id.mImage);
			holder.mText = (TextView)convertView.findViewById(R.id.mText);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder)convertView.getTag();
		}
		
		ListData mData = mListData.get(position);
		
		if (mData != null) {
			holder.mIcon.setVisibility(View.VISIBLE);
			holder.mIcon.setImageDrawable(mData.mIcon);
		} else {
			holder.mIcon.setVisibility(View.GONE);
		}
		
		holder.mText.setText(mData.mTitle);
		
		return convertView;
	}
	
	public void addItem(Drawable icon, String mTitle) {
		ListData addInfo = new ListData();
		
		addInfo.mIcon = icon;
		addInfo.mTitle = mTitle;
		
		mListData.add(addInfo);
	}
	
	class ViewHolder {
		public ImageView mIcon;
		public TextView mText;
		
	}

}
