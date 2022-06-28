package fr.teamA.encheres.bo;

import java.io.Serializable;
import java.time.LocalDate;

public class Encheres implements Serializable {

	private static final long serialVersionUID = 1L;
	private LocalDate dateEnchere;
	private int montantEnchere;
	
	public Encheres() {
		super();
	}

	public Encheres(LocalDate dateEnchere, int montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	@Override
	public String toString() {
		return "Encheres [dateEnchere=" + dateEnchere + ", montantEnchere=" + montantEnchere + "]";
	}
	
	

}
