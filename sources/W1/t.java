package W1;

import N1.k;
import R2.n;
import R2.s;
import S1.k;
import V2.d;
import V2.g;
import android.content.Context;
import android.os.Bundle;
import android.os.ResultReceiver;
import d3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C0977g;
import o3.C1001s0;
import o3.J;
import o3.K;
import o3.L;
import o3.Y;

public abstract class t {

    /* renamed from: a  reason: collision with root package name */
    public static final a f8713a = new a((C2103g) null);

    public static final class a {

        /* renamed from: W1.t$a$a  reason: collision with other inner class name */
        static final class C0122a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f8714a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ String f8715b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f8716c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ k f8717d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0122a(String str, Context context, k kVar, d dVar) {
                super(2, dVar);
                this.f8715b = str;
                this.f8716c = context;
                this.f8717d = kVar;
            }

            public final d create(Object obj, d dVar) {
                return new C0122a(this.f8715b, this.f8716c, this.f8717d, dVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object c5 = W2.b.c();
                int i4 = this.f8714a;
                if (i4 == 0) {
                    n.b(obj);
                    a aVar = t.f8713a;
                    String str = this.f8715b;
                    Context context = this.f8716c;
                    k kVar = this.f8717d;
                    this.f8714a = 1;
                    if (aVar.c(str, context, kVar, this) == c5) {
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
                return ((C0122a) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        static final class b extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            Object f8718a;

            /* renamed from: b  reason: collision with root package name */
            Object f8719b;

            /* renamed from: c  reason: collision with root package name */
            int f8720c;

            /* renamed from: d  reason: collision with root package name */
            int f8721d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ String f8722e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ Context f8723f;

            /* renamed from: g  reason: collision with root package name */
            final /* synthetic */ k f8724g;

            /* renamed from: W1.t$a$b$a  reason: collision with other inner class name */
            static final class C0123a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f8725a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ k f8726b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f8727c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ String f8728d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0123a(k kVar, String str, String str2, V2.d dVar) {
                    super(2, dVar);
                    this.f8726b = kVar;
                    this.f8727c = str;
                    this.f8728d = str2;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new C0123a(this.f8726b, this.f8727c, this.f8728d, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    W2.b.c();
                    if (this.f8725a == 0) {
                        n.b(obj);
                        k kVar = this.f8726b;
                        if (kVar != null) {
                            kVar.e(this.f8727c);
                        }
                        k.a aVar = N1.k.f7778g;
                        if (aVar.v() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("packageName", this.f8728d);
                            ResultReceiver v4 = aVar.v();
                            if (v4 != null) {
                                v4.send(304, bundle);
                            }
                        }
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(J j4, V2.d dVar) {
                    return ((C0123a) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            /* renamed from: W1.t$a$b$b  reason: collision with other inner class name */
            static final class C0124b extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f8729a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ S1.k f8730b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f8731c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ String f8732d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0124b(S1.k kVar, String str, String str2, V2.d dVar) {
                    super(2, dVar);
                    this.f8730b = kVar;
                    this.f8731c = str;
                    this.f8732d = str2;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new C0124b(this.f8730b, this.f8731c, this.f8732d, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    W2.b.c();
                    if (this.f8729a == 0) {
                        n.b(obj);
                        S1.k kVar = this.f8730b;
                        if (kVar != null) {
                            kVar.a(this.f8731c);
                        }
                        k.a aVar = N1.k.f7778g;
                        if (aVar.v() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("packageName", this.f8732d);
                            ResultReceiver v4 = aVar.v();
                            if (v4 != null) {
                                v4.send(301, bundle);
                            }
                        }
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(J j4, V2.d dVar) {
                    return ((C0124b) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            static final class c extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f8733a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ S1.k f8734b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f8735c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ String f8736d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ String f8737e;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                c(S1.k kVar, String str, String str2, String str3, V2.d dVar) {
                    super(2, dVar);
                    this.f8734b = kVar;
                    this.f8735c = str;
                    this.f8736d = str2;
                    this.f8737e = str3;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new c(this.f8734b, this.f8735c, this.f8736d, this.f8737e, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    W2.b.c();
                    if (this.f8733a == 0) {
                        n.b(obj);
                        S1.k kVar = this.f8734b;
                        if (kVar != null) {
                            kVar.c(this.f8735c, this.f8736d);
                        }
                        k.a aVar = N1.k.f7778g;
                        if (aVar.v() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("packageName", this.f8737e);
                            bundle.putString("filename", this.f8735c);
                            bundle.putString("errorMsg", this.f8736d);
                            ResultReceiver v4 = aVar.v();
                            if (v4 != null) {
                                v4.send(303, bundle);
                            }
                        }
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(J j4, V2.d dVar) {
                    return ((c) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            static final class d extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f8738a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ S1.k f8739b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f8740c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ String f8741d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                d(S1.k kVar, String str, String str2, V2.d dVar) {
                    super(2, dVar);
                    this.f8739b = kVar;
                    this.f8740c = str;
                    this.f8741d = str2;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new d(this.f8739b, this.f8740c, this.f8741d, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    W2.b.c();
                    if (this.f8738a == 0) {
                        n.b(obj);
                        S1.k kVar = this.f8739b;
                        if (kVar != null) {
                            kVar.b(this.f8740c);
                        }
                        k.a aVar = N1.k.f7778g;
                        if (aVar.v() != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("packageName", this.f8741d);
                            bundle.putString("filename", this.f8740c);
                            ResultReceiver v4 = aVar.v();
                            if (v4 != null) {
                                v4.send(302, bundle);
                            }
                        }
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(J j4, V2.d dVar) {
                    return ((d) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            static final class e extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f8742a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ S1.k f8743b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ String f8744c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                e(S1.k kVar, String str, V2.d dVar) {
                    super(2, dVar);
                    this.f8743b = kVar;
                    this.f8744c = str;
                }

                public final V2.d create(Object obj, V2.d dVar) {
                    return new e(this.f8743b, this.f8744c, dVar);
                }

                public final Object invokeSuspend(Object obj) {
                    W2.b.c();
                    if (this.f8742a == 0) {
                        n.b(obj);
                        S1.k kVar = this.f8743b;
                        if (kVar == null) {
                            return null;
                        }
                        kVar.d(this.f8744c);
                        return s.f8222a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(J j4, V2.d dVar) {
                    return ((e) create(j4, dVar)).invokeSuspend(s.f8222a);
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, Context context, S1.k kVar, V2.d dVar) {
                super(2, dVar);
                this.f8722e = str;
                this.f8723f = context;
                this.f8724g = kVar;
            }

            public final V2.d create(Object obj, V2.d dVar) {
                return new b(this.f8722e, this.f8723f, this.f8724g, dVar);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:61:0x01d9, code lost:
                if (o3.C0977g.g(r2, r4, r1) == r0) goto L_0x01db;
             */
            /* JADX WARNING: Removed duplicated region for block: B:45:0x012f A[Catch:{ Exception -> 0x0022 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x018e A[Catch:{ Exception -> 0x0022 }] */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x01a8 A[Catch:{ Exception -> 0x0022 }] */
            /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x00bc=Splitter:B:38:0x00bc, B:12:0x002d=Splitter:B:12:0x002d} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r23) {
                /*
                    r22 = this;
                    r1 = r22
                    java.lang.Object r0 = W2.b.c()
                    int r2 = r1.f8721d
                    r3 = 5
                    r4 = 4
                    r5 = 3
                    r6 = 2
                    r7 = 0
                    java.lang.String r8 = "context.packageManager"
                    r9 = 1
                    r10 = 0
                    if (r2 == 0) goto L_0x004a
                    if (r2 == r9) goto L_0x003e
                    if (r2 == r6) goto L_0x0032
                    if (r2 == r5) goto L_0x002d
                    if (r2 == r4) goto L_0x002d
                    if (r2 != r3) goto L_0x0025
                    R2.n.b(r23)     // Catch:{ Exception -> 0x0022 }
                    goto L_0x021e
                L_0x0022:
                    r0 = move-exception
                    goto L_0x01dc
                L_0x0025:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r2)
                    throw r0
                L_0x002d:
                    R2.n.b(r23)     // Catch:{ Exception -> 0x0022 }
                    goto L_0x01c0
                L_0x0032:
                    int r2 = r1.f8720c
                    java.lang.Object r3 = r1.f8718a
                    java.lang.String r3 = (java.lang.String) r3
                    R2.n.b(r23)     // Catch:{ Exception -> 0x0022 }
                    r15 = r3
                    goto L_0x0111
                L_0x003e:
                    java.lang.Object r2 = r1.f8719b
                    android.content.pm.PackageInfo r2 = (android.content.pm.PackageInfo) r2
                    java.lang.Object r3 = r1.f8718a
                    java.lang.String r3 = (java.lang.String) r3
                    R2.n.b(r23)     // Catch:{ NameNotFoundException -> 0x00ba }
                    goto L_0x00b4
                L_0x004a:
                    R2.n.b(r23)
                    java.io.File r2 = new java.io.File
                    java.lang.String r11 = r1.f8722e
                    r2.<init>(r11)
                    boolean r2 = r2.exists()
                    if (r2 == 0) goto L_0x0215
                    android.content.Context r2 = r1.f8723f     // Catch:{ Exception -> 0x0022 }
                    android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ Exception -> 0x0022 }
                    kotlin.jvm.internal.m.d(r2, r8)     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r11 = r1.f8722e     // Catch:{ Exception -> 0x0022 }
                    r12 = 128(0x80, float:1.794E-43)
                    android.content.pm.PackageInfo r2 = W1.s.c(r2, r11, r12)     // Catch:{ Exception -> 0x0022 }
                    if (r2 == 0) goto L_0x01c6
                    android.content.pm.ApplicationInfo r3 = r2.applicationInfo     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r3 = r3.packageName     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r11 = "pi.applicationInfo.packageName"
                    kotlin.jvm.internal.m.d(r3, r11)     // Catch:{ Exception -> 0x0022 }
                    W1.h r11 = new W1.h     // Catch:{ Exception -> 0x0022 }
                    r11.<init>()     // Catch:{ Exception -> 0x0022 }
                    long r11 = r11.m(r2)     // Catch:{ Exception -> 0x0022 }
                    android.content.Context r13 = r1.f8723f     // Catch:{ NameNotFoundException -> 0x00ba }
                    android.content.pm.PackageManager r13 = r13.getPackageManager()     // Catch:{ NameNotFoundException -> 0x00ba }
                    kotlin.jvm.internal.m.d(r13, r8)     // Catch:{ NameNotFoundException -> 0x00ba }
                    android.content.pm.PackageInfo r13 = W1.s.d(r13, r3, r7)     // Catch:{ NameNotFoundException -> 0x00ba }
                    W1.h r14 = new W1.h     // Catch:{ NameNotFoundException -> 0x00ba }
                    r14.<init>()     // Catch:{ NameNotFoundException -> 0x00ba }
                    long r13 = r14.m(r13)     // Catch:{ NameNotFoundException -> 0x00ba }
                    int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                    if (r15 <= 0) goto L_0x00b7
                    o3.E0 r11 = o3.Y.c()     // Catch:{ NameNotFoundException -> 0x00ba }
                    W1.t$a$b$a r12 = new W1.t$a$b$a     // Catch:{ NameNotFoundException -> 0x00ba }
                    S1.k r13 = r1.f8724g     // Catch:{ NameNotFoundException -> 0x00ba }
                    java.lang.String r14 = r1.f8722e     // Catch:{ NameNotFoundException -> 0x00ba }
                    r12.<init>(r13, r14, r3, r10)     // Catch:{ NameNotFoundException -> 0x00ba }
                    r1.f8718a = r3     // Catch:{ NameNotFoundException -> 0x00ba }
                    r1.f8719b = r2     // Catch:{ NameNotFoundException -> 0x00ba }
                    r1.f8721d = r9     // Catch:{ NameNotFoundException -> 0x00ba }
                    java.lang.Object r11 = o3.C0977g.g(r11, r12, r1)     // Catch:{ NameNotFoundException -> 0x00ba }
                    if (r11 != r0) goto L_0x00b4
                    goto L_0x01db
                L_0x00b4:
                    R2.s r0 = R2.s.f8222a     // Catch:{ NameNotFoundException -> 0x00ba }
                    return r0
                L_0x00b7:
                    r11 = r3
                    r3 = 1
                    goto L_0x00bc
                L_0x00ba:
                    r11 = r3
                    r3 = 0
                L_0x00bc:
                    W1.h r12 = new W1.h     // Catch:{ Exception -> 0x0022 }
                    r12.<init>()     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r13 = r1.f8722e     // Catch:{ Exception -> 0x0022 }
                    android.content.Context r14 = r1.f8723f     // Catch:{ Exception -> 0x0022 }
                    android.content.pm.PackageManager r14 = r14.getPackageManager()     // Catch:{ Exception -> 0x0022 }
                    kotlin.jvm.internal.m.d(r14, r8)     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r19 = r12.b(r2, r13, r14)     // Catch:{ Exception -> 0x0022 }
                    W1.h r8 = new W1.h     // Catch:{ Exception -> 0x0022 }
                    r8.<init>()     // Catch:{ Exception -> 0x0022 }
                    long r17 = r8.m(r2)     // Catch:{ Exception -> 0x0022 }
                    W1.g r8 = new W1.g     // Catch:{ Exception -> 0x0022 }
                    r8.<init>()     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r12 = r1.f8722e     // Catch:{ Exception -> 0x0022 }
                    long r20 = r8.f(r12)     // Catch:{ Exception -> 0x0022 }
                    N1.k$a r15 = N1.k.f7778g     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r2 = r2.packageName     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r8 = "pi.packageName"
                    kotlin.jvm.internal.m.d(r2, r8)     // Catch:{ Exception -> 0x0022 }
                    r16 = r2
                    r15.y(r16, r17, r19, r20)     // Catch:{ Exception -> 0x0022 }
                    o3.E0 r2 = o3.Y.c()     // Catch:{ Exception -> 0x0022 }
                    W1.t$a$b$b r8 = new W1.t$a$b$b     // Catch:{ Exception -> 0x0022 }
                    S1.k r12 = r1.f8724g     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r13 = r1.f8722e     // Catch:{ Exception -> 0x0022 }
                    r8.<init>(r12, r13, r11, r10)     // Catch:{ Exception -> 0x0022 }
                    r1.f8718a = r11     // Catch:{ Exception -> 0x0022 }
                    r1.f8719b = r10     // Catch:{ Exception -> 0x0022 }
                    r1.f8720c = r3     // Catch:{ Exception -> 0x0022 }
                    r1.f8721d = r6     // Catch:{ Exception -> 0x0022 }
                    java.lang.Object r2 = o3.C0977g.g(r2, r8, r1)     // Catch:{ Exception -> 0x0022 }
                    if (r2 != r0) goto L_0x010f
                    goto L_0x01db
                L_0x010f:
                    r2 = r3
                    r15 = r11
                L_0x0111:
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                    r3.<init>()     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r6 = "pm install -i \""
                    r3.append(r6)     // Catch:{ Exception -> 0x0022 }
                    android.content.Context r6 = r1.f8723f     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r6 = r6.getPackageName()     // Catch:{ Exception -> 0x0022 }
                    r3.append(r6)     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r6 = "\" "
                    r3.append(r6)     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0022 }
                    if (r2 == 0) goto L_0x0140
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                    r2.<init>()     // Catch:{ Exception -> 0x0022 }
                    r2.append(r3)     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r3 = "-r "
                    r2.append(r3)     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r3 = r2.toString()     // Catch:{ Exception -> 0x0022 }
                L_0x0140:
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0022 }
                    r2.<init>()     // Catch:{ Exception -> 0x0022 }
                    r2.append(r3)     // Catch:{ Exception -> 0x0022 }
                    r3 = 34
                    r2.append(r3)     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r6 = r1.f8722e     // Catch:{ Exception -> 0x0022 }
                    r2.append(r6)     // Catch:{ Exception -> 0x0022 }
                    r2.append(r3)     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0022 }
                    java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r6 = "su"
                    java.lang.String r8 = "-c"
                    java.lang.String[] r2 = new java.lang.String[]{r6, r8, r2}     // Catch:{ Exception -> 0x0022 }
                    java.lang.Process r2 = r3.exec(r2)     // Catch:{ Exception -> 0x0022 }
                    java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0022 }
                    java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0022 }
                    java.io.InputStream r8 = r2.getInputStream()     // Catch:{ Exception -> 0x0022 }
                    r6.<init>(r8)     // Catch:{ Exception -> 0x0022 }
                    r3.<init>(r6)     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r14 = r3.readLine()     // Catch:{ Exception -> 0x0022 }
                    if (r14 == 0) goto L_0x0186
                    java.lang.String r6 = "Success"
                    boolean r6 = m3.m.p(r14, r6, r9)     // Catch:{ Exception -> 0x0022 }
                    if (r6 == 0) goto L_0x0186
                    r7 = 1
                L_0x0186:
                    r3.close()     // Catch:{ Exception -> 0x0022 }
                    r2.waitFor()     // Catch:{ Exception -> 0x0022 }
                    if (r7 != 0) goto L_0x01a8
                    o3.E0 r2 = o3.Y.c()     // Catch:{ Exception -> 0x0022 }
                    W1.t$a$b$c r11 = new W1.t$a$b$c     // Catch:{ Exception -> 0x0022 }
                    S1.k r12 = r1.f8724g     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r13 = r1.f8722e     // Catch:{ Exception -> 0x0022 }
                    r16 = 0
                    r11.<init>(r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0022 }
                    r1.f8718a = r10     // Catch:{ Exception -> 0x0022 }
                    r1.f8721d = r5     // Catch:{ Exception -> 0x0022 }
                    java.lang.Object r2 = o3.C0977g.g(r2, r11, r1)     // Catch:{ Exception -> 0x0022 }
                    if (r2 != r0) goto L_0x01c0
                    goto L_0x01db
                L_0x01a8:
                    o3.E0 r2 = o3.Y.c()     // Catch:{ Exception -> 0x0022 }
                    W1.t$a$b$d r3 = new W1.t$a$b$d     // Catch:{ Exception -> 0x0022 }
                    S1.k r5 = r1.f8724g     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r6 = r1.f8722e     // Catch:{ Exception -> 0x0022 }
                    r3.<init>(r5, r6, r15, r10)     // Catch:{ Exception -> 0x0022 }
                    r1.f8718a = r10     // Catch:{ Exception -> 0x0022 }
                    r1.f8721d = r4     // Catch:{ Exception -> 0x0022 }
                    java.lang.Object r2 = o3.C0977g.g(r2, r3, r1)     // Catch:{ Exception -> 0x0022 }
                    if (r2 != r0) goto L_0x01c0
                    goto L_0x01db
                L_0x01c0:
                    N1.k$a r0 = N1.k.f7778g     // Catch:{ Exception -> 0x0022 }
                    r0.e()     // Catch:{ Exception -> 0x0022 }
                    goto L_0x021e
                L_0x01c6:
                    o3.E0 r2 = o3.Y.c()     // Catch:{ Exception -> 0x0022 }
                    W1.t$a$b$e r4 = new W1.t$a$b$e     // Catch:{ Exception -> 0x0022 }
                    S1.k r5 = r1.f8724g     // Catch:{ Exception -> 0x0022 }
                    java.lang.String r6 = r1.f8722e     // Catch:{ Exception -> 0x0022 }
                    r4.<init>(r5, r6, r10)     // Catch:{ Exception -> 0x0022 }
                    r1.f8721d = r3     // Catch:{ Exception -> 0x0022 }
                    java.lang.Object r2 = o3.C0977g.g(r2, r4, r1)     // Catch:{ Exception -> 0x0022 }
                    if (r2 != r0) goto L_0x021e
                L_0x01db:
                    return r0
                L_0x01dc:
                    N1.k$a r2 = N1.k.f7778g
                    r2.e()
                    S1.k r3 = r1.f8724g
                    if (r3 == 0) goto L_0x01ee
                    java.lang.String r4 = r1.f8722e
                    java.lang.String r5 = r0.getMessage()
                    r3.c(r4, r5)
                L_0x01ee:
                    android.os.ResultReceiver r3 = r2.v()
                    if (r3 == 0) goto L_0x021e
                    android.os.Bundle r3 = new android.os.Bundle
                    r3.<init>()
                    java.lang.String r4 = "filename"
                    java.lang.String r5 = r1.f8722e
                    r3.putString(r4, r5)
                    java.lang.String r4 = "errorMsg"
                    java.lang.String r0 = r0.getMessage()
                    r3.putString(r4, r0)
                    android.os.ResultReceiver r0 = r2.v()
                    if (r0 == 0) goto L_0x021e
                    r2 = 303(0x12f, float:4.25E-43)
                    r0.send(r2, r3)
                    goto L_0x021e
                L_0x0215:
                    S1.k r0 = r1.f8724g
                    if (r0 == 0) goto L_0x021e
                    java.lang.String r2 = r1.f8722e
                    r0.f(r2)
                L_0x021e:
                    R2.s r0 = R2.s.f8222a
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: W1.t.a.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }

            public final Object invoke(J j4, V2.d dVar) {
                return ((b) create(j4, dVar)).invokeSuspend(s.f8222a);
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final Object c(String str, Context context, S1.k kVar, d dVar) {
            Object g4 = C0977g.g(Y.a(), new b(str, context, kVar, (d) null), dVar);
            if (g4 == W2.b.c()) {
                return g4;
            }
            return s.f8222a;
        }

        public final void b(String str, Context context, S1.k kVar) {
            m.e(str, "filename");
            m.e(context, "context");
            C1001s0 unused = C0981i.d(K.a(Y.a()), (g) null, (L) null, new C0122a(str, context, kVar, (d) null), 3, (Object) null);
        }

        public final boolean d() {
            return X1.a.b();
        }

        private a() {
        }
    }
}
