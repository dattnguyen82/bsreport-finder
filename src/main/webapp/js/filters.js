'use strict';

/* Filters */

angular.module('myApp.filters', [])
    .filter('currentdate', ['$filter', function ($filter) {
        return function () {
            return $filter('date')(new Date(), 'yyyy-MM-dd');
        };
    }]);
