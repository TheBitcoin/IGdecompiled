package W1;

import T1.d;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.StringReader;
import java.util.ArrayList;
import kotlin.jvm.internal.m;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: W1.a  reason: case insensitive filesystem */
public final class C1605a {

    /* renamed from: W1.a$a  reason: collision with other inner class name */
    private static final class C0120a {

        /* renamed from: a  reason: collision with root package name */
        private String f8667a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f8668b;

        public final String a() {
            return this.f8667a;
        }

        public final Integer b() {
            return this.f8668b;
        }

        public final void c(String str) {
            this.f8667a = str;
        }

        public final void d(Integer num) {
            this.f8668b = num;
        }
    }

    public final String a(String str) {
        m.e(str, "androidManifest");
        String str2 = str;
        String substring = str2.substring(m3.m.L(str2, "split=\"config.", 0, false, 6, (Object) null) + 14);
        m.d(substring, "this as java.lang.String).substring(startIndex)");
        String substring2 = substring.substring(0, m3.m.L(substring, "\"", 0, false, 6, (Object) null));
        m.d(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring2;
    }

    public final boolean b(String str) {
        m.e(str, "androidManifest");
        if (!m3.m.D(str, "configForSplit=", false, 2, (Object) null) || m3.m.D(str, "configForSplit=\"\"", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    public final boolean c(String str) {
        m.e(str, "androidManifest");
        return m3.m.B(str, "isFeatureSplit=\"-1\"", true);
    }

    public final boolean d(String str) {
        m.e(str, "androidManifest");
        return m3.m.D(str, "split=\"config.", false, 2, (Object) null);
    }

    public final int e(String str) {
        m.e(str, "androidManifest");
        int i4 = -1;
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2 && m3.m.p(newPullParser.getName(), "meta-data", true)) {
                    C0120a aVar = new C0120a();
                    int attributeCount = newPullParser.getAttributeCount();
                    for (int i5 = 0; i5 < attributeCount; i5++) {
                        if (m3.m.p(newPullParser.getAttributeName(i5), RewardPlus.NAME, true) && m3.m.p(newPullParser.getAttributeValue(i5), "com.android.vending.derived.apk.id", true)) {
                            aVar.c(newPullParser.getAttributeValue(i5));
                        } else if (m3.m.p(newPullParser.getAttributeName(i5), "value", true)) {
                            try {
                                String attributeValue = newPullParser.getAttributeValue(i5);
                                m.d(attributeValue, "xpp.getAttributeValue(i)");
                                aVar.d(Integer.valueOf(Integer.parseInt(attributeValue)));
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                    String a5 = aVar.a();
                    if (a5 != null) {
                        if (a5.length() != 0) {
                            if (aVar.b() != null) {
                                Integer b5 = aVar.b();
                                m.b(b5);
                                i4 = b5.intValue();
                            }
                        }
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return i4;
    }

    public final ArrayList f(String str) {
        m.e(str, "androidManifest");
        ArrayList arrayList = new ArrayList();
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(new StringReader(str));
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    if (!m3.m.p(newPullParser.getName(), "uses-feature", true)) {
                        if (m3.m.p(newPullParser.getName(), "uses-library", true)) {
                        }
                    }
                    d dVar = new d();
                    dVar.f(newPullParser.getName());
                    int attributeCount = newPullParser.getAttributeCount();
                    String str2 = "";
                    String str3 = str2;
                    for (int i4 = 0; i4 < attributeCount; i4++) {
                        if (m3.m.p(newPullParser.getAttributeName(i4), "required", true) && newPullParser.getAttributeValue(i4).equals("-1")) {
                            dVar.e(1);
                        } else if (m3.m.p(newPullParser.getAttributeName(i4), RewardPlus.NAME, true)) {
                            str2 = newPullParser.getAttributeValue(i4);
                            m.d(str2, "xpp.getAttributeValue(i)");
                        } else {
                            str3 = newPullParser.getAttributeName(i4);
                            m.d(str3, "xpp.getAttributeName(i)");
                        }
                    }
                    if (str2.length() > 0) {
                        dVar.d(str2);
                    } else if (str3.length() > 0) {
                        dVar.d(str3);
                    }
                    arrayList.add(dVar);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return arrayList;
    }
}
