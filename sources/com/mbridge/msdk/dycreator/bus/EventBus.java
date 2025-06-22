package com.mbridge.msdk.dycreator.bus;

import android.os.Looper;
import android.util.Log;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class EventBus {
    public static String TAG = "Event";

    /* renamed from: a  reason: collision with root package name */
    static ExecutorService f12590a = Executors.newCachedThreadPool();

    /* renamed from: b  reason: collision with root package name */
    private static volatile EventBus f12591b;

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<?>, List<Class<?>>> f12592c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> f12593d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final Map<Object, List<Class<?>>> f12594e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final Map<Class<?>, Object> f12595f = new ConcurrentHashMap();

    /* renamed from: g  reason: collision with root package name */
    private final ThreadLocal<List<Object>> f12596g = new ThreadLocal<List<Object>>() {
        /* access modifiers changed from: protected */
        public /* synthetic */ Object initialValue() {
            return new ArrayList();
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private final ThreadLocal<BooleanWrapper> f12597h = new ThreadLocal<BooleanWrapper>() {
        /* access modifiers changed from: protected */
        public /* synthetic */ Object initialValue() {
            return new BooleanWrapper();
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private String f12598i = "onEvent";

    /* renamed from: j  reason: collision with root package name */
    private final HandlerPoster f12599j = new HandlerPoster(this, Looper.getMainLooper(), 10);

    /* renamed from: k  reason: collision with root package name */
    private final BackgroundPoster f12600k = new BackgroundPoster(this);

    /* renamed from: l  reason: collision with root package name */
    private final AsyncPoster f12601l = new AsyncPoster(this);

    /* renamed from: m  reason: collision with root package name */
    private final SubscriberMethodFinder f12602m = new SubscriberMethodFinder();

    /* renamed from: n  reason: collision with root package name */
    private boolean f12603n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f12604o = true;

    /* renamed from: p  reason: collision with root package name */
    private Map<String, Object> f12605p = new ConcurrentHashMap();

    /* renamed from: com.mbridge.msdk.dycreator.bus.EventBus$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12608a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.mbridge.msdk.dycreator.bus.ThreadMode[] r0 = com.mbridge.msdk.dycreator.bus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f12608a = r0
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.PostThread     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f12608a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.MainThread     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f12608a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.BackgroundThread     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f12608a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.Async     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.bus.EventBus.AnonymousClass3.<clinit>():void");
        }
    }

    static final class BooleanWrapper {

        /* renamed from: a  reason: collision with root package name */
        boolean f12609a;

        BooleanWrapper() {
        }
    }

    interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    private void a(Object obj, String str, boolean z4) {
        for (SubscriberMethod a5 : this.f12602m.a(obj.getClass(), str)) {
            a(obj, a5, z4);
        }
    }

    public static void clearCaches() {
        SubscriberMethodFinder.a();
        f12592c.clear();
    }

    public static void clearSkipMethodNameVerifications() {
        SubscriberMethodFinder.clearSkipMethodNameVerifications();
    }

    public static EventBus getDefault() {
        if (f12591b == null) {
            synchronized (EventBus.class) {
                try {
                    if (f12591b == null) {
                        f12591b = new EventBus();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12591b;
    }

    public static void skipMethodNameVerificationFor(Class<?> cls) {
        SubscriberMethodFinder.a(cls);
    }

    public final void configureLogSubscriberExceptions(boolean z4) {
        if (!this.f12603n) {
            this.f12604o = z4;
            return;
        }
        throw new EventBusException("This method must be called before any registration");
    }

    public final Object getStickyEvent(Class<?> cls) {
        Object obj;
        synchronized (this.f12595f) {
            obj = this.f12595f.get(cls);
        }
        return obj;
    }

    public final void post(Object obj) {
        boolean z4;
        CopyOnWriteArrayList copyOnWriteArrayList;
        List list = this.f12596g.get();
        list.add(obj);
        BooleanWrapper booleanWrapper = this.f12597h.get();
        if (!booleanWrapper.f12609a) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z4 = true;
            } else {
                z4 = false;
            }
            booleanWrapper.f12609a = true;
            while (!list.isEmpty()) {
                try {
                    Object remove = list.remove(0);
                    if (remove != null) {
                        Class<?> cls = remove.getClass();
                        List<Class<?>> a5 = a(cls);
                        int size = a5.size();
                        boolean z5 = false;
                        for (int i4 = 0; i4 < size; i4++) {
                            Class cls2 = a5.get(i4);
                            synchronized (this) {
                                copyOnWriteArrayList = this.f12593d.get(cls2);
                            }
                            if (copyOnWriteArrayList != null) {
                                Iterator it = copyOnWriteArrayList.iterator();
                                while (it.hasNext()) {
                                    a((Subscription) it.next(), remove, z4);
                                }
                                z5 = true;
                            }
                        }
                        if (!z5) {
                            String str = TAG;
                            Log.d(str, "No subscripers registered for event " + cls);
                            if (!(cls == NoSubscriberEvent.class || cls == SubscriberExceptionEvent.class)) {
                                post(new NoSubscriberEvent(this, remove));
                            }
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                } catch (Throwable th) {
                    booleanWrapper.f12609a = false;
                    throw th;
                }
            }
            booleanWrapper.f12609a = false;
        }
    }

    public final void postSticky(Object obj) {
        post(obj);
        synchronized (this.f12595f) {
            this.f12595f.put(obj.getClass(), obj);
        }
    }

    public final void register(Object obj) {
        a(obj, this.f12598i, false);
    }

    public final void registerSticky(Object obj) {
        a(obj, this.f12598i, true);
    }

    public final void release() {
        if (f12591b != null) {
            f12591b = null;
            f12590a = null;
            Map<Class<?>, List<Class<?>>> map = f12592c;
            if (map != null && map.size() > 0) {
                map.clear();
            }
            Map<Class<?>, CopyOnWriteArrayList<Subscription>> map2 = this.f12593d;
            if (map2 != null && map2.size() > 0) {
                this.f12593d.clear();
            }
            Map<Object, List<Class<?>>> map3 = this.f12594e;
            if (map3 != null && map3.size() > 0) {
                this.f12594e.clear();
            }
            Map<Class<?>, Object> map4 = this.f12595f;
            if (map4 != null && map4.size() > 0) {
                this.f12595f.clear();
            }
            Map<String, Object> map5 = this.f12605p;
            if (map5 != null && map5.size() > 0) {
                this.f12605p.clear();
            }
        }
    }

    public final Object removeStickyEvent(Class<?> cls) {
        Object remove;
        synchronized (this.f12595f) {
            remove = this.f12595f.remove(cls);
        }
        return remove;
    }

    public final synchronized void unregister(Object obj, Class<?>... clsArr) {
        try {
            if (clsArr.length != 0) {
                List list = this.f12594e.get(obj);
                if (list != null) {
                    for (Class<?> cls : clsArr) {
                        a(obj, cls);
                        list.remove(cls);
                    }
                    if (list.isEmpty()) {
                        this.f12594e.remove(obj);
                    }
                } else {
                    Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
                }
            } else {
                throw new IllegalArgumentException("Provide at least one event class");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void register(String str, Object obj) {
        Map<String, Object> map = this.f12605p;
        if (map != null && map.containsKey(str)) {
            unregister(this.f12605p.get(str));
        }
        this.f12605p.put(str, obj);
        a(obj, this.f12598i, false);
    }

    public final void registerSticky(Object obj, String str) {
        a(obj, str, true);
    }

    public final void registerSticky(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f12598i, true, cls, clsArr);
    }

    public final synchronized void registerSticky(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        try {
            a(obj, str, true, cls, clsArr);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final boolean removeStickyEvent(Object obj) {
        synchronized (this.f12595f) {
            try {
                Class<?> cls = obj.getClass();
                if (!obj.equals(this.f12595f.get(cls))) {
                    return false;
                }
                this.f12595f.remove(cls);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private synchronized void a(Object obj, String str, boolean z4, Class<?> cls, Class<?>... clsArr) {
        try {
            for (SubscriberMethod next : this.f12602m.a(obj.getClass(), str)) {
                if (cls == next.f12622c) {
                    a(obj, next, z4);
                } else if (clsArr != null) {
                    int length = clsArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= length) {
                            break;
                        } else if (clsArr[i4] == next.f12622c) {
                            a(obj, next, z4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
            }
        } finally {
            while (true) {
            }
        }
    }

    public final void register(Object obj, String str) {
        a(obj, str, false);
    }

    public final void register(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.f12598i, false, cls, clsArr);
    }

    public final synchronized void register(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        try {
            a(obj, str, false, cls, clsArr);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public final synchronized void unregister(Object obj) {
        try {
            List<Class> list = this.f12594e.get(obj);
            if (list != null) {
                for (Class a5 : list) {
                    a(obj, (Class<?>) a5);
                }
                this.f12594e.remove(obj);
            } else {
                String str = TAG;
                Log.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private void a(Object obj, SubscriberMethod subscriberMethod, boolean z4) {
        Object obj2;
        boolean z5 = true;
        this.f12603n = true;
        Class<?> cls = subscriberMethod.f12622c;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f12593d.get(cls);
        Subscription subscription = new Subscription(obj, subscriberMethod);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f12593d.put(cls, copyOnWriteArrayList);
        } else {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (((Subscription) it.next()).equals(subscription)) {
                    throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        subscriberMethod.f12620a.setAccessible(true);
        copyOnWriteArrayList.add(subscription);
        List list = this.f12594e.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f12594e.put(obj, list);
        }
        list.add(cls);
        if (z4) {
            synchronized (this.f12595f) {
                obj2 = this.f12595f.get(cls);
            }
            if (obj2 != null) {
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    z5 = false;
                }
                a(subscription, obj2, z5);
            }
        }
    }

    public final synchronized void unregister(String str) {
        try {
            Map<String, Object> map = this.f12605p;
            if (map != null && map.containsKey(str)) {
                Object remove = this.f12605p.remove(str);
                List<Class> list = this.f12594e.get(remove);
                if (list != null) {
                    for (Class a5 : list) {
                        a(remove, (Class<?>) a5);
                    }
                    this.f12594e.remove(remove);
                } else {
                    String str2 = TAG;
                    Log.w(str2, "Subscriber to unregister was not registered before: " + remove.getClass());
                }
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private void a(Object obj, Class<?> cls) {
        List list = this.f12593d.get(cls);
        if (list != null) {
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                if (((Subscription) list.get(i4)).f12626a == obj) {
                    list.remove(i4);
                    i4--;
                    size--;
                }
                i4++;
            }
        }
    }

    private void a(Subscription subscription, Object obj, boolean z4) {
        int i4 = AnonymousClass3.f12608a[subscription.f12627b.f12621b.ordinal()];
        if (i4 == 1) {
            a(subscription, obj);
        } else if (i4 != 2) {
            if (i4 != 3) {
                if (i4 == 4) {
                    this.f12601l.enqueue(subscription, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + subscription.f12627b.f12621b);
            } else if (z4) {
                this.f12600k.enqueue(subscription, obj);
            } else {
                a(subscription, obj);
            }
        } else if (z4) {
            a(subscription, obj);
        } else {
            this.f12599j.a(subscription, obj);
        }
    }

    private List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = f12592c;
        synchronized (map) {
            try {
                list = map.get(cls);
                if (list == null) {
                    list = new ArrayList<>();
                    for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                        list.add(cls2);
                        a(list, (Class<?>[]) cls2.getInterfaces());
                    }
                    f12592c.put(cls, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    private static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(PendingPost pendingPost) {
        Object obj = pendingPost.f12615a;
        Subscription subscription = pendingPost.f12616b;
        PendingPost.a(pendingPost);
        a(subscription, obj);
    }

    private void a(Subscription subscription, Object obj) throws Error {
        try {
            subscription.f12627b.f12620a.invoke(subscription.f12626a, new Object[]{obj});
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (obj instanceof SubscriberExceptionEvent) {
                String str = TAG;
                Log.e(str, "SubscriberExceptionEvent subscriber " + subscription.f12626a.getClass() + " threw an exception", cause);
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                String str2 = TAG;
                Log.e(str2, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
                return;
            }
            if (this.f12604o) {
                String str3 = TAG;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.f12626a.getClass(), cause);
            }
            post(new SubscriberExceptionEvent(this, cause, obj, subscription.f12626a));
        } catch (IllegalAccessException e6) {
            throw new IllegalStateException("Unexpected exception", e6);
        }
    }
}
