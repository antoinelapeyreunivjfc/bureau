

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
    return $resource('/bureau/webresources/generic/actes/:id', { id : '@id_acte'} );
    
}]);
angular.module('monApp').factory('Modalites', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/modalites/:id', { id : '@id_modalite'} );
    
}]);
angular.module('monApp').factory('Admission', ['$resource', function($resource) {
        
    //  voir https://docs.angularjs.org/api/ngResource/service/$resource pour la doc de cet objet
    return $resource('/bureau/webresources/generic/admission/:id', { id : 'IEP'} );
    
}]);