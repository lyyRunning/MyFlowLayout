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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by luo on 2019/6/18.
 * <p>
 * <p>
 * <p>
 * 以setAdapter形式注入数据
 * 直接设置selector为background即可完成标签选则的切换，类似CheckBox
 * 支持控制选择的Tag数量，比如：单选、多选
 * 支持setOnTagClickListener，当点击某个Tag回调
 * 支持setOnSelectListener，当选择某个Tag后回调
 * 支持adapter.notifyDataChanged
 * Activity重建（或者旋转）后，选择的状态自动保存
 * max_select：-1为不限制选择数量，>=1的数字为控制选择tag的数量
 */

public class SingleActivity extends Activity {

    @BindView(R.id.id_flowlayout)
    TagFlowLayout idFlowlayout;
    @BindView(R.id.tv_text1)
    TextView tvText1;


    private String[] mVals = new String[]
            {"Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single_choose);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        final LayoutInflater mInflater = LayoutInflater.from(this);




        /**
         * 点击某个 Tag 返回
         */
        idFlowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                String tag = mVals[position];
                tvText1.setText(tag);
                Toast.makeText(SingleActivity.this, "Clicked====" + tag, Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        idFlowlayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                        idFlowlayout, false);
                tv.setText(s);
                return tv;
            }

        });
    }

    public static void launch(Context context) {
        Intent intent = new Intent(context, SingleActivity.class);
        context.startActivity(intent);
    }
}
