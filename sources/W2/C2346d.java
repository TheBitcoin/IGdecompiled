package w2;

import H1.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import kotlin.jvm.internal.m;

/* renamed from: w2.d  reason: case insensitive filesystem */
public final class C2346d implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22023a;

    public C2346d(Context context) {
        m.e(context, "context");
        this.f22023a = context;
    }

    public Bitmap a(Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        m.e(bitmap2, "source");
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, bitmap2.getConfig());
        m.d(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        float f4 = (float) (height - (height / 3));
        float f5 = (float) height;
        LinearGradient linearGradient = new LinearGradient(0.0f, f4, 0.0f, f5, 0, ContextCompat.getColor(this.f22023a, R.color.background_color), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        canvas.drawRect(0.0f, f4, (float) width, f5, paint);
        bitmap2.recycle();
        return createBitmap;
    }

    public String key() {
        return "bottomGradient";
    }
}
