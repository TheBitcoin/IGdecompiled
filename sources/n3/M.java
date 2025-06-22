package N3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.jvm.internal.m;

abstract /* synthetic */ class M {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f23636a = Logger.getLogger("okio.Okio");

    public static final X b(File file) {
        m.e(file, "<this>");
        return L.h(new FileOutputStream(file, true));
    }

    public static final boolean c(AssertionError assertionError) {
        boolean z4;
        m.e(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null) {
                z4 = m3.m.D(message, "getsockname failed", false, 2, (Object) null);
            } else {
                z4 = false;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    public static final X d(File file) {
        m.e(file, "<this>");
        return h(file, false, 1, (Object) null);
    }

    public static final X e(File file, boolean z4) {
        m.e(file, "<this>");
        return L.h(new FileOutputStream(file, z4));
    }

    public static final X f(OutputStream outputStream) {
        m.e(outputStream, "<this>");
        return new O(outputStream, new a0());
    }

    public static final X g(Socket socket) {
        m.e(socket, "<this>");
        Y y4 = new Y(socket);
        OutputStream outputStream = socket.getOutputStream();
        m.d(outputStream, "getOutputStream()");
        return y4.z(new O(outputStream, y4));
    }

    public static /* synthetic */ X h(File file, boolean z4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z4 = false;
        }
        return L.g(file, z4);
    }

    public static final Z i(File file) {
        m.e(file, "<this>");
        return new C2526q(new FileInputStream(file), a0.f23669e);
    }

    public static final Z j(InputStream inputStream) {
        m.e(inputStream, "<this>");
        return new C2526q(inputStream, new a0());
    }

    public static final Z k(Socket socket) {
        m.e(socket, "<this>");
        Y y4 = new Y(socket);
        InputStream inputStream = socket.getInputStream();
        m.d(inputStream, "getInputStream()");
        return y4.A(new C2526q(inputStream, y4));
    }
}
