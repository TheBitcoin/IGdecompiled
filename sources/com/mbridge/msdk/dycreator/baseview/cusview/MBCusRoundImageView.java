package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;

public class MBCusRoundImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f12358a;

    /* renamed from: b  reason: collision with root package name */
    private int f12359b;

    /* renamed from: c  reason: collision with root package name */
    private int f12360c;

    /* renamed from: d  reason: collision with root package name */
    private int f12361d;

    /* renamed from: e  reason: collision with root package name */
    private Xfermode f12362e;

    /* renamed from: f  reason: collision with root package name */
    private int f12363f;

    /* renamed from: g  reason: collision with root package name */
    private int f12364g;

    /* renamed from: h  reason: collision with root package name */
    private int f12365h;

    /* renamed from: i  reason: collision with root package name */
    private int f12366i;

    /* renamed from: j  reason: collision with root package name */
    private int f12367j;

    /* renamed from: k  reason: collision with root package name */
    private int f12368k;

    /* renamed from: l  reason: collision with root package name */
    private int f12369l;

    /* renamed from: m  reason: collision with root package name */
    private int f12370m;

    /* renamed from: n  reason: collision with root package name */
    private int f12371n;

    /* renamed from: o  reason: collision with root package name */
    private float[] f12372o;

    /* renamed from: p  reason: collision with root package name */
    private float[] f12373p;

    /* renamed from: q  reason: collision with root package name */
    private RectF f12374q;

    /* renamed from: r  reason: collision with root package name */
    private RectF f12375r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f12376s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f12377t;

    /* renamed from: u  reason: collision with root package name */
    private Path f12378u;

    /* renamed from: v  reason: collision with root package name */
    private Paint f12379v;

    /* renamed from: com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12380a;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12380a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.id     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.src     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.background     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.contentDescription     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.tag     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.visibility     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.scaleType     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.padding     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingTop     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingBottom     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingLeft     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingRight     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.gravity     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f12380a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_gravity     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public MBCusRoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ViewGroup.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HashMap<String, c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            c cVar = c5.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                int i5 = AnonymousClass1.f12380a[cVar.ordinal()];
                if (i5 == 6) {
                    String attributeValue = attributeSet.getAttributeValue(i4);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                } else if (i5 == 13) {
                    String attributeValue2 = attributeSet.getAttributeValue(i4);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue2);
                    }
                } else if (i5 == 14) {
                    String attributeValue3 = attributeSet.getAttributeValue(i4);
                    if (attributeValue3.startsWith("f") || attributeValue3.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue3.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue3);
                    }
                }
            }
        }
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (canvas != null) {
            try {
                canvas.saveLayer(this.f12374q, (Paint) null, 31);
                int i4 = this.f12363f;
                int i5 = this.f12370m;
                int i6 = this.f12364g;
                canvas.scale((((float) (i4 - (i5 * 2))) * 1.0f) / ((float) i4), (((float) (i6 - (i5 * 2))) * 1.0f) / ((float) i6), ((float) i4) / 2.0f, ((float) i6) / 2.0f);
                super.onDraw(canvas);
                Paint paint = this.f12379v;
                if (paint != null) {
                    paint.reset();
                    this.f12379v.setAntiAlias(true);
                    this.f12379v.setStyle(Paint.Style.FILL);
                    this.f12379v.setXfermode(this.f12362e);
                }
                Path path = this.f12378u;
                if (path != null) {
                    path.reset();
                    this.f12378u.addRoundRect(this.f12374q, this.f12373p, Path.Direction.CCW);
                }
                canvas.drawPath(this.f12378u, this.f12379v);
                Paint paint2 = this.f12379v;
                if (paint2 != null) {
                    paint2.setXfermode((Xfermode) null);
                }
                canvas.restore();
                if (this.f12376s) {
                    int i7 = this.f12370m;
                    int i8 = this.f12371n;
                    RectF rectF = this.f12375r;
                    float[] fArr = this.f12372o;
                    try {
                        Path path2 = this.f12378u;
                        if (path2 != null) {
                            path2.reset();
                        }
                        Paint paint3 = this.f12379v;
                        if (paint3 != null) {
                            paint3.setStrokeWidth((float) i7);
                            this.f12379v.setColor(i8);
                            this.f12379v.setStyle(Paint.Style.STROKE);
                        }
                        Path path3 = this.f12378u;
                        if (path3 != null) {
                            path3.addRoundRect(rectF, fArr, Path.Direction.CCW);
                        }
                        canvas.drawPath(this.f12378u, this.f12379v);
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
        try {
            this.f12363f = i4;
            this.f12364g = i5;
            int i11 = 0;
            if (this.f12377t) {
                try {
                    if (!(this.f12372o == null || this.f12373p == null)) {
                        while (true) {
                            i8 = 2;
                            if (i11 >= 2) {
                                break;
                            }
                            float[] fArr = this.f12372o;
                            int i12 = this.f12366i;
                            fArr[i11] = (float) i12;
                            this.f12373p[i11] = ((float) i12) - (((float) this.f12370m) / 2.0f);
                            i11++;
                        }
                        while (true) {
                            i9 = 4;
                            if (i8 >= 4) {
                                break;
                            }
                            float[] fArr2 = this.f12372o;
                            int i13 = this.f12367j;
                            fArr2[i8] = (float) i13;
                            this.f12373p[i8] = ((float) i13) - (((float) this.f12370m) / 2.0f);
                            i8++;
                        }
                        while (true) {
                            if (i9 >= 6) {
                                break;
                            }
                            float[] fArr3 = this.f12372o;
                            int i14 = this.f12368k;
                            fArr3[i9] = (float) i14;
                            this.f12373p[i9] = ((float) i14) - (((float) this.f12370m) / 2.0f);
                            i9++;
                        }
                        for (i10 = 6; i10 < 8; i10++) {
                            float[] fArr4 = this.f12372o;
                            int i15 = this.f12369l;
                            fArr4[i10] = (float) i15;
                            this.f12373p[i10] = ((float) i15) - (((float) this.f12370m) / 2.0f);
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } else if (this.f12372o != null && this.f12373p != null) {
                while (true) {
                    try {
                        float[] fArr5 = this.f12372o;
                        if (i11 >= fArr5.length) {
                            break;
                        }
                        int i16 = this.f12365h;
                        fArr5[i11] = (float) i16;
                        this.f12373p[i11] = ((float) i16) - (((float) this.f12370m) / 2.0f);
                        i11++;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            RectF rectF = this.f12375r;
            if (rectF != null) {
                int i17 = this.f12370m;
                rectF.set(((float) i17) / 2.0f, ((float) i17) / 2.0f, ((float) this.f12363f) - (((float) i17) / 2.0f), ((float) this.f12364g) - (((float) i17) / 2.0f));
            }
            RectF rectF2 = this.f12374q;
            if (rectF2 != null) {
                rectF2.set(0.0f, 0.0f, (float) this.f12363f, (float) this.f12364g);
            }
        } catch (Exception e7) {
            af.b("MBridgeImageView", e7.getMessage());
        }
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArr;
        HashMap<String, c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i4 = 0; i4 < attributeCount; i4++) {
            c cVar = c5.get(attributeSet.getAttributeName(i4));
            if (cVar != null) {
                switch (AnonymousClass1.f12380a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i4);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            break;
                        }
                    case 2:
                        b.a().a(attributeSet.getAttributeValue(i4), (ImageView) this);
                        break;
                    case 3:
                        String attributeValue2 = attributeSet.getAttributeValue(i4);
                        if (!attributeValue2.startsWith("#")) {
                            if (attributeValue2.startsWith("@drawable/")) {
                                attributeValue2 = attributeValue2.substring(10);
                            }
                            setBackgroundResource(getResources().getIdentifier(attributeValue2, "drawable", getContext().getPackageName()));
                            break;
                        } else {
                            try {
                                strArr = attributeValue2.split("-");
                            } catch (Exception unused) {
                                strArr = null;
                            }
                            if (strArr != null && strArr.length <= 2) {
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i4)));
                                break;
                            } else {
                                if (strArr != null && strArr.length == 3) {
                                    try {
                                        GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
                                        gradientDrawable.setGradientType(0);
                                        setBackground(gradientDrawable);
                                        break;
                                    } catch (Exception unused2) {
                                    }
                                }
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i4)));
                                break;
                            }
                        }
                        break;
                    case 4:
                        String attributeValue3 = attributeSet.getAttributeValue(i4);
                        if (TextUtils.isEmpty(attributeValue3)) {
                            break;
                        } else {
                            String str = com.mbridge.msdk.dycreator.e.b.f12637a.get(attributeValue3.substring(8));
                            if (TextUtils.isEmpty(str)) {
                                break;
                            } else {
                                setContentDescription(str);
                                break;
                            }
                        }
                    case 5:
                        String attributeValue4 = attributeSet.getAttributeValue(i4);
                        if (!TextUtils.isEmpty(attributeValue4)) {
                            String str2 = com.mbridge.msdk.dycreator.e.b.f12637a.get(attributeValue4.substring(8));
                            if (!TextUtils.isEmpty(str2)) {
                                setTag(str2);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case 6:
                        String attributeValue5 = attributeSet.getAttributeValue(i4);
                        if (!TextUtils.isEmpty(attributeValue5)) {
                            if (!attributeValue5.equals("invisible")) {
                                if (!attributeValue5.equalsIgnoreCase("gone")) {
                                    break;
                                } else {
                                    setVisibility(8);
                                    break;
                                }
                            } else {
                                setVisibility(4);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 7:
                        String attributeValue6 = attributeSet.getAttributeValue(i4);
                        if (!TextUtils.isEmpty(attributeValue6)) {
                            if (!attributeValue6.equals("fitXY")) {
                                if (!attributeValue6.equals("centerInside")) {
                                    if (!attributeValue6.equals("centerCrop")) {
                                        break;
                                    } else {
                                        setScaleType(ImageView.ScaleType.CENTER_CROP);
                                        break;
                                    }
                                } else {
                                    setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                    break;
                                }
                            } else {
                                setScaleType(ImageView.ScaleType.FIT_XY);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 8:
                        int b5 = b.a().b(attributeSet.getAttributeValue(i4));
                        this.f12361d = b5;
                        this.f12360c = b5;
                        this.f12359b = b5;
                        this.f12358a = b5;
                        setPadding(b5, b5, b5, b5);
                        break;
                    case 9:
                        int b6 = b.a().b(attributeSet.getAttributeValue(i4));
                        this.f12359b = b6;
                        setPadding(this.f12358a, b6, this.f12360c, this.f12361d);
                        break;
                    case 10:
                        int b7 = b.a().b(attributeSet.getAttributeValue(i4));
                        this.f12361d = b7;
                        setPadding(this.f12358a, this.f12359b, this.f12360c, b7);
                        break;
                    case 11:
                        int b8 = b.a().b(attributeSet.getAttributeValue(i4));
                        this.f12358a = b8;
                        setPadding(b8, this.f12359b, this.f12360c, this.f12361d);
                        break;
                    case 12:
                        int b9 = b.a().b(attributeSet.getAttributeValue(i4));
                        this.f12360c = b9;
                        setPadding(this.f12358a, this.f12359b, b9, this.f12361d);
                        break;
                }
            }
        }
    }

    public void setBorder(int i4, int i5, int i6) {
        this.f12376s = true;
        this.f12370m = i5;
        this.f12371n = i6;
        this.f12365h = i4;
    }

    public void setCornerRadius(int i4) {
        this.f12365h = i4;
    }

    public void setCustomBorder(int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f12376s = true;
        this.f12377t = true;
        this.f12370m = i8;
        this.f12371n = i9;
        this.f12366i = i4;
        this.f12368k = i6;
        this.f12367j = i5;
        this.f12369l = i7;
    }

    public MBCusRoundImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, (AttributeSet) null, 0);
        try {
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(context, attributeSet));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public MBCusRoundImageView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f12378u = new Path();
        this.f12379v = new Paint();
        this.f12372o = new float[8];
        this.f12373p = new float[8];
        this.f12375r = new RectF();
        this.f12374q = new RectF();
        this.f12362e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
}
