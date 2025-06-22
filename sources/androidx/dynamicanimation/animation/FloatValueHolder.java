package androidx.dynamicanimation.animation;

public final class FloatValueHolder {
    private float mValue = 0.0f;

    public FloatValueHolder() {
    }

    public float getValue() {
        return this.mValue;
    }

    public void setValue(float f4) {
        this.mValue = f4;
    }

    public FloatValueHolder(float f4) {
        setValue(f4);
    }
}
