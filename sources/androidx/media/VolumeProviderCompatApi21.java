package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class VolumeProviderCompatApi21 {

    public interface Delegate {
        void onAdjustVolume(int i4);

        void onSetVolumeTo(int i4);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i4, int i5, int i6, final Delegate delegate) {
        return new VolumeProvider(i4, i5, i6) {
            public void onAdjustVolume(int i4) {
                delegate.onAdjustVolume(i4);
            }

            public void onSetVolumeTo(int i4) {
                delegate.onSetVolumeTo(i4);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i4) {
        ((VolumeProvider) obj).setCurrentVolume(i4);
    }
}
