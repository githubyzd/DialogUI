package com.dialog.helper;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dialog.helper.customdialog.DialogHelper;
import com.dialog.helper.customdialog.DialogListener;

import java.util.ArrayList;
import java.util.List;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
    }

    public void system1(View view) {
        new AlertDialog.Builder(this)
                .setTitle("警告")
                .setMessage("您的手机即将爆炸，请马上扔掉！！！")
                .setIcon(android.R.drawable.sym_def_app_icon)
                .setCancelable(true)
                .setPositiveButton("扔掉", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "你傻啊，让你扔就扔", Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }

    public void system2(View view) {
        new AlertDialog.Builder(this)
                .setTitle("警告")
                .setMessage("您的手机即将爆炸，请马上扔掉！！！")
                .setIcon(android.R.drawable.sym_def_app_icon)
                .setCancelable(true)
                .setPositiveButton("扔掉", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "你傻啊，让你扔就扔", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("继续使用", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "手机即将爆炸", Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }

    public void system3(View view) {
        new AlertDialog.Builder(this)
                .setTitle("警告")
                .setMessage("您的手机即将爆炸，请马上扔掉！！！")
                .setIcon(android.R.drawable.sym_def_app_icon)
                .setCancelable(true)
                .setPositiveButton("扔掉", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "你傻啊，让你扔就扔", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("继续使用", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "手机即将爆炸", Toast.LENGTH_LONG).show();
                    }
                })
                .setNeutralButton("稍后提醒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "2分钟后提醒", Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }

    public void systemList(View view) {
        final String[] items = {"类型1", "类型2", "类型3", "类型4", "类型5"};
        new AlertDialog.Builder(this)
                .setTitle("请选择你喜欢的类型")
                .setIcon(android.R.drawable.sym_def_app_icon)
                .setCancelable(true)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, items[which], Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }

    int choice = -1;

    public void systemSingle(View view) {
        final String[] items = {"类型1", "类型2", "类型3", "类型4", "类型5"};
        new AlertDialog.Builder(this)
                .setTitle("单选框")
                .setIcon(android.R.drawable.sym_def_app_icon)
                .setCancelable(true)
                .setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choice = which;
                        Toast.makeText(DialogActivity.this, "你选择了" + items[which], Toast.LENGTH_LONG).show();
                    }
                })
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, items[choice], Toast.LENGTH_LONG).show();
                    }
                })
                .show();
    }

    List<Integer> choiceList = new ArrayList();

    public void systemMulti(View view) {
        final String[] items = {"类型1", "类型2", "类型3", "类型4", "类型5"};
        final boolean[] choices = {false, false, false, false, false};
        new AlertDialog.Builder(this)
                .setTitle("多选框")
                .setIcon(android.R.drawable.sym_def_app_icon)
                .setCancelable(true)
                .setMultiChoiceItems(items, choices, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            choiceList.add(which);
                        } else {
                            choiceList.remove(which);
                        }
                    }
                })
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int size = choiceList.size();
                        String str = "";
                        for (int i = 0; i < size; i++) {
                            str += items[choiceList.get(i)] + " ";
                        }
                        Toast.makeText(DialogActivity.this,
                                "你选中了" + str,
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    public void systemProgress(View view) {
        ProgressDialog waitingDialog = new ProgressDialog(this);
        waitingDialog.setTitle("我是一个等待Dialog");
        waitingDialog.setMessage("等待中...");
        waitingDialog.setIndeterminate(true);
        waitingDialog.setCancelable(true);
        waitingDialog.show();
    }

    public void systemProgressbar(View view) {
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog =
                new ProgressDialog(this);
        progressDialog.setProgress(0);
        progressDialog.setTitle("我是一个进度条Dialog");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.show();
    /* 模拟进度增加的过程
     * 新开一个线程，每个100ms，进度增加1
     */
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(100);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 进度达到最大值后，窗口消失
                progressDialog.cancel();
            }
        }).start();
    }

    public void systemEdit(View view) {
        final EditText editText = new EditText(this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(this);
        inputDialog.setTitle("我是一个输入Dialog").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this,
                                editText.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }


    public void customAlert1(View view) {
        DialogHelper.showAlertOneBtn(this, true, "标题", "少年努力，老大徒伤悲！！！", "确定", new DialogListener() {
            @Override
            public void onPositive() {
                Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void customAlert2(View view) {
        DialogHelper.showAlertTwoBtn(this, true, "标题", "少年努力，老大徒伤悲！！！", "确定", "取消", new DialogListener() {
            @Override
            public void onPositive() {
                Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegative() {
                Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void customAlert3(View view) {
        DialogHelper.showAlertThreeBtn(this, true, "标题", "少年努力，老大徒伤悲！！！", "确定", "稍后提醒", "取消", new DialogListener() {
            @Override
            public void onPositive() {
                Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNegative() {
                Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNeutral() {
                Toast.makeText(DialogActivity.this, "稍后提醒", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void customEdit(View view) {
        DialogHelper.showAlertEdit(this, true, "登录", "请输入用户名", "请输入密码", "登录", "取消", new DialogListener() {
            @Override
            public void onGetInput(CharSequence input1, CharSequence input2) {
                Toast.makeText(DialogActivity.this, "input1:" + input1 + "   input2:" + input2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanges(CharSequence input1, CharSequence input2) {
                Toast.makeText(DialogActivity.this, "input1:" + input1 + "   input2:" + input2, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancle() {
                Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loading(View view){
        DialogHelper.showLoading(this,"加载中...",true,true,false);
    }

}
