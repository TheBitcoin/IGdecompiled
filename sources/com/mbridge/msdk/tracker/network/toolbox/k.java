package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.MediaType;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.tracker.network.h;
import com.mbridge.msdk.tracker.network.q;
import com.mbridge.msdk.tracker.network.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f15623a;

    public k() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Dispatcher dispatcher = new Dispatcher(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, timeUnit, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false)));
        dispatcher.setMaxRequestsPerHost(50);
        dispatcher.setMaxRequests(256);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30, timeUnit);
        builder.connectTimeout(30, timeUnit);
        builder.writeTimeout(30, timeUnit);
        builder.retryOnConnectionFailure(true);
        builder.connectionPool(new ConnectionPool(32, 5, TimeUnit.MINUTES));
        builder.dispatcher(dispatcher);
        this.f15623a = builder.build();
    }

    private static RequestBody a(u uVar) {
        byte[] p4;
        if (uVar == null || (p4 = uVar.p()) == null) {
            return null;
        }
        return RequestBody.create((MediaType) null, p4);
    }

    public final g a(u<?> uVar, Map<String, String> map) throws IOException {
        int i4;
        q z4 = uVar.z();
        if (this.f15623a != null) {
            int u4 = uVar.u() <= 0 ? 30000 : uVar.u();
            long v4 = uVar.v();
            String a5 = uVar.i() == 0 ? d.a(uVar.k(), uVar) : uVar.k();
            if (z4 != null) {
                z4.a(a5);
                long j4 = (long) u4;
                z4.b(j4);
                z4.c(j4);
                z4.d(j4);
                z4.j(uVar.g());
            }
            if (z4 != null) {
                try {
                    z4.i(uVar.q());
                } catch (Exception unused) {
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Protocol.HTTP_1_1);
            arrayList.add(Protocol.HTTP_2);
            OkHttpClient.Builder protocols = this.f15623a.newBuilder().protocols(arrayList);
            long j5 = (long) u4;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            OkHttpClient.Builder callTimeout = protocols.readTimeout(j5, timeUnit).connectTimeout(j5, timeUnit).writeTimeout(j5, timeUnit).callTimeout(Math.max(v4, 0), timeUnit);
            if (!(z4 == null || callTimeout == null)) {
                try {
                    callTimeout.eventListener(new OKHTTPEventListener(z4));
                } catch (Exception unused2) {
                }
            }
            Request.Builder builder = new Request.Builder();
            for (Map.Entry next : uVar.c().entrySet()) {
                builder.addHeader((String) next.getKey(), (String) next.getValue());
            }
            builder.addHeader("Connection", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
            switch (uVar.i()) {
                case 0:
                    builder.get();
                    break;
                case 1:
                    RequestBody a6 = a(uVar);
                    if (a6 != null) {
                        builder.post(a6);
                        break;
                    } else {
                        throw new IOException("can't create request body for post");
                    }
                case 2:
                    RequestBody a7 = a(uVar);
                    if (a7 != null) {
                        builder.put(a7);
                        break;
                    } else {
                        throw new IOException("can't create request body for put");
                    }
                case 3:
                    builder.delete();
                    break;
                case 4:
                    builder.head();
                    break;
                case 5:
                    builder.method("OPTIONS", (RequestBody) null);
                    break;
                case 6:
                    builder.method("TRACE", (RequestBody) null);
                    break;
                case 7:
                    RequestBody a8 = a(uVar);
                    if (a8 != null) {
                        builder.patch(a8);
                        break;
                    } else {
                        throw new IOException("can't create request body for patch");
                    }
                default:
                    throw new IllegalStateException("Unknown method type.");
            }
            Response execute = callTimeout.build().newCall(builder.url(a5).build()).execute();
            Headers headers = execute.headers();
            ArrayList arrayList2 = new ArrayList();
            int size = headers.size();
            for (int i5 = 0; i5 < size; i5++) {
                String name = headers.name(i5);
                String value = headers.value(i5);
                if (name != null) {
                    arrayList2.add(new h(name, value));
                }
            }
            ResponseBody body = execute.body();
            if (body == null) {
                return new g(execute.code(), arrayList2);
            }
            int code = execute.code();
            if (body.contentLength() > 2147483647L) {
                i4 = -1;
            } else {
                i4 = (int) body.contentLength();
            }
            return new g(code, arrayList2, i4, body.byteStream());
        }
        throw new IOException("okhttp client is null");
    }
}
