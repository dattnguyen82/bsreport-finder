'use strict';

/* Controllers */
angular.module('myApp.controllers', [])
   .controller('appController', function ($scope, myAppServices) {
      $scope.controller_text = "View 1 Controller Text";
      $scope.keywords = "";
      $scope.search_in_progress = false;
      $scope.bsr_objects = [];

      $scope.find_by_keywords = function()
      {
        setTimeout(function ()
        {
            $scope.search_in_progress = true;
            $scope.bsr_objects = [];
            myAppServices.find_by_keywords($scope.keywords)
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
