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
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.logica.ILogicaInsertaProductoMateriaPrima;
import org.upiicsa.web.Resultado;
import org.upiicsa.web.model.ProductoView;

@Controller
public class ProductoController {

	@Autowired
	private ILogicaInsertaProductoMateriaPrima logica;

	@RequestMapping(value = "/Producto", method = RequestMethod.GET)
	public String index() {
		return "producto/index";
	}

	@RequestMapping(value = "/Producto/Editar", method = RequestMethod.GET)
	public String editor(@RequestParam(value = "id", required = false) Integer id) {
		return "producto/editor";
	}

	@RequestMapping(value = "/Producto/inserta", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<Producto> insertaProducto(@RequestBody ProductoView JSON) {
		Resultado<Producto> result = new Resultado<Producto>();

		Producto pr = new Producto();

		if (JSON.getId()!=null)
			pr.setId(JSON.getId());
		pr.setNombre(JSON.getNombre());
		pr.setCantidadInventarioInicial(JSON.getCantidadInventarioInicial());
		pr.setCantidadInventarioFinal(JSON.getCantidadInventarioFinal());
		pr.setCostoInicial(JSON.getCostoInicial());
		pr.setUnidades(JSON.getUnidades());
		result.setObjeto(pr);
		try {
			if (JSON.getId() == null)
				logica.insertaProducto(pr);
			else
				logica.updateProducto(pr);
			
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;
	}

	@RequestMapping(value = "/Producto/All", method = RequestMethod.POST)
	@ResponseBody
	public List<ProductoView> getProductos() {
		try {
			List<Producto> pr = logica.getProductos();
			List<ProductoView> pwd = new ArrayList<ProductoView>();

			for (Producto producto : pr) {
				ProductoView pv = new ProductoView();
				pv.setNombre(producto.getNombre());
				pv.setId(producto.getId());
				pv.setCantidadInventarioInicial(producto.getCantidadInventarioInicial());
				pv.setCantidadInventarioFinal(producto.getCantidadInventarioFinal());
				pv.setCostoInicial(producto.getCostoInicial());
				pv.setUnidades(producto.getUnidades());

				pwd.add(pv);
			}
			System.out.println(pwd.size());
			return pwd;
		} catch (Exception ex) {
			return null;
		}
	}

	@RequestMapping(value = "/Producto/Delete", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<Producto> deleteProducto(@RequestBody Integer id) {
		Resultado<Producto> result = new Resultado<Producto>();
		result.setObjeto(null);
		try {

			logica.deleteProducto(id);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;

	}

	@RequestMapping(value = "/Producto/DeleteAll", method = RequestMethod.POST)
	@ResponseBody
	public Resultado<Producto> deleteAll(@RequestBody Integer[] ids) {
		Resultado<Producto> result = new Resultado<Producto>();
		result.setObjeto(null);
		try {

			for (Integer id : ids)
				logica.deleteProducto(id);
			result.setResultado("OK");
		} catch (Exception ex) {
			result.setResultado(ex.getMessage());
		}
		return result;

	}

	@RequestMapping(value = "/Producto/Id", method = RequestMethod.POST)
	@ResponseBody
	public ProductoView getProductoPorId(@RequestBody Integer id) {
		ProductoView pv = logica.getProductoPorId(id);
		return pv;
	}

}
