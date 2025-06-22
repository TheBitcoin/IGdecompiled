package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import d3.l;

public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, l lVar) {
        int save = canvas.save();
        canvas.clipRect(rect);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, l lVar) {
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            matrix = new Matrix();
        }
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static final void withRotation(Canvas canvas, float f4, float f5, float f6, l lVar) {
        int save = canvas.save();
        canvas.rotate(f4, f5, f6);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f4, float f5, float f6, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 0.0f;
        }
        if ((i4 & 4) != 0) {
            f6 = 0.0f;
        }
        int save = canvas.save();
        canvas.rotate(f4, f5, f6);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static final void withSave(Canvas canvas, l lVar) {
        int save = canvas.save();
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static final void withScale(Canvas canvas, float f4, float f5, float f6, float f7, l lVar) {
        int save = canvas.save();
        canvas.scale(f4, f5, f6, f7);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f4, float f5, float f6, float f7, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 1.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 1.0f;
        }
        if ((i4 & 4) != 0) {
            f6 = 0.0f;
        }
        if ((i4 & 8) != 0) {
            f7 = 0.0f;
        }
        int save = canvas.save();
        canvas.scale(f4, f5, f6, f7);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static final void withSkew(Canvas canvas, float f4, float f5, l lVar) {
        int save = canvas.save();
        canvas.skew(f4, f5);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f4, float f5, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 0.0f;
        }
        int save = canvas.save();
        canvas.skew(f4, f5);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static final void withTranslation(Canvas canvas, float f4, float f5, l lVar) {
        int save = canvas.save();
        canvas.translate(f4, f5);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f4, float f5, l lVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f4 = 0.0f;
        }
        if ((i4 & 2) != 0) {
            f5 = 0.0f;
        }
        int save = canvas.save();
        canvas.translate(f4, f5);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, l lVar) {
        int save = canvas.save();
        canvas.clipRect(rectF);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static final void withClip(Canvas canvas, int i4, int i5, int i6, int i7, l lVar) {
        int save = canvas.save();
        canvas.clipRect(i4, i5, i6, i7);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static final void withClip(Canvas canvas, float f4, float f5, float f6, float f7, l lVar) {
        int save = canvas.save();
        canvas.clipRect(f4, f5, f6, f7);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }

    public static final void withClip(Canvas canvas, Path path, l lVar) {
        int save = canvas.save();
        canvas.clipPath(path);
        try {
            lVar.invoke(canvas);
        } finally {
            kotlin.jvm.internal.l.b(1);
            canvas.restoreToCount(save);
            kotlin.jvm.internal.l.a(1);
        }
    }
}
