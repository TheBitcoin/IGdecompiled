package com.mbridge.msdk.foundation.download;

public enum DownloadResourceType {
    DOWNLOAD_RESOURCE_TYPE_VIDEO(0),
    DOWNLOAD_RESOURCE_TYPE_ZIP(1),
    DOWNLOAD_RESOURCE_TYPE_IMAGE(2),
    DOWNLOAD_RESOURCE_TYPE_HTML(3),
    DOWNLOAD_RESOURCE_TYPE_OTHER(4),
    DOWNLOAD_RESOURCE_TYPE_APK(5);
    
    public int resourceType;

    private DownloadResourceType(int i4) {
        this.resourceType = i4;
    }

    public static DownloadResourceType getDownloadResourceType(int i4) {
        if (i4 == 0) {
            return DOWNLOAD_RESOURCE_TYPE_VIDEO;
        }
        if (i4 == 1) {
            return DOWNLOAD_RESOURCE_TYPE_ZIP;
        }
        if (i4 == 2) {
            return DOWNLOAD_RESOURCE_TYPE_IMAGE;
        }
        if (i4 == 3) {
            return DOWNLOAD_RESOURCE_TYPE_HTML;
        }
        if (i4 == 4) {
            return DOWNLOAD_RESOURCE_TYPE_OTHER;
        }
        if (i4 != 5) {
            return null;
        }
        return DOWNLOAD_RESOURCE_TYPE_APK;
    }
}
