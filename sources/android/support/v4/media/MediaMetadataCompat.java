package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;

public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new a();

    /* renamed from: d  reason: collision with root package name */
    static final ArrayMap f715d;

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f716e = {"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f717f = {"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f718g = {"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};

    /* renamed from: a  reason: collision with root package name */
    final Bundle f719a;

    /* renamed from: b  reason: collision with root package name */
    private Object f720b;

    /* renamed from: c  reason: collision with root package name */
    private MediaDescriptionCompat f721c;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        /* renamed from: b */
        public MediaMetadataCompat[] newArray(int i4) {
            return new MediaMetadataCompat[i4];
        }
    }

    static {
        ArrayMap arrayMap = new ArrayMap();
        f715d = arrayMap;
        arrayMap.put("android.media.metadata.TITLE", 1);
        arrayMap.put("android.media.metadata.ARTIST", 1);
        arrayMap.put("android.media.metadata.DURATION", 0);
        arrayMap.put("android.media.metadata.ALBUM", 1);
        arrayMap.put("android.media.metadata.AUTHOR", 1);
        arrayMap.put("android.media.metadata.WRITER", 1);
        arrayMap.put("android.media.metadata.COMPOSER", 1);
        arrayMap.put("android.media.metadata.COMPILATION", 1);
        arrayMap.put("android.media.metadata.DATE", 1);
        arrayMap.put("android.media.metadata.YEAR", 0);
        arrayMap.put("android.media.metadata.GENRE", 1);
        arrayMap.put("android.media.metadata.TRACK_NUMBER", 0);
        arrayMap.put("android.media.metadata.NUM_TRACKS", 0);
        arrayMap.put("android.media.metadata.DISC_NUMBER", 0);
        arrayMap.put("android.media.metadata.ALBUM_ARTIST", 1);
        arrayMap.put("android.media.metadata.ART", 2);
        arrayMap.put("android.media.metadata.ART_URI", 1);
        arrayMap.put("android.media.metadata.ALBUM_ART", 2);
        arrayMap.put("android.media.metadata.ALBUM_ART_URI", 1);
        arrayMap.put("android.media.metadata.USER_RATING", 3);
        arrayMap.put("android.media.metadata.RATING", 3);
        arrayMap.put("android.media.metadata.DISPLAY_TITLE", 1);
        arrayMap.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        arrayMap.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        arrayMap.put("android.media.metadata.DISPLAY_ICON", 2);
        arrayMap.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        arrayMap.put("android.media.metadata.MEDIA_ID", 1);
        arrayMap.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        arrayMap.put("android.media.metadata.MEDIA_URI", 1);
        arrayMap.put("android.media.metadata.ADVERTISEMENT", 0);
        arrayMap.put("android.media.metadata.DOWNLOAD_STATUS", 0);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.f719a = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public static MediaMetadataCompat a(Object obj) {
        if (obj == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        g.a(obj, obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.f720b = obj;
        return createFromParcel;
    }

    public Bitmap b(String str) {
        try {
            return (Bitmap) this.f719a.getParcelable(str);
        } catch (Exception e5) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e5);
            return null;
        }
    }

    public MediaDescriptionCompat c() {
        Uri uri;
        Bitmap bitmap;
        Uri uri2;
        MediaDescriptionCompat mediaDescriptionCompat = this.f721c;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        String e5 = e("android.media.metadata.MEDIA_ID");
        CharSequence[] charSequenceArr = new CharSequence[3];
        CharSequence f4 = f("android.media.metadata.DISPLAY_TITLE");
        if (TextUtils.isEmpty(f4)) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < 3) {
                String[] strArr = f716e;
                if (i5 >= strArr.length) {
                    break;
                }
                int i6 = i5 + 1;
                CharSequence f5 = f(strArr[i5]);
                if (!TextUtils.isEmpty(f5)) {
                    charSequenceArr[i4] = f5;
                    i4++;
                }
                i5 = i6;
            }
        } else {
            charSequenceArr[0] = f4;
            charSequenceArr[1] = f("android.media.metadata.DISPLAY_SUBTITLE");
            charSequenceArr[2] = f("android.media.metadata.DISPLAY_DESCRIPTION");
        }
        int i7 = 0;
        while (true) {
            String[] strArr2 = f717f;
            uri = null;
            if (i7 >= strArr2.length) {
                bitmap = null;
                break;
            }
            bitmap = b(strArr2[i7]);
            if (bitmap != null) {
                break;
            }
            i7++;
        }
        int i8 = 0;
        while (true) {
            String[] strArr3 = f718g;
            if (i8 >= strArr3.length) {
                uri2 = null;
                break;
            }
            String e6 = e(strArr3[i8]);
            if (!TextUtils.isEmpty(e6)) {
                uri2 = Uri.parse(e6);
                break;
            }
            i8++;
        }
        String e7 = e("android.media.metadata.MEDIA_URI");
        if (!TextUtils.isEmpty(e7)) {
            uri = Uri.parse(e7);
        }
        MediaDescriptionCompat.b bVar = new MediaDescriptionCompat.b();
        bVar.f(e5);
        bVar.i(charSequenceArr[0]);
        bVar.h(charSequenceArr[1]);
        bVar.b(charSequenceArr[2]);
        bVar.d(bitmap);
        bVar.e(uri2);
        bVar.g(uri);
        Bundle bundle = new Bundle();
        if (this.f719a.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
            bundle.putLong("android.media.extra.BT_FOLDER_TYPE", d("android.media.metadata.BT_FOLDER_TYPE"));
        }
        if (this.f719a.containsKey("android.media.metadata.DOWNLOAD_STATUS")) {
            bundle.putLong("android.media.extra.DOWNLOAD_STATUS", d("android.media.metadata.DOWNLOAD_STATUS"));
        }
        if (!bundle.isEmpty()) {
            bVar.c(bundle);
        }
        MediaDescriptionCompat a5 = bVar.a();
        this.f721c = a5;
        return a5;
    }

    public long d(String str) {
        return this.f719a.getLong(str, 0);
    }

    public int describeContents() {
        return 0;
    }

    public String e(String str) {
        CharSequence charSequence = this.f719a.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public CharSequence f(String str) {
        return this.f719a.getCharSequence(str);
    }

    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeBundle(this.f719a);
    }
}
