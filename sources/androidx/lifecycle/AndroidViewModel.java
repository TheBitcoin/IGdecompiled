package androidx.lifecycle;

import android.app.Application;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import kotlin.jvm.internal.m;

public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application application2) {
        m.e(application2, MimeTypes.BASE_TYPE_APPLICATION);
        this.application = application2;
    }

    public <T extends Application> T getApplication() {
        T t4 = this.application;
        m.c(t4, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t4;
    }
}
