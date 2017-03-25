package com.example.gridviewdemo.adapter;

import java.util.ArrayList;

import com.example.gridviewdemo.R;
import com.example.gridviewdemo.bean.GridViewBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter {
	private ArrayList<GridViewBean> dataLsit=new ArrayList<GridViewBean>();
	
	private LayoutInflater mInflater=null;
	
	public  GridViewAdapter(Context context,ArrayList<GridViewBean> dataLsit){
		this.dataLsit=dataLsit;
		mInflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		
		return dataLsit.size();
	}

	@Override
	public Object getItem(int position) {
		
		return dataLsit.get(position);
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		
		if(convertView==null){
			holder=new ViewHolder();
			convertView=mInflater.inflate(R.layout.activity_main_item, null);
			holder.name=(TextView)convertView.findViewById(R.id.name);
			holder.itemView=(RelativeLayout)convertView.findViewById(R.id.item_view);
			
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		
		
		GridViewBean bean=dataLsit.get(position);
		holder.name.setText(bean.getName());
		
		if(bean.isChoose()){
			holder.name.setTextColor(0xffCC533A);
		}else{
			holder.name.setTextColor(0xff333333);
		}
		return convertView;
	}
	
	
	public void setChoose(int position,GridViewBean bean){
		dataLsit.set(position, bean);
		notifyDataSetChanged();
	}
	
	private class ViewHolder{
		private TextView name;
		private RelativeLayout itemView;
	}

}
