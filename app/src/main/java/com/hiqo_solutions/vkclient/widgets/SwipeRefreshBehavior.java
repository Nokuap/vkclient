package com.hiqo_solutions.vkclient.widgets;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dmitry.zheltko on 8/13/2015.
 */
public class SwipeRefreshBehavior extends CoordinatorLayout.Behavior<SwipeRefreshLayout> {
    public SwipeRefreshBehavior(Context context, AttributeSet attrs) {
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, SwipeRefreshLayout child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, SwipeRefreshLayout child, View dependency) {
        float translationY = Math.min(0, dependency.getTranslationY() - dependency.getHeight());
        child.setTranslationY(dependency.getHeight() + dependency.getY()); // y always negative for appBar
        return true;
    }
}
