package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

class CardViewBaseImpl implements CardViewImpl {
    final RectF mCornerRect = new RectF();

    CardViewBaseImpl() {
    }

    private RoundRectDrawableWithShadow createBackground(Context context, ColorStateList colorStateList, float f4, float f5, float f6) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f4, f5, f6);
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.getCardBackground();
    }

    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getColor();
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getShadowSize();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMaxShadowSize();
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMinHeight();
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMinWidth();
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getCornerRadius();
    }

    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper() {
            public void drawRoundRect(Canvas canvas, RectF rectF, float f4, Paint paint) {
                Canvas canvas2 = canvas;
                RectF rectF2 = rectF;
                float f5 = 2.0f * f4;
                float width = (rectF2.width() - f5) - 1.0f;
                float height = (rectF2.height() - f5) - 1.0f;
                if (f4 >= 1.0f) {
                    float f6 = f4 + 0.5f;
                    float f7 = -f6;
                    CardViewBaseImpl.this.mCornerRect.set(f7, f7, f6, f6);
                    int save = canvas.save();
                    canvas.translate(rectF2.left + f6, rectF2.top + f6);
                    Paint paint2 = paint;
                    canvas2.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint2);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas2.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint2);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas2.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint2);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas2.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint2);
                    canvas.restoreToCount(save);
                    float f8 = rectF2.top;
                    canvas2.drawRect((rectF2.left + f6) - 1.0f, f8, (rectF2.right - f6) + 1.0f, f8 + f6, paint2);
                    float f9 = rectF2.bottom;
                    Canvas canvas3 = canvas;
                    canvas3.drawRect((rectF2.left + f6) - 1.0f, f9 - f6, (rectF2.right - f6) + 1.0f, f9, paint2);
                }
                canvas.drawRect(rectF2.left, rectF2.top + f4, rectF2.right, rectF2.bottom - f4, paint);
            }
        };
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f4, float f5, float f6) {
        RoundRectDrawableWithShadow createBackground = createBackground(context, colorStateList, f4, f5, f6);
        createBackground.setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        cardViewDelegate.setCardBackground(createBackground);
        updatePadding(cardViewDelegate);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        getShadowBackground(cardViewDelegate).setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        getShadowBackground(cardViewDelegate).setColor(colorStateList);
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f4) {
        getShadowBackground(cardViewDelegate).setShadowSize(f4);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f4) {
        getShadowBackground(cardViewDelegate).setMaxShadowSize(f4);
        updatePadding(cardViewDelegate);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f4) {
        getShadowBackground(cardViewDelegate).setCornerRadius(f4);
        updatePadding(cardViewDelegate);
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        getShadowBackground(cardViewDelegate).getMaxShadowAndCornerPadding(rect);
        cardViewDelegate.setMinWidthHeightInternal((int) Math.ceil((double) getMinWidth(cardViewDelegate)), (int) Math.ceil((double) getMinHeight(cardViewDelegate)));
        cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
