package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import java.util.ArrayList;

public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i4) {
        int i5;
        ChainHead[] chainHeadArr;
        int i6;
        if (i4 == 0) {
            i6 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i5 = 0;
        } else {
            i6 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i5 = 2;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            ChainHead chainHead = chainHeadArr[i7];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i4, i5, chainHead);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v2, resolved type: androidx.constraintlayout.core.widgets.ConstraintWidget} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v3, resolved type: androidx.constraintlayout.core.SolverVariable} */
    /* JADX WARNING: type inference failed for: r6v12, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        if (r8 == 2) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
        if (r8 == 2) goto L_0x0033;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x025d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02b1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0399  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x046a  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x04a4 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:284:0x04bd  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x04c0  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x04c6  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x04c9  */
    /* JADX WARNING: Removed duplicated region for block: B:291:0x04cd  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x04dd  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x04e1 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0385 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:320:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.core.LinearSystem r38, int r39, int r40, androidx.constraintlayout.core.widgets.ChainHead r41) {
        /*
            r0 = r37
            r1 = r38
            r9 = r39
            r2 = r41
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = r2.mFirst
            androidx.constraintlayout.core.widgets.ConstraintWidget r11 = r2.mLast
            androidx.constraintlayout.core.widgets.ConstraintWidget r12 = r2.mFirstVisibleWidget
            androidx.constraintlayout.core.widgets.ConstraintWidget r13 = r2.mLastVisibleWidget
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r2.mHead
            float r4 = r2.mTotalWeight
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r0.mListDimensionBehaviors
            r5 = r5[r9]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r14 = 1
            if (r5 != r6) goto L_0x001f
            r5 = 1
            goto L_0x0020
        L_0x001f:
            r5 = 0
        L_0x0020:
            r6 = 2
            if (r9 != 0) goto L_0x0039
            int r8 = r3.mHorizontalChainStyle
            if (r8 != 0) goto L_0x0029
            r15 = 1
            goto L_0x002a
        L_0x0029:
            r15 = 0
        L_0x002a:
            if (r8 != r14) goto L_0x002f
            r16 = 1
            goto L_0x0031
        L_0x002f:
            r16 = 0
        L_0x0031:
            if (r8 != r6) goto L_0x0035
        L_0x0033:
            r6 = 1
            goto L_0x0036
        L_0x0035:
            r6 = 0
        L_0x0036:
            r14 = r10
            r8 = 0
            goto L_0x004a
        L_0x0039:
            int r8 = r3.mVerticalChainStyle
            if (r8 != 0) goto L_0x003f
            r15 = 1
            goto L_0x0040
        L_0x003f:
            r15 = 0
        L_0x0040:
            if (r8 != r14) goto L_0x0045
            r16 = 1
            goto L_0x0047
        L_0x0045:
            r16 = 0
        L_0x0047:
            if (r8 != r6) goto L_0x0035
            goto L_0x0033
        L_0x004a:
            r19 = r4
            r22 = 0
            if (r8 != 0) goto L_0x0130
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            r4 = r4[r40]
            if (r6 == 0) goto L_0x0059
            r20 = 1
            goto L_0x005b
        L_0x0059:
            r20 = 4
        L_0x005b:
            int r23 = r4.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r14.mListDimensionBehaviors
            r7 = r7[r9]
            r24 = r5
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r7 != r5) goto L_0x0073
            int[] r7 = r14.mResolvedMatchConstraintDefault
            r7 = r7[r9]
            if (r7 != 0) goto L_0x0073
            r7 = 1
        L_0x0070:
            r25 = r6
            goto L_0x0075
        L_0x0073:
            r7 = 0
            goto L_0x0070
        L_0x0075:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r4.mTarget
            if (r6 == 0) goto L_0x0081
            if (r14 == r10) goto L_0x0081
            int r6 = r6.getMargin()
            int r23 = r23 + r6
        L_0x0081:
            r6 = r23
            if (r25 == 0) goto L_0x008b
            if (r14 == r10) goto L_0x008b
            if (r14 == r12) goto L_0x008b
            r20 = 8
        L_0x008b:
            r23 = r7
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r4.mTarget
            if (r7 == 0) goto L_0x00cb
            if (r14 != r12) goto L_0x00a0
            r26 = r8
            androidx.constraintlayout.core.SolverVariable r8 = r4.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r7 = r7.mSolverVariable
            r27 = r15
            r15 = 6
            r1.addGreaterThan(r8, r7, r6, r15)
            goto L_0x00ad
        L_0x00a0:
            r26 = r8
            r27 = r15
            androidx.constraintlayout.core.SolverVariable r8 = r4.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r7 = r7.mSolverVariable
            r15 = 8
            r1.addGreaterThan(r8, r7, r6, r15)
        L_0x00ad:
            if (r23 == 0) goto L_0x00b3
            if (r25 != 0) goto L_0x00b3
            r20 = 5
        L_0x00b3:
            if (r14 != r12) goto L_0x00bf
            if (r25 == 0) goto L_0x00bf
            boolean r7 = r14.isInBarrier(r9)
            if (r7 == 0) goto L_0x00bf
            r7 = 5
            goto L_0x00c1
        L_0x00bf:
            r7 = r20
        L_0x00c1:
            androidx.constraintlayout.core.SolverVariable r8 = r4.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            androidx.constraintlayout.core.SolverVariable r4 = r4.mSolverVariable
            r1.addEquality(r8, r4, r6, r7)
            goto L_0x00cf
        L_0x00cb:
            r26 = r8
            r27 = r15
        L_0x00cf:
            if (r24 == 0) goto L_0x0103
            int r4 = r14.getVisibility()
            r15 = 8
            if (r4 == r15) goto L_0x00f1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r4 = r14.mListDimensionBehaviors
            r4 = r4[r9]
            if (r4 != r5) goto L_0x00f1
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            int r5 = r40 + 1
            r5 = r4[r5]
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            r4 = r4[r40]
            androidx.constraintlayout.core.SolverVariable r4 = r4.mSolverVariable
            r6 = 0
            r7 = 5
            r1.addGreaterThan(r5, r4, r6, r7)
            goto L_0x00f2
        L_0x00f1:
            r6 = 0
        L_0x00f2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            r4 = r4[r40]
            androidx.constraintlayout.core.SolverVariable r4 = r4.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r0.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            r15 = 8
            r1.addGreaterThan(r4, r5, r6, r15)
        L_0x0103:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            int r5 = r40 + 1
            r4 = r4[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x011e
            androidx.constraintlayout.core.widgets.ConstraintWidget r4 = r4.mOwner
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r4.mListAnchors
            r5 = r5[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x011e
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.mOwner
            if (r5 == r14) goto L_0x011c
            goto L_0x011e
        L_0x011c:
            r22 = r4
        L_0x011e:
            if (r22 == 0) goto L_0x0125
            r14 = r22
            r8 = r26
            goto L_0x0126
        L_0x0125:
            r8 = 1
        L_0x0126:
            r4 = r19
            r5 = r24
            r6 = r25
            r15 = r27
            goto L_0x004a
        L_0x0130:
            r24 = r5
            r25 = r6
            r27 = r15
            if (r13 == 0) goto L_0x0194
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r11.mListAnchors
            int r5 = r40 + 1
            r4 = r4[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r4 = r4.mTarget
            if (r4 == 0) goto L_0x0194
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r13.mListAnchors
            r4 = r4[r5]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r6 = r13.mListDimensionBehaviors
            r6 = r6[r9]
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r7 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r7) goto L_0x016a
            int[] r6 = r13.mResolvedMatchConstraintDefault
            r6 = r6[r9]
            if (r6 != 0) goto L_0x016a
            if (r25 != 0) goto L_0x016a
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r4.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r6.mOwner
            if (r7 != r0) goto L_0x016a
            androidx.constraintlayout.core.SolverVariable r7 = r4.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            int r8 = r4.getMargin()
            int r8 = -r8
            r15 = 5
            r1.addEquality(r7, r6, r8, r15)
            goto L_0x0180
        L_0x016a:
            r15 = 5
            if (r25 == 0) goto L_0x0180
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r4.mTarget
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r6.mOwner
            if (r7 != r0) goto L_0x0180
            androidx.constraintlayout.core.SolverVariable r7 = r4.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            int r8 = r4.getMargin()
            int r8 = -r8
            r14 = 4
            r1.addEquality(r7, r6, r8, r14)
        L_0x0180:
            androidx.constraintlayout.core.SolverVariable r6 = r4.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r5 = r7[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            int r4 = r4.getMargin()
            int r4 = -r4
            r7 = 6
            r1.addLowerThan(r6, r5, r4, r7)
            goto L_0x0195
        L_0x0194:
            r15 = 5
        L_0x0195:
            if (r24 == 0) goto L_0x01ae
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r0.mListAnchors
            int r4 = r40 + 1
            r0 = r0[r4]
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r11.mListAnchors
            r4 = r5[r4]
            androidx.constraintlayout.core.SolverVariable r5 = r4.mSolverVariable
            int r4 = r4.getMargin()
            r6 = 8
            r1.addGreaterThan(r0, r5, r4, r6)
        L_0x01ae:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r2.mWeightedMatchConstraintsWidgets
            if (r0 == 0) goto L_0x025b
            int r4 = r0.size()
            r5 = 1
            if (r4 <= r5) goto L_0x025b
            boolean r5 = r2.mHasUndefinedWeights
            if (r5 == 0) goto L_0x01c7
            boolean r5 = r2.mHasComplexMatchWeights
            if (r5 != 0) goto L_0x01c7
            int r5 = r2.mWidgetsMatchCount
            float r5 = (float) r5
            r30 = r5
            goto L_0x01c9
        L_0x01c7:
            r30 = r19
        L_0x01c9:
            r5 = 0
            r7 = r22
            r6 = 0
            r29 = 0
        L_0x01cf:
            if (r6 >= r4) goto L_0x025b
            java.lang.Object r8 = r0.get(r6)
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r8
            float[] r14 = r8.mWeight
            r14 = r14[r9]
            int r19 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r19 >= 0) goto L_0x0200
            boolean r14 = r2.mHasComplexMatchWeights
            if (r14 == 0) goto L_0x01f8
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r8 = r8.mListAnchors
            int r14 = r40 + 1
            r14 = r8[r14]
            androidx.constraintlayout.core.SolverVariable r14 = r14.mSolverVariable
            r8 = r8[r40]
            androidx.constraintlayout.core.SolverVariable r8 = r8.mSolverVariable
            r37 = 0
            r5 = 0
            r15 = 4
            r1.addEquality(r14, r8, r5, r15)
            r14 = 0
            goto L_0x021b
        L_0x01f8:
            r37 = 0
            r15 = 4
            r14 = 1065353216(0x3f800000, float:1.0)
            r31 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0205
        L_0x0200:
            r37 = 0
            r15 = 4
            r31 = r14
        L_0x0205:
            int r5 = (r31 > r37 ? 1 : (r31 == r37 ? 0 : -1))
            if (r5 != 0) goto L_0x021e
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r8.mListAnchors
            int r8 = r40 + 1
            r8 = r5[r8]
            androidx.constraintlayout.core.SolverVariable r8 = r8.mSolverVariable
            r5 = r5[r40]
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            r14 = 0
            r15 = 8
            r1.addEquality(r8, r5, r14, r15)
        L_0x021b:
            r19 = r0
            goto L_0x0253
        L_0x021e:
            r14 = 0
            if (r7 == 0) goto L_0x024e
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r7.mListAnchors
            r7 = r5[r40]
            androidx.constraintlayout.core.SolverVariable r7 = r7.mSolverVariable
            int r15 = r40 + 1
            r5 = r5[r15]
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r14 = r8.mListAnchors
            r19 = r0
            r0 = r14[r40]
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            r14 = r14[r15]
            androidx.constraintlayout.core.SolverVariable r14 = r14.mSolverVariable
            androidx.constraintlayout.core.ArrayRow r28 = r1.createRow()
            r34 = r0
            r33 = r5
            r32 = r7
            r35 = r14
            r28.createRowEqualMatchDimensions(r29, r30, r31, r32, r33, r34, r35)
            r0 = r28
            r1.addConstraint(r0)
            goto L_0x0250
        L_0x024e:
            r19 = r0
        L_0x0250:
            r7 = r8
            r29 = r31
        L_0x0253:
            int r6 = r6 + 1
            r0 = r19
            r5 = 0
            r15 = 5
            goto L_0x01cf
        L_0x025b:
            if (r12 == 0) goto L_0x02af
            if (r12 == r13) goto L_0x0261
            if (r25 == 0) goto L_0x02af
        L_0x0261:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r10.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r11.mListAnchors
            int r4 = r40 + 1
            r2 = r2[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r0.mTarget
            if (r0 == 0) goto L_0x0272
            androidx.constraintlayout.core.SolverVariable r0 = r0.mSolverVariable
            goto L_0x0274
        L_0x0272:
            r0 = r22
        L_0x0274:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.mTarget
            if (r5 == 0) goto L_0x027b
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            goto L_0x027d
        L_0x027b:
            r5 = r22
        L_0x027d:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r12.mListAnchors
            r6 = r6[r40]
            if (r13 == 0) goto L_0x0287
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r4]
        L_0x0287:
            if (r0 == 0) goto L_0x02ab
            if (r5 == 0) goto L_0x02ab
            if (r9 != 0) goto L_0x0291
            float r3 = r3.mHorizontalBiasPercent
        L_0x028f:
            r4 = r3
            goto L_0x0294
        L_0x0291:
            float r3 = r3.mVerticalBiasPercent
            goto L_0x028f
        L_0x0294:
            int r3 = r6.getMargin()
            int r7 = r2.getMargin()
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            r8 = 7
            r36 = r2
            r2 = r0
            r0 = r1
            r1 = r6
            r6 = r36
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x02ab:
            r0 = r38
            goto L_0x04a2
        L_0x02af:
            if (r27 == 0) goto L_0x038b
            if (r12 == 0) goto L_0x038b
            int r0 = r2.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x02be
            int r1 = r2.mWidgetsCount
            if (r1 != r0) goto L_0x02be
            r18 = 1
            goto L_0x02c0
        L_0x02be:
            r18 = 0
        L_0x02c0:
            r14 = r12
            r15 = r14
        L_0x02c2:
            if (r14 == 0) goto L_0x02ab
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r9]
        L_0x02c8:
            if (r0 == 0) goto L_0x02d7
            int r1 = r0.getVisibility()
            r6 = 8
            if (r1 != r6) goto L_0x02d9
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r9]
            goto L_0x02c8
        L_0x02d7:
            r6 = 8
        L_0x02d9:
            if (r0 != 0) goto L_0x02e6
            if (r14 != r13) goto L_0x02de
            goto L_0x02e6
        L_0x02de:
            r19 = r0
            r9 = 8
            r21 = 5
            goto L_0x037e
        L_0x02e6:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            r1 = r1[r40]
            androidx.constraintlayout.core.SolverVariable r2 = r1.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x02f3
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            goto L_0x02f5
        L_0x02f3:
            r3 = r22
        L_0x02f5:
            if (r15 == r14) goto L_0x0300
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r4 = r40 + 1
            r3 = r3[r4]
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            goto L_0x030f
        L_0x0300:
            if (r14 != r12) goto L_0x030f
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r10.mListAnchors
            r3 = r3[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x030d
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            goto L_0x030f
        L_0x030d:
            r3 = r22
        L_0x030f:
            int r1 = r1.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            int r5 = r40 + 1
            r4 = r4[r5]
            int r4 = r4.getMargin()
            if (r0 == 0) goto L_0x0326
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r0.mListAnchors
            r7 = r7[r40]
            androidx.constraintlayout.core.SolverVariable r8 = r7.mSolverVariable
            goto L_0x0333
        L_0x0326:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r11.mListAnchors
            r7 = r7[r5]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r7 = r7.mTarget
            if (r7 == 0) goto L_0x0331
            androidx.constraintlayout.core.SolverVariable r8 = r7.mSolverVariable
            goto L_0x0333
        L_0x0331:
            r8 = r22
        L_0x0333:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r14.mListAnchors
            r6 = r6[r5]
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            if (r7 == 0) goto L_0x0340
            int r7 = r7.getMargin()
            int r4 = r4 + r7
        L_0x0340:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r15.mListAnchors
            r7 = r7[r5]
            int r7 = r7.getMargin()
            int r1 = r1 + r7
            if (r2 == 0) goto L_0x02de
            if (r3 == 0) goto L_0x02de
            if (r8 == 0) goto L_0x02de
            if (r6 == 0) goto L_0x02de
            if (r14 != r12) goto L_0x035b
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r1 = r1[r40]
            int r1 = r1.getMargin()
        L_0x035b:
            if (r14 != r13) goto L_0x0365
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r4 = r13.mListAnchors
            r4 = r4[r5]
            int r4 = r4.getMargin()
        L_0x0365:
            r7 = r4
            r5 = r8
            if (r18 == 0) goto L_0x036c
            r8 = 8
            goto L_0x036d
        L_0x036c:
            r8 = 5
        L_0x036d:
            r4 = 1056964608(0x3f000000, float:0.5)
            r9 = r3
            r3 = r1
            r1 = r2
            r2 = r9
            r19 = r0
            r9 = 8
            r21 = 5
            r0 = r38
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x037e:
            int r0 = r14.getVisibility()
            if (r0 == r9) goto L_0x0385
            r15 = r14
        L_0x0385:
            r9 = r39
            r14 = r19
            goto L_0x02c2
        L_0x038b:
            r9 = 8
            if (r16 == 0) goto L_0x02ab
            if (r12 == 0) goto L_0x02ab
            int r0 = r2.mWidgetsMatchCount
            if (r0 <= 0) goto L_0x039c
            int r1 = r2.mWidgetsCount
            if (r1 != r0) goto L_0x039c
            r18 = 1
            goto L_0x039e
        L_0x039c:
            r18 = 0
        L_0x039e:
            r14 = r12
            r15 = r14
        L_0x03a0:
            if (r14 == 0) goto L_0x044f
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r14.mNextChainWidget
            r0 = r0[r39]
        L_0x03a6:
            if (r0 == 0) goto L_0x03b3
            int r1 = r0.getVisibility()
            if (r1 != r9) goto L_0x03b3
            androidx.constraintlayout.core.widgets.ConstraintWidget[] r0 = r0.mNextChainWidget
            r0 = r0[r39]
            goto L_0x03a6
        L_0x03b3:
            if (r14 == r12) goto L_0x0441
            if (r14 == r13) goto L_0x0441
            if (r0 == 0) goto L_0x0441
            if (r0 != r13) goto L_0x03bd
            r0 = r22
        L_0x03bd:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            r1 = r1[r40]
            androidx.constraintlayout.core.SolverVariable r2 = r1.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x03c9
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
        L_0x03c9:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r15.mListAnchors
            int r4 = r40 + 1
            r3 = r3[r4]
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            int r1 = r1.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r5 = r14.mListAnchors
            r5 = r5[r4]
            int r5 = r5.getMargin()
            if (r0 == 0) goto L_0x03ef
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r0.mListAnchors
            r6 = r6[r40]
            androidx.constraintlayout.core.SolverVariable r7 = r6.mSolverVariable
            androidx.constraintlayout.core.widgets.ConstraintAnchor r8 = r6.mTarget
            if (r8 == 0) goto L_0x03ec
            androidx.constraintlayout.core.SolverVariable r8 = r8.mSolverVariable
            goto L_0x0400
        L_0x03ec:
            r8 = r22
            goto L_0x0400
        L_0x03ef:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r13.mListAnchors
            r6 = r6[r40]
            if (r6 == 0) goto L_0x03f8
            androidx.constraintlayout.core.SolverVariable r7 = r6.mSolverVariable
            goto L_0x03fa
        L_0x03f8:
            r7 = r22
        L_0x03fa:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r8 = r14.mListAnchors
            r8 = r8[r4]
            androidx.constraintlayout.core.SolverVariable r8 = r8.mSolverVariable
        L_0x0400:
            if (r6 == 0) goto L_0x0407
            int r6 = r6.getMargin()
            int r5 = r5 + r6
        L_0x0407:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r15.mListAnchors
            r4 = r6[r4]
            int r4 = r4.getMargin()
            int r1 = r1 + r4
            if (r18 == 0) goto L_0x0415
            r4 = 8
            goto L_0x0416
        L_0x0415:
            r4 = 4
        L_0x0416:
            if (r2 == 0) goto L_0x0438
            if (r3 == 0) goto L_0x0438
            if (r7 == 0) goto L_0x0438
            if (r8 == 0) goto L_0x0438
            r6 = r8
            r8 = r4
            r4 = 1056964608(0x3f000000, float:0.5)
            r19 = r3
            r3 = r1
            r1 = r2
            r2 = r19
            r19 = r7
            r7 = r5
            r5 = r19
            r19 = r0
            r20 = 4
            r0 = r38
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = r0
            goto L_0x043e
        L_0x0438:
            r1 = r38
            r19 = r0
            r20 = 4
        L_0x043e:
            r0 = r19
            goto L_0x0445
        L_0x0441:
            r1 = r38
            r20 = 4
        L_0x0445:
            int r2 = r14.getVisibility()
            if (r2 == r9) goto L_0x044c
            r15 = r14
        L_0x044c:
            r14 = r0
            goto L_0x03a0
        L_0x044f:
            r1 = r38
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r0 = r12.mListAnchors
            r0 = r0[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r2 = r2[r40]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            int r4 = r40 + 1
            r9 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r11.mListAnchors
            r3 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r10 = r3.mTarget
            r8 = 5
            if (r2 == 0) goto L_0x0477
            if (r12 == r13) goto L_0x0479
            androidx.constraintlayout.core.SolverVariable r3 = r0.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            int r0 = r0.getMargin()
            r1.addEquality(r3, r2, r0, r8)
        L_0x0477:
            r0 = r1
            goto L_0x0492
        L_0x0479:
            if (r10 == 0) goto L_0x0477
            androidx.constraintlayout.core.SolverVariable r1 = r0.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            int r3 = r0.getMargin()
            androidx.constraintlayout.core.SolverVariable r5 = r9.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r6 = r10.mSolverVariable
            int r7 = r9.getMargin()
            r4 = 1056964608(0x3f000000, float:0.5)
            r0 = r38
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0492:
            if (r10 == 0) goto L_0x04a2
            if (r12 == r13) goto L_0x04a2
            androidx.constraintlayout.core.SolverVariable r1 = r9.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r2 = r10.mSolverVariable
            int r3 = r9.getMargin()
            int r3 = -r3
            r0.addEquality(r1, r2, r3, r8)
        L_0x04a2:
            if (r27 != 0) goto L_0x04a6
            if (r16 == 0) goto L_0x0501
        L_0x04a6:
            if (r12 == 0) goto L_0x0501
            if (r12 == r13) goto L_0x0501
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r1 = r12.mListAnchors
            r2 = r1[r40]
            if (r13 != 0) goto L_0x04b1
            r13 = r12
        L_0x04b1:
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            r17 = 1
            int r4 = r40 + 1
            r3 = r3[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r2.mTarget
            if (r5 == 0) goto L_0x04c0
            androidx.constraintlayout.core.SolverVariable r5 = r5.mSolverVariable
            goto L_0x04c2
        L_0x04c0:
            r5 = r22
        L_0x04c2:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r3.mTarget
            if (r6 == 0) goto L_0x04c9
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            goto L_0x04cb
        L_0x04c9:
            r6 = r22
        L_0x04cb:
            if (r11 == r13) goto L_0x04db
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r6 = r11.mListAnchors
            r6 = r6[r4]
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x04d9
            androidx.constraintlayout.core.SolverVariable r6 = r6.mSolverVariable
            r22 = r6
        L_0x04d9:
            r6 = r22
        L_0x04db:
            if (r12 != r13) goto L_0x04df
            r3 = r1[r4]
        L_0x04df:
            if (r5 == 0) goto L_0x0501
            if (r6 == 0) goto L_0x0501
            int r1 = r2.getMargin()
            androidx.constraintlayout.core.widgets.ConstraintAnchor[] r7 = r13.mListAnchors
            r4 = r7[r4]
            int r7 = r4.getMargin()
            androidx.constraintlayout.core.SolverVariable r2 = r2.mSolverVariable
            androidx.constraintlayout.core.SolverVariable r3 = r3.mSolverVariable
            r8 = 5
            r4 = 1056964608(0x3f000000, float:0.5)
            r36 = r3
            r3 = r1
            r1 = r2
            r2 = r5
            r5 = r6
            r6 = r36
            r0.addCentering(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0501:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Chain.applyChainConstraints(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead):void");
    }
}
