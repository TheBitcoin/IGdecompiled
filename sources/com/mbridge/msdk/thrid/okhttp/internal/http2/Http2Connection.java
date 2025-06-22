package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.internal.NamedRunnable;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Http2Connection implements Closeable, AutoCloseable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int AWAIT_PING = 3;
    static final int DEGRADED_PING = 2;
    static final long DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    static final int INTERVAL_PING = 1;
    static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    /* access modifiers changed from: private */
    public static final ExecutorService listenerExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    private long awaitPingsSent = 0;
    private long awaitPongsReceived = 0;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests;
    private long degradedPingsSent = 0;
    private long degradedPongDeadlineNs = 0;
    private long degradedPongsReceived = 0;
    final String hostname;
    /* access modifiers changed from: private */
    public long intervalPingsSent = 0;
    /* access modifiers changed from: private */
    public long intervalPongsReceived = 0;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings = new Settings();
    final Settings peerSettings;
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final ReaderRunnable readerRunnable;
    /* access modifiers changed from: private */
    public boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    long unacknowledgedBytesRead = 0;
    final Http2Writer writer;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService writerExecutor;

    final class IntervalPingRunnable extends NamedRunnable {
        IntervalPingRunnable() {
            super("OkHttp %s ping", Http2Connection.this.hostname);
        }

        public void execute() {
            boolean z4;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.intervalPongsReceived < Http2Connection.this.intervalPingsSent) {
                    z4 = true;
                } else {
                    Http2Connection.access$208(Http2Connection.this);
                    z4 = false;
                }
            }
            if (z4) {
                Http2Connection.this.failConnection();
            } else {
                Http2Connection.this.writePing(false, 1, 0);
            }
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            public void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;

        PingRunnable(boolean z4, int i4, int i5) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.hostname, Integer.valueOf(i4), Integer.valueOf(i5));
            this.reply = z4;
            this.payload1 = i4;
            this.payload2 = i5;
        }

        public void execute() {
            Http2Connection.this.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.hostname);
            this.reader = http2Reader;
        }

        public void ackSettings() {
        }

        public void alternateService(int i4, String str, ByteString byteString, String str2, int i5, long j4) {
        }

        /* JADX WARNING: type inference failed for: r4v11, types: [java.lang.Object[]] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:2|3|9|19|20|22|23|24) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0069 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void applyAndAckSettings(boolean r7, com.mbridge.msdk.thrid.okhttp.internal.http2.Settings r8) {
            /*
                r6 = this;
                r0 = 1
                r1 = 0
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r2 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r2 = r2.writer
                monitor-enter(r2)
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0067 }
                monitor-enter(r3)     // Catch:{ all -> 0x0067 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r4 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Settings r4 = r4.peerSettings     // Catch:{ all -> 0x001c }
                int r4 = r4.getInitialWindowSize()     // Catch:{ all -> 0x001c }
                if (r7 == 0) goto L_0x001f
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r7 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Settings r7 = r7.peerSettings     // Catch:{ all -> 0x001c }
                r7.clear()     // Catch:{ all -> 0x001c }
                goto L_0x001f
            L_0x001c:
                r7 = move-exception
                goto L_0x0098
            L_0x001f:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r7 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Settings r7 = r7.peerSettings     // Catch:{ all -> 0x001c }
                r7.merge(r8)     // Catch:{ all -> 0x001c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r7 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Settings r7 = r7.peerSettings     // Catch:{ all -> 0x001c }
                int r7 = r7.getInitialWindowSize()     // Catch:{ all -> 0x001c }
                r8 = -1
                r5 = 0
                if (r7 == r8) goto L_0x005a
                if (r7 == r4) goto L_0x005a
                int r7 = r7 - r4
                long r7 = (long) r7     // Catch:{ all -> 0x001c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r4 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                java.util.Map<java.lang.Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream> r4 = r4.streams     // Catch:{ all -> 0x001c }
                boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x001c }
                if (r4 != 0) goto L_0x005c
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r4 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                java.util.Map<java.lang.Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream> r4 = r4.streams     // Catch:{ all -> 0x001c }
                java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x001c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r5 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x001c }
                java.util.Map<java.lang.Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream> r5 = r5.streams     // Catch:{ all -> 0x001c }
                int r5 = r5.size()     // Catch:{ all -> 0x001c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream[] r5 = new com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream[r5]     // Catch:{ all -> 0x001c }
                java.lang.Object[] r4 = r4.toArray(r5)     // Catch:{ all -> 0x001c }
                r5 = r4
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream[] r5 = (com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream[]) r5     // Catch:{ all -> 0x001c }
                goto L_0x005c
            L_0x005a:
                r7 = 0
            L_0x005c:
                monitor-exit(r3)     // Catch:{ all -> 0x001c }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0069 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r4 = r3.writer     // Catch:{ IOException -> 0x0069 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Settings r3 = r3.peerSettings     // Catch:{ IOException -> 0x0069 }
                r4.applyAndAckSettings(r3)     // Catch:{ IOException -> 0x0069 }
                goto L_0x006e
            L_0x0067:
                r7 = move-exception
                goto L_0x009a
            L_0x0069:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0067 }
                r3.failConnection()     // Catch:{ all -> 0x0067 }
            L_0x006e:
                monitor-exit(r2)     // Catch:{ all -> 0x0067 }
                if (r5 == 0) goto L_0x0081
                int r2 = r5.length
                r3 = 0
            L_0x0073:
                if (r3 >= r2) goto L_0x0081
                r4 = r5[r3]
                monitor-enter(r4)
                r4.addBytesToWriteWindow(r7)     // Catch:{ all -> 0x007e }
                monitor-exit(r4)     // Catch:{ all -> 0x007e }
                int r3 = r3 + r0
                goto L_0x0073
            L_0x007e:
                r7 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x007e }
                throw r7
            L_0x0081:
                java.util.concurrent.ExecutorService r7 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.listenerExecutor
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection$ReaderRunnable$3 r8 = new com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection$ReaderRunnable$3
                java.lang.String r2 = "OkHttp %s settings"
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this
                java.lang.String r3 = r3.hostname
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r0[r1] = r3
                r8.<init>(r2, r0)
                r7.execute(r8)
                return
            L_0x0098:
                monitor-exit(r3)     // Catch:{ all -> 0x001c }
                throw r7     // Catch:{ all -> 0x0067 }
            L_0x009a:
                monitor-exit(r2)     // Catch:{ all -> 0x0067 }
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.ReaderRunnable.applyAndAckSettings(boolean, com.mbridge.msdk.thrid.okhttp.internal.http2.Settings):void");
        }

        public void data(boolean z4, int i4, BufferedSource bufferedSource, int i5) throws IOException {
            if (Http2Connection.this.pushedStream(i4)) {
                Http2Connection.this.pushDataLater(i4, bufferedSource, i5, z4);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i4);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater(i4, ErrorCode.PROTOCOL_ERROR);
                long j4 = (long) i5;
                Http2Connection.this.updateConnectionFlowControl(j4);
                bufferedSource.skip(j4);
                return;
            }
            stream.receiveData(bufferedSource, i5);
            if (z4) {
                stream.receiveFin();
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:18|19|20|21) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r4.this$0.close(r0, r0);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r4 = this;
                com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode.INTERNAL_ERROR
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader r1 = r4.reader     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                r1.readConnectionPreface(r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            L_0x0007:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader r1 = r4.reader     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                r2 = 0
                boolean r1 = r1.nextFrame(r2, r4)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                if (r1 == 0) goto L_0x0011
                goto L_0x0007
            L_0x0011:
                com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r1 = com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x0026 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r2 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x001a }
                r2.close(r1, r0)     // Catch:{ IOException -> 0x001a }
            L_0x001a:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader r0 = r4.reader
                com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r0)
                goto L_0x002e
            L_0x0020:
                r2 = move-exception
                goto L_0x002f
            L_0x0022:
                r2 = move-exception
                r1 = r0
                goto L_0x002f
            L_0x0025:
                r1 = r0
            L_0x0026:
                com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x0020 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r1 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x001a }
                r1.close(r0, r0)     // Catch:{ IOException -> 0x001a }
                goto L_0x001a
            L_0x002e:
                return
            L_0x002f:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r3 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0034 }
                r3.close(r1, r0)     // Catch:{ IOException -> 0x0034 }
            L_0x0034:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Reader r0 = r4.reader
                com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.ReaderRunnable.execute():void");
        }

        public void goAway(int i4, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.streams.values().toArray(new Http2Stream[Http2Connection.this.streams.size()]);
                boolean unused = Http2Connection.this.shutdown = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i4 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream(http2Stream.getId());
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0075, code lost:
            r0.receiveHeaders(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
            if (r6 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x007a, code lost:
            r0.receiveFin();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r9, int r10, int r11, java.util.List<com.mbridge.msdk.thrid.okhttp.internal.http2.Header> r12) {
            /*
                r8 = this;
                r11 = 2
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this
                boolean r0 = r0.pushedStream(r10)
                if (r0 == 0) goto L_0x000f
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r11 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this
                r11.pushHeadersLater(r10, r12, r9)
                return
            L_0x000f:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r1 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this
                monitor-enter(r1)
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = r0.getStream(r10)     // Catch:{ all -> 0x0024 }
                if (r0 != 0) goto L_0x0073
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                boolean r0 = r0.shutdown     // Catch:{ all -> 0x0024 }
                if (r0 == 0) goto L_0x0027
                monitor-exit(r1)     // Catch:{ all -> 0x0024 }
                return
            L_0x0024:
                r0 = move-exception
                r9 = r0
                goto L_0x007e
            L_0x0027:
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                int r2 = r0.lastGoodStreamId     // Catch:{ all -> 0x0024 }
                if (r10 > r2) goto L_0x002f
                monitor-exit(r1)     // Catch:{ all -> 0x0024 }
                return
            L_0x002f:
                int r2 = r10 % 2
                int r0 = r0.nextStreamId     // Catch:{ all -> 0x0024 }
                int r0 = r0 % r11
                if (r2 != r0) goto L_0x0038
                monitor-exit(r1)     // Catch:{ all -> 0x0024 }
                return
            L_0x0038:
                com.mbridge.msdk.thrid.okhttp.Headers r7 = com.mbridge.msdk.thrid.okhttp.internal.Util.toHeaders(r12)     // Catch:{ all -> 0x0024 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r2 = new com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream     // Catch:{ all -> 0x0024 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r4 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                r5 = 0
                r6 = r9
                r3 = r10
                r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0024 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r9 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                r9.lastGoodStreamId = r3     // Catch:{ all -> 0x0024 }
                java.util.Map<java.lang.Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream> r9 = r9.streams     // Catch:{ all -> 0x0024 }
                java.lang.Integer r10 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0024 }
                r9.put(r10, r2)     // Catch:{ all -> 0x0024 }
                java.util.concurrent.ExecutorService r9 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.listenerExecutor     // Catch:{ all -> 0x0024 }
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection$ReaderRunnable$1 r10 = new com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection$ReaderRunnable$1     // Catch:{ all -> 0x0024 }
                java.lang.String r12 = "OkHttp %s stream %d"
                com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0024 }
                java.lang.String r0 = r0.hostname     // Catch:{ all -> 0x0024 }
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0024 }
                java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x0024 }
                r4 = 0
                r11[r4] = r0     // Catch:{ all -> 0x0024 }
                r0 = 1
                r11[r0] = r3     // Catch:{ all -> 0x0024 }
                r10.<init>(r12, r11, r2)     // Catch:{ all -> 0x0024 }
                r9.execute(r10)     // Catch:{ all -> 0x0024 }
                monitor-exit(r1)     // Catch:{ all -> 0x0024 }
                return
            L_0x0073:
                r6 = r9
                monitor-exit(r1)     // Catch:{ all -> 0x0024 }
                r0.receiveHeaders(r12)
                if (r6 == 0) goto L_0x007d
                r0.receiveFin()
            L_0x007d:
                return
            L_0x007e:
                monitor-exit(r1)     // Catch:{ all -> 0x0024 }
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.ReaderRunnable.headers(boolean, int, int, java.util.List):void");
        }

        public void ping(boolean z4, int i4, int i5) {
            if (z4) {
                synchronized (Http2Connection.this) {
                    if (i4 == 1) {
                        try {
                            Http2Connection.access$108(Http2Connection.this);
                        } catch (Throwable th) {
                            throw th;
                        }
                    } else if (i4 == 2) {
                        Http2Connection.access$608(Http2Connection.this);
                    } else if (i4 == 3) {
                        Http2Connection.access$708(Http2Connection.this);
                        Http2Connection.this.notifyAll();
                    }
                }
                return;
            }
            try {
                Http2Connection.this.writerExecutor.execute(new PingRunnable(true, i4, i5));
            } catch (RejectedExecutionException unused) {
            }
        }

        public void priority(int i4, int i5, int i6, boolean z4) {
        }

        public void pushPromise(int i4, int i5, List<Header> list) {
            Http2Connection.this.pushRequestLater(i5, list);
        }

        public void rstStream(int i4, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream(i4)) {
                Http2Connection.this.pushResetLater(i4, errorCode);
                return;
            }
            Http2Stream removeStream = Http2Connection.this.removeStream(i4);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean z4, Settings settings) {
            try {
                final boolean z5 = z4;
                final Settings settings2 = settings;
                Http2Connection.this.writerExecutor.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.hostname}) {
                    public void execute() {
                        ReaderRunnable.this.applyAndAckSettings(z5, settings2);
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        }

        public void windowUpdate(int i4, long j4) {
            if (i4 == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection http2Connection = Http2Connection.this;
                    http2Connection.bytesLeftInWriteWindow += j4;
                    http2Connection.notifyAll();
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i4);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j4);
                }
            }
        }
    }

    Http2Connection(Builder builder) {
        int i4;
        Builder builder2 = builder;
        Settings settings = new Settings();
        this.peerSettings = settings;
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = builder2.pushObserver;
        boolean z4 = builder2.client;
        this.client = z4;
        this.listener = builder2.listener;
        if (z4) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        this.nextStreamId = i4;
        if (z4) {
            this.nextStreamId = i4 + 2;
        }
        if (z4) {
            this.okHttpSettings.set(7, 16777216);
        }
        String str = builder2.hostname;
        this.hostname = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", str), false));
        this.writerExecutor = scheduledThreadPoolExecutor;
        if (builder2.pingIntervalMillis != 0) {
            IntervalPingRunnable intervalPingRunnable = new IntervalPingRunnable();
            int i5 = builder2.pingIntervalMillis;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(intervalPingRunnable, (long) i5, (long) i5, TimeUnit.MILLISECONDS);
        }
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", str), true));
        settings.set(7, 65535);
        settings.set(5, 16384);
        this.bytesLeftInWriteWindow = (long) settings.getInitialWindowSize();
        this.socket = builder2.socket;
        this.writer = new Http2Writer(builder2.sink, z4);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder2.source, z4));
    }

    static /* synthetic */ long access$108(Http2Connection http2Connection) {
        long j4 = http2Connection.intervalPongsReceived;
        http2Connection.intervalPongsReceived = 1 + j4;
        return j4;
    }

    static /* synthetic */ long access$208(Http2Connection http2Connection) {
        long j4 = http2Connection.intervalPingsSent;
        http2Connection.intervalPingsSent = 1 + j4;
        return j4;
    }

    static /* synthetic */ long access$608(Http2Connection http2Connection) {
        long j4 = http2Connection.degradedPongsReceived;
        http2Connection.degradedPongsReceived = 1 + j4;
        return j4;
    }

    static /* synthetic */ long access$708(Http2Connection http2Connection) {
        long j4 = http2Connection.awaitPongsReceived;
        http2Connection.awaitPongsReceived = 1 + j4;
        return j4;
    }

    /* access modifiers changed from: private */
    public void failConnection() {
        try {
            ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
            close(errorCode, errorCode);
        } catch (IOException unused) {
        }
    }

    private synchronized void pushExecutorExecute(NamedRunnable namedRunnable) {
        if (!this.shutdown) {
            this.pushExecutor.execute(namedRunnable);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream getStream(int i4) {
        return this.streams.get(Integer.valueOf(i4));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001b, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isHealthy(long r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.shutdown     // Catch:{ all -> 0x0018 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r6)
            return r1
        L_0x0008:
            long r2 = r6.degradedPongsReceived     // Catch:{ all -> 0x0018 }
            long r4 = r6.degradedPingsSent     // Catch:{ all -> 0x0018 }
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x001a
            long r2 = r6.degradedPongDeadlineNs     // Catch:{ all -> 0x0018 }
            int r0 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x001a
            monitor-exit(r6)
            return r1
        L_0x0018:
            r7 = move-exception
            goto L_0x001d
        L_0x001a:
            monitor-exit(r6)
            r7 = 1
            return r7
        L_0x001d:
            monitor-exit(r6)     // Catch:{ all -> 0x0018 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.isHealthy(long):boolean");
    }

    public synchronized int maxConcurrentStreams() {
        return this.peerSettings.getMaxConcurrentStreams(Integer.MAX_VALUE);
    }

    public Http2Stream newStream(List<Header> list, boolean z4) throws IOException {
        return newStream(0, list, z4);
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    /* access modifiers changed from: package-private */
    public void pushDataLater(int i4, BufferedSource bufferedSource, int i5, boolean z4) throws IOException {
        final Buffer buffer = new Buffer();
        long j4 = (long) i5;
        bufferedSource.require(j4);
        bufferedSource.read(buffer, j4);
        if (buffer.size() == j4) {
            final int i6 = i4;
            final int i7 = i5;
            final boolean z5 = z4;
            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostname, Integer.valueOf(i4)}) {
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.pushObserver.onData(i6, buffer, i7, z5);
                        if (onData) {
                            Http2Connection.this.writer.rstStream(i6, ErrorCode.CANCEL);
                        }
                        if (onData || z5) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i6));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i5);
    }

    /* access modifiers changed from: package-private */
    public void pushHeadersLater(int i4, List<Header> list, boolean z4) {
        try {
            final List<Header> list2 = list;
            final boolean z5 = z4;
            final int i5 = i4;
            try {
                pushExecutorExecute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostname, Integer.valueOf(i4)}) {
                    public void execute() {
                        boolean onHeaders = Http2Connection.this.pushObserver.onHeaders(i5, list2, z5);
                        if (onHeaders) {
                            try {
                                Http2Connection.this.writer.rstStream(i5, ErrorCode.CANCEL);
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        if (onHeaders || z5) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i5));
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException unused) {
            }
        } catch (RejectedExecutionException unused2) {
        }
    }

    /* access modifiers changed from: package-private */
    public void pushRequestLater(int i4, List<Header> list) {
        Throwable th;
        synchronized (this) {
            try {
                if (this.currentPushRequests.contains(Integer.valueOf(i4))) {
                    try {
                        writeSynResetLater(i4, ErrorCode.PROTOCOL_ERROR);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            th = th;
                            throw th;
                        }
                        throw th;
                    }
                } else {
                    this.currentPushRequests.add(Integer.valueOf(i4));
                    try {
                        final int i5 = i4;
                        final List<Header> list2 = list;
                        try {
                            pushExecutorExecute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostname, Integer.valueOf(i4)}) {
                                public void execute() {
                                    if (Http2Connection.this.pushObserver.onRequest(i5, list2)) {
                                        try {
                                            Http2Connection.this.writer.rstStream(i5, ErrorCode.CANCEL);
                                            synchronized (Http2Connection.this) {
                                                Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i5));
                                            }
                                        } catch (IOException unused) {
                                        }
                                    }
                                }
                            });
                        } catch (RejectedExecutionException unused) {
                        }
                    } catch (RejectedExecutionException unused2) {
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void pushResetLater(int i4, ErrorCode errorCode) {
        final int i5 = i4;
        final ErrorCode errorCode2 = errorCode;
        pushExecutorExecute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostname, Integer.valueOf(i4)}) {
            public void execute() {
                Http2Connection.this.pushObserver.onReset(i5, errorCode2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.currentPushRequests.remove(Integer.valueOf(i5));
                }
            }
        });
    }

    public Http2Stream pushStream(int i4, List<Header> list, boolean z4) throws IOException {
        if (!this.client) {
            return newStream(i4, list, z4);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    /* access modifiers changed from: package-private */
    public boolean pushedStream(int i4) {
        return i4 != 0 && (i4 & 1) == 0;
    }

    /* access modifiers changed from: package-private */
    public synchronized Http2Stream removeStream(int i4) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i4));
        notifyAll();
        return remove;
    }

    /* access modifiers changed from: package-private */
    public void sendDegradedPingLater() {
        synchronized (this) {
            try {
                long j4 = this.degradedPongsReceived;
                long j5 = this.degradedPingsSent;
                if (j4 >= j5) {
                    this.degradedPingsSent = j5 + 1;
                    this.degradedPongDeadlineNs = System.nanoTime() + 1000000000;
                    try {
                        this.writerExecutor.execute(new NamedRunnable("OkHttp %s ping", this.hostname) {
                            public void execute() {
                                Http2Connection.this.writePing(false, 2, 0);
                            }
                        });
                    } catch (RejectedExecutionException unused) {
                    }
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.okHttpSettings.merge(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.settings(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.shutdown) {
                    this.shutdown = true;
                    int i4 = this.lastGoodStreamId;
                    this.writer.goAway(i4, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void start() throws IOException {
        start(true);
    }

    /* access modifiers changed from: package-private */
    public synchronized void updateConnectionFlowControl(long j4) {
        long j5 = this.unacknowledgedBytesRead + j4;
        this.unacknowledgedBytesRead = j5;
        if (j5 >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater(0, this.unacknowledgedBytesRead);
            this.unacknowledgedBytesRead = 0;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.writer.maxDataLength());
        r6 = (long) r3;
        r8.bytesLeftInWriteWindow -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0058 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeData(int r9, boolean r10, com.mbridge.msdk.thrid.okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0067
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.bytesLeftInWriteWindow     // Catch:{ InterruptedException -> 0x0058 }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0032
            java.util.Map<java.lang.Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream> r3 = r8.streams     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x0058 }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x0058 }
            if (r3 == 0) goto L_0x002a
            r8.wait()     // Catch:{ InterruptedException -> 0x0058 }
            goto L_0x0012
        L_0x0028:
            r9 = move-exception
            goto L_0x0065
        L_0x002a:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x0058 }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x0058 }
            throw r9     // Catch:{ InterruptedException -> 0x0058 }
        L_0x0032:
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0028 }
            int r4 = (int) r3     // Catch:{ all -> 0x0028 }
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r3 = r8.writer     // Catch:{ all -> 0x0028 }
            int r3 = r3.maxDataLength()     // Catch:{ all -> 0x0028 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0028 }
            long r4 = r8.bytesLeftInWriteWindow     // Catch:{ all -> 0x0028 }
            long r6 = (long) r3     // Catch:{ all -> 0x0028 }
            long r4 = r4 - r6
            r8.bytesLeftInWriteWindow = r4     // Catch:{ all -> 0x0028 }
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            long r12 = r12 - r6
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            r4.data(r5, r9, r11, r3)
            goto L_0x000d
        L_0x0058:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0028 }
            r9.interrupt()     // Catch:{ all -> 0x0028 }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0028 }
            r9.<init>()     // Catch:{ all -> 0x0028 }
            throw r9     // Catch:{ all -> 0x0028 }
        L_0x0065:
            monitor-exit(r8)     // Catch:{ all -> 0x0028 }
            throw r9
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.writeData(int, boolean, com.mbridge.msdk.thrid.okio.Buffer, long):void");
    }

    /* access modifiers changed from: package-private */
    public void writePing(boolean z4, int i4, int i5) {
        try {
            this.writer.ping(z4, i4, i5);
        } catch (IOException unused) {
            failConnection();
        }
    }

    /* access modifiers changed from: package-private */
    public void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    /* access modifiers changed from: package-private */
    public void writeSynReply(int i4, boolean z4, List<Header> list) throws IOException {
        this.writer.synReply(z4, i4, list);
    }

    /* access modifiers changed from: package-private */
    public void writeSynReset(int i4, ErrorCode errorCode) throws IOException {
        this.writer.rstStream(i4, errorCode);
    }

    /* access modifiers changed from: package-private */
    public void writeSynResetLater(int i4, ErrorCode errorCode) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.writerExecutor;
            final ErrorCode errorCode2 = errorCode;
            Object[] objArr = {this.hostname, Integer.valueOf(i4)};
            final int i5 = i4;
            scheduledExecutorService.execute(new NamedRunnable("OkHttp %s stream %d", objArr) {
                public void execute() {
                    try {
                        Http2Connection.this.writeSynReset(i5, errorCode2);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void writeWindowUpdateLater(int i4, long j4) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.writerExecutor;
            final long j5 = j4;
            Object[] objArr = {this.hostname, Integer.valueOf(i4)};
            final int i5 = i4;
            scheduledExecutorService.execute(new NamedRunnable("OkHttp Window Update %s stream %d", objArr) {
                public void execute() {
                    try {
                        Http2Connection.this.writer.windowUpdate(i5, j5);
                    } catch (IOException unused) {
                        Http2Connection.this.failConnection();
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    private com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream newStream(int r10, java.util.List<com.mbridge.msdk.thrid.okhttp.internal.http2.Header> r11, boolean r12) throws java.io.IOException {
        /*
            r9 = this;
            r3 = r12 ^ 1
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r6 = r9.writer
            monitor-enter(r6)
            monitor-enter(r9)     // Catch:{ all -> 0x0082 }
            int r0 = r9.nextStreamId     // Catch:{ all -> 0x0076 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0018
            com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode r0 = com.mbridge.msdk.thrid.okhttp.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0013 }
            r9.shutdown(r0)     // Catch:{ all -> 0x0013 }
            goto L_0x0018
        L_0x0013:
            r0 = move-exception
            r10 = r0
            r2 = r9
            goto L_0x0080
        L_0x0018:
            boolean r0 = r9.shutdown     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0079
            int r1 = r9.nextStreamId     // Catch:{ all -> 0x0076 }
            int r0 = r1 + 2
            r9.nextStreamId = r0     // Catch:{ all -> 0x0076 }
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream r0 = new com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream     // Catch:{ all -> 0x0076 }
            r5 = 0
            r4 = 0
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x003d }
            if (r12 == 0) goto L_0x0040
            long r4 = r2.bytesLeftInWriteWindow     // Catch:{ all -> 0x003d }
            r7 = 0
            int r12 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r12 == 0) goto L_0x0040
            long r4 = r0.bytesLeftInWriteWindow     // Catch:{ all -> 0x003d }
            int r12 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x003b
            goto L_0x0040
        L_0x003b:
            r12 = 0
            goto L_0x0041
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            r10 = r0
            goto L_0x0080
        L_0x0040:
            r12 = 1
        L_0x0041:
            boolean r4 = r0.isOpen()     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x0050
            java.util.Map<java.lang.Integer, com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream> r4 = r2.streams     // Catch:{ all -> 0x003d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x003d }
            r4.put(r5, r0)     // Catch:{ all -> 0x003d }
        L_0x0050:
            monitor-exit(r9)     // Catch:{ all -> 0x003d }
            if (r10 != 0) goto L_0x005c
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r4 = r2.writer     // Catch:{ all -> 0x0059 }
            r4.synStream(r3, r1, r10, r11)     // Catch:{ all -> 0x0059 }
            goto L_0x0065
        L_0x0059:
            r0 = move-exception
        L_0x005a:
            r10 = r0
            goto L_0x0085
        L_0x005c:
            boolean r3 = r2.client     // Catch:{ all -> 0x0059 }
            if (r3 != 0) goto L_0x006e
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r3 = r2.writer     // Catch:{ all -> 0x0059 }
            r3.pushPromise(r10, r1, r11)     // Catch:{ all -> 0x0059 }
        L_0x0065:
            monitor-exit(r6)     // Catch:{ all -> 0x0059 }
            if (r12 == 0) goto L_0x006d
            com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Writer r10 = r2.writer
            r10.flush()
        L_0x006d:
            return r0
        L_0x006e:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            r10.<init>(r11)     // Catch:{ all -> 0x0059 }
            throw r10     // Catch:{ all -> 0x0059 }
        L_0x0076:
            r0 = move-exception
            r2 = r9
            goto L_0x003e
        L_0x0079:
            r2 = r9
            com.mbridge.msdk.thrid.okhttp.internal.http2.ConnectionShutdownException r10 = new com.mbridge.msdk.thrid.okhttp.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x003d }
            r10.<init>()     // Catch:{ all -> 0x003d }
            throw r10     // Catch:{ all -> 0x003d }
        L_0x0080:
            monitor-exit(r9)     // Catch:{ all -> 0x003d }
            throw r10     // Catch:{ all -> 0x0059 }
        L_0x0082:
            r0 = move-exception
            r2 = r9
            goto L_0x005a
        L_0x0085:
            monitor-exit(r6)     // Catch:{ all -> 0x0059 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):com.mbridge.msdk.thrid.okhttp.internal.http2.Http2Stream");
    }

    /* access modifiers changed from: package-private */
    public void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Http2Stream[] http2StreamArr = null;
        try {
            shutdown(errorCode);
            e = null;
        } catch (IOException e5) {
            e = e5;
        }
        synchronized (this) {
            try {
                if (!this.streams.isEmpty()) {
                    http2StreamArr = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);
                    this.streams.clear();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (http2StreamArr != null) {
            for (Http2Stream close : http2StreamArr) {
                try {
                    close.close(errorCode2);
                } catch (IOException e6) {
                    if (e != null) {
                        e = e6;
                    }
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException e7) {
            if (e == null) {
                e = e7;
            }
        }
        try {
            this.socket.close();
        } catch (IOException e8) {
            e = e8;
        }
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public void start(boolean z4) throws IOException {
        if (z4) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, (long) (initialWindowSize - 65535));
            }
        }
        new Thread(this.readerRunnable).start();
    }

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        int pingIntervalMillis;
        PushObserver pushObserver = PushObserver.CANCEL;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder(boolean z4) {
            this.client = z4;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder pingIntervalMillis(int i4) {
            this.pingIntervalMillis = i4;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Builder socket(Socket socket2) throws IOException {
            return socket(socket2, ((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket2)), Okio.buffer(Okio.sink(socket2)));
        }

        public Builder socket(Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket2;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public void writePing() {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }
}
