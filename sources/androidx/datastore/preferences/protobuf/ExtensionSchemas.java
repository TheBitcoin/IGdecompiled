package androidx.datastore.preferences.protobuf;

@CheckReturnValue
final class ExtensionSchemas {
    private static final ExtensionSchema<?> FULL_SCHEMA = loadSchemaForFullRuntime();
    private static final ExtensionSchema<?> LITE_SCHEMA = new ExtensionSchemaLite();

    ExtensionSchemas() {
    }

    static ExtensionSchema<?> full() {
        ExtensionSchema<?> extensionSchema = FULL_SCHEMA;
        if (extensionSchema != null) {
            return extensionSchema;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    static ExtensionSchema<?> lite() {
        return LITE_SCHEMA;
    }

    private static ExtensionSchema<?> loadSchemaForFullRuntime() {
        try {
            return (ExtensionSchema) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
