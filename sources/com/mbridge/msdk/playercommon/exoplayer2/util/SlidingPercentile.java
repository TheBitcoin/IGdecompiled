package com.mbridge.msdk.playercommon.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SlidingPercentile {
    private static final Comparator<Sample> INDEX_COMPARATOR = new Comparator<Sample>() {
        public final int compare(Sample sample, Sample sample2) {
            return sample.index - sample2.index;
        }
    };
    private static final int MAX_RECYCLED_SAMPLES = 5;
    private static final int SORT_ORDER_BY_INDEX = 1;
    private static final int SORT_ORDER_BY_VALUE = 0;
    private static final int SORT_ORDER_NONE = -1;
    private static final Comparator<Sample> VALUE_COMPARATOR = new Comparator<Sample>() {
        public final int compare(Sample sample, Sample sample2) {
            float f4 = sample.value;
            float f5 = sample2.value;
            if (f4 < f5) {
                return -1;
            }
            return f5 < f4 ? 1 : 0;
        }
    };
    private int currentSortOrder = -1;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private final Sample[] recycledSamples = new Sample[5];
    private final ArrayList<Sample> samples = new ArrayList<>();
    private int totalWeight;

    private static class Sample {
        public int index;
        public float value;
        public int weight;

        private Sample() {
        }
    }

    public SlidingPercentile(int i4) {
        this.maxWeight = i4;
    }

    private void ensureSortedByIndex() {
        if (this.currentSortOrder != 1) {
            Collections.sort(this.samples, INDEX_COMPARATOR);
            this.currentSortOrder = 1;
        }
    }

    private void ensureSortedByValue() {
        if (this.currentSortOrder != 0) {
            Collections.sort(this.samples, VALUE_COMPARATOR);
            this.currentSortOrder = 0;
        }
    }

    public void addSample(int i4, float f4) {
        Sample sample;
        ensureSortedByIndex();
        int i5 = this.recycledSampleCount;
        if (i5 > 0) {
            Sample[] sampleArr = this.recycledSamples;
            int i6 = i5 - 1;
            this.recycledSampleCount = i6;
            sample = sampleArr[i6];
        } else {
            sample = new Sample();
        }
        int i7 = this.nextSampleIndex;
        this.nextSampleIndex = i7 + 1;
        sample.index = i7;
        sample.weight = i4;
        sample.value = f4;
        this.samples.add(sample);
        this.totalWeight += i4;
        while (true) {
            int i8 = this.totalWeight;
            int i9 = this.maxWeight;
            if (i8 > i9) {
                int i10 = i8 - i9;
                Sample sample2 = this.samples.get(0);
                int i11 = sample2.weight;
                if (i11 <= i10) {
                    this.totalWeight -= i11;
                    this.samples.remove(0);
                    int i12 = this.recycledSampleCount;
                    if (i12 < 5) {
                        Sample[] sampleArr2 = this.recycledSamples;
                        this.recycledSampleCount = i12 + 1;
                        sampleArr2[i12] = sample2;
                    }
                } else {
                    sample2.weight = i11 - i10;
                    this.totalWeight -= i10;
                }
            } else {
                return;
            }
        }
    }

    public float getPercentile(float f4) {
        ensureSortedByValue();
        float f5 = f4 * ((float) this.totalWeight);
        int i4 = 0;
        for (int i5 = 0; i5 < this.samples.size(); i5++) {
            Sample sample = this.samples.get(i5);
            i4 += sample.weight;
            if (((float) i4) >= f5) {
                return sample.value;
            }
        }
        if (this.samples.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<Sample> arrayList = this.samples;
        return arrayList.get(arrayList.size() - 1).value;
    }
}
