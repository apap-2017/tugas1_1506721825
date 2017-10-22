package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author farhan.nurdaitama
 * 
 * kelas yang merpresentasikan kota
 *
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class KotaModel {
	
	private int id;
	private String nama_kota;
	private String kode_kota;

}
