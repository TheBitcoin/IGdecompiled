package com.google.gson;

public class j extends RuntimeException {
    public j(String str) {
        super(str);
    }

    public j(String str, Throwable th) {
        super(str, th);
    }

    public j(Throwable th) {
        super(th);
    }
}
