package androidx.constraintlayout.core.state;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLContainer;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.state.Transition;
import com.mbridge.msdk.foundation.entity.b;
import java.lang.reflect.Array;

public class TransitionParser {
    private static int map(String str, String... strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (strArr[i4].equals(str)) {
                return i4;
            }
        }
        return 0;
    }

    @Deprecated
    public static void parse(CLObject cLObject, Transition transition, CorePixelDp corePixelDp) throws CLParsingException {
        parse(cLObject, transition);
    }

    private static void parseKeyAttribute(CLObject cLObject, Transition transition) throws CLParsingException {
        CLArray arrayOrNull;
        CustomVariable[][] customVariableArr;
        CustomVariable[] customVariableArr2;
        CLObject cLObject2;
        int i4;
        CLObject cLObject3 = cLObject;
        Transition transition2 = transition;
        int i5 = 9;
        CLArray arrayOrNull2 = cLObject3.getArrayOrNull(TypedValues.AttributesType.S_TARGET);
        if (arrayOrNull2 != null && (arrayOrNull = cLObject3.getArrayOrNull(b.JSON_KEY_FRAME_ADS)) != null) {
            String stringOrNull = cLObject3.getStringOrNull("transitionEasing");
            String[] strArr = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha"};
            int[] iArr = {311, 312, 304, 305, 306, 308, 309, 310, 303};
            boolean[] zArr = {false, false, true, true, true, false, false, false, false};
            int size = arrayOrNull.size();
            TypedBundle[] typedBundleArr = new TypedBundle[size];
            for (int i6 = 0; i6 < arrayOrNull.size(); i6++) {
                typedBundleArr[i6] = new TypedBundle();
            }
            int i7 = 0;
            while (i7 < i5) {
                String str = strArr[i7];
                int i8 = iArr[i7];
                boolean z4 = zArr[i7];
                CLArray arrayOrNull3 = cLObject3.getArrayOrNull(str);
                if (arrayOrNull3 == null || arrayOrNull3.size() == size) {
                    if (arrayOrNull3 != null) {
                        for (int i9 = 0; i9 < size; i9++) {
                            float f4 = arrayOrNull3.getFloat(i9);
                            if (z4) {
                                f4 = transition2.mToPixel.toPixels(f4);
                            }
                            typedBundleArr[i9].add(i8, f4);
                        }
                    } else {
                        float floatOrNaN = cLObject3.getFloatOrNaN(str);
                        if (!Float.isNaN(floatOrNaN)) {
                            if (z4) {
                                floatOrNaN = transition2.mToPixel.toPixels(floatOrNaN);
                            }
                            for (int i10 = 0; i10 < size; i10++) {
                                typedBundleArr[i10].add(i8, floatOrNaN);
                            }
                        }
                    }
                    i7++;
                    i5 = 9;
                } else {
                    throw new CLParsingException("incorrect size for " + str + " array, not matching targets array!", cLObject3);
                }
            }
            CLElement orNull = cLObject3.getOrNull("custom");
            if (orNull == null || !(orNull instanceof CLObject)) {
                customVariableArr = null;
            } else {
                CLObject cLObject4 = (CLObject) orNull;
                int size2 = cLObject4.size();
                int size3 = arrayOrNull.size();
                int[] iArr2 = new int[2];
                iArr2[1] = size2;
                iArr2[0] = size3;
                customVariableArr = (CustomVariable[][]) Array.newInstance(CustomVariable.class, iArr2);
                int i11 = 0;
                while (i11 < size2) {
                    CLKey cLKey = (CLKey) cLObject4.get(i11);
                    String content = cLKey.content();
                    if (cLKey.getValue() instanceof CLArray) {
                        CLArray cLArray = (CLArray) cLKey.getValue();
                        int size4 = cLArray.size();
                        if (size4 == size && size4 > 0) {
                            if (cLArray.get(0) instanceof CLNumber) {
                                int i12 = 0;
                                while (i12 < size) {
                                    customVariableArr[i12][i11] = new CustomVariable(content, (int) TypedValues.Custom.TYPE_FLOAT, cLArray.get(i12).getFloat());
                                    i12++;
                                    cLObject4 = cLObject4;
                                }
                            } else {
                                cLObject2 = cLObject4;
                                int i13 = 0;
                                while (i13 < size) {
                                    long parseColorString = ConstraintSetParser.parseColorString(cLArray.get(i13).content());
                                    if (parseColorString != -1) {
                                        i4 = i13;
                                        customVariableArr[i13][i11] = new CustomVariable(content, (int) TypedValues.Custom.TYPE_COLOR, (int) parseColorString);
                                    } else {
                                        i4 = i13;
                                    }
                                    i13 = i4 + 1;
                                }
                            }
                        }
                        cLObject2 = cLObject4;
                    } else {
                        cLObject2 = cLObject4;
                        CLElement value = cLKey.getValue();
                        if (value instanceof CLNumber) {
                            float f5 = value.getFloat();
                            for (int i14 = 0; i14 < size; i14++) {
                                customVariableArr[i14][i11] = new CustomVariable(content, (int) TypedValues.Custom.TYPE_FLOAT, f5);
                            }
                        } else {
                            long parseColorString2 = ConstraintSetParser.parseColorString(value.content());
                            if (parseColorString2 != -1) {
                                int i15 = 0;
                                while (i15 < size) {
                                    customVariableArr[i15][i11] = new CustomVariable(content, (int) TypedValues.Custom.TYPE_COLOR, (int) parseColorString2);
                                    i15++;
                                    size2 = size2;
                                    parseColorString2 = parseColorString2;
                                }
                            }
                        }
                    }
                    i11++;
                    size2 = size2;
                    cLObject4 = cLObject2;
                }
            }
            String stringOrNull2 = cLObject3.getStringOrNull("curveFit");
            for (int i16 = 0; i16 < arrayOrNull2.size(); i16++) {
                for (int i17 = 0; i17 < size; i17++) {
                    String string = arrayOrNull2.getString(i16);
                    TypedBundle typedBundle = typedBundleArr[i17];
                    if (stringOrNull2 != null) {
                        typedBundle.add((int) TypedValues.PositionType.TYPE_CURVE_FIT, map(stringOrNull2, "spline", "linear"));
                    }
                    typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                    typedBundle.add(100, arrayOrNull.getInt(i17));
                    if (customVariableArr != null) {
                        customVariableArr2 = customVariableArr[i17];
                    } else {
                        customVariableArr2 = null;
                    }
                    transition2.addKeyAttribute(string, typedBundle, customVariableArr2);
                }
            }
        }
    }

    private static void parseKeyCycle(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject cLObject2 = cLObject;
        Transition transition2 = transition;
        CLArray array = cLObject2.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject2.getArray(b.JSON_KEY_FRAME_ADS);
        String stringOrNull = cLObject2.getStringOrNull("transitionEasing");
        String[] strArr = {"scaleX", "scaleY", "translationX", "translationY", "translationZ", "rotationX", "rotationY", "rotationZ", "alpha", TypedValues.CycleType.S_WAVE_PERIOD, TypedValues.CycleType.S_WAVE_OFFSET, TypedValues.CycleType.S_WAVE_PHASE};
        int i4 = 12;
        int[] iArr = {311, 312, 304, 305, 306, 308, 309, 310, 403, TypedValues.CycleType.TYPE_WAVE_PERIOD, TypedValues.CycleType.TYPE_WAVE_OFFSET, TypedValues.CycleType.TYPE_WAVE_PHASE};
        int[] iArr2 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 2, 0};
        int size = array2.size();
        TypedBundle[] typedBundleArr = new TypedBundle[size];
        for (int i5 = 0; i5 < size; i5++) {
            typedBundleArr[i5] = new TypedBundle();
        }
        boolean z4 = false;
        for (int i6 = 0; i6 < 12; i6++) {
            if (cLObject2.has(strArr[i6]) && iArr2[i6] == 1) {
                z4 = true;
            }
        }
        int i7 = 0;
        while (i7 < i4) {
            String str = strArr[i7];
            int i8 = iArr[i7];
            int i9 = iArr2[i7];
            CLArray arrayOrNull = cLObject2.getArrayOrNull(str);
            String[] strArr2 = strArr;
            if (arrayOrNull == null || arrayOrNull.size() == size) {
                if (arrayOrNull != null) {
                    int i10 = 0;
                    while (i10 < size) {
                        float f4 = arrayOrNull.getFloat(i10);
                        int i11 = i10;
                        if (i9 == 1) {
                            f4 = transition2.mToPixel.toPixels(f4);
                        } else if (i9 == 2 && z4) {
                            f4 = transition2.mToPixel.toPixels(f4);
                        }
                        typedBundleArr[i11].add(i8, f4);
                        i10 = i11 + 1;
                    }
                } else {
                    float floatOrNaN = cLObject2.getFloatOrNaN(str);
                    if (!Float.isNaN(floatOrNaN)) {
                        if (i9 == 1) {
                            floatOrNaN = transition2.mToPixel.toPixels(floatOrNaN);
                        } else if (i9 == 2 && z4) {
                            floatOrNaN = transition2.mToPixel.toPixels(floatOrNaN);
                        }
                        for (int i12 = 0; i12 < size; i12++) {
                            typedBundleArr[i12].add(i8, floatOrNaN);
                        }
                        i7++;
                        strArr = strArr2;
                        i4 = 12;
                    }
                }
                i7++;
                strArr = strArr2;
                i4 = 12;
            } else {
                throw new CLParsingException("incorrect size for $attrName array, not matching targets array!", cLObject2);
            }
        }
        String stringOrNull2 = cLObject2.getStringOrNull("curveFit");
        String stringOrNull3 = cLObject2.getStringOrNull("easing");
        String stringOrNull4 = cLObject2.getStringOrNull("waveShape");
        String stringOrNull5 = cLObject2.getStringOrNull(TypedValues.CycleType.S_CUSTOM_WAVE_SHAPE);
        for (int i13 = 0; i13 < array.size(); i13++) {
            for (int i14 = 0; i14 < size; i14++) {
                String string = array.getString(i13);
                TypedBundle typedBundle = typedBundleArr[i14];
                if (stringOrNull2 != null) {
                    if (stringOrNull2.equals("linear")) {
                        typedBundle.add(401, 1);
                    } else if (stringOrNull2.equals("spline")) {
                        typedBundle.add(401, 0);
                    }
                }
                typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull);
                if (stringOrNull3 != null) {
                    typedBundle.add((int) TypedValues.CycleType.TYPE_EASING, stringOrNull3);
                }
                if (stringOrNull4 != null) {
                    typedBundle.add((int) TypedValues.CycleType.TYPE_WAVE_SHAPE, stringOrNull4);
                }
                if (stringOrNull5 != null) {
                    typedBundle.add((int) TypedValues.CycleType.TYPE_CUSTOM_WAVE_SHAPE, stringOrNull5);
                }
                typedBundle.add(100, array2.getInt(i14));
                transition2.addKeyCycle(string, typedBundle);
            }
        }
    }

    public static void parseKeyFrames(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject objectOrNull = cLObject.getObjectOrNull("KeyFrames");
        if (objectOrNull != null) {
            CLArray arrayOrNull = objectOrNull.getArrayOrNull("KeyPositions");
            if (arrayOrNull != null) {
                for (int i4 = 0; i4 < arrayOrNull.size(); i4++) {
                    CLElement cLElement = arrayOrNull.get(i4);
                    if (cLElement instanceof CLObject) {
                        parseKeyPosition((CLObject) cLElement, transition);
                    }
                }
            }
            CLArray arrayOrNull2 = objectOrNull.getArrayOrNull(TypedValues.AttributesType.NAME);
            if (arrayOrNull2 != null) {
                for (int i5 = 0; i5 < arrayOrNull2.size(); i5++) {
                    CLElement cLElement2 = arrayOrNull2.get(i5);
                    if (cLElement2 instanceof CLObject) {
                        parseKeyAttribute((CLObject) cLElement2, transition);
                    }
                }
            }
            CLArray arrayOrNull3 = objectOrNull.getArrayOrNull("KeyCycles");
            if (arrayOrNull3 != null) {
                for (int i6 = 0; i6 < arrayOrNull3.size(); i6++) {
                    CLElement cLElement3 = arrayOrNull3.get(i6);
                    if (cLElement3 instanceof CLObject) {
                        parseKeyCycle((CLObject) cLElement3, transition);
                    }
                }
            }
        }
    }

    private static void parseKeyPosition(CLObject cLObject, Transition transition) throws CLParsingException {
        CLObject cLObject2 = cLObject;
        TypedBundle typedBundle = new TypedBundle();
        CLArray array = cLObject2.getArray(TypedValues.AttributesType.S_TARGET);
        CLArray array2 = cLObject2.getArray(b.JSON_KEY_FRAME_ADS);
        CLArray arrayOrNull = cLObject2.getArrayOrNull("percentX");
        CLArray arrayOrNull2 = cLObject2.getArrayOrNull("percentY");
        CLArray arrayOrNull3 = cLObject2.getArrayOrNull("percentWidth");
        CLArray arrayOrNull4 = cLObject2.getArrayOrNull("percentHeight");
        String stringOrNull = cLObject2.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        String stringOrNull2 = cLObject2.getStringOrNull("transitionEasing");
        String stringOrNull3 = cLObject2.getStringOrNull("curveFit");
        String stringOrNull4 = cLObject2.getStringOrNull("type");
        if (stringOrNull4 == null) {
            stringOrNull4 = "parentRelative";
        }
        if (arrayOrNull != null && array2.size() != arrayOrNull.size()) {
            return;
        }
        if (arrayOrNull2 == null || array2.size() == arrayOrNull2.size()) {
            int i4 = 0;
            while (i4 < array.size()) {
                String string = array.getString(i4);
                int map = map(stringOrNull4, "deltaRelative", "pathRelative", "parentRelative");
                typedBundle.clear();
                typedBundle.add((int) TypedValues.PositionType.TYPE_POSITION_TYPE, map);
                if (stringOrNull3 != null) {
                    map(typedBundle, TypedValues.PositionType.TYPE_CURVE_FIT, stringOrNull3, "spline", "linear");
                }
                typedBundle.addIfNotNull(TypedValues.PositionType.TYPE_TRANSITION_EASING, stringOrNull2);
                if (stringOrNull != null) {
                    map(typedBundle, 509, stringOrNull, "none", "startVertical", "startHorizontal", "flip", "below", "above");
                }
                int i5 = 0;
                while (i5 < array2.size()) {
                    typedBundle.add(100, array2.getInt(i5));
                    set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_X, arrayOrNull, i5);
                    set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_Y, arrayOrNull2, i5);
                    set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_WIDTH, arrayOrNull3, i5);
                    set(typedBundle, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, arrayOrNull4, i5);
                    transition.addKeyPosition(string, typedBundle);
                    i5++;
                    stringOrNull4 = stringOrNull4;
                }
                String str = stringOrNull4;
                Transition transition2 = transition;
                i4++;
                stringOrNull4 = str;
            }
        }
    }

    private static void parseOnSwipe(CLContainer cLContainer, Transition transition) {
        CLContainer cLContainer2 = cLContainer;
        String stringOrNull = cLContainer2.getStringOrNull("anchor");
        int map = map(cLContainer2.getStringOrNull("side"), Transition.OnSwipe.SIDES);
        int map2 = map(cLContainer2.getStringOrNull("direction"), Transition.OnSwipe.DIRECTIONS);
        float floatOrNaN = cLContainer2.getFloatOrNaN("scale");
        float floatOrNaN2 = cLContainer2.getFloatOrNaN("threshold");
        float floatOrNaN3 = cLContainer2.getFloatOrNaN("maxVelocity");
        float floatOrNaN4 = cLContainer2.getFloatOrNaN("maxAccel");
        String stringOrNull2 = cLContainer2.getStringOrNull("limitBounds");
        int map3 = map(cLContainer2.getStringOrNull("mode"), Transition.OnSwipe.MODE);
        int map4 = map(cLContainer2.getStringOrNull("touchUp"), Transition.OnSwipe.TOUCH_UP);
        float floatOrNaN5 = cLContainer2.getFloatOrNaN("springMass");
        float floatOrNaN6 = cLContainer2.getFloatOrNaN("springStiffness");
        float floatOrNaN7 = cLContainer2.getFloatOrNaN("springDamping");
        float floatOrNaN8 = cLContainer2.getFloatOrNaN("stopThreshold");
        int map5 = map(cLContainer2.getStringOrNull("springBoundary"), Transition.OnSwipe.BOUNDARY);
        String stringOrNull3 = cLContainer2.getStringOrNull("around");
        Transition.OnSwipe createOnSwipe = transition.createOnSwipe();
        createOnSwipe.setAnchorId(stringOrNull);
        createOnSwipe.setAnchorSide(map);
        createOnSwipe.setDragDirection(map2);
        createOnSwipe.setDragScale(floatOrNaN);
        createOnSwipe.setDragThreshold(floatOrNaN2);
        createOnSwipe.setMaxVelocity(floatOrNaN3);
        createOnSwipe.setMaxAcceleration(floatOrNaN4);
        createOnSwipe.setLimitBoundsTo(stringOrNull2);
        createOnSwipe.setAutoCompleteMode(map3);
        createOnSwipe.setOnTouchUp(map4);
        createOnSwipe.setSpringMass(floatOrNaN5);
        createOnSwipe.setSpringStiffness(floatOrNaN6);
        createOnSwipe.setSpringDamping(floatOrNaN7);
        createOnSwipe.setSpringStopThreshold(floatOrNaN8);
        createOnSwipe.setSpringBoundary(map5);
        createOnSwipe.setRotationCenterId(stringOrNull3);
    }

    private static void set(TypedBundle typedBundle, int i4, CLArray cLArray, int i5) throws CLParsingException {
        if (cLArray != null) {
            typedBundle.add(i4, cLArray.getFloat(i5));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void parse(@NonNull CLObject cLObject, @NonNull Transition transition) throws CLParsingException {
        transition.resetProperties();
        String stringOrNull = cLObject.getStringOrNull(TypedValues.TransitionType.S_PATH_MOTION_ARC);
        TypedBundle typedBundle = new TypedBundle();
        boolean z4 = true;
        boolean z5 = false;
        if (stringOrNull != null) {
            char c5 = 65535;
            switch (stringOrNull.hashCode()) {
                case -1857024520:
                    if (stringOrNull.equals("startVertical")) {
                        c5 = 0;
                        break;
                    }
                    break;
                case -1007052250:
                    if (stringOrNull.equals("startHorizontal")) {
                        c5 = 1;
                        break;
                    }
                    break;
                case 3145837:
                    if (stringOrNull.equals("flip")) {
                        c5 = 2;
                        break;
                    }
                    break;
                case 3387192:
                    if (stringOrNull.equals("none")) {
                        c5 = 3;
                        break;
                    }
                    break;
                case 92611485:
                    if (stringOrNull.equals("above")) {
                        c5 = 4;
                        break;
                    }
                    break;
                case 93621297:
                    if (stringOrNull.equals("below")) {
                        c5 = 5;
                        break;
                    }
                    break;
            }
            switch (c5) {
                case 0:
                    typedBundle.add(509, 1);
                    break;
                case 1:
                    typedBundle.add(509, 2);
                    break;
                case 2:
                    typedBundle.add(509, 3);
                    break;
                case 3:
                    typedBundle.add(509, 0);
                    break;
                case 4:
                    typedBundle.add(509, 5);
                    break;
                case 5:
                    typedBundle.add(509, 4);
                    break;
            }
            z5 = true;
        }
        String stringOrNull2 = cLObject.getStringOrNull("interpolator");
        if (stringOrNull2 != null) {
            typedBundle.add((int) TypedValues.TransitionType.TYPE_INTERPOLATOR, stringOrNull2);
            z5 = true;
        }
        float floatOrNaN = cLObject.getFloatOrNaN(TypedValues.TransitionType.S_STAGGERED);
        if (!Float.isNaN(floatOrNaN)) {
            typedBundle.add((int) TypedValues.TransitionType.TYPE_STAGGERED, floatOrNaN);
        } else {
            z4 = z5;
        }
        if (z4) {
            transition.setTransitionProperties(typedBundle);
        }
        CLObject objectOrNull = cLObject.getObjectOrNull("onSwipe");
        if (objectOrNull != null) {
            parseOnSwipe(objectOrNull, transition);
        }
        parseKeyFrames(cLObject, transition);
    }

    private static void map(TypedBundle typedBundle, int i4, String str, String... strArr) {
        for (int i5 = 0; i5 < strArr.length; i5++) {
            if (strArr[i5].equals(str)) {
                typedBundle.add(i4, i5);
            }
        }
    }
}
