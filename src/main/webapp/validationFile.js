app.service('hexafy', function() {
    this.myFunc = function (x) {
        return x.toString(16);
    }
});

function validateText(id) {
    if ($("#" + id).val() == null || $("#" + id).val() == "") {
        var div = $("#" + id).closest("div");
        div.removeClass("has-success");
        $("#glypcn" + id).remove();
        div.addClass("has-error has-feedback");
        div.append('<span id="glypcn' + id + '" class="glyphicon glyphicon-remove form-control-feedback"></span>');
        return false;
    } else {
        var div = $("#" + id).closest("div");
        div.removeClass("has-error");
        $("#glypcn" + id).remove();
        div.addClass("has-success has-feedback");
        div.append('<span id="glypcn' + id + '" class="glyphicon glyphicon-ok form-control-feedback"></span>');
        return true;
    }
}

function passwordMatch(id1, id2) {
    if($("#"+id1).val() === $("#"+id2).val()){
        var div = $("#" + id2).closest("div");
        div.removeClass("has-error");
        $("#glypcn" + id2).remove();
        div.addClass("has-success has-feedback");
        div.append('<span id="glypcn' + id2 + '" class="glyphicon glyphicon-ok form-control-feedback"></span>');
        return true;
    }
    else{
        var div = $("#" + id2).closest("div");
        div.removeClass("has-success");
        $("#glypcn" + id2).remove();
        div.addClass("has-error has-feedback");
        div.append('<span id="glypcn' + id2 + '" class="glyphicon glyphicon-remove form-control-feedback"></span>');
        return false;
    }
}

function validateContact(id) {
    var phone_regex = /^[0-9]{10}$/i;
    if (!phone_regex.test($("#" + id).val())) {
        var div = $("#" + id).closest("div");
        div.removeClass("has-success");
        $("#glypcn" + id).remove();
        div.addClass("has-error has-feedback");
        div.append('<span id="glypcn' + id + '" class="glyphicon glyphicon-remove form-control-feedback"></span>');
        return false;
    } else {
        var div = $("#" + id).closest("div");
        div.removeClass("has-error");
        $("#glypcn" + id).remove();
        div.addClass("has-success has-feedback");
        div.append('<span id="glypcn' + id + '" class="glyphicon glyphicon-ok form-control-feedback"></span>');
        return true;
    }
}

function validateEmail(id) {
    var email_regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
    if (!email_regex.test($("#" + id).val())) {
        var div = $("#" + id).closest("div");
        div.removeClass("has-success");
        $("#glypcn" + id).remove();
        div.addClass("has-error has-feedback");
        div.append('<span id="glypcn' + id + '" class="glyphicon glyphicon-remove form-control-feedback"></span>');
        return false;
    } else {
        var div = $("#" + id).closest("div");
        div.removeClass("has-error");
        $("#glypcn" + id).remove();
        div.addClass("has-success has-feedback");
        div.append('<span id="glypcn' + id + '" class="glyphicon glyphicon-ok form-control-feedback"></span>');
        return true;
    }
}

function submitForm() {
    console.log("Submission testing");
    if (!validateText("name")) {
        return false;
    }
    if (!validateContact("contact")) {
        return false;
    }
    if (!validateEmail("emailID")) {
        return false;
    }
    if (!validateText("passWord")) {
        return false;
    }
    if (!validateText("rePassword")) {
        return false;
    }
    if (!passwordMatch("passWord", "rePassword")) {
        return false;
    }
    console.log("Form Submission successfull") 
}