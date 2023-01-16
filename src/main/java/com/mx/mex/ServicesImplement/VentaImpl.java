package com.mx.mex.ServicesImplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.mex.Dto.Venta;
import com.mx.mex.Repository.IVentaRepository;
import com.mx.mex.Services.IVenta;

@Service
public class VentaImpl implements IVenta {

	@Autowired
	private IVentaRepository venta;
	
@Override
	public List<Venta> venta() {
		// TODO Auto-generated method stub
		return venta.venta();
	}

}
