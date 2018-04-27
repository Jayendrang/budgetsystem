<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<tags:template>
	<jsp:attribute name="head">  
		<script type="text/javascript">
		 
		</script>
  	</jsp:attribute>  
	<jsp:body>
	<% String user_id=request.getAttribute("user_id").toString(); 
		
	%>
		<h1>Hello <c:out value="${ user_id }" /></h1>
		<p>This is just an example page.</p>
	</jsp:body>
</tags:template>