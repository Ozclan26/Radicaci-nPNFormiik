package PageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class productoRadicacion extends Base {

	public productoRadicacion(WebDriver driver) {
		super(driver);
	} 
 
	// INSTANCIA DE LOS LOCALIZADORES WEB
	By productoSugerido = By.id("ProSug");
	By montoSugerido = By.id("MonSug");
	By plazoSugerido = By.id("PlaSug");
	By frecuenciaPago = By.id("FrePagSug");
	By destinoEconomico = By.id("DesEcoCre");
	By validacionAlivio = By.id("ValDeuAli");
	By fechaDesembolso = By.id("FecEstDes");
	By fechaPrimerCuota = By.id("FecPriCuo");
	By seguroDeudores = By.id("M_SEG_DEU");
	By data = By.id("M_DATA");
	By cifin = By.id("M_CIFIN");
	By tieneAhorro = By.id("TieAho_0");
	By noTieneAhorro = By.id("TieAho_1");
	By desembolsoCuenta = By.id("DesDesCue_1");
	By desembolsoCuentaSi = By.id("DesDesCue_0");
	By debitoAuto = By.id("DebAut_1");
	By emergencia = By.id("EstEstEme_1");
	By btnConsultaCuota = By.id("ConCuo");
	By alertaCuota = By.xpath("//p[contains(text(),'Cuota calculada exitosamente')]");
	By btnAceptar = By.xpath("//span[contains(text(),'Aceptar')]");
	By btnSiguiente3 = By.id("btnNext_3");
	//REESTRUCTURACION
	By creditosRecoger = By.id("CanCreRec");
	//SEGUROS
	By agregarSeguro = By.id("add_Seg");
	By iframeSeguro = By.id("ifrm_Seg");
	By seleccionSeguro = By.id("SelSeg");
	By tipoPlan = By.id("TipPla");
	By valorPrima = By.id("ValPriMen");
	By cantidadBenefi = By.id("CanBen");
	By cantidadBenefiExe = By.id("CanBenExe");
	By idBeneficiario = By.id("IdBen1");
	By nombreBeneficiario = By.id("NomBen1");
	By apeBeneficiario = By.id("ApeBen1");
	By parBeneficiario = By.id("ParBen1");
	By porcBeneficiario = By.id("PorBen1");
	By btnGuardar = By.id("btnSubmit");
	//SEGURO HOGAR
	By direccion = By.id("Dir");
	By departamento = By.id("NomDep");
	By ideDepartamento = By.id("IdeDep");
	By ciudad = By.id("NomCiu");
	By ideCiudad = By.id("IdeCiu");
	By uso = By.id("Uso");
	By tipoInmueble = By.id("TipInm");
	By numPisos = By.id("NumPis");
	By numSotanos = By.id("NumSot");
	
	
	public void dataProducto(String idecaso,String producto,String monto, String plazo, String frecuencia, String fechaDes, String fechaCuo, String tipoCredito, String restructuracion, String voySeguro, String familia, String exequial, String hogar, String recogerCreditos, String desemCuenta) throws IOException, InterruptedException {
		isDisplayed(productoSugerido);
		elementoVisible(productoSugerido);
		moverMouse(productoSugerido);
		elementoClickeable(productoSugerido);
		Select listProducto = new Select(findElement(productoSugerido));
		listProducto.selectByVisibleText(producto);
		isDisplayed(montoSugerido);
		elementoVisible(montoSugerido);
		moverMouse(montoSugerido);
		elementoClickeable(montoSugerido);
		hacerClic(montoSugerido);
		cleanTest(montoSugerido);
		escribirTexto(montoSugerido, monto);
		isDisplayed(plazoSugerido);
		elementoVisible(plazoSugerido);
		moverMouse(plazoSugerido);
		elementoClickeable(plazoSugerido);
		hacerClic(plazoSugerido);
		cleanTest(plazoSugerido);
		escribirTexto(plazoSugerido, plazo);
		isDisplayed(frecuenciaPago);
		elementoVisible(frecuenciaPago);
		moverMouse(frecuenciaPago);
		elementoClickeable(frecuenciaPago);
		Select listFrecuencia = new Select(findElement(frecuenciaPago));
		listFrecuencia.selectByVisibleText(frecuencia);
		isDisplayed(destinoEconomico);
		elementoVisible(destinoEconomico);
		moverMouse(destinoEconomico);
		elementoClickeable(destinoEconomico);
		Select listDestino = new Select(findElement(destinoEconomico));
		if (producto.contains("Inmueble Productivo")) {
			listDestino.selectByVisibleText(producto);
			tomarCaptura(idecaso, "16-formProducto1");
		}
		
		else {
			listDestino.selectByVisibleText("Activo Fijo");
			tomarCaptura(idecaso, "16-formProducto1");
		}
		
		boolean existeAli = validarExistencia(validacionAlivio);
		if (existeAli == true) {
			isDisplayed(validacionAlivio);
			elementoVisible(validacionAlivio);
			moverMouse(validacionAlivio);
			elementoClickeable(validacionAlivio);
			hacerClic(validacionAlivio);
		}
		
		// RECOGÉ TODOS LOS CRÉDITOS
		if (recogerCreditos.contains("Si")) {
			boolean existe = validarExistencia(creditosRecoger);
			if (existe == true) {
				isDisplayed(creditosRecoger);
				elementoVisible(creditosRecoger);
				quitarAtributo(creditosRecoger);
				int cantidad = obtenerInnerHtml(creditosRecoger);
				for (int i = 1; i <= cantidad; i++) {
					By credit = By.id("CreRecSel" + i + "_0");
					isDisplayed(credit);
					elementoVisible(credit);
					elementoClickeable(credit);
					hacerClic(credit);
					escribirTexto(credit, ""+ Keys.TAB);
					tomarCaptura(idecaso, "17-Crédito " + i + " Recogido");
				}
			}
		}
		// NO RECOGE NINGUN CRÉDITO
		else {
			boolean existe = validarExistencia(creditosRecoger);
			if (existe == true) {
				isDisplayed(creditosRecoger);
				elementoVisible(creditosRecoger);
				quitarAtributo(creditosRecoger);
				int cantidad = obtenerInnerHtml(creditosRecoger);
				for (int i = 1; i <= cantidad; i++) {
					By credit = By.id("CreRecSel" + i + "_1");
					isDisplayed(credit);
					elementoVisible(credit);
					elementoClickeable(credit);
					hacerClic(credit);
					escribirTexto(credit, ""+ Keys.TAB);
					tomarCaptura(idecaso, "17-Crédito " + i + " No Recogido");
				}
			}
		}
		
		tomarCaptura(idecaso, "18-valorAlivio");
		if (tipoCredito.contains("Inmueble Productivo") || tipoCredito.contains("Microcredito")) {
			if (voySeguro.contains("Si")) {
				seguros("Voy Seguro","B1",idecaso);
			}
			if (familia.contains("Si")) {
				seguros("Voy Seguro Familia","C1",idecaso);
			}
			if (hogar.contains("Si")) {
				voySeguroHogar(idecaso);
			}
			if (exequial.contains("Si")) {
				seguros("Plan Exequial","A1",idecaso);
			}
		}
		isDisplayed(fechaDesembolso);
		elementoVisible(fechaDesembolso);
		quitarAtributo(fechaDesembolso);
		moverMouse(fechaDesembolso);
		elementoClickeable(fechaDesembolso);
		cleanTest(fechaDesembolso);
		escribirTexto(fechaDesembolso, fechaDes);
		isDisplayed(fechaPrimerCuota);
		elementoVisible(fechaPrimerCuota);
		quitarAtributo(fechaPrimerCuota);
		moverMouse(fechaPrimerCuota);
		elementoClickeable(fechaPrimerCuota);
		cleanTest(fechaPrimerCuota);
		escribirTexto(fechaPrimerCuota, fechaCuo + Keys.TAB);
		tomarCaptura(idecaso, "19-Seguros");
		if(producto.compareTo("REESTRUCTURACION")!=0){
			isDisplayed(data);
			elementoVisible(data);
			moverMouse(data);
			elementoClickeable(data);
			hacerClic(data);
			isDisplayed(cifin);
			elementoVisible(cifin);
			moverMouse(cifin);
			elementoClickeable(cifin);
			hacerClic(cifin);
			isDisplayed(tieneAhorro);
			elementoVisible(tieneAhorro);
			moverMouse(tieneAhorro);
			elementoClickeable(tieneAhorro);
			hacerClic(tieneAhorro);
		}else {
			isDisplayed(noTieneAhorro);
			elementoVisible(noTieneAhorro);
			moverMouse(noTieneAhorro);
			elementoClickeable(noTieneAhorro);
			hacerClic(noTieneAhorro);
		}
		if (tipoCredito.contains("Gotahorro")) {
			isDisplayed(desembolsoCuentaSi);
			elementoVisible(desembolsoCuentaSi);
			moverMouse(desembolsoCuentaSi);
			elementoClickeable(desembolsoCuentaSi);
			hacerClic(desembolsoCuentaSi);
		}
		if (tipoCredito.contains("Microcredito")) {
			if (desemCuenta.contains("Si")) {
				isDisplayed(desembolsoCuentaSi);
				elementoVisible(desembolsoCuentaSi);
				moverMouse(desembolsoCuentaSi);
				elementoClickeable(desembolsoCuentaSi);
				hacerClic(desembolsoCuentaSi);
			}else {
				isDisplayed(desembolsoCuenta);
				elementoVisible(desembolsoCuenta);
				moverMouse(desembolsoCuenta);
				elementoClickeable(desembolsoCuenta);
				hacerClic(desembolsoCuenta);
			}
		}
		isDisplayed(debitoAuto);
		elementoVisible(debitoAuto);
		moverMouse(debitoAuto);
		elementoClickeable(debitoAuto);
		hacerClic(debitoAuto);
		isDisplayed(emergencia);
		elementoVisible(emergencia);
		moverMouse(emergencia);
		elementoClickeable(emergencia);
		hacerClic(emergencia);
		tomarCaptura(idecaso, "20-formProducto2");
		isDisplayed(btnConsultaCuota);
		elementoVisible(btnConsultaCuota);
		moverMouse(btnConsultaCuota);
		elementoClickeable(btnConsultaCuota);
		hacerClic(btnConsultaCuota);
		isDisplayed(alertaCuota);
		elementoVisible(alertaCuota);
		tomarCaptura(idecaso, "21-cuotaCalculada");
		isDisplayed(btnAceptar);
		elementoVisible(btnAceptar);
		elementoClickeable(btnAceptar);
		hacerClic(btnAceptar);
		isDisplayed(btnSiguiente3);
		elementoVisible(btnSiguiente3);
		Thread.sleep(1000);
		tomarCaptura(idecaso, "22-Rubros");
		moverMouse(btnSiguiente3);
		elementoClickeable(btnSiguiente3);
		hacerClic(btnSiguiente3);
	}
	
	//METODOS PARA ELEGIR SEGUROS
	//ESTE METODO CONTEMPLA VOY SEGURO, SEGURO FAMILIA, EXCEQUIAL
	public void seguros(String tipo, String plan, String idecaso) throws InterruptedException, IOException {
		String identificacion = RandomStringUtils.random(9, false, true);
		String nombre = RandomStringUtils.random(6, true, false);
		String apellido = RandomStringUtils.random(6, true, false);
		Thread.sleep(2000);
		isDisplayed(agregarSeguro);
		elementoVisible(agregarSeguro);
		moverMouse(agregarSeguro);
		elementoClickeable(agregarSeguro);
		hacerClic(agregarSeguro);
		isDisplayed(iframeSeguro);
		elementoVisible(iframeSeguro);
		cambioIframeById("ifrm_Seg");
		isDisplayed(seleccionSeguro);
		elementoVisible(seleccionSeguro);
		moverMouse(seleccionSeguro);
		Select listSeguro = new Select(findElement(seleccionSeguro));
		waitOpcionesLista(seleccionSeguro, By.tagName("option"), tipo);
		listSeguro.selectByVisibleText(tipo);
		isDisplayed(tipoPlan);
		elementoVisible(tipoPlan);
		moverMouse(tipoPlan);
		Select listPlan = new Select(findElement(tipoPlan));
		waitOpcionesLista(tipoPlan, By.tagName("option"), plan);
		listPlan.selectByVisibleText(plan);
		isDisplayed(valorPrima);
		elementoVisible(valorPrima);
		moverMouse(valorPrima);
		List<WebElement> opciones = findElementsOfElement(valorPrima,By.tagName("option"));
		opciones.get(1).click();
		if (tipo.contains("Plan Exequial")) {
			isDisplayed(cantidadBenefiExe);
			elementoVisible(cantidadBenefiExe);
			moverMouse(cantidadBenefiExe);
			elementoClickeable(cantidadBenefiExe);
			Select listBenefiExe = new Select(findElement(cantidadBenefiExe));
			waitOpcionesLista(cantidadBenefiExe, By.tagName("option"), "1");
			listBenefiExe.selectByVisibleText("1");
		} else {
			isDisplayed(cantidadBenefi);
			elementoVisible(cantidadBenefi);
			moverMouse(cantidadBenefi);
			elementoClickeable(cantidadBenefi);
			Select listBenefi = new Select(findElement(cantidadBenefi));
			waitOpcionesLista(cantidadBenefi, By.tagName("option"), "1");
			listBenefi.selectByVisibleText("1");
		}
		isDisplayed(idBeneficiario);
		elementoVisible(idBeneficiario);
		moverMouse(idBeneficiario);
		elementoClickeable(idBeneficiario);
		hacerClic(idBeneficiario);
		escribirTexto(idBeneficiario, "1"+identificacion);
		isDisplayed(nombreBeneficiario);
		elementoVisible(nombreBeneficiario);
		moverMouse(nombreBeneficiario);
		elementoClickeable(nombreBeneficiario);
		hacerClic(nombreBeneficiario);
		escribirTexto(nombreBeneficiario, nombre);
		isDisplayed(apeBeneficiario);
		elementoVisible(apeBeneficiario);
		moverMouse(apeBeneficiario);
		elementoClickeable(apeBeneficiario);
		hacerClic(apeBeneficiario);
		escribirTexto(apeBeneficiario, apellido);
		isDisplayed(parBeneficiario);
		elementoVisible(parBeneficiario);
		moverMouse(parBeneficiario);
		elementoClickeable(parBeneficiario);
		if (tipo.equals("Voy Seguro")) {
			Select listParenteso = new Select(findElement(parBeneficiario));
			waitOpcionesLista(parBeneficiario, By.tagName("option"), "Hermano(a)");
			listParenteso.selectByVisibleText("Hermano(a)");
		}
		if (tipo.equals("Voy Seguro Familia")) {
			Select listParenteso = new Select(findElement(parBeneficiario));
			waitOpcionesLista(parBeneficiario, By.tagName("option"), "Sobrino(a)");
			listParenteso.selectByVisibleText("Sobrino(a)");
		}
		if (tipo.contains("Plan Exequial")) {
			Select listParenteso = new Select(findElement(parBeneficiario));
			waitOpcionesLista(parBeneficiario, By.tagName("option"), "Padre");
			listParenteso.selectByVisibleText("Padre");
		}
		isDisplayed(porcBeneficiario);
		elementoVisible(porcBeneficiario);
		moverMouse(porcBeneficiario);
		elementoClickeable(nombreBeneficiario);
		hacerClic(porcBeneficiario);
		escribirTexto(porcBeneficiario, "100");
		tomarCaptura(idecaso, "Seguro-"+tipo);
		isDisplayed(btnGuardar);
		elementoVisible(btnGuardar);
		moverMouse(btnGuardar);
		elementoClickeable(btnGuardar);
		hacerClic(btnGuardar);
		Thread.sleep(1000);
		aceptarAlerta();
		defaultContent();
	}
	
	public void voySeguroHogar(String idecaso) throws IOException {
		isDisplayed(agregarSeguro);
		elementoVisible(agregarSeguro);
		moverMouse(agregarSeguro);
		elementoClickeable(agregarSeguro);
		hacerClic(agregarSeguro);
		isDisplayed(iframeSeguro);
		elementoVisible(iframeSeguro);
		cambioIframeById("ifrm_Seg");
		isDisplayed(seleccionSeguro);
		elementoVisible(seleccionSeguro);
		moverMouse(seleccionSeguro);
		Select listSeguro = new Select(findElement(seleccionSeguro));
		listSeguro.selectByVisibleText("Voy Seguro Hogar");
		isDisplayed(tipoPlan);
		elementoVisible(tipoPlan);
		moverMouse(tipoPlan);
		Select listPlan = new Select(findElement(tipoPlan));
		listPlan.selectByVisibleText("P1");
		isDisplayed(valorPrima);
		elementoVisible(valorPrima);
		moverMouse(valorPrima);
		List<WebElement> opciones = findElementsOfElement(valorPrima,By.tagName("option"));
		opciones.get(1).click();
		isDisplayed(direccion);
		elementoVisible(direccion);
		moverMouse(direccion);
		elementoClickeable(direccion);
		hacerClic(direccion);
		escribirTexto(direccion, "Calle");
		isDisplayed(departamento);
		elementoVisible(departamento);
		moverMouse(departamento);
		quitarAtributo(departamento);
		elementoClickeable(departamento);
		hacerClic(departamento);
		escribirTexto(departamento, "BOYACA");
		isDisplayed(ideDepartamento);
		elementoVisible(ideDepartamento);
		moverMouse(ideDepartamento);
		quitarAtributo(ideDepartamento);
		elementoClickeable(ideDepartamento);
		hacerClic(ideDepartamento);
		escribirTexto(ideDepartamento, "15");
		isDisplayed(ciudad);
		elementoVisible(ciudad);
		moverMouse(ciudad);
		quitarAtributo(ciudad);
		elementoClickeable(ciudad);
		hacerClic(ciudad);
		escribirTexto(ciudad, "BUSBANZA");
		isDisplayed(ideCiudad);
		elementoVisible(ideCiudad);
		moverMouse(ideCiudad);
		quitarAtributo(ideCiudad);
		elementoClickeable(ideCiudad);
		hacerClic(ideCiudad);
		escribirTexto(ideCiudad, "15240");
		isDisplayed(uso);
		elementoVisible(uso);
		moverMouse(uso);
		Select listUso = new Select(findElement(uso));
		listUso.selectByVisibleText("Familiar");
		isDisplayed(tipoInmueble);
		elementoVisible(tipoInmueble);
		moverMouse(tipoInmueble);
		Select listTipoInmueble = new Select(findElement(tipoInmueble));
		listTipoInmueble.selectByVisibleText("Urbano");
		isDisplayed(numPisos);
		elementoVisible(numPisos);
		moverMouse(numPisos);
		elementoClickeable(numPisos);
		hacerClic(numPisos);
		escribirTexto(numPisos, "2");
		isDisplayed(numSotanos);
		elementoVisible(numSotanos);
		moverMouse(numSotanos);
		elementoClickeable(numSotanos);
		hacerClic(numSotanos);
		escribirTexto(numSotanos, "2");
		tomarCaptura(idecaso, "Seguro-Voy Seguro Hogar");
		isDisplayed(btnGuardar);
		elementoVisible(btnGuardar);
		moverMouse(btnGuardar);
		elementoClickeable(btnGuardar);
		hacerClic(btnGuardar);
		aceptarAlerta();
		defaultContent();
	}
}
