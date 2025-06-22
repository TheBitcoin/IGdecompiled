package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ArrayDecoders;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final boolean proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;

    /* renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.datastore.preferences.protobuf.WireFormat$FieldType[] r0 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$WireFormat$FieldType = r0
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BOOL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.BYTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED32     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED32     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FIXED64     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SFIXED64     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.ENUM     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT32     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0084 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT32     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x0090 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.INT64     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x009c }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.UINT64     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00a8 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.MESSAGE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00b4 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT32     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00c0 }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.SINT64     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$google$protobuf$WireFormat$FieldType     // Catch:{ NoSuchFieldError -> 0x00cc }
                androidx.datastore.preferences.protobuf.WireFormat$FieldType r1 = androidx.datastore.preferences.protobuf.WireFormat.FieldType.STRING     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.AnonymousClass1.<clinit>():void");
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i4, int i5, MessageLite messageLite, boolean z4, boolean z5, int[] iArr2, int i6, int i7, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i4;
        this.maxFieldNumber = i5;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.proto3 = z4;
        this.hasExtensions = extensionSchema2 != null && extensionSchema2.hasExtensions(messageLite);
        this.useCachedSizeField = z5;
        this.intArray = iArr2;
        this.checkInitializedCount = i6;
        this.repeatedFieldOffsetStart = i7;
        this.newInstanceSchema = newInstanceSchema2;
        this.listFieldSchema = listFieldSchema2;
        this.unknownFieldSchema = unknownFieldSchema2;
        this.extensionSchema = extensionSchema2;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema2;
    }

    private boolean arePresentForEquals(T t4, T t5, int i4) {
        if (isFieldPresent(t4, i4) == isFieldPresent(t5, i4)) {
            return true;
        }
        return false;
    }

    private static <T> boolean booleanAt(T t4, long j4) {
        return UnsafeUtil.getBoolean((Object) t4, j4);
    }

    private static void checkMutable(Object obj) {
        if (!isMutable(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: " + obj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <K, V> int decodeMapEntry(byte[] r11, int r12, int r13, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata<K, V> r14, java.util.Map<K, V> r15, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r16) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r16
            int r12 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r11, r12, r6)
            int r0 = r6.int1
            if (r0 < 0) goto L_0x006f
            int r1 = r13 - r12
            if (r0 > r1) goto L_0x006f
            int r7 = r12 + r0
            K r0 = r14.defaultKey
            V r1 = r14.defaultValue
            r8 = r0
            r9 = r1
        L_0x0016:
            if (r12 >= r7) goto L_0x0064
            int r0 = r12 + 1
            byte r12 = r11[r12]
            if (r12 >= 0) goto L_0x0024
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r12, r11, r0, r6)
            int r12 = r6.int1
        L_0x0024:
            r2 = r0
            int r0 = r12 >>> 3
            r1 = r12 & 7
            r3 = 1
            if (r0 == r3) goto L_0x004a
            r3 = 2
            if (r0 == r3) goto L_0x0030
            goto L_0x005f
        L_0x0030:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = r14.valueType
            int r0 = r0.getWireType()
            if (r1 != r0) goto L_0x005f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r14.valueType
            V r12 = r14.defaultValue
            java.lang.Class r5 = r12.getClass()
            r0 = r10
            r1 = r11
            r3 = r13
            int r12 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r9 = r6.object1
            goto L_0x0016
        L_0x004a:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = r14.keyType
            int r0 = r0.getWireType()
            if (r1 != r0) goto L_0x005f
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r14.keyType
            r5 = 0
            r0 = r10
            r1 = r11
            r3 = r13
            int r12 = r0.decodeMapEntryValue(r1, r2, r3, r4, r5, r6)
            java.lang.Object r8 = r6.object1
            goto L_0x0016
        L_0x005f:
            int r12 = androidx.datastore.preferences.protobuf.ArrayDecoders.skipField(r12, r11, r2, r13, r6)
            goto L_0x0016
        L_0x0064:
            if (r12 != r7) goto L_0x006a
            r15.put(r8, r9)
            return r7
        L_0x006a:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r11 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r11
        L_0x006f:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r11 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.truncatedMessage()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.decodeMapEntry(byte[], int, int, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, java.util.Map, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    private int decodeMapEntryValue(byte[] bArr, int i4, int i5, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) throws IOException {
        boolean z4;
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i4, registers);
                if (registers.long1 != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                registers.object1 = Boolean.valueOf(z4);
                return decodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i4, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i4));
                return i4 + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i4));
                return i4 + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i4));
                return i4 + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i4));
                return i4 + 4;
            case 9:
            case 10:
            case 11:
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i4, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return decodeVarint32;
            case 12:
            case 13:
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i4, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return decodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(cls), bArr, i4, i5, registers);
            case 15:
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i4, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return decodeVarint322;
            case 16:
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i4, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return decodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i4, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t4, long j4) {
        return UnsafeUtil.getDouble((Object) t4, j4);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i4, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int numberAt = numberAt(i4);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i4)));
        if (object == null || (enumFieldVerifier = getEnumFieldVerifier(i4)) == null) {
            return ub;
        }
        return filterUnknownEnumMap(i4, numberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema2, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i4, int i5, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema2, Object obj) {
        MapEntryLite.Metadata<?, ?> forMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i4));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema2.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(forMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(newCodedBuilder.getCodedOutput(), forMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema2.addLengthDelimited(ub, i5, newCodedBuilder.build());
                    it.remove();
                } catch (IOException e5) {
                    throw new RuntimeException(e5);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t4, long j4) {
        return UnsafeUtil.getFloat((Object) t4, j4);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i4) {
        return (Internal.EnumVerifier) this.objects[((i4 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i4) {
        return this.objects[(i4 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i4) {
        int i5 = (i4 / 3) * 2;
        Schema schema = (Schema) this.objects[i5];
        if (schema != null) {
            return schema;
        }
        Schema schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i5 + 1]);
        this.objects[i5] = schemaFor;
        return schemaFor;
    }

    static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite newInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = newInstance;
        return newInstance;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0521, code lost:
        r5 = r5 + 3;
        r4 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01bd, code lost:
        r6 = r6 + ((r4 + r9) + r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSerializedSizeProto2(T r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            sun.misc.Unsafe r2 = UNSAFE
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 0
        L_0x000f:
            int[] r9 = r0.buffer
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0528
            int r9 = r0.typeAndOffsetAt(r5)
            int r10 = r0.numberAt(r5)
            int r11 = type(r9)
            r12 = 17
            r13 = 1
            if (r11 > r12) goto L_0x003a
            int[] r12 = r0.buffer
            int r14 = r5 + 2
            r12 = r12[r14]
            r14 = r12 & r4
            int r15 = r12 >>> 20
            int r15 = r13 << r15
            if (r14 == r7) goto L_0x0059
            long r7 = (long) r14
            int r8 = r2.getInt(r1, r7)
            r7 = r14
            goto L_0x0059
        L_0x003a:
            boolean r12 = r0.useCachedSizeField
            if (r12 == 0) goto L_0x0057
            androidx.datastore.preferences.protobuf.FieldType r12 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r12 = r12.id()
            if (r11 < r12) goto L_0x0057
            androidx.datastore.preferences.protobuf.FieldType r12 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r12 = r12.id()
            if (r11 > r12) goto L_0x0057
            int[] r12 = r0.buffer
            int r14 = r5 + 2
            r12 = r12[r14]
            r12 = r12 & r4
        L_0x0055:
            r15 = 0
            goto L_0x0059
        L_0x0057:
            r12 = 0
            goto L_0x0055
        L_0x0059:
            long r13 = offset(r9)
            r9 = 0
            r3 = 0
            switch(r11) {
                case 0: goto L_0x0515;
                case 1: goto L_0x050b;
                case 2: goto L_0x04fd;
                case 3: goto L_0x04ef;
                case 4: goto L_0x04e1;
                case 5: goto L_0x04d7;
                case 6: goto L_0x04cc;
                case 7: goto L_0x04c1;
                case 8: goto L_0x04a5;
                case 9: goto L_0x0493;
                case 10: goto L_0x0483;
                case 11: goto L_0x0475;
                case 12: goto L_0x0467;
                case 13: goto L_0x045c;
                case 14: goto L_0x0452;
                case 15: goto L_0x0444;
                case 16: goto L_0x0436;
                case 17: goto L_0x0422;
                case 18: goto L_0x0415;
                case 19: goto L_0x0408;
                case 20: goto L_0x03fb;
                case 21: goto L_0x03ee;
                case 22: goto L_0x03e1;
                case 23: goto L_0x03d4;
                case 24: goto L_0x03c7;
                case 25: goto L_0x03ba;
                case 26: goto L_0x03ae;
                case 27: goto L_0x039e;
                case 28: goto L_0x0392;
                case 29: goto L_0x0385;
                case 30: goto L_0x0378;
                case 31: goto L_0x036b;
                case 32: goto L_0x035e;
                case 33: goto L_0x0351;
                case 34: goto L_0x0344;
                case 35: goto L_0x0326;
                case 36: goto L_0x0308;
                case 37: goto L_0x02ea;
                case 38: goto L_0x02cc;
                case 39: goto L_0x02ae;
                case 40: goto L_0x0290;
                case 41: goto L_0x0272;
                case 42: goto L_0x0254;
                case 43: goto L_0x0236;
                case 44: goto L_0x0219;
                case 45: goto L_0x01fc;
                case 46: goto L_0x01df;
                case 47: goto L_0x01c2;
                case 48: goto L_0x01a1;
                case 49: goto L_0x0191;
                case 50: goto L_0x0181;
                case 51: goto L_0x0173;
                case 52: goto L_0x0167;
                case 53: goto L_0x0157;
                case 54: goto L_0x0147;
                case 55: goto L_0x0137;
                case 56: goto L_0x012b;
                case 57: goto L_0x011e;
                case 58: goto L_0x0111;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00e0;
                case 61: goto L_0x00cf;
                case 62: goto L_0x00c0;
                case 63: goto L_0x00b1;
                case 64: goto L_0x00a5;
                case 65: goto L_0x009a;
                case 66: goto L_0x008b;
                case 67: goto L_0x007c;
                case 68: goto L_0x0064;
                default: goto L_0x0063;
            }
        L_0x0063:
            goto L_0x0079
        L_0x0064:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r13)
            androidx.datastore.preferences.protobuf.MessageLite r3 = (androidx.datastore.preferences.protobuf.MessageLite) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeGroupSize(r10, r3, r4)
        L_0x0078:
            int r6 = r6 + r3
        L_0x0079:
            r11 = 0
            goto L_0x0521
        L_0x007c:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            long r3 = oneofLongAt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r10, r3)
            goto L_0x0078
        L_0x008b:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = oneofIntAt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r10, r3)
            goto L_0x0078
        L_0x009a:
            boolean r9 = r0.isOneofPresent(r1, r10, r5)
            if (r9 == 0) goto L_0x0079
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r10, r3)
            goto L_0x0078
        L_0x00a5:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            r9 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r10, r9)
            goto L_0x0078
        L_0x00b1:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = oneofIntAt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r10, r3)
            goto L_0x0078
        L_0x00c0:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = oneofIntAt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r10, r3)
            goto L_0x0078
        L_0x00cf:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r13)
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r10, r3)
            goto L_0x0078
        L_0x00e0:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r13)
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessage(r10, r3, r4)
            goto L_0x0078
        L_0x00f3:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r13)
            boolean r4 = r3 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r4 == 0) goto L_0x0109
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r10, r3)
            goto L_0x0078
        L_0x0109:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r10, r3)
            goto L_0x0078
        L_0x0111:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            r3 = 1
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r10, r3)
            goto L_0x0078
        L_0x011e:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            r9 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r10, r9)
            goto L_0x0078
        L_0x012b:
            boolean r9 = r0.isOneofPresent(r1, r10, r5)
            if (r9 == 0) goto L_0x0079
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r10, r3)
            goto L_0x0078
        L_0x0137:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = oneofIntAt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r10, r3)
            goto L_0x0078
        L_0x0147:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            long r3 = oneofLongAt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r10, r3)
            goto L_0x0078
        L_0x0157:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            long r3 = oneofLongAt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r10, r3)
            goto L_0x0078
        L_0x0167:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r10, r9)
            goto L_0x0078
        L_0x0173:
            boolean r3 = r0.isOneofPresent(r1, r10, r5)
            if (r3 == 0) goto L_0x0079
            r3 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r10, r3)
            goto L_0x0078
        L_0x0181:
            androidx.datastore.preferences.protobuf.MapFieldSchema r3 = r0.mapFieldSchema
            java.lang.Object r4 = r2.getObject(r1, r13)
            java.lang.Object r9 = r0.getMapFieldDefaultEntry(r5)
            int r3 = r3.getSerializedSize(r10, r4, r9)
            goto L_0x0078
        L_0x0191:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeGroupList(r10, r3, r4)
            goto L_0x0078
        L_0x01a1:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01b5
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x01b5:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
        L_0x01bd:
            int r4 = r4 + r9
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x0079
        L_0x01c2:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01d6
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x01d6:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x01df:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x01f3
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x01f3:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x01fc:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0210
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0210:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x0219:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeEnumListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x022d
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x022d:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x0236:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x024a
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x024a:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x0254:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeBoolListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0268
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0268:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x0272:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x0286
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x0286:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x0290:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02a4
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x02a4:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x02ae:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02c2
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x02c2:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x02cc:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02e0
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x02e0:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x02ea:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x02fe
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x02fe:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x0308:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x031c
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x031c:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x0326:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r3)
            if (r3 <= 0) goto L_0x0079
            boolean r4 = r0.useCachedSizeField
            if (r4 == 0) goto L_0x033a
            long r11 = (long) r12
            r2.putInt(r1, r11, r3)
        L_0x033a:
            int r4 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r10)
            int r9 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r3)
            goto L_0x01bd
        L_0x0344:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt64List(r10, r3, r9)
            goto L_0x0078
        L_0x0351:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt32List(r10, r3, r9)
            goto L_0x0078
        L_0x035e:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r10, r3, r9)
            goto L_0x0078
        L_0x036b:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r10, r3, r9)
            goto L_0x0078
        L_0x0378:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeEnumList(r10, r3, r9)
            goto L_0x0078
        L_0x0385:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt32List(r10, r3, r9)
            goto L_0x0078
        L_0x0392:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeByteStringList(r10, r3)
            goto L_0x0078
        L_0x039e:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessageList(r10, r3, r4)
            goto L_0x0078
        L_0x03ae:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeStringList(r10, r3)
            goto L_0x0078
        L_0x03ba:
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeBoolList(r10, r3, r9)
            goto L_0x0078
        L_0x03c7:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r10, r3, r9)
            goto L_0x0078
        L_0x03d4:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r10, r3, r9)
            goto L_0x0078
        L_0x03e1:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt32List(r10, r3, r9)
            goto L_0x0078
        L_0x03ee:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt64List(r10, r3, r9)
            goto L_0x0078
        L_0x03fb:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt64List(r10, r3, r9)
            goto L_0x0078
        L_0x0408:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r10, r3, r9)
            goto L_0x0078
        L_0x0415:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r13)
            java.util.List r3 = (java.util.List) r3
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r10, r3, r9)
            goto L_0x0078
        L_0x0422:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r13)
            androidx.datastore.preferences.protobuf.MessageLite r3 = (androidx.datastore.preferences.protobuf.MessageLite) r3
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeGroupSize(r10, r3, r4)
            goto L_0x0078
        L_0x0436:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            long r3 = r2.getLong(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r10, r3)
            goto L_0x0078
        L_0x0444:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            int r3 = r2.getInt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r10, r3)
            goto L_0x0078
        L_0x0452:
            r11 = r8 & r15
            if (r11 == 0) goto L_0x0079
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r10, r3)
            goto L_0x0078
        L_0x045c:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            r9 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r10, r9)
            goto L_0x0078
        L_0x0467:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            int r3 = r2.getInt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r10, r3)
            goto L_0x0078
        L_0x0475:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            int r3 = r2.getInt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r10, r3)
            goto L_0x0078
        L_0x0483:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r13)
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r10, r3)
            goto L_0x0078
        L_0x0493:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r13)
            androidx.datastore.preferences.protobuf.Schema r4 = r0.getMessageFieldSchema(r5)
            int r3 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessage(r10, r3, r4)
            goto L_0x0078
        L_0x04a5:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            java.lang.Object r3 = r2.getObject(r1, r13)
            boolean r4 = r3 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r4 == 0) goto L_0x04b9
            androidx.datastore.preferences.protobuf.ByteString r3 = (androidx.datastore.preferences.protobuf.ByteString) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r10, r3)
            goto L_0x0078
        L_0x04b9:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r10, r3)
            goto L_0x0078
        L_0x04c1:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            r3 = 1
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r10, r3)
            goto L_0x0078
        L_0x04cc:
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0079
            r11 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r10, r11)
        L_0x04d5:
            int r6 = r6 + r3
            goto L_0x0521
        L_0x04d7:
            r11 = 0
            r9 = r8 & r15
            if (r9 == 0) goto L_0x0521
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r10, r3)
            goto L_0x04d5
        L_0x04e1:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0521
            int r3 = r2.getInt(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r10, r3)
            goto L_0x04d5
        L_0x04ef:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0521
            long r3 = r2.getLong(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r10, r3)
            goto L_0x04d5
        L_0x04fd:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0521
            long r3 = r2.getLong(r1, r13)
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r10, r3)
            goto L_0x04d5
        L_0x050b:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0521
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r10, r9)
            goto L_0x04d5
        L_0x0515:
            r11 = 0
            r3 = r8 & r15
            if (r3 == 0) goto L_0x0521
            r3 = 0
            int r3 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r10, r3)
            goto L_0x04d5
        L_0x0521:
            int r5 = r5 + 3
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000f
        L_0x0528:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            int r2 = r0.getUnknownFieldsSerializedSize(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.hasExtensions
            if (r2 == 0) goto L_0x053e
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r2 = r0.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r1 = r2.getExtensions(r1)
            int r1 = r1.getSerializedSize()
            int r6 = r6 + r1
        L_0x053e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.getSerializedSizeProto2(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int getSerializedSizeProto3(T r15) {
        /*
            r14 = this;
            r0 = r15
            sun.misc.Unsafe r1 = UNSAFE
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0006:
            int[] r5 = r14.buffer
            int r5 = r5.length
            if (r3 >= r5) goto L_0x04eb
            int r5 = r14.typeAndOffsetAt(r3)
            int r6 = type(r5)
            int r7 = r14.numberAt(r3)
            long r8 = offset(r5)
            androidx.datastore.preferences.protobuf.FieldType r5 = androidx.datastore.preferences.protobuf.FieldType.DOUBLE_LIST_PACKED
            int r5 = r5.id()
            if (r6 < r5) goto L_0x0036
            androidx.datastore.preferences.protobuf.FieldType r5 = androidx.datastore.preferences.protobuf.FieldType.SINT64_LIST_PACKED
            int r5 = r5.id()
            if (r6 > r5) goto L_0x0036
            int[] r5 = r14.buffer
            int r10 = r3 + 2
            r5 = r5[r10]
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r10
            goto L_0x0037
        L_0x0036:
            r5 = 0
        L_0x0037:
            r12 = 0
            r13 = 1
            r10 = 0
            switch(r6) {
                case 0: goto L_0x04d9;
                case 1: goto L_0x04cd;
                case 2: goto L_0x04bd;
                case 3: goto L_0x04ad;
                case 4: goto L_0x049d;
                case 5: goto L_0x0491;
                case 6: goto L_0x0485;
                case 7: goto L_0x0479;
                case 8: goto L_0x045b;
                case 9: goto L_0x0447;
                case 10: goto L_0x0435;
                case 11: goto L_0x0425;
                case 12: goto L_0x0415;
                case 13: goto L_0x0409;
                case 14: goto L_0x03fd;
                case 15: goto L_0x03ed;
                case 16: goto L_0x03dd;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03bd;
                case 19: goto L_0x03b3;
                case 20: goto L_0x03a9;
                case 21: goto L_0x039f;
                case 22: goto L_0x0395;
                case 23: goto L_0x038b;
                case 24: goto L_0x0381;
                case 25: goto L_0x0377;
                case 26: goto L_0x036d;
                case 27: goto L_0x035f;
                case 28: goto L_0x0355;
                case 29: goto L_0x034b;
                case 30: goto L_0x0341;
                case 31: goto L_0x0337;
                case 32: goto L_0x032d;
                case 33: goto L_0x0323;
                case 34: goto L_0x0319;
                case 35: goto L_0x02fb;
                case 36: goto L_0x02dd;
                case 37: goto L_0x02bf;
                case 38: goto L_0x02a1;
                case 39: goto L_0x0283;
                case 40: goto L_0x0265;
                case 41: goto L_0x0247;
                case 42: goto L_0x0229;
                case 43: goto L_0x020b;
                case 44: goto L_0x01ee;
                case 45: goto L_0x01d1;
                case 46: goto L_0x01b4;
                case 47: goto L_0x0197;
                case 48: goto L_0x0177;
                case 49: goto L_0x0169;
                case 50: goto L_0x0159;
                case 51: goto L_0x014b;
                case 52: goto L_0x013f;
                case 53: goto L_0x012f;
                case 54: goto L_0x011f;
                case 55: goto L_0x010f;
                case 56: goto L_0x0103;
                case 57: goto L_0x00f7;
                case 58: goto L_0x00eb;
                case 59: goto L_0x00cd;
                case 60: goto L_0x00ba;
                case 61: goto L_0x00a9;
                case 62: goto L_0x009a;
                case 63: goto L_0x008b;
                case 64: goto L_0x0080;
                case 65: goto L_0x0075;
                case 66: goto L_0x0066;
                case 67: goto L_0x0057;
                case 68: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x04e7
        L_0x0040:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r15, (long) r8)
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5
            androidx.datastore.preferences.protobuf.Schema r6 = r14.getMessageFieldSchema(r3)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeGroupSize(r7, r5, r6)
        L_0x0054:
            int r4 = r4 + r5
            goto L_0x04e7
        L_0x0057:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            long r5 = oneofLongAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r7, r5)
            goto L_0x0054
        L_0x0066:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = oneofIntAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r7, r5)
            goto L_0x0054
        L_0x0075:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r7, r10)
            goto L_0x0054
        L_0x0080:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r7, r2)
            goto L_0x0054
        L_0x008b:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = oneofIntAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r7, r5)
            goto L_0x0054
        L_0x009a:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = oneofIntAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r7, r5)
            goto L_0x0054
        L_0x00a9:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r15, (long) r8)
            androidx.datastore.preferences.protobuf.ByteString r5 = (androidx.datastore.preferences.protobuf.ByteString) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r7, r5)
            goto L_0x0054
        L_0x00ba:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r15, (long) r8)
            androidx.datastore.preferences.protobuf.Schema r6 = r14.getMessageFieldSchema(r3)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessage(r7, r5, r6)
            goto L_0x0054
        L_0x00cd:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r15, (long) r8)
            boolean r6 = r5 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r6 == 0) goto L_0x00e3
            androidx.datastore.preferences.protobuf.ByteString r5 = (androidx.datastore.preferences.protobuf.ByteString) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r7, r5)
            goto L_0x0054
        L_0x00e3:
            java.lang.String r5 = (java.lang.String) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r7, r5)
            goto L_0x0054
        L_0x00eb:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r7, r13)
            goto L_0x0054
        L_0x00f7:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r7, r2)
            goto L_0x0054
        L_0x0103:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r7, r10)
            goto L_0x0054
        L_0x010f:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = oneofIntAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r7, r5)
            goto L_0x0054
        L_0x011f:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            long r5 = oneofLongAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r7, r5)
            goto L_0x0054
        L_0x012f:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            long r5 = oneofLongAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r7, r5)
            goto L_0x0054
        L_0x013f:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r7, r12)
            goto L_0x0054
        L_0x014b:
            boolean r5 = r14.isOneofPresent(r15, r7, r3)
            if (r5 == 0) goto L_0x04e7
            r5 = 0
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r7, r5)
            goto L_0x0054
        L_0x0159:
            androidx.datastore.preferences.protobuf.MapFieldSchema r5 = r14.mapFieldSchema
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r15, (long) r8)
            java.lang.Object r8 = r14.getMapFieldDefaultEntry(r3)
            int r5 = r5.getSerializedSize(r7, r6, r8)
            goto L_0x0054
        L_0x0169:
            java.util.List r5 = listAt(r15, r8)
            androidx.datastore.preferences.protobuf.Schema r6 = r14.getMessageFieldSchema(r3)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeGroupList(r7, r5, r6)
            goto L_0x0054
        L_0x0177:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt64ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x018b
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x018b:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
        L_0x0193:
            int r5 = r5 + r7
            int r5 = r5 + r6
            goto L_0x0054
        L_0x0197:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt32ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x01ab
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x01ab:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x01b4:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x01c8
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x01c8:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x01d1:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x01e5
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x01e5:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x01ee:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeEnumListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x0202
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x0202:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x020b:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt32ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x021f
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x021f:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x0229:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeBoolListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x023d
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x023d:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x0247:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x025b
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x025b:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x0265:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x0279
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x0279:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x0283:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt32ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x0297
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x0297:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x02a1:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt64ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x02b5
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x02b5:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x02bf:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt64ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x02d3
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x02d3:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x02dd:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x02f1
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x02f1:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x02fb:
            java.lang.Object r6 = r1.getObject(r15, r8)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64ListNoTag(r6)
            if (r6 <= 0) goto L_0x04e7
            boolean r8 = r14.useCachedSizeField
            if (r8 == 0) goto L_0x030f
            long r8 = (long) r5
            r1.putInt(r15, r8, r6)
        L_0x030f:
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeTagSize(r7)
            int r7 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32SizeNoTag(r6)
            goto L_0x0193
        L_0x0319:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt64List(r7, r5, r2)
            goto L_0x0054
        L_0x0323:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeSInt32List(r7, r5, r2)
            goto L_0x0054
        L_0x032d:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r7, r5, r2)
            goto L_0x0054
        L_0x0337:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r7, r5, r2)
            goto L_0x0054
        L_0x0341:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeEnumList(r7, r5, r2)
            goto L_0x0054
        L_0x034b:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt32List(r7, r5, r2)
            goto L_0x0054
        L_0x0355:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeByteStringList(r7, r5)
            goto L_0x0054
        L_0x035f:
            java.util.List r5 = listAt(r15, r8)
            androidx.datastore.preferences.protobuf.Schema r6 = r14.getMessageFieldSchema(r3)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessageList(r7, r5, r6)
            goto L_0x0054
        L_0x036d:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeStringList(r7, r5)
            goto L_0x0054
        L_0x0377:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeBoolList(r7, r5, r2)
            goto L_0x0054
        L_0x0381:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r7, r5, r2)
            goto L_0x0054
        L_0x038b:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r7, r5, r2)
            goto L_0x0054
        L_0x0395:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt32List(r7, r5, r2)
            goto L_0x0054
        L_0x039f:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeUInt64List(r7, r5, r2)
            goto L_0x0054
        L_0x03a9:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeInt64List(r7, r5, r2)
            goto L_0x0054
        L_0x03b3:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed32List(r7, r5, r2)
            goto L_0x0054
        L_0x03bd:
            java.util.List r5 = listAt(r15, r8)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeFixed64List(r7, r5, r2)
            goto L_0x0054
        L_0x03c7:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r15, (long) r8)
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5
            androidx.datastore.preferences.protobuf.Schema r6 = r14.getMessageFieldSchema(r3)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeGroupSize(r7, r5, r6)
            goto L_0x0054
        L_0x03dd:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            long r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r15, (long) r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt64Size(r7, r5)
            goto L_0x0054
        L_0x03ed:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r15, (long) r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSInt32Size(r7, r5)
            goto L_0x0054
        L_0x03fd:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed64Size(r7, r10)
            goto L_0x0054
        L_0x0409:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeSFixed32Size(r7, r2)
            goto L_0x0054
        L_0x0415:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r15, (long) r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeEnumSize(r7, r5)
            goto L_0x0054
        L_0x0425:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r15, (long) r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt32Size(r7, r5)
            goto L_0x0054
        L_0x0435:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r15, (long) r8)
            androidx.datastore.preferences.protobuf.ByteString r5 = (androidx.datastore.preferences.protobuf.ByteString) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r7, r5)
            goto L_0x0054
        L_0x0447:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r15, (long) r8)
            androidx.datastore.preferences.protobuf.Schema r6 = r14.getMessageFieldSchema(r3)
            int r5 = androidx.datastore.preferences.protobuf.SchemaUtil.computeSizeMessage(r7, r5, r6)
            goto L_0x0054
        L_0x045b:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r15, (long) r8)
            boolean r6 = r5 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r6 == 0) goto L_0x0471
            androidx.datastore.preferences.protobuf.ByteString r5 = (androidx.datastore.preferences.protobuf.ByteString) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBytesSize(r7, r5)
            goto L_0x0054
        L_0x0471:
            java.lang.String r5 = (java.lang.String) r5
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeStringSize(r7, r5)
            goto L_0x0054
        L_0x0479:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeBoolSize(r7, r13)
            goto L_0x0054
        L_0x0485:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed32Size(r7, r2)
            goto L_0x0054
        L_0x0491:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFixed64Size(r7, r10)
            goto L_0x0054
        L_0x049d:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r15, (long) r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt32Size(r7, r5)
            goto L_0x0054
        L_0x04ad:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            long r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r15, (long) r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeUInt64Size(r7, r5)
            goto L_0x0054
        L_0x04bd:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            long r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r15, (long) r8)
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeInt64Size(r7, r5)
            goto L_0x0054
        L_0x04cd:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeFloatSize(r7, r12)
            goto L_0x0054
        L_0x04d9:
            boolean r5 = r14.isFieldPresent(r15, r3)
            if (r5 == 0) goto L_0x04e7
            r5 = 0
            int r5 = androidx.datastore.preferences.protobuf.CodedOutputStream.computeDoubleSize(r7, r5)
            goto L_0x0054
        L_0x04e7:
            int r3 = r3 + 3
            goto L_0x0006
        L_0x04eb:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r1 = r14.unknownFieldSchema
            int r0 = r14.getUnknownFieldsSerializedSize(r1, r15)
            int r4 = r4 + r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.getSerializedSizeProto3(java.lang.Object):int");
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t4) {
        return unknownFieldSchema2.getSerializedSize(unknownFieldSchema2.getFromMessage(t4));
    }

    private static <T> int intAt(T t4, long j4) {
        return UnsafeUtil.getInt((Object) t4, j4);
    }

    private static boolean isEnforceUtf8(int i4) {
        return (i4 & ENFORCE_UTF8_MASK) != 0;
    }

    private boolean isFieldPresent(T t4, int i4, int i5, int i6, int i7) {
        if (i5 == 1048575) {
            return isFieldPresent(t4, i4);
        }
        return (i6 & i7) != 0;
    }

    private <N> boolean isListInitialized(Object obj, int i4, int i5) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i4));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i5);
        for (int i6 = 0; i6 < list.size(); i6++) {
            if (!messageFieldSchema.isInitialized(list.get(i6))) {
                return false;
            }
        }
        return true;
    }

    private boolean isMapInitialized(T t4, int i4, int i5) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject((Object) t4, offset(i4)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i5)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        Schema<?> schema = null;
        for (Object next : forMapData.values()) {
            if (schema == null) {
                schema = Protobuf.getInstance().schemaFor(next.getClass());
            }
            if (!schema.isInitialized(next)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t4, T t5, int i4) {
        long presenceMaskAndOffsetAt = (long) (presenceMaskAndOffsetAt(i4) & 1048575);
        if (UnsafeUtil.getInt((Object) t4, presenceMaskAndOffsetAt) == UnsafeUtil.getInt((Object) t5, presenceMaskAndOffsetAt)) {
            return true;
        }
        return false;
    }

    private boolean isOneofPresent(T t4, int i4, int i5) {
        if (UnsafeUtil.getInt((Object) t4, (long) (presenceMaskAndOffsetAt(i5) & 1048575)) == i4) {
            return true;
        }
        return false;
    }

    private static boolean isRequired(int i4) {
        return (i4 & REQUIRED_MASK) != 0;
    }

    private static List<?> listAt(Object obj, long j4) {
        return (List) UnsafeUtil.getObject(obj, j4);
    }

    private static <T> long longAt(T t4, long j4) {
        return UnsafeUtil.getLong((Object) t4, j4);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v70, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v71, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v72, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v73, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v74, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v75, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v76, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v77, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v78, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v79, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v80, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v81, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v82, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v83, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v84, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v85, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v86, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v88, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v89, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v90, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB>} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x02aa, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x02ab, code lost:
        r2 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02af, code lost:
        r2 = r19;
        r4 = r20;
        r6 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02cd, code lost:
        r6 = r21;
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02d0, code lost:
        r1 = r7;
        r4 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x035c, code lost:
        r6 = r21;
        r1 = r7;
        r4 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0387, code lost:
        r11 = r17;
        r6 = r21;
        r10 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x04bf, code lost:
        r6 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x04c3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x04ef, code lost:
        r6 = r21;
        r1 = r7;
        r4 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x06fc, code lost:
        if (r4.skipField() == false) goto L_0x06fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x06fe, code lost:
        r0 = r1.checkInitializedCount;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0703, code lost:
        if (r0 < r1.repeatedFieldOffsetStart) goto L_0x0705;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0705, code lost:
        r4 = r1.filterMapUnknownEnumValues(r2, r1.intArray[r0], r4, r11, r19);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0713, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x071b, code lost:
        if (r5 == null) goto L_0x071d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:?, code lost:
        r5 = r11.getBuilderFromMessage(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0726, code lost:
        if (r11.mergeOneFieldFrom(r5, r4) == false) goto L_0x0728;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x0728, code lost:
        r0 = r1.checkInitializedCount;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x072d, code lost:
        if (r0 < r1.repeatedFieldOffsetStart) goto L_0x072f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x072f, code lost:
        r4 = r1.filterMapUnknownEnumValues(r2, r1.intArray[r0], r4, r11, r19);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x073d, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0741, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x0752, code lost:
        r4 = r1.filterMapUnknownEnumValues(r2, r1.intArray[r7], r4, r11, r19);
        r7 = r7 + 1;
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0765, code lost:
        r5.setBuilderToMessage(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:315:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:319:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:321:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00a8, code lost:
        r0 = r9.checkInitializedCount;
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00ad, code lost:
        if (r0 >= r9.repeatedFieldOffsetStart) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00af, code lost:
        r4 = r9.filterMapUnknownEnumValues(r2, r9.intArray[r0], r4, r5, r19);
        r7 = r2;
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00be, code lost:
        r7 = r2;
        r1 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c0, code lost:
        if (r4 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00c2, code lost:
        r5.setBuilderToMessage(r7, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x011b, code lost:
        r2 = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:127:? A[ExcHandler: InvalidWireTypeException (unused androidx.datastore.preferences.protobuf.InvalidProtocolBufferException$InvalidWireTypeException), PHI: r11 
      PHI: (r11v68 androidx.datastore.preferences.protobuf.UnknownFieldSchema) = (r11v67 androidx.datastore.preferences.protobuf.UnknownFieldSchema), (r11v69 androidx.datastore.preferences.protobuf.UnknownFieldSchema), (r11v69 androidx.datastore.preferences.protobuf.UnknownFieldSchema) binds: [B:129:0x02b8, B:121:0x0297, B:122:?] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC, Splitter:B:121:0x0297] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04c3 A[Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }, ExcHandler: all (th java.lang.Throwable), PHI: r2 r7 r11 
      PHI: (r2v35 T) = (r2v33 T), (r2v36 T) binds: [B:223:0x04e0, B:214:0x04b2] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r7v9 androidx.datastore.preferences.protobuf.MessageSchema) = (r7v7 androidx.datastore.preferences.protobuf.MessageSchema), (r7v11 androidx.datastore.preferences.protobuf.MessageSchema) binds: [B:223:0x04e0, B:214:0x04b2] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v37 androidx.datastore.preferences.protobuf.UnknownFieldSchema) = (r11v35 androidx.datastore.preferences.protobuf.UnknownFieldSchema), (r11v38 androidx.datastore.preferences.protobuf.UnknownFieldSchema) binds: [B:223:0x04e0, B:214:0x04b2] A[DONT_GENERATE, DONT_INLINE], Splitter:B:214:0x04b2] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x06f8 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x071b  */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0752 A[LOOP:6: B:291:0x074e->B:293:0x0752, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0765  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <UT, UB, ET extends androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB> r17, androidx.datastore.preferences.protobuf.ExtensionSchema<ET> r18, T r19, androidx.datastore.preferences.protobuf.Reader r20, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r21) throws java.io.IOException {
        /*
            r16 = this;
            r1 = r16
            r4 = r21
            r8 = 0
            r0 = r8
            r5 = r0
        L_0x0007:
            int r2 = r20.getFieldNumber()     // Catch:{ all -> 0x0744 }
            int r3 = r1.positionForFieldNumber(r2)     // Catch:{ all -> 0x0744 }
            if (r3 >= 0) goto L_0x00d4
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x003f
            int r0 = r1.checkInitializedCount
            r4 = r5
        L_0x0019:
            int r2 = r1.repeatedFieldOffsetStart
            if (r0 >= r2) goto L_0x0032
            int[] r2 = r1.intArray
            r3 = r2[r0]
            r6 = r19
            r5 = r17
            r2 = r19
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            r9 = r1
            r1 = r2
            r6 = r5
            int r0 = r0 + 1
            r1 = r9
            goto L_0x0019
        L_0x0032:
            r6 = r17
            r9 = r1
            r1 = r19
            if (r4 == 0) goto L_0x003c
            r6.setBuilderToMessage(r1, r4)
        L_0x003c:
            r1 = r9
            goto L_0x0740
        L_0x003f:
            r6 = r17
            r9 = r1
            r1 = r19
            boolean r3 = r9.hasExtensions     // Catch:{ all -> 0x00cc }
            if (r3 != 0) goto L_0x004c
            r7 = r18
            r3 = r8
            goto L_0x0055
        L_0x004c:
            androidx.datastore.preferences.protobuf.MessageLite r3 = r9.defaultInstance     // Catch:{ all -> 0x00cc }
            r7 = r18
            java.lang.Object r2 = r7.findExtensionByNumber(r4, r3, r2)     // Catch:{ all -> 0x00cc }
            r3 = r2
        L_0x0055:
            if (r3 == 0) goto L_0x0081
            if (r0 != 0) goto L_0x005d
            androidx.datastore.preferences.protobuf.FieldSet r0 = r18.getMutableExtensions(r19)     // Catch:{ all -> 0x0065 }
        L_0x005d:
            r2 = r5
            r5 = r0
            r0 = r7
            r7 = r6
            r6 = r2
            r2 = r20
            goto L_0x006b
        L_0x0065:
            r0 = move-exception
            r2 = r1
            r11 = r6
            r1 = r9
            goto L_0x074a
        L_0x006b:
            java.lang.Object r3 = r0.parseExtension(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0078 }
            r6 = r4
            r0 = r5
            r5 = r7
            r4 = r2
            r2 = r1
            r5 = r3
            r4 = r6
            r1 = r9
            goto L_0x0007
        L_0x0078:
            r0 = move-exception
            r2 = r1
            r10 = r6
            r5 = r7
        L_0x007c:
            r11 = r5
            r1 = r9
        L_0x007e:
            r5 = r10
            goto L_0x074a
        L_0x0081:
            r2 = r1
            r10 = r5
            r5 = r6
            r6 = r4
            r4 = r20
            boolean r1 = r5.shouldDiscardUnknownFields(r4)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x009a
            boolean r1 = r4.skipField()     // Catch:{ all -> 0x0098 }
            if (r1 == 0) goto L_0x00a8
        L_0x0093:
            r4 = r6
            r1 = r9
            r5 = r10
            goto L_0x0007
        L_0x0098:
            r0 = move-exception
            goto L_0x007c
        L_0x009a:
            if (r10 != 0) goto L_0x00a1
            java.lang.Object r1 = r5.getBuilderFromMessage(r2)     // Catch:{ all -> 0x0098 }
            r10 = r1
        L_0x00a1:
            boolean r1 = r5.mergeOneFieldFrom(r10, r4)     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x00a8
            goto L_0x0093
        L_0x00a8:
            int r0 = r9.checkInitializedCount
            r4 = r10
        L_0x00ab:
            int r1 = r9.repeatedFieldOffsetStart
            if (r0 >= r1) goto L_0x00be
            int[] r1 = r9.intArray
            r3 = r1[r0]
            r6 = r19
            r1 = r9
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            r7 = r2
            int r0 = r0 + 1
            goto L_0x00ab
        L_0x00be:
            r7 = r2
            r1 = r9
            if (r4 == 0) goto L_0x0740
            r5.setBuilderToMessage(r7, r4)
            goto L_0x0740
        L_0x00c7:
            r0 = move-exception
            r7 = r2
            r1 = r9
            r11 = r5
            goto L_0x007e
        L_0x00cc:
            r0 = move-exception
            r7 = r1
            r10 = r5
            r5 = r6
            r1 = r9
        L_0x00d1:
            r11 = r5
        L_0x00d2:
            r2 = r7
            goto L_0x007e
        L_0x00d4:
            r7 = r19
            r6 = r4
            r10 = r5
            r5 = r17
            r4 = r20
            int r9 = r1.typeAndOffsetAt(r3)     // Catch:{ all -> 0x00ef }
            int r11 = type(r9)     // Catch:{ InvalidWireTypeException -> 0x00f1 }
            switch(r11) {
                case 0: goto L_0x06df;
                case 1: goto L_0x06cc;
                case 2: goto L_0x06b9;
                case 3: goto L_0x06a6;
                case 4: goto L_0x0693;
                case 5: goto L_0x0680;
                case 6: goto L_0x066d;
                case 7: goto L_0x065a;
                case 8: goto L_0x064f;
                case 9: goto L_0x063b;
                case 10: goto L_0x0628;
                case 11: goto L_0x0615;
                case 12: goto L_0x05ed;
                case 13: goto L_0x05da;
                case 14: goto L_0x05c7;
                case 15: goto L_0x05b4;
                case 16: goto L_0x05a1;
                case 17: goto L_0x058d;
                case 18: goto L_0x057b;
                case 19: goto L_0x0569;
                case 20: goto L_0x0557;
                case 21: goto L_0x0545;
                case 22: goto L_0x0533;
                case 23: goto L_0x0521;
                case 24: goto L_0x050f;
                case 25: goto L_0x04fd;
                case 26: goto L_0x04f5;
                case 27: goto L_0x04dc;
                case 28: goto L_0x04ca;
                case 29: goto L_0x04ae;
                case 30: goto L_0x0473;
                case 31: goto L_0x0460;
                case 32: goto L_0x044d;
                case 33: goto L_0x043a;
                case 34: goto L_0x0427;
                case 35: goto L_0x0414;
                case 36: goto L_0x0401;
                case 37: goto L_0x03ef;
                case 38: goto L_0x03dd;
                case 39: goto L_0x03cb;
                case 40: goto L_0x03b9;
                case 41: goto L_0x03a7;
                case 42: goto L_0x0395;
                case 43: goto L_0x0376;
                case 44: goto L_0x033b;
                case 45: goto L_0x0328;
                case 46: goto L_0x0315;
                case 47: goto L_0x0302;
                case 48: goto L_0x02e5;
                case 49: goto L_0x02b7;
                case 50: goto L_0x0296;
                case 51: goto L_0x0281;
                case 52: goto L_0x026c;
                case 53: goto L_0x0257;
                case 54: goto L_0x0242;
                case 55: goto L_0x022d;
                case 56: goto L_0x0218;
                case 57: goto L_0x0203;
                case 58: goto L_0x01ee;
                case 59: goto L_0x01e5;
                case 60: goto L_0x01d2;
                case 61: goto L_0x01c1;
                case 62: goto L_0x01ac;
                case 63: goto L_0x0183;
                case 64: goto L_0x016f;
                case 65: goto L_0x015b;
                case 66: goto L_0x0147;
                case 67: goto L_0x0133;
                case 68: goto L_0x011f;
                default: goto L_0x00e7;
            }     // Catch:{ InvalidWireTypeException -> 0x00f1 }
        L_0x00e7:
            if (r10 != 0) goto L_0x00f6
            java.lang.Object r2 = r5.getBuilderFromMessage(r7)     // Catch:{ InvalidWireTypeException -> 0x00f1 }
            r10 = r2
            goto L_0x00f6
        L_0x00ef:
            r0 = move-exception
            goto L_0x00d1
        L_0x00f1:
            r11 = r5
        L_0x00f2:
            r2 = r7
        L_0x00f3:
            r5 = r10
            goto L_0x06f2
        L_0x00f6:
            boolean r2 = r5.mergeOneFieldFrom(r10, r4)     // Catch:{ InvalidWireTypeException -> 0x00f1 }
            if (r2 != 0) goto L_0x011a
            int r0 = r1.checkInitializedCount
            r4 = r10
        L_0x00ff:
            int r2 = r1.repeatedFieldOffsetStart
            if (r0 >= r2) goto L_0x0112
            int[] r2 = r1.intArray
            r3 = r2[r0]
            r6 = r19
            r2 = r7
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            r11 = r5
            int r0 = r0 + 1
            goto L_0x00ff
        L_0x0112:
            r11 = r5
            if (r4 == 0) goto L_0x0740
            r11.setBuilderToMessage(r7, r4)
            goto L_0x0740
        L_0x011a:
            r11 = r5
        L_0x011b:
            r2 = r7
        L_0x011c:
            r5 = r10
            goto L_0x0741
        L_0x011f:
            r11 = r5
            java.lang.Object r5 = r1.mutableOneofMessageFieldForMerge(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.Schema r9 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r4.mergeGroupField(r5, r9, r6)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.storeOneofMessageField(r7, r2, r3, r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0131:
            r0 = move-exception
            goto L_0x00d2
        L_0x0133:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            long r14 = r4.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Long r5 = java.lang.Long.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0147:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            int r5 = r4.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x015b:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            long r14 = r4.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Long r5 = java.lang.Long.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x016f:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            int r5 = r4.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0183:
            r11 = r5
            int r5 = r4.readEnum()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r12 = r1.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            if (r12 == 0) goto L_0x019c
            boolean r12 = r12.isInRange(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            if (r12 == 0) goto L_0x0195
            goto L_0x019c
        L_0x0195:
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.storeUnknownEnum(r7, r2, r5, r10, r11)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r2 = r7
            goto L_0x0741
        L_0x019c:
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x01ac:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            int r5 = r4.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x01c1:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.ByteString r5 = r4.readBytes()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x01d2:
            r11 = r5
            java.lang.Object r5 = r1.mutableOneofMessageFieldForMerge(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.Schema r9 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r4.mergeMessageField(r5, r9, r6)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.storeOneofMessageField(r7, r2, r3, r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x01e5:
            r11 = r5
            r1.readString(r7, r9, r4)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x01ee:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            boolean r5 = r4.readBool()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0203:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            int r5 = r4.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0218:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            long r14 = r4.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Long r5 = java.lang.Long.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x022d:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            int r5 = r4.readInt32()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0242:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            long r14 = r4.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Long r5 = java.lang.Long.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0257:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            long r14 = r4.readInt64()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Long r5 = java.lang.Long.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x026c:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            float r5 = r4.readFloat()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0281:
            r11 = r5
            long r12 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            double r14 = r4.readDouble()     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            java.lang.Double r5 = java.lang.Double.valueOf(r14)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r7, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            r1.setOneofPresent(r7, r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f2, all -> 0x0131 }
            goto L_0x011b
        L_0x0296:
            r11 = r5
            java.lang.Object r4 = r1.getMapFieldDefaultEntry(r3)     // Catch:{ InvalidWireTypeException -> 0x02af, all -> 0x02aa }
            r5 = r6
            r2 = r7
            r6 = r20
            r1.mergeMap(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x02af, all -> 0x02aa }
            r2 = r19
            r4 = r20
            r6 = r21
            goto L_0x011c
        L_0x02aa:
            r0 = move-exception
            r2 = r19
            goto L_0x007e
        L_0x02af:
            r2 = r19
            r4 = r20
            r6 = r21
            goto L_0x00f3
        L_0x02b7:
            r11 = r5
            long r4 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x02af, all -> 0x02df }
            androidx.datastore.preferences.protobuf.Schema r6 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x02af, all -> 0x02df }
            r2 = r19
            r7 = r21
            r3 = r4
            r5 = r20
            r1.readGroupList(r2, r3, r5, r6, r7)     // Catch:{ InvalidWireTypeException -> 0x02da, all -> 0x02d4 }
            r7 = r1
            r1 = r2
            r12 = r5
        L_0x02cd:
            r6 = r21
            r2 = r1
        L_0x02d0:
            r1 = r7
            r4 = r12
            goto L_0x011c
        L_0x02d4:
            r0 = move-exception
            r7 = r1
            r1 = r2
        L_0x02d7:
            r1 = r7
            goto L_0x007e
        L_0x02da:
            r6 = r21
            r4 = r5
            goto L_0x00f3
        L_0x02df:
            r0 = move-exception
            r7 = r1
            r1 = r19
        L_0x02e3:
            r2 = r1
            goto L_0x02d7
        L_0x02e5:
            r11 = r7
            r7 = r1
            r1 = r11
            r12 = r4
            r11 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            r12.readSInt64List(r2)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            goto L_0x02cd
        L_0x02f8:
            r0 = move-exception
            goto L_0x02e3
        L_0x02fa:
            r6 = r21
            r2 = r1
        L_0x02fd:
            r1 = r7
            r5 = r10
        L_0x02ff:
            r4 = r12
            goto L_0x06f2
        L_0x0302:
            r11 = r7
            r7 = r1
            r1 = r11
            r12 = r4
            r11 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            r12.readSInt32List(r2)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            goto L_0x02cd
        L_0x0315:
            r11 = r7
            r7 = r1
            r1 = r11
            r12 = r4
            r11 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            r12.readSFixed64List(r2)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            goto L_0x02cd
        L_0x0328:
            r11 = r7
            r7 = r1
            r1 = r11
            r12 = r4
            r11 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r2 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            java.util.List r2 = r2.mutableListAt(r1, r3)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            r12.readSFixed32List(r2)     // Catch:{ InvalidWireTypeException -> 0x02fa, all -> 0x02f8 }
            goto L_0x02cd
        L_0x033b:
            r11 = r7
            r7 = r1
            r1 = r11
            r12 = r4
            r11 = r5
            androidx.datastore.preferences.protobuf.ListFieldSchema r4 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0374, all -> 0x0370 }
            long r5 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0374, all -> 0x0370 }
            java.util.List r4 = r4.mutableListAt(r1, r5)     // Catch:{ InvalidWireTypeException -> 0x0374, all -> 0x0370 }
            r12.readEnumList(r4)     // Catch:{ InvalidWireTypeException -> 0x0374, all -> 0x0370 }
            r5 = r4
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r4 = r7.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x0374, all -> 0x0370 }
            r3 = r5
            r5 = r10
            r6 = r11
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.filterUnknownEnumList((java.lang.Object) r1, (int) r2, (java.util.List<java.lang.Integer>) r3, (androidx.datastore.preferences.protobuf.Internal.EnumVerifier) r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x0369, all -> 0x0362 }
            r2 = r1
            r11 = r17
        L_0x035c:
            r6 = r21
            r1 = r7
            r4 = r12
            goto L_0x0741
        L_0x0362:
            r0 = move-exception
            r2 = r1
        L_0x0364:
            r11 = r17
        L_0x0366:
            r1 = r7
            goto L_0x074a
        L_0x0369:
            r11 = r17
        L_0x036b:
            r6 = r21
            r2 = r1
        L_0x036e:
            r1 = r7
            goto L_0x02ff
        L_0x0370:
            r0 = move-exception
            r2 = r1
            r5 = r10
            goto L_0x0364
        L_0x0374:
            r5 = r10
            goto L_0x0369
        L_0x0376:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
        L_0x0387:
            r11 = r17
            r6 = r21
            r10 = r5
            goto L_0x02d0
        L_0x038e:
            r0 = move-exception
            goto L_0x0364
        L_0x0390:
            r11 = r17
        L_0x0392:
            r6 = r21
            goto L_0x036e
        L_0x0395:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readBoolList(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x03a7:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x03b9:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x03cb:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x03dd:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readUInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x03ef:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x0401:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readFloatList(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x0414:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readDoubleList(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x0427:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readSInt64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x043a:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readSInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x044d:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readSFixed64List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x0460:
            r12 = r4
            r2 = r7
            r5 = r10
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            r12.readSFixed32List(r1)     // Catch:{ InvalidWireTypeException -> 0x0390, all -> 0x038e }
            goto L_0x0387
        L_0x0473:
            r5 = r7
            r7 = r1
            r1 = r2
            r2 = r5
            r12 = r4
            r5 = r10
            androidx.datastore.preferences.protobuf.ListFieldSchema r4 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x04a9, all -> 0x04a3 }
            long r9 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x04a9, all -> 0x04a3 }
            java.util.List r4 = r4.mutableListAt(r2, r9)     // Catch:{ InvalidWireTypeException -> 0x04a9, all -> 0x04a3 }
            r12.readEnumList(r4)     // Catch:{ InvalidWireTypeException -> 0x04a9, all -> 0x04a3 }
            r6 = r4
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r4 = r7.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x04a9, all -> 0x04a3 }
            r3 = r2
            r2 = r1
            r1 = r3
            r3 = r6
            r6 = r17
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.filterUnknownEnumList((java.lang.Object) r1, (int) r2, (java.util.List<java.lang.Integer>) r3, (androidx.datastore.preferences.protobuf.Internal.EnumVerifier) r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x049f, all -> 0x0499 }
            r2 = r1
            r11 = r6
            goto L_0x035c
        L_0x0499:
            r0 = move-exception
            r2 = r1
            r10 = r5
            r11 = r6
            goto L_0x0366
        L_0x049f:
            r10 = r5
            r11 = r6
            goto L_0x036b
        L_0x04a3:
            r0 = move-exception
            r11 = r17
            r10 = r5
            goto L_0x0366
        L_0x04a9:
            r11 = r17
            r10 = r5
            goto L_0x0392
        L_0x04ae:
            r12 = r4
            r11 = r5
            r2 = r7
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            r12.readUInt32List(r1)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
        L_0x04bf:
            r6 = r21
            goto L_0x02d0
        L_0x04c3:
            r0 = move-exception
            goto L_0x02d7
        L_0x04c6:
            r6 = r21
            goto L_0x02fd
        L_0x04ca:
            r12 = r4
            r11 = r5
            r2 = r7
            r7 = r1
            androidx.datastore.preferences.protobuf.ListFieldSchema r1 = r7.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            long r3 = offset(r9)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            java.util.List r1 = r1.mutableListAt(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            r12.readBytesList(r1)     // Catch:{ InvalidWireTypeException -> 0x04c6, all -> 0x04c3 }
            goto L_0x04bf
        L_0x04dc:
            r12 = r4
            r11 = r5
            r2 = r7
            r7 = r1
            androidx.datastore.preferences.protobuf.Schema r5 = r7.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x04ef, all -> 0x04c3 }
            r6 = r21
            r3 = r9
            r1.readMessageList(r2, r3, r4, r5, r6)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x04ec:
            r0 = move-exception
            goto L_0x007e
        L_0x04ef:
            r6 = r21
            r1 = r7
            r4 = r12
            goto L_0x00f3
        L_0x04f5:
            r11 = r5
            r2 = r7
            r5 = r9
            r1.readStringList(r2, r5, r4)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x04fd:
            r11 = r5
            r2 = r7
            r5 = r9
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readBoolList(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x050f:
            r11 = r5
            r2 = r7
            r5 = r9
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readFixed32List(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0521:
            r11 = r5
            r2 = r7
            r5 = r9
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readFixed64List(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0533:
            r11 = r5
            r2 = r7
            r5 = r9
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readInt32List(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0545:
            r11 = r5
            r2 = r7
            r5 = r9
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readUInt64List(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0557:
            r11 = r5
            r2 = r7
            r5 = r9
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readInt64List(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0569:
            r11 = r5
            r2 = r7
            r5 = r9
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readFloatList(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x057b:
            r11 = r5
            r2 = r7
            r5 = r9
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r1.listFieldSchema     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            java.util.List r3 = r3.mutableListAt(r2, r12)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.readDoubleList(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x058d:
            r11 = r5
            r2 = r7
            java.lang.Object r5 = r1.mutableMessageFieldForMerge(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.Schema r7 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.mergeGroupField(r5, r7, r6)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.storeMessageField(r2, r3, r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x05a1:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r14 = r4.readSInt64()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r12, (long) r14)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x05b4:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            int r5 = r4.readSInt32()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x05c7:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r14 = r4.readSFixed64()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r12, (long) r14)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x05da:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            int r5 = r4.readSFixed32()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x05ed:
            r11 = r7
            r7 = r2
            r2 = r11
            r11 = r5
            r5 = r9
            int r9 = r4.readEnum()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r12 = r1.getEnumFieldVerifier(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            if (r12 == 0) goto L_0x0609
            boolean r12 = r12.isInRange(r9)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            if (r12 == 0) goto L_0x0603
            goto L_0x0609
        L_0x0603:
            java.lang.Object r5 = androidx.datastore.preferences.protobuf.SchemaUtil.storeUnknownEnum(r2, r7, r9, r10, r11)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x0741
        L_0x0609:
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r9)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0615:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            int r5 = r4.readUInt32()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0628:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.ByteString r5 = r4.readBytes()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putObject((java.lang.Object) r2, (long) r12, (java.lang.Object) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x063b:
            r11 = r5
            r2 = r7
            java.lang.Object r5 = r1.mutableMessageFieldForMerge(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.MessageLite r5 = (androidx.datastore.preferences.protobuf.MessageLite) r5     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.Schema r7 = r1.getMessageFieldSchema(r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r4.mergeMessageField(r5, r7, r6)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.storeMessageField(r2, r3, r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x064f:
            r11 = r5
            r2 = r7
            r5 = r9
            r1.readString(r2, r5, r4)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x065a:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            boolean r5 = r4.readBool()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r2, (long) r12, (boolean) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x066d:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            int r5 = r4.readFixed32()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0680:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r14 = r4.readFixed64()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r12, (long) r14)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x0693:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            int r5 = r4.readInt32()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putInt((java.lang.Object) r2, (long) r12, (int) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x06a6:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r14 = r4.readUInt64()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r12, (long) r14)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x06b9:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            long r14 = r4.readInt64()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putLong((java.lang.Object) r2, (long) r12, (long) r14)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x06cc:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            float r5 = r4.readFloat()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putFloat((java.lang.Object) r2, (long) r12, (float) r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x06df:
            r11 = r5
            r2 = r7
            r5 = r9
            long r12 = offset(r5)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            double r14 = r4.readDouble()     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            androidx.datastore.preferences.protobuf.UnsafeUtil.putDouble((java.lang.Object) r2, (long) r12, (double) r14)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            r1.setFieldPresent(r2, r3)     // Catch:{ InvalidWireTypeException -> 0x00f3, all -> 0x04ec }
            goto L_0x011c
        L_0x06f2:
            boolean r3 = r11.shouldDiscardUnknownFields(r4)     // Catch:{ all -> 0x0719 }
            if (r3 == 0) goto L_0x071b
            boolean r3 = r4.skipField()     // Catch:{ all -> 0x0719 }
            if (r3 != 0) goto L_0x0741
            int r0 = r1.checkInitializedCount
            r4 = r5
        L_0x0701:
            int r3 = r1.repeatedFieldOffsetStart
            if (r0 >= r3) goto L_0x0713
            int[] r3 = r1.intArray
            r3 = r3[r0]
            r6 = r19
            r5 = r11
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0701
        L_0x0713:
            if (r4 == 0) goto L_0x0740
        L_0x0715:
            r11.setBuilderToMessage(r2, r4)
            goto L_0x0740
        L_0x0719:
            r0 = move-exception
            goto L_0x074a
        L_0x071b:
            if (r5 != 0) goto L_0x0722
            java.lang.Object r3 = r11.getBuilderFromMessage(r2)     // Catch:{ all -> 0x0719 }
            r5 = r3
        L_0x0722:
            boolean r3 = r11.mergeOneFieldFrom(r5, r4)     // Catch:{ all -> 0x0719 }
            if (r3 != 0) goto L_0x0741
            int r0 = r1.checkInitializedCount
            r4 = r5
        L_0x072b:
            int r3 = r1.repeatedFieldOffsetStart
            if (r0 >= r3) goto L_0x073d
            int[] r3 = r1.intArray
            r3 = r3[r0]
            r6 = r19
            r5 = r11
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x072b
        L_0x073d:
            if (r4 == 0) goto L_0x0740
            goto L_0x0715
        L_0x0740:
            return
        L_0x0741:
            r4 = r6
            goto L_0x0007
        L_0x0744:
            r0 = move-exception
            r11 = r17
            r2 = r19
            r10 = r5
        L_0x074a:
            int r3 = r1.checkInitializedCount
            r7 = r3
            r4 = r5
        L_0x074e:
            int r3 = r1.repeatedFieldOffsetStart
            if (r7 >= r3) goto L_0x0762
            int[] r3 = r1.intArray
            r3 = r3[r7]
            r6 = r19
            r5 = r11
            java.lang.Object r4 = r1.filterMapUnknownEnumValues(r2, r3, r4, r5, r6)
            int r7 = r7 + 1
            r1 = r16
            goto L_0x074e
        L_0x0762:
            r5 = r11
            if (r4 == 0) goto L_0x0768
            r5.setBuilderToMessage(r2, r4)
        L_0x0768:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i4, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) throws IOException {
        long offset = offset(typeAndOffsetAt(i4));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    private void mergeMessage(T t4, T t5, int i4) {
        if (isFieldPresent(t5, i4)) {
            long offset = offset(typeAndOffsetAt(i4));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t5, offset);
            if (object != null) {
                Schema messageFieldSchema = getMessageFieldSchema(i4);
                if (!isFieldPresent(t4, i4)) {
                    if (!isMutable(object)) {
                        unsafe.putObject(t4, offset, object);
                    } else {
                        Object newInstance = messageFieldSchema.newInstance();
                        messageFieldSchema.mergeFrom(newInstance, object);
                        unsafe.putObject(t4, offset, newInstance);
                    }
                    setFieldPresent(t4, i4);
                    return;
                }
                Object object2 = unsafe.getObject(t4, offset);
                if (!isMutable(object2)) {
                    Object newInstance2 = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance2, object2);
                    unsafe.putObject(t4, offset, newInstance2);
                    object2 = newInstance2;
                }
                messageFieldSchema.mergeFrom(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + numberAt(i4) + " is present but null: " + t5);
        }
    }

    private void mergeOneofMessage(T t4, T t5, int i4) {
        int numberAt = numberAt(i4);
        if (isOneofPresent(t5, numberAt, i4)) {
            long offset = offset(typeAndOffsetAt(i4));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t5, offset);
            if (object != null) {
                Schema messageFieldSchema = getMessageFieldSchema(i4);
                if (!isOneofPresent(t4, numberAt, i4)) {
                    if (!isMutable(object)) {
                        unsafe.putObject(t4, offset, object);
                    } else {
                        Object newInstance = messageFieldSchema.newInstance();
                        messageFieldSchema.mergeFrom(newInstance, object);
                        unsafe.putObject(t4, offset, newInstance);
                    }
                    setOneofPresent(t4, numberAt, i4);
                    return;
                }
                Object object2 = unsafe.getObject(t4, offset);
                if (!isMutable(object2)) {
                    Object newInstance2 = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance2, object2);
                    unsafe.putObject(t4, offset, newInstance2);
                    object2 = newInstance2;
                }
                messageFieldSchema.mergeFrom(object2, object);
                return;
            }
            throw new IllegalStateException("Source subfield " + numberAt(i4) + " is present but null: " + t5);
        }
    }

    private void mergeSingleField(T t4, T t5, int i4) {
        int typeAndOffsetAt = typeAndOffsetAt(i4);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i4);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putDouble((Object) t4, offset, UnsafeUtil.getDouble((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putFloat((Object) t4, offset, UnsafeUtil.getFloat((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putLong((Object) t4, offset, UnsafeUtil.getLong((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putLong((Object) t4, offset, UnsafeUtil.getLong((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putInt((Object) t4, offset, UnsafeUtil.getInt((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putLong((Object) t4, offset, UnsafeUtil.getLong((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putInt((Object) t4, offset, UnsafeUtil.getInt((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putBoolean((Object) t4, offset, UnsafeUtil.getBoolean((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putObject((Object) t4, offset, UnsafeUtil.getObject((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 9:
                mergeMessage(t4, t5, i4);
                return;
            case 10:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putObject((Object) t4, offset, UnsafeUtil.getObject((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putInt((Object) t4, offset, UnsafeUtil.getInt((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putInt((Object) t4, offset, UnsafeUtil.getInt((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putInt((Object) t4, offset, UnsafeUtil.getInt((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putLong((Object) t4, offset, UnsafeUtil.getLong((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putInt((Object) t4, offset, UnsafeUtil.getInt((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(t5, i4)) {
                    UnsafeUtil.putLong((Object) t4, offset, UnsafeUtil.getLong((Object) t5, offset));
                    setFieldPresent(t4, i4);
                    return;
                }
                return;
            case 17:
                mergeMessage(t4, t5, i4);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t4, t5, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t4, t5, offset);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t5, numberAt, i4)) {
                    UnsafeUtil.putObject((Object) t4, offset, UnsafeUtil.getObject((Object) t5, offset));
                    setOneofPresent(t4, numberAt, i4);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(t4, t5, i4);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t5, numberAt, i4)) {
                    UnsafeUtil.putObject((Object) t4, offset, UnsafeUtil.getObject((Object) t5, offset));
                    setOneofPresent(t4, numberAt, i4);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(t4, t5, i4);
                return;
            default:
                return;
        }
    }

    private Object mutableMessageFieldForMerge(T t4, int i4) {
        Schema messageFieldSchema = getMessageFieldSchema(i4);
        long offset = offset(typeAndOffsetAt(i4));
        if (!isFieldPresent(t4, i4)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t4, offset);
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    private Object mutableOneofMessageFieldForMerge(T t4, int i4, int i5) {
        Schema messageFieldSchema = getMessageFieldSchema(i5);
        if (!isOneofPresent(t4, i4, i5)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t4, offset(typeAndOffsetAt(i5)));
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
        }
        return newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema2, ListFieldSchema listFieldSchema2, UnknownFieldSchema<?, ?> unknownFieldSchema2, ExtensionSchema<?> extensionSchema2, MapFieldSchema mapFieldSchema2) {
        boolean z4;
        int i4;
        int i5;
        int[] iArr;
        int i6;
        if (structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3) {
            z4 = true;
        } else {
            z4 = false;
        }
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            i5 = 0;
            i4 = 0;
        } else {
            i5 = fields[0].getFieldNumber();
            i4 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr2 = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i7 = 0;
        int i8 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i7++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i8++;
            }
        }
        int[] iArr3 = null;
        if (i7 > 0) {
            iArr = new int[i7];
        } else {
            iArr = null;
        }
        if (i8 > 0) {
            iArr3 = new int[i8];
        }
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i9 < fields.length) {
            FieldInfo fieldInfo2 = fields[i9];
            int fieldNumber = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr2, i10, objArr);
            if (i11 < checkInitialized.length && checkInitialized[i11] == fieldNumber) {
                checkInitialized[i11] = i10;
                i11++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr[i12] = i10;
                i12++;
            } else if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                i6 = i10;
                iArr3[i13] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                i13++;
                i9++;
                i10 = i6 + 3;
            }
            i6 = i10;
            i9++;
            i10 = i6 + 3;
        }
        if (iArr == null) {
            iArr = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[(checkInitialized.length + iArr.length + iArr3.length)];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr, 0, iArr4, checkInitialized.length, iArr.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr.length, iArr3.length);
        return new MessageSchema<>(iArr2, objArr, i5, i4, structuralMessageInfo.getDefaultInstance(), z4, true, iArr4, checkInitialized.length, checkInitialized.length + iArr.length, newInstanceSchema2, listFieldSchema2, unknownFieldSchema2, extensionSchema2, mapFieldSchema2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x031f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0367  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> androidx.datastore.preferences.protobuf.MessageSchema<T> newSchemaForRawMessageInfo(androidx.datastore.preferences.protobuf.RawMessageInfo r33, androidx.datastore.preferences.protobuf.NewInstanceSchema r34, androidx.datastore.preferences.protobuf.ListFieldSchema r35, androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r36, androidx.datastore.preferences.protobuf.ExtensionSchema<?> r37, androidx.datastore.preferences.protobuf.MapFieldSchema r38) {
        /*
            androidx.datastore.preferences.protobuf.ProtoSyntax r0 = r33.getSyntax()
            androidx.datastore.preferences.protobuf.ProtoSyntax r1 = androidx.datastore.preferences.protobuf.ProtoSyntax.PROTO3
            r2 = 0
            if (r0 != r1) goto L_0x000b
            r10 = 1
            goto L_0x000c
        L_0x000b:
            r10 = 0
        L_0x000c:
            java.lang.String r0 = r33.getStringInfo()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0028
            r4 = 1
        L_0x001e:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0029
            r4 = r6
            goto L_0x001e
        L_0x0028:
            r6 = 1
        L_0x0029:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0048
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0035:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0045
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0035
        L_0x0045:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0048:
            if (r6 != 0) goto L_0x0057
            int[] r6 = EMPTY_INT_ARRAY
            r12 = r6
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            goto L_0x0164
        L_0x0057:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0063:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0073
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0063
        L_0x0073:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0076:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0095
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0082:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0095:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a1
        L_0x00b1:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b4:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 * 2
            int r16 = r16 + r6
            r6 = r13
            r13 = r12
            r12 = r6
            r6 = r4
            r4 = r15
        L_0x0164:
            sun.misc.Unsafe r15 = UNSAFE
            java.lang.Object[] r17 = r33.getObjects()
            androidx.datastore.preferences.protobuf.MessageLite r18 = r33.getDefaultInstance()
            java.lang.Class r2 = r18.getClass()
            r18 = 1
            int r3 = r11 * 3
            int[] r3 = new int[r3]
            int r11 = r11 * 2
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r13 = r13 + r14
            r23 = r13
            r22 = r14
            r20 = 0
            r21 = 0
        L_0x0185:
            if (r4 >= r1) goto L_0x03b3
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ad
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r7 = r24
            r24 = 13
        L_0x0195:
            int r25 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r5) goto L_0x01a7
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r24
            r4 = r4 | r7
            int r24 = r24 + 13
            r7 = r25
            goto L_0x0195
        L_0x01a7:
            int r7 = r7 << r24
            r4 = r4 | r7
            r7 = r25
            goto L_0x01af
        L_0x01ad:
            r7 = r24
        L_0x01af:
            int r24 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r5) goto L_0x01dc
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bd:
            int r26 = r5 + 1
            char r5 = r0.charAt(r5)
            r27 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d6
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r7 = r7 | r1
            int r24 = r24 + 13
            r5 = r26
            r1 = r27
            goto L_0x01bd
        L_0x01d6:
            int r1 = r5 << r24
            r7 = r7 | r1
            r1 = r26
            goto L_0x01e0
        L_0x01dc:
            r27 = r1
            r1 = r24
        L_0x01e0:
            r5 = r7 & 255(0xff, float:3.57E-43)
            r24 = r3
            r3 = r7 & 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x01ee
            int r3 = r20 + 1
            r12[r20] = r21
            r20 = r3
        L_0x01ee:
            r3 = 51
            r29 = r4
            if (r5 < r3) goto L_0x0291
            int r3 = r1 + 1
            char r1 = r0.charAt(r1)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r4) goto L_0x021d
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
        L_0x0203:
            int r32 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r4) goto L_0x0218
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r31
            r1 = r1 | r3
            int r31 = r31 + 13
            r3 = r32
            r4 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0203
        L_0x0218:
            int r3 = r3 << r31
            r1 = r1 | r3
            r3 = r32
        L_0x021d:
            int r4 = r5 + -51
            r31 = r1
            r1 = 9
            if (r4 == r1) goto L_0x023f
            r1 = 17
            if (r4 != r1) goto L_0x022a
            goto L_0x023f
        L_0x022a:
            r1 = 12
            if (r4 != r1) goto L_0x024c
            if (r10 != 0) goto L_0x024c
            int r1 = r21 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            int r4 = r16 + 1
            r16 = r17[r16]
            r11[r1] = r16
        L_0x023c:
            r16 = r4
            goto L_0x024c
        L_0x023f:
            int r1 = r21 / 3
            int r1 = r1 * 2
            int r1 = r1 + 1
            int r4 = r16 + 1
            r16 = r17[r16]
            r11[r1] = r16
            goto L_0x023c
        L_0x024c:
            int r1 = r31 * 2
            r4 = r17[r1]
            r26 = r1
            boolean r1 = r4 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x025a
            java.lang.reflect.Field r4 = (java.lang.reflect.Field) r4
        L_0x0258:
            r1 = r3
            goto L_0x0263
        L_0x025a:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = reflectField(r2, r4)
            r17[r26] = r4
            goto L_0x0258
        L_0x0263:
            long r3 = r15.objectFieldOffset(r4)
            int r4 = (int) r3
            int r3 = r26 + 1
            r26 = r1
            r1 = r17[r3]
            r28 = r3
            boolean r3 = r1 instanceof java.lang.reflect.Field
            if (r3 == 0) goto L_0x0279
            java.lang.reflect.Field r1 = (java.lang.reflect.Field) r1
        L_0x0276:
            r28 = r4
            goto L_0x0282
        L_0x0279:
            java.lang.String r1 = (java.lang.String) r1
            java.lang.reflect.Field r1 = reflectField(r2, r1)
            r17[r28] = r1
            goto L_0x0276
        L_0x0282:
            long r3 = r15.objectFieldOffset(r1)
            int r1 = (int) r3
            r30 = r0
            r0 = r1
            r4 = r28
            r1 = 0
            r28 = r26
            goto L_0x037f
        L_0x0291:
            int r3 = r16 + 1
            r4 = r17[r16]
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = reflectField(r2, r4)
            r31 = r3
            r3 = 9
            if (r5 == r3) goto L_0x0300
            r3 = 17
            if (r5 != r3) goto L_0x02a6
            goto L_0x0300
        L_0x02a6:
            r3 = 27
            if (r5 == r3) goto L_0x02f3
            r3 = 49
            if (r5 != r3) goto L_0x02af
            goto L_0x02f3
        L_0x02af:
            r3 = 12
            if (r5 == r3) goto L_0x02e4
            r3 = 30
            if (r5 == r3) goto L_0x02e4
            r3 = 44
            if (r5 != r3) goto L_0x02bc
            goto L_0x02e4
        L_0x02bc:
            r3 = 50
            if (r5 != r3) goto L_0x030c
            int r3 = r22 + 1
            r12[r22] = r21
            int r22 = r21 / 3
            int r22 = r22 * 2
            int r26 = r16 + 2
            r28 = r17[r31]
            r11[r22] = r28
            r28 = r3
            r3 = r7 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x02e1
            int r22 = r22 + 1
            int r3 = r16 + 3
            r16 = r17[r26]
            r11[r22] = r16
            r16 = r3
        L_0x02de:
            r22 = r28
            goto L_0x030e
        L_0x02e1:
            r16 = r26
            goto L_0x02de
        L_0x02e4:
            if (r10 != 0) goto L_0x030c
            int r3 = r21 / 3
            int r3 = r3 * 2
            int r3 = r3 + 1
            int r16 = r16 + 2
            r26 = r17[r31]
            r11[r3] = r26
            goto L_0x030e
        L_0x02f3:
            int r3 = r21 / 3
            int r3 = r3 * 2
            int r3 = r3 + 1
            int r16 = r16 + 2
            r26 = r17[r31]
            r11[r3] = r26
            goto L_0x030e
        L_0x0300:
            int r3 = r21 / 3
            int r3 = r3 * 2
            int r3 = r3 + 1
            java.lang.Class r16 = r4.getType()
            r11[r3] = r16
        L_0x030c:
            r16 = r31
        L_0x030e:
            long r3 = r15.objectFieldOffset(r4)
            int r4 = (int) r3
            r3 = r7 & 4096(0x1000, float:5.74E-42)
            r26 = r4
            r4 = 4096(0x1000, float:5.74E-42)
            if (r3 != r4) goto L_0x0367
            r3 = 17
            if (r5 > r3) goto L_0x0367
            int r3 = r1 + 1
            char r1 = r0.charAt(r1)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r4) goto L_0x0344
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r25 = 13
        L_0x032e:
            int r28 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r4) goto L_0x0340
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r25
            r1 = r1 | r3
            int r25 = r25 + 13
            r3 = r28
            goto L_0x032e
        L_0x0340:
            int r3 = r3 << r25
            r1 = r1 | r3
            goto L_0x0346
        L_0x0344:
            r28 = r3
        L_0x0346:
            int r3 = r6 * 2
            int r25 = r1 / 32
            int r3 = r3 + r25
            r4 = r17[r3]
            r30 = r0
            boolean r0 = r4 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0357
            java.lang.reflect.Field r4 = (java.lang.reflect.Field) r4
            goto L_0x035f
        L_0x0357:
            java.lang.String r4 = (java.lang.String) r4
            java.lang.reflect.Field r4 = reflectField(r2, r4)
            r17[r3] = r4
        L_0x035f:
            long r3 = r15.objectFieldOffset(r4)
            int r0 = (int) r3
            int r1 = r1 % 32
            goto L_0x036f
        L_0x0367:
            r30 = r0
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r28 = r1
            r1 = 0
        L_0x036f:
            r3 = 18
            if (r5 < r3) goto L_0x037d
            r3 = 49
            if (r5 > r3) goto L_0x037d
            int r3 = r23 + 1
            r12[r23] = r26
            r23 = r3
        L_0x037d:
            r4 = r26
        L_0x037f:
            int r3 = r21 + 1
            r24[r21] = r29
            int r26 = r21 + 2
            r29 = r0
            r0 = r7 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x038e
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x038f
        L_0x038e:
            r0 = 0
        L_0x038f:
            r7 = r7 & 256(0x100, float:3.59E-43)
            if (r7 == 0) goto L_0x0396
            r7 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0397
        L_0x0396:
            r7 = 0
        L_0x0397:
            r0 = r0 | r7
            int r5 = r5 << 20
            r0 = r0 | r5
            r0 = r0 | r4
            r24[r3] = r0
            int r21 = r21 + 3
            int r0 = r1 << 20
            r0 = r0 | r29
            r24[r26] = r0
            r3 = r24
            r1 = r27
            r4 = r28
            r0 = r30
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0185
        L_0x03b3:
            r24 = r3
            androidx.datastore.preferences.protobuf.MessageSchema r4 = new androidx.datastore.preferences.protobuf.MessageSchema
            androidx.datastore.preferences.protobuf.MessageLite r0 = r33.getDefaultInstance()
            r6 = r11
            r11 = 0
            r5 = r14
            r14 = r13
            r13 = r5
            r15 = r34
            r16 = r35
            r17 = r36
            r18 = r37
            r19 = r38
            r7 = r8
            r8 = r9
            r5 = r24
            r9 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.newSchemaForRawMessageInfo(androidx.datastore.preferences.protobuf.RawMessageInfo, androidx.datastore.preferences.protobuf.NewInstanceSchema, androidx.datastore.preferences.protobuf.ListFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, androidx.datastore.preferences.protobuf.MapFieldSchema):androidx.datastore.preferences.protobuf.MessageSchema");
    }

    private int numberAt(int i4) {
        return this.buffer[i4];
    }

    private static long offset(int i4) {
        return (long) (i4 & 1048575);
    }

    private static <T> boolean oneofBooleanAt(T t4, long j4) {
        return ((Boolean) UnsafeUtil.getObject((Object) t4, j4)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t4, long j4) {
        return ((Double) UnsafeUtil.getObject((Object) t4, j4)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t4, long j4) {
        return ((Float) UnsafeUtil.getObject((Object) t4, j4)).floatValue();
    }

    private static <T> int oneofIntAt(T t4, long j4) {
        return ((Integer) UnsafeUtil.getObject((Object) t4, j4)).intValue();
    }

    private static <T> long oneofLongAt(T t4, long j4) {
        return ((Long) UnsafeUtil.getObject((Object) t4, j4)).longValue();
    }

    private <K, V> int parseMapField(T t4, byte[] bArr, int i4, int i5, int i6, long j4, ArrayDecoders.Registers registers) throws IOException {
        long j5 = j4;
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i6);
        Object object = unsafe.getObject(t4, j5);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            unsafe.putObject(t4, j5, newMapField);
            object = newMapField;
        }
        return decodeMapEntry(bArr, i4, i5, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t4, byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, int i10, long j4, int i11, ArrayDecoders.Registers registers) throws IOException {
        int i12 = i7;
        int i13 = i8;
        long j5 = j4;
        int i14 = i11;
        Unsafe unsafe = UNSAFE;
        long j6 = (long) (this.buffer[i14 + 2] & 1048575);
        boolean z4 = true;
        switch (i10) {
            case 51:
                int i15 = i4;
                if (i13 != 1) {
                    return i15;
                }
                unsafe.putObject(t4, j5, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i4)));
                int i16 = i15 + 8;
                unsafe.putInt(t4, j6, i12);
                return i16;
            case 52:
                int i17 = i4;
                if (i13 != 5) {
                    return i17;
                }
                unsafe.putObject(t4, j5, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i4)));
                int i18 = i17 + 4;
                unsafe.putInt(t4, j6, i12);
                return i18;
            case 53:
            case 54:
                int i19 = i4;
                ArrayDecoders.Registers registers2 = registers;
                if (i13 != 0) {
                    return i19;
                }
                int decodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i19, registers2);
                unsafe.putObject(t4, j5, Long.valueOf(registers2.long1));
                unsafe.putInt(t4, j6, i12);
                return decodeVarint64;
            case 55:
            case 62:
                int i20 = i4;
                ArrayDecoders.Registers registers3 = registers;
                if (i13 != 0) {
                    return i20;
                }
                int decodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i20, registers3);
                unsafe.putObject(t4, j5, Integer.valueOf(registers3.int1));
                unsafe.putInt(t4, j6, i12);
                return decodeVarint32;
            case 56:
            case 65:
                int i21 = i4;
                if (i13 != 1) {
                    return i21;
                }
                unsafe.putObject(t4, j5, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i4)));
                int i22 = i21 + 8;
                unsafe.putInt(t4, j6, i12);
                return i22;
            case 57:
            case 64:
                int i23 = i4;
                if (i13 != 5) {
                    return i23;
                }
                unsafe.putObject(t4, j5, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i4)));
                int i24 = i23 + 4;
                unsafe.putInt(t4, j6, i12);
                return i24;
            case 58:
                int i25 = i4;
                ArrayDecoders.Registers registers4 = registers;
                if (i13 != 0) {
                    return i25;
                }
                int decodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i25, registers4);
                if (registers4.long1 == 0) {
                    z4 = false;
                }
                unsafe.putObject(t4, j5, Boolean.valueOf(z4));
                unsafe.putInt(t4, j6, i12);
                return decodeVarint642;
            case 59:
                int i26 = i4;
                ArrayDecoders.Registers registers5 = registers;
                if (i13 != 2) {
                    return i26;
                }
                int decodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i26, registers5);
                int i27 = registers5.int1;
                if (i27 == 0) {
                    unsafe.putObject(t4, j5, "");
                } else if ((i9 & ENFORCE_UTF8_MASK) == 0 || Utf8.isValidUtf8(bArr, decodeVarint322, decodeVarint322 + i27)) {
                    unsafe.putObject(t4, j5, new String(bArr, decodeVarint322, i27, Internal.UTF_8));
                    decodeVarint322 += i27;
                } else {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                unsafe.putInt(t4, j6, i12);
                return decodeVarint322;
            case 60:
                int i28 = i4;
                ArrayDecoders.Registers registers6 = registers;
                if (i13 != 2) {
                    return i28;
                }
                Object mutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t4, i12, i14);
                int mergeMessageField = ArrayDecoders.mergeMessageField(mutableOneofMessageFieldForMerge, getMessageFieldSchema(i14), bArr, i4, i5, registers6);
                storeOneofMessageField(t4, i12, i14, mutableOneofMessageFieldForMerge);
                return mergeMessageField;
            case 61:
                int i29 = i4;
                ArrayDecoders.Registers registers7 = registers;
                if (i13 != 2) {
                    return i29;
                }
                int decodeBytes = ArrayDecoders.decodeBytes(bArr, i29, registers7);
                unsafe.putObject(t4, j5, registers7.object1);
                unsafe.putInt(t4, j6, i12);
                return decodeBytes;
            case 63:
                int i30 = i4;
                int i31 = i6;
                ArrayDecoders.Registers registers8 = registers;
                if (i13 != 0) {
                    return i30;
                }
                int decodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i30, registers8);
                int i32 = registers8.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i14);
                if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i32)) {
                    unsafe.putObject(t4, j5, Integer.valueOf(i32));
                    unsafe.putInt(t4, j6, i12);
                    return decodeVarint323;
                }
                getMutableUnknownFields(t4).storeField(i31, Long.valueOf((long) i32));
                return decodeVarint323;
            case 66:
                int i33 = i4;
                ArrayDecoders.Registers registers9 = registers;
                if (i13 != 0) {
                    return i33;
                }
                int decodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i33, registers9);
                unsafe.putObject(t4, j5, Integer.valueOf(CodedInputStream.decodeZigZag32(registers9.int1)));
                unsafe.putInt(t4, j6, i12);
                return decodeVarint324;
            case 67:
                int i34 = i4;
                ArrayDecoders.Registers registers10 = registers;
                if (i13 != 0) {
                    return i34;
                }
                int decodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i34, registers10);
                unsafe.putObject(t4, j5, Long.valueOf(CodedInputStream.decodeZigZag64(registers10.long1)));
                unsafe.putInt(t4, j6, i12);
                return decodeVarint643;
            case 68:
                if (i13 == 3) {
                    Object mutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t4, i12, i14);
                    int mergeGroupField = ArrayDecoders.mergeGroupField(mutableOneofMessageFieldForMerge2, getMessageFieldSchema(i14), bArr, i4, i5, (i6 & -8) | 4, registers);
                    storeOneofMessageField(t4, i12, i14, mutableOneofMessageFieldForMerge2);
                    return mergeGroupField;
                }
                break;
        }
        return i4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v66, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v67, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        r8 = r6;
        r13 = r7;
        r9 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c8, code lost:
        r11 = r11 | r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c9, code lost:
        r3 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ca, code lost:
        r5 = r9;
        r4 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cd, code lost:
        r8 = r6;
        r13 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0112, code lost:
        r11 = r11 | r15;
        r3 = r13;
        r13 = r1;
        r1 = r7;
        r7 = r3;
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0118, code lost:
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0119, code lost:
        r5 = r9;
        r4 = r12;
        r9 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014a, code lost:
        r1 = r8;
        r8 = r2;
        r2 = r1;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01ab, code lost:
        r11 = r11 | r15;
        r4 = r13;
        r13 = r7;
        r7 = r4;
        r8 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0231, code lost:
        r25 = r2;
        r2 = r8;
        r19 = r9;
        r6 = r12;
        r8 = r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.datastore.preferences.protobuf.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int parseProto3Message(T r28, byte[] r29, int r30, int r31, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r32) throws java.io.IOException {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r7 = r29
            r8 = r31
            r13 = r32
            checkMutable(r1)
            sun.misc.Unsafe r2 = UNSAFE
            r16 = 0
            r9 = -1
            r3 = r30
            r4 = -1
            r5 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r11 = 0
        L_0x001a:
            if (r3 >= r8) goto L_0x0377
            int r6 = r3 + 1
            byte r3 = r7[r3]
            if (r3 >= 0) goto L_0x0028
            int r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r3, r7, r6, r13)
            int r3 = r13.int1
        L_0x0028:
            int r12 = r3 >>> 3
            r14 = r3 & 7
            if (r12 <= r4) goto L_0x0035
            int r5 = r5 / 3
            int r4 = r0.positionForFieldNumber(r12, r5)
            goto L_0x0039
        L_0x0035:
            int r4 = r0.positionForFieldNumber(r12)
        L_0x0039:
            if (r4 != r9) goto L_0x0048
            r8 = r1
            r25 = r2
            r18 = r3
            r2 = r6
            r6 = r12
            r17 = -1
            r19 = 0
            goto L_0x0356
        L_0x0048:
            int[] r5 = r0.buffer
            int r17 = r4 + 1
            r5 = r5[r17]
            int r9 = type(r5)
            r18 = r3
            r19 = r4
            long r3 = offset(r5)
            r20 = 1048575(0xfffff, float:1.469367E-39)
            r15 = 17
            r21 = r3
            if (r9 > r15) goto L_0x023c
            int[] r4 = r0.buffer
            int r15 = r19 + 2
            r4 = r4[r15]
            int r15 = r4 >>> 20
            r3 = 1
            int r15 = r3 << r15
            r4 = r4 & r20
            if (r4 == r10) goto L_0x008a
            r3 = 1048575(0xfffff, float:1.469367E-39)
            if (r10 == r3) goto L_0x0082
            r23 = r4
            long r3 = (long) r10
            r2.putInt(r1, r3, r11)
            r4 = r23
            r3 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0082:
            if (r4 == r3) goto L_0x0089
            long r10 = (long) r4
            int r11 = r2.getInt(r1, r10)
        L_0x0089:
            r10 = r4
        L_0x008a:
            r3 = 5
            switch(r9) {
                case 0: goto L_0x0212;
                case 1: goto L_0x01fe;
                case 2: goto L_0x01da;
                case 3: goto L_0x01da;
                case 4: goto L_0x01bf;
                case 5: goto L_0x018a;
                case 6: goto L_0x016f;
                case 7: goto L_0x0150;
                case 8: goto L_0x0129;
                case 9: goto L_0x00f2;
                case 10: goto L_0x00e1;
                case 11: goto L_0x01bf;
                case 12: goto L_0x00d1;
                case 13: goto L_0x016f;
                case 14: goto L_0x018a;
                case 15: goto L_0x00b5;
                case 16: goto L_0x0094;
                default: goto L_0x008e;
            }
        L_0x008e:
            r8 = r6
            r13 = r7
            r9 = r19
            goto L_0x0231
        L_0x0094:
            if (r14 != 0) goto L_0x008e
            int r9 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r7, r6, r13)
            long r3 = r13.long1
            long r5 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag64(r3)
            r3 = r2
            r2 = r1
            r1 = r3
            r3 = r21
            r1.putLong(r2, r3, r5)
            r26 = r2
            r2 = r1
            r1 = r26
            r11 = r11 | r15
            r3 = r9
            r4 = r12
            r5 = r19
        L_0x00b2:
            r9 = -1
            goto L_0x001a
        L_0x00b5:
            r9 = r19
            r3 = r21
            if (r14 != 0) goto L_0x00cd
            int r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r7, r6, r13)
            int r6 = r13.int1
            int r6 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag32(r6)
            r2.putInt(r1, r3, r6)
        L_0x00c8:
            r11 = r11 | r15
        L_0x00c9:
            r3 = r5
        L_0x00ca:
            r5 = r9
            r4 = r12
            goto L_0x00b2
        L_0x00cd:
            r8 = r6
            r13 = r7
            goto L_0x0231
        L_0x00d1:
            r9 = r19
            r3 = r21
            if (r14 != 0) goto L_0x00cd
            int r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r7, r6, r13)
            int r6 = r13.int1
            r2.putInt(r1, r3, r6)
            goto L_0x00c8
        L_0x00e1:
            r9 = r19
            r3 = r21
            r5 = 2
            if (r14 != r5) goto L_0x00cd
            int r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeBytes(r7, r6, r13)
            java.lang.Object r6 = r13.object1
            r2.putObject(r1, r3, r6)
            goto L_0x00c8
        L_0x00f2:
            r9 = r19
            r5 = 2
            if (r14 != r5) goto L_0x0120
            r3 = r1
            java.lang.Object r1 = r0.mutableMessageFieldForMerge(r3, r9)
            r4 = r2
            androidx.datastore.preferences.protobuf.Schema r2 = r0.getMessageFieldSchema(r9)
            r5 = r7
            r7 = r3
            r3 = r5
            r5 = r8
            r8 = r4
            r4 = r6
            r6 = r13
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.mergeMessageField(r1, r2, r3, r4, r5, r6)
            r13 = r3
            r3 = r1
            r1 = r6
            r0.storeMessageField(r7, r9, r3)
        L_0x0112:
            r11 = r11 | r15
            r3 = r13
            r13 = r1
            r1 = r7
            r7 = r3
            r3 = r2
        L_0x0118:
            r2 = r8
        L_0x0119:
            r5 = r9
            r4 = r12
            r9 = -1
        L_0x011c:
            r8 = r31
            goto L_0x001a
        L_0x0120:
            r8 = r7
            r7 = r1
            r1 = r13
            r13 = r8
            r8 = r2
            r1 = r7
            r8 = r6
            goto L_0x0231
        L_0x0129:
            r3 = r7
            r7 = r1
            r1 = r13
            r13 = r3
            r8 = r2
            r2 = r6
            r9 = r19
            r3 = r21
            r6 = 2
            if (r14 != r6) goto L_0x014a
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r5 & r6
            if (r5 != 0) goto L_0x0140
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeString(r13, r2, r1)
            goto L_0x0144
        L_0x0140:
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeStringRequireUtf8(r13, r2, r1)
        L_0x0144:
            java.lang.Object r5 = r1.object1
            r8.putObject(r7, r3, r5)
            goto L_0x0112
        L_0x014a:
            r1 = r8
            r8 = r2
            r2 = r1
            r1 = r7
            goto L_0x0231
        L_0x0150:
            r3 = r7
            r7 = r1
            r1 = r13
            r13 = r3
            r8 = r2
            r2 = r6
            r9 = r19
            r3 = r21
            if (r14 != 0) goto L_0x014a
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r13, r2, r1)
            long r5 = r1.long1
            r18 = 0
            int r14 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1))
            if (r14 == 0) goto L_0x016a
            r5 = 1
            goto L_0x016b
        L_0x016a:
            r5 = 0
        L_0x016b:
            androidx.datastore.preferences.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r7, (long) r3, (boolean) r5)
            goto L_0x0112
        L_0x016f:
            r4 = r7
            r7 = r1
            r1 = r13
            r13 = r4
            r8 = r2
            r2 = r6
            r9 = r19
            r4 = r21
            if (r14 != r3) goto L_0x014a
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFixed32(r13, r2)
            r8.putInt(r7, r4, r3)
            int r3 = r2 + 4
            r11 = r11 | r15
            r2 = r13
            r13 = r1
            r1 = r7
            r7 = r2
            goto L_0x0118
        L_0x018a:
            r3 = r7
            r7 = r1
            r1 = r13
            r13 = r3
            r8 = r2
            r2 = r6
            r9 = r19
            r4 = r21
            r3 = 1
            if (r14 != r3) goto L_0x01b3
            r3 = r4
            long r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFixed64(r13, r2)
            r26 = r7
            r7 = r1
            r1 = r8
            r8 = r2
            r2 = r26
            r1.putLong(r2, r3, r5)
            r2 = r1
            r1 = r26
            int r3 = r8 + 8
        L_0x01ab:
            r11 = r11 | r15
            r4 = r13
            r13 = r7
            r7 = r4
            r8 = r31
            goto L_0x00ca
        L_0x01b3:
            r26 = r7
            r7 = r1
            r1 = r26
            r26 = r8
            r8 = r2
            r2 = r26
            goto L_0x0231
        L_0x01bf:
            r3 = r13
            r13 = r7
            r7 = r3
            r8 = r6
            r9 = r19
            r3 = r21
            if (r14 != 0) goto L_0x0231
            int r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r13, r8, r7)
            int r6 = r7.int1
            r2.putInt(r1, r3, r6)
            r11 = r11 | r15
            r3 = r13
            r13 = r7
            r7 = r3
            r8 = r31
            goto L_0x00c9
        L_0x01da:
            r3 = r13
            r13 = r7
            r7 = r3
            r8 = r6
            r9 = r19
            r3 = r21
            if (r14 != 0) goto L_0x0231
            int r8 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r13, r8, r7)
            long r5 = r7.long1
            r26 = r2
            r2 = r1
            r1 = r26
            r1.putLong(r2, r3, r5)
            r26 = r2
            r2 = r1
            r1 = r26
            r11 = r11 | r15
            r3 = r13
            r13 = r7
            r7 = r3
            r3 = r8
            goto L_0x0119
        L_0x01fe:
            r4 = r13
            r13 = r7
            r7 = r4
            r8 = r6
            r9 = r19
            r4 = r21
            if (r14 != r3) goto L_0x0231
            float r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFloat(r13, r8)
            androidx.datastore.preferences.protobuf.UnsafeUtil.putFloat((java.lang.Object) r1, (long) r4, (float) r3)
            int r3 = r8 + 4
            goto L_0x01ab
        L_0x0212:
            r3 = r13
            r13 = r7
            r7 = r3
            r8 = r6
            r9 = r19
            r4 = r21
            r3 = 1
            if (r14 != r3) goto L_0x0231
            double r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeDouble(r13, r8)
            androidx.datastore.preferences.protobuf.UnsafeUtil.putDouble((java.lang.Object) r1, (long) r4, (double) r6)
            int r3 = r8 + 8
            r11 = r11 | r15
            r8 = r31
            r5 = r9
            r4 = r12
            r7 = r13
            r9 = -1
            r13 = r32
            goto L_0x001a
        L_0x0231:
            r25 = r2
            r2 = r8
            r19 = r9
            r6 = r12
            r17 = -1
            r8 = r1
            goto L_0x0356
        L_0x023c:
            r8 = r6
            r13 = r7
            r15 = r19
            r3 = r21
            r6 = 27
            if (r9 != r6) goto L_0x0298
            r6 = 2
            if (r14 != r6) goto L_0x0286
            java.lang.Object r5 = r2.getObject(r1, r3)
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r5 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r5
            boolean r6 = r5.isModifiable()
            if (r6 != 0) goto L_0x0267
            int r6 = r5.size()
            if (r6 != 0) goto L_0x025e
            r6 = 10
            goto L_0x0260
        L_0x025e:
            int r6 = r6 * 2
        L_0x0260:
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r5 = r5.mutableCopyWithCapacity(r6)
            r2.putObject(r1, r3, r5)
        L_0x0267:
            r6 = r5
            androidx.datastore.preferences.protobuf.Schema r1 = r0.getMessageFieldSchema(r15)
            r5 = r31
            r7 = r32
            r4 = r8
            r3 = r13
            r8 = r2
            r2 = r18
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeMessageList(r1, r2, r3, r4, r5, r6, r7)
            r7 = r29
            r13 = r32
            r3 = r1
            r2 = r8
            r4 = r12
            r5 = r15
            r9 = -1
            r1 = r28
            goto L_0x011c
        L_0x0286:
            r26 = r8
            r8 = r2
            r2 = r26
            r3 = r2
            r25 = r8
            r24 = r11
            r9 = r12
            r19 = r15
            r17 = -1
            r15 = r10
            goto L_0x0324
        L_0x0298:
            r26 = r8
            r8 = r2
            r2 = r26
            r1 = 49
            if (r9 > r1) goto L_0x02e3
            r1 = r10
            r6 = r11
            r11 = r9
            long r9 = (long) r5
            r24 = r6
            r25 = r8
            r6 = r12
            r7 = r14
            r8 = r15
            r5 = r18
            r17 = -1
            r14 = r32
            r15 = r1
            r12 = r3
            r1 = r28
            r4 = r31
            r3 = r2
            r2 = r29
            int r7 = r0.parseRepeatedField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r9 = r6
            r19 = r8
            if (r7 == r3) goto L_0x02da
            r0 = r27
            r1 = r28
            r8 = r31
            r13 = r32
            r3 = r7
            r4 = r9
            r10 = r15
            r5 = r19
            r11 = r24
            r2 = r25
            r9 = -1
            r7 = r29
            goto L_0x001a
        L_0x02da:
            r8 = r28
            r2 = r7
        L_0x02dd:
            r6 = r9
        L_0x02de:
            r10 = r15
            r11 = r24
            goto L_0x0356
        L_0x02e3:
            r25 = r8
            r24 = r11
            r7 = r14
            r19 = r15
            r17 = -1
            r11 = r9
            r15 = r10
            r9 = r12
            r12 = r3
            r3 = r2
            r0 = 50
            if (r11 != r0) goto L_0x0328
            r6 = 2
            if (r7 != r6) goto L_0x0324
            r0 = r27
            r1 = r28
            r2 = r29
            r4 = r31
            r8 = r32
            r6 = r12
            r5 = r19
            int r6 = r0.parseMapField(r1, r2, r3, r4, r5, r6, r8)
            if (r6 == r3) goto L_0x0320
            r0 = r27
            r1 = r28
            r7 = r29
            r8 = r31
            r13 = r32
            r3 = r6
            r4 = r9
            r10 = r15
            r5 = r19
            r11 = r24
            r2 = r25
            goto L_0x00b2
        L_0x0320:
            r8 = r28
            r2 = r6
            goto L_0x02dd
        L_0x0324:
            r8 = r28
            r2 = r3
            goto L_0x02dd
        L_0x0328:
            r0 = r27
            r1 = r28
            r2 = r29
            r4 = r31
            r8 = r5
            r6 = r9
            r9 = r11
            r10 = r12
            r5 = r18
            r12 = r19
            r13 = r32
            int r7 = r0.parseOneofField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            r8 = r1
            if (r7 == r3) goto L_0x0354
            r0 = r27
            r13 = r32
            r4 = r6
            r3 = r7
            r1 = r8
            r10 = r15
            r5 = r19
            r11 = r24
            r2 = r25
            r9 = -1
            r7 = r29
            goto L_0x011c
        L_0x0354:
            r2 = r7
            goto L_0x02de
        L_0x0356:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = getMutableUnknownFields(r8)
            r1 = r29
            r3 = r31
            r5 = r32
            r0 = r18
            int r0 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeUnknownField(r0, r1, r2, r3, r4, r5)
            r7 = r29
            r13 = r32
            r4 = r6
            r1 = r8
            r5 = r19
            r2 = r25
            r9 = -1
            r8 = r3
            r3 = r0
            r0 = r27
            goto L_0x001a
        L_0x0377:
            r25 = r2
            r4 = r8
            r15 = r10
            r24 = r11
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r1
            if (r15 == r0) goto L_0x038b
            long r0 = (long) r15
            r6 = r24
            r2 = r25
            r2.putInt(r8, r0, r6)
        L_0x038b:
            if (r3 != r4) goto L_0x038e
            return r3
        L_0x038e:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.parseProto3Message(java.lang.Object, byte[], int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    private int parseRepeatedField(T t4, byte[] bArr, int i4, int i5, int i6, int i7, int i8, int i9, long j4, int i10, long j5, ArrayDecoders.Registers registers) throws IOException {
        int i11;
        int i12 = i9;
        long j6 = j5;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufList = (Internal.ProtobufList) unsafe.getObject(t4, j6);
        if (!protobufList.isModifiable()) {
            int size = protobufList.size();
            protobufList = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(t4, j6, protobufList);
        }
        Internal.ProtobufList protobufList2 = protobufList;
        switch (i10) {
            case 18:
            case 35:
                ArrayDecoders.Registers registers2 = registers;
                if (i8 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i4, protobufList2, registers2);
                }
                if (i8 == 1) {
                    return ArrayDecoders.decodeDoubleList(i6, bArr, i4, i5, protobufList2, registers2);
                }
                break;
            case 19:
            case 36:
                ArrayDecoders.Registers registers3 = registers;
                if (i8 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i4, protobufList2, registers3);
                }
                if (i8 == 5) {
                    return ArrayDecoders.decodeFloatList(i6, bArr, i4, i5, protobufList2, registers3);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                ArrayDecoders.Registers registers4 = registers;
                if (i8 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i4, protobufList2, registers4);
                }
                if (i8 == 0) {
                    return ArrayDecoders.decodeVarint64List(i6, bArr, i4, i5, protobufList2, registers4);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                ArrayDecoders.Registers registers5 = registers;
                if (i8 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i4, protobufList2, registers5);
                }
                if (i8 == 0) {
                    return ArrayDecoders.decodeVarint32List(i6, bArr, i4, i5, protobufList2, registers5);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                ArrayDecoders.Registers registers6 = registers;
                if (i8 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i4, protobufList2, registers6);
                }
                if (i8 == 1) {
                    return ArrayDecoders.decodeFixed64List(i6, bArr, i4, i5, protobufList2, registers6);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                ArrayDecoders.Registers registers7 = registers;
                if (i8 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i4, protobufList2, registers7);
                }
                if (i8 == 5) {
                    return ArrayDecoders.decodeFixed32List(i6, bArr, i4, i5, protobufList2, registers7);
                }
                break;
            case 25:
            case 42:
                ArrayDecoders.Registers registers8 = registers;
                if (i8 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i4, protobufList2, registers8);
                }
                if (i8 == 0) {
                    return ArrayDecoders.decodeBoolList(i6, bArr, i4, i5, protobufList2, registers8);
                }
                break;
            case 26:
                if (i8 == 2) {
                    if ((j4 & 536870912) == 0) {
                        return ArrayDecoders.decodeStringList(i6, bArr, i4, i5, protobufList2, registers);
                    }
                    return ArrayDecoders.decodeStringListRequireUtf8(i6, bArr, i4, i5, protobufList2, registers);
                }
                break;
            case 27:
                if (i8 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i12), i6, bArr, i4, i5, protobufList2, registers);
                }
                break;
            case 28:
                if (i8 == 2) {
                    return ArrayDecoders.decodeBytesList(i6, bArr, i4, i5, protobufList2, registers);
                }
                break;
            case 30:
            case 44:
                ArrayDecoders.Registers registers9 = registers;
                if (i8 == 2) {
                    i11 = ArrayDecoders.decodePackedVarint32List(bArr, i4, protobufList2, registers9);
                } else if (i8 == 0) {
                    i11 = ArrayDecoders.decodeVarint32List(i6, bArr, i4, i5, protobufList2, registers9);
                }
                SchemaUtil.filterUnknownEnumList((Object) t4, i7, (List<Integer>) protobufList2, getEnumFieldVerifier(i12), null, this.unknownFieldSchema);
                return i11;
            case 33:
            case 47:
                ArrayDecoders.Registers registers10 = registers;
                if (i8 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i4, protobufList2, registers10);
                }
                if (i8 == 0) {
                    return ArrayDecoders.decodeSInt32List(i6, bArr, i4, i5, protobufList2, registers10);
                }
                break;
            case 34:
            case 48:
                ArrayDecoders.Registers registers11 = registers;
                if (i8 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i4, protobufList2, registers11);
                }
                if (i8 == 0) {
                    return ArrayDecoders.decodeSInt64List(i6, bArr, i4, i5, protobufList2, registers11);
                }
                break;
            case 49:
                if (i8 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i12), i6, bArr, i4, i5, protobufList2, registers);
                }
                break;
        }
        return i4;
    }

    private int positionForFieldNumber(int i4) {
        if (i4 < this.minFieldNumber || i4 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i4, 0);
    }

    private int presenceMaskAndOffsetAt(int i4) {
        return this.buffer[i4 + 2];
    }

    private <E> void readGroupList(Object obj, long j4, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j4), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i4, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i4)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i4, Reader reader) throws IOException {
        if (isEnforceUtf8(i4)) {
            UnsafeUtil.putObject(obj, offset(i4), (Object) reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i4), (Object) reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i4), (Object) reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i4, Reader reader) throws IOException {
        if (isEnforceUtf8(i4)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i4)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i4)));
        }
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void setFieldPresent(T t4, int i4) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i4);
        long j4 = (long) (1048575 & presenceMaskAndOffsetAt);
        if (j4 != 1048575) {
            UnsafeUtil.putInt((Object) t4, j4, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt((Object) t4, j4));
        }
    }

    private void setOneofPresent(T t4, int i4, int i5) {
        UnsafeUtil.putInt((Object) t4, (long) (presenceMaskAndOffsetAt(i5) & 1048575), i4);
    }

    private int slowPositionForFieldNumber(int i4, int i5) {
        int length = (this.buffer.length / 3) - 1;
        while (i5 <= length) {
            int i6 = (length + i5) >>> 1;
            int i7 = i6 * 3;
            int numberAt = numberAt(i7);
            if (i4 == numberAt) {
                return i7;
            }
            if (i4 < numberAt) {
                length = i6 - 1;
            } else {
                i5 = i6 + 1;
            }
        }
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo r8, int[] r9, int r10, java.lang.Object[] r11) {
        /*
            androidx.datastore.preferences.protobuf.OneofInfo r0 = r8.getOneof()
            r1 = 0
            if (r0 == 0) goto L_0x0025
            androidx.datastore.preferences.protobuf.FieldType r2 = r8.getType()
            int r2 = r2.id()
            int r2 = r2 + 51
            java.lang.reflect.Field r3 = r0.getValueField()
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r3)
            int r4 = (int) r3
            java.lang.reflect.Field r0 = r0.getCaseField()
            long r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
        L_0x0022:
            int r0 = (int) r5
        L_0x0023:
            r3 = 0
            goto L_0x006b
        L_0x0025:
            androidx.datastore.preferences.protobuf.FieldType r0 = r8.getType()
            java.lang.reflect.Field r2 = r8.getField()
            long r2 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r2)
            int r4 = (int) r2
            int r2 = r0.id()
            boolean r3 = r0.isList()
            if (r3 != 0) goto L_0x005a
            boolean r0 = r0.isMap()
            if (r0 != 0) goto L_0x005a
            java.lang.reflect.Field r0 = r8.getPresenceField()
            if (r0 != 0) goto L_0x004c
            r0 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0051
        L_0x004c:
            long r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
            int r0 = (int) r5
        L_0x0051:
            int r3 = r8.getPresenceMask()
            int r3 = java.lang.Integer.numberOfTrailingZeros(r3)
            goto L_0x006b
        L_0x005a:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            if (r0 != 0) goto L_0x0062
            r0 = 0
            goto L_0x0023
        L_0x0062:
            java.lang.reflect.Field r0 = r8.getCachedSizeField()
            long r5 = androidx.datastore.preferences.protobuf.UnsafeUtil.objectFieldOffset(r0)
            goto L_0x0022
        L_0x006b:
            int r5 = r8.getFieldNumber()
            r9[r10] = r5
            int r5 = r10 + 1
            boolean r6 = r8.isEnforceUtf8()
            if (r6 == 0) goto L_0x007c
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x007d
        L_0x007c:
            r6 = 0
        L_0x007d:
            boolean r7 = r8.isRequired()
            if (r7 == 0) goto L_0x0085
            r1 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0085:
            r1 = r1 | r6
            int r2 = r2 << 20
            r1 = r1 | r2
            r1 = r1 | r4
            r9[r5] = r1
            int r1 = r10 + 2
            int r2 = r3 << 20
            r0 = r0 | r2
            r9[r1] = r0
            java.lang.Class r9 = r8.getMessageFieldClass()
            java.lang.Object r0 = r8.getMapDefaultEntry()
            if (r0 == 0) goto L_0x00bd
            int r10 = r10 / 3
            int r10 = r10 * 2
            java.lang.Object r0 = r8.getMapDefaultEntry()
            r11[r10] = r0
            if (r9 == 0) goto L_0x00ae
            int r10 = r10 + 1
            r11[r10] = r9
            return
        L_0x00ae:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00da
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
            return
        L_0x00bd:
            if (r9 == 0) goto L_0x00c8
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            r11[r10] = r9
            return
        L_0x00c8:
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r9 = r8.getEnumVerifier()
            if (r9 == 0) goto L_0x00da
            int r10 = r10 / 3
            int r10 = r10 * 2
            int r10 = r10 + 1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r8 = r8.getEnumVerifier()
            r11[r10] = r8
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.storeFieldData(androidx.datastore.preferences.protobuf.FieldInfo, int[], int, java.lang.Object[]):void");
    }

    private void storeMessageField(T t4, int i4, Object obj) {
        UNSAFE.putObject(t4, offset(typeAndOffsetAt(i4)), obj);
        setFieldPresent(t4, i4);
    }

    private void storeOneofMessageField(T t4, int i4, int i5, Object obj) {
        UNSAFE.putObject(t4, offset(typeAndOffsetAt(i5)), obj);
        setOneofPresent(t4, i4, i5);
    }

    private static int type(int i4) {
        return (i4 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i4) {
        return this.buffer[i4 + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x048e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInAscendingOrderProto2(T r19, androidx.datastore.preferences.protobuf.Writer r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.hasExtensions
            if (r3 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r3 = r0.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r3 = r3.getExtensions(r1)
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            int[] r6 = r0.buffer
            int r6 = r6.length
            sun.misc.Unsafe r7 = UNSAFE
            r10 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x002d:
            if (r10 >= r6) goto L_0x048c
            int r13 = r0.typeAndOffsetAt(r10)
            int r14 = r0.numberAt(r10)
            int r15 = type(r13)
            r4 = 17
            r16 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            if (r15 > r4) goto L_0x0058
            int[] r4 = r0.buffer
            int r17 = r10 + 2
            r4 = r4[r17]
            r9 = r4 & r16
            if (r9 == r11) goto L_0x0053
            long r11 = (long) r9
            int r12 = r7.getInt(r1, r11)
            r11 = r9
        L_0x0053:
            int r4 = r4 >>> 20
            int r4 = r8 << r4
            goto L_0x0059
        L_0x0058:
            r4 = 0
        L_0x0059:
            if (r5 == 0) goto L_0x0077
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r9 = r0.extensionSchema
            int r9 = r9.extensionNumber(r5)
            if (r9 > r14) goto L_0x0077
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r9 = r0.extensionSchema
            r9.serializeExtension(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0075
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0059
        L_0x0075:
            r5 = 0
            goto L_0x0059
        L_0x0077:
            long r8 = offset(r13)
            switch(r15) {
                case 0: goto L_0x047d;
                case 1: goto L_0x0471;
                case 2: goto L_0x0465;
                case 3: goto L_0x0459;
                case 4: goto L_0x044d;
                case 5: goto L_0x0441;
                case 6: goto L_0x0435;
                case 7: goto L_0x0429;
                case 8: goto L_0x041d;
                case 9: goto L_0x040c;
                case 10: goto L_0x03fd;
                case 11: goto L_0x03f0;
                case 12: goto L_0x03e3;
                case 13: goto L_0x03d6;
                case 14: goto L_0x03c9;
                case 15: goto L_0x03bc;
                case 16: goto L_0x03af;
                case 17: goto L_0x039e;
                case 18: goto L_0x038e;
                case 19: goto L_0x037e;
                case 20: goto L_0x036e;
                case 21: goto L_0x035e;
                case 22: goto L_0x034e;
                case 23: goto L_0x033e;
                case 24: goto L_0x032e;
                case 25: goto L_0x031e;
                case 26: goto L_0x030f;
                case 27: goto L_0x02fc;
                case 28: goto L_0x02ed;
                case 29: goto L_0x02dd;
                case 30: goto L_0x02cd;
                case 31: goto L_0x02bd;
                case 32: goto L_0x02ad;
                case 33: goto L_0x029d;
                case 34: goto L_0x028d;
                case 35: goto L_0x027d;
                case 36: goto L_0x026d;
                case 37: goto L_0x025d;
                case 38: goto L_0x024d;
                case 39: goto L_0x023d;
                case 40: goto L_0x022d;
                case 41: goto L_0x021d;
                case 42: goto L_0x020d;
                case 43: goto L_0x01fd;
                case 44: goto L_0x01ed;
                case 45: goto L_0x01dd;
                case 46: goto L_0x01cd;
                case 47: goto L_0x01bd;
                case 48: goto L_0x01ad;
                case 49: goto L_0x019a;
                case 50: goto L_0x0191;
                case 51: goto L_0x0182;
                case 52: goto L_0x0173;
                case 53: goto L_0x0164;
                case 54: goto L_0x0155;
                case 55: goto L_0x0146;
                case 56: goto L_0x0137;
                case 57: goto L_0x0128;
                case 58: goto L_0x0119;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f7;
                case 61: goto L_0x00e7;
                case 62: goto L_0x00d9;
                case 63: goto L_0x00cb;
                case 64: goto L_0x00bd;
                case 65: goto L_0x00af;
                case 66: goto L_0x00a1;
                case 67: goto L_0x0093;
                case 68: goto L_0x0081;
                default: goto L_0x007e;
            }
        L_0x007e:
            r13 = 0
            goto L_0x0488
        L_0x0081:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            java.lang.Object r4 = r7.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeGroup(r14, r4, r8)
            goto L_0x007e
        L_0x0093:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            long r8 = oneofLongAt(r1, r8)
            r2.writeSInt64(r14, r8)
            goto L_0x007e
        L_0x00a1:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            int r4 = oneofIntAt(r1, r8)
            r2.writeSInt32(r14, r4)
            goto L_0x007e
        L_0x00af:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            long r8 = oneofLongAt(r1, r8)
            r2.writeSFixed64(r14, r8)
            goto L_0x007e
        L_0x00bd:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            int r4 = oneofIntAt(r1, r8)
            r2.writeSFixed32(r14, r4)
            goto L_0x007e
        L_0x00cb:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            int r4 = oneofIntAt(r1, r8)
            r2.writeEnum(r14, r4)
            goto L_0x007e
        L_0x00d9:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            int r4 = oneofIntAt(r1, r8)
            r2.writeUInt32(r14, r4)
            goto L_0x007e
        L_0x00e7:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            java.lang.Object r4 = r7.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r2.writeBytes(r14, r4)
            goto L_0x007e
        L_0x00f7:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            java.lang.Object r4 = r7.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeMessage(r14, r4, r8)
            goto L_0x007e
        L_0x010a:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.writeString(r14, r4, r2)
            goto L_0x007e
        L_0x0119:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            boolean r4 = oneofBooleanAt(r1, r8)
            r2.writeBool(r14, r4)
            goto L_0x007e
        L_0x0128:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            int r4 = oneofIntAt(r1, r8)
            r2.writeFixed32(r14, r4)
            goto L_0x007e
        L_0x0137:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            long r8 = oneofLongAt(r1, r8)
            r2.writeFixed64(r14, r8)
            goto L_0x007e
        L_0x0146:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            int r4 = oneofIntAt(r1, r8)
            r2.writeInt32(r14, r4)
            goto L_0x007e
        L_0x0155:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            long r8 = oneofLongAt(r1, r8)
            r2.writeUInt64(r14, r8)
            goto L_0x007e
        L_0x0164:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            long r8 = oneofLongAt(r1, r8)
            r2.writeInt64(r14, r8)
            goto L_0x007e
        L_0x0173:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            float r4 = oneofFloatAt(r1, r8)
            r2.writeFloat(r14, r4)
            goto L_0x007e
        L_0x0182:
            boolean r4 = r0.isOneofPresent(r1, r14, r10)
            if (r4 == 0) goto L_0x007e
            double r8 = oneofDoubleAt(r1, r8)
            r2.writeDouble(r14, r8)
            goto L_0x007e
        L_0x0191:
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.writeMapHelper(r2, r14, r4, r10)
            goto L_0x007e
        L_0x019a:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.Schema r9 = r0.getMessageFieldSchema(r10)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeGroupList(r4, r8, r2, r9)
            goto L_0x007e
        L_0x01ad:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 1
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r4, r8, r2, r13)
            goto L_0x007e
        L_0x01bd:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r4, r8, r2, r13)
            goto L_0x007e
        L_0x01cd:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r4, r8, r2, r13)
            goto L_0x007e
        L_0x01dd:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r4, r8, r2, r13)
            goto L_0x007e
        L_0x01ed:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r4, r8, r2, r13)
            goto L_0x007e
        L_0x01fd:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r4, r8, r2, r13)
            goto L_0x007e
        L_0x020d:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r4, r8, r2, r13)
            goto L_0x007e
        L_0x021d:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r4, r8, r2, r13)
            goto L_0x007e
        L_0x022d:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r4, r8, r2, r13)
            goto L_0x007e
        L_0x023d:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r4, r8, r2, r13)
            goto L_0x007e
        L_0x024d:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r4, r8, r2, r13)
            goto L_0x007e
        L_0x025d:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r4, r8, r2, r13)
            goto L_0x007e
        L_0x026d:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r4, r8, r2, r13)
            goto L_0x007e
        L_0x027d:
            r13 = 1
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r4, r8, r2, r13)
            goto L_0x007e
        L_0x028d:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r4, r8, r2, r13)
            goto L_0x0488
        L_0x029d:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r4, r8, r2, r13)
            goto L_0x0488
        L_0x02ad:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r4, r8, r2, r13)
            goto L_0x0488
        L_0x02bd:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r4, r8, r2, r13)
            goto L_0x0488
        L_0x02cd:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r4, r8, r2, r13)
            goto L_0x0488
        L_0x02dd:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r4, r8, r2, r13)
            goto L_0x0488
        L_0x02ed:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBytesList(r4, r8, r2)
            goto L_0x007e
        L_0x02fc:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.Schema r9 = r0.getMessageFieldSchema(r10)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeMessageList(r4, r8, r2, r9)
            goto L_0x007e
        L_0x030f:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeStringList(r4, r8, r2)
            goto L_0x007e
        L_0x031e:
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            r13 = 0
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r4, r8, r2, r13)
            goto L_0x0488
        L_0x032e:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r4, r8, r2, r13)
            goto L_0x0488
        L_0x033e:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r4, r8, r2, r13)
            goto L_0x0488
        L_0x034e:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r4, r8, r2, r13)
            goto L_0x0488
        L_0x035e:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r4, r8, r2, r13)
            goto L_0x0488
        L_0x036e:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r4, r8, r2, r13)
            goto L_0x0488
        L_0x037e:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r4, r8, r2, r13)
            goto L_0x0488
        L_0x038e:
            r13 = 0
            int r4 = r0.numberAt(r10)
            java.lang.Object r8 = r7.getObject(r1, r8)
            java.util.List r8 = (java.util.List) r8
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r4, r8, r2, r13)
            goto L_0x0488
        L_0x039e:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            java.lang.Object r4 = r7.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeGroup(r14, r4, r8)
            goto L_0x0488
        L_0x03af:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            long r8 = r7.getLong(r1, r8)
            r2.writeSInt64(r14, r8)
            goto L_0x0488
        L_0x03bc:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            int r4 = r7.getInt(r1, r8)
            r2.writeSInt32(r14, r4)
            goto L_0x0488
        L_0x03c9:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            long r8 = r7.getLong(r1, r8)
            r2.writeSFixed64(r14, r8)
            goto L_0x0488
        L_0x03d6:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            int r4 = r7.getInt(r1, r8)
            r2.writeSFixed32(r14, r4)
            goto L_0x0488
        L_0x03e3:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            int r4 = r7.getInt(r1, r8)
            r2.writeEnum(r14, r4)
            goto L_0x0488
        L_0x03f0:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            int r4 = r7.getInt(r1, r8)
            r2.writeUInt32(r14, r4)
            goto L_0x0488
        L_0x03fd:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            java.lang.Object r4 = r7.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r2.writeBytes(r14, r4)
            goto L_0x0488
        L_0x040c:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            java.lang.Object r4 = r7.getObject(r1, r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r0.getMessageFieldSchema(r10)
            r2.writeMessage(r14, r4, r8)
            goto L_0x0488
        L_0x041d:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            java.lang.Object r4 = r7.getObject(r1, r8)
            r0.writeString(r14, r4, r2)
            goto L_0x0488
        L_0x0429:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            boolean r4 = booleanAt(r1, r8)
            r2.writeBool(r14, r4)
            goto L_0x0488
        L_0x0435:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            int r4 = r7.getInt(r1, r8)
            r2.writeFixed32(r14, r4)
            goto L_0x0488
        L_0x0441:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            long r8 = r7.getLong(r1, r8)
            r2.writeFixed64(r14, r8)
            goto L_0x0488
        L_0x044d:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            int r4 = r7.getInt(r1, r8)
            r2.writeInt32(r14, r4)
            goto L_0x0488
        L_0x0459:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            long r8 = r7.getLong(r1, r8)
            r2.writeUInt64(r14, r8)
            goto L_0x0488
        L_0x0465:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            long r8 = r7.getLong(r1, r8)
            r2.writeInt64(r14, r8)
            goto L_0x0488
        L_0x0471:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            float r4 = floatAt(r1, r8)
            r2.writeFloat(r14, r4)
            goto L_0x0488
        L_0x047d:
            r13 = 0
            r4 = r4 & r12
            if (r4 == 0) goto L_0x0488
            double r8 = doubleAt(r1, r8)
            r2.writeDouble(r14, r8)
        L_0x0488:
            int r10 = r10 + 3
            goto L_0x002d
        L_0x048c:
            if (r5 == 0) goto L_0x04a3
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r4 = r0.extensionSchema
            r4.serializeExtension(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a1
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x048c
        L_0x04a1:
            r5 = 0
            goto L_0x048c
        L_0x04a3:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r3 = r0.unknownFieldSchema
            r0.writeUnknownInMessageTo(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInAscendingOrderProto2(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x0588  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInAscendingOrderProto3(T r13, androidx.datastore.preferences.protobuf.Writer r14) throws java.io.IOException {
        /*
            r12 = this;
            boolean r0 = r12.hasExtensions
            r1 = 0
            if (r0 == 0) goto L_0x001c
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r12.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.getExtensions(r13)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x001c
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x001e
        L_0x001c:
            r0 = r1
            r2 = r0
        L_0x001e:
            int[] r3 = r12.buffer
            int r3 = r3.length
            r4 = 0
            r5 = 0
        L_0x0023:
            if (r5 >= r3) goto L_0x0586
            int r6 = r12.typeAndOffsetAt(r5)
            int r7 = r12.numberAt(r5)
        L_0x002d:
            if (r2 == 0) goto L_0x004b
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r8 = r12.extensionSchema
            int r8 = r8.extensionNumber(r2)
            if (r8 > r7) goto L_0x004b
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r8 = r12.extensionSchema
            r8.serializeExtension(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0049
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x002d
        L_0x0049:
            r2 = r1
            goto L_0x002d
        L_0x004b:
            int r8 = type(r6)
            r9 = 1
            switch(r8) {
                case 0: goto L_0x0571;
                case 1: goto L_0x055f;
                case 2: goto L_0x054d;
                case 3: goto L_0x053b;
                case 4: goto L_0x0529;
                case 5: goto L_0x0517;
                case 6: goto L_0x0505;
                case 7: goto L_0x04f2;
                case 8: goto L_0x04df;
                case 9: goto L_0x04c8;
                case 10: goto L_0x04b3;
                case 11: goto L_0x04a0;
                case 12: goto L_0x048d;
                case 13: goto L_0x047a;
                case 14: goto L_0x0467;
                case 15: goto L_0x0454;
                case 16: goto L_0x0441;
                case 17: goto L_0x042a;
                case 18: goto L_0x0417;
                case 19: goto L_0x0404;
                case 20: goto L_0x03f1;
                case 21: goto L_0x03de;
                case 22: goto L_0x03cb;
                case 23: goto L_0x03b8;
                case 24: goto L_0x03a5;
                case 25: goto L_0x0392;
                case 26: goto L_0x037f;
                case 27: goto L_0x0368;
                case 28: goto L_0x0355;
                case 29: goto L_0x0342;
                case 30: goto L_0x032f;
                case 31: goto L_0x031c;
                case 32: goto L_0x0309;
                case 33: goto L_0x02f6;
                case 34: goto L_0x02e3;
                case 35: goto L_0x02d0;
                case 36: goto L_0x02bd;
                case 37: goto L_0x02aa;
                case 38: goto L_0x0297;
                case 39: goto L_0x0284;
                case 40: goto L_0x0271;
                case 41: goto L_0x025e;
                case 42: goto L_0x024b;
                case 43: goto L_0x0238;
                case 44: goto L_0x0225;
                case 45: goto L_0x0212;
                case 46: goto L_0x01ff;
                case 47: goto L_0x01ec;
                case 48: goto L_0x01d9;
                case 49: goto L_0x01c2;
                case 50: goto L_0x01b5;
                case 51: goto L_0x01a2;
                case 52: goto L_0x018f;
                case 53: goto L_0x017c;
                case 54: goto L_0x0169;
                case 55: goto L_0x0156;
                case 56: goto L_0x0143;
                case 57: goto L_0x0130;
                case 58: goto L_0x011d;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f3;
                case 61: goto L_0x00de;
                case 62: goto L_0x00cb;
                case 63: goto L_0x00b8;
                case 64: goto L_0x00a5;
                case 65: goto L_0x0092;
                case 66: goto L_0x007f;
                case 67: goto L_0x006c;
                case 68: goto L_0x0055;
                default: goto L_0x0053;
            }
        L_0x0053:
            goto L_0x0582
        L_0x0055:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeGroup(r7, r6, r8)
            goto L_0x0582
        L_0x006c:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeSInt64(r7, r8)
            goto L_0x0582
        L_0x007f:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeSInt32(r7, r6)
            goto L_0x0582
        L_0x0092:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeSFixed64(r7, r8)
            goto L_0x0582
        L_0x00a5:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeSFixed32(r7, r6)
            goto L_0x0582
        L_0x00b8:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeEnum(r7, r6)
            goto L_0x0582
        L_0x00cb:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeUInt32(r7, r6)
            goto L_0x0582
        L_0x00de:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            r14.writeBytes(r7, r6)
            goto L_0x0582
        L_0x00f3:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeMessage(r7, r6, r8)
            goto L_0x0582
        L_0x010a:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            r12.writeString(r7, r6, r14)
            goto L_0x0582
        L_0x011d:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            boolean r6 = oneofBooleanAt(r13, r8)
            r14.writeBool(r7, r6)
            goto L_0x0582
        L_0x0130:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeFixed32(r7, r6)
            goto L_0x0582
        L_0x0143:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeFixed64(r7, r8)
            goto L_0x0582
        L_0x0156:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = oneofIntAt(r13, r8)
            r14.writeInt32(r7, r6)
            goto L_0x0582
        L_0x0169:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeUInt64(r7, r8)
            goto L_0x0582
        L_0x017c:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = oneofLongAt(r13, r8)
            r14.writeInt64(r7, r8)
            goto L_0x0582
        L_0x018f:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            float r6 = oneofFloatAt(r13, r8)
            r14.writeFloat(r7, r6)
            goto L_0x0582
        L_0x01a2:
            boolean r8 = r12.isOneofPresent(r13, r7, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            double r8 = oneofDoubleAt(r13, r8)
            r14.writeDouble(r7, r8)
            goto L_0x0582
        L_0x01b5:
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            r12.writeMapHelper(r14, r7, r6, r5)
            goto L_0x0582
        L_0x01c2:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeGroupList(r7, r6, r14, r8)
            goto L_0x0582
        L_0x01d9:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ec:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x01ff:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0212:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0225:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0238:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x024b:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x025e:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0271:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0284:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x0297:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02aa:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02bd:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02d0:
            int r7 = r12.numberAt(r5)
            long r10 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r10)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r7, r6, r14, r9)
            goto L_0x0582
        L_0x02e3:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x02f6:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0309:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x031c:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x032f:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0342:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0355:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBytesList(r7, r6, r14)
            goto L_0x0582
        L_0x0368:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeMessageList(r7, r6, r14, r8)
            goto L_0x0582
        L_0x037f:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeStringList(r7, r6, r14)
            goto L_0x0582
        L_0x0392:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03a5:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03b8:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03cb:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03de:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x03f1:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0404:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x0417:
            int r7 = r12.numberAt(r5)
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            java.util.List r6 = (java.util.List) r6
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r7, r6, r14, r4)
            goto L_0x0582
        L_0x042a:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeGroup(r7, r6, r8)
            goto L_0x0582
        L_0x0441:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeSInt64(r7, r8)
            goto L_0x0582
        L_0x0454:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeSInt32(r7, r6)
            goto L_0x0582
        L_0x0467:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeSFixed64(r7, r8)
            goto L_0x0582
        L_0x047a:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeSFixed32(r7, r6)
            goto L_0x0582
        L_0x048d:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeEnum(r7, r6)
            goto L_0x0582
        L_0x04a0:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeUInt32(r7, r6)
            goto L_0x0582
        L_0x04b3:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            androidx.datastore.preferences.protobuf.ByteString r6 = (androidx.datastore.preferences.protobuf.ByteString) r6
            r14.writeBytes(r7, r6)
            goto L_0x0582
        L_0x04c8:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            androidx.datastore.preferences.protobuf.Schema r8 = r12.getMessageFieldSchema(r5)
            r14.writeMessage(r7, r6, r8)
            goto L_0x0582
        L_0x04df:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            java.lang.Object r6 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r13, (long) r8)
            r12.writeString(r7, r6, r14)
            goto L_0x0582
        L_0x04f2:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            boolean r6 = booleanAt(r13, r8)
            r14.writeBool(r7, r6)
            goto L_0x0582
        L_0x0505:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeFixed32(r7, r6)
            goto L_0x0582
        L_0x0517:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeFixed64(r7, r8)
            goto L_0x0582
        L_0x0529:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            int r6 = intAt(r13, r8)
            r14.writeInt32(r7, r6)
            goto L_0x0582
        L_0x053b:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeUInt64(r7, r8)
            goto L_0x0582
        L_0x054d:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            long r8 = longAt(r13, r8)
            r14.writeInt64(r7, r8)
            goto L_0x0582
        L_0x055f:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            float r6 = floatAt(r13, r8)
            r14.writeFloat(r7, r6)
            goto L_0x0582
        L_0x0571:
            boolean r8 = r12.isFieldPresent(r13, r5)
            if (r8 == 0) goto L_0x0582
            long r8 = offset(r6)
            double r8 = doubleAt(r13, r8)
            r14.writeDouble(r7, r8)
        L_0x0582:
            int r5 = r5 + 3
            goto L_0x0023
        L_0x0586:
            if (r2 == 0) goto L_0x059c
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r3 = r12.extensionSchema
            r3.serializeExtension(r14, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x059a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0586
        L_0x059a:
            r2 = r1
            goto L_0x0586
        L_0x059c:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r12.unknownFieldSchema
            r12.writeUnknownInMessageTo(r0, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInAscendingOrderProto3(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x058e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void writeFieldsInDescendingOrder(T r11, androidx.datastore.preferences.protobuf.Writer r12) throws java.io.IOException {
        /*
            r10 = this;
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r10.unknownFieldSchema
            r10.writeUnknownInMessageTo(r0, r11, r12)
            boolean r0 = r10.hasExtensions
            r1 = 0
            if (r0 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r10.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r0 = r0.getExtensions(r11)
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0021
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0023
        L_0x0021:
            r0 = r1
            r2 = r0
        L_0x0023:
            int[] r3 = r10.buffer
            int r3 = r3.length
            int r3 = r3 + -3
        L_0x0028:
            if (r3 < 0) goto L_0x058c
            int r4 = r10.typeAndOffsetAt(r3)
            int r5 = r10.numberAt(r3)
        L_0x0032:
            if (r2 == 0) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            int r6 = r6.extensionNumber(r2)
            if (r6 <= r5) goto L_0x0050
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r6 = r10.extensionSchema
            r6.serializeExtension(r12, r2)
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004e
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x0032
        L_0x004e:
            r2 = r1
            goto L_0x0032
        L_0x0050:
            int r6 = type(r4)
            r7 = 0
            r8 = 1
            switch(r6) {
                case 0: goto L_0x0577;
                case 1: goto L_0x0565;
                case 2: goto L_0x0553;
                case 3: goto L_0x0541;
                case 4: goto L_0x052f;
                case 5: goto L_0x051d;
                case 6: goto L_0x050b;
                case 7: goto L_0x04f8;
                case 8: goto L_0x04e5;
                case 9: goto L_0x04ce;
                case 10: goto L_0x04b9;
                case 11: goto L_0x04a6;
                case 12: goto L_0x0493;
                case 13: goto L_0x0480;
                case 14: goto L_0x046d;
                case 15: goto L_0x045a;
                case 16: goto L_0x0447;
                case 17: goto L_0x0430;
                case 18: goto L_0x041d;
                case 19: goto L_0x040a;
                case 20: goto L_0x03f7;
                case 21: goto L_0x03e4;
                case 22: goto L_0x03d1;
                case 23: goto L_0x03be;
                case 24: goto L_0x03ab;
                case 25: goto L_0x0398;
                case 26: goto L_0x0385;
                case 27: goto L_0x036e;
                case 28: goto L_0x035b;
                case 29: goto L_0x0348;
                case 30: goto L_0x0335;
                case 31: goto L_0x0322;
                case 32: goto L_0x030f;
                case 33: goto L_0x02fc;
                case 34: goto L_0x02e9;
                case 35: goto L_0x02d6;
                case 36: goto L_0x02c3;
                case 37: goto L_0x02b0;
                case 38: goto L_0x029d;
                case 39: goto L_0x028a;
                case 40: goto L_0x0277;
                case 41: goto L_0x0264;
                case 42: goto L_0x0251;
                case 43: goto L_0x023e;
                case 44: goto L_0x022b;
                case 45: goto L_0x0218;
                case 46: goto L_0x0205;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01df;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bb;
                case 51: goto L_0x01a8;
                case 52: goto L_0x0195;
                case 53: goto L_0x0182;
                case 54: goto L_0x016f;
                case 55: goto L_0x015c;
                case 56: goto L_0x0149;
                case 57: goto L_0x0136;
                case 58: goto L_0x0123;
                case 59: goto L_0x0110;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e4;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00be;
                case 64: goto L_0x00ab;
                case 65: goto L_0x0098;
                case 66: goto L_0x0085;
                case 67: goto L_0x0072;
                case 68: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            goto L_0x0588
        L_0x005b:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeGroup(r5, r4, r6)
            goto L_0x0588
        L_0x0072:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x0085:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x0098:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x00ab:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x00be:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x00d1:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x00e4:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x00f9:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x0110:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeString(r5, r4, r12)
            goto L_0x0588
        L_0x0123:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            boolean r4 = oneofBooleanAt(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x0136:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x0149:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x015c:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = oneofIntAt(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x016f:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0182:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = oneofLongAt(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0195:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            float r4 = oneofFloatAt(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x01a8:
            boolean r6 = r10.isOneofPresent(r11, r5, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            double r6 = oneofDoubleAt(r11, r6)
            r12.writeDouble(r5, r6)
            goto L_0x0588
        L_0x01bb:
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeMapHelper(r12, r5, r4, r3)
            goto L_0x0588
        L_0x01c8:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeGroupList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x01df:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x01f2:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0205:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0218:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x022b:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x023e:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0251:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0264:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x0277:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x028a:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x029d:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02b0:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02c3:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02d6:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r8)
            goto L_0x0588
        L_0x02e9:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x02fc:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x030f:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0322:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeSFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0335:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeEnumList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0348:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x035b:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBytesList(r5, r4, r12)
            goto L_0x0588
        L_0x036e:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            androidx.datastore.preferences.protobuf.SchemaUtil.writeMessageList(r5, r4, r12, r6)
            goto L_0x0588
        L_0x0385:
            int r5 = r10.numberAt(r3)
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeStringList(r5, r4, r12)
            goto L_0x0588
        L_0x0398:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeBoolList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03ab:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03be:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFixed64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03d1:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt32List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03e4:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeUInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x03f7:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeInt64List(r5, r4, r12, r7)
            goto L_0x0588
        L_0x040a:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeFloatList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x041d:
            int r5 = r10.numberAt(r3)
            long r8 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r8)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.SchemaUtil.writeDoubleList(r5, r4, r12, r7)
            goto L_0x0588
        L_0x0430:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeGroup(r5, r4, r6)
            goto L_0x0588
        L_0x0447:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeSInt64(r5, r6)
            goto L_0x0588
        L_0x045a:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeSInt32(r5, r4)
            goto L_0x0588
        L_0x046d:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeSFixed64(r5, r6)
            goto L_0x0588
        L_0x0480:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeSFixed32(r5, r4)
            goto L_0x0588
        L_0x0493:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeEnum(r5, r4)
            goto L_0x0588
        L_0x04a6:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeUInt32(r5, r4)
            goto L_0x0588
        L_0x04b9:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.ByteString r4 = (androidx.datastore.preferences.protobuf.ByteString) r4
            r12.writeBytes(r5, r4)
            goto L_0x0588
        L_0x04ce:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            androidx.datastore.preferences.protobuf.Schema r6 = r10.getMessageFieldSchema(r3)
            r12.writeMessage(r5, r4, r6)
            goto L_0x0588
        L_0x04e5:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            java.lang.Object r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r11, (long) r6)
            r10.writeString(r5, r4, r12)
            goto L_0x0588
        L_0x04f8:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            boolean r4 = booleanAt(r11, r6)
            r12.writeBool(r5, r4)
            goto L_0x0588
        L_0x050b:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeFixed32(r5, r4)
            goto L_0x0588
        L_0x051d:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeFixed64(r5, r6)
            goto L_0x0588
        L_0x052f:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            int r4 = intAt(r11, r6)
            r12.writeInt32(r5, r4)
            goto L_0x0588
        L_0x0541:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeUInt64(r5, r6)
            goto L_0x0588
        L_0x0553:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            long r6 = longAt(r11, r6)
            r12.writeInt64(r5, r6)
            goto L_0x0588
        L_0x0565:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            float r4 = floatAt(r11, r6)
            r12.writeFloat(r5, r4)
            goto L_0x0588
        L_0x0577:
            boolean r6 = r10.isFieldPresent(r11, r3)
            if (r6 == 0) goto L_0x0588
            long r6 = offset(r4)
            double r6 = doubleAt(r11, r6)
            r12.writeDouble(r5, r6)
        L_0x0588:
            int r3 = r3 + -3
            goto L_0x0028
        L_0x058c:
            if (r2 == 0) goto L_0x05a3
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r11 = r10.extensionSchema
            r11.serializeExtension(r12, r2)
            boolean r11 = r0.hasNext()
            if (r11 == 0) goto L_0x05a1
            java.lang.Object r11 = r0.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            r2 = r11
            goto L_0x058c
        L_0x05a1:
            r2 = r1
            goto L_0x058c
        L_0x05a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.writeFieldsInDescendingOrder(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private <K, V> void writeMapHelper(Writer writer, int i4, Object obj, int i5) throws IOException {
        if (obj != null) {
            writer.writeMap(i4, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i5)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i4, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writer.writeString(i4, (String) obj);
        } else {
            writer.writeBytes(i4, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema2, T t4, Writer writer) throws IOException {
        unknownFieldSchema2.writeTo(unknownFieldSchema2.getFromMessage(t4), writer);
    }

    public boolean equals(T t4, T t5) {
        int length = this.buffer.length;
        for (int i4 = 0; i4 < length; i4 += 3) {
            if (!equals(t4, t5, i4)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t4).equals(this.unknownFieldSchema.getFromMessage(t5))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t4).equals(this.extensionSchema.getExtensions(t5));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    public int getSerializedSize(T t4) {
        if (this.proto3) {
            return getSerializedSizeProto3(t4);
        }
        return getSerializedSizeProto2(t4);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x016b, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0229, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.buffer
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022d
            int r3 = r8.typeAndOffsetAt(r1)
            int r4 = r8.numberAt(r1)
            long r5 = offset(r3)
            int r3 = type(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020d;
                case 2: goto L_0x0201;
                case 3: goto L_0x01f5;
                case 4: goto L_0x01ed;
                case 5: goto L_0x01e1;
                case 6: goto L_0x01d9;
                case 7: goto L_0x01cd;
                case 8: goto L_0x01bf;
                case 9: goto L_0x01b4;
                case 10: goto L_0x01a8;
                case 11: goto L_0x01a0;
                case 12: goto L_0x0198;
                case 13: goto L_0x0190;
                case 14: goto L_0x0184;
                case 15: goto L_0x017c;
                case 16: goto L_0x0170;
                case 17: goto L_0x0161;
                case 18: goto L_0x0155;
                case 19: goto L_0x0155;
                case 20: goto L_0x0155;
                case 21: goto L_0x0155;
                case 22: goto L_0x0155;
                case 23: goto L_0x0155;
                case 24: goto L_0x0155;
                case 25: goto L_0x0155;
                case 26: goto L_0x0155;
                case 27: goto L_0x0155;
                case 28: goto L_0x0155;
                case 29: goto L_0x0155;
                case 30: goto L_0x0155;
                case 31: goto L_0x0155;
                case 32: goto L_0x0155;
                case 33: goto L_0x0155;
                case 34: goto L_0x0155;
                case 35: goto L_0x0155;
                case 36: goto L_0x0155;
                case 37: goto L_0x0155;
                case 38: goto L_0x0155;
                case 39: goto L_0x0155;
                case 40: goto L_0x0155;
                case 41: goto L_0x0155;
                case 42: goto L_0x0155;
                case 43: goto L_0x0155;
                case 44: goto L_0x0155;
                case 45: goto L_0x0155;
                case 46: goto L_0x0155;
                case 47: goto L_0x0155;
                case 48: goto L_0x0155;
                case 49: goto L_0x0155;
                case 50: goto L_0x0149;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x010f;
                case 54: goto L_0x00fd;
                case 55: goto L_0x00ef;
                case 56: goto L_0x00dd;
                case 57: goto L_0x00cf;
                case 58: goto L_0x00bd;
                case 59: goto L_0x00a9;
                case 60: goto L_0x0098;
                case 61: goto L_0x0087;
                case 62: goto L_0x007a;
                case 63: goto L_0x006d;
                case 64: goto L_0x0060;
                case 65: goto L_0x004f;
                case 66: goto L_0x0042;
                case 67: goto L_0x0031;
                case 68: goto L_0x001e;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0229
        L_0x001e:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
        L_0x002e:
            int r2 = r2 + r3
            goto L_0x0229
        L_0x0031:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0042:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x004f:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0060:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x006d:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x007a:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x0087:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x0098:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x00a9:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x00bd:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            boolean r3 = oneofBooleanAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashBoolean(r3)
            goto L_0x002e
        L_0x00cf:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x00dd:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x00ef:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            int r3 = oneofIntAt(r9, r5)
            goto L_0x002e
        L_0x00fd:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x010f:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            long r3 = oneofLongAt(r9, r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0121:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            float r3 = oneofFloatAt(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002e
        L_0x0133:
            boolean r3 = r8.isOneofPresent(r9, r4, r1)
            if (r3 == 0) goto L_0x0229
            int r2 = r2 * 53
            double r3 = oneofDoubleAt(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0149:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x0155:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x0161:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            if (r3 == 0) goto L_0x016b
            int r7 = r3.hashCode()
        L_0x016b:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0229
        L_0x0170:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x017c:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x0184:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0190:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x0198:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x01a0:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x01a8:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x01b4:
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            if (r3 == 0) goto L_0x016b
            int r7 = r3.hashCode()
            goto L_0x016b
        L_0x01bf:
            int r2 = r2 * 53
            java.lang.Object r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getObject((java.lang.Object) r9, (long) r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x002e
        L_0x01cd:
            int r2 = r2 * 53
            boolean r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getBoolean((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashBoolean(r3)
            goto L_0x002e
        L_0x01d9:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x01e1:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x01ed:
            int r2 = r2 * 53
            int r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getInt((java.lang.Object) r9, (long) r5)
            goto L_0x002e
        L_0x01f5:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0201:
            int r2 = r2 * 53
            long r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getLong((java.lang.Object) r9, (long) r5)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x020d:
            int r2 = r2 * 53
            float r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getFloat((java.lang.Object) r9, (long) r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x002e
        L_0x0219:
            int r2 = r2 * 53
            double r3 = androidx.datastore.preferences.protobuf.UnsafeUtil.getDouble((java.lang.Object) r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = androidx.datastore.preferences.protobuf.Internal.hashLong(r3)
            goto L_0x002e
        L_0x0229:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022d:
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r0 = r8.unknownFieldSchema
            java.lang.Object r0 = r0.getFromMessage(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.hasExtensions
            if (r0 == 0) goto L_0x024b
            int r2 = r2 * 53
            androidx.datastore.preferences.protobuf.ExtensionSchema<?> r0 = r8.extensionSchema
            androidx.datastore.preferences.protobuf.FieldSet r9 = r0.getExtensions(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.hashCode(java.lang.Object):int");
    }

    public final boolean isInitialized(T t4) {
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 1048575;
        int i8 = 0;
        while (i6 < this.checkInitializedCount) {
            int i9 = this.intArray[i6];
            int numberAt = numberAt(i9);
            int typeAndOffsetAt = typeAndOffsetAt(i9);
            int i10 = this.buffer[i9 + 2];
            int i11 = i10 & 1048575;
            int i12 = 1 << (i10 >>> 20);
            if (i11 != i7) {
                if (i11 != 1048575) {
                    i8 = UNSAFE.getInt(t4, (long) i11);
                }
                i4 = i8;
                i5 = i11;
            } else {
                i5 = i7;
                i4 = i8;
            }
            T t5 = t4;
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t5, i9, i5, i4, i12)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t5, numberAt, i9) && !isInitialized(t5, typeAndOffsetAt, getMessageFieldSchema(i9))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t5, typeAndOffsetAt, i9)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t5, typeAndOffsetAt, i9)) {
                    return false;
                }
            } else if (isFieldPresent(t5, i9, i5, i4, i12) && !isInitialized(t5, typeAndOffsetAt, getMessageFieldSchema(i9))) {
                return false;
            }
            i6++;
            t4 = t5;
            i7 = i5;
            i8 = i4;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t4).isInitialized();
    }

    public void makeImmutable(T t4) {
        if (isMutable(t4)) {
            if (t4 instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t4;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i4 = 0; i4 < length; i4 += 3) {
                int typeAndOffsetAt = typeAndOffsetAt(i4);
                long offset = offset(typeAndOffsetAt);
                int type = type(typeAndOffsetAt);
                if (type != 9) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t4, numberAt(i4), i4)) {
                            getMessageFieldSchema(i4).makeImmutable(UNSAFE.getObject(t4, offset));
                        }
                    } else {
                        switch (type) {
                            case 17:
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.listFieldSchema.makeImmutableListAt(t4, offset);
                                continue;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(t4, offset);
                                if (object != null) {
                                    unsafe.putObject(t4, offset, this.mapFieldSchema.toImmutable(object));
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (isFieldPresent(t4, i4)) {
                    getMessageFieldSchema(i4).makeImmutable(UNSAFE.getObject(t4, offset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t4);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t4);
            }
        }
    }

    public void mergeFrom(T t4, T t5) {
        checkMutable(t4);
        t5.getClass();
        for (int i4 = 0; i4 < this.buffer.length; i4 += 3) {
            mergeSingleField(t4, t5, i4);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t4, t5);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t4, t5);
        }
    }

    public T newInstance() {
        return this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: androidx.datastore.preferences.protobuf.UnknownFieldSetLite} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v59, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v60, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v61, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02a8, code lost:
        r8 = r0;
        r19 = r3;
        r5 = r9;
        r17 = r10;
        r18 = r12;
        r0 = r13;
        r12 = r14;
        r2 = r15;
        r15 = 1048575;
        r9 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x009a, code lost:
        r3 = r9;
        r15 = r19;
        r9 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c9, code lost:
        r6 = r14;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f2, code lost:
        r2 = r8;
        r1 = r9;
        r8 = r10;
        r7 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f6, code lost:
        r6 = r14;
        r9 = r15;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00fc, code lost:
        r11 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0117, code lost:
        r12 = r12 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0119, code lost:
        r4 = r29;
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011d, code lost:
        r1 = r9;
        r9 = r11;
        r3 = r15;
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x018e, code lost:
        r7 = r5;
        r1 = r9;
        r8 = r10;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x019a, code lost:
        r1 = r9;
        r3 = r15;
        r9 = r5;
        r15 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01bf, code lost:
        r12 = r12 | r20;
        r4 = r29;
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0224, code lost:
        r7 = r9;
        r8 = r10;
        r6 = r14;
        r5 = r21;
        r9 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x022a, code lost:
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0231, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0287, code lost:
        r12 = r12 | r20;
        r4 = r29;
        r7 = r9;
        r8 = r10;
        r6 = r14;
        r5 = r21;
        r9 = r3;
        r3 = r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0400  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0415  */
    @androidx.datastore.preferences.protobuf.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int parseProto2Message(T r26, byte[] r27, int r28, int r29, int r30, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r31) throws java.io.IOException {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r4 = r29
            r7 = r31
            checkMutable(r1)
            sun.misc.Unsafe r9 = UNSAFE
            r16 = 0
            r11 = -1
            r3 = r28
            r5 = -1
            r6 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
            r13 = 0
        L_0x001b:
            if (r3 >= r4) goto L_0x042f
            int r13 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0029
            int r13 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r3, r2, r13, r7)
            int r3 = r7.int1
        L_0x0029:
            r24 = r13
            r13 = r3
            r3 = r24
            int r14 = r13 >>> 3
            r7 = r13 & 7
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r10 = 3
            if (r14 <= r5) goto L_0x003e
            int r6 = r6 / r10
            int r5 = r0.positionForFieldNumber(r14, r6)
            goto L_0x0042
        L_0x003e:
            int r5 = r0.positionForFieldNumber(r14)
        L_0x0042:
            if (r5 != r11) goto L_0x005b
            r5 = r31
            r2 = r3
            r17 = r8
            r19 = r9
            r18 = r12
            r21 = r14
            r12 = 0
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r9 = r30
            r8 = r0
        L_0x0058:
            r0 = r13
            goto L_0x03e5
        L_0x005b:
            int[] r6 = r0.buffer
            int r18 = r5 + 1
            r6 = r6[r18]
            r18 = -1
            int r11 = type(r6)
            r19 = r3
            long r3 = offset(r6)
            r10 = 17
            if (r11 > r10) goto L_0x02bc
            int[] r10 = r0.buffer
            int r20 = r5 + 2
            r10 = r10[r20]
            int r20 = r10 >>> 20
            r2 = 1
            int r20 = r2 << r20
            r10 = r10 & r17
            r21 = r14
            if (r10 == r8) goto L_0x0092
            r14 = 1048575(0xfffff, float:1.469367E-39)
            if (r8 == r14) goto L_0x008b
            long r14 = (long) r8
            r9.putInt(r1, r14, r12)
        L_0x008b:
            long r14 = (long) r10
            int r8 = r9.getInt(r1, r14)
            r12 = r8
            goto L_0x0093
        L_0x0092:
            r10 = r8
        L_0x0093:
            r8 = 5
            switch(r11) {
                case 0: goto L_0x0293;
                case 1: goto L_0x0273;
                case 2: goto L_0x024d;
                case 3: goto L_0x024d;
                case 4: goto L_0x0234;
                case 5: goto L_0x0201;
                case 6: goto L_0x01e2;
                case 7: goto L_0x01c5;
                case 8: goto L_0x01a0;
                case 9: goto L_0x0167;
                case 10: goto L_0x0151;
                case 11: goto L_0x0234;
                case 12: goto L_0x0122;
                case 13: goto L_0x01e2;
                case 14: goto L_0x0201;
                case 15: goto L_0x00ff;
                case 16: goto L_0x00d3;
                case 17: goto L_0x00a1;
                default: goto L_0x0097;
            }
        L_0x0097:
            r11 = r27
            r14 = r5
        L_0x009a:
            r3 = r9
            r15 = r19
            r9 = r31
            goto L_0x02a8
        L_0x00a1:
            r2 = 3
            if (r7 != r2) goto L_0x00cf
            java.lang.Object r2 = r0.mutableMessageFieldForMerge(r1, r5)
            int r3 = r21 << 3
            r7 = r3 | 4
            androidx.datastore.preferences.protobuf.Schema r3 = r0.getMessageFieldSchema(r5)
            r4 = r27
            r6 = r29
            r8 = r31
            r14 = r5
            r5 = r19
            int r3 = androidx.datastore.preferences.protobuf.ArrayDecoders.mergeGroupField(r2, r3, r4, r5, r6, r7, r8)
            r11 = r8
            r8 = r4
            r0.storeMessageField(r1, r14, r2)
            r12 = r12 | r20
            r4 = r29
            r2 = r8
            r8 = r10
            r7 = r11
        L_0x00c9:
            r6 = r14
        L_0x00ca:
            r5 = r21
        L_0x00cc:
            r11 = -1
            goto L_0x001b
        L_0x00cf:
            r14 = r5
            r11 = r27
            goto L_0x009a
        L_0x00d3:
            r8 = r27
            r11 = r31
            r14 = r5
            r5 = r19
            if (r7 != 0) goto L_0x00f9
            int r7 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r8, r5, r11)
            long r5 = r11.long1
            long r5 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag64(r5)
            r2 = r1
            r1 = r9
            r1.putLong(r2, r3, r5)
            r15 = r1
            r9 = r2
            r12 = r12 | r20
            r4 = r29
            r3 = r7
        L_0x00f2:
            r2 = r8
            r1 = r9
            r8 = r10
            r7 = r11
        L_0x00f6:
            r6 = r14
            r9 = r15
            goto L_0x00ca
        L_0x00f9:
            r15 = r5
            r3 = r9
            r9 = r11
        L_0x00fc:
            r11 = r8
            goto L_0x02a8
        L_0x00ff:
            r8 = r27
            r11 = r31
            r14 = r5
            r15 = r9
            r5 = r19
            r9 = r1
            if (r7 != 0) goto L_0x011d
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r8, r5, r11)
            int r2 = r11.int1
            int r2 = androidx.datastore.preferences.protobuf.CodedInputStream.decodeZigZag32(r2)
            r15.putInt(r9, r3, r2)
        L_0x0117:
            r12 = r12 | r20
        L_0x0119:
            r4 = r29
            r3 = r1
            goto L_0x00f2
        L_0x011d:
            r1 = r9
            r9 = r11
            r3 = r15
            r15 = r5
            goto L_0x00fc
        L_0x0122:
            r8 = r27
            r11 = r31
            r14 = r5
            r15 = r9
            r5 = r19
            r9 = r1
            if (r7 != 0) goto L_0x011d
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r8, r5, r11)
            int r2 = r11.int1
            androidx.datastore.preferences.protobuf.Internal$EnumVerifier r5 = r0.getEnumFieldVerifier(r14)
            if (r5 == 0) goto L_0x014d
            boolean r5 = r5.isInRange(r2)
            if (r5 == 0) goto L_0x0140
            goto L_0x014d
        L_0x0140:
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r3 = getMutableUnknownFields(r9)
            long r4 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r4)
            r3.storeField(r13, r2)
            goto L_0x0119
        L_0x014d:
            r15.putInt(r9, r3, r2)
            goto L_0x0117
        L_0x0151:
            r8 = r27
            r11 = r31
            r14 = r5
            r15 = r9
            r5 = r19
            r9 = r1
            r1 = 2
            if (r7 != r1) goto L_0x011d
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeBytes(r8, r5, r11)
            java.lang.Object r2 = r11.object1
            r15.putObject(r9, r3, r2)
            goto L_0x0117
        L_0x0167:
            r8 = r27
            r11 = r31
            r14 = r5
            r15 = r9
            r5 = r19
            r9 = r1
            r1 = 2
            if (r7 != r1) goto L_0x0194
            java.lang.Object r1 = r0.mutableMessageFieldForMerge(r9, r14)
            androidx.datastore.preferences.protobuf.Schema r2 = r0.getMessageFieldSchema(r14)
            r4 = r5
            r3 = r8
            r6 = r11
            r5 = r29
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.mergeMessageField(r1, r2, r3, r4, r5, r6)
            r11 = r3
            r5 = r6
            r0.storeMessageField(r9, r14, r1)
            r12 = r12 | r20
            r4 = r29
            r3 = r2
        L_0x018e:
            r7 = r5
            r1 = r9
            r8 = r10
            r2 = r11
            goto L_0x00f6
        L_0x0194:
            r24 = r8
            r8 = r5
            r5 = r11
            r11 = r24
        L_0x019a:
            r1 = r9
            r3 = r15
            r9 = r5
            r15 = r8
            goto L_0x02a8
        L_0x01a0:
            r11 = r27
            r14 = r5
            r15 = r9
            r8 = r19
            r5 = r31
            r9 = r1
            r1 = 2
            if (r7 != r1) goto L_0x019a
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            r1 = r1 & r6
            if (r1 != 0) goto L_0x01b6
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeString(r11, r8, r5)
            goto L_0x01ba
        L_0x01b6:
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeStringRequireUtf8(r11, r8, r5)
        L_0x01ba:
            java.lang.Object r2 = r5.object1
            r15.putObject(r9, r3, r2)
        L_0x01bf:
            r12 = r12 | r20
            r4 = r29
            r3 = r1
            goto L_0x018e
        L_0x01c5:
            r11 = r27
            r14 = r5
            r15 = r9
            r8 = r19
            r5 = r31
            r9 = r1
            if (r7 != 0) goto L_0x019a
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r11, r8, r5)
            long r6 = r5.long1
            r22 = 0
            int r8 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1))
            if (r8 == 0) goto L_0x01dd
            goto L_0x01de
        L_0x01dd:
            r2 = 0
        L_0x01de:
            androidx.datastore.preferences.protobuf.UnsafeUtil.putBoolean((java.lang.Object) r9, (long) r3, (boolean) r2)
            goto L_0x01bf
        L_0x01e2:
            r11 = r27
            r14 = r5
            r15 = r9
            r5 = r31
            r9 = r1
            r1 = r19
            if (r7 != r8) goto L_0x01fb
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFixed32(r11, r1)
            r15.putInt(r9, r3, r2)
            int r3 = r1 + 4
            r12 = r12 | r20
            r4 = r29
            goto L_0x018e
        L_0x01fb:
            r3 = r15
            r15 = r1
            r1 = r9
            r9 = r5
            goto L_0x02a8
        L_0x0201:
            r11 = r27
            r14 = r5
            r15 = r9
            r5 = r31
            r9 = r1
            r1 = r19
            if (r7 != r2) goto L_0x022d
            long r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFixed64(r11, r1)
            r2 = r15
            r15 = r1
            r1 = r2
            r2 = r9
            r9 = r31
            r1.putLong(r2, r3, r5)
            r24 = r2
            r2 = r1
            r1 = r24
            int r3 = r15 + 8
            r12 = r12 | r20
            r4 = r29
        L_0x0224:
            r7 = r9
            r8 = r10
            r6 = r14
            r5 = r21
            r9 = r2
        L_0x022a:
            r2 = r11
            goto L_0x00cc
        L_0x022d:
            r2 = r15
            r15 = r1
            r1 = r9
            r9 = r5
        L_0x0231:
            r3 = r2
            goto L_0x02a8
        L_0x0234:
            r11 = r27
            r14 = r5
            r2 = r9
            r15 = r19
            r9 = r31
            if (r7 != 0) goto L_0x0231
            int r5 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint32(r11, r15, r9)
            int r6 = r9.int1
            r2.putInt(r1, r3, r6)
            r12 = r12 | r20
            r4 = r29
            r3 = r5
            goto L_0x0224
        L_0x024d:
            r11 = r27
            r14 = r5
            r2 = r9
            r15 = r19
            r9 = r31
            if (r7 != 0) goto L_0x0231
            int r7 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeVarint64(r11, r15, r9)
            long r5 = r9.long1
            r24 = r2
            r2 = r1
            r1 = r24
            r1.putLong(r2, r3, r5)
            r3 = r1
            r1 = r2
            r12 = r12 | r20
            r2 = r9
            r9 = r3
            r3 = r7
            r7 = r2
            r4 = r29
            r8 = r10
            r2 = r11
            goto L_0x00c9
        L_0x0273:
            r11 = r27
            r14 = r5
            r15 = r19
            r4 = r3
            r3 = r9
            r9 = r31
            if (r7 != r8) goto L_0x02a8
            float r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeFloat(r11, r15)
            androidx.datastore.preferences.protobuf.UnsafeUtil.putFloat((java.lang.Object) r1, (long) r4, (float) r2)
            int r2 = r15 + 4
        L_0x0287:
            r12 = r12 | r20
            r4 = r29
            r7 = r9
            r8 = r10
            r6 = r14
            r5 = r21
            r9 = r3
            r3 = r2
            goto L_0x022a
        L_0x0293:
            r11 = r27
            r14 = r5
            r15 = r19
            r4 = r3
            r3 = r9
            r9 = r31
            if (r7 != r2) goto L_0x02a8
            double r6 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeDouble(r11, r15)
            androidx.datastore.preferences.protobuf.UnsafeUtil.putDouble((java.lang.Object) r1, (long) r4, (double) r6)
            int r2 = r15 + 8
            goto L_0x0287
        L_0x02a8:
            r8 = r0
            r19 = r3
            r5 = r9
            r17 = r10
            r18 = r12
            r0 = r13
            r12 = r14
            r2 = r15
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r9 = r30
            goto L_0x03e5
        L_0x02bc:
            r21 = r14
            r15 = r19
            r14 = r5
            r4 = r3
            r3 = r9
            r9 = r31
            r2 = 27
            if (r11 != r2) goto L_0x031e
            r2 = 2
            if (r7 != r2) goto L_0x030b
            java.lang.Object r2 = r3.getObject(r1, r4)
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r2 = (androidx.datastore.preferences.protobuf.Internal.ProtobufList) r2
            boolean r6 = r2.isModifiable()
            if (r6 != 0) goto L_0x02ea
            int r6 = r2.size()
            if (r6 != 0) goto L_0x02e1
            r6 = 10
            goto L_0x02e3
        L_0x02e1:
            int r6 = r6 * 2
        L_0x02e3:
            androidx.datastore.preferences.protobuf.Internal$ProtobufList r2 = r2.mutableCopyWithCapacity(r6)
            r3.putObject(r1, r4, r2)
        L_0x02ea:
            r6 = r2
            androidx.datastore.preferences.protobuf.Schema r1 = r0.getMessageFieldSchema(r14)
            r5 = r29
            r7 = r9
            r2 = r13
            r4 = r15
            r15 = r3
            r3 = r27
            int r1 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeMessageList(r1, r2, r3, r4, r5, r6, r7)
            r4 = r29
            r7 = r31
            r3 = r1
            r6 = r14
            r9 = r15
            r5 = r21
            r11 = -1
            r1 = r26
            r2 = r27
            goto L_0x001b
        L_0x030b:
            r24 = r15
            r15 = r3
            r3 = r24
            r17 = r8
            r18 = r12
            r12 = r14
            r19 = r15
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            goto L_0x03ac
        L_0x031e:
            r2 = r15
            r15 = r3
            r3 = r2
            r2 = r13
            r1 = 49
            if (r11 > r1) goto L_0x0367
            long r9 = (long) r6
            r1 = r26
            r17 = r8
            r18 = r12
            r8 = r14
            r19 = r15
            r6 = r21
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r14 = r31
            r12 = r4
            r4 = r29
            r5 = r2
            r2 = r27
            int r7 = r0.parseRepeatedField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r13 = r5
            r12 = r8
            if (r7 == r3) goto L_0x035e
            r0 = r25
            r1 = r26
            r2 = r27
            r4 = r29
            r3 = r7
        L_0x0350:
            r6 = r12
            r8 = r17
            r12 = r18
            r9 = r19
            r5 = r21
            r11 = -1
            r7 = r31
            goto L_0x001b
        L_0x035e:
            r8 = r25
            r9 = r30
            r5 = r31
            r2 = r7
            goto L_0x0058
        L_0x0367:
            r13 = r2
            r17 = r8
            r9 = r11
            r18 = r12
            r12 = r14
            r19 = r15
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r10 = r4
            r0 = 50
            if (r9 != r0) goto L_0x03b5
            r1 = 2
            if (r7 != r1) goto L_0x03ac
            r0 = r25
            r1 = r26
            r2 = r27
            r4 = r29
            r8 = r31
            r6 = r10
            r5 = r12
            int r6 = r0.parseMapField(r1, r2, r3, r4, r5, r6, r8)
            if (r6 == r3) goto L_0x03a3
            r0 = r25
            r1 = r26
            r2 = r27
            r4 = r29
            r7 = r31
            r3 = r6
            r6 = r12
            r8 = r17
            r12 = r18
            r9 = r19
            goto L_0x00ca
        L_0x03a3:
            r8 = r25
            r9 = r30
            r5 = r31
            r2 = r6
            goto L_0x0058
        L_0x03ac:
            r8 = r25
            r9 = r30
            r5 = r31
            r2 = r3
            goto L_0x0058
        L_0x03b5:
            r0 = r25
            r1 = r26
            r2 = r27
            r4 = r29
            r8 = r6
            r5 = r13
            r6 = r21
            r13 = r31
            int r7 = r0.parseOneofField(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            r8 = r0
            r0 = r5
            r5 = r13
            if (r7 == r3) goto L_0x03e2
            r1 = r26
            r2 = r27
            r4 = r29
            r13 = r0
            r3 = r7
            r0 = r8
            r6 = r12
            r8 = r17
            r12 = r18
            r9 = r19
            r11 = -1
            r7 = r5
            r5 = r21
            goto L_0x001b
        L_0x03e2:
            r9 = r30
            r2 = r7
        L_0x03e5:
            if (r0 != r9) goto L_0x03f4
            if (r9 == 0) goto L_0x03f4
            r6 = r26
            r7 = r29
            r13 = r0
            r10 = r2
            r0 = r17
            r12 = r18
            goto L_0x0440
        L_0x03f4:
            boolean r1 = r8.hasExtensions
            if (r1 == 0) goto L_0x0415
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r1 = r5.extensionRegistry
            androidx.datastore.preferences.protobuf.ExtensionRegistryLite r3 = androidx.datastore.preferences.protobuf.ExtensionRegistryLite.getEmptyRegistry()
            if (r1 == r3) goto L_0x0415
            androidx.datastore.preferences.protobuf.MessageLite r5 = r8.defaultInstance
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r6 = r8.unknownFieldSchema
            r4 = r26
            r1 = r27
            r3 = r29
            r7 = r31
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeExtensionOrUnknownField(r0, r1, r2, r3, r4, r5, r6, r7)
            r6 = r4
            r7 = r29
        L_0x0413:
            r3 = r2
            goto L_0x0427
        L_0x0415:
            r6 = r26
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r4 = getMutableUnknownFields(r6)
            r1 = r27
            r3 = r29
            r5 = r31
            int r2 = androidx.datastore.preferences.protobuf.ArrayDecoders.decodeUnknownField(r0, r1, r2, r3, r4, r5)
            r7 = r3
            goto L_0x0413
        L_0x0427:
            r2 = r27
            r13 = r0
            r1 = r6
            r4 = r7
            r0 = r8
            goto L_0x0350
        L_0x042f:
            r6 = r1
            r7 = r4
            r17 = r8
            r19 = r9
            r18 = r12
            r15 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r30
            r8 = r0
            r10 = r3
            r0 = r17
        L_0x0440:
            if (r0 == r15) goto L_0x0448
            long r0 = (long) r0
            r15 = r19
            r15.putInt(r6, r0, r12)
        L_0x0448:
            int r0 = r8.checkInitializedCount
            r1 = 0
            r11 = r0
            r3 = r1
        L_0x044d:
            int r0 = r8.repeatedFieldOffsetStart
            if (r11 >= r0) goto L_0x0465
            int[] r0 = r8.intArray
            r2 = r0[r11]
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r4 = r8.unknownFieldSchema
            r5 = r26
            r1 = r6
            r0 = r8
            java.lang.Object r2 = r0.filterMapUnknownEnumValues(r1, r2, r3, r4, r5)
            r3 = r2
            androidx.datastore.preferences.protobuf.UnknownFieldSetLite r3 = (androidx.datastore.preferences.protobuf.UnknownFieldSetLite) r3
            int r11 = r11 + 1
            goto L_0x044d
        L_0x0465:
            r1 = r6
            r0 = r8
            if (r3 == 0) goto L_0x046e
            androidx.datastore.preferences.protobuf.UnknownFieldSchema<?, ?> r2 = r0.unknownFieldSchema
            r2.setBuilderToMessage(r1, r3)
        L_0x046e:
            if (r9 != 0) goto L_0x0478
            if (r10 != r7) goto L_0x0473
            goto L_0x047c
        L_0x0473:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r1 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r1
        L_0x0478:
            if (r10 > r7) goto L_0x047d
            if (r13 != r9) goto L_0x047d
        L_0x047c:
            return r10
        L_0x047d:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r1 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.parseFailure()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.parseProto2Message(java.lang.Object, byte[], int, int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    public void writeTo(T t4, Writer writer) throws IOException {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t4, writer);
        } else if (this.proto3) {
            writeFieldsInAscendingOrderProto3(t4, writer);
        } else {
            writeFieldsInAscendingOrderProto2(t4, writer);
        }
    }

    private boolean isFieldPresent(T t4, int i4) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i4);
        long j4 = (long) (1048575 & presenceMaskAndOffsetAt);
        if (j4 == 1048575) {
            int typeAndOffsetAt = typeAndOffsetAt(i4);
            long offset = offset(typeAndOffsetAt);
            switch (type(typeAndOffsetAt)) {
                case 0:
                    return Double.doubleToRawLongBits(UnsafeUtil.getDouble((Object) t4, offset)) != 0;
                case 1:
                    return Float.floatToRawIntBits(UnsafeUtil.getFloat((Object) t4, offset)) != 0;
                case 2:
                    return UnsafeUtil.getLong((Object) t4, offset) != 0;
                case 3:
                    return UnsafeUtil.getLong((Object) t4, offset) != 0;
                case 4:
                    return UnsafeUtil.getInt((Object) t4, offset) != 0;
                case 5:
                    return UnsafeUtil.getLong((Object) t4, offset) != 0;
                case 6:
                    return UnsafeUtil.getInt((Object) t4, offset) != 0;
                case 7:
                    return UnsafeUtil.getBoolean((Object) t4, offset);
                case 8:
                    Object object = UnsafeUtil.getObject((Object) t4, offset);
                    if (object instanceof String) {
                        return !((String) object).isEmpty();
                    }
                    if (object instanceof ByteString) {
                        return !ByteString.EMPTY.equals(object);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return UnsafeUtil.getObject((Object) t4, offset) != null;
                case 10:
                    return !ByteString.EMPTY.equals(UnsafeUtil.getObject((Object) t4, offset));
                case 11:
                    return UnsafeUtil.getInt((Object) t4, offset) != 0;
                case 12:
                    return UnsafeUtil.getInt((Object) t4, offset) != 0;
                case 13:
                    return UnsafeUtil.getInt((Object) t4, offset) != 0;
                case 14:
                    return UnsafeUtil.getLong((Object) t4, offset) != 0;
                case 15:
                    return UnsafeUtil.getInt((Object) t4, offset) != 0;
                case 16:
                    return UnsafeUtil.getLong((Object) t4, offset) != 0;
                case 17:
                    return UnsafeUtil.getObject((Object) t4, offset) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (UnsafeUtil.getInt((Object) t4, j4) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
        }
    }

    private int positionForFieldNumber(int i4, int i5) {
        if (i4 < this.minFieldNumber || i4 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i4, i5);
    }

    public void mergeFrom(T t4, Reader reader, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        extensionRegistryLite.getClass();
        checkMutable(t4);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t4, reader, extensionRegistryLite);
    }

    private boolean equals(T t4, T t5, int i4) {
        int typeAndOffsetAt = typeAndOffsetAt(i4);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t4, t5, i4) && Double.doubleToLongBits(UnsafeUtil.getDouble((Object) t4, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble((Object) t5, offset));
            case 1:
                return arePresentForEquals(t4, t5, i4) && Float.floatToIntBits(UnsafeUtil.getFloat((Object) t4, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat((Object) t5, offset));
            case 2:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getLong((Object) t4, offset) == UnsafeUtil.getLong((Object) t5, offset);
            case 3:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getLong((Object) t4, offset) == UnsafeUtil.getLong((Object) t5, offset);
            case 4:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getInt((Object) t4, offset) == UnsafeUtil.getInt((Object) t5, offset);
            case 5:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getLong((Object) t4, offset) == UnsafeUtil.getLong((Object) t5, offset);
            case 6:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getInt((Object) t4, offset) == UnsafeUtil.getInt((Object) t5, offset);
            case 7:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getBoolean((Object) t4, offset) == UnsafeUtil.getBoolean((Object) t5, offset);
            case 8:
                return arePresentForEquals(t4, t5, i4) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t4, offset), UnsafeUtil.getObject((Object) t5, offset));
            case 9:
                return arePresentForEquals(t4, t5, i4) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t4, offset), UnsafeUtil.getObject((Object) t5, offset));
            case 10:
                return arePresentForEquals(t4, t5, i4) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t4, offset), UnsafeUtil.getObject((Object) t5, offset));
            case 11:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getInt((Object) t4, offset) == UnsafeUtil.getInt((Object) t5, offset);
            case 12:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getInt((Object) t4, offset) == UnsafeUtil.getInt((Object) t5, offset);
            case 13:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getInt((Object) t4, offset) == UnsafeUtil.getInt((Object) t5, offset);
            case 14:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getLong((Object) t4, offset) == UnsafeUtil.getLong((Object) t5, offset);
            case 15:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getInt((Object) t4, offset) == UnsafeUtil.getInt((Object) t5, offset);
            case 16:
                return arePresentForEquals(t4, t5, i4) && UnsafeUtil.getLong((Object) t4, offset) == UnsafeUtil.getLong((Object) t5, offset);
            case 17:
                return arePresentForEquals(t4, t5, i4) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t4, offset), UnsafeUtil.getObject((Object) t5, offset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t4, offset), UnsafeUtil.getObject((Object) t5, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t4, offset), UnsafeUtil.getObject((Object) t5, offset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return isOneofCaseEqual(t4, t5, i4) && SchemaUtil.safeEquals(UnsafeUtil.getObject((Object) t4, offset), UnsafeUtil.getObject((Object) t5, offset));
            default:
                return true;
        }
    }

    public void mergeFrom(T t4, byte[] bArr, int i4, int i5, ArrayDecoders.Registers registers) throws IOException {
        if (this.proto3) {
            parseProto3Message(t4, bArr, i4, i5, registers);
        } else {
            parseProto2Message(t4, bArr, i4, i5, 0, registers);
        }
    }

    private static boolean isInitialized(Object obj, int i4, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i4)));
    }
}
