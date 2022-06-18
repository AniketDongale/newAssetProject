package com.company.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name= "Assets",
			uniqueConstraints = @UniqueConstraint(
					                       name ="Asset_uniqueId",
					                       columnNames = "assetId"
					                       )		            
      )
public class Assets {
	
	
	@Id
	@SequenceGenerator(
			name = "asset_sequence",
			sequenceName = "asset_sequence",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "asset_sequence")
	@Column(nullable = false)
	private long assetId;
	@Column(nullable = false , length = 50 )
	private String assetName;
	
	
	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}
	public long getAssetId() {
		return assetId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
			this.assetName = assetName;
	}
}
