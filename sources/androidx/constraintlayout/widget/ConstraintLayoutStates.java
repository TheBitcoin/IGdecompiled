package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    int mCurrentConstraintNumber = -1;
    int mCurrentStateId = -1;
    ConstraintSet mDefaultConstraintSet;
    private SparseArray<State> mStateList = new SparseArray<>();

    static class State {
        int mConstraintID = -1;
        ConstraintSet mConstraintSet;
        int mId;
        ArrayList<Variant> mVariants = new ArrayList<>();

        State(Context context, XmlPullParser xmlPullParser) {
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
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
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
        ConstraintSet mConstraintSet;
        int mId;
        float mMaxHeight = Float.NaN;
        float mMaxWidth = Float.NaN;
        float mMinHeight = Float.NaN;
        float mMinWidth = Float.NaN;

        Variant(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = obtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.clone(context, this.mConstraintID);
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

    ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i4) {
        this.mConstraintLayout = constraintLayout;
        load(context, i4);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "Error parsing resource: "
            java.lang.String r1 = "ConstraintLayoutStates"
            android.content.res.Resources r2 = r11.getResources()
            android.content.res.XmlResourceParser r2 = r2.getXml(r12)
            int r3 = r2.getEventType()     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            r4 = 0
        L_0x0011:
            r5 = 1
            if (r3 == r5) goto L_0x00ab
            r6 = 2
            if (r3 == r6) goto L_0x0019
            goto L_0x0081
        L_0x0019:
            java.lang.String r3 = r2.getName()     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            int r7 = r3.hashCode()     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            r8 = 4
            r9 = 3
            switch(r7) {
                case -1349929691: goto L_0x0053;
                case 80204913: goto L_0x0049;
                case 1382829617: goto L_0x0040;
                case 1657696882: goto L_0x0036;
                case 1901439077: goto L_0x0027;
                default: goto L_0x0026;
            }     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
        L_0x0026:
            goto L_0x005d
        L_0x0027:
            java.lang.String r5 = "Variant"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            if (r3 == 0) goto L_0x005d
            r5 = 3
            goto L_0x005e
        L_0x0031:
            r11 = move-exception
            goto L_0x0086
        L_0x0033:
            r11 = move-exception
            goto L_0x0099
        L_0x0036:
            java.lang.String r5 = "layoutDescription"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            if (r3 == 0) goto L_0x005d
            r5 = 0
            goto L_0x005e
        L_0x0040:
            java.lang.String r7 = "StateSet"
            boolean r3 = r3.equals(r7)     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            if (r3 == 0) goto L_0x005d
            goto L_0x005e
        L_0x0049:
            java.lang.String r5 = "State"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            if (r3 == 0) goto L_0x005d
            r5 = 2
            goto L_0x005e
        L_0x0053:
            java.lang.String r5 = "ConstraintSet"
            boolean r3 = r3.equals(r5)     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            if (r3 == 0) goto L_0x005d
            r5 = 4
            goto L_0x005e
        L_0x005d:
            r5 = -1
        L_0x005e:
            if (r5 == r6) goto L_0x0074
            if (r5 == r9) goto L_0x0069
            if (r5 == r8) goto L_0x0065
            goto L_0x0081
        L_0x0065:
            r10.parseConstraintSet(r11, r2)     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            goto L_0x0081
        L_0x0069:
            androidx.constraintlayout.widget.ConstraintLayoutStates$Variant r3 = new androidx.constraintlayout.widget.ConstraintLayoutStates$Variant     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            r3.<init>(r11, r2)     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            if (r4 == 0) goto L_0x0081
            r4.add(r3)     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            goto L_0x0081
        L_0x0074:
            androidx.constraintlayout.widget.ConstraintLayoutStates$State r3 = new androidx.constraintlayout.widget.ConstraintLayoutStates$State     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            r3.<init>(r11, r2)     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintLayoutStates$State> r4 = r10.mStateList     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            int r5 = r3.mId     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            r4.put(r5, r3)     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            r4 = r3
        L_0x0081:
            int r3 = r2.next()     // Catch:{ XmlPullParserException -> 0x0033, IOException -> 0x0031 }
            goto L_0x0011
        L_0x0086:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            android.util.Log.e(r1, r12, r11)
            goto L_0x00ab
        L_0x0099:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r12)
            java.lang.String r12 = r2.toString()
            android.util.Log.e(r1, r12, r11)
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.load(android.content.Context, int):void");
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        int i4;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        int i5 = 0;
        while (i5 < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i5);
            String attributeValue = xmlPullParser.getAttributeValue(i5);
            if (attributeName == null || attributeValue == null || !"id".equals(attributeName)) {
                i5++;
            } else {
                if (attributeValue.contains("/")) {
                    i4 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i4 = -1;
                }
                if (i4 == -1) {
                    if (attributeValue.length() > 1) {
                        i4 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.load(context, xmlPullParser);
                this.mConstraintSetMap.put(i4, constraintSet);
                return;
            }
        }
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

    public void updateConstraints(int i4, float f4, float f5) {
        ConstraintSet constraintSet;
        int i5;
        State state;
        int findMatch;
        ConstraintSet constraintSet2;
        int i6;
        int i7 = this.mCurrentStateId;
        if (i7 == i4) {
            if (i4 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(i7);
            }
            int i8 = this.mCurrentConstraintNumber;
            if ((i8 == -1 || !state.mVariants.get(i8).match(f4, f5)) && this.mCurrentConstraintNumber != (findMatch = state.findMatch(f4, f5))) {
                if (findMatch == -1) {
                    constraintSet2 = this.mDefaultConstraintSet;
                } else {
                    constraintSet2 = state.mVariants.get(findMatch).mConstraintSet;
                }
                if (findMatch == -1) {
                    i6 = state.mConstraintID;
                } else {
                    i6 = state.mVariants.get(findMatch).mConstraintID;
                }
                if (constraintSet2 != null) {
                    this.mCurrentConstraintNumber = findMatch;
                    ConstraintsChangedListener constraintsChangedListener = this.mConstraintsChangedListener;
                    if (constraintsChangedListener != null) {
                        constraintsChangedListener.preLayoutChange(-1, i6);
                    }
                    constraintSet2.applyTo(this.mConstraintLayout);
                    ConstraintsChangedListener constraintsChangedListener2 = this.mConstraintsChangedListener;
                    if (constraintsChangedListener2 != null) {
                        constraintsChangedListener2.postLayoutChange(-1, i6);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.mCurrentStateId = i4;
        State state2 = this.mStateList.get(i4);
        int findMatch2 = state2.findMatch(f4, f5);
        if (findMatch2 == -1) {
            constraintSet = state2.mConstraintSet;
        } else {
            constraintSet = state2.mVariants.get(findMatch2).mConstraintSet;
        }
        if (findMatch2 == -1) {
            i5 = state2.mConstraintID;
        } else {
            i5 = state2.mVariants.get(findMatch2).mConstraintID;
        }
        if (constraintSet == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i4 + ", dim =" + f4 + ", " + f5);
            return;
        }
        this.mCurrentConstraintNumber = findMatch2;
        ConstraintsChangedListener constraintsChangedListener3 = this.mConstraintsChangedListener;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.preLayoutChange(i4, i5);
        }
        constraintSet.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener constraintsChangedListener4 = this.mConstraintsChangedListener;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.postLayoutChange(i4, i5);
        }
    }
}
