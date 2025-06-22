package androidx.window.core;

import R2.k;
import S2.C1594h;
import androidx.window.core.SpecificationComputer;
import d3.l;
import kotlin.jvm.internal.m;

final class FailedSpecification<T> extends SpecificationComputer<T> {
    private final WindowStrictModeException exception;
    private final Logger logger;
    private final String message;
    private final String tag;
    private final T value;
    private final SpecificationComputer.VerificationMode verificationMode;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SpecificationComputer.VerificationMode.values().length];
            iArr[SpecificationComputer.VerificationMode.STRICT.ordinal()] = 1;
            iArr[SpecificationComputer.VerificationMode.LOG.ordinal()] = 2;
            iArr[SpecificationComputer.VerificationMode.QUIET.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FailedSpecification(T t4, String str, String str2, Logger logger2, SpecificationComputer.VerificationMode verificationMode2) {
        m.e(t4, "value");
        m.e(str, "tag");
        m.e(str2, "message");
        m.e(logger2, "logger");
        m.e(verificationMode2, "verificationMode");
        this.value = t4;
        this.tag = str;
        this.message = str2;
        this.logger = logger2;
        this.verificationMode = verificationMode2;
        WindowStrictModeException windowStrictModeException = new WindowStrictModeException(createMessage(t4, str2));
        StackTraceElement[] stackTrace = windowStrictModeException.getStackTrace();
        m.d(stackTrace, "stackTrace");
        Object[] array = C1594h.p(stackTrace, 2).toArray(new StackTraceElement[0]);
        if (array != null) {
            windowStrictModeException.setStackTrace((StackTraceElement[]) array);
            this.exception = windowStrictModeException;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public T compute() {
        int i4 = WhenMappings.$EnumSwitchMapping$0[this.verificationMode.ordinal()];
        if (i4 == 1) {
            throw this.exception;
        } else if (i4 == 2) {
            this.logger.debug(this.tag, createMessage(this.value, this.message));
            return null;
        } else if (i4 == 3) {
            return null;
        } else {
            throw new k();
        }
    }

    public final WindowStrictModeException getException() {
        return this.exception;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getTag() {
        return this.tag;
    }

    public final T getValue() {
        return this.value;
    }

    public final SpecificationComputer.VerificationMode getVerificationMode() {
        return this.verificationMode;
    }

    public SpecificationComputer<T> require(String str, l lVar) {
        m.e(str, "message");
        m.e(lVar, "condition");
        return this;
    }
}
