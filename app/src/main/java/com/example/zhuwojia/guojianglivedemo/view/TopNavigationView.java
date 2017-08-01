package com.example.zhuwojia.guojianglivedemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zhuwojia.guojianglivedemo.R;

/**
 * author：shixinxin on 2017/7/12
 * version：v1.0
 */

public class TopNavigationView extends HorizontalScrollView {

private Context context;
    private String[] titles = new String[]{"关注", "热门", "最新", "颜值", "才艺", "情感"};
    private TextView currentView;
    private LinearLayout layout;
    private TopNaviagtionClickListener topNaviagtionClickListener;

    public TopNavigationView(Context context) {
        super(context);
        init(context);
    }

    public TopNavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TopNavigationView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(final Context context) {
        this.context = context;
        setHorizontalScrollBarEnabled(false);
        layout = new LinearLayout(context);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.gravity = Gravity.CENTER_VERTICAL;
        layout.setLayoutParams(params);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setGravity(Gravity.CENTER_VERTICAL);
        for (int i = 0; i < titles.length; i++) {

            final TextView view = new TextView(context);
            LayoutParams ll = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
            ll.gravity = Gravity.CENTER;
            view.setLayoutParams(ll);
            view.setText(titles[i]);
            view.setPadding(dip2px(context,15), 0, dip2px(context,15), 0);
            if (i == 1) {
                view.setTextColor(context.getResources().getColor(R.color.sx_white));
                view.setTextSize(sp2px(context,6));
                currentView = view;
            } else {
                view.setTextColor(context.getResources().getColor(R.color.sx_grey_AB));
                view.setTextSize(sp2px(context,5));
            }
            layout.addView(view);
            final int finalI = i;
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentView != null) {
                        currentView.setTextColor(context.getResources().getColor(R.color.sx_grey_AB));
                        currentView.setTextSize(sp2px(context,5));
                    }
                    view.setTextColor(context.getResources().getColor(R.color.sx_white));
                    view.setTextSize(sp2px(context,6));
                    currentView = view;
                    if(topNaviagtionClickListener!=null){
                        topNaviagtionClickListener.onClick(finalI);
                    }
                }
            });

        }
        addView(layout);
    }

    public void setCurrentPosition(int position) {
        TextView view = (TextView) layout.getChildAt(position);
        if (currentView != null) {
            currentView.setTextColor(getResources().getColor(R.color.sx_grey_AB));
            currentView.setTextSize(getResources().getDimension(R.dimen.sp_5));
        }
        view.setTextColor(getResources().getColor(R.color.sx_white));
        view.setTextSize(getResources().getDimension(R.dimen.sp_6));
        currentView = view;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(),dip2px(context,50));
    }

    public interface TopNaviagtionClickListener{
        public void onClick(int position);
    }

    public void setTopNaviagtionClickListener(TopNaviagtionClickListener topNaviagtionClickListener) {
        this.topNaviagtionClickListener = topNaviagtionClickListener;
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
