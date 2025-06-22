package com.mbridge.msdk.playercommon.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() {
        public final SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        public final SpliceScheduleCommand[] newArray(int i4) {
            return new SpliceScheduleCommand[i4];
        }
    };
    public final List<Event> events;

    public static final class ComponentSplice {
        public final int componentTag;
        public final long utcSpliceTime;

        /* access modifiers changed from: private */
        public static ComponentSplice createFromParcel(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.utcSpliceTime);
        }

        private ComponentSplice(int i4, long j4) {
            this.componentTag = i4;
            this.utcSpliceTime = j4;
        }
    }

    static SpliceScheduleCommand parseFromSection(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        ArrayList arrayList = new ArrayList(readUnsignedByte);
        for (int i4 = 0; i4 < readUnsignedByte; i4++) {
            arrayList.add(Event.parseFromSection(parsableByteArray));
        }
        return new SpliceScheduleCommand((List<Event>) arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i5 = 0; i5 < size; i5++) {
            this.events.get(i5).writeToParcel(parcel);
        }
    }

    private SpliceScheduleCommand(List<Event> list) {
        this.events = DesugarCollections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i4 = 0; i4 < readInt; i4++) {
            arrayList.add(Event.createFromParcel(parcel));
        }
        this.events = DesugarCollections.unmodifiableList(arrayList);
    }

    public static final class Event {
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final List<ComponentSplice> componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        private Event(long j4, boolean z4, boolean z5, boolean z6, List<ComponentSplice> list, long j5, boolean z7, long j6, int i4, int i5, int i6) {
            this.spliceEventId = j4;
            this.spliceEventCancelIndicator = z4;
            this.outOfNetworkIndicator = z5;
            this.programSpliceFlag = z6;
            this.componentSpliceList = DesugarCollections.unmodifiableList(list);
            this.utcSpliceTime = j5;
            this.autoReturn = z7;
            this.breakDurationUs = j6;
            this.uniqueProgramId = i4;
            this.availNum = i5;
            this.availsExpected = i6;
        }

        /* access modifiers changed from: private */
        public static Event createFromParcel(Parcel parcel) {
            return new Event(parcel);
        }

        /* access modifiers changed from: private */
        public static Event parseFromSection(ParsableByteArray parsableByteArray) {
            int i4;
            int i5;
            int i6;
            long j4;
            boolean z4;
            long j5;
            ArrayList arrayList;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            long j6;
            long j7;
            boolean z10;
            boolean z11;
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            boolean z12 = true;
            if ((parsableByteArray.readUnsignedByte() & 128) == 0) {
                z12 = false;
            }
            ArrayList arrayList2 = new ArrayList();
            if (!z12) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if ((readUnsignedByte & 128) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if ((readUnsignedByte & 64) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if ((readUnsignedByte & 32) != 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z8) {
                    j6 = parsableByteArray.readUnsignedInt();
                } else {
                    j6 = C.TIME_UNSET;
                }
                if (!z8) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    ArrayList arrayList3 = new ArrayList(readUnsignedByte2);
                    int i7 = 0;
                    while (i7 < readUnsignedByte2) {
                        arrayList3.add(new ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt()));
                        i7++;
                        readUnsignedByte2 = readUnsignedByte2;
                    }
                    arrayList2 = arrayList3;
                }
                if (z9) {
                    long readUnsignedByte3 = (long) parsableByteArray.readUnsignedByte();
                    if ((128 & readUnsignedByte3) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    j7 = ((((readUnsignedByte3 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                    z10 = z11;
                } else {
                    z10 = false;
                    j7 = C.TIME_UNSET;
                }
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                boolean z13 = z7;
                z4 = z10;
                z6 = z13;
                i4 = parsableByteArray.readUnsignedByte();
                long j8 = j6;
                i6 = readUnsignedShort;
                i5 = readUnsignedByte4;
                long j9 = j7;
                arrayList = arrayList2;
                z5 = z8;
                j5 = j8;
                j4 = j9;
            } else {
                arrayList = arrayList2;
                z6 = false;
                z5 = false;
                j5 = C.TIME_UNSET;
                z4 = false;
                j4 = C.TIME_UNSET;
                i6 = 0;
                i5 = 0;
                i4 = 0;
            }
            return new Event(readUnsignedInt, z12, z6, z5, arrayList, j5, z4, j4, i6, i5, i4);
        }

        /* access modifiers changed from: private */
        public void writeToParcel(Parcel parcel) {
            parcel.writeLong(this.spliceEventId);
            parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : 0);
            parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : 0);
            parcel.writeByte(this.programSpliceFlag ? (byte) 1 : 0);
            int size = this.componentSpliceList.size();
            parcel.writeInt(size);
            for (int i4 = 0; i4 < size; i4++) {
                this.componentSpliceList.get(i4).writeToParcel(parcel);
            }
            parcel.writeLong(this.utcSpliceTime);
            parcel.writeByte(this.autoReturn ? (byte) 1 : 0);
            parcel.writeLong(this.breakDurationUs);
            parcel.writeInt(this.uniqueProgramId);
            parcel.writeInt(this.availNum);
            parcel.writeInt(this.availsExpected);
        }

        private Event(Parcel parcel) {
            this.spliceEventId = parcel.readLong();
            boolean z4 = false;
            this.spliceEventCancelIndicator = parcel.readByte() == 1;
            this.outOfNetworkIndicator = parcel.readByte() == 1;
            this.programSpliceFlag = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i4 = 0; i4 < readInt; i4++) {
                arrayList.add(ComponentSplice.createFromParcel(parcel));
            }
            this.componentSpliceList = DesugarCollections.unmodifiableList(arrayList);
            this.utcSpliceTime = parcel.readLong();
            this.autoReturn = parcel.readByte() == 1 ? true : z4;
            this.breakDurationUs = parcel.readLong();
            this.uniqueProgramId = parcel.readInt();
            this.availNum = parcel.readInt();
            this.availsExpected = parcel.readInt();
        }
    }
}
