package androidx.profileinstaller;

import androidx.annotation.NonNull;
import java.util.TreeMap;

class DexProfileData {
    @NonNull
    final String apkName;
    int classSetSize;
    @NonNull
    int[] classes;
    final long dexChecksum;
    @NonNull
    final String dexName;
    final int hotMethodRegionSize;
    long mTypeIdCount;
    @NonNull
    final TreeMap<Integer, Integer> methods;
    final int numMethodIds;

    DexProfileData(@NonNull String str, @NonNull String str2, long j4, long j5, int i4, int i5, int i6, @NonNull int[] iArr, @NonNull TreeMap<Integer, Integer> treeMap) {
        this.apkName = str;
        this.dexName = str2;
        this.dexChecksum = j4;
        this.mTypeIdCount = j5;
        this.classSetSize = i4;
        this.hotMethodRegionSize = i5;
        this.numMethodIds = i6;
        this.classes = iArr;
        this.methods = treeMap;
    }
}
