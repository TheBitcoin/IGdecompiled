package b3;

import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.m;
import l3.e;

final class h implements e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final BufferedReader f9650a;

    public static final class a implements Iterator, e3.a {

        /* renamed from: a  reason: collision with root package name */
        private String f9651a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f9652b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f9653c;

        a(h hVar) {
            this.f9653c = hVar;
        }

        /* renamed from: a */
        public String next() {
            if (hasNext()) {
                String str = this.f9651a;
                this.f9651a = null;
                m.b(str);
                return str;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f9651a == null && !this.f9652b) {
                String readLine = this.f9653c.f9650a.readLine();
                this.f9651a = readLine;
                if (readLine == null) {
                    this.f9652b = true;
                }
            }
            if (this.f9651a != null) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public h(BufferedReader bufferedReader) {
        m.e(bufferedReader, "reader");
        this.f9650a = bufferedReader;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
