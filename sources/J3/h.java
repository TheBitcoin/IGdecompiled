package J3;

import E3.c;
import J3.C2489d;
import N3.C2514e;
import N3.C2516g;
import N3.C2517h;
import N3.Z;
import N3.a0;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class h implements Closeable, AutoCloseable {

    /* renamed from: e  reason: collision with root package name */
    static final Logger f23552e = Logger.getLogger(C2490e.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final C2516g f23553a;

    /* renamed from: b  reason: collision with root package name */
    private final a f23554b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23555c;

    /* renamed from: d  reason: collision with root package name */
    final C2489d.a f23556d;

    interface b {
        void a(int i4, C2487b bVar, C2517h hVar);

        void ackSettings();

        void b(boolean z4, int i4, C2516g gVar, int i5);

        void c(int i4, C2487b bVar);

        void d(boolean z4, m mVar);

        void headers(boolean z4, int i4, int i5, List list);

        void ping(boolean z4, int i4, int i5);

        void priority(int i4, int i5, int i6, boolean z4);

        void pushPromise(int i4, int i5, List list);

        void windowUpdate(int i4, long j4);
    }

    h(C2516g gVar, boolean z4) {
        this.f23553a = gVar;
        this.f23555c = z4;
        a aVar = new a(gVar);
        this.f23554b = aVar;
        this.f23556d = new C2489d.a(4096, aVar);
    }

    static int a(int i4, byte b5, short s4) {
        if ((b5 & 8) != 0) {
            i4--;
        }
        if (s4 <= i4) {
            return (short) (i4 - s4);
        }
        throw C2490e.d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s4), Integer.valueOf(i4));
    }

    private void i(b bVar, int i4, byte b5, int i5) {
        boolean z4;
        short s4 = 0;
        if (i5 != 0) {
            if ((b5 & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((b5 & 32) == 0) {
                if ((b5 & 8) != 0) {
                    s4 = (short) (this.f23553a.readByte() & 255);
                }
                bVar.b(z4, i5, this.f23553a, a(i4, b5, s4));
                this.f23553a.skip((long) s4);
                return;
            }
            throw C2490e.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw C2490e.d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void k(b bVar, int i4, byte b5, int i5) {
        if (i4 < 8) {
            throw C2490e.d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i4));
        } else if (i5 == 0) {
            int readInt = this.f23553a.readInt();
            int readInt2 = this.f23553a.readInt();
            int i6 = i4 - 8;
            C2487b a5 = C2487b.a(readInt2);
            if (a5 != null) {
                C2517h hVar = C2517h.f23705e;
                if (i6 > 0) {
                    hVar = this.f23553a.readByteString((long) i6);
                }
                bVar.a(readInt, a5, hVar);
                return;
            }
            throw C2490e.d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        } else {
            throw C2490e.d("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private List l(int i4, short s4, byte b5, int i5) {
        a aVar = this.f23554b;
        aVar.f23561e = i4;
        aVar.f23558b = i4;
        aVar.f23562f = s4;
        aVar.f23559c = b5;
        aVar.f23560d = i5;
        this.f23556d.k();
        return this.f23556d.e();
    }

    private void n(b bVar, int i4, byte b5, int i5) {
        boolean z4;
        short s4 = 0;
        if (i5 != 0) {
            if ((b5 & 1) != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if ((b5 & 8) != 0) {
                s4 = (short) (this.f23553a.readByte() & 255);
            }
            if ((b5 & 32) != 0) {
                r(bVar, i5);
                i4 -= 5;
            }
            bVar.headers(z4, i5, -1, l(a(i4, b5, s4), s4, b5, i5));
            return;
        }
        throw C2490e.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    static int o(C2516g gVar) {
        return (gVar.readByte() & 255) | ((gVar.readByte() & 255) << 16) | ((gVar.readByte() & 255) << 8);
    }

    private void p(b bVar, int i4, byte b5, int i5) {
        boolean z4 = true;
        if (i4 != 8) {
            throw C2490e.d("TYPE_PING length != 8: %s", Integer.valueOf(i4));
        } else if (i5 == 0) {
            int readInt = this.f23553a.readInt();
            int readInt2 = this.f23553a.readInt();
            if ((b5 & 1) == 0) {
                z4 = false;
            }
            bVar.ping(z4, readInt, readInt2);
        } else {
            throw C2490e.d("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void r(b bVar, int i4) {
        boolean z4;
        int readInt = this.f23553a.readInt();
        if ((Integer.MIN_VALUE & readInt) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        bVar.priority(i4, readInt & Integer.MAX_VALUE, (this.f23553a.readByte() & 255) + 1, z4);
    }

    private void u(b bVar, int i4, byte b5, int i5) {
        if (i4 != 5) {
            throw C2490e.d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i4));
        } else if (i5 != 0) {
            r(bVar, i5);
        } else {
            throw C2490e.d("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void v(b bVar, int i4, byte b5, int i5) {
        short s4 = 0;
        if (i5 != 0) {
            if ((b5 & 8) != 0) {
                s4 = (short) (this.f23553a.readByte() & 255);
            }
            bVar.pushPromise(i5, this.f23553a.readInt() & Integer.MAX_VALUE, l(a(i4 - 4, b5, s4), s4, b5, i5));
            return;
        }
        throw C2490e.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void w(b bVar, int i4, byte b5, int i5) {
        if (i4 != 4) {
            throw C2490e.d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i4));
        } else if (i5 != 0) {
            int readInt = this.f23553a.readInt();
            C2487b a5 = C2487b.a(readInt);
            if (a5 != null) {
                bVar.c(i5, a5);
                return;
            }
            throw C2490e.d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
        } else {
            throw C2490e.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void x(b bVar, int i4, byte b5, int i5) {
        if (i5 != 0) {
            throw C2490e.d("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b5 & 1) != 0) {
            if (i4 == 0) {
                bVar.ackSettings();
                return;
            }
            throw C2490e.d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i4 % 6 == 0) {
            m mVar = new m();
            for (int i6 = 0; i6 < i4; i6 += 6) {
                short readShort = this.f23553a.readShort() & 65535;
                int readInt = this.f23553a.readInt();
                if (readShort != 2) {
                    if (readShort == 3) {
                        readShort = 4;
                    } else if (readShort != 4) {
                        if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                            throw C2490e.d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        }
                    } else if (readInt >= 0) {
                        readShort = 7;
                    } else {
                        throw C2490e.d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                } else if (!(readInt == 0 || readInt == 1)) {
                    throw C2490e.d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                }
                mVar.i(readShort, readInt);
            }
            bVar.d(false, mVar);
        } else {
            throw C2490e.d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i4));
        }
    }

    private void z(b bVar, int i4, byte b5, int i5) {
        if (i4 == 4) {
            long readInt = ((long) this.f23553a.readInt()) & 2147483647L;
            if (readInt != 0) {
                bVar.windowUpdate(i5, readInt);
            } else {
                throw C2490e.d("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
        } else {
            throw C2490e.d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i4));
        }
    }

    public void close() {
        this.f23553a.close();
    }

    public boolean d(boolean z4, b bVar) {
        try {
            this.f23553a.require(9);
            int o4 = o(this.f23553a);
            if (o4 < 0 || o4 > 16384) {
                throw C2490e.d("FRAME_SIZE_ERROR: %s", Integer.valueOf(o4));
            }
            byte readByte = (byte) (this.f23553a.readByte() & 255);
            if (!z4 || readByte == 4) {
                byte readByte2 = (byte) (this.f23553a.readByte() & 255);
                int readInt = this.f23553a.readInt() & Integer.MAX_VALUE;
                Logger logger = f23552e;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(C2490e.b(true, readInt, o4, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        i(bVar, o4, readByte2, readInt);
                        break;
                    case 1:
                        n(bVar, o4, readByte2, readInt);
                        break;
                    case 2:
                        u(bVar, o4, readByte2, readInt);
                        break;
                    case 3:
                        w(bVar, o4, readByte2, readInt);
                        break;
                    case 4:
                        x(bVar, o4, readByte2, readInt);
                        break;
                    case 5:
                        v(bVar, o4, readByte2, readInt);
                        break;
                    case 6:
                        p(bVar, o4, readByte2, readInt);
                        break;
                    case 7:
                        k(bVar, o4, readByte2, readInt);
                        break;
                    case 8:
                        z(bVar, o4, readByte2, readInt);
                        break;
                    default:
                        this.f23553a.skip((long) o4);
                        break;
                }
                return true;
            }
            throw C2490e.d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException unused) {
            return false;
        }
    }

    public void g(b bVar) {
        if (!this.f23555c) {
            C2516g gVar = this.f23553a;
            C2517h hVar = C2490e.f23468a;
            C2517h readByteString = gVar.readByteString((long) hVar.G());
            Logger logger = f23552e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(c.o("<< CONNECTION %s", readByteString.m()));
            }
            if (!hVar.equals(readByteString)) {
                throw C2490e.d("Expected a connection header but was %s", readByteString.M());
            }
        } else if (!d(true, bVar)) {
            throw C2490e.d("Required SETTINGS preface not received", new Object[0]);
        }
    }

    static final class a implements Z, AutoCloseable {

        /* renamed from: a  reason: collision with root package name */
        private final C2516g f23557a;

        /* renamed from: b  reason: collision with root package name */
        int f23558b;

        /* renamed from: c  reason: collision with root package name */
        byte f23559c;

        /* renamed from: d  reason: collision with root package name */
        int f23560d;

        /* renamed from: e  reason: collision with root package name */
        int f23561e;

        /* renamed from: f  reason: collision with root package name */
        short f23562f;

        a(C2516g gVar) {
            this.f23557a = gVar;
        }

        private void a() {
            int i4 = this.f23560d;
            int o4 = h.o(this.f23557a);
            this.f23561e = o4;
            this.f23558b = o4;
            byte readByte = (byte) (this.f23557a.readByte() & 255);
            this.f23559c = (byte) (this.f23557a.readByte() & 255);
            Logger logger = h.f23552e;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(C2490e.b(true, this.f23560d, this.f23558b, readByte, this.f23559c));
            }
            int readInt = this.f23557a.readInt() & Integer.MAX_VALUE;
            this.f23560d = readInt;
            if (readByte != 9) {
                throw C2490e.d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (readInt != i4) {
                throw C2490e.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public long e(C2514e eVar, long j4) {
            while (true) {
                int i4 = this.f23561e;
                if (i4 == 0) {
                    this.f23557a.skip((long) this.f23562f);
                    this.f23562f = 0;
                    if ((this.f23559c & 4) != 0) {
                        return -1;
                    }
                    a();
                } else {
                    long e5 = this.f23557a.e(eVar, Math.min(j4, (long) i4));
                    if (e5 == -1) {
                        return -1;
                    }
                    this.f23561e = (int) (((long) this.f23561e) - e5);
                    return e5;
                }
            }
        }

        public a0 timeout() {
            return this.f23557a.timeout();
        }

        public void close() {
        }
    }
}
