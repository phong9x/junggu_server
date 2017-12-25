(function($) {
  trams.setMinHeightDependOn(
    null, 
    [$("header"), $("footer")]
  );
})(jQuery);

$("form").on("click", ".checkbox-only1", function(e) {
	  var $this = $(this);
	  var name = $this.attr("name");
	  var $parent = $(e.delegateTarget);
	  if($this.prop("checked")) {
	    $parent.find("[name=" + name + "]").prop("checked", false);
	    $this.prop("checked", true);
	  }
	});

function loadDistrict(){
	var countrygrouptype = $("#city").val(); 

	var name = $("#city :selected").text();
	if(countrygrouptype != ""){
		$("#cityname").val(name);
	}else{
		$("#cityname").val("");
	}
	
	$.ajax({
      type: "GET",
      url:root_url+"api/dictrict/"+countrygrouptype,
      success: function (response) {
    	  var html = "<option value='' disabled='disabled' selected='selected'>전체</option>";
    	  if(response.code == 0){
    		  for (var i = 0; i < response.data.length; i++) {
    			  html +="<option value='"+response.data[i].id+"'>"+response.data[i].name+"</option>";
			}
    	  }
    	$("#district").html(html); 
      },
      error: function (xhr, ajaxOptions, thrownError) {
      }
    }); 
};


