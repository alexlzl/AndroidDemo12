package com.net168.miuitoast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

	private MiuiToast toast;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    public void showToast(View v){
    	//�����ε����ť��ɶ��Toast.show�ĳ���
    	if(toast == null){
    		toast = MiuiToast.MakeText(this, "��С��Toast", MiuiToast.LENGTH_LONG);
    	}
    	toast.show();
    }

}
