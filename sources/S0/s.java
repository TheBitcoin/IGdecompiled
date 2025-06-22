package s0;

import java.util.Arrays;
import java.util.List;

public class s extends t {

    /* renamed from: a  reason: collision with root package name */
    private final List f21749a;

    public s(List list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f21749a = list;
    }
}
