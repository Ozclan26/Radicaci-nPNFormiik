package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class analisisCrédito extends Base {

	public analisisCrédito(WebDriver driver) {
		super(driver);
	}
  
	// INSTANCIA DE LOS LOCALIZADORES WEB
	By statusCarga = By.id("loadingStatusScreen");
	By analisisCredit = By.xpath("//h3[contains(text(),'Análisis de Crédito')]");
	By estabilidadObs = By.id("ObsEstCli");
	By habilidadObs = By.id("ObsHabEmpCli");
	By historialCre = By.id("ConHisCre");
	By dataCre = By.id("ConDatCre");
	By cifin = By.id("ConCIFIN");
	By clienteExclusivo = By.id("EsCliExc_0");
	By observacionesExclusivo = By.id("ObsCliExc");
	By btnCriteriosAprobacion = By.id("CriApr");
	By alertaCriterios = By.xpath("//p[contains(text(),'Validación criterios aprobación exitosa.')]");
	By alertaCriteriosFallida = By.xpath("//p[contains(text(),'Validación criterios aprobación fallida con error Bloqueate.')]");
	By btnAceptar = By.xpath("//span[contains(text(),'Aceptar')]");
	By observacionReputacion = By.id("ObsAnaCreRep");
	// INFORMACIÓN FINANCIERA
	By origenRecursos = By.id("PaiOriRec");
	By totalVent = By.id("TotVen");
	By totalCom = By.id("TotCom");
	By gastosNeg = By.id("GasNeg");
	By gastosFinan = By.id("GasFin");
	By totalOtrosIng = By.id("TotOtrIng");
	By descripcionOtrosIngresos = By.id("DesOtrIng");
	By ingresosPoliticas = By.id("OtrIng");
	By aportesFlia = By.id("TotApoFam");
	By gastosFliares = By.id("GasFam");
	By bienesNegocio = By.id("Act");
	By pasivosNegocio = By.id("Pas");
	By cuentasBw = By.id("CueWWB");
	By totalActivos = By.id("TotAct");
	By totalPasivos = By.id("EndTot");
	By patrimonio = By.id("Pat");
	By declaraRentaNo = By.id("DecRen_1");
	By monedaExtranjeraNo = By.id("ReaOpeMonExt_1");
	By cuentasExteriorNo = By.id("PosCueExt_1");
	By btnSiguiente2 = By.id("btnNext_2");
	// GEOREFERENCIACION
	By agregarGeoreferencia = By.id("add_Georef");
	By iframeGeoreferencia = By.id("ifrm_Georef");
	By nombreGeo = By.id("NomCom");
	By direccionGeo = By.id("Dir");
	By btnConsultarBarrio = By.id("ConBar");
	By telefonoGeo = By.id("Tel");
	By observacionesGeo = By.id("Obs");
	By btnGuardar = By.id("btnSubmit");
	// REFERENCIAS
	By agregarReferencia = By.id("add_Ref");
	By iframeReferencias = By.id("ifrm_Ref");
	By formularioTipoRef = By.id("CatTipRef");
	By tipoReferencia = By.id("TipRef");
	By nombreReferencia = By.id("NomCom");
	By direccionReferencia = By.id("Dir");
	By telefonoReferencia = By.id("Tel");
	By relacionConSolicitante = By.id("RelConSolPer");
	By relacionFamiliar = By.id("RelConSolFam");
	By tiempoConocidos = By.id("TieConSol");
	By celReferencias = By.id("Cel");
	By opinionReferencia = By.id("OpiSobSol");
	By noPropietario = By.id("EsProNeg_1");
	By actividadReferencia = By.id("ActSol");
	By tiempoActividad = By.id("TieConAct");
	By observacionReferencia = By.id("Obs");
	// SERVICIO CONSULTAR BARRIO
	By barrioCliente = By.id("NomBarCli");
	By codBarrio = By.id("IdeBarCli");
	//DIVS
	By divReferencias = By.id("forms_Ref");
	By divGeoReferencias = By.id("forms_Georef");
	By trsReferencias = By.xpath("//tr[@class='alternative formedititem' or @class='formedititem']");
	By delete = By.className("btnColDel");
	By errorCifin = By.xpath("//p[contains(text(),'Error en una transacción en línea.')]");
	By dataCreditoNoAprobado = By.id("ResAprDatCre_1");
	
	
	public void analisisCaracter(String idecaso,String barrio, String codigoBarrio,String perfil) throws InterruptedException, IOException {
		defaultContent();
		isDisplayed(analisisCredit);
		elementoVisible(analisisCredit);
		moverMouse(analisisCredit);
		elementoClickeable(analisisCredit);
		hacerClic(analisisCredit);
		Thread.sleep(2000);
		isDisplayed(estabilidadObs);
		moverMouse(estabilidadObs);
		elementoVisible(estabilidadObs);
		elementoClickeable(estabilidadObs);
		hacerClic(estabilidadObs);
		cleanTest(estabilidadObs);
		escribirTexto(estabilidadObs, "Ok");
		isDisplayed(habilidadObs);
		moverMouse(habilidadObs);
		elementoVisible(habilidadObs);
		elementoClickeable(estabilidadObs);
		hacerClic(habilidadObs);
		cleanTest(habilidadObs);
		escribirTexto(habilidadObs, "Ok");
		if (perfil.contains("consulta")) {
			isDisplayed(historialCre);
			moverMouse(historialCre);
			elementoVisible(historialCre);
			elementoClickeable(historialCre);
			hacerClic(historialCre);
			elementoInvisible(statusCarga);
			isDisplayed(dataCre);
			moverMouse(dataCre);
			elementoVisible(dataCre);
			elementoClickeable(dataCre);
			hacerClic(dataCre);
			elementoInvisible(statusCarga);
			isDisplayed(cifin);
			moverMouse(cifin);
			elementoVisible(cifin);
			Boolean aprobacionDataCreditoNo = isChecked(dataCreditoNoAprobado);
			elementoClickeable(cifin);
			hacerClic(cifin);
			elementoInvisible(statusCarga);
			if (aprobacionDataCreditoNo == true) {
				isDisplayed(errorCifin);
				elementoVisible(errorCifin);
				elementoClickeable(errorCifin);
				isDisplayed(btnAceptar);
				elementoVisible(btnAceptar);
				elementoClickeable(btnAceptar);
				hacerClic(btnAceptar);
			}
		}
		isDisplayed(clienteExclusivo);
		elementoVisible(clienteExclusivo);
		elementoClickeable(clienteExclusivo);
		moverMouse(clienteExclusivo);
		hacerClic(clienteExclusivo);
		isDisplayed(observacionesExclusivo);
		moverMouse(observacionesExclusivo);
		elementoVisible(observacionesExclusivo);
		elementoClickeable(observacionesExclusivo);
		hacerClic(observacionesExclusivo);
		cleanTest(observacionesExclusivo);
		escribirTexto(observacionesExclusivo, "Ok");
		isDisplayed(btnCriteriosAprobacion);
		moverMouse(btnCriteriosAprobacion);
		elementoVisible(btnCriteriosAprobacion);
		elementoClickeable(btnCriteriosAprobacion);
		hacerClic(btnCriteriosAprobacion);
		isDisplayed(alertaCriterios);
		elementoVisible(alertaCriterios);
		isDisplayed(btnAceptar);
		elementoVisible(btnAceptar);
		elementoClickeable(btnAceptar);
		tomarCaptura(idecaso, "12-criteriosAceptados");
		hacerClic(btnAceptar);
		isDisplayed(observacionReputacion);
		moverMouse(observacionReputacion);
		elementoVisible(observacionReputacion);
		elementoClickeable(observacionReputacion);
		hacerClic(observacionReputacion);
		cleanTest(observacionReputacion);
		escribirTexto(observacionReputacion, "Ok");
		Boolean existe = validarExistencia(divGeoReferencias);
		if (existe == true) {
			int numeroGeoReferencias = cantidadGeoyReferencias(divGeoReferencias,delete);
			if (numeroGeoReferencias < 2) {
				agregarGeoreferencias(barrio,codigoBarrio);
			}
		} else {
			agregarGeoreferencias(barrio,codigoBarrio);
			agregarGeoreferencias(barrio,codigoBarrio);
		}
	}

	public void agregarGeoreferencias(String barrio, String codigoBarrio) throws InterruptedException {
		int numeroAleatorio = (int) (Math.random() * 50 + 1);
		isDisplayed(agregarGeoreferencia);
		moverMouse(agregarGeoreferencia);
		Thread.sleep(1000);
		elementoVisible(agregarGeoreferencia);
		elementoClickeable(agregarGeoreferencia);
		hacerClic(agregarGeoreferencia);
		Thread.sleep(2000);
		isDisplayed(iframeGeoreferencia);
		elementoVisible(iframeGeoreferencia);
		cambioIframeById("ifrm_Georef");
		isDisplayed(nombreGeo);
		moverMouse(nombreGeo);
		elementoVisible(nombreGeo);
		elementoClickeable(nombreGeo);
		hacerClic(nombreGeo);
		escribirTexto(nombreGeo, "Georeferencia" + numeroAleatorio);
		isDisplayed(direccionGeo);
		elementoVisible(direccionGeo);
		elementoClickeable(direccionGeo);
		hacerClic(direccionGeo);
		escribirTexto(direccionGeo, "Calle" + numeroAleatorio);
		isDisplayed(barrioCliente); 
		elementoVisible(barrioCliente);
		quitarAtributo(barrioCliente);
		moverMouse(barrioCliente);
		elementoClickeable(barrioCliente);
		escribirTexto(barrioCliente, barrio);
		isDisplayed(codBarrio);
		elementoVisible(codBarrio);
		quitarAtributo(codBarrio);
		moverMouse(codBarrio);
		elementoClickeable(codBarrio);
		escribirTexto(codBarrio, codigoBarrio);
		isDisplayed(telefonoGeo);
		elementoVisible(telefonoGeo);
		elementoClickeable(telefonoGeo);
		hacerClic(telefonoGeo);
		escribirTexto(telefonoGeo, "1023654");
		isDisplayed(observacionesGeo);
		elementoVisible(observacionesGeo);
		elementoClickeable(observacionesGeo);
		hacerClic(observacionesGeo);
		escribirTexto(observacionesGeo, "Ok");
		isDisplayed(btnGuardar);
		elementoVisible(btnGuardar);
		elementoClickeable(btnGuardar);
		hacerClic(btnGuardar);
		Thread.sleep(2000);
		aceptarAlerta();
		defaultContent();
	}

	public void infoFinanciera(String idecaso,String totalVentas,String perfil) throws InterruptedException, IOException {
		isDisplayed(origenRecursos);
		elementoVisible(origenRecursos);
		elementoClickeable(origenRecursos);
		Select listaPaisOriRec = new Select(findElement(origenRecursos));
		listaPaisOriRec.selectByVisibleText("Colombia");
		isDisplayed(totalVent);
		elementoVisible(totalVent);
		elementoClickeable(totalVent);
		hacerClic(totalVent);
		cleanTest(totalVent);
		escribirTexto(totalVent, totalVentas);
		isDisplayed(totalCom);
		elementoVisible(totalCom);
		elementoClickeable(totalCom);
		hacerClic(totalCom);
		cleanTest(totalCom);
		escribirTexto(totalCom, "500000");
		//escribirTexto(totalCom, "10000000");
		isDisplayed(gastosNeg);
		elementoVisible(gastosNeg);
		elementoClickeable(gastosNeg);
		hacerClic(gastosNeg);
		cleanTest(gastosNeg);
		escribirTexto(gastosNeg, "200000");
		//escribirTexto(gastosNeg, "5000000");
		isDisplayed(gastosFinan);
		elementoVisible(gastosFinan);
		elementoClickeable(gastosFinan);
		hacerClic(gastosFinan);
		cleanTest(gastosFinan);
		escribirTexto(gastosFinan, "200000");
		//escribirTexto(gastosFinan, "1000000");
		isDisplayed(totalOtrosIng);
		elementoVisible(totalOtrosIng);
		elementoClickeable(totalOtrosIng);
		hacerClic(totalOtrosIng);
		cleanTest(totalOtrosIng);
		escribirTexto(totalOtrosIng, "5000000");
		isDisplayed(descripcionOtrosIngresos);
		elementoVisible(descripcionOtrosIngresos);
		elementoClickeable(descripcionOtrosIngresos);
		hacerClic(descripcionOtrosIngresos);
		cleanTest(descripcionOtrosIngresos);
		escribirTexto(descripcionOtrosIngresos, "Independiente");
		tomarCaptura(idecaso, "13-InfoFinanciera1");
		isDisplayed(ingresosPoliticas);
		elementoVisible(ingresosPoliticas);
		elementoClickeable(ingresosPoliticas);
		hacerClic(ingresosPoliticas);
		cleanTest(ingresosPoliticas);
		escribirTexto(ingresosPoliticas, "0");
		isDisplayed(aportesFlia);
		elementoVisible(aportesFlia);
		elementoClickeable(aportesFlia);
		hacerClic(aportesFlia);
		cleanTest(aportesFlia);
		escribirTexto(aportesFlia, "500000");
		isDisplayed(gastosFliares);
		elementoVisible(gastosFliares);
		elementoClickeable(gastosFliares);
		hacerClic(gastosFliares);
		cleanTest(gastosFliares);
		escribirTexto(gastosFliares, "0");
		isDisplayed(bienesNegocio);
		elementoVisible(bienesNegocio);
		elementoClickeable(bienesNegocio);
		hacerClic(bienesNegocio);
		cleanTest(bienesNegocio);
		escribirTexto(bienesNegocio, "1000000");
		isDisplayed(pasivosNegocio);
		elementoVisible(pasivosNegocio);
		elementoClickeable(pasivosNegocio);
		hacerClic(pasivosNegocio);
		cleanTest(pasivosNegocio);
		escribirTexto(pasivosNegocio, "1000000");
		isDisplayed(cuentasBw);
		elementoVisible(cuentasBw);
		elementoClickeable(cuentasBw);
		hacerClic(cuentasBw);
		cleanTest(cuentasBw);
		escribirTexto(cuentasBw, "0");
		isDisplayed(totalActivos);
		elementoVisible(totalActivos);
		elementoClickeable(totalActivos);
		hacerClic(totalActivos);
		cleanTest(totalActivos);
		escribirTexto(totalActivos, "1000000");
		isDisplayed(totalPasivos);
		elementoVisible(totalPasivos);
		elementoClickeable(totalPasivos);
		hacerClic(totalPasivos);
		cleanTest(totalPasivos);
		escribirTexto(totalPasivos, "200000");
		if (perfil.contains("analista")) {
			isDisplayed(patrimonio);
			elementoVisible(patrimonio);
			elementoClickeable(patrimonio);
			hacerClic(patrimonio);
			cleanTest(patrimonio);
			escribirTexto(patrimonio, "200000");
		}
		tomarCaptura(idecaso, "14-InfoFinanciera2");
		Boolean existenReferencias = validarExistencia(divReferencias);
		if (existenReferencias == true) {
			int numeroReferencias = cantidadGeoyReferencias(divReferencias,delete);
			if (numeroReferencias < 3) {
				agregarReferenciaPersonal();
				agregarReferenciaPersonal();
			}
		} else {
			agregarReferenciaPersonal();
			agregarReferenciaFamiliar();
			agregarReferenciaPersonal();
		}
	}

	public void agregarReferenciaPersonal() throws InterruptedException {
		int numeroAleatorio = (int) (Math.random() * 50 + 1);
		isDisplayed(agregarReferencia);
		moverMouse(agregarReferencia);
		Thread.sleep(2000);
		elementoVisible(agregarReferencia);
		elementoClickeable(agregarReferencia);
		hacerClic(agregarReferencia);
		Thread.sleep(2000);
		isDisplayed(iframeReferencias);
		elementoVisible(iframeReferencias);
		cambioIframeById("ifrm_Ref");
		isDisplayed(formularioTipoRef);
		elementoVisible(formularioTipoRef);
		elementoClickeable(formularioTipoRef);
		escribirTexto(formularioTipoRef, "Natural");
		isDisplayed(tipoReferencia);
		elementoVisible(tipoReferencia);
		elementoClickeable(tipoReferencia);
		Select listTipoReferencia = new Select(findElement(tipoReferencia));
		listTipoReferencia.selectByVisibleText("Referencia Comercial y/o Personal");
		isDisplayed(nombreReferencia);
		elementoVisible(nombreReferencia);
		elementoClickeable(nombreReferencia);
		hacerClic(nombreReferencia);
		escribirTexto(nombreReferencia, "Amigo" + numeroAleatorio);
		isDisplayed(direccionReferencia);
		elementoVisible(direccionReferencia);
		elementoClickeable(direccionReferencia);
		hacerClic(direccionReferencia);
		escribirTexto(direccionReferencia, "Calle" + numeroAleatorio);
		isDisplayed(telefonoReferencia);
		elementoVisible(telefonoReferencia);
		elementoClickeable(telefonoReferencia);
		hacerClic(telefonoReferencia);
		escribirTexto(telefonoReferencia, "1023654");
		isDisplayed(celReferencias);
		elementoVisible(celReferencias);
		elementoClickeable(celReferencias);
		hacerClic(celReferencias);
		escribirTexto(celReferencias, "3135489632");
		isDisplayed(relacionConSolicitante);
		elementoVisible(relacionConSolicitante);
		elementoClickeable(relacionConSolicitante);
		Select relacionSolicitante = new Select(findElement(relacionConSolicitante));
		relacionSolicitante.selectByVisibleText("Amigo");
		isDisplayed(tiempoConocidos);
		elementoVisible(tiempoConocidos);
		elementoClickeable(tiempoConocidos);
		Select tiempoDeConocerse = new Select(findElement(tiempoConocidos));
		tiempoDeConocerse.selectByVisibleText("De 5 a 10 años");
		isDisplayed(opinionReferencia);
		elementoVisible(opinionReferencia);
		elementoClickeable(opinionReferencia);
		Select opinionRef = new Select(findElement(opinionReferencia));
		opinionRef.selectByVisibleText("Honesto");
		isDisplayed(noPropietario);
		elementoVisible(noPropietario);
		elementoClickeable(noPropietario);
		hacerClic(noPropietario);
		isDisplayed(actividadReferencia);
		elementoVisible(actividadReferencia);
		elementoClickeable(actividadReferencia);
		hacerClic(actividadReferencia);
		escribirTexto(actividadReferencia, "Independiente");
		isDisplayed(tiempoActividad);
		elementoVisible(tiempoActividad);
		elementoClickeable(tiempoActividad);
		hacerClic(tiempoActividad);
		escribirTexto(tiempoActividad, "99");
		isDisplayed(observacionReferencia);
		elementoVisible(observacionReferencia);
		elementoClickeable(observacionReferencia);
		hacerClic(observacionReferencia);
		escribirTexto(observacionReferencia, "Ok");
		isDisplayed(btnGuardar);
		elementoVisible(btnGuardar);
		elementoClickeable(btnGuardar);
		hacerClic(btnGuardar);
		Thread.sleep(2000);
		aceptarAlerta();
		defaultContent();
	}
	
	public void agregarReferenciaFamiliar() throws InterruptedException {
		int numeroAleatorio = (int) (Math.random() * 50 + 1);
		isDisplayed(agregarReferencia);
		moverMouse(agregarReferencia);
		Thread.sleep(2000);
		elementoVisible(agregarReferencia);
		elementoClickeable(agregarReferencia);
		hacerClic(agregarReferencia);
		Thread.sleep(2000);
		isDisplayed(iframeReferencias);
		elementoVisible(iframeReferencias);
		cambioIframeById("ifrm_Ref");
		isDisplayed(formularioTipoRef);
		elementoVisible(formularioTipoRef);
		elementoClickeable(formularioTipoRef);
		escribirTexto(formularioTipoRef, "Natural");
		isDisplayed(tipoReferencia);
		elementoVisible(tipoReferencia);
		elementoClickeable(tipoReferencia);
		Select listTipoReferencia = new Select(findElement(tipoReferencia));
		listTipoReferencia.selectByVisibleText("Referencia Familiar");
		isDisplayed(nombreReferencia);
		elementoVisible(nombreReferencia);
		elementoClickeable(nombreReferencia);
		hacerClic(nombreReferencia);
		escribirTexto(nombreReferencia, "Familiar" + numeroAleatorio);
		isDisplayed(direccionReferencia);
		elementoVisible(direccionReferencia);
		elementoClickeable(direccionReferencia);
		hacerClic(direccionReferencia);
		escribirTexto(direccionReferencia, "Calle" + numeroAleatorio);
		isDisplayed(telefonoReferencia);
		elementoVisible(telefonoReferencia);
		elementoClickeable(telefonoReferencia);
		hacerClic(telefonoReferencia);
		escribirTexto(telefonoReferencia, "1023654");
		isDisplayed(celReferencias);
		elementoVisible(celReferencias);
		elementoClickeable(celReferencias);
		hacerClic(celReferencias);
		escribirTexto(celReferencias, "3135489632");
		isDisplayed(relacionFamiliar);
		elementoVisible(relacionFamiliar);
		elementoClickeable(relacionFamiliar);
		Select relacionSolicitante = new Select(findElement(relacionFamiliar));
		relacionSolicitante.selectByValue("20");
		isDisplayed(opinionReferencia);
		elementoVisible(opinionReferencia);
		elementoClickeable(opinionReferencia);
		Select opinionRef = new Select(findElement(opinionReferencia));
		opinionRef.selectByVisibleText("Honesto");
		isDisplayed(actividadReferencia);
		elementoVisible(actividadReferencia);
		elementoClickeable(actividadReferencia);
		hacerClic(actividadReferencia);
		escribirTexto(actividadReferencia, "Independiente");
		isDisplayed(tiempoActividad);
		elementoVisible(tiempoActividad);
		elementoClickeable(tiempoActividad);
		hacerClic(tiempoActividad);
		escribirTexto(tiempoActividad, "99");
		isDisplayed(observacionReferencia);
		elementoVisible(observacionReferencia);
		elementoClickeable(observacionReferencia);
		hacerClic(observacionReferencia);
		escribirTexto(observacionReferencia, "Ok");
		isDisplayed(btnGuardar);
		elementoVisible(btnGuardar);
		elementoClickeable(btnGuardar);
		hacerClic(btnGuardar);
		Thread.sleep(2000);
		aceptarAlerta();
		defaultContent();
	}
	
	public void declaracionRenta(String idecaso) throws IOException {
		isDisplayed(declaraRentaNo);
		elementoVisible(declaraRentaNo);
		elementoClickeable(declaraRentaNo);
		hacerClic(declaraRentaNo);
		tomarCaptura(idecaso, "15-Referencias");
		isDisplayed(monedaExtranjeraNo);
		elementoVisible(monedaExtranjeraNo);
		elementoClickeable(monedaExtranjeraNo);
		hacerClic(monedaExtranjeraNo);
		isDisplayed(cuentasExteriorNo);
		elementoVisible(cuentasExteriorNo);
		elementoClickeable(cuentasExteriorNo);
		hacerClic(cuentasExteriorNo);
		isDisplayed(btnSiguiente2);
		elementoVisible(btnSiguiente2);
		elementoClickeable(btnSiguiente2);
		hacerClic(btnSiguiente2);
	}
}
