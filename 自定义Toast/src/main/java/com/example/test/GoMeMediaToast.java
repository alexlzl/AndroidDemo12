package com.example.test;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import static com.example.test.R.layout.toast;

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

    public void showToast(Fragment fragment) {
        int[] location = new int[2];
        mRootView = fragment.getView();
        if (mRootView == null)
            return;
        mRootView.getLocationOnScreen(location);
        if (mToast == null) {
            mToast = new Toast(fragment.getActivity());
        }
        View layout = View.inflate(fragment.getActivity(), toast, null);
        mToast.setView(layout);
        mToast.setGravity(Gravity.FILL_HORIZONTAL | Gravity.TOP, 0, location[1] - getStatusBarHeight(fragment.getActivity()));
        mToast.show();

    }

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
