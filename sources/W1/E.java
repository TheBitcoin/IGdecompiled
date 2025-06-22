package W1;

import T1.h;
import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.internal.m;

public final class E {
    public final ArrayList a(String str) {
        File[] listFiles;
        boolean z4;
        m.e(str, "packagename");
        ArrayList arrayList = new ArrayList();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/Obb/" + str);
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            if (listFiles.length == 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        String name = file2.getName();
                        m.d(name, "fileObb.name");
                        if (m3.m.o(name, ".obb", false, 2, (Object) null)) {
                            arrayList.add(file2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:21|22|23|24|25|26|27|28|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005c, code lost:
        r10 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x00ba */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x00d6 */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ExcHandler: IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:1:0x001d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList b(android.content.Context r15) {
        /*
            r14 = this;
            r0 = 0
            r1 = 1
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
            java.lang.Class<android.os.storage.StorageManager> r3 = android.os.storage.StorageManager.class
            java.lang.String r4 = "context"
            kotlin.jvm.internal.m.e(r15, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.String r5 = "storage"
            java.lang.Object r15 = r15.getSystemService(r5)
            java.lang.String r5 = "null cannot be cast to non-null type android.os.storage.StorageManager"
            kotlin.jvm.internal.m.c(r15, r5)
            android.os.storage.StorageManager r15 = (android.os.storage.StorageManager) r15
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.String r6 = "getVolumeList"
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r0)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.Class[] r5 = (java.lang.Class[]) r5     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.reflect.Method r5 = r3.getMethod(r6, r5)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            r5.setAccessible(r1)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r6, r0)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.Object r5 = r5.invoke(r15, r6)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.Array<*>"
            kotlin.jvm.internal.m.c(r5, r6)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.Object[] r5 = (java.lang.Object[]) r5     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            int r6 = r5.length     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            r7 = 0
        L_0x0041:
            if (r7 >= r6) goto L_0x00dc
            r8 = r5[r7]     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            if (r8 == 0) goto L_0x00d9
            r9 = 0
            java.lang.Class r10 = r8.getClass()     // Catch:{ NoSuchMethodException -> 0x005c, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.String r11 = "getPath"
            java.lang.reflect.Method r10 = r10.getMethod(r11, r9)     // Catch:{ NoSuchMethodException -> 0x005c, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.Object r10 = r10.invoke(r8, r9)     // Catch:{ NoSuchMethodException -> 0x005c, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            kotlin.jvm.internal.m.c(r10, r2)     // Catch:{ NoSuchMethodException -> 0x005c, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NoSuchMethodException -> 0x005c, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            goto L_0x005e
        L_0x005c:
            r10 = r9
        L_0x005e:
            if (r10 != 0) goto L_0x007b
            java.lang.Class r11 = r8.getClass()     // Catch:{ NoSuchMethodException -> 0x007a, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.String r12 = "getDirectory"
            java.lang.reflect.Method r11 = r11.getMethod(r12, r9)     // Catch:{ NoSuchMethodException -> 0x007a, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.Object r11 = r11.invoke(r8, r9)     // Catch:{ NoSuchMethodException -> 0x007a, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.String r12 = "null cannot be cast to non-null type java.io.File"
            kotlin.jvm.internal.m.c(r11, r12)     // Catch:{ NoSuchMethodException -> 0x007a, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.io.File r11 = (java.io.File) r11     // Catch:{ NoSuchMethodException -> 0x007a, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.String r10 = r11.getAbsolutePath()     // Catch:{ NoSuchMethodException -> 0x007a, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc, IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            goto L_0x007b
        L_0x007a:
        L_0x007b:
            if (r10 == 0) goto L_0x00d9
            T1.h r11 = new T1.h     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            r11.<init>(r10)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.io.File r12 = new java.io.File     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            r12.<init>(r10)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            boolean r10 = r12.exists()     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            if (r10 == 0) goto L_0x00d9
            boolean r10 = r12.isDirectory()     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            if (r10 == 0) goto L_0x00d9
            long r12 = r12.getUsableSpace()     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            r11.e(r12)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
            java.lang.String r10 = "getVolumeState"
            java.lang.Class[] r12 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x00ba }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r12[r0] = r13     // Catch:{ Exception -> 0x00ba }
            java.lang.reflect.Method r10 = r3.getMethod(r10, r12)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r12 = r11.b()     // Catch:{ Exception -> 0x00ba }
            java.lang.Object[] r13 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x00ba }
            r13[r0] = r12     // Catch:{ Exception -> 0x00ba }
            java.lang.Object r10 = r10.invoke(r15, r13)     // Catch:{ Exception -> 0x00ba }
            kotlin.jvm.internal.m.c(r10, r2)     // Catch:{ Exception -> 0x00ba }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x00ba }
            r11.g(r10)     // Catch:{ Exception -> 0x00ba }
        L_0x00ba:
            java.lang.Class r10 = r8.getClass()     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r12 = "isRemovable"
            java.lang.reflect.Method r10 = r10.getMethod(r12, r9)     // Catch:{ Exception -> 0x00d6 }
            java.lang.Object r8 = r10.invoke(r8, r9)     // Catch:{ Exception -> 0x00d6 }
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.Boolean"
            kotlin.jvm.internal.m.c(r8, r9)     // Catch:{ Exception -> 0x00d6 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ Exception -> 0x00d6 }
            boolean r8 = r8.booleanValue()     // Catch:{ Exception -> 0x00d6 }
            r11.f(r8)     // Catch:{ Exception -> 0x00d6 }
        L_0x00d6:
            r4.add(r11)     // Catch:{ IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException -> 0x00dc }
        L_0x00d9:
            int r7 = r7 + r1
            goto L_0x0041
        L_0x00dc:
            r4.trimToSize()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.E.b(android.content.Context):java.util.ArrayList");
    }

    public final ArrayList c(Context context) {
        m.e(context, "context");
        ArrayList arrayList = new ArrayList();
        try {
            ArrayList b5 = b(context);
            int size = b5.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!m3.m.D(((h) b5.get(i4)).b(), "/emulated/", false, 2, (Object) null) && ((h) b5.get(i4)).d() && ((h) b5.get(i4)).c()) {
                    File file = new File(((h) b5.get(i4)).b() + ("/Android/data/" + context.getPackageName()));
                    if (!file.exists()) {
                        if (file.mkdirs()) {
                            arrayList.add(b5.get(i4));
                        }
                    } else if (file.canWrite()) {
                        arrayList.add(b5.get(i4));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
