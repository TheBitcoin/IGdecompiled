package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.RendererCapabilities;
import com.mbridge.msdk.playercommon.exoplayer2.RendererConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public abstract class MappingTrackSelector extends TrackSelector {
    @Nullable
    private MappedTrackInfo currentMappedTrackInfo;

    private static int findRenderer(RendererCapabilities[] rendererCapabilitiesArr, TrackGroup trackGroup) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int i4 = 0;
        for (int i5 = 0; i5 < rendererCapabilitiesArr.length; i5++) {
            RendererCapabilities rendererCapabilities = rendererCapabilitiesArr[i5];
            for (int i6 = 0; i6 < trackGroup.length; i6++) {
                int supportsFormat = rendererCapabilities.supportsFormat(trackGroup.getFormat(i6)) & 7;
                if (supportsFormat > i4) {
                    if (supportsFormat == 4) {
                        return i5;
                    }
                    length = i5;
                    i4 = supportsFormat;
                }
            }
        }
        return length;
    }

    private static int[] getFormatSupport(RendererCapabilities rendererCapabilities, TrackGroup trackGroup) throws ExoPlaybackException {
        int[] iArr = new int[trackGroup.length];
        for (int i4 = 0; i4 < trackGroup.length; i4++) {
            iArr[i4] = rendererCapabilities.supportsFormat(trackGroup.getFormat(i4));
        }
        return iArr;
    }

    private static int[] getMixedMimeTypeAdaptationSupports(RendererCapabilities[] rendererCapabilitiesArr) throws ExoPlaybackException {
        int length = rendererCapabilitiesArr.length;
        int[] iArr = new int[length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = rendererCapabilitiesArr[i4].supportsMixedMimeTypeAdaptation();
        }
        return iArr;
    }

    @Nullable
    public final MappedTrackInfo getCurrentMappedTrackInfo() {
        return this.currentMappedTrackInfo;
    }

    public final void onSelectionActivated(Object obj) {
        this.currentMappedTrackInfo = (MappedTrackInfo) obj;
    }

    /* access modifiers changed from: protected */
    public abstract Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws ExoPlaybackException;

    public final TrackSelectorResult selectTracks(RendererCapabilities[] rendererCapabilitiesArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException {
        int[] iArr;
        int[] iArr2 = new int[(rendererCapabilitiesArr.length + 1)];
        int length = rendererCapabilitiesArr.length + 1;
        TrackGroup[][] trackGroupArr = new TrackGroup[length][];
        int[][][] iArr3 = new int[(rendererCapabilitiesArr.length + 1)][][];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = trackGroupArray.length;
            trackGroupArr[i4] = new TrackGroup[i5];
            iArr3[i4] = new int[i5][];
        }
        int[] mixedMimeTypeAdaptationSupports = getMixedMimeTypeAdaptationSupports(rendererCapabilitiesArr);
        for (int i6 = 0; i6 < trackGroupArray.length; i6++) {
            TrackGroup trackGroup = trackGroupArray.get(i6);
            int findRenderer = findRenderer(rendererCapabilitiesArr, trackGroup);
            if (findRenderer == rendererCapabilitiesArr.length) {
                iArr = new int[trackGroup.length];
            } else {
                iArr = getFormatSupport(rendererCapabilitiesArr[findRenderer], trackGroup);
            }
            int i7 = iArr2[findRenderer];
            trackGroupArr[findRenderer][i7] = trackGroup;
            iArr3[findRenderer][i7] = iArr;
            iArr2[findRenderer] = i7 + 1;
        }
        TrackGroupArray[] trackGroupArrayArr = new TrackGroupArray[rendererCapabilitiesArr.length];
        int[] iArr4 = new int[rendererCapabilitiesArr.length];
        for (int i8 = 0; i8 < rendererCapabilitiesArr.length; i8++) {
            int i9 = iArr2[i8];
            trackGroupArrayArr[i8] = new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[i8], i9));
            iArr3[i8] = (int[][]) Util.nullSafeArrayCopy(iArr3[i8], i9);
            iArr4[i8] = rendererCapabilitiesArr[i8].getTrackType();
        }
        MappedTrackInfo mappedTrackInfo = new MappedTrackInfo(iArr4, trackGroupArrayArr, mixedMimeTypeAdaptationSupports, iArr3, new TrackGroupArray((TrackGroup[]) Util.nullSafeArrayCopy(trackGroupArr[rendererCapabilitiesArr.length], iArr2[rendererCapabilitiesArr.length])));
        Pair<RendererConfiguration[], TrackSelection[]> selectTracks = selectTracks(mappedTrackInfo, iArr3, mixedMimeTypeAdaptationSupports);
        return new TrackSelectorResult((RendererConfiguration[]) selectTracks.first, (TrackSelection[]) selectTracks.second, mappedTrackInfo);
    }

    public static final class MappedTrackInfo {
        public static final int RENDERER_SUPPORT_EXCEEDS_CAPABILITIES_TRACKS = 2;
        public static final int RENDERER_SUPPORT_NO_TRACKS = 0;
        public static final int RENDERER_SUPPORT_PLAYABLE_TRACKS = 3;
        public static final int RENDERER_SUPPORT_UNSUPPORTED_TRACKS = 1;
        @Deprecated
        public final int length;
        private final int rendererCount;
        private final int[][][] rendererFormatSupports;
        private final int[] rendererMixedMimeTypeAdaptiveSupports;
        private final TrackGroupArray[] rendererTrackGroups;
        private final int[] rendererTrackTypes;
        private final TrackGroupArray unmappedTrackGroups;

        @Retention(RetentionPolicy.SOURCE)
        @interface RendererSupport {
        }

        MappedTrackInfo(int[] iArr, TrackGroupArray[] trackGroupArrayArr, int[] iArr2, int[][][] iArr3, TrackGroupArray trackGroupArray) {
            this.rendererTrackTypes = iArr;
            this.rendererTrackGroups = trackGroupArrayArr;
            this.rendererFormatSupports = iArr3;
            this.rendererMixedMimeTypeAdaptiveSupports = iArr2;
            this.unmappedTrackGroups = trackGroupArray;
            int length2 = iArr.length;
            this.rendererCount = length2;
            this.length = length2;
        }

        public final int getAdaptiveSupport(int i4, int i5, boolean z4) {
            int i6 = this.rendererTrackGroups[i4].get(i5).length;
            int[] iArr = new int[i6];
            int i7 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                int trackSupport = getTrackSupport(i4, i5, i8);
                if (trackSupport == 4 || (z4 && trackSupport == 3)) {
                    iArr[i7] = i8;
                    i7++;
                }
            }
            return getAdaptiveSupport(i4, i5, Arrays.copyOf(iArr, i7));
        }

        public final int getRendererCount() {
            return this.rendererCount;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            r1 = r1 + 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int getRendererSupport(int r8) {
            /*
                r7 = this;
                int[][][] r0 = r7.rendererFormatSupports
                r8 = r0[r8]
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r8.length
                if (r1 >= r3) goto L_0x0028
                r3 = 0
            L_0x000b:
                r4 = r8[r1]
                int r5 = r4.length
                if (r3 >= r5) goto L_0x0025
                r4 = r4[r3]
                r4 = r4 & 7
                r5 = 3
                if (r4 == r5) goto L_0x001d
                r6 = 4
                if (r4 == r6) goto L_0x001c
                r4 = 1
                goto L_0x001e
            L_0x001c:
                return r5
            L_0x001d:
                r4 = 2
            L_0x001e:
                int r2 = java.lang.Math.max(r2, r4)
                int r3 = r3 + 1
                goto L_0x000b
            L_0x0025:
                int r1 = r1 + 1
                goto L_0x0007
            L_0x0028:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo.getRendererSupport(int):int");
        }

        public final int getRendererType(int i4) {
            return this.rendererTrackTypes[i4];
        }

        @Deprecated
        public final int getTrackFormatSupport(int i4, int i5, int i6) {
            return getTrackSupport(i4, i5, i6);
        }

        public final TrackGroupArray getTrackGroups(int i4) {
            return this.rendererTrackGroups[i4];
        }

        public final int getTrackSupport(int i4, int i5, int i6) {
            return this.rendererFormatSupports[i4][i5][i6] & 7;
        }

        @Deprecated
        public final int getTrackTypeRendererSupport(int i4) {
            return getTypeSupport(i4);
        }

        public final int getTypeSupport(int i4) {
            int i5 = 0;
            for (int i6 = 0; i6 < this.rendererCount; i6++) {
                if (this.rendererTrackTypes[i6] == i4) {
                    i5 = Math.max(i5, getRendererSupport(i6));
                }
            }
            return i5;
        }

        @Deprecated
        public final TrackGroupArray getUnassociatedTrackGroups() {
            return getUnmappedTrackGroups();
        }

        public final TrackGroupArray getUnmappedTrackGroups() {
            return this.unmappedTrackGroups;
        }

        public final int getAdaptiveSupport(int i4, int i5, int[] iArr) {
            int i6 = 0;
            String str = null;
            boolean z4 = false;
            int i7 = 0;
            int i8 = 16;
            while (i6 < iArr.length) {
                String str2 = this.rendererTrackGroups[i4].get(i5).getFormat(iArr[i6]).sampleMimeType;
                int i9 = i7 + 1;
                if (i7 == 0) {
                    str = str2;
                } else {
                    z4 |= !Util.areEqual(str, str2);
                }
                i8 = Math.min(i8, this.rendererFormatSupports[i4][i5][i6] & 24);
                i6++;
                i7 = i9;
            }
            return z4 ? Math.min(i8, this.rendererMixedMimeTypeAdaptiveSupports[i4]) : i8;
        }
    }
}
