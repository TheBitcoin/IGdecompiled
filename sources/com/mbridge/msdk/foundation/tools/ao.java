package com.mbridge.msdk.foundation.tools;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.LinkedHashSet;
import java.util.Set;

final class ao implements FastKV.a<Set<String>> {

    /* renamed from: a  reason: collision with root package name */
    static final ao f13611a = new ao();

    private ao() {
    }

    public final /* synthetic */ byte[] a(Object obj) {
        Set<String> set = (Set) obj;
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i4 = 0;
        int i5 = 0;
        for (String str : set) {
            if (str == null) {
                i4 += 5;
                iArr[i5] = -1;
            } else {
                int a5 = q.a(str);
                strArr[i5] = str;
                iArr[i5] = a5;
                i4 += ((a5 >> 7) == 0 ? 1 : (a5 >> 14) == 0 ? 2 : (a5 >> 21) == 0 ? 3 : (a5 >> 28) == 0 ? 4 : 5) + a5;
            }
            i5++;
        }
        q qVar = new q(i4);
        for (int i6 = 0; i6 < size; i6++) {
            int i7 = iArr[i6];
            int i8 = qVar.f13681b;
            int i9 = i7;
            while ((i9 & -128) != 0) {
                qVar.f13680a[i8] = (byte) ((i9 & ModuleDescriptor.MODULE_VERSION) | 128);
                i9 >>>= 7;
                i8++;
            }
            qVar.f13680a[i8] = (byte) i9;
            qVar.f13681b = i8 + 1;
            if (i7 >= 0) {
                qVar.b(strArr[i6]);
            }
        }
        return qVar.f13680a;
    }

    public final String a() {
        return "StringSet";
    }

    public final /* synthetic */ Object a(byte[] bArr, int i4, int i5) {
        int i6;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i5 > 0) {
            q qVar = new q(bArr, i4);
            int i7 = i4 + i5;
            while (true) {
                i6 = qVar.f13681b;
                if (i6 >= i7) {
                    break;
                }
                byte[] bArr2 = qVar.f13680a;
                int i8 = i6 + 1;
                qVar.f13681b = i8;
                byte b5 = bArr2[i6];
                if ((b5 >> 7) != 0) {
                    int i9 = i6 + 2;
                    qVar.f13681b = i9;
                    b5 = (b5 & Byte.MAX_VALUE) | (bArr2[i8] << 7);
                    if ((b5 >> 14) != 0) {
                        byte b6 = b5 & 16383;
                        int i10 = i6 + 3;
                        qVar.f13681b = i10;
                        byte b7 = b6 | (bArr2[i9] << 14);
                        if ((b7 >> 21) == 0) {
                            b5 = b7;
                        } else {
                            int i11 = i6 + 4;
                            qVar.f13681b = i11;
                            b5 = (bArr2[i10] << 21) | (b7 & 2097151);
                            if ((b5 >> 28) != 0) {
                                qVar.f13681b = i6 + 5;
                                b5 = (268435455 & b5) | (bArr2[i11] << 28);
                            }
                        }
                    }
                }
                linkedHashSet.add(qVar.a((int) b5));
            }
            if (i6 != i7) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
