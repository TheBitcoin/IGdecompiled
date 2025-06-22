package androidx.core.graphics;

import android.graphics.Picture;
import d3.l;

public final class PictureKt {
    public static final Picture record(Picture picture, int i4, int i5, l lVar) {
        try {
            lVar.invoke(picture.beginRecording(i4, i5));
            return picture;
        } finally {
            kotlin.jvm.internal.l.b(1);
            picture.endRecording();
            kotlin.jvm.internal.l.a(1);
        }
    }
}
