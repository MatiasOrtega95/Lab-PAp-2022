<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorActDepPublishProxyid" scope="session" class="publicadores.ControladorActDepPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorActDepPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorActDepPublishProxyid.getEndpoint();
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
        sampleControladorActDepPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorActDepPublish getControladorActDepPublish10mtemp = sampleControladorActDepPublishProxyid.getControladorActDepPublish();
if(getControladorActDepPublish10mtemp == null){
%>
<%=getControladorActDepPublish10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 17:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg020");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        boolean existeInstitucionD17mtemp = sampleControladorActDepPublishProxyid.existeInstitucionD(arg0_1idTemp);
        String tempResultreturnp18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(existeInstitucionD17mtemp));
        %>
        <%= tempResultreturnp18 %>
        <%
break;
case 22:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg055");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        publicadores.DtActividadDeportiva consultaActividadDeportiva22mtemp = sampleControladorActDepPublishProxyid.consultaActividadDeportiva(arg0_2idTemp);
if(consultaActividadDeportiva22mtemp == null){
%>
<%=consultaActividadDeportiva22mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
java.lang.String typedescripcion25 = consultaActividadDeportiva22mtemp.getDescripcion();
        String tempResultdescripcion25 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion25));
        %>
        <%= tempResultdescripcion25 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
%>
<%=consultaActividadDeportiva22mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">picture:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
java.lang.String typepicture29 = consultaActividadDeportiva22mtemp.getPicture();
        String tempResultpicture29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepicture29));
        %>
        <%= tempResultpicture29 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
java.lang.Float typecosto31 = consultaActividadDeportiva22mtemp.getCosto();
        String tempResultcosto31 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecosto31));
        %>
        <%= tempResultcosto31 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
java.lang.String typenombre33 = consultaActividadDeportiva22mtemp.getNombre();
        String tempResultnombre33 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre33));
        %>
        <%= tempResultnombre33 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">anio:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
publicadores.DtFecha tebece0=consultaActividadDeportiva22mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getAnio()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINDIA:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
publicadores.DtFecha tebece0=consultaActividadDeportiva22mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINDIA()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXDIA:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
publicadores.DtFecha tebece0=consultaActividadDeportiva22mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXDIA()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXANIO:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
publicadores.DtFecha tebece0=consultaActividadDeportiva22mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXANIO()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mes:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
publicadores.DtFecha tebece0=consultaActividadDeportiva22mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMes()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINMES:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
publicadores.DtFecha tebece0=consultaActividadDeportiva22mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINMES()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXMES:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
publicadores.DtFecha tebece0=consultaActividadDeportiva22mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXMES()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">dia:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
publicadores.DtFecha tebece0=consultaActividadDeportiva22mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getDia()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINANIO:</TD>
<TD>
<%
if(consultaActividadDeportiva22mtemp != null){
publicadores.DtFecha tebece0=consultaActividadDeportiva22mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINANIO()
%><%}}%>
</TD>
</TABLE>
<%
}
break;
case 57:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg090");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        publicadores.DtActividadDeportiva registoDictadoDeClase57mtemp = sampleControladorActDepPublishProxyid.registoDictadoDeClase(arg0_3idTemp);
if(registoDictadoDeClase57mtemp == null){
%>
<%=registoDictadoDeClase57mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
java.lang.String typedescripcion60 = registoDictadoDeClase57mtemp.getDescripcion();
        String tempResultdescripcion60 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion60));
        %>
        <%= tempResultdescripcion60 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
%>
<%=registoDictadoDeClase57mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">picture:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
java.lang.String typepicture64 = registoDictadoDeClase57mtemp.getPicture();
        String tempResultpicture64 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepicture64));
        %>
        <%= tempResultpicture64 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
java.lang.Float typecosto66 = registoDictadoDeClase57mtemp.getCosto();
        String tempResultcosto66 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecosto66));
        %>
        <%= tempResultcosto66 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
java.lang.String typenombre68 = registoDictadoDeClase57mtemp.getNombre();
        String tempResultnombre68 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre68));
        %>
        <%= tempResultnombre68 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">anio:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
