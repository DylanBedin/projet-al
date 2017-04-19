package model;

public class IndexForbiddenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IndexForbiddenException(){
		super("Il est interdit de supprimer les figures par défaut");
	}
	
}
