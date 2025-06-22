package b;

import C3.c;
import C3.f;
import E2.e;
import E2.g;
import E2.i;
import E2.j;
import E2.l;
import E2.s;
import G2.a;
import G2.g;
import I2.d;
import I2.g;
import I2.h;
import P2.a;
import P2.b;
import S2.C1601o;
import U3.C2589b;
import X3.C2607c;
import X3.C2609e;
import X3.k;
import X3.o;
import X3.q;
import X3.u;
import X3.w;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import b4.d;
import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import com.inmobi.cmp.data.storage.SharedStorage;
import com.inmobi.cmp.model.ChoiceError;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2103g;
import n1.C2160c;
import o1.C2175c;
import o1.C2180h;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public SharedStorage f1114a;

    /* renamed from: b  reason: collision with root package name */
    public final s f1115b;

    /* renamed from: c  reason: collision with root package name */
    public final f f1116c;

    /* renamed from: d  reason: collision with root package name */
    public final q f1117d;

    /* renamed from: e  reason: collision with root package name */
    public final C2607c f1118e;

    /* renamed from: f  reason: collision with root package name */
    public final u f1119f;

    /* renamed from: g  reason: collision with root package name */
    public w f1120g;

    /* renamed from: h  reason: collision with root package name */
    public final X3.m f1121h;

    /* renamed from: i  reason: collision with root package name */
    public final o f1122i;

    /* renamed from: j  reason: collision with root package name */
    public final k f1123j;

    /* renamed from: k  reason: collision with root package name */
    public final C2609e f1124k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1125l;

    /* renamed from: m  reason: collision with root package name */
    public e f1126m;

    /* renamed from: n  reason: collision with root package name */
    public b f1127n;

    /* renamed from: o  reason: collision with root package name */
    public int f1128o;

    /* renamed from: p  reason: collision with root package name */
    public g f1129p;

    public m(SharedStorage sharedStorage, s sVar, f fVar, q qVar, C2607c cVar, u uVar, w wVar, X3.m mVar, o oVar, k kVar, C2609e eVar) {
        kotlin.jvm.internal.m.e(sharedStorage, "storage");
        kotlin.jvm.internal.m.e(sVar, "tcModel");
        kotlin.jvm.internal.m.e(fVar, "portalConfig");
        kotlin.jvm.internal.m.e(qVar, "gvlRepository");
        kotlin.jvm.internal.m.e(cVar, "cmpRepository");
        kotlin.jvm.internal.m.e(uVar, "portalConfigRepository");
        kotlin.jvm.internal.m.e(wVar, "translationsTextRepository");
        kotlin.jvm.internal.m.e(mVar, "geoIPRepository");
        kotlin.jvm.internal.m.e(oVar, "googleVendorsRepository");
        kotlin.jvm.internal.m.e(kVar, "gbcRepository");
        kotlin.jvm.internal.m.e(eVar, "consentRepository");
        this.f1114a = sharedStorage;
        this.f1115b = sVar;
        this.f1116c = fVar;
        this.f1117d = qVar;
        this.f1118e = cVar;
        this.f1119f = uVar;
        this.f1120g = wVar;
        this.f1121h = mVar;
        this.f1122i = oVar;
        this.f1123j = kVar;
        this.f1124k = eVar;
        this.f1126m = new e((Map) null, 1);
        this.f1128o = -1;
        this.f1129p = new g((Long) null, (Map) null, 3);
        this.f1128o = g();
    }

    public final Vector a(Object obj) {
        ArrayList arrayList;
        Boolean bool;
        if (obj instanceof ArrayList) {
            arrayList = (ArrayList) obj;
        } else {
            arrayList = null;
        }
        Vector vector = new Vector((Map) null, 1, (C2103g) null);
        if (arrayList != null) {
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                int i6 = i4 + 1;
                if (i4 < 0) {
                    C1601o.o();
                }
                if (obj2 instanceof Boolean) {
                    bool = (Boolean) obj2;
                } else {
                    bool = null;
                }
                if (kotlin.jvm.internal.m.a(bool, Boolean.TRUE)) {
                    vector.set(i6);
                }
                i4 = i6;
            }
        }
        return vector;
    }

    public final boolean b() {
        String str;
        String str2;
        if (this.f1116c.f170b.f125Q.contains("EEA")) {
            b bVar = this.f1127n;
            if (bVar == null) {
                str = null;
            } else {
                str = bVar.f7989a;
            }
            int[] a5 = E2.b.a(32);
            int length = a5.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = a5[i4];
                i4++;
                String a6 = a.a(i5);
                if (str == null) {
                    str2 = null;
                } else {
                    str2 = str.toUpperCase(Locale.ROOT);
                    kotlin.jvm.internal.m.d(str2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                }
                if (kotlin.jvm.internal.m.a(a6, str2)) {
                    return true;
                }
            }
        }
        if (this.f1116c.f170b.f125Q.contains("WORLDWIDE")) {
            return true;
        }
        return false;
    }

    public final boolean c(Set set) {
        List list = this.f1116c.f170b.f135h;
        if (l.a(set) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (c.a((Number) it.next(), list)) {
                return true;
            }
        }
        return false;
    }

    public final Vector d(Object obj) {
        ArrayList arrayList;
        Integer num;
        if (obj instanceof ArrayList) {
            arrayList = (ArrayList) obj;
        } else {
            arrayList = null;
        }
        Vector vector = new Vector((Map) null, 1, (C2103g) null);
        if (arrayList != null) {
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj2 = arrayList.get(i4);
                i4++;
                if (obj2 instanceof Integer) {
                    num = (Integer) obj2;
                } else {
                    num = null;
                }
                if (num != null) {
                    vector.set(num.intValue());
                }
            }
        }
        return vector;
    }

    public final String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1116c.f170b.f127S.f158c);
        sb.append(this.f1116c.f170b.f127S.f156a);
        return C2589b.b(sb.toString());
    }

    public final String f() {
        return C2589b.b(this.f1116c.f171c.f168c + this.f1116c.f170b.f153z + this.f1116c.f170b.f149v + this.f1116c.f170b.f150w + this.f1116c.f170b.f148u + this.f1116c.f170b.f146s + this.f1116c.f170b.f147t);
    }

    public final int g() {
        int i4 = this.f1114a.i(a4.a.TCF_POLICY_VERSION);
        if (i4 != 0) {
            return i4;
        }
        return this.f1114a.i(a4.a.GPP_POLICY_VERSION);
    }

    public final int h() {
        Integer num;
        z3.e eVar = this.f1115b.f6391a;
        if (eVar == null) {
            num = null;
        } else {
            num = eVar.f4802c;
        }
        if (num != null) {
            return num.intValue();
        }
        int i4 = this.f1114a.i(a4.a.TCF_POLICY_VERSION);
        if (i4 != 0) {
            return i4;
        }
        return this.f1114a.i(a4.a.GPP_POLICY_VERSION);
    }

    public final int i() {
        Integer num;
        z3.e eVar = this.f1115b.f6391a;
        if (eVar == null) {
            num = null;
        } else {
            num = eVar.f4801b;
        }
        if (num == null) {
            return this.f1114a.i(a4.a.VENDOR_LIST_VERSION);
        }
        return num.intValue();
    }

    public final boolean j() {
        if (m()) {
            return !kotlin.jvm.internal.m.a(this.f1114a.j(a4.a.GBC_PURPOSE_HASH), e());
        }
        return false;
    }

    public final boolean k() {
        if (!this.f1116c.f170b.f121M) {
            return false;
        }
        String str = d.f24478n;
        kotlin.jvm.internal.m.e(A3.g.CALIFORNIA, MRAIDCommunicatorUtil.KEY_STATE);
        if (kotlin.jvm.internal.m.a(str, DownloadCommon.DOWNLOAD_REPORT_CANCEL)) {
            return true;
        }
        return false;
    }

    public final boolean l() {
        String str;
        b bVar = this.f1127n;
        if (bVar == null) {
            str = null;
        } else {
            str = bVar.f7989a;
        }
        return m3.m.p(str, "USA", true);
    }

    public final boolean m() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        c cVar = this.f1116c.f170b.f127S;
        if (cVar.f156a) {
            if (cVar.f157b.contains("WORLDWIDE")) {
                return true;
            }
            String str6 = null;
            if (this.f1116c.f170b.f127S.f157b.contains("EEA")) {
                b bVar = this.f1127n;
                if (bVar == null) {
                    str4 = null;
                } else {
                    str4 = bVar.f7989a;
                }
                int[] a5 = E2.b.a(32);
                int length = a5.length;
                int i4 = 0;
                while (i4 < length) {
                    int i5 = a5[i4];
                    i4++;
                    String a6 = a.a(i5);
                    if (str4 == null) {
                        str5 = null;
                    } else {
                        str5 = str4.toUpperCase(Locale.ROOT);
                        kotlin.jvm.internal.m.d(str5, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                    }
                    if (kotlin.jvm.internal.m.a(a6, str5)) {
                        return true;
                    }
                }
            }
            List list = this.f1116c.f170b.f127S.f157b;
            b bVar2 = this.f1127n;
            if (bVar2 == null || (str3 = bVar2.f7989a) == null) {
                str = null;
            } else {
                str = str3.toUpperCase(Locale.ROOT);
                kotlin.jvm.internal.m.d(str, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            }
            if (C1601o.B(list, str)) {
                return true;
            }
            List list2 = this.f1116c.f170b.f127S.f157b;
            b bVar3 = this.f1127n;
            if (!(bVar3 == null || (str2 = bVar3.f7989a) == null)) {
                str6 = str2.toLowerCase(Locale.ROOT);
                kotlin.jvm.internal.m.d(str6, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            if (C1601o.B(list2, str6)) {
                return true;
            }
        }
        return false;
    }

    public final boolean n() {
        SharedStorage sharedStorage = this.f1114a;
        a4.a aVar = a4.a.VENDOR_LIST_LAST_UPDATED;
        sharedStorage.getClass();
        kotlin.jvm.internal.m.e(aVar, "preferenceKey");
        long j4 = sharedStorage.f11786a.getLong("gvl_last_updated", 0);
        if (TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - j4) < ((long) this.f1116c.f170b.f109A) || i() <= this.f1114a.i(a4.a.VENDOR_LIST_VERSION)) {
            return true;
        }
        return false;
    }

    public final boolean o() {
        if (!this.f1116c.f170b.f129b.contains("USP")) {
            return false;
        }
        if (this.f1116c.f170b.f125Q.contains("WORLDWIDE") || this.f1116c.f170b.f125Q.contains("USA")) {
            return true;
        }
        return false;
    }

    public final void p() {
        String str;
        int i4;
        int i5;
        int i6;
        List list;
        int i7;
        String[] strArr;
        String str2;
        String str3;
        int i8;
        String str4;
        String str5;
        String[] strArr2;
        int i9;
        String str6;
        int i10;
        int i11;
        int i12;
        String[] strArr3;
        int i13;
        String str7;
        int intValue;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        String str8;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        String str9;
        int i29;
        int i30;
        String str10;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        int i37;
        int i38;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Integer b5;
        int i39;
        int i40;
        d dVar = d.f24465a;
        int i41 = 0;
        if (dVar.g().i(C2180h.f21393d)) {
            C2175c f4 = dVar.g().f(C2180h.f21393d);
            Vector vector = this.f1115b.f6408r;
            Object c5 = f4.c(C2160c.f21249m);
            kotlin.jvm.internal.m.d(c5, "gppModel.getFieldValue(\n…ONSENTS\n                )");
            vector.set(a(c5));
            Vector vector2 = this.f1115b.f6409s;
            vector2.unsetAllOwnedItems();
            Object c6 = f4.c(C2160c.f21250n);
            kotlin.jvm.internal.m.d(c6, "gppModel.getFieldValue(T…OSE_LEGITIMATE_INTERESTS)");
            vector2.set(a(c6));
            Vector vector3 = this.f1115b.f6407q;
            Object c7 = f4.c(C2160c.f21248l);
            kotlin.jvm.internal.m.d(c7, "gppModel.getFieldValue(T…d.SPECIAL_FEATURE_OPTINS)");
            vector3.set(a(c7));
            Vector vector4 = this.f1115b.f6416z;
            vector4.unsetAllOwnedItems();
            Object c8 = f4.c(C2160c.f21253q);
            kotlin.jvm.internal.m.d(c8, "gppModel.getFieldValue(T…uV2Field.VENDOR_CONSENTS)");
            vector4.setOwnedItems(d(c8));
            Vector vector5 = this.f1115b.f6386C;
            vector5.unsetAllOwnedItems();
            Object c9 = f4.c(C2160c.f21254r);
            kotlin.jvm.internal.m.d(c9, "gppModel.getFieldValue(T…DOR_LEGITIMATE_INTERESTS)");
            vector5.setOwnedItems(d(c9));
        } else {
            String j4 = this.f1114a.j(a4.a.TC_STRING);
            if (j4.length() > 0) {
                str = j4;
            } else {
                str = null;
            }
            if (str != null) {
                kotlin.jvm.internal.m.e(str, "encodedTCString");
                List j02 = m3.m.j0(str, new String[]{"."}, false, 0, 6, (Object) null);
                int size = j02.size();
                s sVar = new s((z3.e) null);
                int i42 = 0;
                while (i42 < i4) {
                    int i43 = i42 + 1;
                    String str16 = (String) j02.get(i42);
                    a.C0087a aVar = G2.a.f6588a;
                    String a5 = aVar.a(String.valueOf(str16.charAt(i41)));
                    G2.c cVar = G2.c.f6592a;
                    G2.d dVar2 = G2.d.SEGMENT_TYPE;
                    Integer a6 = cVar.a(dVar2);
                    if (a6 == null) {
                        i5 = 0;
                    } else {
                        i5 = a6.intValue();
                    }
                    String substring = a5.substring(i41, i5);
                    kotlin.jvm.internal.m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Set set = E2.m.f6377b;
                    d.a aVar2 = I2.d.f6695a;
                    Integer a7 = cVar.a(dVar2);
                    if (a7 == null) {
                        i6 = 0;
                    } else {
                        i6 = a7.intValue();
                    }
                    l lVar = (l) C1601o.C(set, aVar2.a(substring, i6));
                    g.a aVar3 = G2.g.f6612a;
                    String str17 = "encodedString";
                    kotlin.jvm.internal.m.e(str16, str17);
                    kotlin.jvm.internal.m.e(sVar, "tcModel");
                    kotlin.jvm.internal.m.e(lVar, "segment");
                    String a8 = aVar.a(str16);
                    l lVar2 = l.CORE;
                    String str18 = LeanbackPreferenceDialogFragment.ARG_KEY;
                    if (lVar == lVar2) {
                        E2.c cVar2 = E2.c.VERSION;
                        kotlin.jvm.internal.m.e(cVar2, str18);
                        Map map = G2.c.f6593b;
                        Integer num = (Integer) map.get(cVar2);
                        if (num == null) {
                            list = j02;
                            i39 = 0;
                        } else {
                            list = j02;
                            i39 = num.intValue();
                        }
                        String substring2 = a8.substring(i41, i39);
                        kotlin.jvm.internal.m.d(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        kotlin.jvm.internal.m.e(cVar2, str18);
                        Integer num2 = (Integer) map.get(cVar2);
                        if (num2 == null) {
                            i40 = 0;
                        } else {
                            i40 = num2.intValue();
                        }
                        sVar.f6399i = aVar2.a(substring2, i40);
                    } else {
                        list = j02;
                    }
                    if (lVar == lVar2 || (b5 = cVar.b("segmentType")) == null) {
                        i7 = 0;
                    } else {
                        i7 = b5.intValue();
                    }
                    if (sVar.f6399i == 1) {
                        strArr = (String[]) K2.a.f7283b.get(lVar.f6375a);
                    } else {
                        strArr = (String[]) K2.a.f7284c.get(lVar.f6375a);
                    }
                    if (strArr != null) {
                        int length = strArr.length;
                        int i44 = 0;
                        while (i44 < length) {
                            String str19 = strArr[i44];
                            int i45 = i44 + 1;
                            I2.b bVar = I2.b.f6692a;
                            kotlin.jvm.internal.m.e(str19, str18);
                            String str20 = (String) I2.b.f6693b.get(str19);
                            Integer b6 = G2.c.f6592a.b(str19);
                            if (b6 == null && G2.g.f6612a.a(str19)) {
                                b6 = Integer.valueOf(sVar.f6406p);
                            }
                            if ((b6 != null && b6.intValue() == 0) || b6 == null) {
                                str3 = a8;
                                i8 = i45;
                                str4 = str2;
                                str5 = str18;
                                i4 = i4;
                                strArr2 = strArr;
                                length = length;
                                i43 = i43;
                                i9 = i7;
                            } else {
                                try {
                                    str6 = a8.substring(i7, b6.intValue() + i7);
                                    kotlin.jvm.internal.m.d(str6, "this as java.lang.String…ing(startIndex, endIndex)");
                                } catch (IndexOutOfBoundsException unused) {
                                    str6 = m3.m.W(a8, b6.intValue() + i7, '0').substring(i7, b6.intValue() + i7);
                                    kotlin.jvm.internal.m.d(str6, "this as java.lang.String…ing(startIndex, endIndex)");
                                }
                                if (kotlin.jvm.internal.m.a(str19, "version")) {
                                    sVar.f6399i = I2.d.f6695a.a(str6, b6.intValue());
                                    i10 = i7;
                                    i13 = i4;
                                    strArr3 = strArr;
                                } else {
                                    if (kotlin.jvm.internal.m.a(str19, "created")) {
                                        i13 = i4;
                                        strArr3 = strArr;
                                        sVar.f6392b = I2.a.f6691a.a(str6, b6.intValue());
                                    } else {
                                        i13 = i4;
                                        strArr3 = strArr;
                                        if (kotlin.jvm.internal.m.a(str19, "lastUpdated")) {
                                            sVar.f6393c = I2.a.f6691a.a(str6, b6.intValue());
                                        } else {
                                            if (kotlin.jvm.internal.m.a(str19, "cmpId")) {
                                                i11 = i43;
                                                int a9 = I2.d.f6695a.a(str6, b6.intValue());
                                                if (a9 > -1) {
                                                    sVar.f6403m = a9;
                                                } else {
                                                    E2.u uVar = new E2.u("cmpId", String.valueOf(a9), "");
                                                    C2.b bVar2 = C2.b.f6277a;
                                                    ChoiceError choiceError = ChoiceError.TC_MODEL_PROPERTY_ERROR;
                                                    kotlin.jvm.internal.m.d("f.s", "TAG");
                                                    String message = uVar.getMessage();
                                                    if (message == null) {
                                                        str15 = "";
                                                    } else {
                                                        str15 = message;
                                                    }
                                                    bVar2.b(choiceError, "f.s", str15, C2.c.CONSOLE_AND_CALLBACK, uVar);
                                                }
                                            } else {
                                                i11 = i43;
                                                if (kotlin.jvm.internal.m.a(str19, "cmpVersion")) {
                                                    int a10 = I2.d.f6695a.a(str6, b6.intValue());
                                                    if (a10 > -1) {
                                                        sVar.f6404n = a10;
                                                    } else {
                                                        E2.u uVar2 = new E2.u("cmpVersion", String.valueOf(a10), "");
                                                        C2.b bVar3 = C2.b.f6277a;
                                                        ChoiceError choiceError2 = ChoiceError.TC_MODEL_PROPERTY_ERROR;
                                                        kotlin.jvm.internal.m.d("f.s", "TAG");
                                                        String message2 = uVar2.getMessage();
                                                        if (message2 == null) {
                                                            str14 = "";
                                                        } else {
                                                            str14 = message2;
                                                        }
                                                        bVar3.b(choiceError2, "f.s", str14, C2.c.CONSOLE_AND_CALLBACK, uVar2);
                                                    }
                                                } else if (kotlin.jvm.internal.m.a(str19, "consentScreen")) {
                                                    int a11 = I2.d.f6695a.a(str6, b6.intValue());
                                                    if (a11 > -1) {
                                                        sVar.f6400j = a11;
                                                    } else {
                                                        E2.u uVar3 = new E2.u("consentScreen", String.valueOf(a11), "");
                                                        C2.b bVar4 = C2.b.f6277a;
                                                        ChoiceError choiceError3 = ChoiceError.TC_MODEL_PROPERTY_ERROR;
                                                        kotlin.jvm.internal.m.d("f.s", "TAG");
                                                        String message3 = uVar3.getMessage();
                                                        if (message3 == null) {
                                                            str13 = "";
                                                        } else {
                                                            str13 = message3;
                                                        }
                                                        bVar4.b(choiceError3, "f.s", str13, C2.c.CONSOLE_AND_CALLBACK, uVar3);
                                                    }
                                                } else if (kotlin.jvm.internal.m.a(str19, "consentLanguage")) {
                                                    String a12 = I2.e.f6696a.a(str6, b6.intValue());
                                                    kotlin.jvm.internal.m.e(a12, "<set-?>");
                                                    sVar.f6402l = a12;
                                                } else if (kotlin.jvm.internal.m.a(str19, "vendorListVersion")) {
                                                    int a13 = I2.d.f6695a.a(str6, b6.intValue());
                                                    sVar.f6405o = a13;
                                                    if (a13 < 0) {
                                                        E2.u uVar4 = new E2.u("vendorListVersion", String.valueOf(a13), "");
                                                        C2.b bVar5 = C2.b.f6277a;
                                                        ChoiceError choiceError4 = ChoiceError.TC_MODEL_PROPERTY_ERROR;
                                                        kotlin.jvm.internal.m.d("f.s", "TAG");
                                                        String message4 = uVar4.getMessage();
                                                        if (message4 == null) {
                                                            str12 = "";
                                                        } else {
                                                            str12 = message4;
                                                        }
                                                        bVar5.b(choiceError4, "f.s", str12, C2.c.CONSOLE_AND_CALLBACK, uVar4);
                                                    }
                                                } else if (kotlin.jvm.internal.m.a(str19, "policyVersion")) {
                                                    int a14 = I2.d.f6695a.a(str6, b6.intValue());
                                                    sVar.f6401k = a14;
                                                    if (a14 < 0) {
                                                        E2.u uVar5 = new E2.u("policyVersion", String.valueOf(a14), "");
                                                        C2.b bVar6 = C2.b.f6277a;
                                                        ChoiceError choiceError5 = ChoiceError.TC_MODEL_PROPERTY_ERROR;
                                                        kotlin.jvm.internal.m.d("f.s", "TAG");
                                                        String message5 = uVar5.getMessage();
                                                        if (message5 == null) {
                                                            str11 = "";
                                                        } else {
                                                            str11 = message5;
                                                        }
                                                        bVar6.b(choiceError5, "f.s", str11, C2.c.CONSOLE_AND_CALLBACK, uVar5);
                                                    }
                                                } else {
                                                    String str21 = "1";
                                                    String str22 = "value";
                                                    if (kotlin.jvm.internal.m.a(str19, "isServiceSpecific")) {
                                                        kotlin.jvm.internal.m.e(str6, str22);
                                                        sVar.f6395e = kotlin.jvm.internal.m.a(str6, str21);
                                                    } else if (kotlin.jvm.internal.m.a(str19, "useNonStandardStacks")) {
                                                        kotlin.jvm.internal.m.e(str6, str22);
                                                        sVar.f6396f = kotlin.jvm.internal.m.a(str6, str21);
                                                    } else if (kotlin.jvm.internal.m.a(str19, "specialFeatureOptions")) {
                                                        sVar.f6407q = b.a(b6, I2.c.f6694a, str6, "<set-?>");
                                                    } else if (kotlin.jvm.internal.m.a(str19, "purposeConsents")) {
                                                        sVar.f6408r = b.a(b6, I2.c.f6694a, str6, "<set-?>");
                                                    } else if (kotlin.jvm.internal.m.a(str19, "purposeLegitimateInterests")) {
                                                        sVar.f6409s = b.a(b6, I2.c.f6694a, str6, "<set-?>");
                                                    } else if (kotlin.jvm.internal.m.a(str19, "purposeOneTreatment")) {
                                                        kotlin.jvm.internal.m.e(str6, str22);
                                                        sVar.f6397g = kotlin.jvm.internal.m.a(str6, str21);
                                                    } else if (kotlin.jvm.internal.m.a(str19, "publisherCountryCode")) {
                                                        sVar.b(I2.e.f6696a.a(str6, b6.intValue()));
                                                    } else if (kotlin.jvm.internal.m.a(str19, "vendorConsents")) {
                                                        h.a aVar4 = h.f6699a;
                                                        String substring3 = a8.substring(i7);
                                                        kotlin.jvm.internal.m.d(substring3, "this as java.lang.String).substring(startIndex)");
                                                        Vector a15 = aVar4.a(substring3);
                                                        kotlin.jvm.internal.m.e(a15, "<set-?>");
                                                        sVar.f6416z = a15;
                                                        b6 = Integer.valueOf(a15.getBitLength());
                                                    } else {
                                                        i12 = length;
                                                        if (kotlin.jvm.internal.m.a(str19, "vendorLegitimateInterests")) {
                                                            h.a aVar5 = h.f6699a;
                                                            String substring4 = a8.substring(i7);
                                                            kotlin.jvm.internal.m.d(substring4, "this as java.lang.String).substring(startIndex)");
                                                            Vector a16 = aVar5.a(substring4);
                                                            kotlin.jvm.internal.m.e(a16, "<set-?>");
                                                            sVar.f6386C = a16;
                                                            b6 = Integer.valueOf(a16.getBitLength());
                                                            i10 = i7;
                                                            str7 = a8;
                                                            i8 = i45;
                                                            str4 = str2;
                                                            str5 = str18;
                                                            i9 = b6.intValue() + i10;
                                                            i4 = i13;
                                                            strArr2 = strArr3;
                                                            length = i12;
                                                            i43 = i11;
                                                        } else {
                                                            if (kotlin.jvm.internal.m.a(str19, "publisherRestrictions")) {
                                                                g.a aVar6 = I2.g.f6698a;
                                                                z3.e eVar = new z3.e();
                                                                kotlin.jvm.internal.m.e(str6, str2);
                                                                kotlin.jvm.internal.m.e(eVar, "gvl");
                                                                j jVar = new j(eVar, (List) null, (List) null, (Map) null, 14);
                                                                d.a aVar7 = I2.d.f6695a;
                                                                G2.c cVar3 = G2.c.f6592a;
                                                                i10 = i7;
                                                                G2.d dVar3 = G2.d.NUM_RESTRICTIONS;
                                                                Integer a17 = cVar3.a(dVar3);
                                                                if (a17 == null) {
                                                                    str3 = a8;
                                                                    intValue = 0;
                                                                } else {
                                                                    str3 = a8;
                                                                    intValue = a17.intValue();
                                                                }
                                                                i8 = i45;
                                                                String substring5 = str6.substring(0, intValue);
                                                                kotlin.jvm.internal.m.d(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
                                                                Integer a18 = cVar3.a(dVar3);
                                                                if (a18 == null) {
                                                                    i14 = 0;
                                                                } else {
                                                                    i14 = a18.intValue();
                                                                }
                                                                int a19 = aVar7.a(substring5, i14);
                                                                Integer a20 = cVar3.a(dVar3);
                                                                if (a20 == null) {
                                                                    i15 = 0;
                                                                } else {
                                                                    i15 = a20.intValue();
                                                                }
                                                                int i46 = 0;
                                                                while (i46 < a19) {
                                                                    int i47 = i46 + 1;
                                                                    d.a aVar8 = I2.d.f6695a;
                                                                    G2.c cVar4 = G2.c.f6592a;
                                                                    int i48 = a19;
                                                                    G2.d dVar4 = G2.d.PURPOSE_ID;
                                                                    Integer a21 = cVar4.a(dVar4);
                                                                    if (a21 == null) {
                                                                        i16 = i47;
                                                                        i17 = 0;
                                                                    } else {
                                                                        i16 = i47;
                                                                        i17 = a21.intValue();
                                                                    }
                                                                    String substring6 = str6.substring(i15, i17);
                                                                    kotlin.jvm.internal.m.d(substring6, "this as java.lang.String…ing(startIndex, endIndex)");
                                                                    Integer a22 = cVar4.a(dVar4);
                                                                    if (a22 == null) {
                                                                        i18 = i15;
                                                                        i19 = 0;
                                                                    } else {
                                                                        i18 = i15;
                                                                        i19 = a22.intValue();
                                                                    }
                                                                    int a23 = aVar8.a(substring6, i19);
                                                                    Integer a24 = cVar4.a(dVar4);
                                                                    if (a24 == null) {
                                                                        i20 = 0;
                                                                    } else {
                                                                        i20 = a24.intValue();
                                                                    }
                                                                    int i49 = i18 + i20;
                                                                    G2.d dVar5 = G2.d.RESTRICTION_TYPE;
                                                                    Integer a25 = cVar4.a(dVar5);
                                                                    if (a25 == null) {
                                                                        str8 = str2;
                                                                        i21 = 0;
                                                                    } else {
                                                                        str8 = str2;
                                                                        i21 = a25.intValue();
                                                                    }
                                                                    String substring7 = str6.substring(i49, i21);
                                                                    kotlin.jvm.internal.m.d(substring7, "this as java.lang.String…ing(startIndex, endIndex)");
                                                                    Integer a26 = cVar4.a(dVar5);
                                                                    if (a26 == null) {
                                                                        i22 = i49;
                                                                        i23 = 0;
                                                                    } else {
                                                                        i22 = i49;
                                                                        i23 = a26.intValue();
                                                                    }
                                                                    int a27 = aVar8.a(substring7, i23);
                                                                    Integer a28 = cVar4.a(dVar5);
                                                                    if (a28 == null) {
                                                                        i24 = 0;
                                                                    } else {
                                                                        i24 = a28.intValue();
                                                                    }
                                                                    int i50 = i22 + i24;
                                                                    i iVar = new i(a23, E2.k.valueOf(String.valueOf(a27)));
                                                                    G2.d dVar6 = G2.d.NUM_ENTRIES;
                                                                    Integer a29 = cVar4.a(dVar6);
                                                                    if (a29 == null) {
                                                                        i25 = 0;
                                                                    } else {
                                                                        i25 = a29.intValue();
                                                                    }
                                                                    String substring8 = str6.substring(i50, i25);
                                                                    kotlin.jvm.internal.m.d(substring8, "this as java.lang.String…ing(startIndex, endIndex)");
                                                                    Integer a30 = cVar4.a(dVar6);
                                                                    if (a30 == null) {
                                                                        i26 = i50;
                                                                        i27 = 0;
                                                                    } else {
                                                                        i26 = i50;
                                                                        i27 = a30.intValue();
                                                                    }
                                                                    int a31 = aVar8.a(substring8, i27);
                                                                    Integer a32 = cVar4.a(dVar6);
                                                                    if (a32 == null) {
                                                                        i28 = 0;
                                                                    } else {
                                                                        i28 = a32.intValue();
                                                                    }
                                                                    int i51 = i26 + i28;
                                                                    if (a31 >= 0) {
                                                                        int i52 = 0;
                                                                        while (true) {
                                                                            G2.c cVar5 = G2.c.f6592a;
                                                                            int i53 = i52 + 1;
                                                                            G2.d dVar7 = G2.d.ANY_BOOLEAN;
                                                                            Integer a33 = cVar5.a(dVar7);
                                                                            if (a33 == null) {
                                                                                str9 = str18;
                                                                                i29 = 0;
                                                                            } else {
                                                                                str9 = str18;
                                                                                i29 = a33.intValue();
                                                                            }
                                                                            String substring9 = str6.substring(i51, i29);
                                                                            kotlin.jvm.internal.m.d(substring9, "this as java.lang.String…ing(startIndex, endIndex)");
                                                                            kotlin.jvm.internal.m.e(substring9, str22);
                                                                            boolean a34 = kotlin.jvm.internal.m.a(substring9, str21);
                                                                            Integer a35 = cVar5.a(dVar7);
                                                                            if (a35 == null) {
                                                                                i30 = 0;
                                                                            } else {
                                                                                i30 = a35.intValue();
                                                                            }
                                                                            int i54 = i51 + i30;
                                                                            d.a aVar9 = I2.d.f6695a;
                                                                            String str23 = str21;
                                                                            G2.d dVar8 = G2.d.VENDOR_ID;
                                                                            Integer a36 = cVar5.a(dVar8);
                                                                            if (a36 == null) {
                                                                                str10 = str22;
                                                                                i31 = 0;
                                                                            } else {
                                                                                str10 = str22;
                                                                                i31 = a36.intValue();
                                                                            }
                                                                            String substring10 = str6.substring(i54, i31);
                                                                            kotlin.jvm.internal.m.d(substring10, "this as java.lang.String…ing(startIndex, endIndex)");
                                                                            Integer a37 = cVar5.a(dVar8);
                                                                            if (a37 == null) {
                                                                                i32 = i54;
                                                                                i33 = 0;
                                                                            } else {
                                                                                i32 = i54;
                                                                                i33 = a37.intValue();
                                                                            }
                                                                            int a38 = aVar9.a(substring10, i33);
                                                                            Integer a39 = cVar5.a(dVar8);
                                                                            if (a39 == null) {
                                                                                i34 = 0;
                                                                            } else {
                                                                                i34 = a39.intValue();
                                                                            }
                                                                            int i55 = i32 + i34;
                                                                            if (a34) {
                                                                                Integer a40 = cVar5.a(dVar8);
                                                                                if (a40 == null) {
                                                                                    i35 = 0;
                                                                                } else {
                                                                                    i35 = a40.intValue();
                                                                                }
                                                                                String substring11 = str6.substring(i55, i35);
                                                                                kotlin.jvm.internal.m.d(substring11, "this as java.lang.String…ing(startIndex, endIndex)");
                                                                                Integer a41 = cVar5.a(dVar8);
                                                                                if (a41 == null) {
                                                                                    i36 = i55;
                                                                                    i37 = 0;
                                                                                } else {
                                                                                    i36 = i55;
                                                                                    i37 = a41.intValue();
                                                                                }
                                                                                int a42 = aVar9.a(substring11, i37);
                                                                                Integer a43 = cVar5.a(dVar8);
                                                                                if (a43 == null) {
                                                                                    i38 = 0;
                                                                                } else {
                                                                                    i38 = a43.intValue();
                                                                                }
                                                                                int i56 = i36 + i38;
                                                                                if (a42 >= a38) {
                                                                                    if (a38 <= a42) {
                                                                                        while (true) {
                                                                                            int i57 = a38 + 1;
                                                                                            jVar.c(a38, iVar);
                                                                                            if (a38 == a42) {
                                                                                                break;
                                                                                            }
                                                                                            a38 = i57;
                                                                                        }
                                                                                    }
                                                                                    i51 = i56;
                                                                                } else {
                                                                                    StringBuilder sb = new StringBuilder();
                                                                                    g.a aVar10 = I2.g.f6698a;
                                                                                    sb.append("h.g");
                                                                                    sb.append(": Invalid RangeEntry: endVendorId ");
                                                                                    sb.append(a42);
                                                                                    sb.append(" is less than ");
                                                                                    sb.append(a38);
                                                                                    throw new G2.e(sb.toString());
                                                                                }
                                                                            } else {
                                                                                jVar.c(a38, iVar);
                                                                                i51 = i55;
                                                                            }
                                                                            if (i52 == a31) {
                                                                                a19 = i48;
                                                                                i46 = i16;
                                                                                str2 = str8;
                                                                                str21 = str23;
                                                                                str18 = str9;
                                                                                str22 = str10;
                                                                                break;
                                                                            }
                                                                            i52 = i53;
                                                                            str21 = str23;
                                                                            str18 = str9;
                                                                            str22 = str10;
                                                                        }
                                                                    } else {
                                                                        a19 = i48;
                                                                        i46 = i16;
                                                                        str2 = str8;
                                                                    }
                                                                }
                                                                str4 = str2;
                                                                str5 = str18;
                                                                kotlin.jvm.internal.m.e(jVar, "<set-?>");
                                                                sVar.f6390G = jVar;
                                                            } else {
                                                                i10 = i7;
                                                                str3 = a8;
                                                                i8 = i45;
                                                                str4 = str2;
                                                                str5 = str18;
                                                                if (kotlin.jvm.internal.m.a(str19, "publisherConsents")) {
                                                                    sVar.f6412v = b.a(b6, I2.c.f6694a, str6, "<set-?>");
                                                                } else if (kotlin.jvm.internal.m.a(str19, "publisherLegitimateInterests")) {
                                                                    sVar.f6413w = b.a(b6, I2.c.f6694a, str6, "<set-?>");
                                                                } else if (kotlin.jvm.internal.m.a(str19, "numCustomPurposes")) {
                                                                    sVar.f6406p = I2.d.f6695a.a(str6, b6.intValue());
                                                                } else if (kotlin.jvm.internal.m.a(str19, "publisherCustomConsents")) {
                                                                    sVar.f6414x = b.a(b6, I2.c.f6694a, str6, "<set-?>");
                                                                } else if (kotlin.jvm.internal.m.a(str19, "publisherCustomLegitimateInterests")) {
                                                                    sVar.f6415y = b.a(b6, I2.c.f6694a, str6, "<set-?>");
                                                                } else if (kotlin.jvm.internal.m.a(str19, "vendorsAllowed")) {
                                                                    Vector a44 = h.f6699a.a(str6);
                                                                    kotlin.jvm.internal.m.e(a44, "<set-?>");
                                                                    sVar.f6389F = a44;
                                                                } else if (kotlin.jvm.internal.m.a(str19, "vendorsDisclosed")) {
                                                                    Vector a45 = h.f6699a.a(str6);
                                                                    kotlin.jvm.internal.m.e(a45, "<set-?>");
                                                                    sVar.f6388E = a45;
                                                                } else {
                                                                    g.a aVar11 = G2.g.f6612a;
                                                                    throw new G2.e("g.g" + ": Unable to find: " + str19 + " field on TCModel, segment");
                                                                }
                                                            }
                                                            i9 = b6.intValue() + i10;
                                                            i4 = i13;
                                                            strArr2 = strArr3;
                                                            length = i12;
                                                            i43 = i11;
                                                        }
                                                    }
                                                }
                                            }
                                            i10 = i7;
                                            str7 = a8;
                                            i12 = length;
                                            i8 = i45;
                                            str4 = str2;
                                            str5 = str18;
                                            i9 = b6.intValue() + i10;
                                            i4 = i13;
                                            strArr2 = strArr3;
                                            length = i12;
                                            i43 = i11;
                                        }
                                    }
                                    i10 = i7;
                                }
                                str7 = a8;
                                i11 = i43;
                                i12 = length;
                                i8 = i45;
                                str4 = str2;
                                str5 = str18;
                                i9 = b6.intValue() + i10;
                                i4 = i13;
                                strArr2 = strArr3;
                                length = i12;
                                i43 = i11;
                            }
                            i44 = i8;
                            a8 = str3;
                            str17 = str4;
                            str18 = str5;
                        }
                    }
                    j02 = list;
                    size = i4;
                    i42 = i43;
                    i41 = 0;
                }
                this.f1115b.f6408r.set(sVar.f6408r);
                Vector vector6 = this.f1115b.f6409s;
                vector6.unsetAllOwnedItems();
                vector6.set(sVar.f6409s);
                this.f1115b.f6407q.set(sVar.f6407q);
                Vector vector7 = this.f1115b.f6416z;
                vector7.unsetAllOwnedItems();
                vector7.setOwnedItems(sVar.f6416z);
                Vector vector8 = this.f1115b.f6386C;
                vector8.unsetAllOwnedItems();
                vector8.setOwnedItems(sVar.f6386C);
            }
        }
        b4.d dVar9 = b4.d.f24465a;
        if (dVar9.g().j(C2180h.f21395f) || this.f1114a.j(a4.a.TC_STRING).length() > 0) {
            String str24 = this.f1116c.f170b.f117I;
            if (str24 != null) {
                PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
                if (str24.equals(privacyEncodingMode.getValue())) {
                    if (!dVar9.g().i(C2180h.f21393d)) {
                        this.f1124k.a(privacyEncodingMode, false);
                    }
                    this.f1114a.b(a4.a.TCF_CMP_SDK_ID);
                    this.f1114a.b(a4.a.TCF_CMP_SDK_VERSION);
                    this.f1114a.b(a4.a.TCF_POLICY_VERSION);
                    this.f1114a.b(a4.a.TCF_GDPR_APPLIES);
                    this.f1114a.b(a4.a.TCF_PUBLISHER_CC);
                    this.f1114a.b(a4.a.TCF_PURPOSE_ONE_TREATMENT);
                    this.f1114a.b(a4.a.TCF_USE_NON_STANDARD_STACKS);
                    this.f1114a.b(a4.a.TC_STRING);
                    this.f1114a.b(a4.a.TCF_VENDOR_CONSENTS);
                    this.f1114a.b(a4.a.TCF_VENDOR_LEGITIMATE_INTERESTS);
                    this.f1114a.b(a4.a.TCF_PURPOSE_CONSENTS);
                    this.f1114a.b(a4.a.TCF_PURPOSE_LEGITIMATE_INTERESTS);
                    this.f1114a.b(a4.a.TCF_SPECIAL_FEATURES_OPT_INS);
                    this.f1114a.b(a4.a.TCF_PUBLISHER_RESTRICTIONS);
                    this.f1114a.b(a4.a.TCF_PUBLISHER_CONSENT);
                    this.f1114a.b(a4.a.TCF_PUBLISHER_LEGITIMATE_INTERESTS);
                    this.f1114a.b(a4.a.TCF_PUBLISHER_CUSTOM_PURPOSES_CONSENTS);
                    this.f1114a.b(a4.a.TCF_PUBLISHER_CUSTOM_PURPOSES_LEGITIMATE_INTERESTS);
                    return;
                }
            }
            String str25 = this.f1116c.f170b.f117I;
            if (str25 != null) {
                PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
                if (str25.equals(privacyEncodingMode2.getValue())) {
                    dVar9.g().b(C2180h.f21393d);
                    this.f1114a.b(a4.a.GPP_CMP_SDK_ID);
                    this.f1114a.b(a4.a.GPP_CMP_SDK_VERSION);
                    this.f1114a.b(a4.a.GPP_POLICY_VERSION);
                    this.f1114a.b(a4.a.GPP_GDPR_APPLIES);
                    this.f1114a.b(a4.a.GPP_PUBLISHER_CC);
                    this.f1114a.b(a4.a.GPP_PURPOSE_ONE_TREATMENT);
                    this.f1114a.b(a4.a.GPP_USE_NON_STANDARD_STACKS);
                    this.f1114a.b(a4.a.GPP_STRING);
                    this.f1114a.b(a4.a.GPP_VENDOR_CONSENTS);
                    this.f1114a.b(a4.a.GPP_VENDOR_LEGITIMATE_INTERESTS);
                    this.f1114a.b(a4.a.GPP_PURPOSE_CONSENTS);
                    this.f1114a.b(a4.a.GPP_PURPOSE_LEGITIMATE_INTERESTS);
                    this.f1114a.b(a4.a.GPP_SPECIAL_FEATURES_OPT_INS);
                    this.f1114a.b(a4.a.GPP_PUBLISHER_RESTRICTIONS);
                    this.f1114a.b(a4.a.GPP_PUBLISHER_CONSENT);
                    this.f1114a.b(a4.a.GPP_PUBLISHER_LEGITIMATE_INTERESTS);
                    this.f1114a.b(a4.a.GPP_PUBLISHER_CUSTOM_PURPOSES_CONSENTS);
                    this.f1114a.b(a4.a.GPP_PUBLISHER_CUSTOM_PURPOSES_LEGITIMATE_INTERESTS);
                    if (this.f1114a.j(a4.a.TC_STRING).length() == 0) {
                        this.f1124k.a(privacyEncodingMode2, false);
                        return;
                    }
                    return;
                }
            }
            if (!dVar9.g().i(C2180h.f21393d)) {
                this.f1124k.a(PrivacyEncodingMode.GPP, false);
            }
            if (this.f1114a.j(a4.a.TC_STRING).length() == 0) {
                this.f1124k.a(PrivacyEncodingMode.TCF, false);
            }
        }
    }

    public final void q() {
        this.f1114a.c(a4.a.GPP_CMP_SDK_ID, this.f1115b.f6403m);
        this.f1114a.c(a4.a.GPP_CMP_SDK_VERSION, this.f1115b.f6404n);
        this.f1114a.c(a4.a.GPP_POLICY_VERSION, this.f1115b.f());
        this.f1114a.c(a4.a.GPP_GDPR_APPLIES, b() ? 1 : 0);
        this.f1114a.e(a4.a.GPP_PUBLISHER_CC, this.f1116c.f170b.f133f);
        this.f1114a.c(a4.a.GPP_PURPOSE_ONE_TREATMENT, this.f1115b.f6397g ? 1 : 0);
        this.f1114a.c(a4.a.GPP_USE_NON_STANDARD_STACKS, this.f1115b.f6396f ? 1 : 0);
    }

    public final void r() {
        this.f1114a.c(a4.a.TCF_CMP_SDK_ID, this.f1115b.f6403m);
        this.f1114a.c(a4.a.TCF_CMP_SDK_VERSION, this.f1115b.f6404n);
        this.f1114a.c(a4.a.TCF_POLICY_VERSION, this.f1115b.f());
        this.f1114a.c(a4.a.TCF_GDPR_APPLIES, b() ? 1 : 0);
        this.f1114a.e(a4.a.TCF_PUBLISHER_CC, this.f1116c.f170b.f133f);
        this.f1114a.c(a4.a.TCF_PURPOSE_ONE_TREATMENT, this.f1115b.f6397g ? 1 : 0);
        this.f1114a.c(a4.a.TCF_USE_NON_STANDARD_STACKS, this.f1115b.f6396f ? 1 : 0);
    }

    public final boolean s() {
        boolean z4;
        if (this.f1114a.j(a4.a.TRANSLATIONS_TEXT).length() <= 0 || this.f1114a.j(a4.a.PORTAL_CONFIG).length() <= 0 || (this.f1129p.f6353b.containsKey(String.valueOf(this.f1115b.f6403m)) && n() && kotlin.jvm.internal.m.a(kotlin.jvm.internal.m.m(this.f1114a.j(a4.a.NON_IAB_VENDOR_CONSENT_HASH), f()), this.f1114a.j(a4.a.OPTION_HASH)) && this.f1128o == h() && ((this.f1114a.j(a4.a.TC_STRING).length() != 0 || b4.d.f24465a.g().j(C2180h.f21395f)) && !j()))) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (m()) {
            this.f1114a.e(a4.a.GBC_PURPOSE_HASH, e());
        }
        return z4;
    }
}
