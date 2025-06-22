package com.google.android.gms.internal.measurement;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.measurement.k  reason: case insensitive filesystem */
public final class C0596k implements C0663s {

    /* renamed from: a  reason: collision with root package name */
    private final Double f1964a;

    public C0596k(Double d5) {
        if (d5 == null) {
            this.f1964a = Double.valueOf(Double.NaN);
        } else {
            this.f1964a = d5;
        }
    }

    public final Boolean C() {
        boolean z4;
        if (Double.isNaN(this.f1964a.doubleValue()) || this.f1964a.doubleValue() == 0.0d) {
            z4 = false;
        } else {
            z4 = true;
        }
        return Boolean.valueOf(z4);
    }

    public final Double D() {
        return this.f1964a;
    }

    public final String E() {
        BigDecimal bigDecimal;
        int scale;
        if (Double.isNaN(this.f1964a.doubleValue())) {
            return "NaN";
        }
        if (!Double.isInfinite(this.f1964a.doubleValue())) {
            BigDecimal valueOf = BigDecimal.valueOf(this.f1964a.doubleValue());
            if (valueOf.signum() == 0) {
                bigDecimal = new BigDecimal(BigInteger.ZERO, 0);
            } else {
                bigDecimal = C0587j.a(valueOf);
            }
            DecimalFormat decimalFormat = new DecimalFormat("0E0");
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            if (bigDecimal.scale() > 0) {
                scale = bigDecimal.precision();
            } else {
                scale = bigDecimal.scale();
            }
            decimalFormat.setMinimumFractionDigits(scale - 1);
            String format = decimalFormat.format(bigDecimal);
            int indexOf = format.indexOf(ExifInterface.LONGITUDE_EAST);
            if (indexOf <= 0) {
                return format;
            }
            int parseInt = Integer.parseInt(format.substring(indexOf + 1));
            if ((parseInt >= 0 || parseInt <= -7) && (parseInt < 0 || parseInt >= 21)) {
                return format.replace("E-", "e-").replace(ExifInterface.LONGITUDE_EAST, "e+");
            }
            return bigDecimal.toPlainString();
        } else if (this.f1964a.doubleValue() > 0.0d) {
            return "Infinity";
        } else {
            return "-Infinity";
        }
    }

    public final Iterator F() {
        return null;
    }

    public final C0663s G(String str, Z2 z22, List list) {
        if ("toString".equals(str)) {
            return new C0679u(E());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", new Object[]{E(), str}));
    }

    public final C0663s b() {
        return new C0596k(this.f1964a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0596k)) {
            return false;
        }
        return this.f1964a.equals(((C0596k) obj).f1964a);
    }

    public final int hashCode() {
        return this.f1964a.hashCode();
    }

    public final String toString() {
        return E();
    }
}
