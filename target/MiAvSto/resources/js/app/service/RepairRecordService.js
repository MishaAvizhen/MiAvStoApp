var RepairRecordService = (function () {

    var methods = {

        addRepairRecordItem: function (repairRecord, callback, errorcallback) {
            $.ajax({
                url: "/api/addRepairRecord",
                type: "POST",
                data: JSON.stringify(repairRecord),
                dataType : 'json',
                contentType : "application/json",
                success: function (data) {
                    callback(data);
                },
                error: function (error) {
                    errorcallback(error);
                }
            });
        }

    };

    return methods;

}());