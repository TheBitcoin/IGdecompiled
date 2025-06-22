package com.mbridge.msdk.playercommon.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.source.MediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSpec;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public interface MediaSourceEventListener {

    public static final class EventDispatcher {
        private final CopyOnWriteArrayList<ListenerAndHandler> listenerAndHandlers;
        @Nullable
        public final MediaSource.MediaPeriodId mediaPeriodId;
        private final long mediaTimeOffsetMs;
        public final int windowIndex;

        private static final class ListenerAndHandler {
            public final Handler handler;
            public final MediaSourceEventListener listener;

            public ListenerAndHandler(Handler handler2, MediaSourceEventListener mediaSourceEventListener) {
                this.handler = handler2;
                this.listener = mediaSourceEventListener;
            }
        }

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, (MediaSource.MediaPeriodId) null, 0);
        }

        private long adjustMediaTime(long j4) {
            long usToMs = C.usToMs(j4);
            if (usToMs == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            return this.mediaTimeOffsetMs + usToMs;
        }

        private void postOrRun(Handler handler, Runnable runnable) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }

        public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            boolean z4;
            if (handler == null || mediaSourceEventListener == null) {
                z4 = false;
            } else {
                z4 = true;
            }
            Assertions.checkArgument(z4);
            this.listenerAndHandlers.add(new ListenerAndHandler(handler, mediaSourceEventListener));
        }

        public final void downstreamFormatChanged(int i4, @Nullable Format format, int i5, @Nullable Object obj, long j4) {
            downstreamFormatChanged(new MediaLoadData(1, i4, format, i5, obj, adjustMediaTime(j4), C.TIME_UNSET));
        }

        public final void loadCanceled(DataSpec dataSpec, int i4, long j4, long j5, long j6) {
            loadCanceled(dataSpec, i4, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET, j4, j5, j6);
        }

        public final void loadCompleted(DataSpec dataSpec, int i4, long j4, long j5, long j6) {
            loadCompleted(dataSpec, i4, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET, j4, j5, j6);
        }

        public final void loadError(DataSpec dataSpec, int i4, long j4, long j5, long j6, IOException iOException, boolean z4) {
            loadError(dataSpec, i4, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET, j4, j5, j6, iOException, z4);
        }

        public final void loadStarted(DataSpec dataSpec, int i4, long j4) {
            loadStarted(dataSpec, i4, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET, j4);
        }

        public final void mediaPeriodCreated() {
            boolean z4;
            if (this.mediaPeriodId != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkState(z4);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onMediaPeriodCreated(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId);
                    }
                });
            }
        }

        public final void mediaPeriodReleased() {
            boolean z4;
            if (this.mediaPeriodId != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkState(z4);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onMediaPeriodReleased(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId);
                    }
                });
            }
        }

        public final void readingStarted() {
            boolean z4;
            if (this.mediaPeriodId != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkState(z4);
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onReadingStarted(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId);
                    }
                });
            }
        }

        public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                if (next.listener == mediaSourceEventListener) {
                    this.listenerAndHandlers.remove(next);
                }
            }
        }

        public final void upstreamDiscarded(int i4, long j4, long j5) {
            upstreamDiscarded(new MediaLoadData(1, i4, (Format) null, 3, (Object) null, adjustMediaTime(j4), adjustMediaTime(j5)));
        }

        @CheckResult
        public final EventDispatcher withParameters(int i4, @Nullable MediaSource.MediaPeriodId mediaPeriodId2, long j4) {
            return new EventDispatcher(this.listenerAndHandlers, i4, mediaPeriodId2, j4);
        }

        private EventDispatcher(CopyOnWriteArrayList<ListenerAndHandler> copyOnWriteArrayList, int i4, @Nullable MediaSource.MediaPeriodId mediaPeriodId2, long j4) {
            this.listenerAndHandlers = copyOnWriteArrayList;
            this.windowIndex = i4;
            this.mediaPeriodId = mediaPeriodId2;
            this.mediaTimeOffsetMs = j4;
        }

        public final void loadCanceled(DataSpec dataSpec, int i4, int i5, @Nullable Format format, int i6, @Nullable Object obj, long j4, long j5, long j6, long j7, long j8) {
            loadCanceled(new LoadEventInfo(dataSpec, j6, j7, j8), new MediaLoadData(i4, i5, format, i6, obj, adjustMediaTime(j4), adjustMediaTime(j5)));
        }

        public final void loadCompleted(DataSpec dataSpec, int i4, int i5, @Nullable Format format, int i6, @Nullable Object obj, long j4, long j5, long j6, long j7, long j8) {
            loadCompleted(new LoadEventInfo(dataSpec, j6, j7, j8), new MediaLoadData(i4, i5, format, i6, obj, adjustMediaTime(j4), adjustMediaTime(j5)));
        }

        public final void loadError(DataSpec dataSpec, int i4, int i5, @Nullable Format format, int i6, @Nullable Object obj, long j4, long j5, long j6, long j7, long j8, IOException iOException, boolean z4) {
            loadError(new LoadEventInfo(dataSpec, j6, j7, j8), new MediaLoadData(i4, i5, format, i6, obj, adjustMediaTime(j4), adjustMediaTime(j5)), iOException, z4);
        }

        public final void loadStarted(DataSpec dataSpec, int i4, int i5, @Nullable Format format, int i6, @Nullable Object obj, long j4, long j5, long j6) {
            loadStarted(new LoadEventInfo(dataSpec, j6, 0, 0), new MediaLoadData(i4, i5, format, i6, obj, adjustMediaTime(j4), adjustMediaTime(j5)));
        }

        public final void downstreamFormatChanged(final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onDownstreamFormatChanged(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, mediaLoadData);
                    }
                });
            }
        }

        public final void upstreamDiscarded(final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onUpstreamDiscarded(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, mediaLoadData);
                    }
                });
            }
        }

        public final void loadCanceled(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onLoadCanceled(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        public final void loadCompleted(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onLoadCompleted(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }

        public final void loadError(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z4) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                final LoadEventInfo loadEventInfo2 = loadEventInfo;
                final MediaLoadData mediaLoadData2 = mediaLoadData;
                final IOException iOException2 = iOException;
                final boolean z5 = z4;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onLoadError(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, loadEventInfo2, mediaLoadData2, iOException2, z5);
                    }
                });
            }
        }

        public final void loadStarted(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
            Iterator<ListenerAndHandler> it = this.listenerAndHandlers.iterator();
            while (it.hasNext()) {
                ListenerAndHandler next = it.next();
                final MediaSourceEventListener mediaSourceEventListener = next.listener;
                postOrRun(next.handler, new Runnable() {
                    public void run() {
                        MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener;
                        EventDispatcher eventDispatcher = EventDispatcher.this;
                        mediaSourceEventListener.onLoadStarted(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, loadEventInfo, mediaLoadData);
                    }
                });
            }
        }
    }

    public static final class LoadEventInfo {
        public final long bytesLoaded;
        public final DataSpec dataSpec;
        public final long elapsedRealtimeMs;
        public final long loadDurationMs;

        public LoadEventInfo(DataSpec dataSpec2, long j4, long j5, long j6) {
            this.dataSpec = dataSpec2;
            this.elapsedRealtimeMs = j4;
            this.loadDurationMs = j5;
            this.bytesLoaded = j6;
        }
    }

    public static final class MediaLoadData {
        public final int dataType;
        public final long mediaEndTimeMs;
        public final long mediaStartTimeMs;
        @Nullable
        public final Format trackFormat;
        @Nullable
        public final Object trackSelectionData;
        public final int trackSelectionReason;
        public final int trackType;

        public MediaLoadData(int i4, int i5, @Nullable Format format, int i6, @Nullable Object obj, long j4, long j5) {
            this.dataType = i4;
            this.trackType = i5;
            this.trackFormat = format;
            this.trackSelectionReason = i6;
            this.trackSelectionData = obj;
            this.mediaStartTimeMs = j4;
            this.mediaEndTimeMs = j5;
        }
    }

    void onDownstreamFormatChanged(int i4, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void onLoadCanceled(int i4, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadCompleted(int i4, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadError(int i4, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z4);

    void onLoadStarted(int i4, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onMediaPeriodCreated(int i4, MediaSource.MediaPeriodId mediaPeriodId);

    void onMediaPeriodReleased(int i4, MediaSource.MediaPeriodId mediaPeriodId);

    void onReadingStarted(int i4, MediaSource.MediaPeriodId mediaPeriodId);

    void onUpstreamDiscarded(int i4, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);
}
