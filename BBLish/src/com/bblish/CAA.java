package com.bblish;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CAA extends ArrayAdapter<info> {
	
	ViewHolder vh = null;
	LayoutInflater inflater = null;
	ArrayList<info> infoList = null;
	Context ct = null;

	public CAA(Context context, int resource, ArrayList<info> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		
		this.inflater = LayoutInflater.from(context);
		this.ct = context;
	}
	
	@Override
	public int getCount() {
		return super.getCount();
	}
	
	@Override
	public info getItem(int position) {
		return super.getItem(position);
	}
	
	@Override
	public long getItemId(int position) {
		return super.getItemId(position);
	}
	
	@Override
	public View getView(int position, View convertview, ViewGroup parent) {
		View v = convertview;
		
		if (v == null) {
			vh =  new ViewHolder();
			v = inflater.inflate(R.layout.listview_item, null);
			vh.tv = (TextView)v.findViewById(R.id.mText);
//			vh.iv = (ImageView)v.findViewById(R.id.iv);
			
			v.setTag(vh);
		} else {
			vh = (ViewHolder)v.getTag();
		}
		
		vh.tv.setText(getItem(position).title);
		vh.iv.setTag(position);
		
		return v;
	}
	
	public void setArrayList(ArrayList<info> arrays) {
		this.infoList = arrays;
	}
	
	public ArrayList<info> getArrayList() {
		return infoList;
	}
	
	class ViewHolder {
		public TextView tv =  null;
		public ImageView iv = null;
	}

}
