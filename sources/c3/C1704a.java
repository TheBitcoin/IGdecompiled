package c3;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import k3.c;
import kotlin.jvm.internal.C2100d;
import kotlin.jvm.internal.D;
import kotlin.jvm.internal.m;

/* renamed from: c3.a  reason: case insensitive filesystem */
public abstract class C1704a {
    public static final Class a(c cVar) {
        m.e(cVar, "<this>");
        Class d5 = ((C2100d) cVar).d();
        m.c(d5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return d5;
    }

    public static final Class b(c cVar) {
        m.e(cVar, "<this>");
        Class d5 = ((C2100d) cVar).d();
        if (!d5.isPrimitive()) {
            m.c(d5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return d5;
        }
        String name = d5.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    d5 = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    d5 = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    d5 = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    d5 = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    d5 = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    d5 = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals(TypedValues.Custom.S_BOOLEAN)) {
                    d5 = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals(TypedValues.Custom.S_FLOAT)) {
                    d5 = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    d5 = Short.class;
                    break;
                }
                break;
        }
        m.c(d5, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return d5;
    }

    public static final c c(Class cls) {
        m.e(cls, "<this>");
        return D.b(cls);
    }
}
