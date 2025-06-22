package l2;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

/* renamed from: l2.e  reason: case insensitive filesystem */
public final class C2125e {

    /* renamed from: b  reason: collision with root package name */
    public static final a f21021b = new a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f21022a;

    /* renamed from: l2.e$a */
    public static final class a {
        public a(C2103g gVar) {
        }
    }

    public C2125e(Context context) {
        m.e(context, "context");
        this.f21022a = context;
    }

    public final long a() {
        try {
            return this.f21022a.getSharedPreferences("sp_uptodown_services", 0).getLong("versioncode_registered", -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    public final void b(long j4) {
        try {
            SharedPreferences.Editor edit = this.f21022a.getSharedPreferences("sp_uptodown_services", 0).edit();
            edit.putLong("versioncode_registered", j4);
            edit.apply();
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
