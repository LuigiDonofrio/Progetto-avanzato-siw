package it.uniroma3.interfaccia;

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

	/*public String getMessage() {

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

	}*/
	
	public String getCarrello() {
		String htmlGenerated = "";
		Ordine ordine = (Ordine) this.sessionUI.getAttribute("ordine");
		if (ordine != null) {
			for (OrderLine orderline : ordine.getOrderLines()) {
				String nomeMaiusc = orderline.getProdotto().getName()
						.substring(0, 1)
						+ orderline.getProdotto().getName().substring(1);
				htmlGenerated = htmlGenerated
						+ ("<div class=\"list-group-item\"><table width=\"100%\"><tr><td width=\"70%\" align=\"center\" >"
								+ nomeMaiusc + "</td><td><span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span></td>");
				htmlGenerated = htmlGenerated
						+ ("<td align=\"center\" width=\"30%\">"
								+ (orderline.getQuantita()) + "</td></tr></table></div>");

			}
		}
		return htmlGenerated;
	}
}