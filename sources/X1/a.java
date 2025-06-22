package X1;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f8809a = false;

    /* renamed from: b  reason: collision with root package name */
    public static int f8810b = 20000;

    /* renamed from: X1.a$a  reason: collision with other inner class name */
    class C0126a extends Z1.a {

        /* renamed from: p  reason: collision with root package name */
        final /* synthetic */ Set f8811p;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0126a(int i4, boolean z4, String[] strArr, Set set) {
            super(i4, z4, strArr);
            this.f8811p = set;
        }

        public void c(int i4, String str) {
            if (i4 == 158) {
                this.f8811p.addAll(Arrays.asList(str.split(" ")));
            }
            super.c(i4, str);
        }
    }

    public enum b {
        VERBOSE,
        ERROR,
        DEBUG,
        WARN
    }

    private static void a(Z1.b bVar, Z1.a aVar) {
        while (!aVar.i()) {
            e("RootShell v1.4", bVar.G(aVar));
            e("RootShell v1.4", "Processed " + aVar.f8838d + " of " + aVar.f8837c + " output from command.");
            synchronized (aVar) {
                try {
                    if (!aVar.i()) {
                        aVar.wait(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                    }
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                }
            }
            if (!aVar.h() && !aVar.i()) {
                boolean z4 = bVar.f8869l;
                if (!z4 && !bVar.f8870m) {
                    e("RootShell v1.4", "Waiting for a command to be executed in a shell that is not executing and not reading! \n\n Command: " + aVar.g());
                    Exception exc = new Exception();
                    exc.setStackTrace(Thread.currentThread().getStackTrace());
                    exc.printStackTrace();
                } else if (!z4 || bVar.f8870m) {
                    e("RootShell v1.4", "Waiting for a command to be executed in a shell that is not reading! \n\n Command: " + aVar.g());
                    Exception exc2 = new Exception();
                    exc2.setStackTrace(Thread.currentThread().getStackTrace());
                    exc2.printStackTrace();
                } else {
                    e("RootShell v1.4", "Waiting for a command to be executed in a shell that is executing but not reading! \n\n Command: " + aVar.g());
                    Exception exc3 = new Exception();
                    exc3.setStackTrace(Thread.currentThread().getStackTrace());
                    exc3.printStackTrace();
                }
            }
        }
    }

    public static boolean b() {
        HashSet<String> hashSet = new HashSet<>();
        try {
            c("Checking for Root access");
            C0126a aVar = new C0126a(158, false, new String[]{"id"}, hashSet);
            Z1.b.L().w(aVar);
            a(Z1.b.L(), aVar);
            for (String str : hashSet) {
                c(str);
                if (str.toLowerCase().contains("uid=0")) {
                    c("Access Given");
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void c(String str) {
        f((String) null, str, b.DEBUG, (Exception) null);
    }

    public static void d(String str, b bVar, Exception exc) {
        f((String) null, str, bVar, exc);
    }

    public static void e(String str, String str2) {
        f(str, str2, b.DEBUG, (Exception) null);
    }

    public static void f(String str, String str2, b bVar, Exception exc) {
        if (str2 != null && !str2.equals("") && f8809a) {
            if (str == null) {
                str = "RootShell v1.4";
            }
            int ordinal = bVar.ordinal();
            if (ordinal == 0) {
                Log.v(str, str2);
            } else if (ordinal == 1) {
                Log.e(str, str2, exc);
            } else if (ordinal == 2) {
                Log.d(str, str2);
            } else if (ordinal == 3) {
                Log.w(str, str2);
            }
        }
    }
}
