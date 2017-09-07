package com.dialog.helper.customdialog;


import android.app.AlertDialog;
import android.content.Context;

/**
 * Created by yzd on 2017/9/1 0001.
 */

public class DialogHelper {

    private static AlertDialog alertDialog;

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

    public static void dismiss() {
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
    }

}
