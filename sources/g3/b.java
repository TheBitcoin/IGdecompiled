package G3;

import D3.C2462j;
import E3.C2476a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List f23325a;

    /* renamed from: b  reason: collision with root package name */
    private int f23326b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23327c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23328d;

    public b(List list) {
        this.f23325a = list;
    }

    private boolean c(SSLSocket sSLSocket) {
        for (int i4 = this.f23326b; i4 < this.f23325a.size(); i4++) {
            if (((C2462j) this.f23325a.get(i4)).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public C2462j a(SSLSocket sSLSocket) {
        C2462j jVar;
        int i4 = this.f23326b;
        int size = this.f23325a.size();
        while (true) {
            if (i4 >= size) {
                jVar = null;
                break;
            }
            jVar = (C2462j) this.f23325a.get(i4);
            if (jVar.c(sSLSocket)) {
                this.f23326b = i4 + 1;
                break;
            }
            i4++;
        }
        if (jVar != null) {
            this.f23327c = c(sSLSocket);
            C2476a.f23240a.c(jVar, sSLSocket, this.f23328d);
            return jVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f23328d + ", modes=" + this.f23325a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(IOException iOException) {
        this.f23328d = true;
        if (!this.f23327c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z4 = iOException instanceof SSLHandshakeException;
        if ((z4 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z4 || (iOException instanceof SSLProtocolException)) {
            return true;
        }
        return false;
    }
}
