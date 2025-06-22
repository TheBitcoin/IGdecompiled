package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.m;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

final class SqlDateTypeAdapter extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    static final r f11721b = new r() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f11722a;

    /* renamed from: e */
    public Date b(C2079a aVar) {
        java.util.Date parse;
        if (aVar.L() == C2080b.NULL) {
            aVar.H();
            return null;
        }
        String J4 = aVar.J();
        try {
            synchronized (this) {
                parse = this.f11722a.parse(J4);
            }
            return new Date(parse.getTime());
        } catch (ParseException e5) {
            throw new m("Failed parsing '" + J4 + "' as SQL Date; at path " + aVar.r(), e5);
        }
    }

    /* renamed from: f */
    public void d(C2081c cVar, Date date) {
        String format;
        if (date == null) {
            cVar.x();
            return;
        }
        synchronized (this) {
            format = this.f11722a.format(date);
        }
        cVar.O(format);
    }

    private SqlDateTypeAdapter() {
        this.f11722a = new SimpleDateFormat("MMM d, yyyy");
    }
}
