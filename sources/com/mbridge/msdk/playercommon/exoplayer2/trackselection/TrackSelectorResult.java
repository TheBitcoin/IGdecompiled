package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import com.mbridge.msdk.playercommon.exoplayer2.RendererConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

public final class TrackSelectorResult {
    public final Object info;
    public final int length;
    public final RendererConfiguration[] rendererConfigurations;
    public final TrackSelectionArray selections;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, TrackSelection[] trackSelectionArr, Object obj) {
        this.rendererConfigurations = rendererConfigurationArr;
        this.selections = new TrackSelectionArray(trackSelectionArr);
        this.info = obj;
        this.length = rendererConfigurationArr.length;
    }

    public final boolean isEquivalent(TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.selections.length != this.selections.length) {
            return false;
        }
        for (int i4 = 0; i4 < this.selections.length; i4++) {
            if (!isEquivalent(trackSelectorResult, i4)) {
                return false;
            }
        }
        return true;
    }

    public final boolean isRendererEnabled(int i4) {
        if (this.rendererConfigurations[i4] != null) {
            return true;
        }
        return false;
    }

    public final boolean isEquivalent(TrackSelectorResult trackSelectorResult, int i4) {
        if (trackSelectorResult != null && Util.areEqual(this.rendererConfigurations[i4], trackSelectorResult.rendererConfigurations[i4]) && Util.areEqual(this.selections.get(i4), trackSelectorResult.selections.get(i4))) {
            return true;
        }
        return false;
    }
}
