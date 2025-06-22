package com.uptodown.util.views;

import I1.a;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import w2.e;

public final class CropImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private e f19431a;

    /* renamed from: b  reason: collision with root package name */
    private int f19432b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (C2103g) null);
        m.e(context, "context");
    }

    private final void a() {
        setScaleType(ImageView.ScaleType.MATRIX);
        if (getDrawable() != null) {
            this.f19431a = new e(this);
        }
    }

    private final void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.f6688a);
        m.d(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.f19432b = obtainStyledAttributes.getInt(0, -1);
        obtainStyledAttributes.recycle();
    }

    public final int getCropType() {
        return this.f19432b;
    }

    public final void setCropType(int i4) {
        this.f19432b = i4;
    }

    /* access modifiers changed from: protected */
    public boolean setFrame(int i4, int i5, int i6, int i7) {
        boolean frame = super.setFrame(i4, i5, i6, i7);
        if (!(isInEditMode() || this.f19431a == null || getDrawable() == null)) {
            e eVar = this.f19431a;
            m.b(eVar);
            eVar.a();
        }
        return frame;
    }

    public void setImageBitmap(Bitmap bitmap) {
        m.e(bitmap, "bm");
        super.setImageBitmap(bitmap);
        a();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a();
    }

    public void setImageResource(int i4) {
        super.setImageResource(i4);
        a();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CropImageView(Context context, AttributeSet attributeSet, int i4, int i5, C2103g gVar) {
        this(context, attributeSet, (i5 & 4) != 0 ? 0 : i4);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CropImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        m.e(context, "context");
        this.f19432b = -1;
        b(attributeSet);
        a();
    }
}