publicadores.DtFecha tebece0=registoDictadoDeClase57mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getAnio()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINDIA:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
publicadores.DtFecha tebece0=registoDictadoDeClase57mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINDIA()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXDIA:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
publicadores.DtFecha tebece0=registoDictadoDeClase57mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXDIA()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXANIO:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
publicadores.DtFecha tebece0=registoDictadoDeClase57mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXANIO()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mes:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
publicadores.DtFecha tebece0=registoDictadoDeClase57mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMes()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINMES:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
publicadores.DtFecha tebece0=registoDictadoDeClase57mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINMES()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXMES:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
publicadores.DtFecha tebece0=registoDictadoDeClase57mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXMES()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">dia:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
publicadores.DtFecha tebece0=registoDictadoDeClase57mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getDia()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINANIO:</TD>
<TD>
<%
if(registoDictadoDeClase57mtemp != null){
publicadores.DtFecha tebece0=registoDictadoDeClase57mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINANIO()
%><%}}%>
</TD>
</TABLE>
<%
}
break;
case 92:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg095");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        String arg1_5id=  request.getParameter("arg197");
            java.lang.String arg1_5idTemp = null;
        if(!arg1_5id.equals("")){
         arg1_5idTemp  = arg1_5id;
        }
        sampleControladorActDepPublishProxyid.eliminarRegistroClase(arg0_4idTemp,arg1_5idTemp);
break;
case 99:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg0102");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        String arg1_7id=  request.getParameter("arg1104");
            java.lang.String arg1_7idTemp = null;
        if(!arg1_7id.equals("")){
         arg1_7idTemp  = arg1_7id;
        }
        String arg2_8id=  request.getParameter("arg2106");
            java.lang.String arg2_8idTemp = null;
        if(!arg2_8id.equals("")){
         arg2_8idTemp  = arg2_8id;
        }
        String arg3_9id=  request.getParameter("arg3108");
        int arg3_9idTemp  = Integer.parseInt(arg3_9id);
        String arg4_10id=  request.getParameter("arg4110");
        float arg4_10idTemp  = Float.parseFloat(arg4_10id);
        String anio_12id=  request.getParameter("anio114");
        int anio_12idTemp  = Integer.parseInt(anio_12id);
        String mINDIA_13id=  request.getParameter("mINDIA116");
        int mINDIA_13idTemp  = Integer.parseInt(mINDIA_13id);
        String mAXDIA_14id=  request.getParameter("mAXDIA118");
        int mAXDIA_14idTemp  = Integer.parseInt(mAXDIA_14id);
        String mAXANIO_15id=  request.getParameter("mAXANIO120");
        int mAXANIO_15idTemp  = Integer.parseInt(mAXANIO_15id);
        String mes_16id=  request.getParameter("mes122");
        int mes_16idTemp  = Integer.parseInt(mes_16id);
        String mINMES_17id=  request.getParameter("mINMES124");
        int mINMES_17idTemp  = Integer.parseInt(mINMES_17id);
        String mAXMES_18id=  request.getParameter("mAXMES126");
        int mAXMES_18idTemp  = Integer.parseInt(mAXMES_18id);
        String dia_19id=  request.getParameter("dia128");
        int dia_19idTemp  = Integer.parseInt(dia_19id);
        String mINANIO_20id=  request.getParameter("mINANIO130");
        int mINANIO_20idTemp  = Integer.parseInt(mINANIO_20id);
        %>
        <jsp:useBean id="publicadores1DtFecha_11id" scope="session" class="publicadores.DtFecha" />
        <%
        publicadores1DtFecha_11id.setAnio(anio_12idTemp);
        publicadores1DtFecha_11id.setMINDIA(mINDIA_13idTemp);
        publicadores1DtFecha_11id.setMAXDIA(mAXDIA_14idTemp);
        publicadores1DtFecha_11id.setMAXANIO(mAXANIO_15idTemp);
        publicadores1DtFecha_11id.setMes(mes_16idTemp);
        publicadores1DtFecha_11id.setMINMES(mINMES_17idTemp);
        publicadores1DtFecha_11id.setMAXMES(mAXMES_18idTemp);
        publicadores1DtFecha_11id.setDia(dia_19idTemp);
        publicadores1DtFecha_11id.setMINANIO(mINANIO_20idTemp);
        String arg6_21id=  request.getParameter("arg6132");
            java.lang.String arg6_21idTemp = null;
        if(!arg6_21id.equals("")){
         arg6_21idTemp  = arg6_21id;
        }
        sampleControladorActDepPublishProxyid.altaActividadDeportiva(arg0_6idTemp,arg1_7idTemp,arg2_8idTemp,arg3_9idTemp,arg4_10idTemp,publicadores1DtFecha_11id,arg6_21idTemp);
