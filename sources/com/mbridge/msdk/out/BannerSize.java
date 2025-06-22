package com.mbridge.msdk.out;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.ab;

public class BannerSize {
    public static final int DEV_SET_TYPE = 5;
    public static final int LARGE_TYPE = 1;
    public static final int MEDIUM_TYPE = 2;
    public static final int SMART_TYPE = 3;
    public static final int STANDARD_TYPE = 4;
    private int height;
    private int width;

    public BannerSize(int i4, int i5, int i6) {
        if (i4 == 1) {
            this.height = 90;
            this.width = 320;
        } else if (i4 == 2) {
            this.height = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
            this.width = MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION;
        } else if (i4 == 3) {
            setSmartMode();
        } else if (i4 == 4) {
            this.height = 50;
            this.width = 320;
        } else if (i4 == 5) {
            this.height = i6;
            this.width = i5;
        }
    }

    private void setSmartMode() {
        if (ab.h(c.m().c()) < 720) {
            this.height = 50;
            this.width = 320;
            return;
        }
        this.height = 90;
        this.width = 728;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
