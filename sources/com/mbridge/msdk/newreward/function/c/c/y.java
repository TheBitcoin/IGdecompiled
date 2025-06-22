package com.mbridge.msdk.newreward.function.c.c;

import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;

public final class y extends q implements OnDownloadStateListener<b>, OnProgressStateListener<b> {

    /* renamed from: a  reason: collision with root package name */
    private final b f14605a;

    /* renamed from: b  reason: collision with root package name */
    private final a f14606b;

    /* renamed from: c  reason: collision with root package name */
    private final n f14607c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14608d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14609e;

    /* renamed from: f  reason: collision with root package name */
    private final String f14610f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14611g = false;

    /* renamed from: h  reason: collision with root package name */
    private final int f14612h;

    /* renamed from: i  reason: collision with root package name */
    private DownloadRequest f14613i;

    /* renamed from: j  reason: collision with root package name */
    private x f14614j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f14615k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f14616l = false;

    public y(b bVar, a aVar, n nVar, int i4) {
        this.f14605a = bVar;
        this.f14606b = aVar;
        this.f14607c = nVar;
        this.f14612h = i4;
        String j4 = nVar.j();
        this.f14608d = j4;
        String str = e.a(c.MBRIDGE_VC) + File.separator;
        this.f14609e = str;
        String a5 = com.mbridge.msdk.newreward.function.h.c.a(j4);
        this.f14610f = a5;
        String str2 = str + a5;
        nVar.a(new File(str2));
        nVar.a(true);
        File file = new File(str2);
        if (file.exists() && file.isFile()) {
            nVar.a(1);
            nVar.b(true);
            nVar.a(false);
        }
    }

    public final void a(int i4, x xVar) {
        DownloadMessage downloadMessage;
        int i5;
        this.f14614j = xVar;
        if (TextUtils.isEmpty(this.f14608d)) {
            if (this.f14607c.d()) {
                x xVar2 = this.f14614j;
                if (xVar2 != null) {
                    xVar2.a(this.f14605a, this.f14606b, this);
                    this.f14614j.b(this.f14605a, this.f14606b, this);
                    return;
                }
                return;
            }
            x xVar3 = this.f14614j;
            if (xVar3 != null) {
                xVar3.a(this.f14605a, this.f14606b, this);
                this.f14614j.a(this.f14605a, this.f14606b, this, new MBridgeError(5, MBridgeError.ERROR_MESSAGE_DOWNLOAD_RESOURCE_URL_ERROR));
            }
        } else if (this.f14616l) {
            x xVar4 = this.f14614j;
            if (xVar4 != null) {
                xVar4.b(this.f14605a, this.f14606b, this);
            }
        } else {
            this.f14615k = false;
            int videoCtnType = this.f14606b.h().getVideoCtnType();
            if (i4 == 1 || (i5 = this.f14612h) == 100) {
                this.f14611g = false;
                downloadMessage = new DownloadMessage(this.f14605a, this.f14608d, this.f14610f, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            } else if (videoCtnType == 1) {
                this.f14611g = false;
                downloadMessage = new DownloadMessage(this.f14605a, this.f14608d, this.f14610f, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            } else {
                this.f14611g = true;
                downloadMessage = new DownloadMessage(this.f14605a, this.f14608d, this.f14610f, i5, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_VIDEO);
            }
            DownloadRequest build = MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withWriteTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withDownloadPriority(DownloadPriority.IMMEDIATE).withHttpRetryCounter(5).withDirectoryPathInternal(this.f14609e).withDownloadStateListener(this).withProgressStateListener(this).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).with("download_scene", "download_video").with("do_us_fi_re", Boolean.toString(true)).build();
            this.f14613i = build;
            build.start();
        }
    }

    public final void onCancelDownload(DownloadMessage<b> downloadMessage) {
        if (this.f14615k) {
            x xVar = this.f14614j;
            if (xVar != null) {
                xVar.b(this.f14605a, this.f14606b, this, new MBridgeError(4, MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT));
                return;
            }
            return;
        }
        x xVar2 = this.f14614j;
        if (xVar2 != null) {
            xVar2.a(this.f14605a, this.f14606b, this, new MBridgeError(2, MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR));
        }
    }

    public final void onDownloadComplete(DownloadMessage<b> downloadMessage) {
        int i4;
        String str = this.f14613i.get("cache", "2");
        n nVar = this.f14607c;
        if (TextUtils.equals(str, "2")) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        nVar.a(i4);
        this.f14607c.b(true);
        this.f14607c.a(false);
        this.f14616l = true;
        x xVar = this.f14614j;
        if (xVar != null) {
            xVar.b(this.f14605a, this.f14606b, this);
        }
    }

    public final void onDownloadError(DownloadMessage<b> downloadMessage, DownloadError downloadError) {
        int i4;
        String str = this.f14613i.get("cache", "2");
        n nVar = this.f14607c;
        if (TextUtils.equals(str, "2")) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        nVar.a(i4);
        this.f14607c.b(false);
        this.f14607c.a(false);
        MBridgeError mBridgeError = new MBridgeError(2, MBridgeError.ERROR_MESSAGE_DOWNLOAD_VIDEO_ERROR);
        mBridgeError.setException(downloadError.getException());
        x xVar = this.f14614j;
        if (xVar != null) {
            xVar.a(this.f14605a, this.f14606b, this, mBridgeError);
        }
    }

    public final void onDownloadStart(DownloadMessage<b> downloadMessage) {
        x xVar = this.f14614j;
        if (xVar != null) {
            xVar.a(this.f14605a, this.f14606b, this);
        }
    }

    public final void onProgress(DownloadMessage<b> downloadMessage, DownloadProgress downloadProgress) {
        int i4;
        if (downloadProgress.getCurrentDownloadRate() >= this.f14612h) {
            String str = this.f14613i.get("cache", "2");
            n nVar = this.f14607c;
            if (TextUtils.equals(str, "2")) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            nVar.a(i4);
            this.f14607c.b(true);
            this.f14607c.a(false);
            if (this.f14611g) {
                this.f14613i.cancel(downloadMessage);
            }
        }
    }
}
