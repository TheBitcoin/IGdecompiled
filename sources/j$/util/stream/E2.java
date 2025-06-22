package j$.util.stream;

import j$.time.format.r;
import j$.util.C1127b;
import j$.util.Collection$EL;
import j$.util.Objects;
import java.util.ArrayList;

public final class E2 extends C1245w2 {

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f5279d;

    public final void k(long j4) {
        ArrayList arrayList;
        if (j4 < 2147483639) {
            if (j4 >= 0) {
                int i4 = (int) j4;
            } else {
                arrayList = new ArrayList();
            }
            this.f5279d = arrayList;
            return;
        }
        throw new IllegalArgumentException("Stream size exceeds max array size");
    }

    public final void j() {
        C1127b.w(this.f5279d, this.f5626b);
        C1187i2 i2Var = this.f5498a;
        i2Var.k((long) this.f5279d.size());
        if (!this.f5627c) {
            ArrayList arrayList = this.f5279d;
            Objects.requireNonNull(i2Var);
            Collection$EL.a(arrayList, new r(9, i2Var));
        } else {
            ArrayList arrayList2 = this.f5279d;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                if (i2Var.m()) {
                    break;
                }
                i2Var.accept(obj);
            }
        }
        i2Var.j();
        this.f5279d = null;
    }

    public final void accept(Object obj) {
        this.f5279d.add(obj);
    }
}
