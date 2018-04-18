$(document).ready(function(){
	//alert('First Jquery Script');
$('#btn').click(function(){
	c=parseInt($('#f').val())+parseInt($('#s').val());
	$('#result').html('Sum is:'+c);
	});});