package fr.upmc.aladyn.dyn_generics.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Déclare les annotations pour les types de paramètres d'une méthode
 * @author Charles DUFOUR
 * @author Nicolas RIGNAULT
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DynamicGenericTypeParameters {
	/**
	 * Tableau des noms associés types
	 * @return le tableau
	 */
	String[] typeParams();
}
