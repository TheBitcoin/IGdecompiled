package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okio.BufferedSource;
import java.io.IOException;
import java.util.List;

public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        public boolean onData(int i4, BufferedSource bufferedSource, int i5, boolean z4) throws IOException {
            bufferedSource.skip((long) i5);
            return true;
        }

        public boolean onHeaders(int i4, List<Header> list, boolean z4) {
            return true;
        }

        public boolean onRequest(int i4, List<Header> list) {
            return true;
        }

        public void onReset(int i4, ErrorCode errorCode) {
        }
    };

    boolean onData(int i4, BufferedSource bufferedSource, int i5, boolean z4) throws IOException;

    boolean onHeaders(int i4, List<Header> list, boolean z4);

    boolean onRequest(int i4, List<Header> list);

    void onReset(int i4, ErrorCode errorCode);
}
