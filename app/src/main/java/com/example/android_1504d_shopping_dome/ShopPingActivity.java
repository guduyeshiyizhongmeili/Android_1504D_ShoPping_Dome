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

	//�ܼۣ�����
	int userprice;
	int usercount;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.shoppingactivity);
		
		
		//�����ԴID
		listView=(ListView) findViewById(R.id.listview);
		but=(Button) findViewById(R.id.but);
		text_price=(TextView) findViewById(R.id.text_price);
		
		
		//��list�������
		for (int i = 0; i <100; i++) {
			User user=new User(10, 0, false);
			list.add(user);
		}
		adapter=new MyBase(this, list);
		listView.setAdapter(adapter);
		
		//���ó�������������������
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//����ProgressDialog
				dialog=new ProgressDialog(ShopPingActivity.this);
				dialog.setIcon(R.drawable.ic_launcher);
				dialog.setTitle("����ɾ������������");
				dialog.setMax(100);
				//������ʽ
				dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
				dialog.show();
				
				new Thread(){
					
					public void run() {
						while(true){
							//�ж������ǰ�Ľ��ȴ���100����ʧ������=0ʱ������+1
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
		//���ܴ������ܼۣ�����
		userprice=tprice;
		usercount=tcount;
		text_price.setText("�ܼۣ�"+userprice+"RMB");
		
	}
	
	
	

}
