/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("RegistrationController", function($scope, $location, UserService, AuthService){

        // init
        $scope.newUser = {};


        $scope.$watch('newUser.username+newUser.password+newUser.password2+newUser.eMail',function(newValue, oldValue){
            UserService.checkUsername($scope.newUser.username).success(function (result) {
                $scope.loginError = result.ok ? undefined : result.msg;
            });
        });

        $scope.register = function () {
            AuthService.register($scope.newUser).success(function (result){
                $("#registration-modal").modal("hide");
            });
        }



    });