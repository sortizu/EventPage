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
        var inputFormMode = $("#form-mode");
        inputFormMode.val("edit");
        var selectedRow = $("tr.table-active");
        var id = selectedRow.attr("data-id");
        var columnsOfSelectedRow = selectedRow.find("td");
        var modalFormInputs=$(".modal-form-input")
        for (var i = 0; i < columnsOfSelectedRow.length; i++) {
          var column = columnsOfSelectedRow.eq(i);
          modalFormInputs.eq(i).val(column.attr("value"));
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
        var selectedRowsID = [];
        for (var i = 0; i < selectedRows.length; i++) {
          var id = selectedRows.eq(i).attr("data-id");
          // Remove table row
          //$('tr[data-id="' + id + '"]').remove();
          selectedRowsID.push(id);
        }
        $.ajax({
          url:"<%=apiLink%>",
          type:"POST",
          dataType:'json',
          data: {'json[]':selectedRowsID.toString(),'form-mode':"delete"},
          success:function(data){
            window.alert("EXITO");
          },
          error:function(data){
            location.reload();
          }
      });

      });

      // Funcion que permite limpia el formulario cuando se abre el formulario
      $("#addButton").click(function () {
        var inputFormMode = $("#form-mode");
        inputFormMode.val("add");
        // Clear modal data
        var modalFormInputs=$(".modal-form-input")
        for (var i = 0; i < modalFormInputs.length; i++) {
          modalFormInputs.eq(i).val("");
        }
        // Change modal title
        $("#mainModal .modal-title").text("Agregar "+'<%=pageElementName%>');
      });

    
    });
  </script>