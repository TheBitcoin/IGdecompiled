package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.m;
import g1.C2032a;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final a f11531a;

    /* renamed from: b  reason: collision with root package name */
    private final List f11532b;

    public static abstract class a {

        /* renamed from: b  reason: collision with root package name */
        public static final a f11533b = new C0168a(Date.class);

        /* renamed from: a  reason: collision with root package name */
        private final Class f11534a;

        /* renamed from: com.google.gson.internal.bind.DefaultDateTypeAdapter$a$a  reason: collision with other inner class name */
        class C0168a extends a {
            C0168a(Class cls) {
                super(cls);
            }

            /* access modifiers changed from: protected */
            public Date a(Date date) {
                return date;
            }
        }

        protected a(Class cls) {
            this.f11534a = cls;
        }

        /* access modifiers changed from: protected */
        public abstract Date a(Date date);
    }

    private Date e(C2079a aVar) {
        String J4 = aVar.J();
        synchronized (this.f11532b) {
            try {
                for (DateFormat parse : this.f11532b) {
                    try {
                        Date parse2 = parse.parse(J4);
                        return parse2;
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return C2032a.c(J4, new ParsePosition(0));
                } catch (ParseException e5) {
                    throw new m("Failed parsing '" + J4 + "' as Date; at path " + aVar.r(), e5);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: f */
    public Date b(C2079a aVar) {
        if (aVar.L() == C2080b.NULL) {
            aVar.H();
            return null;
        }
        return this.f11531a.a(e(aVar));
    }

    /* renamed from: g */
    public void d(C2081c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.x();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f11532b.get(0);
        synchronized (this.f11532b) {
            format = dateFormat.format(date);
        }
        cVar.O(format);
    }

    public String toString() {
        DateFormat dateFormat = (DateFormat) this.f11532b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
