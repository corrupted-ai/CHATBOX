<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="width: 100%;">
	<c:if test="${myposts}">
		<c:forEach var="postings" items="${viewmyposts}">
		<div class="card border-secondary mb-3" style="max-width: 20rem;">
			<div class="card-header"><div>Posted in : ${postings.group.groupName}</div>
				<div>Posted on : ${postings.datetime}</div>
			 </div>
			<div class="card-body">
				<p class="card-text">${postings.post}</p>
			</div>
		</div>
		</c:forEach>
	</c:if>
	
	<c:if test="${not myposts}">
		<div style="text-align: center; margin-top: 20PX; font-weight: bold;">No Posts Yet</div>
	</c:if>
	
</div>