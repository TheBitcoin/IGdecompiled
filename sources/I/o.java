package I;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;
import k0.C0937l;
import k0.C0940o;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f265a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C0294a f266b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f267c;

    public /* synthetic */ o(Context context, C0294a aVar, CountDownLatch countDownLatch) {
        this.f265a = context;
        this.f266b = aVar;
        this.f267c = countDownLatch;
    }

    public final void run() {
        C0937l lVar;
        C0294a aVar = this.f266b;
        if (TextUtils.isEmpty(aVar.g())) {
            lVar = C0940o.e((Object) null);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("google.message_id", aVar.g());
            Integer h4 = aVar.h();
            if (h4 != null) {
                bundle.putInt("google.product_id", h4.intValue());
            }
            Context context = this.f265a;
            bundle.putBoolean("supports_message_handled", true);
            lVar = D.b(context).c(2, bundle);
        }
        lVar.b(m.f263a, new n(this.f267c));
    }
}
