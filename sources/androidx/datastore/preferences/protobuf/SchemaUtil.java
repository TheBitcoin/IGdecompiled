package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.Internal;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

@CheckReturnValue
final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> PROTO2_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(false);
    private static final UnknownFieldSchema<?, ?> PROTO3_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(true);
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    private SchemaUtil() {
    }

    static int computeSizeBoolList(int i4, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z4) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.computeLengthDelimitedFieldSize(size);
        }
        return size * CodedOutputStream.computeBoolSize(i4, true);
    }

    static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    static int computeSizeByteStringList(int i4, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = size * CodedOutputStream.computeTagSize(i4);
        for (int i5 = 0; i5 < list.size(); i5++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i5));
        }
        return computeTagSize;
    }

    static int computeSizeEnumList(int i4, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeEnumListNoTag);
        }
        return computeSizeEnumListNoTag + (size * CodedOutputStream.computeTagSize(i4));
    }

    static int computeSizeEnumListNoTag(List<Integer> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += CodedOutputStream.computeEnumSizeNoTag(list.get(i4).intValue());
            i4++;
        }
        return i6;
    }

    static int computeSizeFixed32List(int i4, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z4) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 4);
        }
        return size * CodedOutputStream.computeFixed32Size(i4, 0);
    }

    static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    static int computeSizeFixed64List(int i4, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z4) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 8);
        }
        return size * CodedOutputStream.computeFixed64Size(i4, 0);
    }

    static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    static int computeSizeGroupList(int i4, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += CodedOutputStream.computeGroupSize(i4, list.get(i6));
        }
        return i5;
    }

    static int computeSizeInt32List(int i4, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt32ListNoTag);
        }
        return computeSizeInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i4));
    }

    static int computeSizeInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += CodedOutputStream.computeInt32SizeNoTag(list.get(i4).intValue());
            i4++;
        }
        return i6;
    }

    static int computeSizeInt64List(int i4, List<Long> list, boolean z4) {
        if (list.size() == 0) {
            return 0;
        }
        int computeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt64ListNoTag);
        }
        return computeSizeInt64ListNoTag + (list.size() * CodedOutputStream.computeTagSize(i4));
    }

    static int computeSizeInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += CodedOutputStream.computeInt64SizeNoTag(list.get(i4).longValue());
            i4++;
        }
        return i6;
    }

    static int computeSizeMessage(int i4, Object obj, Schema schema) {
        if (obj instanceof LazyFieldLite) {
            return CodedOutputStream.computeLazyFieldSize(i4, (LazyFieldLite) obj);
        }
        return CodedOutputStream.computeMessageSize(i4, (MessageLite) obj, schema);
    }

    static int computeSizeMessageList(int i4, List<?> list) {
        int computeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i4) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof LazyFieldLite) {
                computeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                computeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
            }
            computeTagSize += computeMessageSizeNoTag;
        }
        return computeTagSize;
    }

    static int computeSizeSInt32List(int i4, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt32ListNoTag);
        }
        return computeSizeSInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i4));
    }

    static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i4).intValue());
            i4++;
        }
        return i6;
    }

    static int computeSizeSInt64List(int i4, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt64ListNoTag);
        }
        return computeSizeSInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i4));
    }

    static int computeSizeSInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i4).longValue());
            i4++;
        }
        return i6;
    }

    static int computeSizeStringList(int i4, List<?> list) {
        int computeStringSizeNoTag;
        int computeStringSizeNoTag2;
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i4) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i5 < size) {
                Object raw = lazyStringList.getRaw(i5);
                if (raw instanceof ByteString) {
                    computeStringSizeNoTag2 = CodedOutputStream.computeBytesSizeNoTag((ByteString) raw);
                } else {
                    computeStringSizeNoTag2 = CodedOutputStream.computeStringSizeNoTag((String) raw);
                }
                computeTagSize += computeStringSizeNoTag2;
                i5++;
            }
            return computeTagSize;
        }
        while (i5 < size) {
            Object obj = list.get(i5);
            if (obj instanceof ByteString) {
                computeStringSizeNoTag = CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
            } else {
                computeStringSizeNoTag = CodedOutputStream.computeStringSizeNoTag((String) obj);
            }
            computeTagSize += computeStringSizeNoTag;
            i5++;
        }
        return computeTagSize;
    }

    static int computeSizeUInt32List(int i4, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt32ListNoTag);
        }
        return computeSizeUInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i4));
    }

    static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i4).intValue());
            i4++;
        }
        return i6;
    }

    static int computeSizeUInt64List(int i4, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (z4) {
            return CodedOutputStream.computeTagSize(i4) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt64ListNoTag);
        }
        return computeSizeUInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i4));
    }

    static int computeSizeUInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            int i5 = 0;
            while (i4 < size) {
                i5 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i4));
                i4++;
            }
            return i5;
        }
        int i6 = 0;
        while (i4 < size) {
            i6 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i4).longValue());
            i4++;
        }
        return i6;
    }

    @CanIgnoreReturnValue
    static <UT, UB> UB filterUnknownEnumList(Object obj, int i4, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                Integer num = list.get(i6);
                int intValue = num.intValue();
                if (enumLiteMap.findValueByNumber(intValue) != null) {
                    if (i6 != i5) {
                        list.set(i5, num);
                    }
                    i5++;
                } else {
                    ub = storeUnknownEnum(obj, i4, intValue, ub, unknownFieldSchema);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = it.next().intValue();
            if (enumLiteMap.findValueByNumber(intValue2) == null) {
                ub = storeUnknownEnum(obj, i4, intValue2, ub, unknownFieldSchema);
                it.remove();
            }
        }
        return ub;
    }

    private static Class<?> getGeneratedMessageClass() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema(boolean z4) {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z4)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t4, T t5) {
        FieldSet<FT> extensions = extensionSchema.getExtensions(t5);
        if (!extensions.isEmpty()) {
            extensionSchema.getMutableExtensions(t4).mergeFrom(extensions);
        }
    }

    static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t4, T t5, long j4) {
        UnsafeUtil.putObject((Object) t4, j4, mapFieldSchema.mergeFrom(UnsafeUtil.getObject((Object) t4, j4), UnsafeUtil.getObject((Object) t5, j4)));
    }

    static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t4, T t5) {
        unknownFieldSchema.setToMessage(t4, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t4), unknownFieldSchema.getFromMessage(t5)));
    }

    public static UnknownFieldSchema<?, ?> proto2UnknownFieldSetSchema() {
        return PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> proto3UnknownFieldSetSchema() {
        return PROTO3_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    static boolean safeEquals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static boolean shouldUseTableSwitch(int i4, int i5, int i6) {
        if (i5 < 40) {
            return true;
        }
        long j4 = ((long) i5) - ((long) i4);
        long j5 = (long) i6;
        return j4 + 10 <= ((2 * j5) + 3) + ((j5 + 3) * 3);
    }

    @CanIgnoreReturnValue
    static <UT, UB> UB storeUnknownEnum(Object obj, int i4, int i5, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.getBuilderFromMessage(obj);
        }
        unknownFieldSchema.addVarint(ub, i4, (long) i5);
        return ub;
    }

    static String toCamelCase(String str, boolean z4) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if ('a' > charAt || charAt > 'z') {
                if ('A' > charAt || charAt > 'Z') {
                    if ('0' <= charAt && charAt <= '9') {
                        sb.append(charAt);
                    }
                    z4 = true;
                } else if (i4 != 0 || z4) {
                    sb.append(charAt);
                } else {
                    sb.append((char) (charAt + ' '));
                }
            } else if (z4) {
                sb.append((char) (charAt - ' '));
            } else {
                sb.append(charAt);
            }
            z4 = false;
        }
        return sb.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int i4, boolean z4, Writer writer) throws IOException {
        if (z4) {
            writer.writeBool(i4, true);
        }
    }

    public static void writeBoolList(int i4, List<Boolean> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBoolList(i4, list, z4);
        }
    }

    public static void writeBytes(int i4, ByteString byteString, Writer writer) throws IOException {
        if (byteString != null && !byteString.isEmpty()) {
            writer.writeBytes(i4, byteString);
        }
    }

    public static void writeBytesList(int i4, List<ByteString> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeBytesList(i4, list);
        }
    }

    public static void writeDouble(int i4, double d5, Writer writer) throws IOException {
        if (Double.doubleToRawLongBits(d5) != 0) {
            writer.writeDouble(i4, d5);
        }
    }

    public static void writeDoubleList(int i4, List<Double> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeDoubleList(i4, list, z4);
        }
    }

    public static void writeEnum(int i4, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeEnum(i4, i5);
        }
    }

    public static void writeEnumList(int i4, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeEnumList(i4, list, z4);
        }
    }

    public static void writeFixed32(int i4, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeFixed32(i4, i5);
        }
    }

    public static void writeFixed32List(int i4, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed32List(i4, list, z4);
        }
    }

    public static void writeFixed64(int i4, long j4, Writer writer) throws IOException {
        if (j4 != 0) {
            writer.writeFixed64(i4, j4);
        }
    }

    public static void writeFixed64List(int i4, List<Long> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFixed64List(i4, list, z4);
        }
    }

    public static void writeFloat(int i4, float f4, Writer writer) throws IOException {
        if (Float.floatToRawIntBits(f4) != 0) {
            writer.writeFloat(i4, f4);
        }
    }

    public static void writeFloatList(int i4, List<Float> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeFloatList(i4, list, z4);
        }
    }

    public static void writeGroupList(int i4, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeGroupList(i4, list);
        }
    }

    public static void writeInt32(int i4, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeInt32(i4, i5);
        }
    }

    public static void writeInt32List(int i4, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt32List(i4, list, z4);
        }
    }

    public static void writeInt64(int i4, long j4, Writer writer) throws IOException {
        if (j4 != 0) {
            writer.writeInt64(i4, j4);
        }
    }

    public static void writeInt64List(int i4, List<Long> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeInt64List(i4, list, z4);
        }
    }

    public static void writeLazyFieldList(int i4, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                ((LazyFieldLite) it.next()).writeTo(writer, i4);
            }
        }
    }

    public static void writeMessage(int i4, Object obj, Writer writer) throws IOException {
        if (obj != null) {
            writer.writeMessage(i4, obj);
        }
    }

    public static void writeMessageList(int i4, List<?> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeMessageList(i4, list);
        }
    }

    public static void writeSFixed32(int i4, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeSFixed32(i4, i5);
        }
    }

    public static void writeSFixed32List(int i4, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed32List(i4, list, z4);
        }
    }

    public static void writeSFixed64(int i4, long j4, Writer writer) throws IOException {
        if (j4 != 0) {
            writer.writeSFixed64(i4, j4);
        }
    }

    public static void writeSFixed64List(int i4, List<Long> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSFixed64List(i4, list, z4);
        }
    }

    public static void writeSInt32(int i4, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeSInt32(i4, i5);
        }
    }

    public static void writeSInt32List(int i4, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt32List(i4, list, z4);
        }
    }

    public static void writeSInt64(int i4, long j4, Writer writer) throws IOException {
        if (j4 != 0) {
            writer.writeSInt64(i4, j4);
        }
    }

    public static void writeSInt64List(int i4, List<Long> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeSInt64List(i4, list, z4);
        }
    }

    public static void writeString(int i4, Object obj, Writer writer) throws IOException {
        if (obj instanceof String) {
            writeStringInternal(i4, (String) obj, writer);
        } else {
            writeBytes(i4, (ByteString) obj, writer);
        }
    }

    private static void writeStringInternal(int i4, String str, Writer writer) throws IOException {
        if (str != null && !str.isEmpty()) {
            writer.writeString(i4, str);
        }
    }

    public static void writeStringList(int i4, List<String> list, Writer writer) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeStringList(i4, list);
        }
    }

    public static void writeUInt32(int i4, int i5, Writer writer) throws IOException {
        if (i5 != 0) {
            writer.writeUInt32(i4, i5);
        }
    }

    public static void writeUInt32List(int i4, List<Integer> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt32List(i4, list, z4);
        }
    }

    public static void writeUInt64(int i4, long j4, Writer writer) throws IOException {
        if (j4 != 0) {
            writer.writeUInt64(i4, j4);
        }
    }

    public static void writeUInt64List(int i4, List<Long> list, Writer writer, boolean z4) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeUInt64List(i4, list, z4);
        }
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    static int computeSizeGroupList(int i4, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            i5 += CodedOutputStream.computeGroupSize(i4, list.get(i6), schema);
        }
        return i5;
    }

    public static void writeGroupList(int i4, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeGroupList(i4, list, schema);
        }
    }

    public static void writeMessageList(int i4, List<?> list, Writer writer, Schema schema) throws IOException {
        if (list != null && !list.isEmpty()) {
            writer.writeMessageList(i4, list, schema);
        }
    }

    static int computeSizeMessageList(int i4, List<?> list, Schema schema) {
        int computeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i4) * size;
        for (int i5 = 0; i5 < size; i5++) {
            Object obj = list.get(i5);
            if (obj instanceof LazyFieldLite) {
                computeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                computeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, schema);
            }
            computeTagSize += computeMessageSizeNoTag;
        }
        return computeTagSize;
    }

    @CanIgnoreReturnValue
    static <UT, UB> UB filterUnknownEnumList(Object obj, int i4, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                Integer num = list.get(i6);
                int intValue = num.intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i6 != i5) {
                        list.set(i5, num);
                    }
                    i5++;
                } else {
                    ub = storeUnknownEnum(obj, i4, intValue, ub, unknownFieldSchema);
                }
            }
            if (i5 != size) {
                list.subList(i5, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int intValue2 = it.next().intValue();
            if (!enumVerifier.isInRange(intValue2)) {
                ub = storeUnknownEnum(obj, i4, intValue2, ub, unknownFieldSchema);
                it.remove();
            }
        }
        return ub;
    }
}
