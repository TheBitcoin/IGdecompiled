package com.uptodown.activities;

import J1.N;
import N1.k;
import R2.g;
import R2.h;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c2.F;
import c2.G;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.mbridge.msdk.MBridgeConstans;
import com.squareup.picasso.A;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import g2.O;
import java.util.ArrayList;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import y2.n;

public final class Gallery extends C1826a {

    /* renamed from: M  reason: collision with root package name */
    public static final a f17702M = new a((C2103g) null);

    /* renamed from: J  reason: collision with root package name */
    private final g f17703J = h.a(new N(this));
    /* access modifiers changed from: private */

    /* renamed from: K  reason: collision with root package name */
    public ArrayList f17704K;

    /* renamed from: L  reason: collision with root package name */
    private final d f17705L = new d(this);

    public static final class a {
        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        private a() {
        }
    }

    private final class b extends PagerAdapter {

        public static final class a implements A {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ G f17707a;

            a(G g4) {
                this.f17707a = g4;
            }

            public void a(Exception exc, Drawable drawable) {
                m.e(exc, "e");
                this.f17707a.f9753c.setVisibility(8);
            }

            public void b(Drawable drawable) {
            }

            public void c(Bitmap bitmap, s.e eVar) {
                m.e(bitmap, "bitmap");
                m.e(eVar, TypedValues.TransitionType.S_FROM);
                this.f17707a.f9752b.setImage(ImageSource.bitmap(bitmap));
                this.f17707a.f9753c.setVisibility(8);
            }
        }

        public b() {
        }

        /* access modifiers changed from: private */
        public static final void b(Gallery gallery, View view) {
            if (!UptodownApp.f17422D.a0()) {
                return;
            }
            if (gallery.g3().f9736c.getVisibility() == 0) {
                n nVar = new n(gallery);
                RelativeLayout relativeLayout = gallery.g3().f9736c;
                m.d(relativeLayout, "toolbarGallery");
                nVar.i(relativeLayout, R.anim.slide_to_top_toolbar);
                return;
            }
            n nVar2 = new n(gallery);
            RelativeLayout relativeLayout2 = gallery.g3().f9736c;
            m.d(relativeLayout2, "toolbarGallery");
            nVar2.h(relativeLayout2, R.anim.slide_in_top_toolbar);
        }

        public void destroyItem(ViewGroup viewGroup, int i4, Object obj) {
            m.e(viewGroup, "container");
            m.e(obj, "item");
            viewGroup.removeView((RelativeLayout) obj);
        }

        public int getCount() {
            if (Gallery.this.f17704K == null) {
                return 0;
            }
            ArrayList d32 = Gallery.this.f17704K;
            m.b(d32);
            return d32.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i4) {
            m.e(viewGroup, "container");
            G c5 = G.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            m.d(c5, "inflate(...)");
            c5.f9753c.setVisibility(0);
            a aVar = new a(c5);
            c5.f9752b.setTag(aVar);
            s h4 = s.h();
            ArrayList d32 = Gallery.this.f17704K;
            m.b(d32);
            h4.l(((O) d32.get(i4)).e()).l(R.drawable.shape_bg_placeholder).k(aVar);
            viewGroup.addView(c5.getRoot());
            c5.f9752b.setOnClickListener(new C1836k(Gallery.this));
            RelativeLayout b5 = c5.getRoot();
            m.d(b5, "getRoot(...)");
            return b5;
        }

        public boolean isViewFromObject(View view, Object obj) {
            m.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
            m.e(obj, "object");
            return view == obj;
        }
    }

    public static final class c implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Gallery f17708a;

        c(Gallery gallery) {
            this.f17708a = gallery;
        }

        public void onPageScrollStateChanged(int i4) {
        }

        public void onPageScrolled(int i4, float f4, int i5) {
        }

        public void onPageSelected(int i4) {
            this.f17708a.j3(i4);
        }
    }

    public static final class d extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Gallery f17709a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Gallery gallery) {
            super(true);
            this.f17709a = gallery;
        }

        public void handleOnBackPressed() {
            this.f17709a.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final F f3(Gallery gallery) {
        return F.c(gallery.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final F g3() {
        return (F) this.f17703J.getValue();
    }

    private final void h3(int i4) {
        g3().f9738e.setAdapter(new b());
        if (i4 > 0) {
            g3().f9738e.setCurrentItem(i4);
        }
        g3().f9738e.addOnPageChangeListener(new c(this));
        j3(i4);
        g3().f9737d.setTypeface(k.f7778g.w());
        g3().f9735b.setOnClickListener(new J1.O(this));
    }

    /* access modifiers changed from: private */
    public static final void i3(Gallery gallery, View view) {
        gallery.f17705L.handleOnBackPressed();
    }

    /* access modifiers changed from: private */
    public final void j3(int i4) {
        Integer num;
        TextView textView = g3().f9737d;
        Integer valueOf = Integer.valueOf(i4 + 1);
        ArrayList arrayList = this.f17704K;
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        textView.setText(getString(R.string.gallery_item_count, new Object[]{valueOf, num}));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        int i4;
        Bundle bundleExtra;
        ArrayList arrayList;
        super.onCreate(bundle);
        setContentView((View) g3().getRoot());
        Window window = getWindow();
        m.d(window, "getWindow(...)");
        O2(window);
        getOnBackPressedDispatcher().addCallback(this, this.f17705L);
        Intent intent = getIntent();
        if (!(intent == null || (bundleExtra = intent.getBundleExtra("bundle")) == null)) {
            if (bundleExtra.containsKey("images")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    arrayList = bundleExtra.getParcelableArrayList("images", O.class);
                } else {
                    arrayList = bundleExtra.getParcelableArrayList("images");
                }
                this.f17704K = arrayList;
            }
            if (bundleExtra.containsKey("index")) {
                i4 = bundleExtra.getInt("index");
                h3(i4);
            }
        }
        i4 = 0;
        h3(i4);
    }
}
