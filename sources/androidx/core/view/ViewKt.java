package androidx.core.view;

import V2.d;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.exifinterface.media.ExifInterface;
import d3.a;
import d3.l;
import kotlin.jvm.internal.m;
import l3.e;
import l3.h;

public final class ViewKt {
    public static final void doOnAttach(View view, l lVar) {
        if (view.isAttachedToWindow()) {
            lVar.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnAttach$1(view, lVar));
        }
    }

    public static final void doOnDetach(View view, l lVar) {
        if (!view.isAttachedToWindow()) {
            lVar.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new ViewKt$doOnDetach$1(view, lVar));
        }
    }

    public static final void doOnLayout(View view, l lVar) {
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new ViewKt$doOnLayout$$inlined$doOnNextLayout$1(lVar));
        } else {
            lVar.invoke(view);
        }
    }

    public static final void doOnNextLayout(View view, l lVar) {
        view.addOnLayoutChangeListener(new ViewKt$doOnNextLayout$1(lVar));
    }

    public static final OneShotPreDrawListener doOnPreDraw(View view, l lVar) {
        return OneShotPreDrawListener.add(view, new ViewKt$doOnPreDraw$1(lVar, view));
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        if (view.isLaidOut()) {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate(-((float) view.getScrollX()), -((float) view.getScrollY()));
            view.draw(canvas);
            return createBitmap;
        }
        throw new IllegalStateException("View needs to be laid out before calling drawToBitmap()");
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final e getAllViews(View view) {
        return h.b(new ViewKt$allViews$1(view, (d) null));
    }

    public static final e getAncestors(View view) {
        return h.f(view.getParent(), ViewKt$ancestors$1.INSTANCE);
    }

    public static final int getMarginBottom(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart();
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(View view) {
        if (view.getVisibility() == 8) {
            return true;
        }
        return false;
    }

    public static final boolean isInvisible(View view) {
        if (view.getVisibility() == 4) {
            return true;
        }
        return false;
    }

    public static final boolean isVisible(View view) {
        if (view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public static final Runnable postDelayed(View view, long j4, a aVar) {
        ViewKt$postDelayed$runnable$1 viewKt$postDelayed$runnable$1 = new ViewKt$postDelayed$runnable$1(aVar);
        view.postDelayed(viewKt$postDelayed$runnable$1, j4);
        return viewKt$postDelayed$runnable$1;
    }

    public static final Runnable postOnAnimationDelayed(View view, long j4, a aVar) {
        L l4 = new L(aVar);
        view.postOnAnimationDelayed(l4, j4);
        return l4;
    }

    /* access modifiers changed from: private */
    public static final void postOnAnimationDelayed$lambda$1(a aVar) {
        aVar.invoke();
    }

    public static final void setGone(View view, boolean z4) {
        int i4;
        if (z4) {
            i4 = 8;
        } else {
            i4 = 0;
        }
        view.setVisibility(i4);
    }

    public static final void setInvisible(View view, boolean z4) {
        int i4;
        if (z4) {
            i4 = 4;
        } else {
            i4 = 0;
        }
        view.setVisibility(i4);
    }

    public static final void setPadding(View view, @Px int i4) {
        view.setPadding(i4, i4, i4, i4);
    }

    public static final void setVisible(View view, boolean z4) {
        int i4;
        if (z4) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        view.setVisibility(i4);
    }

    public static final void updateLayoutParams(View view, l lVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            lVar.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public static final /* synthetic */ <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, l lVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        m.j(1, ExifInterface.GPS_DIRECTION_TRUE);
        lVar.invoke(layoutParams);
        view.setLayoutParams(layoutParams);
    }

    public static final void updatePadding(View view, @Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        view.setPadding(i4, i5, i6, i7);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = view.getPaddingLeft();
        }
        if ((i8 & 2) != 0) {
            i5 = view.getPaddingTop();
        }
        if ((i8 & 4) != 0) {
            i6 = view.getPaddingRight();
        }
        if ((i8 & 8) != 0) {
            i7 = view.getPaddingBottom();
        }
        view.setPadding(i4, i5, i6, i7);
    }

    public static final void updatePaddingRelative(View view, @Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        view.setPaddingRelative(i4, i5, i6, i7);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = view.getPaddingStart();
        }
        if ((i8 & 2) != 0) {
            i5 = view.getPaddingTop();
        }
        if ((i8 & 4) != 0) {
            i6 = view.getPaddingEnd();
        }
        if ((i8 & 8) != 0) {
            i7 = view.getPaddingBottom();
        }
        view.setPaddingRelative(i4, i5, i6, i7);
    }
}
