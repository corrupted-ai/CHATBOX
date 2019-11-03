<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div style="width: 100%;">

	<div style="width: 100%;">
		<form action="search" method="post">
			<div class="form-group">
				<label class="col-form-label">Search Members</label> <input
					type="text" class="form-control" name="sname"
					placeholder="Search Name">
				<div align="center" style="padding-top: 30px">
					<button type="submit" class="btn btn-secondary">Search</button>
				</div>
			</div>
		</form>
	</div>
	<c:if test="${searchuser}">
		<c:if test="${userfound}">
			<c:if test="${not isadmin}">
				<c:forEach var="founduser" items="${foundusers}">
					<div style="width: 100%; border: 1px dashed black">
						<form action="memberinfo">
							<div style="padding: 10px;">
								${founduser.name}
								<button style="position: absolute; right: 5px;" type="submit"
									name="memberbutton" value="${founduser.id}"
									class="btn btn-info btn-sm">view</button>
							</div>
						</form>
					</div>
				</c:forEach>
			</c:if>



			<c:if test="${isadmin}">
				<c:forEach var="uiglist" items="${searchlist}">
					<div style="width: 100%; border: 1px dashed black">
						<form action="memberinfo">
							<div style="padding: 10px;">
								${uiglist.user.name}
								<button style="position: absolute; right: 5px;" type="submit"
									name="memberbutton" value="${uiglist.user.id}"
									class="btn btn-info btn-sm">view</button>
							</div>
						</form>

						<c:if test="${not uiglist.ingroup}">
							<form action="addtogroup" method="post">
								<div align="center" style="padding-top: 3px">
									<button type="submit" value="${uiglist.user.id}" name="button"
										class="btn btn-info btn-sm">+Add to Group</button>
								</div>
							</form>
						</c:if>

						<c:if test="${uiglist.ingroup}">
							<form action="removefromgroup" method="post">
								<div align="left" style="padding-top: 3px">
									<button type="button" class="btn btn-info disabled">added</button>
									<span align="right" style="padding-top: 3px">
										<button type="submit" value="${uiglist.user.id}" name="button"
											class="btn btn-outline-danger btn-sm">Remove from
											Group</button>
									</span>
								</div>
							</form>
						</c:if>
					</div>

				</c:forEach>
			</c:if>




		</c:if>
		<c:if test="${not userfound}">

			<div
				style="text-align: center; margin-top: 20PX; color: red; width: 100%">
				No Users Found</div>
		</c:if>

	</c:if>
</div>