package y2;

import H1.e;
import R2.k;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class h implements e {

    /* renamed from: a  reason: collision with root package name */
    private final int f22791a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22792b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22793c;

    /* renamed from: d  reason: collision with root package name */
    private final a f22794d;

    public enum a {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT;

        static {
            a[] a5;
            f22811q = X2.b.a(a5);
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22812a;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|(2:29|30)|31|33) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|33) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                y2.h$a[] r0 = y2.h.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                y2.h$a r1 = y2.h.a.ALL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                y2.h$a r1 = y2.h.a.TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                y2.h$a r1 = y2.h.a.TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                y2.h$a r1 = y2.h.a.BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                y2.h$a r1 = y2.h.a.BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                y2.h$a r1 = y2.h.a.TOP     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                y2.h$a r1 = y2.h.a.BOTTOM     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                y2.h$a r1 = y2.h.a.LEFT     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                y2.h$a r1 = y2.h.a.RIGHT     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                y2.h$a r1 = y2.h.a.OTHER_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                y2.h$a r1 = y2.h.a.OTHER_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                y2.h$a r1 = y2.h.a.OTHER_BOTTOM_LEFT     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                y2.h$a r1 = y2.h.a.OTHER_BOTTOM_RIGHT     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                y2.h$a r1 = y2.h.a.DIAGONAL_FROM_TOP_LEFT     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                y2.h$a r1 = y2.h.a.DIAGONAL_FROM_TOP_RIGHT     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                f22812a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: y2.h.b.<clinit>():void");
        }
    }

    public h(int i4, a aVar) {
        m.e(aVar, "cornerType");
        this.f22791a = i4;
        this.f22792b = i4 * 2;
        this.f22794d = aVar;
    }

    private final void b(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22793c;
        int i5 = this.f22792b;
        RectF rectF = new RectF((float) i4, f5 - ((float) i5), (float) (i4 + i5), f5);
        int i6 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        int i7 = this.f22793c;
        canvas.drawRect(new RectF((float) i7, (float) i7, (float) (i7 + this.f22792b), f5 - ((float) this.f22791a)), paint);
        int i8 = this.f22793c;
        canvas.drawRect(new RectF((float) (this.f22791a + i8), (float) i8, f4, f5), paint);
    }

    private final void c(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22792b;
        RectF rectF = new RectF(f4 - ((float) i4), f5 - ((float) i4), f4, f5);
        int i5 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        int i6 = this.f22793c;
        canvas.drawRect(new RectF((float) i6, (float) i6, f4 - ((float) this.f22791a), f5), paint);
        int i7 = this.f22791a;
        canvas.drawRect(new RectF(f4 - ((float) i7), (float) this.f22793c, f4, f5 - ((float) i7)), paint);
    }

    private final void d(Canvas canvas, Paint paint, float f4, float f5) {
        RectF rectF = new RectF((float) this.f22793c, f5 - ((float) this.f22792b), f4, f5);
        int i4 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i4, (float) i4, paint);
        int i5 = this.f22793c;
        canvas.drawRect(new RectF((float) i5, (float) i5, f4, f5 - ((float) this.f22791a)), paint);
    }

    private final void e(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22793c;
        int i5 = this.f22792b;
        RectF rectF = new RectF((float) i4, (float) i4, (float) (i4 + i5), (float) (i4 + i5));
        int i6 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        int i7 = this.f22792b;
        RectF rectF2 = new RectF(f4 - ((float) i7), f5 - ((float) i7), f4, f5);
        int i8 = this.f22791a;
        canvas.drawRoundRect(rectF2, (float) i8, (float) i8, paint);
        int i9 = this.f22793c;
        int i10 = this.f22791a;
        canvas.drawRect(new RectF((float) i9, (float) (i9 + i10), f4 - ((float) i10), f5), paint);
        int i11 = this.f22793c;
        int i12 = this.f22791a;
        canvas.drawRect(new RectF((float) (i11 + i12), (float) i11, f4, f5 - ((float) i12)), paint);
    }

    private final void f(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22792b;
        int i5 = this.f22793c;
        RectF rectF = new RectF(f4 - ((float) i4), (float) i5, f4, (float) (i5 + i4));
        int i6 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        int i7 = this.f22793c;
        int i8 = this.f22792b;
        RectF rectF2 = new RectF((float) i7, f5 - ((float) i8), (float) (i7 + i8), f5);
        int i9 = this.f22791a;
        canvas.drawRoundRect(rectF2, (float) i9, (float) i9, paint);
        int i10 = this.f22793c;
        int i11 = this.f22791a;
        canvas.drawRect(new RectF((float) i10, (float) i10, f4 - ((float) i11), f5 - ((float) i11)), paint);
        int i12 = this.f22793c;
        int i13 = this.f22791a;
        canvas.drawRect(new RectF((float) (i12 + i13), (float) (i12 + i13), f4, f5), paint);
    }

    private final void g(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22793c;
        RectF rectF = new RectF((float) i4, (float) i4, (float) (i4 + this.f22792b), f5);
        int i5 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        int i6 = this.f22793c;
        canvas.drawRect(new RectF((float) (this.f22791a + i6), (float) i6, f4, f5), paint);
    }

    private final void h(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22793c;
        RectF rectF = new RectF((float) i4, (float) i4, f4, (float) (i4 + this.f22792b));
        int i5 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        RectF rectF2 = new RectF(f4 - ((float) this.f22792b), (float) this.f22793c, f4, f5);
        int i6 = this.f22791a;
        canvas.drawRoundRect(rectF2, (float) i6, (float) i6, paint);
        int i7 = this.f22793c;
        int i8 = this.f22791a;
        canvas.drawRect(new RectF((float) i7, (float) (i7 + i8), f4 - ((float) i8), f5), paint);
    }

    private final void i(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22793c;
        RectF rectF = new RectF((float) i4, (float) i4, f4, (float) (i4 + this.f22792b));
        int i5 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        int i6 = this.f22793c;
        RectF rectF2 = new RectF((float) i6, (float) i6, (float) (i6 + this.f22792b), f5);
        int i7 = this.f22791a;
        canvas.drawRoundRect(rectF2, (float) i7, (float) i7, paint);
        int i8 = this.f22793c;
        int i9 = this.f22791a;
        canvas.drawRect(new RectF((float) (i8 + i9), (float) (i8 + i9), f4, f5), paint);
    }

    private final void j(Canvas canvas, Paint paint, float f4, float f5) {
        RectF rectF = new RectF((float) this.f22793c, f5 - ((float) this.f22792b), f4, f5);
        int i4 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i4, (float) i4, paint);
        RectF rectF2 = new RectF(f4 - ((float) this.f22792b), (float) this.f22793c, f4, f5);
        int i5 = this.f22791a;
        canvas.drawRoundRect(rectF2, (float) i5, (float) i5, paint);
        int i6 = this.f22793c;
        int i7 = this.f22791a;
        canvas.drawRect(new RectF((float) i6, (float) i6, f4 - ((float) i7), f5 - ((float) i7)), paint);
    }

    private final void k(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22793c;
        RectF rectF = new RectF((float) i4, (float) i4, (float) (i4 + this.f22792b), f5);
        int i5 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        RectF rectF2 = new RectF((float) this.f22793c, f5 - ((float) this.f22792b), f4, f5);
        int i6 = this.f22791a;
        canvas.drawRoundRect(rectF2, (float) i6, (float) i6, paint);
        int i7 = this.f22793c;
        int i8 = this.f22791a;
        canvas.drawRect(new RectF((float) (i7 + i8), (float) i7, f4, f5 - ((float) i8)), paint);
    }

    private final void l(Canvas canvas, Paint paint, float f4, float f5) {
        RectF rectF = new RectF(f4 - ((float) this.f22792b), (float) this.f22793c, f4, f5);
        int i4 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i4, (float) i4, paint);
        int i5 = this.f22793c;
        canvas.drawRect(new RectF((float) i5, (float) i5, f4 - ((float) this.f22791a), f5), paint);
    }

    private final void m(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22793c;
        float f6 = f4 - ((float) i4);
        float f7 = f5 - ((float) i4);
        switch (b.f22812a[this.f22794d.ordinal()]) {
            case 1:
                int i5 = this.f22793c;
                RectF rectF = new RectF((float) i5, (float) i5, f6, f7);
                int i6 = this.f22791a;
                canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
                return;
            case 2:
                n(canvas, paint, f6, f7);
                return;
            case 3:
                o(canvas, paint, f6, f7);
                return;
            case 4:
                b(canvas, paint, f6, f7);
                return;
            case 5:
                c(canvas, paint, f6, f7);
                return;
            case 6:
                p(canvas, paint, f6, f7);
                return;
            case 7:
                d(canvas, paint, f6, f7);
                return;
            case 8:
                g(canvas, paint, f6, f7);
                return;
            case 9:
                l(canvas, paint, f6, f7);
                return;
            case 10:
                j(canvas, paint, f6, f7);
                return;
            case 11:
                k(canvas, paint, f6, f7);
                return;
            case 12:
                h(canvas, paint, f6, f7);
                return;
            case 13:
                i(canvas, paint, f6, f7);
                return;
            case 14:
                e(canvas, paint, f6, f7);
                return;
            case 15:
                f(canvas, paint, f6, f7);
                return;
            default:
                throw new k();
        }
    }

    private final void n(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22793c;
        int i5 = this.f22792b;
        RectF rectF = new RectF((float) i4, (float) i4, (float) (i4 + i5), (float) (i4 + i5));
        int i6 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        int i7 = this.f22793c;
        int i8 = this.f22791a;
        canvas.drawRect(new RectF((float) i7, (float) (i7 + i8), (float) (i7 + i8), f5), paint);
        int i9 = this.f22793c;
        canvas.drawRect(new RectF((float) (this.f22791a + i9), (float) i9, f4, f5), paint);
    }

    private final void o(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22792b;
        int i5 = this.f22793c;
        RectF rectF = new RectF(f4 - ((float) i4), (float) i5, f4, (float) (i5 + i4));
        int i6 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        int i7 = this.f22793c;
        canvas.drawRect(new RectF((float) i7, (float) i7, f4 - ((float) this.f22791a), f5), paint);
        int i8 = this.f22791a;
        canvas.drawRect(new RectF(f4 - ((float) i8), (float) (this.f22793c + i8), f4, f5), paint);
    }

    private final void p(Canvas canvas, Paint paint, float f4, float f5) {
        int i4 = this.f22793c;
        RectF rectF = new RectF((float) i4, (float) i4, f4, (float) (i4 + this.f22792b));
        int i5 = this.f22791a;
        canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
        int i6 = this.f22793c;
        canvas.drawRect(new RectF((float) i6, (float) (i6 + this.f22791a), f4, f5), paint);
    }

    public Bitmap a(Bitmap bitmap) {
        m.e(bitmap, "source");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        m.d(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        m(canvas, paint, (float) width, (float) height);
        bitmap.recycle();
        return createBitmap;
    }

    public String key() {
        return "RoundedTransformation(radius=" + this.f22791a + ", margin=" + this.f22793c + ", diameter=" + this.f22792b + ", cornerType=" + this.f22794d.name() + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(int i4, a aVar, int i5, C2103g gVar) {
        this(i4, (i5 & 2) != 0 ? a.ALL : aVar);
    }
}
