package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("iso3"), Util.getIntegerCodeForString("iso4"), Util.getIntegerCodeForString("iso5"), Util.getIntegerCodeForString("iso6"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV")};
    private static final int SEARCH_LENGTH = 4096;

    private Sniffer() {
    }

    private static boolean isCompatibleBrand(int i4) {
        if ((i4 >>> 8) == Util.getIntegerCodeForString("3gp")) {
            return true;
        }
        for (int i5 : COMPATIBLE_BRANDS) {
            if (i5 == i4) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return sniffInternal(extractorInput, true);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c1, code lost:
        r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean sniffInternal(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput r19, boolean r20) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r0 = r19
            long r1 = r0.getLength()
            r3 = 4096(0x1000, double:2.0237E-320)
            r5 = -1
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0012
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0013
        L_0x0012:
            r1 = r3
        L_0x0013:
            int r2 = (int) r1
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r1 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray
            r3 = 64
            r1.<init>((int) r3)
            r3 = 0
            r4 = 0
            r7 = 0
        L_0x001e:
            r8 = 1
            if (r4 >= r2) goto L_0x00c1
            r9 = 8
            r1.reset(r9)
            byte[] r10 = r1.data
            r0.peekFully(r10, r3, r9)
            long r10 = r1.readUnsignedInt()
            int r12 = r1.readInt()
            r13 = 1
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x004b
            byte[] r10 = r1.data
            r0.peekFully(r10, r9, r9)
            r10 = 16
            r1.setLimit(r10)
            long r13 = r1.readUnsignedLongToLong()
            r10 = r13
            r13 = 16
            goto L_0x0062
        L_0x004b:
            r13 = 0
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x0060
            long r13 = r0.getLength()
            int r15 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r15 == 0) goto L_0x0060
            long r10 = r0.getPosition()
            long r13 = r13 - r10
            long r10 = (long) r9
            long r10 = r10 + r13
        L_0x0060:
            r13 = 8
        L_0x0062:
            long r14 = (long) r13
            int r16 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x0068
            return r3
        L_0x0068:
            int r4 = r4 + r13
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_moov
            if (r12 != r13) goto L_0x006e
            goto L_0x001e
        L_0x006e:
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_moof
            if (r12 == r13) goto L_0x00bf
            int r13 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_mvex
            if (r12 != r13) goto L_0x0077
            goto L_0x00bf
        L_0x0077:
            long r5 = (long) r4
            long r5 = r5 + r10
            long r5 = r5 - r14
            r17 = r4
            r13 = 0
            long r3 = (long) r2
            int r18 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r18 < 0) goto L_0x0083
            goto L_0x00c1
        L_0x0083:
            long r10 = r10 - r14
            int r3 = (int) r10
            int r4 = r17 + r3
            int r5 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom.TYPE_ftyp
            if (r12 != r5) goto L_0x00b5
            if (r3 >= r9) goto L_0x008e
            return r13
        L_0x008e:
            r1.reset(r3)
            byte[] r5 = r1.data
            r0.peekFully(r5, r13, r3)
            int r3 = r3 / 4
            r5 = 0
        L_0x0099:
            if (r5 >= r3) goto L_0x00b1
            if (r5 != r8) goto L_0x00a2
            r6 = 4
            r1.skipBytes(r6)
            goto L_0x00ae
        L_0x00a2:
            int r6 = r1.readInt()
            boolean r6 = isCompatibleBrand(r6)
            if (r6 == 0) goto L_0x00ae
            r7 = 1
            goto L_0x00b1
        L_0x00ae:
            int r5 = r5 + 1
            goto L_0x0099
        L_0x00b1:
            if (r7 != 0) goto L_0x00ba
            r13 = 0
            return r13
        L_0x00b5:
            if (r3 == 0) goto L_0x00ba
            r0.advancePeekPosition(r3)
        L_0x00ba:
            r3 = 0
            r5 = -1
            goto L_0x001e
        L_0x00bf:
            r0 = 1
            goto L_0x00c2
        L_0x00c1:
            r0 = 0
        L_0x00c2:
            if (r7 == 0) goto L_0x00c9
            r1 = r20
            if (r1 != r0) goto L_0x00c9
            return r8
        L_0x00c9:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Sniffer.sniffInternal(com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput, boolean):boolean");
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return sniffInternal(extractorInput, false);
    }
}
