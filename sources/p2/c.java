package p2;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.leanback.widget.DetailsOverviewLogoPresenter;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.m;

public final class c extends DetailsOverviewLogoPresenter {

    public static final class a extends DetailsOverviewLogoPresenter.ViewHolder {
        public a(View view) {
            super(view);
        }

        public FullWidthDetailsOverviewRowPresenter getParentPresenter() {
            FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter = this.mParentPresenter;
            m.d(fullWidthDetailsOverviewRowPresenter, "mParentPresenter");
            return fullWidthDetailsOverviewRowPresenter;
        }

        public FullWidthDetailsOverviewRowPresenter.ViewHolder getParentViewHolder() {
            FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder = this.mParentViewHolder;
            m.d(viewHolder, "mParentViewHolder");
            return viewHolder;
        }
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        m.e(viewHolder, "viewHolder");
        m.e(obj, "item");
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        View view = viewHolder.view;
        m.c(view, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) view).setImageDrawable(detailsOverviewRow.getImageDrawable());
        a aVar = (a) viewHolder;
        if (isBoundToImage(aVar, detailsOverviewRow)) {
            aVar.getParentPresenter().notifyOnBindLogo(aVar.getParentViewHolder());
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        m.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lb_fullwidth_details_overview_logo, viewGroup, false);
        m.c(inflate, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) inflate;
        Resources resources = viewGroup.getResources();
        imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(resources.getDimensionPixelSize(R.dimen.tv_detail_thumb_width), resources.getDimensionPixelSize(R.dimen.tv_detail_thumb_height)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new a(imageView);
    }
}
