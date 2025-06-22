package com.squareup.picasso;

import N3.L;
import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import com.squareup.picasso.s;
import com.squareup.picasso.x;
import java.io.InputStream;

class d extends x {

    /* renamed from: b  reason: collision with root package name */
    private static final UriMatcher f17237b;

    /* renamed from: a  reason: collision with root package name */
    private final Context f17238a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f17237b = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher.addURI("com.android.contacts", "display_photo/#", 4);
    }

    d(Context context) {
        this.f17238a = context;
    }

    private InputStream j(v vVar) {
        ContentResolver contentResolver = this.f17238a.getContentResolver();
        Uri uri = vVar.f17353d;
        int match = f17237b.match(uri);
        if (match != 1) {
            if (match != 2) {
                if (match != 3) {
                    if (match != 4) {
                        throw new IllegalStateException("Invalid uri: " + uri);
                    }
                }
            }
            return contentResolver.openInputStream(uri);
        }
        uri = ContactsContract.Contacts.lookupContact(contentResolver, uri);
        if (uri == null) {
            return null;
        }
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    public boolean c(v vVar) {
        Uri uri = vVar.f17353d;
        if (!"content".equals(uri.getScheme()) || !ContactsContract.Contacts.CONTENT_URI.getHost().equals(uri.getHost()) || f17237b.match(vVar.f17353d) == -1) {
            return false;
        }
        return true;
    }

    public x.a f(v vVar, int i4) {
        InputStream j4 = j(vVar);
        if (j4 == null) {
            return null;
        }
        return new x.a(L.l(j4), s.e.DISK);
    }
}
