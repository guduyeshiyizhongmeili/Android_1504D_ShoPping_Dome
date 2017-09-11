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
        //�õ�TabHost
        tabHost=getTabHost();
        
        //������һ��ѡ�
        TabSpec spec1=tabHost.newTabSpec("one");
        spec1.setIndicator("��ҳ");
        //�������Ӧ��Activity��Ҳ����ҳ��ʾ��Activity
        spec1.setContent(new Intent(this,HomeActivity.class));
        //����ǩ��ӵ�TabHost��
        tabHost.addTab(spec1);
        
        
        //������2��ѡ�
        TabSpec spec2=tabHost.newTabSpec("two");
        spec2.setIndicator("����");
        //�������Ӧ��Activity��Ҳ����ҳ��ʾ��Activity
        spec2.setContent(new Intent(this,ClassActivity.class));
        //����ǩ��ӵ�TabHost��
        tabHost.addTab(spec2);
        
        
        //������3��ѡ�
        TabSpec spec3=tabHost.newTabSpec("three");
        spec3.setIndicator("���ﳵ");
        //�������Ӧ��Activity��Ҳ����ҳ��ʾ��Activity
        spec3.setContent(new Intent(this,ShopPingActivity.class));
        //����ǩ��ӵ�TabHost��
        tabHost.addTab(spec3);
        
    }

    
}
