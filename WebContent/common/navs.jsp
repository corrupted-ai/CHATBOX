<ul class="nav nav-tabs">
	<li class="nav-item">
		<form action="mygroups" method="post">
			<button class="nav-link" type="submit">Your groups</button>
		</form>
	</li>
	<li class="nav-item mr-auto">
		<form action="myposts" method="post">
			<button class="nav-link" type="submit">Your Posts</button>
		</form>
	</li>
</ul>
<span style="position: absolute; right: 5px;">

	<button type="button" onclick="openmodal()" class="btn btn-primary">+
		Create Group</button>

</span>


<div class="modal" id="groupname">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Enter Group Name</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form action="creategroup" class="nameform" method="post"
					novalidate="novalidate">
					<div class="form-group">
						<input type="text" class="form-control validate" name="gname"
							placeholder="Enter name of the group">
					</div>
					<div align="center" style="padding-top: 30px">
						<button type="submit" class="btn btn-info">Ok</button>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>





<script type="text/javascript">
	function openmodal() {
		$("#groupname").modal("show");
	};

	$(".nameform").validate({
		rules : {
			gname : {
				required : true,
			}
		},
		messages : {
			gname : {
				required : "Group Name is required",
			}
		},
		errorElement : 'div',
		errorPlacement : function(error, element) {
			var placement = $(element).data('error');
			if (placement) {
				$(placement).append(error)
			} else {
				error.insertAfter(element);
			}
		}
	});
</script>