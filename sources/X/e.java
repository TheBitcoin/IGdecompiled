package x;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JobInfoSchedulerService f4621a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JobParameters f4622b;

    public /* synthetic */ e(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f4621a = jobInfoSchedulerService;
        this.f4622b = jobParameters;
    }

    public final void run() {
        this.f4621a.jobFinished(this.f4622b, false);
    }
}
