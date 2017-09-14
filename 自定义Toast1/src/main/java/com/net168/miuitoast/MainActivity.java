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
    	//避免多次点击按钮造成多次Toast.show的出现
    	if(toast == null){
    		toast = MiuiToast.MakeText(this, "仿小米Toast", MiuiToast.LENGTH_LONG);
    	}
    	toast.show();
    }

}
