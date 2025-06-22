package N3;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.m;

final class Y extends C2512c {

    /* renamed from: o  reason: collision with root package name */
    private final Socket f23665o;

    public Y(Socket socket) {
        m.e(socket, "socket");
        this.f23665o = socket;
    }

    /* access modifiers changed from: protected */
    public void B() {
        try {
            this.f23665o.close();
        } catch (Exception e5) {
            Logger a5 = M.f23636a;
            Level level = Level.WARNING;
            a5.log(level, "Failed to close timed out socket " + this.f23665o, e5);
        } catch (AssertionError e6) {
            if (L.e(e6)) {
                Logger a6 = M.f23636a;
                Level level2 = Level.WARNING;
                a6.log(level2, "Failed to close timed out socket " + this.f23665o, e6);
                return;
            }
            throw e6;
        }
    }

    /* access modifiers changed from: protected */
    public IOException x(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }
}
