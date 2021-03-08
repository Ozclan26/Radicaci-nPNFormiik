package PageObjects;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class radicarSolicitud extends Base {

	public radicarSolicitud(WebDriver driver) {
		super(driver);
	}

	loguinFormiik resul = new loguinFormiik(driver);
	// INSTANCIA DE LOS LOCALIZADORES WEB
	// CLIENTE NUEVO
	By apellidoCliente = By.id("PriApeCli");
	By nombreCliente = By.id("PriNomCli");
	By fechaNacimiento = By.id("FecNacCli");
	By fechaExpedicion = By.id("FecExpIdeCli");
	By generoCliente = By.id("GenCli");
	By direccionResi = By.id("DirResCli");
	By actividadCiiu = By.id("NomAct");
	By ideActividad = By.id("IdeAct");
	// CLIENTE EXISTENTE
	By lugarNacimiento = By.id("LugNacCli");
	By paisNacimiento = By.id("PaiNac");
	By departamentoNacimiento = By.id("DepNac");
	By ciudadNacimiento = By.id("CiuNac");
	By nacionalidadCliente = By.id("NcnCli");
	By depExpedicion = By.id("DepExp");
	By lugarExpedicion = By.id("LugExpIdeCli");
	By otraNacionalidadNo = By.id("TieOtrNacCli_1");
	By tributaOtroPaisNo = By.id("TieResOtrPaiCli_1");
	By permanenciaPaisNo = By.id("CliPerPai_1");
	By estadoCivil = By.id("EstCivCli");
	By tieneHijos = By.id("TieHij");
	By personasCargo = By.id("PerCarCli");
	By composicionFliarNo = By.id("DilComFam_1");
	By afiliciacionSalud = By.id("TipSalCli");
	By accesoInternet = By.id("AccIntCli");
	// INFO CONTACTO Y RESIDENCIA
	By zonaResidencia = By.id("ZonResi");
	By referenciaResidencia = By.id("RefCli");
	By paisResidencia = By.id("PaiResCli");
	// CONSULTAR BARRIO
	By barrioCliente = By.id("NomBarResCli");
	By codBarrio = By.id("IdeBarResCli");
	// CAMPOS DESPUES DE CIUDAD
	By estratoCliente = By.id("EtrCli");
	By tipoNumContacto = By.id("TipNumCon");
	By celuCliente = By.id("CelCli");
	By tipoVivienda = By.id("TipVivCli");
	By mesesPermanencia = By.id("MesPerVivCli");
	By noCorreo = By.id("PosCorEle_1");
	By nivelEducativo = By.id("NivEduCli");
	By ultimoAñoCursado = By.id("UltAnoCur");
	By ocupacionCliente = By.id("OcuCli");
	By profesionCliente = By.id("ProfSoli");
	By noPep = By.id("EsCliPep_1");
	By siPep = By.id("EsCliPep_0");
	By tipoPep = By.id("TipPep");
	By noReincorporado = By.id("CliRei_1");
	By noVinculoLaboral = By.id("EstVinLabCli_1");
	By ubicacionNeg = By.id("NegEnDom");
	By zonaNeg = By.id("ZonMicro");
	By dirNeg = By.id("DirNeg");
	By refeNeg = By.id("RefMicro");
	By tipoLocal = By.id("TipLocNeg");
	By paisNeg = By.id("PaiResNeg");
	By nombreBarrioeg = By.id("NomBarNeg");
	By codBarrioeg = By.id("IdeBarNeg");

	By nombreNegocio = By.id("NomNeg");
	By tipoConNegocio = By.id("TipNumConNeg");
	By celNegocio = By.id("CelNeg");
	By noCamara = By.id("RegCamComNeg_1");
	By tiempoFunNegocio = By.id("TieFunNeg");
	By ventasAnuales = By.id("VenBruAnu");
	By noOtraActividad = By.id("TieOtrActEco_1");
	By numeroEmpleados = By.id("NumEmpNeg");
	// ELEMENTOS INFO CRÉDITO
	By tipoCredit = By.id("TipCre");
	By productoCredito = By.id("Pro");
	By montoSolicitado = By.id("MonSol");
	By plazoSolicitado = By.id("PlaSol");
	By frecuenciaPago = By.id("FrePag");
	By noReestructuracion = By.id("EsRee_1");
	By siReestructuracion = By.id("EsRee_0");
	By creditosRestructurar = By.id("CanCreARee");
	By origenSoli = By.id("OriSolCre");
	By dondeRecibeInfo = By.id("DonReciExtraSolCre");
	// SELECCIÓN ANALISTA
	By tipoConsultaAnalista = By.id("TipConAna");
	By agenciaAnalista = By.id("AgeConAna");
	By btnConsultaAnalista = By.id("ConAna");
	By analistaCredito = By.id("Ana");
	// EFECTUAR RADICACIÓN
	By btnRadicar = By.id("EfeRad");
	By alertaRadicacion = By.xpath("//p[contains(text(),'Radicación exitosa')]");
	By btnAceptar = By.xpath("//span[contains(text(),'Aceptar')]");
	By solicitudCreada = By.xpath("//div[@id=\"orderForm\"]/h2");
	By numSolCreada = By.id("NumSolCre");
	By btnGuardar = By.id("btnSubmit");
	By alertaDatosGuardar = By.xpath("//p[contains(text(),'Los datos serán guardados. ¿Continuar?')]");
	By alertaDatosGuardados = By.xpath("//td[contains(text(),'Los datos fueron guardados')]");
	By btnSiguiente = By.id("btnNext_1");
	By radicacion = By.xpath("//h3[contains(text(),'Radicación')]");
	By mensajeRespuesta = By.id("MenResRad");
	By tituloCredito = By.xpath("//h4[contains(text(), 'Información del crédito')]");
	By labelProducto = By.xpath("//label[contains(text(), 'Tipo de Producto')]");
	By labelCiudad = By.xpath("//label[contains(text(), 'Ciudad expedición de identificación del solicitante')]");
	By tituloSolicitudSOLN = By.xpath("//h2[contains(text(),'SOLN')]");
	By tituloSolicitudRADN = By.xpath("//h2[contains(text(),'RADN')]");
	By tituloSolicitudSOLJ = By.xpath("//h2[contains(text(),'SOLJ')]");
	By tituloSolicitudRADJ = By.xpath("//h2[contains(text(),'RADJ')]");
	static String solicitud = "";

	public void realizarRadicacion(String apellido, String nombre, String idecaso, String barrio, String codigoBarrio,
			String estrato, String pep, String actividadRiesgosa,String perfil) throws IOException {
		String tipoCliente = loguinFormiik.resultadoCliente;
		if (perfil.contains("analista")) {
			cambiarDeElementoaOtro(depExpedicion, tituloSolicitudSOLN);
		}
		if (tipoCliente.contains("nuevo")) {
			isDisplayed(apellidoCliente);
			elementoVisible(apellidoCliente);
			elementoClickeable(apellidoCliente);
			hacerClic(apellidoCliente);
			cleanTest(apellidoCliente);
			escribirTexto(apellidoCliente, apellido);
			isDisplayed(nombreCliente);
			elementoVisible(nombreCliente);
			elementoClickeable(nombreCliente);
			hacerClic(nombreCliente);
			cleanTest(nombreCliente);
			escribirTexto(nombreCliente, nombre);
			isDisplayed(fechaNacimiento);
			elementoVisible(fechaNacimiento);
			quitarAtributo(fechaNacimiento);
			elementoClickeable(fechaNacimiento);
			hacerClic(fechaNacimiento);
			cleanTest(fechaNacimiento);
			escribirTexto(fechaNacimiento, "26/10/1989");
			// escribirTexto(fechaNacimiento, "26/05/1945");
		}
		isDisplayed(paisNacimiento);
		elementoVisible(paisNacimiento);
		elementoClickeable(paisNacimiento);
		Select listPaisNaci = new Select(findElement(paisNacimiento));
		listPaisNaci.selectByVisibleText("Colombia");
		isDisplayed(departamentoNacimiento);
		elementoVisible(departamentoNacimiento);
		elementoClickeable(departamentoNacimiento);
		Select listDepNaci = new Select(findElement(departamentoNacimiento));
		listDepNaci.selectByVisibleText("Bogotá D.C.");
		isDisplayed(ciudadNacimiento);
		elementoVisible(ciudadNacimiento);
		elementoClickeable(ciudadNacimiento);
		Select listCiuNaci = new Select(findElement(ciudadNacimiento));
		listCiuNaci.selectByVisibleText("BOGOTÁ, D.C.");
		if (tipoCliente.contains("nuevo")) {
			isDisplayed(fechaExpedicion);
			elementoVisible(fechaExpedicion);
			quitarAtributo(fechaExpedicion);
			elementoClickeable(fechaExpedicion);
			hacerClic(fechaExpedicion);
			cleanTest(fechaExpedicion);
			escribirTexto(fechaExpedicion, "29/10/2008" + Keys.ENTER);
			// escribirTexto(fechaExpedicion, "30/05/1963");
		}
		isDisplayed(depExpedicion);
		elementoVisible(depExpedicion);
		elementoClickeable(depExpedicion);
		Select listDepExp= new Select(findElement(depExpedicion));
		listDepExp.selectByVisibleText("Antioquia");
		isDisplayed(lugarExpedicion);
		elementoVisible(lugarExpedicion);
		elementoClickeable(lugarExpedicion);
		Select listCiuExp= new Select(findElement(lugarExpedicion));
		//waitOpcionesLista(lugarExpedicion, By.tagName("option"), "MEDELLÍN");
		listCiuExp.selectByVisibleText("MEDELLÍN");
		if (tipoCliente.contains("nuevo")) {
			isDisplayed(nacionalidadCliente);
			elementoVisible(nacionalidadCliente);
			elementoClickeable(nacionalidadCliente);
			Select listaNacionalidad= new Select(findElement(nacionalidadCliente));
			listaNacionalidad.selectByVisibleText("Colombia");
		}
		isDisplayed(otraNacionalidadNo);
		elementoVisible(otraNacionalidadNo);
		elementoClickeable(otraNacionalidadNo);
		hacerClic(otraNacionalidadNo);
		isDisplayed(tributaOtroPaisNo);
		elementoVisible(tributaOtroPaisNo);
		elementoClickeable(tributaOtroPaisNo);
		hacerClic(tributaOtroPaisNo);
		tomarCaptura(idecaso, "05-radicacion1");
		isDisplayed(permanenciaPaisNo);
		elementoVisible(permanenciaPaisNo);
		elementoClickeable(permanenciaPaisNo);
		hacerClic(permanenciaPaisNo);
		if (tipoCliente.contains("nuevo")) {
			isDisplayed(generoCliente);
			elementoVisible(generoCliente);
			elementoClickeable(generoCliente);
			Select listaGenero = new Select(findElement(generoCliente));
			listaGenero.selectByVisibleText("Masculino");
		}
		isDisplayed(estadoCivil);
		elementoVisible(estadoCivil);
		elementoClickeable(estadoCivil);
		Select listaEstadoCivil = new Select(findElement(estadoCivil));
		listaEstadoCivil.selectByVisibleText("Soltero(a)");
		isDisplayed(tieneHijos);
		elementoVisible(tieneHijos);
		elementoClickeable(tieneHijos);
		hacerClic(tieneHijos);
		cleanTest(tieneHijos);
		escribirTexto(tieneHijos, "0");
		isDisplayed(personasCargo);
		elementoVisible(personasCargo);
		elementoClickeable(personasCargo);
		hacerClic(personasCargo);
		cleanTest(personasCargo);
		escribirTexto(personasCargo, "0");
		isDisplayed(composicionFliarNo);
		elementoVisible(composicionFliarNo);
		elementoClickeable(composicionFliarNo);
		hacerClic(composicionFliarNo);
		isDisplayed(afiliciacionSalud);
		elementoVisible(afiliciacionSalud);
		elementoClickeable(afiliciacionSalud);
		Select listaSalud = new Select(findElement(afiliciacionSalud));
		listaSalud.selectByVisibleText("SISBEN");
		isDisplayed(accesoInternet);
		elementoVisible(accesoInternet);
		elementoClickeable(accesoInternet);
		Select listaInternet = new Select(findElement(accesoInternet));
		listaInternet.selectByVisibleText("Trabajo");
		isDisplayed(noCorreo);
		elementoVisible(noCorreo);
		elementoClickeable(noCorreo);
		hacerClic(noCorreo);
		isDisplayed(nivelEducativo);
		elementoVisible(nivelEducativo);
		elementoClickeable(nivelEducativo);
		Select listaNivelEducativo = new Select(findElement(nivelEducativo));
		listaNivelEducativo.selectByVisibleText("Primaria");
		isDisplayed(ultimoAñoCursado);
		elementoVisible(ultimoAñoCursado);
		elementoClickeable(ultimoAñoCursado);
		hacerClic(ultimoAñoCursado);
		cleanTest(ultimoAñoCursado);
		escribirTexto(ultimoAñoCursado, "11");
		isDisplayed(profesionCliente);
		elementoVisible(profesionCliente);
		elementoClickeable(profesionCliente);
		Select listaProfesion = new Select(findElement(profesionCliente));
		int valor = (int) (Math.random() * 256 + 1);
		listaProfesion.selectByValue(String.valueOf(valor));
		isDisplayed(noReincorporado);
		elementoVisible(noReincorporado);
		elementoClickeable(noReincorporado);
		hacerClic(noReincorporado);
		// AQUI VA SI ES PEP O NO
		if (pep.contains("Si") || pep.contains("si")) {
			isDisplayed(siPep);
			elementoVisible(siPep);
			elementoClickeable(siPep);
			hacerClic(siPep);
			isDisplayed(tipoPep);
			elementoVisible(tipoPep);
			elementoClickeable(tipoPep);
			List<WebElement> tipos = findElementsOfElement(tipoPep, By.tagName("option"));
			tipos.get(3).click();
		} else {
			isDisplayed(noPep);
			elementoVisible(noPep);
			elementoClickeable(noPep);
			hacerClic(noPep);
		}
		// INFORMACIÓN CONTACTO Y RESIDENCIA
		isDisplayed(zonaResidencia);
		elementoVisible(zonaResidencia);
		elementoClickeable(zonaResidencia);
		Select listZonaNaci = new Select(findElement(zonaResidencia));
		listZonaNaci.selectByVisibleText("Urbano");
		if (tipoCliente.contains("nuevo")) {
			isDisplayed(direccionResi);
			elementoVisible(direccionResi);
			quitarAtributo(direccionResi);
			moverMouse(direccionResi);
			elementoClickeable(direccionResi);
			cleanTest(direccionResi);
			escribirTexto(direccionResi, "carrera 6ta");
		}
		isDisplayed(referenciaResidencia);
		elementoVisible(referenciaResidencia);
		quitarAtributo(referenciaResidencia);
		moverMouse(referenciaResidencia);
		elementoClickeable(referenciaResidencia);
		cleanTest(referenciaResidencia);
		escribirTexto(referenciaResidencia, "Frente al estadio");
		isDisplayed(paisResidencia);
		elementoVisible(paisResidencia);
		elementoClickeable(paisResidencia);
		Select listaPaisResidencia = new Select(findElement(paisResidencia));
		listaPaisResidencia.selectByVisibleText("Colombia");
		// NUEVA FORMA DE OBTENER EL BARRIO
		isDisplayed(barrioCliente);
		elementoVisible(barrioCliente);
		quitarAtributo(barrioCliente);
		moverMouse(barrioCliente);
		elementoClickeable(barrioCliente);
		cleanTest(barrioCliente);
		escribirTexto(barrioCliente, barrio);
		isDisplayed(codBarrio);
		elementoVisible(codBarrio);
		quitarAtributo(codBarrio);
		moverMouse(codBarrio);
		elementoClickeable(codBarrio);
		cleanTest(codBarrio);
		escribirTexto(codBarrio, codigoBarrio);
		isDisplayed(estratoCliente);
		elementoVisible(estratoCliente);
		elementoClickeable(estratoCliente);
		Select listaEstrato = new Select(findElement(estratoCliente));
		listaEstrato.selectByVisibleText("Estrato 2");
		isDisplayed(tipoNumContacto);
		elementoVisible(tipoNumContacto);
		elementoClickeable(tipoNumContacto);
		Select listaNumContacto = new Select(findElement(tipoNumContacto));
		listaNumContacto.selectByVisibleText("Celular");
		tomarCaptura(idecaso, "06-radicacion2");
		if (perfil.contains("analista")) {
			isDisplayed(celuCliente);
			elementoVisible(celuCliente);
			elementoClickeable(celuCliente);
			hacerClic(celuCliente);
			cleanTest(celuCliente);
			escribirTexto(celuCliente, "3214569874");
		}
		isDisplayed(tipoVivienda);
		elementoVisible(tipoVivienda);
		elementoClickeable(tipoVivienda);
		Select listaVivienda = new Select(findElement(tipoVivienda));
		listaVivienda.selectByVisibleText("Propia sin deuda");
		isDisplayed(mesesPermanencia);
		elementoVisible(mesesPermanencia);
		quitarAtributo(mesesPermanencia);
		moverMouse(mesesPermanencia);
		elementoClickeable(mesesPermanencia);
		cleanTest(mesesPermanencia);
		escribirTexto(mesesPermanencia, "01/01/2000");
		// INFORMACIÓN DEL NEGOCIO
		isDisplayed(ocupacionCliente);
		elementoVisible(ocupacionCliente);
		elementoClickeable(ocupacionCliente);
		Select listaOcupacion = new Select(findElement(ocupacionCliente));
		listaOcupacion.selectByVisibleText("Empleado Con Negocio");
		isDisplayed(nombreNegocio);
		elementoVisible(nombreNegocio);
		elementoClickeable(nombreNegocio);
		hacerClic(nombreNegocio);
		cleanTest(nombreNegocio);
		escribirTexto(nombreNegocio, "Mi Negocio");
		isDisplayed(ubicacionNeg);
		elementoVisible(ubicacionNeg);
		elementoClickeable(ubicacionNeg);
		Select listaUbicacionNeg = new Select(findElement(ubicacionNeg));
		listaUbicacionNeg.selectByVisibleText("Local Comercial");
		isDisplayed(zonaNeg);
		elementoVisible(zonaNeg);
		elementoClickeable(zonaNeg);
		Select listZonaNeg = new Select(findElement(zonaNeg));
		listZonaNeg.selectByVisibleText("Urbano");
		isDisplayed(dirNeg);
		elementoVisible(dirNeg);
		moverMouse(dirNeg);
		elementoClickeable(dirNeg);
		cleanTest(dirNeg);
		escribirTexto(dirNeg, "Calle 12");
		isDisplayed(refeNeg);
		elementoVisible(refeNeg);
		moverMouse(refeNeg);
		elementoClickeable(refeNeg);
		cleanTest(refeNeg);
		escribirTexto(refeNeg, "Frente al parque");
		isDisplayed(tipoLocal);
		elementoVisible(tipoLocal);
		elementoClickeable(tipoLocal);
		Select listaLocal = new Select(findElement(tipoLocal));
		listaLocal.selectByVisibleText("Familiar");
		tomarCaptura(idecaso, "07-radicacion3");
		isDisplayed(paisNeg);
		elementoVisible(paisNeg);
		elementoClickeable(paisNeg);
		Select listaPaisNeg = new Select(findElement(paisNeg));
		listaPaisNeg.selectByVisibleText("Colombia");
		isDisplayed(nombreBarrioeg);
		elementoVisible(nombreBarrioeg);
		quitarAtributo(nombreBarrioeg);
		moverMouse(nombreBarrioeg);
		elementoClickeable(nombreBarrioeg);
		cleanTest(nombreBarrioeg);
		escribirTexto(nombreBarrioeg, barrio);
		isDisplayed(codBarrioeg);
		elementoVisible(codBarrioeg);
		quitarAtributo(codBarrioeg);
		moverMouse(codBarrioeg);
		elementoClickeable(codBarrioeg);
		cleanTest(codBarrioeg);
		escribirTexto(codBarrioeg, codigoBarrio);
		isDisplayed(tipoConNegocio);
		elementoVisible(tipoConNegocio);
		elementoClickeable(tipoConNegocio);
		Select contactoNegocio = new Select(findElement(tipoConNegocio));
		contactoNegocio.selectByVisibleText("Celular");
		if (perfil.contains("analista")) {
			isDisplayed(celNegocio);
			elementoVisible(celNegocio);
			elementoClickeable(celNegocio);
			hacerClic(celNegocio);
			cleanTest(celNegocio);
			escribirTexto(celNegocio, "3214569874");
		}
		isDisplayed(noCamara);
		elementoVisible(noCamara);
		elementoClickeable(noCamara);
		hacerClic(noCamara);
		isDisplayed(tiempoFunNegocio);
		elementoVisible(tiempoFunNegocio);
		quitarAtributo(tiempoFunNegocio);
		moverMouse(tiempoFunNegocio);
		elementoClickeable(tiempoFunNegocio);
		cleanTest(tiempoFunNegocio);
		escribirTexto(tiempoFunNegocio, "01/01/2000");
		//escribirTexto(tiempoFunNegocio, "31/12/2020");
		if (actividadRiesgosa.contains("Si") || actividadRiesgosa.contains("si")) {
			isDisplayed(actividadCiiu);
			elementoVisible(actividadCiiu);
			quitarAtributo(actividadCiiu);
			elementoClickeable(actividadCiiu);
			hacerClic(actividadCiiu);
			cleanTest(actividadCiiu);
			escribirTexto(actividadCiiu, "Actividades de juegos de azar y apuestas");
			isDisplayed(ideActividad);
			elementoVisible(ideActividad);
			quitarAtributo(ideActividad);
			elementoClickeable(ideActividad);
			hacerClic(ideActividad);
			cleanTest(ideActividad);
			escribirTexto(ideActividad, "9200");
		} else {
			isDisplayed(actividadCiiu);
			elementoVisible(actividadCiiu);
			quitarAtributo(actividadCiiu);
			elementoClickeable(actividadCiiu);
			hacerClic(actividadCiiu);
			cleanTest(actividadCiiu);
			escribirTexto(actividadCiiu, "Mantenimiento y reparacion de vehiculos automotores");
			isDisplayed(ideActividad);
			elementoVisible(ideActividad);
			quitarAtributo(ideActividad);
			elementoClickeable(ideActividad);
			hacerClic(ideActividad);
			cleanTest(ideActividad);
			escribirTexto(ideActividad, "4520");
		}
		if (tipoCliente.contains("nuevo")) {
			isDisplayed(actividadCiiu);
			elementoVisible(actividadCiiu);
			quitarAtributo(actividadCiiu);
			elementoClickeable(actividadCiiu);
			hacerClic(actividadCiiu);
			cleanTest(actividadCiiu);
			if (actividadRiesgosa.contains("Si") || actividadRiesgosa.contains("si")) {
				escribirTexto(actividadCiiu, "Actividades de juegos de azar y apuestas");
				isDisplayed(ideActividad);
				elementoVisible(ideActividad);
				quitarAtributo(ideActividad);
				elementoClickeable(ideActividad);
				hacerClic(ideActividad);
				cleanTest(ideActividad);
				escribirTexto(ideActividad, "9200");
			} else {
				escribirTexto(actividadCiiu, "Mantenimiento y reparacion de vehiculos automotores");
				isDisplayed(ideActividad);
				elementoVisible(ideActividad);
				quitarAtributo(ideActividad);
				elementoClickeable(ideActividad);
				hacerClic(ideActividad);
				cleanTest(ideActividad);
				escribirTexto(ideActividad, "4520");
			}
		}

		isDisplayed(ventasAnuales);
		elementoVisible(ventasAnuales);
		elementoClickeable(ventasAnuales);
		hacerClic(ventasAnuales);
		cleanTest(ventasAnuales);
		escribirTexto(ventasAnuales, "20000000");

		tomarCaptura(idecaso, "08-radicacion4");
		isDisplayed(noOtraActividad);
		elementoVisible(noOtraActividad);
		elementoClickeable(noOtraActividad);
		hacerClic(noOtraActividad);
		isDisplayed(numeroEmpleados);
		elementoVisible(numeroEmpleados);
		elementoClickeable(numeroEmpleados);
		hacerClic(numeroEmpleados);
		cleanTest(numeroEmpleados);
		escribirTexto(numeroEmpleados, "0");
		// INFORMACIÓN LABORAL DEL CLIENTE
		isDisplayed(noVinculoLaboral);
		elementoVisible(noVinculoLaboral);
		elementoClickeable(noVinculoLaboral);
		hacerClic(noVinculoLaboral);
	}

	public void datosCredito(String idecaso, String tipoCredito, String producto, String monto, String plazo,
			String frecuencia, String restructuracion) throws IOException, InterruptedException {
		isDisplayed(tipoCredit);
		elementoVisible(tipoCredit);
		elementoClickeable(tipoCredit);
		Select listaCredito = new Select(findElement(tipoCredit));
		listaCredito.selectByVisibleText(tipoCredito);
		isDisplayed(productoCredito);
		elementoVisible(productoCredito);
		elementoClickeable(productoCredito);
		findElementsOfElementTest(productoCredito, By.tagName("option"));
		Select listaProducto = new Select(findElement(productoCredito));
		listaProducto.selectByVisibleText(producto);
		isDisplayed(montoSolicitado);
		elementoVisible(montoSolicitado);
		elementoClickeable(montoSolicitado);
		hacerClic(montoSolicitado);
		escribirTexto(montoSolicitado, monto);
		isDisplayed(plazoSolicitado);
		elementoVisible(plazoSolicitado);
		elementoClickeable(plazoSolicitado);
		hacerClic(plazoSolicitado);
		escribirTexto(plazoSolicitado, plazo);
		isDisplayed(frecuenciaPago);
		elementoVisible(frecuenciaPago);
		elementoClickeable(frecuenciaPago);
		Select listaFrecuencia = new Select(findElement(frecuenciaPago));
		listaFrecuencia.selectByVisibleText(frecuencia);
		if (tipoCredito.contains("Microcrédito")) {
			String prod = producto;
			if (prod.contains("Gotahorro") == false) {
				if (restructuracion.equals("Si")) {
					isDisplayed(siReestructuracion);
					elementoVisible(siReestructuracion);
					elementoClickeable(siReestructuracion);
					hacerClic(siReestructuracion);
					Boolean existe = validarExistencia(creditosRestructurar);
					if (existe == true) {
						isDisplayed(creditosRestructurar);
						elementoVisible(creditosRestructurar);
						quitarAtributo(creditosRestructurar);
						int cantidad = obtenerInnerHtml(creditosRestructurar);
						if (cantidad > 0) {
							int numeroAleatorio = (int) (Math.random() * cantidad + 1);
							By selectCreditos = By.id("NumCreReeRad" + cantidad);
							isDisplayed(selectCreditos);
							elementoVisible(selectCreditos);
							elementoClickeable(selectCreditos);
							List<WebElement> campoCredito = findElementsOfElement(selectCreditos, By.tagName("option"));
							campoCredito.get(numeroAleatorio).click();
						} else {
							isDisplayed(noReestructuracion);
							elementoVisible(noReestructuracion);
							elementoClickeable(noReestructuracion);
							hacerClic(noReestructuracion);
						}
					}
				}
				if (restructuracion.equals("No")) {
					isDisplayed(noReestructuracion);
					elementoVisible(noReestructuracion);
					elementoClickeable(noReestructuracion);
					hacerClic(noReestructuracion);
				}
			}

		}
		isDisplayed(origenSoli);
		waitOpcionesLista(origenSoli, By.tagName("option"), "Volante");
		elementoVisible(origenSoli);
		elementoClickeable(origenSoli);
		Select listaOrigen = new Select(findElement(origenSoli));
		listaOrigen.selectByVisibleText("Volante");
		Thread.sleep(1000);
		tomarCaptura(idecaso, "10-Restructuracion");
		isDisplayed(dondeRecibeInfo);
		waitOpcionesLista(dondeRecibeInfo, By.tagName("option"), "Mensaje de Texto");
		elementoVisible(dondeRecibeInfo);
		elementoClickeable(dondeRecibeInfo);
		Select listaRecibeInfo = new Select(findElement(dondeRecibeInfo));
		listaRecibeInfo.selectByVisibleText("Mensaje de Texto");
	}

	public void seleccionAnalista(String idecaso, String agencia, String analista, String producto, String perfil)
			throws IOException {
		isDisplayed(tipoConsultaAnalista);
		elementoVisible(tipoConsultaAnalista);
		elementoClickeable(tipoConsultaAnalista);
		Select listaConsultaAnalista = new Select(findElement(tipoConsultaAnalista));
		listaConsultaAnalista.selectByVisibleText("Agencia");
		isDisplayed(agenciaAnalista);
		elementoVisible(agenciaAnalista);
		elementoClickeable(agenciaAnalista);
		findElementsOfElementTest(agenciaAnalista, By.tagName("option"));
		Select listaAgencia = new Select(findElement(agenciaAnalista));
		listaAgencia.selectByVisibleText(agencia);
		tomarCaptura(idecaso, "créditoEscogido");
		isDisplayed(btnConsultaAnalista);
		elementoVisible(btnConsultaAnalista);
		elementoClickeable(btnConsultaAnalista);
		hacerClic(btnConsultaAnalista);
		isDisplayed(analistaCredito);
		waitOpcionesLista(analistaCredito, By.tagName("option"), analista);
		elementoVisible(analistaCredito);
		elementoClickeable(analistaCredito);
		Select listaAnalista = new Select(findElement(analistaCredito));
		listaAnalista.selectByVisibleText(analista);
		tomarCaptura(idecaso, "10-analista");
		String desicion = "radicada";
		String restructuracion = "No";
		efectuarRadicacion(idecaso, producto, perfil, restructuracion, desicion);
	}

	public void efectuarRadicacion(String idecaso, String producto, String perfil, String restructuracion,
			String desicion) throws IOException {
		isDisplayed(btnRadicar);
		elementoVisible(btnRadicar);
		elementoClickeable(btnRadicar);
		hacerClic(btnRadicar);
		isDisplayed(alertaRadicacion);
		elementoVisible(alertaRadicacion);
		obtenerTexto(alertaRadicacion);
		if (perfil.contains("analista")) {
			tomarCaptura(idecaso, "11-radicacionEfectuada");
		} else {
			tomarCaptura(idecaso, "11-radicacionEfectuada");
		}
		isDisplayed(btnAceptar);
		elementoVisible(btnAceptar);
		elementoClickeable(btnAceptar);
		hacerClic(btnAceptar);
		isDisplayed(numSolCreada);
		elementoVisible(numSolCreada);
		quitarAtributo(numSolCreada);
		solicitud = getInnerHtml(numSolCreada);
		isDisplayed(solicitudCreada);
		elementoVisible(solicitudCreada);
		quitarAtributo(solicitudCreada);
		obtenerTexto(solicitudCreada);
		tomarCaptura(idecaso, "Número Solicitud");
		cambiarDeElementoaOtro(solicitudCreada, mensajeRespuesta);
		//tomarCaptura(idecaso, "INFO DEL CRÉDITO");
		tomarCaptura(idecaso, "09-datosCredito");
		exportarSolicitudes(obtenerTexto(solicitudCreada), producto, restructuracion, desicion, perfil);
		if (perfil.contains("asesor") || perfil.contains("contact")) {
			isDisplayed(btnGuardar);
			elementoVisible(btnGuardar);
			elementoClickeable(btnGuardar);
			hacerClic(btnGuardar);
			isDisplayed(alertaDatosGuardar);
			elementoVisible(alertaDatosGuardar);
			isDisplayed(btnAceptar);
			elementoVisible(btnAceptar);
			elementoClickeable(btnAceptar);
			hacerClic(btnAceptar);
			isDisplayed(alertaDatosGuardados);
			elementoVisible(alertaDatosGuardados);
			tomarCaptura(idecaso, "12-SolicitudGuardada");
			isDisplayed(btnAceptar);
			elementoVisible(btnAceptar);
			elementoClickeable(btnAceptar);
			hacerClic(btnAceptar);
		}
	}

	public void clienteConsultado() {
		isDisplayed(composicionFliarNo);
		elementoVisible(composicionFliarNo);
		moverMouse(composicionFliarNo);
		elementoClickeable(composicionFliarNo);
		hacerClic(composicionFliarNo);
		isDisplayed(afiliciacionSalud);
		elementoVisible(afiliciacionSalud);
		elementoClickeable(afiliciacionSalud);
		Select listaSalud = new Select(findElement(afiliciacionSalud));
		listaSalud.selectByVisibleText("SISBEN");
		isDisplayed(accesoInternet);
		elementoVisible(accesoInternet);
		elementoClickeable(accesoInternet);
		Select listaInternet = new Select(findElement(accesoInternet));
		listaInternet.selectByVisibleText("Trabajo");
		isDisplayed(tipoNumContacto);
		elementoVisible(tipoNumContacto);
		elementoClickeable(tipoNumContacto);
		Select listaNumContacto = new Select(findElement(tipoNumContacto));
		listaNumContacto.selectByVisibleText("Celular");
		isDisplayed(celuCliente);
		elementoVisible(celuCliente);
		elementoClickeable(celuCliente);
		hacerClic(celuCliente);
		cleanTest(celuCliente);
		escribirTexto(celuCliente, "3214569874");
		isDisplayed(ultimoAñoCursado);
		elementoVisible(ultimoAñoCursado);
		elementoClickeable(ultimoAñoCursado);
		hacerClic(ultimoAñoCursado);
		cleanTest(ultimoAñoCursado);
		escribirTexto(ultimoAñoCursado, "11");
	}

	public void clicMenuRadicacion() {
		isDisplayed(radicacion);
		elementoVisible(radicacion);
		moverMouse(radicacion);
		elementoClickeable(radicacion);
		hacerClic(radicacion);
	}

	public void añadirReestructuracion(String producto) {
		isDisplayed(siReestructuracion);
		elementoVisible(siReestructuracion);
		elementoClickeable(siReestructuracion);
		hacerClic(siReestructuracion);
	}

	public void exportarSolicitudes(String identificacion, String solConsulta, String tipoSol, String user,
			String perfil, String producto, String monto, String plazo, String restructuracion, String voySeg,
			String familia, String excequial, String hogar) throws EncryptedDocumentException, IOException {
		if (perfil.equals("consulta")) {
			escribir(identificacion, solConsulta, tipoSol, user, perfil, producto, monto, plazo, restructuracion,
					voySeg, familia, excequial, hogar);
		}
		if (perfil.equals("analista")) {
			escribir(identificacion, solicitud, tipoSol, user, perfil, producto, monto, plazo, restructuracion, voySeg,
					familia, excequial, hogar);
		}
		if (perfil.equals("asesor") || perfil.equals("contact")) {
			escribir(identificacion, solicitud, tipoSol, user, perfil, producto, monto, plazo, restructuracion, voySeg,
					familia, excequial, hogar);
		}
	}

}
