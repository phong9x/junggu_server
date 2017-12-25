var box_number = 2;

$(document).ready(function() {
	$("#add_more_intro").click(function(){
		var partten = $("#attack_pattern_intro").html();
		box_number +=1;
		var genarateHTML = partten.replace(/\[BOX_ID\]/g ,+box_number);
		$("#more_attack_intro").append(genarateHTML);
		handle_image_intro_upload(box_number);
	});
});


function closeIntroAttack(id){
	$("#intro_"+id).remove();
	
}

function handle_image_intro_upload(id){
	  var readUrl = function(input, img) {

	    if (input.files && input.files[0]) {
	      var reader = new FileReader();

	      reader.onload = function(e) {
	        img.attr('src', e.target.result);
	      }

	      reader.readAsDataURL(input.files[0]);
	    }
	  };

	  var box = $("#intro_"+id);
	    var pickBtn = $(box).find('.pick-btn');
	    var realFilePicker = $(box).find('.real-input');
	    var imgPreview = $(box).find('.img-preview');

	    var deleteBtn = $(box).find('.delete-btn');
	    var defaultImg = $(box).find(".data-default-image");
	    var informDeleted = $(box).find(".inform-deleted");
	    
	    console.log(realFilePicker[0]);
	    
	    pickBtn.each(function(i, val){
		    $(this).click(function() {
		    	console.log(i);
			      $(realFilePicker[i]).trigger('click');
			    });
	    });
	    realFilePicker.each(function(i, val){
	    	$(this).change(function() {
			      readUrl($(this).get(0), $(imgPreview[i]));
			      informDeleted.prop("checked", false);
			    });
	    });
	    
	    deleteBtn.each(function(i, val){
	    	$(this).click(function(event) {
			        $(realFilePicker[i]).val('');
			        if ($(defaultImg[i])) {
			          $(imgPreview[i]).attr('src', $(defaultImg[i]).val());
			        } else {
			        	$(imgPreview[i]).attr('src', '');
			        }
			        $(informDeleted[i]).prop("checked", true);
			      });
	    });
}