package androidx.profileinstaller;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

class ProfileTranscoder {
    private static final int FIRST_FLAG = 1;
    private static final int HOT = 1;
    private static final int INLINE_CACHE_MEGAMORPHIC_ENCODING = 7;
    private static final int INLINE_CACHE_MISSING_TYPES_ENCODING = 6;
    private static final int LAST_FLAG = 4;
    static final byte[] MAGIC_PROF = {112, 114, 111, 0};
    static final byte[] MAGIC_PROFM = {112, 114, 109, 0};
    private static final int POST_STARTUP = 4;
    private static final int STARTUP = 2;

    private ProfileTranscoder() {
    }

    private static int computeMethodFlags(@NonNull DexProfileData dexProfileData) {
        int i4 = 0;
        for (Map.Entry<Integer, Integer> value : dexProfileData.methods.entrySet()) {
            i4 |= ((Integer) value.getValue()).intValue();
        }
        return i4;
    }

    @NonNull
    private static byte[] createCompressibleBody(@NonNull DexProfileData[] dexProfileDataArr, @NonNull byte[] bArr) throws IOException {
        int i4 = 0;
        int i5 = 0;
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            i5 += Encoding.utf8Length(generateDexKey(dexProfileData.apkName, dexProfileData.dexName, bArr)) + 16 + (dexProfileData.classSetSize * 2) + dexProfileData.hotMethodRegionSize + getMethodBitmapStorageSize(dexProfileData.numMethodIds);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i5);
        if (Arrays.equals(bArr, ProfileVersion.V009_O_MR1)) {
            int length = dexProfileDataArr.length;
            while (i4 < length) {
                DexProfileData dexProfileData2 = dexProfileDataArr[i4];
                writeLineHeader(byteArrayOutputStream, dexProfileData2, generateDexKey(dexProfileData2.apkName, dexProfileData2.dexName, bArr));
                writeLineData(byteArrayOutputStream, dexProfileData2);
                i4++;
            }
        } else {
            for (DexProfileData dexProfileData3 : dexProfileDataArr) {
                writeLineHeader(byteArrayOutputStream, dexProfileData3, generateDexKey(dexProfileData3.apkName, dexProfileData3.dexName, bArr));
            }
            int length2 = dexProfileDataArr.length;
            while (i4 < length2) {
                writeLineData(byteArrayOutputStream, dexProfileDataArr[i4]);
                i4++;
            }
        }
        if (byteArrayOutputStream.size() == i5) {
            return byteArrayOutputStream.toByteArray();
        }
        throw Encoding.error("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i5);
    }