break;
case 134:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0137");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        java.lang.String[] listarActividadesDeportivas134mtemp = sampleControladorActDepPublishProxyid.listarActividadesDeportivas(arg0_22idTemp);
if(listarActividadesDeportivas134mtemp == null){
%>
<%=listarActividadesDeportivas134mtemp %>
<%
}else{
        String tempreturnp135 = null;
        if(listarActividadesDeportivas134mtemp != null){
        java.util.List listreturnp135= java.util.Arrays.asList(listarActividadesDeportivas134mtemp);
        tempreturnp135 = listreturnp135.toString();
        }
        %>
        <%=tempreturnp135%>
        <%
}
break;
case 139:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0142");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        java.lang.String[] listarClases139mtemp = sampleControladorActDepPublishProxyid.listarClases(arg0_23idTemp);
if(listarClases139mtemp == null){
%>
<%=listarClases139mtemp %>
<%
}else{
        String tempreturnp140 = null;
        if(listarClases139mtemp != null){
        java.util.List listreturnp140= java.util.Arrays.asList(listarClases139mtemp);
        tempreturnp140 = listreturnp140.toString();
        }
        %>
        <%=tempreturnp140%>
        <%
}
break;
case 144:
        gotMethod = true;
        String arg0_24id=  request.getParameter("arg0199");
            java.lang.String arg0_24idTemp = null;
        if(!arg0_24id.equals("")){
         arg0_24idTemp  = arg0_24id;
        }
        publicadores.DtClase getDtClase144mtemp = sampleControladorActDepPublishProxyid.getDtClase(arg0_24idTemp);
if(getDtClase144mtemp == null){
%>
<%=getDtClase144mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
java.lang.String typeurl147 = getDtClase144mtemp.getUrl();
        String tempResulturl147 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl147));
        %>
        <%= tempResulturl147 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaInicio:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">hora:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFechaHora tebece0=getDtClase144mtemp.getFechaInicio();
