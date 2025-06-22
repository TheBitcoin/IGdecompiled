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
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.c.a.a;
import com.mbridge.msdk.newreward.function.c.a.b;
import com.mbridge.msdk.newreward.function.command.d;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

abstract class r extends q implements OnDownloadStateListener<b>, OnProgressStateListener<b> {

    /* renamed from: a  reason: collision with root package name */
    private final b f14580a;

    /* renamed from: b  reason: collision with root package name */
    private final a f14581b;

    /* renamed from: c  reason: collision with root package name */
    private final b f14582c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14583d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14584e;

    /* renamed from: f  reason: collision with root package name */
    private DownloadRequest<?> f14585f;

    /* renamed from: g  reason: collision with root package name */
    private final String f14586g;

    /* renamed from: h  reason: collision with root package name */
    private x f14587h;

    /* renamed from: i  reason: collision with root package name */
    private final String f14588i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f14589j = false;

    protected r(b bVar, a aVar, b bVar2) {
        this.f14580a = bVar;
        this.f14581b = aVar;
        this.f14582c = bVar2;
        String j4 = bVar2.j();
        this.f14583d = j4;
        String str = e.a(c.MBRIDGE_700_XML) + File.separator;
        this.f14588i = str;
        String a5 = com.mbridge.msdk.newreward.function.h.c.a(j4);
        this.f14584e = a5;
        String str2 = str + a5.replace(".zip", "").replace(".xml", "");
        this.f14586g = str2;
        bVar2.a(true);
        File a6 = a(str2);
        if (a6 != null && a6.exists()) {
            this.f14589j = true;
            bVar2.a(1);
            bVar2.a(a6);
            bVar2.b(true);
            bVar2.a(false);
        }
    }

