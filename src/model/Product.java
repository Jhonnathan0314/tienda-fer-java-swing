/**
 * 
 */
package model;

import java.sql.Date;

/**
 * @author JONATAN FRANCO
 *
 */
public class Product {
	//Declaracion de variables
	private int id;
	private String name;
	private int quantityAvailable;
	private float saleValue;
	private String packaging;
	private String quantityPackaging;
	private String quantityUnit;
	private Date updateDate;
	private Section section;
	
	//Metodos constructores
	public Product(int id, String name, int quantityAvailable, float saleValue, String packaging, String quantityPackaging, String quantityUnit, Date updateDate, Section section) {
		super();
		this.id = id;
		this.name = name;
		this.quantityAvailable = quantityAvailable;
		this.saleValue = saleValue;
		this.packaging = packaging;
		this.quantityPackaging = quantityPackaging;
		this.quantityUnit = quantityUnit;
		this.updateDate = updateDate;
		this.section = section;
	}
	
	public Product() { }

	//Metodos get y set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantityAvailable() {
		return quantityAvailable;
	}

	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}

	public float getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(float saleValue) {
		this.saleValue = saleValue;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getQuantityPackaging() {
		return quantityPackaging;
	}

	public void setQuantityPackaging(String quantityPackaging) {
		this.quantityPackaging = quantityPackaging;
	}

	public String getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(String quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
}
