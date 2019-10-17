$(function(){
    $("#championCost").prop("disabled", true);
    $("#championArmor").prop("disabled", true);
    $("#championMR").prop("disabled", true);
    $("#championMana").prop("disabled", true);
    $("#championRange").prop("disabled", true);

    $("#championHP").prop("disabled", true);
    $("#championDmg").prop("disabled", true);
    $("#championAS").prop("disabled", true);
    $("#championDPS").prop("disabled", true);
    $("#championCrit").prop("disabled", true);


    $('#edit').click(function () {
        $("#championCost").prop("disabled", false);
        $("#championArmor").prop("disabled", false);
        $("#championMR").prop("disabled", false);
        $("#championMana").prop("disabled", false);
        $("#championRange").prop("disabled", false);

        $("#championHP").prop("disabled", false);
        $("#championDmg").prop("disabled", false);
        $("#championAS").prop("disabled", false);
        $("#championDPS").prop("disabled", false);
        $("#championCrit").prop("disabled", false);

        $("#edit").prop("disabled", true);
        $("#save").prop("disabled", false);
    })

    $('#save').click(function () {
        $("#championCost").prop("disabled", true);
        $("#championArmor").prop("disabled", true);
        $("#championMR").prop("disabled", true);
        $("#championMana").prop("disabled", true);
        $("#championRange").prop("disabled", true);

        $("#championHP").prop("disabled", true);
        $("#championDmg").prop("disabled", true);
        $("#championAS").prop("disabled", true);
        $("#championDPS").prop("disabled", true);
        $("#championCrit").prop("disabled", true);

        $("#save").prop("disabled", true);
        $("#edit").prop("disabled", false);
    })
console.log("hello");
});