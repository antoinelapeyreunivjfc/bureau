

angular.module('monApp').factory('Crayons', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/crayons/:id?', { id : '@id'} );
    
}]);

angular.module('monApp').factory('Boites', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/boites/:id', { id : '@id'} );
    
}]);

angular.module('monApp').factory('Actes', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/actes/:id', { id : '@id'} );
    
}]);

angular.module('monApp').factory('Admission', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/admission/:id', { id : '@id'} );
    
}]);

angular.module('monApp').factory('UF', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/uf/:id', { id : '@code_UF'} );
    
}]);

angular.module('monApp').factory('Modalite', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/modalite/:id', { id : '@id_modalite'} );
    
}]);

angular.module('monApp').factory('CCAM', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/ccam/:id', { id : '@code_CCAM'} );
    
}]);

angular.module('monApp').factory('Images', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/images/:id', { id : '@id'} );
    
}]);