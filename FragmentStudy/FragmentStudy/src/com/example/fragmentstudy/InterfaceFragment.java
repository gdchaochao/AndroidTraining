package com.example.fragmentstudy;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class InterfaceFragment extends Fragment{

	 private MyListener myListener; 
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
		
	}
	
	 /** Fragment第一次附属于Activity时调用,在onCreate之前调用 */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		myListener = (MyListener) activity; 
	}

	public interface MyListener{
		public void showMessage(int index);
	}
	
	/*点触监听事件*/
	class ButtonOnClickListener implements  OnClickListener{

		@Override
		public void onClick(View v) {

			switch (v.getId()) {
			case 1:
				myListener.showMessage(1);
				break;
			case 2:
				myListener.showMessage(2);
				break;
			default:
				break;
			}
		}
		
	}
}