    private static WritableFileSection createCompressibleClassSection(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        int i5 = 0;
        while (i4 < dexProfileDataArr.length) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i4];
                Encoding.writeUInt16(byteArrayOutputStream, i4);
                Encoding.writeUInt16(byteArrayOutputStream, dexProfileData.classSetSize);
                i5 = i5 + 4 + (dexProfileData.classSetSize * 2);
                writeClasses(byteArrayOutputStream, dexProfileData);
                i4++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i5 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.CLASSES, i5, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.error("Expected size " + i5 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static WritableFileSection createCompressibleMethodsSection(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i4 = 0;
        int i5 = 0;
        while (i4 < dexProfileDataArr.length) {
            try {
                DexProfileData dexProfileData = dexProfileDataArr[i4];
                int computeMethodFlags = computeMethodFlags(dexProfileData);
                byte[] createMethodBitmapRegionForS = createMethodBitmapRegionForS(computeMethodFlags, dexProfileData);
                byte[] createMethodsWithInlineCaches = createMethodsWithInlineCaches(dexProfileData);
                Encoding.writeUInt16(byteArrayOutputStream, i4);
                int length = createMethodBitmapRegionForS.length + 2 + createMethodsWithInlineCaches.length;
                Encoding.writeUInt32(byteArrayOutputStream, (long) length);
                Encoding.writeUInt16(byteArrayOutputStream, computeMethodFlags);
                byteArrayOutputStream.write(createMethodBitmapRegionForS);
                byteArrayOutputStream.write(createMethodsWithInlineCaches);
                i5 = i5 + 6 + length;
                i4++;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i5 == byteArray.length) {
            WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.METHODS, i5, byteArray, true);
            byteArrayOutputStream.close();
            return writableFileSection;
        }
        throw Encoding.error("Expected size " + i5 + ", does not match actual size " + byteArray.length);
        throw th;
    }

    private static byte[] createMethodBitmapRegionForS(int i4, @NonNull DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeMethodBitmapForS(byteArrayOutputStream, i4, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static byte[] createMethodsWithInlineCaches(@NonNull DexProfileData dexProfileData) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            writeMethodsWithInlineCaches(byteArrayOutputStream, dexProfileData);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @NonNull
    private static String enforceSeparator(@NonNull String str, @NonNull String str2) {
        if ("!".equals(str2)) {
            return str.replace(":", "!");
        }
        if (":".equals(str2)) {
            return str.replace("!", ":");
        }
        return str;
    }

    @NonNull
    private static String extractKey(@NonNull String str) {
        int indexOf = str.indexOf("!");
        if (indexOf < 0) {
            indexOf = str.indexOf(":");
        }
        if (indexOf > 0) {
            return str.substring(indexOf + 1);
        }
        return str;
    }

    @Nullable
    private static DexProfileData findByDexName(@NonNull DexProfileData[] dexProfileDataArr, @NonNull String str) {
        if (dexProfileDataArr.length <= 0) {
            return null;
        }
        String extractKey = extractKey(str);
        for (int i4 = 0; i4 < dexProfileDataArr.length; i4++) {
            if (dexProfileDataArr[i4].dexName.equals(extractKey)) {
                return dexProfileDataArr[i4];
            }
        }
        return null;
    }

    @NonNull
    private static String generateDexKey(@NonNull String str, @NonNull String str2, @NonNull byte[] bArr) {
        String dexKeySeparator = ProfileVersion.dexKeySeparator(bArr);
        if (str.length() <= 0) {
            return enforceSeparator(str2, dexKeySeparator);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return enforceSeparator(str2, dexKeySeparator);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + ProfileVersion.dexKeySeparator(bArr) + str2;
    }

    private static int getMethodBitmapStorageSize(int i4) {
        return roundUpToByte(i4 * 2) / 8;
    }

    private static int getMethodBitmapStorageSizeForS(int i4, int i5) {
        return roundUpToByte(Integer.bitCount(i4 & -2) * i5) / 8;
    }

    private static int methodFlagBitmapIndex(int i4, int i5, int i6) {
        if (i4 == 1) {
            throw Encoding.error("HOT methods are not stored in the bitmap");
        } else if (i4 == 2) {
            return i5;
        } else {
            if (i4 == 4) {
                return i5 + i6;
            }
            throw Encoding.error("Unexpected flag: " + i4);
        }
    }

    private static int[] readClasses(@NonNull InputStream inputStream, int i4) throws IOException {
        int[] iArr = new int[i4];
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += Encoding.readUInt16(inputStream);
            iArr[i6] = i5;
        }
        return iArr;
    }

    private static int readFlagsFromBitmap(@NonNull BitSet bitSet, int i4, int i5) {
        int i6 = 2;
        if (!bitSet.get(methodFlagBitmapIndex(2, i4, i5))) {
            i6 = 0;
        }
        if (bitSet.get(methodFlagBitmapIndex(4, i4, i5))) {
            return i6 | 4;
        }
        return i6;
    }

    static byte[] readHeader(@NonNull InputStream inputStream, @NonNull byte[] bArr) throws IOException {
        if (Arrays.equals(bArr, Encoding.read(inputStream, bArr.length))) {
            return Encoding.read(inputStream, ProfileVersion.V010_P.length);
        }
        throw Encoding.error("Invalid magic");
    }

    private static void readHotMethodRegion(@NonNull InputStream inputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int available = inputStream.available() - dexProfileData.hotMethodRegionSize;
        int i4 = 0;
        while (inputStream.available() > available) {
            i4 += Encoding.readUInt16(inputStream);
            dexProfileData.methods.put(Integer.valueOf(i4), 1);
            for (int readUInt16 = Encoding.readUInt16(inputStream); readUInt16 > 0; readUInt16--) {
                skipInlineCache(inputStream);
            }
        }
        if (inputStream.available() != available) {
            throw Encoding.error("Read too much data during profile line parse");
        }
    }

    @NonNull
    static DexProfileData[] readMeta(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull byte[] bArr2, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.METADATA_V001_N)) {
            if (!Arrays.equals(ProfileVersion.V015_S, bArr2)) {
                return readMetadata001(inputStream, bArr, dexProfileDataArr);
            }
            throw Encoding.error("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        } else if (Arrays.equals(bArr, ProfileVersion.METADATA_V002)) {
            return readMetadataV002(inputStream, bArr2, dexProfileDataArr);
        } else {
            throw Encoding.error("Unsupported meta version");
        }
    }

    @NonNull
    static DexProfileData[] readMetadata001(@NonNull InputStream inputStream, @NonNull byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.METADATA_V001_N)) {
            int readUInt8 = Encoding.readUInt8(inputStream);
            byte[] readCompressed = Encoding.readCompressed(inputStream, (int) Encoding.readUInt32(inputStream), (int) Encoding.readUInt32(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readCompressed);
                try {
                    DexProfileData[] readMetadataForNBody = readMetadataForNBody(byteArrayInputStream, readUInt8, dexProfileDataArr);
                    byteArrayInputStream.close();
                    return readMetadataForNBody;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw Encoding.error("Content found after the end of file");
            }
        } else {
            throw Encoding.error("Unsupported meta version");
        }
        throw th;
    }

    @NonNull
    private static DexProfileData[] readMetadataForNBody(@NonNull InputStream inputStream, int i4, DexProfileData[] dexProfileDataArr) throws IOException {
        int i5 = 0;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i4 == dexProfileDataArr.length) {
            String[] strArr = new String[i4];
            int[] iArr = new int[i4];
            for (int i6 = 0; i6 < i4; i6++) {
                int readUInt16 = Encoding.readUInt16(inputStream);
                iArr[i6] = Encoding.readUInt16(inputStream);
                strArr[i6] = Encoding.readString(inputStream, readUInt16);
            }
            while (i5 < i4) {
                DexProfileData dexProfileData = dexProfileDataArr[i5];
                if (dexProfileData.dexName.equals(strArr[i5])) {
                    int i7 = iArr[i5];
                    dexProfileData.classSetSize = i7;
                    dexProfileData.classes = readClasses(inputStream, i7);
                    i5++;
                } else {
                    throw Encoding.error("Order of dexfiles in metadata did not match baseline");
                }
            }
            return dexProfileDataArr;
        }
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    @NonNull
    static DexProfileData[] readMetadataV002(@NonNull InputStream inputStream, @NonNull byte[] bArr, DexProfileData[] dexProfileDataArr) throws IOException {
        int readUInt16 = Encoding.readUInt16(inputStream);
        byte[] readCompressed = Encoding.readCompressed(inputStream, (int) Encoding.readUInt32(inputStream), (int) Encoding.readUInt32(inputStream));
        if (inputStream.read() <= 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readCompressed);
            try {
                DexProfileData[] readMetadataV002Body = readMetadataV002Body(byteArrayInputStream, bArr, readUInt16, dexProfileDataArr);
                byteArrayInputStream.close();
                return readMetadataV002Body;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw Encoding.error("Content found after the end of file");
        }
        throw th;
    }

    @NonNull
    private static DexProfileData[] readMetadataV002Body(@NonNull InputStream inputStream, @NonNull byte[] bArr, int i4, DexProfileData[] dexProfileDataArr) throws IOException {
        int i5 = 0;
        if (inputStream.available() == 0) {
            return new DexProfileData[0];
        }
        if (i4 == dexProfileDataArr.length) {
            while (i5 < i4) {
                Encoding.readUInt16(inputStream);
                String readString = Encoding.readString(inputStream, Encoding.readUInt16(inputStream));
                long readUInt32 = Encoding.readUInt32(inputStream);
                int readUInt16 = Encoding.readUInt16(inputStream);
                DexProfileData findByDexName = findByDexName(dexProfileDataArr, readString);
                if (findByDexName != null) {
                    findByDexName.mTypeIdCount = readUInt32;
                    int[] readClasses = readClasses(inputStream, readUInt16);
                    if (Arrays.equals(bArr, ProfileVersion.V001_N)) {
                        findByDexName.classSetSize = readUInt16;
                        findByDexName.classes = readClasses;
                    }
                    i5++;
                } else {
                    throw Encoding.error("Missing profile key: " + readString);
                }
            }
            return dexProfileDataArr;
        }
        throw Encoding.error("Mismatched number of dex files found in metadata");
    }

    private static void readMethodBitmap(@NonNull InputStream inputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        BitSet valueOf = BitSet.valueOf(Encoding.read(inputStream, Encoding.bitsToBytes(dexProfileData.numMethodIds * 2)));
        int i4 = 0;
        while (true) {
            int i5 = dexProfileData.numMethodIds;
            if (i4 < i5) {
                int readFlagsFromBitmap = readFlagsFromBitmap(valueOf, i4, i5);
                if (readFlagsFromBitmap != 0) {
                    Integer num = dexProfileData.methods.get(Integer.valueOf(i4));
                    if (num == null) {
                        num = 0;
                    }
                    dexProfileData.methods.put(Integer.valueOf(i4), Integer.valueOf(readFlagsFromBitmap | num.intValue()));
                }
                i4++;
            } else {
                return;
            }
        }
    }

    @NonNull
    static DexProfileData[] readProfile(@NonNull InputStream inputStream, @NonNull byte[] bArr, @NonNull String str) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.V010_P)) {
            int readUInt8 = Encoding.readUInt8(inputStream);
            byte[] readCompressed = Encoding.readCompressed(inputStream, (int) Encoding.readUInt32(inputStream), (int) Encoding.readUInt32(inputStream));
            if (inputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readCompressed);
                try {
                    DexProfileData[] readUncompressedBody = readUncompressedBody(byteArrayInputStream, str, readUInt8);
                    byteArrayInputStream.close();
                    return readUncompressedBody;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw Encoding.error("Content found after the end of file");
            }
        } else {
            throw Encoding.error("Unsupported version");
        }
        throw th;
    }

    @NonNull
    private static DexProfileData[] readUncompressedBody(@NonNull InputStream inputStream, @NonNull String str, int i4) throws IOException {
        InputStream inputStream2 = inputStream;
        int i5 = i4;
        if (inputStream2.available() == 0) {
            return new DexProfileData[0];
        }
        DexProfileData[] dexProfileDataArr = new DexProfileData[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            int readUInt16 = Encoding.readUInt16(inputStream2);
            int readUInt162 = Encoding.readUInt16(inputStream2);
            long readUInt32 = Encoding.readUInt32(inputStream2);
            long readUInt322 = Encoding.readUInt32(inputStream2);
            long readUInt323 = Encoding.readUInt32(inputStream2);
            String readString = Encoding.readString(inputStream2, readUInt16);
            dexProfileDataArr[i6] = new DexProfileData(str, readString, readUInt322, 0, readUInt162, (int) readUInt32, (int) readUInt323, new int[readUInt162], new TreeMap());
        }
        for (int i7 = 0; i7 < i5; i7++) {
            DexProfileData dexProfileData = dexProfileDataArr[i7];
            readHotMethodRegion(inputStream2, dexProfileData);
            dexProfileData.classes = readClasses(inputStream2, dexProfileData.classSetSize);
            readMethodBitmap(inputStream2, dexProfileData);
        }
        return dexProfileDataArr;
    }

    private static int roundUpToByte(int i4) {
        return (i4 + 7) & -8;
    }

    private static void setMethodBitmapBit(@NonNull byte[] bArr, int i4, int i5, @NonNull DexProfileData dexProfileData) {
        int methodFlagBitmapIndex = methodFlagBitmapIndex(i4, i5, dexProfileData.numMethodIds);
        int i6 = methodFlagBitmapIndex / 8;
        bArr[i6] = (byte) ((1 << (methodFlagBitmapIndex % 8)) | bArr[i6]);
    }

    private static void skipInlineCache(@NonNull InputStream inputStream) throws IOException {
        Encoding.readUInt16(inputStream);
        int readUInt8 = Encoding.readUInt8(inputStream);
        if (readUInt8 != 6 && readUInt8 != 7) {
            while (readUInt8 > 0) {
                Encoding.readUInt8(inputStream);
                for (int readUInt82 = Encoding.readUInt8(inputStream); readUInt82 > 0; readUInt82--) {
                    Encoding.readUInt16(inputStream);
                }
                readUInt8--;
            }
        }
    }

    static boolean transcodeAndWriteBody(@NonNull OutputStream outputStream, @NonNull byte[] bArr, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        if (Arrays.equals(bArr, ProfileVersion.V015_S)) {
            writeProfileForS(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.V010_P)) {
            writeProfileForP(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.V005_O)) {
            writeProfileForO(outputStream, dexProfileDataArr);
            return true;
        } else if (Arrays.equals(bArr, ProfileVersion.V009_O_MR1)) {
            writeProfileForO_MR1(outputStream, dexProfileDataArr);
            return true;
        } else if (!Arrays.equals(bArr, ProfileVersion.V001_N)) {
            return false;
        } else {
            writeProfileForN(outputStream, dexProfileDataArr);
            return true;
        }
    }

    private static void writeClasses(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int[] iArr = dexProfileData.classes;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = iArr[i4];
            Encoding.writeUInt16(outputStream, i6 - i5);
            i4++;
            i5 = i6;
        }
    }

    private static WritableFileSection writeDexFileSection(@NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Encoding.writeUInt16(byteArrayOutputStream, dexProfileDataArr.length);
            int i4 = 2;
            for (DexProfileData dexProfileData : dexProfileDataArr) {
                Encoding.writeUInt32(byteArrayOutputStream, dexProfileData.dexChecksum);
                Encoding.writeUInt32(byteArrayOutputStream, dexProfileData.mTypeIdCount);
                Encoding.writeUInt32(byteArrayOutputStream, (long) dexProfileData.numMethodIds);
                String generateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, ProfileVersion.V015_S);
                int utf8Length = Encoding.utf8Length(generateDexKey);
                Encoding.writeUInt16(byteArrayOutputStream, utf8Length);
                i4 = i4 + 14 + utf8Length;
                Encoding.writeString(byteArrayOutputStream, generateDexKey);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i4 == byteArray.length) {
                WritableFileSection writableFileSection = new WritableFileSection(FileSectionType.DEX_FILES, i4, byteArray, false);
                byteArrayOutputStream.close();
                return writableFileSection;
            }
            throw Encoding.error("Expected size " + i4 + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    static void writeHeader(@NonNull OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(MAGIC_PROF);
        outputStream.write(bArr);
    }

    private static void writeLineData(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        writeMethodsWithInlineCaches(outputStream, dexProfileData);
        writeClasses(outputStream, dexProfileData);
        writeMethodBitmap(outputStream, dexProfileData);
    }

    private static void writeLineHeader(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData, @NonNull String str) throws IOException {
        Encoding.writeUInt16(outputStream, Encoding.utf8Length(str));
        Encoding.writeUInt16(outputStream, dexProfileData.classSetSize);
        Encoding.writeUInt32(outputStream, (long) dexProfileData.hotMethodRegionSize);
        Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
        Encoding.writeUInt32(outputStream, (long) dexProfileData.numMethodIds);
        Encoding.writeString(outputStream, str);
    }

    private static void writeMethodBitmap(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[getMethodBitmapStorageSize(dexProfileData.numMethodIds)];
        for (Map.Entry next : dexProfileData.methods.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                setMethodBitmapBit(bArr, 2, intValue, dexProfileData);
            }
            if ((intValue2 & 4) != 0) {
                setMethodBitmapBit(bArr, 4, intValue, dexProfileData);
            }
        }
        outputStream.write(bArr);
    }

    private static void writeMethodBitmapForS(@NonNull OutputStream outputStream, int i4, @NonNull DexProfileData dexProfileData) throws IOException {
        byte[] bArr = new byte[getMethodBitmapStorageSizeForS(i4, dexProfileData.numMethodIds)];
        for (Map.Entry next : dexProfileData.methods.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            int i5 = 0;
            for (int i6 = 1; i6 <= 4; i6 <<= 1) {
                if (!(i6 == 1 || (i6 & i4) == 0)) {
                    if ((i6 & intValue2) == i6) {
                        int i7 = (dexProfileData.numMethodIds * i5) + intValue;
                        int i8 = i7 / 8;
                        bArr[i8] = (byte) ((1 << (i7 % 8)) | bArr[i8]);
                    }
                    i5++;
                }
            }
        }
        outputStream.write(bArr);
    }

    private static void writeMethodsWithInlineCaches(@NonNull OutputStream outputStream, @NonNull DexProfileData dexProfileData) throws IOException {
        int i4 = 0;
        for (Map.Entry next : dexProfileData.methods.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            if ((((Integer) next.getValue()).intValue() & 1) != 0) {
                Encoding.writeUInt16(outputStream, intValue - i4);
                Encoding.writeUInt16(outputStream, 0);
                i4 = intValue;
            }
        }
    }

    private static void writeProfileForN(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.writeUInt16(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String generateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, ProfileVersion.V001_N);
            Encoding.writeUInt16(outputStream, Encoding.utf8Length(generateDexKey));
            Encoding.writeUInt16(outputStream, dexProfileData.methods.size());
            Encoding.writeUInt16(outputStream, dexProfileData.classes.length);
            Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
            Encoding.writeString(outputStream, generateDexKey);
            for (Integer intValue : dexProfileData.methods.keySet()) {
                Encoding.writeUInt16(outputStream, intValue.intValue());
            }
            for (int writeUInt16 : dexProfileData.classes) {
                Encoding.writeUInt16(outputStream, writeUInt16);
            }
        }
    }

    private static void writeProfileForO(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        Encoding.writeUInt8(outputStream, dexProfileDataArr.length);
        for (DexProfileData dexProfileData : dexProfileDataArr) {
            String generateDexKey = generateDexKey(dexProfileData.apkName, dexProfileData.dexName, ProfileVersion.V005_O);
            Encoding.writeUInt16(outputStream, Encoding.utf8Length(generateDexKey));
            Encoding.writeUInt16(outputStream, dexProfileData.classes.length);
            Encoding.writeUInt32(outputStream, (long) (dexProfileData.methods.size() * 4));
            Encoding.writeUInt32(outputStream, dexProfileData.dexChecksum);
            Encoding.writeString(outputStream, generateDexKey);
            for (Integer intValue : dexProfileData.methods.keySet()) {
                Encoding.writeUInt16(outputStream, intValue.intValue());
                Encoding.writeUInt16(outputStream, 0);
            }
            for (int writeUInt16 : dexProfileData.classes) {
                Encoding.writeUInt16(outputStream, writeUInt16);
            }
        }
    }

    private static void writeProfileForO_MR1(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] createCompressibleBody = createCompressibleBody(dexProfileDataArr, ProfileVersion.V009_O_MR1);
        Encoding.writeUInt8(outputStream, dexProfileDataArr.length);
        Encoding.writeCompressed(outputStream, createCompressibleBody);
    }

    private static void writeProfileForP(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        byte[] createCompressibleBody = createCompressibleBody(dexProfileDataArr, ProfileVersion.V010_P);
        Encoding.writeUInt8(outputStream, dexProfileDataArr.length);
        Encoding.writeCompressed(outputStream, createCompressibleBody);
    }

    private static void writeProfileForS(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        writeProfileSections(outputStream, dexProfileDataArr);
    }

    private static void writeProfileSections(@NonNull OutputStream outputStream, @NonNull DexProfileData[] dexProfileDataArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(writeDexFileSection(dexProfileDataArr));
        arrayList.add(createCompressibleClassSection(dexProfileDataArr));
        arrayList.add(createCompressibleMethodsSection(dexProfileDataArr));
        long length2 = ((long) ProfileVersion.V015_S.length) + ((long) MAGIC_PROF.length) + 4 + ((long) (arrayList.size() * 16));
        Encoding.writeUInt32(outputStream, (long) arrayList.size());
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            WritableFileSection writableFileSection = (WritableFileSection) arrayList.get(i4);
            Encoding.writeUInt32(outputStream, writableFileSection.mType.getValue());
            Encoding.writeUInt32(outputStream, length2);
            if (writableFileSection.mNeedsCompression) {
                byte[] bArr = writableFileSection.mContents;
                byte[] compress = Encoding.compress(bArr);
                arrayList2.add(compress);
                Encoding.writeUInt32(outputStream, (long) compress.length);
                Encoding.writeUInt32(outputStream, (long) bArr.length);
                length = compress.length;
            } else {
                arrayList2.add(writableFileSection.mContents);
                Encoding.writeUInt32(outputStream, (long) writableFileSection.mContents.length);
                Encoding.writeUInt32(outputStream, 0);
                length = writableFileSection.mContents.length;
            }
            length2 += (long) length;
        }
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            outputStream.write((byte[]) arrayList2.get(i5));
        }
    }
}
