package com.google.android.gms.auth.api.signin.internal;

import G.g;
import G.x;
import K.f;
import android.os.Bundle;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

final class a implements LoaderManager.LoaderCallbacks {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SignInHubActivity f1243a;

    /* synthetic */ a(SignInHubActivity signInHubActivity, x xVar) {
        this.f1243a = signInHubActivity;
    }

    public final Loader onCreateLoader(int i4, Bundle bundle) {
        return new g(this.f1243a, f.b());
    }

    public final /* bridge */ /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        Void voidR = (Void) obj;
        SignInHubActivity signInHubActivity = this.f1243a;
        signInHubActivity.setResult(signInHubActivity.f1241d, signInHubActivity.f1242e);
        this.f1243a.finish();
    }

    public final void onLoaderReset(Loader loader) {
    }
}
