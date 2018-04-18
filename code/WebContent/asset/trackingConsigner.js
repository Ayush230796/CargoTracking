$(document).ready(

function(){
	
$('#btn').click(function(){
	$.getJSON("SearchByTrackingIDJSON",{ajax:true,tid:$('#tid').val()},function(data){

		var h='<table>';
	 h+='<tr><td>'
     h+='<table width=400>';
	h+='<tr><td><b><i>Consignee:</i></b></td><td>'+data[0].CEO+'</td><td><b><i>Consigner:</i></b></td><td>'+data[0].CNO+'</td></tr>';
	h+='<tr><td><b><i>Firm:</i></b></td><td>'+data[0].CEF+'</td><td><b><i>Firm:</i></b></td><td>'+data[0].CNF+'</td></tr>';
	h+='<tr><td><b><i>Contact Person:</i></b></td><td>'+data[0].CEC+'</td><td><b><i>Contact Person:</i></b></td><td>'+data[0].CNC+'</td></tr>';
	h+='<tr><td><b><i>Product Desc:</i></b></td><td>'+data[0].PRODUCTDESC+'<br> Dispatch by Vehicle No:'+data[0].VEICHELNO+'</td><td><b><i>Dispatch Date:</i></b></td><td>'+data[0].DISPATCHDATE+'</td></tr></table>';
	 	h+='<br><table border=1 width=400>';
	h+='<tr><th>Transaction Id</th><th>Date</th><th>Time</th><th>Description</th><th>Location</th></tr>';
	$.each(data,function(i,item){
		h+='<tr><td>'+item.TRACKINGTRANSCATIONID+'</td><td>'+item.TDATE+'</td><td>'+item.TTIME+'</td><td>'+item.DESCRIPTION+'</td><td>'+item.LAT+","+item.LNG+"</td></tr>";
		
	});	 
    h+='</table></td></tr>';
    $('#result').html(h);	
	});
});
});

