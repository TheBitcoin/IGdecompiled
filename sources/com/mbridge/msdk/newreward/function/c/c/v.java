package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.download.core.RequestBuilder;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;

public final class v extends q implements OnDownloadStateListener<b>, OnProgressStateListener<b> {

    /* renamed from: a  reason: collision with root package name */
    private final String f14590a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14591b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14592c;

    /* renamed from: d  reason: collision with root package name */
    private final b f14593d;

    /* renamed from: e  reason: collision with root package name */
    private final a f14594e;

    /* renamed from: f  reason: collision with root package name */
    private final c f14595f;

    /* renamed from: g  reason: collision with root package name */
    private final String f14596g;

    /* renamed from: h  reason: collision with root package name */
    private DownloadRequest<?> f14597h;

    /* renamed from: i  reason: collision with root package name */
    private x f14598i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14599j = false;

    /* renamed from: k  reason: collision with root package name */
    private String f14600k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14601l = false;

    public v(b bVar, a aVar, c cVar) {
        c cVar2;
        String str;
        boolean z4;
        this.f14593d = bVar;
        this.f14594e = aVar;
        this.f14595f = cVar;
        String j4 = cVar.j();
        this.f14596g = j4;
        if (!TextUtils.isEmpty(j4)) {
            if (!j4.contains(".zip") || !j4.contains(ResourceManager.KEY_MD5FILENAME)) {
                z4 = false;
            } else {
                z4 = true;
            }
            this.f14601l = z4;
        }
        if (this.f14601l) {
            cVar2 = c.MBRIDGE_700_RES;
        } else {
            cVar2 = c.MBRIDGE_700_HTML;
        }
        String a5 = e.a(cVar2);
        String md5 = SameMD5.getMD5(aq.b(j4));
        this.f14590a = md5;
        this.f14591b = a5 + "/";
        this.f14592c = a5 + "/" + md5;
        cVar.a(true);
        if (this.f14601l) {
            str = ResourceManager.getinstance().getResDirFromCampaign(j4);
        } else {
            str = HTMLResourceManager.getInstance().getHtmlContentFromUrl(j4);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f14599j = true;
            cVar.a(1);
            cVar.a(str);
            cVar.b(true);
            cVar.a(false);
        }
    }

    public final void a(int i4, x xVar) {
        StringBuilder sb;
        String str;
        DownloadResourceType downloadResourceType;
        String str2;
        this.f14598i = xVar;
        if (xVar != null) {
            xVar.a(this.f14593d, this.f14594e, this);
        }
        if (this.f14599j) {
            x xVar2 = this.f14598i;
            if (xVar2 != null) {
                xVar2.b(this.f14593d, this.f14594e, this);
                return;
            }
            return;
        }
        if (this.f14601l) {
            sb = new StringBuilder();
            sb.append(this.f14590a);
            str = ".zip";
        } else {
            sb = new StringBuilder();
            sb.append(this.f14590a);
            str = ".html";
        }
        sb.append(str);
        String sb2 = sb.toString();
        this.f14600k = this.f14591b + sb2;
        b bVar = this.f14593d;
        String str3 = this.f14596g;
        if (this.f14601l) {
            downloadResourceType = DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP;
        } else {
            downloadResourceType = DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_HTML;
        }
        RequestBuilder withTimeout = MBDownloadManager.getInstance().download(new DownloadMessage(bVar, str3, sb2, 100, downloadResourceType)).withReadTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withWriteTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withDownloadPriority(DownloadPriority.IMMEDIATE).withHttpRetryCounter(5).withDirectoryPathInternal(this.f14591b).withDownloadStateListener(this).withProgressStateListener(this).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        c cVar = this.f14595f;
        if (cVar != null) {
            int b_ = cVar.b_();
            if (b_ == 2) {
                str2 = "download_template";
            } else if (b_ == 3) {
                str2 = "download_big_template";
            } else if (b_ == 4) {
                str2 = "download_end_card";
            }
            DownloadRequest<?> build = withTimeout.with("download_scene", str2).with("do_us_fi_re", Boolean.toString(true)).build();
            this.f14597h = build;
            build.start();
        }
        str2 = "un_known";
        DownloadRequest<?> build2 = withTimeout.with("download_scene", str2).with("do_us_fi_re", Boolean.toString(true)).build();
        this.f14597h = build2;
        build2.start();
    }

