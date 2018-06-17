package com.qiufeng.customviews;

import android.app.*;
import android.content.*;
import android.widget.*;
import com.github.mrengineer13.snackbar.*;

public class ui
{
	static Toast toast;
	public static void toast(Context cx,String str){
		if(toast!=null)toast.cancel();
		toast=Toast.makeText(cx,str,Toast.LENGTH_SHORT);
		toast.show();
	}
	public static void snack(Activity cx,String str,String label){
		new SnackBar.Builder(cx)
			.withMessage(str)
			.withActionMessage(label)
			.withStyle(SnackBar.Style.DEFAULT)
			.withDuration((short)2000)
			.withTextColorId(R.color.fbutton_color_emerald)
			.show();
	}
	public static void snack(Activity cx,String str){
		snack(cx,str,"");
	}
}
