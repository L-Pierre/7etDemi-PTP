<div class="container">
	<section class="row breath">
		<div class="col-md-12 footerlinks">
			<p>
				<fmt:message key="libelle.footer_copyright" />
			</p>
		</div>
	</section>
	<!-- // End Client Logos -->
</div>
<!-- // Container Ends -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/easing.js"></script>
<script src="js/typer.js"></script>
<script src="js/nicescroll.js"></script>
<!-- Scroll to Explore  -->
<script>
	$(function() {
		$('.scrollto, .gototop').bind('click', function(event) {
			var $anchor = $(this);
			$('html, body').stop().animate({
				scrollTop : $($anchor.attr('href')).offset().top
			}, 1500, 'easeInOutExpo');
			event.preventDefault();
		});
	});
</script>