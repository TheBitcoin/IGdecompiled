package androidx.leanback.widget;

import android.util.Property;
import androidx.annotation.CallSuper;
import androidx.leanback.widget.ParallaxEffect;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

public abstract class Parallax<PropertyT extends Property> {
    private final List<ParallaxEffect> mEffects = new ArrayList(4);
    private float[] mFloatValues = new float[4];
    final List<PropertyT> mProperties;
    final List<PropertyT> mPropertiesReadOnly;
    private int[] mValues = new int[4];

    public static class FloatProperty extends Property<Parallax, Float> {
        public static final float UNKNOWN_AFTER = Float.MAX_VALUE;
        public static final float UNKNOWN_BEFORE = -3.4028235E38f;
        private final int mIndex;

        public FloatProperty(String str, int i4) {
            super(Float.class, str);
            this.mIndex = i4;
        }

        public final PropertyMarkerValue at(float f4, float f5) {
            return new FloatPropertyMarkerValue(this, f4, f5);
        }

        public final PropertyMarkerValue atAbsolute(float f4) {
            return new FloatPropertyMarkerValue(this, f4, 0.0f);
        }

        public final PropertyMarkerValue atFraction(float f4) {
            return new FloatPropertyMarkerValue(this, 0.0f, f4);
        }

        public final PropertyMarkerValue atMax() {
            return new FloatPropertyMarkerValue(this, 0.0f, 1.0f);
        }

        public final PropertyMarkerValue atMin() {
            return new FloatPropertyMarkerValue(this, 0.0f);
        }

        public final int getIndex() {
            return this.mIndex;
        }

        public final float getValue(Parallax parallax) {
            return parallax.getFloatPropertyValue(this.mIndex);
        }

        public final void setValue(Parallax parallax, float f4) {
            parallax.setFloatPropertyValue(this.mIndex, f4);
        }

        public final Float get(Parallax parallax) {
            return Float.valueOf(parallax.getFloatPropertyValue(this.mIndex));
        }

        public final void set(Parallax parallax, Float f4) {
            parallax.setFloatPropertyValue(this.mIndex, f4.floatValue());
        }
    }

    static class FloatPropertyMarkerValue extends PropertyMarkerValue<FloatProperty> {
        private final float mFactionOfMax;
        private final float mValue;

        FloatPropertyMarkerValue(FloatProperty floatProperty, float f4) {
            this(floatProperty, f4, 0.0f);
        }

        /* access modifiers changed from: package-private */
        public final float getMarkerValue(Parallax parallax) {
            if (this.mFactionOfMax == 0.0f) {
                return this.mValue;
            }
            return this.mValue + (parallax.getMaxValue() * this.mFactionOfMax);
        }

        FloatPropertyMarkerValue(FloatProperty floatProperty, float f4, float f5) {
            super(floatProperty);
            this.mValue = f4;
            this.mFactionOfMax = f5;
        }
    }

    public static class IntProperty extends Property<Parallax, Integer> {
        public static final int UNKNOWN_AFTER = Integer.MAX_VALUE;
        public static final int UNKNOWN_BEFORE = Integer.MIN_VALUE;
        private final int mIndex;

        public IntProperty(String str, int i4) {
            super(Integer.class, str);
            this.mIndex = i4;
        }

        public final PropertyMarkerValue at(int i4, float f4) {
            return new IntPropertyMarkerValue(this, i4, f4);
        }

        public final PropertyMarkerValue atAbsolute(int i4) {
            return new IntPropertyMarkerValue(this, i4, 0.0f);
        }

        public final PropertyMarkerValue atFraction(float f4) {
            return new IntPropertyMarkerValue(this, 0, f4);
        }

        public final PropertyMarkerValue atMax() {
            return new IntPropertyMarkerValue(this, 0, 1.0f);
        }

        public final PropertyMarkerValue atMin() {
            return new IntPropertyMarkerValue(this, 0);
        }

        public final int getIndex() {
            return this.mIndex;
        }

        public final int getValue(Parallax parallax) {
            return parallax.getIntPropertyValue(this.mIndex);
        }

        public final void setValue(Parallax parallax, int i4) {
            parallax.setIntPropertyValue(this.mIndex, i4);
        }

        public final Integer get(Parallax parallax) {
            return Integer.valueOf(parallax.getIntPropertyValue(this.mIndex));
        }

        public final void set(Parallax parallax, Integer num) {
            parallax.setIntPropertyValue(this.mIndex, num.intValue());
        }
    }

    static class IntPropertyMarkerValue extends PropertyMarkerValue<IntProperty> {
        private final float mFactionOfMax;
        private final int mValue;

        IntPropertyMarkerValue(IntProperty intProperty, int i4) {
            this(intProperty, i4, 0.0f);
        }

        /* access modifiers changed from: package-private */
        public final int getMarkerValue(Parallax parallax) {
            if (this.mFactionOfMax == 0.0f) {
                return this.mValue;
            }
            return this.mValue + Math.round(parallax.getMaxValue() * this.mFactionOfMax);
        }

        IntPropertyMarkerValue(IntProperty intProperty, int i4, float f4) {
            super(intProperty);
            this.mValue = i4;
            this.mFactionOfMax = f4;
        }
    }

    public static class PropertyMarkerValue<PropertyT> {
        private final PropertyT mProperty;

        public PropertyMarkerValue(PropertyT propertyt) {
            this.mProperty = propertyt;
        }

        public PropertyT getProperty() {
            return this.mProperty;
        }
    }

    public Parallax() {
        ArrayList arrayList = new ArrayList();
        this.mProperties = arrayList;
        this.mPropertiesReadOnly = DesugarCollections.unmodifiableList(arrayList);
    }

