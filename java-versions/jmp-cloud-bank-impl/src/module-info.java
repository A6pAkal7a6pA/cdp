module jmpCloudBankImpl {
    requires transitive jmpBankApi;
    requires jmpDto;
    exports com.mkuleshov.cloud.bank.impl;
}