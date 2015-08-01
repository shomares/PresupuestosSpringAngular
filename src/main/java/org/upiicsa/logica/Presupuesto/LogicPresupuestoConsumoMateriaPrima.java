package org.upiicsa.logica.Presupuesto;

import java.util.ArrayList;
import java.util.List;

import org.upiicsa.dao.IDao;
import org.upiicsa.dao.IDaoPresupuesto;
import org.upiicsa.dao.entidades.Producto;
import org.upiicsa.dao.entidades.UsoMateriaPrima;
import org.upiicsa.web.model.MateriaPrimaView;
import org.upiicsa.web.model.ProductoView;
import org.upiicsa.web.model.Presupuesto.ConsumoMateriaPrima.PresupuestoConsumoMateriaPrima;
import org.upiicsa.web.model.Presupuesto.ConsumoMateriaPrima.PresupuestoConsumoMateriaPrimaFila;
import org.upiicsa.web.model.Presupuesto.ConsumoMateriaPrima.PresupuestoConsumoMateriaXMateria;
import org.upiicsa.web.model.Presupuesto.ConsumoMateriaPrima.PresupuestoXMateriaPrima;
import org.upiicsa.web.model.Presupuesto.Produccion.PresupuestoProduccion;

public class LogicPresupuestoConsumoMateriaPrima extends PresupuestoAbstract {

	private IDao<Producto> daoProducto;
	private IDaoPresupuesto daoPresupuesto;
	private LogicPresupuestoProduccion entrada;

	public IDao<Producto> getDaoProducto() {
		return daoProducto;
	}

	public void setDaoProducto(IDao<Producto> daoProducto) {
		this.daoProducto = daoProducto;
	}

	public LogicPresupuestoProduccion getEntrada() {
		return entrada;
	}

	public void setEntrada(LogicPresupuestoProduccion entrada) {
		this.entrada = entrada;
	}

	public LogicPresupuestoConsumoMateriaPrima() {
	}

	@Override
	public void calcular() {
		PresupuestoConsumoMateriaPrima salida = new PresupuestoConsumoMateriaPrima();
		// TODO Auto-generated method stub
		List<Producto> productos = daoProducto.getAll();
		List<PresupuestoConsumoMateriaPrimaFila> lista = new ArrayList<PresupuestoConsumoMateriaPrimaFila>();
		List<PresupuestoXMateriaPrima> consumoMateriaPrima = new ArrayList<PresupuestoXMateriaPrima>();
		ProductoView pw;
		Float i = 0.0f;
		for (Producto producto : productos) {
			PresupuestoConsumoMateriaPrimaFila fila = new PresupuestoConsumoMateriaPrimaFila();
			List<PresupuestoConsumoMateriaXMateria> arreglo = new ArrayList<PresupuestoConsumoMateriaXMateria>();
			Producto finalp = daoPresupuesto.getProductoById(producto.getId());
			PresupuestoProduccion presupuesto = (PresupuestoProduccion) entrada.getSalida();
			Float unidadesAProducir = presupuesto.getUnidadesAProducir(finalp);
			Float total = 0.0f;

			for (UsoMateriaPrima uso : finalp.getUsoMateriaPrima()) {

				int j = 0;
				PresupuestoConsumoMateriaXMateria mat = new PresupuestoConsumoMateriaXMateria();
				MateriaPrimaView view = new MateriaPrimaView();
				view.setId(uso.getMateriaPrima().getId());
				view.setNombre(uso.getMateriaPrima().getNombre());
				mat.setConsumoUnidades(uso.getUsoProducto());
				mat.setUnidadesConsumo(unidadesAProducir * uso.getUsoProducto());
				mat.setMateriaPrima(view);
				total += mat.getUnidadesConsumo();

				while (j < consumoMateriaPrima.size()) {
					PresupuestoXMateriaPrima xmateria = consumoMateriaPrima.get(j);
					if (xmateria.getMateriaPrima().getId() == uso.getMateriaPrima().getId()) {
						Float totald = xmateria.getTotal() + mat.getUnidadesConsumo();
						xmateria.setTotal(totald);
						break;
					}
					j++;
				}

				if (j == consumoMateriaPrima.size()) {
					PresupuestoXMateriaPrima xmateria = new PresupuestoXMateriaPrima();
					Float totald = mat.getUnidadesConsumo();
					xmateria.setMateriaPrima(view);
					xmateria.setTotal(totald);
					consumoMateriaPrima.add(xmateria);
				}

				arreglo.add(mat);

			}
			pw= new ProductoView();
			fila.setTotal(total);
			fila.setConsumos(arreglo);
			fila.setUnidadesAProducir(unidadesAProducir);
			pw.setNombre(finalp.getNombre());
			pw.setId(finalp.getId());
			fila.setProducto(pw);

			lista.add(fila);
			notificaAvance((Float) (i++ / productos.size() * 100.0f), this.notificarAvance);
		}
		salida.setPresupuestoXmateriaPrima(consumoMateriaPrima);
		salida.setFila(lista);
		this.salida = salida;
		notificaAvance(this.salida, this.notificarFin);
	}

	public IDaoPresupuesto getDaoPresupuesto() {
		return daoPresupuesto;
	}

	public void setDaoPresupuesto(IDaoPresupuesto daoPresupuesto) {
		this.daoPresupuesto = daoPresupuesto;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

}
