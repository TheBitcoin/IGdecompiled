package com.mbridge.msdk.video.module.a.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ae;

public final class j extends e {

    /* renamed from: a  reason: collision with root package name */
    private int f16525a;

    public j(ImageView imageView, int i4) {
        super(imageView);
        this.f16525a = i4;
    }

    public final void onSuccessLoad(Bitmap bitmap, String str) {
        Bitmap a5;
        if (bitmap != null) {
            try {
                if (this.f16519b != null && !bitmap.isRecycled() && (a5 = ae.a(bitmap, 1, this.f16525a)) != null) {
                    this.f16519b.setImageBitmap(a5);
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }
}
