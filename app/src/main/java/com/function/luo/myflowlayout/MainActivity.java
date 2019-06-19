package com.function.luo.myflowlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                //单个选择
                SingleActivity.launch(this);
                break;
            case R.id.btn2:
                //三个选择
                MultipleSelectionActivity.launch(this);
                break;
            case R.id.btn3:
                //多选选择
                LimitSelectedActivity.launch(this);
                break;
            case R.id.btn4:
                //滑动选择
                ScrollViewActivity.launch(this);
                break;
            case R.id.btn5:
                //listView选择
                ListViewActivity.launch(this);

                break;
            case R.id.btn6:
                //对齐方式
                GravityActivity.launch(this);
                break;
            default:
        }
    }
}
