package androidx.window.core;

import d3.l;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

public abstract class SpecificationComputer<T> {
    public static final Companion Companion = new Companion((C2103g) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        public static /* synthetic */ SpecificationComputer startSpecification$default(Companion companion, Object obj, String str, VerificationMode verificationMode, Logger logger, int i4, Object obj2) {
            if ((i4 & 2) != 0) {
                verificationMode = BuildConfig.INSTANCE.getVerificationMode();
            }
            if ((i4 & 4) != 0) {
                logger = AndroidLogger.INSTANCE;
            }
            return companion.startSpecification(obj, str, verificationMode, logger);
        }

        public final <T> SpecificationComputer<T> startSpecification(T t4, String str, VerificationMode verificationMode, Logger logger) {
            m.e(t4, "<this>");
            m.e(str, "tag");
            m.e(verificationMode, "verificationMode");
            m.e(logger, "logger");
            return new ValidSpecification(t4, str, verificationMode, logger);
        }

        private Companion() {
        }
    }

    public enum VerificationMode {
        STRICT,
        LOG,
        QUIET
    }

    public abstract T compute();

    /* access modifiers changed from: protected */
    public final String createMessage(Object obj, String str) {
        m.e(obj, "value");
        m.e(str, "message");
        return str + " value: " + obj;
    }

    public abstract SpecificationComputer<T> require(String str, l lVar);
}
