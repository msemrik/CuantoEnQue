app.controller("TabController",function(){
	var tab = this;
	tab.selectedTab=1;

    tab.setSelected = function(value){
        tab.selectedTab=value;
        if (tab.selectedTab==1)
            angular.element($('#movementController')).scope().mov.initializeTab();

    }

    tab.isSelected = function(value){
        return (tab.selectedTab===value);
    }


 });

