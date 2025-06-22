package com.inmobi.cmp.presentation.components;

import A3.g;
import J2.f;
import R2.n;
import R2.s;
import T3.C2578f;
import T3.C2585m;
import V2.d;
import V3.C2592c;
import V3.C2596g;
import X3.C2605a;
import X3.C2606b;
import Z3.C2612a;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import c.C0500c;
import c.i;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import com.inmobi.cmp.data.model.ChoiceColor;
import com.inmobi.cmp.data.model.ThemeMode;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import d3.p;
import d4.c;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.L;
import o3.Y;

public final class CmpActivity extends AppCompatActivity {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f11789b = 0;

    /* renamed from: a  reason: collision with root package name */
    public c f11790a;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f11791a;

        static {
            int[] iArr = new int[ThemeMode.values().length];
            iArr[ThemeMode.LIGHT.ordinal()] = 1;
            iArr[ThemeMode.DARK.ordinal()] = 2;
            f11791a = iArr;
        }
    }

    public static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        public int f11792a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CmpActivity f11793b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(CmpActivity cmpActivity, d dVar) {
            super(2, dVar);
            this.f11793b = cmpActivity;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f11793b, dVar);
        }

        public Object invoke(Object obj, Object obj2) {
            J j4 = (J) obj;
            return new b(this.f11793b, (d) obj2).invokeSuspend(s.f8222a);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            boolean z4;
            Object c5 = W2.b.c();
            int i4 = this.f11792a;
            c cVar = null;
            if (i4 == 0) {
                n.b(obj);
                c cVar2 = this.f11793b.f11790a;
                if (cVar2 != null) {
                    this.f11792a = 1;
                    obj = C0977g.g(Y.b(), new d4.b(cVar2, (d) null), this);
                    if (obj == c5) {
                        return c5;
                    }
                }
                return s.f8222a;
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b4.d dVar = b4.d.f24465a;
            b4.d.f24470f = (C2592c) obj;
            CmpActivity cmpActivity = this.f11793b;
            int i5 = CmpActivity.f11789b;
            Bundle extras = cmpActivity.getIntent().getExtras();
            if (extras == null) {
                str = null;
            } else {
                str = extras.getString("EXTRA_ACTION");
            }
            if (str != null) {
                int hashCode = str.hashCode();
                boolean z5 = false;
                if (hashCode != -2113348999) {
                    if (hashCode != -1969243076) {
                        if (hashCode != 1166950650) {
                            if (hashCode == 1517267649 && str.equals("ACTION_SHOW_CCPA_SCREEN")) {
                                if (!cmpActivity.isFinishing()) {
                                    FragmentManager supportFragmentManager = cmpActivity.getSupportFragmentManager();
                                    m.d(supportFragmentManager, "supportFragmentManager");
                                    if (!supportFragmentManager.isDestroyed() && !supportFragmentManager.isStateSaved()) {
                                        if (ChoiceCmp.INSTANCE.isViewModelAvailable$app_release()) {
                                            C2585m mVar = C2585m.f24018a;
                                            mVar.e(C2578f.CCPA, false);
                                            if (i.f1158b) {
                                                mVar.e(C2578f.USPWITHGBC, false);
                                            }
                                            supportFragmentManager.beginTransaction().add((Fragment) new c4.d(), c4.d.f24496y).commit();
                                        } else {
                                            C2.b.a(C2.b.f6277a, ChoiceError.MISSING_INITIALIZATION, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
                                            cmpActivity.finish();
                                        }
                                    }
                                }
                                return s.f8222a;
                            }
                        } else if (str.equals("ACTION_SHOW_CMP_DIALOG")) {
                            Bundle extras2 = cmpActivity.getIntent().getExtras();
                            if (extras2 != null) {
                                z5 = extras2.getBoolean("EXTRA_FORCE", false);
                            }
                            C2596g c6 = dVar.p().c();
                            if (c6.f24135a.length() <= 0 || c6.f24136b.length() <= 0 || c6.f24137c.length() <= 0 || c6.f24138d.length() <= 0) {
                                C2.b.a(C2.b.f6277a, ChoiceError.MISSING_INIT_SCREEN_TEXTS, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
                                cmpActivity.finish();
                                return s.f8222a;
                            }
                            C2585m mVar2 = C2585m.f24018a;
                            boolean z6 = !z5;
                            mVar2.e(C2578f.GDPR, z6);
                            if (i.f1158b) {
                                mVar2.e(C2578f.GDPRWITHGBC, z6);
                            }
                            f fVar = new f();
                            String simpleName = f.class.getSimpleName();
                            m.d(simpleName, "PrivacyBottomSheet::class.java.simpleName");
                            if (!cmpActivity.isFinishing()) {
                                FragmentManager supportFragmentManager2 = cmpActivity.getSupportFragmentManager();
                                m.d(supportFragmentManager2, "supportFragmentManager");
                                if (!supportFragmentManager2.isDestroyed() && !supportFragmentManager2.isStateSaved()) {
                                    fVar.show(supportFragmentManager2, simpleName);
                                }
                            }
                            ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
                            ChoiceCmpCallback callback = choiceCmp.getCallback();
                            if (callback != null) {
                                callback.onCmpUIShown(choiceCmp.ping$app_release(true, CmpStatus.LOADED, DisplayStatus.VISIBLE));
                            }
                            return s.f8222a;
                        }
                    } else if (str.equals("ACTION_SHOW_GBC_SCREEN")) {
                        if (!cmpActivity.isFinishing()) {
                            FragmentManager supportFragmentManager3 = cmpActivity.getSupportFragmentManager();
                            m.d(supportFragmentManager3, "supportFragmentManager");
                            if (!supportFragmentManager3.isDestroyed() && !supportFragmentManager3.isStateSaved()) {
                                if (ChoiceCmp.INSTANCE.isViewModelAvailable$app_release()) {
                                    C2585m.f24018a.e(C2578f.GBC, false);
                                    supportFragmentManager3.beginTransaction().add((Fragment) new C0500c(), C0500c.f1138r).commit();
                                } else {
                                    C2.b.a(C2.b.f6277a, ChoiceError.MISSING_INITIALIZATION, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
                                    cmpActivity.finish();
                                }
                            }
                        }
                        return s.f8222a;
                    }
                } else if (str.equals("ACTION_SHOW_US_REGULATION_SCREEN")) {
                    Bundle extras3 = cmpActivity.getIntent().getExtras();
                    if (extras3 == null) {
                        z4 = false;
                    } else {
                        z4 = extras3.getBoolean("EXTRA_FORCE", false);
                    }
                    if (!cmpActivity.isFinishing()) {
                        FragmentManager supportFragmentManager4 = cmpActivity.getSupportFragmentManager();
                        m.d(supportFragmentManager4, "supportFragmentManager");
                        if (!supportFragmentManager4.isDestroyed() && !supportFragmentManager4.isStateSaved()) {
                            if (ChoiceCmp.INSTANCE.isViewModelAvailable$app_release()) {
                                if (i.f1158b) {
                                    C2585m.f24018a.e(C2578f.USPWITHGBC, false);
                                }
                                c cVar3 = cmpActivity.f11790a;
                                if (cVar3 != null) {
                                    cVar = cVar3;
                                } else {
                                    m.u("viewModel");
                                }
                                if (cVar.f24532b.f170b.f121M) {
                                    String str2 = b4.d.f24478n;
                                    m.e(g.CALIFORNIA, MRAIDCommunicatorUtil.KEY_STATE);
                                    if (m.a(str2, DownloadCommon.DOWNLOAD_REPORT_CANCEL)) {
                                        C2585m.f24018a.e(C2578f.CCPA, false);
                                        supportFragmentManager4.beginTransaction().add((Fragment) new c4.d(), c4.d.f24496y).commit();
                                    }
                                }
                                C2585m.f24018a.e(C2578f.MSPA, !z4);
                                supportFragmentManager4.beginTransaction().add((Fragment) new n.f(), n.f.f3572y).commit();
                            } else {
                                C2.b.a(C2.b.f6277a, ChoiceError.MISSING_INITIALIZATION, (String) null, (String) null, (C2.c) null, (Throwable) null, 30);
                                cmpActivity.finish();
                            }
                        }
                    }
                    return s.f8222a;
                }
            }
            cmpActivity.finish();
            return s.f8222a;
        }
    }

    public void onCreate(Bundle bundle) {
        int i4;
        ChoiceColor choiceColor;
        super.onCreate(bundle);
        b4.d dVar = b4.d.f24465a;
        ThemeMode themeMode = b4.d.f24468d.getThemeMode();
        if (themeMode == null) {
            i4 = -1;
        } else {
            i4 = a.f11791a[themeMode.ordinal()];
        }
        if (i4 == 1) {
            getDelegate().setLocalNightMode(1);
        } else if (i4 == 2) {
            getDelegate().setLocalNightMode(2);
        }
        m.e(this, "context");
        m.e(this, "context");
        if (b4.d.f24490z == null) {
            if (b4.d.f24468d.getThemeMode() == ThemeMode.LIGHT) {
                choiceColor = b4.d.f24468d.getLightModeColors();
            } else if (b4.d.f24468d.getThemeMode() == ThemeMode.DARK) {
                choiceColor = b4.d.f24468d.getDarkModeColors();
            } else {
                if (b4.d.f24468d.getLightModeColors() != null && b4.d.f24468d.getDarkModeColors() != null) {
                    int i5 = getResources().getConfiguration().uiMode & 48;
                    if (i5 == 16) {
                        choiceColor = b4.d.f24468d.getLightModeColors();
                    } else if (i5 == 32) {
                        choiceColor = b4.d.f24468d.getDarkModeColors();
                    }
                } else if (b4.d.f24468d.getLightModeColors() == null) {
                    choiceColor = b4.d.f24468d.getDarkModeColors();
                }
                choiceColor = b4.d.f24468d.getLightModeColors();
            }
            b4.d.f24490z = new C2606b(choiceColor, new C2612a());
        }
        C2605a aVar = b4.d.f24490z;
        if (aVar == null) {
            m.u("choiceStyleSheetRepository");
            aVar = null;
        }
        c cVar = new c(aVar, dVar.j());
        m.e(cVar, "<set-?>");
        this.f11790a = cVar;
        C1001s0 unused = C0981i.d(LifecycleOwnerKt.getLifecycleScope(this), (V2.g) null, (L) null, new b(this, (d) null), 3, (Object) null);
    }
}
