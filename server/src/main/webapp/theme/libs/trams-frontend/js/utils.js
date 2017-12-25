window.trams = window.trams || {};

(function($) {
  trams.setMinHeightDependOn = function(main, others) {
    var othersHeight = 0;
    var viewportHeight;

    others.forEach(function(item) {
      othersHeight += item.height();
    });

    // alert(othersHeight);
  };
})(jQuery);

// 
// UNDISABLED IF
// 
(function($) {
  if(!$("[data-undisable-if]").length) return;

  $("[data-undisable-if]").each(function(index, el) {
    var self = $(this);
    var triggerSelector = self.attr("data-undisable-if");
    var undisableValue = self.attr("data-undisable-value");
    $(triggerSelector).on("change", function() {
      var that = $(this);

      if(undisableValue) {
        //We has undisable value which mean target 
        //trigger is a selectbox
        var isMatch = that.val() == undisableValue;
        self.prop("disabled", !isMatch);

        return;
      }

      //Code reach this part mean target is 
      // a checkbox or radio, easy done!
      self.prop("disabled", !that.is(":checked"));
    });
  });
})(jQuery);


// 
// bootstrap datepicker
// 
//(function($) {
//	  if (!$(".trams-datepicker").length) return;
//
//	  $('.trams-datepicker').each(function() {
//		 
//	    $(this).datetimepicker({
//	    minDate: new Date(),
//	      changeMonth: true,
//	      changeYear: true,
//	      showOtherMonths: true,
//	      showButtonPanel: true,
//	      startDate: new Date(),
//	      dateFormat: "yy-mm-dd",
//	      yearRange: "c-100:c+100"
//	    });
//
//	    // $(this).datepicker($.datepicker.regional["ko"]);
//	  });

(function($) {
	if (!$(".trams-datepicker").length) return;
  $('.trams-datepicker').datetimepicker(
		  {		  setDate:new Date(),
			  	  format: 'YYYYMMDD',
			      yearRange: "c-100:c+100",
			      showOtherMonths: true,
			      showButtonPanel: true,
			    }
  );
  
})(jQuery);


/* --------------------------------------------------------------------- */
/* .auto handle image upload
/* --------------------------------------------------------------------- */
(function($) {
  var readUrl = function(input, img) {

    if (input.files && input.files[0]) {
      var reader = new FileReader();

      reader.onload = function(e) {
        img.attr('src', e.target.result);
      }
      reader.readAsDataURL(input.files[0]);
    }
  };

  var handle = function(index, el) {
    var $this = $(this);
    var pickBtn = $this.find('.pick-btn');
    var realFilePicker = $this.find('.real-input');
    var imgPreview = $this.find('.img-preview');

    var deleteBtn = $this.find('.delete-btn');
    var defaultImg = $this.attr("data-default-image");
    var informDeleted = $this.find(".inform-deleted");

    pickBtn.click(function() {
      realFilePicker.trigger('click');
    });

    realFilePicker.change(function() {
      readUrl(realFilePicker.get(0), imgPreview);
      informDeleted.prop("checked", false);
    });

    if (deleteBtn) {
      deleteBtn.click(function(event) {
        realFilePicker.val('');
        if (defaultImg) {
          imgPreview.attr('src', defaultImg);
        } else {
          imgPreview.attr('src', '');
        }

        informDeleted.prop("checked", true);
      });
    }
  }

  if ($('.trams-input-group-file').length) {
    $('.trams-input-group-file').each(handle);
  }

})(jQuery);



/* --------------------------------------------------------------------- */
/* confirm
/* --------------------------------------------------------------------- */
(function($) {
  var current = null;

  var nc = window.tramsNC = window.tramsNC || {};

  nc.confirm = function() {
    current.data("confirmed", true);
    current.trigger("click");
  };

  $(document).on('click', '.trams-need-confirm', function(e) {
    var self = $(this);
    var confirmed = self.data("confirmed");

    if (confirmed) return true;

    var popupId = self.attr("data-trams-confirm-popup");
    current = self;

    $(popupId).modal("show");

    return false;
  });
})(jQuery);


(function($) {
	  if(!$("[data-tbx-hidden]").length) return;

	  $("[data-tbx-hidden]").each(function(index, el) {
	    var dataKey = $(this).data("key");
	    var textboxHidden = $(this).data("tbx-hidden");
	    
	    $(this).on("change", function() {
	      if($(textboxHidden)) {
	    	 var dTextbox = $(this).val();
	    	  $(textboxHidden).val(dataKey+"_"+dTextbox+"_");
	      }
	    });
	    
	  });
	})(jQuery);


(function($) {
	  if(!$("[data-disable]").length) return;
	  $("[data-disable]").each(function(index, el) {
	    var self = $(this);
	    var triggerSelector = self.attr("data-disable");
	    var enableVal = self.attr("data-enable-val");
	    var defaulDisable = $(triggerSelector).attr("data-defaut-enable");
	    
	    if($(defaulDisable).is(':checked') && $(defaulDisable).val() == $(defaulDisable).attr("data-enable-val")){
	    	  $(triggerSelector).prop("disabled", false);
	    	  
	      }
	      
	    $(this).on("change", function() {
	      if($(this).is(':checked') && $(this).val() == enableVal){
	    	  $(triggerSelector).prop("disabled", false);
	    	  var preVal = $(triggerSelector).data("pre-val");
	    	  $(triggerSelector).val(preVal);
	      }else{
	    	  $(triggerSelector).prop("disabled", true);
	    	  var preVal = $(triggerSelector).val();
	    	  $(triggerSelector).attr("data-pre-val",preVal);
	    	  $(triggerSelector).val("");
	      }
	    });
	  });
	})(jQuery);

(function($) {
	if(!$("[data-disable-group]").length) return;
	
	var group = $("[data-group]");
	$(group).each(function(index, el) {
		$(this).prop("disabled", true);
		///$(this).prop("checked", false);
	});
	
	$("[data-disable-group]").each(function(index, el) {
		
		var self = $(this);
		var triggerSelector = self.attr("data-disable-group");
		var enableVal = self.attr("data-enable-val");
		
		$(group).each(function(index, el) {
			if($(this).data("group") == triggerSelector){
				console.log($(self).is(':checked') && $(self).val() == enableVal);
				if($(self).is(':checked') && $(self).val() == enableVal){
					$(this).prop("disabled", false);
				}
			}
		});
		 
		$(this).on("change", function() {
			$(group).each(function(index, el) {
				if($(this).data("group") == triggerSelector){
					if($(self).is(':checked') && $(self).val() == enableVal){
						$(this).prop("disabled", false);
					}else{
						$(this).prop("disabled", true);
						$(this).prop("checked", false);
					} 
				}
			});
		});
	});
})(jQuery);

//(function($) {
//	
//	  var checkbook1 = document.getElementById('staff_to_help_main_1');
//	  var checkbook2 = document.getElementById('staff_to_help_main_1');
//	  console.log("asdasdas");
//	  if(checkbook1.checked) {
//		 
//	  }else{
//		 
//	  }
//
//	})(jQuery);

