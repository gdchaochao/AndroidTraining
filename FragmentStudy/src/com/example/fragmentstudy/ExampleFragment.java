package com.example.fragmentstudy;

import java.util.Date;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class ExampleFragment extends Fragment{

	private String title = "";
	public ExampleFragment(String title) {
		super();
		this.title = title;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.layout_fragment_example, null);
		TextView textView = (TextView) view.findViewById(R.id.fragment_textView);
		textView.setText(textView.getText().toString()+"\n"+title+"\n"+new Date().getTime());
//		return super.onCreateView(inflater, container, savedInstanceState);
		return view;
	}
}
