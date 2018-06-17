package com.qiufeng.customviews;

import android.graphics.*;
import android.view.*;
import android.widget.*;
import com.amulyakhare.textdrawable.*;
import com.amulyakhare.textdrawable.util.*;
import com.github.ybq.android.spinkit.*;
import com.github.ybq.android.spinkit.sprite.*;
import com.oguzdev.circularfloatingactionmenu.library.*;
import info.hoang8f.widget.*;


public class menu
{
	public static FloatingActionMenu fam;
	public static SubActionButton button1;
	public static SubActionButton button2;
	public static SubActionButton add;
	public static LayoutInflater li=LayoutInflater.from(MainActivity.cx);
	public static LinearLayout view=(LinearLayout)li.inflate(R.layout.item_pager,null);
	public static SpinKitView spinKitView = (SpinKitView) view.findViewById(R.id.spin_kit);
	public static FButton fbtn=(FButton)view.findViewById(R.id.mainFButton);
	static{
		Style style = Style.CUBE_GRID;
		Sprite drawable = SpriteFactory.create(style);
		spinKitView.setIndeterminateDrawable(drawable);
		spinKitView.setBackgroundColor(Color.BLUE);
		fbtn.setOnClickListener(FBtn.vo);
		view.removeView(fbtn);
		view.removeView(spinKitView);
	}
	public static boolean btn1opened=true;
	public static boolean btn2opened=true;
	public static void init(){
		ImageView icon = new ImageView(MainActivity.cx); // Create an icon
		icon.setImageResource( R.drawable.ic_launcher );
		FloatingActionButton actionButton = new FloatingActionButton.Builder(MainActivity.ctx)
			.setContentView(icon)
			.build();
		SubActionButton.Builder itemBuilder = new SubActionButton.Builder(MainActivity.ctx);
// repeat many times:
		 button1=newSab(itemBuilder,"Load");
		 button2=newSab(itemBuilder,"FButton");
		 add=newSab(itemBuilder,"Add");
		FloatingActionMenu.Builder actionMenu = new FloatingActionMenu.Builder(MainActivity.ctx);
		actionMenu.addSubActionView(button1,200,200);
		actionMenu.addSubActionView(button2,175,175);
		actionMenu.addSubActionView(add,150,150);
		// ...
		actionMenu.attachTo(actionButton);
		 fam=actionMenu.build();
		button1.setOnClickListener(new View.OnClickListener(){
				public void onClick(View v){
					btn1opened=!btn1opened;
					if(btn1opened)MainActivity.mainLayout.removeView(spinKitView);
					else MainActivity.mainLayout.addView(spinKitView);
					fam.close(true);
				}
			});
		button2.setOnClickListener(new View.OnClickListener(){
				public void onClick(View view){
					btn2opened=!btn2opened;
					if(btn2opened)MainActivity.mainLayout.removeView(fbtn);
					else MainActivity.mainLayout.addView(fbtn);
					fam.close(true);
				}
			});
		add.setOnClickListener(new View.OnClickListener(){
				public void onClick(View view){
					ui.snack(MainActivity.ctx,"Nothing yet!","DONE");
					fam.close(true);
				}
			});
	}
	public static SubActionButton newSab(SubActionButton.Builder sb,String str){
		ImageView itemIcon2 = new ImageView(MainActivity.ctx);
		TextDrawable drawable = TextDrawable.builder()
			.beginConfig()
			.width(100)
			.height(100)
			.fontSize(20)
			.bold()
			.toUpperCase()
			.endConfig()
			.buildRoundRect(str, getCol(str),100);
		itemIcon2.setImageDrawable(drawable ); 
		SubActionButton button2 = sb.setContentView(itemIcon2).build();
		return button2;
	}
	public static int getCol(String str){
		return ColorGenerator.MATERIAL.getColor(str);
	}
}
