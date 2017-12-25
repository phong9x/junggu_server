
(function($) {
    if (!$("#educationLevel_select").length) return;
    
    $(window).on("load", function() {
    	var selectName=$("#educationName_select");
    	var e = document.getElementById("educationLevel_select");
    	var text = e.options[e.selectedIndex].text;
    	selectName.val(text);
    	
    	var select = $("#educationLevel_select");
    	var selected = select.find("option:selected");
    	var etc = $("#educationLevelEtc");
    	console.log(selected.val());
    	if(selected.val() === "9") {
    		etc.removeAttr("disabled");
    		
    	} else{
    		etc.attr("disabled", "disabled");
    	}
    });
    
    $("#educationLevel_select").on("change", function() {
    	var selectName=$("#educationName_select");
    	var select = $("#educationLevel_select");
    	var selected = select.find("option:selected");
    	var etc = $("#educationLevelEtc");
    	
    	var e = document.getElementById("educationLevel_select");
    	var text = e.options[e.selectedIndex].text;
    	selectName.val(text);
    	
    	
    	
    	if(selected.val() === "9") {
    		etc.removeAttr("disabled");
    	} else{
    		etc.attr("disabled", "disabled");
    	}
    });
})(jQuery);



(function($) {
	$("#expRadioYes").change(function() {
		$(".exp-input").prop("disabled", false);
		$("#experience_none_place").show();
	});
	
	$("#expRadioNo").change(function() {
		$(".exp-input").prop("disabled", true);
		$("#experience_none_place").hide();
	});
})(jQuery);


(function($) {	
	$(".facility-18").on("change", function() {
		if($(this).is(":checked")) {
			$("#facilityList_other").prop("disabled", false);
		}else{
			$("#facilityList_other").prop("disabled", true);
		}
	});
	
})(jQuery);


var box_number = 2;
var id=document.getElementById('id_detail_add_more_attach').value;
if(id!=""){
box_number = parseInt(id);
}
$(document).ready(function() {
	$("#add_more_attach").click(function(){
		var partten = $("#attack_pattern").html();
		box_number +=1;
		var genarateHTML = partten.replace(/\[BOX_ID\]/g ,+box_number);
		$("#more_attack").append(genarateHTML);
		handle_image_upload(box_number);
	});
});
	
	



function closeFacilityAttack(id){
	$("#box_"+id).remove();
}

function handle_image_upload(id){
	  var readUrl = function(input, img) {

	    if (input.files && input.files[0]) {
	      var reader = new FileReader();

	      reader.onload = function(e) {
	        img.attr('src', e.target.result);
	      }

	      reader.readAsDataURL(input.files[0]);
	    }
	  };

	  var box = $("#box_"+id);
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

(function ($) {
	 if (!$(".store_edit_google_map").length) return;
   var timer;
   var mapCanvas = document.getElementById('map');
   var map_lat =  $("#latitude").val();
   var map_long = $("#longitude").val();

   function initialize() {
       var mapOptions = {
           center: new google.maps.LatLng(map_lat, map_long),
           zoom: 15,
           mapTypeId: google.maps.MapTypeId.ROADMAP
       }

       var map = new google.maps.Map(mapCanvas,mapOptions);

       // Creating a marker and positioning it on the map
       var marker = new google.maps.Marker({
           position: new google.maps.LatLng(map_lat, map_long),
           map: map
       });
       
       
   }
   google.maps.event.addDomListener(window, 'load', initialize);
})(jQuery);

(function ($) {
	 if (!$(".store_google_map").length) return;
    var url = root_url+"/items/store/google_map";
    var timer;
    var mapCanvas = document.getElementById('map');
    var map_lat = mapCanvas.getAttribute('data-map-lat');
    var map_long = mapCanvas.getAttribute('data-map-long');

    function initialize() {
        var mapOptions = {
            center: new google.maps.LatLng(map_lat, map_long),
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
        }

        var map = new google.maps.Map(mapCanvas,mapOptions);

        // Creating a marker and positioning it on the map
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(map_lat, map_long),
            map: map
        });


    }
    google.maps.event.addDomListener(window, 'load', initialize);
})(jQuery);

function load_google_map() {
    	var add1=$('#address1').val();
    	var add2=$('#address2').val();
    	var city=$("#city :selected").text();
    	var district=$("#district :selected").text();
    	var address=add1+" "+district+" "+city;
    	if(address==''){
    		address=add2;
    	}
    	
    	var url = root_url+"items/store/google_map";
        $.ajax({
        	type: "GET",
            url: url,
            data: {
                address: address
            },
            success: function (data) {
            	if(data.code == 0){
					var map_lat = data.value;
                    var map_long = data.message;
                    $("input[name='latitude']").val(map_lat);
                    $("input[name='longitude']").val(map_long);
                    var mapCanvas = document.getElementById('map');
                    $("#google_map").show();
                    mapOptions = {
                        center: new google.maps.LatLng(map_lat, map_long),
                        zoom: 15,
                        mapTypeId: google.maps.MapTypeId.ROADMAP
                    }
                    map = new google.maps.Map(mapCanvas,mapOptions);
                    marker = new google.maps.Marker({
                        position: new google.maps.LatLng(map_lat, map_long),
                        map: map
                    });
                    google.maps.event.trigger(map, 'resize');

				}else if(data.code == 2){
					
				} 
            	
            	
                
            }
        })

};

function load_google_map_input_address() {
	var add1=$('#address1').val();
	var add2=$('#address2').val();
	var city=$("#city :selected").text();
	var district=$("#district :selected").text();
	var address=add1+" "+district+" "+city;
	if(city!=null && district!=null){
	var url = root_url+"items/store/google_map";
    $.ajax({
    	type: "GET",
        url: url,
        data: {
            address: address
        },
        success: function (data) {
        	if(data.code == 0){
				var map_lat = data.value;
                var map_long = data.message;
                $("input[name='latitude']").val(map_lat);
                $("input[name='longitude']").val(map_long);
                var mapCanvas = document.getElementById('map');
                $("#google_map").show();
                mapOptions = {
                    center: new google.maps.LatLng(map_lat, map_long),
                    zoom: 15,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                }
                map = new google.maps.Map(mapCanvas,mapOptions);
                marker = new google.maps.Marker({
                    position: new google.maps.LatLng(map_lat, map_long),
                    map: map
                });
                google.maps.event.trigger(map, 'resize');

			}else if(data.code == 2){
				
			} 
        	
        	
            
        }
    })
	}
	
};

