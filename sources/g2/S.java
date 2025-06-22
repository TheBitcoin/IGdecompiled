package g2;

import W1.C1612h;
import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.UptodownApp;
import g2.C2060s;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;
import u2.t;

public final class S implements Parcelable {
    public static Parcelable.Creator<S> CREATOR = new a();

    /* renamed from: j  reason: collision with root package name */
    public static final b f20455j = new b((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    private long f20456a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f20457b;

    /* renamed from: c  reason: collision with root package name */
    private long f20458c = -1;

    /* renamed from: d  reason: collision with root package name */
    private String f20459d;

    /* renamed from: e  reason: collision with root package name */
    private int f20460e;

    /* renamed from: f  reason: collision with root package name */
    private int f20461f;

    /* renamed from: g  reason: collision with root package name */
    private String f20462g;

    /* renamed from: h  reason: collision with root package name */
    private C2060s f20463h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList f20464i;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public S createFromParcel(Parcel parcel) {
            m.e(parcel, "source");
            return new S(parcel);
        }

        /* renamed from: b */
        public S[] newArray(int i4) {
            return new S[i4];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2103g gVar) {
            this();
        }

        public final int a(Context context) {
            m.e(context, "context");
            return b(context).size();
        }

        public final ArrayList b(Context context) {
            C2048f Y4;
            m.e(context, "context");
            t a5 = t.f21927u.a(context);
            a5.a();
            ArrayList arrayList = new ArrayList();
            Iterator it = a5.F0().iterator();
            m.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                m.d(next, "next(...)");
                S s4 = (S) next;
                if (!new C1612h().p(context, s4.h())) {
                    if (!m3.m.p(s4.h(), context.getPackageName(), true) || s4.j() <= 0) {
                        if (!s4.m() && (Y4 = a5.Y(s4.h())) != null && Y4.e() == 0 && Y4.C(context)) {
                            arrayList.add(s4);
                        }
                    } else if (s4.j() > 671) {
                        arrayList.add(s4);
                    }
                }
            }
            a5.i();
            return arrayList;
        }

        public final S c(C2048f fVar, JSONObject jSONObject) {
            m.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            m.e(jSONObject, "jsonObject");
            if (jSONObject.isNull("packagename")) {
                return null;
            }
            String optString = jSONObject.optString("packagename");
            m.b(optString);
            S s4 = new S(optString);
            if (!jSONObject.isNull("versionName")) {
                s4.u(jSONObject.optString("versionName"));
            }
            if (!jSONObject.isNull("versionCode")) {
                s4.t(jSONObject.optLong("versionCode"));
            }
            C2060s.c cVar = new C2060s.c();
            if (!jSONObject.isNull("size")) {
                cVar.q(jSONObject.optLong("size"));
            }
            if (!jSONObject.isNull("fileID")) {
                String optString2 = jSONObject.optString("fileID");
                try {
                    m.b(optString2);
                    cVar.m(Long.parseLong(optString2));
                } catch (NumberFormatException e5) {
                    e5.printStackTrace();
                }
                C2060s sVar = new C2060s();
                sVar.e(fVar, s4);
                sVar.o().add(cVar);
                s4.n(sVar);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("requiredFeatures");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    arrayList.add(optJSONArray.getString(i4));
                }
                s4.s(arrayList);
            }
            return s4;
        }

