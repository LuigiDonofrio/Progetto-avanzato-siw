package it.uniroma3.controller;

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
public class Interfaccia {
	private String message;
	private String carrello;
	private HttpServletRequest requestUI=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	private HttpSession sessionUI = requestUI.getSession();
	
	
	public String getMessage(){
	
		String messageWelcome="/faces/loginUser.jsp";
		String bottoneLog="";
		
		if(this.sessionUI.getAttribute("currentUser")!=null){ 
			Utente u = (Utente)this.sessionUI.getAttribute("currentUser");
			messageWelcome=("<span class=\"glyphicon glyphicon-user\" aria-hidden=\"true\"></span><font color=\"#FFFFF\"><b>BENVENUTO</b>: "+u.getName()+"</font>");
			bottoneLog= " <a href='"+this.requestUI.getContextPath()+"/faces/loginUser.jsp' class=\"btn btn-success\" role=\"button\">Logout</button></a>";
			return messageWelcome+bottoneLog;
		}else{
			return " <a href='"+this.requestUI.getContextPath()+"/faces/loginUser.jsp' class=\"btn btn-success\" role=\"button\">Login</button></a>";
		}
		
	}
	
	
	public String getCarrello(){
	String htmlGenerated="";
	Ordine ordine = (Ordine)this.requestUI.getSession().getAttribute("ordine");
      	if(ordine!=null){
      		htmlGenerated="<div class=\"col-xs-6 col-sm-3 sidebar-offcanvas\" id=\"sidebar\">";
      			htmlGenerated=htmlGenerated+("<div class=\"panel panel-default\"><div class=\"panel-heading\"><h3 class=\"panel-title\"><table width=\"100%\"><tr><td width=\"70%\">Carrello</td><td width=\"30%\" align=\"right\"><span class=\"glyphicon glyphicon-shopping-cart\" aria-hidden=\"true\" styl=\"float:right\"></span></td></tr></table></h3></div>");	
      				htmlGenerated=htmlGenerated+("<div class=\"panel-body\">");
						
      	for(OrderLine orderline :ordine.getOrderLines()){
      		htmlGenerated=htmlGenerated+("<a href='#' class=\"list-group-item\"><table width=\"100%\"><tr><td width=\"70%\" align=\"center\" >"+ orderline.getProdotto().getName()+"</td><td><span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span></td>");
      		htmlGenerated=htmlGenerated+("<td align=\"center\" width=\"30%\">"+(orderline.getQuantita())+"</td></tr></table></a>");
      		
      	}
      	}
    return htmlGenerated;	
	}
		
	}
