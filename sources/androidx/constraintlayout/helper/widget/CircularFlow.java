package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

public class CircularFlow extends VirtualLayout {
    private static final String TAG = "CircularFlow";
    private static float sDefaultAngle;
    private static int sDefaultRadius;
    private float[] mAngles;
    ConstraintLayout mContainer;
    private int mCountAngle;
    private int mCountRadius;
    private int[] mRadius;
    private String mReferenceAngles;
    private Float mReferenceDefaultAngle;
    private Integer mReferenceDefaultRadius;
    private String mReferenceRadius;
    int mViewCenter;

    public CircularFlow(Context context) {
        super(context);
    }

    private void addAngle(String str) {
        float[] fArr;
        if (str != null && str.length() != 0 && this.myContext != null && (fArr = this.mAngles) != null) {
            if (this.mCountAngle + 1 > fArr.length) {
                this.mAngles = Arrays.copyOf(fArr, fArr.length + 1);
            }
            this.mAngles[this.mCountAngle] = (float) Integer.parseInt(str);
            this.mCountAngle++;
        }
    }

    private void addRadius(String str) {
        int[] iArr;
        if (str != null && str.length() != 0 && this.myContext != null && (iArr = this.mRadius) != null) {
            if (this.mCountRadius + 1 > iArr.length) {
                this.mRadius = Arrays.copyOf(iArr, iArr.length + 1);
            }
            this.mRadius[this.mCountRadius] = (int) (((float) Integer.parseInt(str)) * this.myContext.getResources().getDisplayMetrics().density);
            this.mCountRadius++;
        }
    }

