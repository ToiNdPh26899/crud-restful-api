var myApp = angular.module("myModule", ["ngRoute"]);

myApp.config(function ($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix("");
  $routeProvider
    .when("/home", {
      templateUrl: "pages/home.html",
      controller: hienThiController,
    })
    .when("/add", {
      templateUrl: "pages/save.html",
      controller: addController,
    })
    .when("/update/:productBrandId", {
      templateUrl: "pages/update.html",
      controller: updateController,
    })
    .when("/delete", {
      templateUrl: "pages/home.html",
      controller: hienThiController,
    })
    .otherwise({ redirectTo: "/home" });
});
