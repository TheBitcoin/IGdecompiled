package androidx.datastore.core;

import d3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.FileStorageConnection", f = "FileStorage.kt", l = {213, 118}, m = "writeScope")
final class FileStorageConnection$writeScope$1 extends d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileStorageConnection<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileStorageConnection$writeScope$1(FileStorageConnection<T> fileStorageConnection, V2.d dVar) {
        super(dVar);
        this.this$0 = fileStorageConnection;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeScope((p) null, this);
    }
}
