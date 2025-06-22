package v2;

import androidx.browser.trusted.sharing.ShareTarget;
import g2.L;
import h2.C2072d;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import kotlin.jvm.internal.m;
import m3.d;
import org.json.JSONObject;
import u2.F;
import u2.u;

/* renamed from: v2.a  reason: case insensitive filesystem */
public final class C2330a {

    /* renamed from: a  reason: collision with root package name */
    private HttpsURLConnection f21998a;

    /* renamed from: b  reason: collision with root package name */
    private OutputStream f21999b;

    /* renamed from: c  reason: collision with root package name */
    private final String f22000c = "--";

    /* renamed from: d  reason: collision with root package name */
    private final String f22001d = ("SwA" + System.currentTimeMillis() + "SwA");

    /* renamed from: e  reason: collision with root package name */
    private long f22002e;

    public C2330a(C2072d dVar) {
    }

    private final L g(Exception exc, L l4, String str) {
        l4.h(str);
        if (exc.getMessage() != null) {
            l4.i(exc.getMessage());
            return l4;
        }
        l4.i(exc.toString());
        return l4;
    }

    private final void l(String str, String str2) {
        OutputStream outputStream = this.f21999b;
        m.b(outputStream);
        Charset charset = d.f21160b;
        byte[] bytes = (this.f22000c + this.f22001d + "\r\n").getBytes(charset);
        m.d(bytes, "getBytes(...)");
        outputStream.write(bytes);
        OutputStream outputStream2 = this.f21999b;
        m.b(outputStream2);
        byte[] bytes2 = "Content-Type: text/plain\r\n".getBytes(charset);
        m.d(bytes2, "getBytes(...)");
        outputStream2.write(bytes2);
        OutputStream outputStream3 = this.f21999b;
        m.b(outputStream3);
        byte[] bytes3 = ("Content-Disposition: form-data; name=\"" + str + "\"\r\n").getBytes(charset);
        m.d(bytes3, "getBytes(...)");
        outputStream3.write(bytes3);
        OutputStream outputStream4 = this.f21999b;
        m.b(outputStream4);
        byte[] bytes4 = ("\r\n" + str2 + "\r\n").getBytes(charset);
        m.d(bytes4, "getBytes(...)");
        outputStream4.write(bytes4);
    }

    public final void a(String str, String str2, byte[] bArr, JSONObject jSONObject) {
        m.e(str, "paramName");
        m.e(str2, "fileName");
        m.e(bArr, "bytes");
        try {
            OutputStream outputStream = this.f21999b;
            m.b(outputStream);
            Charset charset = d.f21160b;
            byte[] bytes = (this.f22000c + this.f22001d + "\r\n").getBytes(charset);
            m.d(bytes, "getBytes(...)");
            outputStream.write(bytes);
            OutputStream outputStream2 = this.f21999b;
            m.b(outputStream2);
            byte[] bytes2 = ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes(charset);
            m.d(bytes2, "getBytes(...)");
            outputStream2.write(bytes2);
            OutputStream outputStream3 = this.f21999b;
            m.b(outputStream3);
            byte[] bytes3 = "Content-Type: application/octet-stream\r\n".getBytes(charset);
            m.d(bytes3, "getBytes(...)");
            outputStream3.write(bytes3);
            OutputStream outputStream4 = this.f21999b;
            m.b(outputStream4);
            byte[] bytes4 = "Content-Transfer-Encoding: binary\r\n".getBytes(charset);
            m.d(bytes4, "getBytes(...)");
            outputStream4.write(bytes4);
            OutputStream outputStream5 = this.f21999b;
            m.b(outputStream5);
            byte[] bytes5 = "\r\n".getBytes(charset);
            m.d(bytes5, "getBytes(...)");
            outputStream5.write(bytes5);
            OutputStream outputStream6 = this.f21999b;
            m.b(outputStream6);
            outputStream6.write(bArr, 0, bArr.length);
            OutputStream outputStream7 = this.f21999b;
            m.b(outputStream7);
            byte[] bytes6 = "\r\n".getBytes(charset);
            m.d(bytes6, "getBytes(...)");
            outputStream7.write(bytes6);
        } catch (IOException unused) {
            OutputStream outputStream8 = this.f21999b;
            m.b(outputStream8);
            outputStream8.close();
        } catch (Exception unused2) {
            OutputStream outputStream9 = this.f21999b;
            m.b(outputStream9);
            outputStream9.close();
        } catch (OutOfMemoryError unused3) {
            OutputStream outputStream10 = this.f21999b;
            m.b(outputStream10);
            outputStream10.close();
        }
    }

