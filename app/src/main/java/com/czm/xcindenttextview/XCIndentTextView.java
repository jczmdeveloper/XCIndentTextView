package com.czm.xcindenttextview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by caizhiming on 2016/4/21.
 * 首行缩进TextView,支持自定义缩进宽度以及样式
 */
public class XCIndentTextView extends FrameLayout{
    private Context mContext;
    public TextView mTextView;
    public TextView mIndentView;

    private int mPadding = PhoneUtil.dip2px(getContext(),8);
    private int mIndentLineHeight;

    private LayoutParams mLpIndentView;

    public XCIndentTextView(Context context) {
        this(context, null);
    }
    public XCIndentTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public XCIndentTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        //add TextView
        mTextView = new TextView(context,attrs,defStyleAttr);
        addView(mTextView);
        setTextSize(17);
        //add IndentView
        mIndentView = new TextView(context,attrs,defStyleAttr);
        addView(mIndentView);
        mLpIndentView = (LayoutParams) mIndentView.getLayoutParams();
        mLpIndentView.width = 0;
        mLpIndentView.topMargin = PhoneUtil.dip2px(mContext,2);
        setIndentTextColor(Color.WHITE);
        mIndentView.setGravity(Gravity.CENTER);
        setIndentTextSize(13);
        setIndentLayoutParams();
    }
    public void setIndentLayoutParams(){
        mLpIndentView.width = 0;
        mLpIndentView.height = getIndentLineHeight();
    }
    public void updateIndentViewWidth(String text){
        mLpIndentView.width = getIndentLineWidth(text);
        mIndentView.requestLayout();
    }
    //======set TextView attribute=====
    public void setText(final String s){
        SpannableString ssResult = getSpannableString(s,mIndentView.getLayoutParams().width + PhoneUtil.dip2px(mContext,8));
        mTextView.setText(ssResult);
    }
    public static SpannableString getSpannableString(String result,int indentWidth){
        SpannableString ss = new SpannableString(result);
        ss.setSpan(new LeadingMarginSpan.Standard(indentWidth, 0), 0, ss.length(), 0);
        return ss;
    }
    public void setTextColor(int color){
        mTextView.setTextColor(color);
    }
    public void setTextSize(float size){
        mTextView.setTextSize(size);
    }
    //=======set IndentView attribute====
    public void setIndentText(String s){
        mIndentView.setText(s);
        mIndentView.setGravity(Gravity.CENTER);
        updateIndentViewWidth(s);

    }
    public void setIndentTextColor(int color){
        mIndentView.setTextColor(color);
    }
    public void setIndentTextSize(float size){
        mIndentView.setTextSize(size);
    }
    public void setIndentBackground(Drawable drawable){
        mIndentView.setBackgroundColor(Color.TRANSPARENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mIndentView.setBackground(drawable);
        }else{
            mIndentView.setBackgroundDrawable(drawable);
        }
    }

    public int getIndentLineHeight(){
        if(mIndentLineHeight <= 0){
            mIndentLineHeight = PhoneUtil.dip2px(mContext,18);
        }
        return mIndentLineHeight;
    }

    public int getIndentLineWidth(String text){
        int indentWidth = (int) mIndentView.getPaint().measureText(text);
        indentWidth += mPadding*2;
        return indentWidth;
    }
    public int getLineHeight(TextView textView){
        int lineHeight = 0;
        if(lineHeight <= 0){
            Rect rect = new Rect();
            textView.getLineBounds(0,rect);
            lineHeight = rect.height();
        }
        return lineHeight;
    }
    public int getFontHeight(Paint paint){
        int fontHeight = 0;
        if(fontHeight <= 0){
            Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
            fontHeight = fontMetrics.bottom-fontMetrics.top;
        }
        return fontHeight;
    }
}
