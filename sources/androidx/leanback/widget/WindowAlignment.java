package androidx.leanback.widget;

class WindowAlignment {
    public final Axis horizontal;
    private Axis mMainAxis;
    private int mOrientation = 0;
    private Axis mSecondAxis;
    public final Axis vertical;

    public static class Axis {
        static final int PF_KEYLINE_OVER_HIGH_EDGE = 2;
        static final int PF_KEYLINE_OVER_LOW_EDGE = 1;
        private int mMaxEdge;
        private int mMaxScroll;
        private int mMinEdge;
        private int mMinScroll;
        private String mName;
        private int mPaddingMax;
        private int mPaddingMin;
        private int mPreferredKeyLine = 2;
        private boolean mReversedFlow;
        private int mSize;
        private int mWindowAlignment = 3;
        private int mWindowAlignmentOffset = 0;
        private float mWindowAlignmentOffsetPercent = 50.0f;

        public Axis(String str) {
            reset();
            this.mName = str;
        }

        /* access modifiers changed from: package-private */
        public final int calculateKeyline() {
            int i4;
            if (!this.mReversedFlow) {
                int i5 = this.mWindowAlignmentOffset;
                if (i5 < 0) {
                    i5 += this.mSize;
                }
                float f4 = this.mWindowAlignmentOffsetPercent;
                if (f4 != -1.0f) {
                    return i5 + ((int) ((((float) this.mSize) * f4) / 100.0f));
                }
                return i5;
            }
            int i6 = this.mWindowAlignmentOffset;
            if (i6 >= 0) {
                i4 = this.mSize - i6;
            } else {
                i4 = -i6;
            }
            float f5 = this.mWindowAlignmentOffsetPercent;
            if (f5 != -1.0f) {
                return i4 - ((int) ((((float) this.mSize) * f5) / 100.0f));
            }
            return i4;
        }

        /* access modifiers changed from: package-private */
        public final int calculateScrollToKeyLine(int i4, int i5) {
            return i4 - i5;
        }

        public final int getClientSize() {
            return (this.mSize - this.mPaddingMin) - this.mPaddingMax;
        }

        public final int getMaxScroll() {
            return this.mMaxScroll;
        }

        public final int getMinScroll() {
            return this.mMinScroll;
        }

        public final int getPaddingMax() {
            return this.mPaddingMax;
        }

        public final int getPaddingMin() {
            return this.mPaddingMin;
        }

        public final int getScroll(int i4) {
            int i5;
            int i6;
            int size = getSize();
            int calculateKeyline = calculateKeyline();
            boolean isMinUnknown = isMinUnknown();
            boolean isMaxUnknown = isMaxUnknown();
            if (!isMinUnknown) {
                int i7 = this.mPaddingMin;
                int i8 = calculateKeyline - i7;
                if (this.mReversedFlow ? (this.mWindowAlignment & 2) != 0 : (this.mWindowAlignment & 1) != 0) {
                    int i9 = this.mMinEdge;
                    if (i4 - i9 <= i8) {
                        int i10 = i9 - i7;
                        if (isMaxUnknown || i10 <= (i6 = this.mMaxScroll)) {
                            return i10;
                        }
                        return i6;
                    }
                }
            }
            if (!isMaxUnknown) {
                int i11 = this.mPaddingMax;
                int i12 = (size - calculateKeyline) - i11;
                if (this.mReversedFlow ? (this.mWindowAlignment & 1) != 0 : (this.mWindowAlignment & 2) != 0) {
                    int i13 = this.mMaxEdge;
                    if (i13 - i4 <= i12) {
                        int i14 = i13 - (size - i11);
                        if (isMinUnknown || i14 >= (i5 = this.mMinScroll)) {
                            return i14;
                        }
                        return i5;
                    }
                }
            }
            return calculateScrollToKeyLine(i4, calculateKeyline);
        }

        public final int getSize() {
            return this.mSize;
        }

        public final int getWindowAlignment() {
            return this.mWindowAlignment;
        }

        public final int getWindowAlignmentOffset() {
            return this.mWindowAlignmentOffset;
        }

        public final float getWindowAlignmentOffsetPercent() {
            return this.mWindowAlignmentOffsetPercent;
        }

        public final void invalidateScrollMax() {
            this.mMaxEdge = Integer.MAX_VALUE;
            this.mMaxScroll = Integer.MAX_VALUE;
        }

        public final void invalidateScrollMin() {
            this.mMinEdge = Integer.MIN_VALUE;
            this.mMinScroll = Integer.MIN_VALUE;
        }

        public final boolean isMaxUnknown() {
            if (this.mMaxEdge == Integer.MAX_VALUE) {
                return true;
            }
            return false;
        }

