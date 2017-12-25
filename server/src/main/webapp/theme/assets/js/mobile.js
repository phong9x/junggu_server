/* --------------------------------------------------------------------- */
/* DATA PLACEHOLDER
/* --------------------------------------------------------------------- */
(function($) {
  if (!$("[data-jg-placeholder]").length) return;

  $("[data-jg-placeholder]").each(function() {
    var placeholderContent = $(this).attr("data-jg-placeholder");
    $(this).attr("placeholder", placeholderContent);

    $(this).on("focus", function() {
      $(this).attr("placeholder", "");
    });

    $(this).on("blur", function() {
      $(this).attr("placeholder", placeholderContent);
    });
  });
})(jQuery);



/* --------------------------------------------------------------------- */
/* .jg-scroller-style-1
/* --------------------------------------------------------------------- */
(function($) {
  if (!$(".jg-scroller-style-1").length) return;

  var contentToScroll;
  var idNum = 1;

  $('.jg-scroller-style-1').each(function() {
    $(this).attr("id", 'scroller' + idNum);
    
    var id = $(this).attr('id');

    idNum++;

    contentToScroll = new IScroll('#' + id, {
      mouseWheel: true,
      scrollbars: false
    });
  });


  // $(".jg-scroller-style-1").each(function() {
  //   var myScroll = new IScroll(".jg-scroller-style-1", {
  //     mouseWheel: true,
  //     scrollbars: false
  //   });
  // });
})(jQuery);
