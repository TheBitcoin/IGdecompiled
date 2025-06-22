package j$.util.concurrent;

import j$.sun.misc.a;
import java.util.concurrent.locks.LockSupport;

public final class q extends l {

    /* renamed from: h  reason: collision with root package name */
    public static final a f5168h;

    /* renamed from: i  reason: collision with root package name */
    public static final long f5169i;

    /* renamed from: e  reason: collision with root package name */
    public r f5170e;

    /* renamed from: f  reason: collision with root package name */
    public volatile r f5171f;

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f5172g;
    volatile int lockState;

    static {
        a aVar = a.f4833b;
        f5168h = aVar;
        f5169i = aVar.h(q.class, "lockState");
    }

    public static int i(Object obj, Object obj2) {
        int compareTo;
        if (obj == null || obj2 == null || (compareTo = obj.getClass().getName().compareTo(obj2.getClass().getName())) == 0) {
            return System.identityHashCode(obj) <= System.identityHashCode(obj2) ? -1 : 1;
        }
        return compareTo;
    }

    public q(r rVar) {
        super(-2, (Object) null, (Object) null);
        int i4;
        this.f5171f = rVar;
        r rVar2 = null;
        while (rVar != null) {
            r rVar3 = (r) rVar.f5155d;
            rVar.f5175g = null;
            rVar.f5174f = null;
            if (rVar2 == null) {
                rVar.f5173e = null;
                rVar.f5177i = false;
            } else {
                Object obj = rVar.f5153b;
                int i5 = rVar.f5152a;
                r rVar4 = rVar2;
                Class<?> cls = null;
                while (true) {
                    Object obj2 = rVar4.f5153b;
                    int i6 = rVar4.f5152a;
                    if (i6 > i5) {
                        i4 = -1;
                    } else if (i6 < i5) {
                        i4 = 1;
                    } else {
                        if (!(cls == null && (cls = ConcurrentHashMap.c(obj)) == null)) {
                            int i7 = ConcurrentHashMap.f5118g;
                            int compareTo = (obj2 == null || obj2.getClass() != cls) ? 0 : ((Comparable) obj).compareTo(obj2);
                            if (compareTo != 0) {
                                i4 = compareTo;
                            }
                        }
                        i4 = i(obj, obj2);
                    }
                    r rVar5 = i4 <= 0 ? rVar4.f5174f : rVar4.f5175g;
                    if (rVar5 == null) {
                        break;
                    }
                    rVar4 = rVar5;
                }
                rVar.f5173e = rVar4;
                if (i4 <= 0) {
                    rVar4.f5174f = rVar;
                } else {
                    rVar4.f5175g = rVar;
                }
                rVar = c(rVar2, rVar);
            }
            rVar2 = rVar;
            rVar = rVar3;
        }
        this.f5170e = rVar2;
    }

    public final void d() {
        if (!f5168h.c(this, f5169i, 0, 1)) {
            boolean z4 = false;
            while (true) {
                int i4 = this.lockState;
                if ((i4 & -3) == 0) {
                    if (f5168h.c(this, f5169i, i4, 1)) {
                        break;
                    }
                } else if ((i4 & 2) == 0) {
                    if (f5168h.c(this, f5169i, i4, i4 | 2)) {
                        this.f5172g = Thread.currentThread();
                        z4 = true;
                    }
                } else if (z4) {
                    LockSupport.park(this);
                }
            }
            if (z4) {
                this.f5172g = null;
            }
        }
    }

    public final l a(int i4, Object obj) {
        Thread thread;
        Thread thread2;
        Object obj2;
        l lVar = this.f5171f;
        while (true) {
            r rVar = null;
            if (lVar != null) {
                int i5 = this.lockState;
                if ((i5 & 3) == 0) {
                    a aVar = f5168h;
                    long j4 = f5169i;
                    if (aVar.c(this, j4, i5, i5 + 4)) {
                        try {
                            r rVar2 = this.f5170e;
                            if (rVar2 != null) {
                                rVar = rVar2.b(i4, obj, (Class) null);
                            }
                            if (aVar.e(this, j4) == 6 && (thread2 = this.f5172g) != null) {
                                LockSupport.unpark(thread2);
                            }
                            return rVar;
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            if (f5168h.e(this, f5169i) == 6 && (thread = this.f5172g) != null) {
                                LockSupport.unpark(thread);
                            }
                            throw th2;
                        }
                    }
                } else if (lVar.f5152a != i4 || ((obj2 = lVar.f5153b) != obj && (obj2 == null || !obj.equals(obj2)))) {
                    lVar = lVar.f5155d;
                }
            } else {
                return null;
            }
        }
        return lVar;
    }

