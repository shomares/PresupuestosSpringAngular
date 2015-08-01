package org.upiicsa.logica.Presupuesto;

import java.util.List;

import org.upiicsa.dao.IDao;
import org.upiicsa.dao.entidades.BalanceGeneral;
import org.upiicsa.dao.entidades.Configuracion;
import org.upiicsa.dao.entidades.MateriaPrima;
import org.upiicsa.dao.entidades.Producto;

public class LogicaBalanceGeneral extends PresupuestoAbstract {

	private IDao<BalanceGeneral> daoBalanceGeneral;

	private IDao<MateriaPrima> daoMateriaPrima;

	private IDao<Configuracion> daoConfiguracion;

	private IDao<Producto> daoProduccto;

	private LogicaEstadoResultados logicaEstadoResultados;

	private LogicPresupuestoCompras logicPresupuestoCompras;

	private LogicProrrateoFinal logicProrrateoFinal;

	private LogicCostoUnitarioProduccion logicCostoUnitarioProduccion;

	private LogicPresupuestoManoObra logicPresupuestoManoObra;

	public IDao<BalanceGeneral> getDaoBalanceGeneral() {
		return daoBalanceGeneral;
	}

	public void setDaoBalanceGeneral(IDao<BalanceGeneral> daoBalanceGeneral) {
		this.daoBalanceGeneral = daoBalanceGeneral;
	}

	public IDao<MateriaPrima> getDaoMateriaPrima() {
		return daoMateriaPrima;
	}

	public void setDaoMateriaPrima(IDao<MateriaPrima> daoMateriaPrima) {
		this.daoMateriaPrima = daoMateriaPrima;
	}

	public LogicaEstadoResultados getLogicaEstadoResultados() {
		return logicaEstadoResultados;
	}

	public void setLogicaEstadoResultados(LogicaEstadoResultados logicaEstadoResultados) {
		this.logicaEstadoResultados = logicaEstadoResultados;
	}

	@Override
	public void calcular() {
		// TODO Auto-generated method stub
		List<BalanceGeneral> balances = daoBalanceGeneral.getAll();
		List<Configuracion> configs = daoConfiguracion.getAll();

		if (!balances.isEmpty()) {
			BalanceGeneral balance = balances.get(0);
			Configuracion conf = configs.get(0);
			Float inventarios = 0.0f;
			Float productos = 0.0f;

			Float ventas = logicaEstadoResultados.getVentasTotales();
			List<MateriaPrima> materiasPrimas = daoMateriaPrima.getAll();
			for (MateriaPrima pr : materiasPrimas)
				inventarios += pr.getCantidadInventarioFinal() * pr.getCostoPresupuestado();

			for (Producto pr : daoProduccto.getAll()) {
				productos += pr.getCantidadInventarioFinal()
						* logicCostoUnitarioProduccion.getCostoUnitario(pr.getId());

			}
			balance.setInventariodeMateriaPrima(inventarios);
			Float cobroDeVentas = ((conf.getProcientoPagoCompra() / 100) * (ventas));
			Float totalEntradas = balance.getCajayBancos() + balance.getClientes() + cobroDeVentas;
			Float pagoDeCompras = (logicPresupuestoCompras.getTotal()) * (conf.getProcientoPagoCompra() / 100);
			Float gastosDeOperacion = (conf.getGastoAdministracion() + conf.getGastoVentas());
			Float totalSalidas = balance.getProveedores() + balance.getImpxpagar() + pagoDeCompras
					+ logicPresupuestoManoObra.getTotal() + logicProrrateoFinal.getTotal() + gastosDeOperacion;
			Float saldoEfectivo = totalEntradas - totalSalidas;

			balance.setCajayBancos(saldoEfectivo);
			balance.setClientes(ventas - cobroDeVentas);
			balance.setInventariodeMateriaPrima(inventarios);
			// balance.setDepreciacionAcumulada(conf.getDepreciacionAcumulada());
			balance.setProveedores(logicPresupuestoCompras.getTotal() - pagoDeCompras);
			balance.setImpxpagar(logicaEstadoResultados.getISR());
			balance.setUtDelEjercicio(balance.getUtDelEjercicio() + logicaEstadoResultados.getUilidad());
			this.salida = balance;

		}

	}

	public IDao<Producto> getDaoProduccto() {
		return daoProduccto;
	}

	public void setDaoProduccto(IDao<Producto> daoProduccto) {
		this.daoProduccto = daoProduccto;
	}

	public LogicPresupuestoCompras getLogicPresupuestoCompras() {
		return logicPresupuestoCompras;
	}

	public void setLogicPresupuestoCompras(LogicPresupuestoCompras logicPresupuestoCompras) {
		this.logicPresupuestoCompras = logicPresupuestoCompras;
	}

	public LogicProrrateoFinal getLogicProrrateoFinal() {
		return logicProrrateoFinal;
	}

	public void setLogicProrrateoFinal(LogicProrrateoFinal logicProrrateoFinal) {
		this.logicProrrateoFinal = logicProrrateoFinal;
	}

	public LogicCostoUnitarioProduccion getLogicCostoUnitarioProduccion() {
		return logicCostoUnitarioProduccion;
	}

	public void setLogicCostoUnitarioProduccion(LogicCostoUnitarioProduccion logicCostoUnitarioProduccion) {
		this.logicCostoUnitarioProduccion = logicCostoUnitarioProduccion;
	}

	public LogicPresupuestoManoObra getLogicPresupuestoManoObra() {
		return logicPresupuestoManoObra;
	}

	public void setLogicPresupuestoManoObra(LogicPresupuestoManoObra logicPresupuestoManoObra) {
		this.logicPresupuestoManoObra = logicPresupuestoManoObra;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public IDao<Configuracion> getDaoConfiguracion() {
		return daoConfiguracion;
	}

	public void setDaoConfiguracion(IDao<Configuracion> daoConfiguracion) {
		this.daoConfiguracion = daoConfiguracion;
	}

}
