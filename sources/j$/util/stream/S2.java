package j$.util.stream;

import j$.time.format.r;
import j$.util.Objects;
import j$.util.function.Consumer$CC;
import j$.util.i0;
import j$.util.j0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class S2 extends C1154c implements Consumer, Iterable {

    /* renamed from: e  reason: collision with root package name */
    public Object[] f5402e = new Object[(1 << 4)];

    /* renamed from: f  reason: collision with root package name */
    public Object[][] f5403f;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final void r(long j4) {
        long j5;
        int i4 = this.f5479c;
        if (i4 == 0) {
            j5 = (long) this.f5402e.length;
        } else {
            j5 = this.f5480d[i4] + ((long) this.f5403f[i4].length);
        }
        if (j4 > j5) {
            if (this.f5403f == null) {
                Object[][] objArr = new Object[8][];
                this.f5403f = objArr;
                this.f5480d = new long[8];
                objArr[0] = this.f5402e;
            }
            int i5 = i4 + 1;
            while (j4 > j5) {
                Object[][] objArr2 = this.f5403f;
                if (i5 >= objArr2.length) {
                    int length = objArr2.length * 2;
                    this.f5403f = (Object[][]) Arrays.copyOf(objArr2, length);
                    this.f5480d = Arrays.copyOf(this.f5480d, length);
                }
                int i6 = this.f5477a;
                if (!(i5 == 0 || i5 == 1)) {
                    i6 = Math.min((i6 + i5) - 1, 30);
                }
                int i7 = 1 << i6;
                Object[][] objArr3 = this.f5403f;
                objArr3[i5] = new Object[i7];
                long[] jArr = this.f5480d;
                int i8 = i5 - 1;
                jArr[i5] = jArr[i8] + ((long) objArr3[i8].length);
                j5 += (long) i7;
                i5++;
            }
        }
    }

    public final void clear() {
        Object[][] objArr = this.f5403f;
        if (objArr != null) {
            this.f5402e = objArr[0];
            int i4 = 0;
            while (true) {
                Object[] objArr2 = this.f5402e;
                if (i4 >= objArr2.length) {
                    break;
                }
                objArr2[i4] = null;
                i4++;
            }
            this.f5403f = null;
            this.f5480d = null;
        } else {
            for (int i5 = 0; i5 < this.f5478b; i5++) {
                this.f5402e[i5] = null;
            }
        }
        this.f5478b = 0;
        this.f5479c = 0;
    }

    public final Iterator iterator() {
        i0 spliterator = spliterator();
        Objects.requireNonNull(spliterator);
        return new j0(spliterator);
    }

    public void forEach(Consumer consumer) {
        for (int i4 = 0; i4 < this.f5479c; i4++) {
            for (Object accept : this.f5403f[i4]) {
                consumer.accept(accept);
            }
        }
        for (int i5 = 0; i5 < this.f5478b; i5++) {
            consumer.accept(this.f5402e[i5]);
        }
    }

    public void accept(Object obj) {
        long j4;
        int i4 = this.f5478b;
        Object[] objArr = this.f5402e;
        if (i4 == objArr.length) {
            if (this.f5403f == null) {
                Object[][] objArr2 = new Object[8][];
                this.f5403f = objArr2;
                this.f5480d = new long[8];
                objArr2[0] = objArr;
            }
            int i5 = this.f5479c;
            int i6 = i5 + 1;
            Object[][] objArr3 = this.f5403f;
            if (i6 >= objArr3.length || objArr3[i6] == null) {
                if (i5 == 0) {
                    j4 = (long) objArr.length;
                } else {
                    j4 = ((long) objArr3[i5].length) + this.f5480d[i5];
                }
                r(j4 + 1);
            }
            this.f5478b = 0;
            int i7 = this.f5479c + 1;
            this.f5479c = i7;
            this.f5402e = this.f5403f[i7];
        }
        Object[] objArr4 = this.f5402e;
        int i8 = this.f5478b;
        this.f5478b = i8 + 1;
        objArr4[i8] = obj;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        Objects.requireNonNull(arrayList);
        forEach(new r(10, arrayList));
        String obj = arrayList.toString();
        return "SpinedBuffer:" + obj;
    }

    public i0 spliterator() {
        return new J2(this, 0, this.f5479c, 0, this.f5478b);
    }
}
