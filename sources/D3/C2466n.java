package D3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: D3.n  reason: case insensitive filesystem */
public interface C2466n {

    /* renamed from: a  reason: collision with root package name */
    public static final C2466n f23099a = new a();

    /* renamed from: D3.n$a */
    class a implements C2466n {
        a() {
        }

        public List lookup(String str) {
            if (str != null) {
                try {
                    return Arrays.asList(InetAddress.getAllByName(str));
                } catch (NullPointerException e5) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                    unknownHostException.initCause(e5);
                    throw unknownHostException;
                }
            } else {
                throw new UnknownHostException("hostname == null");
            }
        }
    }

    List lookup(String str);
}
