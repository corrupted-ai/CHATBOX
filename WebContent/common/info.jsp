<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="card border-primary mb-3"
	style="max-width: 20rem; padding: 5px">
	<div class="card-header">Info Panel</div>
	<div class="card-body" style="padding: 5px">
		<h4 class="card-title">${infouser.name}</h4>
		<img alt="user pic" src="common/userimg.png" height="175px"
			width="100%">
		<div style="color: blue; margin-top: 10px">Email :
			${infouser.email}</div>
		<div style="color: blue; margin-top: 10px">Phone :
			${infouser.phone}</div>	
	</div>
</div>

