function validate() {

    var x = $(".testinput");
    var isValid = false;

    x.each(function (i, el) {
        if ($(this).val() === "" || $(this).val() === null) {
            $(this).css("border-color", "red");
            isValid = false;
        } else {
            $(this).css("border-color", "inherit");
            isValid = true;
        }
    });
    console.log(x);
    console.log(isValid);
    return isValid;

}




