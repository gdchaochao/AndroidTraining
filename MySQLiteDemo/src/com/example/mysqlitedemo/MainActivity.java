package com.example.mysqlitedemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	private int mOperateIndex;
	private TextView mInfo = null;
	FeedReaderDbExcutor excutor;
	private int count;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		excutor = new FeedReaderDbExcutor(getApplicationContext());
//		excutor.insertData("2", "tt", "cc");
//		Toast.makeText(getApplicationContext(), "index:" + excutor.getDataIndex(1), Toast.LENGTH_SHORT).show();
		
		mOperateIndex = 1;
		count = 0;
		mInfo = (TextView) findViewById(R.id.row_text);
		mInfo.setText("index:" + mOperateIndex);
	}

	
	public void onPlus(View view) {
		mOperateIndex++;
		mInfo.setText("index:" + mOperateIndex);
	}
	
	public void onDesc(View view) {
		if (mOperateIndex > 1) {
			mOperateIndex--;
			mInfo.setText("index:" + mOperateIndex);
		}
	}
	
	public void onInsertData(View view) {
		count++;
		excutor.insertData(mOperateIndex + "", "title" + count, "content");
	}
	
	public void onQueryData(View view) {
		String text = excutor.getTitleData(mOperateIndex);
		Toast.makeText(getApplicationContext(), "Title:" + text, Toast.LENGTH_SHORT).show();
	}
	
	public void onDeleteData(View view) {
		int changeCount = excutor.deleteData(mOperateIndex);
		Toast.makeText(getApplicationContext(), "Change:" + changeCount, Toast.LENGTH_SHORT).show();
	}
	
	public void onUpdateData(View view) {
		count++;
		int changeCount = excutor.updateData(mOperateIndex, "title" + count);
		Toast.makeText(getApplicationContext(), "Change:" + changeCount, Toast.LENGTH_SHORT).show();
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
