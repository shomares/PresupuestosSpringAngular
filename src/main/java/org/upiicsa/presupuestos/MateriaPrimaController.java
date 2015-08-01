package org.upiicsa.presupuestos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.upiicsa.dao.entidades.MateriaPrima;
import org.upiicsa.logica.ILogicaInsertaProductoMateriaPrima;
import org.upiicsa.web.Resultado;
import org.upiicsa.web.model.MateriaPrimaView;

@Controller
public class MateriaPrimaController {

	@Autowired
	private ILogicaInsertaProductoMateriaPrima logica;

	@RequestMapping(value = "/MateriaPrima", method = RequestMethod.GET)
	public String index() {
		return "materiaPrima/index";
	}

	@RequestMapping(value = "/MateriaPrima/Editar", method = RequestMethod.GET)
	public String editor(@RequestParam(value = "id", required = false) Integer id) {
		return "materiaPrima/editor";
	}

	@RequestMapping(value = "/MateriaPrima/inserta", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<MateriaPrima> insertaProducto(@RequestBody MateriaPrimaView JSON) {
		Resultado<MateriaPrima> result = new Resultado<MateriaPrima>();

		MateriaPrima pr = new MateriaPrima();

		if (JSON.getId() != null )
			pr.setId(JSON.getId());

		pr.setNombre(JSON.getNombre());
		pr.setCantidadInventarioInicial(JSON.getCantidadInventarioInicial());
		pr.setCantidadInventarioFinal(JSON.getCantidadInventarioFinal());
		pr.setCostoInicial(JSON.getCostoInicial());
		pr.setCostoPresupuestado(JSON.getCostoPresupuestado());
		result.setObjeto(pr);
		try {

			if (JSON.getId() == null || JSON.getId() == 0)
				logica.insertaMateriaPrima(pr);
			else
				logica.updateMateriaPrima(pr);

			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/MateriaPrima/All", method = RequestMethod.POST)
	@ResponseBody
	public List<MateriaPrimaView> getProductos() {
		try {
			List<MateriaPrima> pr = logica.getMateriaPrimas();
			List<MateriaPrimaView> pwd = new ArrayList<MateriaPrimaView>();

			for (MateriaPrima materia : pr) {
				MateriaPrimaView pv = new MateriaPrimaView();
				pv.setNombre(materia.getNombre());
				pv.setId(materia.getId());
				pv.setCantidadInventarioInicial(materia.getCantidadInventarioInicial());
				pv.setCantidadInventarioFinal(materia.getCantidadInventarioFinal());
				pv.setCostoInicial(materia.getCostoInicial());
				pv.setCostoPresupuestado(materia.getCostoPresupuestado());
				pwd.add(pv);
			}
			System.out.println(pwd.size());
			return pwd;
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value = "/MateriaPrima/Delete", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<MateriaPrima> deleteProducto(@RequestBody Integer id) {
		Resultado<MateriaPrima> result = new Resultado<MateriaPrima>();
		result.setObjeto(null);
		try {

			logica.deleteMateriaPrima(id);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;

	}

	@RequestMapping(value = "/MateriaPrima/DeleteAll", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<MateriaPrima> deleteAll(@RequestBody Integer[] ids) {
		Resultado<MateriaPrima> result = new Resultado<MateriaPrima>();
		result.setObjeto(null);
		try {

			for (Integer id : ids)
				logica.deleteMateriaPrima(id);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;

	}

	@RequestMapping(value = "/MateriaPrima/Id", method = RequestMethod.POST)
	@ResponseBody
	public MateriaPrimaView getProductoPorId(@RequestBody Integer id) {
		MateriaPrimaView pv = logica.getMateriaPrimaPorId(id);
		return pv;
	}

}
