$( window ).ready(function() {
	
	$('#cropUrlButton').click(function(event) {
		
		event.preventDefault();
		ajaxCropUrl();
	});
	
	function ajaxCropUrl() {
		
		var form = new FormData();
		form.append('url', $('#cropUrlString').val());
		
		$.ajax({
            
            type: "POST",
            url: '/crop/url',
            data: form,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
			success : function(result) {
				if(result.status == 'OK') {
					//$("#copiedText").fadeIn();//.show().delay(2000).fadeOut();
					$('#generatedTrimmedURI').val('http://cropml.herokuapp.com/'+result.obj.shortenUri);
					$('#generatedTrimmedURIDiv').fadeIn();
					console.log('work' + result);
					//$('#generatedTrimmedURI').addClass('active');
					
				}
			},
			error : function(e) {
				alert('error');
				console.log(e);
			}
		});
	}
	
	$('#generatedTrimmedURIDiv').click(function(){
		$('#generatedTrimmedURI').select();
		document.execCommand("copy");
		$("#copiedText").fadeIn().delay(3000).fadeOut(800);
	});
	
});