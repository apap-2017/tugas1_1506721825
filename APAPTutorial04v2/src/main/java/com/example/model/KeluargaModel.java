package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * 
 * @author farhan.nurdaitama
 * 
 * kelas yang merpresentasikan keluarga
 *
 */
@Data
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class KeluargaModel {
	
	private int id;
	private String nomor_kk;
	private String alamat;
	private String rt;
	private String rw;
	private KelurahanModel kelurahan;
	private String id_kelurahan;
	private int is_tidak_berlaku;
	private List<PendudukModel> penduduks;

}
