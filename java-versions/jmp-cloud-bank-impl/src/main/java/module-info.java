module jmpCloudBankImpl {
    requires jmpDto;
    requires transitive jmpBankApi;
    exports com.mkuleshov.cloud.bank.impl;
}