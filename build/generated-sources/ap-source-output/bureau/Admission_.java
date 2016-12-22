package bureau;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Admission.class)
public abstract class Admission_ {

	public static volatile SingularAttribute<Admission, String> IPP_patient;
	public static volatile SingularAttribute<Admission, String> nom_patient;
	public static volatile SingularAttribute<Admission, String> prenom_patient;
	public static volatile SingularAttribute<Admission, Integer> IEP;
	public static volatile ListAttribute<Admission, Acte> actes;

}

