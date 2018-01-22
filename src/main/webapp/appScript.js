var app = angular.module('pizzeriaApp', ["ngRoute"]);

app.service('menuService', ['$http', function ($http) {
    this.generateMenu = function () {
        return $http({
            url: '/PizzaMiniProject/PizzaMiniProject/menu',
            method: "GET",
        }).then(function (response) {
            console.log(response.data);
            return response.data;
        }, function (response) {
            return response.data;
        });
    }
}]);

app.service('loginService', ['$http', function ($http, $scope) {
    this.loginUser = function (Name, Password) {
        if (Name.length == 0 || Password.length == 0) {
            alert("Please enter the values");
        } else {
            return $http({
                url: '/PizzaMiniProject/PizzaMiniProject/valid',
                method: "POST",
                data: {
                    "username": Name,
                    "password": Password
                }
            }).then(function (response) {
                return response.data;
            }, function (response) {
                alert("Invalid credentials");
            });
        }
    }
}]);

app.service('signupService', ['$http', function ($http, $scope) {
    this.signupUser = function (name, contact, address) {
        if (name.length === 0) {
            alert("Please enter the values");
        } else {
            return $http({
                url: '/PizzaMiniProject/PizzaMiniProject/register',
                method: "POST",
                data: {
                    "name": name,
                    "contact": contact,
                    "address": address
                }
            }).then(function (response) {
                return response.data;
            }, function (response) {
                alert("Invalid values");
            });
        }
    },
    this.addUserDetails = function(custID, dob, email, password) {
        return $http({
            url: '/PizzaMiniProject/PizzaMiniProject/addregistercustomer',
            method: 'POST',
            data: {
                "customerId":custID,
                "dob":dob,
                "username": email,
                "password": password
            }
        }).then(function(response) {
            alert('Signup successful');
        }, function(response) {
            alert("Signup failure");
        });
    }
}]);

app.service('cartService', ['$http', function ($http) {
    this.generateMenu = function () {
        return $http({
            url: '/PizzaMiniProject/PizzaMiniProject/cartItems',
            method: "GET",
        }).then(function (response) {
            return response.data;
        }, function (response) {
            return response.data;
        });
    }
}]);

app.controller("cartController", function($scope, $rootScope) {
    if($rootScope.cartList === undefined) {
        document.getElementById("cartView").innerHTML = '<h1 class="text-center">Sorry! Cart is empty</h1>';
    } else if($rootScope.cartList.length === 0) {
        document.getElementById("cartView").innerHTML = '<h1 class="text-center">Sorry! Cart is empty</h1>';
    }
});

app.controller("menuController", function ($scope, $rootScope, menuService) {
    $rootScope.menuItems;
    $rootScope.vegPizzas = [];
    $rootScope.nonVegPizzas = [];
    $rootScope.vegToppings = [];
    $rootScope.nonVegToppings = [];
    $rootScope.crusts = [];
    $rootScope.combos = [];
    menuService.generateMenu().then(
        function (data) {
            $rootScope.menuItems = data;

            for (var i = 0; i < $rootScope.menuItems.length; i++) {
                if (($rootScope.menuItems[i]["category"] === "veg") &
                    ($rootScope.menuItems[i]["availability"] === 1)) {
                    $rootScope.vegPizzas
                        .push($rootScope.menuItems[i]);
                }
            }
            for (var i = 0; i < $rootScope.menuItems.length; i++) {
                if (($rootScope.menuItems[i]["category"] === "nonveg") &
                    ($rootScope.menuItems[i]["availability"] === 1)) {
                    $rootScope.nonVegPizzas
                        .push($rootScope.menuItems[i]);
                }
            }
            for (var i = 0; i < $rootScope.menuItems.length; i++) {
                if (($rootScope.menuItems[i]["category"] === "nonVegTopping") &
                    ($rootScope.menuItems[i]["availability"] === 1)) {
                    $rootScope.vegToppings
                        .push($rootScope.menuItems[i]);
                }
            }
            for (var i = 0; i < $rootScope.menuItems.length; i++) {
                if (($rootScope.menuItems[i]["category"] === "vegTopping") &
                    ($rootScope.menuItems[i]["availability"] === 1)) {
                    $rootScope.nonVegToppings
                        .push($rootScope.menuItems[i]);
                }
            }
            for (var i = 0; i < $rootScope.menuItems.length; i++) {
                if (($rootScope.menuItems[i]["category"] === "crust") &
                    ($rootScope.menuItems[i]["availability"] === 1)) {
                    $rootScope.crusts
                        .push($rootScope.menuItems[i]);
                }
            }
            for (var i = 0; i < $rootScope.menuItems.length; i++) {
                if (($rootScope.menuItems[i]["category"] === "combo") &
                    ($rootScope.menuItems[i]["availability"] === 1)) {
                    $rootScope.combos
                        .push($rootScope.menuItems[i]);
                }
            }
        });
});

