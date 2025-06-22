package androidx.datastore.preferences.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

@CheckReturnValue
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() {
        public int compare(ByteString byteString, ByteString byteString2) {
            ByteIterator it = byteString.iterator();
            ByteIterator it2 = byteString2.iterator();
            while (it.hasNext() && it2.hasNext()) {
                int compareTo = Integer.valueOf(ByteString.toInt(it.nextByte())).compareTo(Integer.valueOf(ByteString.toInt(it2.nextByte())));
                if (compareTo != 0) {
                    return compareTo;
                }
            }
            return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
        }
    };
    private static final ByteArrayCopier byteArrayCopier;
    private static final long serialVersionUID = 1;
    private int hash = 0;

    static abstract class AbstractByteIterator implements ByteIterator {
        AbstractByteIterator() {
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }

        public final Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        public byte[] copyFrom(byte[] bArr, int i4, int i5) {
            return Arrays.copyOfRange(bArr, i4, i5 + i4);
        }
    }

    private static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bArr, int i4, int i5) {
            super(bArr);
            ByteString.checkRange(i4, i4 + i5, bArr.length);
            this.bytesOffset = i4;
            this.bytesLength = i5;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        public byte byteAt(int i4) {
            ByteString.checkIndex(i4, size());
            return this.bytes[this.bytesOffset + i4];
        }

        /* access modifiers changed from: protected */
        public void copyToInternal(byte[] bArr, int i4, int i5, int i6) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i4, bArr, i5, i6);
        }

        /* access modifiers changed from: protected */
        public int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        /* access modifiers changed from: package-private */
        public byte internalByteAt(int i4) {
            return this.bytes[this.bytesOffset + i4];
        }

        public int size() {
            return this.bytesLength;
        }

        /* access modifiers changed from: package-private */
        public Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    private interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i4, int i5);
    }

    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    static final class CodedBuilder {
        private final byte[] buffer;
        private final CodedOutputStream output;

        public ByteString build() {
            this.output.checkNoSpaceLeft();
            return new LiteralByteString(this.buffer);
        }

        public CodedOutputStream getCodedOutput() {
            return this.output;
        }

        private CodedBuilder(int i4) {
            byte[] bArr = new byte[i4];
            this.buffer = bArr;
            this.output = CodedOutputStream.newInstance(bArr);
        }
    }

    static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        LeafByteString() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean equalsRange(ByteString byteString, int i4, int i5);

        /* access modifiers changed from: protected */
        public final int getTreeDepth() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public final boolean isBalanced() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public void writeToReverse(ByteOutput byteOutput) throws IOException {
            writeTo(byteOutput);
        }
    }

    private static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bArr) {
            bArr.getClass();
            this.bytes = bArr;
        }

        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, getOffsetIntoBytes(), size()).asReadOnlyBuffer();
        }

        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        public byte byteAt(int i4) {
            return this.bytes[i4];
        }

        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, getOffsetIntoBytes(), size());
        }

        /* access modifiers changed from: protected */
        public void copyToInternal(byte[] bArr, int i4, int i5, int i6) {
            System.arraycopy(this.bytes, i4, bArr, i5, i6);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int peekCachedHashCode = peekCachedHashCode();
            int peekCachedHashCode2 = literalByteString.peekCachedHashCode();
            if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
                return equalsRange(literalByteString, 0, size());
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean equalsRange(ByteString byteString, int i4, int i5) {
            if (i5 <= byteString.size()) {
                int i6 = i4 + i5;
                if (i6 > byteString.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i4 + ", " + i5 + ", " + byteString.size());
                } else if (!(byteString instanceof LiteralByteString)) {
                    return byteString.substring(i4, i6).equals(substring(0, i5));
                } else {
                    LiteralByteString literalByteString = (LiteralByteString) byteString;
                    byte[] bArr = this.bytes;
                    byte[] bArr2 = literalByteString.bytes;
                    int offsetIntoBytes = getOffsetIntoBytes() + i5;
                    int offsetIntoBytes2 = getOffsetIntoBytes();
                    int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i4;
                    while (offsetIntoBytes2 < offsetIntoBytes) {
                        if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                            return false;
                        }
                        offsetIntoBytes2++;
                        offsetIntoBytes3++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i5 + size());
            }
        }

        /* access modifiers changed from: protected */
        public int getOffsetIntoBytes() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public byte internalByteAt(int i4) {
            return this.bytes[i4];
        }

        public final boolean isValidUtf8() {
            int offsetIntoBytes = getOffsetIntoBytes();
            return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
        }

        public final CodedInputStream newCodedInput() {
            return CodedInputStream.newInstance(this.bytes, getOffsetIntoBytes(), size(), true);
        }

        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, getOffsetIntoBytes(), size());
        }

        /* access modifiers changed from: protected */
        public final int partialHash(int i4, int i5, int i6) {
            return Internal.partialHash(i4, this.bytes, getOffsetIntoBytes() + i5, i6);
        }

        /* access modifiers changed from: protected */
        public final int partialIsValidUtf8(int i4, int i5, int i6) {
            int offsetIntoBytes = getOffsetIntoBytes() + i5;
            return Utf8.partialIsValidUtf8(i4, this.bytes, offsetIntoBytes, i6 + offsetIntoBytes);
        }

        public int size() {
            return this.bytes.length;
        }

        public final ByteString substring(int i4, int i5) {
            int checkRange = ByteString.checkRange(i4, i5, size());
            if (checkRange == 0) {
                return ByteString.EMPTY;
            }
            return new BoundedByteString(this.bytes, getOffsetIntoBytes() + i4, checkRange);
        }

        /* access modifiers changed from: protected */
        public final String toStringInternal(Charset charset) {
            return new String(this.bytes, getOffsetIntoBytes(), size(), charset);
        }

        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }

        /* access modifiers changed from: package-private */
        public final void writeToInternal(OutputStream outputStream, int i4, int i5) throws IOException {
            outputStream.write(this.bytes, getOffsetIntoBytes() + i4, i5);
        }

        /* access modifiers changed from: package-private */
        public final void writeTo(ByteOutput byteOutput) throws IOException {
            byteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        public byte[] copyFrom(byte[] bArr, int i4, int i5) {
            byte[] bArr2 = new byte[i5];
            System.arraycopy(bArr, i4, bArr2, 0, i5);
            return bArr2;
        }
    }

    static {
        ByteArrayCopier byteArrayCopier2;
        if (Android.isOnAndroidDevice()) {
            byteArrayCopier2 = new SystemByteArrayCopier();
        } else {
            byteArrayCopier2 = new ArraysByteArrayCopier();
        }
        byteArrayCopier = byteArrayCopier2;
    }

    ByteString() {
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i4) {
        if (i4 < 1) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i4)}));
        } else if (i4 == 1) {
            return it.next();
        } else {
            int i5 = i4 >>> 1;
            return balancedConcat(it, i5).concat(balancedConcat(it, i4 - i5));
        }
    }

    static void checkIndex(int i4, int i5) {
        if (((i5 - (i4 + 1)) | i4) >= 0) {
            return;
        }
        if (i4 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i4);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i4 + ", " + i5);
    }

    @CanIgnoreReturnValue
    static int checkRange(int i4, int i5, int i6) {
        int i7 = i5 - i4;
        if ((i4 | i5 | i7 | (i6 - i5)) >= 0) {
            return i7;
        }
        if (i4 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i4 + " < 0");
        } else if (i5 < i4) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i4 + ", " + i5);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i5 + " >= " + i6);
        }
    }

    public static ByteString copyFrom(byte[] bArr, int i4, int i5) {
        checkRange(i4, i4 + i5, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, i4, i5));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(Internal.UTF_8));
    }

    public static final ByteString empty() {
        return EMPTY;
    }

    private static int extractHexDigit(String str, int i4) {
        int hexDigit = hexDigit(str.charAt(i4));
        if (hexDigit != -1) {
            return hexDigit;
        }
        throw new NumberFormatException("Invalid hexString " + str + " must only contain [0-9a-fA-F] but contained " + str.charAt(i4) + " at index " + i4);
    }

    public static ByteString fromHex(@CompileTimeConstant String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = i4 * 2;
                bArr[i4] = (byte) (extractHexDigit(str, i5 + 1) | (extractHexDigit(str, i5) << 4));
            }
            return new LiteralByteString(bArr);
        }
        throw new NumberFormatException("Invalid hexString " + str + " of length " + str.length() + " must be even.");
    }

    private static int hexDigit(char c5) {
        if (c5 >= '0' && c5 <= '9') {
            return c5 - '0';
        }
        if (c5 >= 'A' && c5 <= 'F') {
            return c5 - '7';
        }
        if (c5 < 'a' || c5 > 'f') {
            return -1;
        }
        return c5 - 'W';
    }

    static CodedBuilder newCodedBuilder(int i4) {
        return new CodedBuilder(i4);
    }

    public static Output newOutput(int i4) {
        return new Output(i4);
    }

    private static ByteString readChunk(InputStream inputStream, int i4) throws IOException {
        byte[] bArr = new byte[i4];
        int i5 = 0;
        while (i5 < i4) {
            int read = inputStream.read(bArr, i5, i4 - i5);
            if (read == -1) {
                break;
            }
            i5 += read;
        }
        if (i5 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i5);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    /* access modifiers changed from: private */
    public static int toInt(byte b5) {
        return b5 & 255;
    }

    private String truncateAndEscapeForDisplay() {
        if (size() <= 50) {
            return TextFormatEscaper.escapeBytes(this);
        }
        return TextFormatEscaper.escapeBytes(substring(0, 47)) + "...";
    }

    public static Comparator<ByteString> unsignedLexicographicalComparator() {
        return UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    }

    static ByteString wrap(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasArray()) {
            return new NioByteString(byteBuffer);
        }
        return wrap(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i4);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return RopeByteString.concatenate(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i4) {
        copyTo(bArr, 0, i4, size());
    }

    /* access modifiers changed from: protected */
    public abstract void copyToInternal(byte[] bArr, int i4, int i5, int i6);

    public final boolean endsWith(ByteString byteString) {
        if (size() < byteString.size() || !substring(size() - byteString.size()).equals(byteString)) {
            return false;
        }
        return true;
    }

    public abstract boolean equals(Object obj);

    /* access modifiers changed from: protected */
    public abstract int getTreeDepth();

    public final int hashCode() {
        int i4 = this.hash;
        if (i4 == 0) {
            int size = size();
            i4 = partialHash(size, 0, size);
            if (i4 == 0) {
                i4 = 1;
            }
            this.hash = i4;
        }
        return i4;
    }

    /* access modifiers changed from: package-private */
    public abstract byte internalByteAt(int i4);

    /* access modifiers changed from: protected */
    public abstract boolean isBalanced();

    public final boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public abstract boolean isValidUtf8();

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    /* access modifiers changed from: protected */
    public abstract int partialHash(int i4, int i5, int i6);

    /* access modifiers changed from: protected */
    public abstract int partialIsValidUtf8(int i4, int i5, int i6);

    /* access modifiers changed from: protected */
    public final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        if (size() < byteString.size() || !substring(0, byteString.size()).equals(byteString)) {
            return false;
        }
        return true;
    }

    public final ByteString substring(int i4) {
        return substring(i4, size());
    }

    public abstract ByteString substring(int i4, int i5);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e5) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e5);
            throw unsupportedEncodingException;
        }
    }

    /* access modifiers changed from: protected */
    public abstract String toStringInternal(Charset charset);

    public final String toStringUtf8() {
        return toString(Internal.UTF_8);
    }

    /* access modifiers changed from: package-private */
    public abstract void writeTo(ByteOutput byteOutput) throws IOException;

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    /* access modifiers changed from: package-private */
    public final void writeTo(OutputStream outputStream, int i4, int i5) throws IOException {
        checkRange(i4, i4 + i5, size());
        if (i5 > 0) {
            writeToInternal(outputStream, i4, i5);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void writeToInternal(OutputStream outputStream, int i4, int i5) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void writeToReverse(ByteOutput byteOutput) throws IOException;

    public static Output newOutput() {
        return new Output(128);
    }

    public static ByteString readFrom(InputStream inputStream, int i4) throws IOException {
        return readFrom(inputStream, i4, i4);
    }

    @Deprecated
    public final void copyTo(byte[] bArr, int i4, int i5, int i6) {
        checkRange(i4, i4 + i6, size());
        checkRange(i5, i5 + i6, bArr.length);
        if (i6 > 0) {
            copyToInternal(bArr, i4, i5, i6);
        }
    }

    public ByteIterator iterator() {
        return new AbstractByteIterator() {
            private final int limit;
            private int position = 0;

            {
                this.limit = ByteString.this.size();
            }

            public boolean hasNext() {
                if (this.position < this.limit) {
                    return true;
                }
                return false;
            }

            public byte nextByte() {
                int i4 = this.position;
                if (i4 < this.limit) {
                    this.position = i4 + 1;
                    return ByteString.this.internalByteAt(i4);
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString readFrom(InputStream inputStream, int i4, int i5) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString readChunk = readChunk(inputStream, i4);
            if (readChunk == null) {
                return copyFrom((Iterable<ByteString>) arrayList);
            }
            arrayList.add(readChunk);
            i4 = Math.min(i4 * 2, i5);
        }
    }

    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        Output(int i4) {
            if (i4 >= 0) {
                this.initialCapacity = i4;
                this.flushedBuffers = new ArrayList<>();
                this.buffer = new byte[i4];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private void flushFullBuffer(int i4) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i4, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i4 = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i4 >= bArr.length) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (i4 > 0) {
                this.flushedBuffers.add(new LiteralByteString(Arrays.copyOf(bArr, i4)));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }

        public synchronized void reset() {
            this.flushedBuffers.clear();
            this.flushedBuffersTotalBytes = 0;
            this.bufferPos = 0;
        }

        public synchronized int size() {
            return this.flushedBuffersTotalBytes + this.bufferPos;
        }

        public synchronized ByteString toByteString() {
            flushLastBuffer();
            return ByteString.copyFrom((Iterable<ByteString>) this.flushedBuffers);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        public synchronized void write(int i4) {
            try {
                if (this.bufferPos == this.buffer.length) {
                    flushFullBuffer(1);
                }
                byte[] bArr = this.buffer;
                int i5 = this.bufferPos;
                this.bufferPos = i5 + 1;
                bArr[i5] = (byte) i4;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            int i4;
            ByteString[] byteStringArr;
            byte[] bArr;
            int i5;
            synchronized (this) {
                byteStringArr = (ByteString[]) this.flushedBuffers.toArray(new ByteString[0]);
                bArr = this.buffer;
                i5 = this.bufferPos;
            }
            for (ByteString writeTo : byteStringArr) {
                writeTo.writeTo(outputStream);
            }
            outputStream.write(Arrays.copyOf(bArr, i5));
        }

        public synchronized void write(byte[] bArr, int i4, int i5) {
            try {
                byte[] bArr2 = this.buffer;
                int length = bArr2.length;
                int i6 = this.bufferPos;
                if (i5 <= length - i6) {
                    System.arraycopy(bArr, i4, bArr2, i6, i5);
                    this.bufferPos += i5;
                } else {
                    int length2 = bArr2.length - i6;
                    System.arraycopy(bArr, i4, bArr2, i6, length2);
                    int i7 = i5 - length2;
                    flushFullBuffer(i7);
                    System.arraycopy(bArr, i4 + length2, this.buffer, 0, i7);
                    this.bufferPos = i7;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i4) {
        checkRange(0, i4, byteBuffer.remaining());
        byte[] bArr = new byte[i4];
        byteBuffer.get(bArr);
        return new LiteralByteString(bArr);
    }

    static ByteString wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : toStringInternal(charset);
    }

    static ByteString wrap(byte[] bArr, int i4, int i5) {
        return new BoundedByteString(bArr, i4, i5);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay()});
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new LiteralByteString(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new LiteralByteString(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int i4;
        if (!(iterable instanceof Collection)) {
            Iterator<ByteString> it = iterable.iterator();
            i4 = 0;
            while (it.hasNext()) {
                it.next();
                i4++;
            }
        } else {
            i4 = ((Collection) iterable).size();
        }
        if (i4 == 0) {
            return EMPTY;
        }
        return balancedConcat(iterable.iterator(), i4);
    }
}
