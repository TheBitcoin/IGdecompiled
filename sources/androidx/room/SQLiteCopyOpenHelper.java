package androidx.room;

import R2.s;
import android.content.Context;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.util.ProcessLock;
import b3.C1642b;
import j3.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.m;

public final class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper, AutoCloseable {
    private final Context context;
    private final String copyFromAssetPath;
    private final File copyFromFile;
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;
    private final SupportSQLiteOpenHelper delegate;
    private boolean verified;

    public SQLiteCopyOpenHelper(Context context2, String str, File file, Callable<InputStream> callable, int i4, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        m.e(context2, "context");
        m.e(supportSQLiteOpenHelper, "delegate");
        this.context = context2;
        this.copyFromAssetPath = str;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.databaseVersion = i4;
        this.delegate = supportSQLiteOpenHelper;
    }

    private final void copyDatabaseFile(File file, boolean z4) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.copyFromAssetPath != null) {
            readableByteChannel = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
            m.d(readableByteChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.copyFromFile != null) {
            readableByteChannel = new FileInputStream(this.copyFromFile).getChannel();
            m.d(readableByteChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable<InputStream> callable = this.copyFromInputStream;
            if (callable != null) {
                try {
                    readableByteChannel = Channels.newChannel(callable.call());
                    m.d(readableByteChannel, "newChannel(inputStream)");
                } catch (Exception e5) {
                    throw new IOException("inputStreamCallable exception on call", e5);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        m.d(channel, "output");
        FileUtil.copy(readableByteChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            m.d(createTempFile, "intermediateFile");
            dispatchOnOpenPrepackagedDatabase(createTempFile, z4);
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
            }
            return;
        }
        throw new IOException("Failed to create directories for " + file.getAbsolutePath());
    }

    private final SupportSQLiteOpenHelper createFrameworkOpenHelper(File file) {
        try {
            int readVersion = DBUtil.readVersion(file);
            return new FrameworkSQLiteOpenHelperFactory().create(SupportSQLiteOpenHelper.Configuration.Companion.builder(this.context).name(file.getAbsolutePath()).callback(new SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1(readVersion, e.a(readVersion, 1))).build());
        } catch (IOException e5) {
            throw new RuntimeException("Malformed database file, unable to read version.", e5);
        }
    }

    private final void dispatchOnOpenPrepackagedDatabase(File file, boolean z4) {
        SupportSQLiteDatabase supportSQLiteDatabase;
        DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
        if (databaseConfiguration2 == null) {
            m.u("databaseConfiguration");
            databaseConfiguration2 = null;
        }
        if (databaseConfiguration2.prepackagedDatabaseCallback != null) {
            SupportSQLiteOpenHelper createFrameworkOpenHelper = createFrameworkOpenHelper(file);
            if (z4) {
                try {
                    supportSQLiteDatabase = createFrameworkOpenHelper.getWritableDatabase();
                } catch (Throwable th) {
                    C1642b.a(createFrameworkOpenHelper, th);
                    throw th;
                }
            } else {
                supportSQLiteDatabase = createFrameworkOpenHelper.getReadableDatabase();
            }
            DatabaseConfiguration databaseConfiguration3 = this.databaseConfiguration;
            if (databaseConfiguration3 == null) {
                m.u("databaseConfiguration");
                databaseConfiguration3 = null;
            }
            RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback = databaseConfiguration3.prepackagedDatabaseCallback;
            m.b(prepackagedDatabaseCallback);
            prepackagedDatabaseCallback.onOpenPrepackagedDatabase(supportSQLiteDatabase);
            s sVar = s.f8222a;
            C1642b.a(createFrameworkOpenHelper, (Throwable) null);
        }
    }

    private final void verifyDatabaseFile(boolean z4) {
        String databaseName = getDatabaseName();
        if (databaseName != null) {
            File databasePath = this.context.getDatabasePath(databaseName);
            DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
            DatabaseConfiguration databaseConfiguration3 = null;
            if (databaseConfiguration2 == null) {
                m.u("databaseConfiguration");
                databaseConfiguration2 = null;
            }
            boolean z5 = databaseConfiguration2.multiInstanceInvalidation;
            File filesDir = this.context.getFilesDir();
            m.d(filesDir, "context.filesDir");
            ProcessLock processLock = new ProcessLock(databaseName, filesDir, z5);
            try {
                ProcessLock.lock$default(processLock, false, 1, (Object) null);
                if (!databasePath.exists()) {
                    m.d(databasePath, "databaseFile");
                    copyDatabaseFile(databasePath, z4);
                    processLock.unlock();
                    return;
                }
                try {
                    m.d(databasePath, "databaseFile");
                    int readVersion = DBUtil.readVersion(databasePath);
                    if (readVersion == this.databaseVersion) {
                        processLock.unlock();
                        return;
                    }
                    DatabaseConfiguration databaseConfiguration4 = this.databaseConfiguration;
                    if (databaseConfiguration4 == null) {
                        m.u("databaseConfiguration");
                    } else {
                        databaseConfiguration3 = databaseConfiguration4;
                    }
                    if (databaseConfiguration3.isMigrationRequired(readVersion, this.databaseVersion)) {
                        processLock.unlock();
                        return;
                    }
                    if (this.context.deleteDatabase(databaseName)) {
                        try {
                            copyDatabaseFile(databasePath, z4);
                        } catch (IOException e5) {
                            Log.w(Room.LOG_TAG, "Unable to copy database file.", e5);
                        }
                    } else {
                        Log.w(Room.LOG_TAG, "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                    }
                    processLock.unlock();
                } catch (IOException e6) {
                    Log.w(Room.LOG_TAG, "Unable to read database version.", e6);
                    processLock.unlock();
                }
            } catch (IOException e7) {
                throw new RuntimeException("Unable to copy database file.", e7);
            } catch (Throwable th) {
                processLock.unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("Required value was null.");
        }
    }

    public synchronized void close() {
        getDelegate().close();
        this.verified = false;
    }

    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(false);
            this.verified = true;
        }
        return getDelegate().getReadableDatabase();
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(true);
            this.verified = true;
        }
        return getDelegate().getWritableDatabase();
    }

    public final void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration2) {
        m.e(databaseConfiguration2, "databaseConfiguration");
        this.databaseConfiguration = databaseConfiguration2;
    }

    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z4) {
        getDelegate().setWriteAheadLoggingEnabled(z4);
    }
}
