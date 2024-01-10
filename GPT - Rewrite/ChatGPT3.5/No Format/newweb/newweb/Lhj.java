package com.newweb.model.business;

import javax.persistence.*;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.newweb.model.base.MaterialBrand;

/**
 * 铝材表
 * @author qianlong
 *
 */
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="t_lhj")
public class Lhj {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int ID;

	@Column
	private String name;  // 型材名称(如边封)

	@Column
	private String norms;  // 规格

	@ManyToOne
	@JoinColumn(name="materialbrandid")
	private MaterialBrand materialBrand;  // 所属材料品牌ID

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNorms() {
		return norms;
	}

	public void setNorms(String norms) {
		this.norms = norms;
	}

	public MaterialBrand getMaterialBrand() {
		return materialBrand;
	}

	public void setMaterialBrand(MaterialBrand materialBrand) {
		this.materialBrand = materialBrand;
	}
}
