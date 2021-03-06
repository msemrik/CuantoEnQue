app.controller("AlertsCtrl",function($scope, $http, $log, alertsManager){
	var alert = this;

	alert.clearAlerts = function(){
		alertsManager.clearAlerts();
	}

	alert.revert = function(id,typeOfMovement){
		alertsManager.clearAlerts();
	}
	$scope.alerts = alertsManager.alerts;
	
	$scope.open = function(){
      console.log('DialogDemoCtrl - opened');
    }
	
	
	$scope.showModal = false;


});


app.factory('alertsManager', function() {
    return {
        alerts: {},
        addAlert: function(jsonMessage) {
            for(var x in this.alerts) {
				delete this.alerts[x];
			}
			this.alerts[jsonMessage.Style] = this.alerts[jsonMessage.Style] || [];
            this.alerts[jsonMessage.Style].push(jsonMessage);
        },
        clearAlerts: function() {
            for(var x in this.alerts) {
           delete this.alerts[x];
        }
        }
    };
});


app.factory('modalManager', function($scope ) {
    return {
    showModal: function(jsonMessage) {
                        $scope.modalTitle='Prueba Titulo';
                		$scope.modalMessage='Prueba Mensaje';
                		$scope.showModal = !$scope.showModal;
            }
    };
	    });