package h2;

import N1.k;
import R2.n;
import R2.s;
import V2.d;
import V2.g;
import W2.b;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvMyAppsActivity;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;
import u2.I;

/* renamed from: h2.j  reason: case insensitive filesystem */
public final class C2078j extends ResultReceiver {

    /* renamed from: h2.j$a */
    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f20858a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f20859b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Activity activity, d dVar) {
            super(2, dVar);
            this.f20859b = activity;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f20859b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            b.c();
            if (this.f20858a == 0) {
                n.b(obj);
                ((MyApps) this.f20859b).p5(false);
                return s.f8222a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    public C2078j(Handler handler) {
        super(handler);
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i4, Bundle bundle) {
        Boolean bool;
        if (i4 == 602) {
            I.f21896a.b();
            return;
        }
        k.a aVar = k.f7778g;
        if (aVar.g() != null) {
            Activity g4 = aVar.g();
            Integer num = null;
            if (g4 instanceof Updates) {
                if (i4 == 600) {
                    ((Updates) g4).P5();
                } else if (i4 == 601) {
                    if (bundle != null) {
                        bool = Boolean.valueOf(bundle.getBoolean("newUpdatesAvailable"));
                    } else {
                        bool = null;
                    }
                    if (bundle != null) {
                        num = Integer.valueOf(bundle.getInt("newUpdatesAvailableCount"));
                    }
                    ((Updates) g4).O5(bool, num);
                }
            } else if (g4 instanceof MyApps) {
                if (i4 == 601) {
                    C1001s0 unused = C0981i.d(K.a(Y.c()), (g) null, (L) null, new a(g4, (d) null), 3, (Object) null);
                }
            } else if (g4 instanceof SecurityActivity) {
                if (i4 == 601) {
                    ((SecurityActivity) g4).k5();
                }
            } else if (g4 instanceof TvMyAppsActivity) {
                if (i4 == 601) {
                    TvMyAppsActivity tvMyAppsActivity = (TvMyAppsActivity) g4;
                    tvMyAppsActivity.runOnUiThread(new TvMyAppsActivity.a());
                }
            } else if (g4 instanceof MainActivity) {
                if (i4 == 603) {
                    ((MainActivity) g4).c7();
                } else if (i4 == 604) {
                    MainActivity mainActivity = (MainActivity) g4;
                    mainActivity.runOnUiThread(new MainActivity.C1817a());
                }
            } else if (g4 instanceof AppDetailActivity) {
                if (i4 == 603) {
                    ((AppDetailActivity) g4).p3();
                }
            } else if (g4 instanceof WishlistActivity) {
                if (i4 == 601) {
                    ((WishlistActivity) g4).r5((String) null);
                }
            } else if (g4 instanceof RecommendedActivity) {
                if (i4 == 601) {
                    ((RecommendedActivity) g4).t5((String) null);
                }
            } else if (g4 instanceof PublicListActivity) {
                if (i4 == 601) {
                    ((PublicListActivity) g4).X4((String) null);
                }
            } else if (g4 instanceof RollbackActivity) {
                if (i4 == 601) {
                    RollbackActivity rollbackActivity = (RollbackActivity) g4;
                    rollbackActivity.runOnUiThread(new RollbackActivity.a());
                }
            } else if ((g4 instanceof TvAppDetailActivity) && i4 == 603) {
                TvAppDetailActivity tvAppDetailActivity = (TvAppDetailActivity) g4;
                tvAppDetailActivity.runOnUiThread(new TvAppDetailActivity.a());
            }
        }
    }
}
