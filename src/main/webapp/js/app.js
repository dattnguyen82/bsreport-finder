'use strict';

angular.module('myApp', [
    'ngRoute',
    'myApp.filters',
    'myApp.services',
    'myApp.directives',
    'myApp.controllers',
    'myApp.config'
]).
config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/view1.html', controller: 'appController', public: true})
        .otherwise({redirectTo: '/'});
}]).
run(function($rootScope, $http) {

    });
