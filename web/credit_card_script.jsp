<script>
    $(document).ready(function () {
        $("#addCreditCard").click(function(){
            $("#card-number").val("");
            $("#expiration-date").val("");
            $("#card-owner").val("");
            $("#shoppingModal").modal("hide");
            $("#addCreditCardModal").modal("show");
        });

        $("#returnFromCreditCard").click(function(){
            $("#addCreditCardModal").modal("hide");
            $("#shoppingModal").modal("show");
        });

        //the follow js code filter only numeric values in the input text
        $("input#card-number").on("input", function () {
            this.value = this.value.replace(/[^0-9]/g, '');
        });

        $("#saveCreditCard").click(function(e){
            var cardNumber = $("#card-number").val();
            var expirationDate = $("#expiration-date").val();
            var cardOwner = $("#card-owner").val();
            if(cardNumber == "" || expirationDate == "" || cardOwner == ""){
                return;
            }
            $("#addCreditCardModal").modal("hide");
            $("#shoppingModal").modal("show");
        });
    });
</script>