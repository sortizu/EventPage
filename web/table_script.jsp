<script>
    $(document).ready(function () {
      // Funcion que agrega la clase table-active a la fila seleccionada
      $("tbody tr").click(function () {
        
        selectRow($(this));
      });

      function selectRow(clickedRow){
        if (clickedRow.hasClass("table-active")) {
            clickedRow.removeClass("table-active");
        }else{
            clickedRow.addClass("table-active");
        }
        var selectedRowsLength = $("tr.table-active").length;
        
        // Enable edit button
        if (selectedRowsLength > 0) {
          if (selectedRowsLength > 1) {
            $("#editButton").prop("disabled", true);
          } else {
            $("#editButton").prop("disabled", false);
          }
          $("#deleteButton").prop("disabled", false);
        }else{
          $("#editButton").prop("disabled", true);
          $("#deleteButton").prop("disabled", true);
        }
      }
      // Funcion que permite editar los datos de la fila seleccionada
      $("#editButton").click(function () {
        // Get selected row data
        var mainForm = $("#mainForm");
        mainForm.addClass("edit-mode");
        mainForm.removeClass("add-mode");
        mainForm.attr("action", '<%=apiLinkEdit%>');
        var selectedRow = $("tr.table-active");
        var id = selectedRow.attr("data-id");
        var columnsOfSelectedRow = selectedRow.find("td");
        var modalFormInputs=$(".modal-form-input")
        for (var i = 1; i < columnsOfSelectedRow.length; i++) {
          var column = columnsOfSelectedRow[i];
          modalFormInputs.eq(i-1).val(column.innerHTML);
        }
        // Change modal title
        $("#mainModal .modal-title").text("Editar "+'<%=pageElementName%>');
        // Show modal
        $("#mainModal").modal("show");
      });

      // Funcion que permite eliminar los datos de la fila seleccionada (no funciona)
      $("#confirmDeleteButton").click(function () {
        // Get selected row data
        var selectedRows = $("tr.table-active");
        for (var i = 0; i < selectedRows.length; i++) {
          var id = selectedRows.eq(i).attr("data-id");
          // Remove table row
          $('tr[data-id="' + id + '"]').remove();
        }
        $("#confirmDeleteModal").modal("hide");
      });

      // Funcion que permite limpia el formulario cuando se abre el formulario
      $("#addButton").click(function () {
        var mainForm = $("#mainForm");
        mainForm.addClass("add-mode");
        mainForm.removeClass("edit-mode");
        mainForm.attr("action", '<%=apiLinkAdd%>');
        // Clear modal data
        var modalFormInputs=$(".modal-form-input")
        for (var i = 0; i < modalFormInputs.length; i++) {
          modalFormInputs.eq(i).val("");
        }
        // Change modal title
        $("#mainModal .modal-title").text("Agregar "+'<%=pageElementName%>');
      });

      $("#mainFormSubmitButton").click(function () {
        var mainForm = $("#mainForm");
        if(mainForm.hasClass("add-mode")){
            var modalFormInputs=$(".modal-form-input")
            var table = document.getElementById("mainTable");
            var rowQuantity = table.rows.length;
            for (var i = 0; i < modalFormInputs.length; i++) {
                if(modalFormInputs.eq(i).val()=="" || modalFormInputs.eq(i).val()==null){
                    window.alert("Por favor, rellene todos los campos")
                    return;
                    }
                }
            var row = table.insertRow(rowQuantity);
            row.onclick = function () {
        
        selectRow($(this));
      }; 
            row.setAttribute("data-id", rowQuantity);
            row.insertCell(0).innerHTML=rowQuantity;
            var colIndex=1
            for (var i = 0; i < modalFormInputs.length; i++) {
                var cell = row.insertCell(colIndex);
                    cell.innerHTML = modalFormInputs.eq(i).val();
                    if(modalFormInputs.eq(i).hasClass("form-input-ignore")){
                    cell.hidden=true
                    }
                    colIndex++;
                
                
            }
        }else if(mainForm.hasClass("edit-mode")){
            var selectedRow = $("tr.table-active");
            var columnsOfSelectedRow = selectedRow.find("td");
            var modalFormInputs=$(".modal-form-input")
            for (var i = 1; i < columnsOfSelectedRow.length; i++) {
                var column = columnsOfSelectedRow[i];
                column.innerHTML=modalFormInputs.eq(i-1).val();
            }
        }
        $("#mainModal").modal("hide");
      });
    });
  </script>