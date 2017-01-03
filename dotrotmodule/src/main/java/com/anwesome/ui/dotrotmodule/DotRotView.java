package com.anwesome.ui.dotrotmodule;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by anweshmishra on 03/01/17.
 */
public class DotRotView extends View {
    private boolean clicked = false;
    private OnClickListener onClickListener;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public DotRotView(Context context) {
        super(context);
    }
    public DotRotView(Context context, AttributeSet attrs) {
        super(context,attrs);
    }
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        int w = canvas.getWidth(),h = canvas.getHeight();
        int radius = w/4;
        if(h<w) {
            radius = h/4;
        }
        paint.setColor(Color.parseColor("#f44336"));
        paint.setStyle(Paint.Style.STROKE);
        if(clicked) {
            paint.setStyle(Paint.Style.FILL);
        }
        canvas.drawCircle(w/2,h/2,radius,paint);
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()  == MotionEvent.ACTION_DOWN) {
            clicked = true;
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,360);
            valueAnimator.setDuration(AppConstants.GAME_DELAY);
            valueAnimator.addUpdateListener(new AnimationUpdateAdapter());
            valueAnimator.addListener(new AnimationAdapter());
            valueAnimator.start();
            postInvalidate();
        }
        return true;
    }
    private class AnimationUpdateAdapter implements ValueAnimator.AnimatorUpdateListener {
        public void onAnimationUpdate(ValueAnimator animator) {
            setRotation((float)animator.getAnimatedValue());
        }
    }
    private class AnimationAdapter implements Animator.AnimatorListener {
        public void onAnimationEnd(Animator animator) {
            clicked = false;
            if(onClickListener!=null) {
                onClickListener.onClick(DotRotView.this);
            }
            postInvalidate();
        }
        public void onAnimationStart(Animator animator) {

        }
        public void onAnimationRepeat(Animator animator) {

        }
        public void onAnimationCancel(Animator animator) {

        }


    }
}
