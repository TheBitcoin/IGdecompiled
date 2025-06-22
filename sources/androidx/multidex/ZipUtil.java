package androidx.multidex;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class ZipUtil {
    private static final int BUFFER_SIZE = 16384;
    private static final int ENDHDR = 22;
    private static final int ENDSIG = 101010256;

    static class CentralDirectory {
        long offset;
        long size;

        CentralDirectory() {
        }
    }

    ZipUtil() {
    }

    static long computeCrcOfCentralDir(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        CRC32 crc32 = new CRC32();
        long j4 = centralDirectory.size;
        randomAccessFile.seek(centralDirectory.offset);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j4));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j4 -= (long) read;
            if (j4 == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j4));
        }
        return crc32.getValue();
    }

    static CentralDirectory findCentralDirectory(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length();
        long j4 = length - 22;
        long j5 = 0;
        if (j4 >= 0) {
            long j6 = length - 65558;
            if (j6 >= 0) {
                j5 = j6;
            }
            int reverseBytes = Integer.reverseBytes(ENDSIG);
            do {
                randomAccessFile.seek(j4);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    CentralDirectory centralDirectory = new CentralDirectory();
                    centralDirectory.size = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    centralDirectory.offset = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                    return centralDirectory;
                }
                j4--;
            } while (j4 >= j5);
            throw new ZipException("End Of Central Directory signature not found");
        }
        throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
    }

    static long getZipCrc(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, CampaignEx.JSON_KEY_AD_R);
        try {
            return computeCrcOfCentralDir(randomAccessFile, findCentralDirectory(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}
