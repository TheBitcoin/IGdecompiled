package b1;

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

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final w f9060a = new w();

    private w() {
    }

    private final v a(String str, int i4, int i5, boolean z4) {
        return new v(str, i4, i5, z4);
    }

    static /* synthetic */ v b(w wVar, String str, int i4, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        if ((i6 & 8) != 0) {
            z4 = false;
        }
        return wVar.a(str, i4, i5, z4);
    }

    public final List c(Context context) {
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
            String str2 = runningAppProcessInfo.processName;
            m.d(str2, "runningAppProcessInfo.processName");
            arrayList2.add(new v(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, m.a(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final v d(Context context) {
        Object obj;
        m.e(context, "context");
        int myPid = Process.myPid();
        Iterator it = c(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((v) obj).b() == myPid) {
                break;
            }
        }
        v vVar = (v) obj;
        if (vVar != null) {
            return vVar;
        }
        return b(this, e(), myPid, 0, false, 12, (Object) null);
    }

    public final String e() {
        String a5;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 33) {
            String a6 = Process.myProcessName();
            m.d(a6, "myProcessName()");
            return a6;
        } else if (i4 >= 28 && (a5 = Application.getProcessName()) != null) {
            return a5;
        } else {
            String a7 = R.m.a();
            if (a7 != null) {
                return a7;
            }
            return "";
        }
    }
}
