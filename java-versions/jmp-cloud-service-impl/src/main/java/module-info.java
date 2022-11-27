module jmpServiceApiImpl {
    uses com.mkuleshov.service.api.Service;
    requires transitive jmpServiceApi;
    requires jmpDto;
    provides com.mkuleshov.service.api.Service with com.mkuleshov.service.api.impl.CloudServiceImpl;
    exports com.mkuleshov.service.api.impl;
    exports com.mkuleshov.service.api.exception;
}