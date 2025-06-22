package androidx.privacysandbox.ads.adservices.topics;

import j$.util.Objects;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.m;

public final class GetTopicsResponse {
    private final List<Topic> topics;

    public GetTopicsResponse(List<Topic> list) {
        m.e(list, "topics");
        this.topics = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (this.topics.size() != getTopicsResponse.topics.size()) {
            return false;
        }
        return m.a(new HashSet(this.topics), new HashSet(getTopicsResponse.topics));
    }

    public final List<Topic> getTopics() {
        return this.topics;
    }

    public int hashCode() {
        return Objects.hash(this.topics);
    }

    public String toString() {
        return "Topics=" + this.topics;
    }
}
