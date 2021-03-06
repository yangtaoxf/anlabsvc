var TableEditable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }

                oTable.fnDraw();
            }

            function editRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                //jqTds[0].innerHTML = '';
                jqTds[1].innerHTML = '<input type="text" class="m-wrap large" value="' + aData[1] + '">';
                jqTds[2].innerHTML = '<input type="text" class="m-wrap large" value="' + aData[2] + '">';
                jqTds[3].innerHTML = '<a class="edit" href="">Save</a>';
                jqTds[4].innerHTML = '<a class="cancel" href="">Cancel</a>';
            }

            function saveRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                //oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 2, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 3, false);
                oTable.fnUpdate('<a class="delete" href="">Delete</a>', nRow, 4, false);
                oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 0, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 3, false);
                oTable.fnUpdate('<a class="edit" href="">Edit</a>', nRow, 4, false);
                oTable.fnDraw();
            }

            var oTable = $('#sample_editable_1').dataTable({

                "bPaginate": false,
                "bFilter": false,
                "bInfo": false
            });

            jQuery('#sample_editable_1_wrapper .dataTables_filter input').addClass("m-wrap medium"); // modify table search input
            jQuery('#sample_editable_1_wrapper div[class=row-fluid]').css("display","none");
            var nEditing = null;

            $('#sample_editable_1_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '',
                        '<a class="edit" href="">Edit</a>', '<a class="cancel" data-mode="new" href="">Cancel</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
            });

            $('#sample_editable_1 a.delete').live('click', function (e) {
                e.preventDefault();


                var nRow = $(this).parents('tr')[0];
                oTable.fnDeleteRow(nRow);
              //  alert("Deleted! Do not forget to do some ajax to sync with backend :)");

                var jqInputs = $('td', nRow);
                var id = jqInputs[0].innerText;
                $.ajax({
                    type: "GET",
                    url: "deleteCategory",
                    contentType: "application/json; charset=utf-8",
                    data: "id=" + id,
                    //dataType: "json",
                    success: function (data) {
                        if (data.success == true) {

                        } else if (data.success == false) {
                            alert("failed")

                        }
                    }
                });
            });

            $('#sample_editable_1 a.cancel').live('click', function (e) {
                e.preventDefault();
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#sample_editable_1 a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "Save") {
                    /* Editing this row and want to save it */
                    saveRow(oTable, nEditing);
                    //nEditing = null;
                    //alert("Updated! Do not forget to do some ajax to sync with backend :)");

                    var jqInputs = $('td', nEditing);
                    var id = jqInputs[0].innerText;
                    var cnName = jqInputs[1].innerText;
                    var enName = jqInputs[2].innerText;
                    var json = {
                        "id": id,
                        "cnName":cnName,
                        "enName":enName
                    };
                    $.ajax({
                        type: "POST",
                        url: "andOrUpdateCategory",
                        contentType: "application/json; charset=utf-8",
                        data: JSON.stringify(json),
                        dataType: "json",
                        success: function (data) {
                            if (data.success == true) {
                                window.location.reload();
                            } else if (data.success == false) {
                                alert("failed")

                            }
                        }
                    });

                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }

    };

}();