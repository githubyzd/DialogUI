package com.dialog.helper.popupexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dialog.helper.R;
import com.dialog.helper.popupexample.popupview.PopuItem;
import com.dialog.helper.popupexample.popupview.PopupView;

public class PopupExampleActivity extends AppCompatActivity {
    private static final int ID_USER = 1;
    private static final int ID_GROUNP = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_example);

        final PopuItem userItem = new PopuItem(ID_USER, "用户", getResources().getDrawable(R.drawable.child_image));
        final PopuItem grounpItem = new PopuItem(ID_GROUNP, "群组", getResources().getDrawable(R.drawable.user_group));

        //use setSticky(true) to disable PopupWindowView dialog being dismissed after an item is clicked
        userItem.setSticky(true);


        //show on btn1
        Button btn1 = (Button) this.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PopupView.Builder(PopupExampleActivity.this)
                        .setAnchorView(v)
                        .addItem(userItem)
                        .addItem(grounpItem)
                        .setOrientation(PopupView.VERTICAL)
                        .setOnPopuItemClickListener(new PopupView.OnPopuItemClickListener() {
                            @Override
                            public void onItemClick(PopupView source, int pos, int actionId) {
                                PopuItem PopuItem = source.getPopuItem(pos);
                                //here we can filter which action item was clicked with pos or actionId parameter
                                if (actionId == ID_USER) {
                                    Toast.makeText(getApplicationContext(), "click user", Toast.LENGTH_SHORT).show();
                                } else if (actionId == ID_GROUNP) {
                                    Toast.makeText(getApplicationContext(), "click group", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), PopuItem.getTitle() + " selected", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setOnDismissListener(new PopupView.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                Toast.makeText(getApplicationContext(), "Dismissed", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();
            }
        });

        Button btn2 = (Button) this.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PopupView.Builder(PopupExampleActivity.this)
                        .setAnchorView(v)
                        .addItem(userItem)
                        .addItem(grounpItem)
                        .setOrientation(PopupView.VERTICAL)
                        .setOnPopuItemClickListener(new PopupView.OnPopuItemClickListener() {
                            @Override
                            public void onItemClick(PopupView source, int pos, int actionId) {
                                PopuItem PopuItem = source.getPopuItem(pos);
                                //here we can filter which action item was clicked with pos or actionId parameter
                                if (actionId == ID_USER) {
                                    Toast.makeText(getApplicationContext(), "click user", Toast.LENGTH_SHORT).show();
                                } else if (actionId == ID_GROUNP) {
                                    Toast.makeText(getApplicationContext(), "click group", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), PopuItem.getTitle() + " selected", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setOnDismissListener(new PopupView.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                Toast.makeText(getApplicationContext(), "Dismissed", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();
            }
        });

        Button btn3 = (Button) this.findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new PopupView.Builder(PopupExampleActivity.this)
                        .setAnchorView(v)
                        .addItem(userItem)
                        .addItem(grounpItem)
                        .setAnimStyle(PopupView.ANIM_REFLECT)
                        .setOrientation(PopupView.VERTICAL)
                        .setOnPopuItemClickListener(new PopupView.OnPopuItemClickListener() {
                            @Override
                            public void onItemClick(PopupView source, int pos, int actionId) {
                                PopuItem PopuItem = source.getPopuItem(pos);
                                //here we can filter which action item was clicked with pos or actionId parameter
                                if (actionId == ID_USER) {
                                    Toast.makeText(getApplicationContext(), "click user", Toast.LENGTH_SHORT).show();
                                } else if (actionId == ID_GROUNP) {
                                    Toast.makeText(getApplicationContext(), "click group", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), PopuItem.getTitle() + " selected", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setOnDismissListener(new PopupView.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                Toast.makeText(getApplicationContext(), "Dismissed", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build()
                        .show();
            }
        });
        Button btn4 = (Button) this.findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PopupExampleActivity.this, ListDemoActivity.class);
                PopupExampleActivity.this.startActivity(intent);
            }
        });
    }
}
