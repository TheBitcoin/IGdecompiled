package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.core.app.BundleCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class MediaControllerCompat {

    /* renamed from: a  reason: collision with root package name */
    private final b f725a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaSessionCompat.Token f726b;

    /* renamed from: c  reason: collision with root package name */
    private final HashSet f727c = new HashSet();

    static class MediaControllerImplApi21 implements b {

        /* renamed from: a  reason: collision with root package name */
        protected final Object f728a;

        /* renamed from: b  reason: collision with root package name */
        final Object f729b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private final List f730c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private HashMap f731d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        final MediaSessionCompat.Token f732e;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* renamed from: a  reason: collision with root package name */
            private WeakReference f733a;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super((Handler) null);
                this.f733a = new WeakReference(mediaControllerImplApi21);
            }

            /* access modifiers changed from: protected */
            public void onReceiveResult(int i4, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21) this.f733a.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f729b) {
                        mediaControllerImplApi21.f732e.e(b.a.h(BundleCompat.getBinder(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                        mediaControllerImplApi21.f732e.f(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                        mediaControllerImplApi21.f();
                    }
                }
            }
        }

        private static class a extends a.c {
            a(a aVar) {
                super(aVar);
            }

            public void S(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            public void a(Bundle bundle) {
                throw new AssertionError();
            }

            public void c(List list) {
                throw new AssertionError();
            }

            public void e(CharSequence charSequence) {
                throw new AssertionError();
            }

            public void g() {
                throw new AssertionError();
            }

            public void k0(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f732e = token;
            Object c5 = c.c(context, token.d());
            this.f728a = c5;
            if (c5 == null) {
                throw new RemoteException();
            } else if (token.c() == null) {
                g();
            }
        }

        private void g() {
            h("android.support.v4.media.session.command.GET_EXTRA_BINDER", (Bundle) null, new ExtraBinderRequestResultReceiver(this));
        }

        public MediaMetadataCompat a() {
            Object d5 = c.d(this.f728a);
            if (d5 != null) {
                return MediaMetadataCompat.a(d5);
            }
            return null;
        }

        public final void b(a aVar) {
            c.i(this.f728a, aVar.mCallbackObj);
            synchronized (this.f729b) {
                if (this.f732e.c() != null) {
                    try {
                        a aVar2 = (a) this.f731d.remove(aVar);
                        if (aVar2 != null) {
                            aVar.mIControllerCallback = null;
                            this.f732e.c().F(aVar2);
                        }
                    } catch (RemoteException e5) {
                        Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e5);
                    }
                } else {
                    this.f730c.remove(aVar);
                }
            }
        }

        public boolean c(KeyEvent keyEvent) {
            return c.b(this.f728a, keyEvent);
        }

        public f d() {
            Object f4 = c.f(this.f728a);
            if (f4 != null) {
                return new g(f4);
            }
            return null;
        }

        public final void e(a aVar, Handler handler) {
            c.g(this.f728a, aVar.mCallbackObj, handler);
            synchronized (this.f729b) {
                if (this.f732e.c() != null) {
                    a aVar2 = new a(aVar);
                    this.f731d.put(aVar, aVar2);
                    aVar.mIControllerCallback = aVar2;
                    try {
                        this.f732e.c().n(aVar2);
                        aVar.postToHandler(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e5) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e5);
                    }
                } else {
                    aVar.mIControllerCallback = null;
                    this.f730c.add(aVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void f() {
            if (this.f732e.c() != null) {
                for (a aVar : this.f730c) {
                    a aVar2 = new a(aVar);
                    this.f731d.put(aVar, aVar2);
                    aVar.mIControllerCallback = aVar2;
                    try {
                        this.f732e.c().n(aVar2);
                        aVar.postToHandler(13, (Object) null, (Bundle) null);
                    } catch (RemoteException e5) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e5);
                    }
                }
                this.f730c.clear();
            }
        }

        public PlaybackStateCompat getPlaybackState() {
            if (this.f732e.c() != null) {
                try {
                    return this.f732e.c().getPlaybackState();
                } catch (RemoteException e5) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e5);
                }
            }
            Object e6 = c.e(this.f728a);
            if (e6 != null) {
                return PlaybackStateCompat.a(e6);
            }
            return null;
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver) {
            c.h(this.f728a, str, bundle, resultReceiver);
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {
        final Object mCallbackObj = c.a(new b(this));
        C0019a mHandler;
        a mIControllerCallback;

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a  reason: collision with other inner class name */
        private class C0019a extends Handler {

            /* renamed from: a  reason: collision with root package name */
            boolean f734a = false;

            C0019a(Looper looper) {
                super(looper);
            }

            public void handleMessage(Message message) {
                if (this.f734a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.a(data);
                            a.this.onSessionEvent((String) message.obj, data);
                            return;
                        case 2:
                            a.this.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            a.this.onMetadataChanged((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            a.this.onAudioInfoChanged((e) message.obj);
                            return;
                        case 5:
                            a.this.onQueueChanged((List) message.obj);
                            return;
                        case 6:
                            a.this.onQueueTitleChanged((CharSequence) message.obj);
                            return;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.a(bundle);
                            a.this.onExtrasChanged(bundle);
                            return;
                        case 8:
                            a.this.onSessionDestroyed();
                            return;
                        case 9:
                            a.this.onRepeatModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 11:
                            a.this.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            a.this.onShuffleModeChanged(((Integer) message.obj).intValue());
                            return;
                        case 13:
                            a.this.onSessionReady();
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        private static class b implements c.a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference f736a;

            b(a aVar) {
                this.f736a = new WeakReference(aVar);
            }

            public void a(Bundle bundle) {
                a aVar = (a) this.f736a.get();
                if (aVar != null) {
                    aVar.onExtrasChanged(bundle);
                }
            }

            public void b(Object obj) {
                a aVar = (a) this.f736a.get();
                if (aVar != null) {
                    aVar.onMetadataChanged(MediaMetadataCompat.a(obj));
                }
            }

            public void c(List list) {
                a aVar = (a) this.f736a.get();
                if (aVar != null) {
                    aVar.onQueueChanged(MediaSessionCompat.QueueItem.b(list));
                }
            }

            public void d(int i4, int i5, int i6, int i7, int i8) {
                a aVar = (a) this.f736a.get();
                if (aVar != null) {
                    aVar.onAudioInfoChanged(new e(i4, i5, i6, i7, i8));
                }
            }

            public void e(CharSequence charSequence) {
                a aVar = (a) this.f736a.get();
                if (aVar != null) {
                    aVar.onQueueTitleChanged(charSequence);
                }
            }

            public void f(Object obj) {
                a aVar = (a) this.f736a.get();
                if (aVar != null && aVar.mIControllerCallback == null) {
                    aVar.onPlaybackStateChanged(PlaybackStateCompat.a(obj));
                }
            }

            public void g() {
                a aVar = (a) this.f736a.get();
                if (aVar != null) {
                    aVar.onSessionDestroyed();
                }
            }

            public void h(String str, Bundle bundle) {
                a aVar = (a) this.f736a.get();
                if (aVar == null) {
                    return;
                }
                if (aVar.mIControllerCallback == null || Build.VERSION.SDK_INT >= 23) {
                    aVar.onSessionEvent(str, bundle);
                }
            }
        }

        private static class c extends a.C0020a {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference f737a;

            c(a aVar) {
                this.f737a = new WeakReference(aVar);
            }

            public void I(boolean z4) {
                a aVar = (a) this.f737a.get();
                if (aVar != null) {
                    aVar.postToHandler(11, Boolean.valueOf(z4), (Bundle) null);
                }
            }

            public void Q(boolean z4) {
            }

            public void Y(int i4) {
                a aVar = (a) this.f737a.get();
                if (aVar != null) {
                    aVar.postToHandler(12, Integer.valueOf(i4), (Bundle) null);
                }
            }

            public void h0(PlaybackStateCompat playbackStateCompat) {
                a aVar = (a) this.f737a.get();
                if (aVar != null) {
                    aVar.postToHandler(2, playbackStateCompat, (Bundle) null);
                }
            }

            public void j(String str, Bundle bundle) {
                a aVar = (a) this.f737a.get();
                if (aVar != null) {
                    aVar.postToHandler(1, str, bundle);
                }
            }

            public void onRepeatModeChanged(int i4) {
                a aVar = (a) this.f737a.get();
                if (aVar != null) {
                    aVar.postToHandler(9, Integer.valueOf(i4), (Bundle) null);
                }
            }

            public void y() {
                a aVar = (a) this.f737a.get();
                if (aVar != null) {
                    aVar.postToHandler(13, (Object) null, (Bundle) null);
                }
            }
        }

        public void binderDied() {
            postToHandler(8, (Object) null, (Bundle) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public a getIControllerCallback() {
            return this.mIControllerCallback;
        }

        public void onAudioInfoChanged(e eVar) {
        }

        public void onCaptioningEnabledChanged(boolean z4) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public abstract void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat);

        public abstract void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat);

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onRepeatModeChanged(int i4) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int i4) {
        }

        /* access modifiers changed from: package-private */
        public void postToHandler(int i4, Object obj, Bundle bundle) {
            C0019a aVar = this.mHandler;
            if (aVar != null) {
                Message obtainMessage = aVar.obtainMessage(i4, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        /* access modifiers changed from: package-private */
        public void setHandler(Handler handler) {
            if (handler == null) {
                C0019a aVar = this.mHandler;
                if (aVar != null) {
                    aVar.f734a = false;
                    aVar.removeCallbacksAndMessages((Object) null);
                    this.mHandler = null;
                    return;
                }
                return;
            }
            C0019a aVar2 = new C0019a(handler.getLooper());
            this.mHandler = aVar2;
            aVar2.f734a = true;
        }
    }

    interface b {
        MediaMetadataCompat a();

        void b(a aVar);

        boolean c(KeyEvent keyEvent);

        f d();

        void e(a aVar, Handler handler);

        PlaybackStateCompat getPlaybackState();
    }

    static class c extends MediaControllerImplApi21 {
        public c(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }

        public f d() {
            Object f4 = c.f(this.f728a);
            if (f4 != null) {
                return new h(f4);
            }
            return null;
        }
    }

    static class d extends c {
        public d(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }

        public f d() {
            Object f4 = c.f(this.f728a);
            if (f4 != null) {
                return new i(f4);
            }
            return null;
        }
    }

    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        private final int f738a;

        /* renamed from: b  reason: collision with root package name */
        private final int f739b;

        /* renamed from: c  reason: collision with root package name */
        private final int f740c;

        /* renamed from: d  reason: collision with root package name */
        private final int f741d;

        /* renamed from: e  reason: collision with root package name */
        private final int f742e;

        e(int i4, int i5, int i6, int i7, int i8) {
            this.f738a = i4;
            this.f739b = i5;
            this.f740c = i6;
            this.f741d = i7;
            this.f742e = i8;
        }
    }

    public static abstract class f {
        f() {
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d();

        public abstract void e(long j4);

        public abstract void f(int i4);

        public abstract void g(int i4);

        public abstract void h();

        public abstract void i();
    }

    static class g extends f {

        /* renamed from: a  reason: collision with root package name */
        protected final Object f743a;

        public g(Object obj) {
            this.f743a = obj;
        }

        public void a() {
            c.d.a(this.f743a);
        }

        public void b() {
            c.d.b(this.f743a);
        }

        public void c() {
            c.d.c(this.f743a);
        }

        public void d() {
            c.d.d(this.f743a);
        }

        public void e(long j4) {
            c.d.e(this.f743a, j4);
        }

        public void f(int i4) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE", i4);
            j("android.support.v4.media.session.action.SET_REPEAT_MODE", bundle);
        }

        public void g(int i4) {
            Bundle bundle = new Bundle();
            bundle.putInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE", i4);
            j("android.support.v4.media.session.action.SET_SHUFFLE_MODE", bundle);
        }

        public void h() {
            c.d.g(this.f743a);
        }

        public void i() {
            c.d.h(this.f743a);
        }

        public void j(String str, Bundle bundle) {
            MediaControllerCompat.h(str, bundle);
            c.d.f(this.f743a, str, bundle);
        }
    }

    static class h extends g {
        public h(Object obj) {
            super(obj);
        }
    }

    static class i extends h {
        public i(Object obj) {
            super(obj);
        }
    }

    public MediaControllerCompat(Context context, MediaSessionCompat.Token token) {
        if (token != null) {
            this.f726b = token;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 24) {
                this.f725a = new d(context, token);
            } else if (i4 >= 23) {
                this.f725a = new c(context, token);
            } else {
                this.f725a = new MediaControllerImplApi21(context, token);
            }
        } else {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
    }

    static void h(String str, Bundle bundle) {
        if (str != null) {
            if (!str.equals("android.support.v4.media.session.action.FOLLOW") && !str.equals("android.support.v4.media.session.action.UNFOLLOW")) {
                return;
            }
            if (bundle == null || !bundle.containsKey("android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE")) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + ".");
            }
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f725a.c(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public MediaMetadataCompat b() {
        return this.f725a.a();
    }

    public PlaybackStateCompat c() {
        return this.f725a.getPlaybackState();
    }

    public f d() {
        return this.f725a.d();
    }

    public void e(a aVar) {
        f(aVar, (Handler) null);
    }

    public void f(a aVar, Handler handler) {
        if (aVar != null) {
            if (handler == null) {
                handler = new Handler();
            }
            aVar.setHandler(handler);
            this.f725a.e(aVar, handler);
            this.f727c.add(aVar);
            return;
        }
        throw new IllegalArgumentException("callback must not be null");
    }

    public void g(a aVar) {
        if (aVar != null) {
            try {
                this.f727c.remove(aVar);
                this.f725a.b(aVar);
            } finally {
                aVar.setHandler((Handler) null);
            }
        } else {
            throw new IllegalArgumentException("callback must not be null");
        }
    }
}
