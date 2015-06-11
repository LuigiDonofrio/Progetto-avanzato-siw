package it.uniroma3.interfaccia;

import it.uniroma3.controller.UtenteController;
import it.uniroma3.facade.UtenteFacade;
import it.uniroma3.model.Cliente;
import it.uniroma3.model.OrderLine;
import it.uniroma3.model.Ordine;
import it.uniroma3.model.Utente;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@SessionScoped
@ManagedBean
public class Index {
	private HttpServletRequest requestUI = (HttpServletRequest) FacesContext
			.getCurrentInstance().getExternalContext().getRequest();
	private HttpSession sessionUI = requestUI.getSession();

	public String getPannello(){

		Utente utente = (Utente)this.sessionUI.getAttribute("currentUser");
		String html="";
		if(utente!=null){
			if(utente.isAdmin()){
				return "Amministratore";
			}else{
				return "Cliente";
			}
		}
		return null;
	}

	public String getMessage() {

		String messageWelcome = "/faces/loginUser.jsp";
		String bottoneLog = "";

		if (this.sessionUI.getAttribute("currentUser") != null) {
			Utente u = (Utente) this.sessionUI.getAttribute("currentUser");
			messageWelcome = ("<span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span><font color=\"#FFFFF\"><b>BENVENUTO</b>: "
					+ u.getName() + "</font>");
			bottoneLog = " <a href='"
					+ this.requestUI.getContextPath()
					+ "/faces/loginUser.jsp' class=\"btn btn-success\" role=\"button\">Logout</a>";
			return messageWelcome + bottoneLog;
		} else {
			return " <a href='"
					+ this.requestUI.getContextPath()
					+ "/faces/loginUser.jsp' class=\"btn btn-success\" role=\"button\">Login</a> | Oppure <a href='"
					+ this.requestUI.getContextPath()
					+ "/faces/registraCliente.jsp'> Registrati</a>";
		}

	}

	public String getCarrello() {
		String htmlGenerated = "";
		Ordine ordine = (Ordine) this.sessionUI.getAttribute(
				"ordine");
		if (ordine != null) {
			htmlGenerated = "<div class=\"col-xs-6 col-sm-3 sidebar-offcanvas\" id=\"sidebar\">";
			htmlGenerated = htmlGenerated
					+ ("<div class=\"panel panel-default\"><div class=\"panel-heading\"><h3 class=\"panel-title\"><table width=\"100%\"><tr><td width=\"70%\">Carrello</td><td width=\"30%\" align=\"right\"><span class=\"glyphicon glyphicon-shopping-cart\" aria-hidden=\"true\" styl=\"float:right\"></span></td></tr></table></h3></div>");
			htmlGenerated = htmlGenerated + ("<div class=\"panel-body\">");

			for (OrderLine orderline : ordine.getOrderLines()) {
				String nomeMaiusc = orderline.getProdotto().getName()
						.substring(0, 1)
						+ orderline.getProdotto().getName().substring(1);
				htmlGenerated = htmlGenerated
						+ ("<a href='#' class=\"list-group-item\"><table width=\"100%\"><tr><td width=\"70%\" align=\"center\" >"
								+ nomeMaiusc + "</td><td><span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span></td>");
				htmlGenerated = htmlGenerated
						+ ("<td align=\"center\" width=\"30%\">"
								+ (orderline.getQuantita()) + "</td></tr></table></a>");

			}
			htmlGenerated = htmlGenerated + ("</div><a href=\"faces/riepilogoOrdine.jsp\" class=\"btn btn-success\" role=\"button\">Conferma</a></div>");
		}
		return htmlGenerated;
	}


	public String getRiepilogo(){
		Ordine ordine = (Ordine)this.sessionUI.getAttribute("ordine");
		String htmlGen = "";
		System.out.println();
		if(ordine!=null){
			htmlGen="<table width=\"100%\"><tr><td><b>Nome Prodotto<b></td><td><b>Quantita<b></td><td><b>Costo</td>";
			for(OrderLine linea: ordine.getOrderLines()){
				htmlGen = htmlGen
						+"<tr><td width=\"70%\">"+linea.getProdotto().getName().substring(0, 1).toUpperCase()+linea.getProdotto().getName().substring(1)+"</td>"
						+ "<td width=\"15%\" align=\"center\">"+linea.getQuantita()+"</td>"
						+"<td width=\"15%\">"+linea.getQuantita()*linea.getProdotto().getPrice()+"</td>"
						+ "</tr>";
			}
		}

		return htmlGen+"</table>";
	}
	
	public String getProva(){
		return "<f:view><h:form><h:commandLink action=\"\" value=\"Peto\"/></h:form></f:view>";
	}
}
