package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ResourcesCompat.FontCallback f848a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Typeface f849b;

    public /* synthetic */ a(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.f848a = fontCallback;
        this.f849b = typeface;
    }

    public final void run() {
        this.f848a.onFontRetrieved(this.f849b);
    }
}
