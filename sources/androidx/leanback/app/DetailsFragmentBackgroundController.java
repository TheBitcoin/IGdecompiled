package androidx.leanback.app;

import android.animation.PropertyValuesHolder;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.R;
import androidx.leanback.graphics.FitWidthBitmapDrawable;
import androidx.leanback.media.PlaybackGlue;
import androidx.leanback.media.PlaybackGlueHost;
import androidx.leanback.widget.DetailsParallaxDrawable;
import androidx.leanback.widget.ParallaxTarget;

@Deprecated
public class DetailsFragmentBackgroundController {
    boolean mCanUseHost = false;
    Bitmap mCoverBitmap;
    final DetailsFragment mFragment;
    boolean mInitialControlVisible = false;
    private Fragment mLastVideoFragmentForGlueHost;
    DetailsParallaxDrawable mParallaxDrawable;
    int mParallaxDrawableMaxOffset;
    PlaybackGlue mPlaybackGlue;
    int mSolidColor;
    DetailsBackgroundVideoHelper mVideoHelper;

    public DetailsFragmentBackgroundController(DetailsFragment detailsFragment) {
        if (detailsFragment.mDetailsBackgroundController == null) {
            detailsFragment.mDetailsBackgroundController = this;
            this.mFragment = detailsFragment;
            return;
        }
        throw new IllegalStateException("Each DetailsFragment is allowed to initialize DetailsFragmentBackgroundController once");
    }

