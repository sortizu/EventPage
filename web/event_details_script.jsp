<script>
    $(document).ready(function () {
        $(".showEventDetails").click(function(){
            var idEvent = $(this).attr("data-id");
            $.ajax({
                url: "DetalleEventoServlet",
                type: "POST",
                data: {"id":idEvent},
                success: function (response) {
                    window.alert(response);
                },
                error: function (error) {
                    var jsonString = error.responseText.replaceAll("=", ":");
                     jsonString = jsonString.replaceAll("'", '"');
                    var eventData = JSON.parse("{"+jsonString+"}");
                    $("#detailEventName").text(eventData.nombreEvento);
                    $("#detailEventDescription").text(eventData.descripcion);
                    $("#detailEventCapacity").text(eventData.capacidad);
                    $("#detailEventCost").text("$"+eventData.costo);
                    $("#detailEventDate").text(eventData.fecha);
                    $("#detailEventDate").attr("data-id",eventData.id_evento);
                    $("#eventDetailModal").modal("show");
                }
            });
        });

    });
</script>