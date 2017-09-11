package com.example.android_1504d_shopping_dome;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;

public class MyBase extends BaseAdapter {

	private Context context;
	private List<User> list;
	private int tprice;//总价
	private int tcount;//总量
	
	
	public MyBase(Context context, List<User> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		final ViewHolder holder;
		
		if(convertView==null){
			convertView=LayoutInflater.from(context).inflate(R.layout.mybase, null);
			holder=new ViewHolder();
			holder.checkBox=(CheckBox) convertView.findViewById(R.id.checkBox1);
			holder.price=(TextView) convertView.findViewById(R.id.text_price);
			convertView.setTag(holder);
		}else{
		    holder=(ViewHolder) convertView.getTag();
		}
		
			holder.price.setText(list.get(position).price+"");
			holder.checkBox.setChecked(list.get(position).isCheck);
			holder.checkBox.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					User user=list.get(position);
					if(holder.checkBox.isChecked()){
						//设置增加总价，总量
						tprice+=user.price;
						tcount+=1;
						user.isCheck=true;
					}else{
						//设置减少总价，总量
						tprice-=user.price;
						tcount-=1;
						user.isCheck=false;
					}
					
					//得到当前的Activity调取SetpPriceCount方法 进行传参
				ShopPingActivity activity=(ShopPingActivity) context;
				activity.SetpPriceCount(tprice, tcount);
					
				}
			});
		
		
		
		
		
		return convertView;
	}

	class ViewHolder{
		
		CheckBox checkBox;
		TextView name,price;
		
	}
	
}
