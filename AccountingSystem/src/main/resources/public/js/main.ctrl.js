app.controller("MainController",['$http','$scope',function($http,$scope){



    var vm = this;

    vm.title = 'AngularJS Tutorial Example';
    vm.searchInput = '';
    vm.shows = [
        {
            title: 'Game of Thrones',
            year: 2011,
            favorite: true
        },
        {
            title: 'Walking Dead',
            year: 2010,
            favorite: false
        },
        {
            title: 'Firefly',
            year: 2002,
            favorite: true
        },
        {
            title: 'Banshee',
            year: 2013,
            favorite: true
        },
        {
            title: 'Greys Anatomy',
            year: 2005,
            favorite: false
        }
    ];
/*
     $http.get('http://localhost:8090/getReasons').
               success(function(data) {
                   vm.orders= data;
               });*/
               var error="";
               var data="";
               $http({method: 'GET', url: '/getReasons',   headers: {'Content-Type': 'application/json'}})
                   .success(function (data){
                      vm.orders= data;
                    data=data;
                   })
                   .error(function (error, status){
                       error = { message: error, status: status};
                       console.log(error);
                 });



                $http({method: 'GET', url: '/getReasons'}).
                     success(function(data, status) {
                      vm.orders= data;
                     }).
                     error(function(data, status) {
                       vm.orders = [
                               {
                                   id: 1,
                                   title: 'Year Ascending',
                                   key: 'year',
                                   reverse: false
                               },
                               {
                                   id: 2,
                                   title: 'Year Descending',
                                   key: 'year',
                                   reverse: true
                               },
                               {
                                   id: 3,
                                   title: 'Title Ascending',
                                   key: 'title',
                                   reverse: false
                               },
                               {
                                   id: 4,
                                   title: 'Title Descending',
                                   key: 'title',
                                   reverse: true
                               }
                           ];
                   });



    vm.order = vm.orders[0];
    vm.new = {};
    vm.addShow = function() {
        vm.shows.push(vm.new);
        vm.new = {};
    };
}]);

