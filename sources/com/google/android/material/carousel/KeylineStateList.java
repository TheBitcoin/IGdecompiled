package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = DesugarCollections.unmodifiableList(list);
        this.endStateSteps = DesugarCollections.unmodifiableList(list2);
        float f4 = list.get(list.size() - 1).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f4;
        float f5 = keylineState.getLastKeyline().loc - list2.get(list2.size() - 1).getLastKeyline().loc;
        this.endShiftRange = f5;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f4, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f5, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f4, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f4, fArr);
        if (stateStepsRange[0] >= 0.5f) {
            return list.get((int) stateStepsRange[2]);
        }
        return list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f4) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f4 == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i4 = 0; i4 < keylineState.getKeylines().size(); i4++) {
            if (!keylineState.getKeylines().get(i4).isAnchor) {
                return i4;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f4) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f4 == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f4, float f5, float f6) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f4, f5), getStateStepsEnd(carousel, keylineState, f4, f6));
    }

    private static float[] getStateStepInterpolationPoints(float f4, List<KeylineState> list, boolean z4) {
        float f5;
        float f6;
        int size = list.size();
        float[] fArr = new float[size];
        for (int i4 = 1; i4 < size; i4++) {
            int i5 = i4 - 1;
            KeylineState keylineState = list.get(i5);
            KeylineState keylineState2 = list.get(i4);
            if (z4) {
                f5 = keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
            } else {
                f5 = keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc;
            }
            float f7 = f5 / f4;
            if (i4 == size - 1) {
                f6 = 1.0f;
            } else {
                f6 = fArr[i5] + f7;
            }
            fArr[i4] = f6;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f4, float f5) {
        int containerHeight;
        int i4;
        KeylineState keylineState2 = keylineState;
        float f6 = f4;
        float f7 = f5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState2);
        int findLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState2);
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        } else {
            containerHeight = carousel.getContainerHeight();
        }
        float f8 = (float) containerHeight;
        if (!isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) && findLastNonAnchorKeylineIndex != -1) {
            int lastFocalKeylineIndex = findLastNonAnchorKeylineIndex - keylineState2.getLastFocalKeylineIndex();
            float f9 = keylineState2.getFirstKeyline().locOffset - (keylineState2.getFirstKeyline().maskedItemSize / 2.0f);
            if (lastFocalKeylineIndex > 0 || keylineState2.getLastFocalKeyline().cutoff <= 0.0f) {
                float f10 = 0.0f;
                int i5 = 0;
                while (i5 < lastFocalKeylineIndex) {
                    KeylineState keylineState3 = (KeylineState) arrayList.get(arrayList.size() - 1);
                    int i6 = findLastNonAnchorKeylineIndex - i5;
                    float f11 = f10 + keylineState2.getKeylines().get(i6).cutoff;
                    int i7 = i6 + 1;
                    if (i7 < keylineState2.getKeylines().size()) {
                        i4 = findLastIndexBeforeFirstFocalKeylineWithMask(keylineState3, keylineState2.getKeylines().get(i7).mask) + 1;
                    } else {
                        i4 = 0;
                    }
                    KeylineState keylineState4 = keylineState3;
                    int i8 = i4;
                    KeylineState keylineState5 = keylineState4;
                    KeylineState moveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState5, findLastNonAnchorKeylineIndex, i8, f9 - f11, keylineState2.getFirstFocalKeylineIndex() + i5 + 1, keylineState2.getLastFocalKeylineIndex() + i5 + 1, f8);
                    if (i5 == lastFocalKeylineIndex - 1 && f7 > 0.0f) {
                        moveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(moveKeylineAndCreateKeylineState, f7, f8, false, f6);
                    }
                    arrayList.add(moveKeylineAndCreateKeylineState);
                    i5++;
                    f10 = f11;
                }
            } else {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState2, f9 - keylineState2.getLastFocalKeyline().cutoff, f8));
                return arrayList;
            }
        } else if (f7 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState2, f7, f8, false, f6));
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f4, float[] fArr) {
        int size = list.size();
        float f5 = fArr[0];
        int i4 = 1;
        while (i4 < size) {
            float f6 = fArr[i4];
            if (f4 <= f6) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f5, f6, f4), (float) (i4 - 1), (float) i4};
            }
            i4++;
            f5 = f6;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f4, float f5) {
        int containerHeight;
        KeylineState keylineState2 = keylineState;
        float f6 = f4;
        float f7 = f5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState2);
        int findFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState2);
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        } else {
            containerHeight = carousel.getContainerHeight();
        }
        float f8 = (float) containerHeight;
        if (!isFirstFocalItemAtLeftOfContainer(keylineState2) && findFirstNonAnchorKeylineIndex != -1) {
            int firstFocalKeylineIndex = keylineState2.getFirstFocalKeylineIndex() - findFirstNonAnchorKeylineIndex;
            float f9 = keylineState2.getFirstKeyline().locOffset - (keylineState2.getFirstKeyline().maskedItemSize / 2.0f);
            if (firstFocalKeylineIndex > 0 || keylineState2.getFirstFocalKeyline().cutoff <= 0.0f) {
                float f10 = 0.0f;
                int i4 = 0;
                while (i4 < firstFocalKeylineIndex) {
                    KeylineState keylineState3 = (KeylineState) arrayList.get(arrayList.size() - 1);
                    int i5 = findFirstNonAnchorKeylineIndex + i4;
                    int size = keylineState2.getKeylines().size() - 1;
                    float f11 = f10 + keylineState2.getKeylines().get(i5).cutoff;
                    int i6 = i5 - 1;
                    if (i6 >= 0) {
                        size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState3, keylineState2.getKeylines().get(i6).mask) - 1;
                    }
                    KeylineState keylineState4 = keylineState3;
                    int i7 = size;
                    KeylineState moveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState4, findFirstNonAnchorKeylineIndex, i7, f9 + f11, (keylineState2.getFirstFocalKeylineIndex() - i4) - 1, (keylineState2.getLastFocalKeylineIndex() - i4) - 1, f8);
                    if (i4 == firstFocalKeylineIndex - 1 && f7 > 0.0f) {
                        moveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(moveKeylineAndCreateKeylineState, f7, f8, true, f6);
                    }
                    arrayList.add(moveKeylineAndCreateKeylineState);
                    i4++;
                    f10 = f11;
                }
            } else {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState2, f9 + keylineState2.getFirstFocalKeyline().cutoff, f8));
                return arrayList;
            }
        } else if (f7 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState2, f7, f8, true, f6));
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        if (keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) < 0.0f || keylineState.getFirstFocalKeyline() != keylineState.getFirstNonAnchorKeyline()) {
            return false;
        }
        return true;
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        if (keylineState.getLastFocalKeyline().locOffset + (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) > ((float) containerHeight) || keylineState.getLastFocalKeyline() != keylineState.getLastNonAnchorKeyline()) {
            return false;
        }
        return true;
    }

    private static KeylineState lerp(List<KeylineState> list, float f4, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f4, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i4, int i5, float f4, int i6, int i7, float f5) {
        boolean z4;
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i5, (KeylineState.Keyline) arrayList.remove(i4));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f5);
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i8);
            float f6 = keyline.maskedItemSize;
            float f7 = f4 + (f6 / 2.0f);
            if (i8 < i6 || i8 > i7) {
                z4 = false;
            } else {
                z4 = true;
            }
            builder.addKeyline(f7, keyline.mask, f6, z4, keyline.isAnchor, keyline.cutoff);
            f4 += keyline.maskedItemSize;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylineStateForPadding(KeylineState keylineState, float f4, float f5, boolean z4, float f6) {
        float f7;
        boolean z5;
        float f8;
        float f9;
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f5);
        float numberOfNonAnchorKeylines = f4 / ((float) keylineState.getNumberOfNonAnchorKeylines());
        if (z4) {
            f7 = f4;
        } else {
            f7 = 0.0f;
        }
        float f10 = f7;
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i4);
            if (keyline.isAnchor) {
                float f11 = keyline.locOffset;
                float f12 = f11;
                builder.addKeyline(f12, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
                float f13 = f6;
            } else {
                if (i4 < keylineState.getFirstFocalKeylineIndex() || i4 > keylineState.getLastFocalKeylineIndex()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                float f14 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f14, keylineState.getItemSize(), f6);
                float f15 = (f14 / 2.0f) + f10;
                float f16 = f15 - keyline.locOffset;
                float f17 = keyline.cutoff;
                if (z4) {
                    f8 = f16;
                } else {
                    f8 = 0.0f;
                }
                if (z4) {
                    f9 = 0.0f;
                } else {
                    f9 = f16;
                }
                builder.addKeyline(f15, childMaskPercentage, f14, z5, false, f17, f8, f9);
                f10 += f14;
            }
        }
        return builder.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f4, float f5) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f4, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), f5);
    }

    /* access modifiers changed from: package-private */
    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    /* access modifiers changed from: package-private */
    public KeylineState getEndState() {
        List<KeylineState> list = this.endStateSteps;
        return list.get(list.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i4, int i5, int i6, boolean z4) {
        int i7;
        int i8;
        int i9;
        float itemSize = this.defaultState.getItemSize();
        HashMap hashMap = new HashMap();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = -1;
            if (i10 >= i4) {
                break;
            }
            if (z4) {
                i9 = (i4 - i10) - 1;
            } else {
                i9 = i10;
            }
            float f4 = ((float) i9) * itemSize;
            if (!z4) {
                i12 = 1;
            }
            if (f4 * ((float) i12) > ((float) i6) - this.endShiftRange || i10 >= i4 - this.endStateSteps.size()) {
                Integer valueOf = Integer.valueOf(i9);
                List<KeylineState> list = this.endStateSteps;
                hashMap.put(valueOf, list.get(MathUtils.clamp(i11, 0, list.size() - 1)));
                i11++;
            }
            i10++;
        }
        int i13 = 0;
        for (int i14 = i4 - 1; i14 >= 0; i14--) {
            if (z4) {
                i7 = (i4 - i14) - 1;
            } else {
                i7 = i14;
            }
            float f5 = ((float) i7) * itemSize;
            if (z4) {
                i8 = -1;
            } else {
                i8 = 1;
            }
            if (f5 * ((float) i8) < ((float) i5) + this.startShiftRange || i14 < this.startStateSteps.size()) {
                Integer valueOf2 = Integer.valueOf(i7);
                List<KeylineState> list2 = this.startStateSteps;
                hashMap.put(valueOf2, list2.get(MathUtils.clamp(i13, 0, list2.size() - 1)));
                i13++;
            }
        }
        return hashMap;
    }

    public KeylineState getShiftedState(float f4, float f5, float f6) {
        return getShiftedState(f4, f5, f6, false);
    }

    /* access modifiers changed from: package-private */
    public KeylineState getStartState() {
        List<KeylineState> list = this.startStateSteps;
        return list.get(list.size() - 1);
    }

    /* access modifiers changed from: package-private */
    public KeylineState getShiftedState(float f4, float f5, float f6, boolean z4) {
        float[] fArr;
        List<KeylineState> list;
        float f7;
        float f8 = this.startShiftRange + f5;
        float f9 = f6 - this.endShiftRange;
        float f10 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f11 = getEndState().getLastFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f10) {
            f8 += f10;
        }
        if (this.endShiftRange == f11) {
            f9 -= f11;
        }
        if (f4 < f8) {
            f7 = AnimationUtils.lerp(1.0f, 0.0f, f5, f8, f4);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else if (f4 <= f9) {
            return this.defaultState;
        } else {
            f7 = AnimationUtils.lerp(0.0f, 1.0f, f9, f6, f4);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        if (z4) {
            return closestStateStepFromInterpolation(list, f7, fArr);
        }
        return lerp(list, f7, fArr);
    }
}
