<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="width: 100%; margin-right: 5px">

	<c:if test="${not nogroups}">
		<c:forEach var="g" items="${yourgroups}">
			<div style="width: 100%; border: 1px solid black">
				<form action="grouping">
					<div style="padding: 10px;">
						${g.groupName}
						<div align="right">
							<button type="submit" name="viewgroup" value="${g.gid}"
								class="btn btn-info btn-sm">view</button>
						</div>
					</div>
				</form>
			</div>
		</c:forEach>
	</c:if>
	<c:if test="${nogroups}">
		<div style="text-align: center; margin-top: 20PX; font-weight: bold;">No groups found</div>
		<div style="text-align: center; margin-top: 20PX; font-weight: bold;">Create a group</div>
	</c:if>
</div>