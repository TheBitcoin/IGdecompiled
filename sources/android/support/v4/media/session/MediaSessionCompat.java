package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.d;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaSessionCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        ResultReceiver f747a;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* renamed from: b */
            public ResultReceiverWrapper[] newArray(int i4) {
                return new ResultReceiverWrapper[i4];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f747a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i4) {
            this.f747a.writeToParcel(parcel, i4);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final Object f748a;

        /* renamed from: b  reason: collision with root package name */
        private b f749b;

        /* renamed from: c  reason: collision with root package name */
        private Bundle f750c;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable((ClassLoader) null));
            }

            /* renamed from: b */
            public Token[] newArray(int i4) {
                return new Token[i4];
            }
        }

        Token(Object obj) {
            this(obj, (b) null, (Bundle) null);
        }

        public static Token a(Object obj) {
            return b(obj, (b) null);
        }

        public static Token b(Object obj, b bVar) {
            if (obj != null) {
                return new Token(d.a(obj), bVar);
            }
            return null;
        }

        public b c() {
            return this.f749b;
        }

        public Object d() {
            return this.f748a;
        }

        public int describeContents() {
            return 0;
        }

        public void e(b bVar) {
            this.f749b = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f748a;
            if (obj2 != null) {
                Object obj3 = token.f748a;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            } else if (token.f748a == null) {
                return true;
            } else {
                return false;
            }
        }

        public void f(Bundle bundle) {
            this.f750c = bundle;
        }

        public int hashCode() {
            Object obj = this.f748a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public void writeToParcel(Parcel parcel, int i4) {
            parcel.writeParcelable((Parcelable) this.f748a, i4);
        }

        Token(Object obj, b bVar) {
            this(obj, bVar, (Bundle) null);
        }

        Token(Object obj, b bVar, Bundle bundle) {
            this.f748a = obj;
            this.f749b = bVar;
            this.f750c = bundle;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private final MediaDescriptionCompat f744a;

        /* renamed from: b  reason: collision with root package name */
        private final long f745b;

        /* renamed from: c  reason: collision with root package name */
        private Object f746c;

        static class a implements Parcelable.Creator {
            a() {
            }

            /* renamed from: a */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* renamed from: b */
            public QueueItem[] newArray(int i4) {
                return new QueueItem[i4];
            }
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j4) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j4 != -1) {
                this.f744a = mediaDescriptionCompat;
                this.f745b = j4;
                this.f746c = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        public static QueueItem a(Object obj) {
            if (obj != null) {
                return new QueueItem(obj, MediaDescriptionCompat.a(d.a.a(obj)), d.a.b(obj));
            }
            return null;
        }

        public static List b(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object a5 : list) {
                arrayList.add(a(a5));
            }
            return arrayList;
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f744a + ", Id=" + this.f745b + " }";
        }

        public void writeToParcel(Parcel parcel, int i4) {
            this.f744a.writeToParcel(parcel, i4);
            parcel.writeLong(this.f745b);
        }

        QueueItem(Parcel parcel) {
            this.f744a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f745b = parcel.readLong();
        }
    }
}
