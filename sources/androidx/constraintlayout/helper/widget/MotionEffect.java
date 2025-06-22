package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;

public class MotionEffect extends MotionHelper {
    public static final int AUTO = -1;
    public static final int EAST = 2;
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final String TAG = "FadeMove";
    private static final int UNSET = -1;
    public static final int WEST = 3;
    private int mFadeMove = -1;
    private float mMotionEffectAlpha = 0.1f;
    private int mMotionEffectEnd = 50;
    private int mMotionEffectStart = 49;
    private boolean mMotionEffectStrictMove = true;
    private int mMotionEffectTranslationX = 0;
    private int mMotionEffectTranslationY = 0;
    private int mViewTransitionId = -1;

    public MotionEffect(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i5 = obtainStyledAttributes.getInt(index, this.mMotionEffectStart);
                    this.mMotionEffectStart = i5;
                    this.mMotionEffectStart = Math.max(Math.min(i5, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i6 = obtainStyledAttributes.getInt(index, this.mMotionEffectEnd);
                    this.mMotionEffectEnd = i6;
                    this.mMotionEffectEnd = Math.max(Math.min(i6, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.mMotionEffectTranslationX = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMotionEffectTranslationX);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.mMotionEffectTranslationY = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMotionEffectTranslationY);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.mMotionEffectAlpha = obtainStyledAttributes.getFloat(index, this.mMotionEffectAlpha);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.mFadeMove = obtainStyledAttributes.getInt(index, this.mFadeMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.mMotionEffectStrictMove = obtainStyledAttributes.getBoolean(index, this.mMotionEffectStrictMove);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.mViewTransitionId = obtainStyledAttributes.getResourceId(index, this.mViewTransitionId);
                }
            }
            int i7 = this.mMotionEffectStart;
            int i8 = this.mMotionEffectEnd;
            if (i7 == i8) {
                if (i7 > 0) {
                    this.mMotionEffectStart = i7 - 1;
                } else {
                    this.mMotionEffectEnd = i8 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isDecorator() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x018d, code lost:
        if (r14 == 0.0f) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01a1, code lost:
        if (r14 == 0.0f) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01b1, code lost:
        if (r15 == 0.0f) goto L_0x0192;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01c1, code lost:
        if (r15 == 0.0f) goto L_0x0169;
     */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.MotionController> r24) {
        /*
            r22 = this;
            r0 = r22
            r1 = r24
            android.view.ViewParent r2 = r0.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            android.view.View[] r2 = r0.getViews(r2)
            if (r2 != 0) goto L_0x002b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = androidx.constraintlayout.motion.widget.Debug.getLoc()
            r1.append(r2)
            java.lang.String r2 = " views = null"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FadeMove"
            android.util.Log.v(r2, r1)
            return
        L_0x002b:
            androidx.constraintlayout.motion.widget.KeyAttributes r3 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r3.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r4 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r4.<init>()
            float r5 = r0.mMotionEffectAlpha
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r6 = "alpha"
            r3.setValue(r6, r5)
            float r5 = r0.mMotionEffectAlpha
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.setValue(r6, r5)
            int r5 = r0.mMotionEffectStart
            r3.setFramePosition(r5)
            int r5 = r0.mMotionEffectEnd
            r4.setFramePosition(r5)
            androidx.constraintlayout.motion.widget.KeyPosition r5 = new androidx.constraintlayout.motion.widget.KeyPosition
            r5.<init>()
            int r6 = r0.mMotionEffectStart
            r5.setFramePosition(r6)
            r6 = 0
            r5.setType(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "percentX"
            r5.setValue(r8, r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r9 = "percentY"
            r5.setValue(r9, r7)
            androidx.constraintlayout.motion.widget.KeyPosition r7 = new androidx.constraintlayout.motion.widget.KeyPosition
            r7.<init>()
            int r10 = r0.mMotionEffectEnd
            r7.setFramePosition(r10)
            r7.setType(r6)
            r10 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r7.setValue(r8, r11)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r7.setValue(r9, r8)
            int r8 = r0.mMotionEffectTranslationX
            r9 = 0
            if (r8 <= 0) goto L_0x00bc
            androidx.constraintlayout.motion.widget.KeyAttributes r8 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r8.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r11 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r11.<init>()
            int r12 = r0.mMotionEffectTranslationX
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "translationX"
            r8.setValue(r13, r12)
            int r12 = r0.mMotionEffectEnd
            r8.setFramePosition(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r11.setValue(r13, r12)
            int r12 = r0.mMotionEffectEnd
            int r12 = r12 - r10
            r11.setFramePosition(r12)
            goto L_0x00be
        L_0x00bc:
            r8 = r9
            r11 = r8
        L_0x00be:
            int r12 = r0.mMotionEffectTranslationY
            if (r12 <= 0) goto L_0x00ea
            androidx.constraintlayout.motion.widget.KeyAttributes r9 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r9.<init>()
            androidx.constraintlayout.motion.widget.KeyAttributes r12 = new androidx.constraintlayout.motion.widget.KeyAttributes
            r12.<init>()
            int r13 = r0.mMotionEffectTranslationY
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "translationY"
            r9.setValue(r14, r13)
            int r13 = r0.mMotionEffectEnd
            r9.setFramePosition(r13)
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12.setValue(r14, r13)
            int r13 = r0.mMotionEffectEnd
            int r13 = r13 - r10
            r12.setFramePosition(r13)
            goto L_0x00eb
        L_0x00ea:
            r12 = r9
        L_0x00eb:
            int r13 = r0.mFadeMove
            r16 = 0
            r6 = -1
            r17 = 0
            if (r13 != r6) goto L_0x0157
            r13 = 4
            int[] r6 = new int[r13]
            r15 = 0
            r18 = 3
            r19 = 2
        L_0x00fc:
            int r14 = r2.length
            if (r15 >= r14) goto L_0x0145
            r14 = r2[r15]
            java.lang.Object r14 = r1.get(r14)
            androidx.constraintlayout.motion.widget.MotionController r14 = (androidx.constraintlayout.motion.widget.MotionController) r14
            if (r14 != 0) goto L_0x010a
            goto L_0x0142
        L_0x010a:
            float r20 = r14.getFinalX()
            float r21 = r14.getStartX()
            float r20 = r20 - r21
            float r21 = r14.getFinalY()
            float r14 = r14.getStartY()
            float r21 = r21 - r14
            int r14 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0127
            r14 = r6[r10]
            int r14 = r14 + r10
            r6[r10] = r14
        L_0x0127:
            int r14 = (r21 > r17 ? 1 : (r21 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x0130
            r14 = r6[r16]
            int r14 = r14 + r10
            r6[r16] = r14
        L_0x0130:
            int r14 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x0139
            r14 = r6[r18]
            int r14 = r14 + r10
            r6[r18] = r14
        L_0x0139:
            int r14 = (r20 > r17 ? 1 : (r20 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0142
            r14 = r6[r19]
            int r14 = r14 + r10
            r6[r19] = r14
        L_0x0142:
            int r15 = r15 + 1
            goto L_0x00fc
        L_0x0145:
            r14 = r6[r16]
            r15 = r14
            r14 = 0
        L_0x0149:
            if (r10 >= r13) goto L_0x0155
            r13 = r6[r10]
            if (r15 >= r13) goto L_0x0151
            r14 = r10
            r15 = r13
        L_0x0151:
            int r10 = r10 + 1
            r13 = 4
            goto L_0x0149
        L_0x0155:
            r13 = r14
            goto L_0x015b
        L_0x0157:
            r18 = 3
            r19 = 2
        L_0x015b:
            r6 = 0
        L_0x015c:
            int r10 = r2.length
            if (r6 >= r10) goto L_0x01fb
            r10 = r2[r6]
            java.lang.Object r10 = r1.get(r10)
            androidx.constraintlayout.motion.widget.MotionController r10 = (androidx.constraintlayout.motion.widget.MotionController) r10
            if (r10 != 0) goto L_0x016e
        L_0x0169:
            r1 = r23
            r15 = -1
            goto L_0x01f1
        L_0x016e:
            float r14 = r10.getFinalX()
            float r15 = r10.getStartX()
            float r14 = r14 - r15
            float r15 = r10.getFinalY()
            float r16 = r10.getStartY()
            float r15 = r15 - r16
            if (r13 != 0) goto L_0x0194
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 <= 0) goto L_0x0190
            boolean r15 = r0.mMotionEffectStrictMove
            if (r15 == 0) goto L_0x0192
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0190
            goto L_0x0192
        L_0x0190:
            r1 = 3
            goto L_0x01c4
        L_0x0192:
            r1 = 3
            goto L_0x01c3
        L_0x0194:
            r1 = 1
            if (r13 != r1) goto L_0x01a4
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x0190
            boolean r15 = r0.mMotionEffectStrictMove
            if (r15 == 0) goto L_0x0192
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0190
            goto L_0x0192
        L_0x01a4:
            r1 = 2
            if (r13 != r1) goto L_0x01b4
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 >= 0) goto L_0x0190
            boolean r14 = r0.mMotionEffectStrictMove
            if (r14 == 0) goto L_0x0192
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x0190
            goto L_0x0192
        L_0x01b4:
            r1 = 3
            if (r13 != r1) goto L_0x01c4
            int r14 = (r14 > r17 ? 1 : (r14 == r17 ? 0 : -1))
            if (r14 <= 0) goto L_0x01c4
            boolean r14 = r0.mMotionEffectStrictMove
            if (r14 == 0) goto L_0x0169
            int r14 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r14 != 0) goto L_0x01c4
        L_0x01c3:
            goto L_0x0169
        L_0x01c4:
            int r14 = r0.mViewTransitionId
            r15 = -1
            if (r14 != r15) goto L_0x01ec
            r10.addKey(r3)
            r10.addKey(r4)
            r10.addKey(r5)
            r10.addKey(r7)
            int r14 = r0.mMotionEffectTranslationX
            if (r14 <= 0) goto L_0x01df
            r10.addKey(r8)
            r10.addKey(r11)
        L_0x01df:
            int r14 = r0.mMotionEffectTranslationY
            if (r14 <= 0) goto L_0x01e9
            r10.addKey(r9)
            r10.addKey(r12)
        L_0x01e9:
            r1 = r23
            goto L_0x01f1
        L_0x01ec:
            r1 = r23
            r1.applyViewTransition(r14, r10)
        L_0x01f1:
            int r6 = r6 + 1
            r1 = r24
            r18 = 3
            r19 = 2
            goto L_0x015c
        L_0x01fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.onPreSetup(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        init(context, attributeSet);
    }
}
