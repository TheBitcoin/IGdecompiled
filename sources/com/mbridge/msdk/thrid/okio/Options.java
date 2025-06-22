package com.mbridge.msdk.thrid.okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j4, Buffer buffer, int i4, List<ByteString> list, int i5, int i6, List<Integer> list2) {
        int i7;
        int i8;
        long j5;
        int i9;
        List<Integer> list3;
        int i10;
        long j6;
        Buffer buffer2 = buffer;
        int i11 = i4;
        List<ByteString> list4 = list;
        int i12 = i5;
        int i13 = i6;
        List<Integer> list5 = list2;
        if (i12 < i13) {
            int i14 = i12;
            while (i14 < i13) {
                if (list4.get(i14).size() >= i11) {
                    i14++;
                } else {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i5);
            ByteString byteString2 = list4.get(i13 - 1);
            if (i11 == byteString.size()) {
                int intValue = list5.get(i12).intValue();
                int i15 = i12 + 1;
                ByteString byteString3 = list4.get(i15);
                i7 = i15;
                i8 = intValue;
                byteString = byteString3;
            } else {
                i7 = i12;
                i8 = -1;
            }
            long j7 = 2;
            if (byteString.getByte(i11) != byteString2.getByte(i11)) {
                int i16 = 1;
                for (int i17 = i7 + 1; i17 < i13; i17++) {
                    if (list4.get(i17 - 1).getByte(i11) != list4.get(i17).getByte(i11)) {
                        i16++;
                    }
                }
                long intCount = j4 + ((long) intCount(buffer2)) + 2 + ((long) (i16 * 2));
                buffer2.writeInt(i16);
                buffer2.writeInt(i8);
                for (int i18 = i7; i18 < i13; i18++) {
                    byte b5 = list4.get(i18).getByte(i11);
                    if (i18 == i7 || b5 != list4.get(i18 - 1).getByte(i11)) {
                        buffer2.writeInt((int) b5 & 255);
                    }
                }
                Buffer buffer3 = new Buffer();
                int i19 = i7;
                while (i19 < i13) {
                    byte b6 = list4.get(i19).getByte(i11);
                    int i20 = i19 + 1;
                    int i21 = i20;
                    while (true) {
                        if (i21 >= i13) {
                            i21 = i13;
                            break;
                        } else if (b6 != list4.get(i21).getByte(i11)) {
                            break;
                        } else {
                            i21++;
                        }
                    }
                    if (i20 == i21 && i11 + 1 == list4.get(i19).size()) {
                        buffer2.writeInt(list5.get(i19).intValue());
                        list3 = list5;
                        j6 = intCount;
                        i10 = i21;
                    } else {
                        buffer2.writeInt((int) ((((long) intCount(buffer3)) + intCount) * -1));
                        list3 = list5;
                        j6 = intCount;
                        i10 = i21;
                        List<ByteString> list6 = list;
                        buildTrieRecursive(j6, buffer3, i11 + 1, list6, i19, i10, list3);
                        list4 = list6;
                    }
                    intCount = j6;
                    i19 = i10;
                    list5 = list3;
                }
                buffer2.write(buffer3, buffer3.size());
                return;
            }
            List<Integer> list7 = list5;
            int min = Math.min(byteString.size(), byteString2.size());
            int i22 = 0;
            int i23 = i11;
            while (true) {
                if (i23 >= min) {
                    j5 = j7;
                    break;
                }
                j5 = j7;
                if (byteString.getByte(i23) != byteString2.getByte(i23)) {
                    break;
                }
                i22++;
                i23++;
                j7 = j5;
            }
            long intCount2 = j4 + ((long) intCount(buffer2)) + j5 + ((long) i22) + 1;
            buffer2.writeInt(-i22);
            buffer2.writeInt(i8);
            int i24 = i11;
            while (true) {
                i9 = i11 + i22;
                if (i24 >= i9) {
                    break;
                }
                buffer2.writeInt((int) byteString.getByte(i24) & 255);
                i24++;
            }
            if (i7 + 1 != i13) {
                Buffer buffer4 = new Buffer();
                buffer2.writeInt((int) ((((long) intCount(buffer4)) + intCount2) * -1));
                long j8 = intCount2;
                buildTrieRecursive(j8, buffer4, i9, list4, i7, i13, list7);
                buffer2.write(buffer4, buffer4.size());
            } else if (i9 == list4.get(i7).size()) {
                buffer2.writeInt(list7.get(i7).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList2.add(-1);
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i5]), Integer.valueOf(i5));
        }
        if (((ByteString) arrayList.get(0)).size() != 0) {
            int i6 = 0;
            while (i6 < arrayList.size()) {
                ByteString byteString = (ByteString) arrayList.get(i6);
                int i7 = i6 + 1;
                int i8 = i7;
                while (i8 < arrayList.size()) {
                    ByteString byteString2 = (ByteString) arrayList.get(i8);
                    if (!byteString2.startsWith(byteString)) {
                        continue;
                        break;
                    } else if (byteString2.size() == byteString.size()) {
                        throw new IllegalArgumentException("duplicate option: " + byteString2);
                    } else if (((Integer) arrayList2.get(i8)).intValue() > ((Integer) arrayList2.get(i6)).intValue()) {
                        arrayList.remove(i8);
                        arrayList2.remove(i8);
                    } else {
                        i8++;
                    }
                }
                i6 = i7;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive(0, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
            int intCount = intCount(buffer);
            int[] iArr = new int[intCount];
            for (int i9 = 0; i9 < intCount; i9++) {
                iArr[i9] = buffer.readInt();
            }
            if (buffer.exhausted()) {
                return new Options((ByteString[]) byteStringArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    public final int size() {
        return this.byteStrings.length;
    }

    public ByteString get(int i4) {
        return this.byteStrings[i4];
    }
}
