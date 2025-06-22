package com.google.android.gms.internal.measurement;

final class N5 extends IllegalArgumentException {
    N5(int i4, int i5) {
        super("Unpaired surrogate at index " + i4 + " of " + i5);
    }
}