if(tebece0 != null){
%>
<%=tebece0.getHora()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXHORA:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFechaHora tebece0=getDtClase144mtemp.getFechaInicio();
if(tebece0 != null){
%>
<%=tebece0.getMAXHORA()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">seg:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFechaHora tebece0=getDtClase144mtemp.getFechaInicio();
if(tebece0 != null){
%>
<%=tebece0.getSeg()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">min:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFechaHora tebece0=getDtClase144mtemp.getFechaInicio();
if(tebece0 != null){
%>
<%=tebece0.getMin()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINMIN:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFechaHora tebece0=getDtClase144mtemp.getFechaInicio();
if(tebece0 != null){
%>
<%=tebece0.getMINMIN()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINSEG:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFechaHora tebece0=getDtClase144mtemp.getFechaInicio();
if(tebece0 != null){
%>
<%=tebece0.getMINSEG()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXMIN:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFechaHora tebece0=getDtClase144mtemp.getFechaInicio();
if(tebece0 != null){
%>
<%=tebece0.getMAXMIN()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXSEG:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFechaHora tebece0=getDtClase144mtemp.getFechaInicio();
if(tebece0 != null){
%>
<%=tebece0.getMAXSEG()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINHORA:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFechaHora tebece0=getDtClase144mtemp.getFechaInicio();
if(tebece0 != null){
%>
<%=tebece0.getMINHORA()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">picture:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
java.lang.String typepicture169 = getDtClase144mtemp.getPicture();
        String tempResultpicture169 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepicture169));
        %>
        <%= tempResultpicture169 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">anio:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFecha tebece0=getDtClase144mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getAnio()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINDIA:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFecha tebece0=getDtClase144mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINDIA()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXDIA:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFecha tebece0=getDtClase144mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXDIA()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXANIO:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFecha tebece0=getDtClase144mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXANIO()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mes:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFecha tebece0=getDtClase144mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMes()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINMES:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFecha tebece0=getDtClase144mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINMES()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXMES:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFecha tebece0=getDtClase144mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXMES()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">dia:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFecha tebece0=getDtClase144mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getDia()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINANIO:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
publicadores.DtFecha tebece0=getDtClase144mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINANIO()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">actDep:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
java.lang.String typeactDep191 = getDtClase144mtemp.getActDep();
        String tempResultactDep191 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeactDep191));
        %>
        <%= tempResultactDep191 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">profe:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
java.lang.String typeprofe193 = getDtClase144mtemp.getProfe();
        String tempResultprofe193 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeprofe193));
        %>
        <%= tempResultprofe193 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">cantRegistros:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
%>
<%=getDtClase144mtemp.getCantRegistros()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getDtClase144mtemp != null){
java.lang.String typenombre197 = getDtClase144mtemp.getNombre();
        String tempResultnombre197 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre197));
        %>
        <%= tempResultnombre197 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 201:
        gotMethod = true;
        java.lang.String[] listarInstituciones201mtemp = sampleControladorActDepPublishProxyid.listarInstituciones();
if(listarInstituciones201mtemp == null){
%>
<%=listarInstituciones201mtemp %>
<%
}else{
        String tempreturnp202 = null;
        if(listarInstituciones201mtemp != null){
        java.util.List listreturnp202= java.util.Arrays.asList(listarInstituciones201mtemp);
        tempreturnp202 = listreturnp202.toString();
        }
        %>
        <%=tempreturnp202%>
        <%
}
break;
case 204:
        gotMethod = true;
        String arg0_25id=  request.getParameter("arg0207");
            java.lang.String arg0_25idTemp = null;
        if(!arg0_25id.equals("")){
         arg0_25idTemp  = arg0_25id;
        }
        String arg1_26id=  request.getParameter("arg1209");
            java.lang.String arg1_26idTemp = null;
        if(!arg1_26id.equals("")){
         arg1_26idTemp  = arg1_26id;
        }
        sampleControladorActDepPublishProxyid.altaRegistroDictadoDeClase(arg0_25idTemp,arg1_26idTemp);
break;
case 211:
        gotMethod = true;
        java.lang.String[] getSocios211mtemp = sampleControladorActDepPublishProxyid.getSocios();
if(getSocios211mtemp == null){
%>
<%=getSocios211mtemp %>
<%
}else{
        String tempreturnp212 = null;
        if(getSocios211mtemp != null){
        java.util.List listreturnp212= java.util.Arrays.asList(getSocios211mtemp);
        tempreturnp212 = listreturnp212.toString();
        }
        %>
        <%=tempreturnp212%>
        <%
}
break;
case 214:
        gotMethod = true;
        String descripcion_28id=  request.getParameter("descripcion219");
            java.lang.String descripcion_28idTemp = null;
        if(!descripcion_28id.equals("")){
         descripcion_28idTemp  = descripcion_28id;
        }
        String duracion_29id=  request.getParameter("duracion221");
        int duracion_29idTemp  = Integer.parseInt(duracion_29id);
        String picture_30id=  request.getParameter("picture223");
            java.lang.String picture_30idTemp = null;
        if(!picture_30id.equals("")){
         picture_30idTemp  = picture_30id;
        }
        String costo_31id=  request.getParameter("costo225");
            java.lang.Float costo_31idTemp = null;
        if(!costo_31id.equals("")){
         costo_31idTemp  = java.lang.Float.valueOf(costo_31id);
        }
        String nombre_32id=  request.getParameter("nombre227");
            java.lang.String nombre_32idTemp = null;
        if(!nombre_32id.equals("")){
         nombre_32idTemp  = nombre_32id;
        }
        String anio_34id=  request.getParameter("anio231");
        int anio_34idTemp  = Integer.parseInt(anio_34id);
        String mINDIA_35id=  request.getParameter("mINDIA233");
        int mINDIA_35idTemp  = Integer.parseInt(mINDIA_35id);
        String mAXDIA_36id=  request.getParameter("mAXDIA235");
        int mAXDIA_36idTemp  = Integer.parseInt(mAXDIA_36id);
        String mAXANIO_37id=  request.getParameter("mAXANIO237");
        int mAXANIO_37idTemp  = Integer.parseInt(mAXANIO_37id);
        String mes_38id=  request.getParameter("mes239");
        int mes_38idTemp  = Integer.parseInt(mes_38id);
        String mINMES_39id=  request.getParameter("mINMES241");
        int mINMES_39idTemp  = Integer.parseInt(mINMES_39id);
        String mAXMES_40id=  request.getParameter("mAXMES243");
        int mAXMES_40idTemp  = Integer.parseInt(mAXMES_40id);
        String dia_41id=  request.getParameter("dia245");
        int dia_41idTemp  = Integer.parseInt(dia_41id);
        String mINANIO_42id=  request.getParameter("mINANIO247");
        int mINANIO_42idTemp  = Integer.parseInt(mINANIO_42id);
        %>
        <jsp:useBean id="publicadores1DtFecha_33id" scope="session" class="publicadores.DtFecha" />
        <%
        publicadores1DtFecha_33id.setAnio(anio_34idTemp);
        publicadores1DtFecha_33id.setMINDIA(mINDIA_35idTemp);
        publicadores1DtFecha_33id.setMAXDIA(mAXDIA_36idTemp);
        publicadores1DtFecha_33id.setMAXANIO(mAXANIO_37idTemp);
        publicadores1DtFecha_33id.setMes(mes_38idTemp);
        publicadores1DtFecha_33id.setMINMES(mINMES_39idTemp);
        publicadores1DtFecha_33id.setMAXMES(mAXMES_40idTemp);
        publicadores1DtFecha_33id.setDia(dia_41idTemp);
        publicadores1DtFecha_33id.setMINANIO(mINANIO_42idTemp);
        %>
        <jsp:useBean id="publicadores1DtActividadDeportiva_27id" scope="session" class="publicadores.DtActividadDeportiva" />
        <%
        publicadores1DtActividadDeportiva_27id.setDescripcion(descripcion_28idTemp);
        publicadores1DtActividadDeportiva_27id.setDuracion(duracion_29idTemp);
        publicadores1DtActividadDeportiva_27id.setPicture(picture_30idTemp);
        publicadores1DtActividadDeportiva_27id.setCosto(costo_31idTemp);
        publicadores1DtActividadDeportiva_27id.setNombre(nombre_32idTemp);
        publicadores1DtActividadDeportiva_27id.setFechaReg(publicadores1DtFecha_33id);
        sampleControladorActDepPublishProxyid.modificarActividadDeportiva(publicadores1DtActividadDeportiva_27id);
break;
case 249:
        gotMethod = true;
        java.lang.String[] getActividadesDeportivas249mtemp = sampleControladorActDepPublishProxyid.getActividadesDeportivas();
if(getActividadesDeportivas249mtemp == null){
%>
<%=getActividadesDeportivas249mtemp %>
<%
}else{
        String tempreturnp250 = null;
        if(getActividadesDeportivas249mtemp != null){
        java.util.List listreturnp250= java.util.Arrays.asList(getActividadesDeportivas249mtemp);
        tempreturnp250 = listreturnp250.toString();
        }
        %>
        <%=tempreturnp250%>
        <%
}
break;
case 252:
        gotMethod = true;
        String arg0_43id=  request.getParameter("arg0285");
            java.lang.String arg0_43idTemp = null;
        if(!arg0_43id.equals("")){
         arg0_43idTemp  = arg0_43id;
        }
        publicadores.DtActividadDeportiva getDtActividadDeportiva252mtemp = sampleControladorActDepPublishProxyid.getDtActividadDeportiva(arg0_43idTemp);
if(getDtActividadDeportiva252mtemp == null){
%>
<%=getDtActividadDeportiva252mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
java.lang.String typedescripcion255 = getDtActividadDeportiva252mtemp.getDescripcion();
        String tempResultdescripcion255 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion255));
        %>
        <%= tempResultdescripcion255 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
