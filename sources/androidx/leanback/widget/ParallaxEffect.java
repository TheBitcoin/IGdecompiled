package androidx.leanback.widget;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.ParallaxTarget;
import java.util.ArrayList;
import java.util.List;

public abstract class ParallaxEffect {
    final List<Parallax.PropertyMarkerValue> mMarkerValues = new ArrayList(2);
    final List<ParallaxTarget> mTargets = new ArrayList(4);
    final List<Float> mTotalWeights = new ArrayList(2);
    final List<Float> mWeights = new ArrayList(2);

    static final class FloatEffect extends ParallaxEffect {
        FloatEffect() {
        }

        /* access modifiers changed from: package-private */
        public Number calculateDirectValue(Parallax parallax) {
            if (this.mMarkerValues.size() != 2) {
                throw new RuntimeException("Must use two marker values for direct mapping");
            } else if (this.mMarkerValues.get(0).getProperty() == this.mMarkerValues.get(1).getProperty()) {
                float markerValue = ((Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(0)).getMarkerValue(parallax);
                float markerValue2 = ((Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(1)).getMarkerValue(parallax);
                if (markerValue > markerValue2) {
                    float f4 = markerValue2;
                    markerValue2 = markerValue;
                    markerValue = f4;
                }
                Float f5 = ((Parallax.FloatProperty) this.mMarkerValues.get(0).getProperty()).get(parallax);
                if (f5.floatValue() < markerValue) {
                    return Float.valueOf(markerValue);
                }
                if (f5.floatValue() > markerValue2) {
                    return Float.valueOf(markerValue2);
                }
                return f5;
            } else {
                throw new RuntimeException("Marker value must use same Property for direct mapping");
            }
        }

        /* access modifiers changed from: package-private */
        public float calculateFraction(Parallax parallax) {
            float f4;
            int i4 = 0;
            int i5 = 0;
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (i4 < this.mMarkerValues.size()) {
                Parallax.FloatPropertyMarkerValue floatPropertyMarkerValue = (Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(i4);
                int index = ((Parallax.FloatProperty) floatPropertyMarkerValue.getProperty()).getIndex();
                float markerValue = floatPropertyMarkerValue.getMarkerValue(parallax);
                float floatPropertyValue = parallax.getFloatPropertyValue(index);
                if (i4 == 0) {
                    if (floatPropertyValue >= markerValue) {
                        return 0.0f;
                    }
                } else if (i5 == index && f5 < markerValue) {
                    throw new IllegalStateException("marker value of same variable must be descendant order");
                } else if (floatPropertyValue == Float.MAX_VALUE) {
                    return getFractionWithWeightAdjusted((f5 - f6) / parallax.getMaxValue(), i4);
                } else {
                    if (floatPropertyValue >= markerValue) {
                        if (i5 != index) {
                            if (f6 != -3.4028235E38f) {
                                f5 += floatPropertyValue - f6;
                            } else {
                                f4 = 1.0f - ((floatPropertyValue - markerValue) / parallax.getMaxValue());
                                return getFractionWithWeightAdjusted(f4, i4);
                            }
                        }
                        f4 = (f5 - floatPropertyValue) / (f5 - markerValue);
                        return getFractionWithWeightAdjusted(f4, i4);
                    }
                }
                i4++;
                f5 = markerValue;
                i5 = index;
                f6 = floatPropertyValue;
            }
            return 1.0f;
        }
    }

    static final class IntEffect extends ParallaxEffect {
        IntEffect() {
        }

        /* access modifiers changed from: package-private */
        public Number calculateDirectValue(Parallax parallax) {
            if (this.mMarkerValues.size() != 2) {
                throw new RuntimeException("Must use two marker values for direct mapping");
            } else if (this.mMarkerValues.get(0).getProperty() == this.mMarkerValues.get(1).getProperty()) {
                int markerValue = ((Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(0)).getMarkerValue(parallax);
                int markerValue2 = ((Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(1)).getMarkerValue(parallax);
                if (markerValue > markerValue2) {
                    int i4 = markerValue2;
                    markerValue2 = markerValue;
                    markerValue = i4;
                }
                Integer num = ((Parallax.IntProperty) this.mMarkerValues.get(0).getProperty()).get(parallax);
                if (num.intValue() < markerValue) {
                    return Integer.valueOf(markerValue);
                }
                if (num.intValue() > markerValue2) {
                    return Integer.valueOf(markerValue2);
                }
                return num;
            } else {
                throw new RuntimeException("Marker value must use same Property for direct mapping");
            }
        }

        /* access modifiers changed from: package-private */
        public float calculateFraction(Parallax parallax) {
            float f4;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i4 < this.mMarkerValues.size()) {
                Parallax.IntPropertyMarkerValue intPropertyMarkerValue = (Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(i4);
                int index = ((Parallax.IntProperty) intPropertyMarkerValue.getProperty()).getIndex();
                int markerValue = intPropertyMarkerValue.getMarkerValue(parallax);
                int intPropertyValue = parallax.getIntPropertyValue(index);
                if (i4 == 0) {
                    if (intPropertyValue >= markerValue) {
                        return 0.0f;
                    }
                } else if (i5 == index && i6 < markerValue) {
                    throw new IllegalStateException("marker value of same variable must be descendant order");
                } else if (intPropertyValue == Integer.MAX_VALUE) {
                    return getFractionWithWeightAdjusted(((float) (i6 - i7)) / parallax.getMaxValue(), i4);
                } else {
                    if (intPropertyValue >= markerValue) {
                        if (i5 != index) {
                            if (i7 != Integer.MIN_VALUE) {
                                i6 += intPropertyValue - i7;
                            } else {
                                f4 = 1.0f - (((float) (intPropertyValue - markerValue)) / parallax.getMaxValue());
                                return getFractionWithWeightAdjusted(f4, i4);
                            }
                        }
                        f4 = ((float) (i6 - intPropertyValue)) / ((float) (i6 - markerValue));
                        return getFractionWithWeightAdjusted(f4, i4);
                    }
                }
                i4++;
                i6 = markerValue;
                i5 = index;
                i7 = intPropertyValue;
            }
            return 1.0f;
        }
    }

    ParallaxEffect() {
    }

    public final void addTarget(ParallaxTarget parallaxTarget) {
        this.mTargets.add(parallaxTarget);
    }

    /* access modifiers changed from: package-private */
    public abstract Number calculateDirectValue(Parallax parallax);

    /* access modifiers changed from: package-private */
    public abstract float calculateFraction(Parallax parallax);

    /* access modifiers changed from: package-private */
    public final float getFractionWithWeightAdjusted(float f4, int i4) {
        float size;
        float f5;
        if (this.mMarkerValues.size() >= 3) {
            if (this.mWeights.size() == this.mMarkerValues.size() - 1) {
                List<Float> list = this.mTotalWeights;
                size = list.get(list.size() - 1).floatValue();
                f4 = (f4 * this.mWeights.get(i4 - 1).floatValue()) / size;
                if (i4 < 2) {
                    return f4;
                }
                f5 = this.mTotalWeights.get(i4 - 2).floatValue();
            } else {
                size = (float) (this.mMarkerValues.size() - 1);
                f4 /= size;
                if (i4 >= 2) {
                    f5 = (float) (i4 - 1);
                }
            }
            return f4 + (f5 / size);
        }
        return f4;
    }

    public final List<Parallax.PropertyMarkerValue> getPropertyRanges() {
        return this.mMarkerValues;
    }

    public final List<ParallaxTarget> getTargets() {
        return this.mTargets;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final List<Float> getWeights() {
        return this.mWeights;
    }

    public final void performMapping(Parallax parallax) {
        if (this.mMarkerValues.size() >= 2) {
            if (this instanceof IntEffect) {
                parallax.verifyIntProperties();
            } else {
                parallax.verifyFloatProperties();
            }
            Number number = null;
            boolean z4 = false;
            float f4 = 0.0f;
            for (int i4 = 0; i4 < this.mTargets.size(); i4++) {
                ParallaxTarget parallaxTarget = this.mTargets.get(i4);
                if (parallaxTarget.isDirectMapping()) {
                    if (number == null) {
                        number = calculateDirectValue(parallax);
                    }
                    parallaxTarget.directUpdate(number);
                } else {
                    if (!z4) {
                        f4 = calculateFraction(parallax);
                        z4 = true;
                    }
                    parallaxTarget.update(f4);
                }
            }
        }
    }

    public final void removeTarget(ParallaxTarget parallaxTarget) {
        this.mTargets.remove(parallaxTarget);
    }

    public final void setPropertyRanges(Parallax.PropertyMarkerValue... propertyMarkerValueArr) {
        this.mMarkerValues.clear();
        for (Parallax.PropertyMarkerValue add : propertyMarkerValueArr) {
            this.mMarkerValues.add(add);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setWeights(float... fArr) {
        int length = fArr.length;
        int i4 = 0;
        while (true) {
            float f4 = 0.0f;
            if (i4 >= length) {
                this.mWeights.clear();
                this.mTotalWeights.clear();
                for (float f5 : fArr) {
                    this.mWeights.add(Float.valueOf(f5));
                    f4 += f5;
                    this.mTotalWeights.add(Float.valueOf(f4));
                }
                return;
            } else if (fArr[i4] > 0.0f) {
                i4++;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    public final ParallaxEffect target(ParallaxTarget parallaxTarget) {
        this.mTargets.add(parallaxTarget);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final ParallaxEffect weights(float... fArr) {
        setWeights(fArr);
        return this;
    }

    public final ParallaxEffect target(Object obj, PropertyValuesHolder propertyValuesHolder) {
        this.mTargets.add(new ParallaxTarget.PropertyValuesHolderTarget(obj, propertyValuesHolder));
        return this;
    }

    public final <T, V extends Number> ParallaxEffect target(T t4, Property<T, V> property) {
        this.mTargets.add(new ParallaxTarget.DirectPropertyTarget(t4, property));
        return this;
    }
}
