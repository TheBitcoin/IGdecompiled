package b1;

import M0.f;

public enum u implements f {
    LOG_ENVIRONMENT_UNKNOWN(0),
    LOG_ENVIRONMENT_AUTOPUSH(1),
    LOG_ENVIRONMENT_STAGING(2),
    LOG_ENVIRONMENT_PROD(3);
    

    /* renamed from: a  reason: collision with root package name */
    private final int f9055a;

    private u(int i4) {
        this.f9055a = i4;
    }

    public int getNumber() {
        return this.f9055a;
    }
}
