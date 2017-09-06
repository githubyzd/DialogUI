package com.dialog.helper;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.dialog.helper.popupexample.PopupExampleActivity;
import com.dialog.helper.view.LoadingPopupHelper;
import com.dialog.helper.view.PopupHelper;

public class PopupWindowActivity extends AppCompatActivity {

    private Button topBtn;
    private Button centerBtn;
    private Button bottomBtn;
    private PopupHelper popupHelper;
    private View contentView;
    private View contentView1;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button example1;
    private Button example2;
    private Button example3;
    private LoadingPopupHelper loadingPopupHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);

        topBtn = (Button) findViewById(R.id.popup_top);
        centerBtn = (Button) findViewById(R.id.popup_center);
        bottomBtn = (Button) findViewById(R.id.popup_bottom);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        example1 = (Button) findViewById(R.id.example1);
        example2 = (Button) findViewById(R.id.example2);
        example3 = (Button) findViewById(R.id.example3);
        contentView = LayoutInflater.from(this).inflate(R.layout.popu_layout, null);
        contentView1 = LayoutInflater.from(this).inflate(R.layout.popu1_layout, null);
    }

    public void popup_top(View view) {
        popupHelper = new PopupHelper.Builder(this)
                .contentView(contentView)
                .height(ViewGroup.LayoutParams.WRAP_CONTENT)
                .width(ViewGroup.LayoutParams.MATCH_PARENT)
                .anchorView(topBtn)
                .gravity(Gravity.TOP)
                .parentView(topBtn)
                .outSideTouchable(true)
                .animationStyle(R.style.anim_top)
                .build()
                .showAtLocation();
    }

    public void popup_center(View view) {
        popupHelper = new PopupHelper.Builder(this)
                .contentView(contentView)
                .height(ViewGroup.LayoutParams.WRAP_CONTENT)
                .width(ViewGroup.LayoutParams.MATCH_PARENT)
                .anchorView(topBtn)
                .gravity(Gravity.CENTER)
                .parentView(topBtn)
                .outSideTouchable(true)
                .animationStyle(R.style.anim_center)
                .build()
                .showAtLocation();
    }

    public void popup_bottom(View view) {
        popupHelper = new PopupHelper.Builder(this)
                .contentView(contentView)
                .height(ViewGroup.LayoutParams.WRAP_CONTENT)
                .width(ViewGroup.LayoutParams.MATCH_PARENT)
                .anchorView(topBtn)
                .gravity(Gravity.BOTTOM)
                .parentView(topBtn)
                .outSideTouchable(true)
                .animationStyle(R.style.anim_bottom)
                .build()
                .showAtLocation();
    }

    public void btn1(View view) {
        popupHelper = new PopupHelper.Builder(this)
                .contentView(contentView1)
                .height(ViewGroup.LayoutParams.WRAP_CONTENT)
                .width(btn1.getWidth())
                .anchorView(btn1)
                .outSideTouchable(true)
                .build()
                .showAsDropDown();
    }

    public void btn2(View view) {
        popupHelper = new PopupHelper.Builder(this)
                .contentView(contentView1)
                .height(ViewGroup.LayoutParams.WRAP_CONTENT)
                .width(btn2.getWidth())
                .anchorView(btn2)
                .outSideTouchable(true)
                .build()
                .showAsDropDown();
    }

    public void btn3(View view) {
        popupHelper = new PopupHelper.Builder(this)
                .contentView(contentView1)
                .height(ViewGroup.LayoutParams.WRAP_CONTENT)
                .width(btn3.getWidth())
                .anchorView(btn3)
                .outSideTouchable(true)
                .build()
                .showAsDropDown();
    }

    public void example1(View view) {
        View contentView = LayoutInflater.from(this).inflate(R.layout.example1, null);
        contentView.findViewById(R.id.qq).setOnClickListener(clickListener);
        contentView.findViewById(R.id.qq_qzone).setOnClickListener(clickListener);
        contentView.findViewById(R.id.wechat).setOnClickListener(clickListener);
        contentView.findViewById(R.id.wechat_circle).setOnClickListener(clickListener);
        contentView.findViewById(R.id.sina).setOnClickListener(clickListener);
        contentView.findViewById(R.id.ding).setOnClickListener(clickListener);
        contentView.findViewById(R.id.alipay).setOnClickListener(clickListener);
        contentView.findViewById(R.id.ynote).setOnClickListener(clickListener);
        contentView.findViewById(R.id.tv_cancel).setOnClickListener(clickListener);

        popupHelper = new PopupHelper.Builder(this)
                .contentView(contentView)
                .height(ViewGroup.LayoutParams.WRAP_CONTENT)
                .width(ViewGroup.LayoutParams.MATCH_PARENT)
                .anchorView(topBtn)
                .gravity(Gravity.BOTTOM)
                .parentView(topBtn)
                .outSideTouchable(true)
                .animationStyle(R.style.anim_bottom)
                .build()
                .showAtLocation();
    }

    public void example2(View view) {
        View contentView = LayoutInflater.from(this).inflate(R.layout.example2, null);
        contentView.findViewById(R.id.bt_camera).setOnClickListener(clickListener);
        contentView.findViewById(R.id.bt_photo).setOnClickListener(clickListener);
        contentView.findViewById(R.id.bt_cancel).setOnClickListener(clickListener);

        popupHelper = new PopupHelper.Builder(this)
                .contentView(contentView)
                .height(ViewGroup.LayoutParams.WRAP_CONTENT)
                .width(ViewGroup.LayoutParams.MATCH_PARENT)
                .anchorView(topBtn)
                .gravity(Gravity.BOTTOM)
                .parentView(topBtn)
                .outSideTouchable(true)
                .animationStyle(R.style.anim_bottom)
                .build()
                .showAtLocation();
    }

    public void example3(View view) {
        startActivity(new Intent(this, PopupExampleActivity.class));
    }

    public void loading1(View view) {
        loadingPopupHelper = new LoadingPopupHelper.Builder(this)
                .width(400)
                .height(400)
                .outSideTouchable(true)
                .parentView(btn1)
                .withShadow(true)
                .msg("加载中...")
                .loadingType(LoadingPopupHelper.LOADING_TYPE_DEFAULT)
                .build()
                .showLoading();
        dismissLoading();
    }

    public void loading2(View view) {
        loadingPopupHelper = new LoadingPopupHelper.Builder(this)
                .width(400)
                .height(400)
                .outSideTouchable(true)
                .msg("加载中...")
                .parentView(btn1)
                .withShadow(true)
                .loadingType(LoadingPopupHelper.LOADING_TYPE1)
                .build()
                .showLoading();
        dismissLoading();
    }

    public void loading3(View view) {
        loadingPopupHelper = new LoadingPopupHelper.Builder(this)
                .width(400)
                .height(400)
                .outSideTouchable(true)
                .msg("加载中...")
                .parentView(btn1)
                .withShadow(true)
                .loadingType(LoadingPopupHelper.LOADING_TYPE2)
                .build()
                .showLoading();
        dismissLoading();
    }

    public void loading4(View view) {
        loadingPopupHelper = new LoadingPopupHelper.Builder(this)
                .width(400)
                .height(400)
                .outSideTouchable(true)
                .msg("加载中...")
                .parentView(btn1)
                .withShadow(true)
                .loadingType(LoadingPopupHelper.LOADING_TYPE3)
                .build()
                .showLoading();
        dismissLoading();
    }

    public void loading5(View view) {
        loadingPopupHelper = new LoadingPopupHelper.Builder(this)
                .width(400)
                .height(400)
                .msg("加载中...")
                .outSideTouchable(true)
                .parentView(btn1)
                .withShadow(true)
                .loadingType(LoadingPopupHelper.LOADING_TYPE4)
                .build()
                .showLoading();
        dismissLoading();
    }

    private void dismissLoading() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                loadingPopupHelper.dismissLoading();
            }
        }, 2000);
    }

    private final int CAMERA_CODE = 1024;
    private final int PHOTO_CODE = CAMERA_CODE + 1;
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.qq:
                    Toast.makeText(PopupWindowActivity.this, "QQ分享", Toast.LENGTH_LONG).show();
                    dismiss();
                    break;
                case R.id.qq_qzone:
                    Toast.makeText(PopupWindowActivity.this, "QQ空间分享", Toast.LENGTH_LONG).show();
                    dismiss();
                    break;
                case R.id.wechat:
                    Toast.makeText(PopupWindowActivity.this, "微信分享", Toast.LENGTH_LONG).show();
                    dismiss();
                    break;
                case R.id.wechat_circle:
                    Toast.makeText(PopupWindowActivity.this, "微信朋友圈分享", Toast.LENGTH_LONG).show();
                    dismiss();
                    break;
                case R.id.sina:
                    Toast.makeText(PopupWindowActivity.this, "新浪微博分享", Toast.LENGTH_LONG).show();
                    dismiss();
                    break;
                case R.id.ding:
                    Toast.makeText(PopupWindowActivity.this, "钉钉分享", Toast.LENGTH_LONG).show();
                    dismiss();
                    break;
                case R.id.alipay:
                    Toast.makeText(PopupWindowActivity.this, "支付宝分享", Toast.LENGTH_LONG).show();
                    dismiss();
                    break;
                case R.id.ynote:
                    Toast.makeText(PopupWindowActivity.this, "有道云笔记分享", Toast.LENGTH_LONG).show();
                    dismiss();
                    break;
                case R.id.bt_cancel:
                case R.id.tv_cancel:
                    Toast.makeText(PopupWindowActivity.this, "取消分享", Toast.LENGTH_LONG).show();
                    dismiss();
                    break;
                case R.id.bt_camera:
                    //调用照相机
                    Intent intent = new Intent();
                    intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
                    startActivityForResult(intent, CAMERA_CODE);
                    dismiss();
                    break;
                case R.id.bt_photo:
                    Intent mIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(mIntent, PHOTO_CODE);
                    break;
            }
        }
    };

    public void dismiss() {
        popupHelper.dismiss();
    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        //在此处接受图片地址
        if (resultCode == CAMERA_CODE) {
        } else if (resultCode == PHOTO_CODE) {

        }
    }
}
