package com.mbridge.msdk.thrid.okhttp.internal.http2;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Source;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class Hpack {
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX = nameToFirstIndex();
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE;

    static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        Reader(int i4, Source source2) {
            this(i4, i4, source2);
        }

        private void adjustDynamicTableByteCount() {
            int i4 = this.maxDynamicTableByteCount;
            int i5 = this.dynamicTableByteCount;
            if (i4 >= i5) {
                return;
            }
            if (i4 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i5 - i4);
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int i4) {
            return this.nextHeaderIndex + 1 + i4;
        }

        private int evictToRecoverBytes(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i5 = this.nextHeaderIndex;
                    if (length < i5 || i4 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i5 + 1, headerArr, i5 + 1 + i6, this.headerCount);
                        this.nextHeaderIndex += i6;
                    } else {
                        int i7 = this.dynamicTable[length].hpackSize;
                        i4 -= i7;
                        this.dynamicTableByteCount -= i7;
                        this.headerCount--;
                        i6++;
                    }
                }
                Header[] headerArr2 = this.dynamicTable;
                System.arraycopy(headerArr2, i5 + 1, headerArr2, i5 + 1 + i6, this.headerCount);
                this.nextHeaderIndex += i6;
            }
            return i6;
        }

        private ByteString getName(int i4) throws IOException {
            if (isStaticHeader(i4)) {
                return Hpack.STATIC_HEADER_TABLE[i4].name;
            }
            int dynamicTableIndex = dynamicTableIndex(i4 - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    return headerArr[dynamicTableIndex].name;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        private void insertIntoDynamicTable(int i4, Header header) {
            this.headerList.add(header);
            int i5 = header.hpackSize;
            if (i4 != -1) {
                i5 -= this.dynamicTable[dynamicTableIndex(i4)].hpackSize;
            }
            int i6 = this.maxDynamicTableByteCount;
            if (i5 > i6) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i5) - i6);
            if (i4 == -1) {
                int i7 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i7 > headerArr.length) {
                    Header[] headerArr2 = new Header[(headerArr.length * 2)];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i8 = this.nextHeaderIndex;
                this.nextHeaderIndex = i8 - 1;
                this.dynamicTable[i8] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i4 + dynamicTableIndex(i4) + evictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i5;
        }

        private boolean isStaticHeader(int i4) {
            if (i4 < 0 || i4 > Hpack.STATIC_HEADER_TABLE.length - 1) {
                return false;
            }
            return true;
        }

        private int readByte() throws IOException {
            return this.source.readByte() & 255;
        }

        private void readIndexedHeader(int i4) throws IOException {
            if (isStaticHeader(i4)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i4]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(i4 - Hpack.STATIC_HEADER_TABLE.length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[dynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i4 + 1));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i4) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i4), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i4) throws IOException {
            this.headerList.add(new Header(getName(i4), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        /* access modifiers changed from: package-private */
        public ByteString readByteString() throws IOException {
            boolean z4;
            int readByte = readByte();
            if ((readByte & 128) == 128) {
                z4 = true;
            } else {
                z4 = false;
            }
            int readInt = readInt(readByte, 127);
            if (z4) {
                return ByteString.of(Huffman.get().decode(this.source.readByteArray((long) readInt)));
            }
            return this.source.readByteString((long) readInt);
        }

        /* access modifiers changed from: package-private */
        public void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                byte readByte = this.source.readByte();
                byte b5 = readByte & 255;
                if (b5 == 128) {
                    throw new IOException("index == 0");
                } else if ((readByte & 128) == 128) {
                    readIndexedHeader(readInt(b5, 127) - 1);
                } else if (b5 == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((readByte & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(b5, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int readInt = readInt(b5, 31);
                    this.maxDynamicTableByteCount = readInt;
                    if (readInt < 0 || readInt > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (b5 == 16 || b5 == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(b5, 15) - 1);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int readInt(int i4, int i5) throws IOException {
            int i6 = i4 & i5;
            if (i6 < i5) {
                return i6;
            }
            int i7 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) == 0) {
                    return i5 + (readByte << i7);
                }
                i5 += (readByte & 127) << i7;
                i7 += 7;
            }
        }

        Reader(int i4, int i5, Source source2) {
            this.headerList = new ArrayList();
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i4;
            this.maxDynamicTableByteCount = i5;
            this.source = Okio.buffer(source2);
        }
    }

    static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void adjustDynamicTableByteCount() {
            int i4 = this.maxDynamicTableByteCount;
            int i5 = this.dynamicTableByteCount;
            if (i4 >= i5) {
                return;
            }
            if (i4 == 0) {
                clearDynamicTable();
            } else {
                evictToRecoverBytes(i5 - i4);
            }
        }

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i4) {
            int i5;
            int i6 = 0;
            if (i4 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i5 = this.nextHeaderIndex;
                    if (length < i5 || i4 <= 0) {
                        Header[] headerArr = this.dynamicTable;
                        System.arraycopy(headerArr, i5 + 1, headerArr, i5 + 1 + i6, this.headerCount);
                        Header[] headerArr2 = this.dynamicTable;
                        int i7 = this.nextHeaderIndex;
                        Arrays.fill(headerArr2, i7 + 1, i7 + 1 + i6, (Object) null);
                        this.nextHeaderIndex += i6;
                    } else {
                        int i8 = this.dynamicTable[length].hpackSize;
                        i4 -= i8;
                        this.dynamicTableByteCount -= i8;
                        this.headerCount--;
                        i6++;
                    }
                }
                Header[] headerArr3 = this.dynamicTable;
                System.arraycopy(headerArr3, i5 + 1, headerArr3, i5 + 1 + i6, this.headerCount);
                Header[] headerArr22 = this.dynamicTable;
                int i72 = this.nextHeaderIndex;
                Arrays.fill(headerArr22, i72 + 1, i72 + 1 + i6, (Object) null);
                this.nextHeaderIndex += i6;
            }
            return i6;
        }

        private void insertIntoDynamicTable(Header header) {
            int i4 = header.hpackSize;
            int i5 = this.maxDynamicTableByteCount;
            if (i4 > i5) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i4) - i5);
            int i6 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i6 > headerArr.length) {
                Header[] headerArr2 = new Header[(headerArr.length * 2)];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i7 = this.nextHeaderIndex;
            this.nextHeaderIndex = i7 - 1;
            this.dynamicTable[i7] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i4;
        }

        /* access modifiers changed from: package-private */
        public void setHeaderTableSizeSetting(int i4) {
            this.headerTableSizeSetting = i4;
            int min = Math.min(i4, 16384);
            int i5 = this.maxDynamicTableByteCount;
            if (i5 != min) {
                if (min < i5) {
                    this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
                }
                this.emitDynamicTableSizeUpdate = true;
                this.maxDynamicTableByteCount = min;
                adjustDynamicTableByteCount();
            }
        }

        /* access modifiers changed from: package-private */
        public void writeByteString(ByteString byteString) throws IOException {
            if (!this.useCompression || Huffman.get().encodedLength(byteString) >= byteString.size()) {
                writeInt(byteString.size(), 127, 0);
                this.out.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            Huffman.get().encode(byteString, buffer);
            ByteString readByteString = buffer.readByteString();
            writeInt(readByteString.size(), 127, 128);
            this.out.write(readByteString);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0070  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeHeaders(java.util.List<com.mbridge.msdk.thrid.okhttp.internal.http2.Header> r14) throws java.io.IOException {
            /*
                r13 = this;
                boolean r0 = r13.emitDynamicTableSizeUpdate
                r1 = 0
                if (r0 == 0) goto L_0x001e
                int r0 = r13.smallestHeaderTableSizeSetting
                int r2 = r13.maxDynamicTableByteCount
                r3 = 32
                r4 = 31
                if (r0 >= r2) goto L_0x0012
                r13.writeInt(r0, r4, r3)
            L_0x0012:
                r13.emitDynamicTableSizeUpdate = r1
                r0 = 2147483647(0x7fffffff, float:NaN)
                r13.smallestHeaderTableSizeSetting = r0
                int r0 = r13.maxDynamicTableByteCount
                r13.writeInt(r0, r4, r3)
            L_0x001e:
                int r0 = r14.size()
                r2 = 0
            L_0x0023:
                if (r2 >= r0) goto L_0x00eb
                java.lang.Object r3 = r14.get(r2)
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header r3 = (com.mbridge.msdk.thrid.okhttp.internal.http2.Header) r3
                com.mbridge.msdk.thrid.okio.ByteString r4 = r3.name
                com.mbridge.msdk.thrid.okio.ByteString r4 = r4.toAsciiLowercase()
                com.mbridge.msdk.thrid.okio.ByteString r5 = r3.value
                java.util.Map<com.mbridge.msdk.thrid.okio.ByteString, java.lang.Integer> r6 = com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.NAME_TO_FIRST_INDEX
                java.lang.Object r6 = r6.get(r4)
                java.lang.Integer r6 = (java.lang.Integer) r6
                r7 = 1
                r8 = -1
                if (r6 == 0) goto L_0x006c
                int r6 = r6.intValue()
                int r9 = r6 + 1
                if (r9 <= r7) goto L_0x0069
                r10 = 8
                if (r9 >= r10) goto L_0x0069
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r10 = com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.STATIC_HEADER_TABLE
                r11 = r10[r6]
                com.mbridge.msdk.thrid.okio.ByteString r11 = r11.value
                boolean r11 = com.mbridge.msdk.thrid.okhttp.internal.Util.equal(r11, r5)
                if (r11 == 0) goto L_0x0059
                r6 = r9
                goto L_0x006e
            L_0x0059:
                r10 = r10[r9]
                com.mbridge.msdk.thrid.okio.ByteString r10 = r10.value
                boolean r10 = com.mbridge.msdk.thrid.okhttp.internal.Util.equal(r10, r5)
                if (r10 == 0) goto L_0x0069
                int r6 = r6 + 2
                r12 = r9
                r9 = r6
                r6 = r12
                goto L_0x006e
            L_0x0069:
                r6 = r9
            L_0x006a:
                r9 = -1
                goto L_0x006e
            L_0x006c:
                r6 = -1
                goto L_0x006a
            L_0x006e:
                if (r9 != r8) goto L_0x00a6
                int r10 = r13.nextHeaderIndex
                int r10 = r10 + r7
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r7 = r13.dynamicTable
                int r7 = r7.length
            L_0x0076:
                if (r10 >= r7) goto L_0x00a6
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r11 = r13.dynamicTable
                r11 = r11[r10]
                com.mbridge.msdk.thrid.okio.ByteString r11 = r11.name
                boolean r11 = com.mbridge.msdk.thrid.okhttp.internal.Util.equal(r11, r4)
                if (r11 == 0) goto L_0x00a3
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r11 = r13.dynamicTable
                r11 = r11[r10]
                com.mbridge.msdk.thrid.okio.ByteString r11 = r11.value
                boolean r11 = com.mbridge.msdk.thrid.okhttp.internal.Util.equal(r11, r5)
                if (r11 == 0) goto L_0x0099
                int r7 = r13.nextHeaderIndex
                int r10 = r10 - r7
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r7 = com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.STATIC_HEADER_TABLE
                int r7 = r7.length
                int r9 = r10 + r7
                goto L_0x00a6
            L_0x0099:
                if (r6 != r8) goto L_0x00a3
                int r6 = r13.nextHeaderIndex
                int r6 = r10 - r6
                com.mbridge.msdk.thrid.okhttp.internal.http2.Header[] r11 = com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.STATIC_HEADER_TABLE
                int r11 = r11.length
                int r6 = r6 + r11
            L_0x00a3:
                int r10 = r10 + 1
                goto L_0x0076
            L_0x00a6:
                if (r9 == r8) goto L_0x00b0
                r3 = 127(0x7f, float:1.78E-43)
                r4 = 128(0x80, float:1.794E-43)
                r13.writeInt(r9, r3, r4)
                goto L_0x00e7
            L_0x00b0:
                r7 = 64
                if (r6 != r8) goto L_0x00c3
                com.mbridge.msdk.thrid.okio.Buffer r6 = r13.out
                r6.writeByte((int) r7)
                r13.writeByteString(r4)
                r13.writeByteString(r5)
                r13.insertIntoDynamicTable(r3)
                goto L_0x00e7
            L_0x00c3:
                com.mbridge.msdk.thrid.okio.ByteString r8 = com.mbridge.msdk.thrid.okhttp.internal.http2.Header.PSEUDO_PREFIX
                boolean r8 = r4.startsWith((com.mbridge.msdk.thrid.okio.ByteString) r8)
                if (r8 == 0) goto L_0x00dc
                com.mbridge.msdk.thrid.okio.ByteString r8 = com.mbridge.msdk.thrid.okhttp.internal.http2.Header.TARGET_AUTHORITY
                boolean r4 = r8.equals(r4)
                if (r4 != 0) goto L_0x00dc
                r3 = 15
                r13.writeInt(r6, r3, r1)
                r13.writeByteString(r5)
                goto L_0x00e7
            L_0x00dc:
                r4 = 63
                r13.writeInt(r6, r4, r7)
                r13.writeByteString(r5)
                r13.insertIntoDynamicTable(r3)
            L_0x00e7:
                int r2 = r2 + 1
                goto L_0x0023
            L_0x00eb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Hpack.Writer.writeHeaders(java.util.List):void");
        }

        /* access modifiers changed from: package-private */
        public void writeInt(int i4, int i5, int i6) {
            if (i4 < i5) {
                this.out.writeByte(i4 | i6);
                return;
            }
            this.out.writeByte(i6 | i5);
            int i7 = i4 - i5;
            while (i7 >= 128) {
                this.out.writeByte(128 | (i7 & 127));
                i7 >>>= 7;
            }
            this.out.writeByte(i7);
        }

        Writer(int i4, boolean z4, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i4;
            this.maxDynamicTableByteCount = i4;
            this.useCompression = z4;
            this.out = buffer;
        }
    }

    static {
        Header header = new Header(Header.TARGET_AUTHORITY, "");
        ByteString byteString = Header.TARGET_METHOD;
        Header header2 = new Header(byteString, ShareTarget.METHOD_GET);
        Header header3 = new Header(byteString, ShareTarget.METHOD_POST);
        ByteString byteString2 = Header.TARGET_PATH;
        Header header4 = new Header(byteString2, "/");
        Header header5 = new Header(byteString2, "/index.html");
        ByteString byteString3 = Header.TARGET_SCHEME;
        Header header6 = new Header(byteString3, "http");
        Header header7 = new Header(byteString3, "https");
        ByteString byteString4 = Header.RESPONSE_STATUS;
        Header header8 = header;
        Header header9 = header2;
        STATIC_HEADER_TABLE = new Header[]{header8, header9, header3, header4, header5, header6, header7, new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header("content-encoding", ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(DownloadModel.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header(TypedValues.TransitionType.S_FROM, ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header("referer", ""), new Header(ToolBar.REFRESH, ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
    }

    private Hpack() {
    }

    static ByteString checkLowercase(ByteString byteString) throws IOException {
        int size = byteString.size();
        int i4 = 0;
        while (i4 < size) {
            byte b5 = byteString.getByte(i4);
            if (b5 < 65 || b5 > 90) {
                i4++;
            } else {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i4 = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i4 >= headerArr.length) {
                return DesugarCollections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i4].name)) {
                linkedHashMap.put(headerArr[i4].name, Integer.valueOf(i4));
            }
            i4++;
        }
    }
}
