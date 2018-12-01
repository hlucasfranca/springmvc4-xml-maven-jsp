<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ex" tagdir="/WEB-INF/tags" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<spring:eval expression="formulario.texto?.length()" var="comprimento" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Hello Spring MVC</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">

    <h2>Dados</h2>



    <form:form method="post" action="/confirmacao" modelAttribute="formulario" >

        <div>
            <ex:exemplo nome="${comprimento}" />
        </div>

        <div>
            <spring:eval expression="2 == 1" />
        </div>

        <div>
            <spring:eval expression="2 == 2" />
        </div>

        <div>
            <spring:eval expression="'Texto do form: ' + formulario.texto" />
        </div>


        <form:input path="texto" maxlength="10" teste="sss"/>

        <form:hidden path="objetoUm" />
        <form:hidden path="objetoDois" />
        <form:hidden path="objetoTres" />
        <form:hidden path="objetoQuatro" />

        <input type="submit" />

    </form:form>


</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

<script>
    $(document).on('ready', function(){
        $.get( "ola", function( data ) {
            console.log( "Load was performed." );
        });
    });
</script>

</body>
</html>
