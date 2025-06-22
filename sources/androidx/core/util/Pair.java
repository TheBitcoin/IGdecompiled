package androidx.core.util;

import androidx.annotation.NonNull;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f4, S s4) {
        this.first = f4;
        this.second = s4;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a5, B b5) {
        return new Pair<>(a5, b5);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!ObjectsCompat.equals(pair.first, this.first) || !ObjectsCompat.equals(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i4;
        F f4 = this.first;
        int i5 = 0;
        if (f4 == null) {
            i4 = 0;
        } else {
            i4 = f4.hashCode();
        }
        S s4 = this.second;
        if (s4 != null) {
            i5 = s4.hashCode();
        }
        return i4 ^ i5;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
