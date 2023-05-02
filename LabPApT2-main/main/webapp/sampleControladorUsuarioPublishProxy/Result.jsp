<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorUsuarioPublishProxyid" scope="session" class="publicadores.ControladorUsuarioPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorUsuarioPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorUsuarioPublishProxyid.getEndpoint();
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
        sampleControladorUsuarioPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorUsuarioPublish getControladorUsuarioPublish10mtemp = sampleControladorUsuarioPublishProxyid.getControladorUsuarioPublish();
if(getControladorUsuarioPublish10mtemp == null){
%>
<%=getControladorUsuarioPublish10mtemp %>
<%
}else{
        if(getControladorUsuarioPublish10mtemp!= null){
        String tempreturnp11 = getControladorUsuarioPublish10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg048");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        String arg1_2id=  request.getParameter("arg150");
            java.lang.String arg1_2idTemp = null;
        if(!arg1_2id.equals("")){
         arg1_2idTemp  = arg1_2id;
        }
        publicadores.DtUsuario existeUsuario13mtemp = sampleControladorUsuarioPublishProxyid.existeUsuario(arg0_1idTemp,arg1_2idTemp);
if(existeUsuario13mtemp == null){
%>
<%=existeUsuario13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">anio:</TD>
<TD>
<%
if(existeUsuario13mtemp != null){
publicadores.DtFecha tebece0=existeUsuario13mtemp.getFechaNac();
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
if(existeUsuario13mtemp != null){
publicadores.DtFecha tebece0=existeUsuario13mtemp.getFechaNac();
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
if(existeUsuario13mtemp != null){
publicadores.DtFecha tebece0=existeUsuario13mtemp.getFechaNac();
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
if(existeUsuario13mtemp != null){
publicadores.DtFecha tebece0=existeUsuario13mtemp.getFechaNac();
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
if(existeUsuario13mtemp != null){
publicadores.DtFecha tebece0=existeUsuario13mtemp.getFechaNac();
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
if(existeUsuario13mtemp != null){
publicadores.DtFecha tebece0=existeUsuario13mtemp.getFechaNac();
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
if(existeUsuario13mtemp != null){
publicadores.DtFecha tebece0=existeUsuario13mtemp.getFechaNac();
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
if(existeUsuario13mtemp != null){
publicadores.DtFecha tebece0=existeUsuario13mtemp.getFechaNac();
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
if(existeUsuario13mtemp != null){
publicadores.DtFecha tebece0=existeUsuario13mtemp.getFechaNac();
if(tebece0 != null){
%>
<%=tebece0.getMINANIO()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(existeUsuario13mtemp != null){
java.lang.String typenickname36 = existeUsuario13mtemp.getNickname();
        String tempResultnickname36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname36));
        %>
        <%= tempResultnickname36 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(existeUsuario13mtemp != null){
java.lang.String typeemail38 = existeUsuario13mtemp.getEmail();
        String tempResultemail38 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail38));
        %>
        <%= tempResultemail38 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">contrasenia:</TD>
<TD>
<%
if(existeUsuario13mtemp != null){
java.lang.String typecontrasenia40 = existeUsuario13mtemp.getContrasenia();
        String tempResultcontrasenia40 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecontrasenia40));
        %>
        <%= tempResultcontrasenia40 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">pfp:</TD>
<TD>
<%
if(existeUsuario13mtemp != null){
java.lang.String typepfp42 = existeUsuario13mtemp.getPfp();
        String tempResultpfp42 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepfp42));
        %>
        <%= tempResultpfp42 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(existeUsuario13mtemp != null){
java.lang.String typeapellido44 = existeUsuario13mtemp.getApellido();
        String tempResultapellido44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido44));
        %>
        <%= tempResultapellido44 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(existeUsuario13mtemp != null){
java.lang.String typenombre46 = existeUsuario13mtemp.getNombre();
        String tempResultnombre46 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre46));
        %>
        <%= tempResultnombre46 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 52:
        gotMethod = true;
        java.lang.String[] mostrarUsuarios52mtemp = sampleControladorUsuarioPublishProxyid.mostrarUsuarios();
if(mostrarUsuarios52mtemp == null){
%>
<%=mostrarUsuarios52mtemp %>
<%
}else{
        String tempreturnp53 = null;
        if(mostrarUsuarios52mtemp != null){
        java.util.List listreturnp53= java.util.Arrays.asList(mostrarUsuarios52mtemp);
        tempreturnp53 = listreturnp53.toString();
        }
        %>
        <%=tempreturnp53%>
        <%
}
break;
case 55:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg090");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        publicadores.DtUsuario consultaUsuario55mtemp = sampleControladorUsuarioPublishProxyid.consultaUsuario(arg0_3idTemp);
if(consultaUsuario55mtemp == null){
%>
<%=consultaUsuario55mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">anio:</TD>
<TD>
<%
if(consultaUsuario55mtemp != null){
publicadores.DtFecha tebece0=consultaUsuario55mtemp.getFechaNac();
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
if(consultaUsuario55mtemp != null){
publicadores.DtFecha tebece0=consultaUsuario55mtemp.getFechaNac();
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
if(consultaUsuario55mtemp != null){
publicadores.DtFecha tebece0=consultaUsuario55mtemp.getFechaNac();
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
if(consultaUsuario55mtemp != null){
publicadores.DtFecha tebece0=consultaUsuario55mtemp.getFechaNac();
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
if(consultaUsuario55mtemp != null){
publicadores.DtFecha tebece0=consultaUsuario55mtemp.getFechaNac();
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
if(consultaUsuario55mtemp != null){
publicadores.DtFecha tebece0=consultaUsuario55mtemp.getFechaNac();
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
if(consultaUsuario55mtemp != null){
publicadores.DtFecha tebece0=consultaUsuario55mtemp.getFechaNac();
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
if(consultaUsuario55mtemp != null){
publicadores.DtFecha tebece0=consultaUsuario55mtemp.getFechaNac();
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
if(consultaUsuario55mtemp != null){
publicadores.DtFecha tebece0=consultaUsuario55mtemp.getFechaNac();
if(tebece0 != null){
%>
<%=tebece0.getMINANIO()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(consultaUsuario55mtemp != null){
java.lang.String typenickname78 = consultaUsuario55mtemp.getNickname();
        String tempResultnickname78 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname78));
        %>
        <%= tempResultnickname78 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(consultaUsuario55mtemp != null){
java.lang.String typeemail80 = consultaUsuario55mtemp.getEmail();
        String tempResultemail80 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail80));
        %>
        <%= tempResultemail80 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">contrasenia:</TD>
<TD>
<%
if(consultaUsuario55mtemp != null){
java.lang.String typecontrasenia82 = consultaUsuario55mtemp.getContrasenia();
        String tempResultcontrasenia82 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typecontrasenia82));
        %>
        <%= tempResultcontrasenia82 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">pfp:</TD>
<TD>
<%
if(consultaUsuario55mtemp != null){
java.lang.String typepfp84 = consultaUsuario55mtemp.getPfp();
        String tempResultpfp84 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepfp84));
        %>
        <%= tempResultpfp84 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(consultaUsuario55mtemp != null){
java.lang.String typeapellido86 = consultaUsuario55mtemp.getApellido();
        String tempResultapellido86 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido86));
        %>
        <%= tempResultapellido86 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(consultaUsuario55mtemp != null){
java.lang.String typenombre88 = consultaUsuario55mtemp.getNombre();
        String tempResultnombre88 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre88));
        %>
        <%= tempResultnombre88 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 92:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg0101");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        publicadores.DtInstitucionDeportiva getDtinstitucionDeportiva92mtemp = sampleControladorUsuarioPublishProxyid.getDtinstitucionDeportiva(arg0_4idTemp);
if(getDtinstitucionDeportiva92mtemp == null){
%>
<%=getDtinstitucionDeportiva92mtemp %>
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
if(getDtinstitucionDeportiva92mtemp != null){
java.lang.String typedescripcion95 = getDtinstitucionDeportiva92mtemp.getDescripcion();
        String tempResultdescripcion95 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion95));
        %>
        <%= tempResultdescripcion95 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getDtinstitucionDeportiva92mtemp != null){
java.lang.String typeurl97 = getDtinstitucionDeportiva92mtemp.getUrl();
        String tempResulturl97 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl97));
        %>
        <%= tempResulturl97 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getDtinstitucionDeportiva92mtemp != null){
java.lang.String typenombre99 = getDtinstitucionDeportiva92mtemp.getNombre();
        String tempResultnombre99 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre99));
        %>
        <%= tempResultnombre99 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 103:
        gotMethod = true;
        publicadores.DtUsuario publicadores1DtUsuario_5id = null;
        sampleControladorUsuarioPublishProxyid.altaUsuario(publicadores1DtUsuario_5id);
break;
case 108:
        gotMethod = true;
        java.lang.String[] listarInstituciones108mtemp = sampleControladorUsuarioPublishProxyid.listarInstituciones();
if(listarInstituciones108mtemp == null){
%>
<%=listarInstituciones108mtemp %>
<%
}else{
        String tempreturnp109 = null;
        if(listarInstituciones108mtemp != null){
        java.util.List listreturnp109= java.util.Arrays.asList(listarInstituciones108mtemp);
        tempreturnp109 = listreturnp109.toString();
        }
        %>
        <%=tempreturnp109%>
        <%
}
break;
case 111:
        gotMethod = true;
        publicadores.DtUsuario publicadores1DtUsuario_6id = null;
        sampleControladorUsuarioPublishProxyid.modificarUsuario(publicadores1DtUsuario_6id);
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