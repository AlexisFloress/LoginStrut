<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <title><s:text name = "bienvenido.titulo"/></title>
        <s:head/> 
    </head>
    <body>
        <h1><s:text name = "bienvenido.titulo"/></h1>
        <h2><s:text name = "bienvenido.mensaje"/></h2>
        
        <s:actionmessage/>
        
        <s:text name = "form.usuario"/>: <s:property value = "persona"/>
        <br/>
        <s:text name = "form.password"/>: <s:property value = "clave"/>
        <br/>
        <a href="<s:url action="login"/>">
            <s:text name="bienvenido.regresar"/>
        </a>
    </body>
</html>
