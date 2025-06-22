package h2;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import d3.l;
import g2.C2060s;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: h2.f  reason: case insensitive filesystem */
public final class C2074f extends ResultReceiver {

    /* renamed from: b  reason: collision with root package name */
    public static final a f20845b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private final l f20846a;

    /* renamed from: h2.f$a */
    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2074f(Handler handler, l lVar) {
        super(handler);
        m.e(lVar, "callback");
        this.f20846a = lVar;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i4, Bundle bundle) {
        Parcelable parcelable;
        String w4;
        if (bundle != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) bundle.getParcelable("download", C2060s.class);
            } else {
                parcelable = bundle.getParcelable("download");
            }
            C2060s sVar = (C2060s) parcelable;
            if (sVar != null && (w4 = sVar.w()) != null && w4.length() != 0) {
                l lVar = this.f20846a;
                String w5 = sVar.w();
                m.b(w5);
                lVar.invoke(w5);
            }
        }
    }
}
