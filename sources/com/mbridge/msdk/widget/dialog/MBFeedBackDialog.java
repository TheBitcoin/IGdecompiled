package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.x;

public class MBFeedBackDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Button f17167a;

    /* renamed from: b  reason: collision with root package name */
    private Button f17168b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f17169c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f17170d;

    /* renamed from: e  reason: collision with root package name */
    private Button f17171e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f17172f;

    /* renamed from: g  reason: collision with root package name */
    private int f17173g;

    /* renamed from: h  reason: collision with root package name */
    private int f17174h;

    public MBFeedBackDialog(Context context, a aVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(x.a(context, "mbridge_cm_feedbackview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        setDialogWidthAndHeight(0.5f, 0.8f);
        this.f17170d = aVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.f17172f = (TextView) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e5) {
                af.a("MBAlertDialog", e5.getMessage());
            }
            try {
                this.f17169c = (LinearLayout) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f17168b = (Button) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f17167a = (Button) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
                this.f17171e = (Button) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_private_action_button", "id"));
            } catch (Exception e6) {
                af.a("MBAlertDialog", e6.getMessage());
            }
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Button button = this.f17167a;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.f17170d != null) {
                        MBFeedBackDialog.this.f17170d.a();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        Button button2 = this.f17168b;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MBFeedBackDialog.this.f17170d != null) {
                        MBFeedBackDialog.this.f17170d.b();
                    }
                    MBFeedBackDialog.this.dismiss();
                }
            });
        }
        Button button3 = this.f17171e;
        if (button3 != null) {
            button3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    MBFeedBackDialog.this.dismiss();
                    if (MBFeedBackDialog.this.f17170d != null) {
                        MBFeedBackDialog.this.f17170d.c();
                    }
                }
            });
        }
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (MBFeedBackDialog.this.f17170d != null) {
                    MBFeedBackDialog.this.f17170d.b();
                }
            }
        });
    }

    public static boolean isScreenOrientationPortrait(Context context) {
        if (context.getResources().getConfiguration().orientation == 1) {
            return true;
        }
        return false;
    }

    public void clear() {
        if (this.f17170d != null) {
            this.f17170d = null;
        }
    }

    public a getListener() {
        return this.f17170d;
    }

    public void hideNavigationBar(Window window) {
        if (window != null) {
            window.setFlags(1024, 1024);
            int i4 = Build.VERSION.SDK_INT;
            window.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
            if (i4 >= 28) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                window.setAttributes(attributes);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setLayout(-1, -1);
            window.setGravity(17);
        }
    }

    public void setCancelButtonClickable(boolean z4) {
        Button button = this.f17167a;
        if (button != null) {
            button.setClickable(z4);
            if (z4) {
                this.f17167a.setBackgroundResource(getContext().getResources().getIdentifier("mbridge_cm_feedback_choice_btn_bg_pressed", "drawable", c.m().g()));
                this.f17167a.setAlpha(1.0f);
                return;
            }
            this.f17167a.setBackgroundResource(getContext().getResources().getIdentifier("mbridge_cm_feedback_choice_btn_bg_pressed", "drawable", c.m().g()));
            this.f17167a.setAlpha(0.4f);
        }
    }

    public void setCancelText(String str) {
        Button button = this.f17167a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
    }

    public void setContent(ViewGroup viewGroup) {
        LinearLayout linearLayout = this.f17169c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(viewGroup);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = ak.a(c.m().c(), 16.0f);
            layoutParams.rightMargin = ak.a(c.m().c(), 16.0f);
            layoutParams.topMargin = ak.a(c.m().c(), 3.0f);
            layoutParams.bottomMargin = ak.a(c.m().c(), 3.0f);
            this.f17169c.addView(viewGroup, layoutParams);
        }
    }

    public void setDialogWidthAndHeight(float f4, float f5) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (isScreenOrientationPortrait(getContext())) {
            this.f17174h = displayMetrics.widthPixels;
            this.f17173g = displayMetrics.heightPixels;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = (int) (((float) this.f17173g) * f5);
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
            return;
        }
        this.f17174h = displayMetrics.heightPixels;
        this.f17173g = displayMetrics.widthPixels;
        WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
        attributes2.width = (int) (((float) this.f17173g) * f4);
        attributes2.height = -1;
        attributes2.gravity = 17;
        getWindow().setAttributes(attributes2);
    }

    public void setListener(a aVar) {
        this.f17170d = aVar;
    }

    public void setPrivacyText(String str) {
        Button button = this.f17171e;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f17172f;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void show() {
        super.show();
        try {
            getWindow().setFlags(8, 8);
            super.show();
            hideNavigationBar(getWindow());
            getWindow().clearFlags(8);
        } catch (Exception e5) {
            af.b("MBAlertDialog", e5.getMessage());
            super.show();
        }
    }
}
