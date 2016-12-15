
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

        .controller('ActeNewController', ['Actes', 'Admission', 'UF', 'Modalite', 'CCAM',
            function (Actes, Admission, UF, Modalite, CCAM) {
                this.ac = new Actes();
                this.admission = Admission.query();
                this.uf = UF.query();
                this.modalite = Modalite.query();
                this.ccam = CCAM.query();
                this.update = function () {
                    // appel POST asynchrone au service web sur /actes
                    this.ac.admission = this.admission[this.selAdm];
                    this.ac.UF = this.uf[this.selUf];
                    this.ac.modalite = this.modalite[this.selMod];
                    this.ac.CCAM = this.ccam[this.selCcam];
                    this.ac.$save();
                };
            }])


        .controller('ActeEditController', ['$routeParams', 'Actes', '$location', 'Admission', 'UF', 'Modalite', 'CCAM',
            function ($routeParams, Actes, $location, Admission, UF, Modalite, CCAM) {
                this.ac = Actes.get({id: $routeParams.id});
                this.admission = Admission.query();
                this.uf = UF.query();
                this.modalite = Modalite.query();
                this.ccam = CCAM.query();
                this.update = function () {
                    // appel POST asynchrone au service web sur /actes/{id} 
                    if (typeof this.selAdm !== 'undefined') {
                        this.ac.admission = this.admission[this.selAdm];
                    }
                    if (typeof this.selUF !== 'undefined') {
                        this.ac.UF = this.uf[this.selUf];
                    }
                    if (typeof this.selMod !== 'undefined') {
                        this.ac.modalite = this.modalite[this.selMod];
                    }
                    if (typeof this.selCcam !== 'undefined') {
                        this.ac.CCAM = this.ccam[this.selCcam];
                    }
                    this.ac.$save();
                    $location.path("/actes")
                };
            }
        ])
        
        .controller('AdmissionController', ['Admission',
            function (Admission) {
                this.admission = Admission.query();
                this.delete = function (ad) {
                    // appel DELETE asynchrone au service web sur /actes/{id}
                    //ac.$delete();
                    Admission.delete(ad);
                    // remet à jour le tableau des actes en suprimant l'élément effacé
                    this.admission.splice(this.admission.indexOf(ad), 1);
                };
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
        
        .controller('ModaliteController', ['Modalites',
            function (Modalites) {
                this.modalites = Modalites.query();
                this.delete = function (mo) {
                    // appel DELETE asynchrone au service web sur /crayons/{id}
                    //cr.$delete();
                    Modalites.delete(mo);
                    // remet à jour le tableau des crayons en suprimant l'élément effacé
                    this.modalites.splice(this.modalites.indexOf(mo), 1);
                };
            }
        ])
        .controller('ModaliteNewController', ['Modalites',
            function (Modalites) {
                this.mo = new Modalites();
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons
                    this.mo.$save();
                };
            }])


        .controller('ModaliteEditController', ['$routeParams', 'Modalites', '$location',
            function ($routeParams, Modalites, $location) {
                this.mo = Modalites.get({id: $routeParams.id});
                this.update = function () {
                    // appel POST asynchrone au service web sur /crayons/{id} 
                    this.mo.$save();
                    $location.path("/")
                };
            }
        ])
