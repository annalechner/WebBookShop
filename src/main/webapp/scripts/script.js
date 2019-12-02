/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#myInput").on("keyup", function () {
        var value = $(this).val().toLowerCase();
        if ($('#option1').is(':checked')) {
            $("#myTable tr td:nth-child(1)").filter(function () {
                $(this).parent().toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        } else if ($('#option2').is(':checked')) {
            $("#myTable tr td:nth-child(3)").filter(function () {
                $(this).parent().toggle($(this).text().toLowerCase().indexOf(value) > -1)
            });
        }
    });
});
