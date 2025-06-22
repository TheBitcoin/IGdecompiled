package androidx.appcompat.widget;

class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRelative = false;
    private boolean mIsRtl = false;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;

    RtlSpacingHelper() {
    }

    public int getEnd() {
        if (this.mIsRtl) {
            return this.mLeft;
        }
        return this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        if (this.mIsRtl) {
            return this.mRight;
        }
        return this.mLeft;
    }

    public void setAbsolute(int i4, int i5) {
        this.mIsRelative = false;
        if (i4 != Integer.MIN_VALUE) {
            this.mExplicitLeft = i4;
            this.mLeft = i4;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.mExplicitRight = i5;
            this.mRight = i5;
        }
    }

    public void setDirection(boolean z4) {
        if (z4 != this.mIsRtl) {
            this.mIsRtl = z4;
            if (!this.mIsRelative) {
                this.mLeft = this.mExplicitLeft;
                this.mRight = this.mExplicitRight;
            } else if (z4) {
                int i4 = this.mEnd;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.mExplicitLeft;
                }
                this.mLeft = i4;
                int i5 = this.mStart;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = this.mExplicitRight;
                }
                this.mRight = i5;
            } else {
                int i6 = this.mStart;
                if (i6 == Integer.MIN_VALUE) {
                    i6 = this.mExplicitLeft;
                }
                this.mLeft = i6;
                int i7 = this.mEnd;
                if (i7 == Integer.MIN_VALUE) {
                    i7 = this.mExplicitRight;
                }
                this.mRight = i7;
            }
        }
    }

    public void setRelative(int i4, int i5) {
        this.mStart = i4;
        this.mEnd = i5;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i5 != Integer.MIN_VALUE) {
                this.mLeft = i5;
            }
            if (i4 != Integer.MIN_VALUE) {
                this.mRight = i4;
                return;
            }
            return;
        }
        if (i4 != Integer.MIN_VALUE) {
            this.mLeft = i4;
        }
        if (i5 != Integer.MIN_VALUE) {
            this.mRight = i5;
        }
    }
}
