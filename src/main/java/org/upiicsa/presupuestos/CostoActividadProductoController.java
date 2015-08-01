package org.upiicsa.presupuestos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.upiicsa.logica.ILogicaInsertaCostoActividad;
import org.upiicsa.logica.IUsoMateriaPrima;
import org.upiicsa.web.Resultado;
import org.upiicsa.web.model.CostoActividadView;
import org.upiicsa.web.model.UsoMateriaPorProductoView;

@Controller
public class CostoActividadProductoController {

	@Autowired
	private ILogicaInsertaCostoActividad logica;

	@RequestMapping(value = "/CostoActividad", method = RequestMethod.GET)
	public String index() {
		return "costoActividad/index";
	}

	@RequestMapping(value = "/CostoActividad/Editar", method = RequestMethod.GET)
	public String editor(@RequestParam(value = "id", required = false) Integer id) {
		return "costoActividad/editor";
	}

	@RequestMapping(value = "/CostoActividad/inserta", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<CostoActividadView> insertaCostoActividad(@RequestBody CostoActividadView JSON) {
		Resultado<CostoActividadView> result = new Resultado<CostoActividadView>();
		try {
			logica.insertaUsoProducto(JSON);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/CostoActividad/GetIdAll", method = RequestMethod.POST)
	@ResponseBody
	public CostoActividadView getUsoActividad(@RequestBody Integer id) {
		try {
			CostoActividadView uso = logica.getByIdCostoActividad(id);
			return uso;

		} catch (Exception ex) {
			return null;
		}
	}

}
