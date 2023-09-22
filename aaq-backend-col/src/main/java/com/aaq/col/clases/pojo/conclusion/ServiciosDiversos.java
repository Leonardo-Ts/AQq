package com.aaq.col.clases.pojo.conclusion;

import java.io.Serializable;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ServiciosDiversos  implements Serializable {
		
	private static final long serialVersionUID = -4609109980263827008L;
	
		private List<Coberturas> coberturas;
		private List<Reparacion> reparacion;
		private List<Grua> solicitarGrua;
		private List<PaseMedico> paseMedico;
		private List<Abogado> abogados;

		@SuppressWarnings("unused")
		private JRDataSource coberturasD;
		@SuppressWarnings("unused")
		private JRDataSource reparacionD;
		@SuppressWarnings("unused")
		private JRDataSource paseMedicoD;
		@SuppressWarnings("unused")
		private JRDataSource solicitarGruaD;
		@SuppressWarnings("unused")
		private JRDataSource abogadosD;
		
		
		public List<Reparacion> getReparacion() {
			return reparacion;
		}
		public void setReparacion(List<Reparacion> reparacion) {
			this.reparacion = reparacion;
		}
		public List<Grua> getSolicitarGrua() {
			return solicitarGrua;
		}
		public void setSolicitarGrua(List<Grua> solicitarGrua) {
			this.solicitarGrua = solicitarGrua;
		}
		public List<PaseMedico> getPaseMedico() {
			return paseMedico;
		}
		public void setPaseMedico(List<PaseMedico> paseMedico) {
			this.paseMedico = paseMedico;
		}
		
		public List<Abogado> getAbogados() {
			return abogados;
		}
		public void setAbogados(List<Abogado> abogados) {
			this.abogados = abogados;
		}
		
		public List<Coberturas> getCoberturas() {
			return coberturas;
		}
		public void setCoberturas(List<Coberturas> coberturas) {
			this.coberturas = coberturas;
		}
	///*******************JRBeanCollectionDataSource*************************/
	
		public JRDataSource getCoberturasD() {
			return new JRBeanCollectionDataSource(this.coberturas);
		}
		public void setCoberturasD(JRDataSource coberturasD) {
			this.coberturasD = coberturasD;
		}
		
		public JRDataSource getReparacionD() {
			return new JRBeanCollectionDataSource(this.reparacion);
		}
		public void setReparacionD(JRDataSource reparacionD) {
			this.reparacionD = reparacionD;
		}
		
		public JRDataSource getPaseMedicoD() {
			return new JRBeanCollectionDataSource(this.paseMedico);
		}
		public void setPaseMedicoD(JRDataSource paseMedicoD) {
			this.paseMedicoD = paseMedicoD;
		}
		
		public JRDataSource getSolicitarGruaD() {
			return new JRBeanCollectionDataSource(this.solicitarGrua);
		}
		public void setSolicitarGruaD(JRDataSource solicitarGruaD) {
			this.solicitarGruaD = solicitarGruaD;
		}
		
		public JRDataSource getAbogadosD() {
			return new JRBeanCollectionDataSource(this.abogados);
		}
		public void setAbogadosD(JRDataSource abogadosD) {
			this.abogadosD = abogadosD;
		}


}