    public ParallaxEffect addEffect(PropertyMarkerValue... propertyMarkerValueArr) {
        ParallaxEffect parallaxEffect;
        if (propertyMarkerValueArr[0].getProperty() instanceof IntProperty) {
            parallaxEffect = new ParallaxEffect.IntEffect();
        } else {
            parallaxEffect = new ParallaxEffect.FloatEffect();
        }
        parallaxEffect.setPropertyRanges(propertyMarkerValueArr);
        this.mEffects.add(parallaxEffect);
        return parallaxEffect;
    }

    public final PropertyT addProperty(String str) {
        int size = this.mProperties.size();
        PropertyT createProperty = createProperty(str, size);
        int i4 = 0;
        if (createProperty instanceof IntProperty) {
            int length = this.mValues.length;
            if (length == size) {
                int[] iArr = new int[(length * 2)];
                while (i4 < length) {
                    iArr[i4] = this.mValues[i4];
                    i4++;
                }
                this.mValues = iArr;
            }
            this.mValues[size] = Integer.MAX_VALUE;
        } else if (createProperty instanceof FloatProperty) {
            int length2 = this.mFloatValues.length;
            if (length2 == size) {
                float[] fArr = new float[(length2 * 2)];
                while (i4 < length2) {
                    fArr[i4] = this.mFloatValues[i4];
                    i4++;
                }
                this.mFloatValues = fArr;
            }
            this.mFloatValues[size] = Float.MAX_VALUE;
        } else {
            throw new IllegalArgumentException("Invalid Property type");
        }
        this.mProperties.add(createProperty);
        return createProperty;
    }

    public abstract PropertyT createProperty(String str, int i4);

    public List<ParallaxEffect> getEffects() {
        return this.mEffects;
    }

    /* access modifiers changed from: package-private */
    public final float getFloatPropertyValue(int i4) {
        return this.mFloatValues[i4];
    }

    /* access modifiers changed from: package-private */
    public final int getIntPropertyValue(int i4) {
        return this.mValues[i4];
    }

    public abstract float getMaxValue();

    public final List<PropertyT> getProperties() {
        return this.mPropertiesReadOnly;
    }

    public void removeAllEffects() {
        this.mEffects.clear();
    }

    public void removeEffect(ParallaxEffect parallaxEffect) {
        this.mEffects.remove(parallaxEffect);
    }

    /* access modifiers changed from: package-private */
    public final void setFloatPropertyValue(int i4, float f4) {
        if (i4 < this.mProperties.size()) {
            this.mFloatValues[i4] = f4;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /* access modifiers changed from: package-private */
    public final void setIntPropertyValue(int i4, int i5) {
        if (i4 < this.mProperties.size()) {
            this.mValues[i4] = i5;
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    @CallSuper
    public void updateValues() {
        for (int i4 = 0; i4 < this.mEffects.size(); i4++) {
            this.mEffects.get(i4).performMapping(this);
        }
    }

    /* access modifiers changed from: package-private */
    public final void verifyFloatProperties() throws IllegalStateException {
        if (this.mProperties.size() >= 2) {
            float floatPropertyValue = getFloatPropertyValue(0);
            int i4 = 1;
            while (i4 < this.mProperties.size()) {
                float floatPropertyValue2 = getFloatPropertyValue(i4);
                if (floatPropertyValue2 < floatPropertyValue) {
                    Integer valueOf = Integer.valueOf(i4);
                    String name = ((Property) this.mProperties.get(i4)).getName();
                    int i5 = i4 - 1;
                    throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is smaller than Property[%d]\"%s\"", new Object[]{valueOf, name, Integer.valueOf(i5), ((Property) this.mProperties.get(i5)).getName()}));
                } else if (floatPropertyValue == -3.4028235E38f && floatPropertyValue2 == Float.MAX_VALUE) {
                    int i6 = i4 - 1;
                    throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is UNKNOWN_BEFORE and Property[%d]\"%s\" is UNKNOWN_AFTER", new Object[]{Integer.valueOf(i6), ((Property) this.mProperties.get(i6)).getName(), Integer.valueOf(i4), ((Property) this.mProperties.get(i4)).getName()}));
                } else {
                    i4++;
                    floatPropertyValue = floatPropertyValue2;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void verifyIntProperties() throws IllegalStateException {
        if (this.mProperties.size() >= 2) {
            int intPropertyValue = getIntPropertyValue(0);
            int i4 = 1;
            while (i4 < this.mProperties.size()) {
                int intPropertyValue2 = getIntPropertyValue(i4);
                if (intPropertyValue2 < intPropertyValue) {
                    Integer valueOf = Integer.valueOf(i4);
                    String name = ((Property) this.mProperties.get(i4)).getName();
                    int i5 = i4 - 1;
                    throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is smaller than Property[%d]\"%s\"", new Object[]{valueOf, name, Integer.valueOf(i5), ((Property) this.mProperties.get(i5)).getName()}));
                } else if (intPropertyValue == Integer.MIN_VALUE && intPropertyValue2 == Integer.MAX_VALUE) {
                    int i6 = i4 - 1;
                    throw new IllegalStateException(String.format("Parallax Property[%d]\"%s\" is UNKNOWN_BEFORE and Property[%d]\"%s\" is UNKNOWN_AFTER", new Object[]{Integer.valueOf(i6), ((Property) this.mProperties.get(i6)).getName(), Integer.valueOf(i4), ((Property) this.mProperties.get(i4)).getName()}));
                } else {
                    i4++;
                    intPropertyValue = intPropertyValue2;
                }
            }
        }
    }
}
