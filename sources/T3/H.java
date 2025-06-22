package t3;

abstract /* synthetic */ class H {

    /* renamed from: a  reason: collision with root package name */
    private static final int f4468a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f4468a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
