package H1;

import java.io.PrintWriter;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f6625a;

    /* renamed from: b  reason: collision with root package name */
    public final int f6626b;

    /* renamed from: c  reason: collision with root package name */
    public final long f6627c;

    /* renamed from: d  reason: collision with root package name */
    public final long f6628d;

    /* renamed from: e  reason: collision with root package name */
    public final long f6629e;

    /* renamed from: f  reason: collision with root package name */
    public final long f6630f;

    /* renamed from: g  reason: collision with root package name */
    public final long f6631g;

    /* renamed from: h  reason: collision with root package name */
    public final long f6632h;

    /* renamed from: i  reason: collision with root package name */
    public final long f6633i;

    /* renamed from: j  reason: collision with root package name */
    public final long f6634j;

    /* renamed from: k  reason: collision with root package name */
    public final int f6635k;

    /* renamed from: l  reason: collision with root package name */
    public final int f6636l;

    /* renamed from: m  reason: collision with root package name */
    public final int f6637m;

    /* renamed from: n  reason: collision with root package name */
    public final long f6638n;

    public d(int i4, int i5, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, int i6, int i7, int i8, long j12) {
        this.f6625a = i4;
        this.f6626b = i5;
        this.f6627c = j4;
        this.f6628d = j5;
        this.f6629e = j6;
        this.f6630f = j7;
        this.f6631g = j8;
        this.f6632h = j9;
        this.f6633i = j10;
        this.f6634j = j11;
        this.f6635k = i6;
        this.f6636l = i7;
        this.f6637m = i8;
        this.f6638n = j12;
    }

    public void a(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.f6625a);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.f6626b);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.f6626b) / ((float) this.f6625a)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.f6627c);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.f6628d);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.f6635k);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.f6629e);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.f6632h);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.f6636l);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.f6630f);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.f6637m);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.f6631g);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.f6633i);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.f6634j);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        return "StatsSnapshot{maxSize=" + this.f6625a + ", size=" + this.f6626b + ", cacheHits=" + this.f6627c + ", cacheMisses=" + this.f6628d + ", downloadCount=" + this.f6635k + ", totalDownloadSize=" + this.f6629e + ", averageDownloadSize=" + this.f6632h + ", totalOriginalBitmapSize=" + this.f6630f + ", totalTransformedBitmapSize=" + this.f6631g + ", averageOriginalBitmapSize=" + this.f6633i + ", averageTransformedBitmapSize=" + this.f6634j + ", originalBitmapCount=" + this.f6636l + ", transformedBitmapCount=" + this.f6637m + ", timeStamp=" + this.f6638n + '}';
    }
}