%>
<%=getDtActividadDeportiva252mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">picture:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
java.lang.String typepicture259 = getDtActividadDeportiva252mtemp.getPicture();
        String tempResultpicture259 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepicture259));
        %>
        <%= tempResultpicture259 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
java.lang.Float typecosto261 = getDtActividadDeportiva252mtemp.getCosto();
        String tempResultcosto261 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecosto261));
        %>
        <%= tempResultcosto261 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
java.lang.String typenombre263 = getDtActividadDeportiva252mtemp.getNombre();
        String tempResultnombre263 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre263));
        %>
        <%= tempResultnombre263 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">anio:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
publicadores.DtFecha tebece0=getDtActividadDeportiva252mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getAnio()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINDIA:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
publicadores.DtFecha tebece0=getDtActividadDeportiva252mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINDIA()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXDIA:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
publicadores.DtFecha tebece0=getDtActividadDeportiva252mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXDIA()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXANIO:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
publicadores.DtFecha tebece0=getDtActividadDeportiva252mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXANIO()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mes:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
publicadores.DtFecha tebece0=getDtActividadDeportiva252mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMes()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINMES:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
publicadores.DtFecha tebece0=getDtActividadDeportiva252mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINMES()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mAXMES:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
publicadores.DtFecha tebece0=getDtActividadDeportiva252mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMAXMES()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">dia:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
publicadores.DtFecha tebece0=getDtActividadDeportiva252mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getDia()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">mINANIO:</TD>
<TD>
<%
if(getDtActividadDeportiva252mtemp != null){
publicadores.DtFecha tebece0=getDtActividadDeportiva252mtemp.getFechaReg();
if(tebece0 != null){
%>
<%=tebece0.getMINANIO()
%><%}}%>
</TD>
</TABLE>
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