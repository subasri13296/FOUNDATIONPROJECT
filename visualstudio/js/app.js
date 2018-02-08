(function () {
    var app = angular.module("demo", ["ngRoute"]);
    app.config(function($routeProvider, $locationProvider) {
        $locationProvider.hashPrefix("");
        $routeProvider.when("/home", {
            templateUrl: "views/home.html",
            controller: function($scope) {
                $scope.message = "Welcome to AJS Routing"
            }
        }).when("/contact", {
            template: "<h1>Contact Content</h1>"
        }).when("/about", {
            template: "<h1>About Content</h1>"
        }).otherwise({
            redirectTo: "/home"
        })
    });
})();