app.controller("signupController", function ($scope, $rootScope, $location, loginService, signupService) {
    $scope.signUpFunc = function () {
        var name = document.getElementById("regName").value;
        var email = document.getElementById("regEmailID").value;
        var Password = document.getElementById("regPassWord").value;
        var rePassword = document.getElementById("regRePassword").value;
        var contact = document.getElementById("regContact").value;
        var dob = document.getElementById("regDoB").value;
        var address = document.getElementById("regAddress").value;
        loginService.loginUser(email, Password).then(function (data) {
            if (data !== '') {
                alert("User already exists! Please go login");
                document.getElementById("regEmailID").value = "";
                document.getElementById("regPassWord").value = "";
                document.getElementById("regRePassword").value = "";
                document.getElementById("regContact").value = "";
                document.getElementById("regDoB").value = "";
                document.getElementById("regAddress").value = "";
            } else {
                signupService.signupUser(name, contact, address).then(function (data) {
                    var custID = data;
                    signupService.addUserDetails(custID, dob, email, Password).then(function(){
                        loginService.loginUser(email,Password).then(function(data){
                            if(data === "") {
                                alert("Go to login Page");
                            }
                            else {
                                $rootScope.userName = email;
                                $rootScope.userData = data;
                                $location.path("/");
                            }
                        })
                    })
                });
            }
        });
    }
});

app.controller("loginController", function ($scope, $rootScope, $location, loginService) {
    $scope.loginFunc = function () {
        var Name = document.getElementById("loginName").value;
        var Password = document.getElementById("loginPass").value;
        loginService.loginUser(Name, Password).then(function (data) {
            if (data === '') {
                alert("Username or Password incorrect");
                $scope.password = "";
            } else {
                $rootScope.userName = $scope.username;
                $rootScope.userData = data;
                $location.path("/");
            }
        });
    }
});

app.controller("navBarController", function ($scope, $rootScope, $location) {
    if ($rootScope.userName === undefined & $rootScope.userData === undefined) {
        document.getElementById("rightList").innerHTML = '<li><a href="#cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>' +
            '<li id="signUp"><a href="#register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>' +
            '<li id=logIn><a href="#login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>';
    } else if ($rootScope.userName === "username" & $rootScope.userData === "userdata") {
        document.getElementById("rightList").innerHTML = '<li><a href="#cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>' +
            '<li id="signUp"><a href="#register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>' +
            '<li id=logIn><a href="#login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>';
    } else {
        document.getElementById("rightList").innerHTML = '<li><a href="#cart"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>' +
            '<li id="orderItem"><a href="#orders"><span></span>My Orders</a></li>' +
            '<li id="logOut"><a href="" ng-click="logoutFunc()"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>';
    }
    $scope.logoutFunc = function () {
        $rootScope.userName = "username";
        $rootScope.userData = "userdata";
        $location.path("/menu");
    }
});

app.config(function ($routeProvider) {
    $routeProvider.when("/", {
        templateUrl: "home.html"
    }).when("/menu", {
        templateUrl: "menu.html"
    }).when("/customize", {
        templateUrl: "customize.html"
    }).when("/about", {
        templateUrl: "about.html"
    }).when("/contact", {
        templateUrl: "contact.html"
    }).when("/orders", {
        templateUrl: "orders.html"
    }).when("/cart", {
        templateUrl: "cart.html"
    }).when("/register", {
        templateUrl: "register.html"
    }).when("/login", {
        templateUrl: "login.html"
    }).when("/logout", {
        templateUrl: "signout.html"
    })
});