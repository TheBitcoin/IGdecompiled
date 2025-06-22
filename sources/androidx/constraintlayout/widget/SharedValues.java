package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SharedValues {
    public static final int UNSET = -1;
    private SparseIntArray mValues = new SparseIntArray();
    private HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> mValuesListeners = new HashMap<>();

    public interface SharedValuesListener {
        void onNewValue(int i4, int i5, int i6);
    }

    public void addListener(int i4, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = this.mValuesListeners.get(Integer.valueOf(i4));
        if (hashSet == null) {
            hashSet = new HashSet();
            this.mValuesListeners.put(Integer.valueOf(i4), hashSet);
        }
        hashSet.add(new WeakReference(sharedValuesListener));
    }

    public void clearListeners() {
        this.mValuesListeners.clear();
    }

    public void fireNewValue(int i4, int i5) {
        int i6 = this.mValues.get(i4, -1);
        if (i6 != i5) {
            this.mValues.put(i4, i5);
            HashSet hashSet = this.mValuesListeners.get(Integer.valueOf(i4));
            if (hashSet != null) {
                Iterator it = hashSet.iterator();
                boolean z4 = false;
                while (it.hasNext()) {
                    SharedValuesListener sharedValuesListener = (SharedValuesListener) ((WeakReference) it.next()).get();
                    if (sharedValuesListener != null) {
                        sharedValuesListener.onNewValue(i4, i5, i6);
                    } else {
                        z4 = true;
                    }
                }
                if (z4) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it2 = hashSet.iterator();
                    while (it2.hasNext()) {
                        WeakReference weakReference = (WeakReference) it2.next();
                        if (((SharedValuesListener) weakReference.get()) == null) {
                            arrayList.add(weakReference);
                        }
                    }
                    hashSet.removeAll(arrayList);
                }
            }
        }
    }

    public int getValue(int i4) {
        return this.mValues.get(i4, -1);
    }

    public void removeListener(int i4, SharedValuesListener sharedValuesListener) {
        HashSet hashSet = this.mValuesListeners.get(Integer.valueOf(i4));
        if (hashSet != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                SharedValuesListener sharedValuesListener2 = (SharedValuesListener) weakReference.get();
                if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                    arrayList.add(weakReference);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }

    public void removeListener(SharedValuesListener sharedValuesListener) {
        for (Integer intValue : this.mValuesListeners.keySet()) {
            removeListener(intValue.intValue(), sharedValuesListener);
        }
    }
}
