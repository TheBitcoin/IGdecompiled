package com.google.android.gms.measurement.internal;

import J.C0309h;
import J.C0313l;
import M.C0335p;
import R.d;
import T.e;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.U0;
import com.google.android.gms.internal.measurement.r7;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import f0.o;
import f0.q;
import f0.r;
import f0.s;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

public final class d6 extends C0905z3 {

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f2945i = {"firebase_", "google_", "ga_"};

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f2946j = {"_err"};

    /* renamed from: c  reason: collision with root package name */
    private SecureRandom f2947c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f2948d = new AtomicLong(0);

    /* renamed from: e  reason: collision with root package name */
    private int f2949e;

    /* renamed from: f  reason: collision with root package name */
    private MeasurementManagerFutures f2950f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f2951g;

    /* renamed from: h  reason: collision with root package name */
    private Integer f2952h = null;

    d6(S2 s22) {
        super(s22);
    }

    private static boolean B0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static Bundle D(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String next : bundle2.keySet()) {
            Object obj = bundle2.get(next);
            if (obj instanceof Bundle) {
                bundle2.putBundle(next, new Bundle((Bundle) obj));
            } else {
                int i4 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i4 < parcelableArr.length) {
                        if (parcelableArr[i4] instanceof Bundle) {
                            parcelableArr[i4] = new Bundle((Bundle) parcelableArr[i4]);
                        }
                        i4++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i4 < list.size()) {
                        Object obj2 = list.get(i4);
                        if (obj2 instanceof Bundle) {
                            list.set(i4, new Bundle((Bundle) obj2));
                        }
                        i4++;
                    }
                }
            }
        }
        return bundle2;
    }

    static boolean D0(String str) {
        return G0((String) G.f2469e0.a((Object) null), str);
    }

    public static Bundle G(List list) {
        Bundle bundle = new Bundle();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Y5 y5 = (Y5) it.next();
                String str = y5.f2827e;
                if (str != null) {
                    bundle.putString(y5.f2824b, str);
                } else {
                    Long l4 = y5.f2826d;
                    if (l4 != null) {
                        bundle.putLong(y5.f2824b, l4.longValue());
                    } else {
                        Double d5 = y5.f2829g;
                        if (d5 != null) {
                            bundle.putDouble(y5.f2824b, d5.doubleValue());
                        }
                    }
                }
            }
        }
        return bundle;
    }

    private static boolean G0(String str, String str2) {
        if (str.equals("*") || Arrays.asList(str.split(",")).contains(str2)) {
            return true;
        }
        return false;
    }

    static boolean H0(String str) {
        return G0((String) G.f2407B0.a((Object) null), str);
    }

    private final Object I(int i4, Object obj, boolean z4, boolean z5, String str) {
        Bundle E4;
        long j4;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                j4 = 1;
            } else {
                j4 = 0;
            }
            return Long.valueOf(j4);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return J(String.valueOf(obj), i4, z4);
            }
            if (!z5 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if ((parcelable instanceof Bundle) && (E4 = E((Bundle) parcelable, (String) null)) != null && !E4.isEmpty()) {
                    arrayList.add(E4);
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    public static String J(String str, int i4, boolean z4) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i4) {
            return str;
        }
        if (!z4) {
            return null;
        }
        String substring = str.substring(0, str.offsetByCodePoints(0, i4));
        return substring + "...";
    }

    static boolean J0(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("_")) {
            return false;
        }
        return true;
    }

    static boolean K0(String str) {
        C0335p.f(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    private static void L(Bundle bundle, int i4, String str, Object obj) {
        if (v0(bundle, i4)) {
            bundle.putString("_ev", J(str, 40, true));
            if (obj != null) {
                C0335p.l(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) String.valueOf(obj).length());
                }
            }
        }
    }

    public static boolean M0(String str) {
        for (String equals : f2946j) {
            if (equals.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private final int N0(String str) {
        if (!w0("event param", str)) {
            return 3;
        }
        if (!o0("event param", (String[]) null, str)) {
            return 14;
        }
        if (!j0("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    private final int O0(String str) {
        if (!C0("event param", str)) {
            return 3;
        }
        if (!o0("event param", (String[]) null, str)) {
            return 14;
        }
        if (!j0("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    private static int P0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        if ("_lgclid".equals(str)) {
            return 100;
        }
        return 36;
    }

    private static boolean S0(String str) {
        C0335p.l(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    static MessageDigest V0() {
        int i4 = 0;
        while (i4 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
                if (instance != null) {
                    return instance;
                }
                i4++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static void X(C0892x4 x4Var, Bundle bundle, boolean z4) {
        if (bundle != null && x4Var != null && (!bundle.containsKey("_sc") || z4)) {
            String str = x4Var.f3294a;
            if (str != null) {
                bundle.putString("_sn", str);
            } else {
                bundle.remove("_sn");
            }
            String str2 = x4Var.f3295b;
            if (str2 != null) {
                bundle.putString("_sc", str2);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", x4Var.f3296c);
        } else if (bundle != null && x4Var == null && z4) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public static void Y(c6 c6Var, int i4, String str, String str2, int i5) {
        Z(c6Var, (String) null, i4, str, str2, i5);
    }

    static void Z(c6 c6Var, String str, int i4, String str2, String str3, int i5) {
        Bundle bundle = new Bundle();
        v0(bundle, i4);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i4 == 6 || i4 == 7 || i4 == 2) {
            bundle.putLong("_el", (long) i5);
        }
        c6Var.b(str, "_err", bundle);
    }

    private final boolean Z0() {
        Integer num;
        if (this.f2951g == null) {
            MeasurementManagerFutures T02 = T0();
            boolean z4 = false;
            if (T02 == null) {
                return false;
            }
            Integer num2 = null;
            try {
                num = (Integer) T02.getMeasurementApiStatusAsync().get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z4 = true;
                        }
                    } catch (CancellationException e5) {
                        e = e5;
                        num2 = num;
                        a().L().b("Measurement manager api exception", e);
                        this.f2951g = Boolean.FALSE;
                        num = num2;
                        a().K().b("Measurement manager api status result", num);
                        return this.f2951g.booleanValue();
                    } catch (ExecutionException e6) {
                        e = e6;
                        num2 = num;
                        a().L().b("Measurement manager api exception", e);
                        this.f2951g = Boolean.FALSE;
                        num = num2;
                        a().K().b("Measurement manager api status result", num);
                        return this.f2951g.booleanValue();
                    } catch (InterruptedException e7) {
                        e = e7;
                        num2 = num;
                        a().L().b("Measurement manager api exception", e);
                        this.f2951g = Boolean.FALSE;
                        num = num2;
                        a().K().b("Measurement manager api status result", num);
                        return this.f2951g.booleanValue();
                    } catch (TimeoutException e8) {
                        e = e8;
                        num2 = num;
                        a().L().b("Measurement manager api exception", e);
                        this.f2951g = Boolean.FALSE;
                        num = num2;
                        a().K().b("Measurement manager api status result", num);
                        return this.f2951g.booleanValue();
                    }
                }
                this.f2951g = Boolean.valueOf(z4);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e9) {
                e = e9;
                a().L().b("Measurement manager api exception", e);
                this.f2951g = Boolean.FALSE;
                num = num2;
                a().K().b("Measurement manager api status result", num);
                return this.f2951g.booleanValue();
            }
            a().K().b("Measurement manager api status result", num);
        }
        return this.f2951g.booleanValue();
    }

    private final void a0(String str, String str2, String str3, Bundle bundle, List list, boolean z4) {
        int i4;
        int i5;
        int i6;
        String str4;
        String str5 = str2;
        Bundle bundle2 = bundle;
        List list2 = list;
        if (bundle2 != null) {
            if (b().g().c0(231100000, true)) {
                i4 = 35;
            } else {
                i4 = 0;
            }
            int i7 = 0;
            for (String str6 : new TreeSet(bundle2.keySet())) {
                if (list2 == null || !list2.contains(str6)) {
                    if (!z4) {
                        i5 = O0(str6);
                    } else {
                        i5 = 0;
                    }
                    if (i5 == 0) {
                        i5 = N0(str6);
                    }
                } else {
                    i5 = 0;
                }
                if (i5 != 0) {
                    if (i5 == 3) {
                        str4 = str6;
                    } else {
                        str4 = null;
                    }
                    L(bundle2, i5, str6, str4);
                    bundle2.remove(str6);
                    String str7 = str3;
                } else {
                    if (h0(bundle2.get(str6))) {
                        a().M().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str5, str3, str6);
                        i6 = 22;
                    } else {
                        String str8 = str3;
                        i6 = u(str, str5, str6, bundle2.get(str6), bundle2, list2, z4, false);
                    }
                    if (i6 != 0 && !"_ev".equals(str6)) {
                        L(bundle2, i6, str6, bundle2.get(str6));
                        bundle2.remove(str6);
                    } else if (K0(str6) && !n0(str6, s.f3388d)) {
                        i7++;
                        if (!c0(231100000, true)) {
                            a().H().c("Item array not supported on client's version of Google Play Services (Android Only)", d().c(str5), d().a(bundle2));
                            v0(bundle2, 23);
                            bundle2.remove(str6);
                        } else if (i7 > i4) {
                            C0835p2 H4 = a().H();
                            H4.c("Item can't contain more than " + i4 + " item-scoped custom params", d().c(str5), d().a(bundle2));
                            v0(bundle2, 28);
                            bundle2.remove(str6);
                        }
                    }
                }
                list2 = list;
            }
        }
    }

    static boolean d0(Context context) {
        ActivityInfo receiverInfo;
        C0335p.l(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static boolean e0(Context context, boolean z4) {
        C0335p.l(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return B0(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return B0(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    static boolean f0(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if ("android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra)) {
            return true;
        }
        return false;
    }

    static boolean g0(Bundle bundle, int i4) {
        int i5 = 0;
        if (bundle.size() <= i4) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i5++;
            if (i5 > i4) {
                bundle.remove(str);
            }
        }
        return true;
    }

    static boolean h0(Object obj) {
        if ((obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
            return true;
        }
        return false;
    }

    static boolean m0(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            C0335p.l(str);
            if (!str.equals(str2)) {
                return true;
            }
            return false;
        } else if (!isEmpty || !isEmpty2) {
            if (isEmpty || !isEmpty2) {
                if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                    return true;
                }
                return false;
            } else if (TextUtils.isEmpty(str4)) {
                return false;
            } else {
                if (TextUtils.isEmpty(str3) || !str3.equals(str4)) {
                    return true;
                }
                return false;
            }
        } else if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            if (!TextUtils.isEmpty(str4)) {
                return true;
            }
            return false;
        } else if (!str3.equals(str4)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean n0(String str, String[] strArr) {
        C0335p.l(strArr);
        for (String equals : strArr) {
            if (Objects.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }

    static byte[] q0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static ArrayList t0(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0755e eVar = (C0755e) it.next();
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.APP_ID, eVar.f2953a);
            bundle.putString(TtmlNode.ATTR_TTS_ORIGIN, eVar.f2954b);
            bundle.putLong("creation_timestamp", eVar.f2956d);
            bundle.putString(RewardPlus.NAME, eVar.f2955c.f2824b);
            o.b(bundle, C0335p.l(eVar.f2955c.c()));
            bundle.putBoolean("active", eVar.f2957e);
            String str = eVar.f2958f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            E e5 = eVar.f2959g;
            if (e5 != null) {
                bundle.putString("timed_out_event_name", e5.f2366a);
                D d5 = e5.f2367b;
                if (d5 != null) {
                    bundle.putBundle("timed_out_event_params", d5.j());
                }
            }
            bundle.putLong("trigger_timeout", eVar.f2960h);
            E e6 = eVar.f2961i;
            if (e6 != null) {
                bundle.putString("triggered_event_name", e6.f2366a);
                D d6 = e6.f2367b;
                if (d6 != null) {
                    bundle.putBundle("triggered_event_params", d6.j());
                }
            }
            bundle.putLong("triggered_timestamp", eVar.f2955c.f2825c);
            bundle.putLong("time_to_live", eVar.f2962j);
            E e7 = eVar.f2963k;
            if (e7 != null) {
                bundle.putString("expired_event_name", e7.f2366a);
                D d7 = e7.f2367b;
                if (d7 != null) {
                    bundle.putBundle("expired_event_params", d7.j());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int u(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.Object r15, android.os.Bundle r16, java.util.List r17, boolean r18, boolean r19) {
        /*
            r11 = this;
            r0 = r16
            r11.k()
            boolean r1 = h0(r15)
            java.lang.String r2 = "param"
            r3 = 0
            if (r1 == 0) goto L_0x0084
            if (r19 == 0) goto L_0x0081
            java.lang.String[] r1 = f0.s.f3387c
            boolean r1 = n0(r14, r1)
            if (r1 != 0) goto L_0x001b
            r12 = 20
            return r12
        L_0x001b:
            com.google.android.gms.measurement.internal.S2 r1 = r11.f3273a
            com.google.android.gms.measurement.internal.F4 r1 = r1.J()
            boolean r1 = r1.h0()
            if (r1 != 0) goto L_0x002a
            r12 = 25
            return r12
        L_0x002a:
            boolean r1 = r15 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x0033
            r4 = r15
            android.os.Parcelable[] r4 = (android.os.Parcelable[]) r4
            int r4 = r4.length
            goto L_0x003e
        L_0x0033:
            boolean r4 = r15 instanceof java.util.ArrayList
            if (r4 == 0) goto L_0x0084
            r4 = r15
            java.util.ArrayList r4 = (java.util.ArrayList) r4
            int r4 = r4.size()
        L_0x003e:
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 <= r5) goto L_0x0084
            com.google.android.gms.measurement.internal.n2 r6 = r11.a()
            com.google.android.gms.measurement.internal.p2 r6 = r6.M()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r7 = "Parameter array is too long; discarded. Value kind, name, array length"
            r6.d(r7, r2, r14, r4)
            if (r1 == 0) goto L_0x0065
            r1 = r15
            android.os.Parcelable[] r1 = (android.os.Parcelable[]) r1
            int r4 = r1.length
            if (r4 <= r5) goto L_0x007e
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r1, r5)
            android.os.Parcelable[] r1 = (android.os.Parcelable[]) r1
            r0.putParcelableArray(r14, r1)
            goto L_0x007e
        L_0x0065:
            boolean r1 = r15 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x007e
            r1 = r15
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r4 = r1.size()
            if (r4 <= r5) goto L_0x007e
            java.util.ArrayList r4 = new java.util.ArrayList
            java.util.List r1 = r1.subList(r3, r5)
            r4.<init>(r1)
            r0.putParcelableArrayList(r14, r4)
        L_0x007e:
            r0 = 17
            goto L_0x0085
        L_0x0081:
            r12 = 21
            return r12
        L_0x0084:
            r0 = 0
        L_0x0085:
            boolean r1 = J0(r13)
            r4 = 0
            if (r1 != 0) goto L_0x009c
            boolean r1 = J0(r14)
            if (r1 == 0) goto L_0x0093
            goto L_0x009c
        L_0x0093:
            com.google.android.gms.measurement.internal.g r1 = r11.b()
            int r1 = r1.o(r4, r3)
            goto L_0x00a4
        L_0x009c:
            com.google.android.gms.measurement.internal.g r1 = r11.b()
            int r1 = r1.u(r4, r3)
        L_0x00a4:
            boolean r1 = r11.l0(r2, r14, r1, r15)
            if (r1 == 0) goto L_0x00ab
            return r0
        L_0x00ab:
            if (r19 == 0) goto L_0x0132
            boolean r1 = r15 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00c0
            r8 = r15
            android.os.Bundle r8 = (android.os.Bundle) r8
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r9 = r17
            r10 = r18
            r4.a0(r5, r6, r7, r8, r9, r10)
            return r0
        L_0x00c0:
            boolean r1 = r15 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x00f4
            android.os.Parcelable[] r15 = (android.os.Parcelable[]) r15
            int r8 = r15.length
            r9 = 0
        L_0x00c8:
            if (r9 >= r8) goto L_0x00f3
            r1 = r15[r9]
            boolean r2 = r1 instanceof android.os.Bundle
            if (r2 != 0) goto L_0x00e2
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.M()
            java.lang.Class r13 = r1.getClass()
            java.lang.String r15 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r12.c(r15, r13, r14)
            goto L_0x0132
        L_0x00e2:
            r5 = r1
            android.os.Bundle r5 = (android.os.Bundle) r5
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r17
            r7 = r18
            r1.a0(r2, r3, r4, r5, r6, r7)
            int r9 = r9 + 1
            goto L_0x00c8
        L_0x00f3:
            return r0
        L_0x00f4:
            boolean r1 = r15 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x0132
            java.util.ArrayList r15 = (java.util.ArrayList) r15
            int r8 = r15.size()
        L_0x00fe:
            if (r3 >= r8) goto L_0x0131
            java.lang.Object r1 = r15.get(r3)
            int r9 = r3 + 1
            boolean r2 = r1 instanceof android.os.Bundle
            if (r2 != 0) goto L_0x0121
            com.google.android.gms.measurement.internal.n2 r12 = r11.a()
            com.google.android.gms.measurement.internal.p2 r12 = r12.M()
            if (r1 == 0) goto L_0x0119
            java.lang.Class r13 = r1.getClass()
            goto L_0x011b
        L_0x0119:
            java.lang.String r13 = "null"
        L_0x011b:
            java.lang.String r15 = "All ArrayList elements must be of type Bundle. Value type, name"
            r12.c(r15, r13, r14)
            goto L_0x0132
        L_0x0121:
            r5 = r1
            android.os.Bundle r5 = (android.os.Bundle) r5
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r17
            r7 = r18
            r1.a0(r2, r3, r4, r5, r6, r7)
            r3 = r9
            goto L_0x00fe
        L_0x0131:
            return r0
        L_0x0132:
            r12 = 4
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d6.u(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    private final boolean u0(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo e5 = e.a(context).e(str, 64);
            if (e5 == null || (signatureArr = e5.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e6) {
            a().G().b("Error obtaining certificate", e6);
            return true;
        } catch (PackageManager.NameNotFoundException e7) {
            a().G().b("Package name not found", e7);
            return true;
        }
    }

    public static long v(long j4, long j5) {
        return (j4 + (j5 * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS)) / 86400000;
    }

    private static boolean v0(Bundle bundle, int i4) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i4);
        return true;
    }

    public static long x(D d5) {
        long j4 = 0;
        if (d5 == null) {
            return 0;
        }
        Iterator it = d5.iterator();
        while (it.hasNext()) {
            Object l4 = d5.l((String) it.next());
            if (l4 instanceof Parcelable[]) {
                j4 += (long) ((Parcelable[]) l4).length;
            }
        }
        return j4;
    }

    static Bundle[] x0(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    static long y(byte[] bArr) {
        boolean z4;
        C0335p.l(bArr);
        int i4 = 0;
        if (bArr.length > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0335p.o(z4);
        int length = bArr.length - 1;
        long j4 = 0;
        while (length >= 0 && length >= bArr.length - 8) {
            j4 += (((long) bArr[length]) & 255) << i4;
            i4 += 8;
            length--;
        }
        return j4;
    }

    static int y0() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public final /* bridge */ /* synthetic */ Context A() {
        return super.A();
    }

    /* access modifiers changed from: package-private */
    public final Object A0(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return I(P0(str), obj, true, false, (String) null);
        }
        return I(P0(str), obj, false, false, (String) null);
    }

    public final /* bridge */ /* synthetic */ d B() {
        return super.B();
    }

    public final /* bridge */ /* synthetic */ C0741c C() {
        return super.C();
    }

    /* access modifiers changed from: package-private */
    public final boolean C0(String str, String str2) {
        if (str2 == null) {
            a().H().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            a().H().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                a().H().c("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    a().H().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle E(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object s02 = s0(next, bundle.get(next));
                if (s02 == null) {
                    a().M().b("Param value can't be null", d().f(next));
                } else {
                    O(bundle2, next, s02);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public final boolean E0(String str, String str2) {
        if (r7.a() && b().q(G.f2520z0) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return b().R().equals(str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle F(java.lang.String r16, java.lang.String r17, android.os.Bundle r18, java.util.List r19, boolean r20) {
        /*
            r15 = this;
            r2 = r17
            r9 = r18
            r6 = r19
            java.lang.String[] r0 = f0.q.f3382d
            boolean r8 = n0(r2, r0)
            r10 = 0
            if (r9 == 0) goto L_0x00d6
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>(r9)
            com.google.android.gms.measurement.internal.g r0 = r15.b()
            int r11 = r0.v()
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r9.keySet()
            r0.<init>(r1)
            java.util.Iterator r12 = r0.iterator()
            r13 = 0
            r14 = 0
        L_0x002b:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x00d5
            java.lang.Object r0 = r12.next()
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            if (r6 == 0) goto L_0x0043
            boolean r0 = r6.contains(r3)
            if (r0 != 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r0 = 0
            goto L_0x0051
        L_0x0043:
            if (r20 != 0) goto L_0x004a
            int r0 = r15.O0(r3)
            goto L_0x004b
        L_0x004a:
            r0 = 0
        L_0x004b:
            if (r0 != 0) goto L_0x0051
            int r0 = r15.N0(r3)
        L_0x0051:
            if (r0 == 0) goto L_0x0060
            r1 = 3
            if (r0 != r1) goto L_0x0058
            r1 = r3
            goto L_0x0059
        L_0x0058:
            r1 = r10
        L_0x0059:
            L(r5, r0, r3, r1)
            r5.remove(r3)
            goto L_0x0092
        L_0x0060:
            java.lang.Object r4 = r9.get(r3)
            r0 = r15
            r1 = r16
            r7 = r20
            int r4 = r0.u(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 17
            if (r4 != r0) goto L_0x0077
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            L(r5, r4, r3, r0)
            goto L_0x0095
        L_0x0077:
            if (r4 == 0) goto L_0x0095
            java.lang.String r0 = "_ev"
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x0095
            r0 = 21
            if (r4 != r0) goto L_0x0087
            r0 = r2
            goto L_0x0088
        L_0x0087:
            r0 = r3
        L_0x0088:
            java.lang.Object r1 = r9.get(r3)
            L(r5, r4, r0, r1)
            r5.remove(r3)
        L_0x0092:
            r6 = r19
            goto L_0x002b
        L_0x0095:
            boolean r0 = K0(r3)
            if (r0 == 0) goto L_0x0092
            int r14 = r14 + 1
            if (r14 <= r11) goto L_0x0092
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Event can't contain more than "
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r1 = " params"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.measurement.internal.n2 r1 = r15.a()
            com.google.android.gms.measurement.internal.p2 r1 = r1.H()
            com.google.android.gms.measurement.internal.h2 r4 = r15.d()
            java.lang.String r4 = r4.c(r2)
            com.google.android.gms.measurement.internal.h2 r6 = r15.d()
            java.lang.String r6 = r6.a(r9)
            r1.c(r0, r4, r6)
            r0 = 5
            v0(r5, r0)
            r5.remove(r3)
            goto L_0x0092
        L_0x00d5:
            return r5
        L_0x00d6:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d6.F(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final boolean F0(String str) {
        k();
        if (e.a(A()).a(str) == 0) {
            return true;
        }
        a().F().b("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final E H(String str, String str2, Bundle bundle, String str3, long j4, boolean z4, boolean z5) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (s(str2) == 0) {
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            String str4 = str;
            String str5 = str2;
            Bundle F4 = F(str4, str5, bundle3, R.e.a("_o"), true);
            String str6 = str5;
            if (z4) {
                F4 = E(F4, str4);
            }
            C0335p.l(F4);
            long j5 = j4;
            return new E(str6, new D(F4), str3, j5);
        }
        a().G().b("Invalid conditional property event name", d().g(str2));
        throw new IllegalArgumentException();
    }

    public final int I0() {
        if (this.f2952h == null) {
            this.f2952h = Integer.valueOf(C0309h.f().a(A()) / 1000);
        }
        return this.f2952h.intValue();
    }

    public final URL K(long j4, String str, String str2, long j5, String str3) {
        try {
            C0335p.f(str2);
            C0335p.f(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{Long.valueOf(j4), Integer.valueOf(I0())}), str2, str, Long.valueOf(j5)});
            if (str.equals(b().S())) {
                format = format.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    format = format.concat("&");
                }
                format = format.concat(str3);
            }
            return new URL(format);
        } catch (MalformedURLException e5) {
            e = e5;
            a().G().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (IllegalArgumentException e6) {
            e = e6;
            a().G().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    public final boolean L0(String str) {
        List<ResolveInfo> queryIntentActivities;
        if (!TextUtils.isEmpty(str) && (queryIntentActivities = A().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0)) != null && !queryIntentActivities.isEmpty()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void M(Bundle bundle, long j4) {
        long j5 = bundle.getLong("_et");
        if (j5 != 0) {
            a().L().b("Params already contained engagement", Long.valueOf(j5));
        }
        bundle.putLong("_et", j4 + j5);
    }

    /* access modifiers changed from: package-private */
    public final void N(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String next : bundle2.keySet()) {
                if (!bundle.containsKey(next)) {
                    g().O(bundle, next, bundle2.get(next));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O(Bundle bundle, String str, Object obj) {
        String str2;
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                if (obj != null) {
                    str2 = obj.getClass().getSimpleName();
                } else {
                    str2 = null;
                }
                a().M().c("Not putting event parameter. Invalid value type. name, type", d().f(str), str2);
            }
        }
    }

    public final void P(U0 u02, int i4) {
        Bundle bundle = new Bundle();
        bundle.putInt(CampaignEx.JSON_KEY_AD_R, i4);
        try {
            u02.f(bundle);
        } catch (RemoteException e5) {
            this.f3273a.a().L().b("Error returning int value to wrapper", e5);
        }
    }

    public final void Q(U0 u02, long j4) {
        Bundle bundle = new Bundle();
        bundle.putLong(CampaignEx.JSON_KEY_AD_R, j4);
        try {
            u02.f(bundle);
        } catch (RemoteException e5) {
            this.f3273a.a().L().b("Error returning long value to wrapper", e5);
        }
    }

    /* access modifiers changed from: package-private */
    public final long Q0() {
        long j4;
        k();
        if (!D0(this.f3273a.y().F())) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j4 = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j4 = 8;
        } else if (y0() < ((Integer) G.f2452Y.a((Object) null)).intValue()) {
            j4 = 16;
        } else {
            j4 = 0;
        }
        if (!F0("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j4 |= 2;
        }
        if (j4 == 0 && !Z0()) {
            j4 |= 64;
        }
        if (j4 == 0) {
            return 1;
        }
        return j4;
    }

    public final void R(U0 u02, Bundle bundle) {
        try {
            u02.f(bundle);
        } catch (RemoteException e5) {
            this.f3273a.a().L().b("Error returning bundle value to wrapper", e5);
        }
    }

    public final long R0() {
        long andIncrement;
        long j4;
        if (this.f2948d.get() == 0) {
            synchronized (this.f2948d) {
                long nextLong = new Random(System.nanoTime() ^ B().currentTimeMillis()).nextLong();
                int i4 = this.f2949e + 1;
                this.f2949e = i4;
                j4 = nextLong + ((long) i4);
            }
            return j4;
        }
        synchronized (this.f2948d) {
            this.f2948d.compareAndSet(-1, 1);
            andIncrement = this.f2948d.getAndIncrement();
        }
        return andIncrement;
    }

    public final void S(U0 u02, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(CampaignEx.JSON_KEY_AD_R, str);
        try {
            u02.f(bundle);
        } catch (RemoteException e5) {
            this.f3273a.a().L().b("Error returning string value to wrapper", e5);
        }
    }

    public final void T(U0 u02, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(CampaignEx.JSON_KEY_AD_R, arrayList);
        try {
            u02.f(bundle);
        } catch (RemoteException e5) {
            this.f3273a.a().L().b("Error returning bundle list to wrapper", e5);
        }
    }

    /* access modifiers changed from: package-private */
    public final MeasurementManagerFutures T0() {
        if (this.f2950f == null) {
            this.f2950f = MeasurementManagerFutures.from(A());
        }
        return this.f2950f;
    }

    public final void U(U0 u02, boolean z4) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(CampaignEx.JSON_KEY_AD_R, z4);
        try {
            u02.f(bundle);
        } catch (RemoteException e5) {
            this.f3273a.a().L().b("Error returning boolean value to wrapper", e5);
        }
    }

    /* access modifiers changed from: package-private */
    public final String U0() {
        byte[] bArr = new byte[16];
        W0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public final void V(U0 u02, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(CampaignEx.JSON_KEY_AD_R, bArr);
        try {
            u02.f(bundle);
        } catch (RemoteException e5) {
            this.f3273a.a().L().b("Error returning byte array to wrapper", e5);
        }
    }

    /* access modifiers changed from: package-private */
    public final void W(C0848r2 r2Var, int i4) {
        int i5 = 0;
        for (String str : new TreeSet(r2Var.f3204d.keySet())) {
            if (K0(str) && (i5 = i5 + 1) > i4) {
                a().H().c("Event can't contain more than " + i4 + " params", d().c(r2Var.f3201a), d().a(r2Var.f3204d));
                v0(r2Var.f3204d, 5);
                r2Var.f3204d.remove(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final SecureRandom W0() {
        k();
        if (this.f2947c == null) {
            this.f2947c = new SecureRandom();
        }
        return this.f2947c;
    }

    /* access modifiers changed from: package-private */
    public final boolean X0() {
        k();
        if (Q0() == 1) {
            return true;
        }
        return false;
    }

    public final boolean Y0() {
        try {
            A().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final /* bridge */ /* synthetic */ C0821n2 a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ C0769g b() {
        return super.b();
    }

    /* access modifiers changed from: package-private */
    public final void b0(Parcelable[] parcelableArr, int i4) {
        C0335p.l(parcelableArr);
        for (Bundle bundle : parcelableArr) {
            int i5 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (K0(str) && !n0(str, s.f3388d) && (i5 = i5 + 1) > i4) {
                    a().H().c("Param can't contain more than " + i4 + " item-scoped custom parameters", d().f(str), d().a(bundle));
                    v0(bundle, 28);
                    bundle.remove(str);
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ C0887x c() {
        return super.c();
    }

    public final boolean c0(int i4, boolean z4) {
        Boolean W4 = this.f3273a.J().W();
        if (I0() >= i4 / 1000) {
            return true;
        }
        if (W4 == null || W4.booleanValue()) {
            return false;
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ C0779h2 d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ C0904z2 e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ P2 f() {
        return super.f();
    }

    public final /* bridge */ /* synthetic */ d6 g() {
        return super.g();
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    /* access modifiers changed from: package-private */
    public final boolean i0(String str, double d5) {
        try {
            SharedPreferences.Editor edit = A().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString("deeplink", str);
            edit.putLong(CampaignEx.JSON_KEY_TIMESTAMP, Double.doubleToRawLongBits(d5));
            return edit.commit();
        } catch (RuntimeException e5) {
            a().G().b("Failed to persist Deferred Deep Link. exception", e5);
            return false;
        }
    }

    public final /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    /* access modifiers changed from: package-private */
    public final boolean j0(String str, int i4, String str2) {
        if (str2 == null) {
            a().H().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i4) {
            return true;
        } else {
            a().H().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i4), str2);
            return false;
        }
    }

    public final /* bridge */ /* synthetic */ void k() {
        super.k();
    }

    /* access modifiers changed from: package-private */
    public final boolean k0(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (S0(str)) {
                return true;
            }
            if (this.f3273a.o()) {
                a().H().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", C0821n2.s(str));
            }
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            if (this.f3273a.o()) {
                a().H().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        } else if (S0(str2)) {
            return true;
        } else {
            a().H().b("Invalid admob_app_id. Analytics disabled.", C0821n2.s(str2));
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void l() {
        k();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                a().L().a("Utils falling back to Random for random id");
            }
        }
        this.f2948d.set(nextLong);
    }

    /* access modifiers changed from: package-private */
    public final boolean l0(String str, String str2, int i4, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i4) {
                a().M().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean o0(String str, String[] strArr, String str2) {
        return p0(str, strArr, (String[]) null, str2);
    }

    /* access modifiers changed from: package-private */
    public final boolean p0(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            a().H().b("Name is required and can't be null. Type", str);
            return false;
        }
        C0335p.l(str2);
        for (String startsWith : f2945i) {
            if (str2.startsWith(startsWith)) {
                a().H().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !n0(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && n0(str2, strArr2)) {
            return true;
        }
        a().H().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean q() {
        return true;
    }

    public final int r(int i4) {
        return C0309h.f().h(A(), C0313l.f342a);
    }

    /* access modifiers changed from: package-private */
    public final int r0(String str) {
        if (!w0("user property", str)) {
            return 6;
        }
        if (!o0("user property", r.f3383a, str)) {
            return 15;
        }
        if (!j0("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int s(String str) {
        if (!w0(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!p0(NotificationCompat.CATEGORY_EVENT, q.f3379a, q.f3380b, str)) {
            return 13;
        }
        if (!j0(NotificationCompat.CATEGORY_EVENT, 40, str)) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Object s0(String str, Object obj) {
        int o4;
        if ("_ev".equals(str)) {
            return I(b().u((String) null, false), obj, true, true, (String) null);
        }
        Object obj2 = obj;
        if (J0(str)) {
            o4 = b().u((String) null, false);
        } else {
            o4 = b().o((String) null, false);
        }
        return I(o4, obj2, false, true, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final int t(String str, Object obj) {
        boolean z4;
        if ("_ldl".equals(str)) {
            z4 = l0("user property referrer", str, P0(str), obj);
        } else {
            z4 = l0("user property", str, P0(str), obj);
        }
        if (z4) {
            return 0;
        }
        return 7;
    }

    /* access modifiers changed from: package-private */
    public final long w(Context context, String str) {
        k();
        C0335p.l(context);
        C0335p.f(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest V02 = V0();
        if (V02 == null) {
            a().G().a("Could not get MD5 instance");
            return -1;
        } else if (packageManager == null) {
            return 0;
        } else {
            try {
                if (u0(context, str)) {
                    return 0;
                }
                Signature[] signatureArr = e.a(context).e(A().getPackageName(), 64).signatures;
                if (signatureArr != null && signatureArr.length > 0) {
                    return y(V02.digest(signatureArr[0].toByteArray()));
                }
                a().L().a("Could not get signatures");
                return -1;
            } catch (PackageManager.NameNotFoundException e5) {
                a().G().b("Package name not found", e5);
                return 0;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean w0(String str, String str2) {
        if (str2 == null) {
            a().H().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            a().H().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        a().H().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            a().H().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final Bundle z(Uri uri, boolean z4) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Uri uri2 = uri;
        if (uri2 == null) {
            return null;
        }
        try {
            if (uri2.isHierarchical()) {
                str9 = uri2.getQueryParameter("utm_campaign");
                str8 = uri2.getQueryParameter("utm_source");
                str7 = uri2.getQueryParameter("utm_medium");
                str6 = uri2.getQueryParameter("gclid");
                if (z4) {
                    str5 = uri2.getQueryParameter("gbraid");
                } else {
                    str5 = null;
                }
                str4 = uri2.getQueryParameter("utm_id");
                str3 = uri2.getQueryParameter("dclid");
                str2 = uri2.getQueryParameter("srsltid");
                str = uri2.getQueryParameter("sfmc_id");
            } else {
                str9 = null;
                str8 = null;
                str7 = null;
                str6 = null;
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str9) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str6) && ((!z4 || TextUtils.isEmpty(str5)) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str))) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str9)) {
                str10 = "sfmc_id";
                bundle.putString("campaign", str9);
            } else {
                str10 = "sfmc_id";
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("source", str8);
            }
            if (!TextUtils.isEmpty(str7)) {
                bundle.putString("medium", str7);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("gclid", str6);
            }
            if (z4 && !TextUtils.isEmpty(str5)) {
                bundle.putString("gbraid", str5);
            }
            String queryParameter = uri2.getQueryParameter("gad_source");
            if (z4 && !TextUtils.isEmpty(queryParameter)) {
                bundle.putString("gad_source", queryParameter);
            }
            String queryParameter2 = uri2.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("term", queryParameter2);
            }
            String queryParameter3 = uri2.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("content", queryParameter3);
            }
            String queryParameter4 = uri2.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("aclid", queryParameter4);
            }
            String queryParameter5 = uri2.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("cp1", queryParameter5);
            }
            String queryParameter6 = uri2.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("anid", queryParameter6);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("campaign_id", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("dclid", str3);
            }
            String queryParameter7 = uri2.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("source_platform", queryParameter7);
            }
            String queryParameter8 = uri2.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("creative_format", queryParameter8);
            }
            String queryParameter9 = uri2.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString("marketing_tactic", queryParameter9);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("srsltid", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString(str10, str);
            }
            return bundle;
        } catch (UnsupportedOperationException e5) {
            a().L().b("Install referrer url isn't a hierarchical URI", e5);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final long z0(String str) {
        if (A().getPackageManager() == null) {
            return 0;
        }
        int i4 = 0;
        try {
            ApplicationInfo c5 = e.a(A()).c(str, 0);
            if (c5 != null) {
                i4 = c5.targetSdkVersion;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            a().J().b("PackageManager failed to find running app: app_id", str);
        }
        return (long) i4;
    }
}
