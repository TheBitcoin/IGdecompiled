package com.mbridge.msdk.foundation.same.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import java.util.concurrent.ThreadPoolExecutor;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f13197a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Handler f13198b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13199c;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final d f13205a = new d();
    }

    /* access modifiers changed from: private */
    public static Bitmap d(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inDither = true;
        return BitmapFactory.decodeFile(str, options);
    }

    public final boolean b(String str) {
        File file;
        if (MBridgeConstans.DEBUG) {
            af.a("CommonImageLoaderRefactor", "isImageFileExists imageUrl = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String c5 = ad.c(str);
            try {
                file = new File(this.f13199c + c5);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonImageLoaderRefactor", "isImageFileExists error", e5);
                }
                file = null;
            }
            if (file == null || !file.isFile() || !file.exists()) {
                return false;
            }
            return true;
        } catch (Exception e6) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonImageLoaderRefactor", "isImageFileExists error", e6);
            }
            return false;
        }
    }

    private d() {
        this.f13198b = new Handler(Looper.getMainLooper());
        this.f13199c = e.a(c.MBRIDGE_700_IMG) + File.separator;
        this.f13197a = f.a();
    }

    private static final class b implements OnDownloadStateListener<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadPoolExecutor f13206a;

        /* renamed from: b  reason: collision with root package name */
        private final Handler f13207b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13208c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13209d;

        /* renamed from: e  reason: collision with root package name */
        private final g f13210e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final String f13211f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final c f13212g;

        public b(Handler handler, ThreadPoolExecutor threadPoolExecutor, String str, String str2, String str3, g gVar, c cVar) {
            this.f13207b = handler;
            this.f13206a = threadPoolExecutor;
            this.f13211f = str;
            this.f13208c = str2;
            this.f13209d = str3;
            this.f13210e = gVar;
            this.f13212g = cVar;
        }

        private void a(final String str) {
            if (this.f13212g != null) {
                this.f13207b.post(new Runnable() {
                    public final void run() {
                        try {
                            b.this.f13212g.onFailedLoad(b.this.f13211f, str);
                        } catch (Exception e5) {
                            if (MBridgeConstans.DEBUG) {
                                af.b("CommonImageLoaderRefactor", "callbackForFailed error", e5);
                            }
                        }
                    }
                });
            }
        }

        public final void onCancelDownload(DownloadMessage<Object> downloadMessage) {
        }

        public final void onDownloadComplete(DownloadMessage<Object> downloadMessage) {
            File file;
            if (MBridgeConstans.DEBUG) {
                af.a("CommonImageLoaderRefactor", "onDownloadComplete imageUrl = " + this.f13211f + " imagePath = " + this.f13208c + this.f13209d);
                try {
                    file = new File(this.f13208c + this.f13209d);
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CommonImageLoaderRefactor", "onDownloadComplete error", e5);
                    }
                    file = null;
                }
                if (file == null || !file.isFile() || !file.exists()) {
                    af.b("CommonImageLoaderRefactor", "onDownloadComplete file not exist");
                } else {
                    af.a("CommonImageLoaderRefactor", "onDownloadComplete file size = " + file.length());
                }
            }
            this.f13206a.execute(new Runnable() {
                public final void run() {
                    b.a(b.this);
                }
            });
        }

        public final void onDownloadError(DownloadMessage<Object> downloadMessage, DownloadError downloadError) {
            if (MBridgeConstans.DEBUG) {
                af.a("CommonImageLoaderRefactor", "onDownloadError imageUrl = " + downloadError.getException().getLocalizedMessage());
            }
            a(downloadError.getException().getLocalizedMessage());
        }

        public final void onDownloadStart(DownloadMessage<Object> downloadMessage) {
        }

        private Bitmap a(Bitmap bitmap, g gVar) {
            if (gVar != null) {
                try {
                    return gVar.a(bitmap);
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b("CommonImageLoaderRefactor", "handlerImageTransformation error", e5);
                    }
                }
            }
            return bitmap;
        }

        static /* synthetic */ void a(b bVar) {
            if (bVar.f13212g != null) {
                try {
                    Bitmap c5 = d.d(bVar.f13208c + bVar.f13209d);
                    if (c5 == null) {
                        bVar.a("bitmap decode failed");
                        return;
                    }
                    final Bitmap a5 = bVar.a(c5, bVar.f13210e);
                    if (a5 == null) {
                        bVar.a("bitmap transformation failed");
                    } else if (bVar.f13212g != null) {
                        bVar.f13207b.post(new Runnable() {
                            public final void run() {
                                try {
                                    b.this.f13212g.onSuccessLoad(a5, b.this.f13211f);
                                } catch (Exception e5) {
                                    if (MBridgeConstans.DEBUG) {
                                        af.b("CommonImageLoaderRefactor", "callbackForSuccess error", e5);
                                    }
                                }
                            }
                        });
                    }
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.a("CommonImageLoaderRefactor", "onDownloadComplete decodeBitmap error = " + e5.getLocalizedMessage());
                    }
                    bVar.a("bitmap decode failed");
                }
            }
        }
    }

    public final Bitmap a(String str) {
        if (MBridgeConstans.DEBUG) {
            af.a("CommonImageLoaderRefactor", "getImageBitmapByUrl imageUrl = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.f13199c + ad.c(str);
        File file = new File(str2);
        if (file.isFile() && file.exists()) {
            try {
                return d(str2);
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("CommonImageLoaderRefactor", "getImageBitmapByUrl error", e5);
                }
            }
        }
        return null;
    }

    public final void a(final String str, final g gVar, final c cVar) {
        try {
            this.f13197a.execute(new Runnable() {
                public final void run() {
                    DownloadRequest a5 = d.this.a(ad.c(str), str, gVar, cVar);
                    if (a5 == null) {
                        if (MBridgeConstans.DEBUG) {
                            af.b("CommonImageLoaderRefactor", "createDownloadRequest error");
                        }
                        if (cVar != null) {
                            d.this.f13198b.post(new Runnable() {
                                public final void run() {
                                    AnonymousClass1 r02 = AnonymousClass1.this;
                                    cVar.onFailedLoad("create download request error", str);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a5.start();
                }
            });
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonImageLoaderRefactor", "loadImage error", e5);
            }
        }
    }

    /* access modifiers changed from: private */
    public DownloadRequest<?> a(String str, String str2, g gVar, c cVar) {
        try {
            String str3 = str2;
            return MBDownloadManager.getInstance().download(new DownloadMessage(new Object(), str3, str, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_IMAGE)).withReadTimeout((long) com.mbridge.msdk.foundation.same.a.f13147u).withConnectTimeout((long) com.mbridge.msdk.foundation.same.a.f13146t).withWriteTimeout((long) com.mbridge.msdk.foundation.same.a.f13145s).withDownloadPriority(DownloadPriority.LOW).withHttpRetryCounter(1).withDirectoryPathInternal(this.f13199c).withDownloadStateListener(new b(this.f13198b, this.f13197a, str2, this.f13199c, str, gVar, cVar)).with("download_scene", "download_image").withProgressStateListener((OnProgressStateListener) null).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).with("do_us_fi_re", Boolean.FALSE.toString()).build();
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b("CommonImageLoaderRefactor", "createDownloadRequest error", e5);
            }
            return null;
        }
    }
}
