package StepDefinitions;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import StepsFormiik.StepsAppFormiik;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="D:\\Insumos\\testFormiik.csv", separator=';')
//@UseTestDataFrom(value="src/test/resources/Data/testFormiik.csv")
//@UseTestDataFrom(value="src/test/resources/Data/testFormiik.csv", separator=';')
public class StepDefinitionsFormiik { 
	private String ideCaso;
	private String usuario;
	private String password;
	private String tipoSolicitud;
	private  String restructuracion;
	private String perfil;
	private String solicitud;
	private String tipoDoc;
	private String identificacion;
	private String apellido;
	private String nombre;
	private String barrio;
	private String codigoBarrio;
	private String estrato;
	private String tipoCredito;
	private String producto;
	private String monto;
	private String plazo;
	private String frecuencia;
	private String agencia;
	private String analista;
	private String totalVentas;
	private String fechaDesembolso;
	private String Fechacuota;
	private String desicionAnalista;
	private String voySeguro;
	private String familia;
	private String exequial;
	private String hogar;
	private String foto;
	private String recogerCreditos;
	private String esPep;
	private String actividadRiesgosa;
	private String desembolsoCuenta;
	
	public void setideCaso(String ideCaso)
	{
		this.ideCaso = ideCaso;
	}
	public void setusuario(String usuario)
	{
		this.usuario = usuario;
	}
	public void setpassword(String password)
	{
		this.password = password;
	}
	public void settipoSolicitud(String tipoSolicitud)
	{
		this.tipoSolicitud = tipoSolicitud;
	}
	public void setrestructuracion(String restructuracion)
	{
		this.restructuracion = restructuracion;
	}
	public void setperfil(String perfil)
	{
		this.perfil = perfil;
	}
	public void setsolicitud(String solicitud)
	{
		this.solicitud = solicitud;
	}
	public void settipoDoc(String tipoDoc)
	{
		this.tipoDoc = tipoDoc;
	}
	public void setidentificacion(String identificacion)
	{
		this.identificacion = identificacion;
	}
	public void setapellido(String apellido)
	{
		this.apellido = apellido;
	}
	public void setnombre(String nombre)
	{
		this.nombre = nombre;
	}
	public void setbarrio(String barrio)
	{
		this.barrio = barrio;
	}
	public void setcodigoBarrio(String codigoBarrio)
	{
		this.codigoBarrio = codigoBarrio;
	}
	public void setEstrato(String estrato)
	{
		this.estrato = estrato;
	}
	public void setCredito(String tipoCredito)
	{
		this.tipoCredito = tipoCredito;
	}
	public void setproducto(String producto)
	{
		this.producto = producto;
	}
	public void setmonto(String monto)
	{
		this.monto = monto;
	}
	public void setplazo(String plazo)
	{
		this.plazo = plazo;
	}
	public void setfrecuencia(String frecuencia)
	{
		this.frecuencia = frecuencia;
	}
	public void setagencia(String agencia)
	{
		this.agencia = agencia;
	}
	public void setanalista(String analista)
	{
		this.analista = analista;
	}
	public void settotalVentas(String totalVentas)
	{
		this.totalVentas = totalVentas;
	}
	public void setfechaDesembolso(String fechaDesembolso)
	{
		this.fechaDesembolso = fechaDesembolso;
	}
	public void setFechacuota(String Fechacuota)
	{
		this.Fechacuota = Fechacuota;
	}
	public void setdesicionAnalista(String desicionAnalista)
	{
		this.desicionAnalista = desicionAnalista;
	}
	
	public void setvoySeguro(String voySeguro)
	{
		this.voySeguro = voySeguro;
	}
	public void setfamilia(String familia)
	{
		this.familia = familia;
	}
	public void setexequial(String exequial)
	{
		this.exequial = exequial;
	}
	public void sethogar(String hogar)
	{
		this.hogar = hogar;
	}
	public void setfoto(String foto)
	{
		this.foto = foto;
	}
	public void setrecogerCreditos(String recogerCreditos)
	{
		this.recogerCreditos = recogerCreditos;
	}
	public void setesPep(String esPep)
	{
		this.esPep = esPep;
	}
	public void setactividadRiesgosa(String actividadRiesgosa)
	{
		this.actividadRiesgosa = actividadRiesgosa;
	}
	public void setdesembolsoACuenta(String desembolsoCuenta)
	{
		this.desembolsoCuenta = desembolsoCuenta;
	}
	
	@Steps
	StepsAppFormiik formiik;
	
	@Test
	public void formiikTest() throws InterruptedException, IOException { 
		if (perfil.contains("consulta")) {
			formiik.setup();
			formiik.searchSolicitud(ideCaso, usuario, password, tipoSolicitud, solicitud);
			formiik.radicacionSolicitud(apellido, nombre, ideCaso, barrio, codigoBarrio, estrato,esPep,actividadRiesgosa,perfil);
			formiik.seleccionMenuRadicacion();
			formiik.analisisDelCredito(ideCaso, barrio, codigoBarrio, totalVentas, perfil);
			formiik.productCredito(ideCaso, producto, monto, plazo, frecuencia, fechaDesembolso, Fechacuota,tipoCredito, restructuracion, voySeguro, familia, exequial, hogar, recogerCreditos,desembolsoCuenta);
			formiik.desicionAnalista(ideCaso, desicionAnalista, foto);
			formiik.excel(identificacion, solicitud, tipoSolicitud, usuario, perfil, producto, monto, plazo,restructuracion, voySeguro, familia, exequial, hogar);
			formiik.finish();
		} else { 
			formiik.setup();
			formiik.inicioSesion(ideCaso, usuario, password, tipoSolicitud, perfil);
			formiik.consultaCliente(ideCaso, tipoDoc, identificacion, apellido, nombre, perfil);
			formiik.radicacionSolicitud(apellido, nombre, ideCaso, barrio, codigoBarrio, estrato,esPep,actividadRiesgosa,perfil);
			formiik.datosDelCredito(ideCaso, tipoCredito, producto, monto, plazo, frecuencia, restructuracion);
			if (perfil.contains("asesor") || perfil.contains("contact")) {
				formiik.selecAnalista(ideCaso, agencia, analista, producto, perfil);
				formiik.excel(identificacion, solicitud, tipoSolicitud, usuario, perfil, producto, monto, plazo,restructuracion, voySeguro, familia, exequial, hogar);
				formiik.finish();
			} else {
				formiik.efectuarRadicacionSolicitud(ideCaso, producto, perfil, restructuracion, desicionAnalista);
				formiik.seleccionMenuRadicacion();
				formiik.analisisDelCredito(ideCaso, barrio, codigoBarrio, totalVentas, perfil);
				formiik.productCredito(ideCaso, producto, monto, plazo, frecuencia, fechaDesembolso, Fechacuota,tipoCredito, restructuracion, voySeguro, familia, exequial, hogar, recogerCreditos,desembolsoCuenta);
				formiik.desicionAnalista(ideCaso, desicionAnalista, foto);
				formiik.excel(identificacion, solicitud, tipoSolicitud, usuario, perfil, producto, monto, plazo,restructuracion, voySeguro, familia, exequial, hogar);
				formiik.finish();
			}
		}
	}
}
