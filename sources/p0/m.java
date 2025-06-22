package p0;

import M.C0335p;

public abstract class m extends Exception {
    protected m() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(String str) {
        super(str);
        C0335p.g(str, "Detail message must not be empty");
    }
}
