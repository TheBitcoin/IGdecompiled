package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    ConstraintLayout.LayoutParams mParams;
    View mView;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            this.mParams = (ConstraintLayout.LayoutParams) layoutParams;
            this.mView = view;
            return;
        }
        throw new RuntimeException("Only children of ConstraintLayout.LayoutParams supported");
    }

    private String sideToString(int i4) {
        switch (i4) {
            case 1:
                return TtmlNode.LEFT;
            case 2:
                return TtmlNode.RIGHT;
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return TtmlNode.END;
            default:
                return "undefined";
        }
    }

    public ConstraintProperties addToHorizontalChain(int i4, int i5) {
        int i6;
        int i7;
        if (i4 == 0) {
            i6 = 1;
        } else {
            i6 = 2;
        }
        connect(1, i4, i6, 0);
        if (i5 == 0) {
            i7 = 2;
        } else {
            i7 = 1;
        }
        connect(2, i5, i7, 0);
        if (i4 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i4)).connect(2, this.mView.getId(), 1, 0);
        }
        if (i5 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5)).connect(1, this.mView.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i4, int i5) {
        int i6;
        int i7;
        if (i4 == 0) {
            i6 = 6;
        } else {
            i6 = 7;
        }
        connect(6, i4, i6, 0);
        if (i5 == 0) {
            i7 = 7;
        } else {
            i7 = 6;
        }
        connect(7, i5, i7, 0);
        if (i4 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i4)).connect(7, this.mView.getId(), 6, 0);
        }
        if (i5 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5)).connect(6, this.mView.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i4, int i5) {
        int i6;
        int i7;
        if (i4 == 0) {
            i6 = 3;
        } else {
            i6 = 4;
        }
        connect(3, i4, i6, 0);
        if (i5 == 0) {
            i7 = 4;
        } else {
            i7 = 3;
        }
        connect(4, i5, i7, 0);
        if (i4 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i4)).connect(4, this.mView.getId(), 3, 0);
        }
        if (i5 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5)).connect(3, this.mView.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f4) {
        this.mView.setAlpha(f4);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int i4, int i5, int i6, int i7, int i8, int i9, float f4) {
        if (i6 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (i9 < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        } else if (f4 <= 0.0f || f4 > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        } else if (i5 == 1 || i5 == 2) {
            connect(1, i4, i5, i6);
            connect(2, i7, i8, i9);
            this.mParams.horizontalBias = f4;
            return this;
        } else if (i5 == 6 || i5 == 7) {
            connect(6, i4, i5, i6);
            connect(7, i7, i8, i9);
            this.mParams.horizontalBias = f4;
            return this;
        } else {
            connect(3, i4, i5, i6);
            connect(4, i7, i8, i9);
            this.mParams.verticalBias = f4;
            return this;
        }
    }

    public ConstraintProperties centerHorizontally(int i4, int i5, int i6, int i7, int i8, int i9, float f4) {
        connect(1, i4, i5, i6);
        connect(2, i7, i8, i9);
        this.mParams.horizontalBias = f4;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i4, int i5, int i6, int i7, int i8, int i9, float f4) {
        connect(6, i4, i5, i6);
        connect(7, i7, i8, i9);
        this.mParams.horizontalBias = f4;
        return this;
    }

    public ConstraintProperties centerVertically(int i4, int i5, int i6, int i7, int i8, int i9, float f4) {
        connect(3, i4, i5, i6);
        connect(4, i7, i8, i9);
        this.mParams.verticalBias = f4;
        return this;
    }

    public ConstraintProperties connect(int i4, int i5, int i6, int i7) {
        switch (i4) {
            case 1:
                if (i6 == 1) {
                    ConstraintLayout.LayoutParams layoutParams = this.mParams;
                    layoutParams.leftToLeft = i5;
                    layoutParams.leftToRight = -1;
                } else if (i6 == 2) {
                    ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    layoutParams2.leftToRight = i5;
                    layoutParams2.leftToLeft = -1;
                } else {
                    throw new IllegalArgumentException("Left to " + sideToString(i6) + " undefined");
                }
                this.mParams.leftMargin = i7;
                return this;
            case 2:
                if (i6 == 1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    layoutParams3.rightToLeft = i5;
                    layoutParams3.rightToRight = -1;
                } else if (i6 == 2) {
                    ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                    layoutParams4.rightToRight = i5;
                    layoutParams4.rightToLeft = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i6) + " undefined");
                }
                this.mParams.rightMargin = i7;
                return this;
            case 3:
                if (i6 == 3) {
                    ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                    layoutParams5.topToTop = i5;
                    layoutParams5.topToBottom = -1;
                    layoutParams5.baselineToBaseline = -1;
                    layoutParams5.baselineToTop = -1;
                    layoutParams5.baselineToBottom = -1;
                } else if (i6 == 4) {
                    ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                    layoutParams6.topToBottom = i5;
                    layoutParams6.topToTop = -1;
                    layoutParams6.baselineToBaseline = -1;
                    layoutParams6.baselineToTop = -1;
                    layoutParams6.baselineToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i6) + " undefined");
                }
                this.mParams.topMargin = i7;
                return this;
            case 4:
                if (i6 == 4) {
                    ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                    layoutParams7.bottomToBottom = i5;
                    layoutParams7.bottomToTop = -1;
                    layoutParams7.baselineToBaseline = -1;
                    layoutParams7.baselineToTop = -1;
                    layoutParams7.baselineToBottom = -1;
                } else if (i6 == 3) {
                    ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                    layoutParams8.bottomToTop = i5;
                    layoutParams8.bottomToBottom = -1;
                    layoutParams8.baselineToBaseline = -1;
                    layoutParams8.baselineToTop = -1;
                    layoutParams8.baselineToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i6) + " undefined");
                }
                this.mParams.bottomMargin = i7;
                return this;
            case 5:
                if (i6 == 5) {
                    ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                    layoutParams9.baselineToBaseline = i5;
                    layoutParams9.bottomToBottom = -1;
                    layoutParams9.bottomToTop = -1;
                    layoutParams9.topToTop = -1;
                    layoutParams9.topToBottom = -1;
                } else if (i6 == 3) {
                    ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                    layoutParams10.baselineToTop = i5;
                    layoutParams10.bottomToBottom = -1;
                    layoutParams10.bottomToTop = -1;
                    layoutParams10.topToTop = -1;
                    layoutParams10.topToBottom = -1;
                } else if (i6 == 4) {
                    ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                    layoutParams11.baselineToBottom = i5;
                    layoutParams11.bottomToBottom = -1;
                    layoutParams11.bottomToTop = -1;
                    layoutParams11.topToTop = -1;
                    layoutParams11.topToBottom = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i6) + " undefined");
                }
                this.mParams.baselineMargin = i7;
                return this;
            case 6:
                if (i6 == 6) {
                    ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                    layoutParams12.startToStart = i5;
                    layoutParams12.startToEnd = -1;
                } else if (i6 == 7) {
                    ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                    layoutParams13.startToEnd = i5;
                    layoutParams13.startToStart = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i6) + " undefined");
                }
                this.mParams.setMarginStart(i7);
                return this;
            case 7:
                if (i6 == 7) {
                    ConstraintLayout.LayoutParams layoutParams14 = this.mParams;
                    layoutParams14.endToEnd = i5;
                    layoutParams14.endToStart = -1;
                } else if (i6 == 6) {
                    ConstraintLayout.LayoutParams layoutParams15 = this.mParams;
                    layoutParams15.endToStart = i5;
                    layoutParams15.endToEnd = -1;
                } else {
                    throw new IllegalArgumentException("right to " + sideToString(i6) + " undefined");
                }
                this.mParams.setMarginEnd(i7);
                return this;
            default:
                throw new IllegalArgumentException(sideToString(i4) + " to " + sideToString(i6) + " unknown");
        }
    }

    public ConstraintProperties constrainDefaultHeight(int i4) {
        this.mParams.matchConstraintDefaultHeight = i4;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i4) {
        this.mParams.matchConstraintDefaultWidth = i4;
        return this;
    }

    public ConstraintProperties constrainHeight(int i4) {
        this.mParams.height = i4;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i4) {
        this.mParams.matchConstraintMaxHeight = i4;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i4) {
        this.mParams.matchConstraintMaxWidth = i4;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i4) {
        this.mParams.matchConstraintMinHeight = i4;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i4) {
        this.mParams.matchConstraintMinWidth = i4;
        return this;
    }

    public ConstraintProperties constrainWidth(int i4) {
        this.mParams.width = i4;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.mParams.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f4) {
        this.mView.setElevation(f4);
        return this;
    }

    public ConstraintProperties goneMargin(int i4, int i5) {
        switch (i4) {
            case 1:
                this.mParams.goneLeftMargin = i5;
                return this;
            case 2:
                this.mParams.goneRightMargin = i5;
                return this;
            case 3:
                this.mParams.goneTopMargin = i5;
                return this;
            case 4:
                this.mParams.goneBottomMargin = i5;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.goneStartMargin = i5;
                return this;
            case 7:
                this.mParams.goneEndMargin = i5;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties horizontalBias(float f4) {
        this.mParams.horizontalBias = f4;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i4) {
        this.mParams.horizontalChainStyle = i4;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f4) {
        this.mParams.horizontalWeight = f4;
        return this;
    }

    public ConstraintProperties margin(int i4, int i5) {
        switch (i4) {
            case 1:
                this.mParams.leftMargin = i5;
                return this;
            case 2:
                this.mParams.rightMargin = i5;
                return this;
            case 3:
                this.mParams.topMargin = i5;
                return this;
            case 4:
                this.mParams.bottomMargin = i5;
                return this;
            case 5:
                throw new IllegalArgumentException("baseline does not support margins");
            case 6:
                this.mParams.setMarginStart(i5);
                return this;
            case 7:
                this.mParams.setMarginEnd(i5);
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeConstraints(int i4) {
        switch (i4) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.mParams;
                layoutParams.leftToRight = -1;
                layoutParams.leftToLeft = -1;
                layoutParams.leftMargin = -1;
                layoutParams.goneLeftMargin = Integer.MIN_VALUE;
                return this;
            case 2:
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                layoutParams2.rightToRight = -1;
                layoutParams2.rightToLeft = -1;
                layoutParams2.rightMargin = -1;
                layoutParams2.goneRightMargin = Integer.MIN_VALUE;
                return this;
            case 3:
                ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                layoutParams3.topToBottom = -1;
                layoutParams3.topToTop = -1;
                layoutParams3.topMargin = -1;
                layoutParams3.goneTopMargin = Integer.MIN_VALUE;
                return this;
            case 4:
                ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                layoutParams4.bottomToTop = -1;
                layoutParams4.bottomToBottom = -1;
                layoutParams4.bottomMargin = -1;
                layoutParams4.goneBottomMargin = Integer.MIN_VALUE;
                return this;
            case 5:
                this.mParams.baselineToBaseline = -1;
                return this;
            case 6:
                ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                layoutParams5.startToEnd = -1;
                layoutParams5.startToStart = -1;
                layoutParams5.setMarginStart(-1);
                this.mParams.goneStartMargin = Integer.MIN_VALUE;
                return this;
            case 7:
                ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                layoutParams6.endToStart = -1;
                layoutParams6.endToEnd = -1;
                layoutParams6.setMarginEnd(-1);
                this.mParams.goneEndMargin = Integer.MIN_VALUE;
                return this;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i4 = layoutParams.leftToRight;
        int i5 = layoutParams.rightToLeft;
        if (i4 == -1 && i5 == -1) {
            int i6 = layoutParams.startToEnd;
            int i7 = layoutParams.endToStart;
            if (!(i6 == -1 && i7 == -1)) {
                ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6));
                ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i7));
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                if (i6 != -1 && i7 != -1) {
                    constraintProperties.connect(7, i7, 6, 0);
                    constraintProperties2.connect(6, i4, 7, 0);
                } else if (!(i4 == -1 && i7 == -1)) {
                    int i8 = layoutParams2.rightToRight;
                    if (i8 != -1) {
                        constraintProperties.connect(7, i8, 7, 0);
                    } else {
                        int i9 = layoutParams2.leftToLeft;
                        if (i9 != -1) {
                            constraintProperties2.connect(6, i9, 6, 0);
                        }
                    }
                }
            }
            removeConstraints(6);
            removeConstraints(7);
            return this;
        }
        ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i4));
        ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5));
        ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
        if (i4 != -1 && i5 != -1) {
            constraintProperties3.connect(2, i5, 1, 0);
            constraintProperties4.connect(1, i4, 2, 0);
        } else if (!(i4 == -1 && i5 == -1)) {
            int i10 = layoutParams3.rightToRight;
            if (i10 != -1) {
                constraintProperties3.connect(2, i10, 2, 0);
            } else {
                int i11 = layoutParams3.leftToLeft;
                if (i11 != -1) {
                    constraintProperties4.connect(1, i11, 1, 0);
                }
            }
        }
        removeConstraints(1);
        removeConstraints(2);
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i4 = layoutParams.topToBottom;
        int i5 = layoutParams.bottomToTop;
        if (!(i4 == -1 && i5 == -1)) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i4));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i5));
            ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
            if (i4 != -1 && i5 != -1) {
                constraintProperties.connect(4, i5, 3, 0);
                constraintProperties2.connect(3, i4, 4, 0);
            } else if (!(i4 == -1 && i5 == -1)) {
                int i6 = layoutParams2.bottomToBottom;
                if (i6 != -1) {
                    constraintProperties.connect(4, i6, 4, 0);
                } else {
                    int i7 = layoutParams2.topToTop;
                    if (i7 != -1) {
                        constraintProperties2.connect(3, i7, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f4) {
        this.mView.setRotation(f4);
        return this;
    }

    public ConstraintProperties rotationX(float f4) {
        this.mView.setRotationX(f4);
        return this;
    }

    public ConstraintProperties rotationY(float f4) {
        this.mView.setRotationY(f4);
        return this;
    }

    public ConstraintProperties scaleX(float f4) {
        this.mView.setScaleY(f4);
        return this;
    }

    public ConstraintProperties scaleY(float f4) {
        return this;
    }

    public ConstraintProperties transformPivot(float f4, float f5) {
        this.mView.setPivotX(f4);
        this.mView.setPivotY(f5);
        return this;
    }

    public ConstraintProperties transformPivotX(float f4) {
        this.mView.setPivotX(f4);
        return this;
    }

    public ConstraintProperties transformPivotY(float f4) {
        this.mView.setPivotY(f4);
        return this;
    }

    public ConstraintProperties translation(float f4, float f5) {
        this.mView.setTranslationX(f4);
        this.mView.setTranslationY(f5);
        return this;
    }

    public ConstraintProperties translationX(float f4) {
        this.mView.setTranslationX(f4);
        return this;
    }

    public ConstraintProperties translationY(float f4) {
        this.mView.setTranslationY(f4);
        return this;
    }

    public ConstraintProperties translationZ(float f4) {
        this.mView.setTranslationZ(f4);
        return this;
    }

    public ConstraintProperties verticalBias(float f4) {
        this.mParams.verticalBias = f4;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i4) {
        this.mParams.verticalChainStyle = i4;
        return this;
    }

    public ConstraintProperties verticalWeight(float f4) {
        this.mParams.verticalWeight = f4;
        return this;
    }

    public ConstraintProperties visibility(int i4) {
        this.mView.setVisibility(i4);
        return this;
    }

    public ConstraintProperties centerHorizontally(int i4) {
        if (i4 == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
            return this;
        }
        center(i4, 2, 0, i4, 1, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i4) {
        if (i4 == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
            return this;
        }
        center(i4, 7, 0, i4, 6, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerVertically(int i4) {
        if (i4 == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
            return this;
        }
        center(i4, 4, 0, i4, 3, 0, 0.5f);
        return this;
    }
}
