(function () {
    'use strict';

    angular
        .module('app')
        .controller('UsersController', UsersController);

    UsersController.$inject = ['$http'];

    function UsersController($http) {
        var vm = this;

        vm.users = [];
        vm.getAll = getAll;
        vm.getLogin = getLogin;
        vm.deleteU = deleteU;
        vm.getAllActive = getAllActive;
        vm.getAllNActive = getAllNActive;

        init();

        function init(){
            getAllActive();
        }

        function getAll(){
            var url = "/Users/all";
            var usersPromise = $http.get(url);
            usersPromise.then(function(response){
                vm.users = response.data;
            });
        }
        function getAllActive(){
            var url = "/Users/active";
            var usersPromise = $http.get(url);
            usersPromise.then(function(response){
                vm.users = response.data;
            });
        }
        function getAllNActive(){
            var url = "/Users/notactive";
            var usersPromise = $http.get(url);
            usersPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function getLogin(login){
            var url = "/Users/find/" + login;
            var usersPromise = $http.get(url);
            usersPromise.then(function(response){
                vm.users = response.data;
            });
        }

        function deleteU(id){
            var url = "/Users/delete/" + id;
            $http.post(url).then(function(response){
                vm.users = response.data;
            });
        }
    }
})();
