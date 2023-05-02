<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorInstPublishProxyid" scope="session" class="publicadores.ControladorInstPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorInstPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorInstPublishProxyid.getEndpoint();
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
        sampleControladorInstPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorInstPublish getControladorInstPublish10mtemp = sampleControladorInstPublishProxyid.getControladorInstPublish();
if(getControladorInstPublish10mtemp == null){
%>
<%=getControladorInstPublish10mtemp %>
<%
}else{
        if(getControladorInstPublish10mtemp!= null){
        String tempreturnp11 = getControladorInstPublish10mtemp.toString();
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
        String arg1_2id=  request.getParameter("arg118");
            java.lang.String arg1_2idTemp = null;
        if(!arg1_2id.equals("")){
         arg1_2idTemp  = arg1_2id;
        }
        String arg2_3id=  request.getParameter("arg220");
            java.lang.String arg2_3idTemp = null;
        if(!arg2_3id.equals("")){
         arg2_3idTemp  = arg2_3id;
        }
        sampleControladorInstPublishProxyid.addInstitucionDep(arg0_1idTemp,arg1_2idTemp,arg2_3idTemp);
break;
case 22:
        gotMethod = true;
        java.lang.String[] listarInstituciones22mtemp = sampleControladorInstPublishProxyid.listarInstituciones();
if(listarInstituciones22mtemp == null){
%>
<%=listarInstituciones22mtemp %>
<%
}else{
        String tempreturnp23 = null;
        if(listarInstituciones22mtemp != null){
        java.util.List listreturnp23= java.util.Arrays.asList(listarInstituciones22mtemp);
        tempreturnp23 = listreturnp23.toString();
        }
        %>
        <%=tempreturnp23%>
        <%
}
break;
case 25:
        gotMethod = true;
        String descripcion_5id=  request.getParameter("descripcion30");
            java.lang.String descripcion_5idTemp = null;
        if(!descripcion_5id.equals("")){
         descripcion_5idTemp  = descripcion_5id;
        }
        String url_6id=  request.getParameter("url32");
            java.lang.String url_6idTemp = null;
        if(!url_6id.equals("")){
         url_6idTemp  = url_6id;
        }
        String nombre_7id=  request.getParameter("nombre34");
            java.lang.String nombre_7idTemp = null;
        if(!nombre_7id.equals("")){
         nombre_7idTemp  = nombre_7id;
        }
        %>
        <jsp:useBean id="publicadores1DtInstitucionDeportiva_4id" scope="session" class="publicadores.DtInstitucionDeportiva" />
        <%
        publicadores1DtInstitucionDeportiva_4id.setDescripcion(descripcion_5idTemp);
        publicadores1DtInstitucionDeportiva_4id.setUrl(url_6idTemp);
        publicadores1DtInstitucionDeportiva_4id.setNombre(nombre_7idTemp);
        sampleControladorInstPublishProxyid.updateInstDep(publicadores1DtInstitucionDeportiva_4id);
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