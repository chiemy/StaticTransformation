package com.chiemy.perspectivelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

public class PerspectiveLayout extends LinearLayout {

	public PerspectiveLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public PerspectiveLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public PerspectiveLayout(Context context) {
		super(context);
		init();
	}
	private void init(){
		//启动静态变换，这样对每个子视图都能调用getChildStaticTransformation();
		this.setStaticTransformationsEnabled(true);
	}
	
	@Override
	protected boolean getChildStaticTransformation(View child, Transformation t) {
		t.clear();
		float delta;
		if(getOrientation() == HORIZONTAL){
			//根据左边缘的距离对子视图进行缩放
			delta = 1.0f - (float)child.getLeft()/getWidth();
		}else{
			//根据到顶端边缘的距离对子视图进行缩放
			delta = 1.0f - (float)child.getTop()/getHeight();
			//根据位置应用颜色淡出效果
			t.setAlpha(delta);
		}
		t.getMatrix().setScale(delta, delta, child.getWidth()/2,child.getHeight()/2);
		return true;
	}
	
}
