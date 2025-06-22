package A0;

import E0.g;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y0.C2420j;

/* renamed from: A0.f  reason: case insensitive filesystem */
class C1270f {

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f5702b = Charset.forName(C.UTF8_NAME);

    /* renamed from: a  reason: collision with root package name */
    private final g f5703a;

    /* renamed from: A0.f$a */
    class a extends JSONObject {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f5704a;

        a(String str) {
            this.f5704a = str;
            put("userId", str);
        }
    }

    public C1270f(g gVar) {
        this.f5703a = gVar;
    }

    private static Map e(String str) {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, o(jSONObject, next));
        }
        return hashMap;
    }

    private static List f(String str) {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            String string = jSONArray.getString(i4);
            try {
                arrayList.add(i.a(string));
            } catch (Exception e5) {
                v0.g f4 = v0.g.f();
                f4.l("Failed de-serializing rollouts state. " + string, e5);
            }
        }
        return arrayList;
    }

    private String g(String str) {
        return o(new JSONObject(str), "userId");
    }

    private static String h(Map map) {
        return new JSONObject(map).toString();
    }

    private static String l(List list) {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i4 = 0; i4 < list.size(); i4++) {
            try {
                jSONArray.put(new JSONObject(i.f5730a.b(list.get(i4))));
            } catch (JSONException e5) {
                v0.g.f().l("Exception parsing rollout assignment!", e5);
            }
        }
        hashMap.put("rolloutsState", jSONArray);
        return new JSONObject(hashMap).toString();
    }

    private static void m(File file) {
        if (file.exists() && file.delete()) {
            v0.g f4 = v0.g.f();
            f4.g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static String n(String str) {
        return new a(str).toString();
    }

    private static String o(JSONObject jSONObject, String str) {
        if (!jSONObject.isNull(str)) {
            return jSONObject.optString(str, (String) null);
        }
        return null;
    }

    public File a(String str) {
        return this.f5703a.q(str, "internal-keys");
    }

    public File b(String str) {
        return this.f5703a.q(str, "keys");
    }

    public File c(String str) {
        return this.f5703a.q(str, "rollouts-state");
    }

    public File d(String str) {
        return this.f5703a.q(str, "user-data");
    }

    /* access modifiers changed from: package-private */
    public Map i(String str, boolean z4) {
        File file;
        Exception e5;
        FileInputStream fileInputStream;
        if (z4) {
            file = a(str);
        } else {
            file = b(str);
        }
        if (!file.exists() || file.length() == 0) {
            m(file);
            return Collections.EMPTY_MAP;
        }
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                Map e6 = e(C2420j.A(fileInputStream));
                C2420j.f(fileInputStream, "Failed to close user metadata file.");
                return e6;
            } catch (Exception e7) {
                e5 = e7;
                try {
                    v0.g.f().l("Error deserializing user metadata.", e5);
                    m(file);
                    C2420j.f(fileInputStream, "Failed to close user metadata file.");
                    return Collections.EMPTY_MAP;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    C2420j.f(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            }
        } catch (Exception e8) {
            Exception exc = e8;
            fileInputStream = null;
            e5 = exc;
            v0.g.f().l("Error deserializing user metadata.", e5);
            m(file);
            C2420j.f(fileInputStream, "Failed to close user metadata file.");
            return Collections.EMPTY_MAP;
        } catch (Throwable th2) {
            th = th2;
            C2420j.f(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public List j(String str) {
        File c5 = c(str);
        if (!c5.exists() || c5.length() == 0) {
            m(c5);
            return Collections.EMPTY_LIST;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(c5);
            try {
                List f4 = f(C2420j.A(fileInputStream2));
                v0.g f5 = v0.g.f();
                f5.b("Loaded rollouts state:\n" + f4 + "\nfor session " + str);
                C2420j.f(fileInputStream2, "Failed to close rollouts state file.");
                return f4;
            } catch (Exception e5) {
                e = e5;
                fileInputStream = fileInputStream2;
                try {
                    v0.g.f().l("Error deserializing rollouts state.", e);
                    m(c5);
                    C2420j.f(fileInputStream, "Failed to close rollouts state file.");
                    return Collections.EMPTY_LIST;
                } catch (Throwable th) {
                    th = th;
                    C2420j.f(fileInputStream, "Failed to close rollouts state file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = fileInputStream2;
                C2420j.f(fileInputStream, "Failed to close rollouts state file.");
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            v0.g.f().l("Error deserializing rollouts state.", e);
            m(c5);
            C2420j.f(fileInputStream, "Failed to close rollouts state file.");
            return Collections.EMPTY_LIST;
        }
    }

    public String k(String str) {
        FileInputStream fileInputStream;
        File d5 = d(str);
        FileInputStream fileInputStream2 = null;
        if (!d5.exists() || d5.length() == 0) {
            v0.g.f().b("No userId set for session " + str);
            m(d5);
            return null;
        }
        try {
            fileInputStream = new FileInputStream(d5);
            try {
                String g4 = g(C2420j.A(fileInputStream));
                v0.g.f().b("Loaded userId " + g4 + " for session " + str);
                C2420j.f(fileInputStream, "Failed to close user metadata file.");
                return g4;
            } catch (Exception e5) {
                e = e5;
                try {
                    v0.g.f().l("Error deserializing user metadata.", e);
                    m(d5);
                    C2420j.f(fileInputStream, "Failed to close user metadata file.");
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    C2420j.f(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
            v0.g.f().l("Error deserializing user metadata.", e);
            m(d5);
            C2420j.f(fileInputStream, "Failed to close user metadata file.");
            return null;
        } catch (Throwable th2) {
            th = th2;
            C2420j.f(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }

    public void p(String str, Map map) {
        q(str, map, false);
    }

    public void q(String str, Map map, boolean z4) {
        File file;
        if (z4) {
            file = a(str);
        } else {
            file = b(str);
        }
        BufferedWriter bufferedWriter = null;
        try {
            String h4 = h(map);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), f5702b));
            try {
                bufferedWriter2.write(h4);
                bufferedWriter2.flush();
                C2420j.f(bufferedWriter2, "Failed to close key/value metadata file.");
            } catch (Exception e5) {
                e = e5;
                bufferedWriter = bufferedWriter2;
                try {
                    v0.g.f().l("Error serializing key/value metadata.", e);
                    m(file);
                    C2420j.f(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    C2420j.f(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                C2420j.f(bufferedWriter, "Failed to close key/value metadata file.");
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            v0.g.f().l("Error serializing key/value metadata.", e);
            m(file);
            C2420j.f(bufferedWriter, "Failed to close key/value metadata file.");
        }
    }

    public void r(String str, List list) {
        File c5 = c(str);
        if (list.isEmpty()) {
            m(c5);
            return;
        }
        BufferedWriter bufferedWriter = null;
        try {
            String l4 = l(list);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c5), f5702b));
            try {
                bufferedWriter2.write(l4);
                bufferedWriter2.flush();
                C2420j.f(bufferedWriter2, "Failed to close rollouts state file.");
            } catch (Exception e5) {
                e = e5;
                bufferedWriter = bufferedWriter2;
                try {
                    v0.g.f().l("Error serializing rollouts state.", e);
                    m(c5);
                    C2420j.f(bufferedWriter, "Failed to close rollouts state file.");
                } catch (Throwable th) {
                    th = th;
                    C2420j.f(bufferedWriter, "Failed to close rollouts state file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                C2420j.f(bufferedWriter, "Failed to close rollouts state file.");
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            v0.g.f().l("Error serializing rollouts state.", e);
            m(c5);
            C2420j.f(bufferedWriter, "Failed to close rollouts state file.");
        }
    }

    public void s(String str, String str2) {
        File d5 = d(str);
        BufferedWriter bufferedWriter = null;
        try {
            String n4 = n(str2);
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(d5), f5702b));
            try {
                bufferedWriter2.write(n4);
                bufferedWriter2.flush();
                C2420j.f(bufferedWriter2, "Failed to close user metadata file.");
            } catch (Exception e5) {
                e = e5;
                bufferedWriter = bufferedWriter2;
                try {
                    v0.g.f().l("Error serializing user metadata.", e);
                    C2420j.f(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    C2420j.f(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter = bufferedWriter2;
                C2420j.f(bufferedWriter, "Failed to close user metadata file.");
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            v0.g.f().l("Error serializing user metadata.", e);
            C2420j.f(bufferedWriter, "Failed to close user metadata file.");
        }
    }
}
