package PageObjects;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class loguinFormiik extends Base{

	public loguinFormiik(WebDriver driver) {
		super(driver);
	}
	   
	//INSTANCIA DE LOS LOCALIZADORES WEB
	By campoUser = By.id("userName");
	By campoPassword = By.id("password");
	By botonEnviar = By.id("submit");
	// ELEMENTOS CREAR ORDEN
	By btnOrdenes = By.id("MainMenu.lnkOrdenesAdministracion");
	By btnNuevaOrden = By.id("MainMenu.lnkNuevaOrden");
	By selectProceso = By.id("cmbProduct");
	By selectForm = By.id("cmbFormType");
	By btnSiguiente = By.id("btnCreateWorkOrder");
	//ELEMENTOS CONSULTA CLIENTE
	By tipoDocumento = By.id("TipIdeCli");
	By numeroIdentificacion = By.id("IdeCli");
	By confirmarIdentificacion = By.id("ConIdeCli");
	By paisOriIdentificacion = By.id("PaiOri");
	By razonSocial = By.id("NomNegCon");
	By primerApellido = By.id("PriApeCliConCli");
	By primerNombre = By.id("PriNomCliConCli");
	By autorizaAlivio = By.id("DeuAliv");
	By btnConsulta = By.id("ConCli");
	By alertaClienteNuevo = By.xpath("//p[contains(text(),'No se encontro informacion del cliente, Es un cliente nuevo')]");
	By alertaClienteExistente = By.xpath("//p[contains(text(),'Cliente consultado')]");
	By alertaConsulta = By.xpath("//p[contains(text(),'Cliente') or contains(text(),'cliente')]");
	By alertaErrorConsulta = By.xpath("//p[contains(text(),'Se ha presentado un error al consultar cliente.')]");
	By btnAceptar = By.xpath("//span[contains(text(),'Aceptar')]");
	By btnSiguiente0 = By.id("btnNext_0");
	By tabRadicacion = By.xpath("//h3[contains(text(),'Consulta Cliente')]");
	By tabConsultaCliente = By.xpath("//h3[contains(text(),'Consulta Cliente')]");
	By labelIden = By.xpath("//label[contains(text(),'Número de identificación')]");
	//BUSQUEDA DE SOLICITUD
	By filtro = By.id("filter");
	By tipoFiltro = By.id("filterExternalType");
	By aplicarFiltro = By.id("filterAply");
	By tablaSolicitudes = By.id("allView");
	By trSolicitudes = By.tagName("tr");
	By nextPage = By.className("nextPage");
	
	static String resultadoCliente = "";

	public void loguin(String idecaso,String usuario, String password) throws IOException {
		crearDirectorio(idecaso);
		isDisplayed(campoUser);
		elementoVisible(campoUser);
		elementoClickeable(campoUser);
		hacerClic(campoUser);
		escribirTexto(campoUser, usuario);
		isDisplayed(campoPassword);
		elementoVisible(campoPassword);
		elementoClickeable(campoPassword);
		hacerClic(campoPassword);
		escribirTexto(campoPassword, password);
		tomarCaptura(idecaso, "01-loguin");
		isDisplayed(botonEnviar);
		elementoVisible(botonEnviar);
		elementoClickeable(botonEnviar);
		hacerClic(botonEnviar);
	}
	
	public void crearNuevaOrden(String idecaso,String tipoSolicitud, String perfil) throws IOException {
		isDisplayed(btnOrdenes);
		elementoVisible(btnOrdenes);
		elementoClickeable(btnOrdenes);
		hacerClic(btnOrdenes);
		isDisplayed(btnNuevaOrden);
		elementoVisible(btnNuevaOrden);
		elementoClickeable(btnNuevaOrden);
		hacerClic(btnNuevaOrden);
		isDisplayed(selectProceso);
		elementoVisible(selectProceso);
		elementoClickeable(selectProceso);
		Select dropProceso = new Select(findElement(selectProceso));
		if (perfil.contains("asesor") || perfil.contains("contact")) {
			waitOpcionesLista(selectProceso, By.tagName("option"), "Radicación Asesores");
			dropProceso.selectByVisibleText("Radicación Asesores");
		}
		if (perfil.contains("analista")) {
			waitOpcionesLista(selectProceso, By.tagName("option"), "Gestión de Solicitudes");
			dropProceso.selectByVisibleText("Gestión de Solicitudes");
		}
		isDisplayed(selectForm);
		elementoVisible(selectForm);
		elementoClickeable(selectForm);
		Select dropForm = new Select(findElement(selectForm));
		dropForm.selectByVisibleText(tipoSolicitud);
		tomarCaptura(idecaso, "02-tipoOrden");
		isDisplayed(btnSiguiente);
		elementoVisible(btnSiguiente);
		elementoClickeable(btnSiguiente);
		hacerClic(btnSiguiente);
	}
	
	public void consultaCliente(String idecaso,String tipoDoc, String identificacion, String apellido, String nombre, String perfil) throws IOException, InterruptedException {
		isDisplayed(tipoDocumento);
		elementoVisible(tipoDocumento);
		elementoClickeable(tipoDocumento);
		hacerClic(tipoDocumento);
		Select dropTipoDoc = new Select(findElement(By.id("TipIdeCli")));
		if (tipoDoc.contains("Cc")) {
			tipoDoc = "Cédula Ciudadanía";
		}
		if (tipoDoc.contains("Ce")) {
			tipoDoc = "Cédula Extranjería";
		}
		dropTipoDoc.selectByVisibleText(tipoDoc);
		isDisplayed(numeroIdentificacion);
		elementoVisible(numeroIdentificacion);
		elementoClickeable(numeroIdentificacion);
		hacerClic(numeroIdentificacion);
		escribirTexto(numeroIdentificacion, identificacion);
		isDisplayed(confirmarIdentificacion);
		elementoVisible(confirmarIdentificacion);
		elementoClickeable(confirmarIdentificacion);
		hacerClic(confirmarIdentificacion);
		escribirTexto(confirmarIdentificacion, identificacion);
		isDisplayed(paisOriIdentificacion);
		elementoVisible(paisOriIdentificacion);
		elementoClickeable(paisOriIdentificacion);
		hacerClic(paisOriIdentificacion);
		escribirTexto(paisOriIdentificacion, "Colombia");
		isDisplayed(primerApellido);
		elementoVisible(primerApellido);
		elementoClickeable(primerApellido);
		hacerClic(primerApellido);
		escribirTexto(primerApellido, apellido);
		isDisplayed(primerNombre);
		elementoVisible(primerNombre);
		elementoClickeable(primerNombre);
		hacerClic(primerNombre);
		escribirTexto(primerNombre, nombre);
		if (perfil.contains("analista")) {
			isDisplayed(autorizaAlivio);
			elementoVisible(autorizaAlivio);
			elementoClickeable(autorizaAlivio);
			hacerClic(autorizaAlivio);
		}
		isDisplayed(btnConsulta);
		elementoVisible(btnConsulta);
		elementoClickeable(btnConsulta);
		hacerClic(btnConsulta);
		isDisplayed(alertaConsulta);
		elementoVisible(alertaConsulta);
		boolean errorConsulta = validarExistencia(alertaErrorConsulta);
		if (errorConsulta == true) {
			tomarCaptura(idecaso, "Error-Consulta-Cliente");
			driver.close();
		}
		boolean clienteNuevo = validarExistencia(alertaClienteNuevo);
		boolean clienteExistente = validarExistencia(alertaClienteExistente);
		if (clienteNuevo == true) {
			resultadoCliente = "nuevo";
		}
		if (clienteExistente == true) {
			resultadoCliente = "existente";
		}
		isDisplayed(btnAceptar);
		elementoVisible(btnAceptar);
		elementoClickeable(btnAceptar);
		tomarCaptura(idecaso, "04-clienteConsultado");
		hacerClic(btnAceptar);
		Thread.sleep(1000);
		tomarCaptura(idecaso, "03-datosConsulta");
		isDisplayed(btnSiguiente0);
		elementoVisible(btnSiguiente0);
		elementoClickeable(btnSiguiente0);
		hacerClic(btnSiguiente0);
		//cambiarDeElementoaOtro(btnSiguiente0, tabConsultaCliente);
//		isDisplayed(tabRadicacion);
//		elementoVisible(tabRadicacion);
		//elementoClickeable(tabRadicacion);
//		hacerClic(tabRadicacion);
//		cambiarDeElementoaOtro(tabConsultaCliente,tabRadicacion);
	}
	//METODO DE ANALISIS A SOLICITUDES RADICADAS POR ASESOR
	public void filtroSolicitud(String tipoSoli, String solicitud) {
		isDisplayed(filtro);
		elementoVisible(filtro);
		elementoClickeable(filtro);
		hacerClic(filtro);
		isDisplayed(tipoFiltro);
		elementoVisible(tipoFiltro);
		elementoClickeable(tipoFiltro);
		Select listTipoFiltro = new Select(findElement(tipoFiltro));
		listTipoFiltro.selectByVisibleText(tipoSoli);
		isDisplayed(aplicarFiltro);
		elementoVisible(aplicarFiltro);
		elementoClickeable(aplicarFiltro);
		hacerClic(aplicarFiltro);
		resultadoConsulta(tablaSolicitudes, trSolicitudes, nextPage, solicitud);
		isDisplayed(btnSiguiente0);
		elementoVisible(btnSiguiente0);
		moverMouse(btnSiguiente0);
		elementoClickeable(btnSiguiente0);
		hacerClic(btnSiguiente0);
	}
	
	public String resultCliente (String valorCliente) {
		return valorCliente;
	}
}
