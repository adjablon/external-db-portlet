<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<form id="countPersons" method="post" action='<portlet:actionURL name="queryForm"/>' enctype="application/x-www-form-urlencoded">
	<input type="text" id="<portlet:namespace/>surname" name="<portlet:namespace/>surname" onfocus="this.value='';" value="Count persons"/>
	<button id="<portlet:namespace/>countSubmit" type="submit">Submit</button>
	 <div id="<portlet:namespace/>response"></div>
</form>
<script type="text/javascript">
	$(document).ready(function() {

		$("#<portlet:namespace/>countSubmit").click(function(e) {
			e.preventDefault();
			$.ajax({
				url : '<portlet:resourceURL id="countPersons"/>',
				type : 'POST',
				data : ({
					surname : $("#<portlet:namespace/>surname").val()
				}),
				success : function(responseData) {
					$("#<portlet:namespace/>response").html(responseData);
				}
			});
		});
	});
</script>