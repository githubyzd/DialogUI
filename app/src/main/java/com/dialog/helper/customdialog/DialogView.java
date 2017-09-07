package com.dialog.helper.customdialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;

/**
 * Created by yzd on 2017/9/7 0007.
 */

public class DialogView {

    private final View rootView;
    private Context mContext;
    private boolean cancelAble;

    private DialogView(Builder builder) {
        mContext = builder.context;
        DialogBean bean = new DialogBean();
        bean.setContext(builder.context);
        bean.setMsg(builder.msg);
        bean.setMiddleBtnText(builder.middlBtnText);
        bean.setLeftBtnText(builder.leftBtnText);
        bean.setRightBtnText(builder.rightBtnText);
        bean.setType(builder.type);
        bean.setTitle(builder.title);
        bean.setHint1(builder.hint1);
        bean.setHint2(builder.hint2);
        bean.setConfirmText(builder.confirmText);
        bean.setCancelText(builder.cancelText);
        bean.setCancelAble(builder.cancelAble);
        bean.setListener(builder.listener);

        cancelAble = builder.cancelAble;

        ViewHolder viewHolder = new ViewHolder(bean);
        rootView = viewHolder.assingDatasAndEvents();

    }


    public AlertDialog show() {
        return new AlertDialog.Builder(mContext)
                .setView(rootView)
                .setCancelable(cancelAble)
                .show();
    }


    public static class Builder {
        private Context context;
        private DialogType type;
        private String title;
        private String msg;
        private boolean cancelAble;
        private String hint1;
        private String hint2;
        private String leftBtnText;
        private String middlBtnText;
        private String rightBtnText;
        private String confirmText;
        private String cancelText;
        private DialogListener listener;

        public Builder(Context activity) {
            context = activity;
        }

        public DialogView.Builder setType(DialogType type) {
            this.type = type;
            return this;
        }

        public DialogView.Builder setTile(String title) {
            this.title = title;
            return this;
        }

        public DialogView.Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public DialogView.Builder setCancelAble(boolean cancelAble) {
            this.cancelAble = cancelAble;
            return this;
        }

        public DialogView.Builder setHint1(String hint1) {
            this.hint1 = hint1;
            return this;
        }

        public DialogView.Builder setHint2(String hint2) {
            this.hint2 = hint2;
            return this;
        }

        public DialogView.Builder setLeftBtnText(String btnText) {
            this.leftBtnText = btnText;
            return this;
        }

        public DialogView.Builder setMiddleBtnText(String btnText) {
            this.middlBtnText = btnText;
            return this;
        }

        public DialogView.Builder setRightBtnText(String btnText) {
            this.rightBtnText = btnText;
            return this;
        }

        public DialogView.Builder setConfirmText(String confirmText) {
            this.confirmText = confirmText;
            return this;
        }

        public DialogView.Builder setCancelText(String cancelText) {
            this.cancelText = cancelText;
            return this;
        }

        public DialogView.Builder setListener(DialogListener listener) {
            this.listener = listener;
            return this;
        }

        public DialogView build() {
            return new DialogView(this);
        }
    }
}