package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import B.a;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import q.p;
import q.u;
import x.e;

@RequiresApi(api = 21)
public class JobInfoSchedulerService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i4 = jobParameters.getExtras().getInt("priority");
        int i5 = jobParameters.getExtras().getInt("attemptNumber");
        u.f(getApplicationContext());
        p.a d5 = p.a().b(string).d(a.b(i4));
        if (string2 != null) {
            d5.c(Base64.decode(string2, 0));
        }
        u.c().e().m(d5.a(), i5, new e(this, jobParameters));
        return true;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
