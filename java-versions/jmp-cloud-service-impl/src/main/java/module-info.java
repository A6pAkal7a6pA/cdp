module jmpServiceApiImpl {
    requires transitive jmpServiceApi;
    requires jmpDto;
    exports com.mkuleshov.service.api.impl;
    exports com.mkuleshov.service.api.exception;
}