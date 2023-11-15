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
                    var newImageSource = '${pageContext.request.contextPath}/img/events_images/'+eventData.id_evento+'.jpg';
                    var errorImageSource = '${pageContext.request.contextPath}/img/placeholders/no_image.jpg';
                    
                    $("#eventDetailImage").attr("src",newImageSource);
                    $("#eventDetailImage").on("error",function(){
                                            $(this).attr("src",errorImageSource);
                                        });

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