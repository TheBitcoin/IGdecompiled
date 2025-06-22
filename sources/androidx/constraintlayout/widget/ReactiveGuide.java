package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;

public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {
    private boolean mAnimateChange = false;
    private boolean mApplyToAllConstraintSets = true;
    private int mApplyToConstraintSetId = 0;
    private int mAttributeId = -1;

    public ReactiveGuide(Context context) {
        super(context);
        super.setVisibility(8);
        init((AttributeSet) null);
    }

    private void changeValue(int i4, int i5, MotionLayout motionLayout, int i6) {
        ConstraintSet constraintSet = motionLayout.getConstraintSet(i6);
        constraintSet.setGuidelineEnd(i5, i4);
        motionLayout.updateState(i6, constraintSet);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.mAttributeId = obtainStyledAttributes.getResourceId(index, this.mAttributeId);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.mAnimateChange = obtainStyledAttributes.getBoolean(index, this.mAnimateChange);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToConstraintSet) {
                    this.mApplyToConstraintSetId = obtainStyledAttributes.getResourceId(index, this.mApplyToConstraintSetId);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_applyToAllConstraintSets) {
                    this.mApplyToAllConstraintSets = obtainStyledAttributes.getBoolean(index, this.mApplyToAllConstraintSets);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mAttributeId != -1) {
            ConstraintLayout.getSharedValues().addListener(this.mAttributeId, this);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(@NonNull Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.mApplyToConstraintSetId;
    }

    public int getAttributeId() {
        return this.mAttributeId;
    }

    public boolean isAnimatingChange() {
        return this.mAnimateChange;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        setMeasuredDimension(0, 0);
    }

    public void onNewValue(int i4, int i5, int i6) {
        setGuidelineBegin(i5);
        int id = getId();
        if (id > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i7 = this.mApplyToConstraintSetId;
            if (i7 != 0) {
                currentState = i7;
            }
            int i8 = 0;
            if (this.mAnimateChange) {
                if (this.mApplyToAllConstraintSets) {
                    int[] constraintSetIds = motionLayout.getConstraintSetIds();
                    while (i8 < constraintSetIds.length) {
                        int i9 = constraintSetIds[i8];
                        if (i9 != currentState) {
                            changeValue(i5, id, motionLayout, i9);
                        }
                        i8++;
                    }
                }
                ConstraintSet cloneConstraintSet = motionLayout.cloneConstraintSet(currentState);
                cloneConstraintSet.setGuidelineEnd(id, i5);
                motionLayout.updateStateAnimate(currentState, cloneConstraintSet, 1000);
            } else if (this.mApplyToAllConstraintSets) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i8 < constraintSetIds2.length) {
                    changeValue(i5, id, motionLayout, constraintSetIds2[i8]);
                    i8++;
                }
            } else {
                changeValue(i5, id, motionLayout, currentState);
            }
        }
    }

    public void setAnimateChange(boolean z4) {
        this.mAnimateChange = z4;
    }

    public void setApplyToConstraintSetId(int i4) {
        this.mApplyToConstraintSetId = i4;
    }

    public void setAttributeId(int i4) {
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i5 = this.mAttributeId;
        if (i5 != -1) {
            sharedValues.removeListener(i5, this);
        }
        this.mAttributeId = i4;
        if (i4 != -1) {
            sharedValues.addListener(i4, this);
        }
    }

    public void setGuidelineBegin(int i4) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideBegin = i4;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i4) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideEnd = i4;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f4) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guidePercent = f4;
        setLayoutParams(layoutParams);
    }

    public void setVisibility(int i4) {
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
        init(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        super.setVisibility(8);
        init(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4);
        super.setVisibility(8);
        init(attributeSet);
    }
}
