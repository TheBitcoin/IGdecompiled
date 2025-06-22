package c2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.uptodown.R;
import com.uptodown.util.views.UsernameTextView;

public final class a1 implements ViewBinding {

    /* renamed from: A  reason: collision with root package name */
    public final UsernameTextView f10192A;

    /* renamed from: B  reason: collision with root package name */
    public final UsernameTextView f10193B;

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f10194a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f10195b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f10196c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f10197d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f10198e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f10199f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f10200g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f10201h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f10202i;

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f10203j;

    /* renamed from: k  reason: collision with root package name */
    public final LinearLayout f10204k;

    /* renamed from: l  reason: collision with root package name */
    public final View f10205l;

    /* renamed from: m  reason: collision with root package name */
    public final RadioButton f10206m;

    /* renamed from: n  reason: collision with root package name */
    public final RadioButton f10207n;

    /* renamed from: o  reason: collision with root package name */
    public final RadioButton f10208o;

    /* renamed from: p  reason: collision with root package name */
    public final RadioButton f10209p;

    /* renamed from: q  reason: collision with root package name */
    public final Toolbar f10210q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f10211r;

    /* renamed from: s  reason: collision with root package name */
    public final TextView f10212s;

    /* renamed from: t  reason: collision with root package name */
    public final TextView f10213t;

    /* renamed from: u  reason: collision with root package name */
    public final TextView f10214u;

    /* renamed from: v  reason: collision with root package name */
    public final TextView f10215v;

    /* renamed from: w  reason: collision with root package name */
    public final TextView f10216w;

    /* renamed from: x  reason: collision with root package name */
    public final TextView f10217x;

    /* renamed from: y  reason: collision with root package name */
    public final UsernameTextView f10218y;

    /* renamed from: z  reason: collision with root package name */
    public final UsernameTextView f10219z;

    private a1(RelativeLayout relativeLayout, EditText editText, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, View view, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, UsernameTextView usernameTextView, UsernameTextView usernameTextView2, UsernameTextView usernameTextView3, UsernameTextView usernameTextView4) {
        this.f10194a = relativeLayout;
        this.f10195b = editText;
        this.f10196c = imageView;
        this.f10197d = imageView2;
        this.f10198e = imageView3;
        this.f10199f = imageView4;
        this.f10200g = linearLayout;
        this.f10201h = linearLayout2;
        this.f10202i = linearLayout3;
        this.f10203j = linearLayout4;
        this.f10204k = linearLayout5;
        this.f10205l = view;
        this.f10206m = radioButton;
        this.f10207n = radioButton2;
        this.f10208o = radioButton3;
        this.f10209p = radioButton4;
        this.f10210q = toolbar;
        this.f10211r = textView;
        this.f10212s = textView2;
        this.f10213t = textView3;
        this.f10214u = textView4;
        this.f10215v = textView5;
        this.f10216w = textView6;
        this.f10217x = textView7;
        this.f10218y = usernameTextView;
        this.f10219z = usernameTextView2;
        this.f10192A = usernameTextView3;
        this.f10193B = usernameTextView4;
    }

