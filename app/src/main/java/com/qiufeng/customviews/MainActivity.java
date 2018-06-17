package com.qiufeng.customviews;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.github.ybq.android.spinkit.*;
import com.github.ybq.android.spinkit.sprite.*;

public class MainActivity extends Activity 
{
	public static Context cx;
	public static Activity ctx;
	public static LayoutInflater li;
	public static ScrollView mainScroll;
	public static LinearLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
		
        super.onCreate(savedInstanceState);
		li=LayoutInflater.from(this);
		mainScroll=(ScrollView)li.inflate(R.layout.main,null);
		mainLayout=(LinearLayout)mainScroll.findViewById(R.id.mainLayout);
        setContentView(mainScroll);
		cx=this;
		ctx=this;
		menu.init();
		
		
    }
}
