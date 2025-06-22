package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.af;

public class MBridgeImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Xfermode f12422a;

    /* renamed from: b  reason: collision with root package name */
    private int f12423b;

    /* renamed from: c  reason: collision with root package name */
    private int f12424c;

    /* renamed from: d  reason: collision with root package name */
    private int f12425d;

    /* renamed from: e  reason: collision with root package name */
    private int f12426e;

    /* renamed from: f  reason: collision with root package name */
    private int f12427f;

    /* renamed from: g  reason: collision with root package name */
    private int f12428g;

    /* renamed from: h  reason: collision with root package name */
    private int f12429h;

    /* renamed from: i  reason: collision with root package name */
    private int f12430i;

    /* renamed from: j  reason: collision with root package name */
    private int f12431j;

    /* renamed from: k  reason: collision with root package name */
    private float[] f12432k;

    /* renamed from: l  reason: collision with root package name */
    private float[] f12433l;

    /* renamed from: m  reason: collision with root package name */
    private RectF f12434m;

    /* renamed from: n  reason: collision with root package name */
    private RectF f12435n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f12436o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f12437p;

    /* renamed from: q  reason: collision with root package name */
    private Path f12438q;

    /* renamed from: r  reason: collision with root package name */
    private Paint f12439r;

    public MBridgeImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (canvas != null) {
            try {
                canvas.saveLayer(this.f12434m, (Paint) null, 31);
                int i4 = this.f12423b;
                int i5 = this.f12430i;
                int i6 = this.f12424c;
                canvas.scale((((float) (i4 - (i5 * 2))) * 1.0f) / ((float) i4), (((float) (i6 - (i5 * 2))) * 1.0f) / ((float) i6), ((float) i4) / 2.0f, ((float) i6) / 2.0f);
                super.onDraw(canvas);
                Paint paint = this.f12439r;
                if (paint != null) {
                    paint.reset();
                    this.f12439r.setAntiAlias(true);
                    this.f12439r.setStyle(Paint.Style.FILL);
                    this.f12439r.setXfermode(this.f12422a);
                }
                Path path = this.f12438q;
                if (path != null) {
                    path.reset();
                    this.f12438q.addRoundRect(this.f12434m, this.f12433l, Path.Direction.CCW);
                }
                canvas.drawPath(this.f12438q, this.f12439r);
                Paint paint2 = this.f12439r;
                if (paint2 != null) {
                    paint2.setXfermode((Xfermode) null);
                }
                canvas.restore();
                if (this.f12436o) {
                    int i7 = this.f12430i;
                    int i8 = this.f12431j;
                    RectF rectF = this.f12435n;
                    float[] fArr = this.f12432k;
                    try {
                        Path path2 = this.f12438q;
                        if (path2 != null) {
                            path2.reset();
                        }
                        Paint paint3 = this.f12439r;
                        if (paint3 != null) {
                            paint3.setStrokeWidth((float) i7);
                            this.f12439r.setColor(i8);
                            this.f12439r.setStyle(Paint.Style.STROKE);
                        }
                        Path path3 = this.f12438q;
                        if (path3 != null) {
                            path3.addRoundRect(rectF, fArr, Path.Direction.CCW);
                        }
                        canvas.drawPath(this.f12438q, this.f12439r);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            } catch (Exception e6) {
                af.a("MBridgeImageView", e6.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        int i8;
        int i9;
        int i10;
        super.onSizeChanged(i4, i5, i6, i7);
        this.f12423b = i4;
        this.f12424c = i5;
        int i11 = 0;
        if (this.f12437p) {
            try {
                if (!(this.f12432k == null || this.f12433l == null)) {
                    while (true) {
                        i8 = 2;
                        if (i11 >= 2) {
                            break;
                        }
                        float[] fArr = this.f12432k;
                        int i12 = this.f12426e;
                        fArr[i11] = (float) i12;
                        this.f12433l[i11] = ((float) i12) - (((float) this.f12430i) / 2.0f);
                        i11++;
                    }
                    while (true) {
                        i9 = 4;
                        if (i8 >= 4) {
                            break;
                        }
                        float[] fArr2 = this.f12432k;
                        int i13 = this.f12427f;
                        fArr2[i8] = (float) i13;
                        this.f12433l[i8] = ((float) i13) - (((float) this.f12430i) / 2.0f);
                        i8++;
                    }
                    while (true) {
                        if (i9 >= 6) {
                            break;
                        }
                        float[] fArr3 = this.f12432k;
                        int i14 = this.f12428g;
                        fArr3[i9] = (float) i14;
                        this.f12433l[i9] = ((float) i14) - (((float) this.f12430i) / 2.0f);
                        i9++;
                    }
                    for (i10 = 6; i10 < 8; i10++) {
                        float[] fArr4 = this.f12432k;
                        int i15 = this.f12429h;
                        fArr4[i10] = (float) i15;
                        this.f12433l[i10] = ((float) i15) - (((float) this.f12430i) / 2.0f);
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } else if (this.f12432k != null && this.f12433l != null) {
            while (true) {
                try {
                    float[] fArr5 = this.f12432k;
                    if (i11 >= fArr5.length) {
                        break;
                    }
                    int i16 = this.f12425d;
                    fArr5[i11] = (float) i16;
                    this.f12433l[i11] = ((float) i16) - (((float) this.f12430i) / 2.0f);
                    i11++;
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
        RectF rectF = this.f12435n;
        if (rectF != null) {
            int i17 = this.f12430i;
            rectF.set(((float) i17) / 2.0f, ((float) i17) / 2.0f, ((float) this.f12423b) - (((float) i17) / 2.0f), ((float) this.f12424c) - (((float) i17) / 2.0f));
        }
        RectF rectF2 = this.f12434m;
        if (rectF2 != null) {
            rectF2.set(0.0f, 0.0f, (float) this.f12423b, (float) this.f12424c);
        }
    }

    public void setBorder(int i4, int i5, int i6) {
        this.f12436o = true;
        this.f12430i = i5;
        this.f12431j = i6;
        this.f12425d = i4;
    }

    public void setCornerRadius(int i4) {
        this.f12425d = i4;
    }

    public void setCustomBorder(int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f12436o = true;
        this.f12437p = true;
        this.f12430i = i8;
        this.f12431j = i9;
        this.f12426e = i4;
        this.f12428g = i6;
        this.f12427f = i5;
        this.f12429h = i7;
    }

    public MBridgeImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBridgeImageView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f12438q = new Path();
        this.f12439r = new Paint();
        this.f12432k = new float[8];
        this.f12433l = new float[8];
        this.f12435n = new RectF();
        this.f12434m = new RectF();
        this.f12422a = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
}
