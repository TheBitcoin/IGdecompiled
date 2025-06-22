package com.uptodown.activities;

import R2.n;
import V2.d;
import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.squareup.picasso.s;
import d3.p;
import g2.C2050h;
import g2.L;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C1001s0;
import o3.Y;
import org.json.JSONArray;
import org.json.JSONObject;
import r3.I;
import r3.K;
import r3.t;
import u2.E;

public final class J extends ViewModel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final t f17720a;

    /* renamed from: b  reason: collision with root package name */
    private final I f17721b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17722c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList f17723a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f17724b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f17725c;

        public a(ArrayList arrayList, boolean z4, boolean z5) {
            m.e(arrayList, "searchResults");
            this.f17723a = arrayList;
            this.f17724b = z4;
            this.f17725c = z5;
        }

        public final boolean a() {
            return this.f17724b;
        }

        public final boolean b() {
            return this.f17725c;
        }

        public final ArrayList c() {
            return this.f17723a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.f17723a, aVar.f17723a) && this.f17724b == aVar.f17724b && this.f17725c == aVar.f17725c;
        }

        public int hashCode() {
            return (((this.f17723a.hashCode() * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f17724b)) * 31) + androidx.privacysandbox.ads.adservices.adid.a.a(this.f17725c);
        }

        public String toString() {
            return "SearchData(searchResults=" + this.f17723a + ", firstRequest=" + this.f17724b + ", hasMoreResults=" + this.f17725c + ')';
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f17726a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ J f17727b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f17728c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f17729d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f17730e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(J j4, Context context, String str, int i4, d dVar) {
            super(2, dVar);
            this.f17727b = j4;
            this.f17728c = context;
            this.f17729d = str;
            this.f17730e = i4;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f17727b, this.f17728c, this.f17729d, this.f17730e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            W2.b.c();
            if (this.f17726a == 0) {
                n.b(obj);
                this.f17727b.f17720a.setValue(E.a.f21883a);
                ArrayList arrayList = new ArrayList();
                L Z02 = new u2.L(this.f17728c).Z0(this.f17729d, 30, this.f17730e);
                boolean z4 = false;
                boolean z5 = true;
                if (!Z02.b() && Z02.e() != null) {
                    JSONObject e5 = Z02.e();
                    m.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("results");
                        if (e5.optInt("success") == 1 && optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i4 = 0; i4 < length; i4++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                                C2050h.b bVar = C2050h.f20600F0;
                                m.b(optJSONObject2);
                                C2050h b5 = C2050h.b.b(bVar, optJSONObject2, (Context) null, 2, (Object) null);
                                arrayList.add(b5);
                                s.h().l(b5.F()).d();
                            }
                        }
                    }
                }
                if (this.f17730e <= 0) {
                    z4 = true;
                } else if (arrayList.size() < 29) {
                    z5 = false;
                }
                this.f17727b.f17720a.setValue(new E.c(new a(arrayList, z4, z5)));
                return R2.s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(o3.J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(R2.s.f8222a);
        }
    }

    public J() {
        t a5 = K.a(E.b.f21884a);
        this.f17720a = a5;
        this.f17721b = a5;
    }

    public final void b(Context context, String str, int i4) {
        m.e(context, "context");
        m.e(str, "textToSearch");
        C1001s0 unused = C0981i.d(ViewModelKt.getViewModelScope(this), Y.b(), (o3.L) null, new b(this, context, str, i4, (d) null), 2, (Object) null);
    }

    public final I c() {
        return this.f17721b;
    }

    public final boolean d() {
        return this.f17722c;
    }

    public final void e(boolean z4) {
        this.f17722c = z4;
    }
}
