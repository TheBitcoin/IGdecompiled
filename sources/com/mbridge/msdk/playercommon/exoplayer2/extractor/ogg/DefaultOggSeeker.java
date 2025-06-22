package com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg;

import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.EOFException;
import java.io.IOException;

final class DefaultOggSeeker implements OggSeeker {
    private static final int DEFAULT_OFFSET = 30000;
    public static final int MATCH_BYTE_RANGE = 100000;
    public static final int MATCH_RANGE = 72000;
    private static final int STATE_IDLE = 3;
    private static final int STATE_READ_LAST_PAGE = 1;
    private static final int STATE_SEEK = 2;
    private static final int STATE_SEEK_TO_END = 0;
    private long end;
    private long endGranule;
    private final long endPosition;
    private final OggPageHeader pageHeader = new OggPageHeader();
    private long positionBeforeSeekToEnd;
    private long start;
    private long startGranule;
    /* access modifiers changed from: private */
    public final long startPosition;
    private int state;
    /* access modifiers changed from: private */
    public final StreamReader streamReader;
    private long targetGranule;
    /* access modifiers changed from: private */
    public long totalGranules;

    private class OggSeekMap implements SeekMap {
        private OggSeekMap() {
        }

        public long getDurationUs() {
            return DefaultOggSeeker.this.streamReader.convertGranuleToTime(DefaultOggSeeker.this.totalGranules);
        }

        public SeekMap.SeekPoints getSeekPoints(long j4) {
            if (j4 == 0) {
                return new SeekMap.SeekPoints(new SeekPoint(0, DefaultOggSeeker.this.startPosition));
            }
            long convertTimeToGranule = DefaultOggSeeker.this.streamReader.convertTimeToGranule(j4);
            DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
            return new SeekMap.SeekPoints(new SeekPoint(j4, defaultOggSeeker.getEstimatedPosition(defaultOggSeeker.startPosition, convertTimeToGranule, WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS)));
        }

        public boolean isSeekable() {
            return true;
        }
    }

    public DefaultOggSeeker(long j4, long j5, StreamReader streamReader2, int i4, long j6) {
        boolean z4;
        if (j4 < 0 || j5 <= j4) {
            z4 = false;
        } else {
            z4 = true;
        }
        Assertions.checkArgument(z4);
        this.streamReader = streamReader2;
        this.startPosition = j4;
        this.endPosition = j5;
        if (((long) i4) == j5 - j4) {
            this.totalGranules = j6;
            this.state = 3;
            return;
        }
        this.state = 0;
    }

    /* access modifiers changed from: private */
    public long getEstimatedPosition(long j4, long j5, long j6) {
        long j7 = this.endPosition;
        long j8 = this.startPosition;
        long j9 = j4 + (((j5 * (j7 - j8)) / this.totalGranules) - j6);
        if (j9 >= j8) {
            j8 = j9;
        }
        if (j8 >= j7) {
            return j7 - 1;
        }
        return j8;
    }

    public final long getNextSeekPosition(long j4, ExtractorInput extractorInput) throws IOException, InterruptedException {
        long j5 = 2;
        if (this.start == this.end) {
            return -(this.startGranule + 2);
        }
        long position = extractorInput.getPosition();
        if (!skipToNextPage(extractorInput, this.end)) {
            long j6 = this.start;
            if (j6 != position) {
                return j6;
            }
            throw new IOException("No ogg page can be found.");
        }
        this.pageHeader.populate(extractorInput, false);
        extractorInput.resetPeekPosition();
        OggPageHeader oggPageHeader = this.pageHeader;
        long j7 = oggPageHeader.granulePosition;
        long j8 = j4 - j7;
        int i4 = oggPageHeader.headerSize + oggPageHeader.bodySize;
        int i5 = (j8 > 0 ? 1 : (j8 == 0 ? 0 : -1));
        if (i5 < 0 || j8 > 72000) {
            if (i5 < 0) {
                this.end = position;
                this.endGranule = j7;
            } else {
                long j9 = (long) i4;
                long position2 = extractorInput.getPosition() + j9;
                this.start = position2;
                this.startGranule = this.pageHeader.granulePosition;
                if ((this.end - position2) + j9 < 100000) {
                    extractorInput.skipFully(i4);
                    return -(this.startGranule + 2);
                }
            }
            long j10 = this.end;
            long j11 = this.start;
            if (j10 - j11 < 100000) {
                this.end = j11;
                return j11;
            }
            long j12 = (long) i4;
            if (i5 > 0) {
                j5 = 1;
            }
            long position3 = extractorInput.getPosition() - (j12 * j5);
            long j13 = this.end;
            long j14 = this.start;
            return Math.min(Math.max(position3 + ((j8 * (j13 - j14)) / (this.endGranule - this.startGranule)), j14), this.end - 1);
        }
        extractorInput.skipFully(i4);
        return -(this.pageHeader.granulePosition + 2);
    }

