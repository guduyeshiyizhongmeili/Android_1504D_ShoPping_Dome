package com.example.android_1504d_shopping_dome;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	private TabHost tabHost;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //得到TabHost
        tabHost=getTabHost();
        
        //创建第一个选项卡
        TabSpec spec1=tabHost.newTabSpec("one");
        spec1.setIndicator("首页");
        //添加所对应个Activity，也是首页显示的Activity
        spec1.setContent(new Intent(this,HomeActivity.class));
        //将标签添加到TabHost中
        tabHost.addTab(spec1);
        
        
        //创建第2个选项卡
        TabSpec spec2=tabHost.newTabSpec("two");
        spec2.setIndicator("分类");
        //添加所对应个Activity，也是首页显示的Activity
        spec2.setContent(new Intent(this,ClassActivity.class));
        //将标签添加到TabHost中
        tabHost.addTab(spec2);
        
        
        //创建第3个选项卡
        TabSpec spec3=tabHost.newTabSpec("three");
        spec3.setIndicator("购物车");
        //添加所对应个Activity，也是首页显示的Activity
        spec3.setContent(new Intent(this,ShopPingActivity.class));
        //将标签添加到TabHost中
        tabHost.addTab(spec3);
        
    }

    
}
