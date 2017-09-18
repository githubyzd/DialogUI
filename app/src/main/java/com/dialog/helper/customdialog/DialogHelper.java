package com.dialog.helper.customdialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.StackView;
import android.widget.TextView;

import com.dialog.helper.R;

/**
 * Created by yzd on 2017/9/1 0001.
 */

public class DialogHelper {

    private static AlertDialog alertDialog;
    private static Dialog dialog;
    /**
     * @param context
     * @param cancelAble
     * @param title
     * @param msg
     * @param btnText
     */
    public static void showAlertOneBtn(Context context, boolean cancelAble, String title, String msg, String btnText, DialogListener listener) {
        alertDialog = new DialogView.Builder(context)
                .setType(DialogType.TYPE_ALERT_ONEBTN)
                .setMiddleBtnText(btnText)
                .setTile(title)
                .setMsg(msg)
                .setCancelAble(cancelAble)
                .setListener(listener)
                .build()
                .show();
    }

    public static void showAlertTwoBtn(Context context, boolean cancelAble, String title, String msg, String positiveText, String negativeText, DialogListener listener) {
        alertDialog = new DialogView.Builder(context)
                .setType(DialogType.TYPE_ALERT_TWOBTN)
                .setLeftBtnText(positiveText)
                .setRightBtnText(negativeText)
                .setTile(title)
                .setMsg(msg)
                .setCancelAble(cancelAble)
                .setListener(listener)
                .build()
                .show();
    }

    public static void showAlertThreeBtn(Context context, boolean cancelAble, String title, String msg, String positiveText, String neutralText, String negativeText, DialogListener listener) {
        alertDialog = new DialogView.Builder(context)
                .setType(DialogType.TYPE_ALERT_THREEBTN)
                .setLeftBtnText(positiveText)
                .setMiddleBtnText(neutralText)
                .setRightBtnText(negativeText)
                .setTile(title)
                .setMsg(msg)
                .setCancelAble(cancelAble)
                .setListener(listener)
                .build()
                .show();
    }

    public static void showAlertEdit(Context context, boolean cancelAble, String title, String hint1, String hint2, String confirmText, String cancelText, DialogListener listener) {
        alertDialog = new DialogView.Builder(context)
                .setType(DialogType.TYPE_ALERT_EDIT)
                .setTile(title)
                .setCancelAble(cancelAble)
                .setHint1(hint1)
                .setHint2(hint2)
                .setConfirmText(confirmText)
                .setCancelText(cancelText)
                .setListener(listener)
                .build()
                .show();
    }

    public static void showLoading(Context context, CharSequence msg, boolean isVertical, boolean cancleable, boolean isWhiteBg){
        dialog = new Dialog(context,R.style.dialog);
        dialog.setCancelable(cancleable);
        View root;
        if (isVertical) {
            root = View.inflate(context, R.layout.dialogui_loading_vertical, null);
        } else {
            root = View.inflate(context, R.layout.dialogui_loading_horizontal, null);
        }

        LinearLayout llBg = (LinearLayout) root.findViewById(R.id.dialogui_ll_bg);
        ProgressBar pbBg = (ProgressBar) root.findViewById(R.id.pb_bg);
        TextView tvMsg = (TextView) root.findViewById(R.id.dialogui_tv_msg);
        tvMsg.setText(msg);
        if (isWhiteBg) {
            llBg.setBackgroundResource(R.drawable.dialogui_shape_wihte_round_corner);
            pbBg.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.dialogui_rotate_mum));
            tvMsg.setTextColor(context.getResources().getColor(R.color.text_black));
        } else {
            llBg.setBackgroundResource(R.drawable.dialogui_shape_gray_round_corner);
            pbBg.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.dialogui_rotate_mum_light));
            tvMsg.setTextColor(Color.WHITE);
        }
        dialog.setContentView(root);
        dialog.show();
    }

    public static void dismiss() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

}
