package androidx.privacysandbox.ads.adservices.measurement;

import S2.C1601o;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import j$.time.Instant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;

@RequiresApi(33)
public final class DeletionRequest {
    public static final Companion Companion = new Companion((C2103g) null);
    public static final int DELETION_MODE_ALL = 0;
    public static final int DELETION_MODE_EXCLUDE_INTERNAL_DATA = 1;
    public static final int MATCH_BEHAVIOR_DELETE = 0;
    public static final int MATCH_BEHAVIOR_PRESERVE = 1;
    private final int deletionMode;
    private final List<Uri> domainUris;
    private final Instant end;
    private final int matchBehavior;
    private final List<Uri> originUris;
    private final Instant start;

    @RequiresApi(33)
    public static final class Builder {
        private final int deletionMode;
        private List<? extends Uri> domainUris = C1601o.h();
        private Instant end;
        private final int matchBehavior;
        private List<? extends Uri> originUris = C1601o.h();
        private Instant start;

        public Builder(int i4, int i5) {
            this.deletionMode = i4;
            this.matchBehavior = i5;
            Instant instant = Instant.MIN;
            m.d(instant, "MIN");
            this.start = instant;
            Instant instant2 = Instant.MAX;
            m.d(instant2, "MAX");
            this.end = instant2;
        }

        public final DeletionRequest build() {
            return new DeletionRequest(this.deletionMode, this.matchBehavior, this.start, this.end, this.domainUris, this.originUris);
        }

        public final Builder setDomainUris(List<? extends Uri> list) {
            m.e(list, "domainUris");
            this.domainUris = list;
            return this;
        }

        public final Builder setEnd(Instant instant) {
            m.e(instant, TtmlNode.END);
            this.end = instant;
            return this;
        }

        public final Builder setOriginUris(List<? extends Uri> list) {
            m.e(list, "originUris");
            this.originUris = list;
            return this;
        }

        public final Builder setStart(Instant instant) {
            m.e(instant, "start");
            this.start = instant;
            return this;
        }
    }

    public static final class Companion {

        @Retention(RetentionPolicy.SOURCE)
        public @interface DeletionMode {
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface MatchBehavior {
        }

        public /* synthetic */ Companion(C2103g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public DeletionRequest(int i4, int i5, Instant instant, Instant instant2, List<? extends Uri> list, List<? extends Uri> list2) {
        m.e(instant, "start");
        m.e(instant2, TtmlNode.END);
        m.e(list, "domainUris");
        m.e(list2, "originUris");
        this.deletionMode = i4;
        this.matchBehavior = i5;
        this.start = instant;
        this.end = instant2;
        this.domainUris = list;
        this.originUris = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeletionRequest)) {
            return false;
        }
        DeletionRequest deletionRequest = (DeletionRequest) obj;
        if (this.deletionMode != deletionRequest.deletionMode || !m.a(new HashSet(this.domainUris), new HashSet(deletionRequest.domainUris)) || !m.a(new HashSet(this.originUris), new HashSet(deletionRequest.originUris)) || !m.a(this.start, deletionRequest.start) || !m.a(this.end, deletionRequest.end) || this.matchBehavior != deletionRequest.matchBehavior) {
            return false;
        }
        return true;
    }

    public final int getDeletionMode() {
        return this.deletionMode;
    }

    public final List<Uri> getDomainUris() {
        return this.domainUris;
    }

    public final Instant getEnd() {
        return this.end;
    }

    public final int getMatchBehavior() {
        return this.matchBehavior;
    }

    public final List<Uri> getOriginUris() {
        return this.originUris;
    }

    public final Instant getStart() {
        return this.start;
    }

    public int hashCode() {
        return (((((((((this.deletionMode * 31) + this.domainUris.hashCode()) * 31) + this.originUris.hashCode()) * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + this.matchBehavior;
    }

    public String toString() {
        String str;
        String str2;
        if (this.deletionMode == 0) {
            str = "DELETION_MODE_ALL";
        } else {
            str = "DELETION_MODE_EXCLUDE_INTERNAL_DATA";
        }
        if (this.matchBehavior == 0) {
            str2 = "MATCH_BEHAVIOR_DELETE";
        } else {
            str2 = "MATCH_BEHAVIOR_PRESERVE";
        }
        return "DeletionRequest { DeletionMode=" + str + ", MatchBehavior=" + str2 + ", Start=" + this.start + ", End=" + this.end + ", DomainUris=" + this.domainUris + ", OriginUris=" + this.originUris + " }";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeletionRequest(int r8, int r9, j$.time.Instant r10, j$.time.Instant r11, java.util.List r12, java.util.List r13, int r14, kotlin.jvm.internal.C2103g r15) {
        /*
            r7 = this;
            r15 = r14 & 4
            if (r15 == 0) goto L_0x000b
            j$.time.Instant r10 = j$.time.Instant.MIN
            java.lang.String r15 = "MIN"
            kotlin.jvm.internal.m.d(r10, r15)
        L_0x000b:
            r3 = r10
            r10 = r14 & 8
            if (r10 == 0) goto L_0x0017
            j$.time.Instant r11 = j$.time.Instant.MAX
            java.lang.String r10 = "MAX"
            kotlin.jvm.internal.m.d(r11, r10)
        L_0x0017:
            r4 = r11
            r10 = r14 & 16
            if (r10 == 0) goto L_0x0020
            java.util.List r12 = S2.C1601o.h()
        L_0x0020:
            r5 = r12
            r10 = r14 & 32
            if (r10 == 0) goto L_0x0029
            java.util.List r13 = S2.C1601o.h()
        L_0x0029:
            r0 = r7
            r1 = r8
            r2 = r9
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.measurement.DeletionRequest.<init>(int, int, j$.time.Instant, j$.time.Instant, java.util.List, java.util.List, int, kotlin.jvm.internal.g):void");
    }
}
