'use strict';

/* Controllers */
angular.module('myApp.controllers', [])
   .controller('appController', function ($scope, myAppServices) {
      $scope.controller_text = "View 1 Controller Text";
      $scope.keywords = "";
      $scope.search_in_progress = false;
      $scope.bsr_objects = [];

        $scope.start_date = "2007-01-01";

        $scope.end_date = "2015-06-01";

        $scope.find_by_keywords = function()
      {
        setTimeout(function ()
        {
            $scope.search_in_progress = true;
            $scope.bsr_objects = [];
            myAppServices.find($scope.keywords, $scope.start_date, $scope.end_date)
                .success(function (response)
                {
                    for (var key in response) {
                        if (response.hasOwnProperty(key)) {
                            var obj = response[key];
                            $scope.bsr_objects.push(obj);
                        }
                    }
                    $scope.search_in_progress = false;
                })
                .error(function (response)
                {
                    $scope.search_in_progress = false;
                });
            }, 100);
        }

    });
