package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class NioByteString extends ByteString.LeafByteString {
    /* access modifiers changed from: private */
    public final ByteBuffer buffer;

    NioByteString(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private ByteBuffer slice(int i4, int i5) {
        if (i4 < this.buffer.position() || i5 > this.buffer.limit() || i4 > i5) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)}));
        }
        ByteBuffer slice = this.buffer.slice();
        Java8Compatibility.position(slice, i4 - this.buffer.position());
        Java8Compatibility.limit(slice, i5 - this.buffer.position());
        return slice;
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    public byte byteAt(int i4) {
        try {
            return this.buffer.get(i4);
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw e5;
        } catch (IndexOutOfBoundsException e6) {
            throw new ArrayIndexOutOfBoundsException(e6.getMessage());
        }
    }

    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    /* access modifiers changed from: protected */
    public void copyToInternal(byte[] bArr, int i4, int i5, int i6) {
        ByteBuffer slice = this.buffer.slice();
        Java8Compatibility.position(slice, i4);
        slice.get(bArr, i5, i6);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    /* access modifiers changed from: package-private */
    public boolean equalsRange(ByteString byteString, int i4, int i5) {
        return substring(0, i5).equals(byteString.substring(i4, i5 + i4));
    }

    public byte internalByteAt(int i4) {
        return byteAt(i4);
    }

    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    public InputStream newInput() {
        return new InputStream() {
            private final ByteBuffer buf;

            {
                this.buf = NioByteString.this.buffer.slice();
            }

            public int available() throws IOException {
                return this.buf.remaining();
            }

            public void mark(int i4) {
                Java8Compatibility.mark(this.buf);
            }

            public boolean markSupported() {
                return true;
            }

            public int read() throws IOException {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                return this.buf.get() & 255;
            }

            public void reset() throws IOException {
                try {
                    Java8Compatibility.reset(this.buf);
                } catch (InvalidMarkException e5) {
                    throw new IOException(e5);
                }
            }

            public int read(byte[] bArr, int i4, int i5) throws IOException {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i5, this.buf.remaining());
                this.buf.get(bArr, i4, min);
                return min;
            }
        };
    }

    /* access modifiers changed from: protected */
    public int partialHash(int i4, int i5, int i6) {
        for (int i7 = i5; i7 < i5 + i6; i7++) {
            i4 = (i4 * 31) + this.buffer.get(i7);
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public int partialIsValidUtf8(int i4, int i5, int i6) {
        return Utf8.partialIsValidUtf8(i4, this.buffer, i5, i6 + i5);
    }

    public int size() {
        return this.buffer.remaining();
    }

    public ByteString substring(int i4, int i5) {
        try {
            return new NioByteString(slice(i4, i5));
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw e5;
        } catch (IndexOutOfBoundsException e6) {
            throw new ArrayIndexOutOfBoundsException(e6.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public String toStringInternal(Charset charset) {
        int i4;
        int i5;
        byte[] bArr;
        if (this.buffer.hasArray()) {
            bArr = this.buffer.array();
            i5 = this.buffer.arrayOffset() + this.buffer.position();
            i4 = this.buffer.remaining();
        } else {
            bArr = toByteArray();
            i4 = bArr.length;
            i5 = 0;
        }
        return new String(bArr, i5, i4, charset);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    /* access modifiers changed from: package-private */
    public void writeToInternal(OutputStream outputStream, int i4, int i5) throws IOException {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + this.buffer.position() + i4, i5);
            return;
        }
        ByteBufferWriter.write(slice(i4, i5 + i4), outputStream);
    }

    /* access modifiers changed from: package-private */
    public void writeTo(ByteOutput byteOutput) throws IOException {
        byteOutput.writeLazy(this.buffer.slice());
    }
}
