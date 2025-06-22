package y0;

import java.io.File;
import java.util.Comparator;

/* renamed from: y0.l  reason: case insensitive filesystem */
public final /* synthetic */ class C2422l implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Long.compare(((File) obj2).lastModified(), ((File) obj).lastModified());
    }
}