    private File b(String str) {
        String a5 = com.mbridge.msdk.newreward.function.h.c.a(new File(str + File.separator + "template_config.json"));
        if (TextUtils.isEmpty(a5)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(a5);
            if (jSONArray.length() == 0) {
                return null;
            }
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("xml_type", "");
                    if (!TextUtils.isEmpty(optString)) {
                        if (TextUtils.equals(optString, b())) {
                            File file = new File(str + File.separator + optJSONObject.optString(RewardPlus.NAME, ""));
                            if (file.exists()) {
                                return file;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return null;
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeDownloader", "findTemplateFile: " + e5.getMessage());
            }
        }
    }

    public void a(int i4, x xVar) {
        this.f14587h = xVar;
        if (xVar != null) {
            xVar.a(this.f14580a, this.f14581b, this);
        }
        if (a()) {
            if (xVar != null) {
                xVar.b(this.f14580a, this.f14581b, this);
            }
        } else if (this.f14589j) {
            if (xVar != null) {
                xVar.b(this.f14580a, this.f14581b, this);
            }
        } else if (!TextUtils.isEmpty(this.f14583d)) {
            DownloadRequest<?> build = MBDownloadManager.getInstance().download(new DownloadMessage(this.f14580a, this.f14583d, this.f14584e, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP)).withReadTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withWriteTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(5).withDirectoryPathInternal(this.f14588i).withDownloadStateListener(this).withProgressStateListener(this).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).with("download_scene", "download_dynamic_view").with("do_us_fi_re", Boolean.toString(true)).build();
            this.f14585f = build;
            build.start();
        } else if (this.f14582c.d()) {
            if (xVar != null) {
                xVar.b(this.f14580a, this.f14581b, this);
            }
        } else if (xVar != null) {
            xVar.a(this.f14580a, this.f14581b, this, new MBridgeError(5, MBridgeError.ERROR_MESSAGE_DOWNLOAD_RESOURCE_URL_ERROR));
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean a();

    /* access modifiers changed from: protected */
    public abstract String b();

    public a c() {
        return this.f14581b;
    }

    public b d() {
        return this.f14580a;
    }

    public a<?> e() {
        return this.f14582c;
    }

    public void onCancelDownload(DownloadMessage<b> downloadMessage) {
        int i4;
        String str = this.f14585f.get("cache", "2");
        b bVar = this.f14582c;
        if (TextUtils.equals(str, "2")) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        bVar.a(i4);
        this.f14582c.b(false);
        this.f14582c.a(false);
        if (this.f14582c.d()) {
            x xVar = this.f14587h;
            if (xVar != null) {
                xVar.b(this.f14580a, this.f14581b, this);
                return;
            }
            return;
        }
        x xVar2 = this.f14587h;
        if (xVar2 != null) {
            xVar2.a(this.f14580a, this.f14581b, this, new MBridgeError(4, MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT));
        }
    }

    public void onDownloadComplete(DownloadMessage<b> downloadMessage) {
        int i4;
        try {
            MBResourceManager.getInstance().unZip(downloadMessage.getSaveFilePath(), this.f14588i);
            String str = this.f14585f.get("cache", "2");
            b bVar = this.f14582c;
            if (TextUtils.equals(str, "2")) {
                i4 = 2;
            } else {
                i4 = 1;
            }
            bVar.a(i4);
            this.f14582c.b(true);
            this.f14582c.a(false);
            this.f14582c.a(a(this.f14586g));
            this.f14582c.a(2);
            com.mbridge.msdk.newreward.function.command.c b5 = d.a().b();
            if (b5 != null) {
                b5.a((Object) b5.a("metrics_config_path", this.f14586g + File.separator + "metrics_config.json", "resource_type", Integer.valueOf(e().b_())), "SharePreReceiver");
            }
            if (this.f14582c.d()) {
                x xVar = this.f14587h;
                if (xVar != null) {
                    xVar.b(this.f14580a, this.f14581b, this);
                    return;
                }
                return;
            }
            x xVar2 = this.f14587h;
            if (xVar2 != null) {
                xVar2.a(this.f14580a, this.f14581b, this, new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR));
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.a("MBridgeDownloader", "onDownloadComplete.unZip: " + e5.getMessage());
            }
            if (this.f14582c.d()) {
                x xVar3 = this.f14587h;
                if (xVar3 != null) {
                    xVar3.b(this.f14580a, this.f14581b, this);
                    return;
                }
                return;
            }
            x xVar4 = this.f14587h;
            if (xVar4 != null) {
                xVar4.a(this.f14580a, this.f14581b, this, new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR));
            }
        } catch (Throwable th) {
            if (this.f14582c.d()) {
                x xVar5 = this.f14587h;
                if (xVar5 != null) {
                    xVar5.b(this.f14580a, this.f14581b, this);
                }
            } else {
                x xVar6 = this.f14587h;
                if (xVar6 != null) {
                    xVar6.a(this.f14580a, this.f14581b, this, new MBridgeError(6, MBridgeError.ERROR_MESSAGE_DOWNLOAD_UN_ZIP_ERROR));
                }
            }
            throw th;
        }
    }

    public void onDownloadError(DownloadMessage<b> downloadMessage, DownloadError downloadError) {
        int i4;
        String str;
        String str2 = this.f14585f.get("cache", "2");
        b bVar = this.f14582c;
        if (TextUtils.equals(str2, "2")) {
            i4 = 2;
        } else {
            i4 = 1;
        }
        bVar.a(i4);
        this.f14582c.b(false);
        this.f14582c.a(false);
        if (this.f14587h != null) {
            b bVar2 = this.f14582c;
            if (bVar2 != null) {
                int b_ = bVar2.b_();
                if (b_ == 2) {
                    str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_VIDEO_TEMPLATE_ERROR;
                } else if (b_ == 3) {
                    str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_BIG_TEMPLATE_ERROR;
                } else if (b_ == 4) {
                    str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_EC_TEMPLATE_ERROR;
                }
                MBridgeError mBridgeError = new MBridgeError(2, str);
                mBridgeError.setException(downloadError.getException());
                this.f14587h.a(this.f14580a, this.f14581b, this, mBridgeError);
            }
            str = MBridgeError.ERROR_MESSAGE_DOWNLOAD_NETWORK_ERROR;
            MBridgeError mBridgeError2 = new MBridgeError(2, str);
            mBridgeError2.setException(downloadError.getException());
            this.f14587h.a(this.f14580a, this.f14581b, this, mBridgeError2);
        }
    }

    public void onDownloadStart(DownloadMessage<b> downloadMessage) {
    }

    public void onProgress(DownloadMessage<b> downloadMessage, DownloadProgress downloadProgress) {
    }

    private File a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str + ".xml");
        if (!file.isFile() || !file.exists()) {
            return b(str);
        }
        return file;
    }
}
