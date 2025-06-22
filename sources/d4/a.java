package d4;

import V3.C2592c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

public class a extends DialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f24517a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f24518b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f24519c;

    /* renamed from: d  reason: collision with root package name */
    public ConstraintLayout f24520d;

    /* renamed from: e  reason: collision with root package name */
    public SearchView f24521e;

    /* renamed from: f  reason: collision with root package name */
    public EditText f24522f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f24523g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f24524h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f24525i;

    /* renamed from: j  reason: collision with root package name */
    public C2592c f24526j;

    /* renamed from: k  reason: collision with root package name */
    public Typeface f24527k;

    /* renamed from: l  reason: collision with root package name */
    public Typeface f24528l;

    public final void g() {
        int i4;
        SearchView searchView = this.f24521e;
        if (searchView != null) {
            int i5 = searchView.getContext().getResources().getConfiguration().uiMode & 48;
            Context context = searchView.getContext();
            if (i5 == 32) {
                i4 = A1.a.search_bar_dark_color;
            } else {
                i4 = A1.a.search_bar_light_color;
            }
            searchView.setBackgroundTintList(ContextCompat.getColorStateList(context, i4));
        }
    }

    public final void h() {
        ImageView imageView = this.f24519c;
        if (imageView != null) {
            imageView.setImageTintList(i());
        }
        ImageView imageView2 = this.f24525i;
        if (imageView2 != null) {
            imageView2.setImageTintList(i());
        }
        TextView textView = this.f24518b;
        if (textView != null) {
            textView.setTextColor(i());
        }
    }

    public final ColorStateList i() {
        int i4;
        int i5 = requireContext().getResources().getConfiguration().uiMode & 48;
        Context requireContext = requireContext();
        if (i5 == 32) {
            i4 = A1.a.colorWhite;
        } else {
            i4 = A1.a.colorBlack;
        }
        return ContextCompat.getColorStateList(requireContext, i4);
    }

    public void onCreate(Bundle bundle) {
        int i4;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 29) {
            i4 = 16974563;
        } else {
            i4 = 16974392;
        }
        setStyle(1, i4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r4, android.os.Bundle r5) {
        /*
            r3 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.m.e(r4, r0)
            super.onViewCreated(r4, r5)
            int r5 = A1.b.f5749j0
            android.view.View r5 = r4.findViewById(r5)
            androidx.appcompat.widget.Toolbar r5 = (androidx.appcompat.widget.Toolbar) r5
            r3.f24517a = r5
            int r5 = A1.b.toolbar_title
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f24518b = r5
            int r5 = A1.b.toolbar_icon
            android.view.View r5 = r4.findViewById(r5)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.f24519c = r5
            int r5 = A1.b.toolbar_container
            android.view.View r5 = r4.findViewById(r5)
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            r3.f24520d = r5
            int r5 = A1.b.toolbar_search
            android.view.View r5 = r4.findViewById(r5)
            androidx.appcompat.widget.SearchView r5 = (androidx.appcompat.widget.SearchView) r5
            int r0 = androidx.appcompat.R.id.search_src_text
            android.view.View r0 = r5.findViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            r3.f24522f = r0
            int r0 = androidx.appcompat.R.id.search_mag_icon
            android.view.View r0 = r5.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r3.f24523g = r0
            int r0 = androidx.appcompat.R.id.search_close_btn
            android.view.View r0 = r5.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r3.f24524h = r0
            r3.f24521e = r5
            int r5 = A1.b.toolbar_menu
            android.view.View r4 = r4.findViewById(r5)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r3.f24525i = r4
            V3.b r4 = b4.d.f24469e
            r5 = 0
            if (r4 != 0) goto L_0x0069
            r0 = r5
            goto L_0x006b
        L_0x0069:
            android.graphics.Typeface r0 = r4.f24061a
        L_0x006b:
            r3.f24527k = r0
            if (r4 != 0) goto L_0x0071
            r4 = r5
            goto L_0x0073
        L_0x0071:
            android.graphics.Typeface r4 = r4.f24062b
        L_0x0073:
            r3.f24528l = r4
            V3.c r4 = b4.d.f24470f
            r3.f24526j = r4
            if (r4 != 0) goto L_0x007d
            goto L_0x0112
        L_0x007d:
            java.lang.Integer r0 = r4.f24064b
            if (r0 != 0) goto L_0x0082
            goto L_0x0096
        L_0x0082:
            int r0 = r0.intValue()
            androidx.appcompat.widget.Toolbar r1 = r3.f24517a
            if (r1 != 0) goto L_0x008b
            goto L_0x008e
        L_0x008b:
            r1.setBackgroundColor(r0)
        L_0x008e:
            androidx.constraintlayout.widget.ConstraintLayout r1 = r3.f24520d
            if (r1 != 0) goto L_0x0093
            goto L_0x0096
        L_0x0093:
            r1.setBackgroundColor(r0)
        L_0x0096:
            java.lang.Integer r0 = r4.f24072j
            if (r0 != 0) goto L_0x009b
            goto L_0x00bb
        L_0x009b:
            int r0 = r0.intValue()
            android.widget.ImageView r1 = r3.f24519c
            if (r1 != 0) goto L_0x00a4
            goto L_0x00ab
        L_0x00a4:
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r0)
            r1.setImageTintList(r2)
        L_0x00ab:
            android.widget.ImageView r1 = r3.f24525i
            if (r1 != 0) goto L_0x00b0
            goto L_0x00b7
        L_0x00b0:
            android.content.res.ColorStateList r2 = android.content.res.ColorStateList.valueOf(r0)
            r1.setImageTintList(r2)
        L_0x00b7:
            android.widget.TextView r1 = r3.f24518b
            if (r1 != 0) goto L_0x00bd
        L_0x00bb:
            r0 = r5
            goto L_0x00c2
        L_0x00bd:
            r1.setTextColor(r0)
            R2.s r0 = R2.s.f8222a
        L_0x00c2:
            if (r0 != 0) goto L_0x00c7
            r3.h()
        L_0x00c7:
            java.lang.Integer r0 = r4.f24065c
            if (r0 != 0) goto L_0x00cd
            r0 = r5
            goto L_0x00df
        L_0x00cd:
            int r0 = r0.intValue()
            androidx.appcompat.widget.SearchView r1 = r3.f24521e
            if (r1 != 0) goto L_0x00d6
            goto L_0x00dd
        L_0x00d6:
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1.setBackgroundTintList(r0)
        L_0x00dd:
            R2.s r0 = R2.s.f8222a
        L_0x00df:
            if (r0 != 0) goto L_0x00e4
            r3.g()
        L_0x00e4:
            java.lang.Integer r4 = r4.f24066d
            if (r4 != 0) goto L_0x00e9
            goto L_0x0112
        L_0x00e9:
            int r4 = r4.intValue()
            android.widget.EditText r5 = r3.f24522f
            if (r5 != 0) goto L_0x00f2
            goto L_0x00f8
        L_0x00f2:
            r5.setTextColor(r4)
            r5.setHintTextColor(r4)
        L_0x00f8:
            android.widget.ImageView r5 = r3.f24523g
            if (r5 != 0) goto L_0x00fd
            goto L_0x0104
        L_0x00fd:
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r4)
            r5.setImageTintList(r0)
        L_0x0104:
            android.widget.ImageView r5 = r3.f24524h
            if (r5 != 0) goto L_0x0109
            goto L_0x0110
        L_0x0109:
            android.content.res.ColorStateList r4 = android.content.res.ColorStateList.valueOf(r4)
            r5.setImageTintList(r4)
        L_0x0110:
            R2.s r5 = R2.s.f8222a
        L_0x0112:
            if (r5 != 0) goto L_0x011a
            r3.h()
            r3.g()
        L_0x011a:
            android.graphics.Typeface r4 = r3.f24527k
            if (r4 != 0) goto L_0x011f
            goto L_0x0127
        L_0x011f:
            android.widget.TextView r5 = r3.f24518b
            if (r5 != 0) goto L_0x0124
            goto L_0x0127
        L_0x0124:
            r5.setTypeface(r4)
        L_0x0127:
            android.graphics.Typeface r4 = r3.f24528l
            if (r4 != 0) goto L_0x012c
            goto L_0x0130
        L_0x012c:
            android.widget.EditText r5 = r3.f24522f
            if (r5 != 0) goto L_0x0131
        L_0x0130:
            return
        L_0x0131:
            r5.setTypeface(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.a.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
