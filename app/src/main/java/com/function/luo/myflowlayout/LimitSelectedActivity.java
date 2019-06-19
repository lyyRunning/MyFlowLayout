package com.function.luo.myflowlayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by luo on 2019/6/18.
 */

public class LimitSelectedActivity extends Activity {
    @BindView(R.id.tv_text1)
    TextView tvText1;
    @BindView(R.id.id_flowlayout)
    TagFlowLayout idFlowlayout;
    List<User> list;
    TagAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limit_choose);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        final LayoutInflater mInflater = LayoutInflater.from(this);

        list = new ArrayList<>();
        list.add(new User("Hello"));
        list.add(new User("Android"));
        list.add(new User("Weclome Hi "));
        list.add(new User("Button"));
        list.add(new User("TextView"));
        list.add(new User("Weclome Hello"));
        list.add(new User("Button Text"));
        list.add(new User("TextView"));
        list.add(new User("utton ImageView"));
        list.add(new User("Weclome"));
        list.add(new User("Hello"));
        list.add(new User("Weclome Hi "));
        list.add(new User("Button"));
        list.add(new User("TextView"));
        list.add(new User("Weclome Hello"));
        list.add(new User("Button Text"));
        list.add(new User("TextView"));
        list.add(new User("utton ImageView"));
        list.add(new User("Weclome"));
        list.add(new User("Hello"));
        list.add(new User("Weclome Hello"));
        /**
         * 选择三个标签
         */
        idFlowlayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {

                tvText1.setText(String.valueOf(selectPosSet));
                Toast.makeText(LimitSelectedActivity.this, "selectPosSet" + selectPosSet, Toast.LENGTH_SHORT).show();

            }
        });


        idFlowlayout.setAdapter(mAdapter = new TagAdapter<User>(list) {
            @Override
            public View getView(FlowLayout parent, int position, User user) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                        idFlowlayout, false);
                tv.setText(user.getName());
                return tv;
            }

        });
        //设置选中的按钮
        mAdapter.setSelectedList(3);

    }


    public static void launch(Context context) {
        Intent intent = new Intent(context, LimitSelectedActivity.class);
        context.startActivity(intent);
    }
}
