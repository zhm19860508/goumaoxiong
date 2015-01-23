$(function() {
	$(".panel").css({"height":$(window).height()});
	jQuery.scrollify({
		section:".panel",
		scrollSpeed:500,
		scrollbars:true
	});
	

	$(".scroll").click(function(e) {
		e.preventDefault();
		jQuery.scrollify("move",$(this).attr("href"));
	});
});