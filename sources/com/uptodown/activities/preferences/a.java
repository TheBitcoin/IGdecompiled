package com.uptodown.activities.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.UptodownApp;
import g2.C2033A;
import g2.C2052j;
import g2.C2065x;
import g2.T;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0236a f18818a = new C0236a((C2103g) null);

    /* renamed from: com.uptodown.activities.preferences.a$a  reason: collision with other inner class name */
    public static final class C0236a {
        public /* synthetic */ C0236a(C2103g gVar) {
            this();
        }

        private final String E(Context context, String str) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains(str)) {
                    return sharedPreferences.getString(str, (String) null);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            return null;
        }

        private final String F(Context context, String str, String str2) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains(str)) {
                    String string = sharedPreferences.getString(str, str2);
                    m.b(string);
                    return string;
                }
            } catch (Exception unused) {
            }
            return str2;
        }

        private final void L0(Context context, String str, int i4) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                edit.putInt(str, i4);
                edit.apply();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        private final void U0(Context context, String str, long j4) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                edit.putLong(str, j4);
                edit.apply();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        private final boolean d0(Context context, String str) {
            try {
                return context.getSharedPreferences("SettingsPreferences", 0).contains(str);
            } catch (Exception unused) {
                return false;
            }
        }

        public static /* synthetic */ boolean i(C0236a aVar, Context context, String str, boolean z4, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                z4 = true;
            }
            return aVar.h(context, str, z4);
        }

        private final void i1(Context context, String str, String str2) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                edit.putString(str, str2);
                edit.apply();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        private final int n(Context context, String str) {
            return context.getSharedPreferences("SettingsPreferences", 0).getInt(str, -1);
        }

        public static /* synthetic */ long y(C0236a aVar, Context context, String str, long j4, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                j4 = -1;
            }
            return aVar.x(context, str, j4);
        }

        public final C2033A A(Context context) {
            m.e(context, "context");
            C2033A a5 = new C2033A();
            Context context2 = context;
            Context context3 = context2;
            a5.j(y(this, context2, "fcm_app_id", 0, 4, (Object) null));
            a5.m(E(context3, "fcm_packagename"));
            a5.k(n(context3, "fcm_download_id"));
            a5.o(y(this, context3, "fcm_received_timestamp", 0, 4, (Object) null));
            a5.q(y(this, context3, "fcm_shown_timestamp", 0, 4, (Object) null));
            if (a5.b() <= -1 || a5.d() == null) {
                return null;
            }
            return a5;
        }

        public final void A0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "delete_apk", z4);
        }

        public final int B(Context context) {
            m.e(context, "context");
            return n(context, "notification_permission_request_api33");
        }

        public final void B0(Context context, String str) {
            m.e(context, "context");
            i1(context, "device_status", str);
        }

        public final long C(Context context) {
            m.e(context, "context");
            return x(context, "last_notification_permission_request_timestamp", 0);
        }

        public final void C0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "is_device_tracking_registered", z4);
        }

        public final long D(Context context) {
            m.e(context, "context");
            return x(context, "last_sign_in_request_timestamp", 0);
        }

        public final void D0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "download_notification", z4);
        }

        public final void E0(Context context, String str) {
            m.e(context, "context");
            m.e(str, "optionIndex");
            i1(context, "download_updates_options", str);
        }

        public final void F0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "app_detail_inflate_view_failed", z4);
        }

        public final T G(Context context) {
            m.e(context, "context");
            return new T(x(context, "bytes_uploaded", 0), x(context, "timestamp_uploaded", 0));
        }

        public final void G0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "gdpr_requested", z4);
        }

        public final long H(Context context) {
            m.e(context, "context");
            return x(context, "uptodown_turbo_register_popup_shown", 0);
        }

        public final void H0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "is_in_eea", z4);
        }

        public final String I(Context context) {
            m.e(context, "context");
            return E(context, "url_526");
        }

        public final void I0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "is_in_eea_checked", z4);
        }

        public final String J(Context context) {
            m.e(context, "context");
            return E(context, "UTOKEN");
        }

        public final void J0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "install_apk_rooted", z4);
        }

        public final int K(Context context) {
            m.e(context, "context");
            return n(context, "versioncode_526");
        }

        public final void K0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "installation_notification", z4);
        }

        public final boolean L(Context context) {
            m.e(context, "context");
            return h(context, "app_detail_inflate_view_failed", false);
        }

        public final boolean M(Context context) {
            m.e(context, "context");
            return h(context, "gdpr_analytics_allowed", false);
        }

        public final void M0(Context context, String str) {
            m.e(context, "context");
            m.e(str, "language");
            i1(context, "Language", str);
            new P1.a(context).C(str);
        }

        public final boolean N(Context context) {
            m.e(context, "context");
            if (UptodownApp.f17422D.Q()) {
                return false;
            }
            return i(this, context, "animations", false, 4, (Object) null);
        }

        public final void N0(Context context, long j4) {
            m.e(context, "context");
            U0(context, "last_analysis_timestamp", j4);
        }

        public final boolean O(Context context) {
            m.e(context, "context");
            return h(context, "gdpr_crashlytics_allowed", false);
        }

        public final void O0(Context context, String str) {
            m.e(context, "context");
            m.e(str, CampaignEx.JSON_KEY_TIMESTAMP);
            i1(context, "last_notification_timestamp", str);
        }

        public final boolean P(Context context) {
            m.e(context, "context");
            return i(this, context, "delete_apk", false, 4, (Object) null);
        }

        public final void P0(Context context, String str) {
            m.e(context, "context");
            m.e(str, MimeTypes.BASE_TYPE_TEXT);
            i1(context, "last_review_text", str);
        }

        public final boolean Q(Context context) {
            m.e(context, "context");
            return h(context, "is_device_tracking_registered", false);
        }

        public final void Q0(Context context, String str) {
            m.e(context, "context");
            m.e(str, CampaignEx.JSON_KEY_TIMESTAMP);
            i1(context, "last_review_timestamp", str);
        }

        public final boolean R(Context context) {
            m.e(context, "context");
            return h(context, "download_notification", true);
        }

        public final void R0(Context context, long j4) {
            m.e(context, "context");
            U0(context, "last_events_timestamp", j4);
        }

        public final boolean S(Context context) {
            m.e(context, "context");
            if (UptodownApp.f17422D.Q()) {
                return false;
            }
            return h(context, "floating_download_queue_active", true);
        }

        public final void S0(Context context, long j4) {
            m.e(context, "context");
            U0(context, "mintegral_interstitial_last_shown", j4);
        }

        public final boolean T(Context context) {
            m.e(context, "context");
            return h(context, "gdpr_requested", false);
        }

        public final void T0(Context context, long j4) {
            m.e(context, "context");
            U0(context, "last_tracking_timestamp", j4);
        }

        public final boolean U(Context context) {
            m.e(context, "context");
            return h(context, "is_in_eea", true);
        }

        public final boolean V(Context context) {
            m.e(context, "context");
            return h(context, "is_in_eea_checked", false);
        }

        public final void V0(Context context, String str) {
            m.e(context, "context");
            m.e(str, "option");
            i1(context, "notifications_frecuency", str);
        }

        public final boolean W(Context context) {
            m.e(context, "context");
            return h(context, "install_apk_rooted", false);
        }

        public final void W0(Context context, int i4) {
            m.e(context, "context");
            L0(context, "notification_permission_request_api33", i4);
        }

        public final boolean X(Context context) {
            m.e(context, "context");
            return h(context, "installation_notification", true);
        }

        public final void X0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "recibir_notificaciones", z4);
        }

        public final boolean Y(Context context) {
            m.e(context, "context");
            return i(this, context, "recibir_notificaciones", false, 4, (Object) null);
        }

        public final void Y0(Context context, long j4) {
            m.e(context, "context");
            U0(context, "last_notification_permission_request_timestamp", j4);
        }

        public final boolean Z(Context context) {
            m.e(context, "context");
            return i(this, context, "only_wifi", false, 4, (Object) null);
        }

        public final void Z0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "only_wifi", z4);
        }

        public final void a(Context context) {
            m.e(context, "context");
            SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            edit.remove("banner_app_id");
            edit.remove("banner_packagename");
            edit.remove(CampaignEx.JSON_KEY_BANNER_URL);
            edit.remove("banner_last_time_shown");
            edit.remove("banner_download_id");
            edit.remove("banner_last_time_clicked");
            edit.remove("banner_counter_impressions");
            edit.remove("banner_last_time_requested");
            edit.apply();
        }

        public final boolean a0(Context context) {
            m.e(context, "context");
            return h(context, "install_apk_as_root_system", false);
        }

        public final void a1(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "install_apk_as_root_system", z4);
        }

        public final void b(Context context) {
            m.e(context, "context");
            SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            edit.remove("interstitial_app_id");
            edit.remove("interstitial_packagename");
            edit.remove("interstitial_url");
            edit.remove("interstitial_last_time_shown");
            edit.remove("interstitial_download_id");
            edit.remove("interstitial_last_time_clicked");
            edit.remove("interstitial_counter_impressions");
            edit.remove("interstitial_last_time_requested");
            edit.apply();
        }

        public final boolean b0(Context context) {
            m.e(context, "context");
            return h(context, "storage_sdcard", false);
        }

        public final void b1(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "storage_sdcard", z4);
        }

        public final void c(Context context) {
            m.e(context, "context");
            SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
            edit.remove("fcm_app_id");
            edit.remove("fcm_packagename");
            edit.remove("fcm_download_id");
            edit.remove("fcm_received_timestamp");
            edit.remove("fcm_shown_timestamp");
            edit.apply();
        }

        public final boolean c0(Context context) {
            m.e(context, "context");
            return d0(context, "storage_sdcard");
        }

        public final void c1(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "settings_utd_sended", z4);
        }

        public final String d(Context context) {
            m.e(context, "context");
            return E(context, "apk_to_rollback");
        }

        public final void d1(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "show_system_apps", z4);
        }

        public final String e(Context context) {
            m.e(context, "context");
            return E(context, "app_id_after_kill");
        }

        public final boolean e0(Context context) {
            m.e(context, "context");
            return h(context, "settings_utd_sended", false);
        }

        public final void e1(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "show_system_services", z4);
        }

        public final int f(Context context) {
            m.e(context, "context");
            return Integer.parseInt(F(context, "autoplay_video", "0"));
        }

        public final boolean f0(Context context) {
            m.e(context, "context");
            return h(context, "show_system_apps", false);
        }

        public final void f1(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "show_warning_download_incompatible", z4);
        }

        public final C2052j g(Context context) {
            m.e(context, "context");
            Context context2 = context;
            long y4 = y(this, context2, "banner_app_id", 0, 4, (Object) null);
            Context context3 = context2;
            String E4 = E(context3, "banner_packagename");
            String E5 = E(context3, CampaignEx.JSON_KEY_BANNER_URL);
            if (y4 <= -1 || E4 == null || E5 == null) {
                return null;
            }
            C2052j jVar = new C2052j(y4, E4, E5);
            jVar.z(y(this, context3, "banner_last_time_shown", 0, 4, (Object) null));
            jVar.v(n(context3, "banner_download_id"));
            jVar.x(y(this, context3, "banner_last_time_clicked", 0, 4, (Object) null));
            jVar.u(n(context3, "banner_counter_impressions"));
            jVar.y(y(this, context3, "banner_last_time_requested", 0, 4, (Object) null));
            return jVar;
        }

        public final boolean g0(Context context) {
            m.e(context, "context");
            return h(context, "show_system_services", false);
        }

        public final void g1(Context context, long j4) {
            m.e(context, "context");
            U0(context, "last_sign_in_request_timestamp", j4);
        }

        public final boolean h(Context context, String str, boolean z4) {
            m.e(context, "context");
            m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains(str)) {
                    return sharedPreferences.getBoolean(str, z4);
                }
            } catch (Exception unused) {
            }
            return z4;
        }

        public final boolean h0(Context context) {
            m.e(context, "context");
            return h(context, "is_status_code_526", false);
        }

        public final void h1(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "is_status_code_526", z4);
        }

        public final boolean i0(Context context) {
            m.e(context, "context");
            return h(context, "gdpr_tracking_allowed", false);
        }

        public final String j(Context context) {
            m.e(context, "context");
            return F(context, "dark_mode", "system");
        }

        public final boolean j0(Context context) {
            m.e(context, "context");
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SharedPreferencesTracking", 0);
                if (sharedPreferences.contains("maintenance_time")) {
                    if (System.currentTimeMillis() < sharedPreferences.getLong("maintenance_time", 0)) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }

        public final void j1(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "gdpr_tracking_allowed", z4);
        }

        public final int k(Context context) {
            m.e(context, "context");
            return Integer.parseInt(F(context, "data_saver_options", "1"));
        }

        public final boolean k0(Context context) {
            m.e(context, "context");
            return h(context, "welcome_popup_shown", false);
        }

        public final void k1(Context context, long j4) {
            m.e(context, "context");
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("SharedPreferencesTracking", 0).edit();
                edit.putLong("maintenance_time", System.currentTimeMillis() + (j4 * ((long) 1000)));
                edit.apply();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final String l(Context context) {
            m.e(context, "context");
            return E(context, "device_status");
        }

        public final boolean l0(Context context) {
            m.e(context, "context");
            return h(context, "wizard_completed", false);
        }

        public final void l1(Context context, long j4) {
            m.e(context, "context");
            U0(context, "uptodown_turbo_register_popup_shown", j4);
        }

        public final String m(Context context) {
            m.e(context, "context");
            return F(context, "download_updates_options", "2");
        }

        public final boolean m0(int i4, Context context) {
            m.e(context, "context");
            return h(context, "wizard_step_" + i4 + "_shown", false);
        }

        public final void m1(Context context, String str) {
            m.e(context, "context");
            i1(context, "url_526", str);
        }

        public final void n0(Context context, C2052j jVar) {
            m.e(context, "context");
            m.e(jVar, "bannerInfo");
            U0(context, "banner_app_id", jVar.k());
            i1(context, "banner_packagename", jVar.r());
            i1(context, CampaignEx.JSON_KEY_BANNER_URL, jVar.n());
            U0(context, "banner_last_time_shown", jVar.q());
            L0(context, "banner_download_id", jVar.m());
            U0(context, "banner_last_time_clicked", jVar.o());
            L0(context, "banner_counter_impressions", jVar.l());
            U0(context, "banner_last_time_requested", jVar.p());
        }

        public final void n1(Context context, String str) {
            m.e(context, "context");
            i1(context, "UTOKEN", str);
        }

        public final C2065x o(Context context) {
            m.e(context, "context");
            Context context2 = context;
            long y4 = y(this, context2, "interstitial_app_id", 0, 4, (Object) null);
            Context context3 = context2;
            String E4 = E(context3, "interstitial_packagename");
            String E5 = E(context3, "interstitial_url");
            if (y4 <= -1 || E4 == null || E5 == null) {
                return null;
            }
            C2065x xVar = new C2065x(y4, E4, E5);
            xVar.z(y(this, context3, "interstitial_last_time_shown", 0, 4, (Object) null));
            xVar.v(n(context3, "interstitial_download_id"));
            xVar.x(y(this, context3, "interstitial_last_time_clicked", 0, 4, (Object) null));
            xVar.u(n(context3, "interstitial_counter_impressions"));
            xVar.y(y(this, context3, "interstitial_last_time_requested", 0, 4, (Object) null));
            return xVar;
        }

        public final void o0(Context context, C2065x xVar) {
            m.e(context, "context");
            m.e(xVar, "interstitialInfo");
            U0(context, "interstitial_app_id", xVar.k());
            i1(context, "interstitial_packagename", xVar.r());
            i1(context, "interstitial_url", xVar.n());
            U0(context, "interstitial_last_time_shown", xVar.q());
            L0(context, "interstitial_download_id", xVar.m());
            U0(context, "interstitial_last_time_clicked", xVar.o());
            L0(context, "interstitial_counter_impressions", xVar.l());
            U0(context, "interstitial_last_time_requested", xVar.p());
        }

        public final void o1(Context context, int i4) {
            m.e(context, "context");
            L0(context, "versioncode_526", i4);
        }

        public final String p(Context context) {
            m.e(context, "context");
            return E(context, "Language");
        }

        public final void p0(Context context, C2033A a5) {
            m.e(context, "context");
            m.e(a5, "notificationFCM");
            U0(context, "fcm_app_id", a5.b());
            i1(context, "fcm_packagename", a5.d());
            L0(context, "fcm_download_id", a5.c());
            U0(context, "fcm_received_timestamp", a5.e());
            U0(context, "fcm_shown_timestamp", a5.f());
        }

        public final void p1(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "welcome_popup_shown", z4);
        }

        public final long q(Context context) {
            m.e(context, "context");
            return x(context, "last_analysis_timestamp", 0);
        }

        public final void q0(Context context, T t4) {
            m.e(context, "context");
            m.e(t4, "uploadInfo");
            U0(context, "bytes_uploaded", t4.b());
            U0(context, "timestamp_uploaded", t4.c());
        }

        public final void q1(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "wizard_completed", z4);
        }

        public final String r(Context context) {
            m.e(context, "context");
            return E(context, "last_notification_timestamp");
        }

        public final void r0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "gdpr_analytics_allowed", z4);
        }

        public final void r1(Context context, int i4) {
            m.e(context, "context");
            w0(context, "wizard_step_" + i4 + "_shown", true);
        }

        public final String s(Context context) {
            m.e(context, "context");
            return E(context, "last_review_text");
        }

        public final void s0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "animations", z4);
        }

        public final boolean s1(Context context) {
            m.e(context, "context");
            return h(context, "show_warning_download_incompatible", true);
        }

        public final String t(Context context) {
            m.e(context, "context");
            return E(context, "last_review_timestamp");
        }

        public final void t0(Context context, String str) {
            m.e(context, "context");
            i1(context, "apk_to_rollback", str);
        }

        public final long u(Context context) {
            m.e(context, "context");
            return x(context, "last_events_timestamp", 0);
        }

        public final void u0(Context context, String str) {
            m.e(context, "context");
            i1(context, "app_id_after_kill", str);
        }

        public final long v(Context context) {
            m.e(context, "context");
            return x(context, "mintegral_interstitial_last_shown", 0);
        }

        public final void v0(Context context, String str) {
            m.e(context, "context");
            m.e(str, "option");
            i1(context, "autoplay_video", str);
        }

        public final long w(Context context) {
            m.e(context, "context");
            return x(context, "last_tracking_timestamp", 0);
        }

        public final void w0(Context context, String str, boolean z4) {
            m.e(context, "context");
            m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("SettingsPreferences", 0).edit();
                edit.putBoolean(str, z4);
                edit.apply();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }

        public final long x(Context context, String str, long j4) {
            m.e(context, "context");
            m.e(str, LeanbackPreferenceDialogFragment.ARG_KEY);
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            try {
                return sharedPreferences.getLong(str, j4);
            } catch (ClassCastException unused) {
                try {
                    long j5 = (long) sharedPreferences.getInt(str, -1);
                    U0(context, str, j5);
                    return j5;
                } catch (ClassCastException unused2) {
                    return j4;
                }
            }
        }

        public final void x0(Context context, boolean z4) {
            m.e(context, "context");
            w0(context, "gdpr_crashlytics_allowed", z4);
        }

        public final void y0(Context context, String str) {
            m.e(context, "context");
            i1(context, "dark_mode", str);
        }

        public final String z(Context context) {
            m.e(context, "context");
            String F4 = F(context, "notifications_frecuency", "1");
            if (!m3.m.p(F4, "0", false)) {
                return F4;
            }
            i1(context, "notifications_frecuency", "1");
            return "1";
        }

        public final void z0(Context context, String str) {
            m.e(context, "context");
            m.e(str, "option");
            i1(context, "data_saver_options", str);
        }

        private C0236a() {
        }
    }
}
