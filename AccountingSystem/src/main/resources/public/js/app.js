var app = angular.module('app', ['ui.bootstrap']);


app.filter('datetime1', function($filter)
{
 return function(input)
 {
  if(input == null){ return ""; } 
 
  var _date = $filter('date')(new Date(input),
                              'MM/dd/yyyy - HH:mm');
 
  return _date.toUpperCase();

};
});