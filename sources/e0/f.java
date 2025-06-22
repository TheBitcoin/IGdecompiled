package E0;

import java.io.File;
import java.io.FilenameFilter;

public final /* synthetic */ class f implements FilenameFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f6304a;

    public /* synthetic */ f(String str) {
        this.f6304a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(this.f6304a);
    }
}
