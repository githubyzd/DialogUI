package com.dialog.helper.customdialog;

import android.print.PrintAttributes;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dialog.helper.R;

/**
 * Created by yzd on 2017/9/7 0007.
 */

public class ViewHolder {
    public View rootView;
    protected TextView tvTitle;
    public TextView tvMsg;
    public EditText et1;
    public EditText et2;
    protected View line;
    protected Button btn1;
    protected View lineBtn2;
    protected Button btn2;
    protected View lineBtn3;
    protected Button btn3;
    protected LinearLayout llContainerHorizontal;
    protected Button btn1Vertical;
    protected View lineBtn2Vertical;
    protected Button btn2Vertical;
    protected View lineBtn3Vertical;
    protected Button btn3Vertical;
    protected LinearLayout llContainerVertical;
    private DialogBean bean;
    private DialogListener listener;

    public ViewHolder(DialogBean bean) {
        this.bean = bean;
        listener = bean.getListener();
        rootView = View.inflate(bean.getContext(), setLayoutRes(), null);
        findViews();
    }

    protected void findViews() {
        tvTitle = (TextView) rootView.findViewById(R.id.dialogui_tv_title);
        tvMsg = (TextView) rootView.findViewById(R.id.dialogui_tv_msg);
        et1 = (EditText) rootView.findViewById(R.id.et_1);
        et2 = (EditText) rootView.findViewById(R.id.et_2);
        line = (View) rootView.findViewById(R.id.line);
        btn1 = (Button) rootView.findViewById(R.id.btn_1);
        lineBtn2 = (View) rootView.findViewById(R.id.line_btn2);
        btn2 = (Button) rootView.findViewById(R.id.btn_2);
        lineBtn3 = (View) rootView.findViewById(R.id.line_btn3);
        btn3 = (Button) rootView.findViewById(R.id.btn_3);
        llContainerHorizontal = (LinearLayout) rootView.findViewById(R.id.ll_container_horizontal);
        btn1Vertical = (Button) rootView.findViewById(R.id.btn_1_vertical);
        lineBtn2Vertical = (View) rootView.findViewById(R.id.line_btn2_vertical);
        btn2Vertical = (Button) rootView.findViewById(R.id.btn_2_vertical);
        lineBtn3Vertical = (View) rootView.findViewById(R.id.line_btn3_vertical);
        btn3Vertical = (Button) rootView.findViewById(R.id.btn_3_vertical);
        llContainerVertical = (LinearLayout) rootView.findViewById(R.id.ll_container_vertical);

        initView();
    }


    protected int setLayoutRes() {
        int layoutRes = 0;
        switch (bean.getType()) {
            case TYPE_ALERT_ONEBTN:
            case TYPE_ALERT_TWOBTN:
            case TYPE_ALERT_THREEBTN:
            case TYPE_ALERT_EDIT:
                layoutRes = R.layout.dialogui_holder_alert;
                break;
            case TYPE_LIST_CENTER:
                layoutRes = R.layout.dialogui_holder_sheet;
                break;
        }
        return layoutRes;
    }


    public View assingDatasAndEvents() {
        switch (bean.getType()) {
            case TYPE_ALERT_ONEBTN:
            case TYPE_ALERT_TWOBTN:
            case TYPE_ALERT_THREEBTN:
                buildAlert();
                break;
            case TYPE_ALERT_EDIT:
                buildAlertEdit();
                break;
        }
        return rootView;
    }

    private void buildAlertEdit() {
        llContainerHorizontal.setVisibility(View.VISIBLE);

        if (bean.getTitle().isEmpty()) {
            tvTitle.setVisibility(View.GONE);
        } else {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(bean.getTitle());
        }

        et1.setVisibility(View.VISIBLE);
        if (!bean.getHint1().isEmpty()) {
            et1.setHint(bean.getHint1());
        }

        et2.setVisibility(View.VISIBLE);
        if (!bean.getHint2().isEmpty()) {
            et2.setHint(bean.getHint2());
        }

        btn1.setVisibility(View.VISIBLE);
        btn1.setText(bean.getConfirmText());
        btn3.setVisibility(View.VISIBLE);
        btn3.setText(bean.getCancelText());
        lineBtn3.setVisibility(View.VISIBLE);

        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (listener != null)
                    listener.onTextChanges(et1.getText(), et2.getText());
            }
        });

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (listener != null)
                    listener.onTextChanges(et1.getText(), et2.getText());
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogHelper.dismiss();
                if (listener != null)
                    listener.onGetInput(et1.getText(), et2.getText());
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogHelper.dismiss();
                if (listener != null)
                    listener.onCancle();
            }
        });
    }

    private void buildAlert() {
        llContainerHorizontal.setVisibility(View.VISIBLE);
        line.setVisibility(View.VISIBLE);
        if (bean.getTitle().isEmpty()) {
            tvTitle.setVisibility(View.GONE);
        } else {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(bean.getTitle());
        }

        if (bean.getMsg().isEmpty()) {
            tvMsg.setVisibility(View.GONE);
        } else {
            tvMsg.setVisibility(View.VISIBLE);
            tvMsg.setText(bean.getMsg());
        }

        if (bean.getType() == DialogType.TYPE_ALERT_ONEBTN) {
            btn2.setVisibility(View.VISIBLE);
            btn2.setText(bean.getMiddleBtnText());
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogHelper.dismiss();
                    if (listener != null)
                        listener.onPositive();
                }
            });
        }

        if (bean.getType() == DialogType.TYPE_ALERT_TWOBTN) {
            btn1.setVisibility(View.VISIBLE);
            lineBtn3.setVisibility(View.VISIBLE);
            btn1.setText(bean.getLeftBtnText());
            btn3.setVisibility(View.VISIBLE);
            btn3.setText(bean.getRightBtnText());
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogHelper.dismiss();
                    if (listener != null)
                        listener.onPositive();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogHelper.dismiss();
                    if (listener != null)
                        listener.onNegative();
                }
            });
        }

        if (bean.getType() == DialogType.TYPE_ALERT_THREEBTN) {
            lineBtn2.setVisibility(View.VISIBLE);
            lineBtn3.setVisibility(View.VISIBLE);
            btn1.setVisibility(View.VISIBLE);
            btn1.setText(bean.getLeftBtnText());
            btn2.setVisibility(View.VISIBLE);
            btn2.setText(bean.getMiddleBtnText());
            btn3.setVisibility(View.VISIBLE);
            btn3.setText(bean.getRightBtnText());
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogHelper.dismiss();
                    if (listener != null)
                        listener.onPositive();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogHelper.dismiss();
                    if (listener != null)
                        listener.onNeutral();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DialogHelper.dismiss();
                    if (listener != null)
                        listener.onNegative();
                }
            });
        }
    }

    private void initView() {
        tvTitle.setVisibility(View.GONE);
        tvMsg.setVisibility(View.GONE);
        et1.setVisibility(View.GONE);
        et2.setVisibility(View.GONE);
        line.setVisibility(View.GONE);
        lineBtn2.setVisibility(View.GONE);
        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        lineBtn3.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        llContainerHorizontal.setVisibility(View.GONE);
        btn1Vertical.setVisibility(View.GONE);
        lineBtn2Vertical.setVisibility(View.GONE);
        btn2Vertical.setVisibility(View.GONE);
        lineBtn3Vertical.setVisibility(View.GONE);
        btn3Vertical.setVisibility(View.GONE);
        llContainerVertical.setVisibility(View.GONE);
    }

}
