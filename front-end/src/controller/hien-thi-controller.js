window.hienThiController = function ($scope, $rootScope, $http, $location) {
  $scope.listHienThi = [];
  $scope.listCategory = [];
  $rootScope.listBrand = [];
  $rootScope.listStatus = [];
  $rootScope.listSubCategory = [];

  $http.get(subCategorysAPI).then(function (response) {
    if (response.status === 200) {
      $rootScope.listSubCategory = response.data;
    }
  });

  $http.get(productsAPI).then(function (response) {
    if (response.status === 200) {
      $scope.listHienThi = response.data;
    }
  });

  $http.get(categorysAPI).then(function (response) {
    if (response.status === 200) {
      $scope.listCategory = response.data;
    }
  });

  $http.get(brandsAPI).then(function (response) {
    if (response.status === 200) {
      $rootScope.listBrand = response.data;
    }
  });

  $http.get(statusAPI).then(function (response) {
    if (response.status === 200) {
      $rootScope.listStatus = response.data;
    }
  });

  console.log($scope.listStatus);

  $scope.deleteProduct = function (event, productBrandId, productId) {
    event.preventDefault();

    console.log(productBrandId, productId);
    $http
      .delete(productsAPI + "/" + productBrandId + "/" + productId)
      .then(function (response) {
        alert("Xoa thanh cong");
        $http.get(productsAPI).then(function (response) {
          if (response.status === 200) {
            $scope.listHienThi = response.data;
          }
        });
        $location.path("/home");
      });
  };
};
