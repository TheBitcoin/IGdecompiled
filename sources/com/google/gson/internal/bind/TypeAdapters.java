package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.d;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.internal.f;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import f1.C1999c;
import i1.C2079a;
import i1.C2080b;
import i1.C2081c;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public abstract class TypeAdapters {

    /* renamed from: A  reason: collision with root package name */
    public static final TypeAdapter f11589A = new TypeAdapter() {
        /* renamed from: e */
        public BigInteger b(C2079a aVar) {
            if (aVar.L() == C2080b.NULL) {
                aVar.H();
                return null;
            }
            String J4 = aVar.J();
            try {
                return new BigInteger(J4);
            } catch (NumberFormatException e5) {
                throw new m("Failed parsing '" + J4 + "' as BigInteger; at path " + aVar.r(), e5);
            }
        }

        /* renamed from: f */
        public void d(C2081c cVar, BigInteger bigInteger) {
            cVar.N(bigInteger);
        }
    };

    /* renamed from: B  reason: collision with root package name */
    public static final TypeAdapter f11590B = new TypeAdapter() {
        /* renamed from: e */
        public f b(C2079a aVar) {
            if (aVar.L() != C2080b.NULL) {
                return new f(aVar.J());
            }
            aVar.H();
            return null;
        }

        /* renamed from: f */
        public void d(C2081c cVar, f fVar) {
            cVar.N(fVar);
        }
    };

    /* renamed from: C  reason: collision with root package name */
    public static final r f11591C;

    /* renamed from: D  reason: collision with root package name */
    public static final TypeAdapter f11592D;

    /* renamed from: E  reason: collision with root package name */
    public static final r f11593E;

    /* renamed from: F  reason: collision with root package name */
    public static final TypeAdapter f11594F;

    /* renamed from: G  reason: collision with root package name */
    public static final r f11595G;

    /* renamed from: H  reason: collision with root package name */
    public static final TypeAdapter f11596H;

    /* renamed from: I  reason: collision with root package name */
    public static final r f11597I;

    /* renamed from: J  reason: collision with root package name */
    public static final TypeAdapter f11598J;

    /* renamed from: K  reason: collision with root package name */
    public static final r f11599K;

    /* renamed from: L  reason: collision with root package name */
    public static final TypeAdapter f11600L;

    /* renamed from: M  reason: collision with root package name */
    public static final r f11601M;

    /* renamed from: N  reason: collision with root package name */
    public static final TypeAdapter f11602N;

    /* renamed from: O  reason: collision with root package name */
    public static final r f11603O;

    /* renamed from: P  reason: collision with root package name */
    public static final TypeAdapter f11604P;

    /* renamed from: Q  reason: collision with root package name */
    public static final r f11605Q;

    /* renamed from: R  reason: collision with root package name */
    public static final TypeAdapter f11606R;

    /* renamed from: S  reason: collision with root package name */
    public static final r f11607S;

    /* renamed from: T  reason: collision with root package name */
    public static final TypeAdapter f11608T;

    /* renamed from: U  reason: collision with root package name */
    public static final r f11609U;

    /* renamed from: V  reason: collision with root package name */
    public static final TypeAdapter f11610V;

    /* renamed from: W  reason: collision with root package name */
    public static final r f11611W;

    /* renamed from: X  reason: collision with root package name */
    public static final r f11612X = new r() {
        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            Class<? super Enum> c5 = typeToken.c();
            Class<Enum> cls = Enum.class;
            if (!cls.isAssignableFrom(c5) || c5 == cls) {
                return null;
            }
            if (!c5.isEnum()) {
                c5 = c5.getSuperclass();
            }
            return new EnumTypeAdapter(c5);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final TypeAdapter f11613a;

    /* renamed from: b  reason: collision with root package name */
    public static final r f11614b;

    /* renamed from: c  reason: collision with root package name */
    public static final TypeAdapter f11615c;

    /* renamed from: d  reason: collision with root package name */
    public static final r f11616d;

    /* renamed from: e  reason: collision with root package name */
    public static final TypeAdapter f11617e;

    /* renamed from: f  reason: collision with root package name */
    public static final TypeAdapter f11618f = new TypeAdapter() {
        /* renamed from: e */
        public Boolean b(C2079a aVar) {
            if (aVar.L() != C2080b.NULL) {
                return Boolean.valueOf(aVar.J());
            }
            aVar.H();
            return null;
        }

        /* renamed from: f */
        public void d(C2081c cVar, Boolean bool) {
            String str;
            if (bool == null) {
                str = "null";
            } else {
                str = bool.toString();
            }
            cVar.O(str);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static final r f11619g;

    /* renamed from: h  reason: collision with root package name */
    public static final TypeAdapter f11620h;

    /* renamed from: i  reason: collision with root package name */
    public static final r f11621i;

    /* renamed from: j  reason: collision with root package name */
    public static final TypeAdapter f11622j;

    /* renamed from: k  reason: collision with root package name */
    public static final r f11623k;

    /* renamed from: l  reason: collision with root package name */
    public static final TypeAdapter f11624l;

    /* renamed from: m  reason: collision with root package name */
    public static final r f11625m;

    /* renamed from: n  reason: collision with root package name */
    public static final TypeAdapter f11626n;

    /* renamed from: o  reason: collision with root package name */
    public static final r f11627o;

    /* renamed from: p  reason: collision with root package name */
    public static final TypeAdapter f11628p;

    /* renamed from: q  reason: collision with root package name */
    public static final r f11629q;

    /* renamed from: r  reason: collision with root package name */
    public static final TypeAdapter f11630r;

    /* renamed from: s  reason: collision with root package name */
    public static final r f11631s;

    /* renamed from: t  reason: collision with root package name */
    public static final TypeAdapter f11632t = new TypeAdapter() {
        /* renamed from: e */
        public Number b(C2079a aVar) {
            if (aVar.L() == C2080b.NULL) {
                aVar.H();
                return null;
            }
            try {
                return Long.valueOf(aVar.E());
            } catch (NumberFormatException e5) {
                throw new m((Throwable) e5);
            }
        }

        /* renamed from: f */
        public void d(C2081c cVar, Number number) {
            if (number == null) {
                cVar.x();
            } else {
                cVar.L(number.longValue());
            }
        }
    };

    /* renamed from: u  reason: collision with root package name */
    public static final TypeAdapter f11633u = new TypeAdapter() {
        /* renamed from: e */
        public Number b(C2079a aVar) {
            if (aVar.L() != C2080b.NULL) {
                return Float.valueOf((float) aVar.A());
            }
            aVar.H();
            return null;
        }

        /* renamed from: f */
        public void d(C2081c cVar, Number number) {
            if (number == null) {
                cVar.x();
                return;
            }
            if (!(number instanceof Float)) {
                number = Float.valueOf(number.floatValue());
            }
            cVar.N(number);
        }
    };

    /* renamed from: v  reason: collision with root package name */
    public static final TypeAdapter f11634v = new TypeAdapter() {
        /* renamed from: e */
        public Number b(C2079a aVar) {
            if (aVar.L() != C2080b.NULL) {
                return Double.valueOf(aVar.A());
            }
            aVar.H();
            return null;
        }

        /* renamed from: f */
        public void d(C2081c cVar, Number number) {
            if (number == null) {
                cVar.x();
            } else {
                cVar.K(number.doubleValue());
            }
        }
    };

    /* renamed from: w  reason: collision with root package name */
    public static final TypeAdapter f11635w;

    /* renamed from: x  reason: collision with root package name */
    public static final r f11636x;

    /* renamed from: y  reason: collision with root package name */
    public static final TypeAdapter f11637y;

    /* renamed from: z  reason: collision with root package name */
    public static final TypeAdapter f11638z = new TypeAdapter() {
        /* renamed from: e */
        public BigDecimal b(C2079a aVar) {
            if (aVar.L() == C2080b.NULL) {
                aVar.H();
                return null;
            }
            String J4 = aVar.J();
            try {
                return new BigDecimal(J4);
            } catch (NumberFormatException e5) {
                throw new m("Failed parsing '" + J4 + "' as BigDecimal; at path " + aVar.r(), e5);
            }
        }

        /* renamed from: f */
        public void d(C2081c cVar, BigDecimal bigDecimal) {
            cVar.N(bigDecimal);
        }
    };

    /* renamed from: com.google.gson.internal.bind.TypeAdapters$30  reason: invalid class name */
    class AnonymousClass30 implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TypeToken f11639a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TypeAdapter f11640b;

        public TypeAdapter a(Gson gson, TypeToken typeToken) {
            if (typeToken.equals(this.f11639a)) {
                return this.f11640b;
            }
            return null;
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Map f11653a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private final Map f11654b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        private final Map f11655c = new HashMap();

        class a implements PrivilegedAction {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Class f11656a;

            a(Class cls) {
                this.f11656a = cls;
            }

            /* renamed from: a */
            public Field[] run() {
                Field[] declaredFields = this.f11656a.getDeclaredFields();
                ArrayList arrayList = new ArrayList(declaredFields.length);
                for (Field field : declaredFields) {
                    if (field.isEnumConstant()) {
                        arrayList.add(field);
                    }
                }
                Field[] fieldArr = (Field[]) arrayList.toArray(new Field[0]);
                AccessibleObject.setAccessible(fieldArr, true);
                return fieldArr;
            }
        }

        public EnumTypeAdapter(Class cls) {
            try {
                for (Field field : (Field[]) AccessController.doPrivileged(new a(cls))) {
                    Enum enumR = (Enum) field.get((Object) null);
                    String name = enumR.name();
                    String str = enumR.toString();
                    C1999c cVar = (C1999c) field.getAnnotation(C1999c.class);
                    if (cVar != null) {
                        name = cVar.value();
                        for (String put : cVar.alternate()) {
                            this.f11653a.put(put, enumR);
                        }
                    }
                    this.f11653a.put(name, enumR);
                    this.f11654b.put(str, enumR);
                    this.f11655c.put(enumR, name);
                }
            } catch (IllegalAccessException e5) {
                throw new AssertionError(e5);
            }
        }

        /* renamed from: e */
        public Enum b(C2079a aVar) {
            if (aVar.L() == C2080b.NULL) {
                aVar.H();
                return null;
            }
            String J4 = aVar.J();
            Enum enumR = (Enum) this.f11653a.get(J4);
            if (enumR == null) {
                return (Enum) this.f11654b.get(J4);
            }
            return enumR;
        }

        /* renamed from: f */
        public void d(C2081c cVar, Enum enumR) {
            String str;
            if (enumR == null) {
                str = null;
            } else {
                str = (String) this.f11655c.get(enumR);
            }
            cVar.O(str);
        }
    }

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11658a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                i1.b[] r0 = i1.C2080b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f11658a = r0
                i1.b r1 = i1.C2080b.NUMBER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f11658a     // Catch:{ NoSuchFieldError -> 0x001d }
                i1.b r1 = i1.C2080b.STRING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f11658a     // Catch:{ NoSuchFieldError -> 0x0028 }
                i1.b r1 = i1.C2080b.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f11658a     // Catch:{ NoSuchFieldError -> 0x0033 }
                i1.b r1 = i1.C2080b.BEGIN_ARRAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f11658a     // Catch:{ NoSuchFieldError -> 0x003e }
                i1.b r1 = i1.C2080b.BEGIN_OBJECT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f11658a     // Catch:{ NoSuchFieldError -> 0x0049 }
                i1.b r1 = i1.C2080b.NULL     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.TypeAdapters.a.<clinit>():void");
        }
    }

    static {
        TypeAdapter a5 = new TypeAdapter() {
            /* renamed from: e */
            public Class b(C2079a aVar) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            /* renamed from: f */
            public void d(C2081c cVar, Class cls) {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }
        }.a();
        f11613a = a5;
        f11614b = a(Class.class, a5);
        TypeAdapter a6 = new TypeAdapter() {
            /* renamed from: e */
            public BitSet b(C2079a aVar) {
                BitSet bitSet = new BitSet();
                aVar.a();
                C2080b L4 = aVar.L();
                int i4 = 0;
                while (L4 != C2080b.END_ARRAY) {
                    int i5 = a.f11658a[L4.ordinal()];
                    boolean z4 = true;
                    if (i5 == 1 || i5 == 2) {
                        int D4 = aVar.D();
                        if (D4 == 0) {
                            z4 = false;
                        } else if (D4 != 1) {
                            throw new m("Invalid bitset value " + D4 + ", expected 0 or 1; at path " + aVar.r());
                        }
                    } else if (i5 == 3) {
                        z4 = aVar.z();
                    } else {
                        throw new m("Invalid bitset value type: " + L4 + "; at path " + aVar.getPath());
                    }
                    if (z4) {
                        bitSet.set(i4);
                    }
                    i4++;
                    L4 = aVar.L();
                }
                aVar.l();
                return bitSet;
            }

            /* renamed from: f */
            public void d(C2081c cVar, BitSet bitSet) {
                cVar.g();
                int length = bitSet.length();
                for (int i4 = 0; i4 < length; i4++) {
                    cVar.L(bitSet.get(i4) ? 1 : 0);
                }
                cVar.l();
            }
        }.a();
        f11615c = a6;
        f11616d = a(BitSet.class, a6);
        AnonymousClass3 r02 = new TypeAdapter() {
            /* renamed from: e */
            public Boolean b(C2079a aVar) {
                C2080b L4 = aVar.L();
                if (L4 == C2080b.NULL) {
                    aVar.H();
                    return null;
                } else if (L4 == C2080b.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(aVar.J()));
                } else {
                    return Boolean.valueOf(aVar.z());
                }
            }

            /* renamed from: f */
            public void d(C2081c cVar, Boolean bool) {
                cVar.M(bool);
            }
        };
        f11617e = r02;
        f11619g = b(Boolean.TYPE, Boolean.class, r02);
        AnonymousClass5 r03 = new TypeAdapter() {
            /* renamed from: e */
            public Number b(C2079a aVar) {
                if (aVar.L() == C2080b.NULL) {
                    aVar.H();
                    return null;
                }
                try {
                    int D4 = aVar.D();
                    if (D4 <= 255 && D4 >= -128) {
                        return Byte.valueOf((byte) D4);
                    }
                    throw new m("Lossy conversion from " + D4 + " to byte; at path " + aVar.r());
                } catch (NumberFormatException e5) {
                    throw new m((Throwable) e5);
                }
            }

            /* renamed from: f */
            public void d(C2081c cVar, Number number) {
                if (number == null) {
                    cVar.x();
                } else {
                    cVar.L((long) number.byteValue());
                }
            }
        };
        f11620h = r03;
        f11621i = b(Byte.TYPE, Byte.class, r03);
        AnonymousClass6 r04 = new TypeAdapter() {
            /* renamed from: e */
            public Number b(C2079a aVar) {
                if (aVar.L() == C2080b.NULL) {
                    aVar.H();
                    return null;
                }
                try {
                    int D4 = aVar.D();
                    if (D4 <= 65535 && D4 >= -32768) {
                        return Short.valueOf((short) D4);
                    }
                    throw new m("Lossy conversion from " + D4 + " to short; at path " + aVar.r());
                } catch (NumberFormatException e5) {
                    throw new m((Throwable) e5);
                }
            }

            /* renamed from: f */
            public void d(C2081c cVar, Number number) {
                if (number == null) {
                    cVar.x();
                } else {
                    cVar.L((long) number.shortValue());
                }
            }
        };
        f11622j = r04;
        f11623k = b(Short.TYPE, Short.class, r04);
        AnonymousClass7 r05 = new TypeAdapter() {
            /* renamed from: e */
            public Number b(C2079a aVar) {
                if (aVar.L() == C2080b.NULL) {
                    aVar.H();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.D());
                } catch (NumberFormatException e5) {
                    throw new m((Throwable) e5);
                }
            }

            /* renamed from: f */
            public void d(C2081c cVar, Number number) {
                if (number == null) {
                    cVar.x();
                } else {
                    cVar.L((long) number.intValue());
                }
            }
        };
        f11624l = r05;
        f11625m = b(Integer.TYPE, Integer.class, r05);
        TypeAdapter a7 = new TypeAdapter() {
            /* renamed from: e */
            public AtomicInteger b(C2079a aVar) {
                try {
                    return new AtomicInteger(aVar.D());
                } catch (NumberFormatException e5) {
                    throw new m((Throwable) e5);
                }
            }

            /* renamed from: f */
            public void d(C2081c cVar, AtomicInteger atomicInteger) {
                cVar.L((long) atomicInteger.get());
            }
        }.a();
        f11626n = a7;
        f11627o = a(AtomicInteger.class, a7);
        TypeAdapter a8 = new TypeAdapter() {
            /* renamed from: e */
            public AtomicBoolean b(C2079a aVar) {
                return new AtomicBoolean(aVar.z());
            }

            /* renamed from: f */
            public void d(C2081c cVar, AtomicBoolean atomicBoolean) {
                cVar.P(atomicBoolean.get());
            }
        }.a();
        f11628p = a8;
        f11629q = a(AtomicBoolean.class, a8);
        TypeAdapter a9 = new TypeAdapter() {
            /* renamed from: e */
            public AtomicIntegerArray b(C2079a aVar) {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.u()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.D()));
                    } catch (NumberFormatException e5) {
                        throw new m((Throwable) e5);
                    }
                }
                aVar.l();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i4 = 0; i4 < size; i4++) {
                    atomicIntegerArray.set(i4, ((Integer) arrayList.get(i4)).intValue());
                }
                return atomicIntegerArray;
            }

            /* renamed from: f */
            public void d(C2081c cVar, AtomicIntegerArray atomicIntegerArray) {
                cVar.g();
                int length = atomicIntegerArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    cVar.L((long) atomicIntegerArray.get(i4));
                }
                cVar.l();
            }
        }.a();
        f11630r = a9;
        f11631s = a(AtomicIntegerArray.class, a9);
        AnonymousClass14 r06 = new TypeAdapter() {
            /* renamed from: e */
            public Character b(C2079a aVar) {
                if (aVar.L() == C2080b.NULL) {
                    aVar.H();
                    return null;
                }
                String J4 = aVar.J();
                if (J4.length() == 1) {
                    return Character.valueOf(J4.charAt(0));
                }
                throw new m("Expecting character, got: " + J4 + "; at " + aVar.r());
            }

            /* renamed from: f */
            public void d(C2081c cVar, Character ch) {
                String str;
                if (ch == null) {
                    str = null;
                } else {
                    str = String.valueOf(ch);
                }
                cVar.O(str);
            }
        };
        f11635w = r06;
        f11636x = b(Character.TYPE, Character.class, r06);
        AnonymousClass15 r07 = new TypeAdapter() {
            /* renamed from: e */
            public String b(C2079a aVar) {
                C2080b L4 = aVar.L();
                if (L4 == C2080b.NULL) {
                    aVar.H();
                    return null;
                } else if (L4 == C2080b.BOOLEAN) {
                    return Boolean.toString(aVar.z());
                } else {
                    return aVar.J();
                }
            }

            /* renamed from: f */
            public void d(C2081c cVar, String str) {
                cVar.O(str);
            }
        };
        f11637y = r07;
        f11591C = a(String.class, r07);
        AnonymousClass19 r08 = new TypeAdapter() {
            /* renamed from: e */
            public StringBuilder b(C2079a aVar) {
                if (aVar.L() != C2080b.NULL) {
                    return new StringBuilder(aVar.J());
                }
                aVar.H();
                return null;
            }

            /* renamed from: f */
            public void d(C2081c cVar, StringBuilder sb) {
                String str;
                if (sb == null) {
                    str = null;
                } else {
                    str = sb.toString();
                }
                cVar.O(str);
            }
        };
        f11592D = r08;
        f11593E = a(StringBuilder.class, r08);
        AnonymousClass20 r09 = new TypeAdapter() {
            /* renamed from: e */
            public StringBuffer b(C2079a aVar) {
                if (aVar.L() != C2080b.NULL) {
                    return new StringBuffer(aVar.J());
                }
                aVar.H();
                return null;
            }

            /* renamed from: f */
            public void d(C2081c cVar, StringBuffer stringBuffer) {
                String str;
                if (stringBuffer == null) {
                    str = null;
                } else {
                    str = stringBuffer.toString();
                }
                cVar.O(str);
            }
        };
        f11594F = r09;
        f11595G = a(StringBuffer.class, r09);
        AnonymousClass21 r010 = new TypeAdapter() {
            /* renamed from: e */
            public URL b(C2079a aVar) {
                if (aVar.L() == C2080b.NULL) {
                    aVar.H();
                    return null;
                }
                String J4 = aVar.J();
                if ("null".equals(J4)) {
                    return null;
                }
                return new URL(J4);
            }

            /* renamed from: f */
            public void d(C2081c cVar, URL url) {
                String str;
                if (url == null) {
                    str = null;
                } else {
                    str = url.toExternalForm();
                }
                cVar.O(str);
            }
        };
        f11596H = r010;
        f11597I = a(URL.class, r010);
        AnonymousClass22 r011 = new TypeAdapter() {
            /* renamed from: e */
            public URI b(C2079a aVar) {
                if (aVar.L() == C2080b.NULL) {
                    aVar.H();
                    return null;
                }
                try {
                    String J4 = aVar.J();
                    if ("null".equals(J4)) {
                        return null;
                    }
                    return new URI(J4);
                } catch (URISyntaxException e5) {
                    throw new g((Throwable) e5);
                }
            }

            /* renamed from: f */
            public void d(C2081c cVar, URI uri) {
                String str;
                if (uri == null) {
                    str = null;
                } else {
                    str = uri.toASCIIString();
                }
                cVar.O(str);
            }
        };
        f11598J = r011;
        f11599K = a(URI.class, r011);
        AnonymousClass23 r012 = new TypeAdapter() {
            /* renamed from: e */
            public InetAddress b(C2079a aVar) {
                if (aVar.L() != C2080b.NULL) {
                    return InetAddress.getByName(aVar.J());
                }
                aVar.H();
                return null;
            }

            /* renamed from: f */
            public void d(C2081c cVar, InetAddress inetAddress) {
                String str;
                if (inetAddress == null) {
                    str = null;
                } else {
                    str = inetAddress.getHostAddress();
                }
                cVar.O(str);
            }
        };
        f11600L = r012;
        f11601M = d(InetAddress.class, r012);
        AnonymousClass24 r013 = new TypeAdapter() {
            /* renamed from: e */
            public UUID b(C2079a aVar) {
                if (aVar.L() == C2080b.NULL) {
                    aVar.H();
                    return null;
                }
                String J4 = aVar.J();
                try {
                    return UUID.fromString(J4);
                } catch (IllegalArgumentException e5) {
                    throw new m("Failed parsing '" + J4 + "' as UUID; at path " + aVar.r(), e5);
                }
            }

            /* renamed from: f */
            public void d(C2081c cVar, UUID uuid) {
                String str;
                if (uuid == null) {
                    str = null;
                } else {
                    str = uuid.toString();
                }
                cVar.O(str);
            }
        };
        f11602N = r013;
        f11603O = a(UUID.class, r013);
        TypeAdapter a10 = new TypeAdapter() {
            /* renamed from: e */
            public Currency b(C2079a aVar) {
                String J4 = aVar.J();
                try {
                    return Currency.getInstance(J4);
                } catch (IllegalArgumentException e5) {
                    throw new m("Failed parsing '" + J4 + "' as Currency; at path " + aVar.r(), e5);
                }
            }

            /* renamed from: f */
            public void d(C2081c cVar, Currency currency) {
                cVar.O(currency.getCurrencyCode());
            }
        }.a();
        f11604P = a10;
        f11605Q = a(Currency.class, a10);
        AnonymousClass26 r014 = new TypeAdapter() {
            /* renamed from: e */
            public Calendar b(C2079a aVar) {
                if (aVar.L() == C2080b.NULL) {
                    aVar.H();
                    return null;
                }
                aVar.d();
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (aVar.L() != C2080b.END_OBJECT) {
                    String F4 = aVar.F();
                    int D4 = aVar.D();
                    if ("year".equals(F4)) {
                        i4 = D4;
                    } else if ("month".equals(F4)) {
                        i5 = D4;
                    } else if ("dayOfMonth".equals(F4)) {
                        i6 = D4;
                    } else if ("hourOfDay".equals(F4)) {
                        i7 = D4;
                    } else if ("minute".equals(F4)) {
                        i8 = D4;
                    } else if ("second".equals(F4)) {
                        i9 = D4;
                    }
                }
                aVar.n();
                return new GregorianCalendar(i4, i5, i6, i7, i8, i9);
            }

            /* renamed from: f */
            public void d(C2081c cVar, Calendar calendar) {
                if (calendar == null) {
                    cVar.x();
                    return;
                }
                cVar.i();
                cVar.v("year");
                cVar.L((long) calendar.get(1));
                cVar.v("month");
                cVar.L((long) calendar.get(2));
                cVar.v("dayOfMonth");
                cVar.L((long) calendar.get(5));
                cVar.v("hourOfDay");
                cVar.L((long) calendar.get(11));
                cVar.v("minute");
                cVar.L((long) calendar.get(12));
                cVar.v("second");
                cVar.L((long) calendar.get(13));
                cVar.n();
            }
        };
        f11606R = r014;
        f11607S = c(Calendar.class, GregorianCalendar.class, r014);
        AnonymousClass27 r015 = new TypeAdapter() {
            /* renamed from: e */
            public Locale b(C2079a aVar) {
                String str;
                String str2;
                String str3 = null;
                if (aVar.L() == C2080b.NULL) {
                    aVar.H();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.J(), "_");
                if (stringTokenizer.hasMoreElements()) {
                    str = stringTokenizer.nextToken();
                } else {
                    str = null;
                }
                if (stringTokenizer.hasMoreElements()) {
                    str2 = stringTokenizer.nextToken();
                } else {
                    str2 = null;
                }
                if (stringTokenizer.hasMoreElements()) {
                    str3 = stringTokenizer.nextToken();
                }
                if (str2 == null && str3 == null) {
                    return new Locale(str);
                }
                if (str3 == null) {
                    return new Locale(str, str2);
                }
                return new Locale(str, str2, str3);
            }

            /* renamed from: f */
            public void d(C2081c cVar, Locale locale) {
                String str;
                if (locale == null) {
                    str = null;
                } else {
                    str = locale.toString();
                }
                cVar.O(str);
            }
        };
        f11608T = r015;
        f11609U = a(Locale.class, r015);
        AnonymousClass28 r016 = new TypeAdapter() {
            private com.google.gson.f f(C2079a aVar, C2080b bVar) {
                int i4 = a.f11658a[bVar.ordinal()];
                if (i4 == 1) {
                    return new k((Number) new f(aVar.J()));
                }
                if (i4 == 2) {
                    return new k(aVar.J());
                }
                if (i4 == 3) {
                    return new k(Boolean.valueOf(aVar.z()));
                }
                if (i4 == 6) {
                    aVar.H();
                    return h.f11501a;
                }
                throw new IllegalStateException("Unexpected token: " + bVar);
            }

            private com.google.gson.f g(C2079a aVar, C2080b bVar) {
                int i4 = a.f11658a[bVar.ordinal()];
                if (i4 == 4) {
                    aVar.a();
                    return new d();
                } else if (i4 != 5) {
                    return null;
                } else {
                    aVar.d();
                    return new i();
                }
            }

            /* renamed from: e */
            public com.google.gson.f b(C2079a aVar) {
                String str;
                boolean z4;
                C2080b L4 = aVar.L();
                com.google.gson.f g4 = g(aVar, L4);
                if (g4 == null) {
                    return f(aVar, L4);
                }
                ArrayDeque arrayDeque = new ArrayDeque();
                while (true) {
                    if (aVar.u()) {
                        if (g4 instanceof i) {
                            str = aVar.F();
                        } else {
                            str = null;
                        }
                        C2080b L5 = aVar.L();
                        com.google.gson.f g5 = g(aVar, L5);
                        if (g5 != null) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (g5 == null) {
                            g5 = f(aVar, L5);
                        }
                        if (g4 instanceof d) {
                            ((d) g4).n(g5);
                        } else {
                            ((i) g4).n(str, g5);
                        }
                        if (z4) {
                            arrayDeque.addLast(g4);
                            g4 = g5;
                        }
                    } else {
                        if (g4 instanceof d) {
                            aVar.l();
                        } else {
                            aVar.n();
                        }
                        if (arrayDeque.isEmpty()) {
                            return g4;
                        }
                        g4 = (com.google.gson.f) arrayDeque.removeLast();
                    }
                }
            }

            /* renamed from: h */
            public void d(C2081c cVar, com.google.gson.f fVar) {
                if (fVar == null || fVar.k()) {
                    cVar.x();
                } else if (fVar.m()) {
                    k h4 = fVar.h();
                    if (h4.s()) {
                        cVar.N(h4.o());
                    } else if (h4.q()) {
                        cVar.P(h4.n());
                    } else {
                        cVar.O(h4.p());
                    }
                } else if (fVar.j()) {
                    cVar.g();
                    Iterator it = fVar.c().iterator();
                    while (it.hasNext()) {
                        d(cVar, (com.google.gson.f) it.next());
                    }
                    cVar.l();
                } else if (fVar.l()) {
                    cVar.i();
                    for (Map.Entry entry : fVar.g().o()) {
                        cVar.v((String) entry.getKey());
                        d(cVar, (com.google.gson.f) entry.getValue());
                    }
                    cVar.n();
                } else {
                    throw new IllegalArgumentException("Couldn't write " + fVar.getClass());
                }
            }
        };
        f11610V = r016;
        f11611W = d(com.google.gson.f.class, r016);
    }

    public static r a(final Class cls, final TypeAdapter typeAdapter) {
        return new r() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                if (typeToken.c() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static r b(final Class cls, final Class cls2, final TypeAdapter typeAdapter) {
        return new r() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                Class c5 = typeToken.c();
                if (c5 == cls || c5 == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static r c(final Class cls, final Class cls2, final TypeAdapter typeAdapter) {
        return new r() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                Class c5 = typeToken.c();
                if (c5 == cls || c5 == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static r d(final Class cls, final TypeAdapter typeAdapter) {
        return new r() {
            public TypeAdapter a(Gson gson, TypeToken typeToken) {
                final Class c5 = typeToken.c();
                if (!cls.isAssignableFrom(c5)) {
                    return null;
                }
                return new TypeAdapter() {
                    public Object b(C2079a aVar) {
                        Object b5 = typeAdapter.b(aVar);
                        if (b5 == null || c5.isInstance(b5)) {
                            return b5;
                        }
                        throw new m("Expected a " + c5.getName() + " but was " + b5.getClass().getName() + "; at path " + aVar.r());
                    }

                    public void d(C2081c cVar, Object obj) {
                        typeAdapter.d(cVar, obj);
                    }
                };
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
