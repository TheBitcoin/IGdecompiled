package com.mbridge.msdk.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.x;
import java.util.Locale;

public class MBAlertDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Button f17158a;

    /* renamed from: b  reason: collision with root package name */
    private Button f17159b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17160c;

    /* renamed from: d  reason: collision with root package name */
    private a f17161d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f17162e;

    public MBAlertDialog(Context context, final a aVar) {
        super(context);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        requestWindowFeature(1);
        View inflate = LayoutInflater.from(context).inflate(x.a(context, "mbridge_cm_alertview", TtmlNode.TAG_LAYOUT), (ViewGroup) null);
        this.f17161d = aVar;
        if (inflate != null) {
            setContentView(inflate);
            try {
                this.f17162e = (TextView) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_titleview", "id"));
            } catch (Exception e5) {
                af.a("MBAlertDialog", e5.getMessage());
            }
            try {
                this.f17160c = (TextView) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_contentview", "id"));
                this.f17159b = (Button) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_confirm_button", "id"));
                this.f17158a = (Button) inflate.findViewById(x.a(context, "mbridge_video_common_alertview_cancel_button", "id"));
            } catch (Exception e6) {
                af.a("MBAlertDialog", e6.getMessage());
            }
        }
        Button button = this.f17158a;
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.a();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        Button button2 = this.f17159b;
        if (button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.b();
                    }
                    MBAlertDialog.this.cancel();
                    MBAlertDialog.this.clear();
                }
            });
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    private void a(String str, String str2, String str3, String str4) {
        setTitle(str);
        setContent(str2);
        setConfirmText(str3);
        setCancelText(str4);
    }

    public void clear() {
        if (this.f17161d != null) {
            this.f17161d = null;
        }
    }

    public a getListener() {
        return this.f17161d;
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

    public void makeDownloadAlert(String str) {
    }

    public void makeIVAlertView(int i4, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        try {
            Context context = getContext();
            String obj = an.a(context, "MBridge_ConfirmTitle" + str, "").toString();
            Context context2 = getContext();
            String obj2 = an.a(context2, "MBridge_ConfirmContent" + str, "").toString();
            Context context3 = getContext();
            String obj3 = an.a(context3, "MBridge_CancelText" + str, "").toString();
            Context context4 = getContext();
            String obj4 = an.a(context4, "MBridge_ConfirmText" + str, "").toString();
            if (!TextUtils.isEmpty(obj) || !TextUtils.isEmpty(obj2) || !TextUtils.isEmpty(obj3) || !TextUtils.isEmpty(obj4)) {
                a(obj, obj2, obj3, obj4);
                return;
            }
            String language = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                if (i4 == a.f13110H) {
                    str2 = "Confirm";
                } else {
                    str2 = "Tips";
                }
                setTitle(str2);
                if (i4 == a.f13110H) {
                    str3 = "If you choose to continue, you will receive a reward after the end. Confirm closed?";
                } else {
                    str3 = "If you choose to continue, you will receive a reward after the end. Whether to continue?";
                }
                setContent(str3);
                if (i4 == a.f13110H) {
                    str4 = "Close";
                } else {
                    str4 = "Cancel";
                }
                setConfirmText(str4);
                setCancelText("Continue");
                return;
            }
            if (i4 == a.f13110H) {
                str5 = "确认关闭？";
            } else {
                str5 = "提示";
            }
            setTitle(str5);
            if (i4 == a.f13110H) {
                str6 = "如果你选择继续，结束后将会获得奖励。确认关闭吗？";
            } else {
                str6 = "如果你选择继续，结束后将会获得奖励。是否继续？";
            }
            setContent(str6);
            if (i4 == a.f13110H) {
                str7 = "确认关闭";
            } else {
                str7 = "取消";
            }
            setConfirmText(str7);
            setCancelText("继续");
        } catch (Exception e5) {
            af.a("MBAlertDialog", e5.getMessage());
        }
    }

    public void makeInsAlert(String str) {
    }

    public void makePlayableAlertView() {
        g b5 = h.a().b(c.m().k());
        if (b5 != null) {
            a(b5.z(), b5.x(), b5.y(), b5.v());
            return;
        }
        String language = Locale.getDefault().getLanguage();
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            setTitle("Confirm to close? ");
            setContent("You will not be rewarded after closing the window");
            setConfirmText("Close it");
            setCancelText("Continue");
            return;
        }
        setTitle("确认关闭？");
        setContent("关闭后您将不会获得任何奖励噢~ ");
        setConfirmText("确认关闭");
        setCancelText("继续试玩");
    }

    public void makeRVAlertView(String str) {
        String str2 = str;
        try {
            Context context = getContext();
            String obj = an.a(context, "MBridge_ConfirmTitle" + str2, "").toString();
            Context context2 = getContext();
            String obj2 = an.a(context2, "MBridge_ConfirmContent" + str2, "").toString();
            Context context3 = getContext();
            String obj3 = an.a(context3, "MBridge_CancelText" + str2, "").toString();
            Context context4 = getContext();
            String obj4 = an.a(context4, "MBridge_ConfirmText" + str2, "").toString();
            g b5 = h.a().b(c.m().k());
            if (TextUtils.isEmpty(obj)) {
                if (TextUtils.isEmpty(obj2) && TextUtils.isEmpty(obj3) && TextUtils.isEmpty(obj4)) {
                    if (b5 != null) {
                        a(b5.z(), b5.x(), b5.y(), b5.w());
                        return;
                    }
                    String language = Locale.getDefault().getLanguage();
                    if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                        setTitle("Confirm to close? ");
                        setContent("You will not be rewarded after closing the window");
                        setConfirmText("Close it");
                        setCancelText("Continue");
                        return;
                    }
                    setTitle("确认关闭？");
                    setContent("关闭后您将不会获得任何奖励噢~ ");
                    setConfirmText("确认关闭");
                    setCancelText("继续观看");
                    return;
                }
            }
            String language2 = Locale.getDefault().getLanguage();
            if (TextUtils.isEmpty(obj)) {
                if (b5 != null) {
                    obj = b5.z();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setTitle("Confirm to close? ");
                } else {
                    setTitle("确认关闭？");
                }
            }
            if (TextUtils.isEmpty(obj2)) {
                if (b5 != null) {
                    obj2 = b5.x();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setContent("You will not be rewarded after closing the window");
                } else {
                    setContent("关闭后您将不会获得任何奖励噢~ ");
                }
            }
            if (TextUtils.isEmpty(obj4)) {
                if (b5 != null) {
                    obj4 = b5.y();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setConfirmText("Close it");
                } else {
                    setConfirmText("确认关闭");
                }
            }
            if (TextUtils.isEmpty(obj3)) {
                if (b5 != null) {
                    obj3 = b5.w();
                } else if (TextUtils.isEmpty(language2) || !language2.equals("zh")) {
                    setCancelText("Continue");
                } else {
                    setCancelText("继续观看");
                }
            }
            a(obj, obj2, obj4, obj3);
        } catch (Exception e5) {
            af.a("MBAlertDialog", e5.getMessage());
        }
    }

    public void onlyShow() {
        super.show();
    }

    public void setCancelText(String str) {
        Button button = this.f17158a;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setConfirmText(String str) {
        Button button = this.f17159b;
        if (button != null) {
            button.setText(str);
        }
    }

    public void setContent(String str) {
        TextView textView = this.f17160c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f17162e;
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
