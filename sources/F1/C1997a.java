package f1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* renamed from: f1.a  reason: case insensitive filesystem */
public @interface C1997a {
    boolean deserialize() default true;

    boolean serialize() default true;
}
