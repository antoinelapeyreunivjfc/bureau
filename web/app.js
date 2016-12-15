/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('monApp', ['ngRoute', 'ngResource']);

angular.module('monApp').config(['$routeProvider', function routeConfig($routeProvider) {
        $routeProvider
                .when('/crayons', {
                    controller: "CrayonsController as ctrl",
                    templateUrl: 'listeCrayon.html'
                })
                .when('/crayon/edit/:id', {
                    controller: "CrayonEditController as ctrl",
                    templateUrl: 'editCrayon.html'
                })
                .when('/crayon/new', {
                    controller: "CrayonNewController as ctrl",
                    templateUrl: 'newCrayon.html'
                })
                .when('/boites', {
                    controller: "BoitesController as ctrl",
                    templateUrl: 'listeBoites.html'
                })
                .when('/boite/edit/:id', {
                    controller: "BoiteEditController as ctrl",
                    templateUrl: 'editBoite.html'
                })
                .when('/boite/new', {
                    controller: "BoiteNewController as ctrl",
                    templateUrl: 'newBoite.html'
                })
                .when('/actes', {
                    controller: "ActesController as ctrl",
                    templateUrl: 'listeActes.html'
                })
                .when('/acte/new', {
                    controller: "ActeNewController as ctrl",
                    templateUrl: 'newActe.html'
                })
                .when('/acte/edit/:id', {
                    controller: "ActeEditController as ctrl",
                    templateUrl: 'editActe.html'
                })
                  .when('/modalites', {
                    controller: "ModalitesController as ctrl",
                    templateUrl: 'listeModalites.html'
                })
                .when('/modalite/new', {
                    controller: "ModaliteNewController as ctrl",
                    templateUrl: 'newModalite.html'
                })
                 .when('/modalite/edit/:id', {
                    controller: "ModaliteEditController as ctrl",
                    templateUrl: 'editModalite.html'
                })
<<<<<<< HEAD
                .when('/admission', {
                    controller: "AdmissionController as ctrl",
                    templateUrl: 'listeAdmission.html'
                })
               
=======
                .when('/modalite/new', {
                    controller: "ModaliteNewController as ctrl",
                    templateUrl: 'newModalite.html'
                })
>>>>>>> parent of 2fdb44c... gyutuk
                .otherwise({redirectTo: '/crayons'});
    }]);

