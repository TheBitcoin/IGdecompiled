package com.mbridge.msdk.playercommon.exoplayer2.text.cea;

import android.text.Layout;
import androidx.annotation.NonNull;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;

final class Cea708Cue extends Cue implements Comparable<Cea708Cue> {
    public static final int PRIORITY_UNSET = -1;
    public final int priority;

    public Cea708Cue(CharSequence charSequence, Layout.Alignment alignment, float f4, int i4, int i5, float f5, int i6, float f6, boolean z4, int i7, int i8) {
        super(charSequence, alignment, f4, i4, i5, f5, i6, f6, z4, i7);
        this.priority = i8;
    }

    public final int compareTo(@NonNull Cea708Cue cea708Cue) {
        int i4 = cea708Cue.priority;
        int i5 = this.priority;
        if (i4 < i5) {
            return -1;
        }
        return i4 > i5 ? 1 : 0;
    }
}
