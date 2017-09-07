package com.dialog.helper.customdialog;

import android.content.Context;

import com.dialog.helper.customdialog.DialogListener;
import com.dialog.helper.customdialog.DialogType;

/**
 * Created by yzd on 2017/9/7 0007.
 */

public class DialogBean {
    private Context context;
    private DialogType type;
    private String title;
    private String msg;
    private boolean cancelAble;
    private String leftBtnText;
    private String middleBtnText;
    private String rightBtnText;
    private String hint1;
    private String hint2;
    private String confirmText;
    private String cancelText;
    private DialogListener listener;

    public DialogBean() {
    }

    public Context getContext() {

        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public DialogType getType() {
        return type;
    }

    public void setType(DialogType type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public boolean isCancelAble() {
        return cancelAble;
    }

    public String getHint1() {
        return hint1;
    }

    public void setHint1(String hint1) {
        this.hint1 = hint1;
    }

    public String getHint2() {
        return hint2;
    }

    public void setHint2(String hint2) {
        this.hint2 = hint2;
    }

    public void setCancelAble(boolean cancelAble) {
        this.cancelAble = cancelAble;
    }

    public String getLeftBtnText() {
        return leftBtnText;
    }

    public void setLeftBtnText(String leftBtnText) {
        this.leftBtnText = leftBtnText;
    }

    public String getMiddleBtnText() {
        return middleBtnText;
    }

    public void setMiddleBtnText(String middleBtnText) {
        this.middleBtnText = middleBtnText;
    }

    public String getRightBtnText() {
        return rightBtnText;
    }

    public DialogListener getListener() {
        return listener;
    }

    public String getConfirmText() {
        return confirmText;
    }

    public void setConfirmText(String confirmText) {
        this.confirmText = confirmText;
    }

    public String getCancelText() {
        return cancelText;
    }

    public void setCancelText(String cancelText) {
        this.cancelText = cancelText;
    }

    public void setListener(DialogListener listener) {
        this.listener = listener;
    }

    public void setRightBtnText(String rightBtnText) {
        this.rightBtnText = rightBtnText;
    }
}