    public final r e(int i4, Object obj, Object obj2) {
        int i5;
        r b5;
        r b6;
        r rVar = this.f5170e;
        Class<?> cls = null;
        boolean z4 = false;
        while (rVar != null) {
            int i6 = rVar.f5152a;
            if (i6 > i4) {
                i5 = -1;
            } else if (i6 < i4) {
                i5 = 1;
            } else {
                Object obj3 = rVar.f5153b;
                if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                    return rVar;
                }
                if (!(cls == null && (cls = ConcurrentHashMap.c(obj)) == null)) {
                    int i7 = ConcurrentHashMap.f5118g;
                    int compareTo = (obj3 == null || obj3.getClass() != cls) ? 0 : ((Comparable) obj).compareTo(obj3);
                    if (compareTo != 0) {
                        i5 = compareTo;
                    }
                }
                if (!z4) {
                    r rVar2 = rVar.f5174f;
                    if (rVar2 != null && (b6 = rVar2.b(i4, obj, cls)) != null) {
                        return b6;
                    }
                    r rVar3 = rVar.f5175g;
                    if (rVar3 != null && (b5 = rVar3.b(i4, obj, cls)) != null) {
                        return b5;
                    }
                    z4 = true;
                }
                i5 = i(obj, obj3);
            }
            r rVar4 = i5 <= 0 ? rVar.f5174f : rVar.f5175g;
            if (rVar4 == null) {
                r rVar5 = this.f5171f;
                r rVar6 = new r(i4, obj, obj2, rVar5, rVar);
                this.f5171f = rVar6;
                if (rVar5 != null) {
                    rVar5.f5176h = rVar6;
                }
                if (i5 <= 0) {
                    rVar.f5174f = rVar6;
                } else {
                    rVar.f5175g = rVar6;
                }
                if (!rVar.f5177i) {
                    rVar6.f5177i = true;
                    return null;
                }
                d();
                try {
                    this.f5170e = c(this.f5170e, rVar6);
                    return null;
                } finally {
                    this.lockState = 0;
                }
            } else {
                rVar = rVar4;
            }
        }
        r rVar7 = new r(i4, obj, obj2, (l) null, (r) null);
        this.f5170e = rVar7;
        this.f5171f = rVar7;
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x0091 A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ac A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ad A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00bd A[Catch:{ all -> 0x0052 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00c0 A[Catch:{ all -> 0x0052 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(j$.util.concurrent.r r11) {
        /*
            r10 = this;
            j$.util.concurrent.l r0 = r11.f5155d
            j$.util.concurrent.r r0 = (j$.util.concurrent.r) r0
            j$.util.concurrent.r r1 = r11.f5176h
            if (r1 != 0) goto L_0x000b
            r10.f5171f = r0
            goto L_0x000d
        L_0x000b:
            r1.f5155d = r0
        L_0x000d:
            if (r0 == 0) goto L_0x0011
            r0.f5176h = r1
        L_0x0011:
            j$.util.concurrent.r r0 = r10.f5171f
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001a
            r10.f5170e = r2
            return r1
        L_0x001a:
            j$.util.concurrent.r r0 = r10.f5170e
            if (r0 == 0) goto L_0x00ce
            j$.util.concurrent.r r3 = r0.f5175g
            if (r3 == 0) goto L_0x00ce
            j$.util.concurrent.r r3 = r0.f5174f
            if (r3 == 0) goto L_0x00ce
            j$.util.concurrent.r r3 = r3.f5174f
            if (r3 != 0) goto L_0x002c
            goto L_0x00ce
        L_0x002c:
            r10.d()
            r1 = 0
            j$.util.concurrent.r r3 = r11.f5174f     // Catch:{ all -> 0x0052 }
            j$.util.concurrent.r r4 = r11.f5175g     // Catch:{ all -> 0x0052 }
            if (r3 == 0) goto L_0x0087
            if (r4 == 0) goto L_0x0087
            r5 = r4
        L_0x0039:
            j$.util.concurrent.r r6 = r5.f5174f     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x003f
            r5 = r6
            goto L_0x0039
        L_0x003f:
            boolean r6 = r5.f5177i     // Catch:{ all -> 0x0052 }
            boolean r7 = r11.f5177i     // Catch:{ all -> 0x0052 }
            r5.f5177i = r7     // Catch:{ all -> 0x0052 }
            r11.f5177i = r6     // Catch:{ all -> 0x0052 }
            j$.util.concurrent.r r6 = r5.f5175g     // Catch:{ all -> 0x0052 }
            j$.util.concurrent.r r7 = r11.f5173e     // Catch:{ all -> 0x0052 }
            if (r5 != r4) goto L_0x0055
            r11.f5173e = r5     // Catch:{ all -> 0x0052 }
            r5.f5175g = r11     // Catch:{ all -> 0x0052 }
            goto L_0x0068
        L_0x0052:
            r11 = move-exception
            goto L_0x00cb
        L_0x0055:
            j$.util.concurrent.r r8 = r5.f5173e     // Catch:{ all -> 0x0052 }
            r11.f5173e = r8     // Catch:{ all -> 0x0052 }
            if (r8 == 0) goto L_0x0064
            j$.util.concurrent.r r9 = r8.f5174f     // Catch:{ all -> 0x0052 }
            if (r5 != r9) goto L_0x0062
            r8.f5174f = r11     // Catch:{ all -> 0x0052 }
            goto L_0x0064
        L_0x0062:
            r8.f5175g = r11     // Catch:{ all -> 0x0052 }
        L_0x0064:
            r5.f5175g = r4     // Catch:{ all -> 0x0052 }
            r4.f5173e = r5     // Catch:{ all -> 0x0052 }
        L_0x0068:
            r11.f5174f = r2     // Catch:{ all -> 0x0052 }
            r11.f5175g = r6     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0070
            r6.f5173e = r11     // Catch:{ all -> 0x0052 }
        L_0x0070:
            r5.f5174f = r3     // Catch:{ all -> 0x0052 }
            r3.f5173e = r5     // Catch:{ all -> 0x0052 }
            r5.f5173e = r7     // Catch:{ all -> 0x0052 }
            if (r7 != 0) goto L_0x007a
            r0 = r5
            goto L_0x0083
        L_0x007a:
            j$.util.concurrent.r r3 = r7.f5174f     // Catch:{ all -> 0x0052 }
            if (r11 != r3) goto L_0x0081
            r7.f5174f = r5     // Catch:{ all -> 0x0052 }
            goto L_0x0083
        L_0x0081:
            r7.f5175g = r5     // Catch:{ all -> 0x0052 }
        L_0x0083:
            if (r6 == 0) goto L_0x008e
            r3 = r6
            goto L_0x008f
        L_0x0087:
            if (r3 == 0) goto L_0x008a
            goto L_0x008f
        L_0x008a:
            if (r4 == 0) goto L_0x008e
            r3 = r4
            goto L_0x008f
        L_0x008e:
            r3 = r11
        L_0x008f:
            if (r3 == r11) goto L_0x00a8
            j$.util.concurrent.r r4 = r11.f5173e     // Catch:{ all -> 0x0052 }
            r3.f5173e = r4     // Catch:{ all -> 0x0052 }
            if (r4 != 0) goto L_0x0099
            r0 = r3
            goto L_0x00a2
        L_0x0099:
            j$.util.concurrent.r r5 = r4.f5174f     // Catch:{ all -> 0x0052 }
            if (r11 != r5) goto L_0x00a0
            r4.f5174f = r3     // Catch:{ all -> 0x0052 }
            goto L_0x00a2
        L_0x00a0:
            r4.f5175g = r3     // Catch:{ all -> 0x0052 }
        L_0x00a2:
            r11.f5173e = r2     // Catch:{ all -> 0x0052 }
            r11.f5175g = r2     // Catch:{ all -> 0x0052 }
            r11.f5174f = r2     // Catch:{ all -> 0x0052 }
        L_0x00a8:
            boolean r4 = r11.f5177i     // Catch:{ all -> 0x0052 }
            if (r4 == 0) goto L_0x00ad
            goto L_0x00b1
        L_0x00ad:
            j$.util.concurrent.r r0 = b(r0, r3)     // Catch:{ all -> 0x0052 }
        L_0x00b1:
            r10.f5170e = r0     // Catch:{ all -> 0x0052 }
            if (r11 != r3) goto L_0x00c8
            j$.util.concurrent.r r0 = r11.f5173e     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x00c8
            j$.util.concurrent.r r3 = r0.f5174f     // Catch:{ all -> 0x0052 }
            if (r11 != r3) goto L_0x00c0
            r0.f5174f = r2     // Catch:{ all -> 0x0052 }
            goto L_0x00c6
        L_0x00c0:
            j$.util.concurrent.r r3 = r0.f5175g     // Catch:{ all -> 0x0052 }
            if (r11 != r3) goto L_0x00c6
            r0.f5175g = r2     // Catch:{ all -> 0x0052 }
        L_0x00c6:
            r11.f5173e = r2     // Catch:{ all -> 0x0052 }
        L_0x00c8:
            r10.lockState = r1
            return r1
        L_0x00cb:
            r10.lockState = r1
            throw r11
        L_0x00ce:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.q.f(j$.util.concurrent.r):boolean");
    }

    public static r g(r rVar, r rVar2) {
        r rVar3;
        if (!(rVar2 == null || (rVar3 = rVar2.f5175g) == null)) {
            r rVar4 = rVar3.f5174f;
            rVar2.f5175g = rVar4;
            if (rVar4 != null) {
                rVar4.f5173e = rVar2;
            }
            r rVar5 = rVar2.f5173e;
            rVar3.f5173e = rVar5;
            if (rVar5 == null) {
                rVar3.f5177i = false;
                rVar = rVar3;
            } else if (rVar5.f5174f == rVar2) {
                rVar5.f5174f = rVar3;
            } else {
                rVar5.f5175g = rVar3;
            }
            rVar3.f5174f = rVar2;
            rVar2.f5173e = rVar3;
        }
        return rVar;
    }

    public static r h(r rVar, r rVar2) {
        r rVar3;
        if (!(rVar2 == null || (rVar3 = rVar2.f5174f) == null)) {
            r rVar4 = rVar3.f5175g;
            rVar2.f5174f = rVar4;
            if (rVar4 != null) {
                rVar4.f5173e = rVar2;
            }
            r rVar5 = rVar2.f5173e;
            rVar3.f5173e = rVar5;
            if (rVar5 == null) {
                rVar3.f5177i = false;
                rVar = rVar3;
            } else if (rVar5.f5175g == rVar2) {
                rVar5.f5175g = rVar3;
            } else {
                rVar5.f5174f = rVar3;
            }
            rVar3.f5175g = rVar2;
            rVar2.f5173e = rVar3;
        }
        return rVar;
    }

    public static r c(r rVar, r rVar2) {
        r rVar3;
        rVar2.f5177i = true;
        while (true) {
            r rVar4 = rVar2.f5173e;
            if (rVar4 == null) {
                rVar2.f5177i = false;
                return rVar2;
            } else if (!rVar4.f5177i || (rVar3 = rVar4.f5173e) == null) {
                return rVar;
            } else {
                r rVar5 = rVar3.f5174f;
                if (rVar4 == rVar5) {
                    r rVar6 = rVar3.f5175g;
                    if (rVar6 == null || !rVar6.f5177i) {
                        if (rVar2 == rVar4.f5175g) {
                            rVar = g(rVar, rVar4);
                            r rVar7 = rVar4.f5173e;
                            rVar3 = rVar7 == null ? null : rVar7.f5173e;
                            r rVar8 = rVar4;
                            rVar4 = rVar7;
                            rVar2 = rVar8;
                        }
                        if (rVar4 != null) {
                            rVar4.f5177i = false;
                            if (rVar3 != null) {
                                rVar3.f5177i = true;
                                rVar = h(rVar, rVar3);
                            }
                        }
                    } else {
                        rVar6.f5177i = false;
                        rVar4.f5177i = false;
                        rVar3.f5177i = true;
                    }
                } else if (rVar5 == null || !rVar5.f5177i) {
                    if (rVar2 == rVar4.f5174f) {
                        rVar = h(rVar, rVar4);
                        r rVar9 = rVar4.f5173e;
                        rVar3 = rVar9 == null ? null : rVar9.f5173e;
                        r rVar10 = rVar4;
                        rVar4 = rVar9;
                        rVar2 = rVar10;
                    }
                    if (rVar4 != null) {
                        rVar4.f5177i = false;
                        if (rVar3 != null) {
                            rVar3.f5177i = true;
                            rVar = g(rVar, rVar3);
                        }
                    }
                } else {
                    rVar5.f5177i = false;
                    rVar4.f5177i = false;
                    rVar3.f5177i = true;
                }
                rVar2 = rVar3;
            }
        }
        return rVar;
    }

    public static r b(r rVar, r rVar2) {
        boolean z4;
        boolean z5;
        while (rVar2 != null && rVar2 != rVar) {
            r rVar3 = rVar2.f5173e;
            if (rVar3 == null) {
                rVar2.f5177i = false;
                return rVar2;
            } else if (rVar2.f5177i) {
                rVar2.f5177i = false;
                return rVar;
            } else {
                r rVar4 = rVar3.f5174f;
                r rVar5 = null;
                if (rVar4 == rVar2) {
                    r rVar6 = rVar3.f5175g;
                    if (rVar6 != null && rVar6.f5177i) {
                        rVar6.f5177i = false;
                        rVar3.f5177i = true;
                        rVar = g(rVar, rVar3);
                        rVar3 = rVar2.f5173e;
                        rVar6 = rVar3 == null ? null : rVar3.f5175g;
                    }
                    if (rVar6 != null) {
                        r rVar7 = rVar6.f5174f;
                        r rVar8 = rVar6.f5175g;
                        if ((rVar8 == null || !rVar8.f5177i) && (rVar7 == null || !rVar7.f5177i)) {
                            rVar6.f5177i = true;
                        } else {
                            if (rVar8 == null || !rVar8.f5177i) {
                                if (rVar7 != null) {
                                    rVar7.f5177i = false;
                                }
                                rVar6.f5177i = true;
                                rVar = h(rVar, rVar6);
                                rVar3 = rVar2.f5173e;
                                if (rVar3 != null) {
                                    rVar5 = rVar3.f5175g;
                                }
                                rVar6 = rVar5;
                            }
                            if (rVar6 != null) {
                                if (rVar3 == null) {
                                    z5 = false;
                                } else {
                                    z5 = rVar3.f5177i;
                                }
                                rVar6.f5177i = z5;
                                r rVar9 = rVar6.f5175g;
                                if (rVar9 != null) {
                                    rVar9.f5177i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.f5177i = false;
                                rVar = g(rVar, rVar3);
                            }
                            rVar2 = rVar;
                        }
                    }
                } else {
                    if (rVar4 != null && rVar4.f5177i) {
                        rVar4.f5177i = false;
                        rVar3.f5177i = true;
                        rVar = h(rVar, rVar3);
                        rVar3 = rVar2.f5173e;
                        rVar4 = rVar3 == null ? null : rVar3.f5174f;
                    }
                    if (rVar4 != null) {
                        r rVar10 = rVar4.f5174f;
                        r rVar11 = rVar4.f5175g;
                        if ((rVar10 == null || !rVar10.f5177i) && (rVar11 == null || !rVar11.f5177i)) {
                            rVar4.f5177i = true;
                        } else {
                            if (rVar10 == null || !rVar10.f5177i) {
                                if (rVar11 != null) {
                                    rVar11.f5177i = false;
                                }
                                rVar4.f5177i = true;
                                rVar = g(rVar, rVar4);
                                rVar3 = rVar2.f5173e;
                                if (rVar3 != null) {
                                    rVar5 = rVar3.f5174f;
                                }
                                rVar4 = rVar5;
                            }
                            if (rVar4 != null) {
                                if (rVar3 == null) {
                                    z4 = false;
                                } else {
                                    z4 = rVar3.f5177i;
                                }
                                rVar4.f5177i = z4;
                                r rVar12 = rVar4.f5174f;
                                if (rVar12 != null) {
                                    rVar12.f5177i = false;
                                }
                            }
                            if (rVar3 != null) {
                                rVar3.f5177i = false;
                                rVar = h(rVar, rVar3);
                            }
                            rVar2 = rVar;
                        }
                    }
                }
                rVar2 = rVar3;
            }
        }
        return rVar;
    }
}
