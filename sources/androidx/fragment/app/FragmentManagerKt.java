package androidx.fragment.app;

import d3.l;
import kotlin.jvm.internal.m;

public final class FragmentManagerKt {
    public static final void commit(FragmentManager fragmentManager, boolean z4, l lVar) {
        m.e(fragmentManager, "$this$commit");
        m.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        m.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void commit$default(FragmentManager fragmentManager, boolean z4, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = false;
        }
        m.e(fragmentManager, "$this$commit");
        m.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        m.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static final void commitNow(FragmentManager fragmentManager, boolean z4, l lVar) {
        m.e(fragmentManager, "$this$commitNow");
        m.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        m.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static /* synthetic */ void commitNow$default(FragmentManager fragmentManager, boolean z4, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = false;
        }
        m.e(fragmentManager, "$this$commitNow");
        m.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        m.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            beginTransaction.commitNowAllowingStateLoss();
        } else {
            beginTransaction.commitNow();
        }
    }

    public static final void transaction(FragmentManager fragmentManager, boolean z4, boolean z5, l lVar) {
        m.e(fragmentManager, "$this$transaction");
        m.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        m.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            if (z5) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z5) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }

    public static /* synthetic */ void transaction$default(FragmentManager fragmentManager, boolean z4, boolean z5, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = false;
        }
        if ((i4 & 2) != 0) {
            z5 = false;
        }
        m.e(fragmentManager, "$this$transaction");
        m.e(lVar, TtmlNode.TAG_BODY);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        m.d(beginTransaction, "beginTransaction()");
        lVar.invoke(beginTransaction);
        if (z4) {
            if (z5) {
                beginTransaction.commitNowAllowingStateLoss();
            } else {
                beginTransaction.commitNow();
            }
        } else if (z5) {
            beginTransaction.commitAllowingStateLoss();
        } else {
            beginTransaction.commit();
        }
    }
}
