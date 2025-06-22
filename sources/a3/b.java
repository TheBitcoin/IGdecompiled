package A3;

public enum b {
    SharingNotice("SharingNotice"),
    SaleOptOutNotice("SaleOptOutNotice"),
    SharingOptOutNotice("SharingOptOutNotice"),
    TargetedAdvertisingOptOutNotice("TargetedAdvertisingOptOutNotice"),
    SensitiveDataProcessingOptOutNotice("SensitiveDataProcessingOptOutNotice"),
    SensitiveDataLimitUseNotice("SensitiveDataLimitUseNotice"),
    SaleOptOut("SaleOptOut"),
    SharingOptOut("SharingOptOut"),
    TargetedAdvertisingOptOut("TargetedAdvertisingOptOut"),
    SensitiveDataProcessing("SensitiveDataProcessing"),
    KnownChildSensitiveDataConsents("KnownChildSensitiveDataConsents"),
    PersonalDataConsents("PersonalDataConsents"),
    MspaCoveredTransaction("MspaCoveredTransaction"),
    MspaOptOutOptionMode("MspaOptOutOptionMode"),
    MspaServiceProviderMode("MspaServiceProviderMode"),
    NONE("none");

    /* access modifiers changed from: public */
    b(String str) {
    }
}
