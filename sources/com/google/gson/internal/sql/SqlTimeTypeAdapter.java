package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.m;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

final class SqlTimeTypeAdapter extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    static final r f11723b = new r() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Time.class) {
                return new SqlTimeTypeAdapter();
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final DateFormat f11724a;

    /* renamed from: e */
    public Time b(C2079a aVar) {
        Time time;
        if (aVar.L() == C2080b.NULL) {
            aVar.H();
            return null;
        }
        String J4 = aVar.J();
        try {
            synchronized (this) {
                time = new Time(this.f11724a.parse(J4).getTime());
            }
            return time;
        } catch (ParseException e5) {
            throw new m("Failed parsing '" + J4 + "' as SQL Time; at path " + aVar.r(), e5);
        }
    }

    /* renamed from: f */
    public void d(C2081c cVar, Time time) {
        String format;
        if (time == null) {
            cVar.x();
            return;
        }
        synchronized (this) {
            format = this.f11724a.format(time);
        }
        cVar.O(format);
    }

    private SqlTimeTypeAdapter() {
        this.f11724a = new SimpleDateFormat("hh:mm:ss a");
    }
}
