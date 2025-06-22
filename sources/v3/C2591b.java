package V3;

import A2.a;
import android.graphics.Typeface;
import kotlin.jvm.internal.m;

/* renamed from: V3.b  reason: case insensitive filesystem */
public final class C2591b {

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f24061a;

    /* renamed from: b  reason: collision with root package name */
    public final Typeface f24062b;

    public C2591b(Typeface typeface, Typeface typeface2) {
        this.f24061a = typeface;
        this.f24062b = typeface2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2591b)) {
            return false;
        }
        C2591b bVar = (C2591b) obj;
        if (m.a(this.f24061a, bVar.f24061a) && m.a(this.f24062b, bVar.f24062b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        Typeface typeface = this.f24061a;
        int i5 = 0;
        if (typeface == null) {
            i4 = 0;
        } else {
            i4 = typeface.hashCode();
        }
        int i6 = i4 * 31;
        Typeface typeface2 = this.f24062b;
        if (typeface2 != null) {
            i5 = typeface2.hashCode();
        }
        return i6 + i5;
    }

    public String toString() {
        StringBuilder a5 = a.a("ChoiceFonts(bold=");
        a5.append(this.f24061a);
        a5.append(", regular=");
        a5.append(this.f24062b);
        a5.append(')');
        return a5.toString();
    }
}
