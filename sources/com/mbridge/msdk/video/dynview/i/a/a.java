package com.mbridge.msdk.video.dynview.i.a;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.p;
import com.mbridge.msdk.video.dynview.c;
import com.mbridge.msdk.video.dynview.g.a;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f16068a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public View f16069b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f16070c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f16071d;

    private a() {
    }

    public final void b() {
        if (this.f16069b != null) {
            this.f16069b = null;
        }
        Bitmap bitmap = this.f16070c;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.f16070c.recycle();
            this.f16070c = null;
        }
        Bitmap bitmap2 = this.f16071d;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f16071d.recycle();
            this.f16071d = null;
        }
    }

    public static a a() {
        a aVar;
        if (f16068a != null) {
            return f16068a;
        }
        synchronized (a.class) {
            try {
                if (f16068a == null) {
                    f16068a = new a();
                }
                aVar = f16068a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public final void a(Map<String, Bitmap> map, c cVar, View view) {
        if (view != null && cVar != null && map != null && map.size() != 0 && map.size() >= 2 && cVar.g() != null && cVar.g().size() >= 2) {
            this.f16069b = view;
            int e5 = cVar.e();
            float d5 = cVar.d();
            float c5 = cVar.c();
            try {
                List<CampaignEx> g4 = cVar.g();
                String str = "";
                String md5 = g4.get(0) != null ? SameMD5.getMD5(g4.get(0).getImageUrl()) : str;
                if (g4.get(1) != null) {
                    str = SameMD5.getMD5(g4.get(1).getImageUrl());
                }
                Bitmap bitmap = null;
                Bitmap bitmap2 = (TextUtils.isEmpty(md5) || !map.containsKey(md5)) ? null : map.get(md5);
                if (!TextUtils.isEmpty(str) && map.containsKey(str)) {
                    bitmap = map.get(str);
                }
                Bitmap bitmap3 = bitmap;
                if (bitmap2 != null && !bitmap2.isRecycled() && bitmap3 != null && !bitmap3.isRecycled()) {
                    a(e5, d5, c5, bitmap2, bitmap3);
                }
            } catch (Exception e6) {
                af.b("ChoiceOneDrawBitBg", e6.getMessage());
            }
        }
    }

    private synchronized void a(int i4, float f4, float f5, Bitmap bitmap, Bitmap bitmap2) {
        try {
            final int i5 = i4;
            final float f6 = f4;
            final float f7 = f5;
            final Bitmap bitmap3 = bitmap;
            try {
                com.mbridge.msdk.foundation.same.f.a.a().execute(new Runnable() {
                    public final void run() {
                        try {
                            Bitmap a5 = p.a(bitmap3, 10);
                            Bitmap a6 = p.a(bitmap3, 10);
                            final a.C0204a a7 = com.mbridge.msdk.video.dynview.g.a.a();
                            a7.a(i5).a(a5).b(a6);
                            if (i5 == 2) {
                                float f4 = f6;
                                float f5 = f7;
                                if (f4 > f5) {
                                    a7.a(f4).b(f7);
                                } else {
                                    a7.a(f5).b(f6);
                                }
                            } else {
                                a7.a(f6).b(f7);
                            }
                            if (a.this.f16069b != null) {
                                a.this.f16069b.post(new Runnable() {
                                    public final void run() {
                                        if (a.this.f16069b != null && a7.a() != null) {
                                            a.this.f16069b.setBackground(a7.a());
                                        }
                                    }
                                });
                            }
                        } catch (Exception e5) {
                            af.b("ChoiceOneDrawBitBg", e5.getMessage());
                        }
                    }
                });
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Exception e6) {
            e = e6;
            try {
                af.a("ChoiceOneDrawBitBg", e.getMessage());
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }
}
