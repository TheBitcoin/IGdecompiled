package com.google.gson.internal;

import android.support.v4.media.a;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import f1.C1997a;
import f1.C2000d;
import f1.C2001e;
import i1.C2079a;
import i1.C2081c;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder implements r, Cloneable {

    /* renamed from: g  reason: collision with root package name */
    public static final Excluder f11503g = new Excluder();

    /* renamed from: a  reason: collision with root package name */
    private double f11504a = -1.0d;

    /* renamed from: b  reason: collision with root package name */
    private int f11505b = 136;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11506c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11507d;

    /* renamed from: e  reason: collision with root package name */
    private List f11508e;

    /* renamed from: f  reason: collision with root package name */
    private List f11509f;

    public Excluder() {
        List list = Collections.EMPTY_LIST;
        this.f11508e = list;
        this.f11509f = list;
    }

    private boolean d(Class cls) {
        if (this.f11504a != -1.0d && !l((C2000d) cls.getAnnotation(C2000d.class), (C2001e) cls.getAnnotation(C2001e.class))) {
            return true;
        }
        if (this.f11506c || !h(cls)) {
            return g(cls);
        }
        return true;
    }

    private boolean e(Class cls, boolean z4) {
        List list;
        if (z4) {
            list = this.f11508e;
        } else {
            list = this.f11509f;
        }
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        a.a(it.next());
        throw null;
    }

    private boolean g(Class cls) {
        if (Enum.class.isAssignableFrom(cls) || i(cls)) {
            return false;
        }
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return true;
        }
        return false;
    }

    private boolean h(Class cls) {
        if (!cls.isMemberClass() || i(cls)) {
            return false;
        }
        return true;
    }

    private boolean i(Class cls) {
        if ((cls.getModifiers() & 8) != 0) {
            return true;
        }
        return false;
    }

    private boolean j(C2000d dVar) {
        if (dVar == null) {
            return true;
        }
        if (this.f11504a >= dVar.value()) {
            return true;
        }
        return false;
    }

    private boolean k(C2001e eVar) {
        if (eVar == null) {
            return true;
        }
        if (this.f11504a < eVar.value()) {
            return true;
        }
        return false;
    }

    private boolean l(C2000d dVar, C2001e eVar) {
        if (!j(dVar) || !k(eVar)) {
            return false;
        }
        return true;
    }

    public TypeAdapter a(Gson gson, TypeToken typeToken) {
        final boolean z4;
        final boolean z5;
        Class c5 = typeToken.c();
        boolean d5 = d(c5);
        if (d5 || e(c5, true)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (d5 || e(c5, false)) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z4 && !z5) {
            return null;
        }
        final Gson gson2 = gson;
        final TypeToken typeToken2 = typeToken;
        return new TypeAdapter() {

            /* renamed from: a  reason: collision with root package name */
            private TypeAdapter f11510a;

            private TypeAdapter e() {
                TypeAdapter typeAdapter = this.f11510a;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter m4 = gson2.m(Excluder.this, typeToken2);
                this.f11510a = m4;
                return m4;
            }

            public Object b(C2079a aVar) {
                if (!z5) {
                    return e().b(aVar);
                }
                aVar.V();
                return null;
            }

            public void d(C2081c cVar, Object obj) {
                if (z4) {
                    cVar.x();
                } else {
                    e().d(cVar, obj);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e5) {
            throw new AssertionError(e5);
        }
    }

    public boolean c(Class cls, boolean z4) {
        if (d(cls) || e(cls, z4)) {
            return true;
        }
        return false;
    }

    public boolean f(Field field, boolean z4) {
        List list;
        C1997a aVar;
        if ((this.f11505b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f11504a != -1.0d && !l((C2000d) field.getAnnotation(C2000d.class), (C2001e) field.getAnnotation(C2001e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f11507d && ((aVar = (C1997a) field.getAnnotation(C1997a.class)) == null || (!z4 ? !aVar.deserialize() : !aVar.serialize()))) {
            return true;
        }
        if ((!this.f11506c && h(field.getType())) || g(field.getType())) {
            return true;
        }
        if (z4) {
            list = this.f11508e;
        } else {
            list = this.f11509f;
        }
        if (list.isEmpty()) {
            return false;
        }
        new com.google.gson.a(field);
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return false;
        }
        a.a(it.next());
        throw null;
    }
}
