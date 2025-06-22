package com.mbridge.msdk.thrid.okhttp.internal.ws;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Callback;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.WebSocket;
import com.mbridge.msdk.thrid.okhttp.WebSocketListener;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.connection.StreamAllocation;
import com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketReader;
import com.mbridge.msdk.thrid.okio.BufferedSink;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue = new ArrayDeque<>();
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue = new ArrayDeque<>();
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;

    final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        Close(int i4, ByteString byteString, long j4) {
            this.code = i4;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j4;
        }
    }

    static final class Message {
        final ByteString data;
        final int formatOpcode;

        Message(int i4, ByteString byteString) {
            this.formatOpcode = i4;
            this.data = byteString;
        }
    }

    private final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        public void run() {
            RealWebSocket.this.writePingFrame();
        }
    }

    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public Streams(boolean z4, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.client = z4;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random2, long j4) {
        if (ShareTarget.METHOD_GET.equals(request.method())) {
            this.originalRequest = request;
            this.listener = webSocketListener;
            this.random = random2;
            this.pingIntervalMillis = j4;
            byte[] bArr = new byte[16];
            random2.nextBytes(bArr);
            this.key = ByteString.of(bArr).base64();
            this.writerRunnable = new Runnable() {
                public void run() {
                    do {
                        try {
                        } catch (IOException e5) {
                            RealWebSocket.this.failWebSocket(e5, (Response) null);
                            return;
                        }
                    } while (RealWebSocket.this.writeOneFrame());
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }

    private void runWriter() {
        ScheduledExecutorService scheduledExecutorService = this.executor;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.writerRunnable);
        }
    }

    /* access modifiers changed from: package-private */
    public void awaitTermination(int i4, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination((long) i4, timeUnit);
    }

    public void cancel() {
        this.call.cancel();
    }

    /* access modifiers changed from: package-private */
    public void checkResponse(Response response) throws ProtocolException {
        if (response.code() == 101) {
            String header = response.header("Connection");
            if ("Upgrade".equalsIgnoreCase(header)) {
                String header2 = response.header("Upgrade");
                if ("websocket".equalsIgnoreCase(header2)) {
                    String header3 = response.header("Sec-WebSocket-Accept");
                    String base64 = ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
                    if (!base64.equals(header3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
                    }
                    return;
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
    }

    public boolean close(int i4, String str) {
        return close(i4, str, 60000);
    }

    public void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request build2 = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        Call newWebSocketCall = Internal.instance.newWebSocketCall(build, build2);
        this.call = newWebSocketCall;
        newWebSocketCall.timeout().clearTimeout();
        this.call.enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, (Response) null);
            }

            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.checkResponse(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        realWebSocket.listener.onOpen(realWebSocket, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e5) {
                        RealWebSocket.this.failWebSocket(e5, (Response) null);
                    }
                } catch (ProtocolException e6) {
                    RealWebSocket.this.failWebSocket(e6, response);
                    Util.closeQuietly((Closeable) response);
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.listener.onFailure(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002b, code lost:
        com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void failWebSocket(java.lang.Exception r4, com.mbridge.msdk.thrid.okhttp.Response r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.failed     // Catch:{ all -> 0x0007 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            return
        L_0x0007:
            r4 = move-exception
            goto L_0x002f
        L_0x0009:
            r0 = 1
            r3.failed = r0     // Catch:{ all -> 0x0007 }
            com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$Streams r0 = r3.streams     // Catch:{ all -> 0x0007 }
            r1 = 0
            r3.streams = r1     // Catch:{ all -> 0x0007 }
            java.util.concurrent.ScheduledFuture<?> r1 = r3.cancelFuture     // Catch:{ all -> 0x0007 }
            if (r1 == 0) goto L_0x0019
            r2 = 0
            r1.cancel(r2)     // Catch:{ all -> 0x0007 }
        L_0x0019:
            java.util.concurrent.ScheduledExecutorService r1 = r3.executor     // Catch:{ all -> 0x0007 }
            if (r1 == 0) goto L_0x0020
            r1.shutdown()     // Catch:{ all -> 0x0007 }
        L_0x0020:
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            com.mbridge.msdk.thrid.okhttp.WebSocketListener r1 = r3.listener     // Catch:{ all -> 0x002a }
            r1.onFailure(r3, r4, r5)     // Catch:{ all -> 0x002a }
            com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r0)
            return
        L_0x002a:
            r4 = move-exception
            com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r0)
            throw r4
        L_0x002f:
            monitor-exit(r3)     // Catch:{ all -> 0x0007 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.failWebSocket(java.lang.Exception, com.mbridge.msdk.thrid.okhttp.Response):void");
    }

    public void initReaderAndWriter(String str, Streams streams2) throws IOException {
        synchronized (this) {
            try {
                this.streams = streams2;
                this.writer = new WebSocketWriter(streams2.client, streams2.sink, this.random);
                ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
                this.executor = scheduledThreadPoolExecutor;
                if (this.pingIntervalMillis != 0) {
                    PingRunnable pingRunnable = new PingRunnable();
                    long j4 = this.pingIntervalMillis;
                    scheduledThreadPoolExecutor.scheduleAtFixedRate(pingRunnable, j4, j4, TimeUnit.MILLISECONDS);
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.reader = new WebSocketReader(streams2.client, streams2.source, this);
    }

    public void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    public void onReadClose(int i4, String str) {
        Streams streams2;
        if (i4 != -1) {
            synchronized (this) {
                try {
                    if (this.receivedCloseCode == -1) {
                        this.receivedCloseCode = i4;
                        this.receivedCloseReason = str;
                        streams2 = null;
                        if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                            Streams streams3 = this.streams;
                            this.streams = streams2;
                            ScheduledFuture<?> scheduledFuture = this.cancelFuture;
                            if (scheduledFuture != null) {
                                scheduledFuture.cancel(false);
                            }
                            this.executor.shutdown();
                            streams2 = streams3;
                        }
                    } else {
                        throw new IllegalStateException("already closed");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                this.listener.onClosing(this, i4, str);
                if (streams2 != null) {
                    this.listener.onClosed(this, i4, str);
                }
            } finally {
                Util.closeQuietly((Closeable) streams2);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void onReadMessage(String str) throws IOException {
        this.listener.onMessage((WebSocket) this, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(com.mbridge.msdk.thrid.okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.failed     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x0024
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0012 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            goto L_0x0024
        L_0x0012:
            r2 = move-exception
            goto L_0x0026
        L_0x0014:
            java.util.ArrayDeque<com.mbridge.msdk.thrid.okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0012 }
            r0.add(r2)     // Catch:{ all -> 0x0012 }
            r1.runWriter()     // Catch:{ all -> 0x0012 }
            int r2 = r1.receivedPingCount     // Catch:{ all -> 0x0012 }
            int r2 = r2 + 1
            r1.receivedPingCount = r2     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)
            return
        L_0x0024:
            monitor-exit(r1)
            return
        L_0x0026:
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.onReadPing(com.mbridge.msdk.thrid.okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString byteString) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0020, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean pong(com.mbridge.msdk.thrid.okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.failed     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x001f
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0012 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x0014
            goto L_0x001f
        L_0x0012:
            r2 = move-exception
            goto L_0x0022
        L_0x0014:
            java.util.ArrayDeque<com.mbridge.msdk.thrid.okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0012 }
            r0.add(r2)     // Catch:{ all -> 0x0012 }
            r1.runWriter()     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)
            r2 = 1
            return r2
        L_0x001f:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x0022:
            monitor-exit(r1)     // Catch:{ all -> 0x0012 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.pong(com.mbridge.msdk.thrid.okio.ByteString):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean processNextFrame() throws IOException {
        try {
            this.reader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                return true;
            }
            return false;
        } catch (Exception e5) {
            failWebSocket(e5, (Response) null);
            return false;
        }
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    /* access modifiers changed from: package-private */
    public synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    /* access modifiers changed from: package-private */
    public synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public Request request() {
        return this.originalRequest;
    }

    public boolean send(String str) {
        if (str != null) {
            return send(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    /* access modifiers changed from: package-private */
    public synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    /* access modifiers changed from: package-private */
    public void tearDown() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.cancelFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.executor.shutdown();
        this.executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r2 == null) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r0.writePong(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0061, code lost:
        if ((r3 instanceof com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Message) == false) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        r1 = ((com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Message) r3).data;
        r0 = com.mbridge.msdk.thrid.okio.Okio.buffer(r0.newMessageSink(((com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Message) r3).formatOpcode, (long) r1.size()));
        r0.write(r1);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        monitor-enter(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r11.queueSize -= (long) r1.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        monitor-exit(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0091, code lost:
        if ((r3 instanceof com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Close) == false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0093, code lost:
        r3 = (com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Close) r3;
        r0.writeClose(r3.code, r3.reason);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009c, code lost:
        if (r4 == null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009e, code lost:
        r11.listener.onClosed(r11, r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a3, code lost:
        com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a7, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ad, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ae, code lost:
        com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b1, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean writeOneFrame() throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = r11.failed     // Catch:{ all -> 0x0008 }
            r1 = 0
            if (r0 == 0) goto L_0x000b
            monitor-exit(r11)     // Catch:{ all -> 0x0008 }
            return r1
        L_0x0008:
            r0 = move-exception
            goto L_0x00b2
        L_0x000b:
            com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketWriter r0 = r11.writer     // Catch:{ all -> 0x0008 }
            java.util.ArrayDeque<com.mbridge.msdk.thrid.okio.ByteString> r2 = r11.pongQueue     // Catch:{ all -> 0x0008 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x0008 }
            com.mbridge.msdk.thrid.okio.ByteString r2 = (com.mbridge.msdk.thrid.okio.ByteString) r2     // Catch:{ all -> 0x0008 }
            r3 = 0
            r4 = -1
            if (r2 != 0) goto L_0x0053
            java.util.ArrayDeque<java.lang.Object> r5 = r11.messageAndCloseQueue     // Catch:{ all -> 0x0008 }
            java.lang.Object r5 = r5.poll()     // Catch:{ all -> 0x0008 }
            boolean r6 = r5 instanceof com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x0008 }
            if (r6 == 0) goto L_0x004a
            int r1 = r11.receivedCloseCode     // Catch:{ all -> 0x0008 }
            java.lang.String r6 = r11.receivedCloseReason     // Catch:{ all -> 0x0008 }
            if (r1 == r4) goto L_0x0034
            com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$Streams r4 = r11.streams     // Catch:{ all -> 0x0008 }
            r11.streams = r3     // Catch:{ all -> 0x0008 }
            java.util.concurrent.ScheduledExecutorService r3 = r11.executor     // Catch:{ all -> 0x0008 }
            r3.shutdown()     // Catch:{ all -> 0x0008 }
        L_0x0032:
            r3 = r5
            goto L_0x0056
        L_0x0034:
            java.util.concurrent.ScheduledExecutorService r4 = r11.executor     // Catch:{ all -> 0x0008 }
            com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$CancelRunnable r7 = new com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$CancelRunnable     // Catch:{ all -> 0x0008 }
            r7.<init>()     // Catch:{ all -> 0x0008 }
            r8 = r5
            com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$Close r8 = (com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Close) r8     // Catch:{ all -> 0x0008 }
            long r8 = r8.cancelAfterCloseMillis     // Catch:{ all -> 0x0008 }
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0008 }
            java.util.concurrent.ScheduledFuture r4 = r4.schedule(r7, r8, r10)     // Catch:{ all -> 0x0008 }
            r11.cancelFuture = r4     // Catch:{ all -> 0x0008 }
            r4 = r3
            goto L_0x0032
        L_0x004a:
            if (r5 != 0) goto L_0x004e
            monitor-exit(r11)     // Catch:{ all -> 0x0008 }
            return r1
        L_0x004e:
            r4 = r3
            r6 = r4
            r3 = r5
        L_0x0051:
            r1 = -1
            goto L_0x0056
        L_0x0053:
            r4 = r3
            r6 = r4
            goto L_0x0051
        L_0x0056:
            monitor-exit(r11)     // Catch:{ all -> 0x0008 }
            if (r2 == 0) goto L_0x005f
            r0.writePong(r2)     // Catch:{ all -> 0x005d }
            goto L_0x00a3
        L_0x005d:
            r0 = move-exception
            goto L_0x00ae
        L_0x005f:
            boolean r2 = r3 instanceof com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Message     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x008f
            r1 = r3
            com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$Message r1 = (com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Message) r1     // Catch:{ all -> 0x005d }
            com.mbridge.msdk.thrid.okio.ByteString r1 = r1.data     // Catch:{ all -> 0x005d }
            com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$Message r3 = (com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Message) r3     // Catch:{ all -> 0x005d }
            int r2 = r3.formatOpcode     // Catch:{ all -> 0x005d }
            int r3 = r1.size()     // Catch:{ all -> 0x005d }
            long r5 = (long) r3     // Catch:{ all -> 0x005d }
            com.mbridge.msdk.thrid.okio.Sink r0 = r0.newMessageSink(r2, r5)     // Catch:{ all -> 0x005d }
            com.mbridge.msdk.thrid.okio.BufferedSink r0 = com.mbridge.msdk.thrid.okio.Okio.buffer((com.mbridge.msdk.thrid.okio.Sink) r0)     // Catch:{ all -> 0x005d }
            r0.write((com.mbridge.msdk.thrid.okio.ByteString) r1)     // Catch:{ all -> 0x005d }
            r0.close()     // Catch:{ all -> 0x005d }
            monitor-enter(r11)     // Catch:{ all -> 0x005d }
            long r2 = r11.queueSize     // Catch:{ all -> 0x008c }
            int r0 = r1.size()     // Catch:{ all -> 0x008c }
            long r0 = (long) r0     // Catch:{ all -> 0x008c }
            long r2 = r2 - r0
            r11.queueSize = r2     // Catch:{ all -> 0x008c }
            monitor-exit(r11)     // Catch:{ all -> 0x008c }
            goto L_0x00a3
        L_0x008c:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x008c }
            throw r0     // Catch:{ all -> 0x005d }
        L_0x008f:
            boolean r2 = r3 instanceof com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x00a8
            com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$Close r3 = (com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.Close) r3     // Catch:{ all -> 0x005d }
            int r2 = r3.code     // Catch:{ all -> 0x005d }
            com.mbridge.msdk.thrid.okio.ByteString r3 = r3.reason     // Catch:{ all -> 0x005d }
            r0.writeClose(r2, r3)     // Catch:{ all -> 0x005d }
            if (r4 == 0) goto L_0x00a3
            com.mbridge.msdk.thrid.okhttp.WebSocketListener r0 = r11.listener     // Catch:{ all -> 0x005d }
            r0.onClosed(r11, r1, r6)     // Catch:{ all -> 0x005d }
        L_0x00a3:
            com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r4)
            r0 = 1
            return r0
        L_0x00a8:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x005d }
            r0.<init>()     // Catch:{ all -> 0x005d }
            throw r0     // Catch:{ all -> 0x005d }
        L_0x00ae:
            com.mbridge.msdk.thrid.okhttp.internal.Util.closeQuietly((java.io.Closeable) r4)
            throw r0
        L_0x00b2:
            monitor-exit(r11)     // Catch:{ all -> 0x0008 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.writeOneFrame():boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001e, code lost:
        if (r1 == -1) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), (com.mbridge.msdk.thrid.okhttp.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.writePing(com.mbridge.msdk.thrid.okio.ByteString.EMPTY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        failWebSocket(r0, (com.mbridge.msdk.thrid.okhttp.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0054, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writePingFrame() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.failed     // Catch:{ all -> 0x0007 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r7)     // Catch:{ all -> 0x0007 }
            return
        L_0x0007:
            r0 = move-exception
            goto L_0x0055
        L_0x0009:
            com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketWriter r0 = r7.writer     // Catch:{ all -> 0x0007 }
            boolean r1 = r7.awaitingPong     // Catch:{ all -> 0x0007 }
            r2 = -1
            if (r1 == 0) goto L_0x0013
            int r1 = r7.sentPingCount     // Catch:{ all -> 0x0007 }
            goto L_0x0014
        L_0x0013:
            r1 = -1
        L_0x0014:
            int r3 = r7.sentPingCount     // Catch:{ all -> 0x0007 }
            r4 = 1
            int r3 = r3 + r4
            r7.sentPingCount = r3     // Catch:{ all -> 0x0007 }
            r7.awaitingPong = r4     // Catch:{ all -> 0x0007 }
            monitor-exit(r7)     // Catch:{ all -> 0x0007 }
            r3 = 0
            if (r1 == r2) goto L_0x004a
            java.net.SocketTimeoutException r0 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "sent ping but didn't receive pong within "
            r2.append(r5)
            long r5 = r7.pingIntervalMillis
            r2.append(r5)
            java.lang.String r5 = "ms (after "
            r2.append(r5)
            int r1 = r1 - r4
            r2.append(r1)
            java.lang.String r1 = " successful ping/pongs)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            r7.failWebSocket(r0, r3)
            return
        L_0x004a:
            com.mbridge.msdk.thrid.okio.ByteString r1 = com.mbridge.msdk.thrid.okio.ByteString.EMPTY     // Catch:{ IOException -> 0x0050 }
            r0.writePing(r1)     // Catch:{ IOException -> 0x0050 }
            return
        L_0x0050:
            r0 = move-exception
            r7.failWebSocket(r0, r3)
            return
        L_0x0055:
            monitor-exit(r7)     // Catch:{ all -> 0x0007 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.writePingFrame():void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean close(int r7, java.lang.String r8, long r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            com.mbridge.msdk.thrid.okhttp.internal.ws.WebSocketProtocol.validateCloseCode(r7)     // Catch:{ all -> 0x002d }
            if (r8 == 0) goto L_0x002f
            com.mbridge.msdk.thrid.okio.ByteString r0 = com.mbridge.msdk.thrid.okio.ByteString.encodeUtf8(r8)     // Catch:{ all -> 0x002d }
            int r1 = r0.size()     // Catch:{ all -> 0x002d }
            long r1 = (long) r1     // Catch:{ all -> 0x002d }
            r3 = 123(0x7b, double:6.1E-322)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0016
            goto L_0x0030
        L_0x0016:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x002d }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            r9.<init>()     // Catch:{ all -> 0x002d }
            java.lang.String r10 = "reason.size() > 123: "
            r9.append(r10)     // Catch:{ all -> 0x002d }
            r9.append(r8)     // Catch:{ all -> 0x002d }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x002d }
            r7.<init>(r8)     // Catch:{ all -> 0x002d }
            throw r7     // Catch:{ all -> 0x002d }
        L_0x002d:
            r7 = move-exception
            goto L_0x004e
        L_0x002f:
            r0 = 0
        L_0x0030:
            boolean r8 = r6.failed     // Catch:{ all -> 0x002d }
            if (r8 != 0) goto L_0x004b
            boolean r8 = r6.enqueuedClose     // Catch:{ all -> 0x002d }
            if (r8 == 0) goto L_0x0039
            goto L_0x004b
        L_0x0039:
            r8 = 1
            r6.enqueuedClose = r8     // Catch:{ all -> 0x002d }
            java.util.ArrayDeque<java.lang.Object> r1 = r6.messageAndCloseQueue     // Catch:{ all -> 0x002d }
            com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$Close r2 = new com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$Close     // Catch:{ all -> 0x002d }
            r2.<init>(r7, r0, r9)     // Catch:{ all -> 0x002d }
            r1.add(r2)     // Catch:{ all -> 0x002d }
            r6.runWriter()     // Catch:{ all -> 0x002d }
            monitor-exit(r6)
            return r8
        L_0x004b:
            monitor-exit(r6)
            r7 = 0
            return r7
        L_0x004e:
            monitor-exit(r6)     // Catch:{ all -> 0x002d }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.close(int, java.lang.String, long):boolean");
    }

    public void onReadMessage(ByteString byteString) throws IOException {
        this.listener.onMessage((WebSocket) this, byteString);
    }

    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return send(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean send(com.mbridge.msdk.thrid.okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.failed     // Catch:{ all -> 0x0022 }
            r1 = 0
            if (r0 != 0) goto L_0x003e
            boolean r0 = r6.enqueuedClose     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x000b
            goto L_0x003e
        L_0x000b:
            long r2 = r6.queueSize     // Catch:{ all -> 0x0022 }
            int r0 = r7.size()     // Catch:{ all -> 0x0022 }
            long r4 = (long) r0     // Catch:{ all -> 0x0022 }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0024
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.close(r7, r8)     // Catch:{ all -> 0x0022 }
            monitor-exit(r6)
            return r1
        L_0x0022:
            r7 = move-exception
            goto L_0x0040
        L_0x0024:
            long r0 = r6.queueSize     // Catch:{ all -> 0x0022 }
            int r2 = r7.size()     // Catch:{ all -> 0x0022 }
            long r2 = (long) r2     // Catch:{ all -> 0x0022 }
            long r0 = r0 + r2
            r6.queueSize = r0     // Catch:{ all -> 0x0022 }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.messageAndCloseQueue     // Catch:{ all -> 0x0022 }
            com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$Message r1 = new com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x0022 }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x0022 }
            r0.add(r1)     // Catch:{ all -> 0x0022 }
            r6.runWriter()     // Catch:{ all -> 0x0022 }
            monitor-exit(r6)
            r7 = 1
            return r7
        L_0x003e:
            monitor-exit(r6)
            return r1
        L_0x0040:
            monitor-exit(r6)     // Catch:{ all -> 0x0022 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.ws.RealWebSocket.send(com.mbridge.msdk.thrid.okio.ByteString, int):boolean");
    }
}
