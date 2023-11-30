<script>
    $(document).ready(function () {
        $(".showEventDetails").click(function(){
            var idEvent = $(this).attr("data-id");
            $.ajax({
                url: "DetalleEventoServlet",
                type: "POST",
                data: {"id":idEvent},
                success: function (response) {
                    var eventData = response;
                    var newImageSource = response["imagen_url"];
                    var errorImageSource = '${pageContext.request.contextPath}/img/placeholders/no_image.jpg';
                    
                    $("#eventDetailImage").attr("src",newImageSource);
                    $("#eventDetailImage").on("error",function(){
                                            $(this).attr("src",errorImageSource);
                                        });

                    $("#detailEventName").text(eventData["nombre_evento"]);
                    $("#detailEventDescription").text(eventData["descripcion"]);
                    $("#detailEventCapacity").text(eventData["capacidad"]);
                    $("#detailEventCost").text("$"+eventData["costo"]);
                    $("#detailEventDate").text(eventData["fecha"]);
                    $("#eventDetailModal").attr("data-id",eventData["id_evento"]);
                    $("#eventDetailModal").modal("show");
                },
                error: function (error) {
                    
                }
            });
        });

    });
</script>