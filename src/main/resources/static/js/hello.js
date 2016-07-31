angular.module('hello', ['ngRoute'])
        .config(function($routeProvider, $httpProvider) {

            $routeProvider.when('/', {
                templateUrl: 'home.html',
                controller: 'home',
                controllerAs: 'controller'
            }).when('/login', {
                templateUrl: 'login.html',
                controller: 'navigation',
                controllerAs: 'controller'
            }).when('/tests', {
                templateUrl: 'tests.html',
                controller: 'selenium',
                controllerAs: 'controller'
            }).otherwise('/');

            $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

        })
        .controller('home', function($http) {
            var self = this;
            $http.get('/resource/').then(function(response) {
                self.greeting = response.data;
            });
        })
        .controller('selenium', function($http) {
            var self = this;
            self.data = {};
            self.data.story = "";
            self.data.browser = "";
            self.data.session = "";
            self.data.action = "";
            self.data.image = "";
            self.userstories = [];
            self.browsers = [];
            self.sessions = [];
            self.actions = [];
            $http.get('/userstories').then(function(response) {
                self.userstories = response.data;
                self.browsers = [];
                self.sessions = [];
                self.actions = [];
                self.data.image = "";
            });
            self.story = function() {
                $http.get('/browsers/' + self.data.story).then(function(response) {
                    self.browsers = response.data;
                    self.sessions = [];
                    self.actions = [];
                    self.data.image = "";
                });
            };
            self.browser = function() {
                $http.get('/session/' + self.data.browser + "/" + self.data.story).then(function(response) {
                    self.sessions = response.data;
                    self.actions = [];
                    self.data.image = "";
                });
            };
            self.action = function() {
                $http.get('/actions/' + self.data.session).then(function(response) {
                    self.actions = response.data;
                    self.data.image = "";
                });
            };
            
            self.image = function() {
                $http.get('/image/' + self.data.action).then(function(response) {
                    self.data.image = response.data;
                });
            };
            

        })
        .controller('navigation',
                function($rootScope, $http, $location) {

                    var self = this

                    var authenticate = function(credentials, callback) {

                        var headers = credentials ? {authorization: "Basic "
                                    + btoa(credentials.username + ":" + credentials.password)
                        } : {};

                        $http.get('user', {headers: headers}).then(function(response) {
                            if (response.data.name) {
                                $rootScope.authenticated = true;
                            } else {
                                $rootScope.authenticated = false;
                            }
                            callback && callback();
                        }, function() {
                            $rootScope.authenticated = false;
                            callback && callback();
                        });

                    };

                    authenticate();
                    self.credentials = {};
                    self.login = function() {
                        authenticate(self.credentials, function() {
                            if ($rootScope.authenticated) {
                                $location.path("/");
                                self.error = false;
                            } else {
                                $location.path("/login");
                                self.error = true;
                            }
                        });
                    };
                    self.logout = function() {
                        $http.post('logout', {}).finally(function() {
                            $rootScope.authenticated = false;
                            $location.path("/");
                        });
                    };
                });