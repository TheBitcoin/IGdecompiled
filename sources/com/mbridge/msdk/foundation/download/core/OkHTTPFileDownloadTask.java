package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.core.DownloaderReporter;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import com.mbridge.msdk.tracker.network.q;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

class OkHTTPFileDownloadTask implements IDownloadTask {
    private static final String CLOSE = "close";
    private static final String CONNECTION = "Connection";
    private static final String FORMAT_RANGE = "bytes=%d-";
    private static final String RESPONSE_BODY_IS_NULL = "response body is null";
    private static final String RESPONSE_CODE = "responseCode ";
    private static final String RESPONSE_CONTENT_LENGTH_IS_NULL = "response content length is null";
    private static final String RESPONSE_INPUTSTREAM_IS_NULL = "response inputStream is null";
    private static final String RESPONSE_IS_NULL = "response is null";
    private final IDatabaseHelper _databaseHelper;
    private volatile DownloadMessage _downloadMessage;
    private DownloadModel _downloadModel;
    private final DownloadRequest _downloadRequest;
    private DownloadResponse _downloadResponse;
    private DownloaderReporter.Builder _downloaderReporter;
    private String _etag = "";
    private InputStream _inputStream;
    private DownloadFileOutputStream _outputStream;
    private ResponseBody _responseBody;
    private q monitor;

    private OkHTTPFileDownloadTask(DownloadRequest downloadRequest, DownloadModel downloadModel, IDatabaseHelper iDatabaseHelper, DownloadMessage downloadMessage, DownloaderReporter.Builder builder) {
        this._downloadRequest = downloadRequest;
        this._downloadModel = downloadModel;
        this._databaseHelper = iDatabaseHelper;
        this._downloadMessage = downloadMessage;
        this._downloaderReporter = builder;
    }

