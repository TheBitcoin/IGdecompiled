package com.google.android.gms.internal.measurement;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import java.util.Map;

public final class N2 implements P2 {
    public final String a(ContentResolver contentResolver, String str) {
        Cursor query;
        Throwable th;
        Uri uri = H2.f1489a;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        if (acquireUnstableContentProviderClient != null) {
            try {
                query = acquireUnstableContentProviderClient.query(uri, (String[]) null, (String) null, new String[]{str}, (String) null);
                if (query == null) {
                    throw new T2("ContentProvider query returned null cursor");
                } else if (query.moveToFirst()) {
                    String string = query.getString(1);
                    query.close();
                    acquireUnstableContentProviderClient.release();
                    return string;
                } else {
                    query.close();
                    acquireUnstableContentProviderClient.release();
                    return null;
                }
            } catch (RemoteException e5) {
                throw new T2("ContentProvider query failed", e5);
            } catch (Throwable th2) {
                Throwable th3 = th2;
                acquireUnstableContentProviderClient.release();
                throw th3;
            }
        } else {
            throw new T2("Unable to acquire ContentProviderClient");
        }
        throw th;
    }

    public final Map b(ContentResolver contentResolver, String[] strArr, Q2 q22) {
        Cursor query;
        Throwable th;
        Uri uri = H2.f1490b;
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri);
        if (acquireUnstableContentProviderClient != null) {
            try {
                query = acquireUnstableContentProviderClient.query(uri, (String[]) null, (String) null, strArr, (String) null);
                if (query != null) {
                    Map a5 = q22.a(query.getCount());
                    while (query.moveToNext()) {
                        a5.put(query.getString(0), query.getString(1));
                    }
                    if (query.isAfterLast()) {
                        query.close();
                        acquireUnstableContentProviderClient.release();
                        return a5;
                    }
                    throw new T2("Cursor read incomplete (ContentProvider dead?)");
                }
                throw new T2("ContentProvider query returned null cursor");
            } catch (RemoteException e5) {
                try {
                    throw new T2("ContentProvider query failed", e5);
                } catch (Throwable th2) {
                    Throwable th3 = th2;
                    acquireUnstableContentProviderClient.release();
                    throw th3;
                }
            } catch (Throwable th4) {
                th.addSuppressed(th4);
            }
        } else {
            throw new T2("Unable to acquire ContentProviderClient");
        }
        throw th;
    }
}
