'use strict';

angular.module('myApp.services', ['myApp.config'])
    .factory('myAppServices', function ($http, myAppConfig) {
      var base = {};

      var serviceUrl = 'https://bsreport-finder.herokuapp.com/get';
        base.find_by_keywords = function(keywords) {
            return $http({
                method: 'GET',
                url:serviceUrl+'?keys='+keywords
            });
        }
        return base;
    });
