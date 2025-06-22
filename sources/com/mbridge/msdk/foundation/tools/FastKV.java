package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.foundation.tools.g;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class FastKV {
    static final int ASYNC_BLOCKING = 1;
    private static final String A_SUFFIX = ".kva";
    private static final int BASE_GC_BYTES_THRESHOLD = 4096;
    private static final int BASE_GC_KEYS_THRESHOLD = 80;
    private static final String BOTH_FILES_ERROR = "both files error";
    private static final String B_SUFFIX = ".kvb";
    private static final String C_SUFFIX = ".kvc";
    private static final int DATA_SIZE_LIMIT = 536870912;
    private static final int DATA_START = 12;
    private static final int DOUBLE_LIMIT;
    private static final byte[] EMPTY_ARRAY = new byte[0];
    static final String GC_FINISH = "gc finish";
    private static final int INTERNAL_LIMIT = 2048;
    private static final String MAP_FAILED = "map failed";
    static final int NON_BLOCKING = 0;
    private static final String OPEN_FILE_FAILED = "open file failed";
    private static final int PAGE_SIZE;
    private static final String PARSE_DATA_FAILED = "parse dara failed";
    static final int SYNC_BLOCKING = 2;
    private static final String TEMP_SUFFIX = ".tmp";
    static final String TRUNCATE_FINISH = "truncate finish";
    private static final int TRUNCATE_THRESHOLD;
    private static final int[] TYPE_SIZE = {0, 1, 4, 4, 8, 8};
    private MappedByteBuffer aBuffer;
    private FileChannel aChannel;
    private boolean autoCommit = true;
    private MappedByteBuffer bBuffer;
    private FileChannel bChannel;
    private long checksum;
    private final Map<String, g.b> data = new HashMap();
    private int dataEnd;
    private final Map<String, a> encoderMap;
    private final Executor executor = new t();
    private q fastBuffer;
    private int invalidBytes;
    private final ArrayList<c> invalids = new ArrayList<>();
    private final b logger = r.f13684b;
    private final String name;
    private final String path;
    private int removeStart;
    private boolean sizeChanged;
    private String tempExternalName;
    private int updateSize;
    private int updateStart;
    private int writingMode;

    public static class Builder {
        private static final Map<String, FastKV> INSTANCE_MAP = new ConcurrentHashMap();
        private a[] encoders;
        private final String name;
        private final String path;
        private int writingMode = 0;

        public Builder(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            } else if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                if (!str.endsWith("/")) {
                    str = str + '/';
                }
                this.path = str;
                this.name = str2;
            }
        }

        public Builder asyncBlocking() {
            this.writingMode = 1;
            return this;
        }

        public Builder blocking() {
            this.writingMode = 2;
            return this;
        }

        public FastKV build() {
            FastKV fastKV;
            String str = this.path + this.name;
            Map<String, FastKV> map = INSTANCE_MAP;
            FastKV fastKV2 = map.get(str);
            if (fastKV2 != null) {
                return fastKV2;
            }
            synchronized (Builder.class) {
                try {
                    fastKV = map.get(str);
                    if (fastKV == null) {
                        fastKV = new FastKV(this.path, this.name, this.encoders, this.writingMode);
                        map.put(str, fastKV);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fastKV;
        }

        public Builder encoder(a[] aVarArr) {
            this.encoders = aVarArr;
            return this;
        }
    }

    public interface a<T> {
        T a(byte[] bArr, int i4, int i5);

        String a();

        byte[] a(T t4);
    }

    public interface b {
        void a(String str, Exception exc);

        void a(String str, String str2);

        void b(String str, Exception exc);
    }

    private static class c implements Comparable<c> {

        /* renamed from: a  reason: collision with root package name */
        int f13491a;

        /* renamed from: b  reason: collision with root package name */
        int f13492b;

        c(int i4, int i5) {
            this.f13492b = i4;
            this.f13491a = i5;
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.f13492b - ((c) obj).f13492b;
        }
    }

    static {
        int a5 = ar.a();
        PAGE_SIZE = a5;
        int max = Math.max(a5 << 1, 16384);
        DOUBLE_LIMIT = max;
        TRUNCATE_THRESHOLD = max << 1;
    }

    FastKV(String str, String str2, a[] aVarArr, int i4) {
        this.path = str;
        this.name = str2;
        this.writingMode = i4;
        HashMap hashMap = new HashMap();
        hashMap.put("StringSet", ao.f13611a);
        if (aVarArr != null && aVarArr.length > 0) {
            for (a aVar : aVarArr) {
                String a5 = aVar.a();
                if (hashMap.containsKey(a5)) {
                    error("duplicate encoder tag:" + a5);
                } else {
                    hashMap.put(a5, aVar);
                }
            }
        }
        this.encoderMap = hashMap;
        loadData();
    }

    private void addObject(String str, Object obj, byte[] bArr, byte b5) {
        boolean z4;
        int i4;
        String str2;
        Object obj2;
        int saveArray = saveArray(str, bArr, b5);
        if (saveArray != 0) {
            String str3 = this.tempExternalName;
            if (str3 != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (z4) {
                this.tempExternalName = null;
                str2 = str3;
                i4 = 32;
            } else {
                str2 = obj;
                i4 = bArr.length;
            }
            if (b5 == 6) {
                obj2 = new g.i(this.updateStart, saveArray, (String) str2, i4, z4);
            } else if (b5 == 7) {
                obj2 = new g.a(this.updateStart, saveArray, str2, i4, z4);
            } else {
                obj2 = new g.h(this.updateStart, saveArray, str2, i4, z4);
            }
            this.data.put(str, obj2);
            updateChange();
        }
    }

    private void addOrUpdate(String str, Object obj, byte[] bArr, g.j jVar, byte b5) {
        if (jVar == null) {
            addObject(str, obj, bArr, b5);
        } else if (jVar.f13663b || jVar.f13666e != bArr.length) {
            updateObject(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.f13657a, bArr);
            jVar.f13665d = obj;
        }
        checkIfCommit();
    }

    private int bytesThreshold() {
        int i4 = this.dataEnd;
        if (i4 <= 16384) {
            return 4096;
        }
        if (i4 <= 65536) {
            return 8192;
        }
        return 16384;
    }

    private void checkGC() {
        int i4;
        if (this.invalidBytes < (bytesThreshold() << 1)) {
            int size = this.invalids.size();
            if (this.dataEnd < 16384) {
                i4 = 80;
            } else {
                i4 = 160;
            }
            if (size < i4) {
                return;
            }
        }
        gc(0);
    }

    private void checkIfCommit() {
        if (this.writingMode != 0 && this.autoCommit) {
            commitToCFile();
        }
    }

    private void checkKey(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void checkKeySize(int i4) {
        if (i4 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void checkValueSize(int i4, boolean z4) {
        if (z4) {
            if (i4 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i4 < 0 || i4 >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void clearData() {
        this.dataEnd = 12;
        this.checksum = 0;
        clearInvalid();
        this.data.clear();
        q qVar = this.fastBuffer;
        if (qVar == null || qVar.f13680a.length != PAGE_SIZE) {
            this.fastBuffer = new q(PAGE_SIZE);
            return;
        }
        qVar.b(0, 0);
        this.fastBuffer.a(4, 0);
    }

    private void clearInvalid() {
        this.invalidBytes = 0;
        this.invalids.clear();
    }

    private boolean commitToCFile() {
        int i4 = this.writingMode;
        if (i4 == 1) {
            this.executor.execute(new Runnable() {
                public final void run() {
                    boolean unused = FastKV.this.writeToCFile();
                }
            });
        } else if (i4 == 2) {
            return writeToCFile();
        }
        return true;
    }

    private void copyBuffer(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i4) {
        FileChannel fileChannel;
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                if (mappedByteBuffer2 == this.bBuffer) {
                    fileChannel = this.bChannel;
                } else {
                    fileChannel = this.aChannel;
                }
                MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, (long) mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bBuffer) {
                    this.bBuffer = map;
                } else {
                    this.aBuffer = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e5) {
                error((Exception) e5);
                toBlockingMode();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i4);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void countInvalid(int i4, int i5) {
        this.invalidBytes += i5 - i4;
        this.invalids.add(new c(i4, i5));
    }

    private void deleteCFiles() {
        try {
            String str = this.path;
            ar.a(new File(str, this.name + C_SUFFIX));
            String str2 = this.path;
            ar.a(new File(str2, this.name + TEMP_SUFFIX));
        } catch (Exception e5) {
            error(e5);
        }
    }

    private void ensureSize(int i4) {
        int length = this.fastBuffer.f13680a.length;
        int i5 = this.dataEnd + i4;
        if (i5 >= length) {
            int i6 = this.invalidBytes;
            if (i6 <= i4 || i6 <= bytesThreshold()) {
                int newCapacity = getNewCapacity(length, i5);
                byte[] bArr = new byte[newCapacity];
                System.arraycopy(this.fastBuffer.f13680a, 0, bArr, 0, this.dataEnd);
                this.fastBuffer.f13680a = bArr;
                if (this.writingMode == 0) {
                    try {
                        FileChannel fileChannel = this.aChannel;
                        FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                        long j4 = (long) newCapacity;
                        MappedByteBuffer map = fileChannel.map(mapMode, 0, j4);
                        this.aBuffer = map;
                        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                        map.order(byteOrder);
                        MappedByteBuffer map2 = this.bChannel.map(mapMode, 0, j4);
                        this.bBuffer = map2;
                        map2.order(byteOrder);
                    } catch (IOException e5) {
                        error(new Exception(MAP_FAILED, e5));
                        this.fastBuffer.b(0, this.dataEnd - 12);
                        this.fastBuffer.a(4, this.checksum);
                        toBlockingMode();
                    }
                }
            } else {
                gc(i4);
            }
        }
    }

    private void error(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, exc);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fastPutString(java.lang.String r10, java.lang.String r11, com.mbridge.msdk.foundation.tools.g.i r12) {
        /*
            r9 = this;
            int r4 = com.mbridge.msdk.foundation.tools.q.a((java.lang.String) r11)
            r0 = 6
            if (r12 != 0) goto L_0x0037
            int r12 = com.mbridge.msdk.foundation.tools.q.a((java.lang.String) r10)
            r9.checkKeySize(r12)
            int r1 = r12 + 4
            int r2 = r1 + r4
            r9.updateSize = r2
            r9.preparePutBytes()
            com.mbridge.msdk.foundation.tools.q r2 = r9.fastBuffer
            r2.a((byte) r0)
            r9.putKey(r10, r12)
            r9.putStringValue(r11, r4)
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r12 = r9.data
            com.mbridge.msdk.foundation.tools.g$i r0 = new com.mbridge.msdk.foundation.tools.g$i
            r2 = r1
            int r1 = r9.updateStart
            int r2 = r2 + r1
            r5 = 0
            r3 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            r12.put(r10, r0)
            r9.updateChange()
            goto L_0x00da
        L_0x0037:
            r3 = r11
            int r10 = r12.f13657a
            int r11 = r12.f13664c
            int r11 = r10 - r11
            int r1 = r12.f13666e
            r2 = 0
            r5 = 0
            if (r1 != r4) goto L_0x006f
            long r6 = r9.checksum
            com.mbridge.msdk.foundation.tools.q r11 = r9.fastBuffer
            long r10 = r11.a((int) r10, (int) r1)
            long r10 = r10 ^ r6
            r9.checksum = r10
            int r10 = r3.length()
            if (r4 != r10) goto L_0x005f
            com.mbridge.msdk.foundation.tools.q r10 = r9.fastBuffer
            byte[] r10 = r10.f13680a
            int r11 = r12.f13657a
            r3.getBytes(r2, r4, r10, r11)
            goto L_0x0068
        L_0x005f:
            com.mbridge.msdk.foundation.tools.q r10 = r9.fastBuffer
            int r11 = r12.f13657a
            r10.f13681b = r11
            r10.b((java.lang.String) r3)
        L_0x0068:
            int r10 = r12.f13657a
            r9.updateStart = r10
            r9.updateSize = r4
            goto L_0x00b3
        L_0x006f:
            int r10 = r11 + r4
            r9.updateSize = r10
            r9.preparePutBytes()
            com.mbridge.msdk.foundation.tools.q r10 = r9.fastBuffer
            r10.a((byte) r0)
            int r10 = r11 + -3
            com.mbridge.msdk.foundation.tools.q r1 = r9.fastBuffer
            byte[] r6 = r1.f13680a
            int r7 = r12.f13664c
            r8 = 1
            int r7 = r7 + r8
            int r1 = r1.f13681b
            java.lang.System.arraycopy(r6, r7, r6, r1, r10)
            com.mbridge.msdk.foundation.tools.q r1 = r9.fastBuffer
            int r6 = r1.f13681b
            int r6 = r6 + r10
            r1.f13681b = r6
            r9.putStringValue(r3, r4)
            int r10 = r12.f13664c
            int r1 = r12.f13657a
            int r6 = r12.f13666e
            int r1 = r1 + r6
            r9.remove(r0, r10, r1)
            boolean r10 = r12.f13663b
            if (r10 == 0) goto L_0x00a7
            java.lang.Object r10 = r12.f13665d
            r5 = r10
            java.lang.String r5 = (java.lang.String) r5
        L_0x00a7:
            r12.f13663b = r2
            int r10 = r9.updateStart
            r12.f13664c = r10
            int r10 = r10 + r11
            r12.f13657a = r10
            r12.f13666e = r4
            r2 = 1
        L_0x00b3:
            r12.f13665d = r3
            r9.updateChange()
            if (r2 == 0) goto L_0x00bd
            r9.checkGC()
        L_0x00bd:
            if (r5 == 0) goto L_0x00da
            java.io.File r10 = new java.io.File
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r9.path
            r11.append(r12)
            java.lang.String r12 = r9.name
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            r10.<init>(r11, r5)
            com.mbridge.msdk.foundation.tools.ar.a((java.io.File) r10)
        L_0x00da:
            r9.checkIfCommit()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.fastPutString(java.lang.String, java.lang.String, com.mbridge.msdk.foundation.tools.g$i):void");
    }

    private byte[] getArrayFromFile(g.a aVar) {
        try {
            byte[] b5 = ar.b(new File(this.path + this.name, (String) aVar.f13665d));
            if (b5 != null) {
                return b5;
            }
            return EMPTY_ARRAY;
        } catch (Exception e5) {
            error(e5);
            return EMPTY_ARRAY;
        }
    }

    private int getNewCapacity(int i4, int i5) {
        if (i5 <= DATA_SIZE_LIMIT) {
            int i6 = PAGE_SIZE;
            if (i5 <= i6) {
                return i6;
            }
            while (i4 < i5) {
                int i7 = DOUBLE_LIMIT;
                if (i4 <= i7) {
                    i4 <<= 1;
                } else {
                    i4 += i7;
                }
            }
            return i4;
        }
        throw new IllegalStateException("data size out of limit");
    }

    private Object getObjectFromFile(g.h hVar) {
        try {
            byte[] b5 = ar.b(new File(this.path + this.name, (String) hVar.f13665d));
            if (b5 != null) {
                byte b6 = b5[0] & 255;
                String str = new String(b5, 1, b6, StandardCharsets.UTF_8);
                a aVar = this.encoderMap.get(str);
                if (aVar != null) {
                    int i4 = b6 + 1;
                    return aVar.a(b5, i4, b5.length - i4);
                }
                warning(new Exception("No encoder for tag:" + str));
                return null;
            }
            warning(new Exception("Read object data failed"));
            return null;
        } catch (Exception e5) {
            error(e5);
            return null;
        }
    }

    private String getStringFromFile(g.i iVar) {
        try {
            byte[] b5 = ar.b(new File(this.path + this.name, (String) iVar.f13665d));
            if (b5 == null || b5.length == 0) {
                return "";
            }
            return new String(b5, StandardCharsets.UTF_8);
        } catch (Exception e5) {
            error(e5);
        }
        return "";
    }

    private void info(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, str);
        }
    }

    private boolean isABFileEqual() {
        q qVar = new q(this.dataEnd);
        this.bBuffer.rewind();
        this.bBuffer.get(qVar.f13680a, 0, this.dataEnd);
        byte[] bArr = this.fastBuffer.f13680a;
        byte[] bArr2 = qVar.f13680a;
        for (int i4 = 0; i4 < this.dataEnd; i4++) {
            if (bArr[i4] != bArr2[i4]) {
                return false;
            }
        }
        return true;
    }

    private synchronized void loadData() {
        try {
            long nanoTime = System.nanoTime();
            if (!loadFromCFile() && this.writingMode == 0) {
                loadFromABFile();
            }
            if (this.fastBuffer == null) {
                this.fastBuffer = new q(PAGE_SIZE);
            }
            if (this.logger != null) {
                info("loading finish, data len:" + this.dataEnd + ", get keys:" + this.data.size() + ", use time:" + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private void loadFromABFile() {
        long j4;
        long j5;
        long j6;
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (ar.c(file)) {
                if (ar.c(file2)) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                    long length = randomAccessFile.length();
                    long length2 = randomAccessFile2.length();
                    this.aChannel = randomAccessFile.getChannel();
                    this.bChannel = randomAccessFile2.getChannel();
                    try {
                        FileChannel fileChannel = this.aChannel;
                        FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                        int i4 = (length > 0 ? 1 : (length == 0 ? 0 : -1));
                        if (i4 > 0) {
                            j4 = length;
                        } else {
                            j4 = (long) PAGE_SIZE;
                        }
                        MappedByteBuffer map = fileChannel.map(mapMode, 0, j4);
                        this.aBuffer = map;
                        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                        map.order(byteOrder);
                        ByteOrder byteOrder2 = byteOrder;
                        FileChannel.MapMode mapMode2 = mapMode;
                        FileChannel fileChannel2 = this.bChannel;
                        int i5 = (length2 > 0 ? 1 : (length2 == 0 ? 0 : -1));
                        if (i5 > 0) {
                            j5 = length2;
                        } else {
                            j5 = (long) PAGE_SIZE;
                        }
                        MappedByteBuffer map2 = fileChannel2.map(mapMode2, 0, j5);
                        this.bBuffer = map2;
                        map2.order(byteOrder2);
                        this.fastBuffer = new q(this.aBuffer.capacity());
                        if (i4 == 0 && i5 == 0) {
                            this.dataEnd = 12;
                            return;
                        }
                        int i6 = this.aBuffer.getInt();
                        long j7 = this.aBuffer.getLong();
                        int i7 = this.bBuffer.getInt();
                        long j8 = this.bBuffer.getLong();
                        if (i6 < 0) {
                            j6 = 12;
                        } else if (((long) i6) <= length - 12) {
                            this.dataEnd = i6 + 12;
                            this.aBuffer.rewind();
                            j6 = 12;
                            this.aBuffer.get(this.fastBuffer.f13680a, 0, this.dataEnd);
                            if (j7 == this.fastBuffer.a(12, i6) && parseData() == 0) {
                                this.checksum = j7;
                                if (length != length2 || !isABFileEqual()) {
                                    warning(new Exception("B file error"));
                                    copyBuffer(this.aBuffer, this.bBuffer, this.dataEnd);
                                    return;
                                }
                                return;
                            }
                        } else {
                            j6 = 12;
                        }
                        if (i7 >= 0 && ((long) i7) <= length2 - j6) {
                            this.data.clear();
                            clearInvalid();
                            this.dataEnd = i7 + 12;
                            if (this.fastBuffer.f13680a.length != this.bBuffer.capacity()) {
                                this.fastBuffer = new q(this.bBuffer.capacity());
                            }
                            this.bBuffer.rewind();
                            this.bBuffer.get(this.fastBuffer.f13680a, 0, this.dataEnd);
                            if (j8 == this.fastBuffer.a(12, i7) && parseData() == 0) {
                                warning(new Exception("A file error"));
                                copyBuffer(this.bBuffer, this.aBuffer, this.dataEnd);
                                this.checksum = j8;
                                return;
                            }
                        }
                        error(BOTH_FILES_ERROR);
                        resetData();
                        return;
                    } catch (IOException e5) {
                        error((Exception) e5);
                        toBlockingMode();
                        tryBlockingIO(file, file2);
                        return;
                    }
                }
            }
            error(new Exception(OPEN_FILE_FAILED));
            toBlockingMode();
        } catch (Exception e6) {
            error(e6);
            clearData();
            toBlockingMode();
        }
    }

    private boolean loadFromCFile() {
        String str = this.path;
        File file = new File(str, this.name + C_SUFFIX);
        String str2 = this.path;
        File file2 = new File(str2, this.name + TEMP_SUFFIX);
        boolean z4 = false;
        try {
            if (!file.exists()) {
                if (file2.exists()) {
                    file = file2;
                } else {
                    file = null;
                }
            }
            if (file != null) {
                if (!loadWithBlockingIO(file)) {
                    clearData();
                    deleteCFiles();
                    return false;
                } else if (this.writingMode == 0) {
                    if (writeToABFile(this.fastBuffer)) {
                        info("recover from c file");
                        try {
                            deleteCFiles();
                            return true;
                        } catch (Exception e5) {
                            e = e5;
                            z4 = true;
                            error(e);
                            return z4;
                        }
                    } else {
                        this.writingMode = 1;
                        return false;
                    }
                }
            } else if (this.writingMode != 0) {
                String str3 = this.path;
                File file3 = new File(str3, this.name + A_SUFFIX);
                String str4 = this.path;
                File file4 = new File(str4, this.name + B_SUFFIX);
                if (file3.exists() && file4.exists()) {
                    tryBlockingIO(file3, file4);
                }
            }
            return false;
        } catch (Exception e6) {
            e = e6;
            error(e);
            return z4;
        }
    }

    private boolean loadWithBlockingIO(File file) throws IOException {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i4 = (int) length;
            int newCapacity = getNewCapacity(PAGE_SIZE, i4);
            q qVar = this.fastBuffer;
            if (qVar == null || qVar.f13680a.length != newCapacity) {
                qVar = new q(new byte[newCapacity]);
                this.fastBuffer = qVar;
            } else {
                qVar.f13681b = 0;
            }
            ar.a(file, qVar.f13680a, i4);
            int c5 = qVar.c();
            long b5 = qVar.b();
            this.dataEnd = c5 + 12;
            if (c5 >= 0 && c5 <= i4 - 12 && b5 == qVar.a(12, c5) && parseData() == 0) {
                this.checksum = b5;
                return true;
            }
        }
        return false;
    }

    private void mergeInvalids() {
        int size = this.invalids.size() - 1;
        c cVar = this.invalids.get(size);
        while (size > 0) {
            int i4 = size - 1;
            c cVar2 = this.invalids.get(i4);
            if (cVar.f13492b == cVar2.f13491a) {
                cVar2.f13491a = cVar.f13491a;
                this.invalids.remove(size);
            }
            cVar = cVar2;
            size = i4;
        }
    }

    private int parseData() {
        Object obj;
        int i4;
        q qVar = this.fastBuffer;
        qVar.f13681b = 12;
        while (true) {
            try {
                int i5 = qVar.f13681b;
                int i6 = this.dataEnd;
                boolean z4 = false;
                if (i5 < i6) {
                    byte a5 = qVar.a();
                    byte b5 = (byte) (a5 & 63);
                    boolean z5 = true;
                    if (b5 >= 1 && b5 <= 8) {
                        byte a6 = qVar.a() & 255;
                        if (a5 < 0) {
                            qVar.f13681b += a6;
                            if (b5 <= 5) {
                                i4 = TYPE_SIZE[b5];
                            } else {
                                i4 = qVar.d() & 65535;
                            }
                            q qVar2 = this.fastBuffer;
                            int i7 = qVar2.f13681b + i4;
                            qVar2.f13681b = i7;
                            countInvalid(i5, i7);
                        } else {
                            String a7 = qVar.a((int) a6);
                            int i8 = qVar.f13681b;
                            if (b5 > 5) {
                                short d5 = 65535 & qVar.d();
                                if ((a5 & 64) == 0) {
                                    z5 = false;
                                }
                                checkValueSize(d5, z5);
                                if (b5 == 6) {
                                    int i9 = i8;
                                    boolean z6 = z5;
                                    short s4 = d5;
                                    this.data.put(a7, new g.i(i5, i9 + 2, qVar.a((int) s4), s4, z6));
                                } else if (b5 == 7) {
                                    int i10 = i8;
                                    boolean z7 = z5;
                                    int i11 = d5;
                                    if (z7) {
                                        obj = qVar.a(i11);
                                    } else {
                                        obj = new byte[i11];
                                        System.arraycopy(qVar.f13680a, qVar.f13681b, obj, 0, i11);
                                        qVar.f13681b += i11;
                                    }
                                    this.data.put(a7, new g.a(i5, i10 + 2, obj, i11, z7));
                                } else if (z5) {
                                    this.data.put(a7, new g.h(i5, i8 + 2, qVar.a((int) d5), d5, true));
                                } else {
                                    short s5 = d5;
                                    byte a8 = qVar.a() & 255;
                                    String a9 = qVar.a((int) a8);
                                    a aVar = this.encoderMap.get(a9);
                                    int i12 = s5 - (a8 + 1);
                                    if (i12 >= 0) {
                                        if (aVar != null) {
                                            try {
                                                Object a10 = aVar.a(qVar.f13680a, qVar.f13681b, i12);
                                                if (a10 != null) {
                                                    this.data.put(a7, new g.h(i5, i8 + 2, a10, s5, false));
                                                }
                                            } catch (Exception e5) {
                                                error(e5);
                                            }
                                        } else {
                                            error("object with tag: " + a9 + " without encoder");
                                        }
                                        qVar.f13681b += i12;
                                    } else {
                                        throw new Exception(PARSE_DATA_FAILED);
                                    }
                                }
                            } else if (b5 == 1) {
                                Map<String, g.b> map = this.data;
                                if (qVar.a() == 1) {
                                    z4 = true;
                                }
                                map.put(a7, new g.c(i8, z4));
                            } else if (b5 == 2) {
                                this.data.put(a7, new g.f(i8, qVar.c()));
                            } else if (b5 == 3) {
                                this.data.put(a7, new g.e(i8, Float.intBitsToFloat(qVar.c())));
                            } else if (b5 != 4) {
                                this.data.put(a7, new g.d(i8, Double.longBitsToDouble(qVar.b())));
                            } else {
                                this.data.put(a7, new g.C0186g(i8, qVar.b()));
                            }
                        }
                    }
                } else if (i5 == i6) {
                    return 0;
                } else {
                    warning(new Exception(PARSE_DATA_FAILED));
                    return -1;
                }
            } catch (Exception e6) {
                warning(e6);
                return -1;
            }
        }
        throw new Exception(PARSE_DATA_FAILED);
    }

    private void preparePutBytes() {
        ensureSize(this.updateSize);
        int i4 = this.dataEnd;
        this.updateStart = i4;
        this.dataEnd = this.updateSize + i4;
        this.fastBuffer.f13681b = i4;
        this.sizeChanged = true;
    }

    private void putKey(String str, int i4) {
        this.fastBuffer.a((byte) i4);
        if (i4 == str.length()) {
            q qVar = this.fastBuffer;
            str.getBytes(0, i4, qVar.f13680a, qVar.f13681b);
            this.fastBuffer.f13681b += i4;
            return;
        }
        this.fastBuffer.b(str);
    }

    private void putStringValue(String str, int i4) {
        this.fastBuffer.a((short) i4);
        if (i4 == str.length()) {
            q qVar = this.fastBuffer;
            str.getBytes(0, i4, qVar.f13680a, qVar.f13681b);
            return;
        }
        this.fastBuffer.b(str);
    }

    private void resetBuffer(MappedByteBuffer mappedByteBuffer) throws IOException {
        FileChannel fileChannel;
        int capacity = mappedByteBuffer.capacity();
        int i4 = PAGE_SIZE;
        if (capacity != i4) {
            if (mappedByteBuffer == this.aBuffer) {
                fileChannel = this.aChannel;
            } else {
                fileChannel = this.bChannel;
            }
            FileChannel fileChannel2 = fileChannel;
            fileChannel2.truncate((long) i4);
            MappedByteBuffer map = fileChannel2.map(FileChannel.MapMode.READ_WRITE, 0, (long) i4);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aBuffer) {
                this.aBuffer = map;
            } else {
                this.bBuffer = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0);
    }

    private void resetData() {
        if (this.writingMode == 0) {
            try {
                resetBuffer(this.aBuffer);
                resetBuffer(this.bBuffer);
            } catch (IOException unused) {
                toBlockingMode();
            }
        }
        clearData();
        ar.a(new File(this.path + this.name));
    }

    private int saveArray(String str, byte[] bArr, byte b5) {
        this.tempExternalName = null;
        if (bArr.length < 2048) {
            return wrapArray(str, bArr, b5);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String b6 = ar.b();
        if (ar.a(new File(this.path + this.name, b6), bArr)) {
            this.tempExternalName = b6;
            byte[] bArr2 = new byte[32];
            b6.getBytes(0, 32, bArr2, 0);
            return wrapArray(str, bArr2, (byte) (b5 | 64));
        }
        error("save large value failed");
        return 0;
    }

    private long shiftCheckSum(long j4, int i4) {
        int i5 = (i4 & 7) << 3;
        return (j4 >>> (64 - i5)) | (j4 << i5);
    }

    private void syncABBuffer(MappedByteBuffer mappedByteBuffer) {
        if (this.sizeChanged && mappedByteBuffer != this.aBuffer) {
            mappedByteBuffer.putInt(0, this.dataEnd - 12);
        }
        mappedByteBuffer.putLong(4, this.checksum);
        int i4 = this.removeStart;
        if (i4 != 0) {
            mappedByteBuffer.put(i4, this.fastBuffer.f13680a[i4]);
        }
        if (this.updateSize != 0) {
            mappedByteBuffer.position(this.updateStart);
            mappedByteBuffer.put(this.fastBuffer.f13680a, this.updateStart, this.updateSize);
        }
    }

    private void toBlockingMode() {
        this.writingMode = 1;
        ar.a((Closeable) this.aChannel);
        ar.a((Closeable) this.bChannel);
        this.aChannel = null;
        this.bChannel = null;
        this.aBuffer = null;
        this.bBuffer = null;
    }

    private void truncate(int i4) {
        int i5 = PAGE_SIZE;
        int newCapacity = getNewCapacity(i5, i4 + i5);
        byte[] bArr = this.fastBuffer.f13680a;
        if (newCapacity < bArr.length) {
            byte[] bArr2 = new byte[newCapacity];
            System.arraycopy(bArr, 0, bArr2, 0, this.dataEnd);
            this.fastBuffer.f13680a = bArr2;
            if (this.writingMode == 0) {
                try {
                    long j4 = (long) newCapacity;
                    this.aChannel.truncate(j4);
                    FileChannel fileChannel = this.aChannel;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0, j4);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    this.bChannel.truncate(j4);
                    MappedByteBuffer map2 = this.bChannel.map(mapMode, 0, j4);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                } catch (IOException e5) {
                    error(new Exception(MAP_FAILED, e5));
                    toBlockingMode();
                }
            }
            info(TRUNCATE_FINISH);
        }
    }

    private void tryBlockingIO(File file, File file2) {
        try {
            if (loadWithBlockingIO(file)) {
                return;
            }
        } catch (IOException e5) {
            warning(e5);
        }
        clearData();
        try {
            if (loadWithBlockingIO(file2)) {
                return;
            }
        } catch (IOException e6) {
            warning(e6);
        }
        clearData();
    }

    private void updateBoolean(byte b5, int i4) {
        long shiftCheckSum = this.checksum ^ shiftCheckSum(1, i4);
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.put(i4, b5);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.put(i4, b5);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.f13680a[i4] = b5;
    }

    private void updateBytes(int i4, byte[] bArr) {
        int length = bArr.length;
        this.checksum ^= this.fastBuffer.a(i4, length);
        q qVar = this.fastBuffer;
        qVar.f13681b = i4;
        qVar.a(bArr);
        long a5 = this.checksum ^ this.fastBuffer.a(i4, length);
        this.checksum = a5;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i4);
            this.aBuffer.put(bArr);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i4);
            this.bBuffer.put(bArr);
            return;
        }
        this.fastBuffer.a(4, a5);
    }

    private void updateChange() {
        this.checksum ^= this.fastBuffer.a(this.updateStart, this.updateSize);
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            syncABBuffer(this.aBuffer);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            syncABBuffer(this.bBuffer);
        } else {
            if (this.sizeChanged) {
                this.fastBuffer.b(0, this.dataEnd - 12);
            }
            this.fastBuffer.a(4, this.checksum);
        }
        this.sizeChanged = false;
        this.removeStart = 0;
        this.updateSize = 0;
    }

    private void updateInt32(int i4, long j4, int i5) {
        long shiftCheckSum = shiftCheckSum(j4, i5) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putInt(i5, i4);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putInt(i5, i4);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.b(i5, i4);
    }

    private void updateInt64(long j4, long j5, int i4) {
        long shiftCheckSum = shiftCheckSum(j5, i4) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putLong(i4, j4);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putLong(i4, j4);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.a(i4, j4);
    }

    private void updateObject(String str, Object obj, byte[] bArr, g.j jVar) {
        String str2;
        boolean z4;
        int saveArray = saveArray(str, bArr, jVar.a());
        if (saveArray != 0) {
            if (jVar.f13663b) {
                str2 = (String) jVar.f13665d;
            } else {
                str2 = null;
            }
            remove(jVar.a(), jVar.f13664c, jVar.f13657a + jVar.f13666e);
            String str3 = this.tempExternalName;
            if (str3 != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            jVar.f13664c = this.updateStart;
            jVar.f13657a = saveArray;
            jVar.f13663b = z4;
            if (z4) {
                jVar.f13665d = str3;
                jVar.f13666e = 32;
                this.tempExternalName = null;
            } else {
                jVar.f13665d = obj;
                jVar.f13666e = bArr.length;
            }
            updateChange();
            checkGC();
            if (str2 != null) {
                ar.a(new File(this.path + this.name, str2));
            }
        }
    }

    private void updateOffset(int i4, int[] iArr) {
        for (g.b next : this.data.values()) {
            int i5 = next.f13657a;
            if (i5 > i4) {
                int length = (iArr.length >> 1) - 1;
                int i6 = 0;
                while (true) {
                    if (i6 > length) {
                        break;
                    }
                    int i7 = (i6 + length) >>> 1;
                    int i8 = iArr[i7 << 1];
                    if (i8 >= i5) {
                        if (i8 <= i5) {
                            length = i7;
                            break;
                        }
                        length = i7 - 1;
                    } else {
                        i6 = i7 + 1;
                    }
                }
                int i9 = iArr[(length << 1) + 1];
                next.f13657a -= i9;
                if (next.a() >= 6) {
                    ((g.j) next).f13664c -= i9;
                }
            }
        }
    }

    private void warning(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.b(this.name, exc);
        }
    }

    private int wrapArray(String str, byte[] bArr, byte b5) {
        wrapHeader(str, b5, bArr.length + 2);
        this.fastBuffer.a((short) bArr.length);
        q qVar = this.fastBuffer;
        int i4 = qVar.f13681b;
        qVar.a(bArr);
        return i4;
    }

    private void wrapHeader(String str, byte b5) {
        wrapHeader(str, b5, TYPE_SIZE[b5]);
    }

    private boolean writeToABFile(q qVar) {
        int length = qVar.f13680a.length;
        String str = this.path;
        File file = new File(str, this.name + A_SUFFIX);
        String str2 = this.path;
        File file2 = new File(str2, this.name + B_SUFFIX);
        try {
            if (!ar.c(file) || !ar.c(file2)) {
                throw new Exception(OPEN_FILE_FAILED);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j4 = (long) length;
            randomAccessFile.setLength(j4);
            randomAccessFile2.setLength(j4);
            this.aChannel = randomAccessFile.getChannel();
            this.bChannel = randomAccessFile2.getChannel();
            FileChannel fileChannel = this.aChannel;
            FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
            MappedByteBuffer map = fileChannel.map(mapMode, 0, j4);
            this.aBuffer = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.bChannel.map(mapMode, 0, j4);
            this.bBuffer = map2;
            map2.order(byteOrder);
            this.aBuffer.put(qVar.f13680a, 0, this.dataEnd);
            this.bBuffer.put(qVar.f13680a, 0, this.dataEnd);
            return true;
        } catch (Exception e5) {
            error(e5);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public synchronized boolean writeToCFile() {
        try {
            String str = this.path;
            File file = new File(str, this.name + TEMP_SUFFIX);
            if (ar.c(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength((long) this.dataEnd);
                randomAccessFile.write(this.fastBuffer.f13680a, 0, this.dataEnd);
                randomAccessFile.close();
                String str2 = this.path;
                File file2 = new File(str2, this.name + C_SUFFIX);
                if (file2.exists()) {
                    if (file2.delete()) {
                    }
                }
                if (file.renameTo(file2)) {
                    return true;
                }
                warning(new Exception("rename failed"));
            }
        } catch (Exception e5) {
            error(e5);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return false;
    }

    public synchronized void clear() {
        resetData();
        if (this.writingMode != 0) {
            deleteCFiles();
        }
    }

    public synchronized boolean commit() {
        this.autoCommit = true;
        return commitToCFile();
    }

    public synchronized boolean contains(String str) {
        return this.data.containsKey(str);
    }

    public synchronized void disableAutoCommit() {
        this.autoCommit = false;
    }

    public synchronized void force() {
        if (this.writingMode == 0) {
            this.aBuffer.force();
            this.bBuffer.force();
        }
    }

    /* access modifiers changed from: package-private */
    public void gc(int i4) {
        boolean z4;
        int i5;
        Collections.sort(this.invalids);
        mergeInvalids();
        c cVar = this.invalids.get(0);
        int i6 = cVar.f13492b;
        int i7 = this.dataEnd;
        int i8 = i7 - this.invalidBytes;
        int i9 = i8 - 12;
        int i10 = i8 - i6;
        int i11 = i7 - i6;
        if (i9 < i11 + i10) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            this.checksum ^= this.fastBuffer.a(i6, i11);
        }
        int size = this.invalids.size();
        int i12 = size - 1;
        int i13 = this.dataEnd - this.invalids.get(i12).f13491a;
        if (i13 > 0) {
            i5 = size;
        } else {
            i5 = i12;
        }
        int[] iArr = new int[(i5 << 1)];
        int i14 = cVar.f13492b;
        int i15 = cVar.f13491a;
        for (int i16 = 1; i16 < size; i16++) {
            c cVar2 = this.invalids.get(i16);
            int i17 = cVar2.f13492b - i15;
            byte[] bArr = this.fastBuffer.f13680a;
            System.arraycopy(bArr, i15, bArr, i14, i17);
            int i18 = (i16 - 1) << 1;
            iArr[i18] = i15;
            iArr[i18 + 1] = i15 - i14;
            i14 += i17;
            i15 = cVar2.f13491a;
        }
        if (i13 > 0) {
            byte[] bArr2 = this.fastBuffer.f13680a;
            System.arraycopy(bArr2, i15, bArr2, i14, i13);
            int i19 = i12 << 1;
            iArr[i19] = i15;
            iArr[i19 + 1] = i15 - i14;
        }
        clearInvalid();
        if (z4) {
            this.checksum = this.fastBuffer.a(12, i9);
        } else {
            this.checksum ^= this.fastBuffer.a(i6, i10);
        }
        this.dataEnd = i8;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i6);
            this.aBuffer.put(this.fastBuffer.f13680a, i6, i10);
            this.aBuffer.putInt(0, i9);
            this.bBuffer.putInt(0, i9);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i6);
            this.bBuffer.put(this.fastBuffer.f13680a, i6, i10);
        } else {
            this.fastBuffer.b(0, i9);
            this.fastBuffer.a(4, this.checksum);
        }
        updateOffset(i6, iArr);
        int i20 = i8 + i4;
        if (this.fastBuffer.f13680a.length - i20 > TRUNCATE_THRESHOLD) {
            truncate(i20);
        }
        info(GC_FINISH);
    }

    public synchronized Map<String, Object> getAll() {
        Object obj;
        int size = this.data.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry next : this.data.entrySet()) {
            String str = (String) next.getKey();
            g.b bVar = (g.b) next.getValue();
            switch (bVar.a()) {
                case 1:
                    obj = Boolean.valueOf(((g.c) bVar).f13658b);
                    break;
                case 2:
                    obj = Integer.valueOf(((g.f) bVar).f13661b);
                    break;
                case 3:
                    obj = Float.valueOf(((g.e) bVar).f13660b);
                    break;
                case 4:
                    obj = Long.valueOf(((g.C0186g) bVar).f13662b);
                    break;
                case 5:
                    obj = Double.valueOf(((g.d) bVar).f13659b);
                    break;
                case 6:
                    g.i iVar = (g.i) bVar;
                    if (!iVar.f13663b) {
                        obj = iVar.f13665d;
                        break;
                    } else {
                        obj = getStringFromFile(iVar);
                        break;
                    }
                case 7:
                    g.a aVar = (g.a) bVar;
                    if (!aVar.f13663b) {
                        obj = aVar.f13665d;
                        break;
                    } else {
                        obj = getArrayFromFile(aVar);
                        break;
                    }
                case 8:
                    g.h hVar = (g.h) bVar;
                    if (!hVar.f13663b) {
                        obj = ((g.h) bVar).f13665d;
                        break;
                    } else {
                        obj = getObjectFromFile(hVar);
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            hashMap.put(str, obj);
        }
        return hashMap;
    }

    public byte[] getArray(String str) {
        return getArray(str, EMPTY_ARRAY);
    }

    public synchronized boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public synchronized long getLong(String str) {
        long j4;
        g.C0186g gVar = (g.C0186g) this.data.get(str);
        if (gVar == null) {
            j4 = 0;
        } else {
            j4 = gVar.f13662b;
        }
        return j4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> T getObject(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r0 = r1.data     // Catch:{ all -> 0x0014 }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.tools.g$h r2 = (com.mbridge.msdk.foundation.tools.g.h) r2     // Catch:{ all -> 0x0014 }
            if (r2 == 0) goto L_0x001a
            boolean r0 = r2.f13663b     // Catch:{ all -> 0x0014 }
            if (r0 == 0) goto L_0x0016
            java.lang.Object r2 = r1.getObjectFromFile(r2)     // Catch:{ all -> 0x0014 }
            goto L_0x0018
        L_0x0014:
            r2 = move-exception
            goto L_0x001d
        L_0x0016:
            java.lang.Object r2 = r2.f13665d     // Catch:{ all -> 0x0014 }
        L_0x0018:
            monitor-exit(r1)
            return r2
        L_0x001a:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x001d:
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.getObject(java.lang.String):java.lang.Object");
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public synchronized Set<String> getStringSet(String str) {
        return (Set) getObject(str);
    }

    public void putAll(Map<String, Object> map) {
        putAll(map, (Map<Class, a>) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void putArray(java.lang.String r8, byte[] r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.checkKey(r8)     // Catch:{ all -> 0x0025 }
            if (r9 != 0) goto L_0x000f
            r7.remove(r8)     // Catch:{ all -> 0x000b }
            r1 = r7
            goto L_0x0020
        L_0x000b:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L_0x0028
        L_0x000f:
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r0 = r7.data     // Catch:{ all -> 0x0025 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0025 }
            r5 = r0
            com.mbridge.msdk.foundation.tools.g$a r5 = (com.mbridge.msdk.foundation.tools.g.a) r5     // Catch:{ all -> 0x0025 }
            r6 = 7
            r4 = r9
            r1 = r7
            r2 = r8
            r3 = r9
            r1.addOrUpdate(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0022 }
        L_0x0020:
            monitor-exit(r7)
            return
        L_0x0022:
            r0 = move-exception
        L_0x0023:
            r8 = r0
            goto L_0x0028
        L_0x0025:
            r0 = move-exception
            r1 = r7
            goto L_0x0023
        L_0x0028:
            monitor-exit(r7)     // Catch:{ all -> 0x0022 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.putArray(java.lang.String, byte[]):void");
    }

    public synchronized void putBoolean(String str, boolean z4) {
        try {
            checkKey(str);
            g.c cVar = (g.c) this.data.get(str);
            if (cVar == null) {
                wrapHeader(str, (byte) 1);
                q qVar = this.fastBuffer;
                int i4 = qVar.f13681b;
                qVar.a(z4 ? (byte) 1 : 0);
                updateChange();
                this.data.put(str, new g.c(i4, z4));
                checkIfCommit();
            } else if (cVar.f13658b != z4) {
                cVar.f13658b = z4;
                updateBoolean(z4 ? (byte) 1 : 0, cVar.f13657a);
                checkIfCommit();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void putDouble(java.lang.String r8, double r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.checkKey(r8)     // Catch:{ all -> 0x0053 }
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r0 = r7.data     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0053 }
            com.mbridge.msdk.foundation.tools.g$d r0 = (com.mbridge.msdk.foundation.tools.g.d) r0     // Catch:{ all -> 0x0053 }
            if (r0 != 0) goto L_0x0033
            r0 = 5
            r7.wrapHeader(r8, r0)     // Catch:{ all -> 0x002f }
            com.mbridge.msdk.foundation.tools.q r0 = r7.fastBuffer     // Catch:{ all -> 0x002f }
            int r1 = r0.f13681b     // Catch:{ all -> 0x002f }
            long r2 = java.lang.Double.doubleToRawLongBits(r9)     // Catch:{ all -> 0x002f }
            r0.a((long) r2)     // Catch:{ all -> 0x002f }
            r7.updateChange()     // Catch:{ all -> 0x002f }
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r0 = r7.data     // Catch:{ all -> 0x002f }
            com.mbridge.msdk.foundation.tools.g$d r2 = new com.mbridge.msdk.foundation.tools.g$d     // Catch:{ all -> 0x002f }
            r2.<init>(r1, r9)     // Catch:{ all -> 0x002f }
            r0.put(r8, r2)     // Catch:{ all -> 0x002f }
            r7.checkIfCommit()     // Catch:{ all -> 0x002f }
        L_0x002d:
            r1 = r7
            goto L_0x0056
        L_0x002f:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L_0x0058
        L_0x0033:
            double r1 = r0.f13659b     // Catch:{ all -> 0x0053 }
            int r8 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r8 == 0) goto L_0x002d
            long r2 = java.lang.Double.doubleToRawLongBits(r9)     // Catch:{ all -> 0x0053 }
            double r4 = r0.f13659b     // Catch:{ all -> 0x0053 }
            long r4 = java.lang.Double.doubleToRawLongBits(r4)     // Catch:{ all -> 0x0053 }
            long r4 = r4 ^ r2
            r0.f13659b = r9     // Catch:{ all -> 0x0053 }
            int r6 = r0.f13657a     // Catch:{ all -> 0x0053 }
            r1 = r7
            r1.updateInt64(r2, r4, r6)     // Catch:{ all -> 0x0050 }
            r7.checkIfCommit()     // Catch:{ all -> 0x0050 }
            goto L_0x0056
        L_0x0050:
            r0 = move-exception
        L_0x0051:
            r8 = r0
            goto L_0x0058
        L_0x0053:
            r0 = move-exception
            r1 = r7
            goto L_0x0051
        L_0x0056:
            monitor-exit(r7)
            return
        L_0x0058:
            monitor-exit(r7)     // Catch:{ all -> 0x0050 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.putDouble(java.lang.String, double):void");
    }

    public synchronized void putFloat(String str, float f4) {
        try {
            checkKey(str);
            g.e eVar = (g.e) this.data.get(str);
            if (eVar == null) {
                wrapHeader(str, (byte) 3);
                q qVar = this.fastBuffer;
                int i4 = qVar.f13681b;
                qVar.b(Float.floatToRawIntBits(f4));
                updateChange();
                this.data.put(str, new g.e(i4, f4));
                checkIfCommit();
            } else if (eVar.f13660b != f4) {
                int floatToRawIntBits = Float.floatToRawIntBits(f4);
                eVar.f13660b = f4;
                updateInt32(floatToRawIntBits, ((long) (Float.floatToRawIntBits(eVar.f13660b) ^ floatToRawIntBits)) & 4294967295L, eVar.f13657a);
                checkIfCommit();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void putInt(String str, int i4) {
        try {
            checkKey(str);
            g.f fVar = (g.f) this.data.get(str);
            if (fVar == null) {
                wrapHeader(str, (byte) 2);
                q qVar = this.fastBuffer;
                int i5 = qVar.f13681b;
                qVar.b(i4);
                updateChange();
                this.data.put(str, new g.f(i5, i4));
                checkIfCommit();
            } else {
                int i6 = fVar.f13661b;
                if (i6 != i4) {
                    fVar.f13661b = i4;
                    updateInt32(i4, ((long) (i6 ^ i4)) & 4294967295L, fVar.f13657a);
                    checkIfCommit();
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void putLong(java.lang.String r10, long r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            r9.checkKey(r10)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r0 = r9.data     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ all -> 0x0047 }
            com.mbridge.msdk.foundation.tools.g$g r0 = (com.mbridge.msdk.foundation.tools.g.C0186g) r0     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x002f
            r0 = 4
            r9.wrapHeader(r10, r0)     // Catch:{ all -> 0x002b }
            com.mbridge.msdk.foundation.tools.q r0 = r9.fastBuffer     // Catch:{ all -> 0x002b }
            int r1 = r0.f13681b     // Catch:{ all -> 0x002b }
            r0.a((long) r11)     // Catch:{ all -> 0x002b }
            r9.updateChange()     // Catch:{ all -> 0x002b }
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r0 = r9.data     // Catch:{ all -> 0x002b }
            com.mbridge.msdk.foundation.tools.g$g r2 = new com.mbridge.msdk.foundation.tools.g$g     // Catch:{ all -> 0x002b }
            r2.<init>(r1, r11)     // Catch:{ all -> 0x002b }
            r0.put(r10, r2)     // Catch:{ all -> 0x002b }
            r9.checkIfCommit()     // Catch:{ all -> 0x002b }
        L_0x0029:
            r3 = r9
            goto L_0x004a
        L_0x002b:
            r0 = move-exception
            r10 = r0
            r3 = r9
            goto L_0x004c
        L_0x002f:
            long r1 = r0.f13662b     // Catch:{ all -> 0x0047 }
            int r10 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r10 == 0) goto L_0x0029
            long r6 = r11 ^ r1
            r0.f13662b = r11     // Catch:{ all -> 0x0047 }
            int r8 = r0.f13657a     // Catch:{ all -> 0x0047 }
            r3 = r9
            r4 = r11
            r3.updateInt64(r4, r6, r8)     // Catch:{ all -> 0x0044 }
            r9.checkIfCommit()     // Catch:{ all -> 0x0044 }
            goto L_0x004a
        L_0x0044:
            r0 = move-exception
        L_0x0045:
            r10 = r0
            goto L_0x004c
        L_0x0047:
            r0 = move-exception
            r3 = r9
            goto L_0x0045
        L_0x004a:
            monitor-exit(r9)
            return
        L_0x004c:
            monitor-exit(r9)     // Catch:{ all -> 0x0044 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.putLong(java.lang.String, long):void");
    }

    public synchronized <T> void putObject(String str, T t4, a<T> aVar) {
        Throwable th;
        byte[] bArr;
        try {
            checkKey(str);
            if (aVar != null) {
                String a5 = aVar.a();
                if (a5 == null || a5.isEmpty() || a5.length() > 50) {
                    throw new IllegalArgumentException("Invalid encoder tag:" + a5);
                } else if (!this.encoderMap.containsKey(a5)) {
                    throw new IllegalArgumentException("Encoder hasn't been registered");
                } else if (t4 == null) {
                    try {
                        remove(str);
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    bArr = aVar.a(t4);
                    if (bArr == null) {
                        remove(str);
                        return;
                    }
                    int a6 = q.a(a5);
                    q qVar = new q(a6 + 1 + bArr.length);
                    qVar.a((byte) a6);
                    qVar.b(a5);
                    qVar.a(bArr);
                    try {
                        addOrUpdate(str, t4, qVar.f13680a, (g.h) this.data.get(str), (byte) 8);
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
            } else {
                throw new IllegalArgumentException("Encoder is null");
            }
        } catch (Exception e5) {
            error(e5);
            bArr = null;
        } catch (Throwable th4) {
            th = th4;
            th = th;
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void putString(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.checkKey(r8)     // Catch:{ all -> 0x0043 }
            if (r9 != 0) goto L_0x000f
            r7.remove(r8)     // Catch:{ all -> 0x000b }
        L_0x0009:
            r1 = r7
            goto L_0x003e
        L_0x000b:
            r0 = move-exception
            r8 = r0
            r1 = r7
            goto L_0x0046
        L_0x000f:
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r0 = r7.data     // Catch:{ all -> 0x0043 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0043 }
            r5 = r0
            com.mbridge.msdk.foundation.tools.g$i r5 = (com.mbridge.msdk.foundation.tools.g.i) r5     // Catch:{ all -> 0x0043 }
            int r0 = r9.length()     // Catch:{ all -> 0x0043 }
            int r0 = r0 * 3
            r1 = 2048(0x800, float:2.87E-42)
            if (r0 >= r1) goto L_0x0026
            r7.fastPutString(r8, r9, r5)     // Catch:{ all -> 0x000b }
            goto L_0x0009
        L_0x0026:
            boolean r0 = r9.isEmpty()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0030
            byte[] r0 = EMPTY_ARRAY     // Catch:{ all -> 0x000b }
        L_0x002e:
            r4 = r0
            goto L_0x0037
        L_0x0030:
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0043 }
            byte[] r0 = r9.getBytes(r0)     // Catch:{ all -> 0x0043 }
            goto L_0x002e
        L_0x0037:
            r6 = 6
            r1 = r7
            r2 = r8
            r3 = r9
            r1.addOrUpdate(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0040 }
        L_0x003e:
            monitor-exit(r7)
            return
        L_0x0040:
            r0 = move-exception
        L_0x0041:
            r8 = r0
            goto L_0x0046
        L_0x0043:
            r0 = move-exception
            r1 = r7
            goto L_0x0041
        L_0x0046:
            monitor-exit(r7)     // Catch:{ all -> 0x0040 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.putString(java.lang.String, java.lang.String):void");
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            try {
                remove(str);
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        } else {
            putObject(str, set, ao.f13611a);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void remove(java.lang.String r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r0 = r6.data     // Catch:{ all -> 0x002b }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x002b }
            com.mbridge.msdk.foundation.tools.g$b r0 = (com.mbridge.msdk.foundation.tools.g.b) r0     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0094
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r1 = r6.data     // Catch:{ all -> 0x002b }
            r1.remove(r7)     // Catch:{ all -> 0x002b }
            byte r1 = r0.a()     // Catch:{ all -> 0x002b }
            r2 = 5
            r3 = 0
            if (r1 > r2) goto L_0x002d
            int r7 = com.mbridge.msdk.foundation.tools.q.a((java.lang.String) r7)     // Catch:{ all -> 0x002b }
            int r0 = r0.f13657a     // Catch:{ all -> 0x002b }
            int r7 = r7 + 2
            int r7 = r0 - r7
            int[] r2 = TYPE_SIZE     // Catch:{ all -> 0x002b }
            r2 = r2[r1]     // Catch:{ all -> 0x002b }
            int r0 = r0 + r2
            r6.remove(r1, r7, r0)     // Catch:{ all -> 0x002b }
            goto L_0x0042
        L_0x002b:
            r7 = move-exception
            goto L_0x0096
        L_0x002d:
            com.mbridge.msdk.foundation.tools.g$j r0 = (com.mbridge.msdk.foundation.tools.g.j) r0     // Catch:{ all -> 0x002b }
            int r7 = r0.f13664c     // Catch:{ all -> 0x002b }
            int r2 = r0.f13657a     // Catch:{ all -> 0x002b }
            int r4 = r0.f13666e     // Catch:{ all -> 0x002b }
            int r2 = r2 + r4
            r6.remove(r1, r7, r2)     // Catch:{ all -> 0x002b }
            boolean r7 = r0.f13663b     // Catch:{ all -> 0x002b }
            if (r7 == 0) goto L_0x0042
            java.lang.Object r7 = r0.f13665d     // Catch:{ all -> 0x002b }
            r3 = r7
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x002b }
        L_0x0042:
            r7 = r1 | -128(0xffffffffffffff80, float:NaN)
            byte r7 = (byte) r7     // Catch:{ all -> 0x002b }
            int r0 = r6.writingMode     // Catch:{ all -> 0x002b }
            r1 = 4
            if (r0 != 0) goto L_0x0067
            java.nio.MappedByteBuffer r0 = r6.aBuffer     // Catch:{ all -> 0x002b }
            long r4 = r6.checksum     // Catch:{ all -> 0x002b }
            r0.putLong(r1, r4)     // Catch:{ all -> 0x002b }
            java.nio.MappedByteBuffer r0 = r6.aBuffer     // Catch:{ all -> 0x002b }
            int r2 = r6.removeStart     // Catch:{ all -> 0x002b }
            r0.put(r2, r7)     // Catch:{ all -> 0x002b }
            java.nio.MappedByteBuffer r0 = r6.bBuffer     // Catch:{ all -> 0x002b }
            long r4 = r6.checksum     // Catch:{ all -> 0x002b }
            r0.putLong(r1, r4)     // Catch:{ all -> 0x002b }
            java.nio.MappedByteBuffer r0 = r6.bBuffer     // Catch:{ all -> 0x002b }
            int r1 = r6.removeStart     // Catch:{ all -> 0x002b }
            r0.put(r1, r7)     // Catch:{ all -> 0x002b }
            goto L_0x006e
        L_0x0067:
            com.mbridge.msdk.foundation.tools.q r7 = r6.fastBuffer     // Catch:{ all -> 0x002b }
            long r4 = r6.checksum     // Catch:{ all -> 0x002b }
            r7.a((int) r1, (long) r4)     // Catch:{ all -> 0x002b }
        L_0x006e:
            r7 = 0
            r6.removeStart = r7     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x008e
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x002b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x002b }
            r0.<init>()     // Catch:{ all -> 0x002b }
            java.lang.String r1 = r6.path     // Catch:{ all -> 0x002b }
            r0.append(r1)     // Catch:{ all -> 0x002b }
            java.lang.String r1 = r6.name     // Catch:{ all -> 0x002b }
            r0.append(r1)     // Catch:{ all -> 0x002b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002b }
            r7.<init>(r0, r3)     // Catch:{ all -> 0x002b }
            com.mbridge.msdk.foundation.tools.ar.a((java.io.File) r7)     // Catch:{ all -> 0x002b }
        L_0x008e:
            r6.checkGC()     // Catch:{ all -> 0x002b }
            r6.checkIfCommit()     // Catch:{ all -> 0x002b }
        L_0x0094:
            monitor-exit(r6)
            return
        L_0x0096:
            monitor-exit(r6)     // Catch:{ all -> 0x002b }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.remove(java.lang.String):void");
    }

    public synchronized String toString() {
        return "FastKV: path:" + this.path + " name:" + this.name;
    }

    private void wrapHeader(String str, byte b5, int i4) {
        int a5 = q.a(str);
        checkKeySize(a5);
        this.updateSize = a5 + 2 + i4;
        preparePutBytes();
        this.fastBuffer.a(b5);
        putKey(str, a5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return r2.f13663b ? getArrayFromFile(r2) : (byte[]) r2.f13665d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] getArray(java.lang.String r2, byte[] r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r0 = r1.data     // Catch:{ all -> 0x0014 }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.tools.g$a r2 = (com.mbridge.msdk.foundation.tools.g.a) r2     // Catch:{ all -> 0x0014 }
            if (r2 == 0) goto L_0x001c
            boolean r3 = r2.f13663b     // Catch:{ all -> 0x0014 }
            if (r3 == 0) goto L_0x0016
            byte[] r2 = r1.getArrayFromFile(r2)     // Catch:{ all -> 0x0014 }
            goto L_0x001a
        L_0x0014:
            r2 = move-exception
            goto L_0x001e
        L_0x0016:
            java.lang.Object r2 = r2.f13665d     // Catch:{ all -> 0x0014 }
            byte[] r2 = (byte[]) r2     // Catch:{ all -> 0x0014 }
        L_0x001a:
            monitor-exit(r1)
            return r2
        L_0x001c:
            monitor-exit(r1)
            return r3
        L_0x001e:
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.getArray(java.lang.String, byte[]):byte[]");
    }

    public synchronized boolean getBoolean(String str, boolean z4) {
        g.c cVar = (g.c) this.data.get(str);
        if (cVar != null) {
            z4 = cVar.f13658b;
        }
        return z4;
    }

    public synchronized double getDouble(String str, double d5) {
        g.d dVar = (g.d) this.data.get(str);
        if (dVar != null) {
            d5 = dVar.f13659b;
        }
        return d5;
    }

    public synchronized float getFloat(String str, float f4) {
        g.e eVar = (g.e) this.data.get(str);
        if (eVar != null) {
            f4 = eVar.f13660b;
        }
        return f4;
    }

    public synchronized int getInt(String str, int i4) {
        g.f fVar = (g.f) this.data.get(str);
        if (fVar != null) {
            i4 = fVar.f13661b;
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return r2.f13663b ? getStringFromFile(r2) : (java.lang.String) r2.f13665d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String getString(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.g$b> r0 = r1.data     // Catch:{ all -> 0x0014 }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0014 }
            com.mbridge.msdk.foundation.tools.g$i r2 = (com.mbridge.msdk.foundation.tools.g.i) r2     // Catch:{ all -> 0x0014 }
            if (r2 == 0) goto L_0x001c
            boolean r3 = r2.f13663b     // Catch:{ all -> 0x0014 }
            if (r3 == 0) goto L_0x0016
            java.lang.String r2 = r1.getStringFromFile(r2)     // Catch:{ all -> 0x0014 }
            goto L_0x001a
        L_0x0014:
            r2 = move-exception
            goto L_0x001e
        L_0x0016:
            java.lang.Object r2 = r2.f13665d     // Catch:{ all -> 0x0014 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0014 }
        L_0x001a:
            monitor-exit(r1)
            return r2
        L_0x001c:
            monitor-exit(r1)
            return r3
        L_0x001e:
            monitor-exit(r1)     // Catch:{ all -> 0x0014 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.getString(java.lang.String, java.lang.String):java.lang.String");
    }

    public synchronized void putAll(Map<String, Object> map, Map<Class, a> map2) {
        try {
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (str != null && !str.isEmpty()) {
                    if (value instanceof String) {
                        putString(str, (String) value);
                    } else if (value instanceof Boolean) {
                        putBoolean(str, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        putInt(str, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        putLong(str, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        putFloat(str, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        putDouble(str, ((Double) value).doubleValue());
                    } else if (value instanceof Set) {
                        Set set = (Set) value;
                        if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                            putStringSet(str, (Set) value);
                        }
                    } else if (value instanceof byte[]) {
                        putArray(str, (byte[]) value);
                    } else if (map2 != null) {
                        a aVar = map2.get(value.getClass());
                        if (aVar != null) {
                            putObject(str, value, aVar);
                        } else {
                            warning(new Exception("missing encoder for type:" + value.getClass()));
                        }
                    } else {
                        warning(new Exception("missing encoders"));
                    }
                }
            }
        } finally {
            while (true) {
            }
        }
    }

    private void error(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, new Exception(str));
        }
    }

    public synchronized long getLong(String str, long j4) {
        g.C0186g gVar = (g.C0186g) this.data.get(str);
        if (gVar != null) {
            j4 = gVar.f13662b;
        }
        return j4;
    }

    private void remove(byte b5, int i4, int i5) {
        countInvalid(i4, i5);
        byte b6 = (byte) (b5 | Byte.MIN_VALUE);
        byte[] bArr = this.fastBuffer.f13680a;
        this.checksum = ((((long) (bArr[i4] ^ b6)) & 255) << ((i4 & 7) << 3)) ^ this.checksum;
        bArr[i4] = b6;
        this.removeStart = i4;
    }
}