    public static a1 a(View view) {
        View view2 = view;
        int i4 = R.id.et_username_edit;
        EditText editText = (EditText) ViewBindings.findChildViewById(view2, R.id.et_username_edit);
        if (editText != null) {
            i4 = R.id.iv_lock_username_type_1;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_lock_username_type_1);
            if (imageView != null) {
                i4 = R.id.iv_lock_username_type_2;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_lock_username_type_2);
                if (imageView2 != null) {
                    i4 = R.id.iv_lock_username_type_3;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_lock_username_type_3);
                    if (imageView3 != null) {
                        i4 = R.id.iv_turbo_avatar_title_user_edit;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_turbo_avatar_title_user_edit);
                        if (imageView4 != null) {
                            i4 = R.id.ll_turbo_separator_user_edit;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_turbo_separator_user_edit);
                            if (linearLayout != null) {
                                i4 = R.id.ll_turbo_type_1;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_turbo_type_1);
                                if (linearLayout2 != null) {
                                    i4 = R.id.ll_turbo_type_2;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_turbo_type_2);
                                    if (linearLayout3 != null) {
                                        i4 = R.id.ll_turbo_type_3;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_turbo_type_3);
                                        if (linearLayout4 != null) {
                                            i4 = R.id.ll_turbo_username_type_user_edit;
                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.ll_turbo_username_type_user_edit);
                                            if (linearLayout5 != null) {
                                                i4 = R.id.loading_view_username_edit;
                                                View findChildViewById = ViewBindings.findChildViewById(view2, R.id.loading_view_username_edit);
                                                if (findChildViewById != null) {
                                                    i4 = R.id.rb_turbo_type_0;
                                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_turbo_type_0);
                                                    if (radioButton != null) {
                                                        i4 = R.id.rb_turbo_type_1;
                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_turbo_type_1);
                                                        if (radioButton2 != null) {
                                                            i4 = R.id.rb_turbo_type_2;
                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_turbo_type_2);
                                                            if (radioButton3 != null) {
                                                                i4 = R.id.rb_turbo_type_3;
                                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view2, R.id.rb_turbo_type_3);
                                                                if (radioButton4 != null) {
                                                                    i4 = R.id.toolbar_username_edit;
                                                                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_username_edit);
                                                                    if (toolbar != null) {
                                                                        i4 = R.id.tv_max_chars_user_edit;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_max_chars_user_edit);
                                                                        if (textView != null) {
                                                                            i4 = R.id.tv_min_chars_user_edit;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_min_chars_user_edit);
                                                                            if (textView2 != null) {
                                                                                i4 = R.id.tv_title_toolbar_username_edit;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_title_toolbar_username_edit);
                                                                                if (textView3 != null) {
                                                                                    i4 = R.id.tv_turbo_username_styles_locked_user_edit;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_turbo_username_styles_locked_user_edit);
                                                                                    if (textView4 != null) {
                                                                                        i4 = R.id.tv_turbo_username_title_user_edit;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_turbo_username_title_user_edit);
                                                                                        if (textView5 != null) {
                                                                                            i4 = R.id.tv_type_chars_user_edit;
                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_type_chars_user_edit);
                                                                                            if (textView6 != null) {
                                                                                                i4 = R.id.tv_username_edit_change;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, R.id.tv_username_edit_change);
                                                                                                if (textView7 != null) {
                                                                                                    i4 = R.id.tv_username_type_0;
                                                                                                    UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_username_type_0);
                                                                                                    if (usernameTextView != null) {
                                                                                                        i4 = R.id.tv_username_type_1;
                                                                                                        UsernameTextView usernameTextView2 = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_username_type_1);
                                                                                                        if (usernameTextView2 != null) {
                                                                                                            i4 = R.id.tv_username_type_2;
                                                                                                            UsernameTextView usernameTextView3 = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_username_type_2);
                                                                                                            if (usernameTextView3 != null) {
                                                                                                                i4 = R.id.tv_username_type_3;
                                                                                                                UsernameTextView usernameTextView4 = (UsernameTextView) ViewBindings.findChildViewById(view2, R.id.tv_username_type_3);
                                                                                                                if (usernameTextView4 != null) {
                                                                                                                    return new a1((RelativeLayout) view2, editText, imageView, imageView2, imageView3, imageView4, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, findChildViewById, radioButton, radioButton2, radioButton3, radioButton4, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, usernameTextView, usernameTextView2, usernameTextView3, usernameTextView4);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i4)));
    }

    public static a1 c(LayoutInflater layoutInflater) {
        return d(layoutInflater, (ViewGroup) null, false);
    }

    public static a1 d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z4) {
        View inflate = layoutInflater.inflate(R.layout.username_edit, viewGroup, false);
        if (z4) {
            viewGroup.addView(inflate);
        }
        return a(inflate);
    }

    /* renamed from: b */
    public RelativeLayout getRoot() {
        return this.f10194a;
    }
}
