package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.uptodown.R;

public final class c1 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10256a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f10257b;

    /* renamed from: c  reason: collision with root package name */
    public final YouTubePlayerView f10258c;

    private c1(RelativeLayout relativeLayout, FrameLayout frameLayout, YouTubePlayerView youTubePlayerView) {
        this.f10256a = relativeLayout;
        this.f10257b = frameLayout;
        this.f10258c = youTubePlayerView;
    }

    public static c1 a(View view) {
        int i4 = R.id.youtube_full_screen;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.youtube_full_screen);
        if (frameLayout != null) {
            i4 = R.id.youtube_view;
            YouTubePlayerView youTubePlayerView = (YouTubePlayerView) ViewBindings.findChildViewById(view, R.id.youtube_view);
            if (youTubePlayerView != null) {
                return new c1((RelativeLayout) view, frameLayout, youTubePlayerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    public static c1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static c1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.video_youtube, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10256a;
    }
}
