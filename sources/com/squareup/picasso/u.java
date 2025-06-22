package com.squareup.picasso;

import android.net.NetworkInfo;
import com.squareup.picasso.C;
import com.squareup.picasso.s;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class u extends ThreadPoolExecutor {

    private static final class a extends FutureTask implements Comparable {

        /* renamed from: a  reason: collision with root package name */
        private final C1816c f17348a;

        a(C1816c cVar) {
            super(cVar, (Object) null);
            this.f17348a = cVar;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            s.f r4 = this.f17348a.r();
            s.f r5 = aVar.f17348a.r();
            if (r4 == r5) {
                return this.f17348a.f17213a - aVar.f17348a.f17213a;
            }
            return r5.ordinal() - r4.ordinal();
        }
    }

    u() {
        super(3, 3, 0, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new C.c());
    }

    private void b(int i4) {
        setCorePoolSize(i4);
        setMaximumPoolSize(i4);
    }

    /* access modifiers changed from: package-private */
    public void a(NetworkInfo networkInfo) {
        if (networkInfo == null || !networkInfo.isConnectedOrConnecting()) {
            b(3);
            return;
        }
        int type = networkInfo.getType();
        if (type == 0) {
            int subtype = networkInfo.getSubtype();
            switch (subtype) {
                case 1:
                case 2:
                    b(1);
                    return;
                case 3:
                case 4:
                case 5:
                case 6:
                    break;
                default:
                    switch (subtype) {
                        case 12:
                            break;
                        case 13:
                        case 14:
                        case 15:
                            b(3);
                            return;
                        default:
                            b(3);
                            return;
                    }
            }
            b(2);
        } else if (type == 1 || type == 6 || type == 9) {
            b(4);
        } else {
            b(3);
        }
    }

    public Future submit(Runnable runnable) {
        a aVar = new a((C1816c) runnable);
        execute(aVar);
        return aVar;
    }
}
