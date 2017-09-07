package com.dialog.helper.customdialog;

/**
 * Created by yzd on 2017/9/7 0007.
 */

public abstract class DialogListener {
    /**
     * 确定
     */
    public void onPositive() {
    }

    /**
     * 否定
     */
    public void onNegative() {

    }

    /**
     * 中立
     */
    public void onNeutral() {
    }

    /**
     * 取消
     */
    public void onCancle() {
    }

    /**
     * 获取输入内容
     */
    public void onGetInput(CharSequence input1, CharSequence input2) {
    }

    /**
     * 内容有变化时
     */
    public void onTextChanges(CharSequence input1, CharSequence input2) {

    }

    /**
     * 获取选择集合
     */
    public void onGetChoose(boolean[] states) {

    }
}
