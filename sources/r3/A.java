package r3;

import s3.d;

public final class A extends d {

    /* renamed from: a  reason: collision with root package name */
    public long f4138a = -1;

    /* renamed from: b  reason: collision with root package name */
    public V2.d f4139b;

    /* renamed from: c */
    public boolean a(y yVar) {
        if (this.f4138a >= 0) {
            return false;
        }
        this.f4138a = yVar.X();
        return true;
    }

    /* renamed from: d */
    public V2.d[] b(y yVar) {
        long j4 = this.f4138a;
        this.f4138a = -1;
        this.f4139b = null;
        return yVar.W(j4);
    }
}
