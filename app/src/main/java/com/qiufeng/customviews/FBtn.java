package com.qiufeng.customviews;
import android.view.*;
import android.widget.*;
import info.hoang8f.widget.*;

public class FBtn
{
	public static View.OnClickListener vo=new View.OnClickListener(){
		public void onClick(View view){
			ui.toast(MainActivity.cx,"FButton被按下!");
		}
	};
}
