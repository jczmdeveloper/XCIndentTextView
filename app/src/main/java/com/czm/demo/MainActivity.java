package com.czm.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.czm.xcindenttextview.ColorUtil;
import com.czm.xcindenttextview.PhoneUtil;
import com.czm.xcindenttextview.R;
import com.czm.xcindenttextview.XCIndentTextView;

public class MainActivity extends AppCompatActivity {

    XCIndentTextView mIndentView;
    XCIndentTextView mIndentView2;
    XCIndentTextView mIndentView3;
    XCIndentTextView mIndentView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIndentView = (XCIndentTextView) findViewById(R.id.indentview);
        mIndentView.setIndentText("投资理财");
        mIndentView.setText("如何处理好投资的产品，管理好自己的财产？");
        mIndentView.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(),16),Color.RED));


        mIndentView2 = (XCIndentTextView) findViewById(R.id.indentview2);
        mIndentView2.setIndentText("明星");
        mIndentView2.setText("我最喜欢科比了，看着他退役，好伤心，好难过，学习他的优点");
        mIndentView2.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(),16),Color.BLUE));

        mIndentView3 = (XCIndentTextView) findViewById(R.id.indentview3);
        mIndentView3.setIndentText("星座");
        mIndentView3.setText("我是双子座，大家觉得双子座的如何，各抒己见吧");
        mIndentView3.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(),16),Color.MAGENTA));

        mIndentView4 = (XCIndentTextView) findViewById(R.id.indentview4);
        mIndentView4.setIndentText("今晚打老虎");
        mIndentView4.setText("谷歌发布全新Android Studio 2.0，模拟器3倍速！支持Instant Run ！");
        mIndentView4.setIndentBackground(ColorUtil.createRoundRectShape(PhoneUtil.dip2px(getApplicationContext(),16),Color.MAGENTA));
    }
}
