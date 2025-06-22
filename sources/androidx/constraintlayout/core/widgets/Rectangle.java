package androidx.constraintlayout.core.widgets;

public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x  reason: collision with root package name */
    public int f831x;

    /* renamed from: y  reason: collision with root package name */
    public int f832y;

    public boolean contains(int i4, int i5) {
        int i6;
        int i7 = this.f831x;
        if (i4 < i7 || i4 >= i7 + this.width || i5 < (i6 = this.f832y) || i5 >= i6 + this.height) {
            return false;
        }
        return true;
    }

    public int getCenterX() {
        return (this.f831x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f832y + this.height) / 2;
    }

    /* access modifiers changed from: package-private */
    public void grow(int i4, int i5) {
        this.f831x -= i4;
        this.f832y -= i5;
        this.width += i4 * 2;
        this.height += i5 * 2;
    }

    /* access modifiers changed from: package-private */
    public boolean intersects(Rectangle rectangle) {
        int i4;
        int i5;
        int i6 = this.f831x;
        int i7 = rectangle.f831x;
        if (i6 < i7 || i6 >= i7 + rectangle.width || (i4 = this.f832y) < (i5 = rectangle.f832y) || i4 >= i5 + rectangle.height) {
            return false;
        }
        return true;
    }

    public void setBounds(int i4, int i5, int i6, int i7) {
        this.f831x = i4;
        this.f832y = i5;
        this.width = i6;
        this.height = i7;
    }
}
