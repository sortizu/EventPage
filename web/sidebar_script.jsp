<script>
  $(document).ready(function () {
    function setSidebarHidden(sidebarHidden) {
      var hideSidebarIcon = $(".bi-arrow-bar-left");
      var sidebarOptionTexts = $(".sidebar-option-text");
      if (sidebarHidden == "true") {
        for (var i = 0; i < sidebarOptionTexts.length; i++) {
          var sidebarOptionText = sidebarOptionTexts.eq(i);
          sidebarOptionText.addClass("d-md-inline");
          $("#sidebar").addClass("col-lg-2");
          $("#sidebar").removeClass("col-lg-auto");
          $("#main-content").removeClass("w-100");
        }
        hideSidebarIcon.css("transform", "rotate(0deg)");
      } else {
        for (var i = 0; i < sidebarOptionTexts.length; i++) {
          var sidebarOptionText = sidebarOptionTexts.eq(i);
          sidebarOptionText.removeClass("d-md-inline");
          $("#sidebar").removeClass("col-lg-2");
          $("#sidebar").addClass("col-lg-auto");
          $("#main-content").addClass("w-100");
        }
        hideSidebarIcon.css("transform", "rotate(180deg)");
      }
    }
    var sidebarHidden = localStorage.getItem("sidebarHidden");

    if (sidebarHidden == null) {
      localStorage.setItem("sidebarHidden", "false");
      sidebarHidden = "false";
    }
    setSidebarHidden(sidebarHidden);
    $("#hide-button").click(function () {
      var sidebarHidden = localStorage.getItem("sidebarHidden");
      if (sidebarHidden == "true") {
        localStorage.setItem("sidebarHidden", "false");
        sidebarHidden = "false";
      } else {
        localStorage.setItem("sidebarHidden", "true");
        sidebarHidden = "true";
      }
      setSidebarHidden(sidebarHidden);
    });
  });
</script>
