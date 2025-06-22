package S3;

/* renamed from: S3.e  reason: case insensitive filesystem */
public class C2572e {
    public String a() {
        return c("http.agent");
    }

    public String b() {
        return c("java.vm.version");
    }

    public String c(String str) {
        return System.getProperty(str);
    }
}
