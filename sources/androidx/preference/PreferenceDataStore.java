package androidx.preference;

import androidx.annotation.Nullable;
import java.util.Set;

public abstract class PreferenceDataStore {
    public boolean getBoolean(String str, boolean z4) {
        return z4;
    }

    public float getFloat(String str, float f4) {
        return f4;
    }

    public int getInt(String str, int i4) {
        return i4;
    }

    public long getLong(String str, long j4) {
        return j4;
    }

    @Nullable
    public String getString(String str, @Nullable String str2) {
        return str2;
    }

    @Nullable
    public Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return set;
    }

    public void putBoolean(String str, boolean z4) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putFloat(String str, float f4) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putInt(String str, int i4) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putLong(String str, long j4) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putString(String str, @Nullable String str2) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }

    public void putStringSet(String str, @Nullable Set<String> set) {
        throw new UnsupportedOperationException("Not implemented on this data store");
    }
}