        private b() {
        }
    }

    public S(String str) {
        m.e(str, "packagename");
        this.f20457b = str;
    }

    public final C2060s a() {
        return this.f20463h;
    }

    public final C2060s b(Context context) {
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        C2060s sVar = this.f20463h;
        if (sVar != null) {
            m.b(sVar);
            if (sVar.q() >= 0) {
                C2060s sVar2 = this.f20463h;
                m.b(sVar2);
                this.f20463h = a5.g0(sVar2.q());
                a5.i();
                return this.f20463h;
            }
        }
        this.f20463h = a5.i0(this.f20457b, this.f20458c);
        a5.i();
        return this.f20463h;
    }

    public final boolean c() {
        return UptodownApp.f17422D.O(this);
    }

    public final long d() {
        return this.f20456a;
    }

    public int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f20461f;
    }

    public final String f() {
        return this.f20462g;
    }

    public final int g() {
        return this.f20460e;
    }

    public final String h() {
        return this.f20457b;
    }

    public final ArrayList i() {
        return this.f20464i;
    }

    public final long j() {
        return this.f20458c;
    }

    public final String k() {
        return this.f20459d;
    }

    public final boolean l(S s4) {
        boolean z4;
        Integer num;
        ArrayList o4;
        ArrayList o5;
        S s5 = s4;
        m.e(s5, "anotherUpdate");
        if (this.f20458c == s5.f20458c) {
            z4 = true;
        } else {
            z4 = false;
        }
        C2060s sVar = this.f20463h;
        Integer num2 = null;
        if (sVar == null || (o5 = sVar.o()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(o5.size());
        }
        C2060s sVar2 = s5.f20463h;
        if (!(sVar2 == null || (o4 = sVar2.o()) == null)) {
            num2 = Integer.valueOf(o4.size());
        }
        boolean a5 = m.a(num, num2);
        boolean p4 = m3.m.p(this.f20459d, s5.f20459d, true);
        if (!z4 || !a5 || !p4) {
            return true;
        }
        if (this.f20463h == null || s5.f20463h == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        C2060s sVar3 = this.f20463h;
        m.b(sVar3);
        arrayList.addAll(sVar3.o());
        ArrayList arrayList2 = new ArrayList();
        C2060s sVar4 = s5.f20463h;
        m.b(sVar4);
        arrayList2.addAll(sVar4.o());
        C2060s sVar5 = this.f20463h;
        m.b(sVar5);
        Iterator it = sVar5.o().iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2060s.c cVar = (C2060s.c) next;
            C2060s sVar6 = s5.f20463h;
            m.b(sVar6);
            Iterator it2 = sVar6.o().iterator();
            m.d(it2, "iterator(...)");
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                m.d(next2, "next(...)");
                C2060s.c cVar2 = (C2060s.c) next2;
                if (cVar2.d() == cVar.d()) {
                    arrayList.remove(cVar);
                    arrayList2.remove(cVar2);
                    break;
                }
            }
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        int i4 = this.f20461f;
        if (i4 == 1 || i4 == 2) {
            return true;
        }
        return false;
    }

    public final void n(C2060s sVar) {
        this.f20463h = sVar;
    }

    public final void o(long j4) {
        this.f20456a = j4;
    }

    public final void p(int i4) {
        this.f20461f = i4;
    }

    public final void q(String str) {
        this.f20462g = str;
    }

    public final void r(int i4) {
        this.f20460e = i4;
    }

    public final void s(ArrayList arrayList) {
        this.f20464i = arrayList;
    }

    public final void t(long j4) {
        this.f20458c = j4;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("{id=");
        sb.append(this.f20456a);
        sb.append(", packagename='");
        sb.append(this.f20457b);
        sb.append("', versionCode=");
        sb.append(this.f20458c);
        sb.append(", versionName='");
        sb.append(this.f20459d);
        sb.append("', notified=");
        sb.append(this.f20460e);
        sb.append(", ignoreVersion=");
        sb.append(this.f20461f);
        sb.append(", newFeatures='");
        sb.append(this.f20462g);
        sb.append("', download=");
        C2060s sVar = this.f20463h;
        if (sVar != null) {
            str = sVar.toString();
        } else {
            str = null;
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }

    public final void u(String str) {
        this.f20459d = str;
    }

    public void writeToParcel(Parcel parcel, int i4) {
        m.e(parcel, "parcel");
        parcel.writeLong(this.f20456a);
        parcel.writeString(this.f20457b);
        parcel.writeLong(this.f20458c);
        parcel.writeString(this.f20459d);
        parcel.writeInt(this.f20460e);
        parcel.writeInt(this.f20461f);
        parcel.writeString(this.f20462g);
        parcel.writeParcelable(this.f20463h, i4);
    }

    public S(Parcel parcel) {
        m.e(parcel, "source");
        this.f20456a = parcel.readLong();
        String readString = parcel.readString();
        m.b(readString);
        this.f20457b = readString;
        this.f20458c = parcel.readLong();
        this.f20459d = parcel.readString();
        this.f20460e = parcel.readInt();
        this.f20461f = parcel.readInt();
        this.f20462g = parcel.readString();
        Class<C2060s> cls = C2060s.class;
        if (Build.VERSION.SDK_INT >= 33) {
            this.f20463h = (C2060s) parcel.readParcelable(cls.getClassLoader(), cls);
        } else {
            this.f20463h = (C2060s) parcel.readParcelable(cls.getClassLoader());
        }
    }
}
