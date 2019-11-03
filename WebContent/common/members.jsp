<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div
	style="text-align: center; margin-top: 10PX; width: 100%; font-weight: bold;">Members</div>

<c:if test="${not isadmin}">
	<c:forEach var="u" items="${allusers}">
		<div style="width: 100%; border: 1px dashed black">
			<form action="memberinfo">
				<div style="padding: 10px;">
					${u.name}
					<div align="right"><button type="submit"
						name="memberbutton" value="${u.id}" class="btn btn-info btn-sm">view</button>
					</div>
				</div>
			</form>
		</div>
	</c:forEach>
</c:if>

<c:if test="${isadmin}">
	<c:forEach var="uiglist" items="${fullusers}">
		<div style="width: 100%; border: 1px dashed black">
			<form action="memberinfo">
				<div style="padding: 10px;">
					${uiglist.user.name}
					<div align="right">
					<button  type="submit"
						name="memberbutton" value="${uiglist.user.id}"
						class="btn btn-info btn-sm">view</button>
						</div>
				</div>
			</form>

			<c:if test="${not uiglist.ingroup}">
				<form action="addtogroup" method="post">
					<div align="center" style="padding-top: 3px">
						<button type="submit" name="button" value="${uiglist.user.id}" class="btn btn-info btn-sm">+Add
							to Group</button>
					</div>
				</form>
			</c:if>

			<c:if test="${uiglist.ingroup}">
				<form action="removefromgroup" method="post">
					<div align="left" style="padding-top: 3px">
						<button type="button" class="btn btn-info disabled">added</button>
						<span align="right" style="padding-top: 3px">
							<button type="submit" value="${uiglist.user.id}" name="button"
								class="btn btn-outline-danger btn-sm">Remove from Group</button>
						</span>
					</div>
				</form>
			</c:if>
		</div>

	</c:forEach>



</c:if>




