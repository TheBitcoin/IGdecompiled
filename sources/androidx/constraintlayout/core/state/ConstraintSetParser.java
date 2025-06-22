package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.CLString;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintSetParser {
    private static final boolean PARSER_DEBUG = false;

    public static class DesignElement {
        String mId;
        HashMap<String, String> mParams;
        String mType;

        DesignElement(String str, String str2, HashMap<String, String> hashMap) {
            this.mId = str;
            this.mType = str2;
            this.mParams = hashMap;
        }

        public String getId() {
            return this.mId;
        }

        public HashMap<String, String> getParams() {
            return this.mParams;
        }

        public String getType() {
            return this.mType;
        }
    }

    static class FiniteGenerator implements GeneratedValue {
        float mCurrent = 0.0f;
        float mFrom;
        float mInitial;
        float mMax;
        String mPostfix;
        String mPrefix;
        float mStep;
        boolean mStop = false;
        float mTo;

        FiniteGenerator(float f4, float f5, float f6, String str, String str2) {
            this.mFrom = f4;
            this.mTo = f5;
            this.mStep = f6;
            this.mPrefix = str == null ? "" : str;
            this.mPostfix = str2 == null ? "" : str2;
            this.mMax = f5;
            this.mInitial = f4;
        }

        public ArrayList<String> array() {
            ArrayList<String> arrayList = new ArrayList<>();
            int i4 = (int) this.mInitial;
            int i5 = (int) this.mMax;
            int i6 = i4;
            while (i4 <= i5) {
                arrayList.add(this.mPrefix + i6 + this.mPostfix);
                i6 += (int) this.mStep;
                i4++;
            }
            return arrayList;
        }

        public float value() {
            float f4 = this.mCurrent;
            if (f4 >= this.mMax) {
                this.mStop = true;
            }
            if (!this.mStop) {
                this.mCurrent = f4 + this.mStep;
            }
            return this.mCurrent;
        }
    }

    interface GeneratedValue {
        float value();
    }

    static class Generator implements GeneratedValue {
        float mCurrent;
        float mIncrementBy;
        float mStart;
        boolean mStop = false;

        Generator(float f4, float f5) {
            this.mStart = f4;
            this.mIncrementBy = f5;
            this.mCurrent = f4;
        }

        public float value() {
            if (!this.mStop) {
                this.mCurrent += this.mIncrementBy;
            }
            return this.mCurrent;
        }
    }

    public static class LayoutVariables {
        HashMap<String, ArrayList<String>> mArrayIds = new HashMap<>();
        HashMap<String, GeneratedValue> mGenerators = new HashMap<>();
        HashMap<String, Integer> mMargins = new HashMap<>();

        /* access modifiers changed from: package-private */
        public float get(Object obj) {
            if (obj instanceof CLString) {
                String content = ((CLString) obj).content();
                if (this.mGenerators.containsKey(content)) {
                    return this.mGenerators.get(content).value();
                }
                if (this.mMargins.containsKey(content)) {
                    return this.mMargins.get(content).floatValue();
                }
                return 0.0f;
            } else if (obj instanceof CLNumber) {
                return ((CLNumber) obj).getFloat();
            } else {
                return 0.0f;
            }
        }

        /* access modifiers changed from: package-private */
        public ArrayList<String> getList(String str) {
            if (this.mArrayIds.containsKey(str)) {
                return this.mArrayIds.get(str);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void put(String str, int i4) {
            this.mMargins.put(str, Integer.valueOf(i4));
        }

        public void putOverride(String str, float f4) {
            this.mGenerators.put(str, new OverrideValue(f4));
        }

        /* access modifiers changed from: package-private */
        public void put(String str, float f4, float f5) {
            if (!this.mGenerators.containsKey(str) || !(this.mGenerators.get(str) instanceof OverrideValue)) {
                this.mGenerators.put(str, new Generator(f4, f5));
            }
        }

        /* access modifiers changed from: package-private */
        public void put(String str, float f4, float f5, float f6, String str2, String str3) {
            if (!this.mGenerators.containsKey(str) || !(this.mGenerators.get(str) instanceof OverrideValue)) {
                FiniteGenerator finiteGenerator = new FiniteGenerator(f4, f5, f6, str2, str3);
                this.mGenerators.put(str, finiteGenerator);
                this.mArrayIds.put(str, finiteGenerator.array());
            }
        }

        /* access modifiers changed from: package-private */
        public void put(String str, ArrayList<String> arrayList) {
            this.mArrayIds.put(str, arrayList);
        }
    }

    public enum MotionLayoutDebugFlags {
        NONE,
        SHOW_ALL,
        UNKNOWN
    }

    static class OverrideValue implements GeneratedValue {
        float mValue;

        OverrideValue(float f4) {
            this.mValue = f4;
        }

        public float value() {
            return this.mValue;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0169, code lost:
        if (r8.equals("visible") == false) goto L_0x0161;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyAttribute(androidx.constraintlayout.core.state.State r8, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r9, androidx.constraintlayout.core.state.ConstraintReference r10, androidx.constraintlayout.core.parser.CLObject r11, java.lang.String r12) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 8
            r1 = 4
            r2 = 2
            r3 = 1
            r4 = 0
            r12.getClass()
            java.lang.String r5 = "parent"
            r6 = -1
            int r7 = r12.hashCode()
            switch(r7) {
                case -1448775240: goto L_0x0141;
                case -1364013995: goto L_0x0135;
                case -1349088399: goto L_0x0129;
                case -1249320806: goto L_0x011d;
                case -1249320805: goto L_0x0111;
                case -1249320804: goto L_0x0105;
                case -1225497657: goto L_0x00f9;
                case -1225497656: goto L_0x00ed;
                case -1225497655: goto L_0x00df;
                case -1221029593: goto L_0x00d1;
                case -1068318794: goto L_0x00c3;
                case -987906986: goto L_0x00b5;
                case -987906985: goto L_0x00a7;
                case -908189618: goto L_0x0099;
                case -908189617: goto L_0x008b;
                case -247669061: goto L_0x007e;
                case -61505906: goto L_0x0071;
                case 92909918: goto L_0x0064;
                case 98116417: goto L_0x0057;
                case 111045711: goto L_0x004a;
                case 113126854: goto L_0x003d;
                case 398344448: goto L_0x0030;
                case 1404070310: goto L_0x0023;
                case 1941332754: goto L_0x0016;
                default: goto L_0x0013;
            }
        L_0x0013:
            r7 = -1
            goto L_0x014c
        L_0x0016:
            java.lang.String r7 = "visibility"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x001f
            goto L_0x0013
        L_0x001f:
            r7 = 23
            goto L_0x014c
        L_0x0023:
            java.lang.String r7 = "centerHorizontally"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x002c
            goto L_0x0013
        L_0x002c:
            r7 = 22
            goto L_0x014c
        L_0x0030:
            java.lang.String r7 = "hWeight"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0039
            goto L_0x0013
        L_0x0039:
            r7 = 21
            goto L_0x014c
        L_0x003d:
            java.lang.String r7 = "width"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0046
            goto L_0x0013
        L_0x0046:
            r7 = 20
            goto L_0x014c
        L_0x004a:
            java.lang.String r7 = "vBias"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0053
            goto L_0x0013
        L_0x0053:
            r7 = 19
            goto L_0x014c
        L_0x0057:
            java.lang.String r7 = "hBias"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0060
            goto L_0x0013
        L_0x0060:
            r7 = 18
            goto L_0x014c
        L_0x0064:
            java.lang.String r7 = "alpha"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x006d
            goto L_0x0013
        L_0x006d:
            r7 = 17
            goto L_0x014c
        L_0x0071:
            java.lang.String r7 = "vWeight"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x007a
            goto L_0x0013
        L_0x007a:
            r7 = 16
            goto L_0x014c
        L_0x007e:
            java.lang.String r7 = "hRtlBias"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0087
            goto L_0x0013
        L_0x0087:
            r7 = 15
            goto L_0x014c
        L_0x008b:
            java.lang.String r7 = "scaleY"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0095
            goto L_0x0013
        L_0x0095:
            r7 = 14
            goto L_0x014c
        L_0x0099:
            java.lang.String r7 = "scaleX"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00a3
            goto L_0x0013
        L_0x00a3:
            r7 = 13
            goto L_0x014c
        L_0x00a7:
            java.lang.String r7 = "pivotY"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00b1
            goto L_0x0013
        L_0x00b1:
            r7 = 12
            goto L_0x014c
        L_0x00b5:
            java.lang.String r7 = "pivotX"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00bf
            goto L_0x0013
        L_0x00bf:
            r7 = 11
            goto L_0x014c
        L_0x00c3:
            java.lang.String r7 = "motion"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00cd
            goto L_0x0013
        L_0x00cd:
            r7 = 10
            goto L_0x014c
        L_0x00d1:
            java.lang.String r7 = "height"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00db
            goto L_0x0013
        L_0x00db:
            r7 = 9
            goto L_0x014c
        L_0x00df:
            java.lang.String r7 = "translationZ"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00e9
            goto L_0x0013
        L_0x00e9:
            r7 = 8
            goto L_0x014c
        L_0x00ed:
            java.lang.String r7 = "translationY"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x00f7
            goto L_0x0013
        L_0x00f7:
            r7 = 7
            goto L_0x014c
        L_0x00f9:
            java.lang.String r7 = "translationX"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0103
            goto L_0x0013
        L_0x0103:
            r7 = 6
            goto L_0x014c
        L_0x0105:
            java.lang.String r7 = "rotationZ"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x010f
            goto L_0x0013
        L_0x010f:
            r7 = 5
            goto L_0x014c
        L_0x0111:
            java.lang.String r7 = "rotationY"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x011b
            goto L_0x0013
        L_0x011b:
            r7 = 4
            goto L_0x014c
        L_0x011d:
            java.lang.String r7 = "rotationX"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0127
            goto L_0x0013
        L_0x0127:
            r7 = 3
            goto L_0x014c
        L_0x0129:
            java.lang.String r7 = "custom"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x0133
            goto L_0x0013
        L_0x0133:
            r7 = 2
            goto L_0x014c
        L_0x0135:
            java.lang.String r7 = "center"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x013f
            goto L_0x0013
        L_0x013f:
            r7 = 1
            goto L_0x014c
        L_0x0141:
            java.lang.String r7 = "centerVertically"
            boolean r7 = r12.equals(r7)
            if (r7 != 0) goto L_0x014b
            goto L_0x0013
        L_0x014b:
            r7 = 0
        L_0x014c:
            switch(r7) {
                case 0: goto L_0x02c8;
                case 1: goto L_0x02a6;
                case 2: goto L_0x02a2;
                case 3: goto L_0x0296;
                case 4: goto L_0x028a;
                case 5: goto L_0x027e;
                case 6: goto L_0x026e;
                case 7: goto L_0x025e;
                case 8: goto L_0x024e;
                case 9: goto L_0x0242;
                case 10: goto L_0x023a;
                case 11: goto L_0x022e;
                case 12: goto L_0x0222;
                case 13: goto L_0x0216;
                case 14: goto L_0x020a;
                case 15: goto L_0x01f4;
                case 16: goto L_0x01e8;
                case 17: goto L_0x01dc;
                case 18: goto L_0x01d0;
                case 19: goto L_0x01c4;
                case 20: goto L_0x01b8;
                case 21: goto L_0x01ac;
                case 22: goto L_0x0195;
                case 23: goto L_0x0153;
                default: goto L_0x014f;
            }
        L_0x014f:
            parseConstraint(r8, r9, r11, r10, r12)
            return
        L_0x0153:
            java.lang.String r8 = r11.getString((java.lang.String) r12)
            r8.getClass()
            int r9 = r8.hashCode()
            switch(r9) {
                case -1901805651: goto L_0x0177;
                case 3178655: goto L_0x016c;
                case 466743410: goto L_0x0163;
                default: goto L_0x0161;
            }
        L_0x0161:
            r2 = -1
            goto L_0x0181
        L_0x0163:
            java.lang.String r9 = "visible"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0181
            goto L_0x0161
        L_0x016c:
            java.lang.String r9 = "gone"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0175
            goto L_0x0161
        L_0x0175:
            r2 = 1
            goto L_0x0181
        L_0x0177:
            java.lang.String r9 = "invisible"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x0180
            goto L_0x0161
        L_0x0180:
            r2 = 0
        L_0x0181:
            switch(r2) {
                case 0: goto L_0x018d;
                case 1: goto L_0x0189;
                case 2: goto L_0x0185;
                default: goto L_0x0184;
            }
        L_0x0184:
            return
        L_0x0185:
            r10.visibility(r4)
            return
        L_0x0189:
            r10.visibility(r0)
            return
        L_0x018d:
            r10.visibility(r1)
            r8 = 0
            r10.alpha(r8)
            return
        L_0x0195:
            java.lang.String r9 = r11.getString((java.lang.String) r12)
            boolean r11 = r9.equals(r5)
            if (r11 == 0) goto L_0x01a1
            java.lang.Integer r9 = androidx.constraintlayout.core.state.State.PARENT
        L_0x01a1:
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
            r10.startToStart(r8)
            r10.endToEnd(r8)
            return
        L_0x01ac:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.setHorizontalChainWeight(r8)
            return
        L_0x01b8:
            androidx.constraintlayout.core.state.CorePixelDp r9 = r8.getDpToPixel()
            androidx.constraintlayout.core.state.Dimension r8 = parseDimension(r11, r12, r8, r9)
            r10.setWidth(r8)
            return
        L_0x01c4:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.verticalBias(r8)
            return
        L_0x01d0:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.horizontalBias(r8)
            return
        L_0x01dc:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.alpha(r8)
            return
        L_0x01e8:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.setVerticalChainWeight(r8)
            return
        L_0x01f4:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            boolean r8 = r8.isRtl()
            if (r8 == 0) goto L_0x0206
            r8 = 1065353216(0x3f800000, float:1.0)
            float r9 = r8 - r9
        L_0x0206:
            r10.horizontalBias(r9)
            return
        L_0x020a:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.scaleY(r8)
            return
        L_0x0216:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.scaleX(r8)
            return
        L_0x0222:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.pivotY(r8)
            return
        L_0x022e:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.pivotX(r8)
            return
        L_0x023a:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            parseMotionProperties(r8, r10)
            return
        L_0x0242:
            androidx.constraintlayout.core.state.CorePixelDp r9 = r8.getDpToPixel()
            androidx.constraintlayout.core.state.Dimension r8 = parseDimension(r11, r12, r8, r9)
            r10.setHeight(r8)
            return
        L_0x024e:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            float r8 = toPix(r8, r9)
            r10.translationZ(r8)
            return
        L_0x025e:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            float r8 = toPix(r8, r9)
            r10.translationY(r8)
            return
        L_0x026e:
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((java.lang.String) r12)
            float r9 = r9.get(r11)
            float r8 = toPix(r8, r9)
            r10.translationX(r8)
            return
        L_0x027e:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.rotationZ(r8)
            return
        L_0x028a:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.rotationY(r8)
            return
        L_0x0296:
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r12)
            float r8 = r9.get(r8)
            r10.rotationX(r8)
            return
        L_0x02a2:
            parseCustomProperties(r11, r10, r12)
            return
        L_0x02a6:
            java.lang.String r9 = r11.getString((java.lang.String) r12)
            boolean r11 = r9.equals(r5)
            if (r11 == 0) goto L_0x02b7
            java.lang.Integer r9 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
            goto L_0x02bb
        L_0x02b7:
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
        L_0x02bb:
            r10.startToStart(r8)
            r10.endToEnd(r8)
            r10.topToTop(r8)
            r10.bottomToBottom(r8)
            return
        L_0x02c8:
            java.lang.String r9 = r11.getString((java.lang.String) r12)
            boolean r11 = r9.equals(r5)
            if (r11 == 0) goto L_0x02d4
            java.lang.Integer r9 = androidx.constraintlayout.core.state.State.PARENT
        L_0x02d4:
            androidx.constraintlayout.core.state.ConstraintReference r8 = r8.constraints(r9)
            r10.topToTop(r8)
            r10.bottomToBottom(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.applyAttribute(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.parser.CLObject, java.lang.String):void");
    }

    private static int indexOf(String str, String... strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (strArr[i4].equals(str)) {
                return i4;
            }
        }
        return -1;
    }

    static String lookForType(CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        int size = names.size();
        int i4 = 0;
        while (i4 < size) {
            String str = names.get(i4);
            i4++;
            if (str.equals("type")) {
                return cLObject.getString("type");
            }
        }
        return null;
    }

    static void override(CLObject cLObject, String str, CLObject cLObject2) throws CLParsingException {
        if (!cLObject.has(str)) {
            cLObject.put(str, cLObject2);
            return;
        }
        CLObject object = cLObject.getObject(str);
        ArrayList<String> names = cLObject2.names();
        int size = names.size();
        int i4 = 0;
        while (i4 < size) {
            String str2 = names.get(i4);
            i4++;
            String str3 = str2;
            if (!str3.equals("clear")) {
                object.put(str3, cLObject2.get(str3));
            } else {
                CLArray array = cLObject2.getArray("clear");
                for (int i5 = 0; i5 < array.size(); i5++) {
                    String stringOrNull = array.getStringOrNull(i5);
                    if (stringOrNull != null) {
                        char c5 = 65535;
                        switch (stringOrNull.hashCode()) {
                            case -1727069561:
                                if (stringOrNull.equals("transforms")) {
                                    c5 = 0;
                                    break;
                                }
                                break;
                            case -1606703562:
                                if (stringOrNull.equals("constraints")) {
                                    c5 = 1;
                                    break;
                                }
                                break;
                            case 414334925:
                                if (stringOrNull.equals("dimensions")) {
                                    c5 = 2;
                                    break;
                                }
                                break;
                        }
                        switch (c5) {
                            case 0:
                                object.remove("visibility");
                                object.remove("alpha");
                                object.remove("pivotX");
                                object.remove("pivotY");
                                object.remove("rotationX");
                                object.remove("rotationY");
                                object.remove("rotationZ");
                                object.remove("scaleX");
                                object.remove("scaleY");
                                object.remove("translationX");
                                object.remove("translationY");
                                break;
                            case 1:
                                object.remove("start");
                                object.remove(TtmlNode.END);
                                object.remove("top");
                                object.remove("bottom");
                                object.remove("baseline");
                                object.remove(TtmlNode.CENTER);
                                object.remove("centerHorizontally");
                                object.remove("centerVertically");
                                break;
                            case 2:
                                object.remove("width");
                                object.remove("height");
                                break;
                            default:
                                object.remove(stringOrNull);
                                break;
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseBarrier(androidx.constraintlayout.core.state.State r12, java.lang.String r13, androidx.constraintlayout.core.parser.CLObject r14) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 2
            r1 = -1
            r2 = 0
            r3 = 1
            boolean r4 = r12.isRtl()
            androidx.constraintlayout.core.state.State$Direction r5 = androidx.constraintlayout.core.state.State.Direction.END
            androidx.constraintlayout.core.state.helpers.BarrierReference r13 = r12.barrier(r13, r5)
            java.util.ArrayList r5 = r14.names()
            if (r5 != 0) goto L_0x0016
            goto L_0x011f
        L_0x0016:
            int r6 = r5.size()
            r7 = 0
        L_0x001b:
            if (r7 >= r6) goto L_0x011f
            java.lang.Object r8 = r5.get(r7)
            int r7 = r7 + r3
            java.lang.String r8 = (java.lang.String) r8
            r8.getClass()
            int r9 = r8.hashCode()
            switch(r9) {
                case -1081309778: goto L_0x0046;
                case -962590849: goto L_0x003b;
                case -567445985: goto L_0x0030;
                default: goto L_0x002e;
            }
        L_0x002e:
            r9 = -1
            goto L_0x0050
        L_0x0030:
            java.lang.String r9 = "contains"
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x0039
            goto L_0x002e
        L_0x0039:
            r9 = 2
            goto L_0x0050
        L_0x003b:
            java.lang.String r9 = "direction"
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x0044
            goto L_0x002e
        L_0x0044:
            r9 = 1
            goto L_0x0050
        L_0x0046:
            java.lang.String r9 = "margin"
            boolean r9 = r8.equals(r9)
            if (r9 != 0) goto L_0x004f
            goto L_0x002e
        L_0x004f:
            r9 = 0
        L_0x0050:
            switch(r9) {
                case 0: goto L_0x0108;
                case 1: goto L_0x0076;
                case 2: goto L_0x0054;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x001b
        L_0x0054:
            androidx.constraintlayout.core.parser.CLArray r8 = r14.getArrayOrNull(r8)
            if (r8 == 0) goto L_0x001b
            r9 = 0
        L_0x005b:
            int r10 = r8.size()
            if (r9 >= r10) goto L_0x001b
            androidx.constraintlayout.core.parser.CLElement r10 = r8.get((int) r9)
            java.lang.String r10 = r10.content()
            androidx.constraintlayout.core.state.ConstraintReference r10 = r12.constraints(r10)
            java.lang.Object[] r11 = new java.lang.Object[r3]
            r11[r2] = r10
            r13.add(r11)
            int r9 = r9 + r3
            goto L_0x005b
        L_0x0076:
            java.lang.String r8 = r14.getString((java.lang.String) r8)
            r8.getClass()
            int r9 = r8.hashCode()
            switch(r9) {
                case -1383228885: goto L_0x00bd;
                case 100571: goto L_0x00b2;
                case 115029: goto L_0x00a7;
                case 3317767: goto L_0x009c;
                case 108511772: goto L_0x0091;
                case 109757538: goto L_0x0086;
                default: goto L_0x0084;
            }
        L_0x0084:
            r8 = -1
            goto L_0x00c7
        L_0x0086:
            java.lang.String r9 = "start"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x008f
            goto L_0x0084
        L_0x008f:
            r8 = 5
            goto L_0x00c7
        L_0x0091:
            java.lang.String r9 = "right"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x009a
            goto L_0x0084
        L_0x009a:
            r8 = 4
            goto L_0x00c7
        L_0x009c:
            java.lang.String r9 = "left"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00a5
            goto L_0x0084
        L_0x00a5:
            r8 = 3
            goto L_0x00c7
        L_0x00a7:
            java.lang.String r9 = "top"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00b0
            goto L_0x0084
        L_0x00b0:
            r8 = 2
            goto L_0x00c7
        L_0x00b2:
            java.lang.String r9 = "end"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00bb
            goto L_0x0084
        L_0x00bb:
            r8 = 1
            goto L_0x00c7
        L_0x00bd:
            java.lang.String r9 = "bottom"
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00c6
            goto L_0x0084
        L_0x00c6:
            r8 = 0
        L_0x00c7:
            switch(r8) {
                case 0: goto L_0x0101;
                case 1: goto L_0x00f1;
                case 2: goto L_0x00ea;
                case 3: goto L_0x00e3;
                case 4: goto L_0x00dc;
                case 5: goto L_0x00cc;
                default: goto L_0x00ca;
            }
        L_0x00ca:
            goto L_0x001b
        L_0x00cc:
            if (r4 != 0) goto L_0x00d5
            androidx.constraintlayout.core.state.State$Direction r8 = androidx.constraintlayout.core.state.State.Direction.LEFT
            r13.setBarrierDirection(r8)
            goto L_0x001b
        L_0x00d5:
            androidx.constraintlayout.core.state.State$Direction r8 = androidx.constraintlayout.core.state.State.Direction.RIGHT
            r13.setBarrierDirection(r8)
            goto L_0x001b
        L_0x00dc:
            androidx.constraintlayout.core.state.State$Direction r8 = androidx.constraintlayout.core.state.State.Direction.RIGHT
            r13.setBarrierDirection(r8)
            goto L_0x001b
        L_0x00e3:
            androidx.constraintlayout.core.state.State$Direction r8 = androidx.constraintlayout.core.state.State.Direction.LEFT
            r13.setBarrierDirection(r8)
            goto L_0x001b
        L_0x00ea:
            androidx.constraintlayout.core.state.State$Direction r8 = androidx.constraintlayout.core.state.State.Direction.TOP
            r13.setBarrierDirection(r8)
            goto L_0x001b
        L_0x00f1:
            if (r4 != 0) goto L_0x00fa
            androidx.constraintlayout.core.state.State$Direction r8 = androidx.constraintlayout.core.state.State.Direction.RIGHT
            r13.setBarrierDirection(r8)
            goto L_0x001b
        L_0x00fa:
            androidx.constraintlayout.core.state.State$Direction r8 = androidx.constraintlayout.core.state.State.Direction.LEFT
            r13.setBarrierDirection(r8)
            goto L_0x001b
        L_0x0101:
            androidx.constraintlayout.core.state.State$Direction r8 = androidx.constraintlayout.core.state.State.Direction.BOTTOM
            r13.setBarrierDirection(r8)
            goto L_0x001b
        L_0x0108:
            float r8 = r14.getFloatOrNaN(r8)
            boolean r9 = java.lang.Float.isNaN(r8)
            if (r9 != 0) goto L_0x001b
            float r8 = toPix(r12, r8)
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r13.margin((java.lang.Object) r8)
            goto L_0x001b
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseBarrier(androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseChain(int r8, androidx.constraintlayout.core.state.State r9, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r10, androidx.constraintlayout.core.parser.CLArray r11) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 0
            r1 = 1
            if (r8 != 0) goto L_0x0009
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r8 = r9.horizontalChain()
            goto L_0x000d
        L_0x0009:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r8 = r9.verticalChain()
        L_0x000d:
            androidx.constraintlayout.core.parser.CLElement r2 = r11.get((int) r1)
            boolean r3 = r2 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r3 == 0) goto L_0x00ac
            androidx.constraintlayout.core.parser.CLArray r2 = (androidx.constraintlayout.core.parser.CLArray) r2
            int r3 = r2.size()
            if (r3 >= r1) goto L_0x001f
            goto L_0x00ac
        L_0x001f:
            r3 = 0
        L_0x0020:
            int r4 = r2.size()
            if (r3 >= r4) goto L_0x0033
            java.lang.String r4 = r2.getString((int) r3)
            java.lang.Object[] r5 = new java.lang.Object[r1]
            r5[r0] = r4
            r8.add(r5)
            int r3 = r3 + r1
            goto L_0x0020
        L_0x0033:
            int r2 = r11.size()
            r3 = 2
            if (r2 <= r3) goto L_0x00ac
            androidx.constraintlayout.core.parser.CLElement r11 = r11.get((int) r3)
            boolean r2 = r11 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r2 != 0) goto L_0x0043
            goto L_0x00ac
        L_0x0043:
            androidx.constraintlayout.core.parser.CLObject r11 = (androidx.constraintlayout.core.parser.CLObject) r11
            java.util.ArrayList r2 = r11.names()
            int r3 = r2.size()
            r4 = 0
        L_0x004e:
            if (r4 >= r3) goto L_0x00ac
            java.lang.Object r5 = r2.get(r4)
            int r4 = r4 + r1
            java.lang.String r5 = (java.lang.String) r5
            r5.getClass()
            java.lang.String r6 = "style"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x0066
            parseConstraint(r9, r10, r11, r8, r5)
            goto L_0x004e
        L_0x0066:
            androidx.constraintlayout.core.parser.CLElement r5 = r11.get((java.lang.String) r5)
            boolean r6 = r5 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r6 == 0) goto L_0x0083
            r6 = r5
            androidx.constraintlayout.core.parser.CLArray r6 = (androidx.constraintlayout.core.parser.CLArray) r6
            int r7 = r6.size()
            if (r7 <= r1) goto L_0x0083
            java.lang.String r5 = r6.getString((int) r0)
            float r6 = r6.getFloat((int) r1)
            r8.bias((float) r6)
            goto L_0x0087
        L_0x0083:
            java.lang.String r5 = r5.content()
        L_0x0087:
            r5.getClass()
            java.lang.String r6 = "packed"
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x00a6
            java.lang.String r6 = "spread_inside"
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00a0
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r8.style(r5)
            goto L_0x004e
        L_0x00a0:
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r8.style(r5)
            goto L_0x004e
        L_0x00a6:
            androidx.constraintlayout.core.state.State$Chain r5 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r8.style(r5)
            goto L_0x004e
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChain(int, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLArray):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseChainType(java.lang.String r20, androidx.constraintlayout.core.state.State r21, java.lang.String r22, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r23, androidx.constraintlayout.core.parser.CLObject r24) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r21
            r1 = r22
            r2 = r24
            r3 = 6
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            r10 = r20
            char r10 = r10.charAt(r9)
            r11 = 104(0x68, float:1.46E-43)
            if (r10 != r11) goto L_0x001c
            androidx.constraintlayout.core.state.helpers.HorizontalChainReference r10 = r0.horizontalChain()
        L_0x001a:
            r11 = r10
            goto L_0x0021
        L_0x001c:
            androidx.constraintlayout.core.state.helpers.VerticalChainReference r10 = r0.verticalChain()
            goto L_0x001a
        L_0x0021:
            r11.setKey(r1)
            java.util.ArrayList r10 = r2.names()
            int r12 = r10.size()
            r13 = 0
        L_0x002d:
            if (r13 >= r12) goto L_0x0223
            java.lang.Object r14 = r10.get(r13)
            int r18 = r13 + 1
            java.lang.String r14 = (java.lang.String) r14
            r14.getClass()
            r13 = -1
            int r15 = r14.hashCode()
            switch(r15) {
                case -1383228885: goto L_0x0091;
                case -567445985: goto L_0x0086;
                case 100571: goto L_0x007b;
                case 115029: goto L_0x0070;
                case 3317767: goto L_0x0065;
                case 108511772: goto L_0x005a;
                case 109757538: goto L_0x004f;
                case 109780401: goto L_0x0044;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x009b
        L_0x0044:
            java.lang.String r15 = "style"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x004d
            goto L_0x009b
        L_0x004d:
            r13 = 7
            goto L_0x009b
        L_0x004f:
            java.lang.String r15 = "start"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x0058
            goto L_0x009b
        L_0x0058:
            r13 = 6
            goto L_0x009b
        L_0x005a:
            java.lang.String r15 = "right"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x0063
            goto L_0x009b
        L_0x0063:
            r13 = 5
            goto L_0x009b
        L_0x0065:
            java.lang.String r15 = "left"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x006e
            goto L_0x009b
        L_0x006e:
            r13 = 4
            goto L_0x009b
        L_0x0070:
            java.lang.String r15 = "top"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x0079
            goto L_0x009b
        L_0x0079:
            r13 = 3
            goto L_0x009b
        L_0x007b:
            java.lang.String r15 = "end"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x0084
            goto L_0x009b
        L_0x0084:
            r13 = 2
            goto L_0x009b
        L_0x0086:
            java.lang.String r15 = "contains"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x008f
            goto L_0x009b
        L_0x008f:
            r13 = 1
            goto L_0x009b
        L_0x0091:
            java.lang.String r15 = "bottom"
            boolean r15 = r14.equals(r15)
            if (r15 != 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r13 = 0
        L_0x009b:
            switch(r13) {
                case 0: goto L_0x0210;
                case 1: goto L_0x00ed;
                case 2: goto L_0x0210;
                case 3: goto L_0x0210;
                case 4: goto L_0x0210;
                case 5: goto L_0x0210;
                case 6: goto L_0x0210;
                case 7: goto L_0x00a7;
                default: goto L_0x009e;
            }
        L_0x009e:
            r4 = r23
            r3 = r12
            r5 = 5
            r9 = 3
            r19 = 0
            goto L_0x021a
        L_0x00a7:
            androidx.constraintlayout.core.parser.CLElement r13 = r2.get((java.lang.String) r14)
            boolean r14 = r13 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r14 == 0) goto L_0x00c4
            r14 = r13
            androidx.constraintlayout.core.parser.CLArray r14 = (androidx.constraintlayout.core.parser.CLArray) r14
            int r15 = r14.size()
            if (r15 <= r8) goto L_0x00c4
            java.lang.String r13 = r14.getString((int) r9)
            float r14 = r14.getFloat((int) r8)
            r11.bias((float) r14)
            goto L_0x00c8
        L_0x00c4:
            java.lang.String r13 = r13.content()
        L_0x00c8:
            r13.getClass()
            java.lang.String r14 = "packed"
            boolean r14 = r13.equals(r14)
            if (r14 != 0) goto L_0x00e7
            java.lang.String r14 = "spread_inside"
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x00e1
            androidx.constraintlayout.core.state.State$Chain r13 = androidx.constraintlayout.core.state.State.Chain.SPREAD
            r11.style(r13)
            goto L_0x009e
        L_0x00e1:
            androidx.constraintlayout.core.state.State$Chain r13 = androidx.constraintlayout.core.state.State.Chain.SPREAD_INSIDE
            r11.style(r13)
            goto L_0x009e
        L_0x00e7:
            androidx.constraintlayout.core.state.State$Chain r13 = androidx.constraintlayout.core.state.State.Chain.PACKED
            r11.style(r13)
            goto L_0x009e
        L_0x00ed:
            androidx.constraintlayout.core.parser.CLElement r13 = r2.get((java.lang.String) r14)
            boolean r14 = r13 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r14 == 0) goto L_0x01ed
            r14 = r13
            androidx.constraintlayout.core.parser.CLArray r14 = (androidx.constraintlayout.core.parser.CLArray) r14
            int r15 = r14.size()
            if (r15 >= r8) goto L_0x0100
            goto L_0x01ed
        L_0x0100:
            r13 = 0
        L_0x0101:
            int r15 = r14.size()
            if (r13 >= r15) goto L_0x01e5
            androidx.constraintlayout.core.parser.CLElement r15 = r14.get((int) r13)
            boolean r4 = r15 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L_0x01c9
            androidx.constraintlayout.core.parser.CLArray r15 = (androidx.constraintlayout.core.parser.CLArray) r15
            int r4 = r15.size()
            if (r4 <= 0) goto L_0x01c1
            androidx.constraintlayout.core.parser.CLElement r4 = r15.get((int) r9)
            java.lang.String r4 = r4.content()
            r19 = 0
            int r9 = r15.size()
            r16 = 2143289344(0x7fc00000, float:NaN)
            if (r9 == r7) goto L_0x01ae
            if (r9 == r6) goto L_0x0196
            if (r9 == r5) goto L_0x0174
            if (r9 == r3) goto L_0x013f
            r3 = r12
            r6 = r13
            r5 = 5
            r9 = 3
            r13 = 2143289344(0x7fc00000, float:NaN)
            r15 = 2143289344(0x7fc00000, float:NaN)
            r17 = 2143289344(0x7fc00000, float:NaN)
        L_0x0139:
            r12 = r4
            r4 = r14
            r14 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x01bd
        L_0x013f:
            float r16 = r15.getFloat((int) r8)
            float r9 = r15.getFloat((int) r7)
            float r9 = toPix(r0, r9)
            float r3 = r15.getFloat((int) r6)
            float r3 = toPix(r0, r3)
            float r6 = r15.getFloat((int) r5)
            float r6 = toPix(r0, r6)
            r5 = 5
            float r15 = r15.getFloat((int) r5)
            float r15 = toPix(r0, r15)
            r17 = r16
            r16 = r6
            r6 = r13
            r13 = r17
            r17 = r15
            r15 = r3
            r3 = r12
            r12 = r4
            r4 = r14
            r14 = r9
            r9 = 3
            goto L_0x01bd
        L_0x0174:
            r5 = 5
            float r3 = r15.getFloat((int) r8)
            float r6 = r15.getFloat((int) r7)
            float r6 = toPix(r0, r6)
            r9 = 3
            float r15 = r15.getFloat((int) r9)
            float r15 = toPix(r0, r15)
            r17 = r13
            r13 = r3
            r3 = r12
            r12 = r4
            r4 = r14
            r14 = r6
            r6 = r17
            r17 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x01bd
        L_0x0196:
            r5 = 5
            r9 = 3
            float r3 = r15.getFloat((int) r8)
            float r6 = r15.getFloat((int) r7)
            float r6 = toPix(r0, r6)
            r15 = r6
            r17 = 2143289344(0x7fc00000, float:NaN)
            r6 = r13
            r13 = r3
            r3 = r12
            r12 = r4
            r4 = r14
            r14 = r15
            goto L_0x01bd
        L_0x01ae:
            r5 = 5
            r9 = 3
            float r3 = r15.getFloat((int) r8)
            r6 = r13
            r15 = 2143289344(0x7fc00000, float:NaN)
            r17 = 2143289344(0x7fc00000, float:NaN)
            r13 = r3
            r3 = r12
            goto L_0x0139
        L_0x01bd:
            r11.addChainElement(r12, r13, r14, r15, r16, r17)
            goto L_0x01db
        L_0x01c1:
            r3 = r12
            r6 = r13
            r4 = r14
            r5 = 5
            r9 = 3
            r19 = 0
            goto L_0x01db
        L_0x01c9:
            r3 = r12
            r6 = r13
            r4 = r14
            r5 = 5
            r9 = 3
            r19 = 0
            java.lang.String r12 = r15.content()
            java.lang.Object[] r13 = new java.lang.Object[r8]
            r13[r19] = r12
            r11.add(r13)
        L_0x01db:
            int r13 = r6 + 1
            r12 = r3
            r14 = r4
            r3 = 6
            r5 = 4
            r6 = 3
            r9 = 0
            goto L_0x0101
        L_0x01e5:
            r3 = r12
            r5 = 5
            r9 = 3
            r19 = 0
            r4 = r23
            goto L_0x021a
        L_0x01ed:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " contains should be an array \""
            r2.append(r1)
            java.lang.String r1 = r13.content()
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.println(r1)
            return
        L_0x0210:
            r4 = r23
            r3 = r12
            r5 = 5
            r9 = 3
            r19 = 0
            parseConstraint(r0, r4, r2, r11, r14)
        L_0x021a:
            r12 = r3
            r13 = r18
            r3 = 6
            r5 = 4
            r6 = 3
            r9 = 0
            goto L_0x002d
        L_0x0223:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseChainType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static long parseColorString(String str) {
        if (!str.startsWith("#")) {
            return -1;
        }
        String substring = str.substring(1);
        if (substring.length() == 6) {
            substring = "FF" + substring;
        }
        return Long.parseLong(substring, 16);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01ed, code lost:
        r0 = true;
        r19 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01f0, code lost:
        if (r19 == false) goto L_0x0242;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f2, code lost:
        r7.getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01f9, code lost:
        switch(r7.hashCode()) {
            case 100571: goto L_0x0219;
            case 3317767: goto L_0x0210;
            case 108511772: goto L_0x0207;
            case 109757538: goto L_0x01fe;
            default: goto L_0x01fc;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01fc, code lost:
        r10 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0202, code lost:
        if (r7.equals("start") != false) goto L_0x0205;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0205, code lost:
        r10 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020b, code lost:
        if (r7.equals(com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode.RIGHT) != false) goto L_0x020e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x020e, code lost:
        r10 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0214, code lost:
        if (r7.equals(com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode.LEFT) != false) goto L_0x0217;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0217, code lost:
        r10 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x021d, code lost:
        if (r7.equals(com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode.END) != false) goto L_0x0220;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0220, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0221, code lost:
        switch(r10) {
            case 0: goto L_0x022b;
            case 1: goto L_0x0224;
            case 2: goto L_0x0229;
            case 3: goto L_0x0226;
            default: goto L_0x0224;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0224, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0226, code lost:
        r7 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0229, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x022b, code lost:
        r7 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x022d, code lost:
        if (r0 == false) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x022f, code lost:
        if (r7 == false) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0231, code lost:
        r4.leftToLeft(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0235, code lost:
        r4.leftToRight(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0239, code lost:
        if (r7 == false) goto L_0x023f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x023b, code lost:
        r4.rightToLeft(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x023f, code lost:
        r4.rightToRight(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0242, code lost:
        r4.margin((java.lang.Object) java.lang.Float.valueOf(r23)).marginGone((java.lang.Object) java.lang.Float.valueOf(r14));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0251, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d6, code lost:
        r19 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseConstraint(androidx.constraintlayout.core.state.State r21, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r22, androidx.constraintlayout.core.parser.CLObject r23, androidx.constraintlayout.core.state.ConstraintReference r24, java.lang.String r25) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r21
            r1 = r22
            r2 = r23
            r4 = r25
            java.lang.String r5 = "right"
            java.lang.String r6 = "left"
            java.lang.String r8 = "start"
            java.lang.String r9 = "end"
            java.lang.String r11 = "top"
            java.lang.String r12 = "bottom"
            java.lang.String r13 = "baseline"
            r7 = 0
            r14 = 1
            boolean r16 = r0.isRtl()
            r17 = r16 ^ 1
            androidx.constraintlayout.core.parser.CLArray r10 = r2.getArrayOrNull(r4)
            java.lang.String r15 = "parent"
            if (r10 == 0) goto L_0x0252
            int r2 = r10.size()
            if (r2 <= r14) goto L_0x0252
            java.lang.String r2 = r10.getString((int) r7)
            java.lang.String r7 = r10.getStringOrNull((int) r14)
            int r14 = r10.size()
            r20 = 0
            r3 = 2
            if (r14 <= r3) goto L_0x004a
            androidx.constraintlayout.core.parser.CLElement r14 = r10.getOrNull((int) r3)
            float r3 = r1.get(r14)
            float r3 = toPix(r0, r3)
            goto L_0x004b
        L_0x004a:
            r3 = 0
        L_0x004b:
            int r14 = r10.size()
            r23 = r3
            r3 = 3
            if (r14 <= r3) goto L_0x0061
            androidx.constraintlayout.core.parser.CLElement r14 = r10.getOrNull((int) r3)
            float r14 = r1.get(r14)
            float r14 = toPix(r0, r14)
            goto L_0x0062
        L_0x0061:
            r14 = 0
        L_0x0062:
            boolean r15 = r2.equals(r15)
            if (r15 == 0) goto L_0x006f
            java.lang.Integer r2 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r2 = r0.constraints(r2)
            goto L_0x0073
        L_0x006f:
            androidx.constraintlayout.core.state.ConstraintReference r2 = r0.constraints(r2)
        L_0x0073:
            r4.getClass()
            int r15 = r4.hashCode()
            switch(r15) {
                case -1720785339: goto L_0x00c0;
                case -1498085729: goto L_0x00b5;
                case -1383228885: goto L_0x00ac;
                case 100571: goto L_0x00a3;
                case 115029: goto L_0x009a;
                case 3317767: goto L_0x0091;
                case 108511772: goto L_0x0088;
                case 109757538: goto L_0x007f;
                default: goto L_0x007d;
            }
        L_0x007d:
            r4 = -1
            goto L_0x00c8
        L_0x007f:
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0086
            goto L_0x007d
        L_0x0086:
            r4 = 7
            goto L_0x00c8
        L_0x0088:
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x008f
            goto L_0x007d
        L_0x008f:
            r4 = 6
            goto L_0x00c8
        L_0x0091:
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x0098
            goto L_0x007d
        L_0x0098:
            r4 = 5
            goto L_0x00c8
        L_0x009a:
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x00a1
            goto L_0x007d
        L_0x00a1:
            r4 = 4
            goto L_0x00c8
        L_0x00a3:
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x00aa
            goto L_0x007d
        L_0x00aa:
            r4 = 3
            goto L_0x00c8
        L_0x00ac:
            boolean r4 = r4.equals(r12)
            if (r4 != 0) goto L_0x00b3
            goto L_0x007d
        L_0x00b3:
            r4 = 2
            goto L_0x00c8
        L_0x00b5:
            java.lang.String r15 = "circular"
            boolean r4 = r4.equals(r15)
            if (r4 != 0) goto L_0x00be
            goto L_0x007d
        L_0x00be:
            r4 = 1
            goto L_0x00c8
        L_0x00c0:
            boolean r4 = r4.equals(r13)
            if (r4 != 0) goto L_0x00c7
            goto L_0x007d
        L_0x00c7:
            r4 = 0
        L_0x00c8:
            switch(r4) {
                case 0: goto L_0x0197;
                case 1: goto L_0x0170;
                case 2: goto L_0x012d;
                case 3: goto L_0x0128;
                case 4: goto L_0x00e5;
                case 5: goto L_0x00e1;
                case 6: goto L_0x00dd;
                case 7: goto L_0x00d2;
                default: goto L_0x00cb;
            }
        L_0x00cb:
            r4 = r24
        L_0x00cd:
            r15 = 1
        L_0x00ce:
            r18 = 2
            goto L_0x01ed
        L_0x00d2:
            r4 = r24
            r0 = r17
        L_0x00d6:
            r15 = 1
            r18 = 2
            r19 = 1
            goto L_0x01f0
        L_0x00dd:
            r4 = r24
            r0 = 0
            goto L_0x00d6
        L_0x00e1:
            r4 = r24
            r0 = 1
            goto L_0x00d6
        L_0x00e5:
            r7.getClass()
            int r1 = r7.hashCode()
            switch(r1) {
                case -1720785339: goto L_0x0103;
                case -1383228885: goto L_0x00fa;
                case 115029: goto L_0x00f1;
                default: goto L_0x00ef;
            }
        L_0x00ef:
            r1 = -1
            goto L_0x010b
        L_0x00f1:
            boolean r1 = r7.equals(r11)
            if (r1 != 0) goto L_0x00f8
            goto L_0x00ef
        L_0x00f8:
            r1 = 2
            goto L_0x010b
        L_0x00fa:
            boolean r1 = r7.equals(r12)
            if (r1 != 0) goto L_0x0101
            goto L_0x00ef
        L_0x0101:
            r1 = 1
            goto L_0x010b
        L_0x0103:
            boolean r1 = r7.equals(r13)
            if (r1 != 0) goto L_0x010a
            goto L_0x00ef
        L_0x010a:
            r1 = 0
        L_0x010b:
            switch(r1) {
                case 0: goto L_0x011b;
                case 1: goto L_0x0115;
                case 2: goto L_0x010f;
                default: goto L_0x010e;
            }
        L_0x010e:
            goto L_0x00cb
        L_0x010f:
            r4 = r24
            r4.topToTop(r2)
            goto L_0x00cd
        L_0x0115:
            r4 = r24
            r4.topToBottom(r2)
            goto L_0x00cd
        L_0x011b:
            r4 = r24
            java.lang.Object r1 = r2.getKey()
            r0.baselineNeededFor(r1)
            r4.topToBaseline(r2)
            goto L_0x00cd
        L_0x0128:
            r4 = r24
            r0 = r16
            goto L_0x00d6
        L_0x012d:
            r4 = r24
            r7.getClass()
            int r1 = r7.hashCode()
            switch(r1) {
                case -1720785339: goto L_0x014d;
                case -1383228885: goto L_0x0144;
                case 115029: goto L_0x013b;
                default: goto L_0x0139;
            }
        L_0x0139:
            r1 = -1
            goto L_0x0155
        L_0x013b:
            boolean r1 = r7.equals(r11)
            if (r1 != 0) goto L_0x0142
            goto L_0x0139
        L_0x0142:
            r1 = 2
            goto L_0x0155
        L_0x0144:
            boolean r1 = r7.equals(r12)
            if (r1 != 0) goto L_0x014b
            goto L_0x0139
        L_0x014b:
            r1 = 1
            goto L_0x0155
        L_0x014d:
            boolean r1 = r7.equals(r13)
            if (r1 != 0) goto L_0x0154
            goto L_0x0139
        L_0x0154:
            r1 = 0
        L_0x0155:
            switch(r1) {
                case 0: goto L_0x0164;
                case 1: goto L_0x015f;
                case 2: goto L_0x015a;
                default: goto L_0x0158;
            }
        L_0x0158:
            goto L_0x00cd
        L_0x015a:
            r4.bottomToTop(r2)
            goto L_0x00cd
        L_0x015f:
            r4.bottomToBottom(r2)
            goto L_0x00cd
        L_0x0164:
            java.lang.Object r1 = r2.getKey()
            r0.baselineNeededFor(r1)
            r4.bottomToBaseline(r2)
            goto L_0x00cd
        L_0x0170:
            r4 = r24
            r15 = 1
            androidx.constraintlayout.core.parser.CLElement r11 = r10.get((int) r15)
            float r11 = r1.get(r11)
            int r12 = r10.size()
            r13 = 2
            if (r12 <= r13) goto L_0x0191
            androidx.constraintlayout.core.parser.CLElement r10 = r10.getOrNull((int) r13)
            float r1 = r1.get(r10)
            float r20 = toPix(r0, r1)
            r0 = r20
            goto L_0x0192
        L_0x0191:
            r0 = 0
        L_0x0192:
            r4.circularConstraint(r2, r11, r0)
            goto L_0x00ce
        L_0x0197:
            r4 = r24
            r15 = 1
            r18 = 2
            r7.getClass()
            int r1 = r7.hashCode()
            switch(r1) {
                case -1720785339: goto L_0x01ba;
                case -1383228885: goto L_0x01b1;
                case 115029: goto L_0x01a8;
                default: goto L_0x01a6;
            }
        L_0x01a6:
            r1 = -1
            goto L_0x01c2
        L_0x01a8:
            boolean r1 = r7.equals(r11)
            if (r1 != 0) goto L_0x01af
            goto L_0x01a6
        L_0x01af:
            r1 = 2
            goto L_0x01c2
        L_0x01b1:
            boolean r1 = r7.equals(r12)
            if (r1 != 0) goto L_0x01b8
            goto L_0x01a6
        L_0x01b8:
            r1 = 1
            goto L_0x01c2
        L_0x01ba:
            boolean r1 = r7.equals(r13)
            if (r1 != 0) goto L_0x01c1
            goto L_0x01a6
        L_0x01c1:
            r1 = 0
        L_0x01c2:
            switch(r1) {
                case 0: goto L_0x01dc;
                case 1: goto L_0x01d1;
                case 2: goto L_0x01c6;
                default: goto L_0x01c5;
            }
        L_0x01c5:
            goto L_0x01ed
        L_0x01c6:
            java.lang.Object r1 = r4.getKey()
            r0.baselineNeededFor(r1)
            r4.baselineToTop(r2)
            goto L_0x01ed
        L_0x01d1:
            java.lang.Object r1 = r4.getKey()
            r0.baselineNeededFor(r1)
            r4.baselineToBottom(r2)
            goto L_0x01ed
        L_0x01dc:
            java.lang.Object r1 = r4.getKey()
            r0.baselineNeededFor(r1)
            java.lang.Object r1 = r2.getKey()
            r0.baselineNeededFor(r1)
            r4.baselineToBaseline(r2)
        L_0x01ed:
            r0 = 1
            r19 = 0
        L_0x01f0:
            if (r19 == 0) goto L_0x0242
            r7.getClass()
            int r1 = r7.hashCode()
            switch(r1) {
                case 100571: goto L_0x0219;
                case 3317767: goto L_0x0210;
                case 108511772: goto L_0x0207;
                case 109757538: goto L_0x01fe;
                default: goto L_0x01fc;
            }
        L_0x01fc:
            r10 = -1
            goto L_0x0221
        L_0x01fe:
            boolean r1 = r7.equals(r8)
            if (r1 != 0) goto L_0x0205
            goto L_0x01fc
        L_0x0205:
            r10 = 3
            goto L_0x0221
        L_0x0207:
            boolean r1 = r7.equals(r5)
            if (r1 != 0) goto L_0x020e
            goto L_0x01fc
        L_0x020e:
            r10 = 2
            goto L_0x0221
        L_0x0210:
            boolean r1 = r7.equals(r6)
            if (r1 != 0) goto L_0x0217
            goto L_0x01fc
        L_0x0217:
            r10 = 1
            goto L_0x0221
        L_0x0219:
            boolean r1 = r7.equals(r9)
            if (r1 != 0) goto L_0x0220
            goto L_0x01fc
        L_0x0220:
            r10 = 0
        L_0x0221:
            switch(r10) {
                case 0: goto L_0x022b;
                case 1: goto L_0x0224;
                case 2: goto L_0x0229;
                case 3: goto L_0x0226;
                default: goto L_0x0224;
            }
        L_0x0224:
            r7 = 1
            goto L_0x022d
        L_0x0226:
            r7 = r17
            goto L_0x022d
        L_0x0229:
            r7 = 0
            goto L_0x022d
        L_0x022b:
            r7 = r16
        L_0x022d:
            if (r0 == 0) goto L_0x0239
            if (r7 == 0) goto L_0x0235
            r4.leftToLeft(r2)
            goto L_0x0242
        L_0x0235:
            r4.leftToRight(r2)
            goto L_0x0242
        L_0x0239:
            if (r7 == 0) goto L_0x023f
            r4.rightToLeft(r2)
            goto L_0x0242
        L_0x023f:
            r4.rightToRight(r2)
        L_0x0242:
            java.lang.Float r0 = java.lang.Float.valueOf(r23)
            androidx.constraintlayout.core.state.ConstraintReference r0 = r4.margin((java.lang.Object) r0)
            java.lang.Float r1 = java.lang.Float.valueOf(r14)
            r0.marginGone((java.lang.Object) r1)
            return
        L_0x0252:
            r1 = r24
            r3 = 3
            r18 = 2
            r19 = 1
            r2 = r23
            java.lang.String r2 = r2.getStringOrNull((java.lang.String) r4)
            if (r2 == 0) goto L_0x02db
            boolean r5 = r2.equals(r15)
            if (r5 == 0) goto L_0x026e
            java.lang.Integer r2 = androidx.constraintlayout.core.state.State.PARENT
            androidx.constraintlayout.core.state.ConstraintReference r2 = r0.constraints(r2)
            goto L_0x0272
        L_0x026e:
            androidx.constraintlayout.core.state.ConstraintReference r2 = r0.constraints(r2)
        L_0x0272:
            r4.getClass()
            int r5 = r4.hashCode()
            switch(r5) {
                case -1720785339: goto L_0x02a2;
                case -1383228885: goto L_0x0299;
                case 100571: goto L_0x0290;
                case 115029: goto L_0x0287;
                case 109757538: goto L_0x027e;
                default: goto L_0x027c;
            }
        L_0x027c:
            r7 = -1
            goto L_0x02aa
        L_0x027e:
            boolean r3 = r4.equals(r8)
            if (r3 != 0) goto L_0x0285
            goto L_0x027c
        L_0x0285:
            r7 = 4
            goto L_0x02aa
        L_0x0287:
            boolean r4 = r4.equals(r11)
            if (r4 != 0) goto L_0x028e
            goto L_0x027c
        L_0x028e:
            r7 = 3
            goto L_0x02aa
        L_0x0290:
            boolean r3 = r4.equals(r9)
            if (r3 != 0) goto L_0x0297
            goto L_0x027c
        L_0x0297:
            r7 = 2
            goto L_0x02aa
        L_0x0299:
            boolean r3 = r4.equals(r12)
            if (r3 != 0) goto L_0x02a0
            goto L_0x027c
        L_0x02a0:
            r7 = 1
            goto L_0x02aa
        L_0x02a2:
            boolean r3 = r4.equals(r13)
            if (r3 != 0) goto L_0x02a9
            goto L_0x027c
        L_0x02a9:
            r7 = 0
        L_0x02aa:
            switch(r7) {
                case 0: goto L_0x02ca;
                case 1: goto L_0x02c6;
                case 2: goto L_0x02bc;
                case 3: goto L_0x02b8;
                case 4: goto L_0x02ae;
                default: goto L_0x02ad;
            }
        L_0x02ad:
            goto L_0x02db
        L_0x02ae:
            if (r16 != 0) goto L_0x02b4
            r1.leftToLeft(r2)
            return
        L_0x02b4:
            r1.rightToRight(r2)
            return
        L_0x02b8:
            r1.topToTop(r2)
            return
        L_0x02bc:
            if (r16 != 0) goto L_0x02c2
            r1.rightToRight(r2)
            return
        L_0x02c2:
            r1.leftToLeft(r2)
            return
        L_0x02c6:
            r1.bottomToBottom(r2)
            return
        L_0x02ca:
            java.lang.Object r3 = r1.getKey()
            r0.baselineNeededFor(r3)
            java.lang.Object r3 = r2.getKey()
            r0.baselineNeededFor(r3)
            r1.baselineToBaseline(r2)
        L_0x02db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseConstraint(androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.ConstraintReference, java.lang.String):void");
    }

    static void parseConstraintSets(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            int size = names.size();
            int i4 = 0;
            while (i4 < size) {
                String str = names.get(i4);
                i4++;
                String str2 = str;
                CLObject object = cLObject.getObject(str2);
                String stringOrNull = object.getStringOrNull("Extends");
                if (stringOrNull == null || stringOrNull.isEmpty()) {
                    coreMotionScene.setConstraintSetContent(str2, object.toJSON());
                } else {
                    String constraintSet = coreMotionScene.getConstraintSet(stringOrNull);
                    if (constraintSet != null) {
                        CLObject parse = CLParser.parse(constraintSet);
                        ArrayList<String> names2 = object.names();
                        if (names2 != null) {
                            int size2 = names2.size();
                            int i5 = 0;
                            while (i5 < size2) {
                                String str3 = names2.get(i5);
                                i5++;
                                String str4 = str3;
                                CLElement cLElement = object.get(str4);
                                if (cLElement instanceof CLObject) {
                                    override(parse, str4, (CLObject) cLElement);
                                }
                            }
                            coreMotionScene.setConstraintSetContent(str2, parse.toJSON());
                        }
                    }
                }
            }
        }
    }

    static void parseCustomProperties(CLObject cLObject, ConstraintReference constraintReference, String str) throws CLParsingException {
        ArrayList<String> names;
        CLObject objectOrNull = cLObject.getObjectOrNull(str);
        if (objectOrNull != null && (names = objectOrNull.names()) != null) {
            int size = names.size();
            int i4 = 0;
            while (i4 < size) {
                String str2 = names.get(i4);
                i4++;
                String str3 = str2;
                CLElement cLElement = objectOrNull.get(str3);
                if (cLElement instanceof CLNumber) {
                    constraintReference.addCustomFloat(str3, cLElement.getFloat());
                } else if (cLElement instanceof CLString) {
                    long parseColorString = parseColorString(cLElement.content());
                    if (parseColorString != -1) {
                        constraintReference.addCustomColor(str3, (int) parseColorString);
                    }
                }
            }
        }
    }

    public static void parseDesignElementsJSON(String str, ArrayList<DesignElement> arrayList) throws CLParsingException {
        CLObject parse = CLParser.parse(str);
        ArrayList<String> names = parse.names();
        if (names != null && names.size() > 0) {
            String str2 = names.get(0);
            CLElement cLElement = parse.get(str2);
            str2.getClass();
            if (str2.equals("Design") && (cLElement instanceof CLObject)) {
                CLObject cLObject = (CLObject) cLElement;
                ArrayList<String> names2 = cLObject.names();
                for (int i4 = 0; i4 < names2.size(); i4++) {
                    String str3 = names2.get(i4);
                    CLObject cLObject2 = (CLObject) cLObject.get(str3);
                    PrintStream printStream = System.out;
                    printStream.printf("element found " + str3 + "", new Object[0]);
                    String stringOrNull = cLObject2.getStringOrNull("type");
                    if (stringOrNull != null) {
                        HashMap hashMap = new HashMap();
                        int size = cLObject2.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            CLKey cLKey = (CLKey) cLObject2.get(i4);
                            String content = cLKey.content();
                            String content2 = cLKey.getValue().content();
                            if (content2 != null) {
                                hashMap.put(content, content2);
                            }
                        }
                        arrayList.add(new DesignElement(str2, stringOrNull, hashMap));
                    }
                }
            }
        }
    }

    static Dimension parseDimension(CLObject cLObject, String str, State state, CorePixelDp corePixelDp) throws CLParsingException {
        CLElement cLElement = cLObject.get(str);
        Dimension createFixed = Dimension.createFixed(0);
        if (cLElement instanceof CLString) {
            return parseDimensionMode(cLElement.content());
        }
        if (cLElement instanceof CLNumber) {
            return Dimension.createFixed(state.convertDimension(Float.valueOf(corePixelDp.toPixels(cLObject.getFloat(str)))));
        }
        if (cLElement instanceof CLObject) {
            CLObject cLObject2 = (CLObject) cLElement;
            String stringOrNull = cLObject2.getStringOrNull("value");
            if (stringOrNull != null) {
                createFixed = parseDimensionMode(stringOrNull);
            }
            CLElement orNull = cLObject2.getOrNull("min");
            if (orNull != null) {
                if (orNull instanceof CLNumber) {
                    createFixed.min(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull).getFloat()))));
                } else if (orNull instanceof CLString) {
                    createFixed.min(Dimension.WRAP_DIMENSION);
                }
            }
            CLElement orNull2 = cLObject2.getOrNull("max");
            if (orNull2 != null) {
                if (orNull2 instanceof CLNumber) {
                    createFixed.max(state.convertDimension(Float.valueOf(corePixelDp.toPixels(((CLNumber) orNull2).getFloat()))));
                    return createFixed;
                } else if (orNull2 instanceof CLString) {
                    createFixed.max(Dimension.WRAP_DIMENSION);
                }
            }
        }
        return createFixed;
    }

    static Dimension parseDimensionMode(String str) {
        Dimension createFixed = Dimension.createFixed(0);
        str.getClass();
        char c5 = 65535;
        switch (str.hashCode()) {
            case -1460244870:
                if (str.equals("preferWrap")) {
                    c5 = 0;
                    break;
                }
                break;
            case -995424086:
                if (str.equals("parent")) {
                    c5 = 1;
                    break;
                }
                break;
            case -895684237:
                if (str.equals("spread")) {
                    c5 = 2;
                    break;
                }
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    c5 = 3;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                return Dimension.createSuggested(Dimension.WRAP_DIMENSION);
            case 1:
                return Dimension.createParent();
            case 2:
                return Dimension.createSuggested(Dimension.SPREAD_DIMENSION);
            case 3:
                return Dimension.createWrap();
            default:
                if (str.endsWith("%")) {
                    return Dimension.createPercent(0, Float.parseFloat(str.substring(0, str.indexOf(37))) / 100.0f).suggested(0);
                }
                if (str.contains(":")) {
                    return Dimension.createRatio(str).suggested(Dimension.SPREAD_DIMENSION);
                }
                return createFixed;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0265 A[Catch:{ NumberFormatException -> 0x025a }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x03d3 A[Catch:{ NumberFormatException -> 0x03db }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x03e6 A[Catch:{ NumberFormatException -> 0x03db }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0252 A[Catch:{ NumberFormatException -> 0x025a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseFlowType(java.lang.String r19, androidx.constraintlayout.core.state.State r20, java.lang.String r21, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r22, androidx.constraintlayout.core.parser.CLObject r23) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r20
            r1 = r21
            r2 = r23
            r3 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = r19
            char r8 = r8.charAt(r7)
            r9 = 118(0x76, float:1.65E-43)
            r10 = 1
            if (r8 != r9) goto L_0x0017
            r8 = 1
            goto L_0x0018
        L_0x0017:
            r8 = 0
        L_0x0018:
            androidx.constraintlayout.core.state.helpers.FlowReference r8 = r0.getFlow(r1, r8)
            java.util.ArrayList r9 = r2.names()
            int r11 = r9.size()
            r12 = 0
        L_0x0025:
            if (r12 >= r11) goto L_0x0479
            java.lang.Object r13 = r9.get(r12)
            int r12 = r12 + r10
            java.lang.String r13 = (java.lang.String) r13
            r13.getClass()
            r14 = 1056964608(0x3f000000, float:0.5)
            java.lang.String r15 = ""
            int r16 = r13.hashCode()
            switch(r16) {
                case -1254185091: goto L_0x00cf;
                case -1237307863: goto L_0x00c3;
                case -1198076529: goto L_0x00b7;
                case -853376977: goto L_0x00ac;
                case -836499749: goto L_0x00a1;
                case -806339567: goto L_0x0096;
                case -732635235: goto L_0x008b;
                case -567445985: goto L_0x0080;
                case -488900360: goto L_0x0073;
                case 3169614: goto L_0x0066;
                case 3575610: goto L_0x0059;
                case 3586688: goto L_0x004c;
                case 3657802: goto L_0x003f;
                default: goto L_0x003c;
            }
        L_0x003c:
            r4 = -1
            goto L_0x00da
        L_0x003f:
            java.lang.String r4 = "wrap"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x0048
            goto L_0x003c
        L_0x0048:
            r4 = 12
            goto L_0x00da
        L_0x004c:
            java.lang.String r4 = "vGap"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x0055
            goto L_0x003c
        L_0x0055:
            r4 = 11
            goto L_0x00da
        L_0x0059:
            java.lang.String r4 = "type"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x0062
            goto L_0x003c
        L_0x0062:
            r4 = 10
            goto L_0x00da
        L_0x0066:
            java.lang.String r4 = "hGap"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x006f
            goto L_0x003c
        L_0x006f:
            r4 = 9
            goto L_0x00da
        L_0x0073:
            java.lang.String r4 = "maxElement"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x007c
            goto L_0x003c
        L_0x007c:
            r4 = 8
            goto L_0x00da
        L_0x0080:
            java.lang.String r4 = "contains"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x0089
            goto L_0x003c
        L_0x0089:
            r4 = 7
            goto L_0x00da
        L_0x008b:
            java.lang.String r4 = "vFlowBias"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x0094
            goto L_0x003c
        L_0x0094:
            r4 = 6
            goto L_0x00da
        L_0x0096:
            java.lang.String r4 = "padding"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x009f
            goto L_0x003c
        L_0x009f:
            r4 = 5
            goto L_0x00da
        L_0x00a1:
            java.lang.String r4 = "vStyle"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x00aa
            goto L_0x003c
        L_0x00aa:
            r4 = 4
            goto L_0x00da
        L_0x00ac:
            java.lang.String r4 = "vAlign"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x00b5
            goto L_0x003c
        L_0x00b5:
            r4 = 3
            goto L_0x00da
        L_0x00b7:
            java.lang.String r4 = "hFlowBias"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x00c1
            goto L_0x003c
        L_0x00c1:
            r4 = 2
            goto L_0x00da
        L_0x00c3:
            java.lang.String r4 = "hStyle"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x00cd
            goto L_0x003c
        L_0x00cd:
            r4 = 1
            goto L_0x00da
        L_0x00cf:
            java.lang.String r4 = "hAlign"
            boolean r4 = r13.equals(r4)
            if (r4 != 0) goto L_0x00d9
            goto L_0x003c
        L_0x00d9:
            r4 = 0
        L_0x00da:
            switch(r4) {
                case 0: goto L_0x0447;
                case 1: goto L_0x03ef;
                case 2: goto L_0x0381;
                case 3: goto L_0x0333;
                case 4: goto L_0x02dc;
                case 5: goto L_0x026e;
                case 6: goto L_0x01fd;
                case 7: goto L_0x0141;
                case 8: goto L_0x0133;
                case 9: goto L_0x0125;
                case 10: goto L_0x010b;
                case 11: goto L_0x00fd;
                case 12: goto L_0x00eb;
                default: goto L_0x00dd;
            }
        L_0x00dd:
            androidx.constraintlayout.core.state.ConstraintReference r4 = r20.constraints(r21)
            r15 = r22
            applyAttribute(r0, r15, r4, r2, r13)
        L_0x00e6:
            r10 = 3
        L_0x00e7:
            r13 = 0
        L_0x00e8:
            r15 = 1
            goto L_0x0473
        L_0x00eb:
            r15 = r22
            androidx.constraintlayout.core.parser.CLElement r4 = r2.get((java.lang.String) r13)
            java.lang.String r4 = r4.content()
            int r4 = androidx.constraintlayout.core.state.State.Wrap.getValueByString(r4)
            r8.setWrapMode(r4)
            goto L_0x00e6
        L_0x00fd:
            r15 = r22
            androidx.constraintlayout.core.parser.CLElement r4 = r2.get((java.lang.String) r13)
            int r4 = r4.getInt()
            r8.setVerticalGap(r4)
            goto L_0x00e6
        L_0x010b:
            r15 = r22
            androidx.constraintlayout.core.parser.CLElement r4 = r2.get((java.lang.String) r13)
            java.lang.String r4 = r4.content()
            java.lang.String r13 = "hFlow"
            boolean r4 = r4.equals(r13)
            if (r4 == 0) goto L_0x0121
            r8.setOrientation(r7)
            goto L_0x00e6
        L_0x0121:
            r8.setOrientation(r10)
            goto L_0x00e6
        L_0x0125:
            r15 = r22
            androidx.constraintlayout.core.parser.CLElement r4 = r2.get((java.lang.String) r13)
            int r4 = r4.getInt()
            r8.setHorizontalGap(r4)
            goto L_0x00e6
        L_0x0133:
            r15 = r22
            androidx.constraintlayout.core.parser.CLElement r4 = r2.get((java.lang.String) r13)
            int r4 = r4.getInt()
            r8.setMaxElementsWrap(r4)
            goto L_0x00e6
        L_0x0141:
            r15 = r22
            androidx.constraintlayout.core.parser.CLElement r4 = r2.get((java.lang.String) r13)
            boolean r13 = r4 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r13 == 0) goto L_0x01da
            r13 = r4
            androidx.constraintlayout.core.parser.CLArray r13 = (androidx.constraintlayout.core.parser.CLArray) r13
            int r14 = r13.size()
            if (r14 >= r10) goto L_0x0156
            goto L_0x01da
        L_0x0156:
            r4 = 0
        L_0x0157:
            int r14 = r13.size()
            if (r4 >= r14) goto L_0x00e6
            androidx.constraintlayout.core.parser.CLElement r14 = r13.get((int) r4)
            boolean r10 = r14 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r10 == 0) goto L_0x01c5
            androidx.constraintlayout.core.parser.CLArray r14 = (androidx.constraintlayout.core.parser.CLArray) r14
            int r10 = r14.size()
            if (r10 <= 0) goto L_0x01c1
            androidx.constraintlayout.core.parser.CLElement r10 = r14.get((int) r7)
            java.lang.String r10 = r10.content()
            r17 = 0
            int r7 = r14.size()
            r18 = 2143289344(0x7fc00000, float:NaN)
            if (r7 == r6) goto L_0x01b5
            if (r7 == r5) goto L_0x01a5
            if (r7 == r3) goto L_0x018b
            r3 = 2143289344(0x7fc00000, float:NaN)
            r5 = 2143289344(0x7fc00000, float:NaN)
            r7 = 1
        L_0x0188:
            r14 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x01bd
        L_0x018b:
            r7 = 1
            float r18 = r14.getFloat((int) r7)
            float r3 = r14.getFloat((int) r6)
            float r3 = toPix(r0, r3)
            float r14 = r14.getFloat((int) r5)
            float r14 = toPix(r0, r14)
            r5 = r14
            r14 = r3
        L_0x01a2:
            r3 = r18
            goto L_0x01bd
        L_0x01a5:
            r7 = 1
            float r18 = r14.getFloat((int) r7)
            float r3 = r14.getFloat((int) r6)
            float r3 = toPix(r0, r3)
            r5 = r3
            r14 = r5
            goto L_0x01a2
        L_0x01b5:
            r7 = 1
            float r3 = r14.getFloat((int) r7)
            r5 = 2143289344(0x7fc00000, float:NaN)
            goto L_0x0188
        L_0x01bd:
            r8.addFlowElement(r10, r3, r14, r5)
            goto L_0x01d3
        L_0x01c1:
            r7 = 1
            r17 = 0
            goto L_0x01d3
        L_0x01c5:
            r7 = 1
            r17 = 0
            java.lang.String r3 = r14.content()
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r17] = r3
            r8.add(r5)
        L_0x01d3:
            int r4 = r4 + r7
            r3 = 4
            r5 = 3
            r7 = 0
            r10 = 1
            goto L_0x0157
        L_0x01da:
            java.io.PrintStream r0 = java.lang.System.err
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = " contains should be an array \""
            r2.append(r1)
            java.lang.String r1 = r4.content()
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.println(r1)
            return
        L_0x01fd:
            r15 = r22
            r17 = 0
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r13)
            java.lang.Float r4 = java.lang.Float.valueOf(r14)
            java.lang.Float r5 = java.lang.Float.valueOf(r14)
            boolean r7 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r7 == 0) goto L_0x023b
            r7 = r3
            androidx.constraintlayout.core.parser.CLArray r7 = (androidx.constraintlayout.core.parser.CLArray) r7
            int r10 = r7.size()
            r13 = 1
            if (r10 <= r13) goto L_0x023b
            r10 = 0
            float r3 = r7.getFloat((int) r10)
            java.lang.Float r4 = java.lang.Float.valueOf(r3)
            float r3 = r7.getFloat((int) r13)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            int r10 = r7.size()
            if (r10 <= r6) goto L_0x0243
            float r5 = r7.getFloat((int) r6)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L_0x0243
        L_0x023b:
            float r3 = r3.getFloat()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
        L_0x0243:
            float r3 = r3.floatValue()     // Catch:{ NumberFormatException -> 0x025a }
            r8.verticalBias(r3)     // Catch:{ NumberFormatException -> 0x025a }
            float r3 = r4.floatValue()     // Catch:{ NumberFormatException -> 0x025a }
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x025d
            float r3 = r4.floatValue()     // Catch:{ NumberFormatException -> 0x025a }
            r8.setFirstVerticalBias(r3)     // Catch:{ NumberFormatException -> 0x025a }
            goto L_0x025d
        L_0x025a:
            goto L_0x00e6
        L_0x025d:
            float r3 = r5.floatValue()     // Catch:{ NumberFormatException -> 0x025a }
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x00e6
            float r3 = r5.floatValue()     // Catch:{ NumberFormatException -> 0x025a }
            r8.setLastVerticalBias(r3)     // Catch:{ NumberFormatException -> 0x025a }
            goto L_0x00e6
        L_0x026e:
            r15 = r22
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r13)
            boolean r4 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L_0x02a6
            r4 = r3
            androidx.constraintlayout.core.parser.CLArray r4 = (androidx.constraintlayout.core.parser.CLArray) r4
            int r5 = r4.size()
            r13 = 1
            if (r5 <= r13) goto L_0x02a6
            r10 = 0
            int r5 = r4.getInt((int) r10)
            float r5 = (float) r5
            int r7 = r4.getInt((int) r13)
            float r7 = (float) r7
            int r10 = r4.size()
            if (r10 <= r6) goto L_0x02a3
            int r4 = r4.getInt((int) r6)
            float r4 = (float) r4
            androidx.constraintlayout.core.parser.CLArray r3 = (androidx.constraintlayout.core.parser.CLArray) r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x02a1 }
            r10 = 3
            int r3 = r3.getInt((int) r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x02a1 }
            float r3 = (float) r3
            goto L_0x02ae
        L_0x02a1:
            r3 = 0
            goto L_0x02ae
        L_0x02a3:
            r4 = r5
            r3 = r7
            goto L_0x02ae
        L_0x02a6:
            int r3 = r3.getInt()
            float r5 = (float) r3
            r3 = r5
            r4 = r3
            r7 = r4
        L_0x02ae:
            float r5 = toPix(r0, r5)
            int r5 = java.lang.Math.round(r5)
            r8.setPaddingLeft(r5)
            float r5 = toPix(r0, r7)
            int r5 = java.lang.Math.round(r5)
            r8.setPaddingTop(r5)
            float r4 = toPix(r0, r4)
            int r4 = java.lang.Math.round(r4)
            r8.setPaddingRight(r4)
            float r3 = toPix(r0, r3)
            int r3 = java.lang.Math.round(r3)
            r8.setPaddingBottom(r3)
            goto L_0x00e6
        L_0x02dc:
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r13)
            boolean r4 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L_0x0304
            r4 = r3
            androidx.constraintlayout.core.parser.CLArray r4 = (androidx.constraintlayout.core.parser.CLArray) r4
            int r5 = r4.size()
            r13 = 1
            if (r5 <= r13) goto L_0x0304
            r10 = 0
            java.lang.String r3 = r4.getString((int) r10)
            java.lang.String r5 = r4.getString((int) r13)
            int r7 = r4.size()
            if (r7 <= r6) goto L_0x0302
            java.lang.String r4 = r4.getString((int) r6)
            goto L_0x030a
        L_0x0302:
            r4 = r15
            goto L_0x030a
        L_0x0304:
            java.lang.String r5 = r3.content()
            r3 = r15
            r4 = r3
        L_0x030a:
            boolean r7 = r5.equals(r15)
            if (r7 != 0) goto L_0x0317
            int r5 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r5)
            r8.setVerticalStyle(r5)
        L_0x0317:
            boolean r5 = r3.equals(r15)
            if (r5 != 0) goto L_0x0324
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r3)
            r8.setFirstVerticalStyle(r3)
        L_0x0324:
            boolean r3 = r4.equals(r15)
            if (r3 != 0) goto L_0x00e6
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r4)
            r8.setLastVerticalStyle(r3)
            goto L_0x00e6
        L_0x0333:
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r13)
            java.lang.String r3 = r3.content()
            r3.getClass()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1720785339: goto L_0x035d;
                case -1383228885: goto L_0x0352;
                case 115029: goto L_0x0347;
                default: goto L_0x0345;
            }
        L_0x0345:
            r3 = -1
            goto L_0x0367
        L_0x0347:
            java.lang.String r4 = "top"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0350
            goto L_0x0345
        L_0x0350:
            r3 = 2
            goto L_0x0367
        L_0x0352:
            java.lang.String r4 = "bottom"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x035b
            goto L_0x0345
        L_0x035b:
            r3 = 1
            goto L_0x0367
        L_0x035d:
            java.lang.String r4 = "baseline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0366
            goto L_0x0345
        L_0x0366:
            r3 = 0
        L_0x0367:
            switch(r3) {
                case 0: goto L_0x037b;
                case 1: goto L_0x0375;
                case 2: goto L_0x036f;
                default: goto L_0x036a;
            }
        L_0x036a:
            r8.setVerticalAlign(r6)
            goto L_0x00e6
        L_0x036f:
            r10 = 0
            r8.setVerticalAlign(r10)
            goto L_0x00e6
        L_0x0375:
            r13 = 1
            r8.setVerticalAlign(r13)
            goto L_0x00e6
        L_0x037b:
            r10 = 3
            r8.setVerticalAlign(r10)
            goto L_0x00e7
        L_0x0381:
            r10 = 3
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r13)
            java.lang.Float r4 = java.lang.Float.valueOf(r14)
            java.lang.Float r5 = java.lang.Float.valueOf(r14)
            boolean r7 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r7 == 0) goto L_0x03bc
            r7 = r3
            androidx.constraintlayout.core.parser.CLArray r7 = (androidx.constraintlayout.core.parser.CLArray) r7
            int r13 = r7.size()
            r15 = 1
            if (r13 <= r15) goto L_0x03bc
            r13 = 0
            float r3 = r7.getFloat((int) r13)
            java.lang.Float r4 = java.lang.Float.valueOf(r3)
            float r3 = r7.getFloat((int) r15)
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            int r13 = r7.size()
            if (r13 <= r6) goto L_0x03c4
            float r5 = r7.getFloat((int) r6)
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            goto L_0x03c4
        L_0x03bc:
            float r3 = r3.getFloat()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
        L_0x03c4:
            float r3 = r3.floatValue()     // Catch:{ NumberFormatException -> 0x03db }
            r8.horizontalBias(r3)     // Catch:{ NumberFormatException -> 0x03db }
            float r3 = r4.floatValue()     // Catch:{ NumberFormatException -> 0x03db }
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x03de
            float r3 = r4.floatValue()     // Catch:{ NumberFormatException -> 0x03db }
            r8.setFirstHorizontalBias(r3)     // Catch:{ NumberFormatException -> 0x03db }
            goto L_0x03de
        L_0x03db:
            goto L_0x00e7
        L_0x03de:
            float r3 = r5.floatValue()     // Catch:{ NumberFormatException -> 0x03db }
            int r3 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r3 == 0) goto L_0x00e7
            float r3 = r5.floatValue()     // Catch:{ NumberFormatException -> 0x03db }
            r8.setLastHorizontalBias(r3)     // Catch:{ NumberFormatException -> 0x03db }
            goto L_0x00e7
        L_0x03ef:
            r10 = 3
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r13)
            boolean r4 = r3 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r4 == 0) goto L_0x0418
            r4 = r3
            androidx.constraintlayout.core.parser.CLArray r4 = (androidx.constraintlayout.core.parser.CLArray) r4
            int r5 = r4.size()
            r13 = 1
            if (r5 <= r13) goto L_0x0418
            r5 = 0
            java.lang.String r3 = r4.getString((int) r5)
            java.lang.String r5 = r4.getString((int) r13)
            int r7 = r4.size()
            if (r7 <= r6) goto L_0x0416
            java.lang.String r4 = r4.getString((int) r6)
            goto L_0x041e
        L_0x0416:
            r4 = r15
            goto L_0x041e
        L_0x0418:
            java.lang.String r5 = r3.content()
            r3 = r15
            r4 = r3
        L_0x041e:
            boolean r7 = r5.equals(r15)
            if (r7 != 0) goto L_0x042b
            int r5 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r5)
            r8.setHorizontalStyle(r5)
        L_0x042b:
            boolean r5 = r3.equals(r15)
            if (r5 != 0) goto L_0x0438
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r3)
            r8.setFirstHorizontalStyle(r3)
        L_0x0438:
            boolean r3 = r4.equals(r15)
            if (r3 != 0) goto L_0x00e7
            int r3 = androidx.constraintlayout.core.state.State.Chain.getValueByString(r4)
            r8.setLastHorizontalStyle(r3)
            goto L_0x00e7
        L_0x0447:
            r10 = 3
            androidx.constraintlayout.core.parser.CLElement r3 = r2.get((java.lang.String) r13)
            java.lang.String r3 = r3.content()
            r3.getClass()
            java.lang.String r4 = "end"
            boolean r4 = r3.equals(r4)
            if (r4 != 0) goto L_0x046e
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0468
            r8.setHorizontalAlign(r6)
            goto L_0x00e7
        L_0x0468:
            r13 = 0
            r8.setHorizontalAlign(r13)
            goto L_0x00e8
        L_0x046e:
            r13 = 0
            r15 = 1
            r8.setHorizontalAlign(r15)
        L_0x0473:
            r3 = 4
            r5 = 3
            r7 = 0
            r10 = 1
            goto L_0x0025
        L_0x0479:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseFlowType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void parseGenerate(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            int size = names.size();
            int i4 = 0;
            while (i4 < size) {
                String str = names.get(i4);
                i4++;
                String str2 = str;
                CLElement cLElement = cLObject.get(str2);
                ArrayList<String> list = layoutVariables.getList(str2);
                if (list != null && (cLElement instanceof CLObject)) {
                    int size2 = list.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        String str3 = list.get(i5);
                        i5++;
                        parseWidget(state, layoutVariables, str3, (CLObject) cLElement);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseGridType(java.lang.String r16, androidx.constraintlayout.core.state.State r17, java.lang.String r18, androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r19, androidx.constraintlayout.core.parser.CLObject r20) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r1 = r17
            r2 = r20
            r4 = 2
            r5 = 1
            r0 = r16
            r6 = r18
            androidx.constraintlayout.core.state.helpers.GridReference r7 = r1.getGrid(r6, r0)
            java.util.ArrayList r8 = r2.names()
            int r9 = r8.size()
            r10 = 0
            r0 = 0
        L_0x0018:
            if (r0 >= r9) goto L_0x0254
            java.lang.Object r11 = r8.get(r0)
            int r12 = r0 + 1
            java.lang.String r11 = (java.lang.String) r11
            r11.getClass()
            java.lang.String r0 = ":"
            java.lang.String r13 = ","
            r14 = -1
            int r15 = r11.hashCode()
            switch(r15) {
                case -1439500848: goto L_0x00b8;
                case -806339567: goto L_0x00ad;
                case -567445985: goto L_0x00a2;
                case 3169614: goto L_0x0097;
                case 3506649: goto L_0x008c;
                case 3586688: goto L_0x0081;
                case 97513095: goto L_0x0076;
                case 109497044: goto L_0x006b;
                case 109638249: goto L_0x005d;
                case 144441793: goto L_0x004f;
                case 949721053: goto L_0x0041;
                case 2033353925: goto L_0x0033;
                default: goto L_0x0031;
            }
        L_0x0031:
            goto L_0x00c2
        L_0x0033:
            java.lang.String r15 = "columnWeights"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x003d
            goto L_0x00c2
        L_0x003d:
            r14 = 11
            goto L_0x00c2
        L_0x0041:
            java.lang.String r15 = "columns"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x004b
            goto L_0x00c2
        L_0x004b:
            r14 = 10
            goto L_0x00c2
        L_0x004f:
            java.lang.String r15 = "rowWeights"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x0059
            goto L_0x00c2
        L_0x0059:
            r14 = 9
            goto L_0x00c2
        L_0x005d:
            java.lang.String r15 = "spans"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x0067
            goto L_0x00c2
        L_0x0067:
            r14 = 8
            goto L_0x00c2
        L_0x006b:
            java.lang.String r15 = "skips"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x0074
            goto L_0x00c2
        L_0x0074:
            r14 = 7
            goto L_0x00c2
        L_0x0076:
            java.lang.String r15 = "flags"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x007f
            goto L_0x00c2
        L_0x007f:
            r14 = 6
            goto L_0x00c2
        L_0x0081:
            java.lang.String r15 = "vGap"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x008a
            goto L_0x00c2
        L_0x008a:
            r14 = 5
            goto L_0x00c2
        L_0x008c:
            java.lang.String r15 = "rows"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x0095
            goto L_0x00c2
        L_0x0095:
            r14 = 4
            goto L_0x00c2
        L_0x0097:
            java.lang.String r15 = "hGap"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x00a0
            goto L_0x00c2
        L_0x00a0:
            r14 = 3
            goto L_0x00c2
        L_0x00a2:
            java.lang.String r15 = "contains"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x00ab
            goto L_0x00c2
        L_0x00ab:
            r14 = 2
            goto L_0x00c2
        L_0x00ad:
            java.lang.String r15 = "padding"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x00b6
            goto L_0x00c2
        L_0x00b6:
            r14 = 1
            goto L_0x00c2
        L_0x00b8:
            java.lang.String r15 = "orientation"
            boolean r15 = r11.equals(r15)
            if (r15 != 0) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r14 = 0
        L_0x00c2:
            switch(r14) {
                case 0: goto L_0x0243;
                case 1: goto L_0x01d5;
                case 2: goto L_0x01b1;
                case 3: goto L_0x019e;
                case 4: goto L_0x018d;
                case 5: goto L_0x017a;
                case 6: goto L_0x0139;
                case 7: goto L_0x0123;
                case 8: goto L_0x010d;
                case 9: goto L_0x00f7;
                case 10: goto L_0x00e7;
                case 11: goto L_0x00d1;
                default: goto L_0x00c5;
            }
        L_0x00c5:
            androidx.constraintlayout.core.state.ConstraintReference r0 = r17.constraints(r18)
            r14 = r19
            applyAttribute(r1, r14, r0, r2, r11)
        L_0x00ce:
            r15 = 3
            goto L_0x0251
        L_0x00d1:
            r14 = r19
            androidx.constraintlayout.core.parser.CLElement r0 = r2.get((java.lang.String) r11)
            java.lang.String r0 = r0.content()
            if (r0 == 0) goto L_0x00ce
            boolean r11 = r0.contains(r13)
            if (r11 == 0) goto L_0x00ce
            r7.setColumnWeights(r0)
            goto L_0x00ce
        L_0x00e7:
            r14 = r19
            androidx.constraintlayout.core.parser.CLElement r0 = r2.get((java.lang.String) r11)
            int r0 = r0.getInt()
            if (r0 <= 0) goto L_0x00ce
            r7.setColumnsSet(r0)
            goto L_0x00ce
        L_0x00f7:
            r14 = r19
            androidx.constraintlayout.core.parser.CLElement r0 = r2.get((java.lang.String) r11)
            java.lang.String r0 = r0.content()
            if (r0 == 0) goto L_0x00ce
            boolean r11 = r0.contains(r13)
            if (r11 == 0) goto L_0x00ce
            r7.setRowWeights(r0)
            goto L_0x00ce
        L_0x010d:
            r14 = r19
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            java.lang.String r11 = r11.content()
            if (r11 == 0) goto L_0x00ce
            boolean r0 = r11.contains(r0)
            if (r0 == 0) goto L_0x00ce
            r7.setSpans(r11)
            goto L_0x00ce
        L_0x0123:
            r14 = r19
            androidx.constraintlayout.core.parser.CLElement r11 = r2.get((java.lang.String) r11)
            java.lang.String r11 = r11.content()
            if (r11 == 0) goto L_0x00ce
            boolean r0 = r11.contains(r0)
            if (r0 == 0) goto L_0x00ce
            r7.setSkips(r11)
            goto L_0x00ce
        L_0x0139:
            r14 = r19
            java.lang.String r13 = ""
            androidx.constraintlayout.core.parser.CLElement r0 = r2.get((java.lang.String) r11)     // Catch:{ Exception -> 0x014a }
            boolean r11 = r0 instanceof androidx.constraintlayout.core.parser.CLNumber     // Catch:{ Exception -> 0x014a }
            if (r11 == 0) goto L_0x014c
            int r0 = r0.getInt()     // Catch:{ Exception -> 0x014a }
            goto L_0x0168
        L_0x014a:
            r0 = move-exception
            goto L_0x0151
        L_0x014c:
            java.lang.String r13 = r0.content()     // Catch:{ Exception -> 0x014a }
            goto L_0x0167
        L_0x0151:
            java.io.PrintStream r11 = java.lang.System.err
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r3 = "Error parsing grid flags "
            r15.append(r3)
            r15.append(r0)
            java.lang.String r0 = r15.toString()
            r11.println(r0)
        L_0x0167:
            r0 = 0
        L_0x0168:
            if (r13 == 0) goto L_0x0175
            boolean r3 = r13.isEmpty()
            if (r3 != 0) goto L_0x0175
            r7.setFlags((java.lang.String) r13)
            goto L_0x00ce
        L_0x0175:
            r7.setFlags((int) r0)
            goto L_0x00ce
        L_0x017a:
            r14 = r19
            androidx.constraintlayout.core.parser.CLElement r0 = r2.get((java.lang.String) r11)
            float r0 = r0.getFloat()
            float r0 = toPix(r1, r0)
            r7.setVerticalGaps(r0)
            goto L_0x00ce
        L_0x018d:
            r14 = r19
            androidx.constraintlayout.core.parser.CLElement r0 = r2.get((java.lang.String) r11)
            int r0 = r0.getInt()
            if (r0 <= 0) goto L_0x00ce
            r7.setRowsSet(r0)
            goto L_0x00ce
        L_0x019e:
            r14 = r19
            androidx.constraintlayout.core.parser.CLElement r0 = r2.get((java.lang.String) r11)
            float r0 = r0.getFloat()
            float r0 = toPix(r1, r0)
            r7.setHorizontalGaps(r0)
            goto L_0x00ce
        L_0x01b1:
            r14 = r19
            androidx.constraintlayout.core.parser.CLArray r0 = r2.getArrayOrNull(r11)
            if (r0 == 0) goto L_0x00ce
            r3 = 0
        L_0x01ba:
            int r11 = r0.size()
            if (r3 >= r11) goto L_0x00ce
            androidx.constraintlayout.core.parser.CLElement r11 = r0.get((int) r3)
            java.lang.String r11 = r11.content()
            androidx.constraintlayout.core.state.ConstraintReference r11 = r1.constraints(r11)
            java.lang.Object[] r13 = new java.lang.Object[r5]
            r13[r10] = r11
            r7.add(r13)
            int r3 = r3 + r5
            goto L_0x01ba
        L_0x01d5:
            r14 = r19
            androidx.constraintlayout.core.parser.CLElement r0 = r2.get((java.lang.String) r11)
            boolean r3 = r0 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r3 == 0) goto L_0x020d
            r3 = r0
            androidx.constraintlayout.core.parser.CLArray r3 = (androidx.constraintlayout.core.parser.CLArray) r3
            int r11 = r3.size()
            if (r11 <= r5) goto L_0x020d
            int r11 = r3.getInt((int) r10)
            float r11 = (float) r11
            int r13 = r3.getInt((int) r5)
            float r13 = (float) r13
            int r15 = r3.size()
            if (r15 <= r4) goto L_0x0209
            int r3 = r3.getInt((int) r4)
            float r3 = (float) r3
            androidx.constraintlayout.core.parser.CLArray r0 = (androidx.constraintlayout.core.parser.CLArray) r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0206 }
            r15 = 3
            int r0 = r0.getInt((int) r15)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0207 }
            float r0 = (float) r0
            goto L_0x0216
        L_0x0206:
            r15 = 3
        L_0x0207:
            r0 = 0
            goto L_0x0216
        L_0x0209:
            r15 = 3
            r3 = r11
            r0 = r13
            goto L_0x0216
        L_0x020d:
            r15 = 3
            int r0 = r0.getInt()
            float r11 = (float) r0
            r0 = r11
            r3 = r0
            r13 = r3
        L_0x0216:
            float r11 = toPix(r1, r11)
            int r11 = java.lang.Math.round(r11)
            r7.setPaddingStart(r11)
            float r11 = toPix(r1, r13)
            int r11 = java.lang.Math.round(r11)
            r7.setPaddingTop(r11)
            float r3 = toPix(r1, r3)
            int r3 = java.lang.Math.round(r3)
            r7.setPaddingEnd(r3)
            float r0 = toPix(r1, r0)
            int r0 = java.lang.Math.round(r0)
            r7.setPaddingBottom(r0)
            goto L_0x0251
        L_0x0243:
            r14 = r19
            r15 = 3
            androidx.constraintlayout.core.parser.CLElement r0 = r2.get((java.lang.String) r11)
            int r0 = r0.getInt()
            r7.setOrientation(r0)
        L_0x0251:
            r0 = r12
            goto L_0x0018
        L_0x0254:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGridType(java.lang.String, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables, androidx.constraintlayout.core.parser.CLObject):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = (androidx.constraintlayout.core.parser.CLObject) r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseGuideline(int r1, androidx.constraintlayout.core.state.State r2, androidx.constraintlayout.core.parser.CLArray r3) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 1
            androidx.constraintlayout.core.parser.CLElement r3 = r3.get((int) r0)
            boolean r0 = r3 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r0 != 0) goto L_0x000a
            goto L_0x0014
        L_0x000a:
            androidx.constraintlayout.core.parser.CLObject r3 = (androidx.constraintlayout.core.parser.CLObject) r3
            java.lang.String r0 = "id"
            java.lang.String r0 = r3.getStringOrNull((java.lang.String) r0)
            if (r0 != 0) goto L_0x0015
        L_0x0014:
            return
        L_0x0015:
            parseGuidelineParams(r1, r2, r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGuideline(int, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.parser.CLArray):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0106, code lost:
        r15 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void parseGuidelineParams(int r19, androidx.constraintlayout.core.state.State r20, java.lang.String r21, androidx.constraintlayout.core.parser.CLObject r22) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r20
            r1 = r22
            java.lang.String r2 = "start"
            java.lang.String r4 = "right"
            java.lang.String r6 = "left"
            java.lang.String r7 = "end"
            r9 = 0
            r10 = 1
            java.util.ArrayList r11 = r1.names()
            if (r11 != 0) goto L_0x0015
            return
        L_0x0015:
            androidx.constraintlayout.core.state.ConstraintReference r12 = r20.constraints(r21)
            if (r19 != 0) goto L_0x001f
            r20.horizontalGuideline(r21)
            goto L_0x0022
        L_0x001f:
            r20.verticalGuideline(r21)
        L_0x0022:
            boolean r13 = r0.isRtl()
            if (r13 == 0) goto L_0x002d
            if (r19 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r13 = 0
            goto L_0x002e
        L_0x002d:
            r13 = 1
        L_0x002e:
            androidx.constraintlayout.core.state.helpers.Facade r12 = r12.getFacade()
            androidx.constraintlayout.core.state.helpers.GuidelineReference r12 = (androidx.constraintlayout.core.state.helpers.GuidelineReference) r12
            int r14 = r11.size()
            r15 = 0
            r3 = 0
            r16 = 0
        L_0x003c:
            r17 = 1
        L_0x003e:
            if (r3 >= r14) goto L_0x0118
            java.lang.Object r18 = r11.get(r3)
            int r3 = r3 + r10
            r5 = r18
            java.lang.String r5 = (java.lang.String) r5
            r5.getClass()
            int r18 = r5.hashCode()
            switch(r18) {
                case -678927291: goto L_0x007b;
                case 100571: goto L_0x0072;
                case 3317767: goto L_0x0069;
                case 108511772: goto L_0x0060;
                case 109757538: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            r8 = -1
            goto L_0x0085
        L_0x0055:
            boolean r18 = r5.equals(r2)
            if (r18 != 0) goto L_0x005c
            goto L_0x0053
        L_0x005c:
            r18 = 4
            r8 = 4
            goto L_0x0085
        L_0x0060:
            boolean r18 = r5.equals(r4)
            if (r18 != 0) goto L_0x0067
            goto L_0x0053
        L_0x0067:
            r8 = 3
            goto L_0x0085
        L_0x0069:
            boolean r18 = r5.equals(r6)
            if (r18 != 0) goto L_0x0070
            goto L_0x0053
        L_0x0070:
            r8 = 2
            goto L_0x0085
        L_0x0072:
            boolean r18 = r5.equals(r7)
            if (r18 != 0) goto L_0x0079
            goto L_0x0053
        L_0x0079:
            r8 = 1
            goto L_0x0085
        L_0x007b:
            java.lang.String r8 = "percent"
            boolean r8 = r5.equals(r8)
            if (r8 != 0) goto L_0x0084
            goto L_0x0053
        L_0x0084:
            r8 = 0
        L_0x0085:
            switch(r8) {
                case 0: goto L_0x00b7;
                case 1: goto L_0x00ab;
                case 2: goto L_0x00a1;
                case 3: goto L_0x0095;
                case 4: goto L_0x0089;
                default: goto L_0x0088;
            }
        L_0x0088:
            goto L_0x003e
        L_0x0089:
            float r5 = r1.getFloat((java.lang.String) r5)
            float r5 = toPix(r0, r5)
            r15 = r5
            r17 = r13
            goto L_0x003e
        L_0x0095:
            float r5 = r1.getFloat((java.lang.String) r5)
            float r5 = toPix(r0, r5)
            r15 = r5
        L_0x009e:
            r17 = 0
            goto L_0x003e
        L_0x00a1:
            float r5 = r1.getFloat((java.lang.String) r5)
            float r5 = toPix(r0, r5)
            r15 = r5
            goto L_0x003c
        L_0x00ab:
            float r5 = r1.getFloat((java.lang.String) r5)
            float r5 = toPix(r0, r5)
            r17 = r13 ^ 1
            r15 = r5
            goto L_0x003e
        L_0x00b7:
            androidx.constraintlayout.core.parser.CLArray r8 = r1.getArrayOrNull(r5)
            if (r8 != 0) goto L_0x00c6
            float r5 = r1.getFloat((java.lang.String) r5)
            r15 = r5
        L_0x00c2:
            r16 = 1
            goto L_0x003c
        L_0x00c6:
            int r5 = r8.size()
            if (r5 <= r10) goto L_0x0107
            java.lang.String r5 = r8.getString((int) r9)
            float r8 = r8.getFloat((int) r10)
            r5.getClass()
            int r15 = r5.hashCode()
            switch(r15) {
                case 100571: goto L_0x00fb;
                case 3317767: goto L_0x00f2;
                case 108511772: goto L_0x00e9;
                case 109757538: goto L_0x00e0;
                default: goto L_0x00de;
            }
        L_0x00de:
            r5 = -1
            goto L_0x0103
        L_0x00e0:
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x00e7
            goto L_0x00de
        L_0x00e7:
            r5 = 3
            goto L_0x0103
        L_0x00e9:
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x00f0
            goto L_0x00de
        L_0x00f0:
            r5 = 2
            goto L_0x0103
        L_0x00f2:
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x00f9
            goto L_0x00de
        L_0x00f9:
            r5 = 1
            goto L_0x0103
        L_0x00fb:
            boolean r5 = r5.equals(r7)
            if (r5 != 0) goto L_0x0102
            goto L_0x00de
        L_0x0102:
            r5 = 0
        L_0x0103:
            switch(r5) {
                case 0: goto L_0x0115;
                case 1: goto L_0x0113;
                case 2: goto L_0x010f;
                case 3: goto L_0x010b;
                default: goto L_0x0106;
            }
        L_0x0106:
            r15 = r8
        L_0x0107:
            r16 = 1
            goto L_0x003e
        L_0x010b:
            r15 = r8
            r17 = r13
            goto L_0x0107
        L_0x010f:
            r15 = r8
            r16 = 1
            goto L_0x009e
        L_0x0113:
            r15 = r8
            goto L_0x00c2
        L_0x0115:
            r17 = r13 ^ 1
            goto L_0x0106
        L_0x0118:
            if (r16 == 0) goto L_0x0127
            if (r17 == 0) goto L_0x0120
            r12.percent(r15)
            return
        L_0x0120:
            r0 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 - r15
            r12.percent(r0)
            return
        L_0x0127:
            if (r17 == 0) goto L_0x0131
            java.lang.Float r0 = java.lang.Float.valueOf(r15)
            r12.start(r0)
            return
        L_0x0131:
            java.lang.Float r0 = java.lang.Float.valueOf(r15)
            r12.end(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseGuidelineParams(int, androidx.constraintlayout.core.state.State, java.lang.String, androidx.constraintlayout.core.parser.CLObject):void");
    }

    static void parseHeader(CoreMotionScene coreMotionScene, CLObject cLObject) {
        String stringOrNull = cLObject.getStringOrNull("export");
        if (stringOrNull != null) {
            coreMotionScene.setDebugName(stringOrNull);
        }
    }

    static void parseHelpers(State state, LayoutVariables layoutVariables, CLArray cLArray) throws CLParsingException {
        for (int i4 = 0; i4 < cLArray.size(); i4++) {
            CLElement cLElement = cLArray.get(i4);
            if (cLElement instanceof CLArray) {
                CLArray cLArray2 = (CLArray) cLElement;
                if (cLArray2.size() > 1) {
                    String string = cLArray2.getString(0);
                    string.getClass();
                    char c5 = 65535;
                    switch (string.hashCode()) {
                        case -1785507558:
                            if (string.equals("vGuideline")) {
                                c5 = 0;
                                break;
                            }
                            break;
                        case -1252464839:
                            if (string.equals("hChain")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case -851656725:
                            if (string.equals("vChain")) {
                                c5 = 2;
                                break;
                            }
                            break;
                        case 965681512:
                            if (string.equals("hGuideline")) {
                                c5 = 3;
                                break;
                            }
                            break;
                    }
                    switch (c5) {
                        case 0:
                            parseGuideline(1, state, cLArray2);
                            break;
                        case 1:
                            parseChain(0, state, layoutVariables, cLArray2);
                            break;
                        case 2:
                            parseChain(1, state, layoutVariables, cLArray2);
                            break;
                        case 3:
                            parseGuideline(0, state, cLArray2);
                            break;
                    }
                }
            }
        }
    }

    public static void parseJSON(String str, Transition transition, int i4) {
        CLObject objectOrNull;
        Transition transition2 = transition;
        int i5 = i4;
        try {
            CLObject parse = CLParser.parse(str);
            ArrayList<String> names = parse.names();
            if (names != null) {
                int size = names.size();
                int i6 = 0;
                while (i6 < size) {
                    String str2 = names.get(i6);
                    i6++;
                    String str3 = str2;
                    CLElement cLElement = parse.get(str3);
                    if ((cLElement instanceof CLObject) && (objectOrNull = ((CLObject) cLElement).getObjectOrNull("custom")) != null) {
                        ArrayList<String> names2 = objectOrNull.names();
                        int size2 = names2.size();
                        int i7 = 0;
                        while (i7 < size2) {
                            String str4 = names2.get(i7);
                            i7++;
                            String str5 = str4;
                            CLElement cLElement2 = objectOrNull.get(str5);
                            if (cLElement2 instanceof CLNumber) {
                                transition2.addCustomFloat(i5, str3, str5, cLElement2.getFloat());
                            } else if (cLElement2 instanceof CLString) {
                                long parseColorString = parseColorString(cLElement2.content());
                                if (parseColorString != -1) {
                                    transition2.addCustomColor(i5, str3, str5, (int) parseColorString);
                                }
                            }
                        }
                    }
                }
            }
        } catch (CLParsingException e5) {
            PrintStream printStream = System.err;
            printStream.println("Error parsing JSON " + e5);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseMotionProperties(androidx.constraintlayout.core.parser.CLElement r16, androidx.constraintlayout.core.state.ConstraintReference r17) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = r16
            r1 = 2
            r2 = -1
            r3 = 0
            r4 = 1
            boolean r5 = r0 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r5 != 0) goto L_0x000b
            goto L_0x0018
        L_0x000b:
            androidx.constraintlayout.core.parser.CLObject r0 = (androidx.constraintlayout.core.parser.CLObject) r0
            androidx.constraintlayout.core.motion.utils.TypedBundle r5 = new androidx.constraintlayout.core.motion.utils.TypedBundle
            r5.<init>()
            java.util.ArrayList r6 = r0.names()
            if (r6 != 0) goto L_0x0019
        L_0x0018:
            return
        L_0x0019:
            int r7 = r6.size()
            r8 = 0
        L_0x001e:
            if (r8 >= r7) goto L_0x010c
            java.lang.Object r9 = r6.get(r8)
            int r8 = r8 + r4
            java.lang.String r9 = (java.lang.String) r9
            r9.getClass()
            int r10 = r9.hashCode()
            switch(r10) {
                case -1897525331: goto L_0x005f;
                case -1310311125: goto L_0x0054;
                case -1285003983: goto L_0x0049;
                case -791482387: goto L_0x003e;
                case -236944793: goto L_0x0033;
                default: goto L_0x0031;
            }
        L_0x0031:
            r10 = -1
            goto L_0x0069
        L_0x0033:
            java.lang.String r10 = "relativeTo"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x003c
            goto L_0x0031
        L_0x003c:
            r10 = 4
            goto L_0x0069
        L_0x003e:
            java.lang.String r10 = "pathArc"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x0047
            goto L_0x0031
        L_0x0047:
            r10 = 3
            goto L_0x0069
        L_0x0049:
            java.lang.String r10 = "quantize"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x0052
            goto L_0x0031
        L_0x0052:
            r10 = 2
            goto L_0x0069
        L_0x0054:
            java.lang.String r10 = "easing"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x005d
            goto L_0x0031
        L_0x005d:
            r10 = 1
            goto L_0x0069
        L_0x005f:
            java.lang.String r10 = "stagger"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x0068
            goto L_0x0031
        L_0x0068:
            r10 = 0
        L_0x0069:
            switch(r10) {
                case 0: goto L_0x0101;
                case 1: goto L_0x00f6;
                case 2: goto L_0x00bc;
                case 3: goto L_0x0077;
                case 4: goto L_0x006d;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x001e
        L_0x006d:
            r10 = 605(0x25d, float:8.48E-43)
            java.lang.String r9 = r0.getString((java.lang.String) r9)
            r5.add((int) r10, (java.lang.String) r9)
            goto L_0x001e
        L_0x0077:
            java.lang.String r9 = r0.getString((java.lang.String) r9)
            java.lang.String r14 = "below"
            java.lang.String r15 = "above"
            java.lang.String r10 = "none"
            java.lang.String r11 = "startVertical"
            java.lang.String r12 = "startHorizontal"
            java.lang.String r13 = "flip"
            java.lang.String[] r10 = new java.lang.String[]{r10, r11, r12, r13, r14, r15}
            int r10 = indexOf(r9, r10)
            if (r10 != r2) goto L_0x00b5
            java.io.PrintStream r10 = java.lang.System.err
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            int r12 = r0.getLine()
            r11.append(r12)
            java.lang.String r12 = " pathArc = '"
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = "'"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.println(r9)
            goto L_0x001e
        L_0x00b5:
            r9 = 607(0x25f, float:8.5E-43)
            r5.add((int) r9, (int) r10)
            goto L_0x001e
        L_0x00bc:
            androidx.constraintlayout.core.parser.CLElement r10 = r0.get((java.lang.String) r9)
            boolean r11 = r10 instanceof androidx.constraintlayout.core.parser.CLArray
            r12 = 610(0x262, float:8.55E-43)
            if (r11 == 0) goto L_0x00ed
            androidx.constraintlayout.core.parser.CLArray r10 = (androidx.constraintlayout.core.parser.CLArray) r10
            int r9 = r10.size()
            if (r9 <= 0) goto L_0x001e
            int r11 = r10.getInt((int) r3)
            r5.add((int) r12, (int) r11)
            if (r9 <= r4) goto L_0x001e
            r11 = 611(0x263, float:8.56E-43)
            java.lang.String r12 = r10.getString((int) r4)
            r5.add((int) r11, (java.lang.String) r12)
            if (r9 <= r1) goto L_0x001e
            r9 = 602(0x25a, float:8.44E-43)
            float r10 = r10.getFloat((int) r1)
            r5.add((int) r9, (float) r10)
            goto L_0x001e
        L_0x00ed:
            int r9 = r0.getInt((java.lang.String) r9)
            r5.add((int) r12, (int) r9)
            goto L_0x001e
        L_0x00f6:
            r10 = 603(0x25b, float:8.45E-43)
            java.lang.String r9 = r0.getString((java.lang.String) r9)
            r5.add((int) r10, (java.lang.String) r9)
            goto L_0x001e
        L_0x0101:
            r10 = 600(0x258, float:8.41E-43)
            float r9 = r0.getFloat((java.lang.String) r9)
            r5.add((int) r10, (float) r9)
            goto L_0x001e
        L_0x010c:
            r8 = r17
            r8.mMotionProperties = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseMotionProperties(androidx.constraintlayout.core.parser.CLElement, androidx.constraintlayout.core.state.ConstraintReference):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005d A[Catch:{ CLParsingException -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A[Catch:{ CLParsingException -> 0x006e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void parseMotionSceneJSON(androidx.constraintlayout.core.state.CoreMotionScene r10, java.lang.String r11) {
        /*
            androidx.constraintlayout.core.parser.CLObject r11 = androidx.constraintlayout.core.parser.CLParser.parse(r11)     // Catch:{ CLParsingException -> 0x006e }
            java.util.ArrayList r0 = r11.names()     // Catch:{ CLParsingException -> 0x006e }
            if (r0 != 0) goto L_0x000c
            goto L_0x0085
        L_0x000c:
            int r1 = r0.size()     // Catch:{ CLParsingException -> 0x006e }
            r2 = 0
            r3 = 0
        L_0x0012:
            if (r3 >= r1) goto L_0x0085
            java.lang.Object r4 = r0.get(r3)     // Catch:{ CLParsingException -> 0x006e }
            int r3 = r3 + 1
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ CLParsingException -> 0x006e }
            androidx.constraintlayout.core.parser.CLElement r5 = r11.get((java.lang.String) r4)     // Catch:{ CLParsingException -> 0x006e }
            boolean r6 = r5 instanceof androidx.constraintlayout.core.parser.CLObject     // Catch:{ CLParsingException -> 0x006e }
            if (r6 == 0) goto L_0x0012
            androidx.constraintlayout.core.parser.CLObject r5 = (androidx.constraintlayout.core.parser.CLObject) r5     // Catch:{ CLParsingException -> 0x006e }
            int r6 = r4.hashCode()     // Catch:{ CLParsingException -> 0x006e }
            r7 = -2137403731(0xffffffff8099cead, float:-1.4124972E-38)
            r8 = 2
            r9 = 1
            if (r6 == r7) goto L_0x0050
            r7 = -241441378(0xfffffffff19be59e, float:-1.5439285E30)
            if (r6 == r7) goto L_0x0046
            r7 = 1101852654(0x41acefee, float:21.617153)
            if (r6 == r7) goto L_0x003c
            goto L_0x005a
        L_0x003c:
            java.lang.String r6 = "ConstraintSets"
            boolean r4 = r4.equals(r6)     // Catch:{ CLParsingException -> 0x006e }
            if (r4 == 0) goto L_0x005a
            r4 = 0
            goto L_0x005b
        L_0x0046:
            java.lang.String r6 = "Transitions"
            boolean r4 = r4.equals(r6)     // Catch:{ CLParsingException -> 0x006e }
            if (r4 == 0) goto L_0x005a
            r4 = 1
            goto L_0x005b
        L_0x0050:
            java.lang.String r6 = "Header"
            boolean r4 = r4.equals(r6)     // Catch:{ CLParsingException -> 0x006e }
            if (r4 == 0) goto L_0x005a
            r4 = 2
            goto L_0x005b
        L_0x005a:
            r4 = -1
        L_0x005b:
            if (r4 == 0) goto L_0x006a
            if (r4 == r9) goto L_0x0066
            if (r4 == r8) goto L_0x0062
            goto L_0x0012
        L_0x0062:
            parseHeader(r10, r5)     // Catch:{ CLParsingException -> 0x006e }
            goto L_0x0012
        L_0x0066:
            parseTransitions(r10, r5)     // Catch:{ CLParsingException -> 0x006e }
            goto L_0x0012
        L_0x006a:
            parseConstraintSets(r10, r5)     // Catch:{ CLParsingException -> 0x006e }
            goto L_0x0012
        L_0x006e:
            r10 = move-exception
            java.io.PrintStream r11 = java.lang.System.err
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error parsing JSON "
            r0.append(r1)
            r0.append(r10)
            java.lang.String r10 = r0.toString()
            r11.println(r10)
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.parseMotionSceneJSON(androidx.constraintlayout.core.state.CoreMotionScene, java.lang.String):void");
    }

    static void parseTransitions(CoreMotionScene coreMotionScene, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            int size = names.size();
            int i4 = 0;
            while (i4 < size) {
                String str = names.get(i4);
                i4++;
                String str2 = str;
                coreMotionScene.setTransitionContent(str2, cLObject.getObject(str2).toJSON());
            }
        }
    }

    private static void parseVariables(State state, LayoutVariables layoutVariables, CLObject cLObject) throws CLParsingException {
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            int size = names.size();
            int i4 = 0;
            while (i4 < size) {
                String str = names.get(i4);
                i4++;
                String str2 = str;
                CLElement cLElement = cLObject.get(str2);
                if (cLElement instanceof CLNumber) {
                    layoutVariables.put(str2, cLElement.getInt());
                } else if (cLElement instanceof CLObject) {
                    CLObject cLObject2 = (CLObject) cLElement;
                    if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has(TypedValues.TransitionType.S_TO)) {
                        float f4 = layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM));
                        layoutVariables.put(str2, f4, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_TO)), 1.0f, cLObject2.getStringOrNull("prefix"), cLObject2.getStringOrNull("postfix"));
                    } else if (cLObject2.has(TypedValues.TransitionType.S_FROM) && cLObject2.has("step")) {
                        layoutVariables.put(str2, layoutVariables.get(cLObject2.get(TypedValues.TransitionType.S_FROM)), layoutVariables.get(cLObject2.get("step")));
                    } else if (cLObject2.has("ids")) {
                        CLArray array = cLObject2.getArray("ids");
                        ArrayList arrayList = new ArrayList();
                        for (int i5 = 0; i5 < array.size(); i5++) {
                            arrayList.add(array.getString(i5));
                        }
                        layoutVariables.put(str2, (ArrayList<String>) arrayList);
                    } else if (cLObject2.has("tag")) {
                        layoutVariables.put(str2, state.getIdsForTag(cLObject2.getString("tag")));
                    }
                }
            }
        }
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, String str, CLObject cLObject) throws CLParsingException {
        parseWidget(state, layoutVariables, state.constraints(str), cLObject);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void populateState(@androidx.annotation.NonNull androidx.constraintlayout.core.parser.CLObject r11, @androidx.annotation.NonNull androidx.constraintlayout.core.state.State r12, @androidx.annotation.NonNull androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables r13) throws androidx.constraintlayout.core.parser.CLParsingException {
        /*
            r0 = 2
            r1 = -1
            r2 = 0
            r3 = 1
            java.util.ArrayList r4 = r11.names()
            if (r4 != 0) goto L_0x000c
            goto L_0x012a
        L_0x000c:
            int r5 = r4.size()
            r6 = 0
        L_0x0011:
            if (r6 >= r5) goto L_0x012a
            java.lang.Object r7 = r4.get(r6)
            int r6 = r6 + r3
            java.lang.String r7 = (java.lang.String) r7
            androidx.constraintlayout.core.parser.CLElement r8 = r11.get((java.lang.String) r7)
            r7.getClass()
            int r9 = r7.hashCode()
            switch(r9) {
                case -1824489883: goto L_0x0040;
                case 1875016085: goto L_0x0035;
                case 1921490263: goto L_0x002a;
                default: goto L_0x0028;
            }
        L_0x0028:
            r9 = -1
            goto L_0x004a
        L_0x002a:
            java.lang.String r9 = "Variables"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0033
            goto L_0x0028
        L_0x0033:
            r9 = 2
            goto L_0x004a
        L_0x0035:
            java.lang.String r9 = "Generate"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x003e
            goto L_0x0028
        L_0x003e:
            r9 = 1
            goto L_0x004a
        L_0x0040:
            java.lang.String r9 = "Helpers"
            boolean r9 = r7.equals(r9)
            if (r9 != 0) goto L_0x0049
            goto L_0x0028
        L_0x0049:
            r9 = 0
        L_0x004a:
            switch(r9) {
                case 0: goto L_0x011f;
                case 1: goto L_0x0114;
                case 2: goto L_0x0109;
                default: goto L_0x004d;
            }
        L_0x004d:
            boolean r9 = r8 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r9 == 0) goto L_0x00fc
            androidx.constraintlayout.core.parser.CLObject r8 = (androidx.constraintlayout.core.parser.CLObject) r8
            java.lang.String r9 = lookForType(r8)
            if (r9 == 0) goto L_0x00f7
            int r10 = r9.hashCode()
            switch(r10) {
                case -1785507558: goto L_0x00ca;
                case -1354837162: goto L_0x00bf;
                case -1252464839: goto L_0x00b4;
                case -851656725: goto L_0x00a9;
                case -333143113: goto L_0x009e;
                case 113114: goto L_0x0093;
                case 3181382: goto L_0x0088;
                case 98238902: goto L_0x007d;
                case 111168196: goto L_0x0070;
                case 965681512: goto L_0x0063;
                default: goto L_0x0060;
            }
        L_0x0060:
            r10 = -1
            goto L_0x00d4
        L_0x0063:
            java.lang.String r10 = "hGuideline"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x006c
            goto L_0x0060
        L_0x006c:
            r10 = 9
            goto L_0x00d4
        L_0x0070:
            java.lang.String r10 = "vFlow"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x0079
            goto L_0x0060
        L_0x0079:
            r10 = 8
            goto L_0x00d4
        L_0x007d:
            java.lang.String r10 = "hFlow"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x0086
            goto L_0x0060
        L_0x0086:
            r10 = 7
            goto L_0x00d4
        L_0x0088:
            java.lang.String r10 = "grid"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x0091
            goto L_0x0060
        L_0x0091:
            r10 = 6
            goto L_0x00d4
        L_0x0093:
            java.lang.String r10 = "row"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x009c
            goto L_0x0060
        L_0x009c:
            r10 = 5
            goto L_0x00d4
        L_0x009e:
            java.lang.String r10 = "barrier"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x00a7
            goto L_0x0060
        L_0x00a7:
            r10 = 4
            goto L_0x00d4
        L_0x00a9:
            java.lang.String r10 = "vChain"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x00b2
            goto L_0x0060
        L_0x00b2:
            r10 = 3
            goto L_0x00d4
        L_0x00b4:
            java.lang.String r10 = "hChain"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x00bd
            goto L_0x0060
        L_0x00bd:
            r10 = 2
            goto L_0x00d4
        L_0x00bf:
            java.lang.String r10 = "column"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x00c8
            goto L_0x0060
        L_0x00c8:
            r10 = 1
            goto L_0x00d4
        L_0x00ca:
            java.lang.String r10 = "vGuideline"
            boolean r10 = r9.equals(r10)
            if (r10 != 0) goto L_0x00d3
            goto L_0x0060
        L_0x00d3:
            r10 = 0
        L_0x00d4:
            switch(r10) {
                case 0: goto L_0x00f2;
                case 1: goto L_0x00ed;
                case 2: goto L_0x00e8;
                case 3: goto L_0x00e8;
                case 4: goto L_0x00e3;
                case 5: goto L_0x00ed;
                case 6: goto L_0x00ed;
                case 7: goto L_0x00de;
                case 8: goto L_0x00de;
                case 9: goto L_0x00d9;
                default: goto L_0x00d7;
            }
        L_0x00d7:
            goto L_0x0011
        L_0x00d9:
            parseGuidelineParams(r2, r12, r7, r8)
            goto L_0x0011
        L_0x00de:
            parseFlowType(r9, r12, r7, r13, r8)
            goto L_0x0011
        L_0x00e3:
            parseBarrier(r12, r7, r8)
            goto L_0x0011
        L_0x00e8:
            parseChainType(r9, r12, r7, r13, r8)
            goto L_0x0011
        L_0x00ed:
            parseGridType(r9, r12, r7, r13, r8)
            goto L_0x0011
        L_0x00f2:
            parseGuidelineParams(r3, r12, r7, r8)
            goto L_0x0011
        L_0x00f7:
            parseWidget((androidx.constraintlayout.core.state.State) r12, (androidx.constraintlayout.core.state.ConstraintSetParser.LayoutVariables) r13, (java.lang.String) r7, (androidx.constraintlayout.core.parser.CLObject) r8)
            goto L_0x0011
        L_0x00fc:
            boolean r9 = r8 instanceof androidx.constraintlayout.core.parser.CLNumber
            if (r9 == 0) goto L_0x0011
            int r8 = r8.getInt()
            r13.put((java.lang.String) r7, (int) r8)
            goto L_0x0011
        L_0x0109:
            boolean r7 = r8 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r7 == 0) goto L_0x0011
            androidx.constraintlayout.core.parser.CLObject r8 = (androidx.constraintlayout.core.parser.CLObject) r8
            parseVariables(r12, r13, r8)
            goto L_0x0011
        L_0x0114:
            boolean r7 = r8 instanceof androidx.constraintlayout.core.parser.CLObject
            if (r7 == 0) goto L_0x0011
            androidx.constraintlayout.core.parser.CLObject r8 = (androidx.constraintlayout.core.parser.CLObject) r8
            parseGenerate(r12, r13, r8)
            goto L_0x0011
        L_0x011f:
            boolean r7 = r8 instanceof androidx.constraintlayout.core.parser.CLArray
            if (r7 == 0) goto L_0x0011
            androidx.constraintlayout.core.parser.CLArray r8 = (androidx.constraintlayout.core.parser.CLArray) r8
            parseHelpers(r12, r13, r8)
            goto L_0x0011
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.state.ConstraintSetParser.populateState(androidx.constraintlayout.core.parser.CLObject, androidx.constraintlayout.core.state.State, androidx.constraintlayout.core.state.ConstraintSetParser$LayoutVariables):void");
    }

    private static float toPix(State state, float f4) {
        return state.getDpToPixel().toPixels(f4);
    }

    static void parseWidget(State state, LayoutVariables layoutVariables, ConstraintReference constraintReference, CLObject cLObject) throws CLParsingException {
        if (constraintReference.getWidth() == null) {
            constraintReference.setWidth(Dimension.createWrap());
        }
        if (constraintReference.getHeight() == null) {
            constraintReference.setHeight(Dimension.createWrap());
        }
        ArrayList<String> names = cLObject.names();
        if (names != null) {
            int size = names.size();
            int i4 = 0;
            while (i4 < size) {
                String str = names.get(i4);
                i4++;
                applyAttribute(state, layoutVariables, constraintReference, cLObject, str);
            }
        }
    }

    public static void parseJSON(String str, State state, LayoutVariables layoutVariables) throws CLParsingException {
        try {
            populateState(CLParser.parse(str), state, layoutVariables);
        } catch (CLParsingException e5) {
            PrintStream printStream = System.err;
            printStream.println("Error parsing JSON " + e5);
        }
    }
}
