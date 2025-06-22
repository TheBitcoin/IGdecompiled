package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MessageLite;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    private static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private void recomputeBufferSizeAfterLimit() {
            int i4 = this.limit + this.bufferSizeAfterLimit;
            this.limit = i4;
            int i5 = i4 - this.startPos;
            int i6 = this.currentLimit;
            if (i5 > i6) {
                int i7 = i5 - i6;
                this.bufferSizeAfterLimit = i7;
                this.limit = i4 - i7;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        private void skipRawVarint() throws IOException {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            int i4 = 0;
            while (i4 < 10) {
                byte[] bArr = this.buffer;
                int i5 = this.pos;
                this.pos = i5 + 1;
                if (bArr[i5] < 0) {
                    i4++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i4 = 0;
            while (i4 < 10) {
                if (readRawByte() < 0) {
                    i4++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public void checkLastTagWas(int i4) throws InvalidProtocolBufferException {
            if (this.lastTag != i4) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public void enableAliasing(boolean z4) {
            this.enableAliasing = z4;
        }

        public int getBytesUntilLimit() {
            int i4 = this.currentLimit;
            if (i4 == Integer.MAX_VALUE) {
                return -1;
            }
            return i4 - getTotalBytesRead();
        }

        public int getLastTag() {
            return this.lastTag;
        }

        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        public boolean isAtEnd() throws IOException {
            if (this.pos == this.limit) {
                return true;
            }
            return false;
        }

        public void popLimit(int i4) {
            this.currentLimit = i4;
            recomputeBufferSizeAfterLimit();
        }

        public int pushLimit(int i4) throws InvalidProtocolBufferException {
            if (i4 >= 0) {
                int totalBytesRead = i4 + getTotalBytesRead();
                if (totalBytesRead >= 0) {
                    int i5 = this.currentLimit;
                    if (totalBytesRead <= i5) {
                        this.currentLimit = totalBytesRead;
                        recomputeBufferSizeAfterLimit();
                        return i5;
                    }
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.parseFailure();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        public ByteBuffer readByteBuffer() throws IOException {
            ByteBuffer byteBuffer;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i4 = this.limit;
                int i5 = this.pos;
                if (readRawVarint32 <= i4 - i5) {
                    if (this.immutable || !this.enableAliasing) {
                        byteBuffer = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i5, i5 + readRawVarint32));
                    } else {
                        byteBuffer = ByteBuffer.wrap(this.buffer, i5, readRawVarint32).slice();
                    }
                    this.pos += readRawVarint32;
                    return byteBuffer;
                }
            }
            if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public ByteString readBytes() throws IOException {
            ByteString byteString;
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i4 = this.limit;
                int i5 = this.pos;
                if (readRawVarint32 <= i4 - i5) {
                    if (!this.immutable || !this.enableAliasing) {
                        byteString = ByteString.copyFrom(this.buffer, i5, readRawVarint32);
                    } else {
                        byteString = ByteString.wrap(this.buffer, i5, readRawVarint32);
                    }
                    this.pos += readRawVarint32;
                    return byteString;
                }
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            return ByteString.wrap(readRawBytes(readRawVarint32));
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i4, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i4, 4));
            this.recursionDepth--;
        }

        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte readRawByte() throws IOException {
            int i4 = this.pos;
            if (i4 != this.limit) {
                byte[] bArr = this.buffer;
                this.pos = i4 + 1;
                return bArr[i4];
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte[] readRawBytes(int i4) throws IOException {
            if (i4 > 0) {
                int i5 = this.limit;
                int i6 = this.pos;
                if (i4 <= i5 - i6) {
                    int i7 = i4 + i6;
                    this.pos = i7;
                    return Arrays.copyOfRange(this.buffer, i6, i7);
                }
            }
            if (i4 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i4 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public int readRawLittleEndian32() throws IOException {
            int i4 = this.pos;
            if (this.limit - i4 >= 4) {
                byte[] bArr = this.buffer;
                this.pos = i4 + 4;
                return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long readRawLittleEndian64() throws IOException {
            int i4 = this.pos;
            if (this.limit - i4 >= 8) {
                byte[] bArr = this.buffer;
                this.pos = i4 + 8;
                return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public int readRawVarint32() throws IOException {
            byte b5;
            byte b6;
            int i4 = this.pos;
            int i5 = this.limit;
            if (i5 != i4) {
                byte[] bArr = this.buffer;
                int i6 = i4 + 1;
                byte b7 = bArr[i4];
                if (b7 >= 0) {
                    this.pos = i6;
                    return b7;
                } else if (i5 - i6 >= 9) {
                    int i7 = i4 + 2;
                    byte b8 = (bArr[i6] << 7) ^ b7;
                    if (b8 < 0) {
                        b5 = b8 ^ Byte.MIN_VALUE;
                    } else {
                        int i8 = i4 + 3;
                        byte b9 = (bArr[i7] << 14) ^ b8;
                        if (b9 >= 0) {
                            b6 = b9 ^ 16256;
                        } else {
                            int i9 = i4 + 4;
                            byte b10 = b9 ^ (bArr[i8] << 21);
                            if (b10 < 0) {
                                b5 = -2080896 ^ b10;
                            } else {
                                i8 = i4 + 5;
                                byte b11 = bArr[i9];
                                byte b12 = (b10 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    i9 = i4 + 6;
                                    if (bArr[i8] < 0) {
                                        i8 = i4 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i4 + 8;
                                            if (bArr[i8] < 0) {
                                                i8 = i4 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i10 = i4 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        byte b13 = b12;
                                                        i7 = i10;
                                                        b5 = b13;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b5 = b12;
                                }
                                b6 = b12;
                            }
                            i7 = i9;
                        }
                        i7 = i8;
                    }
                    this.pos = i7;
                    return b5;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        public long readRawVarint64() throws IOException {
            long j4;
            long j5;
            long j6;
            long j7;
            int i4 = this.pos;
            int i5 = this.limit;
            if (i5 != i4) {
                byte[] bArr = this.buffer;
                int i6 = i4 + 1;
                byte b5 = bArr[i4];
                if (b5 >= 0) {
                    this.pos = i6;
                    return (long) b5;
                } else if (i5 - i6 >= 9) {
                    int i7 = i4 + 2;
                    byte b6 = (bArr[i6] << 7) ^ b5;
                    if (b6 < 0) {
                        j4 = (long) (b6 ^ Byte.MIN_VALUE);
                    } else {
                        int i8 = i4 + 3;
                        byte b7 = (bArr[i7] << 14) ^ b6;
                        if (b7 >= 0) {
                            j4 = (long) (b7 ^ 16256);
                            i7 = i8;
                        } else {
                            int i9 = i4 + 4;
                            byte b8 = b7 ^ (bArr[i8] << 21);
                            if (b8 < 0) {
                                j7 = (long) (-2080896 ^ b8);
                            } else {
                                long j8 = (long) b8;
                                int i10 = i4 + 5;
                                long j9 = j8 ^ (((long) bArr[i9]) << 28);
                                if (j9 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    i9 = i4 + 6;
                                    long j10 = j9 ^ (((long) bArr[i10]) << 35);
                                    if (j10 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        i10 = i4 + 7;
                                        j9 = j10 ^ (((long) bArr[i9]) << 42);
                                        if (j9 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            i9 = i4 + 8;
                                            j10 = j9 ^ (((long) bArr[i10]) << 49);
                                            if (j10 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                i7 = i4 + 9;
                                                long j11 = (j10 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                                if (j11 < 0) {
                                                    int i11 = i4 + 10;
                                                    if (((long) bArr[i7]) >= 0) {
                                                        i7 = i11;
                                                    }
                                                }
                                                j4 = j11;
                                            }
                                        }
                                    }
                                    j7 = j5 ^ j10;
                                }
                                j4 = j6 ^ j9;
                            }
                            i7 = i9;
                            j4 = j7;
                        }
                    }
                    this.pos = i7;
                    return j4;
                }
            }
            return readRawVarint64SlowPath();
        }

        /* access modifiers changed from: package-private */
        public long readRawVarint64SlowPath() throws IOException {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte readRawByte = readRawByte();
                j4 |= ((long) (readRawByte & Byte.MAX_VALUE)) << i4;
                if ((readRawByte & 128) == 0) {
                    return j4;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i4 = this.limit;
                int i5 = this.pos;
                if (readRawVarint32 <= i4 - i5) {
                    String str = new String(this.buffer, i5, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i4 = this.limit;
                int i5 = this.pos;
                if (readRawVarint32 <= i4 - i5) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.buffer, i5, readRawVarint32);
                    this.pos += readRawVarint32;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i4, MessageLite.Builder builder) throws IOException {
            readGroup(i4, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        public boolean skipField(int i4) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i4), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.ArrayDecoder.skipMessage():void");
        }

        public void skipRawBytes(int i4) throws IOException {
            if (i4 >= 0) {
                int i5 = this.limit;
                int i6 = this.pos;
                if (i4 <= i5 - i6) {
                    this.pos = i6 + i4;
                    return;
                }
            }
            if (i4 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private ArrayDecoder(byte[] bArr, int i4, int i5, boolean z4) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = bArr;
            this.limit = i5 + i4;
            this.pos = i4;
            this.startPos = i4;
            this.immutable = z4;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(androidx.datastore.preferences.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.ArrayDecoder.skipMessage(androidx.datastore.preferences.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i4, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t4 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i4, 4));
            this.recursionDepth--;
            return t4;
        }

        public boolean skipField(int i4, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i4);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i4), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i4);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t4 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return t4;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private final Iterable<ByteBuffer> input;
        private final Iterator<ByteBuffer> iterator;
        private int lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (this.iterator.hasNext()) {
                tryGetNextByteBuffer();
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private void readRawBytesTo(byte[] bArr, int i4, int i5) throws IOException {
            if (i5 >= 0 && i5 <= remaining()) {
                int i6 = i5;
                while (i6 > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int min = Math.min(i6, (int) currentRemaining());
                    long j4 = (long) min;
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, (long) ((i5 - i6) + i4), j4);
                    i6 -= min;
                    this.currentByteBufferPos += j4;
                }
            } else if (i5 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i5 != 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            int i4 = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = i4;
            int i5 = i4 - this.startOffset;
            int i6 = this.currentLimit;
            if (i5 > i6) {
                int i7 = i5 - i6;
                this.bufferSizeAfterCurrentLimit = i7;
                this.totalBufferSize = i4 - i7;
                return;
            }
            this.bufferSizeAfterCurrentLimit = 0;
        }

        private int remaining() {
            return (int) ((((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private void skipRawVarint() throws IOException {
            int i4 = 0;
            while (i4 < 10) {
                if (readRawByte() < 0) {
                    i4++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:6|7|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
            throw androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
            r2.position(r0);
            r2.limit(r1);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0023 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.nio.ByteBuffer slice(int r4, int r5) throws java.io.IOException {
            /*
                r3 = this;
                java.nio.ByteBuffer r0 = r3.currentByteBuffer
                int r0 = r0.position()
                java.nio.ByteBuffer r1 = r3.currentByteBuffer
                int r1 = r1.limit()
                java.nio.ByteBuffer r2 = r3.currentByteBuffer
                r2.position(r4)     // Catch:{ IllegalArgumentException -> 0x0023 }
                r2.limit(r5)     // Catch:{ IllegalArgumentException -> 0x0023 }
                java.nio.ByteBuffer r4 = r3.currentByteBuffer     // Catch:{ IllegalArgumentException -> 0x0023 }
                java.nio.ByteBuffer r4 = r4.slice()     // Catch:{ IllegalArgumentException -> 0x0023 }
                r2.position(r0)
                r2.limit(r1)
                return r4
            L_0x0021:
                r4 = move-exception
                goto L_0x0028
            L_0x0023:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()     // Catch:{ all -> 0x0021 }
                throw r4     // Catch:{ all -> 0x0021 }
            L_0x0028:
                r2.position(r0)
                r2.limit(r1)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.slice(int, int):java.nio.ByteBuffer");
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer next = this.iterator.next();
            this.currentByteBuffer = next;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long position = (long) next.position();
            this.currentByteBufferPos = position;
            this.currentByteBufferStartPos = position;
            this.currentByteBufferLimit = (long) this.currentByteBuffer.limit();
            long addressOffset = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = addressOffset;
            this.currentByteBufferPos += addressOffset;
            this.currentByteBufferStartPos += addressOffset;
            this.currentByteBufferLimit += addressOffset;
        }

        public void checkLastTagWas(int i4) throws InvalidProtocolBufferException {
            if (this.lastTag != i4) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public void enableAliasing(boolean z4) {
            this.enableAliasing = z4;
        }

        public int getBytesUntilLimit() {
            int i4 = this.currentLimit;
            if (i4 == Integer.MAX_VALUE) {
                return -1;
            }
            return i4 - getTotalBytesRead();
        }

        public int getLastTag() {
            return this.lastTag;
        }

        public int getTotalBytesRead() {
            return (int) ((((long) (this.totalBytesRead - this.startOffset)) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        public boolean isAtEnd() throws IOException {
            if ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize)) {
                return true;
            }
            return false;
        }

        public void popLimit(int i4) {
            this.currentLimit = i4;
            recomputeBufferSizeAfterLimit();
        }

        public int pushLimit(int i4) throws InvalidProtocolBufferException {
            if (i4 >= 0) {
                int totalBytesRead2 = i4 + getTotalBytesRead();
                int i5 = this.currentLimit;
                if (totalBytesRead2 <= i5) {
                    this.currentLimit = totalBytesRead2;
                    recomputeBufferSizeAfterLimit();
                    return i5;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j4 = (long) readRawVarint32;
                if (j4 <= currentRemaining()) {
                    if (this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[readRawVarint32];
                        UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0, j4);
                        this.currentByteBufferPos += j4;
                        return ByteBuffer.wrap(bArr);
                    }
                    long j5 = this.currentByteBufferPos + j4;
                    this.currentByteBufferPos = j5;
                    long j6 = this.currentAddress;
                    return slice((int) ((j5 - j6) - j4), (int) (j5 - j6));
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteBuffer.wrap(bArr2);
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j4 = (long) readRawVarint32;
                long j5 = this.currentByteBufferLimit;
                long j6 = this.currentByteBufferPos;
                if (j4 <= j5 - j6) {
                    if (!this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[readRawVarint32];
                        UnsafeUtil.copyMemory(j6, bArr, 0, j4);
                        this.currentByteBufferPos += j4;
                        return ByteString.wrap(bArr);
                    }
                    int i4 = (int) (j6 - this.currentAddress);
                    ByteString wrap = ByteString.wrap(slice(i4, readRawVarint32 + i4));
                    this.currentByteBufferPos += j4;
                    return wrap;
                }
            }
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (!this.immutable || !this.enableAliasing) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return ByteString.wrap(bArr2);
            } else {
                ArrayList arrayList = new ArrayList();
                while (readRawVarint32 > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int min = Math.min(readRawVarint32, (int) currentRemaining());
                    int i5 = (int) (this.currentByteBufferPos - this.currentAddress);
                    arrayList.add(ByteString.wrap(slice(i5, i5 + min)));
                    readRawVarint32 -= min;
                    this.currentByteBufferPos += (long) min;
                }
                return ByteString.copyFrom((Iterable<ByteString>) arrayList);
            }
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i4, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i4, 4));
            this.recursionDepth--;
        }

        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte readRawByte() throws IOException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j4 = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j4;
            return UnsafeUtil.getByte(j4);
        }

        public byte[] readRawBytes(int i4) throws IOException {
            if (i4 >= 0) {
                long j4 = (long) i4;
                if (j4 <= currentRemaining()) {
                    byte[] bArr = new byte[i4];
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0, j4);
                    this.currentByteBufferPos += j4;
                    return bArr;
                }
            }
            if (i4 >= 0 && i4 <= remaining()) {
                byte[] bArr2 = new byte[i4];
                readRawBytesTo(bArr2, 0, i4);
                return bArr2;
            } else if (i4 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i4 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public int readRawLittleEndian32() throws IOException {
            if (currentRemaining() < 4) {
                return (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24);
            }
            long j4 = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + j4;
            return ((UnsafeUtil.getByte(j4 + 3) & 255) << 24) | (UnsafeUtil.getByte(j4) & 255) | ((UnsafeUtil.getByte(1 + j4) & 255) << 8) | ((UnsafeUtil.getByte(2 + j4) & 255) << 16);
        }

        public long readRawLittleEndian64() throws IOException {
            if (currentRemaining() < 8) {
                return (((long) readRawByte()) & 255) | ((((long) readRawByte()) & 255) << 8) | ((((long) readRawByte()) & 255) << 16) | ((((long) readRawByte()) & 255) << 24) | ((((long) readRawByte()) & 255) << 32) | ((((long) readRawByte()) & 255) << 40) | ((((long) readRawByte()) & 255) << 48) | ((((long) readRawByte()) & 255) << 56);
            }
            long j4 = this.currentByteBufferPos;
            this.currentByteBufferPos = 8 + j4;
            long j5 = ((((long) UnsafeUtil.getByte(4 + j4)) & 255) << 32) | ((((long) UnsafeUtil.getByte(2 + j4)) & 255) << 16) | (((long) UnsafeUtil.getByte(j4)) & 255) | ((((long) UnsafeUtil.getByte(1 + j4)) & 255) << 8) | ((((long) UnsafeUtil.getByte(3 + j4)) & 255) << 24) | ((((long) UnsafeUtil.getByte(5 + j4)) & 255) << 40);
            return ((((long) UnsafeUtil.getByte(j4 + 7)) & 255) << 56) | ((((long) UnsafeUtil.getByte(6 + j4)) & 255) << 48) | j5;
        }

        public int readRawVarint32() throws IOException {
            byte b5;
            byte b6;
            long j4 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j4) {
                long j5 = j4 + 1;
                byte b7 = UnsafeUtil.getByte(j4);
                if (b7 >= 0) {
                    this.currentByteBufferPos++;
                    return b7;
                } else if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j6 = 2 + j4;
                    byte b8 = (UnsafeUtil.getByte(j5) << 7) ^ b7;
                    if (b8 < 0) {
                        b5 = b8 ^ Byte.MIN_VALUE;
                    } else {
                        long j7 = 3 + j4;
                        byte b9 = (UnsafeUtil.getByte(j6) << 14) ^ b8;
                        if (b9 >= 0) {
                            b6 = b9 ^ 16256;
                        } else {
                            long j8 = 4 + j4;
                            byte b10 = b9 ^ (UnsafeUtil.getByte(j7) << 21);
                            if (b10 < 0) {
                                b5 = -2080896 ^ b10;
                            } else {
                                j7 = 5 + j4;
                                byte b11 = UnsafeUtil.getByte(j8);
                                byte b12 = (b10 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    j8 = 6 + j4;
                                    if (UnsafeUtil.getByte(j7) < 0) {
                                        j7 = 7 + j4;
                                        if (UnsafeUtil.getByte(j8) < 0) {
                                            j8 = 8 + j4;
                                            if (UnsafeUtil.getByte(j7) < 0) {
                                                j7 = 9 + j4;
                                                if (UnsafeUtil.getByte(j8) < 0) {
                                                    long j9 = j4 + 10;
                                                    if (UnsafeUtil.getByte(j7) >= 0) {
                                                        long j10 = j9;
                                                        b5 = b12;
                                                        j6 = j10;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b5 = b12;
                                }
                                b6 = b12;
                            }
                            j6 = j8;
                        }
                        j6 = j7;
                    }
                    this.currentByteBufferPos = j6;
                    return b5;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        public long readRawVarint64() throws IOException {
            long j4;
            long j5;
            long j6;
            long j7 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j7) {
                long j8 = j7 + 1;
                byte b5 = UnsafeUtil.getByte(j7);
                if (b5 >= 0) {
                    this.currentByteBufferPos++;
                    return (long) b5;
                } else if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j9 = 2 + j7;
                    byte b6 = (UnsafeUtil.getByte(j8) << 7) ^ b5;
                    if (b6 < 0) {
                        j4 = (long) (b6 ^ Byte.MIN_VALUE);
                    } else {
                        long j10 = 3 + j7;
                        byte b7 = (UnsafeUtil.getByte(j9) << 14) ^ b6;
                        if (b7 >= 0) {
                            j4 = (long) (b7 ^ 16256);
                            j9 = j10;
                        } else {
                            long j11 = 4 + j7;
                            byte b8 = b7 ^ (UnsafeUtil.getByte(j10) << 21);
                            if (b8 < 0) {
                                j4 = (long) (-2080896 ^ b8);
                                j9 = j11;
                            } else {
                                long j12 = 5 + j7;
                                long j13 = (((long) UnsafeUtil.getByte(j11)) << 28) ^ ((long) b8);
                                if (j13 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    long j14 = 6 + j7;
                                    long j15 = j13 ^ (((long) UnsafeUtil.getByte(j12)) << 35);
                                    if (j15 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        j12 = 7 + j7;
                                        j13 = j15 ^ (((long) UnsafeUtil.getByte(j14)) << 42);
                                        if (j13 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            j14 = 8 + j7;
                                            j15 = j13 ^ (((long) UnsafeUtil.getByte(j12)) << 49);
                                            if (j15 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                j12 = 9 + j7;
                                                long j16 = (j15 ^ (((long) UnsafeUtil.getByte(j14)) << 56)) ^ 71499008037633920L;
                                                if (j16 < 0) {
                                                    long j17 = j7 + 10;
                                                    if (((long) UnsafeUtil.getByte(j12)) >= 0) {
                                                        long j18 = j16;
                                                        j9 = j17;
                                                        j4 = j18;
                                                    }
                                                } else {
                                                    j4 = j16;
                                                    j9 = j12;
                                                }
                                            }
                                        }
                                    }
                                    j4 = j5 ^ j15;
                                    j9 = j14;
                                }
                                j4 = j6 ^ j13;
                                j9 = j12;
                            }
                        }
                    }
                    this.currentByteBufferPos = j9;
                    return j4;
                }
            }
            return readRawVarint64SlowPath();
        }

        /* access modifiers changed from: package-private */
        public long readRawVarint64SlowPath() throws IOException {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte readRawByte = readRawByte();
                j4 |= ((long) (readRawByte & Byte.MAX_VALUE)) << i4;
                if ((readRawByte & 128) == 0) {
                    return j4;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j4 = (long) readRawVarint32;
                long j5 = this.currentByteBufferLimit;
                long j6 = this.currentByteBufferPos;
                if (j4 <= j5 - j6) {
                    byte[] bArr = new byte[readRawVarint32];
                    UnsafeUtil.copyMemory(j6, bArr, 0, j4);
                    String str = new String(bArr, Internal.UTF_8);
                    this.currentByteBufferPos += j4;
                    return str;
                }
            }
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[readRawVarint32];
                readRawBytesTo(bArr2, 0, readRawVarint32);
                return new String(bArr2, Internal.UTF_8);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                long j4 = (long) readRawVarint32;
                long j5 = this.currentByteBufferLimit;
                long j6 = this.currentByteBufferPos;
                if (j4 <= j5 - j6) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.currentByteBuffer, (int) (j6 - this.currentByteBufferStartPos), readRawVarint32);
                    this.currentByteBufferPos += j4;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 >= 0 && readRawVarint32 <= remaining()) {
                byte[] bArr = new byte[readRawVarint32];
                readRawBytesTo(bArr, 0, readRawVarint32);
                return Utf8.decodeUtf8(bArr, 0, readRawVarint32);
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i4, MessageLite.Builder builder) throws IOException {
            readGroup(i4, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.startOffset = (int) ((((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        public boolean skipField(int i4) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i4), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.skipMessage():void");
        }

        public void skipRawBytes(int i4) throws IOException {
            if (i4 >= 0 && ((long) i4) <= (((long) (this.totalBufferSize - this.totalBytesRead)) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                while (i4 > 0) {
                    if (currentRemaining() == 0) {
                        getNextByteBuffer();
                    }
                    int min = Math.min(i4, (int) currentRemaining());
                    i4 -= min;
                    this.currentByteBufferPos += (long) min;
                }
            } else if (i4 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i4, boolean z4) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = i4;
            this.input = iterable;
            this.iterator = iterable.iterator();
            this.immutable = z4;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (i4 == 0) {
                this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
                this.currentByteBufferPos = 0;
                this.currentByteBufferStartPos = 0;
                this.currentByteBufferLimit = 0;
                this.currentAddress = 0;
                return;
            }
            tryGetNextByteBuffer();
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(androidx.datastore.preferences.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.IterableDirectByteBufferDecoder.skipMessage(androidx.datastore.preferences.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i4, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t4 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i4, 4));
            this.recursionDepth--;
            return t4;
        }

        public boolean skipField(int i4, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i4);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i4), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i4);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t4 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return t4;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private static final class StreamDecoder extends CodedInputStream {
        /* access modifiers changed from: private */
        public final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        /* access modifiers changed from: private */
        public int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        private interface RefillCallback {
            void onRefill();
        }

        private class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;
            private int lastPos;

            private SkippedDataSink() {
                this.lastPos = StreamDecoder.this.pos;
            }

            /* access modifiers changed from: package-private */
            public ByteBuffer getSkippedData() {
                ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
                if (byteArrayOutputStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                }
                byteArrayOutputStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos);
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }

            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new ByteArrayOutputStream();
                }
                this.byteArrayStream.write(StreamDecoder.this.buffer, this.lastPos, StreamDecoder.this.pos - this.lastPos);
                this.lastPos = 0;
            }
        }

        private static int available(InputStream inputStream) throws IOException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e5) {
                e5.setThrownFromInputStream();
                throw e5;
            }
        }

        private static int read(InputStream inputStream, byte[] bArr, int i4, int i5) throws IOException {
            try {
                return inputStream.read(bArr, i4, i5);
            } catch (InvalidProtocolBufferException e5) {
                e5.setThrownFromInputStream();
                throw e5;
            }
        }

        private ByteString readBytesSlowPath(int i4) throws IOException {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i4);
            if (readRawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom(readRawBytesSlowPathOneChunk);
            }
            int i5 = this.pos;
            int i6 = this.bufferSize;
            int i7 = i6 - i5;
            this.totalBytesRetired += i6;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i4 - i7);
            byte[] bArr = new byte[i4];
            System.arraycopy(this.buffer, i5, bArr, 0, i7);
            for (byte[] next : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(next, 0, bArr, i7, next.length);
                i7 += next.length;
            }
            return ByteString.wrap(bArr);
        }

        private byte[] readRawBytesSlowPath(int i4, boolean z4) throws IOException {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i4);
            if (readRawBytesSlowPathOneChunk == null) {
                int i5 = this.pos;
                int i6 = this.bufferSize;
                int i7 = i6 - i5;
                this.totalBytesRetired += i6;
                this.pos = 0;
                this.bufferSize = 0;
                List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i4 - i7);
                byte[] bArr = new byte[i4];
                System.arraycopy(this.buffer, i5, bArr, 0, i7);
                for (byte[] next : readRawBytesSlowPathRemainingChunks) {
                    System.arraycopy(next, 0, bArr, i7, next.length);
                    i7 += next.length;
                }
                return bArr;
            } else if (z4) {
                return (byte[]) readRawBytesSlowPathOneChunk.clone();
            } else {
                return readRawBytesSlowPathOneChunk;
            }
        }

        private byte[] readRawBytesSlowPathOneChunk(int i4) throws IOException {
            if (i4 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i4 >= 0) {
                int i5 = this.totalBytesRetired;
                int i6 = this.pos;
                int i7 = i5 + i6 + i4;
                if (i7 - this.sizeLimit <= 0) {
                    int i8 = this.currentLimit;
                    if (i7 <= i8) {
                        int i9 = this.bufferSize - i6;
                        int i10 = i4 - i9;
                        if (i10 >= 4096 && i10 > available(this.input)) {
                            return null;
                        }
                        byte[] bArr = new byte[i4];
                        System.arraycopy(this.buffer, this.pos, bArr, 0, i9);
                        this.totalBytesRetired += this.bufferSize;
                        this.pos = 0;
                        this.bufferSize = 0;
                        while (i9 < i4) {
                            int read = read(this.input, bArr, i9, i4 - i9);
                            if (read != -1) {
                                this.totalBytesRetired += read;
                                i9 += read;
                            } else {
                                throw InvalidProtocolBufferException.truncatedMessage();
                            }
                        }
                        return bArr;
                    }
                    skipRawBytes((i8 - i5) - i6);
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int i4) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i4 > 0) {
                int min = Math.min(i4, 4096);
                byte[] bArr = new byte[min];
                int i5 = 0;
                while (i5 < min) {
                    int read = this.input.read(bArr, i5, min - i5);
                    if (read != -1) {
                        this.totalBytesRetired += read;
                        i5 += read;
                    } else {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                }
                i4 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i4 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i4;
            int i5 = this.totalBytesRetired + i4;
            int i6 = this.currentLimit;
            if (i5 > i6) {
                int i7 = i5 - i6;
                this.bufferSizeAfterLimit = i7;
                this.bufferSize = i4 - i7;
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        private void refillBuffer(int i4) throws IOException {
            if (tryRefillBuffer(i4)) {
                return;
            }
            if (i4 > (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        private static long skip(InputStream inputStream, long j4) throws IOException {
            try {
                return inputStream.skip(j4);
            } catch (InvalidProtocolBufferException e5) {
                e5.setThrownFromInputStream();
                throw e5;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
            throw new java.lang.IllegalStateException(r8.input.getClass() + "#skip returned invalid result: " + r0 + "\nThe InputStream implementation is buggy.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void skipRawBytesSlowPath(int r9) throws java.io.IOException {
            /*
                r8 = this;
                if (r9 < 0) goto L_0x0097
                int r0 = r8.totalBytesRetired
                int r1 = r8.pos
                int r2 = r0 + r1
                int r2 = r2 + r9
                int r3 = r8.currentLimit
                if (r2 > r3) goto L_0x008d
                androidx.datastore.preferences.protobuf.CodedInputStream$StreamDecoder$RefillCallback r2 = r8.refillCallback
                r3 = 0
                if (r2 != 0) goto L_0x006f
                int r0 = r0 + r1
                r8.totalBytesRetired = r0
                int r0 = r8.bufferSize
                int r0 = r0 - r1
                r8.bufferSize = r3
                r8.pos = r3
                r3 = r0
            L_0x001d:
                if (r3 >= r9) goto L_0x0067
                int r0 = r9 - r3
                java.io.InputStream r1 = r8.input     // Catch:{ all -> 0x005d }
                long r4 = (long) r0     // Catch:{ all -> 0x005d }
                long r0 = skip(r1, r4)     // Catch:{ all -> 0x005d }
                r6 = 0
                int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
                if (r2 < 0) goto L_0x0038
                int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r6 > 0) goto L_0x0038
                if (r2 != 0) goto L_0x0035
                goto L_0x0067
            L_0x0035:
                int r1 = (int) r0     // Catch:{ all -> 0x005d }
                int r3 = r3 + r1
                goto L_0x001d
            L_0x0038:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005d }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
                r2.<init>()     // Catch:{ all -> 0x005d }
                java.io.InputStream r4 = r8.input     // Catch:{ all -> 0x005d }
                java.lang.Class r4 = r4.getClass()     // Catch:{ all -> 0x005d }
                r2.append(r4)     // Catch:{ all -> 0x005d }
                java.lang.String r4 = "#skip returned invalid result: "
                r2.append(r4)     // Catch:{ all -> 0x005d }
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = "\nThe InputStream implementation is buggy."
                r2.append(r0)     // Catch:{ all -> 0x005d }
                java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x005d }
                r9.<init>(r0)     // Catch:{ all -> 0x005d }
                throw r9     // Catch:{ all -> 0x005d }
            L_0x005d:
                r9 = move-exception
                int r0 = r8.totalBytesRetired
                int r0 = r0 + r3
                r8.totalBytesRetired = r0
                r8.recomputeBufferSizeAfterLimit()
                throw r9
            L_0x0067:
                int r0 = r8.totalBytesRetired
                int r0 = r0 + r3
                r8.totalBytesRetired = r0
                r8.recomputeBufferSizeAfterLimit()
            L_0x006f:
                if (r3 >= r9) goto L_0x008c
                int r0 = r8.bufferSize
                int r1 = r8.pos
                int r1 = r0 - r1
                r8.pos = r0
                r0 = 1
                r8.refillBuffer(r0)
            L_0x007d:
                int r2 = r9 - r1
                int r3 = r8.bufferSize
                if (r2 <= r3) goto L_0x008a
                int r1 = r1 + r3
                r8.pos = r3
                r8.refillBuffer(r0)
                goto L_0x007d
            L_0x008a:
                r8.pos = r2
            L_0x008c:
                return
            L_0x008d:
                int r3 = r3 - r0
                int r3 = r3 - r1
                r8.skipRawBytes(r3)
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
                throw r9
            L_0x0097:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r9 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.negativeSize()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.skipRawBytesSlowPath(int):void");
        }

        private void skipRawVarint() throws IOException {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            int i4 = 0;
            while (i4 < 10) {
                byte[] bArr = this.buffer;
                int i5 = this.pos;
                this.pos = i5 + 1;
                if (bArr[i5] < 0) {
                    i4++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i4 = 0;
            while (i4 < 10) {
                if (readRawByte() < 0) {
                    i4++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean tryRefillBuffer(int i4) throws IOException {
            int i5 = this.pos;
            if (i5 + i4 > this.bufferSize) {
                int i6 = this.sizeLimit;
                int i7 = this.totalBytesRetired;
                if (i4 > (i6 - i7) - i5 || i7 + i5 + i4 > this.currentLimit) {
                    return false;
                }
                RefillCallback refillCallback2 = this.refillCallback;
                if (refillCallback2 != null) {
                    refillCallback2.onRefill();
                }
                int i8 = this.pos;
                if (i8 > 0) {
                    int i9 = this.bufferSize;
                    if (i9 > i8) {
                        byte[] bArr = this.buffer;
                        System.arraycopy(bArr, i8, bArr, 0, i9 - i8);
                    }
                    this.totalBytesRetired += i8;
                    this.bufferSize -= i8;
                    this.pos = 0;
                }
                InputStream inputStream = this.input;
                byte[] bArr2 = this.buffer;
                int i10 = this.bufferSize;
                int read = read(inputStream, bArr2, i10, Math.min(bArr2.length - i10, (this.sizeLimit - this.totalBytesRetired) - i10));
                if (read == 0 || read < -1 || read > this.buffer.length) {
                    throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
                } else if (read <= 0) {
                    return false;
                } else {
                    this.bufferSize += read;
                    recomputeBufferSizeAfterLimit();
                    if (this.bufferSize >= i4) {
                        return true;
                    }
                    return tryRefillBuffer(i4);
                }
            } else {
                throw new IllegalStateException("refillBuffer() called when " + i4 + " bytes were already available in buffer");
            }
        }

        public void checkLastTagWas(int i4) throws InvalidProtocolBufferException {
            if (this.lastTag != i4) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public void enableAliasing(boolean z4) {
        }

        public int getBytesUntilLimit() {
            int i4 = this.currentLimit;
            if (i4 == Integer.MAX_VALUE) {
                return -1;
            }
            return i4 - (this.totalBytesRetired + this.pos);
        }

        public int getLastTag() {
            return this.lastTag;
        }

        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        public boolean isAtEnd() throws IOException {
            if (this.pos != this.bufferSize || tryRefillBuffer(1)) {
                return false;
            }
            return true;
        }

        public void popLimit(int i4) {
            this.currentLimit = i4;
            recomputeBufferSizeAfterLimit();
        }

        public int pushLimit(int i4) throws InvalidProtocolBufferException {
            if (i4 >= 0) {
                int i5 = i4 + this.totalBytesRetired + this.pos;
                int i6 = this.currentLimit;
                if (i5 <= i6) {
                    this.currentLimit = i5;
                    recomputeBufferSizeAfterLimit();
                    return i6;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        public byte[] readByteArray() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i4 = this.bufferSize;
            int i5 = this.pos;
            if (readRawVarint32 > i4 - i5 || readRawVarint32 <= 0) {
                return readRawBytesSlowPath(readRawVarint32, false);
            }
            byte[] copyOfRange = Arrays.copyOfRange(this.buffer, i5, i5 + readRawVarint32);
            this.pos += readRawVarint32;
            return copyOfRange;
        }

        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i4 = this.bufferSize;
            int i5 = this.pos;
            if (readRawVarint32 <= i4 - i5 && readRawVarint32 > 0) {
                ByteBuffer wrap = ByteBuffer.wrap(Arrays.copyOfRange(this.buffer, i5, i5 + readRawVarint32));
                this.pos += readRawVarint32;
                return wrap;
            } else if (readRawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            } else {
                return ByteBuffer.wrap(readRawBytesSlowPath(readRawVarint32, true));
            }
        }

        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            int i4 = this.bufferSize;
            int i5 = this.pos;
            if (readRawVarint32 <= i4 - i5 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.buffer, i5, readRawVarint32);
                this.pos += readRawVarint32;
                return copyFrom;
            } else if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            } else {
                return readBytesSlowPath(readRawVarint32);
            }
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i4, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i4, 4));
            this.recursionDepth--;
        }

        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte readRawByte() throws IOException {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i4 = this.pos;
            this.pos = i4 + 1;
            return bArr[i4];
        }

        public byte[] readRawBytes(int i4) throws IOException {
            int i5 = this.pos;
            if (i4 > this.bufferSize - i5 || i4 <= 0) {
                return readRawBytesSlowPath(i4, false);
            }
            int i6 = i4 + i5;
            this.pos = i6;
            return Arrays.copyOfRange(this.buffer, i5, i6);
        }

        public int readRawLittleEndian32() throws IOException {
            int i4 = this.pos;
            if (this.bufferSize - i4 < 4) {
                refillBuffer(4);
                i4 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i4 + 4;
            return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
        }

        public long readRawLittleEndian64() throws IOException {
            int i4 = this.pos;
            if (this.bufferSize - i4 < 8) {
                refillBuffer(8);
                i4 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i4 + 8;
            return ((((long) bArr[i4 + 7]) & 255) << 56) | (((long) bArr[i4]) & 255) | ((((long) bArr[i4 + 1]) & 255) << 8) | ((((long) bArr[i4 + 2]) & 255) << 16) | ((((long) bArr[i4 + 3]) & 255) << 24) | ((((long) bArr[i4 + 4]) & 255) << 32) | ((((long) bArr[i4 + 5]) & 255) << 40) | ((((long) bArr[i4 + 6]) & 255) << 48);
        }

        public int readRawVarint32() throws IOException {
            byte b5;
            byte b6;
            int i4 = this.pos;
            int i5 = this.bufferSize;
            if (i5 != i4) {
                byte[] bArr = this.buffer;
                int i6 = i4 + 1;
                byte b7 = bArr[i4];
                if (b7 >= 0) {
                    this.pos = i6;
                    return b7;
                } else if (i5 - i6 >= 9) {
                    int i7 = i4 + 2;
                    byte b8 = (bArr[i6] << 7) ^ b7;
                    if (b8 < 0) {
                        b5 = b8 ^ Byte.MIN_VALUE;
                    } else {
                        int i8 = i4 + 3;
                        byte b9 = (bArr[i7] << 14) ^ b8;
                        if (b9 >= 0) {
                            b6 = b9 ^ 16256;
                        } else {
                            int i9 = i4 + 4;
                            byte b10 = b9 ^ (bArr[i8] << 21);
                            if (b10 < 0) {
                                b5 = -2080896 ^ b10;
                            } else {
                                i8 = i4 + 5;
                                byte b11 = bArr[i9];
                                byte b12 = (b10 ^ (b11 << 28)) ^ 266354560;
                                if (b11 < 0) {
                                    i9 = i4 + 6;
                                    if (bArr[i8] < 0) {
                                        i8 = i4 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i4 + 8;
                                            if (bArr[i8] < 0) {
                                                i8 = i4 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i10 = i4 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        byte b13 = b12;
                                                        i7 = i10;
                                                        b5 = b13;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    b5 = b12;
                                }
                                b6 = b12;
                            }
                            i7 = i9;
                        }
                        i7 = i8;
                    }
                    this.pos = i7;
                    return b5;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        public long readRawVarint64() throws IOException {
            long j4;
            long j5;
            long j6;
            long j7;
            int i4 = this.pos;
            int i5 = this.bufferSize;
            if (i5 != i4) {
                byte[] bArr = this.buffer;
                int i6 = i4 + 1;
                byte b5 = bArr[i4];
                if (b5 >= 0) {
                    this.pos = i6;
                    return (long) b5;
                } else if (i5 - i6 >= 9) {
                    int i7 = i4 + 2;
                    byte b6 = (bArr[i6] << 7) ^ b5;
                    if (b6 < 0) {
                        j4 = (long) (b6 ^ Byte.MIN_VALUE);
                    } else {
                        int i8 = i4 + 3;
                        byte b7 = (bArr[i7] << 14) ^ b6;
                        if (b7 >= 0) {
                            j4 = (long) (b7 ^ 16256);
                            i7 = i8;
                        } else {
                            int i9 = i4 + 4;
                            byte b8 = b7 ^ (bArr[i8] << 21);
                            if (b8 < 0) {
                                j7 = (long) (-2080896 ^ b8);
                            } else {
                                long j8 = (long) b8;
                                int i10 = i4 + 5;
                                long j9 = j8 ^ (((long) bArr[i9]) << 28);
                                if (j9 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    i9 = i4 + 6;
                                    long j10 = j9 ^ (((long) bArr[i10]) << 35);
                                    if (j10 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        i10 = i4 + 7;
                                        j9 = j10 ^ (((long) bArr[i9]) << 42);
                                        if (j9 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            i9 = i4 + 8;
                                            j10 = j9 ^ (((long) bArr[i10]) << 49);
                                            if (j10 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                i7 = i4 + 9;
                                                long j11 = (j10 ^ (((long) bArr[i9]) << 56)) ^ 71499008037633920L;
                                                if (j11 < 0) {
                                                    int i11 = i4 + 10;
                                                    if (((long) bArr[i7]) >= 0) {
                                                        i7 = i11;
                                                    }
                                                }
                                                j4 = j11;
                                            }
                                        }
                                    }
                                    j7 = j5 ^ j10;
                                }
                                j4 = j6 ^ j9;
                            }
                            i7 = i9;
                            j4 = j7;
                        }
                    }
                    this.pos = i7;
                    return j4;
                }
            }
            return readRawVarint64SlowPath();
        }

        /* access modifiers changed from: package-private */
        public long readRawVarint64SlowPath() throws IOException {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte readRawByte = readRawByte();
                j4 |= ((long) (readRawByte & Byte.MAX_VALUE)) << i4;
                if ((readRawByte & 128) == 0) {
                    return j4;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i4 = this.bufferSize;
                int i5 = this.pos;
                if (readRawVarint32 <= i4 - i5) {
                    String str = new String(this.buffer, i5, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return "";
            }
            if (readRawVarint32 > this.bufferSize) {
                return new String(readRawBytesSlowPath(readRawVarint32, false), Internal.UTF_8);
            }
            refillBuffer(readRawVarint32);
            String str2 = new String(this.buffer, this.pos, readRawVarint32, Internal.UTF_8);
            this.pos += readRawVarint32;
            return str2;
        }

        public String readStringRequireUtf8() throws IOException {
            byte[] bArr;
            int readRawVarint32 = readRawVarint32();
            int i4 = this.pos;
            int i5 = this.bufferSize;
            if (readRawVarint32 <= i5 - i4 && readRawVarint32 > 0) {
                bArr = this.buffer;
                this.pos = i4 + readRawVarint32;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                i4 = 0;
                if (readRawVarint32 <= i5) {
                    refillBuffer(readRawVarint32);
                    bArr = this.buffer;
                    this.pos = readRawVarint32;
                } else {
                    bArr = readRawBytesSlowPath(readRawVarint32, false);
                }
            }
            return Utf8.decodeUtf8(bArr, i4, readRawVarint32);
        }

        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i4, MessageLite.Builder builder) throws IOException {
            readGroup(i4, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.totalBytesRetired = -this.pos;
        }

        public boolean skipField(int i4) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i4), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.skipMessage():void");
        }

        public void skipRawBytes(int i4) throws IOException {
            int i5 = this.bufferSize;
            int i6 = this.pos;
            if (i4 > i5 - i6 || i4 < 0) {
                skipRawBytesSlowPath(i4);
            } else {
                this.pos = i6 + i4;
            }
        }

        private StreamDecoder(InputStream inputStream, int i4) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(inputStream, "input");
            this.input = inputStream;
            this.buffer = new byte[i4];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(androidx.datastore.preferences.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.StreamDecoder.skipMessage(androidx.datastore.preferences.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i4, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t4 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i4, 4));
            this.recursionDepth--;
            return t4;
        }

        public boolean skipField(int i4, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i4);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i4), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i4);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t4 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return t4;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private static final class UnsafeDirectNioDecoder extends CodedInputStream {
        private final long address;
        private final ByteBuffer buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private long limit;
        private long pos;
        private long startPos;

        private int bufferPos(long j4) {
            return (int) (j4 - this.address);
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void recomputeBufferSizeAfterLimit() {
            long j4 = this.limit + ((long) this.bufferSizeAfterLimit);
            this.limit = j4;
            int i4 = (int) (j4 - this.startPos);
            int i5 = this.currentLimit;
            if (i4 > i5) {
                int i6 = i4 - i5;
                this.bufferSizeAfterLimit = i6;
                this.limit = j4 - ((long) i6);
                return;
            }
            this.bufferSizeAfterLimit = 0;
        }

        private int remaining() {
            return (int) (this.limit - this.pos);
        }

        private void skipRawVarint() throws IOException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws IOException {
            int i4 = 0;
            while (i4 < 10) {
                long j4 = this.pos;
                this.pos = 1 + j4;
                if (UnsafeUtil.getByte(j4) < 0) {
                    i4++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws IOException {
            int i4 = 0;
            while (i4 < 10) {
                if (readRawByte() < 0) {
                    i4++;
                } else {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private ByteBuffer slice(long j4, long j5) throws IOException {
            int position = this.buffer.position();
            int limit2 = this.buffer.limit();
            ByteBuffer byteBuffer = this.buffer;
            try {
                byteBuffer.position(bufferPos(j4));
                byteBuffer.limit(bufferPos(j5));
                ByteBuffer slice = this.buffer.slice();
                byteBuffer.position(position);
                byteBuffer.limit(limit2);
                return slice;
            } catch (IllegalArgumentException e5) {
                InvalidProtocolBufferException truncatedMessage = InvalidProtocolBufferException.truncatedMessage();
                truncatedMessage.initCause(e5);
                throw truncatedMessage;
            } catch (Throwable th) {
                byteBuffer.position(position);
                byteBuffer.limit(limit2);
                throw th;
            }
        }

        public void checkLastTagWas(int i4) throws InvalidProtocolBufferException {
            if (this.lastTag != i4) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        public void enableAliasing(boolean z4) {
            this.enableAliasing = z4;
        }

        public int getBytesUntilLimit() {
            int i4 = this.currentLimit;
            if (i4 == Integer.MAX_VALUE) {
                return -1;
            }
            return i4 - getTotalBytesRead();
        }

        public int getLastTag() {
            return this.lastTag;
        }

        public int getTotalBytesRead() {
            return (int) (this.pos - this.startPos);
        }

        public boolean isAtEnd() throws IOException {
            if (this.pos == this.limit) {
                return true;
            }
            return false;
        }

        public void popLimit(int i4) {
            this.currentLimit = i4;
            recomputeBufferSizeAfterLimit();
        }

        public int pushLimit(int i4) throws InvalidProtocolBufferException {
            if (i4 >= 0) {
                int totalBytesRead = i4 + getTotalBytesRead();
                int i5 = this.currentLimit;
                if (totalBytesRead <= i5) {
                    this.currentLimit = totalBytesRead;
                    recomputeBufferSizeAfterLimit();
                    return i5;
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public boolean readBool() throws IOException {
            if (readRawVarint64() != 0) {
                return true;
            }
            return false;
        }

        public byte[] readByteArray() throws IOException {
            return readRawBytes(readRawVarint32());
        }

        public ByteBuffer readByteBuffer() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[readRawVarint32];
                long j4 = (long) readRawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0, j4);
                this.pos += j4;
                return ByteBuffer.wrap(bArr);
            } else {
                long j5 = this.pos;
                long j6 = (long) readRawVarint32;
                ByteBuffer slice = slice(j5, j5 + j6);
                this.pos += j6;
                return slice;
            }
        }

        public ByteString readBytes() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 <= 0 || readRawVarint32 > remaining()) {
                if (readRawVarint32 == 0) {
                    return ByteString.EMPTY;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (!this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[readRawVarint32];
                long j4 = (long) readRawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0, j4);
                this.pos += j4;
                return ByteString.wrap(bArr);
            } else {
                long j5 = this.pos;
                long j6 = (long) readRawVarint32;
                ByteBuffer slice = slice(j5, j5 + j6);
                this.pos += j6;
                return ByteString.wrap(slice);
            }
        }

        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        public int readEnum() throws IOException {
            return readRawVarint32();
        }

        public int readFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        public void readGroup(int i4, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i4, 4));
            this.recursionDepth--;
        }

        public int readInt32() throws IOException {
            return readRawVarint32();
        }

        public long readInt64() throws IOException {
            return readRawVarint64();
        }

        public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte readRawByte() throws IOException {
            long j4 = this.pos;
            if (j4 != this.limit) {
                this.pos = 1 + j4;
                return UnsafeUtil.getByte(j4);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public byte[] readRawBytes(int i4) throws IOException {
            if (i4 >= 0 && i4 <= remaining()) {
                byte[] bArr = new byte[i4];
                long j4 = this.pos;
                long j5 = (long) i4;
                slice(j4, j4 + j5).get(bArr);
                this.pos += j5;
                return bArr;
            } else if (i4 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if (i4 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            } else {
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        public int readRawLittleEndian32() throws IOException {
            long j4 = this.pos;
            if (this.limit - j4 >= 4) {
                this.pos = 4 + j4;
                return ((UnsafeUtil.getByte(j4 + 3) & 255) << 24) | (UnsafeUtil.getByte(j4) & 255) | ((UnsafeUtil.getByte(1 + j4) & 255) << 8) | ((UnsafeUtil.getByte(2 + j4) & 255) << 16);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        public long readRawLittleEndian64() throws IOException {
            long j4 = this.pos;
            if (this.limit - j4 >= 8) {
                this.pos = 8 + j4;
                return ((((long) UnsafeUtil.getByte(j4 + 7)) & 255) << 56) | (((long) UnsafeUtil.getByte(j4)) & 255) | ((((long) UnsafeUtil.getByte(1 + j4)) & 255) << 8) | ((((long) UnsafeUtil.getByte(2 + j4)) & 255) << 16) | ((((long) UnsafeUtil.getByte(3 + j4)) & 255) << 24) | ((((long) UnsafeUtil.getByte(4 + j4)) & 255) << 32) | ((((long) UnsafeUtil.getByte(5 + j4)) & 255) << 40) | ((((long) UnsafeUtil.getByte(6 + j4)) & 255) << 48);
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
            if (androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3) < 0) goto L_0x008e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int readRawVarint32() throws java.io.IOException {
            /*
                r10 = this;
                long r0 = r10.pos
                long r2 = r10.limit
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto L_0x000a
                goto L_0x008e
            L_0x000a:
                r2 = 1
                long r2 = r2 + r0
                byte r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r0)
                if (r4 < 0) goto L_0x0016
                r10.pos = r2
                return r4
            L_0x0016:
                long r5 = r10.limit
                long r5 = r5 - r2
                r7 = 9
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 >= 0) goto L_0x0021
                goto L_0x008e
            L_0x0021:
                r5 = 2
                long r5 = r5 + r0
                byte r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r4
                if (r2 >= 0) goto L_0x0031
                r0 = r2 ^ -128(0xffffffffffffff80, float:NaN)
                goto L_0x0098
            L_0x0031:
                r3 = 3
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r5)
                int r5 = r5 << 14
                r2 = r2 ^ r5
                if (r2 < 0) goto L_0x0041
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L_0x003f:
                r5 = r3
                goto L_0x0098
            L_0x0041:
                r5 = 4
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L_0x0052
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L_0x0098
            L_0x0052:
                r3 = 5
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r5)
                int r6 = r5 << 28
                r2 = r2 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r6
                if (r5 >= 0) goto L_0x0096
                r5 = 6
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3)
                if (r3 >= 0) goto L_0x0094
                r3 = 7
                long r3 = r3 + r0
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r5)
                if (r5 >= 0) goto L_0x0096
                r5 = 8
                long r5 = r5 + r0
                byte r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3)
                if (r3 >= 0) goto L_0x0094
                long r3 = r0 + r7
                byte r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r5)
                if (r5 >= 0) goto L_0x0096
                r5 = 10
                long r5 = r5 + r0
                byte r0 = androidx.datastore.preferences.protobuf.UnsafeUtil.getByte(r3)
                if (r0 >= 0) goto L_0x0094
            L_0x008e:
                long r0 = r10.readRawVarint64SlowPath()
                int r1 = (int) r0
                return r1
            L_0x0094:
                r0 = r2
                goto L_0x0098
            L_0x0096:
                r0 = r2
                goto L_0x003f
            L_0x0098:
                r10.pos = r5
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.readRawVarint32():int");
        }

        public long readRawVarint64() throws IOException {
            long j4;
            long j5;
            long j6;
            byte b5;
            long j7 = this.pos;
            if (this.limit != j7) {
                long j8 = 1 + j7;
                byte b6 = UnsafeUtil.getByte(j7);
                if (b6 >= 0) {
                    this.pos = j8;
                    return (long) b6;
                } else if (this.limit - j8 >= 9) {
                    long j9 = 2 + j7;
                    byte b7 = (UnsafeUtil.getByte(j8) << 7) ^ b6;
                    if (b7 < 0) {
                        b5 = b7 ^ Byte.MIN_VALUE;
                    } else {
                        long j10 = 3 + j7;
                        byte b8 = b7 ^ (UnsafeUtil.getByte(j9) << 14);
                        if (b8 >= 0) {
                            j4 = (long) (b8 ^ 16256);
                            j9 = j10;
                        } else {
                            j9 = 4 + j7;
                            byte b9 = b8 ^ (UnsafeUtil.getByte(j10) << 21);
                            if (b9 < 0) {
                                b5 = -2080896 ^ b9;
                            } else {
                                long j11 = 5 + j7;
                                long j12 = ((long) b9) ^ (((long) UnsafeUtil.getByte(j9)) << 28);
                                if (j12 >= 0) {
                                    j6 = 266354560;
                                } else {
                                    long j13 = 6 + j7;
                                    long j14 = j12 ^ (((long) UnsafeUtil.getByte(j11)) << 35);
                                    if (j14 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        j11 = 7 + j7;
                                        j12 = j14 ^ (((long) UnsafeUtil.getByte(j13)) << 42);
                                        if (j12 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            j13 = 8 + j7;
                                            j14 = j12 ^ (((long) UnsafeUtil.getByte(j11)) << 49);
                                            if (j14 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                long j15 = 9 + j7;
                                                long j16 = (j14 ^ (((long) UnsafeUtil.getByte(j13)) << 56)) ^ 71499008037633920L;
                                                if (j16 < 0) {
                                                    long j17 = j7 + 10;
                                                    if (((long) UnsafeUtil.getByte(j15)) >= 0) {
                                                        j9 = j17;
                                                        j4 = j16;
                                                    }
                                                } else {
                                                    j4 = j16;
                                                    j9 = j15;
                                                }
                                            }
                                        }
                                    }
                                    j4 = j5 ^ j14;
                                    j9 = j13;
                                }
                                j4 = j6 ^ j12;
                                j9 = j11;
                            }
                        }
                        this.pos = j9;
                        return j4;
                    }
                    j4 = (long) b5;
                    this.pos = j9;
                    return j4;
                }
            }
            return readRawVarint64SlowPath();
        }

        /* access modifiers changed from: package-private */
        public long readRawVarint64SlowPath() throws IOException {
            long j4 = 0;
            for (int i4 = 0; i4 < 64; i4 += 7) {
                byte readRawByte = readRawByte();
                j4 |= ((long) (readRawByte & Byte.MAX_VALUE)) << i4;
                if ((readRawByte & 128) == 0) {
                    return j4;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        public int readSFixed32() throws IOException {
            return readRawLittleEndian32();
        }

        public long readSFixed64() throws IOException {
            return readRawLittleEndian64();
        }

        public int readSInt32() throws IOException {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        public long readSInt64() throws IOException {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        public String readString() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                byte[] bArr = new byte[readRawVarint32];
                long j4 = (long) readRawVarint32;
                UnsafeUtil.copyMemory(this.pos, bArr, 0, j4);
                String str = new String(bArr, Internal.UTF_8);
                this.pos += j4;
                return str;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public String readStringRequireUtf8() throws IOException {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0 && readRawVarint32 <= remaining()) {
                String decodeUtf8 = Utf8.decodeUtf8(this.buffer, bufferPos(this.pos), readRawVarint32);
                this.pos += (long) readRawVarint32;
                return decodeUtf8;
            } else if (readRawVarint32 == 0) {
                return "";
            } else {
                if (readRawVarint32 <= 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        public int readTag() throws IOException {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        public int readUInt32() throws IOException {
            return readRawVarint32();
        }

        public long readUInt64() throws IOException {
            return readRawVarint64();
        }

        @Deprecated
        public void readUnknownGroup(int i4, MessageLite.Builder builder) throws IOException {
            readGroup(i4, builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        public void resetSizeCounter() {
            this.startPos = this.pos;
        }

        public boolean skipField(int i4) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            } else if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            } else if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            } else if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i4), 4));
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    skipRawBytes(4);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage() throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.skipMessage():void");
        }

        public void skipRawBytes(int i4) throws IOException {
            if (i4 >= 0 && i4 <= remaining()) {
                this.pos += (long) i4;
            } else if (i4 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z4) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.buffer = byteBuffer;
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = addressOffset;
            this.limit = ((long) byteBuffer.limit()) + addressOffset;
            long position = addressOffset + ((long) byteBuffer.position());
            this.pos = position;
            this.startPos = position;
            this.immutable = z4;
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        public void skipMessage(androidx.datastore.preferences.protobuf.CodedOutputStream r2) throws java.io.IOException {
            /*
                r1 = this;
            L_0x0000:
                int r0 = r1.readTag()
                if (r0 == 0) goto L_0x000c
                boolean r0 = r1.skipField(r0, r2)
                if (r0 != 0) goto L_0x0000
            L_0x000c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.skipMessage(androidx.datastore.preferences.protobuf.CodedOutputStream):void");
        }

        public <T extends MessageLite> T readGroup(int i4, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            checkRecursionLimit();
            this.recursionDepth++;
            T t4 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(WireFormat.makeTag(i4, 4));
            this.recursionDepth--;
            return t4;
        }

        public boolean skipField(int i4, CodedOutputStream codedOutputStream) throws IOException {
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                long readInt64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeUInt64NoTag(readInt64);
                return true;
            } else if (tagWireType == 1) {
                long readRawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
                return true;
            } else if (tagWireType == 2) {
                ByteString readBytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i4);
                codedOutputStream.writeBytesNoTag(readBytes);
                return true;
            } else if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i4);
                skipMessage(codedOutputStream);
                int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i4), 4);
                checkLastTagWas(makeTag);
                codedOutputStream.writeUInt32NoTag(makeTag);
                return true;
            } else if (tagWireType == 4) {
                return false;
            } else {
                if (tagWireType == 5) {
                    int readRawLittleEndian32 = readRawLittleEndian32();
                    codedOutputStream.writeUInt32NoTag(i4);
                    codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
                    return true;
                }
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int readRawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T t4 = (MessageLite) parser.parsePartialFrom((CodedInputStream) this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(pushLimit);
                return t4;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static int decodeZigZag32(int i4) {
        return (-(i4 & 1)) ^ (i4 >>> 1);
    }

    public static long decodeZigZag64(long j4) {
        return (-(j4 & 1)) ^ (j4 >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static int readRawVarint32(int i4, InputStream inputStream) throws IOException {
        if ((i4 & 128) == 0) {
            return i4;
        }
        int i5 = i4 & ModuleDescriptor.MODULE_VERSION;
        int i6 = 7;
        while (i6 < 32) {
            int read = inputStream.read();
            if (read != -1) {
                i5 |= (read & ModuleDescriptor.MODULE_VERSION) << i6;
                if ((read & 128) == 0) {
                    return i5;
                }
                i6 += 7;
            } else {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
        while (i6 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            } else if ((read2 & 128) == 0) {
                return i5;
            } else {
                i6 += 7;
            }
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public abstract void checkLastTagWas(int i4) throws InvalidProtocolBufferException;

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    /* access modifiers changed from: package-private */
    public final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean z4);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd() throws IOException;

    public abstract void popLimit(int i4);

    public abstract int pushLimit(int i4) throws InvalidProtocolBufferException;

    public abstract boolean readBool() throws IOException;

    public abstract byte[] readByteArray() throws IOException;

    public abstract ByteBuffer readByteBuffer() throws IOException;

    public abstract ByteString readBytes() throws IOException;

    public abstract double readDouble() throws IOException;

    public abstract int readEnum() throws IOException;

    public abstract int readFixed32() throws IOException;

    public abstract long readFixed64() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract <T extends MessageLite> T readGroup(int i4, Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readGroup(int i4, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract int readInt32() throws IOException;

    public abstract long readInt64() throws IOException;

    public abstract <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) throws IOException;

    public abstract byte readRawByte() throws IOException;

    public abstract byte[] readRawBytes(int i4) throws IOException;

    public abstract int readRawLittleEndian32() throws IOException;

    public abstract long readRawLittleEndian64() throws IOException;

    public abstract int readRawVarint32() throws IOException;

    public abstract long readRawVarint64() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long readRawVarint64SlowPath() throws IOException;

    public abstract int readSFixed32() throws IOException;

    public abstract long readSFixed64() throws IOException;

    public abstract int readSInt32() throws IOException;

    public abstract long readSInt64() throws IOException;

    public abstract String readString() throws IOException;

    public abstract String readStringRequireUtf8() throws IOException;

    public abstract int readTag() throws IOException;

    public abstract int readUInt32() throws IOException;

    public abstract long readUInt64() throws IOException;

    @Deprecated
    public abstract void readUnknownGroup(int i4, MessageLite.Builder builder) throws IOException;

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int i4) {
        if (i4 >= 0) {
            int i5 = this.recursionLimit;
            this.recursionLimit = i4;
            return i5;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i4);
    }

    public final int setSizeLimit(int i4) {
        if (i4 >= 0) {
            int i5 = this.sizeLimit;
            this.sizeLimit = i4;
            return i5;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i4);
    }

    /* access modifiers changed from: package-private */
    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public abstract boolean skipField(int i4) throws IOException;

    @Deprecated
    public abstract boolean skipField(int i4, CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipMessage() throws IOException;

    public abstract void skipMessage(CodedOutputStream codedOutputStream) throws IOException;

    public abstract void skipRawBytes(int i4) throws IOException;

    /* access modifiers changed from: package-private */
    public final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i4) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        } else if (inputStream == null) {
            return newInstance(Internal.EMPTY_BYTE_ARRAY);
        } else {
            return new StreamDecoder(inputStream, i4);
        }
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable) {
        if (!UnsafeDirectNioDecoder.isSupported()) {
            return newInstance((InputStream) new IterableByteBufferInputStream(iterable));
        }
        return newInstance(iterable, false);
    }

    static int readRawVarint32(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return readRawVarint32(read, inputStream);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    static CodedInputStream newInstance(Iterable<ByteBuffer> iterable, boolean z4) {
        boolean z5 = false;
        int i4 = 0;
        for (ByteBuffer next : iterable) {
            i4 += next.remaining();
            if (next.hasArray()) {
                z5 |= true;
            } else {
                z5 = next.isDirect() ? z5 | true : z5 | true;
            }
        }
        if (z5) {
            return new IterableDirectByteBufferDecoder(iterable, i4, z4);
        }
        return newInstance((InputStream) new IterableByteBufferInputStream(iterable));
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i4, int i5) {
        return newInstance(bArr, i4, i5, false);
    }

    static CodedInputStream newInstance(byte[] bArr, int i4, int i5, boolean z4) {
        int i6 = i5;
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i4, i6, z4);
        try {
            arrayDecoder.pushLimit(i6);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return newInstance(byteBuffer, false);
    }

    static CodedInputStream newInstance(ByteBuffer byteBuffer, boolean z4) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z4);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.isSupported()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z4);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return newInstance(bArr, 0, remaining, true);
    }
}
