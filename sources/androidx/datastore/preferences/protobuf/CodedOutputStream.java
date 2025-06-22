package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;
    /* access modifiers changed from: private */
    public static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();
    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;

    private static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        AbstractBufferedEncoder(int i4) {
            super();
            if (i4 >= 0) {
                byte[] bArr = new byte[Math.max(i4, 20)];
                this.buffer = bArr;
                this.limit = bArr.length;
                return;
            }
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }

        /* access modifiers changed from: package-private */
        public final void buffer(byte b5) {
            byte[] bArr = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr[i4] = b5;
            this.totalBytesWritten++;
        }

        /* access modifiers changed from: package-private */
        public final void bufferFixed32NoTag(int i4) {
            byte[] bArr = this.buffer;
            int i5 = this.position;
            int i6 = i5 + 1;
            this.position = i6;
            bArr[i5] = (byte) (i4 & 255);
            int i7 = i5 + 2;
            this.position = i7;
            bArr[i6] = (byte) ((i4 >> 8) & 255);
            int i8 = i5 + 3;
            this.position = i8;
            bArr[i7] = (byte) ((i4 >> 16) & 255);
            this.position = i5 + 4;
            bArr[i8] = (byte) ((i4 >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        /* access modifiers changed from: package-private */
        public final void bufferFixed64NoTag(long j4) {
            byte[] bArr = this.buffer;
            int i4 = this.position;
            int i5 = i4 + 1;
            this.position = i5;
            bArr[i4] = (byte) ((int) (j4 & 255));
            int i6 = i4 + 2;
            this.position = i6;
            bArr[i5] = (byte) ((int) ((j4 >> 8) & 255));
            int i7 = i4 + 3;
            this.position = i7;
            bArr[i6] = (byte) ((int) ((j4 >> 16) & 255));
            int i8 = i4 + 4;
            this.position = i8;
            bArr[i7] = (byte) ((int) (255 & (j4 >> 24)));
            int i9 = i4 + 5;
            this.position = i9;
            bArr[i8] = (byte) (((int) (j4 >> 32)) & 255);
            int i10 = i4 + 6;
            this.position = i10;
            bArr[i9] = (byte) (((int) (j4 >> 40)) & 255);
            int i11 = i4 + 7;
            this.position = i11;
            bArr[i10] = (byte) (((int) (j4 >> 48)) & 255);
            this.position = i4 + 8;
            bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        /* access modifiers changed from: package-private */
        public final void bufferInt32NoTag(int i4) {
            if (i4 >= 0) {
                bufferUInt32NoTag(i4);
            } else {
                bufferUInt64NoTag((long) i4);
            }
        }

        /* access modifiers changed from: package-private */
        public final void bufferTag(int i4, int i5) {
            bufferUInt32NoTag(WireFormat.makeTag(i4, i5));
        }

        /* access modifiers changed from: package-private */
        public final void bufferUInt32NoTag(int i4) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j4 = (long) this.position;
                while ((i4 & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i5 = this.position;
                    this.position = i5 + 1;
                    UnsafeUtil.putByte(bArr, (long) i5, (byte) ((i4 & ModuleDescriptor.MODULE_VERSION) | 128));
                    i4 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                UnsafeUtil.putByte(bArr2, (long) i6, (byte) i4);
                this.totalBytesWritten += (int) (((long) this.position) - j4);
                return;
            }
            while ((i4 & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr3[i7] = (byte) ((i4 & ModuleDescriptor.MODULE_VERSION) | 128);
                this.totalBytesWritten++;
                i4 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i8 = this.position;
            this.position = i8 + 1;
            bArr4[i8] = (byte) i4;
            this.totalBytesWritten++;
        }

        /* access modifiers changed from: package-private */
        public final void bufferUInt64NoTag(long j4) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                long j5 = (long) this.position;
                while ((j4 & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    UnsafeUtil.putByte(bArr, (long) i4, (byte) ((((int) j4) & ModuleDescriptor.MODULE_VERSION) | 128));
                    j4 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                UnsafeUtil.putByte(bArr2, (long) i5, (byte) ((int) j4));
                this.totalBytesWritten += (int) (((long) this.position) - j5);
                return;
            }
            while ((j4 & -128) != 0) {
                byte[] bArr3 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr3[i6] = (byte) ((((int) j4) & ModuleDescriptor.MODULE_VERSION) | 128);
                this.totalBytesWritten++;
                j4 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i7 = this.position;
            this.position = i7 + 1;
            bArr4[i7] = (byte) ((int) j4);
            this.totalBytesWritten++;
        }

        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    private static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        ArrayEncoder(byte[] bArr, int i4, int i5) {
            super();
            if (bArr != null) {
                int i6 = i4 + i5;
                if ((i4 | i5 | (bArr.length - i6)) >= 0) {
                    this.buffer = bArr;
                    this.offset = i4;
                    this.position = i4;
                    this.limit = i6;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)}));
            }
            throw new NullPointerException("buffer");
        }

        public void flush() {
        }

        public final int getTotalBytesWritten() {
            return this.position - this.offset;
        }

        public final int spaceLeft() {
            return this.limit - this.position;
        }

        public final void write(byte b5) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr[i4] = b5;
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e5);
            }
        }

        public final void writeBool(int i4, boolean z4) throws IOException {
            writeTag(i4, 0);
            write(z4 ? (byte) 1 : 0);
        }

        public final void writeByteArray(int i4, byte[] bArr) throws IOException {
            writeByteArray(i4, bArr, 0, bArr.length);
        }

        public final void writeByteArrayNoTag(byte[] bArr, int i4, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i4, i5);
        }

        public final void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public final void writeBytes(int i4, ByteString byteString) throws IOException {
            writeTag(i4, 2);
            writeBytesNoTag(byteString);
        }

        public final void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public final void writeFixed32(int i4, int i5) throws IOException {
            writeTag(i4, 5);
            writeFixed32NoTag(i5);
        }

        public final void writeFixed32NoTag(int i4) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i5 = this.position;
                int i6 = i5 + 1;
                this.position = i6;
                bArr[i5] = (byte) (i4 & 255);
                int i7 = i5 + 2;
                this.position = i7;
                bArr[i6] = (byte) ((i4 >> 8) & 255);
                int i8 = i5 + 3;
                this.position = i8;
                bArr[i7] = (byte) ((i4 >> 16) & 255);
                this.position = i5 + 4;
                bArr[i8] = (byte) ((i4 >> 24) & 255);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e5);
            }
        }

        public final void writeFixed64(int i4, long j4) throws IOException {
            writeTag(i4, 1);
            writeFixed64NoTag(j4);
        }

        public final void writeFixed64NoTag(long j4) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i4 = this.position;
                int i5 = i4 + 1;
                this.position = i5;
                bArr[i4] = (byte) (((int) j4) & 255);
                int i6 = i4 + 2;
                this.position = i6;
                bArr[i5] = (byte) (((int) (j4 >> 8)) & 255);
                int i7 = i4 + 3;
                this.position = i7;
                bArr[i6] = (byte) (((int) (j4 >> 16)) & 255);
                int i8 = i4 + 4;
                this.position = i8;
                bArr[i7] = (byte) (((int) (j4 >> 24)) & 255);
                int i9 = i4 + 5;
                this.position = i9;
                bArr[i8] = (byte) (((int) (j4 >> 32)) & 255);
                int i10 = i4 + 6;
                this.position = i10;
                bArr[i9] = (byte) (((int) (j4 >> 40)) & 255);
                int i11 = i4 + 7;
                this.position = i11;
                bArr[i10] = (byte) (((int) (j4 >> 48)) & 255);
                this.position = i4 + 8;
                bArr[i11] = (byte) (((int) (j4 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e5);
            }
        }

        public final void writeInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeInt32NoTag(i5);
        }

        public final void writeInt32NoTag(int i4) throws IOException {
            if (i4 >= 0) {
                writeUInt32NoTag(i4);
            } else {
                writeUInt64NoTag((long) i4);
            }
        }

        public final void writeLazy(byte[] bArr, int i4, int i5) throws IOException {
            write(bArr, i4, i5);
        }

        public final void writeMessage(int i4, MessageLite messageLite) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite);
        }

        public final void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public final void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public final void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        public final void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public final void writeString(int i4, String str) throws IOException {
            writeTag(i4, 2);
            writeStringNoTag(str);
        }

        public final void writeStringNoTag(String str) throws IOException {
            int i4 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i5 = i4 + computeUInt32SizeNoTag2;
                    this.position = i5;
                    int encode = Utf8.encode(str, this.buffer, i5, spaceLeft());
                    this.position = i4;
                    writeUInt32NoTag((encode - i4) - computeUInt32SizeNoTag2);
                    this.position = encode;
                    return;
                }
                writeUInt32NoTag(Utf8.encodedLength(str));
                this.position = Utf8.encode(str, this.buffer, this.position, spaceLeft());
            } catch (Utf8.UnpairedSurrogateException e5) {
                this.position = i4;
                inefficientWriteStringNoTag(str, e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            }
        }

        public final void writeTag(int i4, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i4, i5));
        }

        public final void writeUInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeUInt32NoTag(i5);
        }

        public final void writeUInt32NoTag(int i4) throws IOException {
            while ((i4 & -128) != 0) {
                byte[] bArr = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr[i5] = (byte) ((i4 & ModuleDescriptor.MODULE_VERSION) | 128);
                i4 >>>= 7;
            }
            try {
                byte[] bArr2 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr2[i6] = (byte) i4;
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e5);
            }
        }

        public final void writeUInt64(int i4, long j4) throws IOException {
            writeTag(i4, 0);
            writeUInt64NoTag(j4);
        }

        public final void writeUInt64NoTag(long j4) throws IOException {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS || spaceLeft() < 10) {
                while ((j4 & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i4 = this.position;
                    this.position = i4 + 1;
                    bArr[i4] = (byte) ((((int) j4) & ModuleDescriptor.MODULE_VERSION) | 128);
                    j4 >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i5 = this.position;
                    this.position = i5 + 1;
                    bArr2[i5] = (byte) ((int) j4);
                } catch (IndexOutOfBoundsException e5) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), 1}), e5);
                }
            } else {
                while ((j4 & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i6 = this.position;
                    this.position = i6 + 1;
                    UnsafeUtil.putByte(bArr3, (long) i6, (byte) ((((int) j4) & ModuleDescriptor.MODULE_VERSION) | 128));
                    j4 >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i7 = this.position;
                this.position = 1 + i7;
                UnsafeUtil.putByte(bArr4, (long) i7, (byte) ((int) j4));
            }
        }

        public final void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i4, 2);
            writeByteArrayNoTag(bArr, i5, i6);
        }

        public final void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public final void writeMessage(int i4, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        /* access modifiers changed from: package-private */
        public final void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public final void write(byte[] bArr, int i4, int i5) throws IOException {
            try {
                System.arraycopy(bArr, i4, this.buffer, this.position, i5);
                this.position += i5;
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i5)}), e5);
            }
        }

        public final void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.buffer, this.position, remaining);
                this.position += remaining;
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(remaining)}), e5);
            }
        }
    }

    private static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        private final ByteOutput out;

        ByteOutputEncoder(ByteOutput byteOutput, int i4) {
            super(i4);
            if (byteOutput != null) {
                this.out = byteOutput;
                return;
            }
            throw new NullPointerException("out");
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i4) throws IOException {
            if (this.limit - this.position < i4) {
                doFlush();
            }
        }

        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        public void write(byte b5) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b5);
        }

        public void writeBool(int i4, boolean z4) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i4, 0);
            buffer(z4 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i4, byte[] bArr) throws IOException {
            writeByteArray(i4, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i4, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i4, i5);
        }

        public void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i4, ByteString byteString) throws IOException {
            writeTag(i4, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i4, int i5) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i4, 5);
            bufferFixed32NoTag(i5);
        }

        public void writeFixed32NoTag(int i4) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i4);
        }

        public void writeFixed64(int i4, long j4) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i4, 1);
            bufferFixed64NoTag(j4);
        }

        public void writeFixed64NoTag(long j4) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j4);
        }

        public void writeInt32(int i4, int i5) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i4, 0);
            bufferInt32NoTag(i5);
        }

        public void writeInt32NoTag(int i4) throws IOException {
            if (i4 >= 0) {
                writeUInt32NoTag(i4);
            } else {
                writeUInt64NoTag((long) i4);
            }
        }

        public void writeLazy(byte[] bArr, int i4, int i5) throws IOException {
            flush();
            this.out.writeLazy(bArr, i4, i5);
            this.totalBytesWritten += i5;
        }

        public void writeMessage(int i4, MessageLite messageLite) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i4, String str) throws IOException {
            writeTag(i4, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int length = str.length() * 3;
            int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i4 = computeUInt32SizeNoTag + length;
            int i5 = this.limit;
            if (i4 > i5) {
                byte[] bArr = new byte[length];
                int encode = Utf8.encode(str, bArr, 0, length);
                writeUInt32NoTag(encode);
                writeLazy(bArr, 0, encode);
                return;
            }
            if (i4 > i5 - this.position) {
                doFlush();
            }
            int i6 = this.position;
            try {
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i7 = i6 + computeUInt32SizeNoTag2;
                    this.position = i7;
                    int encode2 = Utf8.encode(str, this.buffer, i7, this.limit - i7);
                    this.position = i6;
                    int i8 = (encode2 - i6) - computeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i8);
                    this.position = encode2;
                    this.totalBytesWritten += i8;
                    return;
                }
                int encodedLength = Utf8.encodedLength(str);
                bufferUInt32NoTag(encodedLength);
                this.position = Utf8.encode(str, this.buffer, this.position, encodedLength);
                this.totalBytesWritten += encodedLength;
            } catch (Utf8.UnpairedSurrogateException e5) {
                this.totalBytesWritten -= this.position - i6;
                this.position = i6;
                inefficientWriteStringNoTag(str, e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            }
        }

        public void writeTag(int i4, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i4, i5));
        }

        public void writeUInt32(int i4, int i5) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i4, 0);
            bufferUInt32NoTag(i5);
        }

        public void writeUInt32NoTag(int i4) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i4);
        }

        public void writeUInt64(int i4, long j4) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i4, 0);
            bufferUInt64NoTag(j4);
        }

        public void writeUInt64NoTag(long j4) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j4);
        }

        public void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i4, 2);
            writeByteArrayNoTag(bArr, i5, i6);
        }

        /* access modifiers changed from: package-private */
        public void writeMessage(int i4, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite, schema);
        }

        /* access modifiers changed from: package-private */
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(byte[] bArr, int i4, int i5) throws IOException {
            flush();
            this.out.write(bArr, i4, i5);
            this.totalBytesWritten += i5;
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.writeLazy(byteBuffer);
            this.totalBytesWritten += remaining;
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            flush();
            int remaining = byteBuffer.remaining();
            this.out.write(byteBuffer);
            this.totalBytesWritten += remaining;
        }
    }

    private static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        HeapNioEncoder(ByteBuffer byteBuffer2) {
            super(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), byteBuffer2.remaining());
            this.byteBuffer = byteBuffer2;
            this.initialPosition = byteBuffer2.position();
        }

        public void flush() {
            Java8Compatibility.position(this.byteBuffer, this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        OutputStreamEncoder(OutputStream outputStream, int i4) {
            super(i4);
            if (outputStream != null) {
                this.out = outputStream;
                return;
            }
            throw new NullPointerException("out");
        }

        private void doFlush() throws IOException {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i4) throws IOException {
            if (this.limit - this.position < i4) {
                doFlush();
            }
        }

        public void flush() throws IOException {
            if (this.position > 0) {
                doFlush();
            }
        }

        public void write(byte b5) throws IOException {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b5);
        }

        public void writeBool(int i4, boolean z4) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i4, 0);
            buffer(z4 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i4, byte[] bArr) throws IOException {
            writeByteArray(i4, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i4, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i4, i5);
        }

        public void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i4, ByteString byteString) throws IOException {
            writeTag(i4, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i4, int i5) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i4, 5);
            bufferFixed32NoTag(i5);
        }

        public void writeFixed32NoTag(int i4) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i4);
        }

        public void writeFixed64(int i4, long j4) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i4, 1);
            bufferFixed64NoTag(j4);
        }

        public void writeFixed64NoTag(long j4) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j4);
        }

        public void writeInt32(int i4, int i5) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i4, 0);
            bufferInt32NoTag(i5);
        }

        public void writeInt32NoTag(int i4) throws IOException {
            if (i4 >= 0) {
                writeUInt32NoTag(i4);
            } else {
                writeUInt64NoTag((long) i4);
            }
        }

        public void writeLazy(byte[] bArr, int i4, int i5) throws IOException {
            write(bArr, i4, i5);
        }

        public void writeMessage(int i4, MessageLite messageLite) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i4, String str) throws IOException {
            writeTag(i4, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int i4;
            int i5;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i6 = computeUInt32SizeNoTag + length;
                int i7 = this.limit;
                if (i6 > i7) {
                    byte[] bArr = new byte[length];
                    int encode = Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(encode);
                    writeLazy(bArr, 0, encode);
                    return;
                }
                if (i6 > i7 - this.position) {
                    doFlush();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                i4 = this.position;
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i8 = i4 + computeUInt32SizeNoTag2;
                    this.position = i8;
                    int encode2 = Utf8.encode(str, this.buffer, i8, this.limit - i8);
                    this.position = i4;
                    i5 = (encode2 - i4) - computeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i5);
                    this.position = encode2;
                } else {
                    i5 = Utf8.encodedLength(str);
                    bufferUInt32NoTag(i5);
                    this.position = Utf8.encode(str, this.buffer, this.position, i5);
                }
                this.totalBytesWritten += i5;
            } catch (Utf8.UnpairedSurrogateException e5) {
                this.totalBytesWritten -= this.position - i4;
                this.position = i4;
                throw e5;
            } catch (ArrayIndexOutOfBoundsException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            } catch (Utf8.UnpairedSurrogateException e7) {
                inefficientWriteStringNoTag(str, e7);
            }
        }

        public void writeTag(int i4, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i4, i5));
        }

        public void writeUInt32(int i4, int i5) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i4, 0);
            bufferUInt32NoTag(i5);
        }

        public void writeUInt32NoTag(int i4) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i4);
        }

        public void writeUInt64(int i4, long j4) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i4, 0);
            bufferUInt64NoTag(j4);
        }

        public void writeUInt64NoTag(long j4) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j4);
        }

        public void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i4, 2);
            writeByteArrayNoTag(bArr, i5, i6);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public void writeMessage(int i4, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite, schema);
        }

        /* access modifiers changed from: package-private */
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(byte[] bArr, int i4, int i5) throws IOException {
            int i6 = this.limit;
            int i7 = this.position;
            if (i6 - i7 >= i5) {
                System.arraycopy(bArr, i4, this.buffer, i7, i5);
                this.position += i5;
                this.totalBytesWritten += i5;
                return;
            }
            int i8 = i6 - i7;
            System.arraycopy(bArr, i4, this.buffer, i7, i8);
            int i9 = i4 + i8;
            int i10 = i5 - i8;
            this.position = this.limit;
            this.totalBytesWritten += i8;
            doFlush();
            if (i10 <= this.limit) {
                System.arraycopy(bArr, i9, this.buffer, 0, i10);
                this.position = i10;
            } else {
                this.out.write(bArr, i9, i10);
            }
            this.totalBytesWritten += i10;
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            int remaining = byteBuffer.remaining();
            int i4 = this.limit;
            int i5 = this.position;
            if (i4 - i5 >= remaining) {
                byteBuffer.get(this.buffer, i5, remaining);
                this.position += remaining;
                this.totalBytesWritten += remaining;
                return;
            }
            int i6 = i4 - i5;
            byteBuffer.get(this.buffer, i5, i6);
            int i7 = remaining - i6;
            this.position = this.limit;
            this.totalBytesWritten += i6;
            doFlush();
            while (true) {
                int i8 = this.limit;
                if (i7 > i8) {
                    byteBuffer.get(this.buffer, 0, i8);
                    this.out.write(this.buffer, 0, this.limit);
                    int i9 = this.limit;
                    i7 -= i9;
                    this.totalBytesWritten += i9;
                } else {
                    byteBuffer.get(this.buffer, 0, i7);
                    this.position = i7;
                    this.totalBytesWritten += i7;
                    return;
                }
            }
        }
    }

    private static final class SafeDirectNioEncoder extends CodedOutputStream {
        private final ByteBuffer buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        private void encode(String str) throws IOException {
            try {
                Utf8.encodeUtf8(str, this.buffer);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void flush() {
            Java8Compatibility.position(this.originalBuffer, this.buffer.position());
        }

        public int getTotalBytesWritten() {
            return this.buffer.position() - this.initialPosition;
        }

        public int spaceLeft() {
            return this.buffer.remaining();
        }

        public void write(byte b5) throws IOException {
            try {
                this.buffer.put(b5);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void writeBool(int i4, boolean z4) throws IOException {
            writeTag(i4, 0);
            write(z4 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i4, byte[] bArr) throws IOException {
            writeByteArray(i4, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i4, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i4, i5);
        }

        public void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i4, ByteString byteString) throws IOException {
            writeTag(i4, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i4, int i5) throws IOException {
            writeTag(i4, 5);
            writeFixed32NoTag(i5);
        }

        public void writeFixed32NoTag(int i4) throws IOException {
            try {
                this.buffer.putInt(i4);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void writeFixed64(int i4, long j4) throws IOException {
            writeTag(i4, 1);
            writeFixed64NoTag(j4);
        }

        public void writeFixed64NoTag(long j4) throws IOException {
            try {
                this.buffer.putLong(j4);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void writeInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeInt32NoTag(i5);
        }

        public void writeInt32NoTag(int i4) throws IOException {
            if (i4 >= 0) {
                writeUInt32NoTag(i4);
            } else {
                writeUInt64NoTag((long) i4);
            }
        }

        public void writeLazy(byte[] bArr, int i4, int i5) throws IOException {
            write(bArr, i4, i5);
        }

        public void writeMessage(int i4, MessageLite messageLite) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i4, String str) throws IOException {
            writeTag(i4, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            int position = this.buffer.position();
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int position2 = this.buffer.position() + computeUInt32SizeNoTag2;
                    Java8Compatibility.position(this.buffer, position2);
                    encode(str);
                    int position3 = this.buffer.position();
                    Java8Compatibility.position(this.buffer, position);
                    writeUInt32NoTag(position3 - position2);
                    Java8Compatibility.position(this.buffer, position3);
                    return;
                }
                writeUInt32NoTag(Utf8.encodedLength(str));
                encode(str);
            } catch (Utf8.UnpairedSurrogateException e5) {
                Java8Compatibility.position(this.buffer, position);
                inefficientWriteStringNoTag(str, e5);
            } catch (IllegalArgumentException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            }
        }

        public void writeTag(int i4, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i4, i5));
        }

        public void writeUInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeUInt32NoTag(i5);
        }

        public void writeUInt32NoTag(int i4) throws IOException {
            while ((i4 & -128) != 0) {
                this.buffer.put((byte) ((i4 & ModuleDescriptor.MODULE_VERSION) | 128));
                i4 >>>= 7;
            }
            try {
                this.buffer.put((byte) i4);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void writeUInt64(int i4, long j4) throws IOException {
            writeTag(i4, 0);
            writeUInt64NoTag(j4);
        }

        public void writeUInt64NoTag(long j4) throws IOException {
            while ((-128 & j4) != 0) {
                this.buffer.put((byte) ((((int) j4) & ModuleDescriptor.MODULE_VERSION) | 128));
                j4 >>>= 7;
            }
            try {
                this.buffer.put((byte) ((int) j4));
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }

        public void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i4, 2);
            writeByteArrayNoTag(bArr, i5, i6);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        public void write(byte[] bArr, int i4, int i5) throws IOException {
            try {
                this.buffer.put(bArr, i4, i5);
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            } catch (BufferOverflowException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            }
        }

        /* access modifiers changed from: package-private */
        public void writeMessage(int i4, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite, schema);
        }

        /* access modifiers changed from: package-private */
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                this.buffer.put(byteBuffer);
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }
    }

    private static final class UnsafeDirectNioEncoder extends CodedOutputStream {
        private final long address;
        private final ByteBuffer buffer;
        private final long initialPosition;
        private final long limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.address = addressOffset;
            long position2 = ((long) byteBuffer.position()) + addressOffset;
            this.initialPosition = position2;
            long limit2 = addressOffset + ((long) byteBuffer.limit());
            this.limit = limit2;
            this.oneVarintLimit = limit2 - 10;
            this.position = position2;
        }

        private int bufferPos(long j4) {
            return (int) (j4 - this.address);
        }

        static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long j4) {
            Java8Compatibility.position(this.buffer, bufferPos(j4));
        }

        public void flush() {
            Java8Compatibility.position(this.originalBuffer, bufferPos(this.position));
        }

        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        public int spaceLeft() {
            return (int) (this.limit - this.position);
        }

        public void write(byte b5) throws IOException {
            long j4 = this.position;
            if (j4 < this.limit) {
                this.position = 1 + j4;
                UnsafeUtil.putByte(j4, b5);
                return;
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
        }

        public void writeBool(int i4, boolean z4) throws IOException {
            writeTag(i4, 0);
            write(z4 ? (byte) 1 : 0);
        }

        public void writeByteArray(int i4, byte[] bArr) throws IOException {
            writeByteArray(i4, bArr, 0, bArr.length);
        }

        public void writeByteArrayNoTag(byte[] bArr, int i4, int i5) throws IOException {
            writeUInt32NoTag(i5);
            write(bArr, i4, i5);
        }

        public void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException {
            writeTag(i4, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        public void writeBytes(int i4, ByteString byteString) throws IOException {
            writeTag(i4, 2);
            writeBytesNoTag(byteString);
        }

        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo((ByteOutput) this);
        }

        public void writeFixed32(int i4, int i5) throws IOException {
            writeTag(i4, 5);
            writeFixed32NoTag(i5);
        }

        public void writeFixed32NoTag(int i4) throws IOException {
            this.buffer.putInt(bufferPos(this.position), i4);
            this.position += 4;
        }

        public void writeFixed64(int i4, long j4) throws IOException {
            writeTag(i4, 1);
            writeFixed64NoTag(j4);
        }

        public void writeFixed64NoTag(long j4) throws IOException {
            this.buffer.putLong(bufferPos(this.position), j4);
            this.position += 8;
        }

        public void writeInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeInt32NoTag(i5);
        }

        public void writeInt32NoTag(int i4) throws IOException {
            if (i4 >= 0) {
                writeUInt32NoTag(i4);
            } else {
                writeUInt64NoTag((long) i4);
            }
        }

        public void writeLazy(byte[] bArr, int i4, int i5) throws IOException {
            write(bArr, i4, i5);
        }

        public void writeMessage(int i4, MessageLite messageLite) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite);
        }

        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo((CodedOutputStream) this);
        }

        public void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer duplicate = byteBuffer.duplicate();
            Java8Compatibility.clear(duplicate);
            write(duplicate);
        }

        public void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i4);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        public void writeString(int i4, String str) throws IOException {
            writeTag(i4, 2);
            writeStringNoTag(str);
        }

        public void writeStringNoTag(String str) throws IOException {
            long j4 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int bufferPos = bufferPos(this.position) + computeUInt32SizeNoTag2;
                    Java8Compatibility.position(this.buffer, bufferPos);
                    Utf8.encodeUtf8(str, this.buffer);
                    int position2 = this.buffer.position() - bufferPos;
                    writeUInt32NoTag(position2);
                    this.position += (long) position2;
                    return;
                }
                int encodedLength = Utf8.encodedLength(str);
                writeUInt32NoTag(encodedLength);
                repositionBuffer(this.position);
                Utf8.encodeUtf8(str, this.buffer);
                this.position += (long) encodedLength;
            } catch (Utf8.UnpairedSurrogateException e5) {
                this.position = j4;
                repositionBuffer(j4);
                inefficientWriteStringNoTag(str, e5);
            } catch (IllegalArgumentException e6) {
                throw new OutOfSpaceException((Throwable) e6);
            } catch (IndexOutOfBoundsException e7) {
                throw new OutOfSpaceException((Throwable) e7);
            }
        }

        public void writeTag(int i4, int i5) throws IOException {
            writeUInt32NoTag(WireFormat.makeTag(i4, i5));
        }

        public void writeUInt32(int i4, int i5) throws IOException {
            writeTag(i4, 0);
            writeUInt32NoTag(i5);
        }

        public void writeUInt32NoTag(int i4) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((i4 & -128) != 0) {
                    long j4 = this.position;
                    this.position = j4 + 1;
                    UnsafeUtil.putByte(j4, (byte) ((i4 & ModuleDescriptor.MODULE_VERSION) | 128));
                    i4 >>>= 7;
                }
                long j5 = this.position;
                this.position = 1 + j5;
                UnsafeUtil.putByte(j5, (byte) i4);
                return;
            }
            while (true) {
                long j6 = this.position;
                if (j6 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
                } else if ((i4 & -128) == 0) {
                    this.position = 1 + j6;
                    UnsafeUtil.putByte(j6, (byte) i4);
                    return;
                } else {
                    this.position = j6 + 1;
                    UnsafeUtil.putByte(j6, (byte) ((i4 & ModuleDescriptor.MODULE_VERSION) | 128));
                    i4 >>>= 7;
                }
            }
        }

        public void writeUInt64(int i4, long j4) throws IOException {
            writeTag(i4, 0);
            writeUInt64NoTag(j4);
        }

        public void writeUInt64NoTag(long j4) throws IOException {
            if (this.position <= this.oneVarintLimit) {
                while ((j4 & -128) != 0) {
                    long j5 = this.position;
                    this.position = j5 + 1;
                    UnsafeUtil.putByte(j5, (byte) ((((int) j4) & ModuleDescriptor.MODULE_VERSION) | 128));
                    j4 >>>= 7;
                }
                long j6 = this.position;
                this.position = 1 + j6;
                UnsafeUtil.putByte(j6, (byte) ((int) j4));
                return;
            }
            while (true) {
                long j7 = this.position;
                if (j7 >= this.limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), 1}));
                } else if ((j4 & -128) == 0) {
                    this.position = 1 + j7;
                    UnsafeUtil.putByte(j7, (byte) ((int) j4));
                    return;
                } else {
                    this.position = j7 + 1;
                    UnsafeUtil.putByte(j7, (byte) ((((int) j4) & ModuleDescriptor.MODULE_VERSION) | 128));
                    j4 >>>= 7;
                }
            }
        }

        public void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException {
            writeTag(i4, 2);
            writeByteArrayNoTag(bArr, i5, i6);
        }

        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            write(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public void writeMessage(int i4, MessageLite messageLite, Schema schema) throws IOException {
            writeTag(i4, 2);
            writeMessageNoTag(messageLite, schema);
        }

        /* access modifiers changed from: package-private */
        public void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(byte[] bArr, int i4, int i5) throws IOException {
            if (bArr != null && i4 >= 0 && i5 >= 0 && bArr.length - i5 >= i4) {
                long j4 = (long) i5;
                long j5 = this.position;
                if (this.limit - j4 >= j5) {
                    UnsafeUtil.copyMemory(bArr, (long) i4, j5, j4);
                    this.position += j4;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(this.position), Long.valueOf(this.limit), Integer.valueOf(i5)}));
        }

        public void write(ByteBuffer byteBuffer) throws IOException {
            try {
                int remaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.buffer.put(byteBuffer);
                this.position += (long) remaining;
            } catch (BufferOverflowException e5) {
                throw new OutOfSpaceException((Throwable) e5);
            }
        }
    }

    public static int computeBoolSize(int i4, boolean z4) {
        return computeTagSize(i4) + computeBoolSizeNoTag(z4);
    }

    public static int computeBoolSizeNoTag(boolean z4) {
        return 1;
    }

    public static int computeByteArraySize(int i4, byte[] bArr) {
        return computeTagSize(i4) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSize(int i4, ByteBuffer byteBuffer) {
        return computeTagSize(i4) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i4, ByteString byteString) {
        return computeTagSize(i4) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeDoubleSize(int i4, double d5) {
        return computeTagSize(i4) + computeDoubleSizeNoTag(d5);
    }

    public static int computeDoubleSizeNoTag(double d5) {
        return 8;
    }

    public static int computeEnumSize(int i4, int i5) {
        return computeTagSize(i4) + computeEnumSizeNoTag(i5);
    }

    public static int computeEnumSizeNoTag(int i4) {
        return computeInt32SizeNoTag(i4);
    }

    public static int computeFixed32Size(int i4, int i5) {
        return computeTagSize(i4) + computeFixed32SizeNoTag(i5);
    }

    public static int computeFixed32SizeNoTag(int i4) {
        return 4;
    }

    public static int computeFixed64Size(int i4, long j4) {
        return computeTagSize(i4) + computeFixed64SizeNoTag(j4);
    }

    public static int computeFixed64SizeNoTag(long j4) {
        return 8;
    }

    public static int computeFloatSize(int i4, float f4) {
        return computeTagSize(i4) + computeFloatSizeNoTag(f4);
    }

    public static int computeFloatSizeNoTag(float f4) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i4, MessageLite messageLite) {
        return (computeTagSize(i4) * 2) + messageLite.getSerializedSize();
    }

    @InlineMe(replacement = "value.getSerializedSize()")
    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i4, int i5) {
        return computeTagSize(i4) + computeInt32SizeNoTag(i5);
    }

    public static int computeInt32SizeNoTag(int i4) {
        if (i4 >= 0) {
            return computeUInt32SizeNoTag(i4);
        }
        return 10;
    }

    public static int computeInt64Size(int i4, long j4) {
        return computeTagSize(i4) + computeInt64SizeNoTag(j4);
    }

    public static int computeInt64SizeNoTag(long j4) {
        return computeUInt64SizeNoTag(j4);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i4, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i4) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeLazyFieldSize(int i4, LazyFieldLite lazyFieldLite) {
        return computeTagSize(i4) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    static int computeLengthDelimitedFieldSize(int i4) {
        return computeUInt32SizeNoTag(i4) + i4;
    }

    public static int computeMessageSetExtensionSize(int i4, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i4) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i4, MessageLite messageLite) {
        return computeTagSize(i4) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    static int computePreferredBufferSize(int i4) {
        if (i4 > 4096) {
            return 4096;
        }
        return i4;
    }

    public static int computeRawMessageSetExtensionSize(int i4, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i4) + computeBytesSize(3, byteString);
    }

    @InlineMe(imports = {"androidx.datastore.preferences.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt32SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint32Size(int i4) {
        return computeUInt32SizeNoTag(i4);
    }

    @InlineMe(imports = {"androidx.datastore.preferences.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt64SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint64Size(long j4) {
        return computeUInt64SizeNoTag(j4);
    }

    public static int computeSFixed32Size(int i4, int i5) {
        return computeTagSize(i4) + computeSFixed32SizeNoTag(i5);
    }

    public static int computeSFixed32SizeNoTag(int i4) {
        return 4;
    }

    public static int computeSFixed64Size(int i4, long j4) {
        return computeTagSize(i4) + computeSFixed64SizeNoTag(j4);
    }

    public static int computeSFixed64SizeNoTag(long j4) {
        return 8;
    }

    public static int computeSInt32Size(int i4, int i5) {
        return computeTagSize(i4) + computeSInt32SizeNoTag(i5);
    }

    public static int computeSInt32SizeNoTag(int i4) {
        return computeUInt32SizeNoTag(encodeZigZag32(i4));
    }

    public static int computeSInt64Size(int i4, long j4) {
        return computeTagSize(i4) + computeSInt64SizeNoTag(j4);
    }

    public static int computeSInt64SizeNoTag(long j4) {
        return computeUInt64SizeNoTag(encodeZigZag64(j4));
    }

    public static int computeStringSize(int i4, String str) {
        return computeTagSize(i4) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int i4;
        try {
            i4 = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            i4 = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(i4);
    }

    public static int computeTagSize(int i4) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i4, 0));
    }

    public static int computeUInt32Size(int i4, int i5) {
        return computeTagSize(i4) + computeUInt32SizeNoTag(i5);
    }

    public static int computeUInt32SizeNoTag(int i4) {
        if ((i4 & -128) == 0) {
            return 1;
        }
        if ((i4 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i4) == 0) {
            return 3;
        }
        return (i4 & -268435456) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i4, long j4) {
        return computeTagSize(i4) + computeUInt64SizeNoTag(j4);
    }

    public static int computeUInt64SizeNoTag(long j4) {
        int i4;
        if ((-128 & j4) == 0) {
            return 1;
        }
        if (j4 < 0) {
            return 10;
        }
        if ((-34359738368L & j4) != 0) {
            j4 >>>= 28;
            i4 = 6;
        } else {
            i4 = 2;
        }
        if ((-2097152 & j4) != 0) {
            i4 += 2;
            j4 >>>= 14;
        }
        return (j4 & -16384) != 0 ? i4 + 1 : i4;
    }

    public static int encodeZigZag32(int i4) {
        return (i4 >> 31) ^ (i4 << 1);
    }

    public static long encodeZigZag64(long j4) {
        return (j4 >> 63) ^ (j4 << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public abstract void flush() throws IOException;

    public abstract int getTotalBytesWritten();

    /* access modifiers changed from: package-private */
    public final void inefficientWriteStringNoTag(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws IOException {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e5) {
            throw new OutOfSpaceException((Throwable) e5);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    public abstract void write(byte b5) throws IOException;

    public abstract void write(ByteBuffer byteBuffer) throws IOException;

    public abstract void write(byte[] bArr, int i4, int i5) throws IOException;

    public abstract void writeBool(int i4, boolean z4) throws IOException;

    public final void writeBoolNoTag(boolean z4) throws IOException {
        write(z4 ? (byte) 1 : 0);
    }

    public abstract void writeByteArray(int i4, byte[] bArr) throws IOException;

    public abstract void writeByteArray(int i4, byte[] bArr, int i5, int i6) throws IOException;

    public final void writeByteArrayNoTag(byte[] bArr) throws IOException {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: package-private */
    public abstract void writeByteArrayNoTag(byte[] bArr, int i4, int i5) throws IOException;

    public abstract void writeByteBuffer(int i4, ByteBuffer byteBuffer) throws IOException;

    public abstract void writeBytes(int i4, ByteString byteString) throws IOException;

    public abstract void writeBytesNoTag(ByteString byteString) throws IOException;

    public final void writeDouble(int i4, double d5) throws IOException {
        writeFixed64(i4, Double.doubleToRawLongBits(d5));
    }

    public final void writeDoubleNoTag(double d5) throws IOException {
        writeFixed64NoTag(Double.doubleToRawLongBits(d5));
    }

    public final void writeEnum(int i4, int i5) throws IOException {
        writeInt32(i4, i5);
    }

    public final void writeEnumNoTag(int i4) throws IOException {
        writeInt32NoTag(i4);
    }

    public abstract void writeFixed32(int i4, int i5) throws IOException;

    public abstract void writeFixed32NoTag(int i4) throws IOException;

    public abstract void writeFixed64(int i4, long j4) throws IOException;

    public abstract void writeFixed64NoTag(long j4) throws IOException;

    public final void writeFloat(int i4, float f4) throws IOException {
        writeFixed32(i4, Float.floatToRawIntBits(f4));
    }

    public final void writeFloatNoTag(float f4) throws IOException {
        writeFixed32NoTag(Float.floatToRawIntBits(f4));
    }

    @Deprecated
    public final void writeGroup(int i4, MessageLite messageLite) throws IOException {
        writeTag(i4, 3);
        writeGroupNoTag(messageLite);
        writeTag(i4, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) throws IOException {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i4, int i5) throws IOException;

    public abstract void writeInt32NoTag(int i4) throws IOException;

    public final void writeInt64(int i4, long j4) throws IOException {
        writeUInt64(i4, j4);
    }

    public final void writeInt64NoTag(long j4) throws IOException {
        writeUInt64NoTag(j4);
    }

    public abstract void writeLazy(ByteBuffer byteBuffer) throws IOException;

    public abstract void writeLazy(byte[] bArr, int i4, int i5) throws IOException;

    public abstract void writeMessage(int i4, MessageLite messageLite) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeMessage(int i4, MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageNoTag(MessageLite messageLite) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeMessageNoTag(MessageLite messageLite, Schema schema) throws IOException;

    public abstract void writeMessageSetExtension(int i4, MessageLite messageLite) throws IOException;

    public final void writeRawByte(byte b5) throws IOException {
        write(b5);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer) throws IOException;

    public final void writeRawBytes(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @InlineMe(replacement = "this.writeFixed32NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian32(int i4) throws IOException {
        writeFixed32NoTag(i4);
    }

    @InlineMe(replacement = "this.writeFixed64NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian64(long j4) throws IOException {
        writeFixed64NoTag(j4);
    }

    public abstract void writeRawMessageSetExtension(int i4, ByteString byteString) throws IOException;

    @InlineMe(replacement = "this.writeUInt32NoTag(value)")
    @Deprecated
    public final void writeRawVarint32(int i4) throws IOException {
        writeUInt32NoTag(i4);
    }

    @InlineMe(replacement = "this.writeUInt64NoTag(value)")
    @Deprecated
    public final void writeRawVarint64(long j4) throws IOException {
        writeUInt64NoTag(j4);
    }

    public final void writeSFixed32(int i4, int i5) throws IOException {
        writeFixed32(i4, i5);
    }

    public final void writeSFixed32NoTag(int i4) throws IOException {
        writeFixed32NoTag(i4);
    }

    public final void writeSFixed64(int i4, long j4) throws IOException {
        writeFixed64(i4, j4);
    }

    public final void writeSFixed64NoTag(long j4) throws IOException {
        writeFixed64NoTag(j4);
    }

    public final void writeSInt32(int i4, int i5) throws IOException {
        writeUInt32(i4, encodeZigZag32(i5));
    }

    public final void writeSInt32NoTag(int i4) throws IOException {
        writeUInt32NoTag(encodeZigZag32(i4));
    }

    public final void writeSInt64(int i4, long j4) throws IOException {
        writeUInt64(i4, encodeZigZag64(j4));
    }

    public final void writeSInt64NoTag(long j4) throws IOException {
        writeUInt64NoTag(encodeZigZag64(j4));
    }

    public abstract void writeString(int i4, String str) throws IOException;

    public abstract void writeStringNoTag(String str) throws IOException;

    public abstract void writeTag(int i4, int i5) throws IOException;

    public abstract void writeUInt32(int i4, int i5) throws IOException;

    public abstract void writeUInt32NoTag(int i4) throws IOException;

    public abstract void writeUInt64(int i4, long j4) throws IOException;

    public abstract void writeUInt64NoTag(long j4) throws IOException;

    private CodedOutputStream() {
    }

    @Deprecated
    static int computeGroupSize(int i4, MessageLite messageLite, Schema schema) {
        return (computeTagSize(i4) * 2) + computeGroupSizeNoTag(messageLite, schema);
    }

    @Deprecated
    static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    static int computeMessageSize(int i4, MessageLite messageLite, Schema schema) {
        return computeTagSize(i4) + computeMessageSizeNoTag(messageLite, schema);
    }

    static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i4) {
        return new OutputStreamEncoder(outputStream, i4);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite, Schema schema) throws IOException {
        schema.writeTo(messageLite, this.wrapper);
    }

    public final void writeRawByte(int i4) throws IOException {
        write((byte) i4);
    }

    public final void writeRawBytes(byte[] bArr, int i4, int i5) throws IOException {
        write(bArr, i4, i5);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) throws IOException {
        byteString.writeTo((ByteOutput) this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i4, int i5) {
        return new ArrayEncoder(bArr, i4, i5);
    }

    /* access modifiers changed from: package-private */
    @Deprecated
    public final void writeGroup(int i4, MessageLite messageLite, Schema schema) throws IOException {
        writeTag(i4, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(i4, 4);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (!byteBuffer.isDirect() || byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("ByteBuffer is read-only");
        } else if (UnsafeDirectNioEncoder.isSupported()) {
            return newUnsafeInstance(byteBuffer);
        } else {
            return newSafeInstance(byteBuffer);
        }
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i4) {
        return newInstance(byteBuffer);
    }

    static CodedOutputStream newInstance(ByteOutput byteOutput, int i4) {
        if (i4 >= 0) {
            return new ByteOutputEncoder(byteOutput, i4);
        }
        throw new IllegalArgumentException("bufferSize must be positive");
    }
}
