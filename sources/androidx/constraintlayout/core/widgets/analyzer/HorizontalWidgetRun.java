package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

public class HorizontalWidgetRun extends WidgetRun {
    private static int[] sTempDimensions = new int[2];

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType[] r0 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType = r0
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r1 = androidx.constraintlayout.core.widgets.analyzer.WidgetRun.RunType.CENTER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.<clinit>():void");
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.mType = DependencyNode.Type.LEFT;
        this.end.mType = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] iArr, int i4, int i5, int i6, int i7, float f4, int i8) {
        int i9 = i5 - i4;
        int i10 = i7 - i6;
        if (i8 == -1) {
            int i11 = (int) ((((float) i10) * f4) + 0.5f);
            int i12 = (int) ((((float) i9) / f4) + 0.5f);
            if (i11 <= i9) {
                iArr[0] = i11;
                iArr[1] = i10;
            } else if (i12 <= i10) {
                iArr[0] = i9;
                iArr[1] = i12;
            }
        } else if (i8 == 0) {
            iArr[0] = (int) ((((float) i10) * f4) + 0.5f);
            iArr[1] = i10;
        } else if (i8 == 1) {
            iArr[0] = i9;
            iArr[1] = (int) ((((float) i9) * f4) + 0.5f);
        }
    }

    /* access modifiers changed from: package-private */
    public void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.mWidget;
        if (constraintWidget.measured) {
            this.mDimension.resolve(constraintWidget.getWidth());
        }
        if (!this.mDimension.resolved) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.mWidget.getHorizontalDimensionBehaviour();
            this.mDimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (horizontalDimensionBehaviour == dimensionBehaviour && (parent2 = this.mWidget.getParent()) != null && (parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour)) {
                    int width = (parent2.getWidth() - this.mWidget.mLeft.getMargin()) - this.mWidget.mRight.getMargin();
                    addTarget(this.start, parent2.mHorizontalRun.start, this.mWidget.mLeft.getMargin());
                    addTarget(this.end, parent2.mHorizontalRun.end, -this.mWidget.mRight.getMargin());
                    this.mDimension.resolve(width);
                    return;
                } else if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.mDimension.resolve(this.mWidget.getWidth());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.mDimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (parent = this.mWidget.getParent()) != null && (parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || parent.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
                addTarget(this.start, parent.mHorizontalRun.start, this.mWidget.mLeft.getMargin());
                addTarget(this.end, parent.mHorizontalRun.end, -this.mWidget.mRight.getMargin());
                return;
            }
        }
        DimensionDependency dimensionDependency = this.mDimension;
        if (dimensionDependency.resolved) {
            ConstraintWidget constraintWidget2 = this.mWidget;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 == null || constraintAnchorArr[1].mTarget == null) {
                    if (constraintAnchor2 != null) {
                        DependencyNode target = getTarget(constraintAnchor);
                        if (target != null) {
                            addTarget(this.start, target, this.mWidget.mListAnchors[0].getMargin());
                            addTarget(this.end, this.start, this.mDimension.value);
                            return;
                        }
                        return;
                    }
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                    if (constraintAnchor3.mTarget != null) {
                        DependencyNode target2 = getTarget(constraintAnchor3);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.mWidget.mListAnchors[1].getMargin());
                            addTarget(this.start, this.end, -this.mDimension.value);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.mWidget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                        addTarget(this.start, this.mWidget.getParent().mHorizontalRun.start, this.mWidget.getX());
                        addTarget(this.end, this.start, this.mDimension.value);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget2.isInHorizontalChain()) {
                    this.start.mMargin = this.mWidget.mListAnchors[0].getMargin();
                    this.end.mMargin = -this.mWidget.mListAnchors[1].getMargin();
                    return;
                } else {
                    DependencyNode target3 = getTarget(this.mWidget.mListAnchors[0]);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.mWidget.mListAnchors[0].getMargin());
                    }
                    DependencyNode target4 = getTarget(this.mWidget.mListAnchors[1]);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.mWidget.mListAnchors[1].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
            }
        }
        if (this.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.mWidget;
            int i4 = constraintWidget3.mMatchConstraintDefaultWidth;
            if (i4 == 2) {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    DimensionDependency dimensionDependency2 = parent3.mVerticalRun.mDimension;
                    this.mDimension.mTargets.add(dimensionDependency2);
                    dimensionDependency2.mDependencies.add(this.mDimension);
                    DimensionDependency dimensionDependency3 = this.mDimension;
                    dimensionDependency3.delegateToWidgetRun = true;
                    dimensionDependency3.mDependencies.add(this.start);
                    this.mDimension.mDependencies.add(this.end);
                }
            } else if (i4 == 3) {
                if (constraintWidget3.mMatchConstraintDefaultHeight == 3) {
                    this.start.updateDelegate = this;
                    this.end.updateDelegate = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget3.mVerticalRun;
                    verticalWidgetRun.start.updateDelegate = this;
                    verticalWidgetRun.end.updateDelegate = this;
                    dimensionDependency.updateDelegate = this;
                    if (constraintWidget3.isInVerticalChain()) {
                        this.mDimension.mTargets.add(this.mWidget.mVerticalRun.mDimension);
                        this.mWidget.mVerticalRun.mDimension.mDependencies.add(this.mDimension);
                        VerticalWidgetRun verticalWidgetRun2 = this.mWidget.mVerticalRun;
                        verticalWidgetRun2.mDimension.updateDelegate = this;
                        this.mDimension.mTargets.add(verticalWidgetRun2.start);
                        this.mDimension.mTargets.add(this.mWidget.mVerticalRun.end);
                        this.mWidget.mVerticalRun.start.mDependencies.add(this.mDimension);
                        this.mWidget.mVerticalRun.end.mDependencies.add(this.mDimension);
                    } else if (this.mWidget.isInHorizontalChain()) {
                        this.mWidget.mVerticalRun.mDimension.mTargets.add(this.mDimension);
                        this.mDimension.mDependencies.add(this.mWidget.mVerticalRun.mDimension);
                    } else {
                        this.mWidget.mVerticalRun.mDimension.mTargets.add(this.mDimension);
                    }
                } else {
                    DimensionDependency dimensionDependency4 = constraintWidget3.mVerticalRun.mDimension;
                    dimensionDependency.mTargets.add(dimensionDependency4);
                    dimensionDependency4.mDependencies.add(this.mDimension);
                    this.mWidget.mVerticalRun.start.mDependencies.add(this.mDimension);
                    this.mWidget.mVerticalRun.end.mDependencies.add(this.mDimension);
                    DimensionDependency dimensionDependency5 = this.mDimension;
                    dimensionDependency5.delegateToWidgetRun = true;
                    dimensionDependency5.mDependencies.add(this.start);
                    this.mDimension.mDependencies.add(this.end);
                    this.start.mTargets.add(this.mDimension);
                    this.end.mTargets.add(this.mDimension);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.mWidget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.mListAnchors;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
        if (constraintAnchor5 == null || constraintAnchorArr2[1].mTarget == null) {
            if (constraintAnchor5 != null) {
                DependencyNode target5 = getTarget(constraintAnchor4);
                if (target5 != null) {
                    addTarget(this.start, target5, this.mWidget.mListAnchors[0].getMargin());
                    addTarget(this.end, this.start, 1, this.mDimension);
                    return;
                }
                return;
            }
            ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
            if (constraintAnchor6.mTarget != null) {
                DependencyNode target6 = getTarget(constraintAnchor6);
                if (target6 != null) {
                    addTarget(this.end, target6, -this.mWidget.mListAnchors[1].getMargin());
                    addTarget(this.start, this.end, -1, this.mDimension);
                }
            } else if (!(constraintWidget4 instanceof Helper) && constraintWidget4.getParent() != null) {
                addTarget(this.start, this.mWidget.getParent().mHorizontalRun.start, this.mWidget.getX());
                addTarget(this.end, this.start, 1, this.mDimension);
            }
        } else if (constraintWidget4.isInHorizontalChain()) {
            this.start.mMargin = this.mWidget.mListAnchors[0].getMargin();
            this.end.mMargin = -this.mWidget.mListAnchors[1].getMargin();
        } else {
            DependencyNode target7 = getTarget(this.mWidget.mListAnchors[0]);
            DependencyNode target8 = getTarget(this.mWidget.mListAnchors[1]);
            if (target7 != null) {
                target7.addDependency(this);
            }
            if (target8 != null) {
                target8.addDependency(this);
            }
            this.mRunType = WidgetRun.RunType.CENTER;
        }
    }

    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.mWidget.setX(dependencyNode.value);
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.mRunGroup = null;
        this.start.clear();
        this.end.clear();
        this.mDimension.clear();
        this.mResolved = false;
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.mResolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.mDimension.resolved = false;
    }

    /* access modifiers changed from: package-private */
    public boolean supportsWrapComputation() {
        if (this.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.mWidget.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "HorizontalRun " + this.mWidget.getDebugName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02a8, code lost:
        if (r7 != 1) goto L_0x030f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void update(androidx.constraintlayout.core.widgets.analyzer.Dependency r14) {
        /*
            r13 = this;
            int[] r1 = androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$widgets$analyzer$WidgetRun$RunType
            androidx.constraintlayout.core.widgets.analyzer.WidgetRun$RunType r2 = r13.mRunType
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 2
            r3 = 3
            r8 = 1
            r9 = 0
            if (r1 == r8) goto L_0x0023
            if (r1 == r2) goto L_0x001f
            if (r1 == r3) goto L_0x0015
            goto L_0x0026
        L_0x0015:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r1.mRight
            r13.updateRunCenter(r14, r2, r1, r9)
            return
        L_0x001f:
            r13.updateRunEnd(r14)
            goto L_0x0026
        L_0x0023:
            r13.updateRunStart(r14)
        L_0x0026:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            boolean r1 = r1.resolved
            r10 = 1056964608(0x3f000000, float:0.5)
            if (r1 != 0) goto L_0x030f
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r13.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r4) goto L_0x030f
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            int r4 = r1.mMatchConstraintDefaultWidth
            if (r4 == r2) goto L_0x02f1
            if (r4 == r3) goto L_0x003e
            goto L_0x030f
        L_0x003e:
            int r2 = r1.mMatchConstraintDefaultHeight
            r4 = -1
            if (r2 == 0) goto L_0x0088
            if (r2 != r3) goto L_0x0046
            goto L_0x0088
        L_0x0046:
            int r1 = r1.getDimensionRatioSide()
            if (r1 == r4) goto L_0x0073
            if (r1 == 0) goto L_0x0064
            if (r1 == r8) goto L_0x0052
            r1 = 0
            goto L_0x0081
        L_0x0052:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r2.mDimension
            int r2 = r2.value
            float r2 = (float) r2
            float r1 = r1.getDimensionRatio()
        L_0x005f:
            float r2 = r2 * r1
        L_0x0061:
            float r2 = r2 + r10
            int r1 = (int) r2
            goto L_0x0081
        L_0x0064:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r2.mDimension
            int r2 = r2.value
            float r2 = (float) r2
            float r1 = r1.getDimensionRatio()
            float r2 = r2 / r1
            goto L_0x0061
        L_0x0073:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r2.mDimension
            int r2 = r2.value
            float r2 = (float) r2
            float r1 = r1.getDimensionRatio()
            goto L_0x005f
        L_0x0081:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r13.mDimension
            r2.resolve(r1)
            goto L_0x030f
        L_0x0088:
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r2 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r11 = r2.start
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r12 = r2.end
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r1.mLeft
            androidx.constraintlayout.core.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0096
            r2 = 1
            goto L_0x0097
        L_0x0096:
            r2 = 0
        L_0x0097:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r1.mTop
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x009f
            r3 = 1
            goto L_0x00a0
        L_0x009f:
            r3 = 0
        L_0x00a0:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r1.mRight
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.mTarget
            if (r5 == 0) goto L_0x00a8
            r5 = 1
            goto L_0x00a9
        L_0x00a8:
            r5 = 0
        L_0x00a9:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r1.mBottom
            androidx.constraintlayout.core.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x00b1
            r6 = 1
            goto L_0x00b2
        L_0x00b1:
            r6 = 0
        L_0x00b2:
            int r7 = r1.getDimensionRatioSide()
            if (r2 == 0) goto L_0x01ec
            if (r3 == 0) goto L_0x01ec
            if (r5 == 0) goto L_0x01ec
            if (r6 == 0) goto L_0x01ec
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            float r6 = r1.getDimensionRatio()
            boolean r1 = r11.resolved
            if (r1 == 0) goto L_0x0123
            boolean r1 = r12.resolved
            if (r1 == 0) goto L_0x0123
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.start
            boolean r2 = r1.readyToSolve
            if (r2 == 0) goto L_0x0432
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.end
            boolean r2 = r2.readyToSolve
            if (r2 != 0) goto L_0x00da
            goto L_0x0432
        L_0x00da:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.start
            int r2 = r2.mMargin
            int r2 = r2 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r13.end
            int r3 = r3.mMargin
            int r3 = r1 - r3
            int r1 = r11.value
            int r4 = r11.mMargin
            int r4 = r4 + r1
            int r1 = r12.value
            int r5 = r12.mMargin
            int r5 = r1 - r5
            int[] r1 = sTempDimensions
            r0 = r13
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            int[] r2 = sTempDimensions
            r2 = r2[r9]
            r1.resolve(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            int[] r2 = sTempDimensions
            r2 = r2[r8]
            r1.resolve(r2)
            return
        L_0x0123:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.start
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x017c
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.end
            boolean r3 = r2.resolved
            if (r3 == 0) goto L_0x017c
            boolean r3 = r11.readyToSolve
            if (r3 == 0) goto L_0x0432
            boolean r3 = r12.readyToSolve
            if (r3 != 0) goto L_0x0139
            goto L_0x0432
        L_0x0139:
            int r3 = r1.value
            int r1 = r1.mMargin
            int r3 = r3 + r1
            int r1 = r2.value
            int r2 = r2.mMargin
            int r1 = r1 - r2
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r11.mTargets
            java.lang.Object r2 = r2.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.value
            int r4 = r11.mMargin
            int r4 = r4 + r2
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r12.mTargets
            java.lang.Object r2 = r2.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.value
            int r5 = r12.mMargin
            int r5 = r2 - r5
            r2 = r3
            r3 = r1
            int[] r1 = sTempDimensions
            r0 = r13
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            int[] r2 = sTempDimensions
            r2 = r2[r9]
            r1.resolve(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            int[] r2 = sTempDimensions
            r2 = r2[r8]
            r1.resolve(r2)
        L_0x017c:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.start
            boolean r2 = r1.readyToSolve
            if (r2 == 0) goto L_0x0432
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.end
            boolean r2 = r2.readyToSolve
            if (r2 == 0) goto L_0x0432
            boolean r2 = r11.readyToSolve
            if (r2 == 0) goto L_0x0432
            boolean r2 = r12.readyToSolve
            if (r2 != 0) goto L_0x0192
            goto L_0x0432
        L_0x0192:
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.start
            int r2 = r2.mMargin
            int r2 = r2 + r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r13.end
            int r3 = r3.mMargin
            int r3 = r1 - r3
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r11.mTargets
            java.lang.Object r1 = r1.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.value
            int r4 = r11.mMargin
            int r4 = r4 + r1
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r12.mTargets
            java.lang.Object r1 = r1.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            int r1 = r1.value
            int r5 = r12.mMargin
            int r5 = r1 - r5
            int[] r1 = sTempDimensions
            r0 = r13
            r0.computeInsetRatio(r1, r2, r3, r4, r5, r6, r7)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            int[] r2 = sTempDimensions
            r2 = r2[r9]
            r1.resolve(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            int[] r2 = sTempDimensions
            r2 = r2[r8]
            r1.resolve(r2)
            goto L_0x030f
        L_0x01ec:
            if (r2 == 0) goto L_0x0276
            if (r5 == 0) goto L_0x0276
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.start
            boolean r1 = r1.readyToSolve
            if (r1 == 0) goto L_0x0432
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.end
            boolean r1 = r1.readyToSolve
            if (r1 != 0) goto L_0x01fe
            goto L_0x0432
        L_0x01fe:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            float r1 = r1.getDimensionRatio()
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r2.mTargets
            java.lang.Object r2 = r2.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r13.start
            int r3 = r3.mMargin
            int r2 = r2 + r3
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r13.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r3.mTargets
            java.lang.Object r3 = r3.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r3
            int r3 = r3.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r13.end
            int r5 = r5.mMargin
            int r3 = r3 - r5
            if (r7 == r4) goto L_0x0252
            if (r7 == 0) goto L_0x0252
            if (r7 == r8) goto L_0x022e
            goto L_0x030f
        L_0x022e:
            int r3 = r3 - r2
            int r2 = r13.getLimitedDimension(r3, r9)
            float r3 = (float) r2
            float r3 = r3 / r1
            float r3 = r3 + r10
            int r3 = (int) r3
            int r4 = r13.getLimitedDimension(r3, r8)
            if (r3 == r4) goto L_0x0242
            float r2 = (float) r4
            float r2 = r2 * r1
            float r2 = r2 + r10
            int r2 = (int) r2
        L_0x0242:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            r1.resolve(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            r1.resolve(r4)
            goto L_0x030f
        L_0x0252:
            int r3 = r3 - r2
            int r2 = r13.getLimitedDimension(r3, r9)
            float r3 = (float) r2
            float r3 = r3 * r1
            float r3 = r3 + r10
            int r3 = (int) r3
            int r4 = r13.getLimitedDimension(r3, r8)
            if (r3 == r4) goto L_0x0266
            float r2 = (float) r4
            float r2 = r2 / r1
            float r2 = r2 + r10
            int r2 = (int) r2
        L_0x0266:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            r1.resolve(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            r1.resolve(r4)
            goto L_0x030f
        L_0x0276:
            if (r3 == 0) goto L_0x030f
            if (r6 == 0) goto L_0x030f
            boolean r1 = r11.readyToSolve
            if (r1 == 0) goto L_0x0432
            boolean r1 = r12.readyToSolve
            if (r1 != 0) goto L_0x0284
            goto L_0x0432
        L_0x0284:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            float r1 = r1.getDimensionRatio()
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r11.mTargets
            java.lang.Object r2 = r2.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r2 = r2.value
            int r3 = r11.mMargin
            int r2 = r2 + r3
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r3 = r12.mTargets
            java.lang.Object r3 = r3.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r3
            int r3 = r3.value
            int r5 = r12.mMargin
            int r3 = r3 - r5
            if (r7 == r4) goto L_0x02ce
            if (r7 == 0) goto L_0x02ab
            if (r7 == r8) goto L_0x02ce
            goto L_0x030f
        L_0x02ab:
            int r3 = r3 - r2
            int r2 = r13.getLimitedDimension(r3, r8)
            float r3 = (float) r2
            float r3 = r3 * r1
            float r3 = r3 + r10
            int r3 = (int) r3
            int r4 = r13.getLimitedDimension(r3, r9)
            if (r3 == r4) goto L_0x02bf
            float r2 = (float) r4
            float r2 = r2 / r1
            float r2 = r2 + r10
            int r2 = (int) r2
        L_0x02bf:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            r1.resolve(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            r1.resolve(r2)
            goto L_0x030f
        L_0x02ce:
            int r3 = r3 - r2
            int r2 = r13.getLimitedDimension(r3, r8)
            float r3 = (float) r2
            float r3 = r3 / r1
            float r3 = r3 + r10
            int r3 = (int) r3
            int r4 = r13.getLimitedDimension(r3, r9)
            if (r3 == r4) goto L_0x02e2
            float r2 = (float) r4
            float r2 = r2 * r1
            float r2 = r2 + r10
            int r2 = (int) r2
        L_0x02e2:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            r1.resolve(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun r1 = r1.mVerticalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            r1.resolve(r2)
            goto L_0x030f
        L_0x02f1:
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.getParent()
            if (r1 == 0) goto L_0x030f
            androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun r1 = r1.mHorizontalRun
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r1.mDimension
            boolean r2 = r1.resolved
            if (r2 == 0) goto L_0x030f
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r13.mWidget
            float r2 = r2.mMatchConstraintPercentWidth
            int r1 = r1.value
            float r1 = (float) r1
            float r1 = r1 * r2
            float r1 = r1 + r10
            int r1 = (int) r1
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r13.mDimension
            r2.resolve(r1)
        L_0x030f:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.start
            boolean r2 = r1.readyToSolve
            if (r2 == 0) goto L_0x0432
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.end
            boolean r3 = r2.readyToSolve
            if (r3 != 0) goto L_0x031d
            goto L_0x0432
        L_0x031d:
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x032d
            boolean r1 = r2.resolved
            if (r1 == 0) goto L_0x032d
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            boolean r1 = r1.resolved
            if (r1 == 0) goto L_0x032d
            goto L_0x0432
        L_0x032d:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            boolean r1 = r1.resolved
            if (r1 != 0) goto L_0x0377
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r13.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r2) goto L_0x0377
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r13.mWidget
            int r2 = r1.mMatchConstraintDefaultWidth
            if (r2 != 0) goto L_0x0377
            boolean r1 = r1.isInHorizontalChain()
            if (r1 != 0) goto L_0x0377
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r2.mTargets
            java.lang.Object r2 = r2.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r13.start
            int r4 = r3.mMargin
            int r1 = r1 + r4
            int r2 = r2.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r13.end
            int r4 = r4.mMargin
            int r2 = r2 + r4
            int r4 = r2 - r1
            r3.resolve(r1)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.end
            r1.resolve(r2)
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            r1.resolve(r4)
            return
        L_0x0377:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            boolean r1 = r1.resolved
            if (r1 != 0) goto L_0x03db
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = r13.mDimensionBehavior
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r1 != r2) goto L_0x03db
            int r1 = r13.matchConstraintsType
            if (r1 != r8) goto L_0x03db
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x03db
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x03db
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r2.mTargets
            java.lang.Object r2 = r2.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r1 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r13.start
            int r3 = r3.mMargin
            int r1 = r1 + r3
            int r2 = r2.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r3 = r13.end
            int r3 = r3.mMargin
            int r2 = r2 + r3
            int r2 = r2 - r1
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            int r1 = r1.wrapValue
            int r1 = java.lang.Math.min(r2, r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r13.mWidget
            int r3 = r2.mMatchConstraintMaxWidth
            int r2 = r2.mMatchConstraintMinWidth
            int r1 = java.lang.Math.max(r2, r1)
            if (r3 <= 0) goto L_0x03d6
            int r1 = java.lang.Math.min(r3, r1)
        L_0x03d6:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r2 = r13.mDimension
            r2.resolve(r1)
        L_0x03db:
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            boolean r1 = r1.resolved
            if (r1 != 0) goto L_0x03e2
            goto L_0x0432
        L_0x03e2:
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.start
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r1 = r1.mTargets
            java.lang.Object r1 = r1.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.end
            java.util.List<androidx.constraintlayout.core.widgets.analyzer.DependencyNode> r2 = r2.mTargets
            java.lang.Object r2 = r2.get(r9)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = (androidx.constraintlayout.core.widgets.analyzer.DependencyNode) r2
            int r3 = r1.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r4 = r13.start
            int r4 = r4.mMargin
            int r3 = r3 + r4
            int r4 = r2.value
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r5 = r13.end
            int r5 = r5.mMargin
            int r4 = r4 + r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r13.mWidget
            float r5 = r5.getHorizontalBiasPercent()
            if (r1 != r2) goto L_0x0412
            int r3 = r1.value
            int r4 = r2.value
            r5 = 1056964608(0x3f000000, float:0.5)
        L_0x0412:
            int r4 = r4 - r3
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r1 = r13.mDimension
            int r1 = r1.value
            int r4 = r4 - r1
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.start
            float r2 = (float) r3
            float r2 = r2 + r10
            float r3 = (float) r4
            float r3 = r3 * r5
            float r2 = r2 + r3
            int r2 = (int) r2
            r1.resolve(r2)
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r1 = r13.end
            androidx.constraintlayout.core.widgets.analyzer.DependencyNode r2 = r13.start
            int r2 = r2.value
            androidx.constraintlayout.core.widgets.analyzer.DimensionDependency r3 = r13.mDimension
            int r3 = r3.value
            int r2 = r2 + r3
            r1.resolve(r2)
        L_0x0432:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.update(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }
}