    private void anchorReferences() {
        this.mContainer = (ConstraintLayout) getParent();
        for (int i4 = 0; i4 < this.mCount; i4++) {
            View viewById = this.mContainer.getViewById(this.mIds[i4]);
            if (viewById != null) {
                int i5 = sDefaultRadius;
                float f4 = sDefaultAngle;
                int[] iArr = this.mRadius;
                if (iArr == null || i4 >= iArr.length) {
                    Integer num = this.mReferenceDefaultRadius;
                    if (num == null || num.intValue() == -1) {
                        Log.e(TAG, "Added radius to view with id: " + this.mMap.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.mCountRadius++;
                        if (this.mRadius == null) {
                            this.mRadius = new int[1];
                        }
                        int[] radius = getRadius();
                        this.mRadius = radius;
                        radius[this.mCountRadius - 1] = i5;
                    }
                } else {
                    i5 = iArr[i4];
                }
                float[] fArr = this.mAngles;
                if (fArr == null || i4 >= fArr.length) {
                    Float f5 = this.mReferenceDefaultAngle;
                    if (f5 == null || f5.floatValue() == -1.0f) {
                        Log.e(TAG, "Added angle to view with id: " + this.mMap.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.mCountAngle++;
                        if (this.mAngles == null) {
                            this.mAngles = new float[1];
                        }
                        float[] angles = getAngles();
                        this.mAngles = angles;
                        angles[this.mCountAngle - 1] = f4;
                    }
                } else {
                    f4 = fArr[i4];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.circleAngle = f4;
                layoutParams.circleConstraint = this.mViewCenter;
                layoutParams.circleRadius = i5;
                viewById.setLayoutParams(layoutParams);
            }
        }
        applyLayoutFeatures();
    }

    private float[] removeAngle(float[] fArr, int i4) {
        if (fArr == null || i4 < 0 || i4 >= this.mCountAngle) {
            return fArr;
        }
        return removeElementFromArray(fArr, i4);
    }

    private static int[] removeElementFromArray(int[] iArr, int i4) {
        int[] iArr2 = new int[(iArr.length - 1)];
        int i5 = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            if (i6 != i4) {
                iArr2[i5] = iArr[i6];
                i5++;
            }
        }
        return iArr2;
    }

    private int[] removeRadius(int[] iArr, int i4) {
        if (iArr == null || i4 < 0 || i4 >= this.mCountRadius) {
            return iArr;
        }
        return removeElementFromArray(iArr, i4);
    }

    private void setAngles(String str) {
        if (str != null) {
            int i4 = 0;
            this.mCountAngle = 0;
            while (true) {
                int indexOf = str.indexOf(44, i4);
                if (indexOf == -1) {
                    addAngle(str.substring(i4).trim());
                    return;
                } else {
                    addAngle(str.substring(i4, indexOf).trim());
                    i4 = indexOf + 1;
                }
            }
        }
    }

    private void setRadius(String str) {
        if (str != null) {
            int i4 = 0;
            this.mCountRadius = 0;
            while (true) {
                int indexOf = str.indexOf(44, i4);
                if (indexOf == -1) {
                    addRadius(str.substring(i4).trim());
                    return;
                } else {
                    addRadius(str.substring(i4, indexOf).trim());
                    i4 = indexOf + 1;
                }
            }
        }
    }

    public void addViewToCircularFlow(View view, int i4, float f4) {
        if (!containsId(view.getId())) {
            addView(view);
            this.mCountAngle++;
            float[] angles = getAngles();
            this.mAngles = angles;
            angles[this.mCountAngle - 1] = f4;
            this.mCountRadius++;
            int[] radius = getRadius();
            this.mRadius = radius;
            radius[this.mCountRadius - 1] = (int) (((float) i4) * this.myContext.getResources().getDisplayMetrics().density);
            anchorReferences();
        }
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.mAngles, this.mCountAngle);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.mRadius, this.mCountRadius);
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.mViewCenter = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mReferenceAngles = string;
                    setAngles(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.mReferenceRadius = string2;
                    setRadius(string2);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, sDefaultAngle));
                    this.mReferenceDefaultAngle = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, sDefaultRadius));
                    this.mReferenceDefaultRadius = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isUpdatable(View view) {
        if (containsId(view.getId()) && indexFromId(view.getId()) != -1) {
            return true;
        }
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.mReferenceAngles;
        if (str != null) {
            this.mAngles = new float[1];
            setAngles(str);
        }
        String str2 = this.mReferenceRadius;
        if (str2 != null) {
            this.mRadius = new int[1];
            setRadius(str2);
        }
        Float f4 = this.mReferenceDefaultAngle;
        if (f4 != null) {
            setDefaultAngle(f4.floatValue());
        }
        Integer num = this.mReferenceDefaultRadius;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        anchorReferences();
    }

    public int removeView(View view) {
        int removeView = super.removeView(view);
        if (removeView == -1) {
            return removeView;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.mContainer);
        constraintSet.clear(view.getId(), 8);
        constraintSet.applyTo(this.mContainer);
        float[] fArr = this.mAngles;
        if (removeView < fArr.length) {
            this.mAngles = removeAngle(fArr, removeView);
            this.mCountAngle--;
        }
        int[] iArr = this.mRadius;
        if (removeView < iArr.length) {
            this.mRadius = removeRadius(iArr, removeView);
            this.mCountRadius--;
        }
        anchorReferences();
        return removeView;
    }

    public void setDefaultAngle(float f4) {
        sDefaultAngle = f4;
    }

    public void setDefaultRadius(int i4) {
        sDefaultRadius = i4;
    }

    public void updateAngle(View view, float f4) {
        if (!isUpdatable(view)) {
            Log.e(TAG, "It was not possible to update angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId <= this.mAngles.length) {
            float[] angles = getAngles();
            this.mAngles = angles;
            angles[indexFromId] = f4;
            anchorReferences();
        }
    }

    public void updateRadius(View view, int i4) {
        if (!isUpdatable(view)) {
            Log.e(TAG, "It was not possible to update radius to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId <= this.mRadius.length) {
            int[] radius = getRadius();
            this.mRadius = radius;
            radius[indexFromId] = (int) (((float) i4) * this.myContext.getResources().getDisplayMetrics().density);
            anchorReferences();
        }
    }

    public void updateReference(View view, int i4, float f4) {
        if (!isUpdatable(view)) {
            Log.e(TAG, "It was not possible to update radius and angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (getAngles().length > indexFromId) {
            float[] angles = getAngles();
            this.mAngles = angles;
            angles[indexFromId] = f4;
        }
        if (getRadius().length > indexFromId) {
            int[] radius = getRadius();
            this.mRadius = radius;
            radius[indexFromId] = (int) (((float) i4) * this.myContext.getResources().getDisplayMetrics().density);
        }
        anchorReferences();
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    private static float[] removeElementFromArray(float[] fArr, int i4) {
        float[] fArr2 = new float[(fArr.length - 1)];
        int i5 = 0;
        for (int i6 = 0; i6 < fArr.length; i6++) {
            if (i6 != i4) {
                fArr2[i5] = fArr[i6];
                i5++;
            }
        }
        return fArr2;
    }
}
