package u2;

import N1.k;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.CustomWebView;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.preferences.a;
import g2.C2060s;
import g2.S;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final a f21920a = new a((C2103g) null);

    public static final class a {

        /* renamed from: u2.q$a$a  reason: collision with other inner class name */
        public static final class C0270a extends CharacterStyle implements UpdateAppearance {

            /* renamed from: a  reason: collision with root package name */
            private final Shader f21921a;

            /* renamed from: b  reason: collision with root package name */
            private final float f21922b;

            public C0270a(Shader shader, float f4) {
                m.e(shader, "shader");
                this.f21921a = shader;
                this.f21922b = f4;
            }

            public void updateDrawState(TextPaint textPaint) {
                m.e(textPaint, "tp");
                textPaint.setShader(this.f21921a);
                textPaint.setTextSize(this.f21922b);
                textPaint.setColor(textPaint.linkColor);
            }
        }

        public /* synthetic */ a(C2103g gVar) {
            this();
        }

        public final void a(ImageView imageView) {
            m.e(imageView, "<this>");
            int dimension = (int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_xs);
            imageView.setBackground(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_stroke_review_avatar_turbo));
            imageView.setPadding(dimension, dimension, dimension, dimension);
        }

        public final void b(ImageView imageView) {
            m.e(imageView, "<this>");
            int dimension = (int) imageView.getContext().getResources().getDimension(R.dimen.border_radius_xs);
            imageView.setBackground(ContextCompat.getDrawable(imageView.getContext(), R.drawable.shape_stroke_review_small_avatar_turbo));
            imageView.setPadding(dimension, dimension, dimension, dimension);
        }

        private a() {
        }
    }

    /* access modifiers changed from: private */
    public static final void f(Activity activity, DialogInterface dialogInterface, int i4) {
        dialogInterface.dismiss();
        Class<GdprPrivacySettings> cls = GdprPrivacySettings.class;
        if (activity instanceof AppDetailActivity) {
            ((AppDetailActivity) activity).n3().launch(new Intent(activity, cls));
        } else if (activity instanceof MainActivity) {
            ((MainActivity) activity).J5().launch(new Intent(activity, cls));
        } else {
            activity.startActivity(new Intent(activity, cls));
        }
    }

    /* access modifiers changed from: private */
    public static final void g(DialogInterface dialogInterface, int i4) {
        m.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    public static /* synthetic */ void r(q qVar, Activity activity, String str, String str2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            str2 = null;
        }
        qVar.q(activity, str, str2);
    }

    public final String c(String str) {
        String str2;
        m.e(str, "url");
        if (!m3.m.D(str, ".uptodown.com/", false, 2, (Object) null)) {
            return str;
        }
        if (m3.m.D(str, "?", false, 2, (Object) null)) {
            str2 = str + '&';
        } else {
            str2 = str + '?';
        }
        return str2 + "userAgent=uptodownandroid";
    }

    public final SpannableString d(String str, String str2, Context context) {
        m.e(str, "originalString");
        m.e(str2, "subString");
        m.e(context, "context");
        SpannableString spannableString = new SpannableString(str);
        String str3 = str2;
        int L4 = m3.m.L(str, str3, 0, false, 6, (Object) null);
        int length = str3.length() + L4;
        if (L4 != -1) {
            float dimension = context.getResources().getDimension(R.dimen.text_size_m);
            Typeface w4 = k.f7778g.w();
            m.b(w4);
            spannableString.setSpan(new b(dimension, w4, ContextCompat.getColor(context, R.color.text_primary)), L4, length, 33);
        }
        return spannableString;
    }

    public final AlertDialog e(AlertDialog alertDialog, Activity activity) {
        m.e(activity, "activity");
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        a.C0236a aVar = com.uptodown.activities.preferences.a.f18818a;
        if (!aVar.U(activity) || aVar.i0(activity)) {
            return null;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(activity.getString(R.string.tracking_disabled_warning_gdpr));
        builder.setPositiveButton(R.string.gdpr_set_up, new o(activity));
        builder.setNegativeButton(17039360, new p());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        if (!activity.isFinishing()) {
            create.show();
        }
        return create;
    }

    public final void h(Context context, String str, String str2) {
        m.e(context, "context");
        m.e(str, "packagenameInstalled");
        m.e(str2, "packageNameDeepLink");
        try {
            if (m3.m.p(str, str2, true)) {
                Iterator it = new w().j(context).iterator();
                m.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    m.d(next, "next(...)");
                    File file = (File) next;
                    w wVar = new w();
                    String name = file.getName();
                    m.d(name, "getName(...)");
                    String i4 = wVar.i(name);
                    if (i4 != null && m3.m.p(i4, str2, true)) {
                        String absolutePath = file.getAbsolutePath();
                        if (file.delete()) {
                            t a5 = t.f21927u.a(context);
                            a5.a();
                            m.b(absolutePath);
                            a5.x(absolutePath);
                            a5.i();
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final ArrayList i(Context context) {
        m.e(context, "context");
        ArrayList arrayList = new ArrayList();
        t a5 = t.f21927u.a(context);
        a5.a();
        Iterator it = a5.m0().iterator();
        m.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            m.d(next, "next(...)");
            C2060s sVar = (C2060s) next;
            if (sVar.K()) {
                arrayList.add(sVar);
            }
        }
        a5.i();
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004f, code lost:
        if (m3.m.y(r2, "https://play.google.com", false, 2, (java.lang.Object) null) != false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String j(android.net.Uri r12) {
        /*
            r11 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.m.e(r12, r0)
            java.lang.String r1 = r12.toString()
            java.lang.String r0 = "toString(...)"
            kotlin.jvm.internal.m.d(r1, r0)
            java.lang.String r2 = "utd://"
            r7 = 0
            r8 = 2
            r9 = 0
            boolean r2 = m3.m.y(r1, r2, r7, r8, r9)
            java.lang.String r10 = "substring(...)"
            if (r2 == 0) goto L_0x0024
            r12 = 6
            java.lang.String r12 = r1.substring(r12)
            kotlin.jvm.internal.m.d(r12, r10)
            return r12
        L_0x0024:
            java.lang.String r2 = r12.toString()
            kotlin.jvm.internal.m.d(r2, r0)
            java.lang.String r3 = "market://"
            boolean r2 = m3.m.y(r2, r3, r7, r8, r9)
            if (r2 != 0) goto L_0x0051
            java.lang.String r2 = r12.toString()
            kotlin.jvm.internal.m.d(r2, r0)
            java.lang.String r3 = "http://play.google.com"
            boolean r2 = m3.m.y(r2, r3, r7, r8, r9)
            if (r2 != 0) goto L_0x0051
            java.lang.String r2 = r12.toString()
            kotlin.jvm.internal.m.d(r2, r0)
            java.lang.String r3 = "https://play.google.com"
            boolean r2 = m3.m.y(r2, r3, r7, r8, r9)
            if (r2 == 0) goto L_0x008d
        L_0x0051:
            java.lang.String r2 = r12.toString()
            kotlin.jvm.internal.m.d(r2, r0)
            r0 = r2
            java.lang.String r2 = "details?id="
            boolean r0 = m3.m.D(r0, r2, r7, r8, r9)
            if (r0 == 0) goto L_0x008d
            r5 = 6
            r6 = 0
            r3 = 0
            r4 = 0
            int r12 = m3.m.L(r1, r2, r3, r4, r5, r6)
            int r12 = r12 + 11
            java.lang.String r0 = "&"
            boolean r0 = m3.m.D(r1, r0, r7, r8, r9)
            if (r0 == 0) goto L_0x0085
            r5 = 6
            r6 = 0
            java.lang.String r2 = "&"
            r3 = 0
            r4 = 0
            int r0 = m3.m.L(r1, r2, r3, r4, r5, r6)
            java.lang.String r12 = r1.substring(r12, r0)
            kotlin.jvm.internal.m.d(r12, r10)
            return r12
        L_0x0085:
            java.lang.String r12 = r1.substring(r12)
            kotlin.jvm.internal.m.d(r12, r10)
            return r12
        L_0x008d:
            java.lang.String r12 = r12.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.q.j(android.net.Uri):java.lang.String");
    }

    public final String k(long j4) {
        if (j4 <= 0) {
            return null;
        }
        return new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(j4));
    }

    public final String l(long j4) {
        if (j4 <= 0) {
            return null;
        }
        return new SimpleDateFormat("dd MMM yyyy HH:mm", Locale.getDefault()).format(new Date(j4));
    }

    public final String m(long j4) {
        if (j4 <= 0) {
            return null;
        }
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date(j4));
    }

    public final File n(Context context) {
        C2060s sVar;
        m.e(context, "context");
        t a5 = t.f21927u.a(context);
        a5.a();
        String packageName = context.getPackageName();
        m.d(packageName, "getPackageName(...)");
        S D02 = a5.D0(packageName);
        File file = null;
        if (D02 != null) {
            sVar = D02.b(context);
        } else {
            sVar = null;
        }
        if (sVar != null && sVar.f()) {
            file = sVar.n();
        }
        a5.i();
        return file;
    }

    public final boolean o(Context context) {
        if (context == null || (context.getResources().getConfiguration().uiMode & 48) != 16) {
            return false;
        }
        return true;
    }

    public final boolean p(View view) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        boolean z4 = false;
        if (view != null && view.isShown()) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            z4 = rect.intersect(new Rect(0, 0, Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels));
        }
        if (!z4) {
            return z4;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            accessibilityNodeInfo = n.a();
        } else {
            accessibilityNodeInfo = AccessibilityNodeInfo.obtain();
        }
        m.b(view);
        view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        boolean isVisibleToUser = accessibilityNodeInfo.isVisibleToUser();
        if (i4 < 33) {
            accessibilityNodeInfo.recycle();
        }
        return isVisibleToUser;
    }

    public final void q(Activity activity, String str, String str2) {
        m.e(activity, "activity");
        m.e(str, "url");
        String c5 = c(str);
        try {
            new CustomTabsIntent.Builder().build().launchUrl(activity, Uri.parse(c5));
        } catch (Exception unused) {
            Intent intent = new Intent(activity, CustomWebView.class);
            if (str2 != null) {
                intent.putExtra(CampaignEx.JSON_KEY_TITLE, str2);
            }
            intent.putExtra("url", c5);
            activity.startActivity(intent, UptodownApp.f17422D.a(activity));
            Bundle bundle = new Bundle();
            bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, "urlNotOpened");
            bundle.putString("url", str);
            new x(activity).d("open_url", bundle);
        }
    }

    public final boolean s(String str, String str2) {
        if (str == null && str2 != null) {
            return false;
        }
        if (str == null || str2 != null) {
            return m3.m.p(str, str2, true);
        }
        return false;
    }

    public final Uri t(File file, Context context) {
        m.e(context, "context");
        if (Build.VERSION.SDK_INT >= 24) {
            m.b(file);
            Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file);
            m.b(uriForFile);
            return uriForFile;
        }
        Uri fromFile = Uri.fromFile(file);
        m.b(fromFile);
        return fromFile;
    }
}
