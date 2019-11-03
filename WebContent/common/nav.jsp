<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor03" aria-controls="navbarColor03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor03">
     <span class="mr-auto" style="margin-left: 40%">${user.name}'s CHATBOX </span>
    <form class="form-inline my-2 my-lg-0" action="memberinfo" method="post">
			<button type="submit" name="myaccount" class="btn btn-outline-info">My Account</button>
		</form>
		<form style="margin-left: 10px" class="form-inline my-2 my-lg-0" action="logout" method="post">
			<button type="submit" class="btn btn-danger">LOGOUT</button>
		</form>
  </div>
</nav>