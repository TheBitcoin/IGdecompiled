package com.google.firebase.iid;

import I.C0294a;
import I.C0295b;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.messaging.C1800n;
import com.google.firebase.messaging.H;
import java.util.concurrent.ExecutionException;
import k0.C0940o;

public final class FirebaseInstanceIdReceiver extends C0295b {
    private static Intent f(Context context, String str, Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    /* access modifiers changed from: protected */
    public int b(Context context, C0294a aVar) {
        try {
            return ((Integer) C0940o.a(new C1800n(context).g(aVar.c()))).intValue();
        } catch (InterruptedException | ExecutionException e5) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e5);
            return 500;
        }
    }

    /* access modifiers changed from: protected */
    public void c(Context context, Bundle bundle) {
        Intent f4 = f(context, "com.google.firebase.messaging.NOTIFICATION_DISMISS", bundle);
        if (H.D(f4)) {
            H.v(f4);
        }
    }
}
