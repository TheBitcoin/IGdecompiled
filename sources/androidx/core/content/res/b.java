package androidx.core.content.res;

import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f850a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f851b;

    public /* synthetic */ b(ResourcesCompat.FontCallback fontCallback, int i4) {
        this.f850a = fontCallback;
        this.f851b = i4;
    }

    public final void run() {
        this.f850a.onFontRetrievalFailed(this.f851b);
    }
}
