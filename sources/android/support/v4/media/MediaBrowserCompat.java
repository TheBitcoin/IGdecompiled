package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import d.C0909b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class MediaBrowserCompat {

    /* renamed from: b  reason: collision with root package name */
    static final boolean f680b = Log.isLoggable("MediaBrowserCompat", 3);

    /* renamed from: a  reason: collision with root package name */
    private final c f681a;

    private static class CustomActionResultReceiver extends C0909b {
        /* access modifiers changed from: protected */
        public void a(int i4, Bundle bundle) {
        }
    }

    private static class ItemReceiver extends C0909b {
        /* access modifiers changed from: protected */
        public void a(int i4, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i4 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                throw null;
            }
            Parcelable parcelable = bundle.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                MediaItem mediaItem = (MediaItem) parcelable;
                throw null;
            }
            throw null;
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final int f682a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f683b;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            /* renamed from: b */
            public MediaItem[] newArray(int i4) {
                return new MediaItem[i4];
            }
        }

        MediaItem(Parcel parcel) {
            this.f682a = parcel.readInt();
            this.f683b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{" + "mFlags=" + this.f682a + ", mDescription=" + this.f683b + '}';
        }

        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.f682a);
            this.f683b.writeToParcel(parcel, i4);
        }
    }

    private static class SearchResultReceiver extends C0909b {
        /* access modifiers changed from: protected */
        public void a(int i4, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i4 != 0 || bundle == null || !bundle.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                throw null;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            if (parcelableArray != null) {
                ArrayList arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            throw null;
        }
    }

    private static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference f684a;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference f685b;

        a(g gVar) {
            this.f684a = new WeakReference(gVar);
        }

        /* access modifiers changed from: package-private */
        public void a(Messenger messenger) {
            this.f685b = new WeakReference(messenger);
        }

        public void handleMessage(Message message) {
            WeakReference weakReference = this.f685b;
            if (weakReference != null && weakReference.get() != null && this.f684a.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.a(data);
                g gVar = (g) this.f684a.get();
                Messenger messenger = (Messenger) this.f685b.get();
                try {
                    int i4 = message.what;
                    if (i4 == 1) {
                        Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                        MediaSessionCompat.a(bundle);
                        gVar.f(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) data.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                    } else if (i4 == 2) {
                        gVar.i(messenger);
                    } else if (i4 != 3) {
                        Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: " + 1 + "\n  Service version: " + message.arg1);
                    } else {
                        Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                        MediaSessionCompat.a(bundle2);
                        Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                        MediaSessionCompat.a(bundle3);
                        gVar.g(messenger, data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        gVar.i(messenger);
                    }
                }
            }
        }
    }

    public static class b {
        a mConnectionCallbackInternal;
        final Object mConnectionCallbackObj = b.c(new C0017b());

        interface a {
            void a();

            void c();

            void d();
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$b$b  reason: collision with other inner class name */
        private class C0017b implements b.a {
            C0017b() {
            }

            public void a() {
                a aVar = b.this.mConnectionCallbackInternal;
                if (aVar != null) {
                    aVar.a();
                }
                b.this.onConnectionSuspended();
            }

            public void c() {
                a aVar = b.this.mConnectionCallbackInternal;
                if (aVar != null) {
                    aVar.c();
                }
                b.this.onConnected();
            }

            public void d() {
                a aVar = b.this.mConnectionCallbackInternal;
                if (aVar != null) {
                    aVar.d();
                }
                b.this.onConnectionFailed();
            }
        }

        public abstract void onConnected();

        public abstract void onConnectionFailed();

        public abstract void onConnectionSuspended();

        /* access modifiers changed from: package-private */
        public void setInternalConnectionCallback(a aVar) {
            this.mConnectionCallbackInternal = aVar;
        }
    }

    interface c {
        void b();

        MediaSessionCompat.Token e();

        void h();
    }

    static class d implements c, g, b.a {

        /* renamed from: a  reason: collision with root package name */
        final Context f687a;

        /* renamed from: b  reason: collision with root package name */
        protected final Object f688b;

        /* renamed from: c  reason: collision with root package name */
        protected final Bundle f689c;

        /* renamed from: d  reason: collision with root package name */
        protected final a f690d = new a(this);

        /* renamed from: e  reason: collision with root package name */
        private final ArrayMap f691e = new ArrayMap();

        /* renamed from: f  reason: collision with root package name */
        protected int f692f;

        /* renamed from: g  reason: collision with root package name */
        protected h f693g;

        /* renamed from: h  reason: collision with root package name */
        protected Messenger f694h;

        /* renamed from: i  reason: collision with root package name */
        private MediaSessionCompat.Token f695i;

        d(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            Bundle bundle2;
            this.f687a = context;
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            this.f689c = bundle2;
            bundle2.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            bVar.setInternalConnectionCallback(this);
            this.f688b = b.b(context, componentName, bVar.mConnectionCallbackObj, bundle2);
        }

        public void a() {
            this.f693g = null;
            this.f694h = null;
            this.f695i = null;
            this.f690d.a((Messenger) null);
        }

        public void b() {
            Messenger messenger;
            h hVar = this.f693g;
            if (!(hVar == null || (messenger = this.f694h) == null)) {
                try {
                    hVar.c(messenger);
                } catch (RemoteException unused) {
                    Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            b.d(this.f688b);
        }

        public void c() {
            Bundle e5 = b.e(this.f688b);
            if (e5 != null) {
                this.f692f = e5.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                IBinder binder = BundleCompat.getBinder(e5, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    this.f693g = new h(binder, this.f689c);
                    Messenger messenger = new Messenger(this.f690d);
                    this.f694h = messenger;
                    this.f690d.a(messenger);
                    try {
                        this.f693g.a(this.f687a, this.f694h);
                    } catch (RemoteException unused) {
                        Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                android.support.v4.media.session.b h4 = b.a.h(BundleCompat.getBinder(e5, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (h4 != null) {
                    this.f695i = MediaSessionCompat.Token.b(b.f(this.f688b), h4);
                }
            }
        }

        public void d() {
        }

        public MediaSessionCompat.Token e() {
            if (this.f695i == null) {
                this.f695i = MediaSessionCompat.Token.a(b.f(this.f688b));
            }
            return this.f695i;
        }

        public void f(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        public void g(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.f694h == messenger) {
                a.a(this.f691e.get(str));
                if (MediaBrowserCompat.f680b) {
                    Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
                }
            }
        }

        public void h() {
            b.a(this.f688b);
        }

        public void i(Messenger messenger) {
        }
    }

    static class e extends d {
        e(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    static class f extends e {
        f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    interface g {
        void f(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void g(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);

        void i(Messenger messenger);
    }

    private static class h {

        /* renamed from: a  reason: collision with root package name */
        private Messenger f696a;

        /* renamed from: b  reason: collision with root package name */
        private Bundle f697b;

        public h(IBinder iBinder, Bundle bundle) {
            this.f696a = new Messenger(iBinder);
            this.f697b = bundle;
        }

        private void b(int i4, Bundle bundle, Messenger messenger) {
            Message obtain = Message.obtain();
            obtain.what = i4;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.f696a.send(obtain);
        }

        /* access modifiers changed from: package-private */
        public void a(Context context, Messenger messenger) {
            Bundle bundle = new Bundle();
            bundle.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f697b);
            b(6, bundle, messenger);
        }

        /* access modifiers changed from: package-private */
        public void c(Messenger messenger) {
            b(7, (Bundle) null, messenger);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            this.f681a = new f(context, componentName, bVar, bundle);
        } else if (i4 >= 23) {
            this.f681a = new e(context, componentName, bVar, bundle);
        } else {
            this.f681a = new d(context, componentName, bVar, bundle);
        }
    }

    public void a() {
        this.f681a.h();
    }

    public void b() {
        this.f681a.b();
    }

    public MediaSessionCompat.Token c() {
        return this.f681a.e();
    }
}
