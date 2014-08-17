package com.chiemy.perspectivelayout;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

public class ScrollActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		HorizontalScrollView scrollView = new HorizontalScrollView(this);
		PerspectiveScrollContentView contentView = new PerspectiveScrollContentView(this);
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
			//动态调整子视图的变换无法通过硬件加速实现，因此要禁用硬件加速，但是例子中这么写图片根本不显示
			//错误提示：View: View too large to fit into drawing cache
			//只能在manifest中添加android:hardwareAccelerated="false",禁用
			//contentView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
		}
		for(int i = 0 ; i < 20 ; i++){
			ImageView iv = new ImageView(this);
			iv.setImageResource(R.drawable.ic_launcher);
			contentView.addView(iv);
		}
		scrollView.addView(contentView);
		setContentView(scrollView);
	}
}
