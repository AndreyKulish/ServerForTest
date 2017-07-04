var app = angular.module("serverApp", []);

app.controller("AppCtrl", function($scope, $http) {

    $scope.websites = [];
    $scope.provider = [];

    $http.get('http://localhost:8088/data').then(function (response){
        $scope.websites = response.data;
    });

    $scope.aAddFunction = function( iconImageUrlForFunction,websiteForFunction,titleForFunction,descriptionForFunction) {
        whotForAdd = [{id:idForFunction }, {iconImageUrl : iconImageUrlForFunction},{website : websiteForFunction},{title : titleForFunction},{description : descriptionForFunction}];

        $scope.iconImageUrl = iconImageUrlForFunction;
        $scope.website = websiteForFunction;
        $scope.title = titleForFunction;
        $scope.description = descriptionForFunction;

        $http.get("http://localhost:8099/api/provider/add?iconImageUrl=" +
            $scope.iconImageUrl + "&website=" +
            $scope.website + "&title=" +
            $scope.title + "&description=" +
            $scope.description
        ).then(function (responce) {
            $scope.websites.push(responce.data);
        });
    }

    $scope.addFunction = function (URL){

        var xhr = new XMLHttpRequest();

        var body =
            'URL=' + encodeURIComponent(URL)
            + '&MIN_SIZE=' + encodeURIComponent(MIN_SIZE)
            + '&MAX_SIZE=' + encodeURIComponent(MAX_SIZE)
            + '&PERIOD_MONITORING_SEC=' + encodeURIComponent(PERIOD_MONITORING_SEC)
            + '&TIME_RESPONSE_OK=' + encodeURIComponent(TIME_RESPONSE_OK)
            + '&TIME_RESPONSE_WARNING=' + encodeURIComponent(TIME_RESPONSE_WARNING)
            + '&TIME_RESPONSE_CRITICAL=' + encodeURIComponent(TIME_RESPONSE_CRITICAL)
        ;

        xhr.open("POST", '/add', true)
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')

        xhr.send(body).then(function (responce) {
            $scope.websites.push(responce.data);
        });
        $scope.URL = "";
        $scope.MIN_SIZE = "";
        $scope.MAX_SIZE = "";
        $scope.PERIOD_MONITORING_SEC = "";
        $scope.TIME_RESPONSE_OK = "";
        $scope.TIME_RESPONSE_WARNING = "";
        $scope.TIME_RESPONSE_CRITICAL = "";
    }

    $scope.startFunction = function (){

        var xhr = new XMLHttpRequest();

        var body = 'FLAG=' + encodeURIComponent("START");

        xhr.open("POST", '/RunWorkerServlet', true)
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')

        xhr.send(body);
    }

    $scope.stopFunction = function (){

        var xhr = new XMLHttpRequest();

        var body = 'FLAG=' + encodeURIComponent("STOP");

        xhr.open("POST", '/RunWorkerServlet', true)
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')

        xhr.send(body);
    }

});