    public boolean canNavigateToVideoFragment() {
        if (this.mPlaybackGlue != null) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public PlaybackGlueHost createGlueHost() {
        PlaybackGlueHost onCreateGlueHost = onCreateGlueHost();
        if (this.mInitialControlVisible) {
            onCreateGlueHost.showControlsOverlay(false);
            return onCreateGlueHost;
        }
        onCreateGlueHost.hideControlsOverlay(false);
        return onCreateGlueHost;
    }

    /* access modifiers changed from: package-private */
    public boolean disableVideoParallax() {
        DetailsBackgroundVideoHelper detailsBackgroundVideoHelper = this.mVideoHelper;
        if (detailsBackgroundVideoHelper == null) {
            return false;
        }
        detailsBackgroundVideoHelper.stopParallax();
        return this.mVideoHelper.isVideoVisible();
    }

    public void enableParallax() {
        int i4 = this.mParallaxDrawableMaxOffset;
        if (i4 == 0) {
            i4 = FragmentUtil.getContext(this.mFragment).getResources().getDimensionPixelSize(R.dimen.lb_details_cover_drawable_parallax_movement);
        }
        FitWidthBitmapDrawable fitWidthBitmapDrawable = new FitWidthBitmapDrawable();
        enableParallax(fitWidthBitmapDrawable, new ColorDrawable(), new ParallaxTarget.PropertyValuesHolderTarget(fitWidthBitmapDrawable, PropertyValuesHolder.ofInt(FitWidthBitmapDrawable.PROPERTY_VERTICAL_OFFSET, new int[]{0, -i4})));
    }

    public final Fragment findOrCreateVideoFragment() {
        return this.mFragment.findOrCreateVideoFragment();
    }

    public final Drawable getBottomDrawable() {
        DetailsParallaxDrawable detailsParallaxDrawable = this.mParallaxDrawable;
        if (detailsParallaxDrawable == null) {
            return null;
        }
        return detailsParallaxDrawable.getBottomDrawable();
    }

    public final Bitmap getCoverBitmap() {
        return this.mCoverBitmap;
    }

    public final Drawable getCoverDrawable() {
        DetailsParallaxDrawable detailsParallaxDrawable = this.mParallaxDrawable;
        if (detailsParallaxDrawable == null) {
            return null;
        }
        return detailsParallaxDrawable.getCoverDrawable();
    }

    public final int getParallaxDrawableMaxOffset() {
        return this.mParallaxDrawableMaxOffset;
    }

    public final PlaybackGlue getPlaybackGlue() {
        return this.mPlaybackGlue;
    }

    @ColorInt
    public final int getSolidColor() {
        return this.mSolidColor;
    }

    public PlaybackGlueHost onCreateGlueHost() {
        return new VideoFragmentGlueHost((VideoFragment) findOrCreateVideoFragment());
    }

    public Fragment onCreateVideoFragment() {
        return new VideoFragment();
    }

    /* access modifiers changed from: package-private */
    public void onStart() {
        if (!this.mCanUseHost) {
            this.mCanUseHost = true;
            PlaybackGlue playbackGlue = this.mPlaybackGlue;
            if (playbackGlue != null) {
                playbackGlue.setHost(createGlueHost());
                this.mLastVideoFragmentForGlueHost = findOrCreateVideoFragment();
            }
        }
        PlaybackGlue playbackGlue2 = this.mPlaybackGlue;
        if (playbackGlue2 != null && playbackGlue2.isPrepared()) {
            this.mPlaybackGlue.play();
        }
    }

    /* access modifiers changed from: package-private */
    public void onStop() {
        PlaybackGlue playbackGlue = this.mPlaybackGlue;
        if (playbackGlue != null) {
            playbackGlue.pause();
        }
    }

    public final void setCoverBitmap(Bitmap bitmap) {
        this.mCoverBitmap = bitmap;
        Drawable coverDrawable = getCoverDrawable();
        if (coverDrawable instanceof FitWidthBitmapDrawable) {
            ((FitWidthBitmapDrawable) coverDrawable).setBitmap(this.mCoverBitmap);
        }
    }

    public final void setParallaxDrawableMaxOffset(int i4) {
        if (this.mParallaxDrawable == null) {
            this.mParallaxDrawableMaxOffset = i4;
            return;
        }
        throw new IllegalStateException("enableParallax already called");
    }

    public final void setSolidColor(@ColorInt int i4) {
        this.mSolidColor = i4;
        Drawable bottomDrawable = getBottomDrawable();
        if (bottomDrawable instanceof ColorDrawable) {
            ((ColorDrawable) bottomDrawable).setColor(i4);
        }
    }

    public void setupVideoPlayback(@NonNull PlaybackGlue playbackGlue) {
        PlaybackGlue playbackGlue2 = this.mPlaybackGlue;
        if (playbackGlue2 != playbackGlue) {
            PlaybackGlueHost playbackGlueHost = null;
            if (playbackGlue2 != null) {
                PlaybackGlueHost host = playbackGlue2.getHost();
                this.mPlaybackGlue.setHost((PlaybackGlueHost) null);
                playbackGlueHost = host;
            }
            this.mPlaybackGlue = playbackGlue;
            this.mVideoHelper.setPlaybackGlue(playbackGlue);
            if (this.mCanUseHost && this.mPlaybackGlue != null) {
                if (playbackGlueHost == null || this.mLastVideoFragmentForGlueHost != findOrCreateVideoFragment()) {
                    this.mPlaybackGlue.setHost(createGlueHost());
                    this.mLastVideoFragmentForGlueHost = findOrCreateVideoFragment();
                    return;
                }
                this.mPlaybackGlue.setHost(playbackGlueHost);
            }
        }
    }

    public final void switchToRows() {
        this.mFragment.switchToRows();
    }

    public final void switchToVideo() {
        this.mFragment.switchToVideo();
    }

    /* access modifiers changed from: package-private */
    public void switchToVideoBeforeCreate() {
        this.mVideoHelper.crossFadeBackgroundToVideo(true, true);
        this.mInitialControlVisible = true;
    }

    public void enableParallax(@NonNull Drawable drawable, @NonNull Drawable drawable2, @Nullable ParallaxTarget.PropertyValuesHolderTarget propertyValuesHolderTarget) {
        if (this.mParallaxDrawable == null) {
            Bitmap bitmap = this.mCoverBitmap;
            if (bitmap != null && (drawable instanceof FitWidthBitmapDrawable)) {
                ((FitWidthBitmapDrawable) drawable).setBitmap(bitmap);
            }
            int i4 = this.mSolidColor;
            if (i4 != 0 && (drawable2 instanceof ColorDrawable)) {
                ((ColorDrawable) drawable2).setColor(i4);
            }
            if (this.mPlaybackGlue == null) {
                DetailsParallaxDrawable detailsParallaxDrawable = new DetailsParallaxDrawable(FragmentUtil.getContext(this.mFragment), this.mFragment.getParallax(), drawable, drawable2, propertyValuesHolderTarget);
                this.mParallaxDrawable = detailsParallaxDrawable;
                this.mFragment.setBackgroundDrawable(detailsParallaxDrawable);
                this.mVideoHelper = new DetailsBackgroundVideoHelper((PlaybackGlue) null, this.mFragment.getParallax(), this.mParallaxDrawable.getCoverDrawable());
                return;
            }
            throw new IllegalStateException("enableParallaxDrawable must be called before enableVideoPlayback");
        }
    }
}
