package androidx.datastore.preferences.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() {
        public AllocatedBuffer allocateDirectBuffer(int i4) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(i4));
        }

        public AllocatedBuffer allocateHeapBuffer(int i4) {
            return AllocatedBuffer.wrap(new byte[i4]);
        }
    };

    BufferAllocator() {
    }

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }

    public abstract AllocatedBuffer allocateDirectBuffer(int i4);

    public abstract AllocatedBuffer allocateHeapBuffer(int i4);
}
