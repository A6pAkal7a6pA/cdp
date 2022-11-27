module jmpCloudBankImpl {
    requires transitive jmpBankApi;
    requires jmpDto;
    provides com.mkuleshov.bank.api.Bank with com.mkuleshov.cloud.bank.impl.CloudBankImpl;
    exports com.mkuleshov.cloud.bank.impl;
}