package com.example.gridviewdemo;

import java.util.ArrayList;

import com.example.gridviewdemo.adapter.GridViewAdapter;
import com.example.gridviewdemo.bean.GridViewBean;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity implements OnItemClickListener{
	
	private ArrayList<GridViewBean> dataLsit=new ArrayList<GridViewBean>();
	
	private ArrayList<GridViewBean> pressedLsit=new ArrayList<GridViewBean>();
	
	private GridView mGridView=null;
	
	private GridViewAdapter mGridViewAdapter=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initDataList();
		
		initWidget();
	}
	
	
	
	
	private void initWidget(){
		mGridView=(GridView)super.findViewById(R.id.grid_view);
		
		mGridViewAdapter=new GridViewAdapter(this, dataLsit);
		
		mGridView.setAdapter(mGridViewAdapter);
		
		mGridView.setOnItemClickListener(this);
	}
	
	private void initDataList(){
		for(int i=0;i<10;i++){
			GridViewBean bean=new GridViewBean();
			bean.setName("数据显示");
			dataLsit.add(bean);
		}
	}




	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		
		GridViewBean bean=dataLsit.get(position);
		
		if(!bean.isChoose()){
			bean.setChoose(true);
			pressedLsit.add(bean);
		}else{
			bean.setChoose(false);
			pressedLsit.remove(bean);
		}
		mGridViewAdapter.setChoose(position, bean);
		mGridViewAdapter.notifyDataSetChanged();
	}

}
