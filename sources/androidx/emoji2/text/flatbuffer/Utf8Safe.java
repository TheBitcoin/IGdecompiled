package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.Utf8;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import java.nio.ByteBuffer;

public final class Utf8Safe extends Utf8 {

    static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i4, int i5) {
            super("Unpaired surrogate at index " + i4 + " of " + i5);
        }
    }

    private static int computeEncodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length && charSequence.charAt(i4) < 128) {
            i4++;
        }
        int i5 = length;
        while (true) {
            if (i4 < length) {
                char charAt = charSequence.charAt(i4);
                if (charAt >= 2048) {
                    i5 += encodedLengthGeneral(charSequence, i4);
                    break;
                }
                i5 += (127 - charAt) >>> 31;
                i4++;
            } else {
                break;
            }
        }
        if (i5 >= length) {
            return i5;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i5) + 4294967296L));
    }

    public static String decodeUtf8Array(byte[] bArr, int i4, int i5) {
        if ((i4 | i5 | ((bArr.length - i4) - i5)) >= 0) {
            int i6 = i4 + i5;
            char[] cArr = new char[i5];
            int i7 = 0;
            while (r12 < i6) {
                byte b5 = bArr[r12];
                if (!Utf8.DecodeUtil.isOneByte(b5)) {
                    break;
                }
                i4 = r12 + 1;
                Utf8.DecodeUtil.handleOneByte(b5, cArr, i7);
                i7++;
            }
            int i8 = i7;
            while (r12 < i6) {
                int i9 = r12 + 1;
                byte b6 = bArr[r12];
                if (Utf8.DecodeUtil.isOneByte(b6)) {
                    int i10 = i8 + 1;
                    Utf8.DecodeUtil.handleOneByte(b6, cArr, i8);
                    while (i9 < i6) {
                        byte b7 = bArr[i9];
                        if (!Utf8.DecodeUtil.isOneByte(b7)) {
                            break;
                        }
                        i9++;
                        Utf8.DecodeUtil.handleOneByte(b7, cArr, i10);
                        i10++;
                    }
                    i8 = i10;
                    r12 = i9;
                } else if (Utf8.DecodeUtil.isTwoBytes(b6)) {
                    if (i9 < i6) {
                        r12 += 2;
                        Utf8.DecodeUtil.handleTwoBytes(b6, bArr[i9], cArr, i8);
                        i8++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.DecodeUtil.isThreeBytes(b6)) {
                    if (i9 < i6 - 1) {
                        int i11 = r12 + 2;
                        r12 += 3;
                        Utf8.DecodeUtil.handleThreeBytes(b6, bArr[i9], bArr[i11], cArr, i8);
                        i8++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i9 < i6 - 2) {
                    byte b8 = bArr[i9];
                    int i12 = r12 + 3;
                    byte b9 = bArr[r12 + 2];
                    r12 += 4;
                    byte b10 = bArr[i12];
                    Utf8.DecodeUtil.handleFourBytes(b6, b8, b9, b10, cArr, i8);
                    i8 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i8);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)}));
    }

    public static String decodeUtf8Buffer(ByteBuffer byteBuffer, int i4, int i5) {
        if ((i4 | i5 | ((byteBuffer.limit() - i4) - i5)) >= 0) {
            int i6 = i4 + i5;
            char[] cArr = new char[i5];
            int i7 = 0;
            while (r12 < i6) {
                byte b5 = byteBuffer.get(r12);
                if (!Utf8.DecodeUtil.isOneByte(b5)) {
                    break;
                }
                i4 = r12 + 1;
                Utf8.DecodeUtil.handleOneByte(b5, cArr, i7);
                i7++;
            }
            int i8 = i7;
            while (r12 < i6) {
                int i9 = r12 + 1;
                byte b6 = byteBuffer.get(r12);
                if (Utf8.DecodeUtil.isOneByte(b6)) {
                    int i10 = i8 + 1;
                    Utf8.DecodeUtil.handleOneByte(b6, cArr, i8);
                    while (i9 < i6) {
                        byte b7 = byteBuffer.get(i9);
                        if (!Utf8.DecodeUtil.isOneByte(b7)) {
                            break;
                        }
                        i9++;
                        Utf8.DecodeUtil.handleOneByte(b7, cArr, i10);
                        i10++;
                    }
                    i8 = i10;
                    r12 = i9;
                } else if (Utf8.DecodeUtil.isTwoBytes(b6)) {
                    if (i9 < i6) {
                        r12 += 2;
                        Utf8.DecodeUtil.handleTwoBytes(b6, byteBuffer.get(i9), cArr, i8);
                        i8++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (Utf8.DecodeUtil.isThreeBytes(b6)) {
                    if (i9 < i6 - 1) {
                        int i11 = r12 + 2;
                        r12 += 3;
                        Utf8.DecodeUtil.handleThreeBytes(b6, byteBuffer.get(i9), byteBuffer.get(i11), cArr, i8);
                        i8++;
                    } else {
                        throw new IllegalArgumentException("Invalid UTF-8");
                    }
                } else if (i9 < i6 - 2) {
                    byte b8 = byteBuffer.get(i9);
                    int i12 = r12 + 3;
                    byte b9 = byteBuffer.get(r12 + 2);
                    r12 += 4;
                    byte b10 = byteBuffer.get(i12);
                    Utf8.DecodeUtil.handleFourBytes(b6, b8, b9, b10, cArr, i8);
                    i8 += 2;
                } else {
                    throw new IllegalArgumentException("Invalid UTF-8");
                }
            }
            return new String(cArr, 0, i8);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i4), Integer.valueOf(i5)}));
    }

    private static int encodeUtf8Array(CharSequence charSequence, byte[] bArr, int i4, int i5) {
        int i6;
        int i7;
        char charAt;
        int length = charSequence.length();
        int i8 = i5 + i4;
        int i9 = 0;
        while (i9 < length && (i7 = i9 + i4) < i8 && (charAt = charSequence.charAt(i9)) < 128) {
            bArr[i7] = (byte) charAt;
            i9++;
        }
        if (i9 == length) {
            return i4 + length;
        }
        int i10 = i4 + i9;
        while (i9 < length) {
            char charAt2 = charSequence.charAt(i9);
            if (charAt2 < 128 && i10 < i8) {
                bArr[i10] = (byte) charAt2;
                i10++;
            } else if (charAt2 < 2048 && i10 <= i8 - 2) {
                int i11 = i10 + 1;
                bArr[i10] = (byte) ((charAt2 >>> 6) | 960);
                i10 += 2;
                bArr[i11] = (byte) ((charAt2 & '?') | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i10 <= i8 - 3) {
                bArr[i10] = (byte) ((charAt2 >>> 12) | 480);
                int i12 = i10 + 2;
                bArr[i10 + 1] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i10 += 3;
                bArr[i12] = (byte) ((charAt2 & '?') | 128);
            } else if (i10 <= i8 - 4) {
                int i13 = i9 + 1;
                if (i13 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i13);
                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        bArr[i10] = (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        bArr[i10 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i14 = i10 + 3;
                        bArr[i10 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i10 += 4;
                        bArr[i14] = (byte) ((codePoint & 63) | 128);
                        i9 = i13;
                    } else {
                        i9 = i13;
                    }
                }
                throw new UnpairedSurrogateException(i9 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i6 = i9 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i6)))) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i10);
            } else {
                throw new UnpairedSurrogateException(i9, length);
            }
            i9++;
        }
        return i10;
    }

    private static void encodeUtf8Buffer(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i4;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i5 = 0;
        while (i5 < length) {
            try {
                char charAt = charSequence.charAt(i5);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i5, (byte) charAt);
                i5++;
            } catch (IndexOutOfBoundsException unused) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (byteBuffer.position() + Math.max(i5, (position - byteBuffer.position()) + 1)));
            }
        }
        if (i5 == length) {
            byteBuffer.position(position + i5);
            return;
        }
        position += i5;
        while (i5 < length) {
            char charAt2 = charSequence.charAt(i5);
            if (charAt2 < 128) {
                byteBuffer.put(position, (byte) charAt2);
            } else if (charAt2 < 2048) {
                i4 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt2 >>> 6) | PsExtractor.AUDIO_STREAM));
                    byteBuffer.put(i4, (byte) ((charAt2 & '?') | 128));
                    position = i4;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i4;
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (byteBuffer.position() + Math.max(i5, (position - byteBuffer.position()) + 1)));
                }
            } else if (charAt2 < 55296 || 57343 < charAt2) {
                i4 = position + 1;
                byteBuffer.put(position, (byte) ((charAt2 >>> 12) | 224));
                position += 2;
                byteBuffer.put(i4, (byte) (((charAt2 >>> 6) & 63) | 128));
                byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
            } else {
                int i6 = i5 + 1;
                if (i6 != length) {
                    try {
                        char charAt3 = charSequence.charAt(i6);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i7 = position + 1;
                            try {
                                byteBuffer.put(position, (byte) ((codePoint >>> 18) | PsExtractor.VIDEO_STREAM_MASK));
                                int i8 = position + 2;
                                try {
                                    byteBuffer.put(i7, (byte) (((codePoint >>> 12) & 63) | 128));
                                    position += 3;
                                    byteBuffer.put(i8, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(position, (byte) ((codePoint & 63) | 128));
                                    i5 = i6;
                                } catch (IndexOutOfBoundsException unused3) {
                                    i5 = i6;
                                    position = i8;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (byteBuffer.position() + Math.max(i5, (position - byteBuffer.position()) + 1)));
                                }
                            } catch (IndexOutOfBoundsException unused4) {
                                position = i7;
                                i5 = i6;
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (byteBuffer.position() + Math.max(i5, (position - byteBuffer.position()) + 1)));
                            }
                        } else {
                            i5 = i6;
                        }
                    } catch (IndexOutOfBoundsException unused5) {
                        i5 = i6;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i5) + " at index " + (byteBuffer.position() + Math.max(i5, (position - byteBuffer.position()) + 1)));
                    }
                }
                throw new UnpairedSurrogateException(i5, length);
            }
            i5++;
            position++;
        }
        byteBuffer.position(position);
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        int i5 = 0;
        while (i4 < length) {
            char charAt = charSequence.charAt(i4);
            if (charAt < 2048) {
                i5 += (127 - charAt) >>> 31;
            } else {
                i5 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i4) >= 65536) {
                        i4++;
                    } else {
                        throw new UnpairedSurrogateException(i4, length);
                    }
                }
            }
            i4++;
        }
        return i5;
    }

    public String decodeUtf8(ByteBuffer byteBuffer, int i4, int i5) throws IllegalArgumentException {
        if (byteBuffer.hasArray()) {
            return decodeUtf8Array(byteBuffer.array(), byteBuffer.arrayOffset() + i4, i5);
        }
        return decodeUtf8Buffer(byteBuffer, i4, i5);
    }

    public void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int arrayOffset = byteBuffer.arrayOffset();
            byteBuffer.position(encodeUtf8Array(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            return;
        }
        encodeUtf8Buffer(charSequence, byteBuffer);
    }

    public int encodedLength(CharSequence charSequence) {
        return computeEncodedLength(charSequence);
    }
}
