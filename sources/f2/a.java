package F2;

import A3.k;
import E2.t;
import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import e4.e;
import kotlin.jvm.internal.m;

public final class a implements Parcelable {
    public static final C0083a CREATOR = new C0083a();

    /* renamed from: a  reason: collision with root package name */
    public final String f6469a;

    /* renamed from: b  reason: collision with root package name */
    public final String f6470b;

    /* renamed from: c  reason: collision with root package name */
    public final String f6471c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6472d;

    /* renamed from: e  reason: collision with root package name */
    public final String f6473e;

    /* renamed from: f  reason: collision with root package name */
    public final String f6474f;

    /* renamed from: g  reason: collision with root package name */
    public final String f6475g;

    /* renamed from: h  reason: collision with root package name */
    public final String f6476h;

    /* renamed from: i  reason: collision with root package name */
    public final String f6477i;

    /* renamed from: j  reason: collision with root package name */
    public final String f6478j;

    /* renamed from: k  reason: collision with root package name */
    public final String f6479k;

    /* renamed from: l  reason: collision with root package name */
    public final String f6480l;

    /* renamed from: m  reason: collision with root package name */
    public final int f6481m;

    /* renamed from: n  reason: collision with root package name */
    public final e f6482n;

    /* renamed from: o  reason: collision with root package name */
    public final String f6483o;

    /* renamed from: p  reason: collision with root package name */
    public final String f6484p;

