package androidx.datastore.core;

import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;

@f(c = "androidx.datastore.core.FileWriteScope", f = "FileStorage.kt", l = {200}, m = "writeData")
final class FileWriteScope$writeData$1 extends d {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FileWriteScope<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileWriteScope$writeData$1(FileWriteScope<T> fileWriteScope, V2.d dVar) {
        super(dVar);
        this.this$0 = fileWriteScope;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeData(null, this);
    }
}