    public final void onCancelDownload(DownloadMessage<b> downloadMessage) {
        int i4;
        String str = this.f14597h.get("cache", "2");
        c cVar = this.f14595f;
        if (TextUtils.equals(str, "2")) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        cVar.a(i4);
        this.f14595f.b(false);
        this.f14595f.a(false);
        if (this.f14595f.d()) {
            x xVar = this.f14598i;
            if (xVar != null) {
                xVar.b(this.f14593d, this.f14594e, this);
                return;
            }
            return;
        }
        x xVar2 = this.f14598i;
        if (xVar2 != null) {
            xVar2.a(this.f14593d, this.f14594e, this, new MBridgeError(4, MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT));
        }
    }

    public final void onDownloadComplete(DownloadMessage<b> downloadMessage) {
        Exception exc;
        String str;
        String str2 = MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR;
        try {
            if (this.f14601l) {
                MBResourceManager.getInstance().unZip(this.f14600k, this.f14592c);
            }
            if (this.f14601l) {
                str = ResourceManager.getinstance().getResDirFromCampaign(this.f14596g);
            } else {
                str = HTMLResourceManager.getInstance().getHtmlContentFromUrl(this.f14596g);
            }
            int i4 = 1;
            this.f14595f.b(true);
            this.f14595f.a(false);
            String str3 = this.f14597h.get("cache", "2");
            c cVar = this.f14595f;
            if (TextUtils.equals(str3, "2")) {
                i4 = 2;
            }
            cVar.a(i4);
            this.f14595f.a(str);
            if (this.f14595f.d()) {
                x xVar = this.f14598i;
                if (xVar != null) {
                    xVar.b(this.f14593d, this.f14594e, this);
                    return;
                }
                return;
            }
            x xVar2 = this.f14598i;
            if (xVar2 != null) {
                xVar2.a(this.f14593d, this.f14594e, this, new MBridgeError(6, str2));
            }
        } catch (Exception e5) {
            exc = e5;
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeDownloader", "onDownloadComplete.unZip: " + exc.getMessage());
            }
            if (this.f14595f.d()) {
                x xVar3 = this.f14598i;
                if (xVar3 != null) {
                    xVar3.b(this.f14593d, this.f14594e, this);
                }
            } else if (this.f14598i != null) {
                this.f14598i.a(this.f14593d, this.f14594e, this, new MBridgeError(6, "unzip error:" + exc.getMessage()));
            }
        } catch (Throwable th) {
            if (this.f14595f.d()) {
                x xVar4 = this.f14598i;
                if (xVar4 != null) {
                    xVar4.b(this.f14593d, this.f14594e, this);
                }
            } else if (this.f14598i != null) {
                if (exc != null) {
                    str2 = "unzip error:" + exc.getMessage();
                }
                this.f14598i.a(this.f14593d, this.f14594e, this, new MBridgeError(6, str2));
            }
            throw th;
        }
    }

    public final void onDownloadError(DownloadMessage<b> downloadMessage, DownloadError downloadError) {
        int i4;
        String str;
        String str2 = this.f14597h.get("cache", "2");
        c cVar = this.f14595f;
        if (TextUtils.equals(str2, "2")) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        cVar.a(i4);
        this.f14595f.b(false);
        this.f14595f.a(false);
        if (this.f14595f.d()) {
            x xVar = this.f14598i;
            if (xVar != null) {
                xVar.b(this.f14593d, this.f14594e, this);
            }
        } else if (this.f14598i != null) {
            c cVar2 = this.f14595f;
            if (cVar2 != null) {
                int b_ = cVar2.b_();
                if (b_ == 2) {
                    str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_VIDEO_TEMPLATE_ERROR;
                } else if (b_ == 3) {
                    str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_BIG_TEMPLATE_ERROR;
                } else if (b_ == 4) {
                    str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_EC_TEMPLATE_ERROR;
                }
                MBridgeError mBridgeError = new MBridgeError(2, str);
                mBridgeError.setException(downloadError.getException());
                this.f14598i.a(this.f14593d, this.f14594e, this, mBridgeError);
            }
            str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR;
            MBridgeError mBridgeError2 = new MBridgeError(2, str);
            mBridgeError2.setException(downloadError.getException());
            this.f14598i.a(this.f14593d, this.f14594e, this, mBridgeError2);
        }
    }

    public final void onDownloadStart(DownloadMessage<b> downloadMessage) {
    }

    public final void onProgress(DownloadMessage<b> downloadMessage, DownloadProgress downloadProgress) {
    }
}
