package com.mbridge.msdk.foundation.download.resource.stream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDownloadRandomAccessDownloadFile implements DownloadFileOutputStream {
    private final BufferedOutputStream bufferedOutputStream;
    private final FileDescriptor fileDescriptor;
    private final RandomAccessFile randomAccess;

    public FileDownloadRandomAccessDownloadFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.randomAccess = randomAccessFile;
        this.fileDescriptor = randomAccessFile.getFD();
        this.bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    public static DownloadFileOutputStream create(File file) throws IOException {
        return new FileDownloadRandomAccessDownloadFile(file);
    }

    public void close() throws IOException {
        this.bufferedOutputStream.close();
        this.randomAccess.close();
    }

    public void flushAndSync() throws IOException {
        this.bufferedOutputStream.flush();
        this.fileDescriptor.sync();
    }

    public void seek(long j4) throws IOException {
        this.randomAccess.seek(j4);
    }

    public void setLength(long j4) throws IOException {
        this.randomAccess.setLength(j4);
    }

    public void write(byte[] bArr, int i4, int i5) throws IOException {
        this.bufferedOutputStream.write(bArr, i4, i5);
    }
}
