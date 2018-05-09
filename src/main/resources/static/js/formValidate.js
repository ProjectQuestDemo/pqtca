function validate() {

    var x = $(".testinput");

    var validationArray = [];

    x.each(function () {
        if ($(this).val() === "" || $(this).val() === null) {
            $(this).css("border-color", "red");
            validationArray.push(false);
        } else {
            console.log("is valid");
            $(this).css("border-color", "inherit");
            validationArray.push(true);
        }
    });

    return !validationArray.includes(false);

}

 // TODO fix validation so that it can be applied to every page, without halting the next button


