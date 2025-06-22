package com.mbridge.msdk.playercommon.exoplayer2.upstream.crypto;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesFlushingCipher {
    private final int blockSize;
    private final Cipher cipher;
    private final byte[] flushedBlock;
    private int pendingXorBytes;
    private final byte[] zerosBlock;

    public AesFlushingCipher(int i4, byte[] bArr, long j4, long j5) {
        try {
            Cipher instance = Cipher.getInstance("AES/CTR/NoPadding");
            this.cipher = instance;
            int blockSize2 = instance.getBlockSize();
            this.blockSize = blockSize2;
            this.zerosBlock = new byte[blockSize2];
            this.flushedBlock = new byte[blockSize2];
            int i5 = (int) (j5 % ((long) blockSize2));
            instance.init(i4, new SecretKeySpec(bArr, Util.splitAtFirst(instance.getAlgorithm(), "/")[0]), new IvParameterSpec(getInitializationVector(j4, j5 / ((long) blockSize2))));
            if (i5 != 0) {
                updateInPlace(new byte[i5], 0, i5);
            }
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException e5) {
            throw new RuntimeException(e5);
        }
    }

    private byte[] getInitializationVector(long j4, long j5) {
        return ByteBuffer.allocate(16).putLong(j4).putLong(j5).array();
    }

    private int nonFlushingUpdate(byte[] bArr, int i4, int i5, byte[] bArr2, int i6) {
        try {
            return this.cipher.update(bArr, i4, i5, bArr2, i6);
        } catch (ShortBufferException e5) {
            throw new RuntimeException(e5);
        }
    }

    public final void update(byte[] bArr, int i4, int i5, byte[] bArr2, int i6) {
        boolean z4;
        int i7 = i4;
        int i8 = i5;
        int i9 = i6;
        do {
            int i10 = this.pendingXorBytes;
            if (i10 > 0) {
                bArr2[i9] = (byte) (bArr[i7] ^ this.flushedBlock[this.blockSize - i10]);
                i9++;
                i7++;
                this.pendingXorBytes = i10 - 1;
                i8--;
            } else {
                int nonFlushingUpdate = nonFlushingUpdate(bArr, i7, i8, bArr2, i9);
                if (i8 != nonFlushingUpdate) {
                    int i11 = i8 - nonFlushingUpdate;
                    int i12 = 0;
                    boolean z5 = true;
                    if (i11 < this.blockSize) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Assertions.checkState(z4);
                    int i13 = i9 + nonFlushingUpdate;
                    int i14 = this.blockSize - i11;
                    this.pendingXorBytes = i14;
                    if (nonFlushingUpdate(this.zerosBlock, 0, i14, this.flushedBlock, 0) != this.blockSize) {
                        z5 = false;
                    }
                    Assertions.checkState(z5);
                    while (i12 < i11) {
                        bArr2[i13] = this.flushedBlock[i12];
                        i12++;
                        i13++;
                    }
                    return;
                }
                return;
            }
        } while (i8 != 0);
    }

    public final void updateInPlace(byte[] bArr, int i4, int i5) {
        update(bArr, i4, i5, bArr, i4);
    }
}
