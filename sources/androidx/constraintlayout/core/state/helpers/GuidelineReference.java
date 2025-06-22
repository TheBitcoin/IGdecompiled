package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.Reference;
import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

public class GuidelineReference implements Facade, Reference {
    private int mEnd = -1;
    private Guideline mGuidelineWidget;
    private Object mKey;
    private int mOrientation;
    private float mPercent = 0.0f;
    private int mStart = -1;
    final State mState;

    public GuidelineReference(State state) {
        this.mState = state;
    }

    public void apply() {
        this.mGuidelineWidget.setOrientation(this.mOrientation);
        int i4 = this.mStart;
        if (i4 != -1) {
            this.mGuidelineWidget.setGuideBegin(i4);
            return;
        }
        int i5 = this.mEnd;
        if (i5 != -1) {
            this.mGuidelineWidget.setGuideEnd(i5);
        } else {
            this.mGuidelineWidget.setGuidePercent(this.mPercent);
        }
    }

    public GuidelineReference end(Object obj) {
        this.mStart = -1;
        this.mEnd = this.mState.convertDimension(obj);
        this.mPercent = 0.0f;
        return this;
    }

    public ConstraintWidget getConstraintWidget() {
        if (this.mGuidelineWidget == null) {
            this.mGuidelineWidget = new Guideline();
        }
        return this.mGuidelineWidget;
    }

    public Facade getFacade() {
        return null;
    }

    public Object getKey() {
        return this.mKey;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public GuidelineReference percent(float f4) {
        this.mStart = -1;
        this.mEnd = -1;
        this.mPercent = f4;
        return this;
    }

    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget instanceof Guideline) {
            this.mGuidelineWidget = (Guideline) constraintWidget;
        } else {
            this.mGuidelineWidget = null;
        }
    }

    public void setKey(Object obj) {
        this.mKey = obj;
    }

    public void setOrientation(int i4) {
        this.mOrientation = i4;
    }

    public GuidelineReference start(Object obj) {
        this.mStart = this.mState.convertDimension(obj);
        this.mEnd = -1;
        this.mPercent = 0.0f;
        return this;
    }
}
