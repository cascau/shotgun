<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    
    <title>Shotgun</title>

<style type="text/css">
body {
	background-image: url('http://crunchify.com/bg.png');
}
</style>
</head>

    <%@ include file="header.jsp" %>
    
    <body>
        <%@ include file="navbar_top.jsp" %>
        
        <div class="container-fluid text-center">
            <div class="row content">
                
                <%@ include file="navbar_left.jsp" %>
                
                <div class="col-sm-8 text-left wrapper"> 
                    <table>
                        <tbody class="scrollContent">
                            <c:forEach var="event" items="${events}">
                                <tr>
                                    <td><c:out value="${event.name}"/></td>
                                    <td><span>From <c:out value="${event.startdt}"/></span></td>
                                    <td><span>To <c:out value="${event.enddt}"/></span></td>
                                    <td></td>
                                    <c:forEach var="performer" items="${event.performers}">
                                        <td><c:out value="${performer.name}"/></td>
                                    </c:forEach>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-sm-2 sidenav">
                    <div class="well">
                        <p>ADS</p>
                    </div>
                    <div class="well">
                        <p>ADS</p>
                    </div>
                </div>
            </div>
        </div>

        <footer class="container-fluid text-center">
            <div style="text-align:center">
                <h2>
                    Hey You..!! This is your 1st Spring MCV Tutorial..<br> <br>
                </h2>
                <h3>
                    <a href="welcome.html">Click here to See Welcome Message... </a>(to
                    check Spring MVC Controller... @RequestMapping("/welcome"))
                </h3>
            </div>
        </footer>
</html>




