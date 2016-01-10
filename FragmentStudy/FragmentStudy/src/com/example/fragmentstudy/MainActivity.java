package com.example.fragmentstudy;

import java.util.ArrayList;
import java.util.List;

import com.example.fragmentstudy.adapter.GridAdapter;
import com.example.fragmentstudy.domain.GridInfo;

import android.os.Bundle;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends FragmentActivity {

	private GridView gridView;
	private List<GridInfo> gridInfos = new ArrayList<GridInfo>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}
	
	private void initViews() {
		gridView = (GridView) findViewById(R.id.main_gridView);
		GridAdapter gridAdapter = new GridAdapter(MainActivity.this);
		getGridOnfoList();
		gridAdapter.setList(gridInfos);
		gridView.setAdapter(gridAdapter);
		gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));

		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		ExampleFragment fragment = new ExampleFragment("主功能页面");
		transaction.add(R.id.main_frameLayout, fragment);
		transaction.commit();
		
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction transaction = fragmentManager.beginTransaction();
				//渐变效果
//				transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN); 
				//通过anim xml 配置Fragment切换效果  new / old
				//上出下进
				transaction.setCustomAnimations(R.anim.push_up_in, R.anim.push_up_out);
				GridInfo info = gridInfos.get(arg2);
				ExampleFragment fragment = new ExampleFragment(info.getName());
				transaction.replace(R.id.main_frameLayout,fragment);
//				transaction.addToBackStack(null);  //提供返回上一页面的功能
				transaction.commit();
				//该方法获取是上一个Fragment          ************************
			}
		});
	}
	
	private void getGridOnfoList() {

		for(int i=0;i<6;i++){
			GridInfo gridInfo = new GridInfo("测试"+i, R.drawable.ic_launcher+"");
			gridInfos.add(gridInfo);
		}
	}
	
	/******************底部选择菜单********************/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
