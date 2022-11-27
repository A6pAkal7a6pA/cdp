module application {
    uses com.mkuleshov.bank.api.Bank;
    uses com.mkuleshov.service.api.Service;
    requires jmpServiceApiImpl;
    requires jmpCloudBankImpl;
    requires jmpDto;
}