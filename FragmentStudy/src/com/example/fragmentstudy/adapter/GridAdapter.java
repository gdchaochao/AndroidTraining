package com.example.fragmentstudy.adapter;

import java.util.List;

import com.example.fragmentstudy.R;
import com.example.fragmentstudy.domain.GridInfo;


import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

	private class GridHolder {
		ImageView appImage;
		TextView appName;
	}
	private Context context;
	private List<GridInfo> list;
	private LayoutInflater mInflater;
	public GridAdapter(Context c) {
		super();
		this.context = c;
	}

	public void setList(List<GridInfo> list) {  
        this.list = list;  
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
    }
	
	@Override
	public int getCount() {
		 return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		GridHolder holder;  
        if (convertView == null) {     
            convertView = mInflater.inflate(R.layout.grid_item, null);     
            holder = new GridHolder();  
            holder.appImage = (ImageView)convertView.findViewById(R.id.itemImage);  
            holder.appName = (TextView)convertView.findViewById(R.id.itemText);  
            convertView.setTag(holder);     
        }else{  
             holder = (GridHolder) convertView.getTag();     
        }  
        GridInfo info = list.get(position);  
        if (info != null) {     
            holder.appName.setText(info.getName());  
            int colorInt = Color.parseColor("#CCFF66");
            if(position%6==1){
            	colorInt = Color.parseColor("#336699");
            } else if (position%6==2) {
            	colorInt = Color.parseColor("#663366");
			}else if (position%6==3) {
            	colorInt = Color.parseColor("#ABCDEF");
			}else if (position%6==4) {
            	colorInt = Color.parseColor("#669933");
			}else if (position%6==5) {
            	colorInt = Color.parseColor("#CC3399");
			}       
            holder.appImage.setBackgroundColor(colorInt);
            holder.appName.setTextColor(Color.BLACK);
            holder.appName.setGravity(Gravity.CENTER);
        }  
        return convertView;  
	}
}
