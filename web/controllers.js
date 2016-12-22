
angular.module('monApp')

        .controller('CrayonsController', ['Crayons',
            function (Crayons) {
                this.crayons = Crayons.query();
                this.delete = function (cr) {
                    // appel DELETE asynchrone au service web sur /crayons/{id}
                    //cr.$delete();
                    Crayons.delete(cr);
                    // remet à jour le tableau des crayons en suprimant l'élément effacé
                    this.crayons.splice(this.crayons.indexOf(cr), 1);
                };
            }
        ])

        .controller('CrayonNewController', ['Crayons',
            function (Crayons) {
                this.cr = new Crayons();
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons
                    this.cr.$save();
                };
            }])


        .controller('CrayonEditController', ['$routeParams', 'Crayons', '$location',
            function ($routeParams, Crayons, $location) {
                this.cr = Crayons.get({id: $routeParams.id});
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons/{id} 
                    this.cr.$save();
                    $location.path("/")
                };
            }
        ])

        .controller('BoitesController', ['Boites',
            function (Boites) {
                this.boites = Boites.query();
                this.delete = function (b) {
                    // appel DELETE asynchrone au service web sur /boites/{id}
                    Boites.delete(b);
                    // remet à jour le tableau local des boites en suprimant l'élément effacé
                    this.boites.splice(this.boites.indexOf(b), 1);
                };
            }
        ])

        .controller('BoiteNewController', ['Boites',
            function (Boites) {
                this.b = new Boites();
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons
                    this.b.$save();
                };
            }])

        .controller('BoiteEditController', ['$routeParams', 'Boites', '$location', 'Crayons',
            function ($routeParams, Boites, $location, Crayons) {
                var self = this;
                self.b = Boites.get({id: $routeParams.id});
                // on souhaite interroger le service web pour n'aller chercher que les crayons 
                // qui ne sont pas dans une boite, car la relation boite -> crayon est de type one to many. 
                // Pour faire cela, le service web qui écoute sur /crayons a été conçu pour pouvoir prendre un
                // paramètre ?type="sansboites" qui lui dit de faire cela. 
                // Or tous les paramètres que l'on passe à la méthode .query() ci-dessous sont ajoutés à l'URL 
                // sous la forme ?prop1=val1&prop2=val2, d'où la syntaxe utilisée 
                self.crayons = Crayons.query({type: "sansboites"});
                self.update = function () {
                    // ajoute le crayon à la liste des crayons de la boite
                    self.b.crayons.push(self.crayonSelect);
                    // supprime le crayon de la liste des crayons affectable
                    self.crayons.splice(self.crayons.indexOf(self.crayonSelect), 1);

                };
                self.deleteCrayonFromBoite = function (cr) {
                    // remet à jour le tableau des crayons de la boite en suprimant l'élément effacé
                    self.b.crayons.splice(self.b.crayons.indexOf(cr), 1);
                    // et en l'ajoutant à la liste des crayons disponibles
                    self.crayons.push(cr);
                }
                self.apply = function () {
                    // on passe la boite au service web pour qu'il la sauve dans la base de données  
                    self.b.$save();
                }
            }
        ])

        .controller('ActesController', ['Actes',
            function (Actes) {
                this.actes = Actes.query(); 
                this.delete = function (ac) {
                    // appel DELETE asynchrone au service web sur /actes/{id}
                    //ac.$delete();
                    Actes.delete(ac);
                    // remet à jour le tableau des actes en suprimant l'élément effacé
                    this.actes.splice(this.actes.indexOf(ac), 1);
                };
            }
        ])

        .controller('ActeNewController', ['Actes', 'Admission', 'UF', 'Modalites', 'CCAM',
            function (Actes, Admission, UF, Modalites, CCAM) {
                this.ac = new Actes();
                this.admission = Admission.query();
                this.uf = UF.query();
                this.modalite = Modalites.query();
                this.ccam = CCAM.query();
                this.update = function () {
                    // appel POST asynchrone au service web sur /actes
                    this.ac.admission = this.admission[this.selAdm];
                    this.ac.uf = this.uf[this.selUf];
                    this.ac.modalite = this.modalite[this.selMod];
                    this.ac.ccam= this.ccam[this.selCcam];
                    this.ac.$save();
                };
            }])

        .controller('ActeEditController', ['$routeParams', 'Actes',  'Admission', 'UF', 'Modalites', 'CCAM','$location',
            function ($routeParams, Actes, Admission, UF, Modalites, CCAM, $location) {
                this.ac = Actes.get({id: $routeParams.id});
                this.admission = Admission.query();
                this.uf = UF.query();
                this.modalite = Modalites.query();
                this.ccam = CCAM.query();
                this.update = function () {
                    // appel POST asynchrone au service web sur /actes/{id} 
                    if (typeof this.selAdm !== 'undefined') {
                        this.ac.admission = this.admission[this.selAdm];
                    }
                    if (typeof this.selUf !== 'undefined') {
                        this.ac.uf = this.uf[this.selUf];
                    }
                    if (typeof this.selMod !== 'undefined') {
                        this.ac.modalite = this.modalite[this.selMod];
                    }
                    if (typeof this.selCcam !== 'undefined') {
                        this.ac.ccam = this.ccam[this.selCcam];
                    }
                   
                    this.ac.$save();
                    $location.path("/actes");
                };
            }
        ])
        
        .controller('ActeController', ['$routeParams', 'Actes', '$location', 'Images',
            function ($routeParams, Actes, $location, Images) {
                this.acte = Actes.get({id: $routeParams.id});
                this.images = Images.query({acte: $routeParams.id});
                this.delete = function (ac) {
                    // appel DELETE asynchrone au service web sur /actes/{id}
                    //ac.$delete();
                    Actes.delete(ac);
                    $location.path("/actes");
                };
            }
        ])
        
        .controller('ImageNewController', ['$routeParams', 'Actes', '$location', 'Images',
            function ($routeParams, Actes, $location, Images) {
                this.ac = Actes.get({id: $routeParams.id});
                this.image = new Images();
                this.update = function () {
                    // appel POST asynchrone au service web sur /actes/{id}
                    this.image.acte = this.ac;
                    this.image.$save();
                    $location.path("/acte/"+this.ac.id);
                };
            }
        ])
        
        .controller('AdmissionController', ['Admission',
            function (Admission) {
                this.admissions = Admission.query();
               // this.delete = function (ad) {
                    // appel DELETE asynchrone au service web sur /actes/{id}
                    //ac.$delete();
                   // Admission.delete(ad);
                    // remet à jour le tableau des actes en suprimant l'élément effacé
                   // this.admission.splice(this.admission.indexOf(ad), 1);
               // };
            }
        ])

        .controller('AdimissionNewController', ['Admission',
            function (Admission) {
                this.ad = new Admission();
                this.update = function () {
                    // appel POST asynchrone au service web sur /actes
                    this.ad.$save();
                };
            }])


        .controller('AdmissionEditController', ['$routeParams', 'Admission', '$location',
            function ($routeParams, Admission, $location) {
                this.ad = Admission.get({id: $routeParams.id});
                this.update = function () {
                    // appel POST asynchrone au service web sur /actes/{id} 
                    this.ad.$save();
                    $location.path("/admission")
                };
            }
        ])
        
        .controller('OneAdmissionController', ['$routeParams', 'Admission', '$location', 'Actes',
            function ($routeParams, Admission, $location, Actes) {
                this.ad = Admission.get({id: $routeParams.id});
                this.actes = Actes.query({admission: $routeParams.id});
                this.delete = function (ac) {
                    // appel DELETE asynchrone au service web sur /actes/{id}
                    //ac.$delete();
                    Actes.delete(ac);
                    // remet à jour le tableau des actes en suprimant l'élément effacé
                    this.actes.splice(this.actes.indexOf(ac), 1);
                };
            }
        ])
        
      .controller('ModalitesController', ['Modalites',
            function (Modalites) {
                this.modalites = Modalites.query();
                this.delete = function (mod) {
                    // appel DELETE asynchrone au service web sur /modalites/{id}
                    //mo.$delete();
                    Modalites.delete(mod);
                    // remet à jour le tableau des modalites en suprimant l'élément effacé
                    this.modalites.splice(this.modalites.indexOf(mod), 1);
                };
            }
        ])
        .controller('ModaliteNewController', ['Modalites',
            function (Modalites) {
                this.mod = new Modalites();
                this.update = function () {
                    // appel POST asynchrone au service web sur /modalites
                    this.mod.$save();
                };
            }])

 .controller('ModaliteEditController', ['$routeParams', 'Modalites', '$location',
            function ($routeParams, Modalites, $location) {
                this.mod = Modalites.get({id: $routeParams.id});
                this.update = function () {
                    // appel POST asynchrone au service web sur /modalites/{id} 
                    this.mod.$save();
                    $location.path("/modalites");
                };
            }
        ])
        