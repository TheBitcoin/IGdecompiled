package b3;

import R2.s;
import d3.l;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import l3.e;
import l3.h;

public abstract class i {

    static final class a extends n implements l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f9654a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ArrayList arrayList) {
            super(1);
            this.f9654a = arrayList;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return s.f8222a;
        }

        public final void invoke(String str) {
            m.e(str, "it");
            this.f9654a.add(str);
        }
    }

    public static final long a(Reader reader, Writer writer, int i4) {
        m.e(reader, "<this>");
        m.e(writer, "out");
        char[] cArr = new char[i4];
        int read = reader.read(cArr);
        long j4 = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j4 += (long) read;
            read = reader.read(cArr);
        }
        return j4;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 8192;
        }
        return a(reader, writer, i4);
    }

    public static final void c(Reader reader, l lVar) {
        BufferedReader bufferedReader;
        m.e(reader, "<this>");
        m.e(lVar, "action");
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader, 8192);
        }
        try {
            for (Object invoke : d(bufferedReader)) {
                lVar.invoke(invoke);
            }
            s sVar = s.f8222a;
            C1642b.a(bufferedReader, (Throwable) null);
        } catch (Throwable th) {
            C1642b.a(bufferedReader, th);
            throw th;
        }
    }

    public static final e d(BufferedReader bufferedReader) {
        m.e(bufferedReader, "<this>");
        return h.d(new h(bufferedReader));
    }

    public static final List e(Reader reader) {
        m.e(reader, "<this>");
        ArrayList arrayList = new ArrayList();
        c(reader, new a(arrayList));
        return arrayList;
    }

    public static final String f(Reader reader) {
        m.e(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, (Object) null);
        String stringWriter2 = stringWriter.toString();
        m.d(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
