package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.d;
import com.google.gson.internal.i;
import com.google.gson.m;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import g1.C2032a;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class DateTypeAdapter extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    public static final r f11529b = new r() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List f11530a;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f11530a = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (d.d()) {
            arrayList.add(i.c(2, 2));
        }
    }

    private Date e(C2079a aVar) {
        String J4 = aVar.J();
        synchronized (this.f11530a) {
            try {
                for (DateFormat parse : this.f11530a) {
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
        if (aVar.L() != C2080b.NULL) {
            return e(aVar);
        }
        aVar.H();
        return null;
    }

    /* renamed from: g */
    public void d(C2081c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.x();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.f11530a.get(0);
        synchronized (this.f11530a) {
            format = dateFormat.format(date);
        }
        cVar.O(format);
    }
}
