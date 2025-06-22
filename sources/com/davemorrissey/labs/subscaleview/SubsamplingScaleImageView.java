package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    /* access modifiers changed from: private */
    public static final String TAG = "SubsamplingScaleImageView";
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final List<Integer> VALID_EASING_STYLES = Arrays.asList(new Integer[]{2, 1});
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(new Integer[]{0, 90, Integer.valueOf(ORIENTATION_180), Integer.valueOf(ORIENTATION_270), -1});
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(new Integer[]{1, 2, 3});
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(new Integer[]{2, 1, 3, 4});
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(new Integer[]{1, 2, 3});
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    /* access modifiers changed from: private */
    public Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    /* access modifiers changed from: private */
    public final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    /* access modifiers changed from: private */
    public boolean isQuickScaling;
    /* access modifiers changed from: private */
    public boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    /* access modifiers changed from: private */
    public int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    /* access modifiers changed from: private */
    public OnImageEventListener onImageEventListener;
    /* access modifiers changed from: private */
    public View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    /* access modifiers changed from: private */
    public boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    /* access modifiers changed from: private */
    public boolean quickScaleEnabled;
    /* access modifiers changed from: private */
    public float quickScaleLastDistance;
    /* access modifiers changed from: private */
    public boolean quickScaleMoved;
    /* access modifiers changed from: private */
    public PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    /* access modifiers changed from: private */
    public PointF quickScaleVLastPoint;
    /* access modifiers changed from: private */
    public PointF quickScaleVStart;
    /* access modifiers changed from: private */
    public boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    /* access modifiers changed from: private */
    public Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    /* access modifiers changed from: private */
    public float scale;
    /* access modifiers changed from: private */
    public float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    /* access modifiers changed from: private */
    public PointF vCenterStart;
    private float vDistStart;
    /* access modifiers changed from: private */
    public PointF vTranslate;
    private PointF vTranslateBefore;
    /* access modifiers changed from: private */
    public PointF vTranslateStart;
    /* access modifiers changed from: private */
    public boolean zoomEnabled;

    private static class Anim {
        /* access modifiers changed from: private */
        public long duration;
        /* access modifiers changed from: private */
        public int easing;
        /* access modifiers changed from: private */
        public boolean interruptible;
        /* access modifiers changed from: private */
        public OnAnimationEventListener listener;
        /* access modifiers changed from: private */
        public int origin;
        /* access modifiers changed from: private */
        public PointF sCenterEnd;
        /* access modifiers changed from: private */
        public PointF sCenterEndRequested;
        /* access modifiers changed from: private */
        public PointF sCenterStart;
        /* access modifiers changed from: private */
        public float scaleEnd;
        /* access modifiers changed from: private */
        public float scaleStart;
        /* access modifiers changed from: private */
        public long time;
        /* access modifiers changed from: private */
        public PointF vFocusEnd;
        /* access modifiers changed from: private */
        public PointF vFocusStart;

        private Anim() {
            this.duration = 500;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }
    }

    private static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z4) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z4;
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new Object[0]);
                this.bitmap = ((ImageDecoder) decoderFactory.make()).decode(context, this.source);
                return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(context, uri));
            } catch (Exception e5) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e5);
                this.exception = e5;
                return null;
            } catch (OutOfMemoryError e6) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e6);
                this.exception = new RuntimeException(e6);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 == null || num == null) {
                    if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                        if (this.preview) {
                            subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                        } else {
                            subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                        }
                    }
                } else if (this.preview) {
                    subsamplingScaleImageView.onPreviewLoaded(bitmap2);
                } else {
                    subsamplingScaleImageView.onImageLoaded(bitmap2, num.intValue(), false);
                }
            }
        }
    }

    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        public void onComplete() {
        }

        public void onInterruptedByNewAnim() {
        }

        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements OnImageEventListener {
        public void onImageLoadError(Exception exc) {
        }

        public void onImageLoaded() {
        }

        public void onPreviewLoadError(Exception exc) {
        }

        public void onPreviewReleased() {
        }

        public void onReady() {
        }

        public void onTileLoadError(Exception exc) {
        }
    }

    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        public void onCenterChanged(PointF pointF, int i4) {
        }

        public void onScaleChanged(float f4, int i4) {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public interface OnStateChangedListener {
        void onCenterChanged(PointF pointF, int i4);

        void onScaleChanged(float f4, int i4);
    }

    private static class ScaleAndTranslate {
        /* access modifiers changed from: private */
        public float scale;
        /* access modifiers changed from: private */
        public final PointF vTranslate;

        private ScaleAndTranslate(float f4, PointF pointF) {
            this.scale = f4;
            this.vTranslate = pointF;
        }
    }

    private static class Tile {
        /* access modifiers changed from: private */
        public Bitmap bitmap;
        /* access modifiers changed from: private */
        public Rect fileSRect;
        /* access modifiers changed from: private */
        public boolean loading;
        /* access modifiers changed from: private */
        public Rect sRect;
        /* access modifiers changed from: private */
        public int sampleSize;
        /* access modifiers changed from: private */
        public Rect vRect;
        /* access modifiers changed from: private */
        public boolean visible;

        private Tile() {
        }
    }

    private static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            boolean unused = tile.loading = true;
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voidArr) {
            SubsamplingScaleImageView subsamplingScaleImageView;
            try {
                subsamplingScaleImageView = this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = this.decoderRef.get();
                Tile tile = this.tileRef.get();
                if (imageRegionDecoder != null && tile != null && subsamplingScaleImageView != null && imageRegionDecoder.isReady() && tile.visible) {
                    subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                    subsamplingScaleImageView.decoderLock.readLock().lock();
                    if (imageRegionDecoder.isReady()) {
                        subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                        if (subsamplingScaleImageView.sRegion != null) {
                            tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                        }
                        Bitmap decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                        subsamplingScaleImageView.decoderLock.readLock().unlock();
                        return decodeRegion;
                    }
                    boolean unused = tile.loading = false;
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                    return null;
                } else if (tile == null) {
                    return null;
                } else {
                    boolean unused2 = tile.loading = false;
                    return null;
                }
            } catch (Exception e5) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e5);
                this.exception = e5;
                return null;
            } catch (OutOfMemoryError e6) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e6);
                this.exception = new RuntimeException(e6);
                return null;
            } catch (Throwable th) {
                subsamplingScaleImageView.decoderLock.readLock().unlock();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            Tile tile = this.tileRef.get();
            if (subsamplingScaleImageView != null && tile != null) {
                if (bitmap != null) {
                    Bitmap unused = tile.bitmap = bitmap;
                    boolean unused2 = tile.loading = false;
                    subsamplingScaleImageView.onTileLoaded();
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
                }
            }
        }
    }

    private static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* access modifiers changed from: protected */
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = this.contextRef.get();
                DecoderFactory decoderFactory = this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new Object[0]);
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) decoderFactory.make();
                this.decoder = imageRegionDecoder;
                Point init = imageRegionDecoder.init(context, this.source);
                int i4 = init.x;
                int i5 = init.y;
                int access$5200 = subsamplingScaleImageView.getExifOrientation(context, uri);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = Math.min(i4, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = Math.min(i5, subsamplingScaleImageView.sRegion.bottom);
                    i4 = subsamplingScaleImageView.sRegion.width();
                    i5 = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i4, i5, access$5200};
            } catch (Exception e5) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e5);
                this.exception = e5;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = Integer.MAX_VALUE;
        this.maxTileHeight = Integer.MAX_VALUE;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setMinimumTileDpi(320);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    int unused = SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener((View.OnLongClickListener) null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            int i4 = R.styleable.SubsamplingScaleImageView_assetName;
            if (obtainStyledAttributes.hasValue(i4) && (string = obtainStyledAttributes.getString(i4)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            int i5 = R.styleable.SubsamplingScaleImageView_src;
            if (obtainStyledAttributes.hasValue(i5) && (resourceId = obtainStyledAttributes.getResourceId(i5, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            int i6 = R.styleable.SubsamplingScaleImageView_panEnabled;
            if (obtainStyledAttributes.hasValue(i6)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(i6, true));
            }
            int i7 = R.styleable.SubsamplingScaleImageView_zoomEnabled;
            if (obtainStyledAttributes.hasValue(i7)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(i7, true));
            }
            int i8 = R.styleable.SubsamplingScaleImageView_quickScaleEnabled;
            if (obtainStyledAttributes.hasValue(i8)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(i8, true));
            }
            int i9 = R.styleable.SubsamplingScaleImageView_tileBackgroundColor;
            if (obtainStyledAttributes.hasValue(i9)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(i9, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int calculateInSampleSize(float f4) {
        int i4;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f4 *= ((float) this.minimumTileDpi) / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth2 = (int) (((float) sWidth()) * f4);
        int sHeight2 = (int) (((float) sHeight()) * f4);
        if (sWidth2 == 0 || sHeight2 == 0) {
            return 32;
        }
        int i5 = 1;
        if (sHeight() > sHeight2 || sWidth() > sWidth2) {
            i4 = Math.round(((float) sHeight()) / ((float) sHeight2));
            int round = Math.round(((float) sWidth()) / ((float) sWidth2));
            if (i4 >= round) {
                i4 = round;
            }
        } else {
            i4 = 1;
        }
        while (true) {
            int i6 = i5 * 2;
            if (i6 >= i4) {
                return i5;
            }
            i5 = i6;
        }
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z4;
        if (getWidth() <= 0 || getHeight() <= 0 || this.sWidth <= 0 || this.sHeight <= 0 || (this.bitmap == null && !isBaseLayerReady())) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!this.readySent && z4) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onReady();
            }
        }
        return z4;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            Paint paint2 = new Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize((float) px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth((float) px(1));
        }
    }

    /* access modifiers changed from: private */
    @AnyThread
    public void debug(String str, Object... objArr) {
        if (this.debug) {
            Log.d(TAG, String.format(str, objArr));
        }
    }

    private float distance(float f4, float f5, float f6, float f7) {
        float f8 = f4 - f5;
        float f9 = f6 - f7;
        return (float) Math.sqrt((double) ((f8 * f8) + (f9 * f9)));
    }

    /* access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        boolean z4;
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                pointF.y = pointF3.y;
            } else {
                pointF.x = (float) (sWidth() / 2);
                pointF.y = (float) (sHeight() / 2);
            }
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f4 = this.scale;
        if (((double) f4) <= ((double) min) * 0.9d || f4 == this.minScale) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            min = minScale();
        }
        int i4 = this.doubleTapZoomStyle;
        if (i4 == 3) {
            setScaleAndCenter(min, pointF);
        } else if (i4 == 2 || !z4 || !this.panEnabled) {
            new AnimationBuilder(min, pointF).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).withOrigin(4).start();
        } else if (i4 == 1) {
            new AnimationBuilder(min, pointF, pointF2).withInterruptible(false).withDuration((long) this.doubleTapZoomDuration).withOrigin(4).start();
        }
        invalidate();
    }

    private float ease(int i4, long j4, float f4, float f5, long j5) {
        if (i4 == 1) {
            return easeOutQuad(j4, f4, f5, j5);
        }
        if (i4 == 2) {
            return easeInOutQuad(j4, f4, f5, j5);
        }
        throw new IllegalStateException("Unexpected easing type: " + i4);
    }

    private float easeInOutQuad(long j4, float f4, float f5, long j5) {
        float f6;
        float f7 = ((float) j4) / (((float) j5) / 2.0f);
        if (f7 < 1.0f) {
            f6 = (f5 / 2.0f) * f7;
        } else {
            float f8 = f7 - 1.0f;
            f6 = (-f5) / 2.0f;
            f7 = (f8 * (f8 - 2.0f)) - 1.0f;
        }
        return (f6 * f7) + f4;
    }

    private float easeOutQuad(long j4, float f4, float f5, long j5) {
        float f6 = ((float) j4) / ((float) j5);
        return ((-f5) * f6 * (f6 - 2.0f)) + f4;
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new Void[0]);
    }

    /* access modifiers changed from: private */
    @AnyThread
    public void fileSRect(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            int i4 = rect.top;
            int i5 = this.sHeight;
            rect2.set(i4, i5 - rect.right, rect.bottom, i5 - rect.left);
        } else if (getRequiredRotation() == 180) {
            int i6 = this.sWidth;
            int i7 = this.sHeight;
            rect2.set(i6 - rect.right, i7 - rect.bottom, i6 - rect.left, i7 - rect.top);
        } else {
            int i8 = this.sWidth;
            rect2.set(i8 - rect.bottom, rect.left, i8 - rect.top, rect.right);
        }
    }

    /* access modifiers changed from: private */
    public void fitToBounds(boolean z4, ScaleAndTranslate scaleAndTranslate) {
        float f4;
        float f5;
        int max;
        if (this.panLimit == 2 && isReady()) {
            z4 = false;
        }
        PointF access$4800 = scaleAndTranslate.vTranslate;
        float limitedScale = limitedScale(scaleAndTranslate.scale);
        float sWidth2 = ((float) sWidth()) * limitedScale;
        float sHeight2 = ((float) sHeight()) * limitedScale;
        if (this.panLimit == 3 && isReady()) {
            access$4800.x = Math.max(access$4800.x, ((float) (getWidth() / 2)) - sWidth2);
            access$4800.y = Math.max(access$4800.y, ((float) (getHeight() / 2)) - sHeight2);
        } else if (z4) {
            access$4800.x = Math.max(access$4800.x, ((float) getWidth()) - sWidth2);
            access$4800.y = Math.max(access$4800.y, ((float) getHeight()) - sHeight2);
        } else {
            access$4800.x = Math.max(access$4800.x, -sWidth2);
            access$4800.y = Math.max(access$4800.y, -sHeight2);
        }
        float f6 = 0.5f;
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight())) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f6 = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.panLimit == 3 && isReady()) {
            f4 = (float) Math.max(0, getWidth() / 2);
            max = Math.max(0, getHeight() / 2);
        } else if (z4) {
            f4 = Math.max(0.0f, (((float) getWidth()) - sWidth2) * paddingLeft);
            f5 = Math.max(0.0f, (((float) getHeight()) - sHeight2) * f6);
            access$4800.x = Math.min(access$4800.x, f4);
            access$4800.y = Math.min(access$4800.y, f5);
            float unused = scaleAndTranslate.scale = limitedScale;
        } else {
            f4 = (float) Math.max(0, getWidth());
            max = Math.max(0, getHeight());
        }
        f5 = (float) max;
        access$4800.x = Math.min(access$4800.x, f4);
        access$4800.y = Math.min(access$4800.y, f5);
        float unused2 = scaleAndTranslate.scale = limitedScale;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0053, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0054, code lost:
        r10 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0056, code lost:
        if (r2 != null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        android.util.Log.w(TAG, "Could not get orientation of image from media store");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        if (r2 == null) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (r2 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
        throw r10;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x005c */
    @androidx.annotation.AnyThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getExifOrientation(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "content"
            boolean r0 = r11.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x006c
            r2 = 0
            java.lang.String r0 = "orientation"
            java.lang.String[] r5 = new java.lang.String[]{r0}     // Catch:{ Exception -> 0x005c }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x005c }
            android.net.Uri r4 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x005c }
            r7 = 0
            r8 = 0
            r6 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005c }
            if (r2 == 0) goto L_0x0056
            boolean r10 = r2.moveToFirst()     // Catch:{ Exception -> 0x005c }
            if (r10 == 0) goto L_0x0056
            int r10 = r2.getInt(r1)     // Catch:{ Exception -> 0x005c }
            java.util.List<java.lang.Integer> r11 = VALID_ORIENTATIONS     // Catch:{ Exception -> 0x005c }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x005c }
            boolean r11 = r11.contains(r0)     // Catch:{ Exception -> 0x005c }
            if (r11 == 0) goto L_0x003c
            r11 = -1
            if (r10 == r11) goto L_0x003c
            r1 = r10
            goto L_0x0056
        L_0x003c:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x005c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005c }
            r0.<init>()     // Catch:{ Exception -> 0x005c }
            java.lang.String r3 = "Unsupported orientation: "
            r0.append(r3)     // Catch:{ Exception -> 0x005c }
            r0.append(r10)     // Catch:{ Exception -> 0x005c }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x005c }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x005c }
            goto L_0x0056
        L_0x0053:
            r0 = move-exception
            r10 = r0
            goto L_0x0066
        L_0x0056:
            if (r2 == 0) goto L_0x00c3
        L_0x0058:
            r2.close()
            goto L_0x00c3
        L_0x005c:
            java.lang.String r10 = TAG     // Catch:{ all -> 0x0053 }
            java.lang.String r11 = "Could not get orientation of image from media store"
            android.util.Log.w(r10, r11)     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x00c3
            goto L_0x0058
        L_0x0066:
            if (r2 == 0) goto L_0x006b
            r2.close()
        L_0x006b:
            throw r10
        L_0x006c:
            java.lang.String r10 = "file:///"
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x00c3
            java.lang.String r10 = "file:///android_asset/"
            boolean r10 = r11.startsWith(r10)
            if (r10 != 0) goto L_0x00c3
            androidx.exifinterface.media.ExifInterface r10 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x00bc }
            r0 = 7
            java.lang.String r11 = r11.substring(r0)     // Catch:{ Exception -> 0x00bc }
            r10.<init>((java.lang.String) r11)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r11 = "Orientation"
            r0 = 1
            int r10 = r10.getAttributeInt(r11, r0)     // Catch:{ Exception -> 0x00bc }
            if (r10 == r0) goto L_0x00bb
            if (r10 != 0) goto L_0x0092
            goto L_0x00bb
        L_0x0092:
            r11 = 6
            if (r10 != r11) goto L_0x0098
            r10 = 90
            return r10
        L_0x0098:
            r11 = 3
            if (r10 != r11) goto L_0x009e
            r10 = 180(0xb4, float:2.52E-43)
            return r10
        L_0x009e:
            r11 = 8
            if (r10 != r11) goto L_0x00a5
            r10 = 270(0x10e, float:3.78E-43)
            return r10
        L_0x00a5:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x00bc }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00bc }
            r0.<init>()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r2 = "Unsupported EXIF orientation: "
            r0.append(r2)     // Catch:{ Exception -> 0x00bc }
            r0.append(r10)     // Catch:{ Exception -> 0x00bc }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x00bc }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x00bc }
        L_0x00bb:
            return r1
        L_0x00bc:
            java.lang.String r10 = TAG
            java.lang.String r11 = "Could not get EXIF orientation of image"
            android.util.Log.w(r10, r11)
        L_0x00c3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.getExifOrientation(android.content.Context, java.lang.String):int");
    }

    @NonNull
    private Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    @AnyThread
    private int getRequiredRotation() {
        int i4 = this.orientation;
        if (i4 == -1) {
            return this.sOrientation;
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ac, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void initialiseBaseLayer(@androidx.annotation.NonNull android.graphics.Point r13) {
        /*
            r12 = this;
            r0 = 1
            r1 = 2
            monitor-enter(r12)
            java.lang.String r2 = "initialiseBaseLayer maxTileDimensions=%dx%d"
            int r3 = r13.x     // Catch:{ all -> 0x0078 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0078 }
            int r4 = r13.y     // Catch:{ all -> 0x0078 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0078 }
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0078 }
            r6 = 0
            r5[r6] = r3     // Catch:{ all -> 0x0078 }
            r5[r0] = r4     // Catch:{ all -> 0x0078 }
            r12.debug(r2, r5)     // Catch:{ all -> 0x0078 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$ScaleAndTranslate r2 = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$ScaleAndTranslate     // Catch:{ all -> 0x0078 }
            android.graphics.PointF r3 = new android.graphics.PointF     // Catch:{ all -> 0x0078 }
            r4 = 0
            r3.<init>(r4, r4)     // Catch:{ all -> 0x0078 }
            r5 = 0
            r2.<init>(r4, r3)     // Catch:{ all -> 0x0078 }
            r12.satTemp = r2     // Catch:{ all -> 0x0078 }
            r12.fitToBounds(r0, r2)     // Catch:{ all -> 0x0078 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$ScaleAndTranslate r2 = r12.satTemp     // Catch:{ all -> 0x0078 }
            float r2 = r2.scale     // Catch:{ all -> 0x0078 }
            int r2 = r12.calculateInSampleSize(r2)     // Catch:{ all -> 0x0078 }
            r12.fullImageSampleSize = r2     // Catch:{ all -> 0x0078 }
            if (r2 <= r0) goto L_0x0043
            int r2 = r2 / r1
            r12.fullImageSampleSize = r2     // Catch:{ all -> 0x003e }
            goto L_0x0043
        L_0x003e:
            r0 = move-exception
            r13 = r0
            r7 = r12
            goto L_0x00ad
        L_0x0043:
            int r1 = r12.fullImageSampleSize     // Catch:{ all -> 0x0078 }
            if (r1 != r0) goto L_0x007b
            android.graphics.Rect r1 = r12.sRegion     // Catch:{ all -> 0x0078 }
            if (r1 != 0) goto L_0x007b
            int r1 = r12.sWidth()     // Catch:{ all -> 0x0078 }
            int r2 = r13.x     // Catch:{ all -> 0x0078 }
            if (r1 >= r2) goto L_0x007b
            int r1 = r12.sHeight()     // Catch:{ all -> 0x0078 }
            int r2 = r13.y     // Catch:{ all -> 0x0078 }
            if (r1 >= r2) goto L_0x007b
            com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder r13 = r12.decoder     // Catch:{ all -> 0x0078 }
            r13.recycle()     // Catch:{ all -> 0x0078 }
            r12.decoder = r5     // Catch:{ all -> 0x0078 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask r6 = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask     // Catch:{ all -> 0x0078 }
            android.content.Context r8 = r12.getContext()     // Catch:{ all -> 0x0078 }
            com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageDecoder> r9 = r12.bitmapDecoderFactory     // Catch:{ all -> 0x0078 }
            android.net.Uri r10 = r12.uri     // Catch:{ all -> 0x0078 }
            r11 = 0
            r7 = r12
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ all -> 0x0075 }
            r12.execute(r6)     // Catch:{ all -> 0x0075 }
            goto L_0x00ab
        L_0x0075:
            r0 = move-exception
        L_0x0076:
            r13 = r0
            goto L_0x00ad
        L_0x0078:
            r0 = move-exception
            r7 = r12
            goto L_0x0076
        L_0x007b:
            r7 = r12
            r12.initialiseTileMap(r13)     // Catch:{ all -> 0x0075 }
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r13 = r7.tileMap     // Catch:{ all -> 0x0075 }
            int r1 = r7.fullImageSampleSize     // Catch:{ all -> 0x0075 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0075 }
            java.lang.Object r13 = r13.get(r1)     // Catch:{ all -> 0x0075 }
            java.util.List r13 = (java.util.List) r13     // Catch:{ all -> 0x0075 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ all -> 0x0075 }
        L_0x0091:
            boolean r1 = r13.hasNext()     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x00a8
            java.lang.Object r1 = r13.next()     // Catch:{ all -> 0x0075 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile r1 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile) r1     // Catch:{ all -> 0x0075 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$TileLoadTask r2 = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$TileLoadTask     // Catch:{ all -> 0x0075 }
            com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder r3 = r7.decoder     // Catch:{ all -> 0x0075 }
            r2.<init>(r12, r3, r1)     // Catch:{ all -> 0x0075 }
            r12.execute(r2)     // Catch:{ all -> 0x0075 }
            goto L_0x0091
        L_0x00a8:
            r12.refreshRequiredTiles(r0)     // Catch:{ all -> 0x0075 }
        L_0x00ab:
            monitor-exit(r12)
            return
        L_0x00ad:
            monitor-exit(r12)     // Catch:{ all -> 0x0075 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.initialiseBaseLayer(android.graphics.Point):void");
    }

    private void initialiseTileMap(Point point) {
        boolean z4;
        int i4;
        int i5;
        Point point2 = point;
        int i6 = 1;
        debug("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point2.x), Integer.valueOf(point2.y));
        this.tileMap = new LinkedHashMap();
        int i7 = this.fullImageSampleSize;
        int i8 = 1;
        int i9 = 1;
        while (true) {
            int sWidth2 = sWidth() / i8;
            int sHeight2 = sHeight() / i9;
            int i10 = sWidth2 / i7;
            int i11 = sHeight2 / i7;
            while (true) {
                if (i10 + i8 + i6 > point2.x || (((double) i10) > ((double) getWidth()) * 1.25d && i7 < this.fullImageSampleSize)) {
                    i8 += i6;
                    sWidth2 = sWidth() / i8;
                    i10 = sWidth2 / i7;
                }
            }
            while (true) {
                if (i11 + i9 + i6 > point2.y || (((double) i11) > ((double) getHeight()) * 1.25d && i7 < this.fullImageSampleSize)) {
                    i9 += i6;
                    sHeight2 = sHeight() / i9;
                    i11 = sHeight2 / i7;
                }
            }
            ArrayList arrayList = new ArrayList(i8 * i9);
            for (int i12 = 0; i12 < i8; i12++) {
                for (int i13 = 0; i13 < i9; i13++) {
                    Tile tile = new Tile();
                    int unused = tile.sampleSize = i7;
                    if (i7 == this.fullImageSampleSize) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    boolean unused2 = tile.visible = z4;
                    int i14 = i12 * sWidth2;
                    int i15 = i13 * sHeight2;
                    if (i12 == i8 - 1) {
                        i4 = sWidth();
                    } else {
                        i4 = (i12 + 1) * sWidth2;
                    }
                    if (i13 == i9 - 1) {
                        i5 = sHeight();
                    } else {
                        i5 = (i13 + 1) * sHeight2;
                    }
                    Rect unused3 = tile.sRect = new Rect(i14, i15, i4, i5);
                    Rect unused4 = tile.vRect = new Rect(0, 0, 0, 0);
                    Rect unused5 = tile.fileSRect = new Rect(tile.sRect);
                    arrayList.add(tile);
                }
            }
            this.tileMap.put(Integer.valueOf(i7), arrayList);
            i6 = 1;
            if (i7 != 1) {
                i7 /= 2;
            } else {
                return;
            }
        }
    }

    private boolean isBaseLayerReady() {
        boolean z4 = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (((Integer) next.getKey()).intValue() == this.fullImageSampleSize) {
                for (Tile tile : (List) next.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z4 = false;
                    }
                }
            }
        }
        return z4;
    }

    /* access modifiers changed from: private */
    @NonNull
    public PointF limitedSCenter(float f4, float f5, float f6, @NonNull PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f4, f5, f6);
        pointF.set((((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2))) - vTranslateForSCenter.x) / f6, (((float) (getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2))) - vTranslateForSCenter.y) / f6);
        return pointF;
    }

    /* access modifiers changed from: private */
    public float limitedScale(float f4) {
        return Math.min(this.maxScale, Math.max(minScale(), f4));
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i4 = this.minimumScaleType;
        if (i4 == 2 || i4 == 4) {
            return Math.max(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
        }
        if (i4 == 3) {
            float f4 = this.minScale;
            if (f4 > 0.0f) {
                return f4;
            }
        }
        return Math.min(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onPreviewLoaded(android.graphics.Bitmap r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "onPreviewLoaded"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x002b }
            r4.debug(r0, r1)     // Catch:{ all -> 0x002b }
            android.graphics.Bitmap r0 = r4.bitmap     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0040
            boolean r0 = r4.imageLoadedSent     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0012
            goto L_0x0040
        L_0x0012:
            android.graphics.Rect r0 = r4.pRegion     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x002d
            int r1 = r0.left     // Catch:{ all -> 0x002b }
            int r2 = r0.top     // Catch:{ all -> 0x002b }
            int r0 = r0.width()     // Catch:{ all -> 0x002b }
            android.graphics.Rect r3 = r4.pRegion     // Catch:{ all -> 0x002b }
            int r3 = r3.height()     // Catch:{ all -> 0x002b }
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r1, r2, r0, r3)     // Catch:{ all -> 0x002b }
            r4.bitmap = r5     // Catch:{ all -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r5 = move-exception
            goto L_0x0045
        L_0x002d:
            r4.bitmap = r5     // Catch:{ all -> 0x002b }
        L_0x002f:
            r5 = 1
            r4.bitmapIsPreview = r5     // Catch:{ all -> 0x002b }
            boolean r5 = r4.checkReady()     // Catch:{ all -> 0x002b }
            if (r5 == 0) goto L_0x003e
            r4.invalidate()     // Catch:{ all -> 0x002b }
            r4.requestLayout()     // Catch:{ all -> 0x002b }
        L_0x003e:
            monitor-exit(r4)
            return
        L_0x0040:
            r5.recycle()     // Catch:{ all -> 0x002b }
            monitor-exit(r4)
            return
        L_0x0045:
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onPreviewLoaded(android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Bitmap bitmap2;
        try {
            debug("onTileLoaded", new Object[0]);
            checkReady();
            checkImageLoaded();
            if (isBaseLayerReady() && (bitmap2 = this.bitmap) != null) {
                if (!this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                this.bitmap = null;
                OnImageEventListener onImageEventListener2 = this.onImageEventListener;
                if (onImageEventListener2 != null && this.bitmapIsCached) {
                    onImageEventListener2.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
            invalidate();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        try {
            debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(this.orientation));
            int i10 = this.sWidth;
            if (i10 > 0 && (i9 = this.sHeight) > 0 && !(i10 == i4 && i9 == i5)) {
                reset(false);
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 != null) {
                    if (!this.bitmapIsCached) {
                        bitmap2.recycle();
                    }
                    this.bitmap = null;
                    OnImageEventListener onImageEventListener2 = this.onImageEventListener;
                    if (onImageEventListener2 != null && this.bitmapIsCached) {
                        onImageEventListener2.onPreviewReleased();
                    }
                    this.bitmapIsPreview = false;
                    this.bitmapIsCached = false;
                }
            }
            this.decoder = imageRegionDecoder;
            this.sWidth = i4;
            this.sHeight = i5;
            this.sOrientation = i6;
            checkReady();
            if (!checkImageLoaded() && (i7 = this.maxTileWidth) > 0 && i7 != Integer.MAX_VALUE && (i8 = this.maxTileHeight) > 0 && i8 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
                initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
            }
            invalidate();
            requestLayout();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r1 != 262) goto L_0x03be;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean onTouchEventInternal(@androidx.annotation.NonNull android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getPointerCount()
            int r1 = r12.getAction()
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x042b
            if (r1 == r5) goto L_0x03bf
            if (r1 == r3) goto L_0x0023
            r6 = 5
            if (r1 == r6) goto L_0x042b
            r6 = 6
            if (r1 == r6) goto L_0x03bf
            r6 = 261(0x105, float:3.66E-43)
            if (r1 == r6) goto L_0x042b
            r2 = 262(0x106, float:3.67E-43)
            if (r1 == r2) goto L_0x03bf
            goto L_0x03be
        L_0x0023:
            int r1 = r11.maxTouchCount
            if (r1 <= 0) goto L_0x03be
            r1 = 1084227584(0x40a00000, float:5.0)
            if (r0 < r3) goto L_0x018a
            float r0 = r12.getX(r4)
            float r6 = r12.getX(r5)
            float r7 = r12.getY(r4)
            float r8 = r12.getY(r5)
            float r0 = r11.distance(r0, r6, r7, r8)
            float r6 = r12.getX(r4)
            float r7 = r12.getX(r5)
            float r6 = r6 + r7
            float r6 = r6 / r2
            float r7 = r12.getY(r4)
            float r12 = r12.getY(r5)
            float r7 = r7 + r12
            float r7 = r7 / r2
            boolean r12 = r11.zoomEnabled
            if (r12 == 0) goto L_0x03be
            android.graphics.PointF r12 = r11.vCenterStart
            float r2 = r12.x
            float r12 = r12.y
            float r12 = r11.distance(r2, r6, r12, r7)
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0075
            float r12 = r11.vDistStart
            float r12 = r0 - r12
            float r12 = java.lang.Math.abs(r12)
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0075
            boolean r12 = r11.isPanning
            if (r12 == 0) goto L_0x03be
        L_0x0075:
            r11.isZooming = r5
            r11.isPanning = r5
            float r12 = r11.scale
            double r1 = (double) r12
            float r12 = r11.maxScale
            float r4 = r11.vDistStart
            float r4 = r0 / r4
            float r8 = r11.scaleStart
            float r4 = r4 * r8
            float r12 = java.lang.Math.min(r12, r4)
            r11.scale = r12
            float r4 = r11.minScale()
            int r12 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r12 > 0) goto L_0x00aa
            r11.vDistStart = r0
            float r12 = r11.minScale()
            r11.scaleStart = r12
            android.graphics.PointF r12 = r11.vCenterStart
            r12.set(r6, r7)
            android.graphics.PointF r12 = r11.vTranslateStart
            android.graphics.PointF r0 = r11.vTranslate
            r12.set(r0)
            goto L_0x0180
        L_0x00aa:
            boolean r12 = r11.panEnabled
            if (r12 == 0) goto L_0x012b
            android.graphics.PointF r12 = r11.vCenterStart
            float r3 = r12.x
            android.graphics.PointF r4 = r11.vTranslateStart
            float r8 = r4.x
            float r3 = r3 - r8
            float r12 = r12.y
            float r4 = r4.y
            float r12 = r12 - r4
            float r4 = r11.scale
            float r8 = r11.scaleStart
            float r9 = r4 / r8
            float r3 = r3 * r9
            float r4 = r4 / r8
            float r12 = r12 * r4
            android.graphics.PointF r4 = r11.vTranslate
            float r3 = r6 - r3
            r4.x = r3
            float r12 = r7 - r12
            r4.y = r12
            int r12 = r11.sHeight()
            double r3 = (double) r12
            double r3 = r3 * r1
            int r12 = r11.getHeight()
            double r8 = (double) r12
            int r12 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x00f3
            float r12 = r11.scale
            int r3 = r11.sHeight()
            float r3 = (float) r3
            float r12 = r12 * r3
            int r3 = r11.getHeight()
            float r3 = (float) r3
            int r12 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x0115
        L_0x00f3:
            int r12 = r11.sWidth()
            double r3 = (double) r12
            double r1 = r1 * r3
            int r12 = r11.getWidth()
            double r3 = (double) r12
            int r12 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r12 >= 0) goto L_0x0180
            float r12 = r11.scale
            int r1 = r11.sWidth()
            float r1 = (float) r1
            float r12 = r12 * r1
            int r1 = r11.getWidth()
            float r1 = (float) r1
            int r12 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r12 < 0) goto L_0x0180
        L_0x0115:
            r11.fitToBounds(r5)
            android.graphics.PointF r12 = r11.vCenterStart
            r12.set(r6, r7)
            android.graphics.PointF r12 = r11.vTranslateStart
            android.graphics.PointF r1 = r11.vTranslate
            r12.set(r1)
            float r12 = r11.scale
            r11.scaleStart = r12
            r11.vDistStart = r0
            goto L_0x0180
        L_0x012b:
            android.graphics.PointF r12 = r11.sRequestedCenter
            if (r12 == 0) goto L_0x0156
            android.graphics.PointF r12 = r11.vTranslate
            int r0 = r11.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r11.scale
            android.graphics.PointF r2 = r11.sRequestedCenter
            float r2 = r2.x
            float r1 = r1 * r2
            float r0 = r0 - r1
            r12.x = r0
            android.graphics.PointF r12 = r11.vTranslate
            int r0 = r11.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r11.scale
            android.graphics.PointF r2 = r11.sRequestedCenter
            float r2 = r2.y
            float r1 = r1 * r2
            float r0 = r0 - r1
            r12.y = r0
            goto L_0x0180
        L_0x0156:
            android.graphics.PointF r12 = r11.vTranslate
            int r0 = r11.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r11.scale
            int r2 = r11.sWidth()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r12.x = r0
            android.graphics.PointF r12 = r11.vTranslate
            int r0 = r11.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r11.scale
            int r2 = r11.sHeight()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r12.y = r0
        L_0x0180:
            r11.fitToBounds(r5)
            boolean r12 = r11.eagerLoadingEnabled
            r11.refreshRequiredTiles(r12)
            goto L_0x03b5
        L_0x018a:
            boolean r0 = r11.isQuickScaling
            if (r0 == 0) goto L_0x02e4
            android.graphics.PointF r0 = r11.quickScaleVStart
            float r0 = r0.y
            float r1 = r12.getY()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            float r0 = r0 * r2
            float r1 = r11.quickScaleThreshold
            float r0 = r0 + r1
            float r1 = r11.quickScaleLastDistance
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x01aa
            r11.quickScaleLastDistance = r0
        L_0x01aa:
            float r1 = r12.getY()
            android.graphics.PointF r2 = r11.quickScaleVLastPoint
            float r6 = r2.y
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x01b7
            r4 = 1
        L_0x01b7:
            float r12 = r12.getY()
            r1 = 0
            r2.set(r1, r12)
            float r12 = r11.quickScaleLastDistance
            float r12 = r0 / r12
            r2 = 1065353216(0x3f800000, float:1.0)
            float r12 = r2 - r12
            float r12 = java.lang.Math.abs(r12)
            r6 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 * r6
            r6 = 1022739087(0x3cf5c28f, float:0.03)
            int r6 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x01da
            boolean r6 = r11.quickScaleMoved
            if (r6 == 0) goto L_0x02d8
        L_0x01da:
            r11.quickScaleMoved = r5
            float r6 = r11.quickScaleLastDistance
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x01e8
            if (r4 == 0) goto L_0x01e7
            float r12 = r12 + r2
            r2 = r12
            goto L_0x01e8
        L_0x01e7:
            float r2 = r2 - r12
        L_0x01e8:
            float r12 = r11.scale
            double r6 = (double) r12
            float r12 = r11.minScale()
            float r4 = r11.maxScale
            float r8 = r11.scale
            float r8 = r8 * r2
            float r2 = java.lang.Math.min(r4, r8)
            float r12 = java.lang.Math.max(r12, r2)
            r11.scale = r12
            boolean r2 = r11.panEnabled
            if (r2 == 0) goto L_0x0283
            android.graphics.PointF r2 = r11.vCenterStart
            float r3 = r2.x
            android.graphics.PointF r4 = r11.vTranslateStart
            float r8 = r4.x
            float r8 = r3 - r8
            float r2 = r2.y
            float r4 = r4.y
            float r4 = r2 - r4
            float r9 = r11.scaleStart
            float r10 = r12 / r9
            float r8 = r8 * r10
            float r12 = r12 / r9
            float r4 = r4 * r12
            android.graphics.PointF r12 = r11.vTranslate
            float r3 = r3 - r8
            r12.x = r3
            float r2 = r2 - r4
            r12.y = r2
            int r12 = r11.sHeight()
            double r2 = (double) r12
            double r2 = r2 * r6
            int r12 = r11.getHeight()
            double r8 = (double) r12
            int r12 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x0246
            float r12 = r11.scale
            int r2 = r11.sHeight()
            float r2 = (float) r2
            float r12 = r12 * r2
            int r2 = r11.getHeight()
            float r2 = (float) r2
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x0268
        L_0x0246:
            int r12 = r11.sWidth()
            double r2 = (double) r12
            double r6 = r6 * r2
            int r12 = r11.getWidth()
            double r2 = (double) r12
            int r12 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x02d8
            float r12 = r11.scale
            int r2 = r11.sWidth()
            float r2 = (float) r2
            float r12 = r12 * r2
            int r2 = r11.getWidth()
            float r2 = (float) r2
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 < 0) goto L_0x02d8
        L_0x0268:
            r11.fitToBounds(r5)
            android.graphics.PointF r12 = r11.vCenterStart
            android.graphics.PointF r0 = r11.quickScaleSCenter
            android.graphics.PointF r0 = r11.sourceToViewCoord(r0)
            r12.set(r0)
            android.graphics.PointF r12 = r11.vTranslateStart
            android.graphics.PointF r0 = r11.vTranslate
            r12.set(r0)
            float r12 = r11.scale
            r11.scaleStart = r12
            r0 = 0
            goto L_0x02d8
        L_0x0283:
            android.graphics.PointF r12 = r11.sRequestedCenter
            if (r12 == 0) goto L_0x02ae
            android.graphics.PointF r12 = r11.vTranslate
            int r1 = r11.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r11.scale
            android.graphics.PointF r4 = r11.sRequestedCenter
            float r4 = r4.x
            float r2 = r2 * r4
            float r1 = r1 - r2
            r12.x = r1
            android.graphics.PointF r12 = r11.vTranslate
            int r1 = r11.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r11.scale
            android.graphics.PointF r3 = r11.sRequestedCenter
            float r3 = r3.y
            float r2 = r2 * r3
            float r1 = r1 - r2
            r12.y = r1
            goto L_0x02d8
        L_0x02ae:
            android.graphics.PointF r12 = r11.vTranslate
            int r1 = r11.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r11.scale
            int r4 = r11.sWidth()
            int r4 = r4 / r3
            float r4 = (float) r4
            float r2 = r2 * r4
            float r1 = r1 - r2
            r12.x = r1
            android.graphics.PointF r12 = r11.vTranslate
            int r1 = r11.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r11.scale
            int r4 = r11.sHeight()
            int r4 = r4 / r3
            float r3 = (float) r4
            float r2 = r2 * r3
            float r1 = r1 - r2
            r12.y = r1
        L_0x02d8:
            r11.quickScaleLastDistance = r0
            r11.fitToBounds(r5)
            boolean r12 = r11.eagerLoadingEnabled
            r11.refreshRequiredTiles(r12)
            goto L_0x03b5
        L_0x02e4:
            boolean r0 = r11.isZooming
            if (r0 != 0) goto L_0x03be
            float r0 = r12.getX()
            android.graphics.PointF r2 = r11.vCenterStart
            float r2 = r2.x
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r12.getY()
            android.graphics.PointF r3 = r11.vCenterStart
            float r3 = r3.y
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            float r3 = r11.density
            float r3 = r3 * r1
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0312
            int r6 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0312
            boolean r6 = r11.isPanning
            if (r6 == 0) goto L_0x03be
        L_0x0312:
            android.graphics.PointF r6 = r11.vTranslate
            android.graphics.PointF r7 = r11.vTranslateStart
            float r7 = r7.x
            float r8 = r12.getX()
            android.graphics.PointF r9 = r11.vCenterStart
            float r9 = r9.x
            float r8 = r8 - r9
            float r7 = r7 + r8
            r6.x = r7
            android.graphics.PointF r6 = r11.vTranslate
            android.graphics.PointF r7 = r11.vTranslateStart
            float r7 = r7.y
            float r12 = r12.getY()
            android.graphics.PointF r8 = r11.vCenterStart
            float r8 = r8.y
            float r12 = r12 - r8
            float r7 = r7 + r12
            r6.y = r7
            android.graphics.PointF r12 = r11.vTranslate
            float r6 = r12.x
            float r12 = r12.y
            r11.fitToBounds(r5)
            android.graphics.PointF r7 = r11.vTranslate
            float r8 = r7.x
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L_0x0349
            r6 = 1
            goto L_0x034a
        L_0x0349:
            r6 = 0
        L_0x034a:
            float r7 = r7.y
            int r8 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x0352
            r8 = 1
            goto L_0x0353
        L_0x0352:
            r8 = 0
        L_0x0353:
            if (r6 == 0) goto L_0x035f
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x035f
            boolean r9 = r11.isPanning
            if (r9 != 0) goto L_0x035f
            r9 = 1
            goto L_0x0360
        L_0x035f:
            r9 = 0
        L_0x0360:
            if (r8 == 0) goto L_0x036c
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x036c
            boolean r0 = r11.isPanning
            if (r0 != 0) goto L_0x036c
            r0 = 1
            goto L_0x036d
        L_0x036c:
            r0 = 0
        L_0x036d:
            int r12 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r12 != 0) goto L_0x037b
            r12 = 1077936128(0x40400000, float:3.0)
            float r12 = r12 * r3
            int r12 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r12 <= 0) goto L_0x037b
            r12 = 1
            goto L_0x037c
        L_0x037b:
            r12 = 0
        L_0x037c:
            if (r9 != 0) goto L_0x038d
            if (r0 != 0) goto L_0x038d
            if (r6 == 0) goto L_0x038a
            if (r8 == 0) goto L_0x038a
            if (r12 != 0) goto L_0x038a
            boolean r12 = r11.isPanning
            if (r12 == 0) goto L_0x038d
        L_0x038a:
            r11.isPanning = r5
            goto L_0x039d
        L_0x038d:
            if (r1 > 0) goto L_0x0393
            int r12 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r12 <= 0) goto L_0x039d
        L_0x0393:
            r11.maxTouchCount = r4
            android.os.Handler r12 = r11.handler
            r12.removeMessages(r5)
            r11.requestDisallowInterceptTouchEvent(r4)
        L_0x039d:
            boolean r12 = r11.panEnabled
            if (r12 != 0) goto L_0x03b0
            android.graphics.PointF r12 = r11.vTranslate
            android.graphics.PointF r0 = r11.vTranslateStart
            float r1 = r0.x
            r12.x = r1
            float r0 = r0.y
            r12.y = r0
            r11.requestDisallowInterceptTouchEvent(r4)
        L_0x03b0:
            boolean r12 = r11.eagerLoadingEnabled
            r11.refreshRequiredTiles(r12)
        L_0x03b5:
            android.os.Handler r12 = r11.handler
            r12.removeMessages(r5)
            r11.invalidate()
            return r5
        L_0x03be:
            return r4
        L_0x03bf:
            android.os.Handler r1 = r11.handler
            r1.removeMessages(r5)
            boolean r1 = r11.isQuickScaling
            if (r1 == 0) goto L_0x03d5
            r11.isQuickScaling = r4
            boolean r1 = r11.quickScaleMoved
            if (r1 != 0) goto L_0x03d5
            android.graphics.PointF r1 = r11.quickScaleSCenter
            android.graphics.PointF r2 = r11.vCenterStart
            r11.doubleTapZoom(r1, r2)
        L_0x03d5:
            int r1 = r11.maxTouchCount
            if (r1 <= 0) goto L_0x0422
            boolean r1 = r11.isZooming
            if (r1 != 0) goto L_0x03e1
            boolean r2 = r11.isPanning
            if (r2 == 0) goto L_0x0422
        L_0x03e1:
            if (r1 == 0) goto L_0x0413
            if (r0 != r3) goto L_0x0413
            r11.isPanning = r5
            android.graphics.PointF r1 = r11.vTranslateStart
            android.graphics.PointF r2 = r11.vTranslate
            float r6 = r2.x
            float r2 = r2.y
            r1.set(r6, r2)
            int r1 = r12.getActionIndex()
            if (r1 != r5) goto L_0x0406
            android.graphics.PointF r1 = r11.vCenterStart
            float r2 = r12.getX(r4)
            float r12 = r12.getY(r4)
            r1.set(r2, r12)
            goto L_0x0413
        L_0x0406:
            android.graphics.PointF r1 = r11.vCenterStart
            float r2 = r12.getX(r5)
            float r12 = r12.getY(r5)
            r1.set(r2, r12)
        L_0x0413:
            r12 = 3
            if (r0 >= r12) goto L_0x0418
            r11.isZooming = r4
        L_0x0418:
            if (r0 >= r3) goto L_0x041e
            r11.isPanning = r4
            r11.maxTouchCount = r4
        L_0x041e:
            r11.refreshRequiredTiles(r5)
            return r5
        L_0x0422:
            if (r0 != r5) goto L_0x042a
            r11.isZooming = r4
            r11.isPanning = r4
            r11.maxTouchCount = r4
        L_0x042a:
            return r5
        L_0x042b:
            r1 = 0
            r11.anim = r1
            r11.requestDisallowInterceptTouchEvent(r5)
            int r1 = r11.maxTouchCount
            int r1 = java.lang.Math.max(r1, r0)
            r11.maxTouchCount = r1
            if (r0 < r3) goto L_0x0486
            boolean r0 = r11.zoomEnabled
            if (r0 == 0) goto L_0x047e
            float r0 = r12.getX(r4)
            float r1 = r12.getX(r5)
            float r3 = r12.getY(r4)
            float r6 = r12.getY(r5)
            float r0 = r11.distance(r0, r1, r3, r6)
            float r1 = r11.scale
            r11.scaleStart = r1
            r11.vDistStart = r0
            android.graphics.PointF r0 = r11.vTranslateStart
            android.graphics.PointF r1 = r11.vTranslate
            float r3 = r1.x
            float r1 = r1.y
            r0.set(r3, r1)
            android.graphics.PointF r0 = r11.vCenterStart
            float r1 = r12.getX(r4)
            float r3 = r12.getX(r5)
            float r1 = r1 + r3
            float r1 = r1 / r2
            float r3 = r12.getY(r4)
            float r12 = r12.getY(r5)
            float r3 = r3 + r12
            float r3 = r3 / r2
            r0.set(r1, r3)
            goto L_0x0480
        L_0x047e:
            r11.maxTouchCount = r4
        L_0x0480:
            android.os.Handler r12 = r11.handler
            r12.removeMessages(r5)
            goto L_0x04a9
        L_0x0486:
            boolean r0 = r11.isQuickScaling
            if (r0 != 0) goto L_0x04a9
            android.graphics.PointF r0 = r11.vTranslateStart
            android.graphics.PointF r1 = r11.vTranslate
            float r2 = r1.x
            float r1 = r1.y
            r0.set(r2, r1)
            android.graphics.PointF r0 = r11.vCenterStart
            float r1 = r12.getX()
            float r12 = r12.getY()
            r0.set(r1, r12)
            android.os.Handler r12 = r11.handler
            r0 = 600(0x258, double:2.964E-321)
            r12.sendEmptyMessageDelayed(r5, r0)
        L_0x04a9:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void preDraw() {
        Float f4;
        if (getWidth() != 0 && getHeight() != 0 && this.sWidth > 0 && this.sHeight > 0) {
            if (!(this.sPendingCenter == null || (f4 = this.pendingScale) == null)) {
                this.scale = f4.floatValue();
                if (this.vTranslate == null) {
                    this.vTranslate = new PointF();
                }
                this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sPendingCenter.x);
                this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sPendingCenter.y);
                this.sPendingCenter = null;
                this.pendingScale = null;
                fitToBounds(true);
                refreshRequiredTiles(true);
            }
            fitToBounds(false);
        }
    }

    private int px(int i4) {
        return (int) (this.density * ((float) i4));
    }

    private void refreshRequiredTiles(boolean z4) {
        if (this.decoder != null && this.tileMap != null) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            for (Map.Entry<Integer, List<Tile>> value : this.tileMap.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                        boolean unused = tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            Bitmap unused2 = tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (tileVisible(tile)) {
                            boolean unused3 = tile.visible = true;
                            if (!tile.loading && tile.bitmap == null && z4) {
                                execute(new TileLoadTask(this, this.decoder, tile));
                            }
                        } else if (tile.sampleSize != this.fullImageSampleSize) {
                            boolean unused4 = tile.visible = false;
                            if (tile.bitmap != null) {
                                tile.bitmap.recycle();
                                Bitmap unused5 = tile.bitmap = null;
                            }
                        }
                    } else if (tile.sampleSize == this.fullImageSampleSize) {
                        boolean unused6 = tile.visible = true;
                    }
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z4) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z4);
        }
    }

    /* JADX INFO: finally extract failed */
    private void reset(boolean z4) {
        OnImageEventListener onImageEventListener2;
        debug("reset newImage=" + z4, new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z4) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null) {
                    imageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 != null && !this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                if (!(this.bitmap == null || !this.bitmapIsCached || (onImageEventListener2 = this.onImageEventListener) == null)) {
                    onImageEventListener2.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (Throwable th) {
                this.decoderLock.writeLock().unlock();
                throw th;
            }
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> value : map.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    boolean unused = tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        Bitmap unused2 = tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sWidth;
        }
        return this.sHeight;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        if (requiredRotation == 90 || requiredRotation == 270) {
            return this.sHeight;
        }
        return this.sWidth;
    }

    private void sendStateChanged(float f4, PointF pointF, int i4) {
        OnStateChangedListener onStateChangedListener2 = this.onStateChangedListener;
        if (onStateChangedListener2 != null) {
            float f5 = this.scale;
            if (f5 != f4) {
                onStateChangedListener2.onScaleChanged(f5, i4);
            }
        }
        if (this.onStateChangedListener != null && !this.vTranslate.equals(pointF)) {
            this.onStateChangedListener.onCenterChanged(getCenter(), i4);
        }
    }

    /* access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!SubsamplingScaleImageView.this.zoomEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                SubsamplingScaleImageView.this.setGestureDetector(context);
                if (SubsamplingScaleImageView.this.quickScaleEnabled) {
                    PointF unused = SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused2 = SubsamplingScaleImageView.this.vTranslateStart = new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    float unused3 = subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                    boolean unused4 = SubsamplingScaleImageView.this.isQuickScaling = true;
                    boolean unused5 = SubsamplingScaleImageView.this.isZooming = true;
                    float unused6 = SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                    SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                    PointF unused7 = subsamplingScaleImageView2.quickScaleSCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                    PointF unused8 = SubsamplingScaleImageView.this.quickScaleVStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused9 = SubsamplingScaleImageView.this.quickScaleVLastPoint = new PointF(SubsamplingScaleImageView.this.quickScaleSCenter.x, SubsamplingScaleImageView.this.quickScaleSCenter.y);
                    boolean unused10 = SubsamplingScaleImageView.this.quickScaleMoved = false;
                    return false;
                }
                SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f4, float f5) {
                if (!SubsamplingScaleImageView.this.panEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f4) <= 500.0f && Math.abs(f5) <= 500.0f) || SubsamplingScaleImageView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f4, f5);
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.vTranslate.x + (f4 * 0.25f), SubsamplingScaleImageView.this.vTranslate.y + (f5 * 0.25f));
                new AnimationBuilder(new PointF((((float) (SubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.this.scale, (((float) (SubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
        this.singleDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    private void setMatrixArray(float[] fArr, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        fArr[0] = f4;
        fArr[1] = f5;
        fArr[2] = f6;
        fArr[3] = f7;
        fArr[4] = f8;
        fArr[5] = f9;
        fArr[6] = f10;
        fArr[7] = f11;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    private void sourceToViewRect(@NonNull Rect rect, @NonNull Rect rect2) {
        rect2.set((int) sourceToViewX((float) rect.left), (int) sourceToViewY((float) rect.top), (int) sourceToViewX((float) rect.right), (int) sourceToViewY((float) rect.bottom));
    }

    private float sourceToViewX(float f4) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f4 * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f4) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f4 * this.scale) + pointF.y;
    }

    private boolean tileVisible(Tile tile) {
        float viewToSourceX = viewToSourceX(0.0f);
        float viewToSourceX2 = viewToSourceX((float) getWidth());
        float viewToSourceY = viewToSourceY(0.0f);
        float viewToSourceY2 = viewToSourceY((float) getHeight());
        if (viewToSourceX > ((float) tile.sRect.right) || ((float) tile.sRect.left) > viewToSourceX2 || viewToSourceY > ((float) tile.sRect.bottom) || ((float) tile.sRect.top) > viewToSourceY2) {
            return false;
        }
        return true;
    }

    @NonNull
    private PointF vTranslateForSCenter(float f4, float f5, float f6) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.satTemp.scale = f6;
        this.satTemp.vTranslate.set(((float) paddingLeft) - (f4 * f6), ((float) paddingTop) - (f5 * f6));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f4) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f4 - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f4) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f4 - pointF.y) / this.scale;
    }

    @Nullable
    public AnimationBuilder animateCenter(PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(pointF);
    }

    @Nullable
    public AnimationBuilder animateScale(float f4) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f4);
    }

    @Nullable
    public AnimationBuilder animateScaleAndCenter(float f4, PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f4, pointF);
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    @Nullable
    public final PointF getCenter() {
        return viewToSourceCoord((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void getPanRemaining(RectF rectF) {
        if (isReady()) {
            float sWidth2 = this.scale * ((float) sWidth());
            float sHeight2 = this.scale * ((float) sHeight());
            int i4 = this.panLimit;
            if (i4 == 3) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - ((float) (getHeight() / 2))));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - ((float) (getWidth() / 2))));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y - (((float) (getHeight() / 2)) - sHeight2));
                rectF.right = Math.max(0.0f, this.vTranslate.x - (((float) (getWidth() / 2)) - sWidth2));
            } else if (i4 == 2) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - ((float) getHeight())));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - ((float) getWidth())));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y + sHeight2);
                rectF.right = Math.max(0.0f, this.vTranslate.x + sWidth2);
            } else {
                rectF.top = Math.max(0.0f, -this.vTranslate.y);
                rectF.left = Math.max(0.0f, -this.vTranslate.x);
                rectF.bottom = Math.max(0.0f, (sHeight2 + this.vTranslate.y) - ((float) getHeight()));
                rectF.right = Math.max(0.0f, (sWidth2 + this.vTranslate.x) - ((float) getWidth()));
            }
        }
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    @Nullable
    public final ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public boolean hasImage() {
        if (this.uri == null && this.bitmap == null) {
            return false;
        }
        return true;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        char c5;
        int i4;
        float f4;
        int i5;
        Canvas canvas2 = canvas;
        super.onDraw(canvas);
        createPaints();
        if (this.sWidth != 0 && this.sHeight != 0 && getWidth() != 0 && getHeight() != 0) {
            if (this.tileMap == null && this.decoder != null) {
                initialiseBaseLayer(getMaxBitmapDimensions(canvas));
            }
            if (checkReady()) {
                preDraw();
                Anim anim2 = this.anim;
                if (!(anim2 == null || anim2.vFocusStart == null)) {
                    float f5 = this.scale;
                    if (this.vTranslateBefore == null) {
                        this.vTranslateBefore = new PointF(0.0f, 0.0f);
                    }
                    this.vTranslateBefore.set(this.vTranslate);
                    long currentTimeMillis = System.currentTimeMillis() - this.anim.time;
                    boolean z4 = currentTimeMillis > this.anim.duration;
                    long min = Math.min(currentTimeMillis, this.anim.duration);
                    this.scale = ease(this.anim.easing, min, this.anim.scaleStart, this.anim.scaleEnd - this.anim.scaleStart, this.anim.duration);
                    float ease = ease(this.anim.easing, min, this.anim.vFocusStart.x, this.anim.vFocusEnd.x - this.anim.vFocusStart.x, this.anim.duration);
                    float ease2 = ease(this.anim.easing, min, this.anim.vFocusStart.y, this.anim.vFocusEnd.y - this.anim.vFocusStart.y, this.anim.duration);
                    this.vTranslate.x -= sourceToViewX(this.anim.sCenterEnd.x) - ease;
                    this.vTranslate.y -= sourceToViewY(this.anim.sCenterEnd.y) - ease2;
                    fitToBounds(z4 || this.anim.scaleStart == this.anim.scaleEnd);
                    sendStateChanged(f5, this.vTranslateBefore, this.anim.origin);
                    refreshRequiredTiles(z4);
                    if (z4) {
                        if (this.anim.listener != null) {
                            try {
                                this.anim.listener.onComplete();
                            } catch (Exception e5) {
                                Log.w(TAG, "Error thrown by animation listener", e5);
                            }
                        }
                        this.anim = null;
                    }
                    invalidate();
                }
                if (this.tileMap == null || !isBaseLayerReady()) {
                    i4 = 5;
                    c5 = 0;
                    Bitmap bitmap2 = this.bitmap;
                    if (bitmap2 != null) {
                        float f6 = this.scale;
                        if (this.bitmapIsPreview) {
                            f6 *= ((float) this.sWidth) / ((float) bitmap2.getWidth());
                            f4 = this.scale * (((float) this.sHeight) / ((float) this.bitmap.getHeight()));
                        } else {
                            f4 = f6;
                        }
                        if (this.matrix == null) {
                            this.matrix = new Matrix();
                        }
                        this.matrix.reset();
                        this.matrix.postScale(f6, f4);
                        this.matrix.postRotate((float) getRequiredRotation());
                        Matrix matrix2 = this.matrix;
                        PointF pointF = this.vTranslate;
                        matrix2.postTranslate(pointF.x, pointF.y);
                        if (getRequiredRotation() == 180) {
                            Matrix matrix3 = this.matrix;
                            float f7 = this.scale;
                            matrix3.postTranslate(((float) this.sWidth) * f7, f7 * ((float) this.sHeight));
                        } else if (getRequiredRotation() == 90) {
                            this.matrix.postTranslate(this.scale * ((float) this.sHeight), 0.0f);
                        } else if (getRequiredRotation() == 270) {
                            this.matrix.postTranslate(0.0f, this.scale * ((float) this.sWidth));
                        }
                        if (this.tileBgPaint != null) {
                            if (this.sRect == null) {
                                this.sRect = new RectF();
                            }
                            this.sRect.set(0.0f, 0.0f, (float) (this.bitmapIsPreview ? this.bitmap.getWidth() : this.sWidth), (float) (this.bitmapIsPreview ? this.bitmap.getHeight() : this.sHeight));
                            this.matrix.mapRect(this.sRect);
                            canvas2.drawRect(this.sRect, this.tileBgPaint);
                        }
                        canvas2.drawBitmap(this.bitmap, this.matrix, this.bitmapPaint);
                    }
                } else {
                    int min2 = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
                    boolean z5 = false;
                    for (Map.Entry next : this.tileMap.entrySet()) {
                        if (((Integer) next.getKey()).intValue() == min2) {
                            for (Tile tile : (List) next.getValue()) {
                                if (tile.visible && (tile.loading || tile.bitmap == null)) {
                                    z5 = true;
                                }
                            }
                        }
                    }
                    for (Map.Entry next2 : this.tileMap.entrySet()) {
                        if (((Integer) next2.getKey()).intValue() == min2 || z5) {
                            for (Tile tile2 : (List) next2.getValue()) {
                                sourceToViewRect(tile2.sRect, tile2.vRect);
                                if (tile2.loading || tile2.bitmap == null) {
                                    i5 = 5;
                                    if (tile2.loading && this.debug) {
                                        canvas2.drawText("LOADING", (float) (tile2.vRect.left + px(5)), (float) (tile2.vRect.top + px(35)), this.debugTextPaint);
                                    }
                                } else {
                                    if (this.tileBgPaint != null) {
                                        canvas2.drawRect(tile2.vRect, this.tileBgPaint);
                                    }
                                    if (this.matrix == null) {
                                        this.matrix = new Matrix();
                                    }
                                    this.matrix.reset();
                                    i5 = 5;
                                    setMatrixArray(this.srcArray, 0.0f, 0.0f, (float) tile2.bitmap.getWidth(), 0.0f, (float) tile2.bitmap.getWidth(), (float) tile2.bitmap.getHeight(), 0.0f, (float) tile2.bitmap.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        setMatrixArray(this.dstArray, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom);
                                    } else if (getRequiredRotation() == 90) {
                                        setMatrixArray(this.dstArray, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top);
                                    } else if (getRequiredRotation() == 180) {
                                        setMatrixArray(this.dstArray, (float) tile2.vRect.right, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top);
                                    } else if (getRequiredRotation() == 270) {
                                        setMatrixArray(this.dstArray, (float) tile2.vRect.left, (float) tile2.vRect.bottom, (float) tile2.vRect.left, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.top, (float) tile2.vRect.right, (float) tile2.vRect.bottom);
                                    }
                                    this.matrix.setPolyToPoly(this.srcArray, 0, this.dstArray, 0, 4);
                                    canvas2.drawBitmap(tile2.bitmap, this.matrix, this.bitmapPaint);
                                    if (this.debug) {
                                        canvas2.drawRect(tile2.vRect, this.debugLinePaint);
                                    }
                                }
                                if (tile2.visible && this.debug) {
                                    canvas2.drawText("ISS " + tile2.sampleSize + " RECT " + tile2.sRect.top + "," + tile2.sRect.left + "," + tile2.sRect.bottom + "," + tile2.sRect.right, (float) (tile2.vRect.left + px(i5)), (float) (tile2.vRect.top + px(15)), this.debugTextPaint);
                                }
                            }
                        }
                    }
                    i4 = 5;
                    c5 = 0;
                }
                if (this.debug) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Scale: ");
                    Locale locale = Locale.ENGLISH;
                    Object[] objArr = new Object[1];
                    objArr[c5] = Float.valueOf(this.scale);
                    sb.append(String.format(locale, "%.2f", objArr));
                    sb.append(" (");
                    Object[] objArr2 = new Object[1];
                    objArr2[c5] = Float.valueOf(minScale());
                    sb.append(String.format(locale, "%.2f", objArr2));
                    sb.append(" - ");
                    Object[] objArr3 = new Object[1];
                    objArr3[c5] = Float.valueOf(this.maxScale);
                    sb.append(String.format(locale, "%.2f", objArr3));
                    sb.append(")");
                    canvas2.drawText(sb.toString(), (float) px(i4), (float) px(15), this.debugTextPaint);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Translate: ");
                    Object[] objArr4 = new Object[1];
                    objArr4[c5] = Float.valueOf(this.vTranslate.x);
                    sb2.append(String.format(locale, "%.2f", objArr4));
                    sb2.append(":");
                    Object[] objArr5 = new Object[1];
                    objArr5[c5] = Float.valueOf(this.vTranslate.y);
                    sb2.append(String.format(locale, "%.2f", objArr5));
                    canvas2.drawText(sb2.toString(), (float) px(i4), (float) px(30), this.debugTextPaint);
                    PointF center = getCenter();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Source center: ");
                    Object[] objArr6 = new Object[1];
                    objArr6[c5] = Float.valueOf(center.x);
                    sb3.append(String.format(locale, "%.2f", objArr6));
                    sb3.append(":");
                    Object[] objArr7 = new Object[1];
                    objArr7[c5] = Float.valueOf(center.y);
                    sb3.append(String.format(locale, "%.2f", objArr7));
                    canvas2.drawText(sb3.toString(), (float) px(i4), (float) px(45), this.debugTextPaint);
                    Anim anim3 = this.anim;
                    if (anim3 != null) {
                        PointF sourceToViewCoord = sourceToViewCoord(anim3.sCenterStart);
                        PointF sourceToViewCoord2 = sourceToViewCoord(this.anim.sCenterEndRequested);
                        PointF sourceToViewCoord3 = sourceToViewCoord(this.anim.sCenterEnd);
                        canvas2.drawCircle(sourceToViewCoord.x, sourceToViewCoord.y, (float) px(10), this.debugLinePaint);
                        this.debugLinePaint.setColor(SupportMenu.CATEGORY_MASK);
                        canvas2.drawCircle(sourceToViewCoord2.x, sourceToViewCoord2.y, (float) px(20), this.debugLinePaint);
                        this.debugLinePaint.setColor(-16776961);
                        canvas2.drawCircle(sourceToViewCoord3.x, sourceToViewCoord3.y, (float) px(25), this.debugLinePaint);
                        this.debugLinePaint.setColor(-16711681);
                        canvas2.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) px(30), this.debugLinePaint);
                    }
                    if (this.vCenterStart != null) {
                        this.debugLinePaint.setColor(SupportMenu.CATEGORY_MASK);
                        PointF pointF2 = this.vCenterStart;
                        canvas2.drawCircle(pointF2.x, pointF2.y, (float) px(20), this.debugLinePaint);
                    }
                    if (this.quickScaleSCenter != null) {
                        this.debugLinePaint.setColor(-16776961);
                        canvas2.drawCircle(sourceToViewX(this.quickScaleSCenter.x), sourceToViewY(this.quickScaleSCenter.y), (float) px(35), this.debugLinePaint);
                    }
                    if (this.quickScaleVStart != null && this.isQuickScaling) {
                        this.debugLinePaint.setColor(-16711681);
                        PointF pointF3 = this.quickScaleVStart;
                        canvas2.drawCircle(pointF3.x, pointF3.y, (float) px(30), this.debugLinePaint);
                    }
                    this.debugLinePaint.setColor(-65281);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onImageLoaded() {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i4, int i5) {
        boolean z4;
        int mode = View.MeasureSpec.getMode(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        boolean z5 = false;
        if (mode != 1073741824) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (mode2 != 1073741824) {
            z5 = true;
        }
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z4 && z5) {
                size = sWidth();
                size2 = sHeight();
            } else if (z5) {
                size2 = (int) ((((double) sHeight()) / ((double) sWidth())) * ((double) size));
            } else if (z4) {
                size = (int) ((((double) sWidth()) / ((double) sHeight())) * ((double) size2));
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    /* access modifiers changed from: protected */
    public void onReady() {
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i4, int i5, int i6, int i7) {
        debug("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i4), Integer.valueOf(i5));
        PointF center = getCenter();
        if (this.readySent && center != null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim2 = this.anim;
        if (anim2 == null || anim2.interruptible) {
            Anim anim3 = this.anim;
            if (!(anim3 == null || anim3.listener == null)) {
                try {
                    this.anim.listener.onInterruptedByUser();
                } catch (Exception e5) {
                    Log.w(TAG, "Error thrown by animation listener", e5);
                }
            }
            this.anim = null;
            if (this.vTranslate == null) {
                GestureDetector gestureDetector2 = this.singleDetector;
                if (gestureDetector2 != null) {
                    gestureDetector2.onTouchEvent(motionEvent);
                }
                return true;
            } else if (this.isQuickScaling || ((gestureDetector = this.detector) != null && !gestureDetector.onTouchEvent(motionEvent))) {
                if (this.vTranslateStart == null) {
                    this.vTranslateStart = new PointF(0.0f, 0.0f);
                }
                if (this.vTranslateBefore == null) {
                    this.vTranslateBefore = new PointF(0.0f, 0.0f);
                }
                if (this.vCenterStart == null) {
                    this.vCenterStart = new PointF(0.0f, 0.0f);
                }
                float f4 = this.scale;
                this.vTranslateBefore.set(this.vTranslate);
                boolean onTouchEventInternal = onTouchEventInternal(motionEvent);
                sendStateChanged(f4, this.vTranslateBefore, 2);
                if (onTouchEventInternal || super.onTouchEvent(motionEvent)) {
                    return true;
                }
                return false;
            } else {
                this.isZooming = false;
                this.isPanning = false;
                this.maxTouchCount = 0;
                return true;
            }
        } else {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF((float) (sWidth() / 2), (float) (sHeight() / 2));
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void setBitmapDecoderClass(@NonNull Class<? extends ImageDecoder> cls) {
        if (cls != null) {
            this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(@NonNull DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.bitmapDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z4) {
        this.debug = z4;
    }

    public final void setDoubleTapZoomDpi(int i4) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i4));
    }

    public final void setDoubleTapZoomDuration(int i4) {
        this.doubleTapZoomDuration = Math.max(0, i4);
    }

    public final void setDoubleTapZoomScale(float f4) {
        this.doubleTapZoomScale = f4;
    }

    public final void setDoubleTapZoomStyle(int i4) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i4))) {
            this.doubleTapZoomStyle = i4;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i4);
    }

    public void setEagerLoadingEnabled(boolean z4) {
        this.eagerLoadingEnabled = z4;
    }

    public void setExecutor(@NonNull Executor executor2) {
        if (executor2 != null) {
            this.executor = executor2;
            return;
        }
        throw new NullPointerException("Executor must not be null");
    }

    public final void setImage(@NonNull ImageSource imageSource) {
        setImage(imageSource, (ImageSource) null, (ImageViewState) null);
    }

    public final void setMaxScale(float f4) {
        this.maxScale = f4;
    }

    public void setMaxTileSize(int i4) {
        this.maxTileWidth = i4;
        this.maxTileHeight = i4;
    }

    public final void setMaximumDpi(int i4) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i4));
    }

    public final void setMinScale(float f4) {
        this.minScale = f4;
    }

    public final void setMinimumDpi(int i4) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i4));
    }

    public final void setMinimumScaleType(int i4) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i4))) {
            this.minimumScaleType = i4;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i4);
    }

    public void setMinimumTileDpi(int i4) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, (float) i4);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener2) {
        this.onImageEventListener = onImageEventListener2;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener2) {
        this.onLongClickListener = onLongClickListener2;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener2) {
        this.onStateChangedListener = onStateChangedListener2;
    }

    public final void setOrientation(int i4) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i4))) {
            this.orientation = i4;
            reset(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i4);
    }

    public final void setPanEnabled(boolean z4) {
        PointF pointF;
        this.panEnabled = z4;
        if (!z4 && (pointF = this.vTranslate) != null) {
            pointF.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
            if (isReady()) {
                refreshRequiredTiles(true);
                invalidate();
            }
        }
    }

    public final void setPanLimit(int i4) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i4))) {
            this.panLimit = i4;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i4);
    }

    public final void setQuickScaleEnabled(boolean z4) {
        this.quickScaleEnabled = z4;
    }

    public final void setRegionDecoderClass(@NonNull Class<? extends ImageRegionDecoder> cls) {
        if (cls != null) {
            this.regionDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(@NonNull DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.regionDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setScaleAndCenter(float f4, @Nullable PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f4);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i4) {
        if (Color.alpha(i4) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i4);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z4) {
        this.zoomEnabled = z4;
    }

    @Nullable
    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public void viewToFileRect(Rect rect, Rect rect2) {
        if (this.vTranslate != null && this.readySent) {
            rect2.set((int) viewToSourceX((float) rect.left), (int) viewToSourceY((float) rect.top), (int) viewToSourceX((float) rect.right), (int) viewToSourceY((float) rect.bottom));
            fileSRect(rect2, rect2);
            rect2.set(Math.max(0, rect2.left), Math.max(0, rect2.top), Math.min(this.sWidth, rect2.right), Math.min(this.sHeight, rect2.bottom));
            Rect rect3 = this.sRegion;
            if (rect3 != null) {
                rect2.offset(rect3.left, rect3.top);
            }
        }
    }

    @Nullable
    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public void visibleFileRect(Rect rect) {
        if (this.vTranslate != null && this.readySent) {
            rect.set(0, 0, getWidth(), getHeight());
            viewToFileRect(rect, rect);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap2, int i4, boolean z4) {
        OnImageEventListener onImageEventListener2;
        try {
            debug("onImageLoaded", new Object[0]);
            int i5 = this.sWidth;
            if (i5 > 0 && this.sHeight > 0) {
                if (i5 == bitmap2.getWidth()) {
                    if (this.sHeight != bitmap2.getHeight()) {
                    }
                }
                reset(false);
            }
            Bitmap bitmap3 = this.bitmap;
            if (bitmap3 != null && !this.bitmapIsCached) {
                bitmap3.recycle();
            }
            if (!(this.bitmap == null || !this.bitmapIsCached || (onImageEventListener2 = this.onImageEventListener) == null)) {
                onImageEventListener2.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = z4;
            this.bitmap = bitmap2;
            this.sWidth = bitmap2.getWidth();
            this.sHeight = bitmap2.getHeight();
            this.sOrientation = i4;
            boolean checkReady = checkReady();
            boolean checkImageLoaded = checkImageLoaded();
            if (checkReady || checkImageLoaded) {
                invalidate();
                requestLayout();
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, (ImageSource) null, imageViewState);
    }

    @Nullable
    public final PointF sourceToViewCoord(float f4, float f5) {
        return sourceToViewCoord(f4, f5, new PointF());
    }

    @Nullable
    public final PointF viewToSourceCoord(float f4, float f5) {
        return viewToSourceCoord(f4, f5, new PointF());
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, (ImageViewState) null);
    }

    public void setMaxTileSize(int i4, int i5) {
        this.maxTileWidth = i4;
        this.maxTileHeight = i5;
    }

    @Nullable
    public final PointF sourceToViewCoord(PointF pointF, @NonNull PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    @Nullable
    public final PointF viewToSourceCoord(PointF pointF, @NonNull PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        /* access modifiers changed from: private */
        @NonNull
        public AnimationBuilder withOrigin(int i4) {
            this.origin = i4;
            return this;
        }

        /* access modifiers changed from: private */
        @NonNull
        public AnimationBuilder withPanLimited(boolean z4) {
            this.panLimited = z4;
            return this;
        }

        public void start() {
            PointF pointF;
            if (!(SubsamplingScaleImageView.this.anim == null || SubsamplingScaleImageView.this.anim.listener == null)) {
                try {
                    SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e5) {
                    Log.w(SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e5);
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float access$6500 = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            if (this.panLimited) {
                SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                PointF pointF2 = this.targetSCenter;
                pointF = subsamplingScaleImageView.limitedSCenter(pointF2.x, pointF2.y, access$6500, new PointF());
            } else {
                pointF = this.targetSCenter;
            }
            Anim unused = SubsamplingScaleImageView.this.anim = new Anim();
            float unused2 = SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            float unused3 = SubsamplingScaleImageView.this.anim.scaleEnd = access$6500;
            long unused4 = SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            PointF unused5 = SubsamplingScaleImageView.this.anim.sCenterEndRequested = pointF;
            PointF unused6 = SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            PointF unused7 = SubsamplingScaleImageView.this.anim.sCenterEnd = pointF;
            PointF unused8 = SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(pointF);
            PointF unused9 = SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF((float) paddingLeft, (float) paddingTop);
            long unused10 = SubsamplingScaleImageView.this.anim.duration = this.duration;
            boolean unused11 = SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            int unused12 = SubsamplingScaleImageView.this.anim.easing = this.easing;
            int unused13 = SubsamplingScaleImageView.this.anim.origin = this.origin;
            long unused14 = SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            OnAnimationEventListener unused15 = SubsamplingScaleImageView.this.anim.listener = this.listener;
            PointF pointF3 = this.vFocus;
            if (pointF3 != null) {
                float f4 = pointF3.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * access$6500);
                float f5 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * access$6500);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(access$6500, new PointF(f4, f5));
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                PointF unused16 = SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f4), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f5));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        @NonNull
        public AnimationBuilder withDuration(long j4) {
            this.duration = j4;
            return this;
        }

        @NonNull
        public AnimationBuilder withEasing(int i4) {
            if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i4))) {
                this.easing = i4;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i4);
        }

        @NonNull
        public AnimationBuilder withInterruptible(boolean z4) {
            this.interruptible = z4;
            return this;
        }

        @NonNull
        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }

        private AnimationBuilder(PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f4) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f4;
            this.targetSCenter = SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f4, PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f4;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f4, PointF pointF, PointF pointF2) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f4;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }
    }

    public final void setImage(@NonNull ImageSource imageSource, ImageSource imageSource2, ImageViewState imageViewState) {
        if (imageSource != null) {
            reset(true);
            if (imageViewState != null) {
                restoreState(imageViewState);
            }
            if (imageSource2 != null) {
                if (imageSource.getBitmap() != null) {
                    throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
                } else if (imageSource.getSWidth() <= 0 || imageSource.getSHeight() <= 0) {
                    throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
                } else {
                    this.sWidth = imageSource.getSWidth();
                    this.sHeight = imageSource.getSHeight();
                    this.pRegion = imageSource2.getSRegion();
                    if (imageSource2.getBitmap() != null) {
                        this.bitmapIsCached = imageSource2.isCached();
                        onPreviewLoaded(imageSource2.getBitmap());
                    } else {
                        Uri uri2 = imageSource2.getUri();
                        if (uri2 == null && imageSource2.getResource() != null) {
                            uri2 = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource2.getResource());
                        }
                        execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, uri2, true));
                    }
                }
            }
            if (imageSource.getBitmap() != null && imageSource.getSRegion() != null) {
                onImageLoaded(Bitmap.createBitmap(imageSource.getBitmap(), imageSource.getSRegion().left, imageSource.getSRegion().top, imageSource.getSRegion().width(), imageSource.getSRegion().height()), 0, false);
            } else if (imageSource.getBitmap() != null) {
                onImageLoaded(imageSource.getBitmap(), 0, imageSource.isCached());
            } else {
                this.sRegion = imageSource.getSRegion();
                Uri uri3 = imageSource.getUri();
                this.uri = uri3;
                if (uri3 == null && imageSource.getResource() != null) {
                    this.uri = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + imageSource.getResource());
                }
                if (imageSource.getTile() || this.sRegion != null) {
                    execute(new TilesInitTask(this, getContext(), this.regionDecoderFactory, this.uri));
                    return;
                }
                execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
            }
        } else {
            throw new NullPointerException("imageSource must not be null");
        }
    }

    @Nullable
    public final PointF sourceToViewCoord(float f4, float f5, @NonNull PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f4), sourceToViewY(f5));
        return pointF;
    }

    @Nullable
    public final PointF viewToSourceCoord(float f4, float f5, @NonNull PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f4), viewToSourceY(f5));
        return pointF;
    }

    private void fitToBounds(boolean z4) {
        boolean z5;
        if (this.vTranslate == null) {
            this.vTranslate = new PointF(0.0f, 0.0f);
            z5 = true;
        } else {
            z5 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z4, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (z5 && this.minimumScaleType != 4) {
            this.vTranslate.set(vTranslateForSCenter((float) (sWidth() / 2), (float) (sHeight() / 2), this.scale));
        }
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, (AttributeSet) null);
    }
}
