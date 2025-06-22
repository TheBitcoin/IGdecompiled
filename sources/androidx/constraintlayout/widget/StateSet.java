package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    int mCurrentConstraintNumber = -1;
    int mCurrentStateId = -1;
    int mDefaultState = -1;
    private SparseArray<State> mStateList = new SparseArray<>();

    static class State {
        int mConstraintID = -1;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants = new ArrayList<>();

        State(Context context, XmlPullParser xmlPullParser) {
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.State_android_id) {
                    this.mId = obtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void add(Variant variant) {
            this.mVariants.add(variant);
        }

        public int findMatch(float f4, float f5) {
            for (int i4 = 0; i4 < this.mVariants.size(); i4++) {
                if (this.mVariants.get(i4).match(f4, f5)) {
                    return i4;
                }
            }
            return -1;
        }
    }

    static class Variant {
        int mConstraintID = -1;
        int mId;
        boolean mIsLayout;
        float mMaxHeight = Float.NaN;
        float mMaxWidth = Float.NaN;
        float mMinHeight = Float.NaN;
        float mMinWidth = Float.NaN;

        Variant(Context context, XmlPullParser xmlPullParser) {
            this.mIsLayout = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = obtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = obtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = obtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = obtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean match(float f4, float f5) {
            if (!Float.isNaN(this.mMinWidth) && f4 < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && f5 < this.mMinHeight) {
                return false;
            }
            if (!Float.isNaN(this.mMaxWidth) && f4 > this.mMaxWidth) {
                return false;
            }
            if (Float.isNaN(this.mMaxHeight) || f5 <= this.mMaxHeight) {
                return true;
            }
            return false;
        }
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r11, org.xmlpull.v1.XmlPullParser r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Error parsing XML resource"
            java.lang.String r1 = "ConstraintLayoutStates"
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r12)
            int[] r3 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r2 = r11.obtainStyledAttributes(r2, r3)
            int r3 = r2.getIndexCount()
            r4 = 0
            r5 = 0
        L_0x0014:
            if (r5 >= r3) goto L_0x0029
            int r6 = r2.getIndex(r5)
            int r7 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r6 != r7) goto L_0x0026
            int r7 = r10.mDefaultState
            int r6 = r2.getResourceId(r6, r7)
            r10.mDefaultState = r6
        L_0x0026:
            int r5 = r5 + 1
            goto L_0x0014
        L_0x0029:
            r2.recycle()
            int r2 = r12.getEventType()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            r3 = 0
        L_0x0031:
            r5 = 1
            if (r2 == r5) goto L_0x00a6
            java.lang.String r6 = "StateSet"
            r7 = 3
            r8 = 2
            if (r2 == r8) goto L_0x004c
            if (r2 == r7) goto L_0x003d
            goto L_0x009a
        L_0x003d:
            java.lang.String r2 = r12.getName()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            boolean r2 = r6.equals(r2)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r2 == 0) goto L_0x009a
            goto L_0x00a6
        L_0x0048:
            r11 = move-exception
            goto L_0x009f
        L_0x004a:
            r11 = move-exception
            goto L_0x00a3
        L_0x004c:
            java.lang.String r2 = r12.getName()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            int r9 = r2.hashCode()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            switch(r9) {
                case 80204913: goto L_0x0073;
                case 1301459538: goto L_0x0069;
                case 1382829617: goto L_0x0062;
                case 1901439077: goto L_0x0058;
                default: goto L_0x0057;
            }     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
        L_0x0057:
            goto L_0x007d
        L_0x0058:
            java.lang.String r5 = "Variant"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r2 == 0) goto L_0x007d
            r5 = 3
            goto L_0x007e
        L_0x0062:
            boolean r2 = r2.equals(r6)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r2 == 0) goto L_0x007d
            goto L_0x007e
        L_0x0069:
            java.lang.String r5 = "LayoutDescription"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r2 == 0) goto L_0x007d
            r5 = 0
            goto L_0x007e
        L_0x0073:
            java.lang.String r5 = "State"
            boolean r2 = r2.equals(r5)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r2 == 0) goto L_0x007d
            r5 = 2
            goto L_0x007e
        L_0x007d:
            r5 = -1
        L_0x007e:
            if (r5 == r8) goto L_0x008e
            if (r5 == r7) goto L_0x0083
            goto L_0x009a
        L_0x0083:
            androidx.constraintlayout.widget.StateSet$Variant r2 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            r2.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            if (r3 == 0) goto L_0x009a
            r3.add(r2)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            goto L_0x009a
        L_0x008e:
            androidx.constraintlayout.widget.StateSet$State r3 = new androidx.constraintlayout.widget.StateSet$State     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            r3.<init>(r11, r12)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r2 = r10.mStateList     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            int r5 = r3.mId     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            r2.put(r5, r3)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
        L_0x009a:
            int r2 = r12.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0048 }
            goto L_0x0031
        L_0x009f:
            android.util.Log.e(r1, r0, r11)
            goto L_0x00a6
        L_0x00a3:
            android.util.Log.e(r1, r0, r11)
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int convertToConstraintSet(int i4, int i5, float f4, float f5) {
        State state = this.mStateList.get(i5);
        if (state == null) {
            return i5;
        }
        int i6 = 0;
        if (f4 != -1.0f && f5 != -1.0f) {
            ArrayList<Variant> arrayList = state.mVariants;
            int size = arrayList.size();
            Variant variant = null;
            while (i6 < size) {
                Variant variant2 = arrayList.get(i6);
                i6++;
                Variant variant3 = variant2;
                if (variant3.match(f4, f5)) {
                    if (i4 != variant3.mConstraintID) {
                        variant = variant3;
                    }
                }
            }
            if (variant != null) {
                return variant.mConstraintID;
            }
            return state.mConstraintID;
        } else if (state.mConstraintID != i4) {
            ArrayList<Variant> arrayList2 = state.mVariants;
            int size2 = arrayList2.size();
            while (i6 < size2) {
                Variant variant4 = arrayList2.get(i6);
                i6++;
                if (i4 == variant4.mConstraintID) {
                }
            }
            return state.mConstraintID;
        }
        return i4;
    }

    public boolean needsToChange(int i4, float f4, float f5) {
        Object obj;
        int i5 = this.mCurrentStateId;
        if (i5 != i4) {
            return true;
        }
        if (i4 == -1) {
            obj = this.mStateList.valueAt(0);
        } else {
            obj = this.mStateList.get(i5);
        }
        State state = (State) obj;
        int i6 = this.mCurrentConstraintNumber;
        if ((i6 == -1 || !state.mVariants.get(i6).match(f4, f5)) && this.mCurrentConstraintNumber != state.findMatch(f4, f5)) {
            return true;
        }
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i4, int i5, int i6) {
        return updateConstraints(-1, i4, (float) i5, (float) i6);
    }

    public int updateConstraints(int i4, int i5, float f4, float f5) {
        State state;
        int findMatch;
        if (i4 == i5) {
            if (i5 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(this.mCurrentStateId);
            }
            if (state == null) {
                return -1;
            }
            if ((this.mCurrentConstraintNumber != -1 && state.mVariants.get(i4).match(f4, f5)) || i4 == (findMatch = state.findMatch(f4, f5))) {
                return i4;
            }
            if (findMatch == -1) {
                return state.mConstraintID;
            }
            return state.mVariants.get(findMatch).mConstraintID;
        }
        State state2 = this.mStateList.get(i5);
        if (state2 == null) {
            return -1;
        }
        int findMatch2 = state2.findMatch(f4, f5);
        if (findMatch2 == -1) {
            return state2.mConstraintID;
        }
        return state2.mVariants.get(findMatch2).mConstraintID;
    }
}
