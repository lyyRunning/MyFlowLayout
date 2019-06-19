package com.function.luo.myflowlayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.abslistview.CommonAdapter;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by luo on 2019/6/18.
 */

public class ListViewActivity extends Activity {

    @BindView(R.id.id_listview)
    ListView listView;
    private List<List<String>> mDatas = new ArrayList<List<String>>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);
        initDatas();
        init();

    }

    private void init() {

        listView.setAdapter(new CommonAdapter<List<String>>(this, R.layout.item_for_listview, mDatas) {
            Map<Integer, Set<Integer>> selectedMap = new HashMap<Integer, Set<Integer>>();


            @Override
            public void convert(final ViewHolder viewHolder, List<String> strings) {
                TagFlowLayout tagFlowLayout = viewHolder.getView(R.id.id_tagflowlayout);

                TagAdapter<String> tagAdapter = new TagAdapter<String>(strings) {
                    @Override
                    public View getView(FlowLayout parent, int position, String o) {
                        //can use viewholder
                        TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                                parent, false);
                        tv.setText(o);
                        return tv;
                    }
                };
                tagFlowLayout.setAdapter(tagAdapter);
                //重置状态
                tagAdapter.setSelectedList(selectedMap.get(viewHolder.getItemPosition()));

                tagFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
                    @Override
                    public void onSelected(Set<Integer> selectPosSet) {
                        selectedMap.put(viewHolder.getItemPosition(), selectPosSet);
                        Toast.makeText(ListViewActivity.this, "selectPosSet" + selectPosSet, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }


    private void initDatas() {
        for (int i = 'A'; i < 'z'; i++) {
            List<String> itemData = new ArrayList<String>(5);
            for (int j = 0; j < 5; j++) {
                itemData.add((char) i + "");
            }
            mDatas.add(itemData);
        }
    }



    public static void launch(Context context) {
        Intent intent = new Intent(context, ListViewActivity.class);
        context.startActivity(intent);
    }
}
