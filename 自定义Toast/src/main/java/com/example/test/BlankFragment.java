package com.example.test;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    TextView textView;
    View frameLayout;


    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView= (TextView) view.findViewById(R.id.test);
//        frameLayout= (FrameLayout) view.findViewById(R.id.root);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getActivity(),"test",Toast.LENGTH_SHORT).show();
//                toast_3();
                GoMeMediaToast.getInstance().showToast(BlankFragment.this);
            }
        });
    }

    public void toast_3(){
        int[] lo=new int[2];
        frameLayout=  getView();
        frameLayout.getLocationOnScreen(lo);
//        frameLayout.getLocationInWindow(lo);
                 // 自定义土司显示位置
                // 创建土司
                Toast toast = new Toast(getActivity());
                 // 找到toast布局的位置
                 View layout = View.inflate(getActivity(),R.layout.toast,null);
                // 设置toast文本，把设置好的布局传进来
                toast.setView(layout);
                 // 设置土司显示在屏幕的位置
                 toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.TOP,0,lo[1]-getStatusBarHeight(getActivity()));
                 // 显示土司
                 toast.show();
            }

    public static int getStatusBarHeight(Context context) {
        /**
         * 获取状态栏高度——方法1
         * */
        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight1;
    }

//    public void test(View view){
//        Toast.makeText(getActivity(),"test",Toast.LENGTH_SHORT).show();
//    }

}
