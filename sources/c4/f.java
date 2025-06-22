package c4;

import C3.a;
import M2.c;
import S2.C1601o;
import T3.C2579g;
import V3.C2590a;
import V3.C2603n;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.data.storage.SharedStorage;
import kotlin.jvm.internal.m;

public final class f extends ViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final SharedStorage f24511a;

    /* renamed from: b  reason: collision with root package name */
    public final ChoiceCmpCallback f24512b;

    /* renamed from: c  reason: collision with root package name */
    public final C2590a f24513c;

    /* renamed from: d  reason: collision with root package name */
    public final C3.f f24514d;

    /* renamed from: e  reason: collision with root package name */
    public final C2579g f24515e;

    /* renamed from: f  reason: collision with root package name */
    public final c f24516f;

    public f(SharedStorage sharedStorage, ChoiceCmpCallback choiceCmpCallback, C2590a aVar, C3.f fVar, C2579g gVar, c cVar) {
        m.e(sharedStorage, "sharedStorage");
        m.e(aVar, "screenTexts");
        m.e(gVar, "tracking");
        m.e(cVar, "gbcPurposeResponse");
        this.f24511a = sharedStorage;
        this.f24512b = choiceCmpCallback;
        this.f24513c = aVar;
        this.f24514d = fVar;
        this.f24515e = gVar;
        this.f24516f = cVar;
    }

    public final String a() {
        a aVar;
        String str;
        C3.f fVar = this.f24514d;
        if (fVar == null || (aVar = fVar.f170b) == null || (str = aVar.f113E) == null) {
            return "";
        }
        return str;
    }

    public final String b() {
        C2603n nVar;
        String str;
        C3.f fVar = this.f24514d;
        if (fVar == null || (nVar = fVar.f174f) == null || (str = nVar.f24216h) == null) {
            return "";
        }
        return str;
    }

    public final boolean c() {
        C3.f fVar;
        a aVar;
        String str;
        if (b().length() <= 0 || (fVar = this.f24514d) == null || (aVar = fVar.f170b) == null || (str = aVar.f113E) == null || str.length() <= 0) {
            return false;
        }
        return true;
    }

    public final String d() {
        if (!this.f24513c.f24056b.isEmpty()) {
            return (String) C1601o.H(this.f24513c.f24056b);
        }
        return "";
    }

    public final boolean e() {
        boolean z4;
        a aVar;
        C3.f fVar = this.f24514d;
        if (fVar == null || (aVar = fVar.f170b) == null || !aVar.f111C) {
            z4 = false;
        } else {
            z4 = true;
        }
        return !z4;
    }

    public final String f() {
        a aVar;
        String str;
        C3.f fVar = this.f24514d;
        if (fVar == null || (aVar = fVar.f170b) == null || (str = aVar.f112D) == null) {
            return "";
        }
        return str;
    }

    public final String g() {
        C2603n nVar;
        String str;
        C3.f fVar = this.f24514d;
        if (fVar == null || (nVar = fVar.f174f) == null || (str = nVar.f24215g) == null) {
            return "";
        }
        return str;
    }

    public final boolean h() {
        C3.f fVar;
        a aVar;
        String str;
        if (g().length() <= 0 || (fVar = this.f24514d) == null || (aVar = fVar.f170b) == null || (str = aVar.f112D) == null || str.length() <= 0) {
            return false;
        }
        return true;
    }

    public final String i() {
        a aVar;
        String str;
        C3.f fVar = this.f24514d;
        if (fVar == null || (aVar = fVar.f170b) == null || (str = aVar.f114F) == null) {
            return "";
        }
        return str;
    }

    public final String j() {
        C2603n nVar;
        String str;
        C3.f fVar = this.f24514d;
        if (fVar == null || (nVar = fVar.f174f) == null || (str = nVar.f24214f) == null) {
            return "";
        }
        return str;
    }

    public final boolean k() {
        C3.f fVar;
        a aVar;
        String str;
        if (j().length() <= 0 || (fVar = this.f24514d) == null || (aVar = fVar.f170b) == null || (str = aVar.f114F) == null || str.length() <= 0) {
            return false;
        }
        return true;
    }
}
