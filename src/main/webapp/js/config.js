angular.module('myApp.config', [])
    .config(function($httpProvider){
        $httpProvider.defaults.useXDomain = true;
        delete $httpProvider.defaults.headers.common['X-Requested-With'];

    })
    .constant('myAppConfig', {
    });