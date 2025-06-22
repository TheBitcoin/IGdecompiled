package com.mbridge.msdk.newreward.function.command.retention;

import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;
import java.lang.reflect.Method;

public class ReportProcess {
    static e adapterModel;

    public static void init(e eVar) {
        adapterModel = eVar;
    }

    public static void reportProcessAtThisTime(Object obj) {
        Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (i4 < length) {
            Method method = declaredMethods[i4];
            Class cls = ReportAnnotation.MethodInfo.class;
            if (method.isAnnotationPresent(cls)) {
                ReportAnnotation.MethodInfo methodInfo = (ReportAnnotation.MethodInfo) method.getAnnotation(cls);
                i4++;
            } else {
                return;
            }
        }
    }
}
