package x;

import B.a;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.zip.Adler32;
import q.p;
import u.C1068a;
import y.C1094d;

/* renamed from: x.d  reason: case insensitive filesystem */
public class C1084d implements x {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4618a;

    /* renamed from: b  reason: collision with root package name */
    private final C1094d f4619b;

    /* renamed from: c  reason: collision with root package name */
    private final f f4620c;

    public C1084d(Context context, C1094d dVar, f fVar) {
        this.f4618a = context;
        this.f4619b = dVar;
        this.f4620c = fVar;
    }

    private boolean d(JobScheduler jobScheduler, int i4, int i5) {
        Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            JobInfo next = it.next();
            int i6 = next.getExtras().getInt("attemptNumber");
            if (next.getId() == i4) {
                if (i6 >= i5) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a(p pVar, int i4, boolean z4) {
        ComponentName componentName = new ComponentName(this.f4618a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f4618a.getSystemService("jobscheduler");
        int c5 = c(pVar);
        if (z4 || !d(jobScheduler, c5, i4)) {
            long f4 = this.f4619b.f(pVar);
            int i5 = i4;
            JobInfo.Builder c6 = this.f4620c.c(new JobInfo.Builder(c5, componentName), pVar.d(), f4, i5);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i5);
            persistableBundle.putString("backendName", pVar.b());
            persistableBundle.putInt("priority", a.a(pVar.d()));
            if (pVar.c() != null) {
                persistableBundle.putString("extras", Base64.encodeToString(pVar.c(), 0));
            }
            c6.setExtras(persistableBundle);
            C1068a.c("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", pVar, Integer.valueOf(c5), Long.valueOf(this.f4620c.g(pVar.d(), f4, i5)), Long.valueOf(f4), Integer.valueOf(i5));
            jobScheduler.schedule(c6.build());
            return;
        }
        C1068a.b("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", pVar);
    }

    public void b(p pVar, int i4) {
        a(pVar, i4, false);
    }

    /* access modifiers changed from: package-private */
    public int c(p pVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f4618a.getPackageName().getBytes(Charset.forName(C.UTF8_NAME)));
        adler32.update(pVar.b().getBytes(Charset.forName(C.UTF8_NAME)));
        adler32.update(ByteBuffer.allocate(4).putInt(a.a(pVar.d())).array());
        if (pVar.c() != null) {
            adler32.update(pVar.c());
        }
        return (int) adler32.getValue();
    }
}
