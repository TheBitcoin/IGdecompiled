package androidx.datastore.core;

import V2.g;
import d3.p;
import kotlin.jvm.internal.C2103g;
import kotlin.jvm.internal.m;
import o3.C1006v;

public abstract class Message<T> {

    public static final class Read<T> extends Message<T> {
        private final State<T> lastState;

        public Read(State<T> state) {
            super((C2103g) null);
            this.lastState = state;
        }

        public State<T> getLastState() {
            return this.lastState;
        }
    }

    public static final class Update<T> extends Message<T> {
        private final C1006v ack;
        private final g callerContext;
        private final State<T> lastState;
        private final p transform;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Update(p pVar, C1006v vVar, State<T> state, g gVar) {
            super((C2103g) null);
            m.e(pVar, "transform");
            m.e(vVar, "ack");
            m.e(gVar, "callerContext");
            this.transform = pVar;
            this.ack = vVar;
            this.lastState = state;
            this.callerContext = gVar;
        }

        public final C1006v getAck() {
            return this.ack;
        }

        public final g getCallerContext() {
            return this.callerContext;
        }

        public State<T> getLastState() {
            return this.lastState;
        }

        public final p getTransform() {
            return this.transform;
        }
    }

    public /* synthetic */ Message(C2103g gVar) {
        this();
    }

    public abstract State<T> getLastState();

    private Message() {
    }
}
