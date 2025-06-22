package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import d3.l;
import d3.p;
import j3.d;
import java.util.Iterator;
import l3.e;

public final class ViewGroupKt {
    public static final boolean contains(ViewGroup viewGroup, View view) {
        if (viewGroup.indexOfChild(view) != -1) {
            return true;
        }
        return false;
    }

    public static final void forEach(ViewGroup viewGroup, l lVar) {
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            lVar.invoke(viewGroup.getChildAt(i4));
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, p pVar) {
        int childCount = viewGroup.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            pVar.invoke(Integer.valueOf(i4), viewGroup.getChildAt(i4));
        }
    }

    public static final View get(ViewGroup viewGroup, int i4) {
        View childAt = viewGroup.getChildAt(i4);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException("Index: " + i4 + ", Size: " + viewGroup.getChildCount());
    }

    public static final e getChildren(ViewGroup viewGroup) {
        return new ViewGroupKt$children$1(viewGroup);
    }

    public static final e getDescendants(ViewGroup viewGroup) {
        return new ViewGroupKt$special$$inlined$Sequence$1(viewGroup);
    }

    public static final d getIndices(ViewGroup viewGroup) {
        return j3.e.i(0, viewGroup.getChildCount());
    }

    public static final int getSize(ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() == 0) {
            return true;
        }
        return false;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        if (viewGroup.getChildCount() != 0) {
            return true;
        }
        return false;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i4) {
        marginLayoutParams.setMargins(i4, i4, i4, i4);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        marginLayoutParams.setMargins(i4, i5, i6, i7);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = marginLayoutParams.leftMargin;
        }
        if ((i8 & 2) != 0) {
            i5 = marginLayoutParams.topMargin;
        }
        if ((i8 & 4) != 0) {
            i6 = marginLayoutParams.rightMargin;
        }
        if ((i8 & 8) != 0) {
            i7 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i4, i5, i6, i7);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i4, @Px int i5, @Px int i6, @Px int i7) {
        marginLayoutParams.setMarginStart(i4);
        marginLayoutParams.topMargin = i5;
        marginLayoutParams.setMarginEnd(i6);
        marginLayoutParams.bottomMargin = i7;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i4 = marginLayoutParams.getMarginStart();
        }
        if ((i8 & 2) != 0) {
            i5 = marginLayoutParams.topMargin;
        }
        if ((i8 & 4) != 0) {
            i6 = marginLayoutParams.getMarginEnd();
        }
        if ((i8 & 8) != 0) {
            i7 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i4);
        marginLayoutParams.topMargin = i5;
        marginLayoutParams.setMarginEnd(i6);
        marginLayoutParams.bottomMargin = i7;
    }
}
