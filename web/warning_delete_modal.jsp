<%@ page contentType="text/html; charset=UTF-8" %>
<div
        class="modal fade"
        id="warningDeleteModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
      >
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="exampleModalLabel">
                ADVERTENCIA
              </h1>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body">
              Algunos eventos dependen de las <%=pageElementPluralName%> que desea eliminar, para proceder seleccione alguna de las siguientes opciones:
            </div>
            <div class="modal-footer">
              <button
                type="button"
                class="btn btn-danger w-100"
                data-bs-dismiss="modal"
                id="WarningDeleteButton1"
              >
              Borrar también los eventos dependientes
              </button>
              <button
                type="button"
                class="btn btn-secondary w-100"
                id="WarningDeleteButton2"
              >
              Borrar solo <%=pageElementPluralName%> seleccionadas (requiere revisión de los eventos dependientes)
              </button>
            </div>
          </div>
        </div>
      </div>