        public final boolean isMinUnknown() {
            if (this.mMinEdge == Integer.MIN_VALUE) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean isPreferKeylineOverHighEdge() {
            if ((this.mPreferredKeyLine & 2) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public final boolean isPreferKeylineOverLowEdge() {
            if ((this.mPreferredKeyLine & 1) != 0) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.mMinEdge = Integer.MIN_VALUE;
            this.mMaxEdge = Integer.MAX_VALUE;
        }

        public final void setPadding(int i4, int i5) {
            this.mPaddingMin = i4;
            this.mPaddingMax = i5;
        }

        /* access modifiers changed from: package-private */
        public final void setPreferKeylineOverHighEdge(boolean z4) {
            int i4;
            if (z4) {
                i4 = this.mPreferredKeyLine | 2;
            } else {
                i4 = this.mPreferredKeyLine & -3;
            }
            this.mPreferredKeyLine = i4;
        }

        /* access modifiers changed from: package-private */
        public final void setPreferKeylineOverLowEdge(boolean z4) {
            int i4;
            if (z4) {
                i4 = this.mPreferredKeyLine | 1;
            } else {
                i4 = this.mPreferredKeyLine & -2;
            }
            this.mPreferredKeyLine = i4;
        }

        public final void setReversedFlow(boolean z4) {
            this.mReversedFlow = z4;
        }

        public final void setSize(int i4) {
            this.mSize = i4;
        }

        public final void setWindowAlignment(int i4) {
            this.mWindowAlignment = i4;
        }

        public final void setWindowAlignmentOffset(int i4) {
            this.mWindowAlignmentOffset = i4;
        }

        public final void setWindowAlignmentOffsetPercent(float f4) {
            if ((f4 < 0.0f || f4 > 100.0f) && f4 != -1.0f) {
                throw new IllegalArgumentException();
            }
            this.mWindowAlignmentOffsetPercent = f4;
        }

        public String toString() {
            return " min:" + this.mMinEdge + " " + this.mMinScroll + " max:" + this.mMaxEdge + " " + this.mMaxScroll;
        }

        public final void updateMinMax(int i4, int i5, int i6, int i7) {
            this.mMinEdge = i4;
            this.mMaxEdge = i5;
            int clientSize = getClientSize();
            int calculateKeyline = calculateKeyline();
            boolean isMinUnknown = isMinUnknown();
            boolean isMaxUnknown = isMaxUnknown();
            if (!isMinUnknown) {
                if (this.mReversedFlow ? (this.mWindowAlignment & 2) == 0 : (this.mWindowAlignment & 1) == 0) {
                    this.mMinScroll = calculateScrollToKeyLine(i6, calculateKeyline);
                } else {
                    this.mMinScroll = this.mMinEdge - this.mPaddingMin;
                }
            }
            if (!isMaxUnknown) {
                if (this.mReversedFlow ? (this.mWindowAlignment & 1) == 0 : (this.mWindowAlignment & 2) == 0) {
                    this.mMaxScroll = calculateScrollToKeyLine(i7, calculateKeyline);
                } else {
                    this.mMaxScroll = (this.mMaxEdge - this.mPaddingMin) - clientSize;
                }
            }
            if (!isMaxUnknown && !isMinUnknown) {
                if (!this.mReversedFlow) {
                    int i8 = this.mWindowAlignment;
                    if ((i8 & 1) != 0) {
                        if (isPreferKeylineOverLowEdge()) {
                            this.mMinScroll = Math.min(this.mMinScroll, calculateScrollToKeyLine(i7, calculateKeyline));
                        }
                        this.mMaxScroll = Math.max(this.mMinScroll, this.mMaxScroll);
                    } else if ((i8 & 2) != 0) {
                        if (isPreferKeylineOverHighEdge()) {
                            this.mMaxScroll = Math.max(this.mMaxScroll, calculateScrollToKeyLine(i6, calculateKeyline));
                        }
                        this.mMinScroll = Math.min(this.mMinScroll, this.mMaxScroll);
                    }
                } else {
                    int i9 = this.mWindowAlignment;
                    if ((i9 & 1) != 0) {
                        if (isPreferKeylineOverLowEdge()) {
                            this.mMaxScroll = Math.max(this.mMaxScroll, calculateScrollToKeyLine(i6, calculateKeyline));
                        }
                        this.mMinScroll = Math.min(this.mMinScroll, this.mMaxScroll);
                    } else if ((i9 & 2) != 0) {
                        if (isPreferKeylineOverHighEdge()) {
                            this.mMinScroll = Math.min(this.mMinScroll, calculateScrollToKeyLine(i7, calculateKeyline));
                        }
                        this.mMaxScroll = Math.max(this.mMinScroll, this.mMaxScroll);
                    }
                }
            }
        }
    }

    WindowAlignment() {
        Axis axis = new Axis("vertical");
        this.vertical = axis;
        Axis axis2 = new Axis("horizontal");
        this.horizontal = axis2;
        this.mMainAxis = axis2;
        this.mSecondAxis = axis;
    }

    public final int getOrientation() {
        return this.mOrientation;
    }

    public final Axis mainAxis() {
        return this.mMainAxis;
    }

    public final void reset() {
        mainAxis().reset();
    }

    public final Axis secondAxis() {
        return this.mSecondAxis;
    }

    public final void setOrientation(int i4) {
        this.mOrientation = i4;
        if (i4 == 0) {
            this.mMainAxis = this.horizontal;
            this.mSecondAxis = this.vertical;
            return;
        }
        this.mMainAxis = this.vertical;
        this.mSecondAxis = this.horizontal;
    }

    public String toString() {
        return "horizontal=" + this.horizontal + "; vertical=" + this.vertical;
    }
}