    public final long read(ExtractorInput extractorInput) throws IOException, InterruptedException {
        ExtractorInput extractorInput2;
        DefaultOggSeeker defaultOggSeeker;
        DefaultOggSeeker defaultOggSeeker2;
        int i4 = this.state;
        if (i4 == 0) {
            defaultOggSeeker = this;
            extractorInput2 = extractorInput;
            long position = extractorInput2.getPosition();
            defaultOggSeeker.positionBeforeSeekToEnd = position;
            defaultOggSeeker.state = 1;
            long j4 = defaultOggSeeker.endPosition - 65307;
            if (j4 > position) {
                return j4;
            }
        } else if (i4 == 1) {
            defaultOggSeeker = this;
            extractorInput2 = extractorInput;
        } else if (i4 == 2) {
            long j5 = this.targetGranule;
            long j6 = 0;
            if (j5 == 0) {
                defaultOggSeeker2 = this;
            } else {
                long nextSeekPosition = getNextSeekPosition(j5, extractorInput);
                if (nextSeekPosition >= 0) {
                    return nextSeekPosition;
                }
                defaultOggSeeker2 = this;
                j6 = defaultOggSeeker2.skipToPageOfGranule(extractorInput, this.targetGranule, -(nextSeekPosition + 2));
            }
            defaultOggSeeker2.state = 3;
            return -(j6 + 2);
        } else if (i4 == 3) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
        defaultOggSeeker.totalGranules = readGranuleOfLastPage(extractorInput2);
        defaultOggSeeker.state = 3;
        return defaultOggSeeker.positionBeforeSeekToEnd;
    }

    /* access modifiers changed from: package-private */
    public final long readGranuleOfLastPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        skipToNextPage(extractorInput);
        this.pageHeader.reset();
        while ((this.pageHeader.type & 4) != 4 && extractorInput.getPosition() < this.endPosition) {
            this.pageHeader.populate(extractorInput, false);
            OggPageHeader oggPageHeader = this.pageHeader;
            extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
        }
        return this.pageHeader.granulePosition;
    }

    public final void resetSeeking() {
        this.start = this.startPosition;
        this.end = this.endPosition;
        this.startGranule = 0;
        this.endGranule = this.totalGranules;
    }

    /* access modifiers changed from: package-private */
    public final void skipToNextPage(ExtractorInput extractorInput) throws IOException, InterruptedException {
        if (!skipToNextPage(extractorInput, this.endPosition)) {
            throw new EOFException();
        }
    }

    /* access modifiers changed from: package-private */
    public final long skipToPageOfGranule(ExtractorInput extractorInput, long j4, long j5) throws IOException, InterruptedException {
        this.pageHeader.populate(extractorInput, false);
        while (true) {
            OggPageHeader oggPageHeader = this.pageHeader;
            if (oggPageHeader.granulePosition < j4) {
                extractorInput.skipFully(oggPageHeader.headerSize + oggPageHeader.bodySize);
                OggPageHeader oggPageHeader2 = this.pageHeader;
                long j6 = oggPageHeader2.granulePosition;
                oggPageHeader2.populate(extractorInput, false);
                j5 = j6;
            } else {
                extractorInput.resetPeekPosition();
                return j5;
            }
        }
    }

    public final long startSeek(long j4) {
        boolean z4;
        int i4 = this.state;
        if (i4 == 3 || i4 == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkArgument(z4);
        long j5 = 0;
        if (j4 != 0) {
            j5 = this.streamReader.convertTimeToGranule(j4);
        }
        this.targetGranule = j5;
        this.state = 2;
        resetSeeking();
        return this.targetGranule;
    }

    public final OggSeekMap createSeekMap() {
        if (this.totalGranules != 0) {
            return new OggSeekMap();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final boolean skipToNextPage(ExtractorInput extractorInput, long j4) throws IOException, InterruptedException {
        int i4;
        long min = Math.min(j4 + 3, this.endPosition);
        int i5 = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            int i6 = 0;
            if (extractorInput.getPosition() + ((long) i5) <= min || (i5 = (int) (min - extractorInput.getPosition())) >= 4) {
                extractorInput.peekFully(bArr, 0, i5, false);
                while (true) {
                    i4 = i5 - 3;
                    if (i6 >= i4) {
                        break;
                    } else if (bArr[i6] == 79 && bArr[i6 + 1] == 103 && bArr[i6 + 2] == 103 && bArr[i6 + 3] == 83) {
                        extractorInput.skipFully(i6);
                        return true;
                    } else {
                        i6++;
                    }
                }
            } else {
                return false;
            }
            extractorInput.skipFully(i4);
        }
    }
}
