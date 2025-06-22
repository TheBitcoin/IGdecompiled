package androidx.constraintlayout.motion.widget;

import android.view.View;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewTransition f834a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View[] f835b;

    public /* synthetic */ a(ViewTransition viewTransition, View[] viewArr) {
        this.f834a = viewTransition;
        this.f835b = viewArr;
    }

    public final void run() {
        ViewTransition.a(this.f834a, this.f835b);
    }
}
