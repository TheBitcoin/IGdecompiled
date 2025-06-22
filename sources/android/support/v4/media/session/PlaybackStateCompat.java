package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    final int f756a;

    /* renamed from: b  reason: collision with root package name */
    final long f757b;

    /* renamed from: c  reason: collision with root package name */
    final long f758c;

    /* renamed from: d  reason: collision with root package name */
    final float f759d;

    /* renamed from: e  reason: collision with root package name */
    final long f760e;

    /* renamed from: f  reason: collision with root package name */
    final int f761f;

    /* renamed from: g  reason: collision with root package name */
    final CharSequence f762g;

    /* renamed from: h  reason: collision with root package name */
    final long f763h;

    /* renamed from: i  reason: collision with root package name */
    List f764i;

    /* renamed from: j  reason: collision with root package name */
    final long f765j;

    /* renamed from: k  reason: collision with root package name */
    final Bundle f766k;

    /* renamed from: l  reason: collision with root package name */
    private Object f767l;

    static class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* renamed from: b */
        public PlaybackStateCompat[] newArray(int i4) {
            return new PlaybackStateCompat[i4];
        }
    }

    PlaybackStateCompat(int i4, long j4, long j5, float f4, long j6, int i5, CharSequence charSequence, long j7, List list, long j8, Bundle bundle) {
        this.f756a = i4;
        this.f757b = j4;
        this.f758c = j5;
        this.f759d = f4;
        this.f760e = j6;
        this.f761f = i5;
        this.f762g = charSequence;
        this.f763h = j7;
        this.f764i = new ArrayList(list);
        this.f765j = j8;
        this.f766k = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        Object obj2 = obj;
        Bundle bundle = null;
        if (obj2 == null) {
            return null;
        }
        List<Object> d5 = e.d(obj2);
        if (d5 != null) {
            ArrayList arrayList2 = new ArrayList(d5.size());
            for (Object a5 : d5) {
                arrayList2.add(CustomAction.a(a5));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = g.a(obj2);
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(e.i(obj2), e.h(obj2), e.c(obj2), e.g(obj2), e.a(obj2), 0, e.e(obj2), e.f(obj2), arrayList, e.b(obj2), bundle);
        playbackStateCompat.f767l = obj2;
        return playbackStateCompat;
    }

    public static int i(long j4) {
        if (j4 == 4) {
            return 126;
        }
        if (j4 == 2) {
            return ModuleDescriptor.MODULE_VERSION;
        }
        if (j4 == 32) {
            return 87;
        }
        if (j4 == 16) {
            return 88;
        }
        if (j4 == 1) {
            return 86;
        }
        if (j4 == 64) {
            return 90;
        }
        if (j4 == 8) {
            return 89;
        }
        return j4 == 512 ? 85 : 0;
    }

    public long b() {
        return this.f760e;
    }

    public long c() {
        return this.f758c;
    }

    public int d() {
        return this.f761f;
    }

    public int describeContents() {
        return 0;
    }

    public CharSequence e() {
        return this.f762g;
    }

    public float f() {
        return this.f759d;
    }

    public long g() {
        return this.f757b;
    }

    public int h() {
        return this.f756a;
    }

    public String toString() {
        return "PlaybackState {" + "state=" + this.f756a + ", position=" + this.f757b + ", buffered position=" + this.f758c + ", speed=" + this.f759d + ", updated=" + this.f763h + ", actions=" + this.f760e + ", error code=" + this.f761f + ", error message=" + this.f762g + ", custom actions=" + this.f764i + ", active item id=" + this.f765j + "}";
    }

    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f756a);
        parcel.writeLong(this.f757b);
        parcel.writeFloat(this.f759d);
        parcel.writeLong(this.f763h);
        parcel.writeLong(this.f758c);
        parcel.writeLong(this.f760e);
        TextUtils.writeToParcel(this.f762g, parcel, i4);
        parcel.writeTypedList(this.f764i);
        parcel.writeLong(this.f765j);
        parcel.writeBundle(this.f766k);
        parcel.writeInt(this.f761f);
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final String f768a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f769b;

        /* renamed from: c  reason: collision with root package name */
        private final int f770c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f771d;

        /* renamed from: e  reason: collision with root package name */
        private Object f772e;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* renamed from: b */
            public CustomAction[] newArray(int i4) {
                return new CustomAction[i4];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i4, Bundle bundle) {
            this.f768a = str;
            this.f769b = charSequence;
            this.f770c = i4;
            this.f771d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null) {
                return null;
            }
            CustomAction customAction = new CustomAction(e.a.a(obj), e.a.d(obj), e.a.c(obj), e.a.b(obj));
            customAction.f772e = obj;
            return customAction;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f769b + ", mIcon=" + this.f770c + ", mExtras=" + this.f771d;
        }

        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeString(this.f768a);
            TextUtils.writeToParcel(this.f769b, parcel, i4);
            parcel.writeInt(this.f770c);
            parcel.writeBundle(this.f771d);
        }

        CustomAction(Parcel parcel) {
            this.f768a = parcel.readString();
            this.f769b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f770c = parcel.readInt();
            this.f771d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f756a = parcel.readInt();
        this.f757b = parcel.readLong();
        this.f759d = parcel.readFloat();
        this.f763h = parcel.readLong();
        this.f758c = parcel.readLong();
        this.f760e = parcel.readLong();
        this.f762g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f764i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f765j = parcel.readLong();
        this.f766k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f761f = parcel.readInt();
    }
}
