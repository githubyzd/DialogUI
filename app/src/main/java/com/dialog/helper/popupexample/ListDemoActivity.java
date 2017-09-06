package com.dialog.helper.popupexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.dialog.helper.R;
import com.dialog.helper.popupexample.popupview.PopuItem;
import com.dialog.helper.popupexample.popupview.PopupView;

import java.util.ArrayList;
import java.util.List;

public class ListDemoActivity extends AppCompatActivity {
    /**
     * Listview selected row
     */
    private int mSelectedRow = 0;

    /**
     * Right arrow icon on each listview row
     */
    private ImageView mMoreIv = null;

    private static final int ID_USER = 1;
    private static final int ID_GROUP = 2;
    private List<PopuItem> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lise_demo);


        ListView mList = (ListView) findViewById(R.id.l_list);

        NewQAAdapter adapter = new NewQAAdapter(this);

        final String[] data = {"Test 01", "Test 02", "Test 03", "Test 04", "Test 05", "Test 06", "Test 07", "Test 08",
                "Test 09", "Test 10"};

        adapter.setData(data);
        mList.setAdapter(adapter);

        PopuItem addItem = new PopuItem(ID_USER, "user", getResources().getDrawable(R.drawable.child_image));
        PopuItem acceptItem = new PopuItem(ID_GROUP, "group", getResources().getDrawable(R.drawable.user_group));
        items.add(addItem);
        items.add(acceptItem);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectedRow = position; //set the selected row

                new PopupView.Builder(ListDemoActivity.this)
                        .setAnchorView(view)
                        .addItems(items)
                        .setOrientation(PopupView.VERTICAL)
                        .setOnPopuItemClickListener(new PopupView.OnPopuItemClickListener() {
                            @Override
                            public void onItemClick(PopupView source, int pos, int actionId) {
                                PopuItem PopuItem = source.getPopuItem(pos);

                                if (actionId == ID_USER) { //Add item selected
                                    Toast.makeText(getApplicationContext(), "Add item selected on row " + mSelectedRow, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), PopuItem.getTitle() + " item selected on row "
                                            + mSelectedRow, Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setOnDismissListener(new PopupView.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                mMoreIv.setImageResource(R.drawable.ic_list_more);
                            }
                        })
                        .build()
                        .show();

                //change the right arrow icon to selected state
                mMoreIv = (ImageView) view.findViewById(R.id.i_more);
                mMoreIv.setImageResource(R.drawable.ic_list_more_selected);
            }
        });
    }
}