    public final long b(String str, String str2, String str3) {
        m.e(str, "paramName");
        m.e(str2, "fileName");
        long j4 = 0;
        try {
            OutputStream outputStream = this.f21999b;
            m.b(outputStream);
            Charset charset = d.f21160b;
            byte[] bytes = (this.f22000c + this.f22001d + "\r\n").getBytes(charset);
            m.d(bytes, "getBytes(...)");
            outputStream.write(bytes);
            OutputStream outputStream2 = this.f21999b;
            m.b(outputStream2);
            byte[] bytes2 = ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes(charset);
            m.d(bytes2, "getBytes(...)");
            outputStream2.write(bytes2);
            OutputStream outputStream3 = this.f21999b;
            m.b(outputStream3);
            byte[] bytes3 = "Content-Type: application/octet-stream\r\n".getBytes(charset);
            m.d(bytes3, "getBytes(...)");
            outputStream3.write(bytes3);
            OutputStream outputStream4 = this.f21999b;
            m.b(outputStream4);
            byte[] bytes4 = "Content-Transfer-Encoding: binary\r\n".getBytes(charset);
            m.d(bytes4, "getBytes(...)");
            outputStream4.write(bytes4);
            OutputStream outputStream5 = this.f21999b;
            m.b(outputStream5);
            byte[] bytes5 = "\r\n".getBytes(charset);
            m.d(bytes5, "getBytes(...)");
            outputStream5.write(bytes5);
            FileInputStream fileInputStream = new FileInputStream(str3);
            byte[] bArr = new byte[8192];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    OutputStream outputStream6 = this.f21999b;
                    m.b(outputStream6);
                    outputStream6.write(bArr, 0, read);
                    j4 += (long) read;
                } else {
                    fileInputStream.close();
                    OutputStream outputStream7 = this.f21999b;
                    m.b(outputStream7);
                    byte[] bytes6 = "\r\n".getBytes(d.f21160b);
                    m.d(bytes6, "getBytes(...)");
                    outputStream7.write(bytes6);
                    return j4;
                }
            }
        } catch (OutOfMemoryError unused) {
            OutputStream outputStream8 = this.f21999b;
            if (outputStream8 != null) {
                outputStream8.close();
            }
            return 0;
        } catch (IOException unused2) {
            OutputStream outputStream9 = this.f21999b;
            if (outputStream9 != null) {
                outputStream9.close();
            }
            return 0;
        } catch (Exception unused3) {
            OutputStream outputStream10 = this.f21999b;
            if (outputStream10 != null) {
                outputStream10.close();
            }
            return 0;
        }
    }

    public final void c(String str, String str2) {
        m.e(str, "paramName");
        m.e(str2, "value");
        l(str, str2);
    }

    public final void d(URL url, String str) {
        m.e(url, "url");
        URLConnection openConnection = url.openConnection();
        m.c(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
        this.f21998a = httpsURLConnection;
        m.b(httpsURLConnection);
        httpsURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        HttpsURLConnection httpsURLConnection2 = this.f21998a;
        m.b(httpsURLConnection2);
        httpsURLConnection2.setDoInput(true);
        HttpsURLConnection httpsURLConnection3 = this.f21998a;
        m.b(httpsURLConnection3);
        httpsURLConnection3.setDoOutput(true);
        HttpsURLConnection httpsURLConnection4 = this.f21998a;
        m.b(httpsURLConnection4);
        httpsURLConnection4.setRequestProperty("Connection", "Keep-Alive");
        HttpsURLConnection httpsURLConnection5 = this.f21998a;
        m.b(httpsURLConnection5);
        httpsURLConnection5.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.f22001d);
        HttpsURLConnection httpsURLConnection6 = this.f21998a;
        m.b(httpsURLConnection6);
        httpsURLConnection6.setRequestProperty("Accept-Charset", "utf-8");
        HttpsURLConnection httpsURLConnection7 = this.f21998a;
        m.b(httpsURLConnection7);
        httpsURLConnection7.setRequestProperty("Accept", "application/json");
        HttpsURLConnection httpsURLConnection8 = this.f21998a;
        m.b(httpsURLConnection8);
        httpsURLConnection8.setRequestProperty("Identificador", "Uptodown_Android");
        HttpsURLConnection httpsURLConnection9 = this.f21998a;
        m.b(httpsURLConnection9);
        httpsURLConnection9.setRequestProperty("apk_file", str);
        HttpsURLConnection httpsURLConnection10 = this.f21998a;
        m.b(httpsURLConnection10);
        httpsURLConnection10.setRequestProperty("Identificador-Version", "671");
        HttpsURLConnection httpsURLConnection11 = this.f21998a;
        m.b(httpsURLConnection11);
        httpsURLConnection11.setRequestProperty("APIKEY", F.f21886a.e());
        u uVar = u.f21949a;
        HttpsURLConnection httpsURLConnection12 = this.f21998a;
        m.b(httpsURLConnection12);
        uVar.a(httpsURLConnection12);
        HttpsURLConnection httpsURLConnection13 = this.f21998a;
        m.b(httpsURLConnection13);
        httpsURLConnection13.setFixedLengthStreamingMode((int) this.f22002e);
        HttpsURLConnection httpsURLConnection14 = this.f21998a;
        m.b(httpsURLConnection14);
        httpsURLConnection14.connect();
        HttpsURLConnection httpsURLConnection15 = this.f21998a;
        m.b(httpsURLConnection15);
        this.f21999b = httpsURLConnection15.getOutputStream();
    }

    public final void e() {
        OutputStream outputStream = this.f21999b;
        m.b(outputStream);
        byte[] bytes = (this.f22000c + this.f22001d + this.f22000c + "\r\n").getBytes(d.f21160b);
        m.d(bytes, "getBytes(...)");
        outputStream.write(bytes);
        OutputStream outputStream2 = this.f21999b;
        m.b(outputStream2);
        outputStream2.close();
    }

    public final L f(boolean z4) {
        boolean z5;
        InputStream inputStream;
        L l4 = new L();
        try {
            HttpsURLConnection httpsURLConnection = this.f21998a;
            m.b(httpsURLConnection);
            int responseCode = httpsURLConnection.getResponseCode();
            l4.k(responseCode);
            if (responseCode < 200 || responseCode >= 300) {
                HttpsURLConnection httpsURLConnection2 = this.f21998a;
                m.b(httpsURLConnection2);
                InputStream errorStream = httpsURLConnection2.getErrorStream();
                if (errorStream == null) {
                    HttpsURLConnection httpsURLConnection3 = this.f21998a;
                    m.b(httpsURLConnection3);
                    errorStream = httpsURLConnection3.getInputStream();
                }
                z5 = false;
            } else {
                HttpsURLConnection httpsURLConnection4 = this.f21998a;
                m.b(httpsURLConnection4);
                inputStream = httpsURLConnection4.getInputStream();
                if (inputStream == null) {
                    HttpsURLConnection httpsURLConnection5 = this.f21998a;
                    m.b(httpsURLConnection5);
                    inputStream = httpsURLConnection5.getErrorStream();
                }
                z5 = true;
            }
            StringBuilder sb = new StringBuilder();
            byte[] bArr = new byte[1024];
            if (!z5 || !z4) {
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read, d.f21160b));
                }
                l4.i(sb.toString());
            } else {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(inputStream, new Inflater(true));
                while (true) {
                    int read2 = inflaterInputStream.read(bArr);
                    if (read2 == -1) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read2, d.f21160b));
                }
                l4.i(sb.toString());
                inflaterInputStream.close();
            }
            inputStream.close();
            HttpsURLConnection httpsURLConnection6 = this.f21998a;
            m.b(httpsURLConnection6);
            httpsURLConnection6.disconnect();
            return l4;
        } catch (SocketTimeoutException e5) {
            return g(e5, l4, "SocketTimeoutException");
        } catch (IllegalStateException e6) {
            return g(e6, l4, "IllegalStateException");
        } catch (IllegalArgumentException e7) {
            return g(e7, l4, "IllegalArgumentException");
        } catch (SecurityException e8) {
            return g(e8, l4, "SecurityException");
        } catch (NullPointerException e9) {
            return g(e9, l4, "NullPointerException");
        } catch (MalformedURLException e10) {
            return g(e10, l4, "MalformedURLException");
        } catch (ProtocolException e11) {
            return g(e11, l4, "ProtocolException");
        } catch (SSLHandshakeException e12) {
            return g(e12, l4, "SSLHandshakeException");
        } catch (IOException e13) {
            return g(e13, l4, "IOException");
        }
    }

    public final void h(String str, String str2, byte[] bArr) {
        m.e(str, "paramName");
        m.e(str2, "fileName");
        m.e(bArr, "bytes");
        long j4 = this.f22002e;
        long length = j4 + ((long) (this.f22000c + this.f22001d + "\r\n").length());
        this.f22002e = length;
        long j5 = (long) 2;
        long length2 = length + ((long) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").length()) + ((long) 40) + ((long) 35) + j5;
        this.f22002e = length2;
        this.f22002e = length2 + ((long) bArr.length) + j5;
    }

    public final void i(String str, String str2, long j4) {
        m.e(str, "paramName");
        m.e(str2, "fileName");
        long j5 = this.f22002e;
        long length = j5 + ((long) (this.f22000c + this.f22001d + "\r\n").length());
        this.f22002e = length;
        long j6 = (long) 2;
        this.f22002e = length + ((long) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").length()) + ((long) 40) + ((long) 35) + j6 + j4 + j6;
    }

    public final void j() {
        long j4 = this.f22002e;
        this.f22002e = j4 + ((long) (this.f22000c + this.f22001d + this.f22000c + "\r\n").length());
    }

    public final void k(String str, String str2) {
        m.e(str, "paramName");
        m.e(str2, "value");
        long j4 = this.f22002e;
        long length = j4 + ((long) (this.f22000c + this.f22001d + "\r\n").length()) + ((long) 26);
        this.f22002e = length;
        long length2 = length + ((long) ("Content-Disposition: form-data; name=\"" + str + "\"\r\n").length());
        this.f22002e = length2;
        this.f22002e = length2 + ((long) ("\r\n" + str2 + "\r\n").length());
    }
}
