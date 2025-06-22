package com.mbridge.msdk.playercommon.exoplayer2.source.ads;

import android.net.Uri;
import androidx.annotation.CheckResult;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public final class AdPlaybackState {
    public static final int AD_STATE_AVAILABLE = 1;
    public static final int AD_STATE_ERROR = 4;
    public static final int AD_STATE_PLAYED = 3;
    public static final int AD_STATE_SKIPPED = 2;
    public static final int AD_STATE_UNAVAILABLE = 0;
    public static final AdPlaybackState NONE = new AdPlaybackState(new long[0]);
    public final int adGroupCount;
    public final long[] adGroupTimesUs;
    public final AdGroup[] adGroups;
    public final long adResumePositionUs;
    public final long contentDurationUs;

    public static final class AdGroup {
        public final int count;
        public final long[] durationsUs;
        public final int[] states;
        public final Uri[] uris;

        public AdGroup() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        @CheckResult
        private static long[] copyDurationsUsWithSpaceForAdCount(long[] jArr, int i4) {
            int length = jArr.length;
            int max = Math.max(i4, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, C.TIME_UNSET);
            return copyOf;
        }

        @CheckResult
        private static int[] copyStatesWithSpaceForAdCount(int[] iArr, int i4) {
            int length = iArr.length;
            int max = Math.max(i4, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        public final int getFirstAdIndexToPlay() {
            return getNextAdIndexToPlay(-1);
        }

        public final int getNextAdIndexToPlay(int i4) {
            int i5;
            int i6 = i4 + 1;
            while (true) {
                int[] iArr = this.states;
                if (i6 >= iArr.length || (i5 = iArr[i6]) == 0 || i5 == 1) {
                    return i6;
                }
                i6++;
            }
            return i6;
        }

        public final boolean hasUnplayedAds() {
            if (this.count == -1 || getFirstAdIndexToPlay() < this.count) {
                return true;
            }
            return false;
        }

        @CheckResult
        public final AdGroup withAdCount(int i4) {
            boolean z4;
            if (this.count != -1 || this.states.length > i4) {
                z4 = false;
            } else {
                z4 = true;
            }
            Assertions.checkArgument(z4);
            return new AdGroup(i4, copyStatesWithSpaceForAdCount(this.states, i4), (Uri[]) Arrays.copyOf(this.uris, i4), copyDurationsUsWithSpaceForAdCount(this.durationsUs, i4));
        }

        @CheckResult
        public final AdGroup withAdDurationsUs(long[] jArr) {
            boolean z4;
            if (this.count == -1 || jArr.length <= this.uris.length) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4);
            int length = jArr.length;
            Uri[] uriArr = this.uris;
            if (length < uriArr.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, uriArr.length);
            }
            return new AdGroup(this.count, this.states, this.uris, jArr);
        }

        @CheckResult
        public final AdGroup withAdState(int i4, int i5) {
            boolean z4;
            int i6 = this.count;
            boolean z5 = false;
            if (i6 == -1 || i5 < i6) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4);
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i5 + 1);
            int i7 = copyStatesWithSpaceForAdCount[i5];
            if (i7 == 0 || i7 == 1 || i7 == i4) {
                z5 = true;
            }
            Assertions.checkArgument(z5);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyStatesWithSpaceForAdCount.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, copyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = this.uris;
            if (uriArr.length != copyStatesWithSpaceForAdCount.length) {
                uriArr = (Uri[]) Arrays.copyOf(uriArr, copyStatesWithSpaceForAdCount.length);
            }
            copyStatesWithSpaceForAdCount[i5] = i4;
            return new AdGroup(this.count, copyStatesWithSpaceForAdCount, uriArr, jArr);
        }

        @CheckResult
        public final AdGroup withAdUri(Uri uri, int i4) {
            boolean z4;
            int i5 = this.count;
            boolean z5 = false;
            if (i5 == -1 || i4 < i5) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assertions.checkArgument(z4);
            int[] copyStatesWithSpaceForAdCount = copyStatesWithSpaceForAdCount(this.states, i4 + 1);
            if (copyStatesWithSpaceForAdCount[i4] == 0) {
                z5 = true;
            }
            Assertions.checkArgument(z5);
            long[] jArr = this.durationsUs;
            if (jArr.length != copyStatesWithSpaceForAdCount.length) {
                jArr = copyDurationsUsWithSpaceForAdCount(jArr, copyStatesWithSpaceForAdCount.length);
            }
            Uri[] uriArr = (Uri[]) Arrays.copyOf(this.uris, copyStatesWithSpaceForAdCount.length);
            uriArr[i4] = uri;
            copyStatesWithSpaceForAdCount[i4] = 1;
            return new AdGroup(this.count, copyStatesWithSpaceForAdCount, uriArr, jArr);
        }

        @CheckResult
        public final AdGroup withAllAdsSkipped() {
            if (this.count == -1) {
                return new AdGroup(0, new int[0], new Uri[0], new long[0]);
            }
            int[] iArr = this.states;
            int length = iArr.length;
            int[] copyOf = Arrays.copyOf(iArr, length);
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = copyOf[i4];
                if (i5 == 1 || i5 == 0) {
                    copyOf[i4] = 2;
                }
            }
            return new AdGroup(length, copyOf, this.uris, this.durationsUs);
        }

        private AdGroup(int i4, int[] iArr, Uri[] uriArr, long[] jArr) {
            Assertions.checkArgument(iArr.length == uriArr.length);
            this.count = i4;
            this.states = iArr;
            this.uris = uriArr;
            this.durationsUs = jArr;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdState {
    }

    public AdPlaybackState(long... jArr) {
        int length = jArr.length;
        this.adGroupCount = length;
        this.adGroupTimesUs = Arrays.copyOf(jArr, length);
        this.adGroups = new AdGroup[length];
        for (int i4 = 0; i4 < length; i4++) {
            this.adGroups[i4] = new AdGroup();
        }
        this.adResumePositionUs = 0;
        this.contentDurationUs = C.TIME_UNSET;
    }

    public final int getAdGroupIndexAfterPositionUs(long j4) {
        int i4 = 0;
        while (true) {
            long[] jArr = this.adGroupTimesUs;
            if (i4 >= jArr.length) {
                break;
            }
            long j5 = jArr[i4];
            if (j5 == Long.MIN_VALUE || (j4 < j5 && this.adGroups[i4].hasUnplayedAds())) {
                break;
            }
            i4++;
        }
        if (i4 < this.adGroupTimesUs.length) {
            return i4;
        }
        return -1;
    }

    public final int getAdGroupIndexForPositionUs(long j4) {
        int length = this.adGroupTimesUs.length - 1;
        while (length >= 0) {
            long j5 = this.adGroupTimesUs[length];
            if (j5 != Long.MIN_VALUE && j5 <= j4) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.adGroups[length].hasUnplayedAds()) {
            return -1;
        }
        return length;
    }

    @CheckResult
    public final AdPlaybackState withAdCount(int i4, int i5) {
        boolean z4;
        if (i5 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        AdGroup[] adGroupArr = this.adGroups;
        if (adGroupArr[i4].count == i5) {
            return this;
        }
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = this.adGroups[i4].withAdCount(i5);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withAdDurationsUs(long[][] jArr) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        for (int i4 = 0; i4 < this.adGroupCount; i4++) {
            adGroupArr2[i4] = adGroupArr2[i4].withAdDurationsUs(jArr[i4]);
        }
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withAdLoadError(int i4, int i5) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].withAdState(4, i5);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withAdResumePositionUs(long j4) {
        if (this.adResumePositionUs == j4) {
            return this;
        }
        return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, j4, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withAdUri(int i4, int i5, Uri uri) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].withAdUri(uri, i5);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withContentDurationUs(long j4) {
        if (this.contentDurationUs == j4) {
            return this;
        }
        return new AdPlaybackState(this.adGroupTimesUs, this.adGroups, this.adResumePositionUs, j4);
    }

    @CheckResult
    public final AdPlaybackState withPlayedAd(int i4, int i5) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].withAdState(3, i5);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withSkippedAd(int i4, int i5) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].withAdState(2, i5);
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    @CheckResult
    public final AdPlaybackState withSkippedAdGroup(int i4) {
        AdGroup[] adGroupArr = this.adGroups;
        AdGroup[] adGroupArr2 = (AdGroup[]) Arrays.copyOf(adGroupArr, adGroupArr.length);
        adGroupArr2[i4] = adGroupArr2[i4].withAllAdsSkipped();
        return new AdPlaybackState(this.adGroupTimesUs, adGroupArr2, this.adResumePositionUs, this.contentDurationUs);
    }

    private AdPlaybackState(long[] jArr, AdGroup[] adGroupArr, long j4, long j5) {
        this.adGroupCount = adGroupArr.length;
        this.adGroupTimesUs = jArr;
        this.adGroups = adGroupArr;
        this.adResumePositionUs = j4;
        this.contentDurationUs = j5;
    }
}
