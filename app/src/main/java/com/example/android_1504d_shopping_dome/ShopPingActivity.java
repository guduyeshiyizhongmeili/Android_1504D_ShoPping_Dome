package com.example.android_1504d_shopping_dome;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ShopPingActivity extends Activity{
	
	private ListView listView;
	private List<User> list=new ArrayList<User>();
	private TextView text_price;
	private Button but;
	private ProgressDialog dialog;
	MyBase adapter;

	//总价，总量
	int userprice;
	int usercount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.shoppingactivity);
		
		
		//获得资源ID
		listView=(ListView) findViewById(R.id.listview);
		but=(Button) findViewById(R.id.but);
		text_price=(TextView) findViewById(R.id.text_price);
		
		
		//对list添加数据
		for (int i = 0; i <100; i++) {
			User user=new User(10, 0, false);
			list.add(user);
		}
		adapter=new MyBase(this, list);
		listView.setAdapter(adapter);
		
		//设置长按监听，弹出进度条
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//创建ProgressDialog
				dialog=new ProgressDialog(ShopPingActivity.this);
				dialog.setIcon(R.drawable.ic_launcher);
				dialog.setTitle("正在删除。。。。。");
				dialog.setMax(100);
				//设置样式
				dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				dialog.show();
				
				new Thread(){
					
					public void run() {
						while(true){
							//判断如果当前的进度大于100是消失，若》=0时就让他+1
							if(dialog.getProgress()>=100){
								dialog.dismiss();
							}else{
								dialog.setProgress(dialog.getProgress()+1);
								try {
									sleep(100);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
							
						}
					};
					
				}.start();
				
				
				return false;
			}
		});
		
		
		
	}
	
	
	public void SetpPriceCount(int tprice,int tcount){
		//接受传过来总价，总量
		userprice=tprice;
		usercount=tcount;
		text_price.setText("总价："+userprice+"RMB");
		
	}
	
	
	

}
