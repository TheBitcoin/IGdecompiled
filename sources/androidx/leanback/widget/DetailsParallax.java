package androidx.leanback.widget;

import androidx.leanback.R;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.RecyclerViewParallax;

public class DetailsParallax extends RecyclerViewParallax {
    final Parallax.IntProperty mFrameBottom;
    final Parallax.IntProperty mFrameTop;

    public DetailsParallax() {
        RecyclerViewParallax.ChildPositionProperty adapterPosition = ((RecyclerViewParallax.ChildPositionProperty) addProperty("overviewRowTop")).adapterPosition(0);
        int i4 = R.id.details_frame;
        this.mFrameTop = adapterPosition.viewId(i4);
        this.mFrameBottom = ((RecyclerViewParallax.ChildPositionProperty) addProperty("overviewRowBottom")).adapterPosition(0).viewId(i4).fraction(1.0f);
    }

    public Parallax.IntProperty getOverviewRowBottom() {
        return this.mFrameBottom;
    }

    public Parallax.IntProperty getOverviewRowTop() {
        return this.mFrameTop;
    }
}
