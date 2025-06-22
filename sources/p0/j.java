package P0;

public interface j {

    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f7985a;

        private a(int i4) {
            this.f7985a = i4;
        }

        public int b() {
            return this.f7985a;
        }
    }

    a b(String str);
}
