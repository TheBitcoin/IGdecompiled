package com.inmobi.cmp.data.storage;

import C3.h;
import a4.a;
import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.leanback.preference.LeanbackPreferenceDialogFragment;
import com.google.gson.Gson;
import com.inmobi.cmp.core.model.Vector;
import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.m;

public class SharedStorage {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f11786a;

    public SharedStorage(Application application) {
        m.e(application, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);
        m.d(defaultSharedPreferences, "getDefaultSharedPreferences(app)");
        this.f11786a = defaultSharedPreferences;
    }

    public static void f(SharedStorage sharedStorage, int i4, h hVar, h hVar2, h hVar3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 1;
        }
        if ((i5 & 2) != 0) {
            hVar = h.YES;
        }
        sharedStorage.getClass();
        m.e(hVar, "explicitNotice");
        m.e(hVar2, "optOut");
        m.e(hVar3, "coveredTransaction");
        String str = i4 + hVar.f181a + hVar2.f181a + hVar3.f181a;
        sharedStorage.e(a.PRIVACY_STRING, str);
        sharedStorage.e(a.SAVED_PRIVACY_STRING, str);
    }

    public final String a(int i4, int i5) {
        String j4 = j(a.SAVED_PRIVACY_STRING);
        if (j4.length() <= 0) {
            return "";
        }
        String substring = j4.substring(i4, i5);
        m.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final void b(a aVar) {
        m.e(aVar, "preferenceKey");
        SharedPreferences.Editor edit = this.f11786a.edit();
        m.d(edit, "editor");
        edit.remove(aVar.f24459a);
        edit.apply();
    }

    public final void c(a aVar, int i4) {
        m.e(aVar, "preferenceKey");
        SharedPreferences.Editor edit = this.f11786a.edit();
        m.d(edit, "editor");
        edit.putInt(aVar.f24459a, i4);
        edit.apply();
    }

    public final void d(a aVar, Vector vector) {
        m.e(aVar, LeanbackPreferenceDialogFragment.ARG_KEY);
        m.e(vector, "list");
        String r4 = new Gson().r(vector);
        m.d(r4, "json");
        e(aVar, r4);
    }

    public final void e(a aVar, String str) {
        m.e(aVar, "preferenceKey");
        m.e(str, "value");
        SharedPreferences.Editor edit = this.f11786a.edit();
        m.d(edit, "editor");
        edit.putString(aVar.f24459a, str);
        edit.apply();
    }

    public final void g(String str, String str2) {
        m.e(str, "preferenceKey");
        m.e(str2, "value");
        SharedPreferences.Editor edit = this.f11786a.edit();
        m.d(edit, "editor");
        edit.putString(str, str2);
        edit.apply();
    }

    public final boolean h(a aVar) {
        m.e(aVar, "preferenceKey");
        return this.f11786a.getBoolean(aVar.f24459a, false);
    }

    public final int i(a aVar) {
        m.e(aVar, "preferenceKey");
        return this.f11786a.getInt(aVar.f24459a, 0);
    }

    public final String j(a aVar) {
        m.e(aVar, "preferenceKey");
        String string = this.f11786a.getString(aVar.f24459a, "");
        if (string == null) {
            return "";
        }
        return string;
    }

    public final Vector k(a aVar) {
        m.e(aVar, LeanbackPreferenceDialogFragment.ARG_KEY);
        try {
            return (Vector) new Gson().j(j(aVar), new SharedStorage$getVectorPreference$type$1().d());
        } catch (Exception unused) {
            return null;
        }
    }
}
