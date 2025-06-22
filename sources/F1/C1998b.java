package f1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* renamed from: f1.b  reason: case insensitive filesystem */
public @interface C1998b {
    boolean nullSafe() default true;

    Class value();
}
