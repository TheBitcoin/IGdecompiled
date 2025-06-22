package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;

public final class Y0 extends H0 implements C1243w0 {
    public final /* synthetic */ void accept(double d5) {
        C1232t1.a();
        throw null;
    }

    public final /* synthetic */ void accept(int i4) {
        C1232t1.k();
        throw null;
    }

    public final /* synthetic */ void accept(long j4) {
        C1232t1.l();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ boolean m() {
        return false;
    }

    public final E0 a() {
        int i4 = this.f5309b;
        Object[] objArr = this.f5308a;
        if (i4 >= objArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f5309b), Integer.valueOf(objArr.length)}));
    }

    public final void k(long j4) {
        Object[] objArr = this.f5308a;
        if (j4 == ((long) objArr.length)) {
            this.f5309b = 0;
            return;
        }
        throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j4), Integer.valueOf(objArr.length)}));
    }

    public final void accept(Object obj) {
        int i4 = this.f5309b;
        Object[] objArr = this.f5308a;
        if (i4 < objArr.length) {
            this.f5309b = 1 + i4;
            objArr[i4] = obj;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(objArr.length)}));
    }

    public final void j() {
        int i4 = this.f5309b;
        Object[] objArr = this.f5308a;
        if (i4 < objArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f5309b), Integer.valueOf(objArr.length)}));
        }
    }

    public final String toString() {
        Object[] objArr = this.f5308a;
        return String.format("FixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(objArr.length - this.f5309b), Arrays.toString(objArr)});
    }
}
