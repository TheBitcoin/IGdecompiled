package androidx.core.view.inputmethod;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

@SuppressLint({"PrivateConstructorForUtilityClass"})
public final class InputConnectionCompat {
    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
    private static final String LOG_TAG = "InputConnectionCompat";

    @RequiresApi(25)
    static class Api25Impl {
        private Api25Impl() {
        }

        @DoNotInline
        static boolean commitContent(InputConnection inputConnection, InputContentInfo inputContentInfo, int i4, Bundle bundle) {
            return inputConnection.commitContent(inputContentInfo, i4, bundle);
        }
    }

    public interface OnCommitContentListener {
        boolean onCommitContent(@NonNull InputContentInfoCompat inputContentInfoCompat, int i4, @Nullable Bundle bundle);
    }

    public static /* synthetic */ boolean a(View view, InputContentInfoCompat inputContentInfoCompat, int i4, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 25 && (i4 & 1) != 0) {
            try {
                inputContentInfoCompat.requestPermission();
                Parcelable parcelable = (Parcelable) inputContentInfoCompat.unwrap();
                if (bundle == null) {
                    bundle = new Bundle();
                } else {
                    bundle = new Bundle(bundle);
                }
                bundle.putParcelable(EXTRA_INPUT_CONTENT_INFO, parcelable);
            } catch (Exception e5) {
                Log.w(LOG_TAG, "Can't insert content from IME; requestPermission() failed", e5);
                return false;
            }
        }
        if (ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(new ClipData(inputContentInfoCompat.getDescription(), new ClipData.Item(inputContentInfoCompat.getContentUri())), 2).setLinkUri(inputContentInfoCompat.getLinkUri()).setExtras(bundle).build()) == null) {
            return true;
        }
        return false;
    }

    public static boolean commitContent(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull InputContentInfoCompat inputContentInfoCompat, int i4, @Nullable Bundle bundle) {
        boolean z4;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (Build.VERSION.SDK_INT >= 25) {
            return Api25Impl.commitContent(inputConnection, c.a(inputContentInfoCompat.unwrap()), i4, bundle);
        }
        int protocol = EditorInfoCompat.getProtocol(editorInfo);
        if (protocol != 2) {
            z4 = false;
            if (!(protocol == 3 || protocol == 4)) {
                return false;
            }
        } else {
            z4 = true;
        }
        Bundle bundle2 = new Bundle();
        if (z4) {
            str = COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY;
        } else {
            str = COMMIT_CONTENT_CONTENT_URI_KEY;
        }
        bundle2.putParcelable(str, inputContentInfoCompat.getContentUri());
        if (z4) {
            str2 = COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY;
        } else {
            str2 = COMMIT_CONTENT_DESCRIPTION_KEY;
        }
        bundle2.putParcelable(str2, inputContentInfoCompat.getDescription());
        if (z4) {
            str3 = COMMIT_CONTENT_LINK_URI_INTEROP_KEY;
        } else {
            str3 = COMMIT_CONTENT_LINK_URI_KEY;
        }
        bundle2.putParcelable(str3, inputContentInfoCompat.getLinkUri());
        if (z4) {
            str4 = COMMIT_CONTENT_FLAGS_INTEROP_KEY;
        } else {
            str4 = COMMIT_CONTENT_FLAGS_KEY;
        }
        bundle2.putInt(str4, i4);
        if (z4) {
            str5 = COMMIT_CONTENT_OPTS_INTEROP_KEY;
        } else {
            str5 = COMMIT_CONTENT_OPTS_KEY;
        }
        bundle2.putParcelable(str5, bundle);
        if (z4) {
            str6 = COMMIT_CONTENT_INTEROP_ACTION;
        } else {
            str6 = COMMIT_CONTENT_ACTION;
        }
        return inputConnection.performPrivateCommand(str6, bundle2);
    }

    @NonNull
    private static OnCommitContentListener createOnCommitContentListenerUsingPerformReceiveContent(@NonNull View view) {
        Preconditions.checkNotNull(view);
        return new d(view);
    }

    @NonNull
    @Deprecated
    public static InputConnection createWrapper(@NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo, @NonNull final OnCommitContentListener onCommitContentListener) {
        ObjectsCompat.requireNonNull(inputConnection, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(editorInfo, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(onCommitContentListener, "onCommitContentListener must be non-null");
        if (Build.VERSION.SDK_INT >= 25) {
            return new InputConnectionWrapper(inputConnection, false) {
                public boolean commitContent(InputContentInfo inputContentInfo, int i4, Bundle bundle) {
                    if (onCommitContentListener.onCommitContent(InputContentInfoCompat.wrap(inputContentInfo), i4, bundle)) {
                        return true;
                    }
                    return super.commitContent(inputContentInfo, i4, bundle);
                }
            };
        }
        if (EditorInfoCompat.getContentMimeTypes(editorInfo).length == 0) {
            return inputConnection;
        }
        return new InputConnectionWrapper(inputConnection, false) {
            public boolean performPrivateCommand(String str, Bundle bundle) {
                if (InputConnectionCompat.handlePerformPrivateCommand(str, bundle, onCommitContentListener)) {
                    return true;
                }
                return super.performPrivateCommand(str, bundle);
            }
        };
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean handlePerformPrivateCommand(@androidx.annotation.Nullable java.lang.String r7, @androidx.annotation.Nullable android.os.Bundle r8, @androidx.annotation.NonNull androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r1 = android.text.TextUtils.equals(r1, r7)
            if (r1 == 0) goto L_0x000e
            r7 = 0
            goto L_0x0017
        L_0x000e:
            java.lang.String r1 = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r7 = android.text.TextUtils.equals(r1, r7)
            if (r7 == 0) goto L_0x0082
            r7 = 1
        L_0x0017:
            r1 = 0
            if (r7 == 0) goto L_0x0020
            java.lang.String r2 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
            goto L_0x0022
        L_0x001d:
            r7 = move-exception
            r2 = r1
            goto L_0x007c
        L_0x0020:
            java.lang.String r2 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
        L_0x0022:
            android.os.Parcelable r2 = r8.getParcelable(r2)     // Catch:{ all -> 0x001d }
            android.os.ResultReceiver r2 = (android.os.ResultReceiver) r2     // Catch:{ all -> 0x001d }
            if (r7 == 0) goto L_0x002f
            java.lang.String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI"
            goto L_0x0031
        L_0x002d:
            r7 = move-exception
            goto L_0x007c
        L_0x002f:
            java.lang.String r3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI"
        L_0x0031:
            android.os.Parcelable r3 = r8.getParcelable(r3)     // Catch:{ all -> 0x002d }
            android.net.Uri r3 = (android.net.Uri) r3     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x003c
            java.lang.String r4 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
            goto L_0x003e
        L_0x003c:
            java.lang.String r4 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
        L_0x003e:
            android.os.Parcelable r4 = r8.getParcelable(r4)     // Catch:{ all -> 0x002d }
            android.content.ClipDescription r4 = (android.content.ClipDescription) r4     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x0049
            java.lang.String r5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
            goto L_0x004b
        L_0x0049:
            java.lang.String r5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
        L_0x004b:
            android.os.Parcelable r5 = r8.getParcelable(r5)     // Catch:{ all -> 0x002d }
            android.net.Uri r5 = (android.net.Uri) r5     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x0056
            java.lang.String r6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
            goto L_0x0058
        L_0x0056:
            java.lang.String r6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
        L_0x0058:
            int r6 = r8.getInt(r6)     // Catch:{ all -> 0x002d }
            if (r7 == 0) goto L_0x0061
            java.lang.String r7 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
            goto L_0x0063
        L_0x0061:
            java.lang.String r7 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
        L_0x0063:
            android.os.Parcelable r7 = r8.getParcelable(r7)     // Catch:{ all -> 0x002d }
            android.os.Bundle r7 = (android.os.Bundle) r7     // Catch:{ all -> 0x002d }
            if (r3 == 0) goto L_0x0076
            if (r4 == 0) goto L_0x0076
            androidx.core.view.inputmethod.InputContentInfoCompat r8 = new androidx.core.view.inputmethod.InputContentInfoCompat     // Catch:{ all -> 0x002d }
            r8.<init>(r3, r4, r5)     // Catch:{ all -> 0x002d }
            boolean r0 = r9.onCommitContent(r8, r6, r7)     // Catch:{ all -> 0x002d }
        L_0x0076:
            if (r2 == 0) goto L_0x007b
            r2.send(r0, r1)
        L_0x007b:
            return r0
        L_0x007c:
            if (r2 == 0) goto L_0x0081
            r2.send(r0, r1)
        L_0x0081:
            throw r7
        L_0x0082:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.inputmethod.InputConnectionCompat.handlePerformPrivateCommand(java.lang.String, android.os.Bundle, androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener):boolean");
    }

    @NonNull
    public static InputConnection createWrapper(@NonNull View view, @NonNull InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        return createWrapper(inputConnection, editorInfo, createOnCommitContentListenerUsingPerformReceiveContent(view));
    }
}
