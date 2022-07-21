'use strict';

$(function() {
	$(document).on('click', '#get_address_btn', function() {
		if($('#destinationZipcode').val().length < 8){
			alert('郵便番号はハイフンを入れて入力してください　（例）123-1234');
			exit;
		};
		
		$.ajax({
			url: 'http://localhost:8082/api/zipcode',
			dataType: 'json',
			data: {
				zipcode: $('#destinationZipcode').val()
			},
			async: true
		}).done(function(data) {
			console.log(JSON.stringify(data));
			$('#destinationAddress1').val(data.address1);
			$('#destinationAddress2').val(data.address2);
		}).fail(function(XMLHttpRequest, textStatus, errorThrown) {
			alert('正しい結果を得られませんでした')
			console.log('XMLHttpRequest:' + XMLHttpRequest.status);
			console.log('textStatus:' + textStatus);
			console.log('errorThrown:' + errorThrown.message);
		});
	});
});