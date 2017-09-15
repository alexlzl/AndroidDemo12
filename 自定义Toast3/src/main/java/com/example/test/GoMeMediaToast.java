package com.example.test;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class GoMeMediaToast {
    private static GoMeMediaToast mGoMeMediaToast;
    private View mRootView;
    private Toast mToast;

    private GoMeMediaToast() {

    }

    public static GoMeMediaToast getInstance() {
        if (mGoMeMediaToast == null) {
            synchronized (GoMeMediaToast.class) {
                mGoMeMediaToast = new GoMeMediaToast();
            }
        }
        return mGoMeMediaToast;
    }

    /**
     * 显示在Fragment顶部
     * @param fragment
     */
    public void showToastOnTop(Fragment fragment) {
        int[] location = new int[2];
        mRootView = fragment.getView();
        if (mRootView == null)
            return;
        mRootView.getLocationOnScreen(location);
        if (mToast == null) {
            mToast = new Toast(fragment.getActivity());
        }
        View layout = View.inflate(fragment.getActivity(), R.layout.toast_layout, null);
        mToast.setView(layout);
        mToast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.TOP, 0, location[1] - getStatusBarHeight(fragment.getActivity()));
        mToast.show();

    }

    /**
     * 显示在Fragment底部
     * @param fragment
     */
    public void showToastOnBottom(Fragment fragment){
        int fragmentViewHeight=0;
        int[] location = new int[2];
        mRootView = fragment.getView();
        fragmentViewHeight=mRootView.getHeight();
        if (mRootView == null)
            return;
        mRootView.getLocationOnScreen(location);
        if (mToast == null) {
            mToast = new Toast(fragment.getActivity());
        }
        View layout = View.inflate(fragment.getActivity(), R.layout.toast_layout, null);
        mToast.setView(layout);
        mToast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.TOP, 0, location[1]+fragmentViewHeight- getStatusBarHeight(fragment.getActivity())-getToastHeight(layout));
        mToast.show();

    }

    /**
     * 获取TOAST视图高度
     * @param toast
     * @return
     */
     private int getToastHeight(View toast){
         int width=View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
         int height=View.MeasureSpec.makeMeasureSpec(0,View.MeasureSpec.UNSPECIFIED);
         toast.measure(width, height);
         int toastMeasuredWidth = toast.getMeasuredWidth();
         int toastMeasuredHeight = toast.getMeasuredHeight();
         return  toastMeasuredHeight;
     }

    /**
     * 获取状态栏高度
     * @param context
     * @return
     */
    private int getStatusBarHeight(Context context) {

        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = context.getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight1;
    }
}
