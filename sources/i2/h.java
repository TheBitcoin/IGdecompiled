package I2;

import G2.c;
import G2.e;
import I2.d;
import com.inmobi.cmp.core.model.Vector;
import java.util.Map;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6699a = new a();

    public static final class a {
        public final Vector a(String str) {
            int i4;
            int i5;
            int i6;
            int i7;
            char c5;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            int i18;
            int i19;
            String str2 = str;
            m.e(str2, "value");
            Vector vector = new Vector((Map) null, 1, (C2103g) null);
            d.a aVar = d.f6695a;
            c cVar = c.f6592a;
            G2.d dVar = G2.d.MAX_ID;
            Integer a5 = cVar.a(dVar);
            if (a5 == null) {
                i4 = 0;
            } else {
                i4 = a5.intValue();
            }
            String substring = str2.substring(0, i4);
            m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            Integer a6 = cVar.a(dVar);
            if (a6 == null) {
                i5 = 0;
            } else {
                i5 = a6.intValue();
            }
            int a7 = aVar.a(substring, i5);
            Integer a8 = cVar.a(dVar);
            if (a8 == null) {
                i6 = 0;
            } else {
                i6 = a8.intValue();
            }
            String valueOf = String.valueOf(str2.charAt(i6));
            G2.d dVar2 = G2.d.ENCODING_TYPE;
            Integer a9 = cVar.a(dVar2);
            if (a9 == null) {
                i7 = 0;
            } else {
                i7 = a9.intValue();
            }
            int a10 = aVar.a(valueOf, i7);
            if (a10 == 0) {
                c5 = 1;
            } else if (a10 == 1) {
                c5 = 2;
            } else {
                a aVar2 = h.f6699a;
                throw new e(m.m("h.h", ": Too large value to encode into VectorEncodingType"));
            }
            Integer a11 = cVar.a(dVar2);
            if (a11 == null) {
                i8 = 0;
            } else {
                i8 = a11.intValue();
            }
            int i20 = i6 + i8;
            if (c5 == 2) {
                G2.d dVar3 = G2.d.NUM_ENTRIES;
                Integer a12 = cVar.a(dVar3);
                if (a12 == null) {
                    i10 = 0;
                } else {
                    i10 = a12.intValue();
                }
                String substring2 = str2.substring(i20, i10);
                m.d(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                Integer a13 = cVar.a(dVar3);
                if (a13 == null) {
                    i11 = 0;
                } else {
                    i11 = a13.intValue();
                }
                int a14 = aVar.a(substring2, i11);
                Integer a15 = cVar.a(dVar3);
                if (a15 == null) {
                    i12 = 0;
                } else {
                    i12 = a15.intValue();
                }
                i9 = i20 + i12;
                if (a14 >= 0) {
                    int i21 = 0;
                    while (true) {
                        int i22 = i21 + 1;
                        String valueOf2 = String.valueOf(str2.charAt(i9));
                        m.e(valueOf2, "value");
                        boolean a16 = m.a(valueOf2, "1");
                        c cVar2 = c.f6592a;
                        Integer a17 = cVar2.a(G2.d.SINGLE_OR_RANGE);
                        if (a17 == null) {
                            i13 = 0;
                        } else {
                            i13 = a17.intValue();
                        }
                        int i23 = i9 + i13;
                        d.a aVar3 = d.f6695a;
                        G2.d dVar4 = G2.d.VENDOR_ID;
                        Integer a18 = cVar2.a(dVar4);
                        if (a18 == null) {
                            i14 = 0;
                        } else {
                            i14 = a18.intValue();
                        }
                        String substring3 = str2.substring(i23, i14);
                        m.d(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                        Integer a19 = cVar2.a(dVar4);
                        if (a19 == null) {
                            i15 = 0;
                        } else {
                            i15 = a19.intValue();
                        }
                        int a20 = aVar3.a(substring3, i15);
                        Integer a21 = cVar2.a(dVar4);
                        if (a21 == null) {
                            i16 = 0;
                        } else {
                            i16 = a21.intValue();
                        }
                        i9 = i23 + i16;
                        if (a16) {
                            Integer a22 = cVar2.a(dVar4);
                            if (a22 == null) {
                                i17 = 0;
                            } else {
                                i17 = a22.intValue();
                            }
                            String substring4 = str2.substring(i9, i17);
                            m.d(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
                            Integer a23 = cVar2.a(dVar4);
                            if (a23 == null) {
                                i18 = 0;
                            } else {
                                i18 = a23.intValue();
                            }
                            int a24 = aVar3.a(substring4, i18);
                            Integer a25 = cVar2.a(dVar4);
                            if (a25 == null) {
                                i19 = 0;
                            } else {
                                i19 = a25.intValue();
                            }
                            i9 += i19;
                            if (a20 <= a24) {
                                while (true) {
                                    int i24 = a20 + 1;
                                    vector.set(a20);
                                    if (a20 == a24) {
                                        break;
                                    }
                                    a20 = i24;
                                }
                            }
                        } else {
                            vector.set(a20);
                        }
                        if (i21 == a14) {
                            break;
                        }
                        i21 = i22;
                    }
                }
            } else {
                int i25 = i20 + a7;
                String substring5 = str2.substring(i20, i25);
                m.d(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
                vector = c.f6694a.a(substring5, a7);
                i9 = i25;
            }
            vector.setBitLength(i9);
            return vector;
        }
    }
}
