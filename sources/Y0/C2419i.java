package y0;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: y0.i  reason: case insensitive filesystem */
class C2419i {

    /* renamed from: b  reason: collision with root package name */
    private static final String f22642b = C2420j.z(UUID.randomUUID().toString() + System.currentTimeMillis());

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicLong f22643c = new AtomicLong(0);

    /* renamed from: a  reason: collision with root package name */
    private final String f22644a;

    C2419i() {
        byte[] bArr = new byte[10];
        f(bArr);
        e(bArr);
        d(bArr);
        String t4 = C2420j.t(bArr);
        Locale locale = Locale.US;
        this.f22644a = String.format(locale, "%s%s%s%s", new Object[]{t4.substring(0, 12), t4.substring(12, 16), t4.subSequence(16, 20), f22642b.substring(0, 12)}).toUpperCase(locale);
    }

    private static byte[] a(long j4) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j4);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] b(long j4) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j4));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private void d(byte[] bArr) {
        byte[] b5 = b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b5[0];
        bArr[9] = b5[1];
    }

    private void e(byte[] bArr) {
        byte[] b5 = b(f22643c.incrementAndGet());
        bArr[6] = b5[0];
        bArr[7] = b5[1];
    }

    private void f(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a5 = a(time / 1000);
        bArr[0] = a5[0];
        bArr[1] = a5[1];
        bArr[2] = a5[2];
        bArr[3] = a5[3];
        byte[] b5 = b(time % 1000);
        bArr[4] = b5[0];
        bArr[5] = b5[1];
    }

    public String c() {
        return this.f22644a;
    }

    public String toString() {
        return this.f22644a;
    }
}
