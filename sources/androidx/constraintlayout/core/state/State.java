package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.state.helpers.AlignHorizontallyReference;
import androidx.constraintlayout.core.state.helpers.AlignVerticallyReference;
import androidx.constraintlayout.core.state.helpers.BarrierReference;
import androidx.constraintlayout.core.state.helpers.FlowReference;
import androidx.constraintlayout.core.state.helpers.GridReference;
import androidx.constraintlayout.core.state.helpers.GuidelineReference;
import androidx.constraintlayout.core.state.helpers.HorizontalChainReference;
import androidx.constraintlayout.core.state.helpers.VerticalChainReference;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import b.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class State {
    static final int CONSTRAINT_RATIO = 2;
    static final int CONSTRAINT_SPREAD = 0;
    static final int CONSTRAINT_WRAP = 1;
    public static final Integer PARENT = 0;
    static final int UNKNOWN = -1;
    ArrayList<Object> mBaselineNeeded;
    ArrayList<ConstraintWidget> mBaselineNeededWidgets;
    boolean mDirtyBaselineNeededWidgets;
    private CorePixelDp mDpToPixel;
    protected HashMap<Object, HelperReference> mHelperReferences = new HashMap<>();
    private boolean mIsLtr = true;
    private int mNumHelpers;
    public final ConstraintReference mParent;
    protected HashMap<Object, Reference> mReferences = new HashMap<>();
    HashMap<String, ArrayList<String>> mTags = new HashMap<>();

    public enum Chain {
        SPREAD,
        SPREAD_INSIDE,
        PACKED;
        
        public static Map<String, Chain> chainMap;
        public static Map<String, Integer> valueMap;

        static {
            Chain chain;
            Chain chain2;
            Chain chain3;
            chainMap = new HashMap();
            valueMap = new HashMap();
            chainMap.put("packed", chain3);
            chainMap.put("spread_inside", chain2);
            chainMap.put("spread", chain);
            valueMap.put("packed", 2);
            valueMap.put("spread_inside", 1);
            valueMap.put("spread", 0);
        }

        public static Chain getChainByString(String str) {
            if (chainMap.containsKey(str)) {
                return chainMap.get(str);
            }
            return null;
        }

        public static int getValueByString(String str) {
            if (valueMap.containsKey(str)) {
                return valueMap.get(str).intValue();
            }
            return -1;
        }
    }

    public enum Constraint {
        LEFT_TO_LEFT,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT,
        RIGHT_TO_RIGHT,
        START_TO_START,
        START_TO_END,
        END_TO_START,
        END_TO_END,
        TOP_TO_TOP,
        TOP_TO_BOTTOM,
        TOP_TO_BASELINE,
        BOTTOM_TO_TOP,
        BOTTOM_TO_BOTTOM,
        BOTTOM_TO_BASELINE,
        BASELINE_TO_BASELINE,
        BASELINE_TO_TOP,
        BASELINE_TO_BOTTOM,
        CENTER_HORIZONTALLY,
        CENTER_VERTICALLY,
        CIRCULAR_CONSTRAINT
    }

    public enum Direction {
        LEFT,
        RIGHT,
        START,
        END,
        TOP,
        BOTTOM
    }

    public enum Helper {
        HORIZONTAL_CHAIN,
        VERTICAL_CHAIN,
        ALIGN_HORIZONTALLY,
        ALIGN_VERTICALLY,
        BARRIER,
        LAYER,
        HORIZONTAL_FLOW,
        VERTICAL_FLOW,
        GRID,
        ROW,
        COLUMN,
        FLOW
    }

    public enum Wrap {
        NONE,
        CHAIN,
        ALIGNED;
        
        public static Map<String, Integer> valueMap;
        public static Map<String, Wrap> wrapMap;

        static {
            Wrap wrap;
            Wrap wrap2;
            Wrap wrap3;
            wrapMap = new HashMap();
            valueMap = new HashMap();
            wrapMap.put("none", wrap);
            wrapMap.put("chain", wrap2);
            wrapMap.put("aligned", wrap3);
            valueMap.put("none", 0);
            valueMap.put("chain", 3);
            valueMap.put("aligned", 2);
        }

        public static Wrap getChainByString(String str) {
            if (wrapMap.containsKey(str)) {
                return wrapMap.get(str);
            }
            return null;
        }

        public static int getValueByString(String str) {
            if (valueMap.containsKey(str)) {
                return valueMap.get(str).intValue();
            }
            return -1;
        }
    }

    public State() {
        ConstraintReference constraintReference = new ConstraintReference(this);
        this.mParent = constraintReference;
        this.mNumHelpers = 0;
        this.mBaselineNeeded = new ArrayList<>();
        this.mBaselineNeededWidgets = new ArrayList<>();
        this.mDirtyBaselineNeededWidgets = true;
        Integer num = PARENT;
        constraintReference.setKey(num);
        this.mReferences.put(num, constraintReference);
    }

    private String createHelperKey() {
        StringBuilder sb = new StringBuilder();
        sb.append("__HELPER_KEY_");
        int i4 = this.mNumHelpers;
        this.mNumHelpers = i4 + 1;
        sb.append(i4);
        sb.append("__");
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x014c, code lost:
        r2 = (androidx.constraintlayout.core.state.HelperReference) r0.getFacade();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void apply(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11) {
        /*
            r10 = this;
            r11.removeAllChildren()
            androidx.constraintlayout.core.state.ConstraintReference r0 = r10.mParent
            androidx.constraintlayout.core.state.Dimension r0 = r0.getWidth()
            r1 = 0
            r0.apply(r10, r11, r1)
            androidx.constraintlayout.core.state.ConstraintReference r0 = r10.mParent
            androidx.constraintlayout.core.state.Dimension r0 = r0.getHeight()
            r2 = 1
            r0.apply(r10, r11, r2)
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r0 = r10.mHelperReferences
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0021:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004b
            java.lang.Object r2 = r0.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r3 = r10.mHelperReferences
            java.lang.Object r3 = r3.get(r2)
            androidx.constraintlayout.core.state.HelperReference r3 = (androidx.constraintlayout.core.state.HelperReference) r3
            androidx.constraintlayout.core.widgets.HelperWidget r3 = r3.getHelperWidget()
            if (r3 == 0) goto L_0x0021
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r4 = r10.mReferences
            java.lang.Object r4 = r4.get(r2)
            androidx.constraintlayout.core.state.Reference r4 = (androidx.constraintlayout.core.state.Reference) r4
            if (r4 != 0) goto L_0x0047
            androidx.constraintlayout.core.state.ConstraintReference r4 = r10.constraints(r2)
        L_0x0047:
            r4.setConstraintWidget(r3)
            goto L_0x0021
        L_0x004b:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r0 = r10.mReferences
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0055:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r0.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r3 = r10.mReferences
            java.lang.Object r3 = r3.get(r2)
            androidx.constraintlayout.core.state.Reference r3 = (androidx.constraintlayout.core.state.Reference) r3
            androidx.constraintlayout.core.state.ConstraintReference r4 = r10.mParent
            if (r3 == r4) goto L_0x0055
            androidx.constraintlayout.core.state.helpers.Facade r4 = r3.getFacade()
            boolean r4 = r4 instanceof androidx.constraintlayout.core.state.HelperReference
            if (r4 == 0) goto L_0x0055
            androidx.constraintlayout.core.state.helpers.Facade r3 = r3.getFacade()
            androidx.constraintlayout.core.state.HelperReference r3 = (androidx.constraintlayout.core.state.HelperReference) r3
            androidx.constraintlayout.core.widgets.HelperWidget r3 = r3.getHelperWidget()
            if (r3 == 0) goto L_0x0055
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r4 = r10.mReferences
            java.lang.Object r4 = r4.get(r2)
            androidx.constraintlayout.core.state.Reference r4 = (androidx.constraintlayout.core.state.Reference) r4
            if (r4 != 0) goto L_0x008d
            androidx.constraintlayout.core.state.ConstraintReference r4 = r10.constraints(r2)
        L_0x008d:
            r4.setConstraintWidget(r3)
            goto L_0x0055
        L_0x0091:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r0 = r10.mReferences
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x009b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00d7
            java.lang.Object r2 = r0.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r3 = r10.mReferences
            java.lang.Object r2 = r3.get(r2)
            androidx.constraintlayout.core.state.Reference r2 = (androidx.constraintlayout.core.state.Reference) r2
            androidx.constraintlayout.core.state.ConstraintReference r3 = r10.mParent
            if (r2 == r3) goto L_0x00d3
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r2.getConstraintWidget()
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = r4.toString()
            r3.setDebugName(r4)
            r4 = 0
            r3.setParent(r4)
            androidx.constraintlayout.core.state.helpers.Facade r4 = r2.getFacade()
            boolean r4 = r4 instanceof androidx.constraintlayout.core.state.helpers.GuidelineReference
            if (r4 == 0) goto L_0x00cf
            r2.apply()
        L_0x00cf:
            r11.add((androidx.constraintlayout.core.widgets.ConstraintWidget) r3)
            goto L_0x009b
        L_0x00d3:
            r2.setConstraintWidget(r11)
            goto L_0x009b
        L_0x00d7:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r11 = r10.mHelperReferences
            java.util.Set r11 = r11.keySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x00e1:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x0124
            java.lang.Object r0 = r11.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.HelperReference> r2 = r10.mHelperReferences
            java.lang.Object r0 = r2.get(r0)
            androidx.constraintlayout.core.state.HelperReference r0 = (androidx.constraintlayout.core.state.HelperReference) r0
            androidx.constraintlayout.core.widgets.HelperWidget r2 = r0.getHelperWidget()
            if (r2 == 0) goto L_0x0120
            java.util.ArrayList<java.lang.Object> r2 = r0.mReferences
            int r3 = r2.size()
            r4 = 0
        L_0x0100:
            if (r4 >= r3) goto L_0x011c
            java.lang.Object r5 = r2.get(r4)
            int r4 = r4 + 1
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r6 = r10.mReferences
            java.lang.Object r5 = r6.get(r5)
            androidx.constraintlayout.core.state.Reference r5 = (androidx.constraintlayout.core.state.Reference) r5
            androidx.constraintlayout.core.widgets.HelperWidget r6 = r0.getHelperWidget()
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r5.getConstraintWidget()
            r6.add(r5)
            goto L_0x0100
        L_0x011c:
            r0.apply()
            goto L_0x00e1
        L_0x0120:
            r0.apply()
            goto L_0x00e1
        L_0x0124:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r11 = r10.mReferences
            java.util.Set r11 = r11.keySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x012e:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x01a2
            java.lang.Object r0 = r11.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r2 = r10.mReferences
            java.lang.Object r0 = r2.get(r0)
            androidx.constraintlayout.core.state.Reference r0 = (androidx.constraintlayout.core.state.Reference) r0
            androidx.constraintlayout.core.state.ConstraintReference r2 = r10.mParent
            if (r0 == r2) goto L_0x012e
            androidx.constraintlayout.core.state.helpers.Facade r2 = r0.getFacade()
            boolean r2 = r2 instanceof androidx.constraintlayout.core.state.HelperReference
            if (r2 == 0) goto L_0x012e
            androidx.constraintlayout.core.state.helpers.Facade r2 = r0.getFacade()
            androidx.constraintlayout.core.state.HelperReference r2 = (androidx.constraintlayout.core.state.HelperReference) r2
            androidx.constraintlayout.core.widgets.HelperWidget r3 = r2.getHelperWidget()
            if (r3 == 0) goto L_0x012e
            java.util.ArrayList<java.lang.Object> r2 = r2.mReferences
            int r4 = r2.size()
            r5 = 0
        L_0x015f:
            if (r5 >= r4) goto L_0x019e
            java.lang.Object r6 = r2.get(r5)
            int r5 = r5 + 1
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r7 = r10.mReferences
            java.lang.Object r7 = r7.get(r6)
            androidx.constraintlayout.core.state.Reference r7 = (androidx.constraintlayout.core.state.Reference) r7
            if (r7 == 0) goto L_0x0179
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r7.getConstraintWidget()
            r3.add(r6)
            goto L_0x015f
        L_0x0179:
            boolean r7 = r6 instanceof androidx.constraintlayout.core.state.Reference
            if (r7 == 0) goto L_0x0187
            androidx.constraintlayout.core.state.Reference r6 = (androidx.constraintlayout.core.state.Reference) r6
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = r6.getConstraintWidget()
            r3.add(r6)
            goto L_0x015f
        L_0x0187:
            java.io.PrintStream r7 = java.lang.System.out
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "couldn't find reference for "
            r8.append(r9)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            r7.println(r6)
            goto L_0x015f
        L_0x019e:
            r0.apply()
            goto L_0x012e
        L_0x01a2:
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r11 = r10.mReferences
            java.util.Set r11 = r11.keySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x01ac:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x01d0
            java.lang.Object r0 = r11.next()
            java.util.HashMap<java.lang.Object, androidx.constraintlayout.core.state.Reference> r1 = r10.mReferences
            java.lang.Object r1 = r1.get(r0)
            androidx.constraintlayout.core.state.Reference r1 = (androidx.constraintlayout.core.state.Reference) r1
            r1.apply()
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r1.getConstraintWidget()
            if (r1 == 0) goto L_0x01ac
            if (r0 == 0) goto L_0x01ac
            java.lang.String r0 = r0.toString()
            r1.stringId = r0
            goto L_0x01ac
        L_0x01d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.State.apply(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer):void");
    }

    public BarrierReference barrier(Object obj, Direction direction) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof BarrierReference)) {
            BarrierReference barrierReference = new BarrierReference(this);
            barrierReference.setBarrierDirection(direction);
            constraints.setFacade(barrierReference);
        }
        return (BarrierReference) constraints.getFacade();
    }

    public void baselineNeededFor(Object obj) {
        this.mBaselineNeeded.add(obj);
        this.mDirtyBaselineNeededWidgets = true;
    }

    public AlignHorizontallyReference centerHorizontally(Object... objArr) {
        AlignHorizontallyReference alignHorizontallyReference = (AlignHorizontallyReference) helper((Object) null, Helper.ALIGN_HORIZONTALLY);
        alignHorizontallyReference.add(objArr);
        return alignHorizontallyReference;
    }

    public AlignVerticallyReference centerVertically(Object... objArr) {
        AlignVerticallyReference alignVerticallyReference = (AlignVerticallyReference) helper((Object) null, Helper.ALIGN_VERTICALLY);
        alignVerticallyReference.add(objArr);
        return alignVerticallyReference;
    }

    public ConstraintReference constraints(Object obj) {
        Reference reference = this.mReferences.get(obj);
        if (reference == null) {
            reference = createConstraintReference(obj);
            this.mReferences.put(obj, reference);
            reference.setKey(obj);
        }
        if (reference instanceof ConstraintReference) {
            return (ConstraintReference) reference;
        }
        return null;
    }

    public int convertDimension(Object obj) {
        if (obj instanceof Float) {
            return Math.round(((Float) obj).floatValue());
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public ConstraintReference createConstraintReference(Object obj) {
        return new ConstraintReference(this);
    }

    public void directMapping() {
        for (Object next : this.mReferences.keySet()) {
            ConstraintReference constraints = constraints(next);
            if (l.a(constraints)) {
                constraints.setView(next);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public CorePixelDp getDpToPixel() {
        return this.mDpToPixel;
    }

    public FlowReference getFlow(Object obj, boolean z4) {
        FlowReference flowReference;
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof FlowReference)) {
            if (z4) {
                flowReference = new FlowReference(this, Helper.VERTICAL_FLOW);
            } else {
                flowReference = new FlowReference(this, Helper.HORIZONTAL_FLOW);
            }
            constraints.setFacade(flowReference);
        }
        return (FlowReference) constraints.getFacade();
    }

    @NonNull
    public GridReference getGrid(@NonNull Object obj, @NonNull String str) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof GridReference)) {
            Helper helper = Helper.GRID;
            if (str.charAt(0) == 'r') {
                helper = Helper.ROW;
            } else if (str.charAt(0) == 'c') {
                helper = Helper.COLUMN;
            }
            constraints.setFacade(new GridReference(this, helper));
        }
        return (GridReference) constraints.getFacade();
    }

    public FlowReference getHorizontalFlow() {
        return (FlowReference) helper((Object) null, Helper.HORIZONTAL_FLOW);
    }

    public ArrayList<String> getIdsForTag(String str) {
        if (this.mTags.containsKey(str)) {
            return this.mTags.get(str);
        }
        return null;
    }

    public FlowReference getVerticalFlow() {
        return (FlowReference) helper((Object) null, Helper.VERTICAL_FLOW);
    }

    public GuidelineReference guideline(Object obj, int i4) {
        ConstraintReference constraints = constraints(obj);
        if (constraints.getFacade() == null || !(constraints.getFacade() instanceof GuidelineReference)) {
            GuidelineReference guidelineReference = new GuidelineReference(this);
            guidelineReference.setOrientation(i4);
            guidelineReference.setKey(obj);
            constraints.setFacade(guidelineReference);
        }
        return (GuidelineReference) constraints.getFacade();
    }

    public State height(Dimension dimension) {
        return setHeight(dimension);
    }

    public HelperReference helper(Object obj, Helper helper) {
        if (obj == null) {
            obj = createHelperKey();
        }
        HelperReference helperReference = this.mHelperReferences.get(obj);
        if (helperReference == null) {
            switch (helper.ordinal()) {
                case 0:
                    helperReference = new HorizontalChainReference(this);
                    break;
                case 1:
                    helperReference = new VerticalChainReference(this);
                    break;
                case 2:
                    helperReference = new AlignHorizontallyReference(this);
                    break;
                case 3:
                    helperReference = new AlignVerticallyReference(this);
                    break;
                case 4:
                    helperReference = new BarrierReference(this);
                    break;
                case 6:
                case 7:
                    helperReference = new FlowReference(this, helper);
                    break;
                case 8:
                case 9:
                case 10:
                    helperReference = new GridReference(this, helper);
                    break;
                default:
                    helperReference = new HelperReference(this, helper);
                    break;
            }
            helperReference.setKey(obj);
            this.mHelperReferences.put(obj, helperReference);
        }
        return helperReference;
    }

    public HorizontalChainReference horizontalChain() {
        return (HorizontalChainReference) helper((Object) null, Helper.HORIZONTAL_CHAIN);
    }

    public GuidelineReference horizontalGuideline(Object obj) {
        return guideline(obj, 0);
    }

    public boolean isBaselineNeeded(ConstraintWidget constraintWidget) {
        if (this.mDirtyBaselineNeededWidgets) {
            this.mBaselineNeededWidgets.clear();
            ArrayList<Object> arrayList = this.mBaselineNeeded;
            int size = arrayList.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList.get(i4);
                i4++;
                ConstraintWidget constraintWidget2 = this.mReferences.get(obj).getConstraintWidget();
                if (constraintWidget2 != null) {
                    this.mBaselineNeededWidgets.add(constraintWidget2);
                }
            }
            this.mDirtyBaselineNeededWidgets = false;
        }
        return this.mBaselineNeededWidgets.contains(constraintWidget);
    }

    @Deprecated
    public boolean isLtr() {
        return this.mIsLtr;
    }

    public boolean isRtl() {
        return !this.mIsLtr;
    }

    public void map(Object obj, Object obj2) {
        ConstraintReference constraints = constraints(obj);
        if (constraints != null) {
            constraints.setView(obj2);
        }
    }

    /* access modifiers changed from: package-private */
    public Reference reference(Object obj) {
        return this.mReferences.get(obj);
    }

    public void reset() {
        for (Object obj : this.mReferences.keySet()) {
            this.mReferences.get(obj).getConstraintWidget().reset();
        }
        this.mReferences.clear();
        this.mReferences.put(PARENT, this.mParent);
        this.mHelperReferences.clear();
        this.mTags.clear();
        this.mBaselineNeeded.clear();
        this.mDirtyBaselineNeededWidgets = true;
    }

    public boolean sameFixedHeight(int i4) {
        return this.mParent.getHeight().equalsFixedValue(i4);
    }

    public boolean sameFixedWidth(int i4) {
        return this.mParent.getWidth().equalsFixedValue(i4);
    }

    public void setDpToPixel(CorePixelDp corePixelDp) {
        this.mDpToPixel = corePixelDp;
    }

    public State setHeight(Dimension dimension) {
        this.mParent.setHeight(dimension);
        return this;
    }

    @Deprecated
    public void setLtr(boolean z4) {
        this.mIsLtr = z4;
    }

    public void setRtl(boolean z4) {
        this.mIsLtr = !z4;
    }

    public void setTag(String str, String str2) {
        ArrayList arrayList;
        ConstraintReference constraints = constraints(str);
        if (l.a(constraints)) {
            constraints.setTag(str2);
            if (!this.mTags.containsKey(str2)) {
                arrayList = new ArrayList();
                this.mTags.put(str2, arrayList);
            } else {
                arrayList = this.mTags.get(str2);
            }
            arrayList.add(str);
        }
    }

    public State setWidth(Dimension dimension) {
        this.mParent.setWidth(dimension);
        return this;
    }

    public VerticalChainReference verticalChain() {
        return (VerticalChainReference) helper((Object) null, Helper.VERTICAL_CHAIN);
    }

    public GuidelineReference verticalGuideline(Object obj) {
        return guideline(obj, 1);
    }

    public State width(Dimension dimension) {
        return setWidth(dimension);
    }

    public FlowReference getHorizontalFlow(Object... objArr) {
        FlowReference flowReference = (FlowReference) helper((Object) null, Helper.HORIZONTAL_FLOW);
        flowReference.add(objArr);
        return flowReference;
    }

    public FlowReference getVerticalFlow(Object... objArr) {
        FlowReference flowReference = (FlowReference) helper((Object) null, Helper.VERTICAL_FLOW);
        flowReference.add(objArr);
        return flowReference;
    }

    public HorizontalChainReference horizontalChain(Object... objArr) {
        HorizontalChainReference horizontalChainReference = (HorizontalChainReference) helper((Object) null, Helper.HORIZONTAL_CHAIN);
        horizontalChainReference.add(objArr);
        return horizontalChainReference;
    }

    public VerticalChainReference verticalChain(Object... objArr) {
        VerticalChainReference verticalChainReference = (VerticalChainReference) helper((Object) null, Helper.VERTICAL_CHAIN);
        verticalChainReference.add(objArr);
        return verticalChainReference;
    }
}
