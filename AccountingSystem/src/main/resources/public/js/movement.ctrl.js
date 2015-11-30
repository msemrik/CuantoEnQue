app.controller("MovementController",function($q,$http,$scope,$filter){

   var mv= this;
   mv.title='Create new movement'
   mv.amount=''
   mv.comment=''
   mv.getReasons = function(){
       var temp = {};
       var defer = $q.defer();

                      $http({method: 'GET', url: 'http://localhost:8090/getReasons'})
                          .success(function(data, status, headers, config) {
                              defer.resolve(data);
                          }).error(function(data, status) {
                              defer.reject('ERROR');
                          });

       return defer.promise;
   };

   mv.getAccounts = function(){
       var temp = {};
       var defer = $q.defer();

                      $http({method: 'GET', url: 'http://localhost:8090/getAccounts'})
                          .success(function(data, status, headers, config) {
                              defer.resolve(data);
                          }).error(function(data, status) {
                              defer.reject('ERROR');
                          });

       return defer.promise;
   };

   mv.getCurrencies = function(){
       var temp = {};
       var defer = $q.defer();

                      $http({method: 'GET', url: 'http://localhost:8090/getCurrencies'})
                          .success(function(data, status, headers, config) {
                              defer.resolve(data);
                          }).error(function(data, status) {
                              defer.reject('ERROR');
                          });

       return defer.promise;
   };



    var reasonPromise = mv.getReasons();
    reasonPromise.then(function(resolve){
                mv.reasons=resolve;
                mv.reason=mv.reasons[0];

                }, function(reject){
                });


    var accountPromise = mv.getAccounts();
    accountPromise.then(function(resolve){
                mv.accountsdest=resolve;
                mv.accountdest=mv.accountsdest[0];
                mv.accountsorig=mv.accountsdest;
                mv.accountorig=mv.accountsorig[0];
                }, function(reject){
                });

    var currenciesPromise = mv.getCurrencies();
    currenciesPromise.then(function(resolve){
                mv.currencies=resolve;
                mv.currency=mv.currencies[0]

                }, function(reject){
                });

				
	mv.date = new Date();
	mv.actualDate=true;
	

    mv.new = {};
	
    mv.addNewMovement = function(valid) {
		
		if(mv.actualDate){
			date= new Date();
		}	
		
        var movementPromise = mv.createMovement(mv.accountorig.id,mv.accountdest.id,10,mv.currency.id,mv.date,mv.reason.id,mv.comment);
        movementPromise.then(function(resolve){
                                if($scope.mostrarAlert==true)
                                alert('mostrando alerta, estuvo bien guardado');
                                else{alert('failed resolved');}
                                }, function(reject){
                                alert('failed rejected');
                                })
    };

    mv.createMovement = function(originAccount, destAccount, amount, currency, date, reason, comment){
       
	   var temp = {};
       var defer = $q.defer();
	   $scope.mostrarAlert=false;
	   $http({method: 'PUT', url: 'http://localhost:8090/createMovement'
			, data: JSON.stringify({"origAccount":originAccount,"destAccount":destAccount,"amount":amount,"currency":currency,"movementDate":date,"reason":reason,"comment":comment})})
                          .success(function(data, status, headers, config) {
                              if(data.statusCode=="OK")
                                    $scope.mostrarAlert=true;
                              defer.resolve(data);
                          }).error(function(data, status) {
                              defer.reject('ERROR');
                          });
       return defer.promise;
   };
   
   
   mv.updateDate = function (event,id){
	   
	   if(event.target.checked)
	   {mv.date=new Date();
		$("#date").removeAttr('required');
	   }
	   else {
		   $("#date").attr('required', true);
	   }
	   
	   
   };

});

