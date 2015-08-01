package org.upiicsa.presupuestos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.Configuracion;
import org.upiicsa.web.Resultado;
import org.upiicsa.web.model.ConfiguracionView;

@Controller
public class ConfiguracionControlller {

	@Autowired
	@Qualifier(value = "daoConfiguracion")
	private IDao<Configuracion> dao;

	@RequestMapping(value = "/Configuracion", method = RequestMethod.GET)
	public String index() {
		return "configuracion/index";
	}

	@ResponseBody
	@RequestMapping(value = "/Configuracion/Get", method = RequestMethod.POST)
	public ConfiguracionView getConfiguracion() {
		List<Configuracion> conf = dao.getAll();
		Configuracion config = new Configuracion();
		ConfiguracionView configV;
		if (conf.isEmpty()) {
			config = new Configuracion();
			dao.insertorUpdate(config);
		} else
			config = conf.get(0);

		configV = new ConfiguracionView();
		configV.setId(config.getId());
		configV.setPorcientoCostoProduccionXVenta(config.getPorcientoCostoProduccionXVenta());

		configV.setMontoAdministracion(config.getGastoAdministracion());
		configV.setMontoVenta(config.getGastoVentas());

		configV.setCostoMantenimiento(config.getCostoMantenimiento());
		configV.setCostoAlmacen(config.getCostoAlmacen());

		configV.setNumeroValesAlmacen(config.getNumeroValesAlmacen());
		configV.setNumeroValesMantenimiento(config.getNumeroValesMantenimiento());
		configV.setNumeroValesAlmacenManto(config.getNumeroValesAlmacenManto());

		configV.setVentasDePeriodo(config.getVentasDePeriodo());
		configV.setProcientoPagoCompra(config.getProcientoPagoCompra());
		configV.setReparticionDividendos(config.getReparticionDividendos());

		return configV;
	}

	@RequestMapping(value = "/Configuracion/inserta", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<Configuracion> insert(@RequestBody ConfiguracionView config) {
		Resultado<Configuracion> result = new Resultado<Configuracion>();

		try {
			Configuracion configV = new Configuracion();
			configV.setId(config.getId());
			configV.setPorcientoCostoProduccionXVenta(config.getPorcientoCostoProduccionXVenta());

			configV.setGastoAdministracion(config.getMontoAdministracion());
			configV.setGastoVentas(config.getMontoVenta());

			configV.setCostoAlmacen(config.getCostoAlmacen());
			configV.setCostoMantenimiento(config.getCostoMantenimiento());
			configV.setNumeroValesAlmacen(config.getNumeroValesAlmacen());
			configV.setNumeroValesMantenimiento(config.getNumeroValesMantenimiento());
			configV.setNumeroValesAlmacenManto(config.getNumeroValesAlmacenManto());

			configV.setVentasDePeriodo(config.getVentasDePeriodo());
			configV.setProcientoPagoCompra(config.getProcientoPagoCompra());
			configV.setReparticionDividendos(config.getReparticionDividendos());

			dao.insertorUpdate(configV);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;

	}

}
