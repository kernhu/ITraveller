package cn.com.mutual.traveller.tools;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Kern on 2016/9/8.
 * <p/>
 * 一个可以启用和禁用滑动的ViewPager
 */
public class NimbleViewPager extends ViewPager {

    private boolean scrollble = true;

    public NimbleViewPager(Context context) {
        super(context);
    }

    public NimbleViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!scrollble) {
            return true;
        }
        return super.onTouchEvent(ev);
    }

    public boolean isScrollble() {
        return scrollble;
    }

    /**
     * @param scrollble 是否可以滑动ViewPager
     */
    public void setScrollble(boolean scrollble) {
        this.scrollble = scrollble;
    }
}
