package androidx.profileinstaller;

import androidx.annotation.NonNull;

class WritableFileSection {
    final byte[] mContents;
    final int mExpectedInflateSize;
    final boolean mNeedsCompression;
    final FileSectionType mType;

    WritableFileSection(@NonNull FileSectionType fileSectionType, int i4, @NonNull byte[] bArr, boolean z4) {
        this.mType = fileSectionType;
        this.mExpectedInflateSize = i4;
        this.mContents = bArr;
        this.mNeedsCompression = z4;
    }
}
