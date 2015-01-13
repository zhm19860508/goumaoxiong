$(function() {
	$(".panel").css({"height":$(window).height()});
	jQuery.scrollify({
		section:".panel",
		scrollSpeed:500,
		easing:"easeOutBounce",
		scrollbars:false
	});
	

	$(".scroll").click(function(e) {
		e.preventDefault();
		jQuery.scrollify("move",$(this).attr("href"));
	});
});