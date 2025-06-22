package v0;

import B0.F;
import S2.C1601o;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final j f21978a = new j();

    private j() {
    }

    public static /* synthetic */ F.e.d.a.c c(j jVar, String str, int i4, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        if ((i6 & 8) != 0) {
            z4 = false;
        }
        return jVar.b(str, i4, i5, z4);
    }

    private final String f() {
        String a5;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            String a6 = Process.myProcessName();
            m.d(a6, "{\n      Process.myProcessName()\n    }");
            return a6;
        } else if (i4 < 28 || (a5 = Application.getProcessName()) == null) {
            return "";
        } else {
            return a5;
        }
    }

    public final F.e.d.a.c a(String str, int i4, int i5) {
        m.e(str, "processName");
        return c(this, str, i4, i5, false, 8, (Object) null);
    }

    public final F.e.d.a.c b(String str, int i4, int i5, boolean z4) {
        m.e(str, "processName");
        F.e.d.a.c a5 = F.e.d.a.c.a().e(str).d(i4).c(i5).b(z4).a();
        m.d(a5, "builder()\n      .setProc…ltProcess)\n      .build()");
        return a5;
    }

    public final List d(Context context) {
        ActivityManager activityManager;
        m.e(context, "context");
        int i4 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> list = null;
        if (systemService instanceof ActivityManager) {
            activityManager = (ActivityManager) systemService;
        } else {
            activityManager = null;
        }
        if (activityManager != null) {
            list = activityManager.getRunningAppProcesses();
        }
        if (list == null) {
            list = C1601o.h();
        }
        ArrayList arrayList = new ArrayList();
        for (Object next : C1601o.E(list)) {
            if (((ActivityManager.RunningAppProcessInfo) next).uid == i4) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(C1601o.p(arrayList, 10));
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj;
            arrayList2.add(F.e.d.a.c.a().e(runningAppProcessInfo.processName).d(runningAppProcessInfo.pid).c(runningAppProcessInfo.importance).b(m.a(runningAppProcessInfo.processName, str)).a());
        }
        return arrayList2;
    }

    public final F.e.d.a.c e(Context context) {
        Object obj;
        m.e(context, "context");
        int myPid = Process.myPid();
        Iterator it = d(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((F.e.d.a.c) obj).c() == myPid) {
                break;
            }
        }
        F.e.d.a.c cVar = (F.e.d.a.c) obj;
        if (cVar != null) {
            return cVar;
        }
        return c(this, f(), myPid, 0, false, 12, (Object) null);
    }
}
