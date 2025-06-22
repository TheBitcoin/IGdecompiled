package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.tracker.network.toolbox.b;
import com.mbridge.msdk.tracker.network.toolbox.j;
import com.mbridge.msdk.tracker.network.toolbox.k;
import com.mbridge.msdk.tracker.network.toolbox.n;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15546a = "m";

    /* renamed from: b  reason: collision with root package name */
    private static volatile m f15547b;

    /* renamed from: c  reason: collision with root package name */
    private v f15548c;

    private m() {
    }

    public static m a() {
        if (f15547b == null) {
            synchronized (m.class) {
                try {
                    if (f15547b == null) {
                        f15547b = new m();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15547b;
    }

    public final v b() {
        if (this.f15548c == null) {
            v a5 = n.a(new b(new k()), (x) null, 10, new j());
            this.f15548c = a5;
            a5.a();
        }
        return this.f15548c;
    }
}
