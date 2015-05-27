'use strict';

angular.module('myApp.services', ['myApp.config'])
    .factory('myAppServices', function ($http, myAppConfig) {
      var base = {};

      var serviceUrl = 'https://bsreport-finder.herokuapp.com/get';
        base.find = function(keywords,start_date,end_date) {

            var query=""

            if (keywords!=null)
            {
                query+="keys="+keywords;
            }

            if (start_date!=null)
            {
                query+="&start_date="+start_date;
            }

            if (end_date!=null)
            {
                query+="&end_date="+end_date;
            }

            return $http({
                method: 'GET',
                url:serviceUrl+'?'+query
            });
        }
        return base;
    });
