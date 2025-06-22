package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CheckReturnValue
abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE = new ListFieldSchemaFull();
    private static final ListFieldSchema LITE_INSTANCE = new ListFieldSchemaLite();

    private static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = DesugarCollections.unmodifiableList(Collections.EMPTY_LIST).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        static <E> List<E> getList(Object obj, long j4) {
            return (List) UnsafeUtil.getObject(obj, j4);
        }

        /* access modifiers changed from: package-private */
        public void makeImmutableListAt(Object obj, long j4) {
            Object obj2;
            List list = (List) UnsafeUtil.getObject(obj, j4);
            if (list instanceof LazyStringList) {
                obj2 = ((LazyStringList) list).getUnmodifiableView();
            } else if (!UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                    obj2 = DesugarCollections.unmodifiableList(list);
                } else {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            UnsafeUtil.putObject(obj, j4, obj2);
        }

        /* access modifiers changed from: package-private */
        public <E> void mergeListsAt(Object obj, Object obj2, long j4) {
            List list = getList(obj2, j4);
            List mutableListAt = mutableListAt(obj, j4, list.size());
            int size = mutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                mutableListAt.addAll(list);
            }
            if (size > 0) {
                list = mutableListAt;
            }
            UnsafeUtil.putObject(obj, j4, (Object) list);
        }

        /* access modifiers changed from: package-private */
        public <L> List<L> mutableListAt(Object obj, long j4) {
            return mutableListAt(obj, j4, 10);
        }

        private static <L> List<L> mutableListAt(Object obj, long j4, int i4) {
            List<L> list;
            List<L> list2 = getList(obj, j4);
            if (list2.isEmpty()) {
                if (list2 instanceof LazyStringList) {
                    list = new LazyStringArrayList(i4);
                } else if (!(list2 instanceof PrimitiveNonBoxingCollection) || !(list2 instanceof Internal.ProtobufList)) {
                    list = new ArrayList<>(i4);
                } else {
                    list = ((Internal.ProtobufList) list2).mutableCopyWithCapacity(i4);
                }
                UnsafeUtil.putObject(obj, j4, (Object) list);
                return list;
            } else if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + i4);
                arrayList.addAll(list2);
                UnsafeUtil.putObject(obj, j4, (Object) arrayList);
                return arrayList;
            } else if (list2 instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(list2.size() + i4);
                lazyStringArrayList.addAll((UnmodifiableLazyStringList) list2);
                UnsafeUtil.putObject(obj, j4, (Object) lazyStringArrayList);
                return lazyStringArrayList;
            } else {
                if ((list2 instanceof PrimitiveNonBoxingCollection) && (list2 instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list2;
                    if (!protobufList.isModifiable()) {
                        Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(list2.size() + i4);
                        UnsafeUtil.putObject(obj, j4, (Object) mutableCopyWithCapacity);
                        return mutableCopyWithCapacity;
                    }
                }
                return list2;
            }
        }
    }

    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j4) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j4);
        }

        /* access modifiers changed from: package-private */
        public void makeImmutableListAt(Object obj, long j4) {
            getProtobufList(obj, j4).makeImmutable();
        }

        /* access modifiers changed from: package-private */
        public <E> void mergeListsAt(Object obj, Object obj2, long j4) {
            Internal.ProtobufList protobufList = getProtobufList(obj, j4);
            Internal.ProtobufList protobufList2 = getProtobufList(obj2, j4);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.isModifiable()) {
                    protobufList = protobufList.mutableCopyWithCapacity(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            if (size > 0) {
                protobufList2 = protobufList;
            }
            UnsafeUtil.putObject(obj, j4, (Object) protobufList2);
        }

        /* access modifiers changed from: package-private */
        public <L> List<L> mutableListAt(Object obj, long j4) {
            int i4;
            Internal.ProtobufList protobufList = getProtobufList(obj, j4);
            if (protobufList.isModifiable()) {
                return protobufList;
            }
            int size = protobufList.size();
            if (size == 0) {
                i4 = 10;
            } else {
                i4 = size * 2;
            }
            Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(i4);
            UnsafeUtil.putObject(obj, j4, (Object) mutableCopyWithCapacity);
            return mutableCopyWithCapacity;
        }
    }

    static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    /* access modifiers changed from: package-private */
    public abstract void makeImmutableListAt(Object obj, long j4);

    /* access modifiers changed from: package-private */
    public abstract <L> void mergeListsAt(Object obj, Object obj2, long j4);

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> mutableListAt(Object obj, long j4);

    private ListFieldSchema() {
    }
}
