package com.miao.singlechat;

import java.util.ArrayList;
import java.util.List;
import com.miao.main.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

public class HaoYouActivity extends Activity implements OnChildClickListener {

    private ExpandableListView mListView = null;
    private HaoYouExpandAdapter mAdapter = null;
    private List<List<HaoYouItem>> mData = new ArrayList<List<HaoYouItem>>();

    private int[] mGroupArrays = new int[] { 
    		R.array.haopengyou,
    		R.array.moshengren, 
    		R.array.mingxing };

    private int[] mDetailIds = new int[] { 
    		R.array.haopengyou_detail,
    		R.array.moshengren_detail, 
    		R.array.mingxing_detail };

    private int[][] mImageIds = new int[][] {
            { R.drawable.img_00, 
              R.drawable.img_01, 
              R.drawable.img_02 },
            { R.drawable.img_10, 
              R.drawable.img_11, 
              R.drawable.img_12,
              R.drawable.img_13, 
              R.drawable.img_14, 
              R.drawable.img_15,
              R.drawable.img_16 },
            { R.drawable.img_20,
              R.drawable.img_21 } };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        mListView = new ExpandableListView(this);
        mListView.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.FILL_PARENT));
        setContentView(mListView);
        
        mListView.setGroupIndicator(getResources().getDrawable(
                R.drawable.expander_floder));
        mAdapter = new HaoYouExpandAdapter(this, mData);
        mListView.setAdapter(mAdapter);
        mListView
                .setDescendantFocusability(ExpandableListView.FOCUS_AFTER_DESCENDANTS);
        mListView.setOnChildClickListener(this);
    }

    
    @Override
    public boolean onChildClick(ExpandableListView parent, View v,
            int groupPosition, int childPosition, long id) {
        // TODO Auto-generated method stub
        HaoYouItem item = mAdapter.getChild(groupPosition, childPosition);
        new AlertDialog.Builder(this)
                .setTitle(item.getName())
                .setMessage(item.getDetail())
                .setIcon(android.R.drawable.ic_menu_more)
                .setNegativeButton("添加进行对话",
                        new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                    int which) {
                                

                            }
                        }).create().show();
        return true;
    }

    private void initData() {
        for (int i = 0; i < mGroupArrays.length; i++) {
            List<HaoYouItem> list = new ArrayList<HaoYouItem>();
            String[] childs = getStringArray(mGroupArrays[i]);
            String[] details = getStringArray(mDetailIds[i]);
            for (int j = 0; j < childs.length; j++) {
                HaoYouItem item = new HaoYouItem(mImageIds[i][j], childs[j], details[j]);
                list.add(item);
            }
            mData.add(list);
        }
    }

    private String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

}