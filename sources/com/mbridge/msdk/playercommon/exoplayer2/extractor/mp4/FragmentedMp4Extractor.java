package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.ParserException;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ChunkIndex;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorsFactory;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.PositionHolder;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.Atom;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.PsExtractor;
import com.mbridge.msdk.playercommon.exoplayer2.text.cea.CeaUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.TimestampAdjuster;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import j$.util.DesugarCollections;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class FragmentedMp4Extractor implements Extractor {
    private static final Format EMSG_FORMAT = Format.createSampleFormat((String) null, MimeTypes.APPLICATION_EMSG, Long.MAX_VALUE);
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() {
        public final Extractor[] createExtractors() {
            return new Extractor[]{new FragmentedMp4Extractor()};
        }
    };
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    private static final int FLAG_SIDELOADED = 8;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final int SAMPLE_GROUP_TYPE_seig = Util.getIntegerCodeForString("seig");
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final String TAG = "FragmentedMp4Extractor";
    @Nullable
    private final TrackOutput additionalEmsgTrackOutput;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private TrackOutput[] cea608TrackOutputs;
    private final List<Format> closedCaptionFormats;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private TrackBundle currentTrackBundle;
    private long durationUs;
    private TrackOutput[] emsgTrackOutputs;
    private long endOfMdatPosition;
    private final byte[] extendedTypeScratch;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalBuffer;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final ArrayDeque<MetadataSampleInfo> pendingMetadataSampleInfos;
    private long pendingSeekTimeUs;
    private boolean processSeiNalUnitPayload;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private long segmentIndexEarliestPresentationTimeUs;
    @Nullable
    private final DrmInitData sideloadedDrmInitData;
    @Nullable
    private final Track sideloadedTrack;
    @Nullable
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray<TrackBundle> trackBundles;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static final class MetadataSampleInfo {
        public final long presentationTimeDeltaUs;
        public final int size;

        public MetadataSampleInfo(long j4, int i4) {
            this.presentationTimeDeltaUs = j4;
            this.size = i4;
        }
    }

    private static final class TrackBundle {
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        private final ParsableByteArray defaultInitializationVector = new ParsableByteArray();
        public DefaultSampleValues defaultSampleValues;
        private final ParsableByteArray encryptionSignalByte = new ParsableByteArray(1);
        public int firstSampleToOutputIndex;
        public final TrackFragment fragment = new TrackFragment();
        public final TrackOutput output;
        public Track track;

        public TrackBundle(TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        private TrackEncryptionBox getEncryptionBox() {
            TrackFragment trackFragment = this.fragment;
            int i4 = trackFragment.header.sampleDescriptionIndex;
            TrackEncryptionBox trackEncryptionBox = trackFragment.trackEncryptionBox;
            if (trackEncryptionBox != null) {
                return trackEncryptionBox;
            }
            return this.track.getSampleDescriptionEncryptionBox(i4);
        }

        /* access modifiers changed from: private */
        public void skipSampleEncryptionData() {
            TrackFragment trackFragment = this.fragment;
            if (trackFragment.definesEncryptionData) {
                ParsableByteArray parsableByteArray = trackFragment.sampleEncryptionData;
                int i4 = getEncryptionBox().initializationVectorSize;
                if (i4 != 0) {
                    parsableByteArray.skipBytes(i4);
                }
                if (this.fragment.sampleHasSubsampleEncryptionTable[this.currentSampleIndex]) {
                    parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort() * 6);
                }
            }
        }

        public final void init(Track track2, DefaultSampleValues defaultSampleValues2) {
            this.track = (Track) Assertions.checkNotNull(track2);
            this.defaultSampleValues = (DefaultSampleValues) Assertions.checkNotNull(defaultSampleValues2);
            this.output.format(track2.format);
            reset();
        }

        public final boolean next() {
            this.currentSampleIndex++;
            int i4 = this.currentSampleInTrackRun + 1;
            this.currentSampleInTrackRun = i4;
            int[] iArr = this.fragment.trunLength;
            int i5 = this.currentTrackRunIndex;
            if (i4 != iArr[i5]) {
                return true;
            }
            this.currentTrackRunIndex = i5 + 1;
            this.currentSampleInTrackRun = 0;
            return false;
        }

        public final int outputSampleEncryptionData() {
            ParsableByteArray parsableByteArray;
            int i4;
            if (!this.fragment.definesEncryptionData) {
                return 0;
            }
            TrackEncryptionBox encryptionBox = getEncryptionBox();
            int i5 = encryptionBox.initializationVectorSize;
            if (i5 != 0) {
                parsableByteArray = this.fragment.sampleEncryptionData;
            } else {
                byte[] bArr = encryptionBox.defaultInitializationVector;
                this.defaultInitializationVector.reset(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.defaultInitializationVector;
                i5 = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean z4 = this.fragment.sampleHasSubsampleEncryptionTable[this.currentSampleIndex];
            ParsableByteArray parsableByteArray3 = this.encryptionSignalByte;
            byte[] bArr2 = parsableByteArray3.data;
            if (z4) {
                i4 = 128;
            } else {
                i4 = 0;
            }
            bArr2[0] = (byte) (i4 | i5);
            parsableByteArray3.setPosition(0);
            this.output.sampleData(this.encryptionSignalByte, 1);
            this.output.sampleData(parsableByteArray, i5);
            if (!z4) {
                return i5 + 1;
            }
            ParsableByteArray parsableByteArray4 = this.fragment.sampleEncryptionData;
            int readUnsignedShort = parsableByteArray4.readUnsignedShort();
            parsableByteArray4.skipBytes(-2);
            int i6 = (readUnsignedShort * 6) + 2;
            this.output.sampleData(parsableByteArray4, i6);
            return i5 + 1 + i6;
        }

        public final void reset() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
            this.firstSampleToOutputIndex = 0;
        }

        public final void seek(long j4) {
            long usToMs = C.usToMs(j4);
            int i4 = this.currentSampleIndex;
            while (true) {
                TrackFragment trackFragment = this.fragment;
                if (i4 < trackFragment.sampleCount && trackFragment.getSamplePresentationTime(i4) < usToMs) {
                    if (this.fragment.sampleIsSyncFrameTable[i4]) {
                        this.firstSampleToOutputIndex = i4;
                    }
                    i4++;
                } else {
                    return;
                }
            }
        }

        public final void updateDrmInitData(DrmInitData drmInitData) {
            String str;
            TrackEncryptionBox sampleDescriptionEncryptionBox = this.track.getSampleDescriptionEncryptionBox(this.fragment.header.sampleDescriptionIndex);
            if (sampleDescriptionEncryptionBox != null) {
                str = sampleDescriptionEncryptionBox.schemeType;
            } else {
                str = null;
            }
            this.output.format(this.track.format.copyWithDrmInitData(drmInitData.copyWithSchemeType(str)));
        }
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private DefaultSampleValues getDefaultSampleValues(SparseArray<DefaultSampleValues> sparseArray, int i4) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (DefaultSampleValues) Assertions.checkNotNull(sparseArray.get(i4));
    }

    private static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < size; i4++) {
            Atom.LeafAtom leafAtom = list.get(i4);
            if (leafAtom.type == Atom.TYPE_pssh) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = leafAtom.data.data;
                UUID parseUuid = PsshAtomUtil.parseUuid(bArr);
                if (parseUuid == null) {
                    Log.w(TAG, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(parseUuid, MimeTypes.VIDEO_MP4, bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData((List<DrmInitData.SchemeData>) arrayList);
    }

    private static TrackBundle getNextFragmentRun(SparseArray<TrackBundle> sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j4 = Long.MAX_VALUE;
        for (int i4 = 0; i4 < size; i4++) {
            TrackBundle valueAt = sparseArray.valueAt(i4);
            int i5 = valueAt.currentTrackRunIndex;
            TrackFragment trackFragment = valueAt.fragment;
            if (i5 != trackFragment.trunCount) {
                long j5 = trackFragment.trunDataPosition[i5];
                if (j5 < j4) {
                    trackBundle = valueAt;
                    j4 = j5;
                }
            }
        }
        return trackBundle;
    }

    @Nullable
    private static TrackBundle getTrackBundle(SparseArray<TrackBundle> sparseArray, int i4) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i4);
    }

    private void maybeInitExtraTracks() {
        int i4;
        if (this.emsgTrackOutputs == null) {
            TrackOutput[] trackOutputArr = new TrackOutput[2];
            this.emsgTrackOutputs = trackOutputArr;
            TrackOutput trackOutput = this.additionalEmsgTrackOutput;
            if (trackOutput != null) {
                trackOutputArr[0] = trackOutput;
                i4 = 1;
            } else {
                i4 = 0;
            }
            if ((this.flags & 4) != 0) {
                trackOutputArr[i4] = this.extractorOutput.track(this.trackBundles.size(), 4);
                i4++;
            }
            TrackOutput[] trackOutputArr2 = (TrackOutput[]) Arrays.copyOf(this.emsgTrackOutputs, i4);
            this.emsgTrackOutputs = trackOutputArr2;
            for (TrackOutput format : trackOutputArr2) {
                format.format(EMSG_FORMAT);
            }
        }
        if (this.cea608TrackOutputs == null) {
            this.cea608TrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
            for (int i5 = 0; i5 < this.cea608TrackOutputs.length; i5++) {
                TrackOutput track = this.extractorOutput.track(this.trackBundles.size() + 1 + i5, 3);
                track.format(this.closedCaptionFormats.get(i5));
                this.cea608TrackOutputs[i5] = track;
            }
        }
    }

    private void onContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        int i4 = containerAtom.type;
        if (i4 == Atom.TYPE_moov) {
            onMoovContainerAtomRead(containerAtom);
        } else if (i4 == Atom.TYPE_moof) {
            onMoofContainerAtomRead(containerAtom);
        } else if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(containerAtom);
        }
    }

    private void onEmsgLeafAtomRead(ParsableByteArray parsableByteArray) {
        TrackOutput[] trackOutputArr = this.emsgTrackOutputs;
        if (trackOutputArr != null && trackOutputArr.length != 0) {
            parsableByteArray.setPosition(12);
            int bytesLeft = parsableByteArray.bytesLeft();
            parsableByteArray.readNullTerminatedString();
            parsableByteArray.readNullTerminatedString();
            long scaleLargeTimestamp = Util.scaleLargeTimestamp(parsableByteArray.readUnsignedInt(), 1000000, parsableByteArray.readUnsignedInt());
            for (TrackOutput sampleData : this.emsgTrackOutputs) {
                parsableByteArray.setPosition(12);
                sampleData.sampleData(parsableByteArray, bytesLeft);
            }
            long j4 = this.segmentIndexEarliestPresentationTimeUs;
            if (j4 != C.TIME_UNSET) {
                long j5 = j4 + scaleLargeTimestamp;
                TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
                if (timestampAdjuster2 != null) {
                    j5 = timestampAdjuster2.adjustSampleTimestamp(j5);
                }
                long j6 = j5;
                for (TrackOutput sampleMetadata : this.emsgTrackOutputs) {
                    sampleMetadata.sampleMetadata(j6, 1, bytesLeft, 0, (TrackOutput.CryptoData) null);
                }
                return;
            }
            this.pendingMetadataSampleInfos.addLast(new MetadataSampleInfo(scaleLargeTimestamp, bytesLeft));
            this.pendingMetadataSampleBytes += bytesLeft;
        }
    }

    private void onLeafAtomRead(Atom.LeafAtom leafAtom, long j4) throws ParserException {
        if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(leafAtom);
            return;
        }
        int i4 = leafAtom.type;
        if (i4 == Atom.TYPE_sidx) {
            Pair<Long, ChunkIndex> parseSidx = parseSidx(leafAtom.data, j4);
            this.segmentIndexEarliestPresentationTimeUs = ((Long) parseSidx.first).longValue();
            this.extractorOutput.seekMap((SeekMap) parseSidx.second);
            this.haveOutputSeekMap = true;
        } else if (i4 == Atom.TYPE_emsg) {
            onEmsgLeafAtomRead(leafAtom.data);
        }
    }

    private void onMoofContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        DrmInitData drmInitData;
        parseMoof(containerAtom, this.trackBundles, this.flags, this.extendedTypeScratch);
        if (this.sideloadedDrmInitData != null) {
            drmInitData = null;
        } else {
            drmInitData = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        }
        if (drmInitData != null) {
            int size = this.trackBundles.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.trackBundles.valueAt(i4).updateDrmInitData(drmInitData);
            }
        }
        if (this.pendingSeekTimeUs != C.TIME_UNSET) {
            int size2 = this.trackBundles.size();
            for (int i5 = 0; i5 < size2; i5++) {
                this.trackBundles.valueAt(i5).seek(this.pendingSeekTimeUs);
            }
            this.pendingSeekTimeUs = C.TIME_UNSET;
        }
    }

    private void onMoovContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z4;
        boolean z5;
        int i4 = 0;
        boolean z6 = true;
        if (this.sideloadedTrack == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4, "Unexpected moov box.");
        DrmInitData drmInitData = this.sideloadedDrmInitData;
        if (drmInitData == null) {
            drmInitData = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        }
        DrmInitData drmInitData2 = drmInitData;
        Atom.ContainerAtom containerAtomOfType = containerAtom.getContainerAtomOfType(Atom.TYPE_mvex);
        SparseArray sparseArray = new SparseArray();
        int size = containerAtomOfType.leafChildren.size();
        long j4 = -9223372036854775807L;
        for (int i5 = 0; i5 < size; i5++) {
            Atom.LeafAtom leafAtom = containerAtomOfType.leafChildren.get(i5);
            int i6 = leafAtom.type;
            if (i6 == Atom.TYPE_trex) {
                Pair<Integer, DefaultSampleValues> parseTrex = parseTrex(leafAtom.data);
                sparseArray.put(((Integer) parseTrex.first).intValue(), parseTrex.second);
            } else if (i6 == Atom.TYPE_mehd) {
                j4 = parseMehd(leafAtom.data);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = containerAtom.containerChildren.size();
        for (int i7 = 0; i7 < size2; i7++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i7);
            if (containerAtom2.type == Atom.TYPE_trak) {
                Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd);
                if ((this.flags & 16) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Track parseTrak = AtomParsers.parseTrak(containerAtom2, leafAtomOfType, j4, drmInitData2, z5, false);
                if (parseTrak != null) {
                    sparseArray2.put(parseTrak.id, parseTrak);
                }
            }
        }
        int size3 = sparseArray2.size();
        if (this.trackBundles.size() == 0) {
            while (i4 < size3) {
                Track track = (Track) sparseArray2.valueAt(i4);
                TrackBundle trackBundle = new TrackBundle(this.extractorOutput.track(i4, track.type));
                trackBundle.init(track, getDefaultSampleValues(sparseArray, track.id));
                this.trackBundles.put(track.id, trackBundle);
                this.durationUs = Math.max(this.durationUs, track.durationUs);
                i4++;
            }
            maybeInitExtraTracks();
            this.extractorOutput.endTracks();
            return;
        }
        if (this.trackBundles.size() != size3) {
            z6 = false;
        }
        Assertions.checkState(z6);
        while (i4 < size3) {
            Track track2 = (Track) sparseArray2.valueAt(i4);
            this.trackBundles.get(track2.id).init(track2, getDefaultSampleValues(sparseArray, track2.id));
            i4++;
        }
    }

    private void outputPendingMetadataSamples(long j4) {
        while (!this.pendingMetadataSampleInfos.isEmpty()) {
            MetadataSampleInfo removeFirst = this.pendingMetadataSampleInfos.removeFirst();
            this.pendingMetadataSampleBytes -= removeFirst.size;
            long j5 = removeFirst.presentationTimeDeltaUs + j4;
            TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
            if (timestampAdjuster2 != null) {
                j5 = timestampAdjuster2.adjustSampleTimestamp(j5);
            }
            long j6 = j5;
            for (TrackOutput sampleMetadata : this.emsgTrackOutputs) {
                sampleMetadata.sampleMetadata(j6, 1, removeFirst.size, this.pendingMetadataSampleBytes, (TrackOutput.CryptoData) null);
            }
        }
    }

    private static long parseMehd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0) {
            return parsableByteArray.readUnsignedInt();
        }
        return parsableByteArray.readUnsignedLongToLong();
    }

    private static void parseMoof(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i4, byte[] bArr) throws ParserException {
        int size = containerAtom.containerChildren.size();
        for (int i5 = 0; i5 < size; i5++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i5);
            if (containerAtom2.type == Atom.TYPE_traf) {
                parseTraf(containerAtom2, sparseArray, i4, bArr);
            }
        }
    }

    private static void parseSaio(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        long j4;
        parsableByteArray.setPosition(8);
        int readInt = parsableByteArray.readInt();
        if ((Atom.parseFullAtomFlags(readInt) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == 1) {
            int parseFullAtomVersion = Atom.parseFullAtomVersion(readInt);
            long j5 = trackFragment.auxiliaryDataPosition;
            if (parseFullAtomVersion == 0) {
                j4 = parsableByteArray.readUnsignedInt();
            } else {
                j4 = parsableByteArray.readUnsignedLongToLong();
            }
            trackFragment.auxiliaryDataPosition = j5 + j4;
            return;
        }
        throw new ParserException("Unexpected saio entry count: " + readUnsignedIntToInt);
    }

    private static void parseSaiz(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i4;
        boolean z4;
        int i5 = trackEncryptionBox.initializationVectorSize;
        parsableByteArray.setPosition(8);
        boolean z5 = true;
        if ((Atom.parseFullAtomFlags(parsableByteArray.readInt()) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == trackFragment.sampleCount) {
            if (readUnsignedByte == 0) {
                boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
                i4 = 0;
                for (int i6 = 0; i6 < readUnsignedIntToInt; i6++) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    i4 += readUnsignedByte2;
                    if (readUnsignedByte2 > i5) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    zArr[i6] = z4;
                }
            } else {
                if (readUnsignedByte <= i5) {
                    z5 = false;
                }
                i4 = readUnsignedByte * readUnsignedIntToInt;
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z5);
            }
            trackFragment.initEncryptionData(i4);
            return;
        }
        throw new ParserException("Length mismatch: " + readUnsignedIntToInt + ", " + trackFragment.sampleCount);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parseSenc(parsableByteArray, 0, trackFragment);
    }

    private static void parseSgpd(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, String str, TrackFragment trackFragment) throws ParserException {
        boolean z4;
        byte[] bArr;
        ParsableByteArray parsableByteArray3 = parsableByteArray;
        ParsableByteArray parsableByteArray4 = parsableByteArray2;
        TrackFragment trackFragment2 = trackFragment;
        parsableByteArray3.setPosition(8);
        int readInt = parsableByteArray3.readInt();
        int readInt2 = parsableByteArray3.readInt();
        int i4 = SAMPLE_GROUP_TYPE_seig;
        if (readInt2 == i4) {
            if (Atom.parseFullAtomVersion(readInt) == 1) {
                parsableByteArray3.skipBytes(4);
            }
            if (parsableByteArray3.readInt() == 1) {
                parsableByteArray4.setPosition(8);
                int readInt3 = parsableByteArray4.readInt();
                if (parsableByteArray4.readInt() == i4) {
                    int parseFullAtomVersion = Atom.parseFullAtomVersion(readInt3);
                    if (parseFullAtomVersion == 1) {
                        if (parsableByteArray4.readUnsignedInt() == 0) {
                            throw new ParserException("Variable length description in sgpd found (unsupported)");
                        }
                    } else if (parseFullAtomVersion >= 2) {
                        parsableByteArray4.skipBytes(4);
                    }
                    if (parsableByteArray4.readUnsignedInt() == 1) {
                        parsableByteArray4.skipBytes(1);
                        int readUnsignedByte = parsableByteArray4.readUnsignedByte();
                        int i5 = (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                        int i6 = readUnsignedByte & 15;
                        if (parsableByteArray4.readUnsignedByte() == 1) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            int readUnsignedByte2 = parsableByteArray4.readUnsignedByte();
                            byte[] bArr2 = new byte[16];
                            parsableByteArray4.readBytes(bArr2, 0, 16);
                            if (!z4 || readUnsignedByte2 != 0) {
                                bArr = null;
                            } else {
                                int readUnsignedByte3 = parsableByteArray4.readUnsignedByte();
                                bArr = new byte[readUnsignedByte3];
                                parsableByteArray4.readBytes(bArr, 0, readUnsignedByte3);
                            }
                            byte[] bArr3 = bArr;
                            trackFragment2.definesEncryptionData = true;
                            trackFragment2.trackEncryptionBox = new TrackEncryptionBox(z4, str, readUnsignedByte2, bArr2, i5, i6, bArr3);
                            return;
                        }
                        return;
                    }
                    throw new ParserException("Entry count in sgpd != 1 (unsupported).");
                }
                return;
            }
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray parsableByteArray, long j4) throws ParserException {
        long readUnsignedLongToLong;
        long readUnsignedLongToLong2;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray2.readInt());
        parsableByteArray2.skipBytes(4);
        long readUnsignedInt = parsableByteArray2.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            readUnsignedLongToLong = parsableByteArray2.readUnsignedInt();
            readUnsignedLongToLong2 = parsableByteArray2.readUnsignedInt();
        } else {
            readUnsignedLongToLong = parsableByteArray2.readUnsignedLongToLong();
            readUnsignedLongToLong2 = parsableByteArray2.readUnsignedLongToLong();
        }
        long j5 = j4 + readUnsignedLongToLong2;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(readUnsignedLongToLong, 1000000, readUnsignedInt);
        parsableByteArray2.skipBytes(2);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j6 = j5;
        long j7 = scaleLargeTimestamp;
        int i4 = 0;
        while (i4 < readUnsignedShort) {
            int readInt = parsableByteArray2.readInt();
            if ((Integer.MIN_VALUE & readInt) == 0) {
                long readUnsignedInt2 = parsableByteArray2.readUnsignedInt();
                iArr[i4] = readInt & Integer.MAX_VALUE;
                jArr[i4] = j6;
                jArr3[i4] = j7;
                readUnsignedLongToLong += readUnsignedInt2;
                long[] jArr4 = jArr3;
                j7 = Util.scaleLargeTimestamp(readUnsignedLongToLong, 1000000, readUnsignedInt);
                jArr2[i4] = j7 - jArr4[i4];
                parsableByteArray2.skipBytes(4);
                j6 += (long) iArr[i4];
                i4++;
                jArr3 = jArr4;
            } else {
                throw new ParserException("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(scaleLargeTimestamp), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private static long parseTfdt(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 1) {
            return parsableByteArray.readUnsignedLongToLong();
        }
        return parsableByteArray.readUnsignedInt();
    }

    private static TrackBundle parseTfhd(ParsableByteArray parsableByteArray, SparseArray<TrackBundle> sparseArray) {
        int i4;
        int i5;
        int i6;
        int i7;
        parsableByteArray.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        TrackBundle trackBundle = getTrackBundle(sparseArray, parsableByteArray.readInt());
        if (trackBundle == null) {
            return null;
        }
        if ((parseFullAtomFlags & 1) != 0) {
            long readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            TrackFragment trackFragment = trackBundle.fragment;
            trackFragment.dataPosition = readUnsignedLongToLong;
            trackFragment.auxiliaryDataPosition = readUnsignedLongToLong;
        }
        DefaultSampleValues defaultSampleValues = trackBundle.defaultSampleValues;
        if ((parseFullAtomFlags & 2) != 0) {
            i4 = parsableByteArray.readUnsignedIntToInt() - 1;
        } else {
            i4 = defaultSampleValues.sampleDescriptionIndex;
        }
        if ((parseFullAtomFlags & 8) != 0) {
            i5 = parsableByteArray.readUnsignedIntToInt();
        } else {
            i5 = defaultSampleValues.duration;
        }
        if ((parseFullAtomFlags & 16) != 0) {
            i6 = parsableByteArray.readUnsignedIntToInt();
        } else {
            i6 = defaultSampleValues.size;
        }
        if ((parseFullAtomFlags & 32) != 0) {
            i7 = parsableByteArray.readUnsignedIntToInt();
        } else {
            i7 = defaultSampleValues.flags;
        }
        trackBundle.fragment.header = new DefaultSampleValues(i4, i5, i6, i7);
        return trackBundle;
    }

    private static void parseTraf(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i4, byte[] bArr) throws ParserException {
        String str;
        TrackBundle parseTfhd = parseTfhd(containerAtom.getLeafAtomOfType(Atom.TYPE_tfhd).data, sparseArray);
        if (parseTfhd != null) {
            TrackFragment trackFragment = parseTfhd.fragment;
            long j4 = trackFragment.nextFragmentDecodeTime;
            parseTfhd.reset();
            int i5 = Atom.TYPE_tfdt;
            if (containerAtom.getLeafAtomOfType(i5) != null && (i4 & 2) == 0) {
                j4 = parseTfdt(containerAtom.getLeafAtomOfType(i5).data);
            }
            parseTruns(containerAtom, parseTfhd, j4, i4);
            TrackEncryptionBox sampleDescriptionEncryptionBox = parseTfhd.track.getSampleDescriptionEncryptionBox(trackFragment.header.sampleDescriptionIndex);
            Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
            if (leafAtomOfType != null) {
                parseSaiz(sampleDescriptionEncryptionBox, leafAtomOfType.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_saio);
            if (leafAtomOfType2 != null) {
                parseSaio(leafAtomOfType2.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_senc);
            if (leafAtomOfType3 != null) {
                parseSenc(leafAtomOfType3.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_sbgp);
            Atom.LeafAtom leafAtomOfType5 = containerAtom.getLeafAtomOfType(Atom.TYPE_sgpd);
            if (!(leafAtomOfType4 == null || leafAtomOfType5 == null)) {
                ParsableByteArray parsableByteArray = leafAtomOfType4.data;
                ParsableByteArray parsableByteArray2 = leafAtomOfType5.data;
                if (sampleDescriptionEncryptionBox != null) {
                    str = sampleDescriptionEncryptionBox.schemeType;
                } else {
                    str = null;
                }
                parseSgpd(parsableByteArray, parsableByteArray2, str, trackFragment);
            }
            int size = containerAtom.leafChildren.size();
            for (int i6 = 0; i6 < size; i6++) {
                Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i6);
                if (leafAtom.type == Atom.TYPE_uuid) {
                    parseUuid(leafAtom.data, trackFragment, bArr);
                }
            }
        }
    }

    private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return Pair.create(Integer.valueOf(parsableByteArray.readInt()), new DefaultSampleValues(parsableByteArray.readUnsignedIntToInt() - 1, parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readUnsignedIntToInt(), parsableByteArray.readInt()));
    }

    private static int parseTrun(TrackBundle trackBundle, int i4, long j4, int i5, ParsableByteArray parsableByteArray, int i6) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i7;
        boolean z9;
        long j5;
        int i8;
        int i9;
        boolean z10;
        int i10;
        int i11;
        int i12;
        boolean z11;
        TrackBundle trackBundle2 = trackBundle;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray2.readInt());
        Track track = trackBundle2.track;
        TrackFragment trackFragment = trackBundle2.fragment;
        DefaultSampleValues defaultSampleValues = trackFragment.header;
        trackFragment.trunLength[i4] = parsableByteArray2.readUnsignedIntToInt();
        long[] jArr = trackFragment.trunDataPosition;
        long j6 = trackFragment.dataPosition;
        jArr[i4] = j6;
        if ((parseFullAtomFlags & 1) != 0) {
            jArr[i4] = j6 + ((long) parsableByteArray2.readInt());
        }
        if ((parseFullAtomFlags & 4) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        int i13 = defaultSampleValues.flags;
        if (z4) {
            i13 = parsableByteArray2.readUnsignedIntToInt();
        }
        if ((parseFullAtomFlags & 256) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        if ((parseFullAtomFlags & 512) != 0) {
            z6 = true;
        } else {
            z6 = false;
        }
        if ((parseFullAtomFlags & 1024) != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if ((parseFullAtomFlags & 2048) != 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        long[] jArr2 = track.editListDurations;
        long j7 = 0;
        if (jArr2 != null && jArr2.length == 1 && jArr2[0] == 0) {
            i7 = 0;
            j7 = Util.scaleLargeTimestamp(track.editListMediaTimes[0], 1000, track.timescale);
        } else {
            i7 = 0;
        }
        int[] iArr = trackFragment.sampleSizeTable;
        int[] iArr2 = trackFragment.sampleCompositionTimeOffsetTable;
        long[] jArr3 = trackFragment.sampleDecodingTimeTable;
        boolean[] zArr = trackFragment.sampleIsSyncFrameTable;
        boolean z12 = z8;
        if (track.type != 2 || (i5 & 1) == 0) {
            z9 = false;
        } else {
            z9 = true;
        }
        int i14 = i6 + trackFragment.trunLength[i4];
        boolean z13 = z4;
        int[] iArr3 = iArr;
        long j8 = track.timescale;
        if (i4 > 0) {
            j5 = trackFragment.nextFragmentDecodeTime;
        } else {
            j5 = j4;
        }
        int i15 = i6;
        long j9 = j5;
        while (i15 < i14) {
            if (z5) {
                i8 = parsableByteArray.readUnsignedIntToInt();
            } else {
                i8 = defaultSampleValues.duration;
            }
            if (z6) {
                i9 = parsableByteArray.readUnsignedIntToInt();
            } else {
                i9 = defaultSampleValues.size;
            }
            if (i15 == 0 && z13) {
                z10 = z9;
                i10 = i13;
            } else if (z7) {
                z10 = z9;
                i10 = parsableByteArray.readInt();
            } else {
                z10 = z9;
                i10 = defaultSampleValues.flags;
            }
            if (z12) {
                i11 = i10;
                i12 = i14;
                iArr2[i15] = (int) ((((long) parsableByteArray.readInt()) * 1000) / j8);
            } else {
                i11 = i10;
                i12 = i14;
                iArr2[i15] = i7;
            }
            long j10 = j9;
            jArr3[i15] = Util.scaleLargeTimestamp(j9, 1000, j8) - j7;
            iArr3[i15] = i9;
            if (((i11 >> 16) & 1) != 0 || (z10 && i15 != 0)) {
                z11 = false;
            } else {
                z11 = true;
            }
            zArr[i15] = z11;
            j9 = j10 + ((long) i8);
            i15++;
            z9 = z10;
            i14 = i12;
        }
        int i16 = i14;
        trackFragment.nextFragmentDecodeTime = j9;
        return i16;
    }

    private static void parseTruns(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, long j4, int i4) {
        int i5;
        long j5;
        TrackBundle trackBundle2;
        List<Atom.LeafAtom> list = containerAtom.leafChildren;
        int size = list.size();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            Atom.LeafAtom leafAtom = list.get(i9);
            if (leafAtom.type == Atom.TYPE_trun) {
                ParsableByteArray parsableByteArray = leafAtom.data;
                parsableByteArray.setPosition(12);
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (readUnsignedIntToInt > 0) {
                    i8 += readUnsignedIntToInt;
                    i7++;
                }
            }
        }
        trackBundle.currentTrackRunIndex = 0;
        trackBundle.currentSampleInTrackRun = 0;
        trackBundle.currentSampleIndex = 0;
        trackBundle.fragment.initTables(i7, i8);
        int i10 = 0;
        int i11 = 0;
        while (i6 < size) {
            Atom.LeafAtom leafAtom2 = list.get(i6);
            if (leafAtom2.type == Atom.TYPE_trun) {
                ParsableByteArray parsableByteArray2 = leafAtom2.data;
                trackBundle2 = trackBundle;
                j5 = j4;
                i5 = i4;
                i11 = parseTrun(trackBundle2, i10, j5, i5, parsableByteArray2, i11);
                i10++;
            } else {
                trackBundle2 = trackBundle;
                j5 = j4;
                i5 = i4;
            }
            i6++;
            trackBundle = trackBundle2;
            j4 = j5;
            i4 = i5;
        }
    }

    private static void parseUuid(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.setPosition(8);
        parsableByteArray.readBytes(bArr, 0, 16);
        if (Arrays.equals(bArr, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            parseSenc(parsableByteArray, 16, trackFragment);
        }
    }

    private void processAtomEnded(long j4) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j4) {
            onContainerAtomRead(this.containerAtoms.pop());
        }
        enterReadingAtomHeaderState();
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.data, 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j4 = this.atomSize;
        if (j4 == 1) {
            extractorInput.readFully(this.atomHeader.data, 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j4 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + ((long) this.atomHeaderBytesRead);
            }
        }
        if (this.atomSize >= ((long) this.atomHeaderBytesRead)) {
            long position = extractorInput.getPosition() - ((long) this.atomHeaderBytesRead);
            if (this.atomType == Atom.TYPE_moof) {
                int size = this.trackBundles.size();
                for (int i4 = 0; i4 < size; i4++) {
                    TrackFragment trackFragment = this.trackBundles.valueAt(i4).fragment;
                    trackFragment.atomPosition = position;
                    trackFragment.auxiliaryDataPosition = position;
                    trackFragment.dataPosition = position;
                }
            }
            int i5 = this.atomType;
            if (i5 == Atom.TYPE_mdat) {
                this.currentTrackBundle = null;
                this.endOfMdatPosition = this.atomSize + position;
                if (!this.haveOutputSeekMap) {
                    this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, position));
                    this.haveOutputSeekMap = true;
                }
                this.parserState = 2;
                return true;
            }
            if (shouldParseContainerAtom(i5)) {
                long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
                this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, position2));
                if (this.atomSize == ((long) this.atomHeaderBytesRead)) {
                    processAtomEnded(position2);
                } else {
                    enterReadingAtomHeaderState();
                }
            } else if (shouldParseLeafAtom(this.atomType)) {
                if (this.atomHeaderBytesRead == 8) {
                    long j5 = this.atomSize;
                    if (j5 <= 2147483647L) {
                        ParsableByteArray parsableByteArray = new ParsableByteArray((int) j5);
                        this.atomData = parsableByteArray;
                        System.arraycopy(this.atomHeader.data, 0, parsableByteArray.data, 0, 8);
                        this.parserState = 1;
                    } else {
                        throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.atomSize <= 2147483647L) {
                this.atomData = null;
                this.parserState = 1;
            } else {
                throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    private void readAtomPayload(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i4 = ((int) this.atomSize) - this.atomHeaderBytesRead;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.data, 8, i4);
            onLeafAtomRead(new Atom.LeafAtom(this.atomType, this.atomData), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i4);
        }
        processAtomEnded(extractorInput.getPosition());
    }

    private void readEncryptionData(ExtractorInput extractorInput) throws IOException, InterruptedException {
        int size = this.trackBundles.size();
        TrackBundle trackBundle = null;
        long j4 = Long.MAX_VALUE;
        for (int i4 = 0; i4 < size; i4++) {
            TrackFragment trackFragment = this.trackBundles.valueAt(i4).fragment;
            if (trackFragment.sampleEncryptionDataNeedsFill) {
                long j5 = trackFragment.auxiliaryDataPosition;
                if (j5 < j4) {
                    trackBundle = this.trackBundles.valueAt(i4);
                    j4 = j5;
                }
            }
        }
        if (trackBundle == null) {
            this.parserState = 3;
            return;
        }
        int position = (int) (j4 - extractorInput.getPosition());
        if (position >= 0) {
            extractorInput.skipFully(position);
            trackBundle.fragment.fillEncryptionData(extractorInput);
            return;
        }
        throw new ParserException("Offset to encryption data was negative.");
    }

    private boolean readSample(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z4;
        TrackOutput.CryptoData cryptoData;
        int i4;
        boolean z5;
        ExtractorInput extractorInput2 = extractorInput;
        int i5 = 4;
        int i6 = 1;
        int i7 = 0;
        if (this.parserState == 3) {
            if (this.currentTrackBundle == null) {
                TrackBundle nextFragmentRun = getNextFragmentRun(this.trackBundles);
                if (nextFragmentRun == null) {
                    int position = (int) (this.endOfMdatPosition - extractorInput2.getPosition());
                    if (position >= 0) {
                        extractorInput2.skipFully(position);
                        enterReadingAtomHeaderState();
                        return false;
                    }
                    throw new ParserException("Offset to end of mdat was negative.");
                }
                int position2 = (int) (nextFragmentRun.fragment.trunDataPosition[nextFragmentRun.currentTrackRunIndex] - extractorInput2.getPosition());
                if (position2 < 0) {
                    Log.w(TAG, "Ignoring negative offset to sample data.");
                    position2 = 0;
                }
                extractorInput2.skipFully(position2);
                this.currentTrackBundle = nextFragmentRun;
            }
            TrackBundle trackBundle = this.currentTrackBundle;
            int[] iArr = trackBundle.fragment.sampleSizeTable;
            int i8 = trackBundle.currentSampleIndex;
            int i9 = iArr[i8];
            this.sampleSize = i9;
            if (i8 < trackBundle.firstSampleToOutputIndex) {
                extractorInput2.skipFully(i9);
                this.currentTrackBundle.skipSampleEncryptionData();
                if (!this.currentTrackBundle.next()) {
                    this.currentTrackBundle = null;
                }
                this.parserState = 3;
                return true;
            }
            if (trackBundle.track.sampleTransformation == 1) {
                this.sampleSize = i9 - 8;
                extractorInput2.skipFully(8);
            }
            int outputSampleEncryptionData = this.currentTrackBundle.outputSampleEncryptionData();
            this.sampleBytesWritten = outputSampleEncryptionData;
            this.sampleSize += outputSampleEncryptionData;
            this.parserState = 4;
            this.sampleCurrentNalBytesRemaining = 0;
        }
        TrackBundle trackBundle2 = this.currentTrackBundle;
        TrackFragment trackFragment = trackBundle2.fragment;
        Track track = trackBundle2.track;
        TrackOutput trackOutput = trackBundle2.output;
        int i10 = trackBundle2.currentSampleIndex;
        long samplePresentationTime = trackFragment.getSamplePresentationTime(i10) * 1000;
        TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
        if (timestampAdjuster2 != null) {
            samplePresentationTime = timestampAdjuster2.adjustSampleTimestamp(samplePresentationTime);
        }
        int i11 = track.nalUnitLengthFieldLength;
        if (i11 == 0) {
            z4 = true;
            while (true) {
                int i12 = this.sampleBytesWritten;
                int i13 = this.sampleSize;
                if (i12 >= i13) {
                    break;
                }
                this.sampleBytesWritten += trackOutput.sampleData(extractorInput2, i13 - i12, false);
            }
        } else {
            byte[] bArr = this.nalPrefix.data;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i14 = i11 + 1;
            int i15 = 4 - i11;
            while (this.sampleBytesWritten < this.sampleSize) {
                int i16 = this.sampleCurrentNalBytesRemaining;
                if (i16 == 0) {
                    extractorInput2.readFully(bArr, i15, i14);
                    this.nalPrefix.setPosition(i7);
                    this.sampleCurrentNalBytesRemaining = this.nalPrefix.readUnsignedIntToInt() - i6;
                    this.nalStartCode.setPosition(i7);
                    trackOutput.sampleData(this.nalStartCode, i5);
                    trackOutput.sampleData(this.nalPrefix, i6);
                    if (this.cea608TrackOutputs.length <= 0 || !NalUnitUtil.isNalUnitSei(track.format.sampleMimeType, bArr[i5])) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    this.processSeiNalUnitPayload = z5;
                    this.sampleBytesWritten += 5;
                    this.sampleSize += i15;
                } else {
                    if (this.processSeiNalUnitPayload) {
                        this.nalBuffer.reset(i16);
                        extractorInput2.readFully(this.nalBuffer.data, i7, this.sampleCurrentNalBytesRemaining);
                        trackOutput.sampleData(this.nalBuffer, this.sampleCurrentNalBytesRemaining);
                        i4 = this.sampleCurrentNalBytesRemaining;
                        ParsableByteArray parsableByteArray = this.nalBuffer;
                        int unescapeStream = NalUnitUtil.unescapeStream(parsableByteArray.data, parsableByteArray.limit());
                        this.nalBuffer.setPosition(MimeTypes.VIDEO_H265.equals(track.format.sampleMimeType) ? 1 : 0);
                        this.nalBuffer.setLimit(unescapeStream);
                        CeaUtil.consume(samplePresentationTime, this.nalBuffer, this.cea608TrackOutputs);
                    } else {
                        i4 = trackOutput.sampleData(extractorInput2, i16, false);
                    }
                    this.sampleBytesWritten += i4;
                    this.sampleCurrentNalBytesRemaining -= i4;
                    i5 = 4;
                    i6 = 1;
                    i7 = 0;
                }
            }
            z4 = true;
        }
        boolean z6 = trackFragment.sampleIsSyncFrameTable[i10];
        if (trackFragment.definesEncryptionData) {
            z6 |= true;
            TrackEncryptionBox trackEncryptionBox = trackFragment.trackEncryptionBox;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = track.getSampleDescriptionEncryptionBox(trackFragment.header.sampleDescriptionIndex);
            }
            cryptoData = trackEncryptionBox.cryptoData;
        } else {
            cryptoData = null;
        }
        trackOutput.sampleMetadata(samplePresentationTime, z6 ? 1 : 0, this.sampleSize, 0, cryptoData);
        outputPendingMetadataSamples(samplePresentationTime);
        if (!this.currentTrackBundle.next()) {
            this.currentTrackBundle = null;
        }
        this.parserState = 3;
        return z4;
    }

    private static boolean shouldParseContainerAtom(int i4) {
        if (i4 == Atom.TYPE_moov || i4 == Atom.TYPE_trak || i4 == Atom.TYPE_mdia || i4 == Atom.TYPE_minf || i4 == Atom.TYPE_stbl || i4 == Atom.TYPE_moof || i4 == Atom.TYPE_traf || i4 == Atom.TYPE_mvex || i4 == Atom.TYPE_edts) {
            return true;
        }
        return false;
    }

    private static boolean shouldParseLeafAtom(int i4) {
        if (i4 == Atom.TYPE_hdlr || i4 == Atom.TYPE_mdhd || i4 == Atom.TYPE_mvhd || i4 == Atom.TYPE_sidx || i4 == Atom.TYPE_stsd || i4 == Atom.TYPE_tfdt || i4 == Atom.TYPE_tfhd || i4 == Atom.TYPE_tkhd || i4 == Atom.TYPE_trex || i4 == Atom.TYPE_trun || i4 == Atom.TYPE_pssh || i4 == Atom.TYPE_saiz || i4 == Atom.TYPE_saio || i4 == Atom.TYPE_senc || i4 == Atom.TYPE_uuid || i4 == Atom.TYPE_sbgp || i4 == Atom.TYPE_sgpd || i4 == Atom.TYPE_elst || i4 == Atom.TYPE_mehd || i4 == Atom.TYPE_emsg) {
            return true;
        }
        return false;
    }

    public final void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        Track track = this.sideloadedTrack;
        if (track != null) {
            TrackBundle trackBundle = new TrackBundle(extractorOutput2.track(0, track.type));
            trackBundle.init(this.sideloadedTrack, new DefaultSampleValues(0, 0, 0, 0));
            this.trackBundles.put(0, trackBundle);
            maybeInitExtraTracks();
            this.extractorOutput.endTracks();
        }
    }

    public final int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        while (true) {
            int i4 = this.parserState;
            if (i4 != 0) {
                if (i4 == 1) {
                    readAtomPayload(extractorInput);
                } else if (i4 == 2) {
                    readEncryptionData(extractorInput);
                } else if (readSample(extractorInput)) {
                    return 0;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    public final void release() {
    }

    public final void seek(long j4, long j5) {
        int size = this.trackBundles.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.trackBundles.valueAt(i4).reset();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.pendingSeekTimeUs = j5;
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    public final boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return Sniffer.sniffFragmented(extractorInput);
    }

    public FragmentedMp4Extractor(int i4) {
        this(i4, (TimestampAdjuster) null);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, int i4, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(i4 + 8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        if ((parseFullAtomFlags & 1) == 0) {
            boolean z4 = (parseFullAtomFlags & 2) != 0;
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt == trackFragment.sampleCount) {
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z4);
                trackFragment.initEncryptionData(parsableByteArray.bytesLeft());
                trackFragment.fillEncryptionData(parsableByteArray);
                return;
            }
            throw new ParserException("Length mismatch: " + readUnsignedIntToInt + ", " + trackFragment.sampleCount);
        }
        throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    public FragmentedMp4Extractor(int i4, @Nullable TimestampAdjuster timestampAdjuster2) {
        this(i4, timestampAdjuster2, (Track) null, (DrmInitData) null);
    }

    public FragmentedMp4Extractor(int i4, @Nullable TimestampAdjuster timestampAdjuster2, @Nullable Track track, @Nullable DrmInitData drmInitData) {
        this(i4, timestampAdjuster2, track, drmInitData, Collections.EMPTY_LIST);
    }

    public FragmentedMp4Extractor(int i4, @Nullable TimestampAdjuster timestampAdjuster2, @Nullable Track track, @Nullable DrmInitData drmInitData, List<Format> list) {
        this(i4, timestampAdjuster2, track, drmInitData, list, (TrackOutput) null);
    }

    public FragmentedMp4Extractor(int i4, @Nullable TimestampAdjuster timestampAdjuster2, @Nullable Track track, @Nullable DrmInitData drmInitData, List<Format> list, @Nullable TrackOutput trackOutput) {
        this.flags = i4 | (track != null ? 8 : 0);
        this.timestampAdjuster = timestampAdjuster2;
        this.sideloadedTrack = track;
        this.sideloadedDrmInitData = drmInitData;
        this.closedCaptionFormats = DesugarCollections.unmodifiableList(list);
        this.additionalEmsgTrackOutput = trackOutput;
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(5);
        this.nalBuffer = new ParsableByteArray();
        this.extendedTypeScratch = new byte[16];
        this.containerAtoms = new ArrayDeque<>();
        this.pendingMetadataSampleInfos = new ArrayDeque<>();
        this.trackBundles = new SparseArray<>();
        this.durationUs = C.TIME_UNSET;
        this.pendingSeekTimeUs = C.TIME_UNSET;
        this.segmentIndexEarliestPresentationTimeUs = C.TIME_UNSET;
        enterReadingAtomHeaderState();
    }
}
