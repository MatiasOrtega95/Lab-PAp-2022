<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorClasePublishProxyid" scope="session" class="publicadores.ControladorClasePublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorClasePublishProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleControladorClasePublishProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleControladorClasePublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorClasePublish getControladorClasePublish10mtemp = sampleControladorClasePublishProxyid.getControladorClasePublish();
if(getControladorClasePublish10mtemp == null){
%>
<%=getControladorClasePublish10mtemp %>
<%
}else{
        if(getControladorClasePublish10mtemp!= null){
        String tempreturnp11 = getControladorClasePublish10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg016");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        java.lang.String[] listarActividadesDeportivas13mtemp = sampleControladorClasePublishProxyid.listarActividadesDeportivas(arg0_1idTemp);
if(listarActividadesDeportivas13mtemp == null){
%>
<%=listarActividadesDeportivas13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(listarActividadesDeportivas13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(listarActividadesDeportivas13mtemp);
        tempreturnp14 = listreturnp14.toString();
        }
        %>
        <%=tempreturnp14%>
        <%
}
break;
case 18:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg021");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        java.lang.String[] listarClases18mtemp = sampleControladorClasePublishProxyid.listarClases(arg0_2idTemp);
if(listarClases18mtemp == null){
%>
<%=listarClases18mtemp %>
<%
}else{
        String tempreturnp19 = null;
        if(listarClases18mtemp != null){
        java.util.List listreturnp19= java.util.Arrays.asList(listarClases18mtemp);
        tempreturnp19 = listreturnp19.toString();
        }
        %>
        <%=tempreturnp19%>
        <%
}
break;
case 23:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg026");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        String arg1_4id=  request.getParameter("arg128");
            java.lang.String arg1_4idTemp = null;
        if(!arg1_4id.equals("")){
         arg1_4idTemp  = arg1_4id;
        }
        String hora_6id=  request.getParameter("hora32");
        int hora_6idTemp  = Integer.parseInt(hora_6id);
        String mAXHORA_7id=  request.getParameter("mAXHORA34");
        int mAXHORA_7idTemp  = Integer.parseInt(mAXHORA_7id);
        String seg_8id=  request.getParameter("seg36");
        int seg_8idTemp  = Integer.parseInt(seg_8id);
        String min_9id=  request.getParameter("min38");
        int min_9idTemp  = Integer.parseInt(min_9id);
        String mINMIN_10id=  request.getParameter("mINMIN40");
        int mINMIN_10idTemp  = Integer.parseInt(mINMIN_10id);
        String mINSEG_11id=  request.getParameter("mINSEG42");
        int mINSEG_11idTemp  = Integer.parseInt(mINSEG_11id);
        String mAXMIN_12id=  request.getParameter("mAXMIN44");
        int mAXMIN_12idTemp  = Integer.parseInt(mAXMIN_12id);
        String mAXSEG_13id=  request.getParameter("mAXSEG46");
        int mAXSEG_13idTemp  = Integer.parseInt(mAXSEG_13id);
        String mINHORA_14id=  request.getParameter("mINHORA48");
        int mINHORA_14idTemp  = Integer.parseInt(mINHORA_14id);
        %>
        <jsp:useBean id="publicadores1DtFechaHora_5id" scope="session" class="publicadores.DtFechaHora" />
        <%
        publicadores1DtFechaHora_5id.setHora(hora_6idTemp);
        publicadores1DtFechaHora_5id.setMAXHORA(mAXHORA_7idTemp);
        publicadores1DtFechaHora_5id.setSeg(seg_8idTemp);
        publicadores1DtFechaHora_5id.setMin(min_9idTemp);
        publicadores1DtFechaHora_5id.setMINMIN(mINMIN_10idTemp);
        publicadores1DtFechaHora_5id.setMINSEG(mINSEG_11idTemp);
        publicadores1DtFechaHora_5id.setMAXMIN(mAXMIN_12idTemp);
        publicadores1DtFechaHora_5id.setMAXSEG(mAXSEG_13idTemp);
        publicadores1DtFechaHora_5id.setMINHORA(mINHORA_14idTemp);
        String arg3_15id=  request.getParameter("arg350");
            java.lang.String arg3_15idTemp = null;
        if(!arg3_15id.equals("")){
         arg3_15idTemp  = arg3_15id;
        }
        String arg4_16id=  request.getParameter("arg452");
            java.lang.String arg4_16idTemp = null;
        if(!arg4_16id.equals("")){
         arg4_16idTemp  = arg4_16id;
        }
        String anio_18id=  request.getParameter("anio56");
        int anio_18idTemp  = Integer.parseInt(anio_18id);
        String mINDIA_19id=  request.getParameter("mINDIA58");
        int mINDIA_19idTemp  = Integer.parseInt(mINDIA_19id);
        String mAXDIA_20id=  request.getParameter("mAXDIA60");
        int mAXDIA_20idTemp  = Integer.parseInt(mAXDIA_20id);
        String mAXANIO_21id=  request.getParameter("mAXANIO62");
        int mAXANIO_21idTemp  = Integer.parseInt(mAXANIO_21id);
        String mes_22id=  request.getParameter("mes64");
        int mes_22idTemp  = Integer.parseInt(mes_22id);
        String mINMES_23id=  request.getParameter("mINMES66");
        int mINMES_23idTemp  = Integer.parseInt(mINMES_23id);
        String mAXMES_24id=  request.getParameter("mAXMES68");
        int mAXMES_24idTemp  = Integer.parseInt(mAXMES_24id);
        String dia_25id=  request.getParameter("dia70");
        int dia_25idTemp  = Integer.parseInt(dia_25id);
        String mINANIO_26id=  request.getParameter("mINANIO72");
        int mINANIO_26idTemp  = Integer.parseInt(mINANIO_26id);
        %>
        <jsp:useBean id="publicadores1DtFecha_17id" scope="session" class="publicadores.DtFecha" />
        <%
        publicadores1DtFecha_17id.setAnio(anio_18idTemp);
        publicadores1DtFecha_17id.setMINDIA(mINDIA_19idTemp);
        publicadores1DtFecha_17id.setMAXDIA(mAXDIA_20idTemp);
        publicadores1DtFecha_17id.setMAXANIO(mAXANIO_21idTemp);
        publicadores1DtFecha_17id.setMes(mes_22idTemp);
        publicadores1DtFecha_17id.setMINMES(mINMES_23idTemp);
        publicadores1DtFecha_17id.setMAXMES(mAXMES_24idTemp);
        publicadores1DtFecha_17id.setDia(dia_25idTemp);
        publicadores1DtFecha_17id.setMINANIO(mINANIO_26idTemp);
        String arg6_27id=  request.getParameter("arg674");
            java.lang.String arg6_27idTemp = null;
        if(!arg6_27id.equals("")){
         arg6_27idTemp  = arg6_27id;
        }
        sampleControladorClasePublishProxyid.addClase(arg0_3idTemp,arg1_4idTemp,publicadores1DtFechaHora_5id,arg3_15idTemp,arg4_16idTemp,publicadores1DtFecha_17id,arg6_27idTemp);
break;
case 76:
        gotMethod = true;
        String arg0_28id=  request.getParameter("arg079");
            java.lang.String arg0_28idTemp = null;
        if(!arg0_28id.equals("")){
         arg0_28idTemp  = arg0_28id;
        }
        java.lang.String[] listarProfesores76mtemp = sampleControladorClasePublishProxyid.listarProfesores(arg0_28idTemp);
if(listarProfesores76mtemp == null){
%>
<%=listarProfesores76mtemp %>
<%
}else{
        String tempreturnp77 = null;
        if(listarProfesores76mtemp != null){
        java.util.List listreturnp77= java.util.Arrays.asList(listarProfesores76mtemp);
        tempreturnp77 = listreturnp77.toString();
        }
        %>
        <%=tempreturnp77%>
        <%
}
break;
case 81:
        gotMethod = true;
        java.lang.String[] listarInstituciones81mtemp = sampleControladorClasePublishProxyid.listarInstituciones();
if(listarInstituciones81mtemp == null){
%>
<%=listarInstituciones81mtemp %>
<%
}else{
        String tempreturnp82 = null;
        if(listarInstituciones81mtemp != null){
        java.util.List listreturnp82= java.util.Arrays.asList(listarInstituciones81mtemp);
        tempreturnp82 = listreturnp82.toString();
        }
        %>
        <%=tempreturnp82%>
        <%
}
break;
case 84:
        gotMethod = true;
        publicadores.DtClase[] rankingClases84mtemp = sampleControladorClasePublishProxyid.rankingClases();
if(rankingClases84mtemp == null){
%>
<%=rankingClases84mtemp %>
<%
}else{
        String tempreturnp85 = null;
        if(rankingClases84mtemp != null){
        java.util.List listreturnp85= java.util.Arrays.asList(rankingClases84mtemp);
        tempreturnp85 = listreturnp85.toString();
        }
        %>
        <%=tempreturnp85%>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>