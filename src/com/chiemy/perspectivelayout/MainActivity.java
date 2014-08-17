package com.chiemy.perspectivelayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void onClick(View v){
		switch(v.getId()){
		case R.id.button1:
			Intent intent = new Intent(this,ScrollActivity.class);
			startActivity(intent);
			break;
		}
	}
}
