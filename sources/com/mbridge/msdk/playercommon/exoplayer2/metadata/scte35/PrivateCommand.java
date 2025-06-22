package com.mbridge.msdk.playercommon.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;

public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() {
        public final PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        public final PrivateCommand[] newArray(int i4) {
            return new PrivateCommand[i4];
        }
    };
    public final byte[] commandBytes;
    public final long identifier;
    public final long ptsAdjustment;

    static PrivateCommand parseFromSection(ParsableByteArray parsableByteArray, int i4, long j4) {
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        int i5 = i4 - 4;
        byte[] bArr = new byte[i5];
        parsableByteArray.readBytes(bArr, 0, i5);
        return new PrivateCommand(readUnsignedInt, bArr, j4);
    }

    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeLong(this.ptsAdjustment);
        parcel.writeLong(this.identifier);
        parcel.writeInt(this.commandBytes.length);
        parcel.writeByteArray(this.commandBytes);
    }

    private PrivateCommand(long j4, byte[] bArr, long j5) {
        this.ptsAdjustment = j5;
        this.identifier = j4;
        this.commandBytes = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.ptsAdjustment = parcel.readLong();
        this.identifier = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.commandBytes = bArr;
        parcel.readByteArray(bArr);
    }
}