    /* renamed from: F2.a$a  reason: collision with other inner class name */
    public static final class C0083a implements Parcelable.Creator {
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ba, code lost:
            if (r0 == 10) goto L_0x00bc;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object createFromParcel(android.os.Parcel r20) {
            /*
                r19 = this;
                r0 = r20
                java.lang.String r1 = "parcel"
                kotlin.jvm.internal.m.e(r0, r1)
                F2.a r2 = new F2.a
                kotlin.jvm.internal.m.e(r0, r1)
                java.lang.String r1 = r0.readString()
                java.lang.String r3 = ""
                if (r1 != 0) goto L_0x0015
                r1 = r3
            L_0x0015:
                java.lang.String r4 = r0.readString()
                if (r4 != 0) goto L_0x001c
                r4 = r3
            L_0x001c:
                java.lang.String r5 = r0.readString()
                if (r5 != 0) goto L_0x0023
                r5 = r3
            L_0x0023:
                java.lang.String r6 = r0.readString()
                if (r6 != 0) goto L_0x002a
                r6 = r3
            L_0x002a:
                java.lang.String r7 = r0.readString()
                if (r7 != 0) goto L_0x0031
                r7 = r3
            L_0x0031:
                java.lang.String r8 = r0.readString()
                if (r8 != 0) goto L_0x0038
                r8 = r3
            L_0x0038:
                java.lang.String r9 = r0.readString()
                if (r9 != 0) goto L_0x003f
                r9 = r3
            L_0x003f:
                java.lang.String r10 = r0.readString()
                if (r10 != 0) goto L_0x0046
                r10 = r3
            L_0x0046:
                java.lang.String r11 = r0.readString()
                if (r11 != 0) goto L_0x004d
                r11 = r3
            L_0x004d:
                java.lang.String r12 = r0.readString()
                if (r12 != 0) goto L_0x0054
                r12 = r3
            L_0x0054:
                java.lang.String r13 = r0.readString()
                if (r13 != 0) goto L_0x005b
                r13 = r3
            L_0x005b:
                java.lang.String r14 = r0.readString()
                if (r14 != 0) goto L_0x0062
                r14 = r3
            L_0x0062:
                int r15 = r0.readInt()
                int r0 = r20.readInt()
                e4.e r16 = e4.e.IAB_VENDOR
                r17 = r1
                r1 = 1
                if (r0 != r1) goto L_0x0072
                goto L_0x00be
            L_0x0072:
                e4.e r1 = e4.e.NON_IAB_VENDOR
                r18 = r1
                r1 = 2
                if (r0 != r1) goto L_0x007a
                goto L_0x00bc
            L_0x007a:
                e4.e r1 = e4.e.GOOGLE_VENDOR
                r18 = r1
                r1 = 3
                if (r0 != r1) goto L_0x0082
                goto L_0x00bc
            L_0x0082:
                e4.e r1 = e4.e.PUBLISHER_VENDOR
                r18 = r1
                r1 = 4
                if (r0 != r1) goto L_0x008a
                goto L_0x00bc
            L_0x008a:
                e4.e r1 = e4.e.PURPOSE
                r18 = r1
                r1 = 5
                if (r0 != r1) goto L_0x0092
                goto L_0x00bc
            L_0x0092:
                e4.e r1 = e4.e.SPECIAL_PURPOSE
                r18 = r1
                r1 = 6
                if (r0 != r1) goto L_0x009a
                goto L_0x00bc
            L_0x009a:
                e4.e r1 = e4.e.FEATURES
                r18 = r1
                r1 = 7
                if (r0 != r1) goto L_0x00a2
                goto L_0x00bc
            L_0x00a2:
                e4.e r1 = e4.e.SPECIAL_FEATURE
                r18 = r1
                r1 = 8
                if (r0 != r1) goto L_0x00ab
                goto L_0x00bc
            L_0x00ab:
                e4.e r1 = e4.e.GOOGLE_BASIC_CONSENT_PURPOSE
                r18 = r1
                r1 = 9
                if (r0 != r1) goto L_0x00b4
                goto L_0x00bc
            L_0x00b4:
                e4.e r1 = e4.e.PURPOSE_PARTNER
                r18 = r1
                r1 = 10
                if (r0 != r1) goto L_0x00be
            L_0x00bc:
                r16 = r18
            L_0x00be:
                java.lang.String r0 = r20.readString()
                if (r0 != 0) goto L_0x00c5
                r0 = r3
            L_0x00c5:
                java.lang.String r1 = r20.readString()
                if (r1 != 0) goto L_0x00d2
                r18 = r3
            L_0x00cd:
                r3 = r17
                r17 = r0
                goto L_0x00d5
            L_0x00d2:
                r18 = r1
                goto L_0x00cd
            L_0x00d5:
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: F2.a.C0083a.createFromParcel(android.os.Parcel):java.lang.Object");
        }

        public Object[] newArray(int i4) {
            return new a[i4];
        }
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i4, e eVar, String str13, String str14) {
        String str15 = str;
        String str16 = str3;
        String str17 = str4;
        String str18 = str5;
        String str19 = str6;
        String str20 = str7;
        String str21 = str8;
        String str22 = str9;
        String str23 = str10;
        String str24 = str11;
        String str25 = str12;
        e eVar2 = eVar;
        String str26 = str13;
        String str27 = str14;
        m.e(str15, RewardPlus.NAME);
        m.e(str16, "purposes");
        m.e(str17, "legitimateInterests");
        m.e(str18, "specialPurposes");
        m.e(str19, "features");
        m.e(str20, "specialFeatures");
        m.e(str21, "dataDeclarations");
        m.e(str22, "privacyPolicy");
        m.e(str23, "cookieMaxAge");
        m.e(str24, "usesNonCookieAccess");
        m.e(str25, "dataRetention");
        m.e(eVar2, "switchItemType");
        m.e(str26, "disclosuresUrl");
        m.e(str27, "disclosuresErrorLabel");
        this.f6469a = str15;
        this.f6470b = str2;
        this.f6471c = str16;
        this.f6472d = str17;
        this.f6473e = str18;
        this.f6474f = str19;
        this.f6475g = str20;
        this.f6476h = str21;
        this.f6477i = str22;
        this.f6478j = str23;
        this.f6479k = str24;
        this.f6480l = str25;
        this.f6481m = i4;
        this.f6482n = eVar2;
        this.f6483o = str26;
        this.f6484p = str27;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (m.a(this.f6469a, aVar.f6469a) && m.a(this.f6470b, aVar.f6470b) && m.a(this.f6471c, aVar.f6471c) && m.a(this.f6472d, aVar.f6472d) && m.a(this.f6473e, aVar.f6473e) && m.a(this.f6474f, aVar.f6474f) && m.a(this.f6475g, aVar.f6475g) && m.a(this.f6476h, aVar.f6476h) && m.a(this.f6477i, aVar.f6477i) && m.a(this.f6478j, aVar.f6478j) && m.a(this.f6479k, aVar.f6479k) && m.a(this.f6480l, aVar.f6480l) && this.f6481m == aVar.f6481m && this.f6482n == aVar.f6482n && m.a(this.f6483o, aVar.f6483o) && m.a(this.f6484p, aVar.f6484p)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = this.f6469a.hashCode() * 31;
        String str = this.f6470b;
        if (str == null) {
            i4 = 0;
        } else {
            i4 = str.hashCode();
        }
        int a5 = k.a(this.f6481m, t.a(this.f6480l, t.a(this.f6479k, t.a(this.f6478j, t.a(this.f6477i, t.a(this.f6476h, t.a(this.f6475g, t.a(this.f6474f, t.a(this.f6473e, t.a(this.f6472d, t.a(this.f6471c, (hashCode + i4) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
        return this.f6484p.hashCode() + t.a(this.f6483o, (this.f6482n.hashCode() + a5) * 31, 31);
    }

    public String toString() {
        return "PartnersDetailDialogArgs(name=" + this.f6469a + ", description=" + this.f6470b + ", purposes=" + this.f6471c + ", legitimateInterests=" + this.f6472d + ", specialPurposes=" + this.f6473e + ", features=" + this.f6474f + ", specialFeatures=" + this.f6475g + ", dataDeclarations=" + this.f6476h + ", privacyPolicy=" + this.f6477i + ", cookieMaxAge=" + this.f6478j + ", usesNonCookieAccess=" + this.f6479k + ", dataRetention=" + this.f6480l + ", vendorId=" + this.f6481m + ", switchItemType=" + this.f6482n + ", disclosuresUrl=" + this.f6483o + ", disclosuresErrorLabel=" + this.f6484p + ')';
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeString(this.f6469a);
        parcel.writeString(this.f6470b);
        parcel.writeString(this.f6471c);
        parcel.writeString(this.f6472d);
        parcel.writeString(this.f6473e);
        parcel.writeString(this.f6474f);
        parcel.writeString(this.f6475g);
        parcel.writeString(this.f6476h);
        parcel.writeString(this.f6477i);
        parcel.writeString(this.f6478j);
        parcel.writeString(this.f6479k);
        parcel.writeString(this.f6480l);
        parcel.writeInt(this.f6481m);
        parcel.writeInt(this.f6482n.f24652a);
        parcel.writeString(this.f6483o);
        parcel.writeString(this.f6484p);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, int r30, e4.e r31, java.lang.String r32, java.lang.String r33, int r34) {
        /*
            r17 = this;
            r0 = r34
            r1 = r0 & 1
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000c
        L_0x000a:
            r1 = r18
        L_0x000c:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r3 = r2
            goto L_0x0014
        L_0x0012:
            r3 = r19
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = r2
            goto L_0x001c
        L_0x001a:
            r4 = r20
        L_0x001c:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0022
            r5 = r2
            goto L_0x0024
        L_0x0022:
            r5 = r21
        L_0x0024:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x002a
            r6 = r2
            goto L_0x002c
        L_0x002a:
            r6 = r22
        L_0x002c:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0032
            r7 = r2
            goto L_0x0034
        L_0x0032:
            r7 = r23
        L_0x0034:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003a
            r8 = r2
            goto L_0x003c
        L_0x003a:
            r8 = r24
        L_0x003c:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0042
            r9 = r2
            goto L_0x0044
        L_0x0042:
            r9 = r25
        L_0x0044:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x004a
            r10 = r2
            goto L_0x004c
        L_0x004a:
            r10 = r26
        L_0x004c:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0052
            r11 = r2
            goto L_0x0054
        L_0x0052:
            r11 = r27
        L_0x0054:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x005a
            r12 = r2
            goto L_0x005c
        L_0x005a:
            r12 = r28
        L_0x005c:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0062
            r13 = r2
            goto L_0x0064
        L_0x0062:
            r13 = r29
        L_0x0064:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x006a
            r14 = 0
            goto L_0x006c
        L_0x006a:
            r14 = r30
        L_0x006c:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0073
            e4.e r15 = e4.e.IAB_VENDOR
            goto L_0x0075
        L_0x0073:
            r15 = r31
        L_0x0075:
            r18 = r1
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x007d
            r1 = r2
            goto L_0x007f
        L_0x007d:
            r1 = r32
        L_0x007f:
            r16 = 32768(0x8000, float:4.5918E-41)
            r0 = r0 & r16
            if (r0 == 0) goto L_0x00a9
            r34 = r2
        L_0x0088:
            r19 = r18
            r33 = r1
            r20 = r3
            r21 = r4
            r22 = r5
            r23 = r6
            r24 = r7
            r25 = r8
            r26 = r9
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r18 = r17
            goto L_0x00ac
        L_0x00a9:
            r34 = r33
            goto L_0x0088
        L_0x00ac:
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: F2.a.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, e4.e, java.lang.String, java.lang.String, int):void");
    }
}
