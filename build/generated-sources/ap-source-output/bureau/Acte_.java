package bureau;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Acte.class)
public abstract class Acte_ {

	public static volatile SingularAttribute<Acte, Integer> id;
	public static volatile SingularAttribute<Acte, CCAM> ccam;
	public static volatile SingularAttribute<Acte, Boolean> passage_factu;
	public static volatile SingularAttribute<Acte, Modalite> modalite;
	public static volatile SingularAttribute<Acte, UF> uf;
	public static volatile SingularAttribute<Acte, Admission> admission;
	public static volatile SingularAttribute<Acte, String> heure;
	public static volatile ListAttribute<Acte, Images> images;
	public static volatile SingularAttribute<Acte, String> date;
	public static volatile SingularAttribute<Acte, Boolean> passage_pp;

}

