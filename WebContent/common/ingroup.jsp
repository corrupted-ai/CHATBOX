<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="width: 100%;">
<div style="position: -webkit-sticky ; position: sticky; top: 0;z-index: 1;background-color: white">
	<div style="text-align: center; font-weight: bold;"> Group Name : ${presentgroup.groupName}</div>
	<form action="postamessage" method="post">
		<div class="form-group">
			<label>Post a Message</label>
			<textarea class="form-control" name="message" rows="3"></textarea>
			<div align="right" style="padding-top: 3px">
				<button type="submit" class="btn btn-outline-warning">Post</button>
			</div>
		</div>
	</form>
</div>
	<c:if test="${posted}">
		<c:forEach var="postings" items="${groupposts}">
		<div class="card border-secondary mb-3" style="max-width: 20rem;">
			<div class="card-header"><div>Posted by : ${postings.postedby.name}</div>
				<div>Posted on : ${postings.datetime}</div>
			 </div>
			<div class="card-body">
				<p class="card-text">${postings.post}</p>
			</div>
		</div>
		</c:forEach>
	</c:if>
	
	<c:if test="${not posted}">
		<div style="text-align: center; margin-top: 20PX; font-weight: bold;">No Messages Yet</div>
		<div style="text-align: center; margin-top: 20PX; font-weight: bold;">Post a messsage</div>
	</c:if>
	
	
</div>