package com.uptodown.activities;

import J1.C1317a5;
import J1.C1324b5;
import J1.C1331c5;
import J1.Y4;
import J1.Z4;
import N1.k;
import R2.g;
import R2.h;
import R2.n;
import R2.s;
import V2.d;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import c2.G0;
import com.uptodown.R;
import d3.p;
import g2.C2067z;
import g2.L;
import g2.r;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.E0;
import o3.J;
import o3.K;
import o3.Y;
import org.json.JSONObject;
import u2.v;

public final class Suggestions extends C1826a {

    /* renamed from: J  reason: collision with root package name */
    private final g f18413J = h.a(new Y4(this));
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public boolean f18414K;

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18415a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Suggestions f18416b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Suggestions suggestions, d dVar) {
            super(2, dVar);
            this.f18416b = suggestions;
        }

        public final d create(Object obj, d dVar) {
            return new a(this.f18416b, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18415a;
            if (i4 == 0) {
                n.b(obj);
                Suggestions suggestions = this.f18416b;
                String obj2 = suggestions.m3().f9755b.getText().toString();
                String obj3 = this.f18416b.m3().f9756c.getText().toString();
                this.f18415a = 1;
                if (suggestions.r3(obj2, obj3, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f18417a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Suggestions f18418b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18419c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f18420d;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f18421a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ A f18422b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Suggestions f18423c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ C f18424d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(A a5, Suggestions suggestions, C c5, d dVar) {
                super(2, dVar);
                this.f18422b = a5;
                this.f18423c = suggestions;
                this.f18424d = c5;
            }

            public final d create(Object obj, d dVar) {
                return new a(this.f18422b, this.f18423c, this.f18424d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                W2.b.c();
                if (this.f18421a == 0) {
                    n.b(obj);
                    try {
                        if (this.f18422b.f20966a == 1) {
                            Suggestions suggestions = this.f18423c;
                            String string = suggestions.getString(R.string.sugerencia_enviada);
                            m.d(string, "getString(...)");
                            suggestions.q0(string);
                            this.f18423c.k3();
                        } else {
                            C c5 = this.f18424d;
                            if (c5.f20968a == null) {
                                c5.f20968a = this.f18423c.getResources().getString(R.string.error_generico);
                            }
                            CharSequence charSequence = (CharSequence) this.f18424d.f20968a;
                            if (charSequence != null) {
                                if (charSequence.length() != 0) {
                                    Suggestions suggestions2 = this.f18423c;
                                    Object obj2 = this.f18424d.f20968a;
                                    m.b(obj2);
                                    suggestions2.q0((String) obj2);
                                }
                            }
                        }
                        this.f18423c.f18414K = false;
                        this.f18423c.m3().f9757d.setVisibility(8);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    return s.f8222a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(J j4, d dVar) {
                return ((a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Suggestions suggestions, String str, String str2, d dVar) {
            super(2, dVar);
            this.f18418b = suggestions;
            this.f18419c = str;
            this.f18420d = str2;
        }

        public final d create(Object obj, d dVar) {
            return new b(this.f18418b, this.f18419c, this.f18420d, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object c5 = W2.b.c();
            int i4 = this.f18417a;
            if (i4 == 0) {
                n.b(obj);
                A a5 = new A();
                C c6 = new C();
                c6.f20968a = "";
                r rVar = new r();
                Context applicationContext = this.f18418b.getApplicationContext();
                m.d(applicationContext, "getApplicationContext(...)");
                rVar.k(applicationContext);
                C2067z zVar = new C2067z();
                v vVar = new v();
                Context applicationContext2 = this.f18418b.getApplicationContext();
                m.d(applicationContext2, "getApplicationContext(...)");
                zVar.g(vVar.f(applicationContext2));
                v vVar2 = new v();
                Context applicationContext3 = this.f18418b.getApplicationContext();
                m.d(applicationContext3, "getApplicationContext(...)");
                zVar.e(vVar2.a(applicationContext3));
                v vVar3 = new v();
                Context applicationContext4 = this.f18418b.getApplicationContext();
                m.d(applicationContext4, "getApplicationContext(...)");
                zVar.h(vVar3.g(applicationContext4));
                v vVar4 = new v();
                Context applicationContext5 = this.f18418b.getApplicationContext();
                m.d(applicationContext5, "getApplicationContext(...)");
                zVar.f(vVar4.b(applicationContext5));
                Context applicationContext6 = this.f18418b.getApplicationContext();
                m.d(applicationContext6, "getApplicationContext(...)");
                L b12 = new u2.L(applicationContext6).b1(this.f18419c, this.f18420d, rVar, zVar);
                if (!b12.b() && b12.e() != null) {
                    JSONObject e5 = b12.e();
                    m.b(e5);
                    if (e5.optInt("success") == 0) {
                        c6.f20968a = b12.g(e5);
                    }
                }
                E0 c7 = Y.c();
                a aVar = new a(a5, this.f18418b, c6, (d) null);
                this.f18417a = 1;
                if (C0977g.g(c7, aVar, this) == c5) {
                    return c5;
                }
            } else if (i4 == 1) {
                n.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s.f8222a;
        }

        public final Object invoke(J j4, d dVar) {
            return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
        }
    }

    /* access modifiers changed from: private */
    public static final G0 j3(Suggestions suggestions) {
        return G0.c(suggestions.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void k3() {
        m3().f9755b.setText("");
        m3().f9756c.setText("");
    }

    private final boolean l3() {
        Editable text = m3().f9755b.getText();
        if (text == null || text.length() == 0) {
            String string = getString(R.string.falta_email_sugerencia);
            m.d(string, "getString(...)");
            q0(string);
            return false;
        }
        Editable text2 = m3().f9756c.getText();
        if (text2 != null && text2.length() != 0) {
            return true;
        }
        String string2 = getString(R.string.falta_texto_sugerencia);
        m.d(string2, "getString(...)");
        q0(string2);
        return false;
    }

    /* access modifiers changed from: private */
    public final G0 m3() {
        return (G0) this.f18413J.getValue();
    }

    /* access modifiers changed from: private */
    public static final void n3(Suggestions suggestions, View view) {
        suggestions.getOnBackPressedDispatcher().onBackPressed();
    }

    /* access modifiers changed from: private */
    public static final void o3(Suggestions suggestions, View view, boolean z4) {
        if (z4) {
            suggestions.m3().f9755b.setHint("");
        } else {
            suggestions.m3().f9755b.setHint(suggestions.getString(R.string.hint_email_registro));
        }
    }

    /* access modifiers changed from: private */
    public static final void p3(Suggestions suggestions, View view, boolean z4) {
        if (z4) {
            suggestions.m3().f9756c.setHint("");
        } else {
            suggestions.m3().f9756c.setHint(suggestions.getString(R.string.hint_text_suggestion));
        }
    }

    /* access modifiers changed from: private */
    public static final void q3(Suggestions suggestions, View view) {
        if (!suggestions.f18414K) {
            suggestions.m3().f9757d.setVisibility(0);
            suggestions.f18414K = true;
            if (suggestions.l3()) {
                C1001s0 unused = C0981i.d(K.a(Y.b()), (V2.g) null, (o3.L) null, new a(suggestions, (d) null), 3, (Object) null);
                return;
            }
            suggestions.f18414K = false;
            suggestions.m3().f9757d.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final Object r3(String str, String str2, d dVar) {
        Object g4 = C0977g.g(Y.b(), new b(this, str, str2, (d) null), dVar);
        if (g4 == W2.b.c()) {
            return g4;
        }
        return s.f8222a;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) m3().getRoot());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_suggestions);
        if (toolbar != null) {
            Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription((CharSequence) getString(R.string.back));
            }
            toolbar.setNavigationOnClickListener(new Z4(this));
            m3().f9760g.setTypeface(k.f7778g.w());
        }
        EditText editText = m3().f9755b;
        k.a aVar = k.f7778g;
        editText.setTypeface(aVar.x());
        m3().f9755b.setOnFocusChangeListener(new C1317a5(this));
        m3().f9756c.setTypeface(aVar.x());
        m3().f9756c.setOnFocusChangeListener(new C1324b5(this));
        m3().f9759f.setTypeface(aVar.w());
        m3().f9759f.setOnClickListener(new C1331c5(this));
    }
}
