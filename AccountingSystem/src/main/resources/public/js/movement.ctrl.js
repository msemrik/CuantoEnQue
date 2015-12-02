app.controller("MovementController",function($q,$http,$scope,$filter,alertsManager){

   var mv= this; 
   
   //function declaration
   mv.getCategories = function(){
       var temp = {};
       var defer = $q.defer();

                      $http({method: 'GET', url: 'http://localhost:8090/getCategories'})
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
   mv.initializeTab = function (){
	
	
    var categoriesPromise = mv.getCategories();
    categoriesPromise.then(function(resolve){
                mv.categories=resolve;
                mv.category=mv.categories[0];

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
   
   mv.updateDate = function (event,id){
	   
	   if(event.target.checked)
	   {mv.date=new Date();
		$("#date").removeAttr('required');
	   }
	   else {
		   $("#date").attr('required', true);
	   }
	   
	   
   };
	};
   mv.addNewMovement = function(valid) {
		if(true)
            $scope.toggleModal({title:'Title',message:'Message',button:{text: 'close',function:'cerrar'}});
		if(!mv.isFormValid(true))
			return ;
		if(mv.actualDate){
			date= new Date();
		}
		
        var movementPromise = mv.createMovement(mv.accountorig.id,mv.accountdest.id,10,mv.currency.id,mv.date,mv.reason.id,mv.comment);
        movementPromise.then(function(resolve){
                                var object;
								if($scope.mostrarAlert==true)
									object={Id:'movId', TypeOfMovement:'MovementController', Message:'Movement Successfully Saved', Style: 'alert-success'};	
                                else
									object={Id:'movId', TypeOfMovement:'MovementController', Message:'Error Saving Movement', Style: 'alert-error'};							
                                alertsManager.addAlert(object);}
								, function(reject){
								object={Id:'movId', TypeOfMovement:'MovementController', Message:'Connection problem, please retry', Style: 'alert-error'};							
                                })
    };		
	//initilize function
	mv.initializeTab()	

	mv.isValid=false;

	
	mv.isFormValid = function (showAlerts){
		mv.isValid=true;
		if(!$scope.addMovement.$valid)
		{	mv.isValid=false;
		}
		if(mv.accountorig.id === mv.accountdest.id)
		{mv.isValid=false;
		 if(showAlerts)
			alert("Origin and Destination Account shouldn't be the same");
		}
		
		return mv.isValid;
		
	};
	
});

