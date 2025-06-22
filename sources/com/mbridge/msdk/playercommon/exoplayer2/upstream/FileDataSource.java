package com.mbridge.msdk.playercommon.exoplayer2.upstream;

import android.net.Uri;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource implements DataSource {
    private long bytesRemaining;
    private RandomAccessFile file;
    private final TransferListener<? super FileDataSource> listener;
    private boolean opened;
    private Uri uri;

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException iOException) {
            super(iOException);
        }
    }

    public FileDataSource() {
        this((TransferListener<? super FileDataSource>) null);
    }

    public final void close() throws FileDataSourceException {
        this.uri = null;
        try {
            RandomAccessFile randomAccessFile = this.file;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.file = null;
            if (this.opened) {
                this.opened = false;
                TransferListener<? super FileDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferEnd(this);
                }
            }
        } catch (IOException e5) {
            throw new FileDataSourceException(e5);
        } catch (Throwable th) {
            this.file = null;
            if (this.opened) {
                this.opened = false;
                TransferListener<? super FileDataSource> transferListener2 = this.listener;
                if (transferListener2 != null) {
                    transferListener2.onTransferEnd(this);
                }
            }
            throw th;
        }
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final long open(DataSpec dataSpec) throws FileDataSourceException {
        try {
            this.uri = dataSpec.uri;
            RandomAccessFile randomAccessFile = new RandomAccessFile(dataSpec.uri.getPath(), CampaignEx.JSON_KEY_AD_R);
            this.file = randomAccessFile;
            randomAccessFile.seek(dataSpec.position);
            long j4 = dataSpec.length;
            if (j4 == -1) {
                j4 = this.file.length() - dataSpec.position;
            }
            this.bytesRemaining = j4;
            if (j4 >= 0) {
                this.opened = true;
                TransferListener<? super FileDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onTransferStart(this, dataSpec);
                }
                return this.bytesRemaining;
            }
            throw new EOFException();
        } catch (IOException e5) {
            throw new FileDataSourceException(e5);
        }
    }

    public final int read(byte[] bArr, int i4, int i5) throws FileDataSourceException {
        if (i5 == 0) {
            return 0;
        }
        long j4 = this.bytesRemaining;
        if (j4 == 0) {
            return -1;
        }
        try {
            int read = this.file.read(bArr, i4, (int) Math.min(j4, (long) i5));
            if (read > 0) {
                this.bytesRemaining -= (long) read;
                TransferListener<? super FileDataSource> transferListener = this.listener;
                if (transferListener != null) {
                    transferListener.onBytesTransferred(this, read);
                }
            }
            return read;
        } catch (IOException e5) {
            throw new FileDataSourceException(e5);
        }
    }

    public FileDataSource(TransferListener<? super FileDataSource> transferListener) {
        this.listener = transferListener;
    }
}
