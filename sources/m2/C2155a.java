package m2;

import android.content.Context;
import android.provider.Settings;
import android.util.Base64;
import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import k2.C2096a;
import k2.b;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import l2.C2121a;
import l2.C2124d;
import m3.d;

/* renamed from: m2.a  reason: case insensitive filesystem */
public final class C2155a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0265a f21157b = new C0265a((C2103g) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f21158a;

    /* renamed from: m2.a$a  reason: collision with other inner class name */
    public static final class C0265a {
        public C0265a(C2103g gVar) {
        }
    }

    public C2155a(Context context) {
        m.e(context, "context");
        this.f21158a = context;
    }

    public static String a(HashMap hashMap) {
        StringBuilder sb = new StringBuilder();
        boolean z4 = true;
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (z4) {
                z4 = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str, C.UTF8_NAME));
            sb.append("=");
            sb.append(URLEncoder.encode(str2, C.UTF8_NAME));
        }
        String sb2 = sb.toString();
        m.d(sb2, "result.toString()");
        return sb2;
    }

    public final C2124d b(String str) {
        BufferedReader bufferedReader;
        OutputStream outputStream;
        m.e(str, "token");
        HashMap hashMap = new HashMap();
        String jSONObject = new C2096a(this.f21158a, str).a(this.f21158a).toString();
        m.d(jSONObject, "jsonObjectContext.toString()");
        hashMap.put("context", jSONObject);
        String jSONObject2 = new b(this.f21158a).a().toString();
        m.d(jSONObject2, "jsonObjectFile.toString()");
        hashMap.put("file", jSONObject2);
        StringBuilder sb = new StringBuilder();
        C2121a aVar = C2121a.f21016a;
        sb.append(aVar.b());
        sb.append("/eapi/sdk-installation/" + Settings.Secure.getString(this.f21158a.getContentResolver(), "android_id"));
        String sb2 = sb.toString();
        C2124d dVar = new C2124d();
        try {
            if (m3.m.p(ShareTarget.METHOD_POST, ShareTarget.METHOD_GET, true)) {
                sb2 = sb2 + '?' + a(hashMap);
            }
            URLConnection openConnection = new URL(sb2).openConnection();
            m.c(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            httpsURLConnection.setReadTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpsURLConnection.setConnectTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
            httpsURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
            httpsURLConnection.setDoInput(true);
            if (m3.m.p(ShareTarget.METHOD_POST, ShareTarget.METHOD_POST, true)) {
                httpsURLConnection.setDoOutput(true);
            }
            if (m3.m.D("https://secure.uptodown.com", "www.xxxyyyxxx.com", false, 2, (Object) null)) {
                Charset charset = d.f21160b;
                byte[] bytes = "".getBytes(charset);
                m.d(bytes, "getBytes(...)");
                byte[] encode = Base64.encode(bytes, 0);
                m.d(encode, "encode(devValue.toByteArray(), Base64.DEFAULT)");
                httpsURLConnection.setRequestProperty("", new String(encode, charset));
            }
            httpsURLConnection.setRequestProperty("Identificador", "Uptodown_Android");
            httpsURLConnection.setRequestProperty("Identificador-Version", "999");
            httpsURLConnection.setRequestProperty("APIKEY", aVar.a());
            if (m3.m.p(ShareTarget.METHOD_POST, ShareTarget.METHOD_POST, true) && (outputStream = httpsURLConnection.getOutputStream()) != null) {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, C.UTF8_NAME));
                bufferedWriter.write(a(hashMap));
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
            }
            int responseCode = httpsURLConnection.getResponseCode();
            dVar.e(responseCode);
            if (responseCode == 200) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getErrorStream()));
                dVar.c(true);
            }
            StringBuilder sb3 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb3.append(readLine);
                } else {
                    dVar.d(sb3.toString());
                    return dVar;
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
            dVar.c(true);
            dVar.d(e5.getMessage());
            return dVar;
        }
    }
}
