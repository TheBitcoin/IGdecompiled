package N3;

import java.io.Closeable;
import java.io.Flushable;

public interface X extends Closeable, Flushable {
    void close();

    void flush();

    void m(C2514e eVar, long j4);

    a0 timeout();
}
