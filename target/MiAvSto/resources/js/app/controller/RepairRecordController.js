$(function () {

    var repairRecordController = (function () {
        var methods = {
            init: function () {
                this.initAddRepairRecordButton();
            },
            initAddRepairRecordButton: function () {
                $("#repairRecordForm").find(".addRepairRecordItem").each(function() {
                    $(this).click(function() {
                      
                    });
                });
            }

        };


        return methods;
    }());

    repairRecordController.init();

});