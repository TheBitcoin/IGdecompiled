package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;

/* renamed from: c2.u0  reason: case insensitive filesystem */
public final class C1693u0 implements ViewBinding {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10781a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f10782b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10783c;

    /* renamed from: d  reason: collision with root package name */
    public final View f10784d;

    /* renamed from: e  reason: collision with root package name */
    public final View f10785e;

    /* renamed from: f  reason: collision with root package name */
    public final NestedScrollView f10786f;

    /* renamed from: g  reason: collision with root package name */
    public final C1695v0 f10787g;

    /* renamed from: h  reason: collision with root package name */
    public final C1699x0 f10788h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f10789i;

    /* renamed from: j  reason: collision with root package name */
    public final RecyclerView f10790j;

    /* renamed from: k  reason: collision with root package name */
    public final Toolbar f10791k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f10792l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f10793m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f10794n;

    private C1693u0(RelativeLayout relativeLayout, EditText editText, ImageView imageView, View view, View view2, NestedScrollView nestedScrollView, C1695v0 v0Var, C1699x0 x0Var, RelativeLayout relativeLayout2, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f10781a = relativeLayout;
        this.f10782b = editText;
        this.f10783c = imageView;
        this.f10784d = view;
        this.f10785e = view2;
        this.f10786f = nestedScrollView;
        this.f10787g = v0Var;
        this.f10788h = x0Var;
        this.f10789i = relativeLayout2;
        this.f10790j = recyclerView;
        this.f10791k = toolbar;
        this.f10792l = textView;
        this.f10793m = textView2;
        this.f10794n = textView3;
    }

    public static C1693u0 a(View view) {
        View view2 = view;
        int i4 = R.id.et_reply;
        EditText editText = (EditText) ViewBindings.findChildViewById(view2, R.id.et_reply);
        if (editText != null) {
            i4 = R.id.iv_user_avatar_reply;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_user_avatar_reply);
            if (imageView != null) {
                i4 = R.id.loading_view_replies;
                View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_replies);
                if (findChildViewById != null) {
                    i4 = R.id.login_wall;
                    View findChildViewById2 = ViewBindings.findChildViewById(view2, R.id.login_wall);
                    if (findChildViewById2 != null) {
                        i4 = R.id.nsv_replies;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.nsv_replies);
                        if (nestedScrollView != null) {
                            i4 = R.id.review;
                            View findChildViewById3 = ViewBindings.findChildViewById(view2, R.id.review);
                            if (findChildViewById3 != null) {
                                C1695v0 a5 = C1695v0.a(findChildViewById3);
                                i4 = R.id.review_turbo;
                                View findChildViewById4 = ViewBindings.findChildViewById(view2, R.id.review_turbo);
                                if (findChildViewById4 != null) {
                                    C1699x0 a6 = C1699x0.a(findChildViewById4);
                                    i4 = R.id.rl_user_reply;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rl_user_reply);
                                    if (relativeLayout != null) {
                                        i4 = R.id.rv_reply;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rv_reply);
                                        if (recyclerView != null) {
                                            i4 = R.id.toolbar_reply;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_reply);
                                            if (toolbar != null) {
                                                i4 = R.id.tv_app_name_reply;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_app_name_reply);
                                                if (textView != null) {
                                                    i4 = R.id.tv_no_answer;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_no_answer);
                                                    if (textView2 != null) {
                                                        i4 = R.id.tv_send_reply;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_send_reply);
                                                        if (textView3 != null) {
                                                            return new C1693u0((RelativeLayout) view2, editText, imageView, findChildViewById, findChildViewById2, nestedScrollView, a5, a6, relativeLayout, recyclerView, toolbar, textView, textView2, textView3);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i4)));
    }

    public static C1693u0 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static C1693u0 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.replies_activity, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10781a;
    }
}
