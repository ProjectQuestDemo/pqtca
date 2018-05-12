const minBtn = $(".close").click(function () {
    $(this).toggleClass('.open');
    $(".content").slideToggle()
});

const minBtn1 = $(".close1").click(function () {
    $(this).toggleClass('.open');
    $(".content1").slideToggle()
});

const minBtn2 = $(".close2").click(function () {
    $(this).toggleClass('.open');
    $(".content2").slideToggle()
});

const hide = $('.dropbtn').click(function () {
    $(this).toggleClass('.show');
    $('#divSec').toggleClass('.hide');
    $('#divTwo').toggleClass('.hide');
});