var app = angular.module('pizzeriaStaff', ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider.when("/", {
        templateUrl: "stafflogin.html"
    })
});