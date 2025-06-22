package androidx.profileinstaller;

enum FileSectionType {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);
    
    private final long mValue;

    private FileSectionType(long j4) {
        this.mValue = j4;
    }

    static FileSectionType fromValue(long j4) {
        FileSectionType[] values = values();
        for (int i4 = 0; i4 < values.length; i4++) {
            if (values[i4].getValue() == j4) {
                return values[i4];
            }
        }
        throw new IllegalArgumentException("Unsupported FileSection Type " + j4);
    }

    public long getValue() {
        return this.mValue;
    }
}
