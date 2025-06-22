package com.mbridge.msdk.playercommon.exoplayer2.trackselection;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.ExoPlaybackException;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.RendererConfiguration;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup;
import com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.MappingTrackSelector;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.BandwidthMeter;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultTrackSelector extends MappingTrackSelector {
    private static final float FRACTION_TO_CONSIDER_FULLSCREEN = 0.98f;
    private static final int[] NO_TRACKS = new int[0];
    private static final int WITHIN_RENDERER_CAPABILITIES_BONUS = 1000;
    @Nullable
    private final TrackSelection.Factory adaptiveTrackSelectionFactory;
    private final AtomicReference<Parameters> parametersReference;

    private static final class AudioConfigurationTuple {
        public final int channelCount;
        @Nullable
        public final String mimeType;
        public final int sampleRate;

        public AudioConfigurationTuple(int i4, int i5, @Nullable String str) {
            this.channelCount = i4;
            this.sampleRate = i5;
            this.mimeType = str;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AudioConfigurationTuple.class == obj.getClass()) {
                AudioConfigurationTuple audioConfigurationTuple = (AudioConfigurationTuple) obj;
                if (this.channelCount == audioConfigurationTuple.channelCount && this.sampleRate == audioConfigurationTuple.sampleRate && TextUtils.equals(this.mimeType, audioConfigurationTuple.mimeType)) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            int i4;
            int i5 = ((this.channelCount * 31) + this.sampleRate) * 31;
            String str = this.mimeType;
            if (str != null) {
                i4 = str.hashCode();
            } else {
                i4 = 0;
            }
            return i5 + i4;
        }
    }

    private static final class AudioTrackScore implements Comparable<AudioTrackScore> {
        private final int bitrate;
        private final int channelCount;
        private final int defaultSelectionFlagScore;
        private final int matchLanguageScore;
        private final Parameters parameters;
        private final int sampleRate;
        private final int withinRendererCapabilitiesScore;

        public AudioTrackScore(Format format, Parameters parameters2, int i4) {
            this.parameters = parameters2;
            int i5 = 0;
            this.withinRendererCapabilitiesScore = DefaultTrackSelector.isSupported(i4, false) ? 1 : 0;
            this.matchLanguageScore = DefaultTrackSelector.formatHasLanguage(format, parameters2.preferredAudioLanguage) ? 1 : 0;
            this.defaultSelectionFlagScore = (format.selectionFlags & 1) != 0 ? 1 : i5;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.bitrate = format.bitrate;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && AudioTrackScore.class == obj.getClass()) {
                AudioTrackScore audioTrackScore = (AudioTrackScore) obj;
                if (this.withinRendererCapabilitiesScore == audioTrackScore.withinRendererCapabilitiesScore && this.matchLanguageScore == audioTrackScore.matchLanguageScore && this.defaultSelectionFlagScore == audioTrackScore.defaultSelectionFlagScore && this.channelCount == audioTrackScore.channelCount && this.sampleRate == audioTrackScore.sampleRate && this.bitrate == audioTrackScore.bitrate) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final int hashCode() {
            return (((((((((this.withinRendererCapabilitiesScore * 31) + this.matchLanguageScore) * 31) + this.defaultSelectionFlagScore) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.bitrate;
        }

        public final int compareTo(AudioTrackScore audioTrackScore) {
            int access$300;
            int i4 = this.withinRendererCapabilitiesScore;
            int i5 = audioTrackScore.withinRendererCapabilitiesScore;
            if (i4 != i5) {
                return DefaultTrackSelector.compareInts(i4, i5);
            }
            int i6 = this.matchLanguageScore;
            int i7 = audioTrackScore.matchLanguageScore;
            if (i6 != i7) {
                return DefaultTrackSelector.compareInts(i6, i7);
            }
            int i8 = this.defaultSelectionFlagScore;
            int i9 = audioTrackScore.defaultSelectionFlagScore;
            if (i8 != i9) {
                return DefaultTrackSelector.compareInts(i8, i9);
            }
            if (this.parameters.forceLowestBitrate) {
                return DefaultTrackSelector.compareInts(audioTrackScore.bitrate, this.bitrate);
            }
            int i10 = 1;
            if (i4 != 1) {
                i10 = -1;
            }
            int i11 = this.channelCount;
            int i12 = audioTrackScore.channelCount;
            if (i11 != i12) {
                access$300 = DefaultTrackSelector.compareInts(i11, i12);
            } else {
                int i13 = this.sampleRate;
                int i14 = audioTrackScore.sampleRate;
                if (i13 != i14) {
                    access$300 = DefaultTrackSelector.compareInts(i13, i14);
                } else {
                    access$300 = DefaultTrackSelector.compareInts(this.bitrate, audioTrackScore.bitrate);
                }
            }
            return i10 * access$300;
        }
    }

    public static final class Parameters implements Parcelable {
        public static final Parcelable.Creator<Parameters> CREATOR = new Parcelable.Creator<Parameters>() {
            public final Parameters createFromParcel(Parcel parcel) {
                return new Parameters(parcel);
            }

            public final Parameters[] newArray(int i4) {
                return new Parameters[i4];
            }
        };
        public static final Parameters DEFAULT = new Parameters();
        public final boolean allowMixedMimeAdaptiveness;
        public final boolean allowNonSeamlessAdaptiveness;
        public final int disabledTextTrackSelectionFlags;
        public final boolean exceedRendererCapabilitiesIfNecessary;
        public final boolean exceedVideoConstraintsIfNecessary;
        public final boolean forceLowestBitrate;
        public final int maxVideoBitrate;
        public final int maxVideoHeight;
        public final int maxVideoWidth;
        @Nullable
        public final String preferredAudioLanguage;
        @Nullable
        public final String preferredTextLanguage;
        /* access modifiers changed from: private */
        public final SparseBooleanArray rendererDisabledFlags;
        public final boolean selectUndeterminedTextLanguage;
        /* access modifiers changed from: private */
        public final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        public final int tunnelingAudioSessionId;
        public final int viewportHeight;
        public final boolean viewportOrientationMayChange;
        public final int viewportWidth;

        private Parameters() {
            this(new SparseArray(), new SparseBooleanArray(), (String) null, (String) null, false, 0, false, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true, 0);
        }

        private static boolean areRendererDisabledFlagsEqual(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i4 = 0; i4 < size; i4++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i4)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean areSelectionOverridesEqual(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i4 = 0; i4 < size; i4++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i4));
                if (indexOfKey < 0 || !areSelectionOverridesEqual(sparseArray.valueAt(i4), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> readSelectionOverrides(Parcel parcel) {
            int readInt = parcel.readInt();
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = new SparseArray<>(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                int readInt2 = parcel.readInt();
                int readInt3 = parcel.readInt();
                HashMap hashMap = new HashMap(readInt3);
                for (int i5 = 0; i5 < readInt3; i5++) {
                    hashMap.put((TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader()), (SelectionOverride) parcel.readParcelable(SelectionOverride.class.getClassLoader()));
                }
                sparseArray.put(readInt2, hashMap);
            }
            return sparseArray;
        }

        private static void writeSelectionOverridesToParcel(Parcel parcel, SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i4 = 0; i4 < size; i4++) {
                int keyAt = sparseArray.keyAt(i4);
                Map valueAt = sparseArray.valueAt(i4);
                int size2 = valueAt.size();
                parcel.writeInt(keyAt);
                parcel.writeInt(size2);
                for (Map.Entry entry : valueAt.entrySet()) {
                    parcel.writeParcelable((Parcelable) entry.getKey(), 0);
                    parcel.writeParcelable((Parcelable) entry.getValue(), 0);
                }
            }
        }

        public final ParametersBuilder buildUpon() {
            return new ParametersBuilder(this);
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Parameters.class == obj.getClass()) {
                Parameters parameters = (Parameters) obj;
                if (this.selectUndeterminedTextLanguage == parameters.selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == parameters.disabledTextTrackSelectionFlags && this.forceLowestBitrate == parameters.forceLowestBitrate && this.allowMixedMimeAdaptiveness == parameters.allowMixedMimeAdaptiveness && this.allowNonSeamlessAdaptiveness == parameters.allowNonSeamlessAdaptiveness && this.maxVideoWidth == parameters.maxVideoWidth && this.maxVideoHeight == parameters.maxVideoHeight && this.exceedVideoConstraintsIfNecessary == parameters.exceedVideoConstraintsIfNecessary && this.exceedRendererCapabilitiesIfNecessary == parameters.exceedRendererCapabilitiesIfNecessary && this.viewportOrientationMayChange == parameters.viewportOrientationMayChange && this.viewportWidth == parameters.viewportWidth && this.viewportHeight == parameters.viewportHeight && this.maxVideoBitrate == parameters.maxVideoBitrate && this.tunnelingAudioSessionId == parameters.tunnelingAudioSessionId && TextUtils.equals(this.preferredAudioLanguage, parameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, parameters.preferredTextLanguage) && areRendererDisabledFlagsEqual(this.rendererDisabledFlags, parameters.rendererDisabledFlags) && areSelectionOverridesEqual(this.selectionOverrides, parameters.selectionOverrides)) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public final boolean getRendererDisabled(int i4) {
            return this.rendererDisabledFlags.get(i4);
        }

        @Nullable
        public final SelectionOverride getSelectionOverride(int i4, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i4);
            if (map != null) {
                return (SelectionOverride) map.get(trackGroupArray);
            }
            return null;
        }

        public final boolean hasSelectionOverride(int i4, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i4);
            if (map == null || !map.containsKey(trackGroupArray)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i4;
            int i5 = (((((((((((((((((((((((((((this.selectUndeterminedTextLanguage ? 1 : 0) * true) + this.disabledTextTrackSelectionFlags) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.allowMixedMimeAdaptiveness ? 1 : 0)) * 31) + (this.allowNonSeamlessAdaptiveness ? 1 : 0)) * 31) + this.maxVideoWidth) * 31) + this.maxVideoHeight) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31) + this.maxVideoBitrate) * 31) + this.tunnelingAudioSessionId) * 31;
            String str = this.preferredAudioLanguage;
            int i6 = 0;
            if (str == null) {
                i4 = 0;
            } else {
                i4 = str.hashCode();
            }
            int i7 = (i5 + i4) * 31;
            String str2 = this.preferredTextLanguage;
            if (str2 != null) {
                i6 = str2.hashCode();
            }
            return i7 + i6;
        }

        public final void writeToParcel(Parcel parcel, int i4) {
            writeSelectionOverridesToParcel(parcel, this.selectionOverrides);
            parcel.writeSparseBooleanArray(this.rendererDisabledFlags);
            parcel.writeString(this.preferredAudioLanguage);
            parcel.writeString(this.preferredTextLanguage);
            Util.writeBoolean(parcel, this.selectUndeterminedTextLanguage);
            parcel.writeInt(this.disabledTextTrackSelectionFlags);
            Util.writeBoolean(parcel, this.forceLowestBitrate);
            Util.writeBoolean(parcel, this.allowMixedMimeAdaptiveness);
            Util.writeBoolean(parcel, this.allowNonSeamlessAdaptiveness);
            parcel.writeInt(this.maxVideoWidth);
            parcel.writeInt(this.maxVideoHeight);
            parcel.writeInt(this.maxVideoBitrate);
            Util.writeBoolean(parcel, this.exceedVideoConstraintsIfNecessary);
            Util.writeBoolean(parcel, this.exceedRendererCapabilitiesIfNecessary);
            parcel.writeInt(this.viewportWidth);
            parcel.writeInt(this.viewportHeight);
            Util.writeBoolean(parcel, this.viewportOrientationMayChange);
            parcel.writeInt(this.tunnelingAudioSessionId);
        }

        Parameters(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray, SparseBooleanArray sparseBooleanArray, @Nullable String str, @Nullable String str2, boolean z4, int i4, boolean z5, boolean z6, boolean z7, int i5, int i6, int i7, boolean z8, boolean z9, int i8, int i9, boolean z10, int i10) {
            this.selectionOverrides = sparseArray;
            this.rendererDisabledFlags = sparseBooleanArray;
            this.preferredAudioLanguage = Util.normalizeLanguageCode(str);
            this.preferredTextLanguage = Util.normalizeLanguageCode(str2);
            this.selectUndeterminedTextLanguage = z4;
            this.disabledTextTrackSelectionFlags = i4;
            this.forceLowestBitrate = z5;
            this.allowMixedMimeAdaptiveness = z6;
            this.allowNonSeamlessAdaptiveness = z7;
            this.maxVideoWidth = i5;
            this.maxVideoHeight = i6;
            this.maxVideoBitrate = i7;
            this.exceedVideoConstraintsIfNecessary = z8;
            this.exceedRendererCapabilitiesIfNecessary = z9;
            this.viewportWidth = i8;
            this.viewportHeight = i9;
            this.viewportOrientationMayChange = z10;
            this.tunnelingAudioSessionId = i10;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean areSelectionOverridesEqual(java.util.Map<com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray, com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r4, java.util.Map<com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray, com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray r1 = (com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.areEqual(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.Parameters.areSelectionOverridesEqual(java.util.Map, java.util.Map):boolean");
        }

        Parameters(Parcel parcel) {
            this.selectionOverrides = readSelectionOverrides(parcel);
            this.rendererDisabledFlags = parcel.readSparseBooleanArray();
            this.preferredAudioLanguage = parcel.readString();
            this.preferredTextLanguage = parcel.readString();
            this.selectUndeterminedTextLanguage = Util.readBoolean(parcel);
            this.disabledTextTrackSelectionFlags = parcel.readInt();
            this.forceLowestBitrate = Util.readBoolean(parcel);
            this.allowMixedMimeAdaptiveness = Util.readBoolean(parcel);
            this.allowNonSeamlessAdaptiveness = Util.readBoolean(parcel);
            this.maxVideoWidth = parcel.readInt();
            this.maxVideoHeight = parcel.readInt();
            this.maxVideoBitrate = parcel.readInt();
            this.exceedVideoConstraintsIfNecessary = Util.readBoolean(parcel);
            this.exceedRendererCapabilitiesIfNecessary = Util.readBoolean(parcel);
            this.viewportWidth = parcel.readInt();
            this.viewportHeight = parcel.readInt();
            this.viewportOrientationMayChange = Util.readBoolean(parcel);
            this.tunnelingAudioSessionId = parcel.readInt();
        }
    }

    public static final class ParametersBuilder {
        private boolean allowMixedMimeAdaptiveness;
        private boolean allowNonSeamlessAdaptiveness;
        private int disabledTextTrackSelectionFlags;
        private boolean exceedRendererCapabilitiesIfNecessary;
        private boolean exceedVideoConstraintsIfNecessary;
        private boolean forceLowestBitrate;
        private int maxVideoBitrate;
        private int maxVideoHeight;
        private int maxVideoWidth;
        @Nullable
        private String preferredAudioLanguage;
        @Nullable
        private String preferredTextLanguage;
        private final SparseBooleanArray rendererDisabledFlags;
        private boolean selectUndeterminedTextLanguage;
        private final SparseArray<Map<TrackGroupArray, SelectionOverride>> selectionOverrides;
        private int tunnelingAudioSessionId;
        private int viewportHeight;
        private boolean viewportOrientationMayChange;
        private int viewportWidth;

        private static SparseArray<Map<TrackGroupArray, SelectionOverride>> cloneSelectionOverrides(SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray) {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray2 = new SparseArray<>();
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                sparseArray2.put(sparseArray.keyAt(i4), new HashMap(sparseArray.valueAt(i4)));
            }
            return sparseArray2;
        }

        public final Parameters build() {
            SparseArray<Map<TrackGroupArray, SelectionOverride>> sparseArray = this.selectionOverrides;
            SparseBooleanArray sparseBooleanArray = this.rendererDisabledFlags;
            String str = this.preferredAudioLanguage;
            String str2 = this.preferredTextLanguage;
            boolean z4 = this.selectUndeterminedTextLanguage;
            int i4 = this.disabledTextTrackSelectionFlags;
            boolean z5 = this.forceLowestBitrate;
            boolean z6 = this.allowMixedMimeAdaptiveness;
            boolean z7 = this.allowNonSeamlessAdaptiveness;
            int i5 = this.maxVideoWidth;
            int i6 = this.maxVideoHeight;
            int i7 = this.maxVideoBitrate;
            boolean z8 = this.exceedVideoConstraintsIfNecessary;
            boolean z9 = this.exceedRendererCapabilitiesIfNecessary;
            int i8 = this.viewportWidth;
            int i9 = this.viewportHeight;
            return new Parameters(sparseArray, sparseBooleanArray, str, str2, z4, i4, z5, z6, z7, i5, i6, i7, z8, z9, i8, i9, this.viewportOrientationMayChange, this.tunnelingAudioSessionId);
        }

        public final ParametersBuilder clearSelectionOverride(int i4, TrackGroupArray trackGroupArray) {
            Map map = this.selectionOverrides.get(i4);
            if (map != null && map.containsKey(trackGroupArray)) {
                map.remove(trackGroupArray);
                if (map.isEmpty()) {
                    this.selectionOverrides.remove(i4);
                }
            }
            return this;
        }

        public final ParametersBuilder clearSelectionOverrides(int i4) {
            Map map = this.selectionOverrides.get(i4);
            if (map != null && !map.isEmpty()) {
                this.selectionOverrides.remove(i4);
            }
            return this;
        }

        public final ParametersBuilder clearVideoSizeConstraints() {
            return setMaxVideoSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        public final ParametersBuilder clearViewportSizeConstraints() {
            return setViewportSize(Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public final ParametersBuilder setAllowMixedMimeAdaptiveness(boolean z4) {
            this.allowMixedMimeAdaptiveness = z4;
            return this;
        }

        public final ParametersBuilder setAllowNonSeamlessAdaptiveness(boolean z4) {
            this.allowNonSeamlessAdaptiveness = z4;
            return this;
        }

        public final ParametersBuilder setDisabledTextTrackSelectionFlags(int i4) {
            this.disabledTextTrackSelectionFlags = i4;
            return this;
        }

        public final ParametersBuilder setExceedRendererCapabilitiesIfNecessary(boolean z4) {
            this.exceedRendererCapabilitiesIfNecessary = z4;
            return this;
        }

        public final ParametersBuilder setExceedVideoConstraintsIfNecessary(boolean z4) {
            this.exceedVideoConstraintsIfNecessary = z4;
            return this;
        }

        public final ParametersBuilder setForceLowestBitrate(boolean z4) {
            this.forceLowestBitrate = z4;
            return this;
        }

        public final ParametersBuilder setMaxVideoBitrate(int i4) {
            this.maxVideoBitrate = i4;
            return this;
        }

        public final ParametersBuilder setMaxVideoSize(int i4, int i5) {
            this.maxVideoWidth = i4;
            this.maxVideoHeight = i5;
            return this;
        }

        public final ParametersBuilder setMaxVideoSizeSd() {
            return setMaxVideoSize(1279, 719);
        }

        public final ParametersBuilder setPreferredAudioLanguage(String str) {
            this.preferredAudioLanguage = str;
            return this;
        }

        public final ParametersBuilder setPreferredTextLanguage(String str) {
            this.preferredTextLanguage = str;
            return this;
        }

        public final ParametersBuilder setRendererDisabled(int i4, boolean z4) {
            if (this.rendererDisabledFlags.get(i4) == z4) {
                return this;
            }
            if (z4) {
                this.rendererDisabledFlags.put(i4, true);
                return this;
            }
            this.rendererDisabledFlags.delete(i4);
            return this;
        }

        public final ParametersBuilder setSelectUndeterminedTextLanguage(boolean z4) {
            this.selectUndeterminedTextLanguage = z4;
            return this;
        }

        public final ParametersBuilder setSelectionOverride(int i4, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
            Map map = this.selectionOverrides.get(i4);
            if (map == null) {
                map = new HashMap();
                this.selectionOverrides.put(i4, map);
            }
            if (map.containsKey(trackGroupArray) && Util.areEqual(map.get(trackGroupArray), selectionOverride)) {
                return this;
            }
            map.put(trackGroupArray, selectionOverride);
            return this;
        }

        public final ParametersBuilder setTunnelingAudioSessionId(int i4) {
            if (this.tunnelingAudioSessionId != i4) {
                this.tunnelingAudioSessionId = i4;
            }
            return this;
        }

        public final ParametersBuilder setViewportSize(int i4, int i5, boolean z4) {
            this.viewportWidth = i4;
            this.viewportHeight = i5;
            this.viewportOrientationMayChange = z4;
            return this;
        }

        public final ParametersBuilder setViewportSizeToPhysicalDisplaySize(Context context, boolean z4) {
            Point physicalDisplaySize = Util.getPhysicalDisplaySize(context);
            return setViewportSize(physicalDisplaySize.x, physicalDisplaySize.y, z4);
        }

        public ParametersBuilder() {
            this(Parameters.DEFAULT);
        }

        private ParametersBuilder(Parameters parameters) {
            this.selectionOverrides = cloneSelectionOverrides(parameters.selectionOverrides);
            this.rendererDisabledFlags = parameters.rendererDisabledFlags.clone();
            this.preferredAudioLanguage = parameters.preferredAudioLanguage;
            this.preferredTextLanguage = parameters.preferredTextLanguage;
            this.selectUndeterminedTextLanguage = parameters.selectUndeterminedTextLanguage;
            this.disabledTextTrackSelectionFlags = parameters.disabledTextTrackSelectionFlags;
            this.forceLowestBitrate = parameters.forceLowestBitrate;
            this.allowMixedMimeAdaptiveness = parameters.allowMixedMimeAdaptiveness;
            this.allowNonSeamlessAdaptiveness = parameters.allowNonSeamlessAdaptiveness;
            this.maxVideoWidth = parameters.maxVideoWidth;
            this.maxVideoHeight = parameters.maxVideoHeight;
            this.maxVideoBitrate = parameters.maxVideoBitrate;
            this.exceedVideoConstraintsIfNecessary = parameters.exceedVideoConstraintsIfNecessary;
            this.exceedRendererCapabilitiesIfNecessary = parameters.exceedRendererCapabilitiesIfNecessary;
            this.viewportWidth = parameters.viewportWidth;
            this.viewportHeight = parameters.viewportHeight;
            this.viewportOrientationMayChange = parameters.viewportOrientationMayChange;
            this.tunnelingAudioSessionId = parameters.tunnelingAudioSessionId;
        }

        public final ParametersBuilder clearSelectionOverrides() {
            if (this.selectionOverrides.size() == 0) {
                return this;
            }
            this.selectionOverrides.clear();
            return this;
        }
    }

    public DefaultTrackSelector() {
        this((TrackSelection.Factory) null);
    }

    private static int compareFormatValues(int i4, int i5) {
        if (i4 == -1) {
            return i5 == -1 ? 0 : -1;
        }
        if (i5 == -1) {
            return 1;
        }
        return i4 - i5;
    }

    /* access modifiers changed from: private */
    public static int compareInts(int i4, int i5) {
        if (i4 > i5) {
            return 1;
        }
        return i5 > i4 ? -1 : 0;
    }

    private static void filterAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i4, @Nullable String str, int i5, int i6, int i7, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list2.size() - 1; size >= 0; size--) {
            int intValue = list2.get(size).intValue();
            if (!isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i4, i5, i6, i7)) {
                list2.remove(size);
            }
        }
    }

    protected static boolean formatHasLanguage(Format format, @Nullable String str) {
        if (str == null || !TextUtils.equals(str, Util.normalizeLanguageCode(format.language))) {
            return false;
        }
        return true;
    }

    protected static boolean formatHasNoLanguage(Format format) {
        if (TextUtils.isEmpty(format.language) || formatHasLanguage(format, C.LANGUAGE_UNDETERMINED)) {
            return true;
        }
        return false;
    }

    private static int getAdaptiveAudioTrackCount(TrackGroup trackGroup, int[] iArr, AudioConfigurationTuple audioConfigurationTuple) {
        int i4 = 0;
        for (int i5 = 0; i5 < trackGroup.length; i5++) {
            if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i5), iArr[i5], audioConfigurationTuple)) {
                i4++;
            }
        }
        return i4;
    }

    private static int[] getAdaptiveAudioTracks(TrackGroup trackGroup, int[] iArr, boolean z4) {
        String str;
        int adaptiveAudioTrackCount;
        HashSet hashSet = new HashSet();
        AudioConfigurationTuple audioConfigurationTuple = null;
        int i4 = 0;
        for (int i5 = 0; i5 < trackGroup.length; i5++) {
            Format format = trackGroup.getFormat(i5);
            int i6 = format.channelCount;
            int i7 = format.sampleRate;
            if (z4) {
                str = null;
            } else {
                str = format.sampleMimeType;
            }
            AudioConfigurationTuple audioConfigurationTuple2 = new AudioConfigurationTuple(i6, i7, str);
            if (hashSet.add(audioConfigurationTuple2) && (adaptiveAudioTrackCount = getAdaptiveAudioTrackCount(trackGroup, iArr, audioConfigurationTuple2)) > i4) {
                i4 = adaptiveAudioTrackCount;
                audioConfigurationTuple = audioConfigurationTuple2;
            }
        }
        if (i4 <= 1) {
            return NO_TRACKS;
        }
        int[] iArr2 = new int[i4];
        int i8 = 0;
        for (int i9 = 0; i9 < trackGroup.length; i9++) {
            if (isSupportedAdaptiveAudioTrack(trackGroup.getFormat(i9), iArr[i9], (AudioConfigurationTuple) Assertions.checkNotNull(audioConfigurationTuple))) {
                iArr2[i8] = i9;
                i8++;
            }
        }
        return iArr2;
    }

    private static int getAdaptiveVideoTrackCountForMimeType(TrackGroup trackGroup, int[] iArr, int i4, @Nullable String str, int i5, int i6, int i7, List<Integer> list) {
        int i8 = 0;
        for (int i9 = 0; i9 < list.size(); i9++) {
            int intValue = list.get(i9).intValue();
            if (isSupportedAdaptiveVideoTrack(trackGroup.getFormat(intValue), str, iArr[intValue], i4, i5, i6, i7)) {
                i8++;
            }
        }
        return i8;
    }

    private static int[] getAdaptiveVideoTracksForGroup(TrackGroup trackGroup, int[] iArr, boolean z4, int i4, int i5, int i6, int i7, int i8, int i9, boolean z5) {
        int i10;
        int i11;
        int i12;
        String str;
        int i13;
        int i14;
        int i15;
        int[] iArr2;
        TrackGroup trackGroup2;
        if (trackGroup.length < 2) {
            return NO_TRACKS;
        }
        List<Integer> viewportFilteredTrackIndices = getViewportFilteredTrackIndices(trackGroup, i8, i9, z5);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        if (!z4) {
            HashSet hashSet = new HashSet();
            String str2 = null;
            int i16 = 0;
            int i17 = 0;
            while (i16 < viewportFilteredTrackIndices.size()) {
                String str3 = trackGroup.getFormat(viewportFilteredTrackIndices.get(i16).intValue()).sampleMimeType;
                if (hashSet.add(str3)) {
                    int i18 = i7;
                    i13 = i6;
                    i14 = i5;
                    String str4 = str3;
                    iArr2 = iArr;
                    trackGroup2 = trackGroup;
                    int adaptiveVideoTrackCountForMimeType = getAdaptiveVideoTrackCountForMimeType(trackGroup2, iArr2, i4, str4, i14, i13, i18, viewportFilteredTrackIndices);
                    int i19 = i18;
                    String str5 = str4;
                    i15 = i19;
                    if (adaptiveVideoTrackCountForMimeType > i17) {
                        i17 = adaptiveVideoTrackCountForMimeType;
                        str2 = str5;
                    }
                } else {
                    int i20 = i6;
                    i14 = i5;
                    i15 = i7;
                    i13 = i20;
                    iArr2 = iArr;
                    trackGroup2 = trackGroup;
                }
                i16++;
                int i21 = i13;
                i7 = i15;
                i5 = i14;
                i6 = i21;
                trackGroup = trackGroup2;
                iArr = iArr2;
            }
            i10 = i6;
            i11 = i5;
            i12 = i7;
            str = str2;
        } else {
            i10 = i6;
            i11 = i5;
            i12 = i7;
            str = null;
        }
        filterAdaptiveVideoTrackCountForMimeType(trackGroup, iArr, i4, str, i11, i10, i12, viewportFilteredTrackIndices);
        if (viewportFilteredTrackIndices.size() < 2) {
            return NO_TRACKS;
        }
        return Util.toArray(viewportFilteredTrackIndices);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r1 != r3) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point getMaxVideoSizeInViewport(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x000f
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            r3 = 1
        L_0x000c:
            if (r1 == r3) goto L_0x000f
            goto L_0x0012
        L_0x000f:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0012:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0022
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.ceilDivide((int) r0, (int) r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0022:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.ceilDivide((int) r3, (int) r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.getMaxVideoSizeInViewport(boolean, int, int, int, int):android.graphics.Point");
    }

    private static List<Integer> getViewportFilteredTrackIndices(TrackGroup trackGroup, int i4, int i5, boolean z4) {
        int i6;
        ArrayList arrayList = new ArrayList(trackGroup.length);
        for (int i7 = 0; i7 < trackGroup.length; i7++) {
            arrayList.add(Integer.valueOf(i7));
        }
        if (!(i4 == Integer.MAX_VALUE || i5 == Integer.MAX_VALUE)) {
            int i8 = Integer.MAX_VALUE;
            for (int i9 = 0; i9 < trackGroup.length; i9++) {
                Format format = trackGroup.getFormat(i9);
                int i10 = format.width;
                if (i10 > 0 && (i6 = format.height) > 0) {
                    Point maxVideoSizeInViewport = getMaxVideoSizeInViewport(z4, i4, i5, i10, i6);
                    int i11 = format.width;
                    int i12 = format.height;
                    int i13 = i11 * i12;
                    if (i11 >= ((int) (((float) maxVideoSizeInViewport.x) * FRACTION_TO_CONSIDER_FULLSCREEN)) && i12 >= ((int) (((float) maxVideoSizeInViewport.y) * FRACTION_TO_CONSIDER_FULLSCREEN)) && i13 < i8) {
                        i8 = i13;
                    }
                }
            }
            if (i8 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int pixelCount = trackGroup.getFormat(((Integer) arrayList.get(size)).intValue()).getPixelCount();
                    if (pixelCount == -1 || pixelCount > i8) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    protected static boolean isSupported(int i4, boolean z4) {
        int i5 = i4 & 7;
        if (i5 != 4) {
            return z4 && i5 == 3;
        }
        return true;
    }

    private static boolean isSupportedAdaptiveAudioTrack(Format format, int i4, AudioConfigurationTuple audioConfigurationTuple) {
        String str;
        if (!isSupported(i4, false) || format.channelCount != audioConfigurationTuple.channelCount || format.sampleRate != audioConfigurationTuple.sampleRate || ((str = audioConfigurationTuple.mimeType) != null && !TextUtils.equals(str, format.sampleMimeType))) {
            return false;
        }
        return true;
    }

    private static boolean isSupportedAdaptiveVideoTrack(Format format, @Nullable String str, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        if (!isSupported(i4, false) || (i4 & i5) == 0 || ((str != null && !Util.areEqual(format.sampleMimeType, str)) || (((i9 = format.width) != -1 && i9 > i6) || (((i10 = format.height) != -1 && i10 > i7) || ((i11 = format.bitrate) != -1 && i11 > i8))))) {
            return false;
        }
        return true;
    }

    private static void maybeConfigureRenderersForTunneling(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, RendererConfiguration[] rendererConfigurationArr, TrackSelection[] trackSelectionArr, int i4) {
        boolean z4;
        if (i4 != 0) {
            boolean z5 = false;
            int i5 = 0;
            int i6 = -1;
            int i7 = -1;
            while (true) {
                if (i5 >= mappedTrackInfo.getRendererCount()) {
                    z4 = true;
                    break;
                }
                int rendererType = mappedTrackInfo.getRendererType(i5);
                TrackSelection trackSelection = trackSelectionArr[i5];
                if ((rendererType == 1 || rendererType == 2) && trackSelection != null && rendererSupportsTunneling(iArr[i5], mappedTrackInfo.getTrackGroups(i5), trackSelection)) {
                    if (rendererType == 1) {
                        if (i7 != -1) {
                            break;
                        }
                        i7 = i5;
                    } else if (i6 != -1) {
                        break;
                    } else {
                        i6 = i5;
                    }
                }
                i5++;
            }
            z4 = false;
            if (!(i7 == -1 || i6 == -1)) {
                z5 = true;
            }
            if (z4 && z5) {
                RendererConfiguration rendererConfiguration = new RendererConfiguration(i4);
                rendererConfigurationArr[i7] = rendererConfiguration;
                rendererConfigurationArr[i6] = rendererConfiguration;
            }
        }
    }

    private static boolean rendererSupportsTunneling(int[][] iArr, TrackGroupArray trackGroupArray, TrackSelection trackSelection) {
        if (trackSelection == null) {
            return false;
        }
        int indexOf = trackGroupArray.indexOf(trackSelection.getTrackGroup());
        for (int i4 = 0; i4 < trackSelection.length(); i4++) {
            if ((iArr[indexOf][trackSelection.getIndexInTrackGroup(i4)] & 32) != 32) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    private static TrackSelection selectAdaptiveVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i4, Parameters parameters, TrackSelection.Factory factory) throws ExoPlaybackException {
        int i5;
        boolean z4;
        if (parameters.allowNonSeamlessAdaptiveness) {
            i5 = 24;
        } else {
            i5 = 16;
        }
        if (!parameters.allowMixedMimeAdaptiveness || (i4 & i5) == 0) {
            z4 = false;
        } else {
            z4 = true;
        }
        for (int i6 = 0; i6 < trackGroupArray.length; i6++) {
            TrackGroup trackGroup = trackGroupArray.get(i6);
            int[] adaptiveVideoTracksForGroup = getAdaptiveVideoTracksForGroup(trackGroup, iArr[i6], z4, i5, parameters.maxVideoWidth, parameters.maxVideoHeight, parameters.maxVideoBitrate, parameters.viewportWidth, parameters.viewportHeight, parameters.viewportOrientationMayChange);
            if (adaptiveVideoTracksForGroup.length > 0) {
                return ((TrackSelection.Factory) Assertions.checkNotNull(factory)).createTrackSelection(trackGroup, adaptiveVideoTracksForGroup);
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0085, code lost:
        if (compareFormatValues(r2.bitrate, r10) < 0) goto L_0x008a;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection selectFixedVideoTrack(com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray r19, int[][] r20, com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.Parameters r21) {
        /*
            r0 = r19
            r1 = r21
            r4 = -1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = -1
            r10 = -1
        L_0x000b:
            int r11 = r0.length
            if (r5 >= r11) goto L_0x00c5
            com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroup r11 = r0.get(r5)
            int r12 = r1.viewportWidth
            int r13 = r1.viewportHeight
            boolean r14 = r1.viewportOrientationMayChange
            java.util.List r12 = getViewportFilteredTrackIndices(r11, r12, r13, r14)
            r13 = r20[r5]
            r14 = 0
        L_0x0020:
            int r15 = r11.length
            if (r14 >= r15) goto L_0x00bc
            r15 = r13[r14]
            r16 = 0
            boolean r2 = r1.exceedRendererCapabilitiesIfNecessary
            boolean r2 = isSupported(r15, r2)
            if (r2 == 0) goto L_0x00b5
            com.mbridge.msdk.playercommon.exoplayer2.Format r2 = r11.getFormat(r14)
            java.lang.Integer r15 = java.lang.Integer.valueOf(r14)
            boolean r15 = r12.contains(r15)
            r17 = 1
            if (r15 == 0) goto L_0x005a
            int r15 = r2.width
            if (r15 == r4) goto L_0x0048
            int r3 = r1.maxVideoWidth
            if (r15 > r3) goto L_0x005a
        L_0x0048:
            int r3 = r2.height
            if (r3 == r4) goto L_0x0050
            int r15 = r1.maxVideoHeight
            if (r3 > r15) goto L_0x005a
        L_0x0050:
            int r3 = r2.bitrate
            if (r3 == r4) goto L_0x0058
            int r15 = r1.maxVideoBitrate
            if (r3 > r15) goto L_0x005a
        L_0x0058:
            r3 = 1
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            if (r3 != 0) goto L_0x0062
            boolean r15 = r1.exceedVideoConstraintsIfNecessary
            if (r15 != 0) goto L_0x0062
            goto L_0x00b5
        L_0x0062:
            if (r3 == 0) goto L_0x0066
            r15 = 2
            goto L_0x0067
        L_0x0066:
            r15 = 1
        L_0x0067:
            r4 = r13[r14]
            r0 = 0
            boolean r4 = isSupported(r4, r0)
            if (r4 == 0) goto L_0x0072
            int r15 = r15 + 1000
        L_0x0072:
            if (r15 <= r8) goto L_0x0077
            r18 = 1
            goto L_0x0079
        L_0x0077:
            r18 = 0
        L_0x0079:
            if (r15 != r8) goto L_0x00a8
            boolean r0 = r1.forceLowestBitrate
            if (r0 == 0) goto L_0x008d
            int r0 = r2.bitrate
            int r0 = compareFormatValues(r0, r10)
            if (r0 >= 0) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            r17 = 0
        L_0x008a:
            r18 = r17
            goto L_0x00a8
        L_0x008d:
            int r0 = r2.getPixelCount()
            if (r0 == r9) goto L_0x0098
            int r0 = compareFormatValues(r0, r9)
            goto L_0x009e
        L_0x0098:
            int r0 = r2.bitrate
            int r0 = compareFormatValues(r0, r10)
        L_0x009e:
            if (r4 == 0) goto L_0x00a5
            if (r3 == 0) goto L_0x00a5
            if (r0 <= 0) goto L_0x0088
            goto L_0x008a
        L_0x00a5:
            if (r0 >= 0) goto L_0x0088
            goto L_0x008a
        L_0x00a8:
            if (r18 == 0) goto L_0x00b5
            int r0 = r2.bitrate
            int r2 = r2.getPixelCount()
            r10 = r0
            r9 = r2
            r6 = r11
            r7 = r14
            r8 = r15
        L_0x00b5:
            int r14 = r14 + 1
            r0 = r19
            r4 = -1
            goto L_0x0020
        L_0x00bc:
            r16 = 0
            int r5 = r5 + 1
            r0 = r19
            r4 = -1
            goto L_0x000b
        L_0x00c5:
            r16 = 0
            if (r6 != 0) goto L_0x00ca
            return r16
        L_0x00ca:
            com.mbridge.msdk.playercommon.exoplayer2.trackselection.FixedTrackSelection r0 = new com.mbridge.msdk.playercommon.exoplayer2.trackselection.FixedTrackSelection
            r0.<init>(r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector.selectFixedVideoTrack(com.mbridge.msdk.playercommon.exoplayer2.source.TrackGroupArray, int[][], com.mbridge.msdk.playercommon.exoplayer2.trackselection.DefaultTrackSelector$Parameters):com.mbridge.msdk.playercommon.exoplayer2.trackselection.TrackSelection");
    }

    public ParametersBuilder buildUponParameters() {
        return getParameters().buildUpon();
    }

    @Deprecated
    public final void clearSelectionOverride(int i4, TrackGroupArray trackGroupArray) {
        setParameters(buildUponParameters().clearSelectionOverride(i4, trackGroupArray));
    }

    @Deprecated
    public final void clearSelectionOverrides(int i4) {
        setParameters(buildUponParameters().clearSelectionOverrides(i4));
    }

    public Parameters getParameters() {
        return this.parametersReference.get();
    }

    @Deprecated
    public final boolean getRendererDisabled(int i4) {
        return getParameters().getRendererDisabled(i4);
    }

    @Deprecated
    @Nullable
    public final SelectionOverride getSelectionOverride(int i4, TrackGroupArray trackGroupArray) {
        return getParameters().getSelectionOverride(i4, trackGroupArray);
    }

    @Deprecated
    public final boolean hasSelectionOverride(int i4, TrackGroupArray trackGroupArray) {
        return getParameters().hasSelectionOverride(i4, trackGroupArray);
    }

    /* access modifiers changed from: protected */
    public TrackSelection[] selectAllTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2, Parameters parameters) throws ExoPlaybackException {
        TrackSelection.Factory factory;
        MappingTrackSelector.MappedTrackInfo mappedTrackInfo2 = mappedTrackInfo;
        int rendererCount = mappedTrackInfo2.getRendererCount();
        TrackSelection[] trackSelectionArr = new TrackSelection[rendererCount];
        boolean z4 = false;
        int i4 = 0;
        boolean z5 = false;
        while (true) {
            boolean z6 = true;
            if (i4 >= rendererCount) {
                break;
            }
            if (2 == mappedTrackInfo2.getRendererType(i4)) {
                if (!z4) {
                    TrackSelection selectVideoTrack = selectVideoTrack(mappedTrackInfo2.getTrackGroups(i4), iArr[i4], iArr2[i4], parameters, this.adaptiveTrackSelectionFactory);
                    trackSelectionArr[i4] = selectVideoTrack;
                    if (selectVideoTrack != null) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                } else {
                    Parameters parameters2 = parameters;
                }
                if (mappedTrackInfo2.getTrackGroups(i4).length <= 0) {
                    z6 = false;
                }
                z5 |= z6;
            } else {
                Parameters parameters3 = parameters;
            }
            i4++;
        }
        boolean z7 = false;
        int i5 = 0;
        boolean z8 = false;
        while (true) {
            Parameters parameters4 = parameters;
            if (i5 >= rendererCount) {
                return trackSelectionArr;
            }
            int rendererType = mappedTrackInfo2.getRendererType(i5);
            if (rendererType != 1) {
                if (rendererType != 2) {
                    if (rendererType != 3) {
                        trackSelectionArr[i5] = selectOtherTrack(rendererType, mappedTrackInfo2.getTrackGroups(i5), iArr[i5], parameters4);
                    } else if (!z8) {
                        TrackSelection selectTextTrack = selectTextTrack(mappedTrackInfo2.getTrackGroups(i5), iArr[i5], parameters4);
                        trackSelectionArr[i5] = selectTextTrack;
                        if (selectTextTrack != null) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                    }
                }
            } else if (!z7) {
                TrackGroupArray trackGroups = mappedTrackInfo2.getTrackGroups(i5);
                int[][] iArr3 = iArr[i5];
                int i6 = iArr2[i5];
                if (z5) {
                    factory = null;
                } else {
                    factory = this.adaptiveTrackSelectionFactory;
                }
                TrackSelection selectAudioTrack = selectAudioTrack(trackGroups, iArr3, i6, parameters4, factory);
                trackSelectionArr[i5] = selectAudioTrack;
                if (selectAudioTrack != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            i5++;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public TrackSelection selectAudioTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i4, Parameters parameters, @Nullable TrackSelection.Factory factory) throws ExoPlaybackException {
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        TrackSelection.Factory factory2 = factory;
        AudioTrackScore audioTrackScore = null;
        int i5 = -1;
        int i6 = -1;
        for (int i7 = 0; i7 < trackGroupArray2.length; i7++) {
            TrackGroup trackGroup = trackGroupArray2.get(i7);
            int[] iArr2 = iArr[i7];
            for (int i8 = 0; i8 < trackGroup.length; i8++) {
                if (isSupported(iArr2[i8], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    AudioTrackScore audioTrackScore2 = new AudioTrackScore(trackGroup.getFormat(i8), parameters2, iArr2[i8]);
                    if (audioTrackScore == null || audioTrackScore2.compareTo(audioTrackScore) > 0) {
                        i5 = i7;
                        i6 = i8;
                        audioTrackScore = audioTrackScore2;
                    }
                }
            }
        }
        if (i5 == -1) {
            return null;
        }
        TrackGroup trackGroup2 = trackGroupArray2.get(i5);
        if (!parameters2.forceLowestBitrate && factory2 != null) {
            int[] adaptiveAudioTracks = getAdaptiveAudioTracks(trackGroup2, iArr[i5], parameters2.allowMixedMimeAdaptiveness);
            if (adaptiveAudioTracks.length > 0) {
                return factory2.createTrackSelection(trackGroup2, adaptiveAudioTracks);
            }
        }
        return new FixedTrackSelection(trackGroup2, i6);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public TrackSelection selectOtherTrack(int i4, TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        TrackGroup trackGroup = null;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < trackGroupArray.length; i7++) {
            TrackGroup trackGroup2 = trackGroupArray.get(i7);
            int[] iArr2 = iArr[i7];
            for (int i8 = 0; i8 < trackGroup2.length; i8++) {
                if (isSupported(iArr2[i8], parameters.exceedRendererCapabilitiesIfNecessary)) {
                    int i9 = 1;
                    if ((trackGroup2.getFormat(i8).selectionFlags & 1) != 0) {
                        i9 = 2;
                    }
                    if (isSupported(iArr2[i8], false)) {
                        i9 += 1000;
                    }
                    if (i9 > i6) {
                        trackGroup = trackGroup2;
                        i5 = i8;
                        i6 = i9;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i5);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public TrackSelection selectTextTrack(TrackGroupArray trackGroupArray, int[][] iArr, Parameters parameters) throws ExoPlaybackException {
        boolean z4;
        boolean z5;
        int i4;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        Parameters parameters2 = parameters;
        TrackGroup trackGroup = null;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < trackGroupArray2.length; i7++) {
            TrackGroup trackGroup2 = trackGroupArray2.get(i7);
            int[] iArr2 = iArr[i7];
            for (int i8 = 0; i8 < trackGroup2.length; i8++) {
                if (isSupported(iArr2[i8], parameters2.exceedRendererCapabilitiesIfNecessary)) {
                    Format format = trackGroup2.getFormat(i8);
                    int i9 = format.selectionFlags & (~parameters2.disabledTextTrackSelectionFlags);
                    int i10 = 1;
                    if ((i9 & 1) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if ((i9 & 2) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    boolean formatHasLanguage = formatHasLanguage(format, parameters2.preferredTextLanguage);
                    if (formatHasLanguage || (parameters2.selectUndeterminedTextLanguage && formatHasNoLanguage(format))) {
                        if (z4) {
                            i4 = 8;
                        } else if (!z5) {
                            i4 = 6;
                        } else {
                            i4 = 4;
                        }
                        i10 = i4 + (formatHasLanguage ? 1 : 0);
                    } else if (z4) {
                        i10 = 3;
                    } else if (z5) {
                        if (formatHasLanguage(format, parameters2.preferredAudioLanguage)) {
                            i10 = 2;
                        }
                    }
                    if (isSupported(iArr2[i8], false)) {
                        i10 += 1000;
                    }
                    if (i10 > i6) {
                        trackGroup = trackGroup2;
                        i5 = i8;
                        i6 = i10;
                    }
                }
            }
        }
        if (trackGroup == null) {
            return null;
        }
        return new FixedTrackSelection(trackGroup, i5);
    }

    /* access modifiers changed from: protected */
    public final Pair<RendererConfiguration[], TrackSelection[]> selectTracks(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int[][][] iArr, int[] iArr2) throws ExoPlaybackException {
        RendererConfiguration rendererConfiguration;
        Parameters parameters = this.parametersReference.get();
        int rendererCount = mappedTrackInfo.getRendererCount();
        TrackSelection[] selectAllTracks = selectAllTracks(mappedTrackInfo, iArr, iArr2, parameters);
        for (int i4 = 0; i4 < rendererCount; i4++) {
            if (parameters.getRendererDisabled(i4)) {
                selectAllTracks[i4] = null;
            } else {
                TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i4);
                if (parameters.hasSelectionOverride(i4, trackGroups)) {
                    SelectionOverride selectionOverride = parameters.getSelectionOverride(i4, trackGroups);
                    if (selectionOverride == null) {
                        selectAllTracks[i4] = null;
                    } else if (selectionOverride.length == 1) {
                        selectAllTracks[i4] = new FixedTrackSelection(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks[0]);
                    } else {
                        selectAllTracks[i4] = ((TrackSelection.Factory) Assertions.checkNotNull(this.adaptiveTrackSelectionFactory)).createTrackSelection(trackGroups.get(selectionOverride.groupIndex), selectionOverride.tracks);
                    }
                }
            }
        }
        RendererConfiguration[] rendererConfigurationArr = new RendererConfiguration[rendererCount];
        for (int i5 = 0; i5 < rendererCount; i5++) {
            if (parameters.getRendererDisabled(i5) || (mappedTrackInfo.getRendererType(i5) != 5 && selectAllTracks[i5] == null)) {
                rendererConfiguration = null;
            } else {
                rendererConfiguration = RendererConfiguration.DEFAULT;
            }
            rendererConfigurationArr[i5] = rendererConfiguration;
        }
        maybeConfigureRenderersForTunneling(mappedTrackInfo, iArr, rendererConfigurationArr, selectAllTracks, parameters.tunnelingAudioSessionId);
        return Pair.create(rendererConfigurationArr, selectAllTracks);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public TrackSelection selectVideoTrack(TrackGroupArray trackGroupArray, int[][] iArr, int i4, Parameters parameters, @Nullable TrackSelection.Factory factory) throws ExoPlaybackException {
        TrackSelection trackSelection;
        if (parameters.forceLowestBitrate || factory == null) {
            trackSelection = null;
        } else {
            trackSelection = selectAdaptiveVideoTrack(trackGroupArray, iArr, i4, parameters, factory);
        }
        if (trackSelection == null) {
            return selectFixedVideoTrack(trackGroupArray, iArr, parameters);
        }
        return trackSelection;
    }

    public void setParameters(Parameters parameters) {
        Assertions.checkNotNull(parameters);
        if (!this.parametersReference.getAndSet(parameters).equals(parameters)) {
            invalidate();
        }
    }

    @Deprecated
    public final void setRendererDisabled(int i4, boolean z4) {
        setParameters(buildUponParameters().setRendererDisabled(i4, z4));
    }

    @Deprecated
    public final void setSelectionOverride(int i4, TrackGroupArray trackGroupArray, SelectionOverride selectionOverride) {
        setParameters(buildUponParameters().setSelectionOverride(i4, trackGroupArray, selectionOverride));
    }

    @Deprecated
    public void setTunnelingAudioSessionId(int i4) {
        setParameters(buildUponParameters().setTunnelingAudioSessionId(i4));
    }

    public DefaultTrackSelector(BandwidthMeter bandwidthMeter) {
        this((TrackSelection.Factory) new AdaptiveTrackSelection.Factory(bandwidthMeter));
    }

    @Deprecated
    public final void clearSelectionOverrides() {
        setParameters(buildUponParameters().clearSelectionOverrides());
    }

    public DefaultTrackSelector(@Nullable TrackSelection.Factory factory) {
        this.adaptiveTrackSelectionFactory = factory;
        this.parametersReference = new AtomicReference<>(Parameters.DEFAULT);
    }

    public void setParameters(ParametersBuilder parametersBuilder) {
        setParameters(parametersBuilder.build());
    }

    public static final class SelectionOverride implements Parcelable {
        public static final Parcelable.Creator<SelectionOverride> CREATOR = new Parcelable.Creator<SelectionOverride>() {
            public final SelectionOverride createFromParcel(Parcel parcel) {
                return new SelectionOverride(parcel);
            }

            public final SelectionOverride[] newArray(int i4) {
                return new SelectionOverride[i4];
            }
        };
        public final int groupIndex;
        public final int length;
        public final int[] tracks;

        public SelectionOverride(int i4, int... iArr) {
            this.groupIndex = i4;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.tracks = copyOf;
            this.length = iArr.length;
            Arrays.sort(copyOf);
        }

        public final boolean containsTrack(int i4) {
            for (int i5 : this.tracks) {
                if (i5 == i4) {
                    return true;
                }
            }
            return false;
        }

        public final int describeContents() {
            return 0;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && SelectionOverride.class == obj.getClass()) {
                SelectionOverride selectionOverride = (SelectionOverride) obj;
                if (this.groupIndex != selectionOverride.groupIndex || !Arrays.equals(this.tracks, selectionOverride.tracks)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.groupIndex * 31) + Arrays.hashCode(this.tracks);
        }

        public final void writeToParcel(Parcel parcel, int i4) {
            parcel.writeInt(this.groupIndex);
            parcel.writeInt(this.tracks.length);
            parcel.writeIntArray(this.tracks);
        }

        SelectionOverride(Parcel parcel) {
            this.groupIndex = parcel.readInt();
            int readByte = parcel.readByte();
            this.length = readByte;
            int[] iArr = new int[readByte];
            this.tracks = iArr;
            parcel.readIntArray(iArr);
        }
    }
}
