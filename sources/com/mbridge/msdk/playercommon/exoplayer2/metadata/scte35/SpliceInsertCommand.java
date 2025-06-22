package com.mbridge.msdk.playercommon.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.TimestampAdjuster;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() {
        public final SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        public final SpliceInsertCommand[] newArray(int i4) {
            return new SpliceInsertCommand[i4];
        }
    };
    public final boolean autoReturn;
    public final int availNum;
    public final int availsExpected;
    public final long breakDurationUs;
    public final List<ComponentSplice> componentSpliceList;
    public final boolean outOfNetworkIndicator;
    public final boolean programSpliceFlag;
    public final long programSplicePlaybackPositionUs;
    public final long programSplicePts;
    public final boolean spliceEventCancelIndicator;
    public final long spliceEventId;
    public final boolean spliceImmediateFlag;
    public final int uniqueProgramId;

    public static final class ComponentSplice {
        public final long componentSplicePlaybackPositionUs;
        public final long componentSplicePts;
        public final int componentTag;

        public static ComponentSplice createFromParcel(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public final void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.componentSplicePts);
            parcel.writeLong(this.componentSplicePlaybackPositionUs);
        }

        private ComponentSplice(int i4, long j4, long j5) {
            this.componentTag = i4;
            this.componentSplicePts = j4;
            this.componentSplicePlaybackPositionUs = j5;
        }
    }

    static SpliceInsertCommand parseFromSection(ParsableByteArray parsableByteArray, long j4, TimestampAdjuster timestampAdjuster) {
        boolean z4;
        int i4;
        int i5;
        int i6;
        long j5;
        boolean z5;
        List list;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        long j6;
        boolean z13;
        boolean z14;
        int i7;
        long j7;
        TimestampAdjuster timestampAdjuster2 = timestampAdjuster;
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        List list2 = Collections.EMPTY_LIST;
        long j8 = C.TIME_UNSET;
        if (!z4) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            if ((readUnsignedByte & 128) != 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            if ((readUnsignedByte & 64) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if ((readUnsignedByte & 32) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((readUnsignedByte & 16) != 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z10 || z12) {
                j6 = -9223372036854775807L;
            } else {
                j6 = TimeSignalCommand.parseSpliceTime(parsableByteArray, j4);
            }
            if (!z10) {
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                ArrayList arrayList = new ArrayList(readUnsignedByte2);
                int i8 = 0;
                while (i8 < readUnsignedByte2) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    if (!z12) {
                        i7 = readUnsignedByte2;
                        j7 = TimeSignalCommand.parseSpliceTime(parsableByteArray, j4);
                    } else {
                        i7 = readUnsignedByte2;
                        j7 = -9223372036854775807L;
                    }
                    arrayList.add(new ComponentSplice(readUnsignedByte3, j7, timestampAdjuster2.adjustTsTimestamp(j7)));
                    i8++;
                    readUnsignedByte2 = i7;
                }
                list2 = arrayList;
            }
            if (z11) {
                long readUnsignedByte4 = (long) parsableByteArray.readUnsignedByte();
                if ((128 & readUnsignedByte4) != 0) {
                    z14 = true;
                } else {
                    z14 = false;
                }
                j8 = ((((readUnsignedByte4 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                z13 = z14;
            } else {
                z13 = false;
            }
            int readUnsignedShort = parsableByteArray.readUnsignedShort();
            long j9 = j6;
            j5 = j8;
            j8 = j9;
            i5 = parsableByteArray.readUnsignedByte();
            i4 = parsableByteArray.readUnsignedByte();
            i6 = readUnsignedShort;
            z5 = z13;
            z8 = z9;
            z7 = z10;
            list = list2;
            z6 = z12;
        } else {
            list = list2;
            j5 = -9223372036854775807L;
            z8 = false;
            z7 = false;
            z6 = false;
            z5 = false;
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        return new SpliceInsertCommand(readUnsignedInt, z4, z8, z7, z6, j8, timestampAdjuster2.adjustTsTimestamp(j8), list, z5, j5, i6, i5, i4);
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.spliceEventId);
        parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : 0);
        parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : 0);
        parcel.writeByte(this.programSpliceFlag ? (byte) 1 : 0);
        parcel.writeByte(this.spliceImmediateFlag ? (byte) 1 : 0);
        parcel.writeLong(this.programSplicePts);
        parcel.writeLong(this.programSplicePlaybackPositionUs);
        int size = this.componentSpliceList.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            this.componentSpliceList.get(i5).writeToParcel(parcel);
        }
        parcel.writeByte(this.autoReturn ? (byte) 1 : 0);
        parcel.writeLong(this.breakDurationUs);
        parcel.writeInt(this.uniqueProgramId);
        parcel.writeInt(this.availNum);
        parcel.writeInt(this.availsExpected);
    }

    private SpliceInsertCommand(long j4, boolean z4, boolean z5, boolean z6, boolean z7, long j5, long j6, List<ComponentSplice> list, boolean z8, long j7, int i4, int i5, int i6) {
        this.spliceEventId = j4;
        this.spliceEventCancelIndicator = z4;
        this.outOfNetworkIndicator = z5;
        this.programSpliceFlag = z6;
        this.spliceImmediateFlag = z7;
        this.programSplicePts = j5;
        this.programSplicePlaybackPositionUs = j6;
        this.componentSpliceList = DesugarCollections.unmodifiableList(list);
        this.autoReturn = z8;
        this.breakDurationUs = j7;
        this.uniqueProgramId = i4;
        this.availNum = i5;
        this.availsExpected = i6;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.spliceEventId = parcel.readLong();
        boolean z4 = false;
        this.spliceEventCancelIndicator = parcel.readByte() == 1;
        this.outOfNetworkIndicator = parcel.readByte() == 1;
        this.programSpliceFlag = parcel.readByte() == 1;
        this.spliceImmediateFlag = parcel.readByte() == 1;
        this.programSplicePts = parcel.readLong();
        this.programSplicePlaybackPositionUs = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            arrayList.add(ComponentSplice.createFromParcel(parcel));
        }
        this.componentSpliceList = DesugarCollections.unmodifiableList(arrayList);
        this.autoReturn = parcel.readByte() == 1 ? true : z4;
        this.breakDurationUs = parcel.readLong();
        this.uniqueProgramId = parcel.readInt();
        this.availNum = parcel.readInt();
        this.availsExpected = parcel.readInt();
    }
}
