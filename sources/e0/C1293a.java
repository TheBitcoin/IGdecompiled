package E0;

import java.io.File;
import java.util.Comparator;

/* renamed from: E0.a  reason: case insensitive filesystem */
public final /* synthetic */ class C1293a implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
