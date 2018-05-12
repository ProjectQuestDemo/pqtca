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
    console.log(validationArray);
    return !validationArray.includes(false);

}

function validate1() {

    var x = $(".testinput1");

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
    console.log(validationArray);
    return !validationArray.includes(false);

}

function validate2() {

    var x = $(".testinput2");

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
    console.log(validationArray);
    return !validationArray.includes(false);

}

function validate3() {

    var x = $(".testinput3");

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
    console.log(validationArray);
    return !validationArray.includes(false);

}

function validate4() {

    var x = $(".testinput4");

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
    console.log(validationArray);
    return !validationArray.includes(false);

}

function validate5() {

    var x = $(".testinput5");

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
    console.log(validationArray);
    return !validationArray.includes(false);

}

function validate6() {

    var x = $(".testinput6");

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
    console.log(validationArray);
    return !validationArray.includes(false);

}

function validate7() {

    var x = $(".testinput7");

    var validationArray = [];

    x.each(function () {
        if ($(this).val() === "" || $(this).val() === null) {
            $(this).css("border-color", "red");
            $(this).css("background-color", "red");
            validationArray.push(false);
        } else {
            console.log("is valid");
            $(this).css("border-color", "inherit");
            validationArray.push(true);
        }
    });
    console.log(validationArray);
    return !validationArray.includes(false);

}

 // TODO fix validation so that it can be applied to every page, without halting the next button


