package androidx.room;

import androidx.annotation.RequiresApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@RequiresApi(16)
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface Upsert {
    Class<?> entity() default Object.class;
}