    public static IDownloadTask create(DownloadRequest downloadRequest, DownloadModel downloadModel, IDatabaseHelper iDatabaseHelper, DownloadMessage downloadMessage, DownloaderReporter.Builder builder) {
        if (Objects.isNull(builder)) {
            builder = new DownloaderReporter.Builder(DownloadCommon.DOWNLOAD_REPORT_KEY);
        }
        return new OkHTTPFileDownloadTask(downloadRequest, downloadModel, iDatabaseHelper, downloadMessage, builder);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01bb  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0217 A[SYNTHETIC, Splitter:B:57:0x0217] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01a0 A[EDGE_INSN: B:93:0x01a0->B:47:0x01a0 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.foundation.download.DownloadResponse handleInputStream(java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37) throws java.io.IOException, java.lang.IllegalAccessException {
        /*
            r33 = this;
            r1 = r33
            java.lang.String r15 = ""
            java.lang.String r2 = "DownloadTask"
            com.mbridge.msdk.foundation.download.DownloadResponse r3 = new com.mbridge.msdk.foundation.download.DownloadResponse
            r3.<init>()
            com.mbridge.msdk.foundation.download.database.DownloadModel r0 = r1._downloadModel
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r0)
            r4 = 1
            if (r0 == 0) goto L_0x005c
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r1._downloadRequest
            java.lang.String r0 = r0.getDownloadId()
            com.mbridge.msdk.foundation.download.DownloadMessage r5 = r1._downloadMessage
            java.lang.String r5 = r5.getDownloadUrl()
            com.mbridge.msdk.foundation.download.DownloadMessage r6 = r1._downloadMessage
            java.lang.String r6 = r6.getResourceUrl()
            com.mbridge.msdk.foundation.download.DownloadMessage r7 = r1._downloadMessage
            java.lang.String r7 = r7.getSaveFileName()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r8 = r1._downloadRequest
            long r8 = r8.getTotalBytes()
            com.mbridge.msdk.foundation.download.DownloadMessage r10 = r1._downloadMessage
            int r12 = r10.getDownloadRate()
            com.mbridge.msdk.foundation.download.DownloadMessage r10 = r1._downloadMessage
            com.mbridge.msdk.foundation.download.DownloadResourceType r14 = r10.getDownloadResourceType()
            r10 = 0
            r13 = 1
            r18 = r3
            r3 = r5
            r4 = r6
            r16 = r15
            r17 = 1
            r6 = r35
            r5 = r37
            r15 = r2
            r2 = r0
            com.mbridge.msdk.foundation.download.database.DownloadModel r0 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r2, r3, r4, r5, r6, r7, r8, r10, r12, r13, r14)
            r9 = r6
            r1._downloadModel = r0
            com.mbridge.msdk.foundation.download.database.IDatabaseHelper r2 = r1._databaseHelper
            r2.insert(r0)
            goto L_0x00b4
        L_0x005c:
            r9 = r35
            r18 = r3
            r16 = r15
            r17 = 1
            r15 = r2
            com.mbridge.msdk.foundation.download.database.DownloadModel r0 = r1._downloadModel
            java.lang.String r19 = r0.getDownloadId()
            com.mbridge.msdk.foundation.download.database.DownloadModel r0 = r1._downloadModel
            java.lang.String r20 = r0.getDownloadUrl()
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r1._downloadMessage
            java.lang.String r21 = r0.getResourceUrl()
            com.mbridge.msdk.foundation.download.database.DownloadModel r0 = r1._downloadModel
            java.lang.String r22 = r0.getEtag()
            com.mbridge.msdk.foundation.download.database.DownloadModel r0 = r1._downloadModel
            java.lang.String r23 = r0.getSaveDirectorPath()
            com.mbridge.msdk.foundation.download.database.DownloadModel r0 = r1._downloadModel
            java.lang.String r24 = r0.getSaveFileName()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r1._downloadRequest
            long r25 = r0.getTotalBytes()
            com.mbridge.msdk.foundation.download.database.DownloadModel r0 = r1._downloadModel
            long r27 = r0.getDownloadedBytes()
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r1._downloadMessage
            int r29 = r0.getDownloadRate()
            com.mbridge.msdk.foundation.download.database.DownloadModel r0 = r1._downloadModel
            int r0 = r0.getUsageCounter()
            int r30 = r0 + 1
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r1._downloadMessage
            com.mbridge.msdk.foundation.download.DownloadResourceType r31 = r0.getDownloadResourceType()
            com.mbridge.msdk.foundation.download.database.DownloadModel r0 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r19, r20, r21, r22, r23, r24, r25, r27, r29, r30, r31)
            r1._downloadModel = r0
            com.mbridge.msdk.foundation.download.database.IDatabaseHelper r2 = r1._databaseHelper
            r2.update(r0, r9)
        L_0x00b4:
            com.mbridge.msdk.foundation.download.resource.MBResourceManager r0 = com.mbridge.msdk.foundation.download.resource.MBResourceManager.getInstance()
            java.io.File r2 = new java.io.File
            r3 = r34
            r2.<init>(r9, r3)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r0.getDownloadFileOutputStream(r2)
            r1._outputStream = r0
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r1._downloadRequest
            long r2 = r2.getDownloadedBytes()
            r0.seek(r2)
            r10 = 100
            r11 = 0
            r2 = 0
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r1._downloadMessage     // Catch:{ all -> 0x0108 }
            if (r0 == 0) goto L_0x010c
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r1._downloadMessage     // Catch:{ all -> 0x0108 }
            boolean r0 = r0.isCheckMD5()     // Catch:{ all -> 0x0108 }
            if (r0 == 0) goto L_0x010c
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r1._downloadMessage     // Catch:{ all -> 0x0108 }
            java.lang.String r0 = r0.getMd5()     // Catch:{ all -> 0x0108 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0108 }
            if (r0 != 0) goto L_0x010c
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r1._downloadMessage     // Catch:{ all -> 0x0108 }
            java.lang.String r3 = r0.getMd5()     // Catch:{ all -> 0x0108 }
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r0)     // Catch:{ all -> 0x0106 }
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r1._downloadMessage     // Catch:{ all -> 0x0106 }
            int r0 = r0.getDownloadRate()     // Catch:{ all -> 0x0106 }
            if (r0 != r10) goto L_0x010e
            boolean r0 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0106 }
            if (r0 != 0) goto L_0x010e
            r4 = 1
            goto L_0x010f
        L_0x0106:
            r0 = move-exception
            goto L_0x0114
        L_0x0108:
            r0 = move-exception
            r3 = r16
            goto L_0x0114
        L_0x010c:
            r3 = r16
        L_0x010e:
            r4 = 0
        L_0x010f:
            r19 = r4
        L_0x0111:
            r0 = r2
            r14 = r3
            goto L_0x0126
        L_0x0114:
            com.mbridge.msdk.foundation.download.core.GlobalComponent r4 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()
            com.mbridge.msdk.foundation.download.utils.ILogger r4 = r4.getLogger()
            java.lang.String r0 = r0.getMessage()
            r4.log((java.lang.String) r15, (java.lang.String) r0)
            r19 = 0
            goto L_0x0111
        L_0x0126:
            com.mbridge.msdk.tracker.network.q r2 = r1.monitor
            if (r2 == 0) goto L_0x012f
            java.lang.String r3 = "process_data_start"
            r2.d((java.lang.String) r3)
        L_0x012f:
            com.mbridge.msdk.foundation.download.core.GlobalComponent r2 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()
            int r2 = r2.getByteBufferSize()
            byte[] r12 = new byte[r2]
        L_0x0139:
            java.io.InputStream r2 = r1._inputStream
            int r2 = r2.read(r12)
            r3 = -1
            if (r2 == r3) goto L_0x01a0
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r3 = r1._outputStream
            r3.write(r12, r11, r2)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r3 = r1._downloadRequest
            long r4 = r3.getDownloadedBytes()
            long r6 = (long) r2
            long r4 = r4 + r6
            r3.setDownloadedBytes(r4)
            if (r19 == 0) goto L_0x015b
            if (r0 == 0) goto L_0x015b
            r0.update(r12, r11, r2)     // Catch:{ Exception -> 0x015a }
            goto L_0x015b
        L_0x015a:
        L_0x015b:
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r2 = r1._outputStream
            r2.flushAndSync()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r1._downloadRequest
            long r2 = r2.getTotalBytes()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r4 = r1._downloadRequest
            long r4 = r4.getDownloadedBytes()
            int r8 = com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r2, r4)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r1._downloadRequest
            com.mbridge.msdk.foundation.download.DownloadMessage r3 = r1._downloadMessage
            com.mbridge.msdk.foundation.download.core.DownloadRequest r4 = r1._downloadRequest
            long r4 = r4.getDownloadedBytes()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r6 = r1._downloadRequest
            long r6 = r6.getTotalBytes()
            r1.sendProgress(r2, r3, r4, r6, r8)
            com.mbridge.msdk.tracker.network.q r2 = r1.monitor
            if (r2 == 0) goto L_0x0190
            com.mbridge.msdk.foundation.download.core.DownloadRequest r3 = r1._downloadRequest
            long r3 = r3.getDownloadedBytes()
            r2.f(r3)
        L_0x0190:
            com.mbridge.msdk.foundation.download.DownloadMessage r2 = r1._downloadMessage
            int r2 = r2.getDownloadRate()
            if (r2 == r10) goto L_0x01a3
            com.mbridge.msdk.foundation.download.DownloadMessage r2 = r1._downloadMessage
            int r2 = r2.getDownloadRate()
            if (r8 < r2) goto L_0x01a3
        L_0x01a0:
            r2 = r18
            goto L_0x01b7
        L_0x01a3:
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r1._downloadRequest
            com.mbridge.msdk.foundation.download.DownloadStatus r2 = r2.getStatus()
            com.mbridge.msdk.foundation.download.DownloadStatus r3 = com.mbridge.msdk.foundation.download.DownloadStatus.CANCELLED
            if (r2 != r3) goto L_0x01b4
            r2 = r18
            r3 = 1
            r2.setCancelled(r3)
            goto L_0x01b7
        L_0x01b4:
            r17 = 1
            goto L_0x0139
        L_0x01b7:
            com.mbridge.msdk.tracker.network.q r3 = r1.monitor
            if (r3 == 0) goto L_0x01c0
            java.lang.String r4 = "process_data_end"
            r3.d((java.lang.String) r4)
        L_0x01c0:
            com.mbridge.msdk.foundation.download.core.GlobalComponent r3 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()
            com.mbridge.msdk.foundation.download.database.IDatabaseHelper r3 = r3.getDatabaseHelper()
            com.mbridge.msdk.foundation.download.DownloadMessage r4 = r1._downloadMessage
            java.lang.String r4 = r4.getDownloadUrl()
            com.mbridge.msdk.foundation.download.DownloadMessage r5 = r1._downloadMessage
            java.lang.String r5 = r5.getResourceUrl()
            com.mbridge.msdk.foundation.download.DownloadMessage r6 = r1._downloadMessage
            java.lang.String r6 = r6.getSaveFileName()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r7 = r1._downloadRequest
            long r7 = r7.getTotalBytes()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r10 = r1._downloadRequest
            long r10 = r10.getDownloadedBytes()
            com.mbridge.msdk.foundation.download.DownloadMessage r12 = r1._downloadMessage
            int r12 = r12.getDownloadRate()
            com.mbridge.msdk.foundation.download.database.DownloadModel r13 = r1._downloadModel
            int r13 = r13.getUsageCounter()
            r34 = r0
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r1._downloadMessage
            com.mbridge.msdk.foundation.download.DownloadResourceType r0 = r0.getDownloadResourceType()
            r18 = r13
            r13 = r0
            r0 = r3
            r3 = r5
            r5 = r9
            r9 = r10
            r11 = r12
            r12 = r18
            r32 = r2
            r2 = r4
            r18 = r15
            r4 = r37
            r15 = r1
            r1 = r36
            com.mbridge.msdk.foundation.download.database.DownloadModel r2 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r1, r2, r3, r4, r5, r6, r7, r9, r11, r12, r13)
            r0.updateProgress(r1, r5, r2)
            if (r19 == 0) goto L_0x029f
            com.mbridge.msdk.foundation.download.core.DownloadRequest r0 = r15._downloadRequest     // Catch:{ all -> 0x022b }
            com.mbridge.msdk.foundation.download.DownloadStatus r0 = r0.getStatus()     // Catch:{ all -> 0x022b }
            com.mbridge.msdk.foundation.download.DownloadStatus r1 = com.mbridge.msdk.foundation.download.DownloadStatus.CANCELLED     // Catch:{ all -> 0x022b }
            if (r0 == r1) goto L_0x029f
            com.mbridge.msdk.tracker.network.q r0 = r15.monitor     // Catch:{ all -> 0x022b }
            if (r0 == 0) goto L_0x0232
            java.lang.String r1 = "validate_data_start"
            r0.d((java.lang.String) r1)     // Catch:{ all -> 0x022b }
            goto L_0x0232
        L_0x022b:
            r0 = move-exception
            r4 = r18
        L_0x022e:
            r2 = r32
            goto L_0x02a2
        L_0x0232:
            byte[] r0 = r34.digest()     // Catch:{ all -> 0x022b }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.SameMD5.hexEncode(r0)     // Catch:{ all -> 0x022b }
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x022b }
            if (r1 == 0) goto L_0x0243
            r1 = r16
            goto L_0x0249
        L_0x0243:
            java.util.Locale r1 = java.util.Locale.US     // Catch:{ all -> 0x022b }
            java.lang.String r1 = r14.toLowerCase(r1)     // Catch:{ all -> 0x022b }
        L_0x0249:
            com.mbridge.msdk.foundation.download.core.GlobalComponent r2 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()     // Catch:{ all -> 0x022b }
            com.mbridge.msdk.foundation.download.utils.ILogger r2 = r2.getLogger()     // Catch:{ all -> 0x022b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x022b }
            r3.<init>()     // Catch:{ all -> 0x022b }
            r3.append(r0)     // Catch:{ all -> 0x022b }
            java.lang.String r4 = " "
            r3.append(r4)     // Catch:{ all -> 0x022b }
            r3.append(r1)     // Catch:{ all -> 0x022b }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x022b }
            r4 = r18
            r2.log((java.lang.String) r4, (java.lang.String) r3)     // Catch:{ all -> 0x0274 }
            com.mbridge.msdk.tracker.network.q r2 = r15.monitor     // Catch:{ all -> 0x0274 }
            if (r2 == 0) goto L_0x0276
            java.lang.String r3 = "validate_data_end"
            r2.d((java.lang.String) r3)     // Catch:{ all -> 0x0274 }
            goto L_0x0276
        L_0x0274:
            r0 = move-exception
            goto L_0x022e
        L_0x0276:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0274 }
            if (r2 != 0) goto L_0x029f
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0274 }
            if (r0 != 0) goto L_0x029f
            com.mbridge.msdk.foundation.download.DownloadMessage r0 = r15._downloadMessage     // Catch:{ all -> 0x0274 }
            r3 = 1
            r0.setMd5VerifyResult(r3)     // Catch:{ all -> 0x0274 }
            r2 = r32
            r2.setFailed(r3)     // Catch:{ all -> 0x029d }
            com.mbridge.msdk.foundation.download.DownloadError r0 = new com.mbridge.msdk.foundation.download.DownloadError     // Catch:{ all -> 0x029d }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x029d }
            java.lang.String r3 = "File MD5 check fail."
            r1.<init>(r3)     // Catch:{ all -> 0x029d }
            r0.<init>(r1)     // Catch:{ all -> 0x029d }
            r2.setError((com.mbridge.msdk.foundation.download.DownloadError) r0)     // Catch:{ all -> 0x029d }
            goto L_0x02bb
        L_0x029d:
            r0 = move-exception
            goto L_0x02a2
        L_0x029f:
            r2 = r32
            goto L_0x02b1
        L_0x02a2:
            com.mbridge.msdk.foundation.download.core.GlobalComponent r1 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()
            com.mbridge.msdk.foundation.download.utils.ILogger r1 = r1.getLogger()
            java.lang.String r0 = r0.getMessage()
            r1.log((java.lang.String) r4, (java.lang.String) r0)
        L_0x02b1:
            boolean r0 = r2.isCancelled()
            if (r0 != 0) goto L_0x02bb
            r3 = 1
            r2.setSuccessful(r3)
        L_0x02bb:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.core.OkHTTPFileDownloadTask.handleInputStream(java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.mbridge.msdk.foundation.download.DownloadResponse");
    }

    private void handlerException(String str, String str2, String str3, Exception exc) {
        try {
            if (Objects.isNotNull(this._databaseHelper) && Objects.isNotNull(this._downloadRequest)) {
                if (!ah.a().a("r_f_s_d_e", true)) {
                    this._databaseHelper.remove(str3, str2);
                    MBResourceManager instance = MBResourceManager.getInstance();
                    instance.deleteFile(new File(this._downloadRequest.getCacheDirectoryPath() + this._downloadMessage.getSaveFileName()));
                }
                this._downloadRequest.setDownloadedBytes(0);
                this._downloadRequest.setTotalBytes(0);
            }
        } catch (Exception e5) {
            GlobalComponent.getInstance().getLogger().log(IDownloadTask.TAG, e5.getMessage());
        }
        this._downloadResponse.setError(exc);
    }

    private DownloadResponse handlerRequestSuccessful(String str, String str2, String str3, Response response, int i4) throws IOException, IllegalAccessException {
        boolean z4;
        DownloadResponse downloadResponse = new DownloadResponse();
        boolean isSupportResume = isSupportResume(i4, this._downloadModel);
        if (response == null || this._downloadRequest == null || i4 != 206 || response.body() == null || this._downloadRequest.getTotalBytes() <= 0 || response.body().contentLength() == this._downloadRequest.getTotalBytes() - this._downloadRequest.getDownloadedBytes()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!isSupportResume && z4) {
            this._downloadRequest.setDownloadedBytes(0);
            this._downloadRequest.setTotalBytes(0);
            if (Objects.isNotNull(this._databaseHelper)) {
                this._databaseHelper.remove(str3, str2);
            }
            this._downloadModel = null;
            MBResourceManager instance = MBResourceManager.getInstance();
            instance.deleteFile(new File(this._downloadRequest.getCacheDirectoryPath() + this._downloadMessage.getSaveFileName()));
        }
        ResponseBody body = response.body();
        this._responseBody = body;
        if (Objects.isNull(body)) {
            downloadResponse.setError((Exception) new IOException(RESPONSE_BODY_IS_NULL));
            this._downloadRequest.setTotalBytes(0);
            this._downloadRequest.setDownloadedBytes(0);
            return downloadResponse;
        }
        long contentLength = this._responseBody.contentLength();
        if (contentLength <= 0) {
            downloadResponse.setError((Exception) new IOException(RESPONSE_CONTENT_LENGTH_IS_NULL));
            return downloadResponse;
        }
        if (this._downloadRequest.getTotalBytes() == 0) {
            this._downloadRequest.setTotalBytes(contentLength);
        }
        InputStream byteStream = this._responseBody.byteStream();
        this._inputStream = byteStream;
        if (!Objects.isNull(byteStream)) {
            return handleInputStream(str, str2, str3, this._etag);
        }
        downloadResponse.setError((Exception) new IOException(RESPONSE_INPUTSTREAM_IS_NULL));
        return downloadResponse;
    }

    private boolean isSupportResume(int i4, DownloadModel downloadModel) {
        if (i4 != 206 || TextUtils.isEmpty(this._etag)) {
            return false;
        }
        if (downloadModel != null && !TextUtils.equals(this._etag, downloadModel.getEtag())) {
            return false;
        }
        return true;
    }

    private void reportDownloadMessage() {
        Exception exc;
        boolean isSuccessful = this._downloadResponse.isSuccessful();
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_SUCCESS, Boolean.toString(isSuccessful));
        boolean isCancelled = this._downloadResponse.isCancelled();
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_CANCEL, Boolean.toString(isCancelled));
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE, String.valueOf(Utils.getDownloadRate(this._downloadRequest.getTotalBytes(), this._downloadRequest.getDownloadedBytes())));
        if (!isSuccessful && !isCancelled) {
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_REASON, this._downloadResponse.getErrorMessage());
        }
        q qVar = this.monitor;
        if (qVar != null) {
            if (isSuccessful) {
                qVar.b(1);
            } else {
                String errorMessage = this._downloadResponse.getErrorMessage();
                DownloadError error = this._downloadResponse.getError();
                if (error == null) {
                    exc = null;
                } else {
                    exc = error.getException();
                }
                q qVar2 = this.monitor;
                if (isCancelled) {
                    exc = new IOException("download request canceled");
                }
                qVar2.a(exc);
                if (TextUtils.equals(errorMessage, "timeout")) {
                    this.monitor.b(3);
                } else {
                    this.monitor.b(2);
                }
            }
        }
        this._downloaderReporter.build().report();
    }

    private void sendProgress(DownloadRequest downloadRequest, DownloadMessage downloadMessage, long j4, long j5, int i4) {
        if (downloadRequest.getStatus() != DownloadStatus.CANCELLED) {
            downloadRequest.handlerProcessEvent(downloadMessage, new DownloadProgress(j4, j5, i4));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x01d3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01d4, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x01d7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x01d8, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x025a, code lost:
        if (r7.isCanceled() == false) goto L_0x025c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x025c, code lost:
        r7.cancel();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x025f, code lost:
        reportDownloadMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0266, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0267, code lost:
        r6 = r4;
        r4 = r3;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x026b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x026c, code lost:
        r3 = r19;
        r6 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02bc, code lost:
        if (r7.isCanceled() == false) goto L_0x025c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x02c1, code lost:
        return r1._downloadResponse;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02da, code lost:
        r7.cancel();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01d3 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:29:0x01b1] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.mbridge.msdk.foundation.download.DownloadResponse run() {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r0 = "User-Agent"
            com.mbridge.msdk.foundation.download.DownloadResponse r3 = new com.mbridge.msdk.foundation.download.DownloadResponse
            r3.<init>()
            r1._downloadResponse = r3
            com.mbridge.msdk.foundation.download.core.DownloadRequest r3 = r1._downloadRequest
            com.mbridge.msdk.foundation.download.DownloadStatus r3 = r3.getStatus()
            com.mbridge.msdk.foundation.download.DownloadStatus r4 = com.mbridge.msdk.foundation.download.DownloadStatus.CANCELLED
            r5 = 1
            if (r3 != r4) goto L_0x001e
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse
            r0.setCancelled(r5)
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse
            return r0
        L_0x001e:
            com.mbridge.msdk.foundation.download.core.DownloadRequest r3 = r1._downloadRequest
            long r3 = r3.getTotalBytes()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r6 = r1._downloadRequest
            long r6 = r6.getDownloadedBytes()
            int r8 = com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r3, r6)
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r9 = r1._downloaderReporter
            java.lang.String r10 = "dcr"
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r9.add(r10, r8)
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r8 = r1._downloaderReporter
            java.lang.String r9 = "ddb"
            java.lang.String r10 = java.lang.String.valueOf(r6)
            r8.add(r9, r10)
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r8 = r1._downloaderReporter
            java.lang.String r9 = "dtb"
            java.lang.String r10 = java.lang.String.valueOf(r3)
            r8.add(r9, r10)
            r8 = 0
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0077
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0077
            int r10 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r10 != 0) goto L_0x0077
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r0 = r1._downloaderReporter
            java.lang.String r2 = "de"
            java.lang.String r3 = "t=c"
            r0.add(r2, r3)
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r0 = r1._downloaderReporter
            com.mbridge.msdk.foundation.download.core.DownloaderReporter r0 = r0.build()
            r0.report()
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse
            r0.setSuccessful(r5)
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse
            return r0
        L_0x0077:
            com.mbridge.msdk.foundation.download.DownloadMessage r3 = r1._downloadMessage
            java.lang.String r3 = r3.getSaveFileName()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r4 = r1._downloadRequest
            java.lang.String r4 = r4.getCacheDirectoryPath()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r10 = r1._downloadRequest
            java.lang.String r10 = r10.getDownloadId()
            com.mbridge.msdk.foundation.download.DownloadMessage r11 = r1._downloadMessage
            java.lang.String r11 = r11.getDownloadUrl()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r12 = r1._downloadRequest
            com.mbridge.msdk.tracker.network.q r12 = r12.getMonitor()
            r1.monitor = r12
            if (r12 != 0) goto L_0x00c0
            com.mbridge.msdk.foundation.download.core.DownloadRequest r12 = r1._downloadRequest
            boolean r12 = r12.canTrack()
            if (r12 == 0) goto L_0x00c0
            boolean r12 = android.text.TextUtils.isEmpty(r11)
            if (r12 != 0) goto L_0x00c0
            com.mbridge.msdk.tracker.network.q r12 = new com.mbridge.msdk.tracker.network.q
            com.mbridge.msdk.foundation.download.core.DownloadRequest r13 = r1._downloadRequest
            java.lang.String r13 = com.mbridge.msdk.foundation.same.d.a((com.mbridge.msdk.foundation.download.core.DownloadRequest<?>) r13)
            java.lang.String r14 = "GET"
            r12.<init>(r13, r14)
            r1.monitor = r12
            r12.a((java.lang.String) r11)
            com.mbridge.msdk.foundation.download.core.DownloadRequest r12 = r1._downloadRequest
            com.mbridge.msdk.tracker.network.q r13 = r1.monitor
            r12.setMonitor(r13)
        L_0x00c0:
            com.mbridge.msdk.foundation.download.core.DownloadRequest r12 = r1._downloadRequest
            long r12 = r12.getTimeout()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r14 = r1._downloadRequest
            long r14 = r14.getConnectTimeout()
            r16 = 0
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r1._downloadRequest
            long r8 = r2.getReadTimeout()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r1._downloadRequest
            r17 = r6
            long r5 = r2.getWriteTimeout()
            com.mbridge.msdk.foundation.download.core.DownloadRequest r2 = r1._downloadRequest
            r19 = r8
            long r7 = r2.getRequestQueueTime()
            com.mbridge.msdk.tracker.network.q r2 = r1.monitor
            if (r2 == 0) goto L_0x010d
            r2.a((long) r12)
            com.mbridge.msdk.tracker.network.q r2 = r1.monitor
            r2.b((long) r14)
            com.mbridge.msdk.tracker.network.q r2 = r1.monitor
            r21 = r10
            r9 = r19
            r2.c((long) r9)
            com.mbridge.msdk.tracker.network.q r2 = r1.monitor
            r2.d((long) r5)
            com.mbridge.msdk.tracker.network.q r2 = r1.monitor
            r19 = r3
            java.lang.String r3 = "queue"
            r2.d((java.lang.String) r3)
            com.mbridge.msdk.tracker.network.q r2 = r1.monitor
            r2.j(r7)
            goto L_0x0113
        L_0x010d:
            r21 = r10
            r9 = r19
            r19 = r3
        L_0x0113:
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.Long r3 = java.lang.Long.valueOf(r17)
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r8[r16] = r3
            java.lang.String r3 = "bytes=%d-"
            java.lang.String r2 = java.lang.String.format(r2, r3, r8)
            com.mbridge.msdk.foundation.download.core.GlobalComponent r3 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.OkHttpClient r3 = r3.getOkHttpClient()     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r3 = r3.newBuilder()     // Catch:{ Exception -> 0x02e1 }
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r3 = r3.connectTimeout(r14, r8)     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r3 = r3.readTimeout(r9, r8)     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r3 = r3.writeTimeout(r5, r8)     // Catch:{ Exception -> 0x02e1 }
            r5 = 0
            long r5 = java.lang.Math.max(r5, r12)     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r3 = r3.callTimeout(r5, r8)     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.tracker.network.toolbox.OKHTTPEventListener r5 = new com.mbridge.msdk.tracker.network.toolbox.OKHTTPEventListener     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.tracker.network.q r6 = r1.monitor     // Catch:{ Exception -> 0x02e1 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r3 = r3.eventListener(r5)     // Catch:{ Exception -> 0x02e1 }
            r7 = 1
            com.mbridge.msdk.thrid.okhttp.OkHttpClient$Builder r3 = r3.retryOnConnectionFailure(r7)     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.OkHttpClient r3 = r3.build()     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.CacheControl$Builder r5 = new com.mbridge.msdk.thrid.okhttp.CacheControl$Builder     // Catch:{ Exception -> 0x02e1 }
            r5.<init>()     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.CacheControl$Builder r5 = r5.noCache()     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.CacheControl r5 = r5.build()     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.Request$Builder r6 = new com.mbridge.msdk.thrid.okhttp.Request$Builder     // Catch:{ Exception -> 0x02e1 }
            r6.<init>()     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.Request$Builder r6 = r6.url((java.lang.String) r11)     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.Request$Builder r5 = r6.cacheControl(r5)     // Catch:{ Exception -> 0x02e1 }
            java.lang.String r6 = "Connection"
            java.lang.String r7 = "close"
            com.mbridge.msdk.thrid.okhttp.Request$Builder r5 = r5.addHeader(r6, r7)     // Catch:{ Exception -> 0x02e1 }
            java.lang.String r6 = "Range"
            com.mbridge.msdk.thrid.okhttp.Request$Builder r2 = r5.addHeader(r6, r2)     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.Request$Builder r2 = r2.removeHeader(r0)     // Catch:{ Exception -> 0x02e1 }
            java.lang.String r5 = "okhttp/3.12.13/MAL_16.8.61"
            com.mbridge.msdk.thrid.okhttp.Request$Builder r0 = r2.addHeader(r0, r5)     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.thrid.okhttp.Request r0 = r0.build()     // Catch:{ Exception -> 0x02e1 }
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r2 = r1._downloaderReporter
            com.mbridge.msdk.thrid.okhttp.HttpUrl r5 = r0.url()
            java.lang.String r5 = r5.host()
            java.lang.String r6 = "ht"
            r2.add(r6, r5)
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r2 = r1._downloaderReporter
            java.lang.String r5 = "url"
            r2.add(r5, r11)
            com.mbridge.msdk.thrid.okhttp.Call r7 = r3.newCall(r0)
            r2 = 0
            com.mbridge.msdk.thrid.okhttp.Response r5 = r7.execute()     // Catch:{ Exception -> 0x02a0 }
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r5)     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            if (r0 != 0) goto L_0x01c1
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r5.body()     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r0)     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            if (r0 == 0) goto L_0x01c7
        L_0x01c1:
            r3 = r19
            r6 = r21
            goto L_0x0271
        L_0x01c7:
            int r6 = r5.code()     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            com.mbridge.msdk.tracker.network.q r0 = r1.monitor     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            if (r0 == 0) goto L_0x01df
            r0.a((int) r6)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            goto L_0x01df
        L_0x01d3:
            r0 = move-exception
            r2 = r5
            goto L_0x02c2
        L_0x01d7:
            r0 = move-exception
            r2 = r5
        L_0x01d9:
            r3 = r19
            r6 = r21
            goto L_0x02a3
        L_0x01df:
            com.mbridge.msdk.foundation.download.core.DownloaderReporter$Builder r0 = r1._downloaderReporter     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            java.lang.String r2 = "drc"
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            r0.add(r2, r3)     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            boolean r0 = r5.isSuccessful()     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            if (r0 != 0) goto L_0x022c
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            r3.<init>()     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            java.lang.String r8 = "responseCode "
            r3.append(r8)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            r3.append(r6)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            r0.setError((java.lang.Exception) r2)     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse     // Catch:{ Exception -> 0x01d7, all -> 0x01d3 }
            java.io.InputStream r2 = r1._inputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeInputStream(r2)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r2 = r1._outputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeOutputStream(r2)
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponse(r5)
            com.mbridge.msdk.thrid.okhttp.ResponseBody r2 = r1._responseBody
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponseBody(r2)
            boolean r2 = r7.isCanceled()
            if (r2 != 0) goto L_0x0228
            r7.cancel()
        L_0x0228:
            r1.reportDownloadMessage()
            return r0
        L_0x022c:
            java.lang.String r0 = "ETag"
            java.lang.String r2 = ""
            java.lang.String r0 = r5.header(r0, r2)     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            r1._etag = r0     // Catch:{ Exception -> 0x026b, all -> 0x01d3 }
            r3 = r4
            r2 = r19
            r4 = r21
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1.handlerRequestSuccessful(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0266, all -> 0x01d3 }
            r6 = r4
            r4 = r3
            r3 = r2
            r1._downloadResponse = r0     // Catch:{ Exception -> 0x0263, all -> 0x01d3 }
            java.io.InputStream r0 = r1._inputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeInputStream(r0)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r1._outputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeOutputStream(r0)
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponse(r5)
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r1._responseBody
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponseBody(r0)
            boolean r0 = r7.isCanceled()
            if (r0 != 0) goto L_0x025f
        L_0x025c:
            r7.cancel()
        L_0x025f:
            r1.reportDownloadMessage()
            goto L_0x02bf
        L_0x0263:
            r0 = move-exception
        L_0x0264:
            r2 = r5
            goto L_0x02a3
        L_0x0266:
            r0 = move-exception
            r6 = r4
            r4 = r3
            r3 = r2
            goto L_0x0264
        L_0x026b:
            r0 = move-exception
            r3 = r19
            r6 = r21
            goto L_0x0264
        L_0x0271:
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse     // Catch:{ Exception -> 0x0263, all -> 0x01d3 }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ Exception -> 0x0263, all -> 0x01d3 }
            java.lang.String r8 = "response is null"
            r2.<init>(r8)     // Catch:{ Exception -> 0x0263, all -> 0x01d3 }
            r0.setError((java.lang.Exception) r2)     // Catch:{ Exception -> 0x0263, all -> 0x01d3 }
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse     // Catch:{ Exception -> 0x0263, all -> 0x01d3 }
            java.io.InputStream r2 = r1._inputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeInputStream(r2)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r2 = r1._outputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeOutputStream(r2)
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponse(r5)
            com.mbridge.msdk.thrid.okhttp.ResponseBody r2 = r1._responseBody
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponseBody(r2)
            boolean r2 = r7.isCanceled()
            if (r2 != 0) goto L_0x029a
            r7.cancel()
        L_0x029a:
            r1.reportDownloadMessage()
            return r0
        L_0x029e:
            r0 = move-exception
            goto L_0x02c2
        L_0x02a0:
            r0 = move-exception
            goto L_0x01d9
        L_0x02a3:
            r1.handlerException(r3, r4, r6, r0)     // Catch:{ all -> 0x029e }
            java.io.InputStream r0 = r1._inputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeInputStream(r0)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r0 = r1._outputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeOutputStream(r0)
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponse(r2)
            com.mbridge.msdk.thrid.okhttp.ResponseBody r0 = r1._responseBody
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponseBody(r0)
            boolean r0 = r7.isCanceled()
            if (r0 != 0) goto L_0x025f
            goto L_0x025c
        L_0x02bf:
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse
            return r0
        L_0x02c2:
            java.io.InputStream r3 = r1._inputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeInputStream(r3)
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r3 = r1._outputStream
            com.mbridge.msdk.foundation.download.utils.Objects.closeOutputStream(r3)
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponse(r2)
            com.mbridge.msdk.thrid.okhttp.ResponseBody r2 = r1._responseBody
            com.mbridge.msdk.foundation.download.utils.Objects.closeResponseBody(r2)
            boolean r2 = r7.isCanceled()
            if (r2 != 0) goto L_0x02dd
            r7.cancel()
        L_0x02dd:
            r1.reportDownloadMessage()
            throw r0
        L_0x02e1:
            r0 = move-exception
            r3 = r19
            r6 = r21
            r1.handlerException(r3, r4, r6, r0)
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse
            r2 = 0
            r0.setSuccessful(r2)
            com.mbridge.msdk.foundation.download.DownloadResponse r0 = r1._downloadResponse
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.core.OkHTTPFileDownloadTask.run():com.mbridge.msdk.foundation.download.DownloadResponse");
    }
}
