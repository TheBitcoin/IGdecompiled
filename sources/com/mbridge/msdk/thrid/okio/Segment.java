package com.mbridge.msdk.thrid.okio;

import androidx.annotation.Nullable;

final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    Segment next;
    boolean owner;
    int pos;
    Segment prev;
    boolean shared;

    Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        int i4;
        Segment segment = this.prev;
        if (segment == this) {
            throw new IllegalStateException();
        } else if (segment.owner) {
            int i5 = this.limit - this.pos;
            int i6 = 8192 - segment.limit;
            if (segment.shared) {
                i4 = 0;
            } else {
                i4 = segment.pos;
            }
            if (i5 <= i6 + i4) {
                writeTo(segment, i5);
                pop();
                SegmentPool.recycle(this);
            }
        }
    }

    @Nullable
    public final Segment pop() {
        Segment segment;
        Segment segment2 = this.next;
        if (segment2 != this) {
            segment = segment2;
        } else {
            segment = null;
        }
        Segment segment3 = this.prev;
        segment3.next = segment2;
        this.next.prev = segment3;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        segment.prev = this;
        segment.next = this.next;
        this.next.prev = segment;
        this.next = segment;
        return segment;
    }

    /* access modifiers changed from: package-private */
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i4) {
        Segment segment;
        if (i4 <= 0 || i4 > this.limit - this.pos) {
            throw new IllegalArgumentException();
        }
        if (i4 >= 1024) {
            segment = sharedCopy();
        } else {
            segment = SegmentPool.take();
            System.arraycopy(this.data, this.pos, segment.data, 0, i4);
        }
        segment.limit = segment.pos + i4;
        this.pos += i4;
        this.prev.push(segment);
        return segment;
    }

    /* access modifiers changed from: package-private */
    public final Segment unsharedCopy() {
        return new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i4) {
        if (segment.owner) {
            int i5 = segment.limit;
            if (i5 + i4 > 8192) {
                if (!segment.shared) {
                    int i6 = segment.pos;
                    if ((i5 + i4) - i6 <= 8192) {
                        byte[] bArr = segment.data;
                        System.arraycopy(bArr, i6, bArr, 0, i5 - i6);
                        segment.limit -= segment.pos;
                        segment.pos = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.data, this.pos, segment.data, segment.limit, i4);
            segment.limit += i4;
            this.pos += i4;
            return;
        }
        throw new IllegalArgumentException();
    }

    Segment(byte[] bArr, int i4, int i5, boolean z4, boolean z5) {
        this.data = bArr;
        this.pos = i4;
        this.limit = i5;
        this.shared = z4;
        this.owner = z5;
    }
}
