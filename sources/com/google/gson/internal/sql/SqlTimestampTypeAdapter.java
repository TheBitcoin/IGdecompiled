package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import i1.C2079a;
import i1.C2081c;
import java.sql.Timestamp;
import java.util.Date;

class SqlTimestampTypeAdapter extends TypeAdapter {

    /* renamed from: b  reason: collision with root package name */
    static final r f11725b = new r() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.c() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.l(Date.class));
            }
            return null;
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final TypeAdapter f11726a;

    /* renamed from: e */
    public Timestamp b(C2079a aVar) {
        Date date = (Date) this.f11726a.b(aVar);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    /* renamed from: f */
    public void d(C2081c cVar, Timestamp timestamp) {
        this.f11726a.d(cVar, timestamp);
    }

    private SqlTimestampTypeAdapter(TypeAdapter typeAdapter) {
        this.f11726a = typeAdapter;
    }
}
