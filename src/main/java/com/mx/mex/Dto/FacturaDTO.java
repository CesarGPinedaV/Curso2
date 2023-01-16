package com.mx.mex.Dto;

public class FacturaDTO {

	private int comprobanteLugarExpedicion;
	private String comprobanteFolio;
	private String comprobanteSerie;
	private String comprobanteMetodoPago;
	private String comprobanteMoneda;
	private String comprobanteExportacion;
	private String comprobanteFormaPago;

	//conceptos
	private String objetoImp;//no pudo se int e posta no respetaba los 0 ants del 1
	private String descripcion;
	private int catidad;
	private int valosUitario;
	private int importe;
	private String claveProd;// este tambien
	private String claveUnidad;
	
    //trasladados
    private int base;
    private int impuesto;
    private String tipoFactor;
    private String tasaCuota;
    private int tImporte;
       
    //traslados
        private int trasladosBase;
        private int trasladosImpuesto;
        private String trasladosTipoFactor;
        private String trasladosTasaCuota;
        private int trasladosImporte;
        
        //comprobante
        private int subtotal;
        private int total;
        
        //
        private String calle;
        private String noExterior;
        private String noInterior;
        private String colonia;
        private String localidad;
        private String municipio;
        private String estado;
        private String pais;
        private String rfc;
        private String nombre;
        private String domicilioFiscal;
        private String cp;
        private String correo;
        private String regimenFiscal;
        private String cfdi;
        private int  pdf;
        private int xml;
	
	public int getComprobanteLugarExpedicion() {
		return comprobanteLugarExpedicion;
	}
	public void setComprobanteLugarExpedicion(int comprobanteLugarExpedicion) {
		this.comprobanteLugarExpedicion = comprobanteLugarExpedicion;
	}
	public String getComprobanteFolio() {
		return comprobanteFolio;
	}
	public void setComprobanteFolio(String comprobanteFolio) {
		this.comprobanteFolio = comprobanteFolio;
	}
	public String getComprobanteSerie() {
		return comprobanteSerie;
	}
	public void setComprobanteSerie(String comprobanteSerie) {
		this.comprobanteSerie = comprobanteSerie;
	}
	public String getComprobanteMetodoPago() {
		return comprobanteMetodoPago;
	}
	public void setComprobanteMetodoPago(String comprobanteMetodoPago) {
		this.comprobanteMetodoPago = comprobanteMetodoPago;
	}
	public String getComprobanteMoneda() {
		return comprobanteMoneda;
	}
	public void setComprobanteMoneda(String comprobanteMoneda) {
		this.comprobanteMoneda = comprobanteMoneda;
	}
	public String getComprobanteExportacion() {
		return comprobanteExportacion;
	}
	public void setComprobanteExportacion(String comprobanteExportacion) {
		this.comprobanteExportacion = comprobanteExportacion;
	}
	public String getComprobanteFormaPago() {
		return comprobanteFormaPago;
	}
	public void setComprobanteFormaPago(String comprobanteFormaPago) {
		this.comprobanteFormaPago = comprobanteFormaPago;
	}
	public String getObjetoImp() {
		return objetoImp;
	}
	public void setObjetoImp(String objetoImp) {
		this.objetoImp = objetoImp;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCatidad() {
		return catidad;
	}
	public void setCatidad(int catidad) {
		this.catidad = catidad;
	}
	public int getValosUitario() {
		return valosUitario;
	}
	public void setValosUitario(int valosUitario) {
		this.valosUitario = valosUitario;
	}
	public int getImporte() {
		return importe;
	}
	public void setImporte(int importe) {
		this.importe = importe;
	}
	public String getClaveProd() {
		return claveProd;
	}
	public void setClaveProd(String claveProd) {
		this.claveProd = claveProd;
	}
	public String getClaveUnidad() {
		return claveUnidad;
	}
	public void setClaveUnidad(String claveUnidad) {
		this.claveUnidad = claveUnidad;
	}
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public int getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(int impuesto) {
		this.impuesto = impuesto;
	}
	public String getTipoFactor() {
		return tipoFactor;
	}
	public void setTipoFactor(String tipoFactor) {
		this.tipoFactor = tipoFactor;
	}
	public String getTasaCuota() {
		return tasaCuota;
	}
	public void setTasaCuota(String tasaCuota) {
		this.tasaCuota = tasaCuota;
	}
	public int gettImporte() {
		return tImporte;
	}
	public void settImporte(int tImporte) {
		this.tImporte = tImporte;
	}
	public int getTrasladosBase() {
		return trasladosBase;
	}
	public void setTrasladosBase(int trasladosBase) {
		this.trasladosBase = trasladosBase;
	}
	public int getTrasladosImpuesto() {
		return trasladosImpuesto;
	}
	public void setTrasladosImpuesto(int trasladosImpuesto) {
		this.trasladosImpuesto = trasladosImpuesto;
	}
	public String getTrasladosTipoFactor() {
		return trasladosTipoFactor;
	}
	public void setTrasladosTipoFactor(String trasladosTipoFactor) {
		this.trasladosTipoFactor = trasladosTipoFactor;
	}
	public String getTrasladosTasaCuota() {
		return trasladosTasaCuota;
	}
	public void setTrasladosTasaCuota(String trasladosTasaCuota) {
		this.trasladosTasaCuota = trasladosTasaCuota;
	}
	public int getTrasladosImporte() {
		return trasladosImporte;
	}
	public void setTrasladosImporte(int trasladosImporte) {
		this.trasladosImporte = trasladosImporte;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNoExterior() {
		return noExterior;
	}
	public void setNoExterior(String noExterior) {
		this.noExterior = noExterior;
	}
	public String getNoInterior() {
		return noInterior;
	}
	public void setNoInterior(String noInterior) {
		this.noInterior = noInterior;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDomicilioFiscal() {
		return domicilioFiscal;
	}
	public void setDomicilioFiscal(String domicilioFiscal) {
		this.domicilioFiscal = domicilioFiscal;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getRegimenFiscal() {
		return regimenFiscal;
	}
	public void setRegimenFiscal(String regimenFiscal) {
		this.regimenFiscal = regimenFiscal;
	}
	public String getCfdi() {
		return cfdi;
	}
	public void setCfdi(String cfdi) {
		this.cfdi = cfdi;
	}
	public int getPdf() {
		return pdf;
	}
	public void setPdf(int pdf) {
		this.pdf = pdf;
	}
	public int getXml() {
		return xml;
	}
	public void setXml(int xml) {
		this.xml = xml;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	
	
	
}
