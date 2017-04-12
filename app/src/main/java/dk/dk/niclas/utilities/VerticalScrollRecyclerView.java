package dk.dk.niclas.utilities;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class VerticalScrollRecyclerView extends RecyclerView {

    private final String TAG = this.getClass().getName();


    public VerticalScrollRecyclerView(Context context) {
        super(context);
    }

    public VerticalScrollRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VerticalScrollRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    ViewConfiguration vc = ViewConfiguration.get(this.getContext());
    private int mTouchSlop = vc.getScaledTouchSlop();
    private boolean mIsScrolling;
    private float startY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        // Always handle the case of the touch gesture being complete.
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            // Release the scroll.
            mIsScrolling = false;
            startY = ev.getY();
            return super.onInterceptTouchEvent(ev); // Do not intercept touch event, let the child handle it
        }
        switch (action) {
            case MotionEvent.ACTION_MOVE: {
                Log.d(TAG, "Moving");
                if (mIsScrolling) {
                    // We're currently scrolling, so yes, intercept the
                    // touch event!
                    return true;
                }
                // If the user has dragged her finger horizontally more than
                // the touch slop, start the scroll

                final float yDiff = calculateDistanceY(ev.getY());
                Log.e("yDiff ", ""+yDiff);
                // Touch slop should be calculated using ViewConfiguration
                // constants.
                if (Math.abs(yDiff) > mTouchSlop) {
                    // Start scrolling!
                    Log.d(TAG, "Scrolling Vertically");
                    mIsScrolling = true;
                    return true;
                }
                break;
            }
        }
        return super.onInterceptTouchEvent(ev);
    }


    private float calculateDistanceY(float endY) {
        return startY - endY;
    }
}